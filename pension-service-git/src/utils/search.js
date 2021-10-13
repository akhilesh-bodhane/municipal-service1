import get from "lodash/get";
import findIndex from "lodash/findIndex";
import isEmpty from "lodash/isEmpty";
import { httpRequest } from "./api";
import envVariables from "../envVariables";
import userService from "../services/userService";
import omitBy from "lodash/omitBy";
import isNil from "lodash/isNil";
import { convertDateToEpoch,convertDateToEpochForMigration} from "../utils";
import {encrypt,decrypt} from "../utils/encryption";
import filter from "lodash/filter";

import logger from "../config/logger";

let requestInfo = {};

export const intConversion = string => {
  return string ? parseInt(string) : null;
};

export const floatConversion = string => {
  return string ? parseFloat(string) : null;
};

export const booleanConversion = string => {
  return string ? ((string==="true")?true:false): null;
};

const employeeRowMapper = async (row, mapper = {}) => {
  let employee = isEmpty(mapper) ? {} : mapper;
  employee.pensionNotificationRegisterId = row.pension_notification_register_id;
  employee.pensionEmployeeId = row.pension_employee_id;
  employee.id = row.employee_hrms_id;
  employee.code = row.employee_hrms_code;
  employee.name = row.name;
  employee.dob = Number(row.date_of_birth);
  //employee.designation = row.designation;
  employee.dateOfRetirement = Number(row.date_of_retirement);
  employee.tenantId = row.tenantid;
  employee.gender = row.gender;
  employee.employeeStatus = row.employee_status;
  employee.employeeType = row.employee_type;
  employee.dateOfAppointment = row.date_of_appointment?Number(row.date_of_appointment):null;
  employee.action = "INITIATE";  
  return employee;
};

const assignmentRowMapper = async (row, mapper = {}) => {
  let assignment = isEmpty(mapper) ? {} : mapper;
  assignment.position =Number(row.position) ;
  assignment.designation = row.designation;
  assignment.department = row.department;
  assignment.fromDate = Number(row.from_date);
  assignment.toDate =row.to_date?Number(row.to_date):null;
  assignment.govtOrderNumber = row.govt_order_no;
  assignment.tenantId = row.tenantid;
  assignment.reportingTo = row.reporting_to;
  assignment.isHOD = row.is_hod;
  assignment.isCurrentAssignment = row.is_current_assignment;
  assignment.isPrimaryAssignment = row.is_primary_assignment;
 
  return assignment;
};

const serviceHistoryRowMapper = async (row, mapper = {}) => {
  let serviceHistory = isEmpty(mapper) ? {} : mapper;
  serviceHistory.serviceStatus =row.service_status ;
  serviceHistory.serviceFrom =Number(row.service_from);
  serviceHistory.serviceTo =row.service_to? Number(row.service_to):null;
  serviceHistory.orderNo =row.order_no ;
  serviceHistory.location =row.location ;  
  serviceHistory.tenantId = row.tenantid;  
  serviceHistory.isCurrentPosition = row.is_current_position;
 
  return serviceHistory;
};

const pensionEmployeeRowMapper = async (row, mapper = {}) => {
  let employee = isEmpty(mapper) ? {} : mapper;
  employee.uuid =row.uuid ;
  employee.tenantId = row.tenantid; 
  employee.hrmsId =Number(row.employee_hrms_id)  ; 
  employee.code =row.employee_hrms_code ;    
  employee.name =row.name ;    
  employee.dob =intConversion(row.date_of_birth) ;    
  employee.dateOfRetirement =intConversion(row.date_of_retirement)  ;   
  employee.hrmsUuid =row.employee_hrms_uuid ; 
  employee.salutation =row.salutation ; 
  employee.gender =row.gender ; 
  employee.employeeStatus =row.employee_status ; 
  employee.employeeType =row.employee_type ; 
  employee.department=row.department;
  employee.designation=row.designation;
  
  return employee;
};

const employeeDisabilityRowMapper = async (row, mapper = {}) => {
  let employee = isEmpty(mapper) ? {} : mapper;
  employee.tenantId = row.tenantid; 
  employee.severityOfDisability =row.severity_of_disability ;  
  employee.disabilityPercentage =row.disability_percentage!=null?Number(row.disability_percentage):null ; 
  employee.dateOfInjury = row.date_of_injury!=null? Number(row.date_of_injury):null;    
  employee.injuryApplicationDate = row.injury_application_date!=null? Number(row.injury_application_date):null;   
  employee.woundExtraordinaryPension = row.wound_extraordinary_pension!=null? Number(row.wound_extraordinary_pension):null;   
  employee.attendantAllowanceGranted =row.attendant_allowance_granted!=null?row.attendant_allowance_granted:false ;   
  employee.comments =row.comments ;   
  return employee;
};

const workflowDocumentRowMapper = async (row, mapper = {}) => {
  let document = isEmpty(mapper) ? {} : mapper;
  document.pensionAttachmentId = row.uuid; 
  document.fileStoreId = row.file_store_id;   
  document.documentType = row.document_type;  
  return document;
};

const searchPensionerRowMapper = async (row, mdms, mapper = {}) => {

  const mdmsBankDetails=get(mdms,"MdmsRes.pension.BankDetails"); 
  let pensioner = isEmpty(mapper) ? {} : mapper;
  pensioner.pensionerId = row.uuid;
  pensioner.tenantId = row.tenantid;
  pensioner.name = row.name;    
  pensioner.code = row.employee_hrms_code;   
  pensioner.pensionerNumber = row.pensioner_number;    
  pensioner.businessService = row.business_service; 
  pensioner.dob = Number(row.date_of_birth) ; 
  pensioner.gender = row.gender; 
  pensioner.dateOfRetirement = Number(row.date_of_retirement);   
  pensioner.dateOfDeath =row.date_of_death!=null? Number(row.date_of_death):null; 
  pensioner.dateOfAppointment =row.date_of_appointment!=null? Number(row.date_of_appointment):null; 
  pensioner.lpd =row.lpd!=null? Number(row.lpd):null; 
  pensioner.ltc =row.ltc!=null? Number(row.ltc):null; 
  pensioner.wef =row.wef!=null? Number(row.wef):null; 
  pensioner.claimantName = row.claimant_name; 
  pensioner.claimantDob = row.claimant_dob; 
  pensioner.address = row.address; 

  let bankDetailsList=filter(mdmsBankDetails,function(x){return x.code==row.bank_details && row.bank_details!=null && row.bank_details!="";});
  if(bankDetailsList.length>0){
    pensioner.bankDetails = bankDetailsList[0].name;  
  }

  //pensioner.bankDetails = row.bank_details; 

  pensioner.bankAccountNumber =row.bank_account_number!=null? decrypt(row.bank_account_number):row.bank_account_number;
  pensioner.bankCode = row.bank_code;
  pensioner.bankIfsc = row.bank_ifsc;
  pensioner.designation = row.designation;
  pensioner.department = row.department;
  return pensioner;
};

const searchPensionerPensionRevisionRowMapper = async (row, mapper = {}) => {
  let revision = isEmpty(mapper) ? {} : mapper;      
  revision.pensionRevisionId = row.uuid;        
  revision.effectiveStartYear = intConversion(row.effective_start_year);
  revision.effectiveStartMonth = intConversion(row.effective_start_month); 
  revision.effectiveEndYear = intConversion(row.effective_end_year);   
  revision.effectiveEndMonth = intConversion(row.effective_end_month);  
  revision.pensionArrear = row.pension_arrear!=null? Number(row.pension_arrear):0;   
  //revision.medicalRelief = row.medical_relief!=null? Number(row.medical_relief):0;   
  revision.fma = row.fma!=null? Number(row.fma):0;
  revision.miscellaneous = row.miscellaneous!=null? Number(row.miscellaneous):0;   
  revision.overPayment = row.over_payment!=null? Number(row.over_payment):0;  
  revision.incomeTax = row.income_tax!=null? Number(row.income_tax):0;
  revision.cess = row.cess!=null? Number(row.cess):0;
  revision.basicPension = row.basic_pension!=null? Number(row.basic_pension):0;  
  revision.da = row.da!=null? Number(row.da):0; 
  revision.commutedPension =row.commuted_pension!=null ?Number(row.commuted_pension):0; 
  revision.netDeductions =row.net_deductions!=null ?Number(row.net_deductions):0; 
  revision.finalCalculatedPension =row.final_calculated_pension!=null ?Number(row.final_calculated_pension):0; 
  revision.additionalPension =row.additional_pension? Number(row.additional_pension):0;  
  revision.interimRelief =row.interim_relief? Number(row.interim_relief):0;   
  revision.totalPension =row.total_pension? Number(row.total_pension):0;      
  revision.pensionDeductions =row.pension_deductions? Number(row.pension_deductions):0;    
  revision.woundExtraordinaryPension =row.wound_extraordinary_pension? Number(row.wound_extraordinary_pension):0; 
  revision.attendantAllowance =row.attendant_allowance? Number(row.attendant_allowance):0; 
  revision.remarks=row.remarks;
  //revision.isEditEnabled =new Date(intConversion(row.effective_start_year),intConversion(row.effective_start_month),1)>new Date()?true:false;
  revision.isEditEnabled =Number(row.effective_start_year) <new Date().getFullYear() || (Number(row.effective_start_year)==new Date().getFullYear() && Number(row.effective_start_month)<new Date().getMonth()+1)?false:true;
  return revision;
};

