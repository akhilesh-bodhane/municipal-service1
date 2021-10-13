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
import { intConversion} from "../utils/search";
import {userDetails} from "../services/userService.js";
const asyncHandler = require("express-async-handler");

import logger from "../config/logger";

export default ({ config, db }) => {
  let api = Router();
  api.post(
    "/_pushEmployeesToPensionNotificationRegister",
    asyncHandler(async ({ body }, res, next) => {      
      
      
     
      let pensionNotApplicableFromYear=envVariables.EGOV_PENSION_NOT_APPLICABLE_FROM_YEAR;
      let hrmsResponse=await getEmployeeDetails(body.RequestInfo,envVariables.EGOV_PENSION_SCHEDULAR_TENANTID);      
      
      let hrmsEmployees=[];
      hrmsEmployees=hrmsResponse.Employees;
      hrmsEmployees=filter(hrmsEmployees,function(x){return (x.dateOfAppointment!=null && new Date(epochToYmd(intConversion(x.dateOfAppointment))).getFullYear()<pensionNotApplicableFromYear)
                            || (x.serviceHistory!=null && x.serviceHistory.length>0 && x.serviceHistory[0].serviceFrom!=null && new Date(epochToYmd(intConversion(x.serviceHistory[0].serviceFrom))).getFullYear()<pensionNotApplicableFromYear);});

      
      let pensionResponse=await getPensionEmployees(body.RequestInfo,envVariables.EGOV_PENSION_SCHEDULAR_TENANTID);   
      let pensionEmployeesList=pensionResponse.Employees;
      
            
      let nextNMonths=envVariables.EGOV_PENSION_PNR_SCHEDULAR_NEXT_N_MONTHS;
      let today=new Date();  
      let createdDate=convertDateToEpoch(`${today.getFullYear()}-${today.getMonth()+1}-${today.getDate()}`,"dob");
      
      let nextNMonthEndDate=new Date(today.getFullYear(),today.getMonth()+nextNMonths,today.getDate());  
    
      let queryResult=hrmsEmployees;  
      let pensionEmployees=[];
      
      for (var i = 0; i < queryResult.length; i++) {    
        if(queryResult[i].user!=null && queryResult[i].user.dob!=null){
        
          let pensionEmployeesFilter=[];
          if(pensionEmployeesList.length>0){
            pensionEmployeesFilter=filter(pensionEmployeesList,function(x){return x.code==queryResult[i].code;})
          }

          

          //employee not exist in pension module
          if(pensionEmployeesFilter.length==0){     
            
            let tenantId=queryResult[i].tenantId;
            let dob=queryResult[i].user.dob;
            let dateOfSuperannuation=queryResult[i].dateOfSuperannuation;
            let actualDateOfSuperannuation=new Date(epochToYmd(intConversion(dateOfSuperannuation))); 
          
            let actualDob=new Date(epochToYmd(intConversion(dob)));                    

            

            if(actualDateOfSuperannuation<=nextNMonthEndDate && actualDateOfSuperannuation>today){
              let employee={
                pensionEmployeeId: uuidv1(),
                tenantId: tenantId,
                id: queryResult[i].id,
                code: queryResult[i].code,
                name: queryResult[i].user.name,
                dob: dob,
                //dateOfRetirement: dateOfRetirement,
                dateOfRetirement: dateOfSuperannuation,
                dateOfDeath: null,          
                uuid: queryResult[i].uuid,  
                salutation: queryResult[i].user.salutation,      
                gender: queryResult[i].user.gender, 
                employeeStatus: queryResult[i].employeeStatus, 
                employeeType: queryResult[i].employeeType, 
                dateOfAppointment: queryResult[i].dateOfAppointment, 
                pensionEmployeeAuditId: uuidv1(),    
                active: true,    
                notificationRegister: {
                  pensionNotificationRegisterId: uuidv1(),      
                  isInitiated: null,        
                  pensionNotificationRegisterAuditId: uuidv1()        
                },      
                auditDetails: {
                  createdBy: body.RequestInfo.userInfo.uuid,
                  lastModifiedBy: null,
                  createdDate: createdDate,      
                  lastModifiedDate: null        
                }      
              };
          
              pensionEmployees.push(employee);

            }
          }        
        }
      }
      
      logger.debug("pensionEmployees", JSON.stringify(pensionEmployees));

      let requestBody = {
        RequestInfo: body.RequestInfo,
        Employees: pensionEmployees
      };
      
      let response=await saveEmployeeToPensionNotificationRegister(requestBody);
      res.json(response);
                      
    })
  );
  return api;
};
