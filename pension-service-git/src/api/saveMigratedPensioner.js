import { Router } from "express";
import producer from "../kafka/producer";
import { requestInfoToResponseInfo} from "../utils";
import envVariables from "../envVariables";
import mdmsData from "../utils/mdmsData";
import { addUUIDAndAuditDetailsMigratedPensioner } from "../utils/create";
import isEmpty from "lodash/isEmpty";
import set from "lodash/set";
import get from "lodash/get";
import { intConversion,mergeMigratedPensionerResults} from "../utils/search";
const asyncHandler = require("express-async-handler");

import logger from "../config/logger";

export default ({ config, db }) => {
  let api = Router();
  api.post(
    "/_saveMigratedPensioner",
    asyncHandler(async ({ body }, res, next) => {
      let payloads = [];
    

           
      let text =
      "SELECT \"Sl No\" As sl_no, \"Name\" As name, \"Employee Code\" AS code, \"Date of Birth\" AS date_of_birth, \"Gender\" AS gender, \"Date of Death (if applicable)\" AS date_of_death, \"Mobile Number\" AS mobile_number, \"Email\" As email, \"Address\" As address, \"Bank Details\" AS bank_details, \"Bank Account Number\" AS bank_account_number, \"Bank IFSC\" AS bank_ifsc, \"Bank Code\" AS bank_code, \"Employee Status\" AS employee_status, \"Employee Type\" AS employee_type, \"Employee Group\" As employee_group, \"Designation\" As designation, \"Department\" AS department, \"Date of Joining\" AS date_of_joining, \"Service End Date\" AS service_end_date, \"Date of Retirement\" AS date_of_retirement, \"Date of Commencement\" As date_of_contingent, \"Claimant Name\" AS claimant_name, \"Claimant Date of Birth\" As claimant_dob, \"Claimant Relationship\" AS claimant_relationship, \"Claimant Mobile Number\" As claimant_mobile_number, \"Claimant Adddress\" AS claimant_address, \"Claimant Bank Details\" AS claimant_bank_details, \"Claimant Bank Account Number\" As claimant_bank_account_number, \"Claimant Bank IFSC\" As claimant_bank_ifsc, \"Claimant Bank Code\" As claimant_bank_code, \"NQS Year\" AS nqs_year, \"NQS Month\" AS nqs_month, \"NQS Days\" AS nqs_days, \"LPD\" AS lpd, \"Commuted Value\" AS commuted_value, \"DCRG\" AS dcrg, \"DCRG Dues Deduction\" AS dcrg_dues_deductions, \"Net Gratuity\" AS net_gratuity, \"Terminal Benefit\" AS terminal_benefit, \"Family Pension I Start Date\" AS family_pension_i_start_date, \"Family Pension I End Date\" AS family_pension_i_end_date, \"Family Pension II Start Date\" AS family_pension_ii_start_date, \"Ex Gratia\" AS ex_gratia, \"LTC\" AS ltc, \"Whether DA Medical Admissible\" AS is_da_medical_admissible, \"Pensioner Number\" AS pensioner_number, \"Start Year\" As start_year, \"Start Month\" AS start_month, \"End Year\" AS end_year, \"End Month\" AS end_month, \"Basic Pension\" AS basic_pension, \"DA\" AS da, \"Commuted Pension\" AS commuted_pension, \"Additional Pension\" AS additional_pension, \"IR\" AS ir, \"FMA\" AS fma, \"Misc\" AS misc, \"Wound or Extraordinary Pension (in case of disability)\" AS wound_extraordinary_pension, \"Attendant Allowance (in case of disability)\" AS attendant_allowance, \"Total Pension\" AS total_pension, \"Over Payment\" AS over_payment, \"Income Tax\" AS income_tax, \"CESS\" AS cess, \"Pension Deductions\" AS pension_deductions, \"Net Deductions\" AS net_deductions, \"Net Pension\" AS net_pension, \"Bill Code\" AS bill_code FROM eg_pension_pensioner_migration_draft WHERE \"Sl No\" IS NOT NULL";                                    
      
      let sqlQuery = text;     
      

      let pensioner=[];
      db.query(sqlQuery, async (err, dbRes) => {
        if (err) {
          logger.error(err.stack);
        } else {        
          pensioner =
          dbRes.rows && !isEmpty(dbRes.rows)
            ? await mergeMigratedPensionerResults(
                dbRes.rows,
                null,
                body.RequestInfo
              )
            : [];  
            
            body.Pensioner=pensioner;            
            body = await addUUIDAndAuditDetailsMigratedPensioner(body); 
            
                     
            payloads.push({
              topic: envVariables.KAFKA_TOPICS_SAVE_MIGRATED_PENSIONER,
              messages: JSON.stringify(body)
            });
              
            producer.send(payloads, function(err, data) {
              let response = {
                ResponseInfo: requestInfoToResponseInfo(body.RequestInfo, true),
                Pensioner: body.Pensioner
              };
              res.json(response);
            });
                                                  
        }
      });      
      
    })
  );
  return api;
};
