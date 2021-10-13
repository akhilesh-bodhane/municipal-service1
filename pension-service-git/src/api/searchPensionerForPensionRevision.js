import { Router } from "express";
import { requestInfoToResponseInfo,epochToYmd } from "../utils";
import { mergeSearchPensionerForPensionRevisionResults,mergePensionerFinalCalculatedBenefit } from "../utils/search";
import isEmpty from "lodash/isEmpty";
import get from "lodash/get";
import some from "lodash/some";
import { actions } from "../utils/search";
import envVariables from "../envVariables";
import mdmsData from "../utils/mdmsData";
import filter from "lodash/filter";
const asyncHandler = require("express-async-handler");

import logger from "../config/logger";

export default ({ config, db }) => {
  let api = Router();
  api.post(
    "/_searchPensionerForPensionRevision",
    asyncHandler(async (request, res, next) => {  
      
      let response = {
        ResponseInfo: requestInfoToResponseInfo(request.body.RequestInfo, true),
        ProcessInstances: []
      };      
     
      const queryObj = JSON.parse(JSON.stringify(request.query));
      

      let text ="SELECT ppfcb.pensioner_id, pp.tenantid, pp.pension_employee_id, pp.business_service, pp.pensioner_number, pe.name, pr.uuid, pr.effective_start_year, pr.effective_start_month, pr.effective_end_year, pr.effective_end_month, pr.pension_arrear, pr.fma, pr.miscellaneous, pr.over_payment, pr.income_tax, pr.cess, pr.basic_pension, pr.additional_pension, pr.commuted_pension, pr.net_deductions, pr.final_calculated_pension, pr.interim_relief, pr.da, pr.total_pension, pr.pension_deductions, pr.pensioner_final_calculated_benefit_id, pr.remarks, pr.wound_extraordinary_pension, pr.attendant_allowance FROM eg_pension_revision pr JOIN eg_pension_pensioner_final_calculated_benefit ppfcb ON pr.pensioner_final_calculated_benefit_id=ppfcb.uuid JOIN eg_pension_pensioner pp ON ppfcb.pensioner_id= pp.uuid JOIN eg_pension_employee pe ON pp.pension_employee_id = pe.uuid WHERE pr.active=true AND pp.active=true AND ppfcb.active=true";
               
      if (queryObj.tenantId) {
        text = `${text} and upper(pp.tenantid) = '${String(queryObj.tenantId).toUpperCase()}' `;
      }
      if (queryObj.pensionerNumber) {
        text = `${text} and pp.pensioner_number = '${queryObj.pensionerNumber}' `;
      }
      
      let sqlQuery = text;
      
      

      let pensionerPensionRevision={};
      let processInstances=[];

      db.query(sqlQuery, async (err, dbRes) => {
        if (err) {
          logger.error(err.stack);
        } else {
          
          pensionerPensionRevision =
            dbRes.rows && !isEmpty(dbRes.rows)
              ? await mergeSearchPensionerForPensionRevisionResults(
                  dbRes.rows,
                  request.query,
                  request.body.RequestInfo
                )
              : {};   
              
              if(pensionerPensionRevision && !isEmpty(pensionerPensionRevision)){
                text="SELECT basic_pension, pension_deductions, additional_pension, commuted_pension, commuted_value, family_pension_i, family_pension_ii, dcrg, net_deductions, final_calculated_pension, interim_relief, da, nqs_year, nqs_month, nqs_day, dues_deductions, compassionate_pension, compensation_pension, terminal_benefit, final_calculated_gratuity, family_pension_i_start_date, family_pension_i_end_date, family_pension_ii_start_date, ex_gratia, pensioner_family_pension, total_pension, provisional_pension, wound_extraordinary_pension, attendant_allowance, invalid_pension FROM eg_pension_pensioner_final_calculated_benefit";
                text=`${text} WHERE uuid = '${pensionerPensionRevision.pensioner.pensionerFinalCalculatedBenefitId}'`;

                sqlQuery = text;
                
                let pensionerFinalCalculatedBenefitDetails={};
                db.query(sqlQuery, async (err, dbRes) => {
                  if (err) {
                    logger.error(err.stack);
                  } else {

                    pensionerFinalCalculatedBenefitDetails =
                    dbRes.rows && !isEmpty(dbRes.rows)
                      ? await mergePensionerFinalCalculatedBenefit(
                          dbRes.rows,
                          request.query,
                          request.body.RequestInfo
                        )
                      : {};  
                      logger.debug("pensionerFinalCalculatedBenefitDetails",pensionerFinalCalculatedBenefitDetails);
                      pensionerPensionRevision.pensionerFinalCalculatedBenefitDetails=pensionerFinalCalculatedBenefitDetails;

                      processInstances.push(pensionerPensionRevision);
                      response.ProcessInstances=processInstances;                                                  
                      res.json(response);            

                  }
                });
              }                           
        }
      });
       
    })
  );
  return api;
};
