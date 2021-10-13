import { Router } from "express";
import producer from "../kafka/producer";
import { requestInfoToResponseInfo,convertDateToEpoch, epochToYmd,getDependentEligibilityForBenefit} from "../utils";
import envVariables from "../envVariables";
import mdmsData from "../utils/mdmsData";
import { addUUIDAndAuditDetails } from "../utils/create";
import isEmpty from "lodash/isEmpty";
import set from "lodash/set";
import get from "lodash/get";
import orderBy from "lodash/orderBy";
import { intConversion} from "../utils/search";
const asyncHandler = require("express-async-handler");

import logger from "../config/logger";

export default ({ config, db }) => {
  let api = Router();
  api.post(
    "/_checkDependentEligibilityForBenefit",
    asyncHandler(async ({ body }, res, next) => {              
     
      for (var i = 0; i < body.ProcessInstances[0].dependents.length; i++) {                 
        body.ProcessInstances[0].dependents[i].dob=epochToYmd(intConversion(body.ProcessInstances[0].dependents[i].dob));
        body.ProcessInstances[0].dependents[i].isDisabled=body.ProcessInstances[0].dependents[i].isDisabled?body.ProcessInstances[0].dependents[i].isDisabled:false;
        body.ProcessInstances[0].dependents[i].maritalStatus=body.ProcessInstances[0].dependents[i].maritalStatus?body.ProcessInstances[0].dependents[i].maritalStatus:false;
        body.ProcessInstances[0].dependents[i].isHollyDependent=body.ProcessInstances[0].dependents[i].isHollyDependent?body.ProcessInstances[0].dependents[i].isHollyDependent:false;
        body.ProcessInstances[0].dependents[i].noSpouseNoChildren=body.ProcessInstances[0].dependents[i].noSpouseNoChildren?body.ProcessInstances[0].dependents[i].noSpouseNoChildren:false;
        body.ProcessInstances[0].dependents[i].isGrandChildFromDeceasedSon=body.ProcessInstances[0].dependents[i].isGrandChildFromDeceasedSon?body.ProcessInstances[0].dependents[i].isGrandChildFromDeceasedSon:false;
        body.ProcessInstances[0].dependents[i].isEligibleForGratuity=false;
        body.ProcessInstances[0].dependents[i].isEligibleForPension=false;
      }
      

      let eligibilityRespone=await getDependentEligibilityForBenefit(body);

      logger.debug("eligibilityRespone",JSON.stringify(eligibilityRespone));
      let dependents=eligibilityRespone.Dependents;

      for (var i = 0; i < dependents.length; i++) {  
        dependents[i].dob=convertDateToEpoch(dependents[i].dob,"dob");
      }
              
      let processInstances=[];
      processInstances.push({
        dependents
        });

        let response = {
          ResponseInfo: requestInfoToResponseInfo(body.RequestInfo, true),
          ProcessInstances: processInstances          
        };
        
        
        res.json(response);     
        
    })
  );
  return api;
};
