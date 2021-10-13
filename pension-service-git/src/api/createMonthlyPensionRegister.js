import { Router } from "express";
import producer from "../kafka/producer";
import { requestInfoToResponseInfo,getPensionRevisions} from "../utils";
import { mergePensionRevisionResults } from "../utils/search";
import envVariables from "../envVariables";
import mdmsData from "../utils/mdmsData";
import { addUUIDAndAuditDetailsCreateMonthlyPensionRegister } from "../utils/create";
import set from "lodash/set";
import get from "lodash/get";
import filter from "lodash/filter";
import isEmpty from "lodash/isEmpty";
const asyncHandler = require("express-async-handler");

import logger from "../config/logger";

export default ({ config, db }) => {
  let api = Router();
  api.post(
    "/_createMonthlyPensionRegister",
    asyncHandler(async ({ body }, res, next) => {
      let payloads = [];
      
      
      let processInstance={  
        tenantId: body.ProcessInstances[0].tenantId,       
        effectiveYear:body.ProcessInstances[0].effectiveYear,
        effectiveMonth:body.ProcessInstances[0].effectiveMonth,
        pensionRegister: []     
      };  
      

      let processInstances=[];
      processInstances.push(processInstance);
      body.ProcessInstances=processInstances;
            
      let tenantId=body.ProcessInstances[0].tenantId;
      let effectiveYear=Number(body.ProcessInstances[0].effectiveYear);
      let effectiveMonth=Number(body.ProcessInstances[0].effectiveMonth);
      let effetiveDate=new Date(effectiveYear,effectiveMonth,1);

      let pensionRevisionResponse = await getPensionRevisions(body.RequestInfo,body.ProcessInstances[0].tenantId); 
      let pensionRevisions=pensionRevisionResponse.ProcessInstances[0].pensionRevision;
      logger.debug("pensionRevisions",pensionRevisions);
      let pensionRegister=[];
      
      for (var i = 0; i < pensionRevisions.length; i++) { 
        let pensionRevision=pensionRevisions[i];
        let effectiveStartDate=new Date(pensionRevision.effectiveStartYear,pensionRevision.effectiveStartMonth,1);
        let effectiveEndDate=pensionRevision.effectiveEndYear!=null? new Date(pensionRevision.effectiveEndYear,pensionRevision.effectiveEndMonth,1):effetiveDate;


        if(effetiveDate>=effectiveStartDate && effetiveDate<=effectiveEndDate){
          pensionRegister.push({
            tenantId: tenantId,
            //pensionerId: pensionRevision.pensionerId,
            pensionRevisionId: pensionRevision.pensionRevisionId,                  
            effectiveYear: effectiveYear,
            effectiveMonth: effectiveMonth
          });
        }
      }
      
 
      body.ProcessInstances[0].pensionRegister=pensionRegister;
      
      body = await addUUIDAndAuditDetailsCreateMonthlyPensionRegister(body);        
      
      
      payloads.push({
        topic: envVariables.KAFKA_TOPICS_CREATE_MONTHLY_PENSION_REGISTER, 
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
