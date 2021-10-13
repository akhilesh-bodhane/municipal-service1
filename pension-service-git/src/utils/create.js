import { addIDGenId, uuidv1,getEmployeeDetails,searchEmployee,epochToYmd } from "../utils";
import envVariables from "../envVariables";
import get from "lodash/get";
import filter from "lodash/filter";
import orderBy from "lodash/orderBy";
import userService from "../services/userService";
import isEmpty from "lodash/isEmpty";
import {  intConversion } from "./search";

import logger from "../config/logger";

export const addUUIDAndAuditDetails = async (request, state= "") => {
  let { ProcessInstances, RequestInfo } = request;
  let businessService=ProcessInstances[0].businessService;
  let action=ProcessInstances[0].action;
  let createdBy = get(RequestInfo, "userInfo.uuid", "");    
  let createdDate = new Date().getTime(); 
  let auditDetails = {
    createdBy: createdBy,       
    lastModifiedBy: null,        
    createdDate: createdDate,        
    lastModifiedDate: null        
  };   
  
  

      

  switch(businessService)
  {
    case envVariables.EGOV_PENSION_RRP_BUSINESS_SERVICE:
      if(action=="INITIATE")
      {
        let pensionEmployeeId=ProcessInstances[0].employee.pensionEmployeeId;
        let code=ProcessInstances[0].employee.code;
        //fetch employee data from hrms 
        let hrmsResponse = await getEmployeeDetails(request.RequestInfo, ProcessInstances[0].tenantId,ProcessInstances[0].employee.code);              
        
        let employee=hrmsResponse.Employees[0];                
        
        if(employee){
          //employee.pensionEmployeeId=ProcessInstances[i].employee.pensionEmployeeId;
          let assignments=[];
          if(employee.assignments && !isEmpty(employee.assignments)){
            assignments=employee.assignments;
            let lastAssignments=[];
            let lastAssignment=[];
            if(assignments.length>1) {    
              assignments=orderBy(assignments,['fromDate'],['desc']);      
              lastAssignments=filter(assignments,function(x){return x.fromDate==assignments[0].fromDate;}); 
              if(lastAssignments.length>1){
                lastAssignments=filter(lastAssignments,function(x){return x.isPrimaryAssignment==true;}); 
                if(lastAssignments.length>0){
                  lastAssignment.push(lastAssignments[0]); 
                }
                else{
                  lastAssignments=filter(assignments,function(x){return x.fromDate==assignments[0].fromDate;}); 
                  lastAssignment.push(lastAssignments[0]);
                }                          
              }                                                                                                                                                                        
            }
            else{
              lastAssignment=assignments;
            }
            for (var i = 0; i <assignments.length; i++){
              if(assignments[i].id==lastAssignment[0].id){
                assignments[i].isPensionApplicable=true;
              }
              assignments[i].id=uuidv1(); 
              assignments[i].tenantId=employee.tenantId;                    
              assignments[i].active=true;      
              assignments[i].pensionEmployeeId=ProcessInstances[0].employee.pensionEmployeeId;     
            }
            //employee.assignments=assignments;
            //ProcessInstances[i].employee.assignments=assignments;
            

          }
          let serviceHistory=[];
          if(employee.serviceHistory && !isEmpty(employee.serviceHistory)){
            serviceHistory=employee.serviceHistory;
            for (var i = 0; i <serviceHistory.length; i++){
              serviceHistory[i].id=uuidv1();     
              serviceHistory[i].tenantId=employee.tenantId;                  
              serviceHistory[i].active=true;        
              serviceHistory[i].pensionEmployeeId=ProcessInstances[0].employee.pensionEmployeeId;            
            }
            //employee.serviceHistory=serviceHistory;
            //ProcessInstances[i].employee.serviceHistory=serviceHistory;
            
          }
                      
          let user=employee.user;
          user.employeeContactDetailsId=uuidv1();     
          user.tenantId=employee.tenantId;                 
          user.active=true; 
          //employee.user=user;
                                           
          //ProcessInstances[i].employee.user=user;
          logger.debug("employee",JSON.stringify(employee));   
          //ProcessInstances[i].employee=employee; 
          ProcessInstances[0].employee={
            pensionEmployeeId: pensionEmployeeId,
            code: code,
            assignments: assignments,
            serviceHistory: serviceHistory,
            user: user
          }        
        }
        //for loop should be replaced new alternative
        for (var i = 0; i < ProcessInstances.length; i++) {      
          /*        
          let applicationNumber =await addIDGenId(RequestInfo, [
            {
              tenantId: ProcessInstances[i].tenantId,
              format: envVariables.EGOV_RR_APPLICATION_FORMATE
            }
          ]);
          */
          let applicationNumber =await addIDGenId(RequestInfo, [
          {
            idName: envVariables.EGOV_IDGEN_PENSION_RRP_APPLICATION_NUMBER_ID_NAME,
            tenantId: ProcessInstances[i].tenantId,            
            format: envVariables.EGOV_RR_APPLICATION_FORMATE,
            count: 1
          }
          ]);

          
          ProcessInstances[i].businessId =applicationNumber;
          
          //workflowHeader object
          let workflowHeader={
            workflowHeaderId: uuidv1(),
            active: true,
            workflowHeaderAudit: {
              workflowHeaderAuditId: uuidv1()
            }
            
          }
          ProcessInstances[i].workflowHeader=workflowHeader;

          //notificationRegister object
          if(ProcessInstances[i].notificationRegister!=null){
            ProcessInstances[i].notificationRegister.pensionNotificationRegisterAuditId=uuidv1()  
          }           

          
         
          //state object
          let state={
            state: ""            
          };
          ProcessInstances[i].state=state;

          //employeeOtherDetails object (default)
          let employeeOtherDetails={
            employeeOtherDetailsId: uuidv1(),
            ltc: 0,
            lpd: 0,            
            pensionArrear: 0,            
            isDaMedicalAdmissible: false,
            fma: 0,
            medicalRelief: 0,
            miscellaneous: 0,
            overPayment: 0,
            incomeTax: 0,
            cess: 0,
            bankAddress: "",
            accountNumber: "",
            claimant: "",
            wef: null,            
            active: true,
            employeeOtherDetailsAudit: {
              employeeOtherDetailsAuditId: uuidv1()
            }
            
          };
          ProcessInstances[i].employeeOtherDetails=employeeOtherDetails;

          //pensionCalculationDetails object (default)
          let pensionCalculationDetails={
            pensionCalculationDetailsId: uuidv1(),            
            basicPensionSystem: 0,
            pensionDeductionsSystem: 0,
            additionalPensionSystem: 0,
            commutedPensionSystem: 0,
            commutedValueSystem: 0,
            familyPensionISystem: 0,
            familyPensionIISystem: 0,
            dcrgSystem: 0,
            netDeductionsSystem: 0,
            finalCalculatedPensionSystem: 0,            
            interimReliefSystem: 0, 
            daSystem: 0, 
            nqsYearSystem: 0,
            nqsMonthSystem: 0,
            nqsDaySystem: 0,
            duesDeductionsSystem: 0,
            compassionatePensionSystem: 0,
            compensationPensionSystem: 0,
            terminalBenefitSystem: 0,
            finalCalculatedGratuitySystem:0,
            active: true,
            pensionCalculationDetailsAudit: {
              pensionCalculationDetailsAuditId: uuidv1()
            }
            
          };
          ProcessInstances[i].pensionCalculationDetails=pensionCalculationDetails;

          //pensionCalculationUpdateDetails object (default)
          let pensionCalculationUpdateDetails={                       
            basicPensionVerified: 0,
            pensionDeductionsVerified: 0,
            additionalPensionVerified: 0,
            commutedPensionVerified: 0,
            commutedValueVerified: 0,
            familyPensionIVerified: 0,
            familyPensionIIVerified: 0,
            dcrgVerified: 0,
            netDeductionsVerified: 0,
            finalCalculatedPensionVerified: 0,
            interimReliefVerified: 0, 
            daVerified: 0,
            nqsYearVerified: 0,
            nqsMonthVerified: 0,
            nqsDayVerified: 0,    
            duesDeductionsVerified: 0,
            compassionatePensionVerified: 0,
            compensationPensionVerified: 0,
            terminalBenefitVerified: 0,         
            finalCalculatedGratuityVerified: 0
          };
          ProcessInstances[i].pensionCalculationUpdateDetails=pensionCalculationUpdateDetails;

          ProcessInstances[i].auditDetails = auditDetails;
        }
      }           
      break;
    case envVariables.EGOV_PENSION_DOE_BUSINESS_SERVICE:
      if(action=="INITIATE")
      {
        //for loop should be replaced new alternative
        for (var i = 0; i < ProcessInstances.length; i++) {    
          /*          
          let applicationNumber =await addIDGenId(RequestInfo, [
            {
              tenantId: ProcessInstances[i].tenantId,
              format: envVariables.EGOV_DE_APPLICATION_FORMATE
            }
          ]);
          */
          let applicationNumber =await addIDGenId(RequestInfo, [
            {
              idName: envVariables.EGOV_IDGEN_PENSION_DOE_APPLICATION_NUMBER_ID_NAME,
              tenantId: ProcessInstances[i].tenantId,         
              format: envVariables.EGOV_DE_APPLICATION_FORMATE,   
              count: 1
            }
          ]);
          ProcessInstances[i].businessId =applicationNumber;
          
          //workflowHeader object
          let workflowHeader={
            workflowHeaderId: uuidv1(),
            active: true,
            workflowHeaderAudit: {
              workflowHeaderAuditId: uuidv1()
            }
            
          }
          ProcessInstances[i].workflowHeader=workflowHeader;
          
          //employee object                  
          ProcessInstances[i].employee.employeeAudit={          
            pensionEmployeeAuditId: uuidv1()
          };
                      
          //state object
          let state={
            state: ""            
          };
          ProcessInstances[i].state=state;

          //employeeOtherDetails object
          let employeeOtherDetails={
            employeeOtherDetailsId: uuidv1(),
            ltc: 0,
            lpd: 0,            
            pensionArrear: 0,            
            isDaMedicalAdmissible: false,
            fma: 0,
            medicalRelief: 0,
            miscellaneous: 0,
            overPayment: 0,
            incomeTax: 0,
            cess: 0,
            bankAddress: "",
            accountNumber: "",
            claimant: "",
            wef: null,                  
            active: true,
            employeeOtherDetailsAudit: {
              employeeOtherDetailsAuditId: uuidv1()
            }
            
          };
          ProcessInstances[i].employeeOtherDetails=employeeOtherDetails;

          //pensionCalculationDetails object
          let pensionCalculationDetails={
            pensionCalculationDetailsId: uuidv1(),            
            basicPensionSystem: 0,
            pensionDeductionsSystem: 0,
            additionalPensionSystem: 0,
            commutedPensionSystem: 0,
            commutedValueSystem: 0,
            familyPensionISystem: 0,
            familyPensionIISystem: 0,
            dcrgSystem: 0,
            netDeductionsSystem: 0,
            finalCalculatedPensionSystem: 0,        
            interimReliefSystem: 0,
            daSystem: 0, 
            nqsYearSystem: 0,
            nqsMonthSystem: 0,
            nqsDaySystem: 0,   
            duesDeductionsSystem: 0,
            compassionatePensionSystem: 0,
            compensationPensionSystem: 0,
            terminalBenefitSystem: 0,
            finalCalculatedGratuitySystem: 0,
            active: true,
            pensionCalculationDetailsAudit: {
              pensionCalculationDetailsAuditId: uuidv1()
            }
            
          };
          ProcessInstances[i].pensionCalculationDetails=pensionCalculationDetails;

          let pensionCalculationUpdateDetails={                       
            basicPensionVerified: 0,
            pensionDeductionsVerified: 0,
            additionalPensionVerified: 0,
            commutedPensionVerified: 0,
            commutedValueVerified: 0,
            familyPensionIVerified: 0,
            familyPensionIIVerified: 0,
            dcrgVerified: 0,
            netDeductionsVerified: 0,
            finalCalculatedPensionVerified: 0,
            interimReliefVerified: 0,
            daVerified: 0,
            nqsYearVerified: 0,
            nqsMonthVerified: 0,
            nqsDayVerified: 0,
            duesDeductionsVerified: 0,
            compassionatePensionVerified: 0,
            compensationPensionVerified: 0,
            terminalBenefitVerified: 0,              
            finalCalculatedGratuityVerified: 0
          };
          ProcessInstances[i].pensionCalculationUpdateDetails=pensionCalculationUpdateDetails;

          ProcessInstances[i].auditDetails = auditDetails;
        }
      }             
      break;
    case envVariables.EGOV_PENSION_DOP_BUSINESS_SERVICE:
      if(action=="INITIATE")
      {
        //for loop should be replaced new alternative
        for (var i = 0; i < ProcessInstances.length; i++) {     
          /*         
          let applicationNumber =await addIDGenId(RequestInfo, [
            {
              tenantId: ProcessInstances[i].tenantId,
              format: envVariables.EGOV_DP_APPLICATION_FORMATE
            }
          ]);
          */
          let applicationNumber =await addIDGenId(RequestInfo, [
            {
              idName: envVariables.EGOV_IDGEN_PENSION_DOP_APPLICATION_NUMBER_ID_NAME,
              tenantId: ProcessInstances[i].tenantId,            
              format: envVariables.EGOV_DP_APPLICATION_FORMATE,
              count: 1
            }
          ]);
          ProcessInstances[i].businessId =applicationNumber;
          //fetch employee detaisl from pension module
          let employeeResponse = await searchEmployee(RequestInfo, ProcessInstances[i].tenantId,ProcessInstances[i].employee.code);
          let employee=employeeResponse.Employees[0];
           //employee object       
           ProcessInstances[i].employee={
            pensionEmployeeId: employee.pensionEmployeeId,
            code: ProcessInstances[i].employee.code,
            dateOfDeath: ProcessInstances[i].employee.dateOfDeath,
            employeeAudit : {          
              pensionEmployeeAuditId: uuidv1()
            }
           }           
          
          //workflowHeader object
          let workflowHeader={
            workflowHeaderId: uuidv1(),
            active: true,
            workflowHeaderAudit: {
              workflowHeaderAuditId: uuidv1()
            }
            
          }
          ProcessInstances[i].workflowHeader=workflowHeader;
          
          //employee object                  
          ProcessInstances[i].employee.employeeAudit={          
            pensionEmployeeAuditId: uuidv1()
          };
                      
          //state object
          let state={
            state: ""            
          };
          ProcessInstances[i].state=state;

          //employeeOtherDetails object
          let employeeOtherDetails={
            employeeOtherDetailsId: uuidv1(),
            ltc: 0,
            lpd: 0,            
            pensionArrear: 0,            
            isDaMedicalAdmissible: false,
            fma: 0,
            medicalRelief: 0,
            miscellaneous: 0,
            overPayment: 0,
            incomeTax: 0,
            cess: 0,
            bankAddress: "",
            accountNumber: "",
            claimant: "",
            wef: null,                  
            active: true,
            employeeOtherDetailsAudit: {
              employeeOtherDetailsAuditId: uuidv1()
            }
            
          };
          ProcessInstances[i].employeeOtherDetails=employeeOtherDetails;

          //pensionCalculationDetails object
          let pensionCalculationDetails={
            pensionCalculationDetailsId: uuidv1(),            
            basicPensionSystem: 0,
            pensionDeductionsSystem: 0,
            additionalPensionSystem: 0,
            commutedPensionSystem: 0,
            commutedValueSystem: 0,
            familyPensionISystem: 0,
            familyPensionIISystem: 0,
            dcrgSystem: 0,
            netDeductionsSystem: 0,
            finalCalculatedPensionSystem: 0,        
            interimReliefSystem: 0,
            daSystem: 0, 
            nqsYearSystem: 0,
            nqsMonthSystem: 0,
            nqsDaySystem: 0,   
            duesDeductionsSystem: 0,
            compassionatePensionSystem: 0,
            compensationPensionSystem: 0,
            terminalBenefitSystem: 0,
            finalCalculatedGratuitySystem: 0,
            active: true,
            pensionCalculationDetailsAudit: {
              pensionCalculationDetailsAuditId: uuidv1()
            }
            
          };
          ProcessInstances[i].pensionCalculationDetails=pensionCalculationDetails;

          let pensionCalculationUpdateDetails={                       
            basicPensionVerified: 0,
            pensionDeductionsVerified: 0,
            additionalPensionVerified: 0,
            commutedPensionVerified: 0,
            commutedValueVerified: 0,
            familyPensionIVerified: 0,
            familyPensionIIVerified: 0,
            dcrgVerified: 0,
            netDeductionsVerified: 0,
            finalCalculatedPensionVerified: 0,
            interimReliefVerified: 0,
            daVerified: 0,
            nqsYearVerified: 0,
            nqsMonthVerified: 0,
            nqsDayVerified: 0,
            duesDeductionsVerified: 0,
            compassionatePensionVerified: 0,
            compensationPensionVerified: 0,
            terminalBenefitVerified: 0,              
            finalCalculatedGratuityVerified: 0
          };
          ProcessInstances[i].pensionCalculationUpdateDetails=pensionCalculationUpdateDetails;

          ProcessInstances[i].auditDetails = auditDetails;
        }
      }      
      break;
  }

  if(action!=envVariables.EGOV_PENSION_WORKFLOW_ACTION_INITIATE){    
        //let leaves=[];
        let documents=[];  
        let dependents=[];

          
          for (var i = 0; i < ProcessInstances.length; i++) {           

            //workflowHeader object
            let workflowHeaderAudit= {
              workflowHeaderAuditId: uuidv1()
            };
            ProcessInstances[i].workflowHeader.workflowHeaderAudit=workflowHeaderAudit;

            //documents
            if(ProcessInstances[i].documents)
            {
              for (var j = 0; j < ProcessInstances[i].documents.length; j++)  
              {
                if(ProcessInstances[i].documents[j].fileStoreId!="")
                {
                  documents.push(
                    {
                      pensionAttachmentId: uuidv1(),
                      workflowHeaderId: ProcessInstances[i].workflowHeader.workflowHeaderId,
                      tenantId: ProcessInstances[i].tenantId,//
                      documentType: ProcessInstances[i].documents[j].documentType,
                      fileStoreId: ProcessInstances[i].documents[j].fileStoreId,
                      documentUid: uuidv1(),//workflow service only
                      active: true,
                      state: state,
                      comment: ProcessInstances[i].documents[j].comment,
                      documentAudit: {                
                        pensionAttachmentAuditId: uuidv1()
                      },                               
                      auditDetails: auditDetails
                    }
                  );
                }            
              } 

            }
                      
            //employeeOtherDetails
            if(ProcessInstances[i].employeeOtherDetails){
              ProcessInstances[i].employeeOtherDetails.ltc=ProcessInstances[i].employeeOtherDetails.ltc? Number(ProcessInstances[i].employeeOtherDetails.ltc):0,
              ProcessInstances[i].employeeOtherDetails.lpd=ProcessInstances[i].employeeOtherDetails.lpd? Number(ProcessInstances[i].employeeOtherDetails.lpd):0,            
              ProcessInstances[i].employeeOtherDetails.pensionArrear=ProcessInstances[i].employeeOtherDetails.pensionArrear? Number(ProcessInstances[i].employeeOtherDetails.pensionArrear):0,            
              ProcessInstances[i].employeeOtherDetails.isDaMedicalAdmissible=ProcessInstances[i].employeeOtherDetails.isDaMedicalAdmissible? ProcessInstances[i].employeeOtherDetails.isDaMedicalAdmissible:false,
              ProcessInstances[i].employeeOtherDetails.fma=ProcessInstances[i].employeeOtherDetails.fma? Number(ProcessInstances[i].employeeOtherDetails.fma):0,
              ProcessInstances[i].employeeOtherDetails.medicalRelief=ProcessInstances[i].employeeOtherDetails.medicalRelief? Number(ProcessInstances[i].employeeOtherDetails.medicalRelief):0,
              ProcessInstances[i].employeeOtherDetails.miscellaneous=ProcessInstances[i].employeeOtherDetails.miscellaneous? Number(ProcessInstances[i].employeeOtherDetails.miscellaneous):0,
              ProcessInstances[i].employeeOtherDetails.overPayment=ProcessInstances[i].employeeOtherDetails.overPayment? Number(ProcessInstances[i].employeeOtherDetails.overPayment):0,
              ProcessInstances[i].employeeOtherDetails.incomeTax=ProcessInstances[i].employeeOtherDetails.incomeTax? Number(ProcessInstances[i].employeeOtherDetails.incomeTax):0,
              ProcessInstances[i].employeeOtherDetails.cess=ProcessInstances[i].employeeOtherDetails.cess? Number(ProcessInstances[i].employeeOtherDetails.cess):0,            
              ProcessInstances[i].employeeOtherDetails.bankAddress=ProcessInstances[i].employeeOtherDetails.bankAddress? ProcessInstances[i].employeeOtherDetails.bankAddress:null,
              ProcessInstances[i].employeeOtherDetails.accountNumber=ProcessInstances[i].employeeOtherDetails.accountNumber? ProcessInstances[i].employeeOtherDetails.accountNumber:null,
              ProcessInstances[i].employeeOtherDetails.claimant=ProcessInstances[i].employeeOtherDetails.claimant?ProcessInstances[i].employeeOtherDetails.claimant:null,
              ProcessInstances[i].employeeOtherDetails.wef=ProcessInstances[i].employeeOtherDetails.wef && ProcessInstances[i].employeeOtherDetails.wef!=0? Number(ProcessInstances[i].employeeOtherDetails.wef):null,
              //ProcessInstances[i].employeeOtherDetails.dateOfContingent=ProcessInstances[i].employeeOtherDetails.dateOfContingent && ProcessInstances[i].employeeOtherDetails.dateOfContingent!=0? Number(ProcessInstances[i].employeeOtherDetails.dateOfContingent):null,
              ProcessInstances[i].employeeOtherDetails.totalNoPayLeavesDays=ProcessInstances[i].employeeOtherDetails.totalNoPayLeavesDays? Number(ProcessInstances[i].employeeOtherDetails.totalNoPayLeavesDays):0,
              ProcessInstances[i].employeeOtherDetails.dues=ProcessInstances[i].employeeOtherDetails.dues? Number(ProcessInstances[i].employeeOtherDetails.dues):0,
              ProcessInstances[i].employeeOtherDetails.isEmploymentActive=ProcessInstances[i].employeeOtherDetails.isEmploymentActive? ProcessInstances[i].employeeOtherDetails.isEmploymentActive:false,
              ProcessInstances[i].employeeOtherDetails.isConvictedSeriousCrimeOrGraveMisconduct=ProcessInstances[i].employeeOtherDetails.isConvictedSeriousCrimeOrGraveMisconduct?ProcessInstances[i].employeeOtherDetails.isConvictedSeriousCrimeOrGraveMisconduct:false,
              ProcessInstances[i].employeeOtherDetails.isAnyJudicialProceedingIsContinuing=ProcessInstances[i].employeeOtherDetails.isAnyJudicialProceedingIsContinuing?ProcessInstances[i].employeeOtherDetails.isAnyJudicialProceedingIsContinuing:false,
              ProcessInstances[i].employeeOtherDetails.isAnyMisconductInsolvencyInefficiency=ProcessInstances[i].employeeOtherDetails.isAnyMisconductInsolvencyInefficiency?ProcessInstances[i].employeeOtherDetails.isAnyMisconductInsolvencyInefficiency:false,
              ProcessInstances[i].employeeOtherDetails.isEmployeeDiesInTerroristAttack=ProcessInstances[i].employeeOtherDetails.isEmployeeDiesInTerroristAttack?ProcessInstances[i].employeeOtherDetails.isEmployeeDiesInTerroristAttack:false,
              ProcessInstances[i].employeeOtherDetails.isEmployeeDiesInAccidentalDeath=ProcessInstances[i].employeeOtherDetails.isEmployeeDiesInAccidentalDeath?ProcessInstances[i].employeeOtherDetails.isEmployeeDiesInAccidentalDeath:false,
              ProcessInstances[i].employeeOtherDetails.isCommutationOpted=ProcessInstances[i].employeeOtherDetails.isCommutationOpted?ProcessInstances[i].employeeOtherDetails.isCommutationOpted:false,
              ProcessInstances[i].employeeOtherDetails.reasonForRetirement=ProcessInstances[i].employeeOtherDetails.reasonForRetirement?ProcessInstances[i].employeeOtherDetails.reasonForRetirement:null,
              ProcessInstances[i].employeeOtherDetails.isEligibleForPension=ProcessInstances[i].employeeOtherDetails.isEligibleForPension?ProcessInstances[i].employeeOtherDetails.isEligibleForPension:false,
              ProcessInstances[i].employeeOtherDetails.isDuesPresent=ProcessInstances[i].employeeOtherDetails.isDuesPresent?ProcessInstances[i].employeeOtherDetails.isDuesPresent:false,
              ProcessInstances[i].employeeOtherDetails.isDuesAmountDecided=ProcessInstances[i].employeeOtherDetails.isDuesAmountDecided?ProcessInstances[i].employeeOtherDetails.isDuesAmountDecided:false,
              ProcessInstances[i].employeeOtherDetails.isTakenMonthlyPensionAndGratuity=ProcessInstances[i].employeeOtherDetails.isTakenMonthlyPensionAndGratuity?ProcessInstances[i].employeeOtherDetails.isTakenMonthlyPensionAndGratuity:false,
              ProcessInstances[i].employeeOtherDetails.isTakenGratuityCommutationTerminalBenefit=ProcessInstances[i].employeeOtherDetails.isTakenGratuityCommutationTerminalBenefit?ProcessInstances[i].employeeOtherDetails.isTakenGratuityCommutationTerminalBenefit:false,
              ProcessInstances[i].employeeOtherDetails.isTakenCompensationPensionAndGratuity=ProcessInstances[i].employeeOtherDetails.isTakenCompensationPensionAndGratuity?ProcessInstances[i].employeeOtherDetails.isTakenCompensationPensionAndGratuity:false,
              ProcessInstances[i].employeeOtherDetails.diesInExtremistsDacoitsSmugglerAntisocialAttack=ProcessInstances[i].employeeOtherDetails.diesInExtremistsDacoitsSmugglerAntisocialAttack?ProcessInstances[i].employeeOtherDetails.diesInExtremistsDacoitsSmugglerAntisocialAttack:false,
              ProcessInstances[i].employeeOtherDetails.isCompassionatePensionGranted=ProcessInstances[i].employeeOtherDetails.isCompassionatePensionGranted?ProcessInstances[i].employeeOtherDetails.isCompassionatePensionGranted:false,
              ProcessInstances[i].employeeOtherDetails.totalNoPayLeavesMonths=ProcessInstances[i].employeeOtherDetails.totalNoPayLeavesMonths? Number(ProcessInstances[i].employeeOtherDetails.totalNoPayLeavesMonths):0,
              ProcessInstances[i].employeeOtherDetails.totalNoPayLeavesYears=ProcessInstances[i].employeeOtherDetails.totalNoPayLeavesYears? Number(ProcessInstances[i].employeeOtherDetails.totalNoPayLeavesYears):0,
              ProcessInstances[i].employeeOtherDetails.noDuesForAvailGovtAccomodation=ProcessInstances[i].employeeOtherDetails.noDuesForAvailGovtAccomodation?ProcessInstances[i].employeeOtherDetails.noDuesForAvailGovtAccomodation:false,
              ProcessInstances[i].employeeOtherDetails.employeeGroup=ProcessInstances[i].employeeOtherDetails.employeeGroup? ProcessInstances[i].employeeOtherDetails.employeeGroup:null
              ProcessInstances[i].employeeOtherDetails.employeeOtherDetailsAudit={
                employeeOtherDetailsAuditId: uuidv1()   
              };
            }         
            
            //pensionCalculationDetails
            if(ProcessInstances[i].pensionCalculationDetails){            
              ProcessInstances[i].pensionCalculationDetails.basicPensionSystem=ProcessInstances[i].pensionCalculationDetails.basicPensionSystem!=null? Number(ProcessInstances[i].pensionCalculationDetails.basicPensionSystem):null,
              ProcessInstances[i].pensionCalculationDetails.pensionDeductionsSystem=ProcessInstances[i].pensionCalculationDetails.pensionDeductionsSystem!=null? Number(ProcessInstances[i].pensionCalculationDetails.pensionDeductionsSystem):null,
              ProcessInstances[i].pensionCalculationDetails.additionalPensionSystem=ProcessInstances[i].pensionCalculationDetails.additionalPensionSystem!=null? Number(ProcessInstances[i].pensionCalculationDetails.additionalPensionSystem):null,
              ProcessInstances[i].pensionCalculationDetails.commutedPensionSystem=ProcessInstances[i].pensionCalculationDetails.commutedPensionSystem!=null? Number(ProcessInstances[i].pensionCalculationDetails.commutedPensionSystem):null,
              ProcessInstances[i].pensionCalculationDetails.commutedValueSystem=ProcessInstances[i].pensionCalculationDetails.commutedValueSystem!=null? Number(ProcessInstances[i].pensionCalculationDetails.commutedValueSystem):null,
              ProcessInstances[i].pensionCalculationDetails.familyPensionISystem=ProcessInstances[i].pensionCalculationDetails.familyPensionISystem!=null? Number(ProcessInstances[i].pensionCalculationDetails.familyPensionISystem):null,
              ProcessInstances[i].pensionCalculationDetails.familyPensionIISystem=ProcessInstances[i].pensionCalculationDetails.familyPensionIISystem!=null?Number(ProcessInstances[i].pensionCalculationDetails.familyPensionIISystem):null,
              ProcessInstances[i].pensionCalculationDetails.dcrgSystem=ProcessInstances[i].pensionCalculationDetails.dcrgSystem!=null? Number(ProcessInstances[i].pensionCalculationDetails.dcrgSystem):null,
              ProcessInstances[i].pensionCalculationDetails.netDeductionsSystem=ProcessInstances[i].pensionCalculationDetails.netDeductionsSystem!=null? Number(ProcessInstances[i].pensionCalculationDetails.netDeductionsSystem):null,
              ProcessInstances[i].pensionCalculationDetails.finalCalculatedPensionSystem=ProcessInstances[i].pensionCalculationDetails.finalCalculatedPensionSystem!=null? Number(ProcessInstances[i].pensionCalculationDetails.finalCalculatedPensionSystem):null,
              ProcessInstances[i].pensionCalculationDetails.interimReliefSystem=ProcessInstances[i].pensionCalculationDetails.interimReliefSystem!=null? Number(ProcessInstances[i].pensionCalculationDetails.interimReliefSystem):null,
              ProcessInstances[i].pensionCalculationDetails.daSystem=ProcessInstances[i].pensionCalculationDetails.daSystem!=null? Number(ProcessInstances[i].pensionCalculationDetails.daSystem):null,
              ProcessInstances[i].pensionCalculationDetails.nqsYearSystem=ProcessInstances[i].pensionCalculationDetails.nqsYearSystem!=null? Number(ProcessInstances[i].pensionCalculationDetails.nqsYearSystem):null,
              ProcessInstances[i].pensionCalculationDetails.nqsMonthSystem=ProcessInstances[i].pensionCalculationDetails.nqsMonthSystem!=null? Number(ProcessInstances[i].pensionCalculationDetails.nqsMonthSystem):null,
              ProcessInstances[i].pensionCalculationDetails.nqsDaySystem=ProcessInstances[i].pensionCalculationDetails.nqsDaySystem!=null? Number(ProcessInstances[i].pensionCalculationDetails.nqsDaySystem):null,
              ProcessInstances[i].pensionCalculationDetails.duesDeductionsSystem=ProcessInstances[i].pensionCalculationDetails.duesDeductionsSystem!=null? Number(ProcessInstances[i].pensionCalculationDetails.duesDeductionsSystem):null,
              ProcessInstances[i].pensionCalculationDetails.compassionatePensionSystem=ProcessInstances[i].pensionCalculationDetails.compassionatePensionSystem!=null? Number(ProcessInstances[i].pensionCalculationDetails.compassionatePensionSystem):null,
              ProcessInstances[i].pensionCalculationDetails.compensationPensionSystem=ProcessInstances[i].pensionCalculationDetails.compensationPensionSystem!=null? Number(ProcessInstances[i].pensionCalculationDetails.compensationPensionSystem):null,
              ProcessInstances[i].pensionCalculationDetails.terminalBenefitSystem=ProcessInstances[i].pensionCalculationDetails.terminalBenefitSystem!=null? Number(ProcessInstances[i].pensionCalculationDetails.terminalBenefitSystem):null,
              ProcessInstances[i].pensionCalculationDetails.finalCalculatedGratuitySystem=ProcessInstances[i].pensionCalculationDetails.finalCalculatedGratuitySystem!=null? Number(ProcessInstances[i].pensionCalculationDetails.finalCalculatedGratuitySystem):null,            
              ProcessInstances[i].pensionCalculationDetails.familyPensionIStartDateSystem=intConversion(ProcessInstances[i].pensionCalculationDetails.familyPensionIStartDateSystem),
              ProcessInstances[i].pensionCalculationDetails.familyPensionIEndDateSystem=intConversion(ProcessInstances[i].pensionCalculationDetails.familyPensionIEndDateSystem),
              ProcessInstances[i].pensionCalculationDetails.familyPensionIIStartDateSystem=intConversion(ProcessInstances[i].pensionCalculationDetails.familyPensionIIStartDateSystem),
              ProcessInstances[i].pensionCalculationDetails.exGratiaSystem=ProcessInstances[i].pensionCalculationDetails.exGratiaSystem!=null? Number(ProcessInstances[i].pensionCalculationDetails.exGratiaSystem):null,
              ProcessInstances[i].pensionCalculationDetails.pensionerFamilyPensionSystem=ProcessInstances[i].pensionCalculationDetails.pensionerFamilyPensionSystem!=null? Number(ProcessInstances[i].pensionCalculationDetails.pensionerFamilyPensionSystem):null,            
              ProcessInstances[i].pensionCalculationDetails.totalPensionSystem=ProcessInstances[i].pensionCalculationDetails.totalPensionSystem!=null? Number(ProcessInstances[i].pensionCalculationDetails.totalPensionSystem):null,
              ProcessInstances[i].pensionCalculationDetails.provisionalPensionSystem=ProcessInstances[i].pensionCalculationDetails.provisionalPensionSystem!=null? Number(ProcessInstances[i].pensionCalculationDetails.provisionalPensionSystem):null,

              ProcessInstances[i].pensionCalculationDetails.interimReliefApplicable=ProcessInstances[i].pensionCalculationDetails.interimReliefApplicable;
              ProcessInstances[i].pensionCalculationDetails.interimReliefExpression=ProcessInstances[i].pensionCalculationDetails.interimReliefExpression;
              ProcessInstances[i].pensionCalculationDetails.basicPensionApplicable=ProcessInstances[i].pensionCalculationDetails.basicPensionApplicable;
              ProcessInstances[i].pensionCalculationDetails.basicPensionExpression=ProcessInstances[i].pensionCalculationDetails.basicPensionExpression;
              ProcessInstances[i].pensionCalculationDetails.provisionalPensionApplicable=ProcessInstances[i].pensionCalculationDetails.provisionalPensionApplicable;
              ProcessInstances[i].pensionCalculationDetails.provisionalPensionExpression=ProcessInstances[i].pensionCalculationDetails.provisionalPensionExpression;
              ProcessInstances[i].pensionCalculationDetails.compassionatePensionApplicable=ProcessInstances[i].pensionCalculationDetails.compassionatePensionApplicable;
              ProcessInstances[i].pensionCalculationDetails.compassionatePensionExpression=ProcessInstances[i].pensionCalculationDetails.compassionatePensionExpression;
              ProcessInstances[i].pensionCalculationDetails.compensationPensionApplicable=ProcessInstances[i].pensionCalculationDetails.compensationPensionApplicable;
              ProcessInstances[i].pensionCalculationDetails.compensationPensionExpression=ProcessInstances[i].pensionCalculationDetails.compensationPensionExpression;
              ProcessInstances[i].pensionCalculationDetails.commutedPensionApplicable=ProcessInstances[i].pensionCalculationDetails.commutedPensionApplicable;
              ProcessInstances[i].pensionCalculationDetails.commutedPensionExpression=ProcessInstances[i].pensionCalculationDetails.commutedPensionExpression;
              ProcessInstances[i].pensionCalculationDetails.familyPensionIApplicable=ProcessInstances[i].pensionCalculationDetails.familyPensionIApplicable;
              ProcessInstances[i].pensionCalculationDetails.familyPensionIExpression=ProcessInstances[i].pensionCalculationDetails.familyPensionIExpression;
              ProcessInstances[i].pensionCalculationDetails.familyPensionIIApplicable=ProcessInstances[i].pensionCalculationDetails.familyPensionIIApplicable;
              ProcessInstances[i].pensionCalculationDetails.familyPensionIIExpression=ProcessInstances[i].pensionCalculationDetails.familyPensionIIExpression;
              ProcessInstances[i].pensionCalculationDetails.daApplicable=ProcessInstances[i].pensionCalculationDetails.daApplicable;
              ProcessInstances[i].pensionCalculationDetails.daExpression=ProcessInstances[i].pensionCalculationDetails.daExpression;
              ProcessInstances[i].pensionCalculationDetails.additionalPensionApplicable=ProcessInstances[i].pensionCalculationDetails.additionalPensionApplicable;
              ProcessInstances[i].pensionCalculationDetails.additionalPensionExpression=ProcessInstances[i].pensionCalculationDetails.additionalPensionExpression;            
              ProcessInstances[i].pensionCalculationDetails.totalPensionApplicable=ProcessInstances[i].pensionCalculationDetails.totalPensionApplicable;
              ProcessInstances[i].pensionCalculationDetails.totalPensionExpression=ProcessInstances[i].pensionCalculationDetails.totalPensionExpression;
              ProcessInstances[i].pensionCalculationDetails.pensionDeductionsApplicable=ProcessInstances[i].pensionCalculationDetails.pensionDeductionsApplicable;
              ProcessInstances[i].pensionCalculationDetails.pensionDeductionsExpression=ProcessInstances[i].pensionCalculationDetails.pensionDeductionsExpression;
              ProcessInstances[i].pensionCalculationDetails.netDeductionsApplicable=ProcessInstances[i].pensionCalculationDetails.netDeductionsApplicable;
              ProcessInstances[i].pensionCalculationDetails.netDeductionsExpression=ProcessInstances[i].pensionCalculationDetails.netDeductionsExpression;
              ProcessInstances[i].pensionCalculationDetails.finalCalculatedPensionApplicable=ProcessInstances[i].pensionCalculationDetails.finalCalculatedPensionApplicable;
              ProcessInstances[i].pensionCalculationDetails.finalCalculatedPensionExpression=ProcessInstances[i].pensionCalculationDetails.finalCalculatedPensionExpression;
              ProcessInstances[i].pensionCalculationDetails.commutationValueApplicable=ProcessInstances[i].pensionCalculationDetails.commutationValueApplicable;
              ProcessInstances[i].pensionCalculationDetails.commutationValueExpression=ProcessInstances[i].pensionCalculationDetails.commutationValueExpression;
              ProcessInstances[i].pensionCalculationDetails.dcrgApplicable=ProcessInstances[i].pensionCalculationDetails.dcrgApplicable;
              ProcessInstances[i].pensionCalculationDetails.dcrgExpression=ProcessInstances[i].pensionCalculationDetails.dcrgExpression;
              ProcessInstances[i].pensionCalculationDetails.terminalBenefitApplicable=ProcessInstances[i].pensionCalculationDetails.terminalBenefitApplicable;
              ProcessInstances[i].pensionCalculationDetails.terminalBenefitExpression=ProcessInstances[i].pensionCalculationDetails.terminalBenefitExpression;
              ProcessInstances[i].pensionCalculationDetails.duesDeductionsApplicable=ProcessInstances[i].pensionCalculationDetails.duesDeductionsApplicable;
              ProcessInstances[i].pensionCalculationDetails.duesDeductionsExpression=ProcessInstances[i].pensionCalculationDetails.duesDeductionsExpression;
              ProcessInstances[i].pensionCalculationDetails.finalCalculatedGratuityApplicable=ProcessInstances[i].pensionCalculationDetails.finalCalculatedGratuityApplicable;
              ProcessInstances[i].pensionCalculationDetails.finalCalculatedGratuityExpression=ProcessInstances[i].pensionCalculationDetails.finalCalculatedGratuityExpression;
              ProcessInstances[i].pensionCalculationDetails.exGratiaApplicable=ProcessInstances[i].pensionCalculationDetails.exGratiaApplicable;
              ProcessInstances[i].pensionCalculationDetails.exGratiaExpression=ProcessInstances[i].pensionCalculationDetails.exGratiaExpression;
              ProcessInstances[i].pensionCalculationDetails.pensionerFamilyPensionApplicable=ProcessInstances[i].pensionCalculationDetails.pensionerFamilyPensionApplicable;
              ProcessInstances[i].pensionCalculationDetails.pensionerFamilyPensionExpression=ProcessInstances[i].pensionCalculationDetails.pensionerFamilyPensionExpression;

              ProcessInstances[i].pensionCalculationDetails.invalidPensionSystem=ProcessInstances[i].pensionCalculationDetails.invalidPensionSystem!=null? Number(ProcessInstances[i].pensionCalculationDetails.invalidPensionSystem):null;
              ProcessInstances[i].pensionCalculationDetails.woundExtraordinaryPensionSystem=ProcessInstances[i].pensionCalculationDetails.woundExtraordinaryPensionSystem!=null? Number(ProcessInstances[i].pensionCalculationDetails.woundExtraordinaryPensionSystem):null;
              ProcessInstances[i].pensionCalculationDetails.attendantAllowanceSystem=ProcessInstances[i].pensionCalculationDetails.attendantAllowanceSystem!=null? Number(ProcessInstances[i].pensionCalculationDetails.attendantAllowanceSystem):null;            

              ProcessInstances[i].pensionCalculationDetails.invalidPensionApplicable=ProcessInstances[i].pensionCalculationDetails.invalidPensionApplicable;
              ProcessInstances[i].pensionCalculationDetails.invalidPensionExpression=ProcessInstances[i].pensionCalculationDetails.invalidPensionExpression;

              ProcessInstances[i].pensionCalculationDetails.woundExtraordinaryPensionApplicable=ProcessInstances[i].pensionCalculationDetails.woundExtraordinaryPensionApplicable;
              ProcessInstances[i].pensionCalculationDetails.woundExtraordinaryPensionExpression=ProcessInstances[i].pensionCalculationDetails.woundExtraordinaryPensionExpression;

              ProcessInstances[i].pensionCalculationDetails.attendantAllowanceApplicable=ProcessInstances[i].pensionCalculationDetails.attendantAllowanceApplicable;
              ProcessInstances[i].pensionCalculationDetails.attendantAllowanceExpression=ProcessInstances[i].pensionCalculationDetails.attendantAllowanceExpression;

              ProcessInstances[i].pensionCalculationDetails.gqsYearSystem=Number(ProcessInstances[i].pensionCalculationDetails.gqsYearSystem);
              ProcessInstances[i].pensionCalculationDetails.gqsMonthSystem=Number(ProcessInstances[i].pensionCalculationDetails.gqsMonthSystem);
              ProcessInstances[i].pensionCalculationDetails.gqsDaySystem=Number(ProcessInstances[i].pensionCalculationDetails.gqsDaySystem);


              ProcessInstances[i].pensionCalculationDetails.pensionCalculationDetailsAudit={
                pensionCalculationDetailsAuditId: uuidv1()  //eg_pension_calculation_details_audit table only, rest of the data for pensionCalculationDetails object comes from ui
              };
            }  

            //pensionCalculationUpdateDetails
            if(ProcessInstances[i].pensionCalculationUpdateDetails){            
              ProcessInstances[i].pensionCalculationUpdateDetails.basicPensionVerified=ProcessInstances[i].pensionCalculationUpdateDetails.basicPensionVerified!=null? Number(ProcessInstances[i].pensionCalculationUpdateDetails.basicPensionVerified):null,
              ProcessInstances[i].pensionCalculationUpdateDetails.pensionDeductionsVerified=ProcessInstances[i].pensionCalculationUpdateDetails.pensionDeductionsVerified!=null? Number(ProcessInstances[i].pensionCalculationUpdateDetails.pensionDeductionsVerified):null,
              ProcessInstances[i].pensionCalculationUpdateDetails.additionalPensionVerified=ProcessInstances[i].pensionCalculationUpdateDetails.additionalPensionVerified!=null? Number(ProcessInstances[i].pensionCalculationUpdateDetails.additionalPensionVerified):null,
              ProcessInstances[i].pensionCalculationUpdateDetails.commutedPensionVerified=ProcessInstances[i].pensionCalculationUpdateDetails.commutedPensionVerified!=null? Number(ProcessInstances[i].pensionCalculationUpdateDetails.commutedPensionVerified):null,
              ProcessInstances[i].pensionCalculationUpdateDetails.commutedValueVerified=ProcessInstances[i].pensionCalculationUpdateDetails.commutedValueVerified!=null? Number(ProcessInstances[i].pensionCalculationUpdateDetails.commutedValueVerified):null,
              ProcessInstances[i].pensionCalculationUpdateDetails.familyPensionIVerified=ProcessInstances[i].pensionCalculationUpdateDetails.familyPensionIVerified!=null? Number(ProcessInstances[i].pensionCalculationUpdateDetails.familyPensionIVerified):null,
              ProcessInstances[i].pensionCalculationUpdateDetails.familyPensionIIVerified=ProcessInstances[i].pensionCalculationUpdateDetails.familyPensionIIVerified!=null? Number(ProcessInstances[i].pensionCalculationUpdateDetails.familyPensionIIVerified):null,
              ProcessInstances[i].pensionCalculationUpdateDetails.dcrgVerified=ProcessInstances[i].pensionCalculationUpdateDetails.dcrgVerified!=null? Number(ProcessInstances[i].pensionCalculationUpdateDetails.dcrgVerified):null,
              ProcessInstances[i].pensionCalculationUpdateDetails.netDeductionsVerified=ProcessInstances[i].pensionCalculationUpdateDetails.netDeductionsVerified!=null? Number(ProcessInstances[i].pensionCalculationUpdateDetails.netDeductionsVerified):null,
              ProcessInstances[i].pensionCalculationUpdateDetails.finalCalculatedPensionVerified=ProcessInstances[i].pensionCalculationUpdateDetails.finalCalculatedPensionVerified!=null? Number(ProcessInstances[i].pensionCalculationUpdateDetails.finalCalculatedPensionVerified):null,
              ProcessInstances[i].pensionCalculationUpdateDetails.interimReliefVerified=ProcessInstances[i].pensionCalculationUpdateDetails.interimReliefVerified!=null? Number(ProcessInstances[i].pensionCalculationUpdateDetails.interimReliefVerified):null,
              ProcessInstances[i].pensionCalculationUpdateDetails.daVerified=ProcessInstances[i].pensionCalculationUpdateDetails.daVerified!=null? Number(ProcessInstances[i].pensionCalculationUpdateDetails.daVerified):null,
              ProcessInstances[i].pensionCalculationUpdateDetails.nqsYearVerified=ProcessInstances[i].pensionCalculationUpdateDetails.nqsYearVerified!=null? Number(ProcessInstances[i].pensionCalculationUpdateDetails.nqsYearVerified):null,
              ProcessInstances[i].pensionCalculationUpdateDetails.nqsMonthVerified=ProcessInstances[i].pensionCalculationUpdateDetails.nqsMonthVerified!=null? Number(ProcessInstances[i].pensionCalculationUpdateDetails.nqsMonthVerified):null,
              ProcessInstances[i].pensionCalculationUpdateDetails.nqsDayVerified=ProcessInstances[i].pensionCalculationUpdateDetails.nqsDayVerified!=null? Number(ProcessInstances[i].pensionCalculationUpdateDetails.nqsDayVerified):null,
              ProcessInstances[i].pensionCalculationUpdateDetails.duesDeductionsVerified=ProcessInstances[i].pensionCalculationUpdateDetails.duesDeductionsVerified!=null? Number(ProcessInstances[i].pensionCalculationUpdateDetails.duesDeductionsVerified):null,
              ProcessInstances[i].pensionCalculationUpdateDetails.compassionatePensionVerified=ProcessInstances[i].pensionCalculationUpdateDetails.compassionatePensionVerified!=null? Number(ProcessInstances[i].pensionCalculationUpdateDetails.compassionatePensionVerified):null,
              ProcessInstances[i].pensionCalculationUpdateDetails.compensationPensionVerified=ProcessInstances[i].pensionCalculationUpdateDetails.compensationPensionVerified!=null? Number(ProcessInstances[i].pensionCalculationUpdateDetails.compensationPensionVerified):null,
              ProcessInstances[i].pensionCalculationUpdateDetails.terminalBenefitVerified=ProcessInstances[i].pensionCalculationUpdateDetails.terminalBenefitVerified!=null? Number(ProcessInstances[i].pensionCalculationUpdateDetails.terminalBenefitVerified):null,
              ProcessInstances[i].pensionCalculationUpdateDetails.finalCalculatedGratuityVerified=ProcessInstances[i].pensionCalculationUpdateDetails.finalCalculatedGratuityVerified!=null? Number(ProcessInstances[i].pensionCalculationUpdateDetails.finalCalculatedGratuityVerified):null,            
              ProcessInstances[i].pensionCalculationUpdateDetails.familyPensionIStartDateVerified=intConversion(ProcessInstances[i].pensionCalculationUpdateDetails.familyPensionIStartDateVerified),
              ProcessInstances[i].pensionCalculationUpdateDetails.familyPensionIEndDateVerified=intConversion(ProcessInstances[i].pensionCalculationUpdateDetails.familyPensionIEndDateVerified);
              ProcessInstances[i].pensionCalculationUpdateDetails.familyPensionIIStartDateVerified=intConversion(ProcessInstances[i].pensionCalculationUpdateDetails.familyPensionIIStartDateVerified);
              ProcessInstances[i].pensionCalculationUpdateDetails.exGratiaVerified=ProcessInstances[i].pensionCalculationUpdateDetails.exGratiaVerified!=null? Number(ProcessInstances[i].pensionCalculationUpdateDetails.exGratiaVerified):null;
              ProcessInstances[i].pensionCalculationUpdateDetails.pensionerFamilyPensionVerified=ProcessInstances[i].pensionCalculationUpdateDetails.pensionerFamilyPensionVerified!=null? Number(ProcessInstances[i].pensionCalculationUpdateDetails.pensionerFamilyPensionVerified):null;            
              ProcessInstances[i].pensionCalculationUpdateDetails.totalPensionVerified=ProcessInstances[i].pensionCalculationUpdateDetails.totalPensionVerified!=null? Number(ProcessInstances[i].pensionCalculationUpdateDetails.totalPensionVerified):null;
              ProcessInstances[i].pensionCalculationUpdateDetails.provisionalPensionVerified=ProcessInstances[i].pensionCalculationUpdateDetails.provisionalPensionVerified!=null? Number(ProcessInstances[i].pensionCalculationUpdateDetails.provisionalPensionVerified):null;
              
              ProcessInstances[i].pensionCalculationUpdateDetails.invalidPensionVerified=ProcessInstances[i].pensionCalculationUpdateDetails.invalidPensionVerified!=null? Number(ProcessInstances[i].pensionCalculationUpdateDetails.invalidPensionVerified):null;
              ProcessInstances[i].pensionCalculationUpdateDetails.woundExtraordinaryPensionVerified=ProcessInstances[i].pensionCalculationUpdateDetails.woundExtraordinaryPensionVerified!=null? Number(ProcessInstances[i].pensionCalculationUpdateDetails.woundExtraordinaryPensionVerified):null;
              ProcessInstances[i].pensionCalculationUpdateDetails.attendantAllowanceVerified=ProcessInstances[i].pensionCalculationUpdateDetails.attendantAllowanceVerified!=null? Number(ProcessInstances[i].pensionCalculationUpdateDetails.attendantAllowanceVerified):null;           

              ProcessInstances[i].pensionCalculationUpdateDetails.gqsYearVerified=Number(ProcessInstances[i].pensionCalculationUpdateDetails.gqsYearVerified);
              ProcessInstances[i].pensionCalculationUpdateDetails.gqsMonthVerified=Number(ProcessInstances[i].pensionCalculationUpdateDetails.gqsMonthVerified);
              ProcessInstances[i].pensionCalculationUpdateDetails.gqsDayVerified=Number(ProcessInstances[i].pensionCalculationUpdateDetails.gqsDayVerified);
            }  

            //dependents          
            if(ProcessInstances[i].dependents)
            {                  
              for (var j = 0; j < ProcessInstances[i].dependents.length; j++)  
              {
                dependents.push(
                  {
                    dependentId: uuidv1(),
                    tenantId: ProcessInstances[i].tenantId,
                    pensionEmployeeId: ProcessInstances[i].employee.pensionEmployeeId,
                    name: ProcessInstances[i].dependents[j].name,
                    dob: Number(ProcessInstances[i].dependents[j].dob),
                    address: ProcessInstances[i].dependents[j].address,                
                    mobileNumber: ProcessInstances[i].dependents[j].mobileNumber, 
                    relationship: ProcessInstances[i].dependents[j].relationship,
                    isDisabled: ProcessInstances[i].dependents[j].isDisabled?ProcessInstances[i].dependents[j].isDisabled:false,
                    maritalStatus: ProcessInstances[i].dependents[j].maritalStatus?ProcessInstances[i].dependents[j].maritalStatus:null,
                    isHollyDependent: ProcessInstances[i].dependents[j].isHollyDependent?ProcessInstances[i].dependents[j].isHollyDependent:false,
                    noSpouseNoChildren: ProcessInstances[i].dependents[j].noSpouseNoChildren?ProcessInstances[i].dependents[j].noSpouseNoChildren:false,
                    isGrandChildFromDeceasedSon: ProcessInstances[i].dependents[j].isGrandChildFromDeceasedSon?ProcessInstances[i].dependents[j].isGrandChildFromDeceasedSon:false,
                    isEligibleForGratuity: ProcessInstances[i].dependents[j].isEligibleForGratuity?ProcessInstances[i].dependents[j].isEligibleForGratuity:false,
                    isEligibleForPension: ProcessInstances[i].dependents[j].isEligibleForPension?ProcessInstances[i].dependents[j].isEligibleForPension:false,
                    gratuityPercentage: ProcessInstances[i].dependents[j].gratuityPercentage?Number(ProcessInstances[i].dependents[j].gratuityPercentage):0,                                                              
                    bankAccountNumber: ProcessInstances[i].dependents[j].bankAccountNumber,
                    bankDetails: ProcessInstances[i].dependents[j].bankDetails,
                    bankCode: ProcessInstances[i].dependents[j].bankCode,
                    bankIfsc: ProcessInstances[i].dependents[j].bankIfsc,
                    active: true,
                    dependentAudit: {                
                      dependentAuditId: uuidv1(),                  
                    },
                    auditDetails: auditDetails
                  }
                );       
              } 
            }

            if(ProcessInstances[0].pensionArrears){
            let pensionArrear = {};
      for(var i = 0; i<ProcessInstances[0].pensionArrears.length; i++){
        pensionArrear = ProcessInstances[0].pensionArrears[i];
        pensionArrear.pensionArrearId = uuidv1();
        pensionArrear.tenantId = ProcessInstances[0].tenantId;
        pensionArrear.workflowHeaderId = ProcessInstances[0].workflowHeader.workflowHeaderId;
        pensionArrear.createdBy = createdBy;
        pensionArrear.createdDate = createdDate;
      }
    }
                    
            ProcessInstances[i].documents=documents;               
            ProcessInstances[i].dependents=dependents;   
            ProcessInstances[i].auditDetails = auditDetails;
          }   
      

  }
        
  request.ProcessInstances = ProcessInstances;
  return request;
};

