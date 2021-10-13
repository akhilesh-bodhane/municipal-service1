import { Router } from "express";
import producer from "../kafka/producer";
import { requestInfoToResponseInfo, createWorkFlow ,searchClosedApplication} from "../utils";
import envVariables from "../envVariables";
import mdmsData from "../utils/mdmsData";
import { addUUIDAndAuditDetailsInitiateReComputation } from "../utils/create";
import { Message} from "../utils/message";
import isEmpty from "lodash/isEmpty";
import set from "lodash/set";
import get from "lodash/get";
import filter from "lodash/filter";
import { intConversion} from "../utils/search";
const asyncHandler = require("express-async-handler");

import logger from "../config/logger";

export default ({ config, db }) => {
  let api = Router();
  api.post(
    "/_initiateReComputation",
    asyncHandler(async ({ body }, res, next) => {
      let payloads = [];
      
      const message=Message();
                 
      let tenantId=body.ProcessInstances[0].tenantId;  
      let businessService=body.ProcessInstances[0].businessService;
      let closedApplicationNumber=body.ProcessInstances[0].closedWorkflow.businessId;
      let action=body.ProcessInstances[0].action;    
      let nextState="";    
                   
      let closedApplicationResponse=await searchClosedApplication(body.RequestInfo,tenantId,businessService,closedApplicationNumber);
      let closedWorkflowHeaderId=closedApplicationResponse.ProcessInstances[0].workflowHeaderId;
      let pensionEmployeeId=closedApplicationResponse.ProcessInstances[0].pensionEmployeeId;
      body.ProcessInstances[0].closedWorkflow.workflowHeaderId=closedWorkflowHeaderId;
      let employee={
        pensionEmployeeId: pensionEmployeeId
      };
      body.ProcessInstances[0].employee=employee;
    
      body = await addUUIDAndAuditDetailsInitiateReComputation(body);      
      
      
      let workflowResponse=await createWorkFlow(body);
      nextState=workflowResponse.ProcessInstances[0].state.state;              
      body.ProcessInstances[0].workflowHeader.state=nextState;  
      
      
            
      let topic=envVariables.KAFKA_TOPICS_INITIATE_RECOMPUTATION;      
    
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
