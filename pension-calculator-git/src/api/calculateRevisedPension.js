import { Router } from "express";
import { calculateRevisedPension} from "../utils/calculationManager";
import { getNQS,getNQSYear,getNQSMonth,getNQSDay} from "../utils/calculationHelper";
import envVariables from "../envVariables";
import { requestInfoToResponseInfo} from "../utils";
import mdmsData from "../utils/mdmsData";
import isEmpty from "lodash/isEmpty";
import set from "lodash/set";
import get from "lodash/get";
import filter from "lodash/filter";
const asyncHandler = require("express-async-handler");


export default () => {
  let api = Router();
  api.post(
    "/_calculateRevisedPension",
    asyncHandler(async ({ body }, res, next) => {
    
    
    let mdms = await mdmsData(body.RequestInfo, body.ProcessInstances[0].tenantId);
    const pensionBenefits=get(mdms,"MdmsRes.pension.pensionRevision");    

    let pensionRevision=body.ProcessInstances[0].pensionRevision;
    let rules={
        benefits: pensionBenefits
    };
    
      
    let benefits=calculateRevisedPension(pensionBenefits,pensionRevision[0]);

    for (var i = 0; i < benefits.length; i++) {       
      switch(String(benefits[i].benefitCode).toUpperCase()){ 
        case "TOTAL_PENSION":
          pensionRevision[0].totalPension=benefits[i].finalBenefitValue;                  
          break; 
        case "NET_DEDUCTION":
          pensionRevision[0].netDeductions=benefits[i].finalBenefitValue;                  
          break; 
        case "FINAL_CALCULATED_PENSION":
          pensionRevision[0].finalCalculatedPension=benefits[i].finalBenefitValue;                  
          break; 
      }
      
    }



      
    let processInstances=[];
    processInstances.push({
      pensionRevision: pensionRevision
    });
    
    let response = {        
      ResponseInfo: requestInfoToResponseInfo(body.RequestInfo, true),
      ProcessInstances:processInstances
    };
    res.json(response);
           
    })
  );
  return api;
};
