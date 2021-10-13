import { Router } from "express";
import { requestInfoToResponseInfo} from "../utils";
import { mergeWorkflowAccessibilty } from "../utils/search";
import isEmpty from "lodash/isEmpty";
import get from "lodash/get";
import some from "lodash/some";
import { actions } from "../utils/search";
import { validateWorkflowSearchModel} from "../utils/modelValidation";
import envVariables from "../envVariables";
import mdmsData from "../utils/mdmsData";
import filter from "lodash/filter";
const asyncHandler = require("express-async-handler");

import logger from "../config/logger";

export default ({ config, db }) => {
  let api = Router();
  api.post(
    "/_getWorkflowAccessibility",
    asyncHandler(async (request, res, next) => {     
      
      let response = {
        ResponseInfo: requestInfoToResponseInfo(request.body.RequestInfo, true),
        ProcessInstances: []
      };

      const queryObj = JSON.parse(JSON.stringify(request.query));
      
     
      let errors = validateWorkflowSearchModel(queryObj);
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
      let text =
        "select pe.employee_hrms_code, pwh.assignee from eg_pension_workflow_header pwh join eg_pension_employee pe on pwh.pension_employee_id=pe.uuid";

      if (!isEmpty(queryObj)) {
        text = text + " where ";
      }
      if (queryObj.tenantId) {
        text = `${text} pwh.tenantid = '${queryObj.tenantId}'`;
      }
      if (queryObj.businessIds) {
        text = `${text} and pwh.application_number = '${queryObj.businessIds}'`;
      }             
      text = `${text} and pwh.active = true`;
      
      
      let sqlQuery = text;      
      
     
      db.query(sqlQuery, async (err, dbRes) => {
        if (err) {
          logger.error(err.stack);
        } else {          
                  
            let workflowAccessibilty =
            dbRes.rows && !isEmpty(dbRes.rows)
              ? await mergeWorkflowAccessibilty(
                  dbRes.rows,
                  request.query,
                  request.body.RequestInfo
                )
              : {};        

              let processInstances=[];
              processInstances.push(workflowAccessibilty);
              response.ProcessInstances=processInstances;      
              res.json(response);
                           
        }
      });  
    })
  );
  return api;
};