const searchPensionRegisterRowMapper = async (row, mapper = {}) => {
  let register = isEmpty(mapper) ? {} : mapper;          
  register.tenantId= row.tenantid;   
  register.effectiveYear = intConversion(row.effective_year);
  register.effectiveMonth = intConversion(row.effective_month);    
  register.pensionArrear = row.pension_arrear!=null? Number(row.pension_arrear):0;
  register.fma = row.fma!=null? Number(row.fma):0;
  register.miscellaneous = row.miscellaneous!=null? Number(row.miscellaneous):0;   
  register.overPayment = row.over_payment!=null? Number(row.over_payment):0;  
  register.incomeTax = row.income_tax!=null? Number(row.income_tax):0;
  register.cess = row.cess!=null? Number(row.cess):0;
  register.basicPension = row.basic_pension!=null? Number(row.basic_pension):0;  
  register.additionalPension =row.additional_pension? Number(row.additional_pension):0;  
  register.commutedPension =row.commuted_pension!=null ?Number(row.commuted_pension):0; 
  register.netDeductions =row.net_deductions!=null ?Number(row.net_deductions):0; 
  register.finalCalculatedPension =row.final_calculated_pension!=null ?Number(row.final_calculated_pension):0;   
  register.interimRelief =row.interim_relief? Number(row.interim_relief):0;         
  register.da = row.da!=null? Number(row.da):0;     
  register.totalPension =row.total_pension!=null? Number(row.total_pension):0;    
  register.pensionDeductions =row.pension_deductions? Number(row.pension_deductions):0;  
  register.woundExtraordinaryPension =row.wound_extraordinary_pension!=null? Number(row.wound_extraordinary_pension):0; 
  register.attendantAllowance =row.attendant_allowance!=null? Number(row.attendant_allowance):0; 
  
  return register;
};

const pensionRevisionRowMapper = async (row, mapper = {}) => {
  let revision = isEmpty(mapper) ? {} : mapper; 
  revision.tenantId = row.tenantid;                     
  revision.pensionRevisionId = row.uuid;       
  revision.pensionerId = row.pensioner_id; 
  revision.dateOfBirth = row.date_of_birth;
  revision.dateOfRetirement = row.date_of_retirement;  
  revision.effectiveStartYear = intConversion(row.effective_start_year);
  revision.effectiveStartMonth = intConversion(row.effective_start_month); 
  revision.effectiveEndYear = intConversion(row.effective_end_year);   
  revision.effectiveEndMonth = intConversion(row.effective_end_month);
  revision.pensionArrear = row.pension_arrear!=null? Number(row.pension_arrear):0;
  revision.fma = row.fma!=null? Number(row.fma):0;
  revision.miscellaneous = row.miscellaneous!=null? Number(row.miscellaneous):0;
  revision.overPayment = row.over_payment!=null? Number(row.over_payment):0;
  revision.incomeTax = row.income_tax!=null? Number(row.income_tax):0;
  revision.cess = row.cess!=null? Number(row.cess):0;
  revision.basicPension = row.basic_pension!=null? Number(row.basic_pension):0;
  revision.commutedPension = row.commuted_pension!=null? Number(row.commuted_pension):0;
  revision.additionalPension = row.additional_pension!=null? Number(row.additional_pension):0;
  revision.netDeductions = row.net_deductions!=null? Number(row.net_deductions):0;
  revision.finalCalculatedPension = row.final_calculated_pension!=null? Number(row.final_calculated_pension):0;
  revision.interimRelief = row.interim_relief!=null? Number(row.interim_relief):0;
  revision.da = row.da!=null? Number(row.da):0;
  revision.totalPension = row.total_pension!=null? Number(row.total_pension):0;
  revision.pensionDeductions = row.pension_deductions!=null? Number(row.pension_deductions):0;
  revision.pensionerFinalCalculatedBenefitId = row.pensioner_final_calculated_benefit_id;
  revision.woundExtraOrdinaryPension = row.wound_extraordinary_pension!=null? Number(row.wound_extraordinary_pension):0;
  revision.attendantAllowance = row.attendant_allowance!=null? Number(row.attendant_allowance):0;

  return revision;
};

const leaveRowMapper = async (row, mapper = {}) => {
  let leave = isEmpty(mapper) ? {} : mapper;
  leave.leaveType = row.leave_type;     
  leave.leaveFrom =Number(row.leave_from) ;
  leave.leaveTo = Number(row.leave_to);
  leave.leaveCount = row.leave_count;
  return leave;
};

const dependentRowMapper = async (row, mdms, mapper = {}) => {

  const mdmsBankDetails=get(mdms,"MdmsRes.pension.BankDetails"); 

  let dependent = isEmpty(mapper) ? {} : mapper;
  dependent.name = row.name;     
  dependent.dob =Number(row.dob) ;
  dependent.address = row.address;
  dependent.mobileNumber = row.mobile_number;
  dependent.relationship = row.relationship;
  dependent.isDisabled = row.is_disabled;
  dependent.maritalStatus = row.marital_status;
  dependent.isHollyDependent = row.is_holly_dependent;
  dependent.noSpouseNoChildren = row.no_spouse_no_children;
  dependent.isGrandChildFromDeceasedSon = row.is_grandchild_from_deceased_son;
  dependent.isEligibleForGratuity = row.is_eligible_for_gratuity;
  dependent.isEligibleForPension = row.is_eligible_for_pension;
  dependent.gratuityPercentage =Number(row.gratuity_percentage) ;
  dependent.bankAccountNumber = row.bank_account_number!=null?decrypt(row.bank_account_number):row.bank_account_number;

  let bankDetailsList=filter(mdmsBankDetails,function(x){return x.code==row.bank_details && row.bank_details!=null && row.bank_details!="";});
  if(bankDetailsList.length>0){
    dependent.bankName = bankDetailsList[0].name;  
  }
  dependent.bankDetails = row.bank_details;
  dependent.bankCode = row.bank_code;
  dependent.bankIfsc = row.bank_ifsc;
  return dependent;
};

const workflowDocumentAuditRowMapper = async (row, mapper = {}) => {    
  let documentAudit = isEmpty(mapper) ? {} : mapper;  
  documentAudit.documentType = row.document_type;     
  documentAudit.state = row.state;     
  documentAudit.comment = row.comment;
  documentAudit.createdBy = row.created_by;
  return documentAudit;
};

const workflowHeaderRowMapper = async (row, mapper = {}) => {
  let workflowHeader = isEmpty(mapper) ? {} : mapper;
  workflowHeader.workflowHeaderId = row.uuid;  
  workflowHeader.applicationDate =intConversion(row.application_date);  
  //workflowHeader.dateOfContingent =row.date_of_contingent;
  return workflowHeader;
};

const isEmployeeExistInPensionModuleRowMapper = async (row, mapper = {}) => {
  let isEmployeeExistInPensionModule = isEmpty(mapper) ? {} : mapper;
  isEmployeeExistInPensionModule.pensionEmployeeId = row.uuid;  
  isEmployeeExistInPensionModule.code = row.employee_hrms_code;  
  return isEmployeeExistInPensionModule;
};

