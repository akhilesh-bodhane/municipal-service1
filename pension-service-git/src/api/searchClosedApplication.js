import { Router } from "express";
import { requestInfoToResponseInfo} from "../utils";
import { mergeSearchClosedApplicationResults } from "../utils/search";
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
    "/_searchClosedApplication",
    asyncHandler(async (request, res, next) => {     
      
      let response = {
        ResponseInfo: requestInfoToResponseInfo(request.body.RequestInfo, true),
        ProcessInstances: []
      };

      const queryObj = JSON.parse(JSON.stringify(request.query));
      

      
                       
      let text ="SELECT pwh.uuid, pwh.tenantid, pwh.pension_employee_id, pwh.workflow_type, pwh.application_number, pwh.application_date, pwh.last_modified_date, pwh.workflow_state, pwhnew.application_number as recomputed_application_number, pe.employee_hrms_code,pe.name FROM eg_pension_workflow_header pwh JOIN eg_pension_employee pe ON pwh.pension_employee_id=pe.uuid LEFT JOIN eg_pension_recomputation_register prr ON pwh.uuid=prr.closed_workflow_header_id LEFT JOIN eg_pension_workflow_header pwhnew ON prr.new_workflow_header_id=pwhnew.uuid";        
      
      text = `${text} WHERE pwh.workflow_state='CLOSED'`;

      if (queryObj.tenantId) {
        text = `${text} AND pwh.tenantid = '${queryObj.tenantId}'`;
      }
      if (queryObj.businessService) {
        text = `${text} AND pwh.workflow_type = '${queryObj.businessService}'`;
      }  
      if (queryObj.businessId) {
        text = `${text} AND pwh.application_number = '${queryObj.businessId}'`;
      } 
      if (queryObj.name) {
        text = `${text} and upper(pe.name) like '%${String(queryObj.name).toUpperCase()}%'`;
      }
      if (queryObj.startDate && queryObj.endDate) {
        text = `${text} AND pwh.last_modified_date >=${Number(queryObj.startDate)} AND pwh.last_modified_date<=${Number(queryObj.endDate)}`;
      }             
            
      let sqlQuery = text;
      
      

      let processInstances=[];

      db.query(sqlQuery, async (err, dbRes) => {
        if (err) {
          logger.error(err.stack);
        } else {
          
          processInstances =
            dbRes.rows && !isEmpty(dbRes.rows)
              ? await mergeSearchClosedApplicationResults(
                  dbRes.rows,
                  request.query,
                  request.body.RequestInfo
                )
              : [];
              
          response.ProcessInstances=processInstances;
          res.json(response);
        }
      });
    })
  );
  return api;
};
