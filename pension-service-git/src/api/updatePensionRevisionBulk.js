import { Router } from "express";
import producer from "../kafka/producer";
import { requestInfoToResponseInfo,getPensionRevisions} from "../utils";
import { mergePensionRevisionResults } from "../utils/search";
import envVariables from "../envVariables";
import mdmsData from "../utils/mdmsData";
import { addUUIDAndAuditDetailsCreatePensionRevisionBulk } from "../utils/create";
import set from "lodash/set";
import get from "lodash/get";
import filter from "lodash/filter";
import isEmpty from "lodash/isEmpty";
import { getYearOfService,getDAPercentage,getCommutationPercentage,getCommutationMultiplier,getIRPercentage,getAdditionalPensionPercentage,getPensionConfigurationValue,getDOJ, getMonthsDaysInRange,getAge,isEldestDependent,getAdditionalPensionPercentageForFamily,getHalfYearOfService, getAdditionalPensionPercentageAfterRetirement, getYearDifference } from "../utils/calculationHelper";

const asyncHandler = require("express-async-handler");

import logger from "../config/logger";

export default ({ config, db }) => {
  let api = Router();
  api.post(
    "/_updatePensionRevisionBulk",
    asyncHandler(async ({ body }, res, next) => {
      let payloads = [];
      
      
      
      
      let tenantId=body.Parameters.tenantId;
      let effectiveYear=Number(body.Parameters.effectiveYear);
      let effectiveMonth=Number(body.Parameters.effectiveMonth);
      let modifyDA=Boolean(body.Parameters.modifyDA);
      let modifyIR=Boolean(body.Parameters.modifyIR);
      let modifyFMA=Boolean(body.Parameters.modifyFMA);
      let FMA=Number(body.Parameters.FMA);
      let effetiveDate=new Date(effectiveYear,effectiveMonth-1,1);

      let pensionRevisionResponse = await getPensionRevisions(body.RequestInfo,body.Parameters.tenantId); 
      let pensionRevisions=pensionRevisionResponse.ProcessInstances[0].pensionRevision;
      logger.debug("pensionRevisions",pensionRevisions);
      let newPensionRevisions=[];
      let oldPensionRevisions=[];
      
      for (var i = 0; i < pensionRevisions.length; i++) { 
        let pensionRevision=pensionRevisions[i];
        let effectiveStartDate=new Date(pensionRevision.effectiveStartYear,pensionRevision.effectiveStartMonth-1,1);
        let effectiveEndDate=pensionRevision.effectiveEndYear!=null? new Date(pensionRevision.effectiveEndYear,pensionRevision.effectiveEndMonth-1,1):effetiveDate;
        let oldPensionRevision;
        let newPensionRevision;


        if(effetiveDate>=effectiveStartDate && effetiveDate<=effectiveEndDate){

          oldPensionRevision=pensionRevision;
          newPensionRevision=pensionRevision;

          if(effectiveMonth==1){
            oldPensionRevision.effectiveEndMonth=12;
          }else{
            oldPensionRevision.effectiveEndMonth=effectiveMonth-1;
          }

          if(effectiveMonth==1){
            oldPensionRevision.effectiveEndYear=effectiveYear-1;
          }else{
            oldPensionRevision.effectiveEndYear=effectiveYear;
          }                    

          let updatedFMA = pensionRevision.fma;

          if(modifyFMA){
            updatedFMA=FMA;
          }

          //newPensionRevision.fma = updatedFMA;

          let mdms = await mdmsData(body.RequestInfo, tenantId);
          
          let updatedAdditionalPension = pensionRevision.additionalPension;

          let additionalPensionPercentage=getAdditionalPensionPercentageAfterRetirement(new Date(Number(pensionRevision.dateOfBirth)),effetiveDate,mdms);

          updatedAdditionalPension=Math.ceil((pensionRevision.basicPension)*additionalPensionPercentage/100);

          let irPercentage = getIRPercentage(effetiveDate, mdms);

          let updatedIR = pensionRevision.interimRelief;

          if(modifyIR){
            updatedIR=Math.round((pensionRevision.basicPension*updatedAdditionalPension)*irPercentage/100);
          }

          let daPercentage = getDAPercentage(effetiveDate, mdms);

          let updatedDA = pensionRevision.da;

          if(modifyDA){
            updatedDA=Math.round((pensionRevision.basicPension+updatedIR+updatedAdditionalPension)*daPercentage/100);
          }

          let updatedCommutedPension = pensionRevision.commutedPension;

          if(pensionRevision.commutedPension > 0){

            let retirementStartedYear = getYearDifference(new Date(Number(pensionRevision.dateOfRetirement)), effetiveDate)

            if (retirementStartedYear>15){
              updatedCommutedPension=0;

            }

          }          

          if(updatedFMA!=pensionRevision.fma || updatedDA!=pensionRevision.da
            || updatedIR!=pensionRevision.interimRelief || updatedAdditionalPension!=pensionRevision.additionalPension
            || updatedCommutedPension!=pensionRevision.commutedPension
            || (pensionRevision.effectiveStartYear==effectiveYear 
              && pensionRevision.effectiveStartMonth==effectiveMonth)){

              
          let updatedTotalPension = pensionRevision.basicPension+updatedDA-updatedCommutedPension+updatedAdditionalPension+updatedIR+updatedFMA+pensionRevision.miscellaneous+pensionRevision.woundExtraOrdinaryPension+pensionRevision.attendantAllowance;

          let updatedNetPension = updatedTotalPension-pensionRevision.netDeductions;
          
          if(oldPensionRevision.effectiveStartYear==effectiveYear 
            && oldPensionRevision.effectiveStartMonth==effectiveMonth ) {}
            else{
          oldPensionRevisions.push(oldPensionRevision);
            }

          newPensionRevisions.push(
            {
            tenantId: tenantId,
            pensionerId: pensionRevision.pensionerId,
            pensionRevisionId: pensionRevision.pensionRevisionId,                  
            effectiveStartYear: effectiveYear,
            effectiveStartMonth: effectiveMonth,
            effectiveEndYear: null,
            effectiveEndMonth:null,
            pensionArrear:pensionRevision.pensionArrear,
            fma:updatedFMA,
            miscellaneous:pensionRevision.miscellaneous,
            overPayment:pensionRevision.over_payment,
            incomeTax:pensionRevision.income_tax,
            cess:pensionRevision.cess,
            basicPension:pensionRevision.basicPension,
            commutedPension:updatedCommutedPension,
            additionalPension:updatedAdditionalPension,
            netDeductions:pensionRevision.netDeductions,
            finalCalculatedPension:updatedNetPension,
            active:true,
            interimRelief:updatedIR,
            da:updatedDA,
            totalPension:updatedTotalPension,
            pensionDeductions:pensionRevision.pensionDeductions,
            pensionerFinalCalculatedBenefitId:pensionRevision.pensionerFinalCalculatedBenefitId,
            woundExtraOrdinaryPension:pensionRevision.woundExtraOrdinaryPension,
            attendantAllowance:pensionRevision.attendantAllowance



          }
          );
        }

        }
      }
      
 
      body.Parameters.oldPensionRevisions=oldPensionRevisions;
      body.Parameters.newPensionRevisions=newPensionRevisions;
      
      body = await addUUIDAndAuditDetailsCreatePensionRevisionBulk(body);        
      
      
      payloads.push({
        topic: envVariables.KAFKA_TOPICS_CREATE_REVISED_PENSION_BULK, 
        messages: JSON.stringify(body)
      });

      producer.send(payloads, function(err, data) {
        let response = {
          ResponseInfo: requestInfoToResponseInfo(body.RequestInfo, true),
          ProcessInstances: body.Parameters
        };
        res.json(response);
      });





    })
  );
  return api;
};