const searchEmployeeRowMapper = async (row, mapper = {}) => {
  let employee = isEmpty(mapper) ? {} : mapper;
  employee.pensionEmployeeId = row.uuid; 
  employee.uuid = row.employee_hrms_uuid;     
  employee.tenantId = row.tenantid;  
  employee.id = intConversion(row.employee_hrms_id),
  employee.code = row.employee_hrms_code;  
  employee.employeeStatus = row.employee_status;  
  employee.employeeType = row.employee_type;  
  employee.dateOfAppointment = intConversion(row.date_of_appointment);
  employee.dateOfRetirement = intConversion(row.date_of_retirement);
  employee.dateOfDeath =row.date_of_death? intConversion(row.date_of_death):null;  
  employee.assignments=[],
  employee.serviceHistory=[],
  employee.user={
    id: intConversion(row.employee_hrms_id),
    uuid: row.employee_hrms_uuid,
    salutation: row.salutation,
    name: row.name,
    gender: row.gender,   
    dob: intConversion(row.date_of_birth),    
    tenantId: row.tenantid,
    mobileNumber:row.mobile_number? row.mobile_number:null,
    emailId: row.email_id? row.email_id:null,
    altContactNumber: row.alt_contact_number?row.alt_contact_number:null,
    pan: row.pan?row.pan:null,
    aadhaarNumber: row.aadhaar_number?row.aadhaar_number:null,
    permanentAddress: row.permanent_address? row.permanent_address:null,
    permanentCity: row.permanent_city?row.permanent_city:null,
    permanentPinCode: row.permanent_pin_code?row.permanent_pin_code:null,
    correspondenceAddress: row.correspondence_address?row.correspondence_address:null,
    correspondenceCity: row.correspondence_city?row.correspondence_city:null,
    correspondencePinCode: row.correspondence_pin_code?row.correspondence_pin_code:null,
    fatherOrHusbandName: row.father_or_husband_name?row.father_or_husband_name:null,
    bloodGroup: row.blood_group?row.blood_group:null,
    identificationMark: row.identification_mark?row.identification_mark:null
  }
  
  return employee;
};

const employeeOtherDetailsRowMapper = async (row, mdms, mapper = {}) => {

  const mdmsBankDetails=get(mdms,"MdmsRes.pension.BankDetails"); 

  let employeeOtherDetails = isEmpty(mapper) ? {} : mapper;  
  employeeOtherDetails.state = row.workflow_state;  
  employeeOtherDetails.ltc =Number(row.ltc) ;  
  employeeOtherDetails.lpd = Number(row.lpd);    
  employeeOtherDetails.pensionArrear = Number(row.pension_arrear);    
  employeeOtherDetails.isDaMedicalAdmissible = row.is_da_medical_admissible;  
  employeeOtherDetails.fma = Number(row.fma);  
  employeeOtherDetails.medicalRelief = Number(row.medical_relief);  
  employeeOtherDetails.miscellaneous = Number(row.miscellaneous);  
  employeeOtherDetails.overPayment = Number(row.over_payment);  
  employeeOtherDetails.incomeTax = Number(row.income_tax);  
  employeeOtherDetails.cess = Number(row.cess);  
  employeeOtherDetails.bankAddress = row.bank_address;
  let bankDetailsList=filter(mdmsBankDetails,function(x){return x.code==row.bank_address && row.bank_address!=null && row.bank_address!="";});
  if(bankDetailsList.length>0){
    employeeOtherDetails.bankName = bankDetailsList[0].name;  
  }
  employeeOtherDetails.accountNumber = row.account_number!=null ? decrypt(row.account_number):row.account_number;  
  employeeOtherDetails.bankCode = row.bank_code;  
  employeeOtherDetails.bankIfsc = row.bank_ifsc;  
  employeeOtherDetails.claimant = row.claimant;  
  employeeOtherDetails.wef =row.wef && row.wef!=0? Number(row.wef):null;  
  employeeOtherDetails.dateOfContingent =row.date_of_contingent? Number(row.date_of_contingent):null;  
  employeeOtherDetails.totalNoPayLeavesDays = Number(row.total_no_pay_leaves_days); 
  employeeOtherDetails.dues = Number(row.dues);
  employeeOtherDetails.isEmploymentActive = row.is_employment_active;
  employeeOtherDetails.isConvictedSeriousCrimeOrGraveMisconduct = row.is_convicted_serious_crime_or_grave_misconduct;
  employeeOtherDetails.isAnyJudicialProceedingIsContinuing = row.is_any_judicial_proceeding_is_continuing;
  employeeOtherDetails.isAnyMisconductInsolvencyInefficiency = row.is_any_misconduct_insolvency_inefficiency;
  employeeOtherDetails.isEmployeeDiesInTerroristAttack = row.is_employee_dies_in_terrorist_attack;
  employeeOtherDetails.isEmployeeDiesInAccidentalDeath = row.is_employee_dies_in_accidental_death;
  employeeOtherDetails.isCommutationOpted = row.is_commutation_opted;
  employeeOtherDetails.reasonForRetirement = row.reason_for_retirement;  
  employeeOtherDetails.isEligibleForPension = row.is_eligible_for_pension;
  employeeOtherDetails.isDuesPresent = row.is_dues_present;
  employeeOtherDetails.isDuesAmountDecided = row.is_dues_amount_decided;
  employeeOtherDetails.isTakenMonthlyPensionAndGratuity = row.is_taken_monthly_pension_and_gratuity;
  employeeOtherDetails.isTakenGratuityCommutationTerminalBenefit = row.is_taken_gratuity_commutation_terminal_benefit;
  employeeOtherDetails.isTakenCompensationPensionAndGratuity = row.is_taken_compensation_pension_and_gratuity;
  employeeOtherDetails.diesInExtremistsDacoitsSmugglerAntisocialAttack = row.dies_in_extremists_dacoits_smuggler_antisocial_attack;
  employeeOtherDetails.isCompassionatePensionGranted = row.is_compassionate_pension_granted;
  employeeOtherDetails.totalNoPayLeavesMonths = Number(row.total_no_pay_leaves_months); 
  employeeOtherDetails.totalNoPayLeavesYears = Number(row.total_no_pay_leaves_years); 
  employeeOtherDetails.noDuesForAvailGovtAccomodation = row.no_dues_for_avail_govt_accomodation;
  employeeOtherDetails.employeeGroup = row.employee_group;
  return employeeOtherDetails;
};

