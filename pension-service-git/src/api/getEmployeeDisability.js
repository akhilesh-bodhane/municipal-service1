import { Router } from "express";
import { requestInfoToResponseInfo} from "../utils";
import { mergeEmployeeDisabilityResults } from "../utils/search";
import isEmpty from "lodash/isEmpty";
import get from "lodash/get";
import some from "lodash/some";
import { actions } from "../utils/search";
import envVariables from "../envVariables";
import mdmsData from "../utils/mdmsData";
import filter from "lodash/filter";
const asyncHandler = require("express-async-handler");

import logger from "../config/logger";

export default ({ config, db }) => {
  let api = Router();
  api.post(
    "/_getEmployeeDisability",
    asyncHandler(async (request, res, next) => {     
      
      let response = {
        ResponseInfo: requestInfoToResponseInfo(request.body.RequestInfo, true),
        Employees: []
      };

      const queryObj = JSON.parse(JSON.stringify(request.query));
      
      

      let text ="SELECT dr.tenantid, dr.severity_of_disability, dr.disability_percentage, dr.date_of_injury, dr.injury_application_date, dr.wound_extraordinary_pension, dr.attendant_allowance_granted, dr.comments FROM eg_pension_disability_register dr JOIN eg_pension_employee pe ON dr.pension_employee_id=pe.uuid WHERE dr.active=true";
               
      if (queryObj.tenantId) {
        text = `${text} and upper(dr.tenantid) = '${String(queryObj.tenantId).toUpperCase()}'`;
      }
      if (queryObj.code) {
        text = `${text} and upper(pe.employee_hrms_code) = '${String(queryObj.code).toUpperCase()}'`;
      }          
     
      let sqlQuery = text;
      
      

      let employees=[];

      db.query(sqlQuery, async (err, dbRes) => {
        if (err) {
          logger.error(err.stack);
        } else {
          
          employees =
            dbRes.rows && !isEmpty(dbRes.rows)
              ? await mergeEmployeeDisabilityResults(
                  dbRes.rows,
                  request.query,
                  request.body.RequestInfo
                )
              : [];
              
              
          response.Employees=employees;
          res.json(response);
        }
      });
       
    })
  );
  return api;
};