export const addUUIDAndAuditDetailsClaimReleaseWorkflow = async (request) => {
  let { ProcessInstances, RequestInfo } = request;
 
  let createdBy = get(RequestInfo, "userInfo.uuid", "");    
  let createdDate = new Date().getTime(); 
  let auditDetails = {
    createdBy: createdBy,       
    lastModifiedBy: null,        
    createdDate: createdDate,        
    lastModifiedDate: null        
  }; 
  for (var i = 0; i < ProcessInstances.length; i++) {  
    let workflowHeader={     
      workflowHeaderAudit: {
        workflowHeaderAuditId: uuidv1()
      }      
    }
    ProcessInstances[i].workflowHeader=workflowHeader;     
    ProcessInstances[i].auditDetails = auditDetails;
  }
  request.ProcessInstances = ProcessInstances;
  return request;

};

export const addUUIDAndAuditDetailsCreateRevisedPension = async (request) => {
  let { ProcessInstances, RequestInfo } = request;
 
  let createdBy = get(RequestInfo, "userInfo.uuid", "");    
  let createdDate = new Date().getTime(); 
  let auditDetails = {
    createdBy: createdBy,       
    lastModifiedBy: null,        
    createdDate: createdDate,        
    lastModifiedDate: null        
  }; 
  
  for (var i = 0; i < ProcessInstances.length; i++) {      
    let pensionRevision=ProcessInstances[i].pensionRevision;//new revised pension

    for (var j = 0; j< pensionRevision.length; j++) {   
      pensionRevision[j].tenantId=ProcessInstances[0].tenantId;
      pensionRevision[j].pensionerId=ProcessInstances[0].pensioner.pensionerId, 
      pensionRevision[j].pensionRevisionId=uuidv1();
      pensionRevision[j].effectiveStartYear=Number(pensionRevision[j].effectiveStartYear);
      pensionRevision[j].effectiveStartMonth=Number(pensionRevision[j].effectiveStartMonth);
      pensionRevision[j].effectiveEndYear=pensionRevision[j].effectiveEndYear==null?null:Number(pensionRevision[j].effectiveEndYear);
      pensionRevision[j].effectiveEndMonth=pensionRevision[j].effectiveEndMonth==null?null:Number(pensionRevision[j].effectiveEndMonth);
      pensionRevision[j].pensionArrear=Number( pensionRevision[j].pensionArrear);
      //revisedPension[j].medicalRelief=Number( revisedPension[j].medicalRelief);
      pensionRevision[j].fma=Number( pensionRevision[j].fma);
      pensionRevision[j].miscellaneous=Number( pensionRevision[j].miscellaneous);
      pensionRevision[j].overPayment=Number( pensionRevision[j].overPayment);
      pensionRevision[j].incomeTax=Number( pensionRevision[j].incomeTax);
      pensionRevision[j].cess=Number( pensionRevision[j].cess);
      pensionRevision[j].basicPension=Number( pensionRevision[j].basicPension);
      pensionRevision[j].da=Number( pensionRevision[j].da);
      pensionRevision[j].commutedPension=Number( pensionRevision[j].commutedPension);
      pensionRevision[j].netDeductions=Number( pensionRevision[j].netDeductions);
      pensionRevision[j].finalCalculatedPension=Number( pensionRevision[j].finalCalculatedPension);
      pensionRevision[j].additionalPension=Number( pensionRevision[j].additionalPension);
      pensionRevision[j].interimRelief=Number( pensionRevision[j].interimRelief);
      pensionRevision[j].totalPension=Number( pensionRevision[j].totalPension);
      pensionRevision[j].pensionDeductions=Number( pensionRevision[j].pensionDeductions);
      pensionRevision[j].woundExtraordinaryPension=pensionRevision[j].woundExtraordinaryPension!=null? Number(pensionRevision[j].woundExtraordinaryPension):null; 
      pensionRevision[j].attendantAllowance=pensionRevision[j].attendantAllowance!=null? Number(pensionRevision[j].attendantAllowance):null;
      pensionRevision[j].pensionerFinalCalculatedBenefitId= ProcessInstances[i].pensioner.pensionerFinalCalculatedBenefitId;
      pensionRevision[j].pensionRevisionAuditId=uuidv1();
      pensionRevision[j].auditDetails = auditDetails;
    }   
    ProcessInstances[i].pensionRevision=pensionRevision;     
    
  }
  request.ProcessInstances = ProcessInstances;
  return request;

};

