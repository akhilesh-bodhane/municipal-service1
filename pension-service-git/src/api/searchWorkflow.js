import { Router } from "express";
import { requestInfoToResponseInfo, searchWorkflow,getFileDetails,searchEmployee, getEmployeeDisability} from "../utils";
import { mergeWorkflowHeader, mergeWorkflowDocumentSearchResults, mergeWorkflowDocumentAuditSearchResults,mergeLeaveSearchResults, mergeEmployeeOtherDetails, mergePensionCalculationDetails, mergePensionCalculationUpdateDetails,mergeDependentResults, mergePensionArrearDetails } from "../utils/search";
import isEmpty from "lodash/isEmpty";
import get from "lodash/get";
import some from "lodash/some";
import { intConversion } from "../utils/search";
import { validateWorkflowSearchModel} from "../utils/modelValidation";
import envVariables from "../envVariables";
import mdmsData from "../utils/mdmsData";
import filter from "lodash/filter";
const asyncHandler = require("express-async-handler");

import logger from "../config/logger";

export default ({ config, db }) => {
  let api = Router();
  api.post(
    "/_searchWorkflow",
    asyncHandler(async (request, res, next) => {     
      
      let response = {
        ResponseInfo: requestInfoToResponseInfo(request.body.RequestInfo, true),
        ProcessInstances: []//,
        //ApplicationDetails: {},
        //PaymentDetails: {}
      };

      const queryObj = JSON.parse(JSON.stringify(request.query));
      

      //getting mdms data
      let mdms = await mdmsData(request.body.RequestInfo, queryObj.tenantId);
      
      
      let errors = validateWorkflowSearchModel(queryObj);
      if (errors.length > 0) {
        next({
          errorType: "custom",
          errorReponse: {
            ResponseInfo: requestInfoToResponseInfo(
              request.body.RequestInfo,
              true
            ),
            Errors: errors
          }
        });
        return;
      }
      
      let workflowResponse = await searchWorkflow(request.body.RequestInfo, queryObj.tenantId,queryObj.businessIds);
      let processInstances=workflowResponse.ProcessInstances;      
           

      let currentState="";
      if(processInstances!=null && processInstances.length>0)
      {
        currentState=processInstances[0].state.state;
      }
      let documentsUpload;
      let documentComment;
      let actorAcccessLevel={};
      switch(currentState)
      {
        case "INITIATED":
          actorAcccessLevel=
          {
            employeeOtherDetailsUpdate: true,
            employeeLeaveUpdate: true,            
            pensionCalculation: false,
            pensionDataUpdate: false
          };
          documentsUpload=true;
          documentComment=false;
          break;
        case "PENDING_FOR_DETAILS_VERIFICATION":
          actorAcccessLevel=
          {
            employeeOtherDetailsUpdate: false,
            employeeLeaveUpdate: false,
           
            pensionCalculation: false,
            pensionDataUpdate: false
          };
          documentsUpload= false;
          documentComment= true;
          break;
        case "PENDING_FOR_DETAILS_REVIEW":
          actorAcccessLevel=
            {
              employeeOtherDetailsUpdate: false,
              employeeLeaveUpdate: false,             
              pensionCalculation: false,
              pensionDataUpdate: false
            };
            documentsUpload= false;
            documentComment= true;
            break;
        case "PENDING_FOR_CALCULATION":
          actorAcccessLevel=
          {
            employeeOtherDetailsUpdate: false,
            employeeLeaveUpdate: false,           
            pensionCalculation: true,
            pensionDataUpdate: true
          };
          documentsUpload= false;
          documentComment= false;
          break;
        case "PENDING_FOR_CALCULATION_VERIFICATION":
          actorAcccessLevel=
          {
            employeeOtherDetailsUpdate: false,
            employeeLeaveUpdate: false,           
            pensionCalculation: false,
            pensionDataUpdate: false
          };
          documentsUpload= false;
          documentComment= false;
          break; 
        case "PENDING_FOR_CALCULATION_APPROVAL":
          actorAcccessLevel=
          {
            employeeOtherDetailsUpdate: false,
            employeeLeaveUpdate: false,           
            pensionCalculation: false,
            pensionDataUpdate: false
          };
          documentsUpload= false;
          documentComment= false;
          break;   
        case "PENDING_FOR_CALCULATION_REVIEW":
          actorAcccessLevel=
          {
            employeeOtherDetailsUpdate: false,
            employeeLeaveUpdate: false,            
            pensionCalculation: false,
            pensionDataUpdate: false
          };
          documentsUpload= false;
          documentComment= true;
          break;
        case "PENDING_FOR_APPROVAL":
          actorAcccessLevel=
          {
            employeeOtherDetailsUpdate: false,
            employeeLeaveUpdate: false,           
            pensionCalculation: false,
            pensionDataUpdate: false
          };
          documentsUpload= false;
          documentComment= false;
          break;
        case "PENDING_FOR_AUDIT":
          actorAcccessLevel=
          {
            employeeOtherDetailsUpdate: false,
            employeeLeaveUpdate: false,          
            pensionCalculation: false,
            pensionDataUpdate: false
          };
          documentsUpload= false;
          documentComment= false;
          break;
        case "PENDING_FOR_CONTINGENT_BILL_PREPARATION_WITH_ACCOUNTS_OFFICER":
          actorAcccessLevel=
          {
            employeeOtherDetailsUpdate: false,
            employeeLeaveUpdate: false,           
            pensionCalculation: false,
            pensionDataUpdate: false
          };
          documentsUpload= false;
          documentComment= false;
          break;
        case "PENDING_FOR_CONTINGENT_BILL_PREPARATION_WITH_SENIOR_ASSISTANT":
          actorAcccessLevel=
          {
            employeeOtherDetailsUpdate: false,
            employeeLeaveUpdate: false,           
            pensionCalculation: false,
            pensionDataUpdate: false
          };
          documentsUpload= false;
          documentComment= false;
          break;
        case "PENDING_FOR_CONTINGENT_BILL_PREPARATION_WITH_CLERK":
          actorAcccessLevel=
          {
            employeeOtherDetailsUpdate: false,
            employeeLeaveUpdate: false,           
            pensionCalculation: false,
            pensionDataUpdate: false
          };
          documentsUpload= false;
          documentComment= false;
          break;
        default:
          actorAcccessLevel=
          {
            employeeOtherDetailsUpdate: false,
            employeeLeaveUpdate: false,           
            pensionCalculation: false,
            pensionDataUpdate: false
          };
          documentsUpload= false;
          documentComment= false;
          break;
  
      }      
            

      //fetch uploaded documents  
      let textDocument =
        "select pa.uuid, pa.file_store_id, pa.document_type from eg_pension_attachment pa join eg_pension_workflow_header pwh on pa.workflow_header_id =pwh.uuid";

      if (!isEmpty(queryObj)) {
        textDocument = textDocument + " where ";
      }
      /*
      if (queryObj.tenantId) {
        textDocument = `${textDocument} pa.tenantid = '${queryObj.tenantId}'`;
      }
      */
      if (queryObj.businessIds) {
        textDocument = `${textDocument} pwh.application_number = '${queryObj.businessIds}'`;
      }             
      textDocument = `${textDocument} and pa.active=true`;
                  
      let sqlQueryDocument=textDocument;
      let workflowDocuments=[];     

      db.query(sqlQueryDocument, async (err, dbRes) => {
        if (err) {
          logger.error(err.stack);
        } 
        else {
           workflowDocuments=dbRes.rows && !isEmpty(dbRes.rows)
              ? await mergeWorkflowDocumentSearchResults(
                  dbRes.rows,
                  request.query,
                  request.body.RequestInfo
                )
              : [];       
                                  
        }
      });
           
      let text ="select pe.employee_hrms_code, pe.date_of_retirement, pe.date_of_death, pwh.uuid, pwh.pension_employee_id, pwh.application_date from eg_pension_employee pe join eg_pension_workflow_header pwh on pe.uuid=pwh.pension_employee_id";        

      if (!isEmpty(queryObj)) {
        text = text + " where ";
      }
      if (queryObj.tenantId) {
        text = `${text} pwh.tenantid = '${queryObj.tenantId}'`;
      }
      if (queryObj.businessIds) {
        text = `${text} and pwh.application_number = '${queryObj.businessIds}'`;
      }             
            
      let sqlQuery = text;      
      
     
      db.query(sqlQuery, async (err, dbRes) => {
        if (err) {
          logger.error(err.stack);
        } else {          
          
            let pensionEmployeeId= dbRes.rows[0].pension_employee_id;  
            

            let workflowHeader =
            dbRes.rows && !isEmpty(dbRes.rows)
              ? await mergeWorkflowHeader(
                  dbRes.rows,
                  request.query,
                  request.body.RequestInfo
                )
              : {};         
              
              //employeeOtherDetails 
              let txtEmployeeOtherDetails ="select workflow_state, ltc, lpd, pension_arrear, is_da_medical_admissible, fma, medical_relief, miscellaneous, over_payment, income_tax, cess, bank_address, account_number, claimant, wef, total_no_pay_leaves_days, dues, is_employment_active, is_convicted_serious_crime_or_grave_misconduct, is_any_judicial_proceeding_is_continuing, is_any_misconduct_insolvency_inefficiency, is_employee_dies_in_terrorist_attack, is_employee_dies_in_accidental_death, is_commutation_opted, reason_for_retirement, is_eligible_for_pension, is_dues_present, is_dues_amount_decided, is_dues_amount_decided, is_taken_monthly_pension_and_gratuity, is_taken_gratuity_commutation_terminal_benefit, is_taken_compensation_pension_and_gratuity, dies_in_extremists_dacoits_smuggler_antisocial_attack, is_compassionate_pension_granted, total_no_pay_leaves_months, total_no_pay_leaves_years, no_dues_for_avail_govt_accomodation, employee_group, date_of_contingent, bank_code, bank_ifsc from eg_pension_employee_other_details";
              if (!isEmpty(queryObj)) {
                txtEmployeeOtherDetails = txtEmployeeOtherDetails + " where ";
              }                  
              
              if (workflowHeader.workflowHeaderId) {
                txtEmployeeOtherDetails = `${txtEmployeeOtherDetails} workflow_header_id = '${workflowHeader.workflowHeaderId}'`;
              }    
                                             
              let sqlEmployeeOtherDetails=txtEmployeeOtherDetails;
              
              let employeeOtherDetails={};

              db.query(sqlEmployeeOtherDetails, async (err, dbRes) => {
                if (err) {
                  logger.error(err.stack);
                } 
                else {                  
                  employeeOtherDetails =
                  dbRes.rows && !isEmpty(dbRes.rows)
                    ? await mergeEmployeeOtherDetails(
                        dbRes.rows,
                        request.query,
                        request.body.RequestInfo,
                        mdms
                      )
                    : {};                         
                }
              });

              //pensionCalculationDetails 
              let txtPensionCalculation ="select basic_pension_sytem, pension_deductions_system, additional_pension_system, commuted_pension_system, commuted_value_system, family_pension_i_system, family_pension_ii_system, dcrg_system, net_deductions_system, final_calculated_pension_system, basic_pension_verified, pension_deductions_verified, additional_pension_verified, commuted_pension_verified, commuted_value_verified, family_pension_i_verified, family_pension_ii_verified, dcrg_verified, net_deductions_verified, final_calculated_pension_verified, interim_relief_system, da_system, interim_relief_verified, da_verified, nqs_year_system, nqs_month_system, nqs_day_system, nqs_year_verified, nqs_month_verified, nqs_day_verified, dues_deductions_system, compassionate_pension_system, compensation_pension_system, terminal_benefit_system, dues_deductions_verified, compassionate_pension_verified, compensation_pension_verified, terminal_benefit_verified, final_calculated_gratuity_system, final_calculated_gratuity_verified, family_pension_i_start_date_system, family_pension_i_start_date_verified, family_pension_i_end_date_system, family_pension_i_end_date_verified, family_pension_ii_start_date_system, family_pension_ii_start_date_verified, ex_gratia_system, ex_gratia_verified, pensioner_family_pension_system, pensioner_family_pension_verified, total_pension_system, total_pension_verified, provisional_pension_system, provisional_pension_verified, interim_relief_applicable, interim_relief_expression, basic_pension_applicable, basic_pension_expression, provisional_pension_applicable, provisional_pension_expression, compassionate_pension_applicable, compassionate_pension_expression, compensation_pension_applicable, compensation_pension_expression, commuted_pension_applicable, commuted_pension_expression, family_pension_i_applicable, family_pension_i_expression, family_pension_ii_applicable, family_pension_ii_expression, da_applicable, da_expression, additional_pension_applicable, additional_pension_expression, total_pension_applicable, total_pension_expression, pension_deductions_applicable, pension_deductions_expression, net_deductions_applicable, net_deductions_expression, final_calculated_pension_applicable, final_calculated_pension_expression, commutation_value_applicable, commutation_value_expression, dcrg_applicable, dcrg_expression, terminal_benefit_applicable, terminal_benefit_expression, dues_deductions_applicable, dues_deductions_expression, final_calculated_gratuity_applicable, final_calculated_gratuity_expression, ex_gratia_applicable, ex_gratia_expression, pensioner_family_pension_applicable, pensioner_family_pension_expression, invalid_pension_system, wound_extraordinary_pension_system, attendant_allowance_system, invalid_pension_verified, wound_extraordinary_pension_verified, attendant_allowance_verified, invalid_pension_applicable, invalid_pension_expression, wound_extraordinary_pension_applicable, wound_extraordinary_pension_expression, attendant_allowance_applicable, attendant_allowance_expression, gqs_year_system, gqs_month_system, gqs_day_system, gqs_year_verified, gqs_month_verified, gqs_day_verified, notification_text_system, notification_text_verified, interim_relief_lpd_system, pension_arrear_system, pension_arrear_verified from eg_pension_calculation_details";
              if (!isEmpty(queryObj)) {
                txtPensionCalculation = txtPensionCalculation + " where ";
              }               
              if (workflowHeader.workflowHeaderId) {
                txtPensionCalculation = `${txtPensionCalculation} workflow_header_id = '${workflowHeader.workflowHeaderId}'`;
              }             
                                             
              let sqlPensionCalculation=txtPensionCalculation;
              

              let pensionCalculationDetails={};
              let pensionCalculationUpdateDetails={};
              let pensionArrears=[];

              db.query(sqlPensionCalculation, async (err, dbRes) => {
                if (err) {
                  logger.error(err.stack);
                } 
                else {                  
                                 
                  pensionCalculationDetails =
                  dbRes.rows && !isEmpty(dbRes.rows)
                    ? await mergePensionCalculationDetails(
                        dbRes.rows,
                        request.query,
                        request.body.RequestInfo
                      )
                    : {};                      
                  pensionCalculationUpdateDetails =
                  dbRes.rows && !isEmpty(dbRes.rows)
                    ? await mergePensionCalculationUpdateDetails(
                        dbRes.rows,
                        request.query,
                        request.body.RequestInfo
                      )
                    : {};                                     
                  
                }
              });

//Pension Arrear

              let txtPensionArrear =" SELECT effective_year,effective_month ,interim_relief,da ,total_pension ,pension_deductions,wound_extraordinary_pension,attendant_allowance,fma,miscellaneous,over_payment,income_tax,cess,basic_pension ,additional_pension,commuted_pension,net_deductions,net_pension from eg_pension_arrear";
              if (!isEmpty(queryObj)) {
                txtPensionArrear = txtPensionArrear + " where ";
              }               
              if (workflowHeader.workflowHeaderId) {
                txtPensionArrear = `${txtPensionArrear} workflow_header_id = '${workflowHeader.workflowHeaderId}'`;
              }             
                                             
              let sqlPensionArrear=txtPensionArrear;
              
              db.query(sqlPensionArrear, async (err, dbRes) => {
                if (err) {
                  logger.error(err.stack);
                } 
                else {                  
                                 
                  pensionArrears=
                  dbRes.rows && !isEmpty(dbRes.rows)
                    ? await mergePensionArrearDetails(
                        dbRes.rows,
                        request.query,
                        request.body.RequestInfo
                      )
                    : {};                      
                                    
                }
              });



              //dependents
              let dependents=[];
              let txtDependent ="SELECT name, dob, address, mobile_number, relationship, is_disabled, marital_status, is_holly_dependent, no_spouse_no_children, is_grandchild_from_deceased_son, is_eligible_for_gratuity, is_eligible_for_pension, gratuity_percentage, bank_account_number, bank_details, bank_code, bank_ifsc FROM eg_pension_dependent";
              if (!isEmpty(queryObj)) {
                txtDependent = `${txtDependent} WHERE`
              }
              /*
              if (queryObj.tenantId) {
                txtDependent = `${txtDependent} tenantid = '${queryObj.tenantId}'`;
              }
              */
              if (pensionEmployeeId) {
                txtDependent = `${txtDependent} pension_employee_id = '${pensionEmployeeId}'`;
              }             
              txtDependent = `${txtDependent} AND active = true`;              
                    
              let sqlQueryDependent=txtDependent;
                           

              db.query(sqlQueryDependent, async (err, dbRes) => {
                if (err) {
                  logger.error(err.stack);
                } 
                else {
                  dependents=dbRes.rows && !isEmpty(dbRes.rows)
                      ? await mergeDependentResults(
                          dbRes.rows,
                          request.query,
                          request.body.RequestInfo,
                          mdms
                        )
                      : [];                            
                }
              });       

             
              //fetch employee details from pension module   
              
              let employeeResponse = await searchEmployee(request.body.RequestInfo, queryObj.tenantId,dbRes.rows[0].employee_hrms_code);
              
              let employee=employeeResponse.Employees[0];  
                           
              /*
              //leaves
              let textLeave ="select leave_type, leave_from, leave_to, leave_count from tbl_pension_employee_leave";

              if (!isEmpty(queryObj)) {
                textLeave = textLeave + " where ";
              }
              if (queryObj.tenantId) {
                textLeave = `${textLeave} tenantid = '${queryObj.tenantId}'`;
              }
              if (dbRes.rows[0].pension_employee_id) {
                textLeave = `${textLeave} and pension_employee_id = '${dbRes.rows[0].pension_employee_id}'`;
              }             
              textLeave = `${textLeave} and active=true`;              
                    
              let sqlQueryLeave=textLeave;
              
              let leaves=[];

              db.query(sqlQueryLeave, async (err, dbRes) => {
                if (err) {
                  logger.error(err.stack);
                } 
                else {
                  leaves=dbRes.rows && !isEmpty(dbRes.rows)
                      ? await mergeLeaveSearchResults(
                          dbRes.rows,
                          request.query,
                          request.body.RequestInfo
                        )
                      : []; 

                  const leaveTypes=get(mdms,"MdmsRes.pension.EmployeeLeaveType");      
                  for (var i = 0; i < leaves.length; i++) {
                    let leave=filter(leaveTypes,function(x){return x.code===leaves[i].leaveType;});                                    
                    leaves[i].leaveTypeName=leave.length>0?leave[0].name:"";
                  }
                                    
                }
              });         
              */

              //document audit
              
              let textDocumentHistory = "SELECT pau.document_type, pau.state, pau.comment, pau.created_by from eg_pension_attachment_audit pau join eg_pension_attachment pa on pau.pension_attachment_id=pa.uuid";
        
              if (!isEmpty(queryObj)) {
                textDocumentHistory = textDocumentHistory + " WHERE ";
              }                
              if (queryObj.tenantId) {
                textDocumentHistory = `${textDocumentHistory} pa.tenantid = '${queryObj.tenantId}'`;
              }     
              /*           
              if (workflowDocuments[i].pensionAttachmentId) {
                textDocumentHistory = `${textDocumentHistory} AND pa.document_type = '${workflowDocuments[i].documentType}'`;
              } 
              */    
              if (workflowHeader.workflowHeaderId) {
                textDocumentHistory = `${textDocumentHistory} and pa.workflow_header_id = '${workflowHeader.workflowHeaderId}'`;
              }     
              textDocumentHistory = `${textDocumentHistory} and pa.active = true`;                    

            
              let sqlQueryDocumentHistory=textDocumentHistory;
                            
              let documentAudit=[];//uploaded documents history
      
              db.query(sqlQueryDocumentHistory, async (err, dbRes) => {
                if (err) {
                  logger.error(err.stack);
                } 
                else {                    
                  documentAudit=dbRes.rows && !isEmpty(dbRes.rows)
                      ? await mergeWorkflowDocumentAuditSearchResults(
                          dbRes.rows,
                          request.query,
                          request.body.RequestInfo
                        )
                      : [];                                          
                  for (var i = 0; i < workflowDocuments.length; i++) { 
                    let workflowDocumentAudit=filter(documentAudit,function(x){return x.documentType==workflowDocuments[i].documentType;});
                    workflowDocuments[i].documentAudit=workflowDocumentAudit;                          
                  }                                                                                
                }
              });        
              
                    
              let documents=[];
              let documentTypes=[]
              switch(processInstances[0].businessService)
              {
                case envVariables.EGOV_PENSION_RRP_BUSINESS_SERVICE:
                  documentTypes=get(mdms,"MdmsRes.pension.DocumentType_RRP");                  
                  break;
                case envVariables.EGOV_PENSION_DOE_BUSINESS_SERVICE:
                  documentTypes=get(mdms,"MdmsRes.pension.DocumentType_DOE");                  
                  break;
                case envVariables.EGOV_PENSION_DOP_BUSINESS_SERVICE:
                  documentTypes=get(mdms,"MdmsRes.pension.DocumentType_DOP");                  
                  break;
              }   
              documentTypes=filter(documentTypes,function(x){return x.active==true;});

              for (var i = 0; i < documentTypes.length; i++) {                       
                //find the document in uploaded documents
                let workflowDocument=filter(workflowDocuments,function(x){return x.documentType==documentTypes[i].code;});
                let fileStoreResponse;
                let pensionAttachmentId="";
                let fileStoreId="";
                let url="";
                let documentAudit=[];
                
                if(workflowDocument.length>0)
                {       
                  pensionAttachmentId =workflowDocument[0].pensionAttachmentId;                
                  fileStoreId=workflowDocument[0].fileStoreId;
                  fileStoreResponse=await getFileDetails(queryObj.tenantId,workflowDocument[0].fileStoreId);
                  if(!isEmpty(fileStoreResponse) && fileStoreResponse.fileStoreIds.length>0)
                  {
                    url=fileStoreResponse.fileStoreIds[0].url;
                    if(url.indexOf(",")>=0)
                    {
                      url=url.split(",")[0];
                    }
                  }
                  documentAudit=workflowDocument[0].documentAudit;
          
                }

                let document={ 
                  pensionAttachmentId: pensionAttachmentId,
                  fileStoreId: fileStoreId,
                  documentType: documentTypes[i].code,
                  //documentTypeName: documentTypes[i].name,
                  isMandatory: documentTypes[i].isMandatory,
                  isMandatoryForCommutation: documentTypes[i].isMandatoryForCommutation,
                  isMandatoryForNoGovtAccomodation: documentTypes[i].isMandatoryForNoGovtAccomodation,
                  url: url,
                  comment: "",
                  documentsUpload: documentsUpload,
                  documentComment: documentComment,
                  documentAudit: documentAudit

                };
                
                documents.push(document);
              }                  
               
              let employeeDisabilityResponse= await getEmployeeDisability(request.body.RequestInfo,queryObj.tenantId,employee.code);             
              let employeeDisability={
                disabilityPercentage: employeeDisabilityResponse.Employees.length>0? employeeDisabilityResponse.Employees[0].disabilityPercentage:null,
                woundExtraordinaryPension:employeeDisabilityResponse.Employees.length>0? employeeDisabilityResponse.Employees[0].woundExtraordinaryPension:null,
                attendantAllowanceGranted: employeeDisabilityResponse.Employees.length>0? employeeDisabilityResponse.Employees[0].attendantAllowanceGranted:false
              }
              for (var i = 0; i < processInstances.length; i++) { 
                processInstances[i].comment="";
                processInstances[i].documents=  documents; 
                processInstances[i].workflowHeader=  workflowHeader; 
                processInstances[i].employee=  employee;   
                processInstances[i].employeeOtherDetails= employeeOtherDetails;                                                                                           
                //processInstances[i].leaves= leaves;                      
                processInstances[i].pensionCalculationDetails= pensionCalculationDetails;
                processInstances[i].pensionCalculationUpdateDetails= pensionCalculationUpdateDetails;
                processInstances[i].pensionArrears= pensionArrears;                
                processInstances[i].dependents= dependents;
                processInstances[i].actorAcccessLevel= actorAcccessLevel;
                processInstances[i].employeeDisability=employeeDisability; 
              }
              /*
              let applicationDetails={
                businessId: processInstances[0].businessId,
                name: processInstances[0].employee.user.name,
                dob: epochToDmy(intConversion(processInstances[0].employee.user.dob)) ,
                dateOfRetirement: epochToDmy(intConversion(processInstances[0].employee.dateOfRetirement)) ,                
                permanentAddress: processInstances[0].employee.user.permanentAddress,
                permanentCity: processInstances[0].employee.user.permanentCity,
                permanentPinCode: processInstances[0].employee.user.permanentPinCode,
                serviceStatus: processInstances[0].employee.serviceHistory[0].serviceStatus,
                serviceFrom: epochToDmy(intConversion( processInstances[0].employee.serviceHistory[0].serviceFrom)) ,                
                serviceTo: processInstances[0].employee.serviceHistory[0].serviceTo!=null? epochToDmy(intConversion( processInstances[0].employee.serviceHistory[0].serviceTo)):null,
                reasonForRetirement: processInstances[0].employeeOtherDetails.reasonForRetirement,
                isEligibleForPension: processInstances[0].employeeOtherDetails.isEligibleForPension,
                isTakenMonthlyPensionAndGratuity: processInstances[0].employeeOtherDetails.isTakenMonthlyPensionAndGratuity,
                isTakenGratuityCommutationTerminalBenefit: processInstances[0].employeeOtherDetails.isTakenGratuityCommutationTerminalBenefit,
                isTakenCompensationPensionAndGratuity: processInstances[0].employeeOtherDetails.isTakenCompensationPensionAndGratuity,
                totalNoPayLeaves: processInstances[0].employeeOtherDetails.totalNoPayLeaves,
                lpd: processInstances[0].employeeOtherDetails.lpd,
                incomeTax: processInstances[0].employeeOtherDetails.incomeTax,
                overPayment: processInstances[0].employeeOtherDetails.overPayment,
                medicalRelief: processInstances[0].employeeOtherDetails.medicalRelief,
                miscellaneous: processInstances[0].employeeOtherDetails.miscellaneous,
                isDuesPresent: processInstances[0].employeeOtherDetails.isDuesPresent,
                isDuesAmountDecided: processInstances[0].employeeOtherDetails.isDuesAmountDecided,
                dues: processInstances[0].employeeOtherDetails.dues,
                isConvictedSeriousCrimeOrGraveMisconduct: processInstances[0].employeeOtherDetails.isConvictedSeriousCrimeOrGraveMisconduct,
                isAnyJudicialProceedingIsContinuing: processInstances[0].employeeOtherDetails.isAnyJudicialProceedingIsContinuing,
                isAnyMisconductInsolvencyInefficiency: processInstances[0].employeeOtherDetails.isAnyMisconductInsolvencyInefficiency,
                isCompassionatePensionGranted: processInstances[0].employeeOtherDetails.isCompassionatePensionGranted,
                isCommutationOpted: processInstances[0].employeeOtherDetails.isCommutationOpted,
                isCommutationOpted: processInstances[0].employeeOtherDetails.isCommutationOpted,
              }

              let paymentDetails={         
                businessId: processInstances[0].businessId,       
                name: processInstances[0].employee.user.name,  
                dob: epochToDmy(intConversion(processInstances[0].employee.user.dob)) ,
                dateOfRetirement: epochToDmy(intConversion(processInstances[0].employee.dateOfRetirement)) ,                             
                permanentAddress: processInstances[0].employee.user.permanentAddress,
                permanentCity: processInstances[0].employee.user.permanentCity,
                permanentPinCode: processInstances[0].employee.user.permanentPinCode,
                serviceFrom: epochToDmy(intConversion( processInstances[0].employee.serviceHistory[0].serviceFrom)) ,                                
                lpd: processInstances[0].employeeOtherDetails.lpd,                
                nqsYearVerified: processInstances[0].pensionCalculationUpdateDetails.nqsYearVerified,
                nqsMonthVerified: processInstances[0].pensionCalculationUpdateDetails.nqsMonthVerified,
                nqsDayVerified: processInstances[0].pensionCalculationUpdateDetails.nqsDayVerified,
                finalCalculatedPensionVerified: processInstances[0].pensionCalculationUpdateDetails.finalCalculatedPensionVerified,
                dcrgVerified: processInstances[0].pensionCalculationUpdateDetails.dcrgVerified,
                accountNumber: processInstances[0].employeeOtherDetails.accountNumber,
                bankAddress: processInstances[0].employeeOtherDetails.bankAddress
              }
              */


              response.ProcessInstances=processInstances;      
              //response.ApplicationDetails=applicationDetails;  
              //response.PaymentDetails=paymentDetails;
              res.json(response);
              
              
        }
      });     
    })
  );
  return api;
};
