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
          moduleName: "pension",
          masterDetails: [
          { name: "employeeType" },
          { name: "dependentsEligibilityForGratuity" },
          { name: "dependentsEligibilityForPension" },
          { name: "benefits" },
          { name: "pensionRevision" },
          { name: "notifications" },          
          { name: "DAPercentage" },
          { name: "CommutationPercentage" },
          { name: "CommutationMultiplier" },
          { name: "IRPercentage" },
          { name: "AdditionalPensionPercentage"},
          { name: "PensionConfig"}          
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