export const addUUIDAndAuditDetailsCloseLastRevisedPension = async (request) => {
  let { ProcessInstances, RequestInfo } = request;
 
  let createdBy = get(RequestInfo, "userInfo.uuid", "");    
  let createdDate = new Date().getTime(); 
  let auditDetails = {
    createdBy: createdBy,       
    lastModifiedBy: null,        
    createdDate: createdDate,        
    lastModifiedDate: null        
  }; 
  
  for (var i = 0; i < ProcessInstances.length; i++) {  
    let lastPensionRevision=ProcessInstances[i].lastPensionRevision;//last revised pension

    let pensionRevision=ProcessInstances[i].pensionRevision;//new or to be updated revised pension
    let effectiveStartYear=Number(pensionRevision[0].effectiveStartYear) ;
    let effectiveStartMonth=Number(pensionRevision[0].effectiveStartMonth) ;
    let lastRevisedPensionEffectiveEndYear;
    let lastRevisedPensionEffectiveEndMonth;
    if(effectiveStartMonth==1){
      lastRevisedPensionEffectiveEndYear=effectiveStartYear-1;
      lastRevisedPensionEffectiveEndMonth=12;      
    }
    else{
      lastRevisedPensionEffectiveEndYear=effectiveStartYear;
      lastRevisedPensionEffectiveEndMonth=effectiveStartMonth-1;
    }


    for (var j = 0; j< lastPensionRevision.length; j++) {           
      lastPensionRevision[j].effectiveEndYear=lastRevisedPensionEffectiveEndYear;
      lastPensionRevision[j].effectiveEndMonth=lastRevisedPensionEffectiveEndMonth;      
      lastPensionRevision[j].pensionRevisionAuditId=uuidv1();
      lastPensionRevision[j].auditDetails = auditDetails;
    }   
    ProcessInstances[i].lastPensionRevision=lastPensionRevision;     
    
  }
  request.ProcessInstances = ProcessInstances;
  return request;

};

