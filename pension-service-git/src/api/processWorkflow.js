import { Router } from "express";
import producer from "../kafka/producer";
import { requestInfoToResponseInfo, createWorkFlow ,searchWorkflow,createUserEventToUser,epochToYmd,convertDateToEpoch,uuidv1,getEmployeeDetails,releaseWorkFlow,getPensionEmployees,closeWorkflowByUser,searchApplication,adjust530AddForDeathRegistration, adjust530AddForDob} from "../utils";
import envVariables from "../envVariables";
import mdmsData from "../utils/mdmsData";
import { addUUIDAndAuditDetails } from "../utils/create";
import { Message} from "../utils/message";
import workflowTemplateInterfaceSMS from "../utils/notificaitonTemplateSMS";
import workflowTemplateInterfaceEMAIL from "../utils/notificaitonTemplateEMAIL";
import isEmpty from "lodash/isEmpty";
import set from "lodash/set";
import get from "lodash/get";
import filter from "lodash/filter";
import orderBy from "lodash/orderBy";
import { intConversion} from "../utils/search";
import {encrypt} from "../utils/encryption";

const asyncHandler = require("express-async-handler");

import logger from "../config/logger";

export default ({ config, db }) => {
  let api = Router();
  api.post(
    "/_processWorkflow",
    asyncHandler(async ({ body }, res, next) => {
      let payloads = [];
      
      const message=Message();
     
      let businessService=body.ProcessInstances[0].businessService;
      let action=body.ProcessInstances[0].action;          
      let notificationPayLoadSMS;
      let notificationPayLoadEMAIL;
      let errorMessage="";
                   
      let currentState="";     
      let nextState="" ;
      if(action!=envVariables.EGOV_PENSION_WORKFLOW_ACTION_INITIATE)//workflow exist, then fetch current state
      {        
        let workflowSearchResponse = await searchWorkflow(body.RequestInfo, body.ProcessInstances[0].tenantId,body.ProcessInstances[0].businessId);
        currentState=workflowSearchResponse.ProcessInstances[0].state.state;
        
      }         
      else {      //initiate
        //parallel application checking
        let searchApplicationResponse = await searchApplication(body.RequestInfo,body.ProcessInstances[0].tenantId,body.ProcessInstances[0].employee.code);   
        let applicationList=searchApplicationResponse.Applications;
        if(applicationList.length>0)
           {
          applicationList=filter(applicationList,function(x){return x.state!="CLOSED" && x.state!="REJECTED" ;});          
          if(applicationList.length>0)   
          {
            let errorMessage=message.PARALLEL_WORLFLOW_EXIST_INITIATE_NA;
            errorMessage=errorMessage.replace(/\{0}/g,String(applicationList[0].businessId));
            let errors = errorMessage;
            if (errors.length > 0) {
              next({
                errorType: "custom",
                errorReponse: {
                  ResponseInfo: requestInfoToResponseInfo(
                    body.RequestInfo,
                    true
                  ),
                  Errors: errors
                }
              });
              return;
            }
          }

        }

        switch(businessService){
          case envVariables.EGOV_PENSION_DOE_BUSINESS_SERVICE:  //Death of an employee

          //search employee in Pension module  
          let pensionResponse = await getPensionEmployees(body.RequestInfo,body.ProcessInstances[0].tenantId,body.ProcessInstances[0].employee.code);   
          let pensionEmployeesList=pensionResponse.Employees;                    
         
          if(pensionEmployeesList.length>0){  
              
              //fetch assignment, service history & contact details from hrms
              //if these data not exist then data will be inserted into pension module
              let hrmsResponse = await getEmployeeDetails(body.RequestInfo, body.ProcessInstances[0].tenantId,body.ProcessInstances[0].employee.code);              
              
              let hrmsEmployee=hrmsResponse.Employees[0];                                                    

              if(hrmsEmployee){            

                let pensionEmployeeId=pensionEmployeesList[0].uuid;                      

                let assignments=[];
                if(hrmsEmployee.assignments && !isEmpty(hrmsEmployee.assignments)){
                  assignments=hrmsEmployee.assignments;
                  for (var i = 0; i <assignments.length; i++){
                    assignments[i].id=uuidv1(); 
                    assignments[i].tenantId=hrmsEmployee.tenantId;                    
                    assignments[i].active=true;      
                    assignments[i].pensionEmployeeId=pensionEmployeeId;
                  }
                }

                let serviceHistory=[];
                if(hrmsEmployee.serviceHistory && !isEmpty(hrmsEmployee.serviceHistory)){
                  serviceHistory=hrmsEmployee.serviceHistory;
                  for (var i = 0; i <serviceHistory.length; i++){
                    serviceHistory[i].id=uuidv1();     
                    serviceHistory[i].tenantId=hrmsEmployee.tenantId;                  
                    serviceHistory[i].active=true;        
                    serviceHistory[i].pensionEmployeeId=pensionEmployeeId;            
                  }                  
                }

                let user=hrmsEmployee.user;
                user.employeeContactDetailsId=uuidv1(); 
                user.dob=adjust530AddForDob(user.dob);
                user.tenantId=hrmsEmployee.tenantId;                 
                user.active=true; 


                let employee={
                  pensionEmployeeId: pensionEmployeeId,                                            
                  uuid: hrmsEmployee.uuid,                    
                  code: hrmsEmployee.code,
                  dateOfDeath: adjust530AddForDeathRegistration(body.ProcessInstances[0].employee.dateOfDeath),
                  tenantId: hrmsEmployee.tenantId,
                  assignments: assignments,
                  serviceHistory: serviceHistory,      
                  user: user,                                   
                  employeeAudit: {
                    pensionEmployeeAuditId: uuidv1()
                  },
                  auditDetails: {
                    createdBy: get(body.RequestInfo, "userInfo.uuid", ""),
                    lastModifiedBy: null,
                    createdDate: new Date().getTime(),      
                    lastModifiedDate: null        
                  }      
                }; 
                body.ProcessInstances[0].employee=employee;
              }
          }
          else{
            
            //search employee from hrms and push that employee in pension module                  
              let hrmsResponse = await getEmployeeDetails(body.RequestInfo, body.ProcessInstances[0].tenantId,body.ProcessInstances[0].employee.code);              
              
              let hrmsEmployee=hrmsResponse.Employees[0];                                                    

              if(hrmsEmployee){

                //let maxRetirementAge=envVariables.EGOV_PENSION_MAX_RETIREMENT_AGE;              

                let pensionEmployeeId=uuidv1();                      

                let dob=adjust530AddForDob(hrmsEmployee.user.dob);
                //let actualDob=new Date(epochToYmd(intConversion(dob)));    
                //let dorYYYYMMDD=`${actualDob.getFullYear()+maxRetirementAge}-${actualDob.getMonth()+1}-${actualDob.getDate()}`;    
                //let dateOfRetirement=convertDateToEpoch(dorYYYYMMDD,"dob");  
                
                let dateOfSuperannuation=hrmsEmployee.dateOfSuperannuation;

                let assignments=[];
                if(hrmsEmployee.assignments && !isEmpty(hrmsEmployee.assignments)){
                  assignments=hrmsEmployee.assignments;
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
                    assignments[i].tenantId=hrmsEmployee.tenantId;                    
                    assignments[i].active=true;      
                    assignments[i].pensionEmployeeId=pensionEmployeeId;
                  }
                }

                let serviceHistory=[];
                if(hrmsEmployee.serviceHistory && !isEmpty(hrmsEmployee.serviceHistory)){
                  serviceHistory=hrmsEmployee.serviceHistory;
                  for (var i = 0; i <serviceHistory.length; i++){
                    serviceHistory[i].id=uuidv1();     
                    serviceHistory[i].tenantId=hrmsEmployee.tenantId;                  
                    serviceHistory[i].active=true;        
                    serviceHistory[i].pensionEmployeeId=pensionEmployeeId;            
                  }                  
                }

                let user=hrmsEmployee.user;
                user.employeeContactDetailsId=uuidv1();     
                user.tenantId=hrmsEmployee.tenantId;                 
                user.active=true; 

                let employee={
                  pensionEmployeeId: pensionEmployeeId,                          
                  id: hrmsEmployee.id,
                  uuid: hrmsEmployee.uuid,                    
                  code: hrmsEmployee.code,
                  name: hrmsEmployee.user.name,
                  dob: dob,
                  //dateOfRetirement: dateOfRetirement,
                  dateOfRetirement: dateOfSuperannuation,
                  dateOfDeath: adjust530AddForDeathRegistration(body.ProcessInstances[0].employee.dateOfDeath),                                      
                  tenantId: hrmsEmployee.tenantId, 
                  salutation: hrmsEmployee.user.salutation,      
                  gender: hrmsEmployee.user.gender, 
                  employeeStatus: hrmsEmployee.employeeStatus,
                  employeeType: hrmsEmployee.employeeType,
                  dateOfAppointment: hrmsEmployee.dateOfAppointment,
                  assignments: assignments,
                  serviceHistory: serviceHistory,      
                  user: user,                 
                  active: true,
                  employeeAudit: {
                    pensionEmployeeAuditId: uuidv1()
                  },
                  auditDetails: {
                    createdBy: get(body.RequestInfo, "userInfo.uuid", ""),
                    lastModifiedBy: null,
                    createdDate: new Date().getTime(),      
                    lastModifiedDate: null        
                  }      
                }; 
                
                body.ProcessInstances[0].employee=employee;                                                                                    
            }        
          }         
        }
      }
      
      body = await addUUIDAndAuditDetails(body,currentState);      
      

      body.ProcessInstances[0].employeeOtherDetails.accountNumber = body.ProcessInstances[0].employeeOtherDetails.accountNumber!=null? encrypt(body.ProcessInstances[0].employeeOtherDetails.accountNumber):body.ProcessInstances[0].employeeOtherDetails.accountNumber;


      if(body.ProcessInstances[0].dependents){

      for (var i = 0; i < body.ProcessInstances[0].dependents.length; i++) {                    
        body.ProcessInstances[0].dependents[i].bankAccountNumber = body.ProcessInstances[0].dependents[i].bankAccountNumber!=null?encrypt(body.ProcessInstances[0].dependents[i].bankAccountNumber):body.ProcessInstances[0].dependents[i].bankAccountNumber;
      } 
    }

      let workflowResponse;        
      if(action!="")//workkflow has an action, _transition endpoint of workflow service should be called
      {
        workflowResponse=await createWorkFlow(body); //workflow transition        
        nextState=workflowResponse.ProcessInstances[0].state.state;        
      }      
      body.ProcessInstances[0].workflowHeader.state=nextState!=""?nextState:currentState;

      
            
      let topic="";
      let eventResponse;
      switch(businessService)
      {
        case envVariables.EGOV_PENSION_RRP_BUSINESS_SERVICE:  //Regular Retirement pension
          if(action==envVariables.EGOV_PENSION_WORKFLOW_ACTION_INITIATE)  //initiate
          {            
            topic=envVariables.KAFKA_TOPICS_RRP_INITIATE;
          }
          else{             
            //Release Workflow                       
            if(action!=""){
              let releaseWorkFlowResponse = await releaseWorkFlow(body);              
            }           
            switch(currentState)
            {
              case "INITIATED": //PMS_DDO                        
                topic=envVariables.KAFKA_TOPICS_SAVE_RRP_INITIATED;  
                if(action==envVariables.EGOV_PENSION_WORKFLOW_ACTION_FORWARD){
                  //eventResponse=await createUserEventToUser(body,body.ProcessInstances[0].employee.tenantId,message.RRP_STARTED_USER_EVENT_NAME,message.RRP_STARTED_USER_EVENT_DESCRIPTION,body.ProcessInstances[0].employee.uuid); 
                  let eventDescription=message.RRP_STARTED_USER_EVENT_DESCRIPTION;
                  eventDescription=eventDescription.replace(/\{0}/g,String(body.ProcessInstances[0].businessId) );
                  //eventResponse=createUserEventToUser(body,body.ProcessInstances[0].employee.tenantId,message.RRP_STARTED_USER_EVENT_NAME,eventDescription,body.ProcessInstances[0].employee.uuid); 
                  notificationPayLoadSMS=workflowTemplateInterfaceSMS(body.ProcessInstances[0]);
                  notificationPayLoadEMAIL=workflowTemplateInterfaceEMAIL(body.ProcessInstances[0]);
                  logger.debug(notificationPayLoadSMS);
                  logger.debug(notificationPayLoadEMAIL);
                  payloads.push(notificationPayLoadSMS);
                  payloads.push(notificationPayLoadEMAIL);
                }                
                break;
              case "PENDING_FOR_DETAILS_VERIFICATION": //ACCOUNTS_OFFICER
                topic=envVariables.KAFKA_TOPICS_SAVE_PENDING_FOR_DETAILS_VERIFICATION;  
                break;
              case "PENDING_FOR_DETAILS_REVIEW": //SENIOR_ASSISTANT
                topic=envVariables.KAFKA_TOPICS_SAVE_PENDING_FOR_DETAILS_REVIEW;  
                break;
              case "PENDING_FOR_CALCULATION": //CLERK  
                if(action==envVariables.EGOV_PENSION_WORKFLOW_ACTION_SEND_BACK) {
                  topic=envVariables.KAFKA_TOPICS_CLEAR_BENEFIT;  
                }           
                else{
                  topic=envVariables.KAFKA_TOPICS_SAVE_PENDING_FOR_CALCULATION;  
                }                    
                break;
              case "PENDING_FOR_CALCULATION_VERIFICATION": //SENIOR_ASSISTANT                 
                break;
              case "PENDING_FOR_CALCULATION_APPROVAL": //ACCOUNTS_OFFICER      
                topic=envVariables.KAFKA_TOPICS_UPDATE_PENSION_WORKFLOW_STATE;                 
                break;
              case "PENDING_FOR_CALCULATION_REVIEW": //ACCOUNTS_OFFICER  
                topic=envVariables.KAFKA_TOPICS_SAVE_PENDING_FOR_CALCULATION_REVIEW;                                               
                break;
              case "PENDING_FOR_APPROVAL": //ADDITIONAL_COMMISSIONER    
                topic=envVariables.KAFKA_TOPICS_UPDATE_PENSION_WORKFLOW_STATE;                                            
                break;
              case "PENDING_FOR_AUDIT": //ACCOUNTS_OFFICER    
                topic=envVariables.KAFKA_TOPICS_UPDATE_PENSION_WORKFLOW_STATE;                                            
                break;
              case "PENDING_FOR_CONTINGENT_BILL_PREPARATION_WITH_ACCOUNTS_OFFICER": //ACCOUNTS_OFFICER                                            
                topic=envVariables.KAFKA_TOPICS_UPDATE_PENSION_WORKFLOW_STATE;    
                break;     
              case "PENDING_FOR_CONTINGENT_BILL_PREPARATION_WITH_SENIOR_ASSISTANT": //SENIOR_ASSISTANT                                            
                topic=envVariables.KAFKA_TOPICS_UPDATE_PENSION_WORKFLOW_STATE;    
                break;   
              case "PENDING_FOR_CONTINGENT_BILL_PREPARATION_WITH_CLERK": //CLERK       
                await closeWorkflowByUser(body); //close workflow  
                topic=envVariables.KAFKA_TOPICS_UPDATE_PENSION_WORKFLOW_STATE;                                  
                break;              
              default:
                break;
            }           
          }          
        break;
        case envVariables.EGOV_PENSION_DOE_BUSINESS_SERVICE:  //Death of an employee        
          if(action===envVariables.EGOV_PENSION_WORKFLOW_ACTION_INITIATE)  //initiate
          {                                                             
            topic=envVariables.KAFKA_TOPICS_DOE_INITIATE;            
          }
          else{ 
            //Release Workflow                       
            if(action!=""){
              let releaseWorkFlowResponse = await releaseWorkFlow(body);              
            }                
            switch(currentState)
            {
              case "INITIATED": //PMS_DDO                           
                topic=envVariables.KAFKA_TOPICS_SAVE_DEATH_INITIATED;    
                if(action==envVariables.EGOV_PENSION_WORKFLOW_ACTION_FORWARD){                  
                  workflowTemplateInterfaceSMS(body.ProcessInstances[0]);
                }                           
                break;
              case "PENDING_FOR_DETAILS_VERIFICATION":
                topic=envVariables.KAFKA_TOPICS_SAVE_PENDING_FOR_DETAILS_VERIFICATION;  
                break;
              case "PENDING_FOR_DETAILS_REVIEW":
                topic=envVariables.KAFKA_TOPICS_SAVE_PENDING_FOR_DETAILS_REVIEW;  
                break;
              case "PENDING_FOR_CALCULATION": //CLERK              
                if(action==envVariables.EGOV_PENSION_WORKFLOW_ACTION_SEND_BACK) {
                  topic=envVariables.KAFKA_TOPICS_CLEAR_BENEFIT;  
                }           
                else{
                  topic=envVariables.KAFKA_TOPICS_SAVE_PENDING_FOR_CALCULATION;  
                }       
                break;
              case "PENDING_FOR_CALCULATION_VERIFICATION":   
                topic=envVariables.KAFKA_TOPICS_UPDATE_PENSION_WORKFLOW_STATE;               
                break;
              case "PENDING_FOR_CALCULATION_APPROVAL":
                topic=envVariables.KAFKA_TOPICS_UPDATE_PENSION_WORKFLOW_STATE;                  
                break;
              case "PENDING_FOR_CALCULATION_REVIEW": //ACCOUNTS_OFFICER  
                topic=envVariables.KAFKA_TOPICS_SAVE_PENDING_FOR_CALCULATION_REVIEW;                                               
                break;
              case "PENDING_FOR_APPROVAL": //ADDITIONAL_COMMISSIONER   
                topic=envVariables.KAFKA_TOPICS_UPDATE_PENSION_WORKFLOW_STATE;                                         
                break;
              case "PENDING_FOR_AUDIT": //ACCOUNTS_OFFICER    
                topic=envVariables.KAFKA_TOPICS_UPDATE_PENSION_WORKFLOW_STATE;                                        
                break;
              case "PENDING_FOR_CONTINGENT_BILL_PREPARATION_WITH_ACCOUNTS_OFFICER": //ACCOUNTS_OFFICER                                            
                topic=envVariables.KAFKA_TOPICS_UPDATE_PENSION_WORKFLOW_STATE;
                break;     
              case "PENDING_FOR_CONTINGENT_BILL_PREPARATION_WITH_SENIOR_ASSISTANT": //SENIOR_ASSISTANT                                            
                topic=envVariables.KAFKA_TOPICS_UPDATE_PENSION_WORKFLOW_STATE;
                break;   
              case "PENDING_FOR_CONTINGENT_BILL_PREPARATION_WITH_CLERK": //CLERK 
                await closeWorkflowByUser(body); //close workflow  
                topic=envVariables.KAFKA_TOPICS_UPDATE_PENSION_WORKFLOW_STATE;                                         
                break;              
              default:
                break;
            }
            
                          

          }
        
        break;
        case envVariables.EGOV_PENSION_DOP_BUSINESS_SERVICE:  //Death of a pensioner        
          if(action===envVariables.EGOV_PENSION_WORKFLOW_ACTION_INITIATE)  //initiate
          {                                                             
            topic=envVariables.KAFKA_TOPICS_DOP_INITIATE;            
          }
          else{ 
            //Release Workflow                       
            if(action!=""){
              let releaseWorkFlowResponse = await releaseWorkFlow(body);              
            }                
            switch(currentState)
            {
              case "INITIATED": //PMS_DDO                           
                topic=envVariables.KAFKA_TOPICS_SAVE_DEATH_INITIATED; 
                if(action==envVariables.EGOV_PENSION_WORKFLOW_ACTION_FORWARD){                  
                  workflowTemplateInterfaceSMS(body.ProcessInstances[0]);
                }                             
                break;
              case "PENDING_FOR_DETAILS_VERIFICATION":
                topic=envVariables.KAFKA_TOPICS_SAVE_PENDING_FOR_DETAILS_VERIFICATION;  
                break;
              case "PENDING_FOR_DETAILS_REVIEW":
                topic=envVariables.KAFKA_TOPICS_SAVE_PENDING_FOR_DETAILS_REVIEW;  
                break;
              case "PENDING_FOR_CALCULATION": //CLERK              
                if(action==envVariables.EGOV_PENSION_WORKFLOW_ACTION_SEND_BACK) {
                  topic=envVariables.KAFKA_TOPICS_CLEAR_BENEFIT;  
                }           
                else{
                  topic=envVariables.KAFKA_TOPICS_SAVE_PENDING_FOR_CALCULATION;  
                }  
                break;
              case "PENDING_FOR_CALCULATION_VERIFICATION":     
                topic=envVariables.KAFKA_TOPICS_UPDATE_PENSION_WORKFLOW_STATE;             
                break;
              case "PENDING_FOR_CALCULATION_APPROVAL":   
                topic=envVariables.KAFKA_TOPICS_UPDATE_PENSION_WORKFLOW_STATE;               
                break;
              case "PENDING_FOR_CALCULATION_REVIEW": //ACCOUNTS_OFFICER  
                topic=envVariables.KAFKA_TOPICS_SAVE_PENDING_FOR_CALCULATION_REVIEW;                                               
                break;
              case "PENDING_FOR_APPROVAL": //ADDITIONAL_COMMISSIONER    
                topic=envVariables.KAFKA_TOPICS_UPDATE_PENSION_WORKFLOW_STATE;                                        
                break;
              case "PENDING_FOR_AUDIT": //ACCOUNTS_OFFICER     
                topic=envVariables.KAFKA_TOPICS_UPDATE_PENSION_WORKFLOW_STATE;                                       
                break;
              case "PENDING_FOR_CONTINGENT_BILL_PREPARATION_WITH_ACCOUNTS_OFFICER": //ACCOUNTS_OFFICER                                            
                topic=envVariables.KAFKA_TOPICS_UPDATE_PENSION_WORKFLOW_STATE;
                break;     
              case "PENDING_FOR_CONTINGENT_BILL_PREPARATION_WITH_SENIOR_ASSISTANT": //SENIOR_ASSISTANT                                            
                topic=envVariables.KAFKA_TOPICS_UPDATE_PENSION_WORKFLOW_STATE;
                break;   
              case "PENDING_FOR_CONTINGENT_BILL_PREPARATION_WITH_CLERK": //CLERK   
                await closeWorkflowByUser(body); //close workflow  
                topic=envVariables.KAFKA_TOPICS_UPDATE_PENSION_WORKFLOW_STATE;                                       
                break;             
              default:
                break;
            }
            
                          

          }
        
        break;

      }

      
      

      payloads.push({
        topic: topic,
        messages: JSON.stringify(body)
      });
      producer.send(payloads, function(err, data) {
        let response = {
          ResponseInfo: requestInfoToResponseInfo(body.RequestInfo, true),
          ProcessInstances: body.ProcessInstances
        };
        res.json(response);
      });
      

        
    })
  );
  return api;
};
