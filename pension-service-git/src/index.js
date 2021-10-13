require("babel-core/register");
require("babel-polyfill");
//import http from "http";
import express from "express";
import cors from "cors";
import morgan from "morgan";
import bodyParser, { json } from "body-parser";
// import util from "util";
import db from "./db";
import middleware from "./middleware";
import api from "./api";
import config from "./config.json";
import tracer from "./middleware/tracer";
import terminusOptions from "./utils/health";
import envVariables from "./envVariables";
import schedule from "node-schedule";
import filter from "lodash/filter";
import lte from "lodash/lte";
import gte from "lodash/gte";
import chain from "lodash/chain";
import producer from "./kafka/producer";
import { epochToYmd,loginRequest,pushEmployeesToPensionNotificationRegister,createMonthlyPensionRegister,updatePensionRevisionBulk} from "./utils";
import {  intConversion } from "./utils/search";
import {userDetails} from "./services/userService";
var swaggerUi = require("swagger-ui-express"),
  swaggerDocument = require("./swagger.json");
//const { createTerminus } = require("@godaddy/terminus");

import logger from "./config/logger";


// const validator = require('swagger-express-validator');

// const opts = {
//   schema:swaggerDocument, // Swagger schema
//   preserveResponseContentType: false, // Do not override responses for validation errors to always be JSON, default is true
//   returnRequestErrors: true, // Include list of request validation errors with response, default is false
//   returnResponseErrors: true, // Include list of response validation errors with response, default is false
//   validateRequest: true,
//   validateResponse: true,
//   requestValidationFn: (req, data, errors) => {
//     logger.debug(`failed request validation: ${req.method} ${req.originalUrl}\n ${util.inspect(errors)}`)
//   },
//   responseValidationFn: (req, data, errors) => {
//     logger.debug(`failed response validation: ${req.method} ${req.originalUrl}\n ${util.inspect(errors)}`)
//   },
//   async: true
// };

let app = express();
//app.server = http.createServer(app);

// Enable health checks and kubernetes shutdown hooks
//createTerminus(app.server, terminusOptions);

// logger
app.use(morgan("dev"));

// 3rd party middleware
app.use(
  cors({
    exposedHeaders: config.corsHeaders
  })
);

app.use(
  bodyParser.json({
    limit: config.bodyLimit
  })
);

app.use(tracer());

app.use("/api-docs", swaggerUi.serve, swaggerUi.setup(swaggerDocument));

// internal middleware
app.use(middleware({ config, db }));

// app.use(validator(opts));

// api router

app.use("/", api({ config, db }));

//error handler middleware
app.use((err, req, res, next) =>{
  
  logger.error(err);
  if (!err.errorType) {
    res.status(err.status).json(err.data);
  }
  else if (err.errorType=="custom") {
    res.status(400).json(err.errorReponse);
  }
  else {
    res.status(500);
    res.send("Oops, something went wrong.");
  }
});


/* app.server.listen(envVariables.SERVER_PORT, () => {
  logger.debug(`Started on port ${app.server.address().port}`);
}); */

app.listen(envVariables.SERVER_PORT, () => {
  logger.debug(`Started on port ${envVariables.SERVER_PORT}`);
});

var rulePensionNotificationRegister = new schedule.RecurrenceRule();
rulePensionNotificationRegister.date  = envVariables.EGOV_PENSION_PNR_SCHEDULAR_START_DATE; 
rulePensionNotificationRegister.hour=envVariables.EGOV_PENSION_PNR_SCHEDULAR_START_HOURS;
rulePensionNotificationRegister.minute = envVariables.EGOV_PENSION_PNR_SCHEDULAR_START_MINUTES;

var j =  schedule.scheduleJob(rulePensionNotificationRegister, async()=>{
  logger.debug('Pension Notification Register Schedular Started.'); 

  const loginResponse = await loginRequest(
    envVariables.EGOV_PENSION_SCHEDULAR_USERNAME,
    envVariables.EGOV_PENSION_SCHEDULAR_PASSWORD,
    envVariables.EGOV_PENSION_SCHEDULAR_GRANT_TYPE,
    envVariables.EGOV_PENSION_SCHEDULAR_SCOPE,
    envVariables.EGOV_PENSION_SCHEDULAR_TENANTID,
    envVariables.EGOV_PENSION_SCHEDULAR_USERTYPE    
  );

  

  let requestInfo={
    apiId: envVariables.EGOV_PENSION_REQUESTINFO_API_ID,
    ver: envVariables.EGOV_PENSION_REQUESTINFO_VER,
    action: envVariables.EGOV_PENSION_REQUESTINFO_ACTION,
    did: envVariables.EGOV_PENSION_REQUESTINFO_DID,
    key: envVariables.EGOV_PENSION_REQUESTINFO_KEY,
    msgId: envVariables.EGOV_PENSION_REQUESTINFO_MSG_ID,
    requesterId: envVariables.EGOV_PENSION_REQUESTINFO_REQUSTER_ID,
    authToken: loginResponse.access_token
  };  
  

  //appends userInfo in requestInfo object 
  let userInfo=await userDetails(requestInfo,loginResponse.access_token);
  requestInfo.userInfo=userInfo;

  let response;
  let requestBody = {
    RequestInfo: requestInfo
  };
  
  response=await pushEmployeesToPensionNotificationRegister(requestBody);
  logger.debug(response);
});

