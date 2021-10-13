import { Router } from "express";
import producer from "../kafka/producer";
import { requestInfoToResponseInfo,searchPensionerForPensionRevision} from "../utils";
import envVariables from "../envVariables";
import mdmsData from "../utils/mdmsData";
import { addUUIDAndAuditDetailsCloseLastRevisedPension,addUUIDAndAuditDetailsCreateRevisedPension } from "../utils/create";
import set from "lodash/set";
import get from "lodash/get";
import filter from "lodash/filter";
const asyncHandler = require("express-async-handler");

import logger from "../config/logger";

export default ({ config, db }) => {
  let api = Router();
  api.post(
    "/_createRevisedPension",
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
      if(pensionRevisionList.length>0){
        pensionRevisionList=filter(pensionRevisionList,function(x){return x.effectiveEndYear==null && x.effectiveEndMonth==null;})
      }  

      if(pensionRevisionList && pensionRevisionList.length>0){
        let lastPensionRevision=[];
        let newPensionRevision = [];
        let nextPensionRevision = [];
        lastPensionRevision.push(pensionRevisionList[0]);  
        
        newPensionRevision.push(body.ProcessInstances[0].pensionRevision[0]);
        if(newPensionRevision[0].effectiveEndMonth != null 
          && newPensionRevision[0].effectiveEndYear != null){
            nextPensionRevision.push(lastPensionRevision[0]);
            let nextPensionRevisionEffectiveStartYear = newPensionRevision[0].effectiveEndMonth==12?newPensionRevision[0].effectiveEndYear+1:newPensionRevision[0].effectiveEndYear;
            let nextPensionRevisionEffectiveStartMonth = newPensionRevision[0].effectiveEndMonth==12?1:newPensionRevision[0].effectiveEndMonth+1;
            
            nextPensionRevision[0].effectiveStartYear = nextPensionRevisionEffectiveStartYear;
            nextPensionRevision[0].effectiveStartMonth = nextPensionRevisionEffectiveStartMonth;

            nextPensionRevision[0].effectiveEndYear = null;
            nextPensionRevision[0].effectiveEndMonth = null;

            body.ProcessInstances[0].pensionRevision.push(nextPensionRevision[0]);

          }

        body.ProcessInstances[0].lastPensionRevision=lastPensionRevision;     
        body = await addUUIDAndAuditDetailsCloseLastRevisedPension(body);
      }

      body = await addUUIDAndAuditDetailsCreateRevisedPension(body);
      
      
      
      payloads.push({
        topic: envVariables.KAFKA_TOPICS_CREATE_REVISED_PENSION, 
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