const pensionCalculationDetailsRowMapper = async (row, mapper = {}) => {  
  let pensionCalculationDetails = isEmpty(mapper) ? {} : mapper;    
  pensionCalculationDetails.basicPensionSystem =row.basic_pension_sytem!=null? Number(row.basic_pension_sytem):null;  
  pensionCalculationDetails.pensionDeductionsSystem =row.pension_deductions_system!=null? Number(row.pension_deductions_system):null;  
  pensionCalculationDetails.additionalPensionSystem = row.additional_pension_system!=null? Number(row.additional_pension_system):null;  
  pensionCalculationDetails.commutedPensionSystem = row.commuted_pension_system!=null? Number(row.commuted_pension_system):null;  
  pensionCalculationDetails.commutedValueSystem = row.commuted_value_system!=null? Number(row.commuted_value_system):null;  
  pensionCalculationDetails.familyPensionISystem =row.family_pension_i_system!=null? Number(row.family_pension_i_system):null; 
  pensionCalculationDetails.familyPensionIISystem =row.family_pension_ii_system!=null? Number(row.family_pension_ii_system):null; 
  pensionCalculationDetails.dcrgSystem =row.dcrg_system!=null? Number(row.dcrg_system):null; 
  pensionCalculationDetails.netDeductionsSystem =row.net_deductions_system!=null? Number(row.net_deductions_system):null; 
  pensionCalculationDetails.finalCalculatedPensionSystem =row.final_calculated_pension_system!=null? Number(row.final_calculated_pension_system):null; 
  pensionCalculationDetails.interimReliefSystem =row.interim_relief_system!=null? Number(row.interim_relief_system):null; 
  pensionCalculationDetails.daSystem =row.da_system!=null? Number(row.da_system):null; 
  pensionCalculationDetails.nqsYearSystem =row.nqs_year_system!=null? Number(row.nqs_year_system):null; 
  pensionCalculationDetails.nqsMonthSystem =row.nqs_month_system!=null? Number(row.nqs_month_system):null; 
  pensionCalculationDetails.nqsDaySystem =row.nqs_day_system!=null? Number(row.nqs_day_system):null; 
  pensionCalculationDetails.duesDeductionsSystem =row.dues_deductions_system!=null? Number(row.dues_deductions_system):null; 
  pensionCalculationDetails.compassionatePensionSystem =row.compassionate_pension_system!=null? Number(row.compassionate_pension_system):null; 
  pensionCalculationDetails.compensationPensionSystem =row.compensation_pension_system!=null? Number(row.compensation_pension_system):null; 
  pensionCalculationDetails.terminalBenefitSystem = row.terminal_benefit_system!=null? Number(row.terminal_benefit_system):null; 
  pensionCalculationDetails.finalCalculatedGratuitySystem =row.final_calculated_gratuity_system!=null? Number(row.final_calculated_gratuity_system):null;   
  pensionCalculationDetails.familyPensionIStartDateSystem = intConversion(row.family_pension_i_start_date_system);   
  pensionCalculationDetails.familyPensionIEndDateSystem = intConversion(row.family_pension_i_end_date_system);   
  pensionCalculationDetails.familyPensionIIStartDateSystem = intConversion(row.family_pension_ii_start_date_system);   
  pensionCalculationDetails.exGratiaSystem = row.ex_gratia_system!=null? Number(row.ex_gratia_system):null;  
  pensionCalculationDetails.pensionerFamilyPensionSystem = row.pensioner_family_pension_system!=null? Number(row.pensioner_family_pension_system):null;    
  pensionCalculationDetails.totalPensionSystem =row.total_pension_system!=null? Number(row.total_pension_system):null;
  pensionCalculationDetails.provisionalPensionSystem =row.provisional_pension_system!=null? Number(row.provisional_pension_system):null;

  pensionCalculationDetails.interimReliefApplicable = row.interim_relief_applicable;
  pensionCalculationDetails.interimReliefExpression = row.interim_relief_expression;
  pensionCalculationDetails.basicPensionApplicable = row.basic_pension_applicable;
  pensionCalculationDetails.basicPensionExpression = row.basic_pension_expression;
  pensionCalculationDetails.provisionalPensionApplicable = row.provisional_pension_applicable;
  pensionCalculationDetails.provisionalPensionExpression = row.provisional_pension_expression;
  pensionCalculationDetails.compassionatePensionApplicable = row.compassionate_pension_applicable;
  pensionCalculationDetails.compassionatePensionExpression = row.compassionate_pension_expression;
  pensionCalculationDetails.compensationPensionApplicable = row.compensation_pension_applicable;
  pensionCalculationDetails.compensationPensionExpression = row.compensation_pension_expression;
  pensionCalculationDetails.commutedPensionApplicable = row.commuted_pension_applicable;
  pensionCalculationDetails.commutedPensionExpression = row.commuted_pension_expression;
  pensionCalculationDetails.familyPensionIApplicable = row.family_pension_i_applicable;
  pensionCalculationDetails.familyPensionIExpression = row.family_pension_i_expression;
  pensionCalculationDetails.familyPensionIIApplicable = row.family_pension_ii_applicable;
  pensionCalculationDetails.familyPensionIIExpression = row.family_pension_ii_expression;
  pensionCalculationDetails.daApplicable = row.da_applicable;
  pensionCalculationDetails.daExpression = row.da_expression;
  pensionCalculationDetails.additionalPensionApplicable = row.additional_pension_applicable;
  pensionCalculationDetails.additionalPensionExpression = row.additional_pension_expression;  
  pensionCalculationDetails.totalPensionApplicable = row.total_pension_applicable;
  pensionCalculationDetails.totalPensionExpression = row.total_pension_expression;
  pensionCalculationDetails.pensionDeductionsApplicable = row.pension_deductions_applicable;
  pensionCalculationDetails.pensionDeductionsExpression = row.pension_deductions_expression;
  pensionCalculationDetails.netDeductionsApplicable = row.net_deductions_applicable;
  pensionCalculationDetails.netDeductionsExpression = row.net_deductions_expression;
  pensionCalculationDetails.finalCalculatedPensionApplicable = row.final_calculated_pension_applicable;
  pensionCalculationDetails.finalCalculatedPensionExpression = row.final_calculated_pension_expression;
  pensionCalculationDetails.commutationValueApplicable = row.commutation_value_applicable;
  pensionCalculationDetails.commutationValueExpression = row.commutation_value_expression;
  pensionCalculationDetails.dcrgApplicable = row.dcrg_applicable;
  pensionCalculationDetails.dcrgExpression = row.dcrg_expression;
  pensionCalculationDetails.terminalBenefitApplicable = row.terminal_benefit_applicable;
  pensionCalculationDetails.terminalBenefitExpression = row.terminal_benefit_expression;
  pensionCalculationDetails.duesDeductionsApplicable = row.dues_deductions_applicable;
  pensionCalculationDetails.duesDeductionsExpression = row.dues_deductions_expression;
  pensionCalculationDetails.finalCalculatedGratuityApplicable = row.final_calculated_gratuity_applicable;
  pensionCalculationDetails.finalCalculatedGratuityExpression = row.final_calculated_gratuity_expression;
  pensionCalculationDetails.exGratiaApplicable = row.ex_gratia_applicable;
  pensionCalculationDetails.exGratiaExpression = row.ex_gratia_expression;
  pensionCalculationDetails.pensionerFamilyPensionApplicable = row.pensioner_family_pension_applicable;
  pensionCalculationDetails.pensionerFamilyPensionExpression = row.pensioner_family_pension_expression;

  pensionCalculationDetails.invalidPensionSystem =row.invalid_pension_system!=null? Number(row.invalid_pension_system):null;
  pensionCalculationDetails.woundExtraordinaryPensionSystem =row.wound_extraordinary_pension_system!=null? Number(row.wound_extraordinary_pension_system):null;
  pensionCalculationDetails.attendantAllowanceSystem =row.attendant_allowance_system!=null? Number(row.attendant_allowance_system):null;

  pensionCalculationDetails.invalidPensionApplicable = row.invalid_pension_applicable;
  pensionCalculationDetails.invalidPensionExpression = row.invalid_pension_expression;

  pensionCalculationDetails.woundExtraordinaryPensionApplicable = row.wound_extraordinary_pension_applicable;
  pensionCalculationDetails.woundExtraordinaryPensionExpression = row.wound_extraordinary_pension_expression;

  pensionCalculationDetails.attendantAllowanceApplicable = row.attendant_allowance_applicable;
  pensionCalculationDetails.attendantAllowanceExpression = row.attendant_allowance_expression;

  pensionCalculationDetails.gqsYearSystem =Number(row.gqs_year_system);
  pensionCalculationDetails.gqsMonthSystem =Number(row.gqs_month_system);
  pensionCalculationDetails.gqsDaySystem =Number(row.gqs_day_system);

  pensionCalculationDetails.notificationTextSystem =row.notification_text_system;
  pensionCalculationDetails.interimReliefLpdSystem =row.interim_relief_lpd_system!=null? Number(row.interim_relief_lpd_system):null;

  pensionCalculationDetails.pensionArrearSystem = row.pension_arrear_system!=null? Number(row.pension_arrear_system):null;  
  
  return pensionCalculationDetails;
};

