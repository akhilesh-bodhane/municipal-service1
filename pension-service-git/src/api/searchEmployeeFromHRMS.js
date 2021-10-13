import { Router } from "express";
import { requestInfoToResponseInfo,getEmployeeDetails,epochToYmd ,convertDateToEpoch, adjust530} from "../utils";
import isEmpty from "lodash/isEmpty";
import get from "lodash/get";
import some from "lodash/some";
import { actions } from "../utils/search";
import { validatePensionNotificationRegisterSearchModel } from "../utils/modelValidation";
import envVariables from "../envVariables";
import mdmsData from "../utils/mdmsData";
import filter from "lodash/filter";
import { intConversion} from "../utils/search";
const asyncHandler = require("express-async-handler");

import logger from "../config/logger";

export default ({ config, db }) => {
  let api = Router();
  api.post(
    "/_searchEmployeeFromHRMS",
    asyncHandler(async (request, res, next) => {     
      
      let response = {
        ResponseInfo: requestInfoToResponseInfo(request.body.RequestInfo, true),
        Employees: []
      };

      const queryObj = JSON.parse(JSON.stringify(request.query));
      

     
      /*
      let errors = validatePensionNotificationRegisterSearchModel(queryObj);
      if (errors.length > 0) {
        next({
          errorType: "custom",
          errorReponse: {
            ResponseInfo: requestInfoToResponseInfo(
              request.body.RequestInfo,
              true
            ),
            Errors: errors
          }
        });
        return;
      }
      */
     let pensionEmployees=[];
     let code="";
     let name="";
     let departments="";
     
     if (queryObj.code) {
      code= queryObj.code;
     }
     if (queryObj.name) {            
      name=queryObj.name;
     }
     if (queryObj.departments) {            
      departments=queryObj.departments;
     }
     //let hrmsResponse = await getEmployeeDetails(request.body.RequestInfo, queryObj.tenantId);   
     let hrmsResponse = await getEmployeeDetails(request.body.RequestInfo, queryObj.tenantId,code,name,departments);   
     let hrmsEmployee=hrmsResponse.Employees;
     /*
     if (queryObj.code) {
      hrmsEmployee=filter(hrmsEmployee,function(x){return x.code==queryObj.code;});  
     }
     if (queryObj.name) {      
      hrmsEmployee=hrmsEmployee.filter(s => String(s.user.name).toUpperCase().includes(String(queryObj.name).toUpperCase()));
     }
     */

     
     logger.debug(hrmsEmployee);         

     let modifiedQueryDobNum = adjust530(queryObj.dob);
     
     /*let modifiedQueryDob = new Date(Number(queryObj.dob));
     modifiedQueryDob.setHours(modifiedQueryDob.getHours() + 5);
     modifiedQueryDob.setMinutes(modifiedQueryDob.getMinutes() + 30);
     let modifiedQueryDobNum = Number(modifiedQueryDob);*/

     if (queryObj.dob) {
      //hrmsEmployee=filter(hrmsEmployee,function(x){return x.user.dob==queryObj.dob;}); 
      hrmsEmployee=filter(hrmsEmployee,function(x){
        
        
        if(x!=null && x.user!=null && x.user.dob!=null){
          return x.user.dob==modifiedQueryDobNum;
        } else{
          return false;}
      }); 
     }
     
     
     //let maxRetirementAge=envVariables.EGOV_PENSION_MAX_RETIREMENT_AGE;

     if(hrmsEmployee){
      for (var i = 0; i < hrmsEmployee.length; i++) {        
        let dob=hrmsEmployee[i].user.dob;
        //let actualDob=new Date(epochToYmd(intConversion(dob))); 
        //let dorYYYYMMDD=`${actualDob.getFullYear()+maxRetirementAge}-${actualDob.getMonth()+1}-${actualDob.getDate()}`;    
        //let dateOfRetirement=convertDateToEpoch(dorYYYYMMDD,"dob");
        let dateOfSuperannuation=hrmsEmployee[i].dateOfSuperannuation;

        let employee={
          pensionEmployeeId: "",
          id: hrmsEmployee[i].id,
          tenantId: hrmsEmployee[i].tenantId,
          code: hrmsEmployee[i].code,
          name: hrmsEmployee[i].user.name,
          dob: dob,          
          dateOfJoining: hrmsEmployee[i].dateOfAppointment,
          dateOfRetirement: dateOfSuperannuation,
          dateOfDeath: null,
          department: hrmsEmployee[i].assignments[hrmsEmployee[i].assignments.length-1].department,
          designation: hrmsEmployee[i].assignments[hrmsEmployee[i].assignments.length-1].designation
        };

        pensionEmployees.push(employee);
      }
     }

      
     response.Employees=pensionEmployees;      
     res.json(response);
       
    })
  );
  return api;
};
