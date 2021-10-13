import { Router } from "express";
import producer from "../kafka/producer";
import { requestInfoToResponseInfo} from "../utils";
import envVariables from "../envVariables";
import mdmsData from "../utils/mdmsData";
import { addUUIDAndAuditDetailsPensionerPensionDiscontinuation } from "../utils/create";
import set from "lodash/set";
import get from "lodash/get";
const asyncHandler = require("express-async-handler");

import logger from "../config/logger";

export default ({ config, db }) => {
  let api = Router();
  api.post(
    "/_pensionerPensionDiscontinuation",
    asyncHandler(async ({ body }, res, next) => {
      let payloads = [];
      //getting mdms data
      
         
      
      body = await addUUIDAndAuditDetailsPensionerPensionDiscontinuation(body);
      
      
      payloads.push({
        topic: envVariables.KAFKA_TOPICS_PENSIONER_PENSION_DISCONTINUATION, 
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
