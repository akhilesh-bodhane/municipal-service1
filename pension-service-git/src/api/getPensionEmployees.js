import { Router } from "express";
import { requestInfoToResponseInfo, adjust530 } from "../utils";
import { mergeSearchEmployee,mergeAssignmentResults,mergeServiceHistoryResults,mergePensionEmployeeResults } from "../utils/search";
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
    "/_getPensionEmployees",
    asyncHandler(async (request, res, next) => {     
      
     
     let text ="SELECT pe.uuid, pe.tenantid, pe.employee_hrms_id, pe.employee_hrms_code, pe.name, pe.date_of_birth, pe.date_of_retirement, pe.date_of_death, pe.active, pe.created_by, pe.last_modified_by, pe.created_date, pe.last_modified_date, pe.employee_hrms_uuid, pe.salutation, pe.gender, pe.employee_status, pe.employee_type, pe.date_of_appointment, pea.department, pea.designation FROM eg_pension_employee pe join eg_pension_employee_assignment pea on pea.pension_employee_id = pe.uuid and pea.is_pension_applicable = true"
      
     if(request.query ){
      const queryObj = JSON.parse(JSON.stringify(request.query));

      text = `${text} WHERE`;

      if (queryObj.tenantId) {
        text = `${text} pe.tenantid = '${queryObj.tenantId}'`;
      }
      if (queryObj.code) {
        text = `${text} and pe.employee_hrms_code = '${queryObj.code}'`;
      }
      if (queryObj.name) {
        text = `${text} and upper(pe.name) like '%${String(queryObj.name).toUpperCase()}%'`;
      }
      if (queryObj.dob) {
        let modifiedQueryDobNum = adjust530(queryObj.dob);
        //text = `${text} and date_of_birth = ${queryObj.dob}`;
        text = `${text} and pe.date_of_birth = ${modifiedQueryDobNum}`;
      }

      if (queryObj.departments) {
        text = `${text} and pea.department = '${String(queryObj.departments)}'`;
      }

     }
      let sqlQuery = text;      
      
      let employees=[];
      db.query(sqlQuery, async (err, dbRes) => {
        if (err) {
          logger.error(err.stack);
        } else {        
          employees =
              dbRes.rows && !isEmpty(dbRes.rows)
                ? await mergePensionEmployeeResults(
                    dbRes.rows,
                    request.query,
                    request.body.RequestInfo
                  )
                : [];  
                
          let response = {
            ResponseInfo: requestInfoToResponseInfo(request.body.RequestInfo, true),
            Employees: employees
          };                                
          res.json(response);          
        }  
      });    
      
    })
  );
  return api;
};
