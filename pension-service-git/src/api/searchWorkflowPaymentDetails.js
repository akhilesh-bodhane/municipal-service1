import { Router } from "express";
import producer from "../kafka/producer";
import { requestInfoToResponseInfo, searchPensionWorkflow,epochToDmy} from "../utils";
import envVariables from "../envVariables";
import mdmsData from "../utils/mdmsData";
import isEmpty from "lodash/isEmpty";
import set from "lodash/set";
import get from "lodash/get";
import filter from "lodash/filter";
import orderBy from "lodash/orderBy";
import { intConversion} from "../utils/search";
const asyncHandler = require("express-async-handler");

import logger from "../config/logger";

export default ({ config, db }) => {
  let api = Router();
  api.post(
    "/_searchWorkflowPaymentDetails",
    asyncHandler(async (request, res, next) => {              
      //getting mdms data
           
      const queryObj = JSON.parse(JSON.stringify(request.query));
      
      let workflowSearchResponse = await searchPensionWorkflow(request.body.RequestInfo, queryObj.tenantId,queryObj.businessIds);
      
      logger.debug("workflowSearchResponse", JSON.stringify(workflowSearchResponse));
              
      let processInstances=workflowSearchResponse.ProcessInstances;
      let businessService=processInstances[0].businessService;
      let businessId=processInstances[0].businessId;
      let paymentOrderNumber=String(businessId).substring(0,6);
      paymentOrderNumber=paymentOrderNumber+String(businessId).substring(String(businessId).length-6,String(businessId).length);
      let date=new Date();
      let day = date.getDate() < 10 ? `0${date.getDate()}` : date.getDate();
      let month =date.getMonth() + 1 < 10 ? `0${date.getMonth() + 1}` : date.getMonth() + 1;      
      var formatted_date =day + "/" +  month + "/" + date.getFullYear();
      
      let bankAccountNumber;
      let bankDetails;
      let bankIfsc;
      let dependents=processInstances[0].dependents;
      let dependentEligibleForPension=[];      
      
      switch(businessService){
        case envVariables.EGOV_PENSION_RRP_BUSINESS_SERVICE:
          bankAccountNumber= processInstances[0].employeeOtherDetails.accountNumber;
          bankDetails= processInstances[0].employeeOtherDetails.bankName;
          bankIfsc= processInstances[0].employeeOtherDetails.bankIfsc;
          break;
        case envVariables.EGOV_PENSION_DOE_BUSINESS_SERVICE:
          dependentEligibleForPension=filter(dependents,function(x){return x.isEligibleForPension==true;});        
          bankAccountNumber=dependentEligibleForPension.length>0?dependentEligibleForPension[0].bankAccountNumber:null;
          bankDetails=dependentEligibleForPension.length>0?dependentEligibleForPension[0].bankName:null;      
          bankIfsc=dependentEligibleForPension.length>0?dependentEligibleForPension[0].bankIfsc:null;      
          break;
        case envVariables.EGOV_PENSION_DOP_BUSINESS_SERVICE:
          dependentEligibleForPension=filter(dependents,function(x){return x.isEligibleForPension==true;});
          bankAccountNumber=dependentEligibleForPension.length>0?dependentEligibleForPension[0].bankAccountNumber:null;
          bankDetails=dependentEligibleForPension.length>0?dependentEligibleForPension[0].bankName:null;              
          bankIfsc=dependentEligibleForPension.length>0?dependentEligibleForPension[0].bankIfsc:null;              
          break;
      }
      let paymentDetails={         
        businessId: processInstances[0].businessId, 
        date:formatted_date,
        paymentOrderNumber:paymentOrderNumber,      
        name: processInstances[0].employee.user.name,  
        dob: epochToDmy(intConversion(processInstances[0].employee.user.dob)) ,
        designation:processInstances[0].employee.assignments[0].designation,
        department:processInstances[0].employee.assignments[0].department,
        dateOfRetirement: epochToDmy(intConversion(processInstances[0].employee.dateOfRetirement)) ,                             
        dateOfDeath: epochToDmy(intConversion(processInstances[0].employee.dateOfDeath)) , 
        permanentAddress: processInstances[0].employee.user.permanentAddress,
        permanentCity: processInstances[0].employee.user.permanentCity,
        permanentPinCode: processInstances[0].employee.user.permanentPinCode,
        fatherOrHusbandName: processInstances[0].employee.user.fatherOrHusbandName,
        dateOfAppointment: epochToDmy(intConversion( processInstances[0].employee.dateOfAppointment)) ,                                
        reasonForRetirement: processInstances[0].employeeOtherDetails.reasonForRetirement,
        lpd: processInstances[0].employeeOtherDetails.lpd,  
        totalNoPayLeavesYears: processInstances[0].employeeOtherDetails.totalNoPayLeavesYears,
        totalNoPayLeavesMonths: processInstances[0].employeeOtherDetails.totalNoPayLeavesMonths,
        totalNoPayLeavesDays: processInstances[0].employeeOtherDetails.totalNoPayLeavesDays,   
        accountNumber: bankAccountNumber,
        bankAddress: bankDetails,   
        bankIfsc: bankIfsc,   
        gqsYearVerified: processInstances[0].pensionCalculationUpdateDetails.gqsYearVerified==null?0:processInstances[0].pensionCalculationUpdateDetails.gqsYearVerified,
        gqsMonthVerified: processInstances[0].pensionCalculationUpdateDetails.gqsMonthVerified==null?0:processInstances[0].pensionCalculationUpdateDetails.gqsMonthVerified,
        gqsDayVerified: processInstances[0].pensionCalculationUpdateDetails.gqsDayVerified==null?0:processInstances[0].pensionCalculationUpdateDetails.gqsDayVerified,          
        nqsYearVerified: processInstances[0].pensionCalculationUpdateDetails.nqsYearVerified==null?0:processInstances[0].pensionCalculationUpdateDetails.nqsYearVerified,
        nqsMonthVerified: processInstances[0].pensionCalculationUpdateDetails.nqsMonthVerified==null?0:processInstances[0].pensionCalculationUpdateDetails.nqsMonthVerified,
        nqsDayVerified: processInstances[0].pensionCalculationUpdateDetails.nqsDayVerified==null?0:processInstances[0].pensionCalculationUpdateDetails.nqsDayVerified,  
        pensionEligibleDependentName:dependentEligibleForPension.length>0?dependentEligibleForPension[0].name:null,      
        benefits:[]       
      };
      let benefits=[];
      let pensionCalculationDetails=processInstances[0].pensionCalculationDetails;
      let pensionCalculationUpdateDetails=processInstances[0].pensionCalculationUpdateDetails;
      if(pensionCalculationDetails.interimReliefApplicable){
        benefits.push({
          "code":"IR",
          "name":"IR",
          "value":pensionCalculationDetails.interimReliefLpdSystem,
          "expression":""
        })
      }

      if(pensionCalculationDetails.basicPensionApplicable){
        benefits.push({
          "code":"BASIC_PENSION",
          "name":"Basic Pension",
          "value":pensionCalculationUpdateDetails.basicPensionVerified,
          "expression":pensionCalculationDetails.basicPensionExpression
        })
      }

      if(pensionCalculationDetails.commutedPensionApplicable){
        benefits.push({
          "code":"COMMUTED_PENSION",
          "name":"Commuted Pension",
          "value":pensionCalculationUpdateDetails.commutedPensionVerified,
          "expression":pensionCalculationDetails.commutedPensionExpression
        })
      }

      if(pensionCalculationDetails.pensionDeductionsApplicable){
        benefits.push({
          "code":"PENSION_DEDUCTION",
          "name":"Pension Deduction",
          "value":pensionCalculationUpdateDetails.pensionDeductionsVerified,
          "expression":pensionCalculationDetails.pensionDeductionsExpression
        })
      }

      if(pensionCalculationDetails.commutationValueApplicable){
        benefits.push({
          "code":"COMMUTATION_VALUE",
          "name":"Commutation Value",
          "value":pensionCalculationUpdateDetails.commutedValueVerified,
          "expression":pensionCalculationDetails.commutationValueExpression
        })
      }

      if(pensionCalculationDetails.daApplicable){
        benefits.push({
          "code":"PENSION_DA",
          "name":"DA",
          "value":pensionCalculationUpdateDetails.daVerified,
          "expression":pensionCalculationDetails.daExpression
        })
      }

      if(pensionCalculationDetails.dcrgApplicable){
        benefits.push({
          "code":"DCRG",
          "name":"DCRG",
          "value":pensionCalculationUpdateDetails.dcrgVerified,
          "expression":pensionCalculationDetails.dcrgExpression
        })
      }

      if(pensionCalculationDetails.additionalPensionApplicable){
        benefits.push({
          "code":"ADDITIONAL_PENSION",
          "name":"Additional Pension",
          "value":pensionCalculationUpdateDetails.additionalPensionVerified,
          "expression":pensionCalculationDetails.additionalPensionExpression
        })
      }

      if(pensionCalculationDetails.compassionatePensionApplicable){
        benefits.push({
          "code":"COMPASSIONATE_PENSION",
          "name":"Compassionate Pension",
          "value":pensionCalculationUpdateDetails.compassionatePensionVerified,
          "expression":pensionCalculationDetails.compassionatePensionExpression
        })
      }

      if(pensionCalculationDetails.compensationPensionApplicable){
        benefits.push({
          "code":"COMPENSATION_PENSION",
          "name":"Compensation Pension",
          "value":pensionCalculationUpdateDetails.compensationPensionVerified,
          "expression":pensionCalculationDetails.compensationPensionExpression
        })
      }

      if(pensionCalculationDetails.terminalBenefitApplicable){
        benefits.push({
          "code":"TERMINAL_BENEFIT",
          "name":"Terminal Benefit",
          "value":pensionCalculationUpdateDetails.terminalBenefitVerified,
          "expression":pensionCalculationDetails.terminalBenefitExpression
        })
      }

      if(pensionCalculationDetails.duesDeductionsApplicable){
        benefits.push({
          "code":"DCRG_DUES_DEDUCTION",
          "name":"DCRG Dues Deduction",
          "value":pensionCalculationUpdateDetails.duesDeductionsVerified,
          "expression":pensionCalculationDetails.duesDeductionsExpression
        })
      }

      if(pensionCalculationDetails.netDeductionsApplicable){
        benefits.push({
          "code":"NET_DEDUCTION",
          "name":"Net Deduction",
          "value":pensionCalculationUpdateDetails.netDeductionsVerified,
          "expression":pensionCalculationDetails.netDeductionsExpression
        })
      }

      if(pensionCalculationDetails.totalPensionApplicable){
        benefits.push({
          "code":"TOTAL_PENSION",
          "name":"Total Pension",
          "value":pensionCalculationUpdateDetails.totalPensionVerified,
          "expression":pensionCalculationDetails.totalPensionExpression
        })
      }

      if(pensionCalculationDetails.finalCalculatedPensionApplicable){
        benefits.push({
          "code":"FINAL_CALCULATED_PENSION",
          "name":"Net Pension",
          "value":pensionCalculationUpdateDetails.finalCalculatedPensionVerified,
          "expression":pensionCalculationDetails.finalCalculatedPensionExpression
        })
      }

      if(pensionCalculationDetails.finalCalculatedGratuityApplicable){
        benefits.push({
          "code":"FINAL_CALCULATED_GRATUITY",
          "name":"Net Gratuity",
          "value":pensionCalculationUpdateDetails.finalCalculatedGratuityVerified,
          "expression":pensionCalculationDetails.finalCalculatedGratuityExpression
        })
      }

      if(pensionCalculationDetails.familyPensionIApplicable){
        benefits.push({
          "code":"FAMILY_PENSION_1",
          "name":"Family Pension I",
          "value":pensionCalculationUpdateDetails.familyPensionIVerified,
          "expression":pensionCalculationDetails.familyPensionIExpression
        })
      }

      if(pensionCalculationDetails.familyPensionIIApplicable){
        benefits.push({
          "code":"FAMILY_PENSION_2",
          "name":"Family Pension II",
          "value":pensionCalculationUpdateDetails.familyPensionIIVerified,
          "expression":pensionCalculationDetails.familyPensionIIExpression
        })
      }

      if(pensionCalculationDetails.pensionerFamilyPensionApplicable){
        benefits.push({
          "code":"PENSIONER_FAMILY_PENSION",
          "name":"Pensioner Family Pension",
          "value":pensionCalculationUpdateDetails.pensionerFamilyPensionVerified,
          "expression":pensionCalculationDetails.pensionerFamilyPensionExpression
        })
      }

      if(pensionCalculationDetails.exGratiaApplicable){
        benefits.push({
          "code":"EX_GRATIA",
          "name":"Ex Gratia",
          "value":pensionCalculationUpdateDetails.exGratiaVerified,
          "expression":pensionCalculationDetails.exGratiaExpression
        })
      }

      if(pensionCalculationDetails.provisionalPensionApplicable){
        benefits.push({
          "code":"PROVISIONAL_PENSION",
          "name":"Provisional Pension",
          "value":pensionCalculationUpdateDetails.provisionalPensionVerified,
          "expression":pensionCalculationDetails.provisionalPensionExpression
        })
      }

      if(pensionCalculationDetails.invalidPensionApplicable){
        benefits.push({
          "code":"INVALID_PENSION",
          "name":"Invalid Pension",
          "value":pensionCalculationUpdateDetails.invalidPensionVerified,
          "expression":pensionCalculationDetails.invalidPensionExpression
        })
      }

      if(pensionCalculationDetails.woundExtraordinaryPensionApplicable){
        benefits.push({
          "code":"WOUND_EXTRAORDINARY_PENSION",
          "name":"Wound or Extraordinary Pension",
          "value":pensionCalculationUpdateDetails.woundExtraordinaryPensionVerified,
          "expression":pensionCalculationDetails.woundExtraordinaryPensionExpression
        })
      }

      if(pensionCalculationDetails.attendantAllowanceApplicable){
        benefits.push({
          "code":"ATTENDANT_ALLOWANCE",
          "name":"Attendant Allowance",
          "value":pensionCalculationUpdateDetails.attendantAllowanceVerified,
          "expression":pensionCalculationDetails.attendantAllowanceExpression
        })
      }

      paymentDetails.benefits=benefits;



      let response = {
        ResponseInfo: requestInfoToResponseInfo(request.body.RequestInfo, true),
        PaymentDetails: paymentDetails          
      };
      
      
      res.json(response);     
        
    })
  );
  return api;
};