const pensionArrearRowMapper = async (row, mapper = {}) => {  

    let pensionArrear = isEmpty(mapper) ? {} : mapper;    
  pensionArrear.effectiveYear =row.effective_year!=null? Number(row.effective_year):null;  
  pensionArrear.effectiveMonth =row.effective_month!=null? Number(row.effective_month):null;  

  pensionArrear.interimRelief =row.interim_relief!=null? Number(row.interim_relief):null; 
  pensionArrear.da =row.da!=null? Number(row.da):null; 
  pensionArrear.totalPension =row.total_pension!=null? Number(row.total_pension):null;

  pensionArrear.pensionDeductions =row.pension_deductions!=null? Number(row.pension_deductions):null;  
  pensionArrear.woundExtraordinaryPension =row.wound_extraordinary_pension!=null? Number(row.wound_extraordinary_pension):null;
  pensionArrear.attendantAllowance =row.attendant_allowance!=null? Number(row.attendant_allowance):null;

  pensionArrear.fma =row.fma!=null? Number(row.fma):null;
  pensionArrear.miscellaneous =row.miscellaneous!=null? Number(row.miscellaneous):null;
  pensionArrear.overPayment =row.over_payment!=null? Number(row.over_payment):null;
  pensionArrear.incomeTax =row.income_tax!=null? Number(row.income_tax):null;
  pensionArrear.cess =row.cess!=null? Number(row.cess):null;

  pensionArrear.basicPension =row.basic_pension!=null? Number(row.basic_pension):null;  
  pensionArrear.additionalPension = row.additional_pension!=null? Number(row.additional_pension):null;  
  pensionArrear.commutedPension = row.commuted_pension!=null? Number(row.commuted_pension):null;  
  pensionArrear.netDeductions =row.net_deductions!=null? Number(row.net_deductions):null; 
  pensionArrear.netPension =row.net_pension!=null? Number(row.net_pension):null; 
      
  return pensionArrear;
};

const pensionCalculationUpdateDetailsRowMapper = async (row, mapper = {}) => {
  let pensionCalculationUpdateDetails = isEmpty(mapper) ? {} : mapper;  
  pensionCalculationUpdateDetails.basicPensionVerified =row.basic_pension_verified!=null? Number(row.basic_pension_verified):null;  
  pensionCalculationUpdateDetails.pensionDeductionsVerified =row.pension_deductions_verified!=null? Number(row.pension_deductions_verified):null;  
  pensionCalculationUpdateDetails.additionalPensionVerified =row.additional_pension_verified!=null? Number(row.additional_pension_verified):null;  
  pensionCalculationUpdateDetails.commutedPensionVerified = row.commuted_pension_verified!=null? Number(row.commuted_pension_verified):null;
  pensionCalculationUpdateDetails.commutedValueVerified = row.commuted_value_verified!=null? Number(row.commuted_value_verified):null;  
  pensionCalculationUpdateDetails.familyPensionIVerified = row.family_pension_i_verified!=null? Number(row.family_pension_i_verified):null;
  pensionCalculationUpdateDetails.familyPensionIIVerified = row.family_pension_ii_verified!=null? Number(row.family_pension_ii_verified):null; 
  pensionCalculationUpdateDetails.dcrgVerified = row.dcrg_verified!=null? Number(row.dcrg_verified):null; 
  pensionCalculationUpdateDetails.netDeductionsVerified = row.net_deductions_verified!=null? Number(row.net_deductions_verified):null; 
  pensionCalculationUpdateDetails.finalCalculatedPensionVerified = row.final_calculated_pension_verified!=null? Number(row.final_calculated_pension_verified):null; 
  pensionCalculationUpdateDetails.interimReliefVerified = row.interim_relief_verified!=null? Number(row.interim_relief_verified):null; 
  pensionCalculationUpdateDetails.daVerified = row.da_verified!=null? Number(row.da_verified):null; 
  pensionCalculationUpdateDetails.nqsYearVerified =row.nqs_year_verified!=null? Number(row.nqs_year_verified):null;
  pensionCalculationUpdateDetails.nqsMonthVerified =row.nqs_month_verified!=null? Number(row.nqs_month_verified):null;
  pensionCalculationUpdateDetails.nqsDayVerified =row.nqs_day_verified!=null? Number(row.nqs_day_verified):null;
  pensionCalculationUpdateDetails.duesDeductionsVerified = row.dues_deductions_verified!=null? Number(row.dues_deductions_verified):null;
  pensionCalculationUpdateDetails.compassionatePensionVerified = row.compassionate_pension_verified!=null? Number(row.compassionate_pension_verified):null;
  pensionCalculationUpdateDetails.compensationPensionVerified = row.compensation_pension_verified!=null? Number(row.compensation_pension_verified):null;
  pensionCalculationUpdateDetails.terminalBenefitVerified = row.terminal_benefit_verified!=null? Number(row.terminal_benefit_verified):null;
  pensionCalculationUpdateDetails.finalCalculatedGratuityVerified = row.final_calculated_gratuity_verified!=null? Number(row.final_calculated_gratuity_verified):null; 
  //pensionCalculationUpdateDetails.additionalFamilyPensionIVerified = row.additional_family_pension_i_verified!=null? Number(row.additional_family_pension_i_verified):null;   
  //pensionCalculationUpdateDetails.additionalFamilyPensionIIVerified = row.additional_family_pension_ii_verified!=null? Number(row.additional_family_pension_ii_verified):null; 
  pensionCalculationUpdateDetails.familyPensionIStartDateVerified = intConversion(row.family_pension_i_start_date_verified);   
  pensionCalculationUpdateDetails.familyPensionIEndDateVerified = intConversion(row.family_pension_i_end_date_verified);   
  pensionCalculationUpdateDetails.familyPensionIIStartDateVerified = intConversion(row.family_pension_ii_start_date_verified);   
  pensionCalculationUpdateDetails.exGratiaVerified = row.ex_gratia_verified!=null? Number(row.ex_gratia_verified):null;  
  pensionCalculationUpdateDetails.pensionerFamilyPensionVerified =row.pensioner_family_pension_verified!=null? Number(row.pensioner_family_pension_verified):null;  
  //pensionCalculationUpdateDetails.additionalPensionerFamilyPensionVerified = row.additional_pensioner_family_pension_verified!=null? Number(row.additional_pensioner_family_pension_verified):null;
  pensionCalculationUpdateDetails.totalPensionVerified = row.total_pension_verified!=null? Number(row.total_pension_verified):null;
  pensionCalculationUpdateDetails.provisionalPensionVerified = row.provisional_pension_verified!=null? Number(row.provisional_pension_verified):null;

  pensionCalculationUpdateDetails.invalidPensionVerified =row.invalid_pension_verified!=null? Number(row.invalid_pension_verified):null;
  pensionCalculationUpdateDetails.woundExtraordinaryPensionVerified =row.wound_extraordinary_pension_verified!=null? Number(row.wound_extraordinary_pension_verified):null;
  pensionCalculationUpdateDetails.attendantAllowanceVerified =row.attendant_allowance_verified!=null? Number(row.attendant_allowance_verified):null;

  pensionCalculationUpdateDetails.gqsYearVerified =Number(row.gqs_year_verified);
  pensionCalculationUpdateDetails.gqsMonthVerified =Number(row.gqs_month_verified);
  pensionCalculationUpdateDetails.gqsDayVerified =Number(row.gqs_day_verified);

  pensionCalculationUpdateDetails.notificationTextVerified =row.notification_text_verified;
  
  pensionCalculationUpdateDetails.pensionArrearVerified = row.pension_arrear_verified!=null? Number(row.pension_arrear_verified):null;
  return pensionCalculationUpdateDetails;
};

