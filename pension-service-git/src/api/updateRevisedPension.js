import { Router } from "express";
import producer from "../kafka/producer";
import { requestInfoToResponseInfo,searchPensionerForPensionRevision} from "../utils";
import envVariables from "../envVariables";
import mdmsData from "../utils/mdmsData";
import { addUUIDAndAuditDetailsUpdateRevisedPension,addUUIDAndAuditDetailsCloseLastRevisedPension } from "../utils/create";
import set from "lodash/set";
import get from "lodash/get";
import filter from "lodash/filter";
import orderBy from "lodash/orderBy";
const asyncHandler = require("express-async-handler");

import logger from "../config/logger";

export default ({ config, db }) => {
  let api = Router();
  api.post(
    "/_updateRevisedPension",
    asyncHandler(async ({ body }, res, next) => {
      let payloads = [];
      
      let processInstance={
        tenantId: body.ProcessInstances[0].tenantId,     
        pensioner: body.ProcessInstances[0].pensioner,   
        pensionRevision: body.ProcessInstances[0].pensionRevision,   
        lastPensionRevision: []     
      };  

      let processInstances=[];
      processInstances.push(processInstance);
      body.ProcessInstances=processInstances;

      let pensionRevisionResponse = await searchPensionerForPensionRevision(body.RequestInfo,body.ProcessInstances[0].tenantId,body.ProcessInstances[0].pensioner.pensionerNumber); 
      let pensionRevisionList=pensionRevisionResponse.ProcessInstances[0].pensionRevision;
      //pensionRevisionList=filter(pensionRevisionList,function(x){return x.effectiveEndYear!=null && x.effectiveEndMonth!=null;})
      if(pensionRevisionList.length>1){
        pensionRevisionList=filter(pensionRevisionList,function(x){return x.effectiveStartYear<body.ProcessInstances[0].pensionRevision[0].effectiveStartYear ||(x.effectiveStartYear==body.ProcessInstances[0].pensionRevision[0].effectiveStartYear && x.effectiveStartMonth<body.ProcessInstances[0].pensionRevision[0].effectiveStartMonth);});
        if(pensionRevisionList.length>1){
          pensionRevisionList=orderBy(pensionRevisionList,['effectiveStartYear','effectiveStartMonth'],['desc']);        
        }                
      }
 
      if(pensionRevisionList && pensionRevisionList.length>1){
        let lastPensionRevision=[];
        lastPensionRevision.push(pensionRevisionList[0]);        
        logger.debug("lastPensionRevision", JSON.stringify(lastPensionRevision));

        body.ProcessInstances[0].lastPensionRevision=lastPensionRevision;       
        body = await addUUIDAndAuditDetailsCloseLastRevisedPension(body);
      }

      body = await addUUIDAndAuditDetailsUpdateRevisedPension(body);
      
      
      payloads.push({
        topic: envVariables.KAFKA_TOPICS_UPDATE_REVISED_PENSION, 
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