var ruleCreatePensionRegister = new schedule.RecurrenceRule();
ruleCreatePensionRegister.date  = envVariables.EGOV_PENSION_CREATE_PENSION_REGISTER_SCHEDULAR_START_DATE; 
ruleCreatePensionRegister.hour=envVariables.EGOV_PENSION_CREATE_PENSION_REGISTER_SCHEDULAR_START_HOURS
ruleCreatePensionRegister.minute = envVariables.EGOV_PENSION_CREATE_PENSION_REGISTER_SCHEDULAR_START_MINUTES;

var i =  schedule.scheduleJob(ruleCreatePensionRegister, async()=>{
  logger.debug('Pension Register Schedular Started.');  
  const loginResponse = await loginRequest( 
    envVariables.EGOV_PENSION_SCHEDULAR_USERNAME,
    envVariables.EGOV_PENSION_SCHEDULAR_PASSWORD,
    envVariables.EGOV_PENSION_SCHEDULAR_GRANT_TYPE,
    envVariables.EGOV_PENSION_SCHEDULAR_SCOPE,
    envVariables.EGOV_PENSION_SCHEDULAR_TENANTID,
    envVariables.EGOV_PENSION_SCHEDULAR_USERTYPE      
  );
  
  let requestInfo={
    apiId: envVariables.EGOV_PENSION_REQUESTINFO_API_ID,
    ver: envVariables.EGOV_PENSION_REQUESTINFO_VER,
    action: envVariables.EGOV_PENSION_REQUESTINFO_ACTION,
    did: envVariables.EGOV_PENSION_REQUESTINFO_DID,
    key: envVariables.EGOV_PENSION_REQUESTINFO_KEY,
    msgId: envVariables.EGOV_PENSION_REQUESTINFO_MSG_ID,
    requesterId: envVariables.EGOV_PENSION_REQUESTINFO_REQUSTER_ID,
    authToken: loginResponse.access_token
  };    

  //appends userInfo in requestInfo object 
  let userInfo=await userDetails(requestInfo,loginResponse.access_token);
  requestInfo.userInfo=userInfo;
  
  let response;
  let requestBody = {
    RequestInfo: requestInfo,
    ProcessInstances: []
  };
  
  response=await createMonthlyPensionRegister(requestBody);
  logger.debug(response);
});

var ruleUpdatePensionRevisionBulk  = new schedule.RecurrenceRule();
ruleUpdatePensionRevisionBulk.date  = envVariables.EGOV_PENSION_UPDATE_PENSION_REVISION_BULK_SCHEDULAR_START_DATE; 
ruleUpdatePensionRevisionBulk.hour=envVariables.EGOV_PENSION_UPDATE_PENSION_REVISION_BULK_SCHEDULAR_START_HOURS
ruleUpdatePensionRevisionBulk.minute = envVariables.EGOV_PENSION_UPDATE_PENSION_REVISION_BULK_SCHEDULAR_START_MINUTES;

var i =  schedule.scheduleJob(ruleUpdatePensionRevisionBulk, async()=>{
  logger.debug('Pension Revision Bulk Schedular Started.');  
  const loginResponse = await loginRequest( 
    envVariables.EGOV_PENSION_SCHEDULAR_USERNAME,
    envVariables.EGOV_PENSION_SCHEDULAR_PASSWORD,
    envVariables.EGOV_PENSION_SCHEDULAR_GRANT_TYPE,
    envVariables.EGOV_PENSION_SCHEDULAR_SCOPE,
    envVariables.EGOV_PENSION_SCHEDULAR_TENANTID,
    envVariables.EGOV_PENSION_SCHEDULAR_USERTYPE      
  );
  
  let requestInfo={
    apiId: envVariables.EGOV_PENSION_REQUESTINFO_API_ID,
    ver: envVariables.EGOV_PENSION_REQUESTINFO_VER,
    action: envVariables.EGOV_PENSION_REQUESTINFO_ACTION,
    did: envVariables.EGOV_PENSION_REQUESTINFO_DID,
    key: envVariables.EGOV_PENSION_REQUESTINFO_KEY,
    msgId: envVariables.EGOV_PENSION_REQUESTINFO_MSG_ID,
    requesterId: envVariables.EGOV_PENSION_REQUESTINFO_REQUSTER_ID,
    authToken: loginResponse.access_token
  };    

  //appends userInfo in requestInfo object 
  let userInfo=await userDetails(requestInfo,loginResponse.access_token);
  requestInfo.userInfo=userInfo;
  
  let response;
  let requestBody = {
    RequestInfo: requestInfo,
    Parameters: {}
  };
  
  response=await updatePensionRevisionBulk(requestBody);
  logger.debug(response);
});




export default app;