const pensionerFinalCalculatedBenefitRowMapper = async (row, mapper = {}) => {
  let pensionerFinalCalculatedBenefitDetails = isEmpty(mapper) ? {} : mapper;  
  pensionerFinalCalculatedBenefitDetails.basicPension =row.basic_pension!=null? Number(row.basic_pension):null;  
  pensionerFinalCalculatedBenefitDetails.pensionDeductions =row.pension_deductions!=null? Number(row.pension_deductions):null;  
  pensionerFinalCalculatedBenefitDetails.additionalPension =row.additional_pension!=null? Number(row.additional_pension):null;  
  pensionerFinalCalculatedBenefitDetails.commutedPension = row.commuted_pension!=null? Number(row.commuted_pension):null;
  pensionerFinalCalculatedBenefitDetails.commutedValue = row.commuted_value!=null? Number(row.commuted_value):null;  
  pensionerFinalCalculatedBenefitDetails.familyPensionI = row.family_pension_i!=null? Number(row.family_pension_i):null;
  pensionerFinalCalculatedBenefitDetails.familyPensionII = row.family_pension_ii!=null? Number(row.family_pension_ii):null; 
  pensionerFinalCalculatedBenefitDetails.dcrg = row.dcrg!=null? Number(row.dcrg):null; 
  pensionerFinalCalculatedBenefitDetails.netDeductions = row.net_deductions!=null? Number(row.net_deductions):null; 
  pensionerFinalCalculatedBenefitDetails.finalCalculatedPension = row.final_calculated_pension!=null? Number(row.final_calculated_pension):null; 
  pensionerFinalCalculatedBenefitDetails.interimRelief = row.interim_relief!=null? Number(row.interim_relief):null; 
  pensionerFinalCalculatedBenefitDetails.da = row.da!=null? Number(row.da):null; 
  pensionerFinalCalculatedBenefitDetails.nqsYear =row.nqs_year!=null? Number(row.nqs_year):null;
  pensionerFinalCalculatedBenefitDetails.nqsMonth =row.nqs_month!=null? Number(row.nqs_month):null;
  pensionerFinalCalculatedBenefitDetails.nqsDay =row.nqs_day!=null? Number(row.nqs_day):null;
  pensionerFinalCalculatedBenefitDetails.duesDeductions = row.dues_deductions!=null? Number(row.dues_deductions):null;
  pensionerFinalCalculatedBenefitDetails.compassionatePension = row.compassionate_pension!=null? Number(row.compassionate_pension):null;
  pensionerFinalCalculatedBenefitDetails.compensationPension = row.compensation_pension!=null? Number(row.compensation_pension):null;
  pensionerFinalCalculatedBenefitDetails.terminalBenefit = row.terminal_benefit!=null? Number(row.terminal_benefit):null;
  pensionerFinalCalculatedBenefitDetails.finalCalculatedGratuity = row.final_calculated_gratuity!=null? Number(row.final_calculated_gratuity):null; 
  //pensionerFinalCalculatedBenefitDetails.additionalFamilyPensionI = row.additional_family_pension_i!=null? Number(row.additional_family_pension_i):null;   
  //pensionerFinalCalculatedBenefitDetails.additionalFamilyPensionII = row.additional_family_pension_ii!=null? Number(row.additional_family_pension_ii):null; 
  pensionerFinalCalculatedBenefitDetails.familyPensionIStartDate = intConversion(row.family_pension_i_start_date);   
  pensionerFinalCalculatedBenefitDetails.familyPensionIEndDate = intConversion(row.family_pension_i_end_date);   
  pensionerFinalCalculatedBenefitDetails.familyPensionIIStartDate = intConversion(row.family_pension_ii_start_date);   
  pensionerFinalCalculatedBenefitDetails.exGratia = row.ex_gratia!=null? Number(row.ex_gratia):null;  
  pensionerFinalCalculatedBenefitDetails.pensionerFamilyPension =row.pensioner_family_pension!=null? Number(row.pensioner_family_pension):null;  
  //pensionerFinalCalculatedBenefitDetails.additionalPensionerFamilyPension = row.additional_pensioner_family_pension!=null? Number(row.additional_pensioner_family_pension):null;
  pensionerFinalCalculatedBenefitDetails.totalPension = row.total_pension!=null? Number(row.total_pension):null;
  pensionerFinalCalculatedBenefitDetails.provisionalPension = row.provisional_pension!=null? Number(row.provisional_pension):null;
  pensionerFinalCalculatedBenefitDetails.woundExtraordinaryPension = row.wound_extraordinary_pension!=null? Number(row.wound_extraordinary_pension):null;
  pensionerFinalCalculatedBenefitDetails.attendantAllowance = row.attendant_allowance!=null? Number(row.attendant_allowance):null;
  pensionerFinalCalculatedBenefitDetails.invalidPension = row.invalid_pension!=null? Number(row.invalid_pension):null;
  
  return pensionerFinalCalculatedBenefitDetails;
};

const workflowAccessibiltyRowMapper = async (row, mapper = {}) => {
  let workflowAccessibilty = isEmpty(mapper) ? {} : mapper;
  workflowAccessibilty.code = row.employee_hrms_code;  
  workflowAccessibilty.assignee = row.assignee;  
  workflowAccessibilty.assigneeName = "";    
  workflowAccessibilty.isClaimEnabled=false;
  workflowAccessibilty.isReleaseEnabled=false;
  workflowAccessibilty.isViewEnabled=false;
  return workflowAccessibilty;
};

export const mergeSearchResults = async (response, query = {}, reqInfo) => {
  requestInfo = reqInfo;
  let result = [];
  for (var i = 0; i < response.length; i++) {
    let employee = {};    
    let index = findIndex(result, { id: response[i].employee_hrms_id });
    if (index != -1) {
        employee = await employeeRowMapper(response[i], result[index]);
        result[index] = employee;
    } else {
        employee = await employeeRowMapper(response[i]);
        result.push(employee);
    }
  }
  //removeEmpty(result);
  return result;
};

export const mergeEmployeeAssigmentResults = async (response, query = {}, reqInfo) => {
  requestInfo = reqInfo;
  let result = [];
  for (var i = 0; i < response.length; i++) {
    let employee = {};    
    let index = findIndex(result, { id: response[i].employee_hrms_id });
    if (index != -1) {
        employee = await employeeRowMapper(response[i], result[index]);
        result[index] = employee;
    } else {
        employee = await employeeRowMapper(response[i]);
        result.push(employee);
    }
  }
  //removeEmpty(result);
  return result;
};

export const mergeWorkflowDocumentSearchResults = async (response, query = {}, reqInfo) => {
  requestInfo = reqInfo;
  let result = [];
  for (var i = 0; i < response.length; i++) {
    let document = {};    
    
    document = await workflowDocumentRowMapper(response[i]);
    result.push(document);
  }
  //removeEmpty(result);
  return result;
};

export const mergeSearchPensionerResults = async (response, query = {}, reqInfo, mdms) => {
  requestInfo = reqInfo;
  let result = [];
  for (var i = 0; i < response.length; i++) {
    let pensioner = {};    
    
    pensioner = await searchPensionerRowMapper(response[i], mdms);
    result.push(pensioner);
  }  
  return result;
};

export const mergeSearchPensionerForPensionRevisionResults = async (response, query = {}, reqInfo) => {
  requestInfo = reqInfo;
  let pensionRevision={
    tenantId: response[0].tenantid,
    pensioner:{
      pensionerId: response[0].pensioner_id,
      pensionEmployeeId: response[0].pension_employee_id,
      //workflowHeaderId: response[0].workflow_header_id,
      pensionerFinalCalculatedBenefitId: response[0].pensioner_final_calculated_benefit_id,
      businessService: response[0].business_service,
      pensionerNumber: response[0].pensioner_number,
      name: response[0].name,
    },
    pensionRevision:[]   
  };

  let result = [];
  for (var i = 0; i < response.length; i++) {
    let pensionRevision = {};        
    pensionRevision = await searchPensionerPensionRevisionRowMapper(response[i]);
    result.push(pensionRevision);
  }  
  pensionRevision.pensionRevision=result;

  return pensionRevision;
};

export const mergeSearchPensionRegisterResults = async (response, query = {}, reqInfo) => {
  requestInfo = reqInfo;

  let result = [];
  for (var i = 0; i < response.length; i++) {
    let register = {};        
    register = await searchPensionRegisterRowMapper(response[i]);
    result.push(register);
  }  
  
  return result;
};

export const mergePensionRevisionResults = async (response, query = {}, reqInfo) => {
  requestInfo = reqInfo;
  
  let result = [];
  for (var i = 0; i < response.length; i++) {
    let pensionRevision = {};        
    pensionRevision = await pensionRevisionRowMapper(response[i]);
    result.push(pensionRevision);
  }  
  

  return result;
};

export const mergeLeaveSearchResults = async (response, query = {}, reqInfo) => {
  requestInfo = reqInfo;
  let result = [];
  for (var i = 0; i < response.length; i++) {
    let leave = {};    
    
    leave = await leaveRowMapper(response[i]);
    result.push(leave);
  }
  //removeEmpty(result);
  return result;
};

export const mergeDependentResults = async (response, query = {}, reqInfo, mdms) => {
  requestInfo = reqInfo;
  let result = [];
  for (var i = 0; i < response.length; i++) {
    let dependent = {};    
    
    dependent = await dependentRowMapper(response[i], mdms);
    result.push(dependent);
  }  
  return result;
};