export const addUUIDAndAuditDetailsUpdateRevisedPension = async (request) => {
  let { ProcessInstances, RequestInfo } = request;
 
  let createdBy = get(RequestInfo, "userInfo.uuid", "");    
  let createdDate = new Date().getTime(); 
  let auditDetails = {
    createdBy: createdBy,       
    lastModifiedBy: null,        
    createdDate: createdDate,        
    lastModifiedDate: null        
  }; 
  
  for (var i = 0; i < ProcessInstances.length; i++) {  
    let pensionRevision=ProcessInstances[i].pensionRevision;//last revised pension
    for (var j = 0; j< pensionRevision.length; j++) {        
      pensionRevision[j].effectiveStartYear=Number( pensionRevision[j].effectiveStartYear);
      pensionRevision[j].effectiveStartMonth=Number( pensionRevision[j].effectiveStartMonth);
      pensionRevision[j].effectiveEndYear=null;
      pensionRevision[j].effectiveEndMonth=null;
      pensionRevision[j].pensionArrear=Number( pensionRevision[j].pensionArrear);
      //pensionRevision[j].medicalRelief=Number( pensionRevision[j].medicalRelief);
      pensionRevision[j].fma=Number(pensionRevision[j].fma);
      pensionRevision[j].miscellaneous=Number( pensionRevision[j].miscellaneous);
      pensionRevision[j].overPayment=Number( pensionRevision[j].overPayment);
      pensionRevision[j].incomeTax=Number( pensionRevision[j].incomeTax);
      pensionRevision[j].cess=Number( pensionRevision[j].cess);
      pensionRevision[j].basicPension=Number( pensionRevision[j].basicPension);
      pensionRevision[j].da=Number( pensionRevision[j].da);
      pensionRevision[j].commutedPension=Number( pensionRevision[j].commutedPension);
      pensionRevision[j].netDeductions=Number( pensionRevision[j].netDeductions);
      pensionRevision[j].finalCalculatedPension=Number( pensionRevision[j].finalCalculatedPension);
      pensionRevision[j].additionalPension=Number( pensionRevision[j].additionalPension);
      pensionRevision[j].interimRelief=Number( pensionRevision[j].interimRelief);
      pensionRevision[j].totalPension=Number( pensionRevision[j].totalPension);
      pensionRevision[j].pensionDeductions=Number( pensionRevision[j].pensionDeductions);      
      pensionRevision[j].woundExtraordinaryPension=pensionRevision[j].woundExtraordinaryPension!=null? Number(pensionRevision[j].woundExtraordinaryPension):null; 
      pensionRevision[j].attendantAllowance=pensionRevision[j].attendantAllowance!=null? Number(pensionRevision[j].attendantAllowance):null;
      pensionRevision[j].pensionRevisionAuditId=uuidv1();
      pensionRevision[j].auditDetails = auditDetails;
    }   
    ProcessInstances[i].pensionRevision=pensionRevision;     
    
  }
  request.ProcessInstances = ProcessInstances;
  return request;

};

