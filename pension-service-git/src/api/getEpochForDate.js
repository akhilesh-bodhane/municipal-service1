import { Router } from "express";
import { epochToYmd} from "../utils";
import { intConversion} from "../utils/search";
const asyncHandler = require("express-async-handler");

export default ({ config, db }) => {
  let api = Router();
  api.post(
    "/_getEpochForDate",
    asyncHandler(async (request, res, next) => {           
      /*let response = {
        ResponseInfo: requestInfoToResponseInfo(request.body.RequestInfo, true),
        Epoch: []
      };*/

      const queryObj = JSON.parse(JSON.stringify(request.query));
      let date=await epochToYmd(intConversion(queryObj.epoch));
      //response.Epoch.push(epochDate);
      //res.json(response);     
      res.json(date);
     
    })
  );
  return api;
};