export const mergeAssignmentResults = async (response, query = {}, reqInfo) => {
  requestInfo = reqInfo;
  let result = [];
  for (var i = 0; i < response.length; i++) {
    let assignment = {};        
    assignment = await assignmentRowMapper(response[i]);
    result.push(assignment);
  }  
  return result;
};

export const mergeServiceHistoryResults = async (response, query = {}, reqInfo) => {
  requestInfo = reqInfo;
  let result = [];
  for (var i = 0; i < response.length; i++) {
    let serviceHistory = {};        
    serviceHistory = await serviceHistoryRowMapper(response[i]);
    result.push(serviceHistory);
  }  
  return result;
};

export const mergePensionEmployeeResults = async (response, query = {}, reqInfo) => {
  requestInfo = reqInfo;
  let result = [];
  for (var i = 0; i < response.length; i++) {
    let employee = {};        
    employee = await pensionEmployeeRowMapper(response[i]);
    result.push(employee);
  }  
  return result;
};

export const mergeEmployeeDisabilityResults = async (response, query = {}, reqInfo) => {
  requestInfo = reqInfo;
  let result = [];
  for (var i = 0; i < response.length; i++) {
    let employee = {};        
    employee = await employeeDisabilityRowMapper(response[i]);
    result.push(employee);
  }  
  return result;
};

export const mergeWorkflowDocumentAuditSearchResults = async (response, query = {}, reqInfo) => {
  requestInfo = reqInfo;
  let result = [];
  for (var i = 0; i < response.length; i++) {
    let documentAudit = {};        
    documentAudit = await workflowDocumentAuditRowMapper(response[i]);
    result.push(documentAudit);
  }
  

  for (var i = 0; i < result.length; i++) {
    let createdBy="";
    let userResponse=await searchUser(
    reqInfo,
    result[i].createdBy
    );  
    
    createdBy=userResponse.name;
    
    result[i].createdBy=createdBy;
  }
  
  return result;
};

export const mergeWorkflowHeader = async (response, query = {}, reqInfo) => {
  requestInfo = reqInfo;
  let result =await workflowHeaderRowMapper(response[0]);;  
  return result;
};

export const mergeIsEmployeeExistInPensionModule = async (response, query = {}, reqInfo) => {
  requestInfo = reqInfo;
  let result =await isEmployeeExistInPensionModuleRowMapper(response[0]);;  
  return result;
};

export const mergeSearchEmployee = async (response, query = {}, reqInfo) => {
  requestInfo = reqInfo;
  let result =await searchEmployeeRowMapper(response[0]);;  
  return result;
};

export const mergeEmployeeOtherDetails = async (response, query = {}, reqInfo, mdms) => {
  requestInfo = reqInfo;
  let result =await employeeOtherDetailsRowMapper(response[0], mdms);;  
  return result;
};

export const mergePensionCalculationDetails = async (response, query = {}, reqInfo) => {
  requestInfo = reqInfo;
  let result =await pensionCalculationDetailsRowMapper(response[0]);;  
  return result;
};

export const mergePensionArrearDetails = async (response, query = {}, reqInfo) => {
  requestInfo = reqInfo;

  let result = [];
  for (var i = 0; i < response.length; i++) {
    let arrear = {};    
    
    arrear = await pensionArrearRowMapper(response[i]);
    result.push(arrear);
  }  
  return result;
};

export const mergePensionCalculationUpdateDetails = async (response, query = {}, reqInfo) => {
  requestInfo = reqInfo;
  let result =await pensionCalculationUpdateDetailsRowMapper(response[0]);;  
  return result;
};

export const mergePensionerFinalCalculatedBenefit = async (response, query = {}, reqInfo) => {
  requestInfo = reqInfo;
  let result =await pensionerFinalCalculatedBenefitRowMapper(response[0]);;  
  return result;
};

export const mergeWorkflowAccessibilty = async (response, query = {}, reqInfo) => {
  requestInfo = reqInfo;
  

  let result =await workflowAccessibiltyRowMapper(response[0]);; 
  

  if(result.assignee)//claimed by self or any other user
  {
    let assigneeName="";
    let userResponse=await searchUser(
      reqInfo,
      result.assignee
    );  
    assigneeName=userResponse.name;
    result.assigneeName=assigneeName;
    result.isClaimEnabled=false;
    result.isReleaseEnabled=result.assignee===requestInfo.userInfo.uuid?true:false;
    result.isViewEnabled=result.assignee===requestInfo.userInfo.uuid?true:false;
  }
  else{
    result.assignee="";
    result.isClaimEnabled=true;
    result.isReleaseEnabled=false;
    result.isViewEnabled=false;

  }
  
  
  
  return result;
};

export const mergeSearchClosedApplicationResults = async (response, query = {}, reqInfo) => {
  requestInfo = reqInfo;
  let result = [];
  for (var i = 0; i < response.length; i++) {
    let application = {};    
    
    application = await searchClosedApplicationRowMapper(response[i]);
    result.push(application);
  }  
  return result;
};

const searchClosedApplicationRowMapper = async (row, mapper = {}) => {
  let application = isEmpty(mapper) ? {} : mapper;
  application.workflowHeaderId = row.uuid;
  application.tenantId = row.tenantid;
  application.businessService = row.workflow_type;
  application.businessId = row.application_number;
  application.applicationDate = intConversion(row.application_date);
  application.lastModifiedDate = intConversion(row.last_modified_date);  
  application.state = row.workflow_state;
  application.recomputedBusinessId = row.recomputed_application_number;
  application.pensionEmployeeId = row.pension_employee_id;   
  application.code = row.employee_hrms_code;   
  application.name = row.name; 
  return application;
};

export const mergeSearchApplicationResults = async (response, query = {}, reqInfo) => {
  requestInfo = reqInfo;
  let result = [];
  for (var i = 0; i < response.length; i++) {
    let application = {};    
    
    application = await searchApplicationRowMapper(response[i]);
    result.push(application);
  }  
  return result;
};

const searchApplicationRowMapper = async (row, mapper = {}) => {
  let application = isEmpty(mapper) ? {} : mapper;
  application.workflowHeaderId = row.uuid;
  application.tenantId = row.tenantid;
  application.businessService = row.workflow_type;
  application.businessId = row.application_number;
  application.applicationDate = intConversion(row.application_date);
  application.lastModifiedDate = intConversion(row.last_modified_date);  
  application.state = row.workflow_state;  
  application.pensionEmployeeId = row.pension_employee_id;   
  application.code = row.employee_hrms_code;   
  application.name = row.name; 
  return application;
};

export const mergeMigratedPensionerResults = async (response, query = {}, reqInfo) => {
  requestInfo = reqInfo;
  let result = [];
  for (var i = 0; i < response.length; i++) {
    let assignment = {};        
    assignment = await migratedPensionerRowMapper(response[i]);
    result.push(assignment);
  }  
  return result;
};

