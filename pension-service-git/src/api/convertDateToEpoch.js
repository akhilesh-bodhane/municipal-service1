import { Router } from "express";
import { convertDateToEpoch} from "../utils";

const asyncHandler = require("express-async-handler");

export default ({ config, db }) => {
  let api = Router();
  api.post(
    "/_convertDateToEpoch",
    asyncHandler(async (request, res, next) => {           
      /*let response = {
        ResponseInfo: requestInfoToResponseInfo(request.body.RequestInfo, true),
        Epoch: []
      };*/

      const queryObj = JSON.parse(JSON.stringify(request.query));
      let epochDate=await convertDateToEpoch(queryObj.date,"dob" );
      //response.Epoch.push(epochDate);
      //res.json(response);  
      res.json(epochDate);              
    })
  );
  return api;
};
