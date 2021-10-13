import { Router } from "express";
import producer from "../kafka/producer";
import { requestInfoToResponseInfo} from "../utils";
import envVariables from "../envVariables";
import mdmsData from "../utils/mdmsData";
import { addUUIDAndAuditDetails } from "../utils/create";
import set from "lodash/set";
import get from "lodash/get";
const asyncHandler = require("express-async-handler");

export default ({ config, db }) => {
  let api = Router();
  api.post(
    "/_saveEmployees",
    asyncHandler(async ({ body }, res, next) => {
      let payloads = [];
      //getting mdms data
      
         
      
      payloads.push({
        topic: envVariables.KAFKA_TOPICS_SAVE_EMPLOYEES, //save employee to pension module
        messages: JSON.stringify(body)
      });
      producer.send(payloads, function(err, data) {
        let response = {
          ResponseInfo: requestInfoToResponseInfo(body.RequestInfo, true),
          Employees: body.Employees
        };
        res.json(response);
      });
    })
  );
  return api;
};
