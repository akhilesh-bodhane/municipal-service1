import { Router } from "express";
import { requestInfoToResponseInfo, adjust530 } from "../utils";
import { mergeSearchPensionerResults } from "../utils/search";
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
    "/_searchPensioner",
    asyncHandler(async (request, res, next) => {     
      
      let response = {
        ResponseInfo: requestInfoToResponseInfo(request.body.RequestInfo, true),
        Pensioners: []
      };

      const queryObj = JSON.parse(JSON.stringify(request.query));

      let mdms = await mdmsData(request.body.RequestInfo, queryObj.tenantId);                

      let text ="SELECT pp.uuid, pp.tenantid, pp.pensioner_number, pp.business_service, pe.name, pe.employee_hrms_code, pe.date_of_birth, pe.gender, pe.date_of_retirement, pe.date_of_death, pe.date_of_appointment, ppad.lpd, ppad.ltc, ppad.wef,";
      text = `${text} (SELECT name FROM eg_pension_dependent WHERE pension_employee_id=pp.pension_employee_id AND is_eligible_for_pension=true AND active=true) AS claimant_name,`;
      text = `${text} (SELECT dob FROM eg_pension_dependent WHERE pension_employee_id=pp.pension_employee_id AND is_eligible_for_pension=true AND active=true) AS claimant_dob,`;
      text = `${text} CASE WHEN pp.business_service='RRP_SERVICE'`;
      text = `${text} THEN (SELECT correspondence_address FROM eg_pension_employee_contact_details WHERE pension_employee_id=pp.pension_employee_id AND active=true)`;
      text = `${text} ELSE (SELECT address FROM eg_pension_dependent WHERE pension_employee_id=pp.pension_employee_id AND is_eligible_for_pension=true AND active=true)`;
      text = `${text} END AS address,`;
      text = `${text} CASE WHEN pp.business_service='RRP_SERVICE'`;
      text = `${text} THEN ppad.bank_address`;
      text = `${text} ELSE (SELECT bank_details FROM eg_pension_dependent WHERE pension_employee_id=pp.pension_employee_id AND is_eligible_for_pension=true AND active=true)`;
      text = `${text} END AS bank_details,`;
      text = `${text} CASE WHEN pp.business_service='RRP_SERVICE'`;
      text = `${text} THEN ppad.account_number`;
      text = `${text} ELSE (SELECT bank_account_number FROM eg_pension_dependent WHERE pension_employee_id=pp.pension_employee_id AND is_eligible_for_pension=true AND active=true)`;
      text = `${text} END AS bank_account_number,`;
      text = `${text} CASE WHEN pp.business_service='RRP_SERVICE'`;
      text = `${text} THEN ppad.bank_code`;
      text = `${text} ELSE (SELECT bank_code FROM eg_pension_dependent WHERE pension_employee_id=pp.pension_employee_id AND is_eligible_for_pension=true AND active=true)`;
      text = `${text} END AS bank_code,`;
      text = `${text} CASE WHEN pp.business_service='RRP_SERVICE'`;
      text = `${text} THEN ppad.bank_ifsc`;
      text = `${text} ELSE (SELECT bank_ifsc FROM eg_pension_dependent WHERE pension_employee_id=pp.pension_employee_id AND is_eligible_for_pension=true AND active=true)`;
      text = `${text} END AS bank_ifsc,`;
      text = `${text} pea.department, pea.designation`;      
      text = `${text} FROM eg_pension_pensioner pp`;
      text = `${text} INNER JOIN eg_pension_employee pe ON pp.pension_employee_id=pe.uuid`;
      text = `${text} INNER JOIN eg_pension_pensioner_application_details ppad ON pp.uuid=ppad.pensioner_id`;
      text = `${text} INNER JOIN eg_pension_employee_assignment pea ON pea.pension_employee_id=pe.uuid AND pea.is_pension_applicable=true`;
      
      text = `${text} WHERE pp.active=true`;
               
      if (queryObj.tenantId) {
        text = `${text} AND pp.tenantid = '${queryObj.tenantId}'`;
      }
      if (queryObj.pensionerNumber) {
        text = `${text} AND pp.pensioner_number = '${queryObj.pensionerNumber}'`;
      }
      if (queryObj.name) {
        text = `${text} AND upper(pe.name) like '%${String(queryObj.name).toUpperCase()}%'`;
      }
      if (queryObj.dob) {
        let modifiedQueryDobNum = adjust530(queryObj.dob);
        //text = `${text} AND pe.date_of_birth = ${queryObj.dob}`;
        text = `${text} AND pe.date_of_birth = ${modifiedQueryDobNum}`;
      }
      if (queryObj.departments) {
        text = `${text} AND pea.department = '${queryObj.departments}'`;
      }
      let sqlQuery = text;
      
      

      let pensioners=[];

      db.query(sqlQuery, async (err, dbRes) => {
        if (err) {
          logger.error(err.stack);
        } else {
          
          pensioners =
            dbRes.rows && !isEmpty(dbRes.rows)
              ? await mergeSearchPensionerResults(
                  dbRes.rows,
                  request.query,
                  request.body.RequestInfo,
                  mdms
                )
              : [];
             
          response.Pensioners=pensioners;
          res.json(response);
        }
      });
       
    })
  );
  return api;
};
