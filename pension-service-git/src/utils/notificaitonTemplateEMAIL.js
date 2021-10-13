import get from "lodash/get";
import envVariables from "../envVariables";

import logger from "../config/logger";

const workflowTemplateInterfaceEMAIL = (pension = {}) => {
  let payload = {};
  const topic = "egov.core.notification.email";
  let emailRequest = {
    email: get(
      pension.employee.user,
      "emailId"
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
                    emailRequest[
                      "subject"]="Notification for Pension Application";
                      emailRequest[
                      "body"
                    ] = 
          
                    `<table style="width: 601px;">
                    <tbody>
                    <tr>
                    <td style="width: 591px;">Dear ${applicantName}, <br /> <br /> Regular Retirement Pension application has been initiated. Application Number ${applicationNumber} is for your future reference.<br /> <br /> Note: This is a system generated email. Please do not reply.<br /> <br /> Regards,<br /> Chandigarh Smart City Private Limited</td>
                    </tr>
                    </tbody>
                    </table>`
                  }
                break;                
        }
        break;
      case envVariables.EGOV_PENSION_DOE_BUSINESS_SERVICE:
        switch (action) {
          case envVariables.EGOV_PENSION_WORKFLOW_ACTION_FORWARD:
            {
              emailRequest[
                "subject"]="Notification for Death Benefit for employee";
                emailRequest[
                "body"
              ] = 
              `<table style="width: 605px;">
              <tbody>
              <tr>
              <td style="width: 595px;">Subject Line: Notification for Death Benefit for employee<br /> <br /> Dear Beneficiary of ${applicantName}, <br /> <br /> Death benefit applicaton of &lt;employee name&gt; has been initiated. Application Number ${applicationNumber} is for your future reference.<br /> <br /> Note: This is a system generated email. Please do not reply.<br /> <br /> Regards,<br /> Chandigarh Smart City Private Limited</td>
              </tr>
              </tbody>
              </table>`;
            }
              break;                
        }
        break;
    case envVariables.EGOV_PENSION_DOP_BUSINESS_SERVICE:
        switch (action) {
          case envVariables.EGOV_PENSION_WORKFLOW_ACTION_FORWARD:
            {
              emailRequest[
                "subject"]="Notification for Death Benefit for pensioner";
                emailRequest[
                "body"
              ] = 
              `<table style="width: 606px;">
              <tbody>
              <tr>
              <td style="width: 596px;">Subject Line: Notification for Death Benefit for pensioner<br /> <br /> Dear Beneficiary of ${applicantName}, <br /> <br /> Death benefit applicaton of ${applicantName} has been initiated. Application Number ${applicationNumber} is for your future reference.<br /> <br /> Note: This is a system generated email. Please do not reply.<br /> <br /> Regards,<br /> Chandigarh Smart City Private Limited</td>
              </tr>
              </tbody>
              </table>
              <p>&nbsp;</p>`;
            }
              break;                
        }
        break;
  }

  emailRequest[
    "isHTML"]=true;
  logger.debug("emailRequest",JSON.stringify(emailRequest));
  
  payload = {
    topic,
    messages: JSON.stringify(emailRequest)
  };
  return payload;
};

export default workflowTemplateInterfaceEMAIL;
