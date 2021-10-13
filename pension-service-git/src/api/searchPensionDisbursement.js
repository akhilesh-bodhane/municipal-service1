import { Router } from "express";
import { requestInfoToResponseInfo,searchPensioner } from "../utils";
import { mergeMonthlyPensionDrawn} from "../utils/search";
import isEmpty from "lodash/isEmpty";
import get from "lodash/get";
import some from "lodash/some";
import { actions } from "../utils/search";
import envVariables from "../envVariables";
import mdmsData from "../utils/mdmsData";
import filter from "lodash/filter";
import{encrypt, decrypt} from "../utils/encryption";
const asyncHandler = require("express-async-handler");

import logger from "../config/logger";

export default ({ config, db }) => {
  let api = Router();
  api.post(
    "/_searchPensionDisbursement",
    asyncHandler(async (request, res, next) => {  
      const queryObj = JSON.parse(JSON.stringify(request.query));
      
      /* let num = "10175936546";
      let en = encrypt(num);

      let de = decrypt(en);

      let de1 = decrypt(en); */
      
      let mdms = await mdmsData(request.body.RequestInfo, queryObj.tenantId);

      let year = filter(request.body.searchParams, function(x){return x.name=="Year";})[0].input;
      let month = filter(request.body.searchParams, function(x){return x.name=="Month";})[0].input;
      
      let text="select pp.pensioner_number as pensioner_number , (case when (pe.date_of_death is null and (pd.name is null or pd.name = '' )) then pe.name else pd.name end) as name, final_calculated_pension,(case when (pe.date_of_death is null and (pd.name is null or pd.name = '' )) then ppad.bank_address else pd.bank_details end) as bank_details,(case when (pe.date_of_death is null and (pd.name is null or pd.name = '' )) then ppad.bank_code else pd.bank_code end) as bank_code,(case when (pe.date_of_death is null and (pd.name is null or pd.name = '' )) then ppad.bank_ifsc else pd.bank_ifsc end) as bank_ifsc,(case when (pe.date_of_death is null and (pd.name is null or pd.name = '' )) then ppad.account_number else pd.bank_account_number end) as bank_account_number from eg_pension_revision pr join eg_pension_pensioner pp on pr.pensioner_id=pp.uuid join eg_pension_employee pe on pp.pension_employee_id=pe.uuid  join eg_pension_pensioner_application_details ppad on ppad.pensioner_id = pp.uuid left join eg_pension_dependent pd on pd.pension_employee_id = pp.pension_employee_id where pp.active=true AND pr.active=true and 1=1 and ((cast(concat('"+year.toString()+"', lpad('"+month.toString()+"',2,'0')) as integer)>=cast(concat(cast(pr.effective_start_year as varchar), lpad(cast(pr.effective_start_month as varchar),2,'0')) as integer) and pr.effective_end_year is not null and pr.effective_end_month is not null and cast(concat('"+year.toString()+"', lpad('"+month.toString()+"',2,'0')) as integer)<=cast(concat(cast(pr.effective_end_year as varchar), lpad(cast(pr.effective_end_month as varchar),2,'0')) as integer)) or (cast(concat('"+year.toString()+"', lpad('"+month.toString()+"',2,'0')) as integer)>=cast(concat(cast(pr.effective_start_year as varchar), lpad(cast(pr.effective_start_month as varchar),2,'0')) as integer) and pr.effective_end_year is null and pr.effective_end_month is null))";
      
      //and cast(concat('"+year.toString()+"', lpad('"+month.toString()+"',2,'0')) as integer)>=cast(concat(cast(pr.effective_start_year as varchar), lpad(cast(pr.effective_start_month as varchar),2,'0')) as integer) and (pr.effective_end_year is not null and pr.effective_end_month is not null and cast(concat('"+year.toString()+"', lpad('"+month.toString()+"',2,'0')) as integer)<cast(concat(cast(pr.effective_end_year as varchar), lpad(cast(pr.effective_end_month as varchar),2,'0')) as integer) or (pr.effective_end_year is null and pr.effective_end_month is null))";
      /* if (!isEmpty(queryObj)) {
        text = `${text} WHERE`;
      }
      if (queryObj.tenantId) {
        text = `${text} tenantid = '${queryObj.tenantId}'`;
      } 
      if (pensioner.pensionerId) {
        text=`${text} AND pensioner_id = '${pensioner.pensionerId}'`;
      }
 */
      let sqlQuery = text;
      
      let pensionerDetails={};
      db.query(sqlQuery, async (err, dbRes) => {
        if (err) {
          logger.error(err.stack);
        } else {

          pensionerDetails =
          dbRes.rows && !isEmpty(dbRes.rows)
            ? await mergeMonthlyPensionDrawn(
                dbRes.rows,
                request.query,
                request.body.RequestInfo,
                mdms
              )
            : {};  
            
            let reportData=[];
            for (var i = 0; i < pensionerDetails.length; i++) {
              reportData.push(
                [pensionerDetails[i].pensionerNumber,pensionerDetails[i].name,pensionerDetails[i].bankDetails,pensionerDetails[i].bankIfsc,pensionerDetails[i].bankCode,pensionerDetails[i].bankAccountNumber,pensionerDetails[i].finalCalculatedPension]

              );
            }

            let response = {
              ResponseInfo: requestInfoToResponseInfo(request.body.RequestInfo, true),
              reportResponses: [
                {
                    viewPath: null,
                    selectiveDownload: false,
                    reportHeader: [
                        {
                            localisationRequired: false,
                            name: "pensioner_number",
                            label: "Pensioner Number",
                            type: "string",
                            defaultValue: null,
                            isMandatory: false,
                            isLocalisationRequired: false,
                            localisationPrefix: "",
                            showColumn: true,
                            total: false,
                            rowTotal: null,
                            columnTotal: null,
                            initialValue: null,
                            minValue: null,
                            maxValue: null
                        },
                        {
                            localisationRequired: false,
                            name: "name",
                            label: "Pensioner Name",
                            type: "string",
                            defaultValue: null,
                            isMandatory: false,
                            isLocalisationRequired: false,
                            localisationPrefix: "",
                            showColumn: true,
                            total: false,
                            rowTotal: null,
                            columnTotal: null,
                            initialValue: null,
                            minValue: null,
                            maxValue: null
                        },
                        {
                            localisationRequired: false,
                            name: "bank_details",
                            label: "Bank Name",
                            type: "string",
                            defaultValue: null,
                            isMandatory: false,
                            isLocalisationRequired: false,
                            localisationPrefix: "",
                            showColumn: true,
                            total: false,
                            rowTotal: null,
                            columnTotal: null,
                            initialValue: null,
                            minValue: null,
                            maxValue: null
                        },
                        {
                            localisationRequired: false,
                            name: "bank_ifsc",
                            label: "Bank IFSC",
                            type: "string",
                            defaultValue: null,
                            isMandatory: false,
                            isLocalisationRequired: false,
                            localisationPrefix: "",
                            showColumn: true,
                            total: false,
                            rowTotal: null,
                            columnTotal: null,
                            initialValue: null,
                            minValue: null,
                            maxValue: null
                        },
                        {
                            localisationRequired: false,
                            name: "bank_code",
                            label: "Bank Code",
                            type: "string",
                            defaultValue: null,
                            isMandatory: false,
                            isLocalisationRequired: false,
                            localisationPrefix: "",
                            showColumn: true,
                            total: false,
                            rowTotal: null,
                            columnTotal: null,
                            initialValue: null,
                            minValue: null,
                            maxValue: null
                        },
                        {
                            localisationRequired: false,
                            name: "bank_account_number",
                            label: "Bank Account Number",
                            type: "string",
                            defaultValue: null,
                            isMandatory: false,
                            isLocalisationRequired: false,
                            localisationPrefix: "",
                            showColumn: true,
                            total: false,
                            rowTotal: null,
                            columnTotal: null,
                            initialValue: null,
                            minValue: null,
                            maxValue: null
                        },
                        {
                            localisationRequired: false,
                            name: "final_calculated_pension",
                            label: "Net Pension",
                            type: "string",
                            defaultValue: null,
                            isMandatory: false,
                            isLocalisationRequired: false,
                            localisationPrefix: "",
                            showColumn: true,
                            total: true,
                            rowTotal: null,
                            columnTotal: null,
                            initialValue: null,
                            minValue: null,
                            maxValue: null
                        }
                    ],
                    ttl: null,
                    reportData: reportData
                }
            ]
            };  
            //response.reportResponses.reportData=["abc","abc"];
            res.json(response);

        
        }
      });
    })
  );
  return api;
};
