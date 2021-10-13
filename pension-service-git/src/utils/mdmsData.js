import { httpRequest } from "./api";
import envVariables from "../envVariables";

export default async (requestInfo = {},tenantId) => {
  if (String(tenantId).includes(".")){
    let index=String(tenantId).indexOf(".");
    tenantId=String(tenantId).substring(0,index);
  }
  var requestBody = {
    RequestInfo: requestInfo,
    MdmsCriteria: {
      tenantId,
      moduleDetails: [
        {
          moduleName: "common-masters",
          masterDetails: [{ name: "Designation" }]
        } ,
        {
          moduleName: "pension",
          masterDetails: [{ name: "DocumentType_RRP" },
          { name: "DocumentType_DOE" },
          { name: "DocumentType_DOP" },
          { name: "EmployeeLeaveType" },
          { name: "Disability" },
          { name: "DAPercentage" },
          { name: "IRPercentage" },
          { name: "AdditionalPensionPercentage" },
          { name: "BankDetails" } 
        ]
        }  

      ]
    }
  };
  var mdmsResponse = await httpRequest({
    hostURL: envVariables.EGOV_MDMS_HOST,
    endPoint: `${envVariables.EGOV_MDMS_CONTEXT_PATH}${
      envVariables.EGOV_MDMS_SEARCH_ENPOINT
    }`,
    requestBody
  });
  return mdmsResponse;
};
