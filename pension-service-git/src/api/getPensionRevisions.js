import { Router } from "express";
import { requestInfoToResponseInfo } from "../utils";
import { mergePensionRevisionResults } from "../utils/search";
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
    "/_getPensionRevisions",
    asyncHandler(async (request, res, next) => {  
      
      let response = {
        ResponseInfo: requestInfoToResponseInfo(request.body.RequestInfo, true),
        ProcessInstances: []
      };      
     
      const queryObj = JSON.parse(JSON.stringify(request.query));
      

      let text ="select pp.tenantid, pp.pensioner_number, pr.pensioner_id, pe.date_of_birth, pe.date_of_retirement, pr.pensioner_final_calculated_benefit_id, pr.uuid, pr.effective_start_year, pr.effective_start_month, pr.effective_end_year, pr.effective_end_month, pension_arrear, miscellaneous, over_payment, income_tax, cess, basic_pension, additional_pension, commuted_pension, net_deductions, final_calculated_pension, interim_relief, da, total_pension, pension_deductions, fma, wound_extraordinary_pension, attendant_allowance from eg_pension_pensioner pp join eg_pension_revision pr on pp.uuid=pr.pensioner_id join eg_pension_employee pe on pe.uuid = pp.pension_employee_id where pp.active=true and pr.active=true";
               
      if (queryObj.tenantId) {
        text = `${text} and upper(pp.tenantid) = '${String(queryObj.tenantId).toUpperCase()}' `;
      }
      
      let sqlQuery = text;
      
      

      let pensionerPensionRevision=[];      
      let processInstances=[];
      db.query(sqlQuery, async (err, dbRes) => {
        if (err) {
          logger.error(err.stack);
        } else {
          
          pensionerPensionRevision =
            dbRes.rows && !isEmpty(dbRes.rows)
              ? await mergePensionRevisionResults(
                  dbRes.rows,
                  request.query,
                  request.body.RequestInfo
                )
              : [];   
              
              let pensionRevision={                
                pensionRevision:pensionerPensionRevision   
              };
              processInstances.push(pensionRevision);  
              response.ProcessInstances=processInstances;                                                              
              res.json(response); 
        }
      });
       
    })
  );
  return api;
};
