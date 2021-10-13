import { Router } from "express";
import { requestInfoToResponseInfo} from "../utils";
import { mergeSearchApplicationResults } from "../utils/search";
import isEmpty from "lodash/isEmpty";
import get from "lodash/get";
import some from "lodash/some";
import envVariables from "../envVariables";
import mdmsData from "../utils/mdmsData";
import filter from "lodash/filter";
const asyncHandler = require("express-async-handler");

import logger from "../config/logger";

export default ({ config, db }) => {
  let api = Router();
  api.post(
    "/_searchApplication",
    asyncHandler(async (request, res, next) => {     
      
      let response = {
        ResponseInfo: requestInfoToResponseInfo(request.body.RequestInfo, true),
        Applications: []
      };
      
      let text ="SELECT pwh.uuid, pwh.tenantid, pwh.pension_employee_id, pwh.workflow_type, pwh.application_number, pwh.application_date, pwh.last_modified_date, pwh.workflow_state, pe.employee_hrms_code, pe.name FROM eg_pension_workflow_header pwh JOIN eg_pension_employee pe ON pwh.pension_employee_id=pe.uuid";        
      if(request.query ){
        const queryObj = JSON.parse(JSON.stringify(request.query));

        text = `${text} WHERE`;
            
        if (queryObj.tenantId) {
          text = `${text} pwh.tenantid = '${queryObj.tenantId}'`;
        }
        if (queryObj.code) {
          text = `${text} AND pe.employee_hrms_code = '${queryObj.code}'`;
        }
        if (queryObj.businessId) {
          text = `${text} AND pwh.application_number = '${queryObj.businessId}'`;
        }
        if (queryObj.businessService) {
          text = `${text} AND pwh.workflow_type = '${queryObj.businessService}'`;
        } 
      } 
       
      let sqlQuery = text;
      
      

      let applications=[];

      db.query(sqlQuery, async (err, dbRes) => {
        if (err) {
          logger.error(err.stack);
        } else {
          
          applications =
            dbRes.rows && !isEmpty(dbRes.rows)
              ? await mergeSearchApplicationResults(
                  dbRes.rows,
                  request.query,
                  request.body.RequestInfo
                )
              : [];
              
          response.Applications=applications;
          res.json(response);
        }
      });
    })
  );
  return api;
};