export const addUUIDAndAuditDetailsCreateMonthlyPensionRegister = async (request) => {
  let { ProcessInstances, RequestInfo } = request;
 
  let createdBy = get(RequestInfo, "userInfo.uuid", "");    
  let createdDate = new Date().getTime(); 
  let auditDetails = {
    createdBy: createdBy,       
    lastModifiedBy: null,        
    createdDate: createdDate,        
    lastModifiedDate: null        
  }; 
  
  for (var i = 0; i < ProcessInstances.length; i++) {          

    for (var j = 0; j< ProcessInstances[i].pensionRegister.length; j++) {              
      ProcessInstances[i].pensionRegister[j].pensionRegisterId=uuidv1();      
      ProcessInstances[i].pensionRegister[j].pensionRegisterAuditId=uuidv1();
      ProcessInstances[i].pensionRegister[j].auditDetails = auditDetails;      
    }   
     
    ProcessInstances[i].auditDetails = auditDetails;       
  }
  request.ProcessInstances = ProcessInstances;
  return request;

};

export const addUUIDAndAuditDetailsCloseWorkflow = async (request,workflowSearchResponse) => {
  let { ProcessInstances, RequestInfo } = request;
 
  let createdBy = get(RequestInfo, "userInfo.uuid", "");    
  let createdDate = new Date().getTime(); 
  let auditDetails = {
    createdBy: createdBy,       
    lastModifiedBy: null,        
    createdDate: createdDate,        
    lastModifiedDate: null        
  }; 
  
  for (var i = 0; i < ProcessInstances.length; i++) {      
    ProcessInstances[i].workflowHeaderId=workflowSearchResponse.ProcessInstances[0].workflowHeader.workflowHeaderId;     
    ProcessInstances[i].pensionEmployeeId=workflowSearchResponse.ProcessInstances[0].employee.pensionEmployeeId; 
    ProcessInstances[i].pensionerId=uuidv1();//eg_pension_pensioner
    ProcessInstances[i].pensionerAuditId=uuidv1();//eg_pension_pensioner_audit
    ProcessInstances[i].pensionerFinalCalculatedBenefitId=uuidv1();//eg_pension_pensioner_final_calculated_benefit
    ProcessInstances[i].pensionRevisionId=uuidv1();//eg_pension_revision
    ProcessInstances[i].pensionRevisionAuditId=uuidv1();//eg_pension_revision_audit
    //ProcessInstances[i].workflowHeaderAuditId=uuidv1();//eg_pension_workflow_header_audit
    ProcessInstances[i].employeeOtherDetailsAuditId=uuidv1();//eg_pension_employee_other_details_audit
    ProcessInstances[i].pensionerApplicationDetailsId=uuidv1();//eg_pension_pensioner_application_details
    ProcessInstances[i].auditDetails = auditDetails;
    ProcessInstances[i].dependentId=null;    
    ProcessInstances[i].effectiveEndYear=null; 
    ProcessInstances[i].effectiveEndMonth=null; 
    ProcessInstances[i].pensionArrear=workflowSearchResponse.ProcessInstances[0].employeeOtherDetails.pensionArrear; 
    //ProcessInstances[i].medicalRelief=workflowSearchResponse.ProcessInstances[0].employeeOtherDetails.medicalRelief; 
    ProcessInstances[i].fma=workflowSearchResponse.ProcessInstances[0].employeeOtherDetails.fma; 
    ProcessInstances[i].miscellaneous=workflowSearchResponse.ProcessInstances[0].employeeOtherDetails.miscellaneous; 
    ProcessInstances[i].overPayment=workflowSearchResponse.ProcessInstances[0].employeeOtherDetails.overPayment; 
    ProcessInstances[i].incomeTax=workflowSearchResponse.ProcessInstances[0].employeeOtherDetails.incomeTax; 
    ProcessInstances[i].cess=workflowSearchResponse.ProcessInstances[0].employeeOtherDetails.cess; 
    ProcessInstances[i].pensionerNumber = await addIDGenId(RequestInfo, [
      {
        idName: envVariables.EGOV_IDGEN_PENSION_PENSIONER_NUMBER_ID_NAME,
        tenantId: ProcessInstances[i].tenantId,
        format: envVariables.EGOV_PN_APPLICATION_FORMATE,
        count: 1
      }
    ]);  
    let effectiveStartDate=new Date();
    switch(workflowSearchResponse.ProcessInstances[0].businessService){
      case envVariables.EGOV_PENSION_RRP_BUSINESS_SERVICE:
        let provisionalPensionVerified=workflowSearchResponse.ProcessInstances[0].pensionCalculationUpdateDetails.provisionalPensionVerified!=null?Number(workflowSearchResponse.ProcessInstances[0].pensionCalculationUpdateDetails.provisionalPensionVerified):0; 
        let compassionatePensionVerified=workflowSearchResponse.ProcessInstances[0].pensionCalculationUpdateDetails.compassionatePensionVerified!=null?Number(workflowSearchResponse.ProcessInstances[0].pensionCalculationUpdateDetails.compassionatePensionVerified):0; 
        let compensationPensionVerified=workflowSearchResponse.ProcessInstances[0].pensionCalculationUpdateDetails.compensationPensionVerified!=null?Number(workflowSearchResponse.ProcessInstances[0].pensionCalculationUpdateDetails.compensationPensionVerified):0; 
        let invalidPensionVerified=workflowSearchResponse.ProcessInstances[0].pensionCalculationUpdateDetails.invalidPensionVerified!=null?Number(workflowSearchResponse.ProcessInstances[0].pensionCalculationUpdateDetails.invalidPensionVerified):0; 
        if(provisionalPensionVerified>0){
          ProcessInstances[i].basicPension=provisionalPensionVerified;
        }
        else if(compassionatePensionVerified>0){
          ProcessInstances[i].basicPension=compassionatePensionVerified;
        }
        else if(compensationPensionVerified>0){
          ProcessInstances[i].basicPension=compensationPensionVerified;
        }
        else if(compensationPensionVerified>0){
          ProcessInstances[i].basicPension=compensationPensionVerified;
        }
        else if(invalidPensionVerified>0){
          ProcessInstances[i].basicPension=invalidPensionVerified;
        }
        else{
          ProcessInstances[i].basicPension=workflowSearchResponse.ProcessInstances[0].pensionCalculationUpdateDetails.basicPensionVerified!=null?Number(workflowSearchResponse.ProcessInstances[0].pensionCalculationUpdateDetails.basicPensionVerified):0; 
        }
        effectiveStartDate=new Date(epochToYmd(intConversion(workflowSearchResponse.ProcessInstances[0].employee.dateOfRetirement)));         
        break;
      case envVariables.EGOV_PENSION_DOE_BUSINESS_SERVICE:
        ProcessInstances[i].basicPension=workflowSearchResponse.ProcessInstances[0].pensionCalculationUpdateDetails.familyPensionIVerified; 
        effectiveStartDate=new Date(epochToYmd(intConversion(workflowSearchResponse.ProcessInstances[0].employee.dateOfDeath)));         
        break;
      case envVariables.EGOV_PENSION_DOP_BUSINESS_SERVICE:
        ProcessInstances[i].basicPension=workflowSearchResponse.ProcessInstances[0].pensionCalculationUpdateDetails.pensionerFamilyPensionVerified; 
        effectiveStartDate=new Date(epochToYmd(intConversion(workflowSearchResponse.ProcessInstances[0].employee.dateOfDeath)));          
        break;

    }

    effectiveStartDate=new Date(effectiveStartDate.getFullYear(),effectiveStartDate.getMonth(),effectiveStartDate.getDate()+1);
    ProcessInstances[i].effectiveStartYear=effectiveStartDate.getFullYear();
    ProcessInstances[i].effectiveStartMonth=effectiveStartDate.getMonth()+1;



    
  }
  request.ProcessInstances = ProcessInstances;
  
  return request;

};

