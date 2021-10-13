import { Router } from "express";
import { requestInfoToResponseInfo,getEmployeeDetails,adjust530 } from "../utils";
import { mergeSearchResults,intConversion } from "../utils/search";
import isEmpty from "lodash/isEmpty";
import get from "lodash/get";
import some from "lodash/some";
import { actions } from "../utils/search";
import { validatePensionNotificationRegisterSearchModel } from "../utils/modelValidation";
import envVariables from "../envVariables";
import mdmsData from "../utils/mdmsData";
import filter from "lodash/filter";
const asyncHandler = require("express-async-handler");

import logger from "../config/logger";

export default ({ config, db }) => {
  let api = Router();
  api.post(
    "/_searchPensionNotificationRegister",
    asyncHandler(async (request, res, next) => {     
      
      let response = {
        ResponseInfo: requestInfoToResponseInfo(request.body.RequestInfo, true),
        Employees: []
      };

      const queryObj = JSON.parse(JSON.stringify(request.query));
      

      //getting mdms data
      //let mdms = await mdmsData(request.body.RequestInfo, queryObj.tenantId);
      
      
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
      
      
     let code="";
     let name="";
     let departments="";
     
     if (queryObj.code) {
      code= queryObj.code;
     }
    //  if (queryObj.name) {            
    //   name=queryObj.name;
    //  }
     if (queryObj.departments) {            
      departments=queryObj.departments;
     }
     //let hrmsResponse = await getEmployeeDetails(request.body.RequestInfo, queryObj.tenantId);   
     let hrmsResponse = await getEmployeeDetails(request.body.RequestInfo, queryObj.tenantId,code,name,departments);   
     let hrmsEmployee=hrmsResponse.Employees;

      let text ="select pnr.uuid as pension_notification_register_id, pe.uuid as pension_employee_id, pe.employee_hrms_id, pe.employee_hrms_code, pe.name, pe.date_of_birth, pe.date_of_retirement, pe.tenantid, pe.gender, pe.employee_status, pe.employee_type, pe.date_of_appointment from eg_pension_employee pe join eg_pension_notification_register pnr on pe.uuid=pnr.pension_employee_id where pnr.active =true and (pnr.is_initiated is null or pnr.is_initiated =false)";
               
      if (queryObj.tenantId) {
        text = `${text} and pe.tenantid = '${queryObj.tenantId}'`;
      }
      if (queryObj.code) {
        text = `${text} and pe.employee_hrms_code = '${queryObj.code}'`;
      }
      if (queryObj.name) {
        text = `${text} and upper(pe.name) like '%${String(queryObj.name).toUpperCase()}%'`;
      }
      if (queryObj.dob) {
        let modifiedQueryDobNum = adjust530(queryObj.dob);
          //text = `${text} and pe.date_of_birth = ${queryObj.dob}`;
          text = `${text} and pe.date_of_birth = ${modifiedQueryDobNum}`;
      }
      if(queryObj.endDate){
        /*
        let today=new Date();
        let startDate=`${today.getFullYear()}-${today.getMonth()+1}-${today.getDate()}`;  
        logger.debug(startDate);      
        let epochStartDate=Number(convertDateToEpoch(startDate,"dob"));        
        let epochEndDate=Number(convertDateToEpoch(queryObj.endDate,"dob"));        
        text = `${text} and pe.date_of_retirement >=${epochStartDate} and pe.date_of_retirement <=${epochEndDate}`;
        */
        text = `${text} and pe.date_of_retirement <=${Number(queryObj.endDate)}`;
      }
     
      let sqlQuery = text;
      
      

      let pensionEmployees=[];
      let employees=[];

      db.query(sqlQuery, async (err, dbRes) => {
        if (err) {
          logger.error(err.stack);
        } else {
          
          employees =
            dbRes.rows && !isEmpty(dbRes.rows)
              ? await mergeSearchResults(
                  dbRes.rows,
                  request.query,
                  request.body.RequestInfo
                )
              : [];
              
          
             for (var i = 0; i < employees.length; i++) {
              let employeeFilter=filter(hrmsEmployee,function(x){return x.code==employees[i].code;});
              //employee exist in hrms
              if(employeeFilter.length>0){
                employees[i].department=employeeFilter[0].assignments[employeeFilter[0].assignments.length-1].department;
                employees[i].designation=employeeFilter[0].assignments[employeeFilter[0].assignments.length-1].designation;
                pensionEmployees.push(employees[i]);
              }
              
            }
          //response.Employees=employees;
          response.Employees=pensionEmployees;
          res.json(response);
        }
      });
       
    })
  );
  return api;
};
