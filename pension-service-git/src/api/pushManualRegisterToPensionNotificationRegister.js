import { Router } from "express";
import producer from "../kafka/producer";
import { requestInfoToResponseInfo, epochToYmd,convertDateToEpoch,uuidv1,getEmployeeDetails,getPensionEmployees,saveEmployeeToPensionNotificationRegister} from "../utils";
import envVariables from "../envVariables";
import mdmsData from "../utils/mdmsData";
import { Message} from "../utils/message";
import isEmpty from "lodash/isEmpty";
import set from "lodash/set";
import get from "lodash/get";
import filter from "lodash/filter";
import orderBy from "lodash/orderBy";
import { intConversion} from "../utils/search";
const asyncHandler = require("express-async-handler");

import logger from "../config/logger";

export default ({ config, db }) => {
  let api = Router();
  api.post(
    "/_pushManualRegisterToPensionNotificationRegister",
    asyncHandler(async ({ body }, res, next) => {
      let payloads = [];
      //getting mdms data      
         
      let employees=[];   

      //search employee in Pension module  
      let pensionResponse = await getPensionEmployees(body.RequestInfo,body.Employees[0].tenantId,body.Employees[0].code);   
      let pensionEmployeesList=pensionResponse.Employees;          
     
      if(pensionEmployeesList.length>0){  
          
          const message=Message();                  

          let errors = message.EMPLOYEE_EXIST_PUSH_MANUAL_REGISTER_TO_PNR_NA;
          if (errors.length > 0) {
            next({
              errorType: "custom",
              errorReponse: {
                ResponseInfo: requestInfoToResponseInfo(
                  body.RequestInfo,
                  true
                ),
                Errors: errors
              }
            });
            return;
          }
          
      }
      else{
        
        //search employee from hrms and push that employee in pension module                  
          let hrmsResponse = await getEmployeeDetails(body.RequestInfo, body.Employees[0].tenantId,body.Employees[0].code);              
          
          let hrmsEmployee=hrmsResponse.Employees[0];                                                    

          if(hrmsEmployee){

            //let maxRetirementAge=envVariables.EGOV_PENSION_MAX_RETIREMENT_AGE;              

            let pensionEmployeeId=uuidv1();                      

            let dob=hrmsEmployee.user.dob;
            //let actualDob=new Date(epochToYmd(intConversion(dob)));    
            //let dorYYYYMMDD=`${actualDob.getFullYear()+maxRetirementAge}-${actualDob.getMonth()+1}-${actualDob.getDate()}`;    
            //let dateOfRetirement=convertDateToEpoch(dorYYYYMMDD,"dob");   

            let dateOfSuperannuation=hrmsEmployee.dateOfSuperannuation;

            let assignments=[];
            if(hrmsEmployee.assignments && !isEmpty(hrmsEmployee.assignments)){
              assignments=hrmsEmployee.assignments;
              let lastAssignments=[];
              let lastAssignment=[];
              if(assignments.length>1) {    
                assignments=orderBy(assignments,['fromDate'],['desc']);      
                lastAssignments=filter(assignments,function(x){return x.fromDate==assignments[0].fromDate;}); 
                if(lastAssignments.length>1){
                  lastAssignments=filter(lastAssignments,function(x){return x.isPrimaryAssignment==true;}); 
                  if(lastAssignments.length>0){
                    lastAssignment.push(lastAssignments[0]); 
                  }
                  else{
                    lastAssignments=filter(assignments,function(x){return x.fromDate==assignments[0].fromDate;}); 
                    lastAssignment.push(lastAssignments[0]);
                  }                          
                }                                                                                                                                                                        
              }
              else{
                lastAssignment=assignments;
              }
              for (var i = 0; i <assignments.length; i++){
                if(assignments[i].id==lastAssignment[0].id){
                  assignments[i].isPensionApplicable=true;
                }
                assignments[i].id=uuidv1(); 
                assignments[i].tenantId=hrmsEmployee.tenantId;                    
                assignments[i].active=true;      
                assignments[i].pensionEmployeeId=pensionEmployeeId;
              }
            }

            let serviceHistory=[];
            if(hrmsEmployee.serviceHistory && !isEmpty(hrmsEmployee.serviceHistory)){
              serviceHistory=hrmsEmployee.serviceHistory;
              for (var i = 0; i <serviceHistory.length; i++){
                serviceHistory[i].id=uuidv1();     
                serviceHistory[i].tenantId=hrmsEmployee.tenantId;                  
                serviceHistory[i].active=true;        
                serviceHistory[i].pensionEmployeeId=pensionEmployeeId;            
              }                  
            }

            /*
            let user=hrmsEmployee.user;
            user.employeeContactDetailsId=uuidv1();     
            user.tenantId=hrmsEmployee.tenantId;                 
            user.active=true; 
            */

            let employee={
              pensionEmployeeId: pensionEmployeeId,                          
              id: hrmsEmployee.id,
              uuid: hrmsEmployee.uuid,                    
              code: hrmsEmployee.code,
              name: hrmsEmployee.user.name,
              dob: dob,
              //dateOfRetirement: dateOfRetirement,
              dateOfRetirement: dateOfSuperannuation,
              dateOfDeath: null,                                      
              tenantId: hrmsEmployee.tenantId, 
              salutation: hrmsEmployee.user.salutation,      
              gender: hrmsEmployee.user.gender, 
              employeeStatus: hrmsEmployee.employeeStatus,
              employeeType: hrmsEmployee.employeeType,
              dateOfAppointment: hrmsEmployee.dateOfAppointment,
              assignments: assignments,
              serviceHistory: serviceHistory,      
              //user: user,                 
              active: true,
              pensionEmployeeAuditId: uuidv1(),
              notificationRegister: {
                pensionNotificationRegisterId: uuidv1(),      
                isInitiated: null,        
                pensionNotificationRegisterAuditId: uuidv1()        
              },   
              auditDetails: {
                createdBy: get(body.RequestInfo, "userInfo.uuid", ""),
                lastModifiedBy: null,
                createdDate: new Date().getTime(),      
                lastModifiedDate: null        
              }      
            }; 
            
            employees.push(employee);
            body.Employees=employees;       

            let response= await saveEmployeeToPensionNotificationRegister(body);
            res.json(response);

        }        
      }                       
    })
  );
  return api;
};