export const addUUIDAndAuditDetailsDisabilityRegistration = async (request) => {
  let { Employees, RequestInfo } = request;
 
  let createdBy = get(RequestInfo, "userInfo.uuid", "");    
  let createdDate = new Date().getTime(); 
  let auditDetails = {
    createdBy: createdBy,       
    lastModifiedBy: null,        
    createdDate: createdDate,        
    lastModifiedDate: null        
  }; 
  
  for (var i = 0; i < Employees.length; i++) {       
    Employees[i].disabilityRegisterId=uuidv1();
    Employees[i].disabilityRegisterAuditId=uuidv1();
    Employees[i].auditDetails=auditDetails;
   
    
  }
  request.Employees = Employees;
  return request;

};

export const addUUIDAndAuditDetailsPensionerPensionDiscontinuation = async (request) => {
  let { ProcessInstances, RequestInfo } = request;
 
  let createdBy = get(RequestInfo, "userInfo.uuid", "");    
  let createdDate = new Date().getTime(); 
  let auditDetails = {
    createdBy: createdBy,       
    lastModifiedBy: null,        
    createdDate: createdDate,        
    lastModifiedDate: null        
  }; 
  
  for (var i = 0; i < ProcessInstances.length; i++) { 
    ProcessInstances[i].auditDetails=auditDetails;      
    }               
  
  request.ProcessInstances = ProcessInstances;
  return request;

};

