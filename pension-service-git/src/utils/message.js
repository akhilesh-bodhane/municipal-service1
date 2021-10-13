import get from "lodash/get";
import some from "lodash/some";

export const Message =()=>{ 
  return {
    EMPLOYEE_EXIST_PUSH_MANUAL_REGISTER_TO_PNR_NA: "Workflow already processed for this employee or this employee already exist in Pension Notification Register.",
    DISABILITY_PERCENTAGE_NOT_SET: "Disability percentage not set.",    
    EMPLOYEE_PUSHED_TO_PNR_USER_EVENT_NAME: "Notification for Pension Election",  
    EMPLOYEE_PUSHED_TO_PNR_USER_EVENT_DESCRIPTION: "You are now elected for pension benefit. Please contact your respective Drawing and Disbursing Officer of respective department.",
    PNR_GENERATED_USER_EVENT_NAME: "NOTIFICATION_REGISTER_UPDATE",
    PNR_GENERATED_USER_EVENT_DESCRIPTION: "Pension Notification Register Report has been generated. Please check the same.",
    RRP_STARTED_USER_EVENT_NAME: "PENSION_APPLICATION_UPDATE",
    RRP_STARTED_USER_EVENT_DESCRIPTION: "You are now eligible for Regular Retirement Pension benefit. Your application number is {0}.",   
    PARALLEL_WORLFLOW_EXIST_INITIATE_NA: "Workflow can't be initiated as an active application with application number {0} is already exist for this employee.",
};
}