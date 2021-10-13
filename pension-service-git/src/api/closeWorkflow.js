import { Router } from "express";
import producer from "../kafka/producer";
import { requestInfoToResponseInfo, createWorkFlow ,searchPensionWorkflow} from "../utils";
import envVariables from "../envVariables";
import mdmsData from "../utils/mdmsData";
import { addUUIDAndAuditDetailsCloseWorkflow } from "../utils/create";
import isEmpty from "lodash/isEmpty";
import set from "lodash/set";
import get from "lodash/get";
import { intConversion} from "../utils/search";
const asyncHandler = require("express-async-handler");

import logger from "../config/logger";

export default ({ config, db }) => {
  let api = Router();
  api.post(
    "/_closeWorkflow",
    asyncHandler(async ({ body }, res, next) => {
      let payloads = [];
    

           
      let action="";
      let topic="";
      let workflowSearchResponse = await searchPensionWorkflow(body.RequestInfo, body.ProcessInstances[0].tenantId,body.ProcessInstances[0].businessId);      
      logger.debug("workflowSearchResponse", JSON.stringify(workflowSearchResponse));
      //currentState=workflowSearchResponse.ProcessInstances[0].state.state;     
      let businessService=body.ProcessInstances[0].businessService;
      let isContingentBillGenerated=body.ProcessInstances[0].isContingentBillGenerated;      
      if(isContingentBillGenerated){
        action=envVariables.EGOV_PENSION_WORKFLOW_ACTION_CLOSE;
      }
      else{
        action=envVariables.EGOV_PENSION_WORKFLOW_ACTION_SEND_BACK;
      }
      body.ProcessInstances[0].action=action;
      body = await addUUIDAndAuditDetailsCloseWorkflow(body,workflowSearchResponse); 
       
      let workflowResponse=await createWorkFlow(body);
      
      switch(action){
        case envVariables.EGOV_PENSION_WORKFLOW_ACTION_CLOSE: //Close Workflow 
          switch(businessService){    
            case envVariables.EGOV_PENSION_RRP_BUSINESS_SERVICE:
              topic= envVariables.KAFKA_TOPICS_SAVE_CLOSED;
              break;
            case envVariables.EGOV_PENSION_DOE_BUSINESS_SERVICE:
              topic= envVariables.KAFKA_TOPICS_SAVE_CLOSED;
              break;
            case envVariables.EGOV_PENSION_DOP_BUSINESS_SERVICE:
              topic= envVariables.KAFKA_TOPICS_SAVE_CLOSED;
              break;
          }
          break;                
        case envVariables.EGOV_PENSION_WORKFLOW_ACTION_SEND_BACK:
          break;
        default:
          break;

      }     
      
         

      payloads.push({
        topic: topic,
        messages: JSON.stringify(body)
      });
      producer.send(payloads, function(err, data) {
        let response = {
          ResponseInfo: requestInfoToResponseInfo(body.RequestInfo, true),
          ProcessInstances: body.ProcessInstances
        };
        res.json(response);
      });
      

        
    })
  );
  return api;
};