const migratedPensionerRowMapper = async (row, mapper = {}) => {
  let pensioner = isEmpty(mapper) ? {} : mapper;
  pensioner.slNo =Number(row.sl_no) ;
  pensioner.name =row.name ;
  pensioner.code =row.code  ;
  pensioner.dateOfBirth =row.date_of_birth!="NA"?intConversion(convertDateToEpochForMigration(String(row.date_of_birth).split("/").reverse().join("-"),"dob")):null ;
  pensioner.gender =row.gender;
  pensioner.dateOfDeath =row.date_of_death!="NA"?intConversion(convertDateToEpochForMigration(String(row.date_of_death).split("/").reverse().join("-"),"dob")):null ;
  pensioner.mobileNumber =row.mobile_number;
  pensioner.email =row.email;
  pensioner.address =row.address;
  pensioner.bankDetails =row.bank_details;
  pensioner.bankAccountNumber =row.bank_account_number!=null? encrypt(row.bank_account_number):row.bank_account_number;
  pensioner.bankIfsc =row.bank_ifsc;
  pensioner.bankCode =row.bank_code;
  pensioner.employeeStatus =row.employee_status ;
  pensioner.employeeType =row.employee_type ;
  pensioner.employeeGroup =row.employee_group ;
  pensioner.designation =row.designation ;
  pensioner.department =row.department;
  pensioner.dateOfJoining =row.date_of_joining!="NA"?intConversion(convertDateToEpochForMigration(String(row.date_of_joining).split("/").reverse().join("-"),"dob")):null ;
  pensioner.serviceEndDate =row.service_end_date!="NA"?intConversion(convertDateToEpochForMigration(String(row.service_end_date).split("/").reverse().join("-"),"dob")):null ;
  pensioner.dateOfRetirement =row.date_of_retirement!="NA"?intConversion(convertDateToEpochForMigration(String(row.date_of_retirement).split("/").reverse().join("-"),"dob")):null ;
  pensioner.dateOfContingent =row.date_of_contingent!="NA"?intConversion(convertDateToEpochForMigration(String(row.date_of_contingent).split("/").reverse().join("-"),"dob")):null ;
  pensioner.claimantName =row.claimant_name!="NA"?row.claimant_name:null ;
  pensioner.claimantDob =row.claimant_dob!="NA"?intConversion(convertDateToEpochForMigration(String(row.claimant_dob).split("/").reverse().join("-"),"dob")):null ;
  pensioner.claimantRelationship =row.claimant_relationship!="NA"?row.claimant_relationship:null;
  pensioner.claimantMobileNumber =row.claimant_mobile_number!="NA"?row.claimant_mobile_number:null ;
  pensioner.claimantAddress =row.claimant_address!="NA"?row.claimant_address:null ;
  pensioner.claimantBankDetails =row.claimant_bank_details!="NA"?row.claimant_bank_details:null ;
  pensioner.claimantBankAccountNumber =row.claimant_bank_account_number!="NA"&&row.claimant_bank_account_number!=null?encrypt(row.claimant_bank_account_number):null ;
  pensioner.claimantBankIfsc =row.claimant_bank_ifsc!="NA"?row.claimant_bank_ifsc:null ;
  pensioner.claimantBankCode =row.claimant_bank_code!="NA"?row.claimant_bank_code:null ;
  pensioner.nqsYear =row.nqs_year!="NA"?Number(row.nqs_year) :null ;
  pensioner.nqsMonth =row.nqs_month!="NA"?Number(row.nqs_month):null ;
  pensioner.nqsDays =row.nqs_days!="NA"?Number(row.nqs_days):null ;
  pensioner.lpd =row.lpd!="NA"?Number(row.lpd):null ;
  pensioner.commutedValue =row.commuted_value!="NA"?Number(row.commuted_value):null  ;
  pensioner.dcrg =row.dcrg!="NA"?Number(row.dcrg):null  ;
  pensioner.dcrgDuesDeductions =row.dcrg_dues_deductions!="NA"?Number(row.dcrg_dues_deductions):null  ;
  pensioner.netGratuity =row.net_gratuity!="NA"?Number(row.net_gratuity):null  ;
  pensioner.terminalBenefit =row.terminal_benefit!="NA"?Number(row.terminal_benefit):null  ;
  pensioner.familyPensionIStartDate =row.family_pension_i_start_date!="NA"?intConversion(convertDateToEpochForMigration(String(row.family_pension_i_start_date).split("/").reverse().join("-"),"dob")):null ;
  pensioner.familyPensionIEndDate =row.family_pension_i_end_date!="NA"?intConversion(convertDateToEpochForMigration(String(row.family_pension_i_end_date).split("/").reverse().join("-"),"dob")):null ;
  pensioner.familyPensionIIStartDate =row.family_pension_ii_start_date!="NA"?intConversion(convertDateToEpochForMigration(String(row.family_pension_ii_start_date).split("/").reverse().join("-"),"dob")):null ;
  pensioner.exGratia =row.ex_gratia!="NA"?Number(row.ex_gratia):null  ;
  pensioner.ltc =row.ltc!="NA"?Number(row.ltc):null  ;
  pensioner.isDaMedicalAdmissible =row.is_da_medical_admissible=="TRUE"?true:false;
  pensioner.pensionerNumber =row.pensioner_number!="NA"?row.pensioner_number:null ;
  pensioner.startYear =row.start_year!="NA"?Number(row.start_year):null  ;
  pensioner.startMonth =row.start_month!="NA"?Number(row.start_month):null;
  pensioner.endYear =row.end_year!="NA" && row.end_year!="" && row.end_year!=null?Number(row.end_year):null;
  pensioner.endMonth =row.end_month!="NA" && row.end_month!="" && row.end_month!=null?Number(row.end_month):null;
  pensioner.basicPension =row.basic_pension!="NA"?Number(row.basic_pension):null;
  pensioner.da =row.da!="NA"?Number(row.da):null;
  pensioner.commutedPension =row.commuted_pension!="NA"?Number(row.commuted_pension):null;
  pensioner.additionalPension =row.additional_pension!="NA"?Number(row.additional_pension):null;
  pensioner.ir =row.ir!="NA"?Number(row.ir):null;
  pensioner.fma =row.fma!="NA"?Number(row.fma):null;
  pensioner.misc =row.misc!="NA"?Number(row.misc):null;
  pensioner.woundExtraordinaryPension =row.wound_extraordinary_pension!="NA"?Number(row.wound_extraordinary_pension):null;
  pensioner.attendantAllowance =row.attendant_allowance!="NA"?Number(row.attendant_allowance):null;
  pensioner.totalPension =row.total_pension!="NA"?Number(row.total_pension):null;
  pensioner.overPayment =row.over_payment!="NA"?Number(row.over_payment):null;
  pensioner.incomeTax =row.income_tax!="NA"?Number(row.income_tax):null;
  pensioner.cess =row.cess!="NA"?Number(row.cess):null;
  pensioner.pensionDeductions =row.pension_deductions!="NA"?Number(row.pension_deductions):null;
  pensioner.netDeductions =row.net_deductions!="NA"?Number(row.net_deductions):null;
  pensioner.netPension =row.net_pension!="NA"?Number(row.net_pension):null;
  pensioner.billCode =row.bill_code=="TRUE"?true:false;   
  return pensioner;
};


const removeEmpty = obj => {
  Object.keys(obj).forEach(function(key) {
    if (obj[key] && typeof obj[key] === "object") removeEmpty(obj[key]);
    else if (obj[key] == null) delete obj[key];
  });
};

const searchUser = async (requestInfo, uuid) => {
  let userSearchReqCriteria = {};
  let userSearchResponse = {};
  userSearchReqCriteria.uuid = [uuid];
  userSearchResponse = await userService.searchUser(
    requestInfo,
    userSearchReqCriteria
  );
  let users = get(userSearchResponse, "user", []);
  return users.length ? users[0] : {};
};

export const searchByMobileNumber = async (mobileNumber, tenantId) => {
  var userSearchReqCriteria = {};
  userSearchReqCriteria.userType = "CITIZEN";
  userSearchReqCriteria.tenantId = tenantId;
  userSearchReqCriteria.mobileNumber = mobileNumber;
  var userSearchResponse = await userService.searchUser(
    requestInfo,
    userSearchReqCriteria
  );
  return userSearchResponse;
};

export const mergeMonthlyPensionDrawn = async (response, query = {}, reqInfo, mdms) => {
  requestInfo = reqInfo;
  
  let result = [];
  for (var i = 0; i < response.length; i++) {
    let pensionRevision = {};        
    pensionRevision = await monthlyPensionDrawnRowMapper(response[i], mdms);
    result.push(pensionRevision);
  }  
  

  return result;
};

const monthlyPensionDrawnRowMapper = async (row, mdms, mapper = {}) => {

  const mdmsBankDetails=get(mdms,"MdmsRes.pension.BankDetails"); 

  let pension = isEmpty(mapper) ? {} : mapper;
  pension.pensionerNumber = row.pensioner_number; 
  pension.name = row.name; 
  pension.finalCalculatedPension = intConversion(Number(row.final_calculated_pension)); 
  let bankDetailsList=filter(mdmsBankDetails,function(x){return (x.code ==null?"":x.code.toUpperCase().trim())==(row.bank_details==null?"":row.bank_details.toUpperCase().trim()) && row.bank_details!=null && row.bank_details!="";});
  if(bankDetailsList.length>0){
    pension.bankDetails = bankDetailsList[0].name;  
  }

  //pension.bankDetails = row.bank_details; 
  pension.bankCode = row.bank_code; 
  pension.bankIfsc = row.bank_ifsc; 
  pension.bankAccountNumber = row.bank_account_number!=null? decrypt(row.bank_account_number):row.bank_account_number; 
  return pension;
};