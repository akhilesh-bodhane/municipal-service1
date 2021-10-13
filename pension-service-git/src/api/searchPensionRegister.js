import { Router } from "express";
import { requestInfoToResponseInfo,searchPensioner } from "../utils";
import { mergeSearchPensionRegisterResults,mergePensionerFinalCalculatedBenefit } from "../utils/search";
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
    "/_searchPensionRegister",
    asyncHandler(async (request, res, next) => {  
      
      let response = {
        ResponseInfo: requestInfoToResponseInfo(request.body.RequestInfo, true),
        ProcessInstances: []
      };      
      let processInstance={
        pensioner:{},
        pensionRegister:[],
        pensionerFinalCalculatedBenefitDetails:{}
      }
      const queryObj = JSON.parse(JSON.stringify(request.query));
      let searchPensionerResponse=await searchPensioner(request.body.RequestInfo,queryObj.tenantId,queryObj.pensionerNumber);
      let pensioner=searchPensionerResponse.Pensioners[0];
      processInstance.pensioner=pensioner;

      let text="SELECT basic_pension, pension_deductions, additional_pension, commuted_pension, commuted_value, family_pension_i, family_pension_ii, dcrg, net_deductions, final_calculated_pension, interim_relief, da, nqs_year, nqs_month, nqs_day, dues_deductions, compassionate_pension, compensation_pension, terminal_benefit, final_calculated_gratuity, family_pension_i_start_date, family_pension_i_end_date, family_pension_ii_start_date, ex_gratia, pensioner_family_pension, total_pension, provisional_pension, wound_extraordinary_pension, attendant_allowance FROM eg_pension_pensioner_final_calculated_benefit";
      if (!isEmpty(queryObj)) {
        text = `${text} WHERE`;
      }
      if (queryObj.tenantId) {
        text = `${text} tenantid = '${queryObj.tenantId}'`;
      } 
      if (pensioner.pensionerId) {
        text=`${text} AND pensioner_id = '${pensioner.pensionerId}'`;
      }

      let sqlQuery = text;
      
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
            
            processInstance.pensionerFinalCalculatedBenefitDetails=pensionerFinalCalculatedBenefitDetails;  

            text ="SELECT pr.tenantid, pr.effective_year, pr.effective_month, pr.pension_arrear, pr.fma, pr.miscellaneous, pr.over_payment, pr.income_tax, pr.cess, pr.basic_pension, pr.additional_pension, pr.commuted_pension, pr.net_deductions, pr.final_calculated_pension, pr.interim_relief, pr.da, pr.total_pension, pr.pension_deductions, pr.wound_extraordinary_pension, pr.attendant_allowance FROM eg_pension_register pr JOIN eg_pension_pensioner pp ON pr.pensioner_id=pp.uuid WHERE pr.active=true";
               
            if (queryObj.tenantId) {
              text = `${text} and pr.tenantid = '${queryObj.tenantId}'`;
            }
            if (pensioner.pensionerId) {
              text=`${text} AND pr.pensioner_id = '${pensioner.pensionerId}'`;
            }
            if (queryObj.year) {
              text = `${text} and pr.effective_year = ${queryObj.year}`;
            }
            
            sqlQuery = text;
            let pensionRegister=[];

            db.query(sqlQuery, async (err, dbRes) => {
              if (err) {
                logger.error(err.stack);
              } else {

                pensionRegister =
                dbRes.rows && !isEmpty(dbRes.rows)
                  ? await mergeSearchPensionRegisterResults(
                      dbRes.rows,
                      request.query,
                      request.body.RequestInfo
                    )
                  : [];                    
                  processInstance.pensionRegister=pensionRegister;                                                      
                  response.ProcessInstances.push(processInstance);                                           
                  res.json(response);               

              }
            });         
        }
      });
    })
  );
  return api;
};
