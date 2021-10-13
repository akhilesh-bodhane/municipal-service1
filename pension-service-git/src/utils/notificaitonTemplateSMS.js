import get from "lodash/get";
import envVariables from "../envVariables";

import logger from "../config/logger";

const workflowTemplateInterfaceSMS = (pension = {}) => {
  let payload = {};
  const topic = "egov.core.notification.sms";
  let smsRequest = {
    mobileNumber: get(
      pension.employee.user,
      "mobileNumber"
    )
  };
  const applicantName = get(
    pension.employee.user,
    "name"
  );
  const applicationType = get(pension, "businessService");
  const applicationNumber = get(pension, "businessId");
  const action = get(pension, "action");
  switch (applicationType) {
      case envVariables.EGOV_PENSION_RRP_BUSINESS_SERVICE:
        switch (action) {
            case envVariables.EGOV_PENSION_WORKFLOW_ACTION_FORWARD:
                {
                    smsRequest[
                      "message"
                    ] = `Dear ${applicantName}, Your Regular Retirement Pension application has been initiated. Your application number is ${applicationNumber}.`;
                  }
                break;                
        }
        break;
      case envVariables.EGOV_PENSION_DOE_BUSINESS_SERVICE:
        switch (action) {
          case envVariables.EGOV_PENSION_WORKFLOW_ACTION_FORWARD:
              {
                  smsRequest[
                    "message"
                  ] = `This is to inform dependents of ${applicantName} that the application of death benefit has been initiated. Please note application number ${applicationNumber} for future reference.`;
                }
              break;                
        }
        break;
    case envVariables.EGOV_PENSION_DOP_BUSINESS_SERVICE:
        switch (action) {
          case envVariables.EGOV_PENSION_WORKFLOW_ACTION_FORWARD:
              {
                  smsRequest[
                    "message"
                  ] = `This is to inform dependents of ${applicantName} that the application of death benefit has been initiated. Please note application number ${applicationNumber} for future reference.`;
                }
              break;                
        }
        break;
  }
  logger.debug("smsRequest",JSON.stringify(smsRequest));
  
  payload = {
    topic,
    messages: JSON.stringify(smsRequest)
  };
  return payload;
};

export default workflowTemplateInterfaceSMS;
