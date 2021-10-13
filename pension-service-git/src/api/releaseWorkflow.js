import { Router } from "express";
import producer from "../kafka/producer";
import { requestInfoToResponseInfo, } from "../utils";
import { addUUIDAndAuditDetailsClaimReleaseWorkflow } from "../utils/create";
import envVariables from "../envVariables";
const asyncHandler = require("express-async-handler");

import logger from "../config/logger";

export default ({ config, db }) => {
  let api = Router();
  api.post(
    "/_releaseWorkflow",
    asyncHandler(async ({ body }, res, next) => {
      let payloads = [];
     
      
         
      body = await addUUIDAndAuditDetailsClaimReleaseWorkflow(body);      
      
      let topic=envVariables.KAFKA_TOPICS_RELEASE_WORKFLOW;
      
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