export const addUUIDAndAuditDetailsInitiateReComputation = async (request) => {
  let { ProcessInstances, RequestInfo } = request; 
  let createdBy = get(RequestInfo, "userInfo.uuid", "");    
  let createdDate = new Date().getTime(); 
  let auditDetails = {
    createdBy: createdBy,       
    lastModifiedBy: null,        
    createdDate: createdDate,        
    lastModifiedDate: null        
  };        
 
  for (var i = 0; i < ProcessInstances.length; i++) { 
    //let applicationFormat;
    let idName="";
    let format="";
    switch(ProcessInstances[i].businessService)
    {
      case envVariables.EGOV_PENSION_RRP_BUSINESS_SERVICE:
        //applicationFormat=envVariables.EGOV_RR_APPLICATION_FORMATE;            
        idName=envVariables.EGOV_IDGEN_PENSION_RRP_APPLICATION_NUMBER_ID_NAME; 
        format= envVariables.EGOV_RR_APPLICATION_FORMATE; 
        break;
      case envVariables.EGOV_PENSION_DOE_BUSINESS_SERVICE:
        //applicationFormat=envVariables.EGOV_DE_APPLICATION_FORMATE;              
        idName=envVariables.EGOV_IDGEN_PENSION_DOE_APPLICATION_NUMBER_ID_NAME;  
        format= envVariables.EGOV_DE_APPLICATION_FORMATE; 
        break;
      case envVariables.EGOV_PENSION_DOP_BUSINESS_SERVICE:
        //applicationFormat=envVariables.EGOV_DP_APPLICATION_FORMATE;          
        idName=envVariables.EGOV_IDGEN_PENSION_DOP_APPLICATION_NUMBER_ID_NAME;
        format= envVariables.EGOV_DP_APPLICATION_FORMATE;   
        break;
    } 
    /*            
    let applicationNumber =await addIDGenId(RequestInfo, [
      {
        tenantId: ProcessInstances[i].tenantId,
        format: applicationFormat
      }
    ]);
    */
    let applicationNumber =await addIDGenId(RequestInfo, [
      {
        idName: idName,
        tenantId: ProcessInstances[i].tenantId, 
        format: format,           
        count: 1
      }
      ]);
    ProcessInstances[i].businessId =applicationNumber;
    
    //workflowHeader object
    let workflowHeader={
      workflowHeaderId: uuidv1(),
      active: true,
      workflowHeaderAudit: {
        workflowHeaderAuditId: uuidv1()
      }
      
    }
    ProcessInstances[i].workflowHeader=workflowHeader;    

    let recomputationRegister={
      recomputationRegisterId: uuidv1(),
      active: true      
    }

    ProcessInstances[i].recomputationRegister=recomputationRegister;  

    let employeeOtherDetails={     
      employeeOtherDetailsId: uuidv1(),    
      active: true,
      employeeOtherDetailsAudit: {
        employeeOtherDetailsAuditId: uuidv1()
      }
      
    };
    ProcessInstances[i].employeeOtherDetails=employeeOtherDetails;

    let pensionCalculationDetails={
      pensionCalculationDetailsId: uuidv1(),                 
      active: true,
      pensionCalculationDetailsAudit: {
        pensionCalculationDetailsAuditId: uuidv1()
      }
      
    };
    ProcessInstances[i].pensionCalculationDetails=pensionCalculationDetails;


    ProcessInstances[i].auditDetails = auditDetails;
  }

  
  request.ProcessInstances = ProcessInstances;
  return request;
};

