import { Router } from "express";
import { getDependentEligibilityForPension,getDependentEligibilityForGratuity} from "../utils/calculationManager";
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
    "/_getDependentEligibilityForBenefit",
    asyncHandler(async ({ body }, res, next) => {
         

    let mdms = await mdmsData(body.RequestInfo, body.ProcessInstances[0].tenantId);   
    let dependents=body.ProcessInstances[0].dependents; 
    
    for (var i = 0; i < dependents.length; i++) { 
      let dependent=dependents[i];
      let eligibility=null;
      eligibility=getDependentEligibilityForGratuity(dependent,mdms);
      dependents[i].isEligibleForGratuity=eligibility=="TRUE"?true:false;     
    }

    

    for (var i = 0; i < dependents.length; i++) {   
      let eligibility=null;    
      if(dependents[i].isEligibleForGratuity){
        let dependent=dependents[i];
        eligibility=getDependentEligibilityForPension(dependent,mdms,dependents);
        if(eligibility=="TRUE"){
          dependents[i].isEligibleForPension=true;
          break;
        }
      }      
    }

    
    
    let response = {        
      ResponseInfo: requestInfoToResponseInfo(body.RequestInfo, true),
      Dependents:dependents
    };
    res.json(response);
           
    })
  );
  return api;
};


