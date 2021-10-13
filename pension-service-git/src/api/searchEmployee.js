import { Router } from "express";
import { requestInfoToResponseInfo } from "../utils";
import { mergeSearchEmployee,mergeAssignmentResults,mergeServiceHistoryResults } from "../utils/search";
import isEmpty from "lodash/isEmpty";
import get from "lodash/get";
import some from "lodash/some";
import { actions } from "../utils/search";
import { validatePensionNotificationRegisterSearchModel } from "../utils/modelValidation";
import envVariables from "../envVariables";
import mdmsData from "../utils/mdmsData";
import filter from "lodash/filter";
import orderBy from "lodash/orderBy";
const asyncHandler = require("express-async-handler");

import logger from "../config/logger";

export default ({ config, db }) => {
  let api = Router();
  api.post(
    "/_searchEmployee",
    asyncHandler(async (request, res, next) => {     
      
      
      const queryObj = JSON.parse(JSON.stringify(request.query));
      

      let employee;
      let assignments=[];
      let serviceHistory=[];
      let employees=[];

      //assignments
      text ="SELECT pea.tenantid, position, department, designation, from_date, to_date, govt_order_no, reporting_to, is_hod, is_current_assignment, is_primary_assignment from eg_pension_employee_assignment pea JOIN eg_pension_employee pe ON pea.pension_employee_id=pe.uuid WHERE pea.is_pension_applicable=true AND pea.active =true"                                
      if (queryObj.code) {
        text = `${text} AND pe.employee_hrms_code = '${queryObj.code}'`;
      }                              

      let sqlQueryAssignment=text;
            
      /* db.query(sqlQueryAssignment, async (err, dbRes) => {
        if (err) {
          logger.error(err.stack);
        } else {        
          assignments =
          dbRes.rows && !isEmpty(dbRes.rows)
            ? await mergeAssignmentResults(
                dbRes.rows,
                request.query,
                request.body.RequestInfo
              )
            : [];  
            logger.debug("assignments",assignments);  
            //employee.assignments=assignments;                                                      
        }
      });                 */
    
    

     

       //service history
       text ="SELECT pesh.tenantid, service_status, service_from, service_to, order_no, location, is_current_position from eg_pension_employee_service_history pesh JOIN eg_pension_employee pe ON pesh.pension_employee_id=pe.uuid WHERE pesh.active =true"                                  
       if (queryObj.code) {
        text = `${text} AND pe.employee_hrms_code = '${queryObj.code}'`;
      }                             
 
       let sqlQueryServiceHistory=text;
              
       /* db.query(sqlQueryServiceHistory, async (err, dbRes) => {
         if (err) {
           logger.error(err.stack);
         } else {        
           serviceHistory =
           dbRes.rows && !isEmpty(dbRes.rows)
             ? await mergeServiceHistoryResults(
                 dbRes.rows,
                 request.query,
                 request.body.RequestInfo
               )
             : []; 
             
            logger.debug("serviceHistory",serviceHistory);                 
            //employee.serviceHistory=serviceHistory;                                              
         }
       });    */

      
     let text =
        "select pe.uuid, pe.tenantid, pe.employee_hrms_id, pe.employee_hrms_code, pe.name, pe.date_of_birth, pe.date_of_retirement, pe.date_of_death, pe.employee_hrms_uuid, pe.salutation, pe.gender, pe.employee_status, pe.employee_type, pe.date_of_appointment, pecd.mobile_number, pecd.email_id, pecd.alt_contact_number, pecd.pan, pecd.aadhaar_number, pecd.permanent_address, pecd.permanent_city, pecd.permanent_pin_code, pecd.correspondence_address, pecd.correspondence_city, pecd.correspondence_pin_code, pecd.father_or_husband_name, pecd.blood_group, pecd.identification_mark from eg_pension_employee pe";
      text =`${text} left join eg_pension_employee_contact_details pecd on pe.uuid = pecd.pension_employee_id and pecd.active =true`;

      if (!isEmpty(queryObj)) {
        text = text + " where ";
      }
      /*
      if (queryObj.tenantId) {
        text = `${text} pe.tenantid = '${queryObj.tenantId}'`;
      }
      */
      if (queryObj.code) {
        text = `${text} pe.employee_hrms_code = '${queryObj.code}'`;
      } 
      /*
      if (queryObj.name) {
        text = `${text} and pe.name = '${queryObj.name}'`;
      }            
      if (queryObj.dob) {
        text = `${text} and pe.date_of_birth = '${queryObj.dob}'`;
      }  
      */     
          
      let sqlQuery = text;      
      

      sqlQuery = sqlQuery + ';' + sqlQueryAssignment + ';' + sqlQueryServiceHistory + ';';
      
      db.query(sqlQuery, async (err, dbRes) => {
        if (err) {
          logger.error(err.stack);
        } else {        
          employee =
              dbRes[0].rows && !isEmpty(dbRes[0].rows)
                ? await mergeSearchEmployee(
                    dbRes[0].rows,
                    request.query,
                    request.body.RequestInfo
                  )
                : {};
                assignments =
          dbRes[1].rows && !isEmpty(dbRes[1].rows)
            ? await mergeAssignmentResults(
                dbRes[1].rows,
                request.query,
                request.body.RequestInfo
              )
            : []; 
                serviceHistory =
                dbRes[2].rows && !isEmpty(dbRes[2].rows)
                  ? await mergeServiceHistoryResults(
                      dbRes[2].rows,
                      request.query,
                      request.body.RequestInfo
                    )
                  : []; 
            logger.debug("employee",JSON.stringify(employee)); 
            employee.assignments=assignments;                                        
            employee.serviceHistory=serviceHistory;  

            employees.push(employee);                      
            let response = {
              ResponseInfo: requestInfoToResponseInfo(request.body.RequestInfo, true),
              Employees: employees
            };                                
            res.json(response); 
        }  
      });    
      
      
      
      
    })
  );
  return api;
};