export const addUUIDAndAuditDetailsMigratedPensioner = async (request) => {  
  let { Pensioner, RequestInfo } = request;
 
  let createdBy = get(RequestInfo, "userInfo.uuid", "");    
  let createdDate = new Date().getTime(); 
  let auditDetails = {
    createdBy: createdBy,       
    lastModifiedBy: null,        
    createdDate: createdDate,        
    lastModifiedDate: null        
  }; 
  
  for (var i = 0; i < Pensioner.length; i++) {    
    if(Pensioner[i].code!=null) {
      Pensioner[i].employeeId = uuidv1(); 
      Pensioner[i].employeeAuditId = uuidv1(); 
      Pensioner[i].employeeContactDetailsId = uuidv1(); 
      Pensioner[i].employeeAssignmentId = uuidv1(); 
      Pensioner[i].employeeServiceHistoryId = uuidv1(); 
      Pensioner[i].dependentId = uuidv1(); 
      Pensioner[i].dependentAuditId = uuidv1(); 
      Pensioner[i].pensionerApplicationDetailsId = uuidv1(); 
      Pensioner[i].pensionerId = uuidv1(); 
      Pensioner[i].pensionerAuditId = uuidv1();       
      Pensioner[i].pensionerFinalCalculatedBenefitId = uuidv1();       
    }
    else{

    }
    
    Pensioner[i].pensionRevisionId = uuidv1(); 
    Pensioner[i].pensionRevisionAuditId = uuidv1();     
    Pensioner[i].auditDetails = auditDetails;       
  }
  request.Pensioner = Pensioner;
  return request;

};


export const addUUIDAndAuditDetailsCreatePensionRevisionBulk = async (request) => {
  let { Parameters, RequestInfo } = request;
 
  let createdBy = get(RequestInfo, "userInfo.uuid", "");    
  let createdDate = new Date().getTime(); 
  let auditDetails = {
    createdBy: createdBy,       
    lastModifiedBy: null,        
    createdDate: createdDate,        
    lastModifiedDate: null        
  }; 
  
  for (var j = 0; j< Parameters.newPensionRevisions.length; j++) {              
    Parameters.newPensionRevisions[j].pensionRevisionId=uuidv1();      
    Parameters.newPensionRevisions[j].pensionRevisionAuditId=uuidv1();
    Parameters.newPensionRevisions[j].auditDetails = auditDetails;      
  }  
  
  for (var j = 0; j< Parameters.oldPensionRevisions.length; j++) {              
    //ProcessInstances[i].oldPensionRevisions[j].pensionRevisionId=uuidv1();    
    Parameters.oldPensionRevisions[j].pensionRevisionAuditId=uuidv1();
    Parameters.oldPensionRevisions[j].auditDetails = auditDetails;      
  }   

  request.Parameters = Parameters;
  return request;

};