import axios from "axios";
import uniqBy from "lodash/uniqBy";
import uniq from "lodash/uniq";
import get from "lodash/get";
import findIndex from "lodash/findIndex";
import isEmpty from "lodash/isEmpty";
import { httpRequest, httpGetRequest } from "./api";
import envVariables from "../envVariables";
import { from } from "linq";

import logger from "../config/logger";

export const uuidv1 = () => {
  return require("uuid/v4")();
};

export const requestInfoToResponseInfo = (requestinfo, success) => {
  let ResponseInfo = {
    apiId: "",
    ver: "",
    ts: 0,
    resMsgId: "",
    msgId: "",
    status: ""
  };
  ResponseInfo.apiId =
    requestinfo && requestinfo.apiId ? requestinfo.apiId : "";
  ResponseInfo.ver = requestinfo && requestinfo.ver ? requestinfo.ver : "";
  ResponseInfo.ts = requestinfo && requestinfo.ts ? requestinfo.ts : null;
  ResponseInfo.resMsgId = "uief87324";
  ResponseInfo.msgId =
    requestinfo && requestinfo.msgId ? requestinfo.msgId : "";
  ResponseInfo.status = success ? "successful" : "failed";

  return ResponseInfo;
};

export const addIDGenId = async (requestInfo, idRequests) => {
  let requestBody = {
    RequestInfo: requestInfo,
    idRequests
  };
  
  let idGenResponse = await httpRequest({
    hostURL: envVariables.EGOV_IDGEN_HOST,
    endPoint: `${envVariables.EGOV_IDGEN_CONTEXT_PATH}${
      envVariables.EGOV_IDGEN_GENERATE_ENPOINT
    }`,
    requestBody
  });
  
  return get(idGenResponse, "idResponses[0].id");
};

export const addQueryArg = (url, queries = []) => {
  if (url && url.includes("?")) {
    const urlParts = url.split("?");
    const path = urlParts[0];
    let queryParts = urlParts.length > 1 ? urlParts[1].split("&") : [];
    queries.forEach(query => {
      const key = query.key;
      const value = query.value;
      const newQuery = `${key}=${value}`;
      queryParts.push(newQuery);
    });
    const newUrl = path + "?" + queryParts.join("&");
    return newUrl;
  } else {
    return url;
  }
};

//Workflow Service
export const createWorkFlow = async body => {  
  let processInstances = body.ProcessInstances.map(processInstances => {
    return {
      tenantId: processInstances.tenantId,
      businessService: processInstances.businessService,
      businessId: processInstances.businessId,//applicationNumber
      action: processInstances.action,
      comment: processInstances.comment!=null?processInstances.comment:null,
      assignee: null,
      documents: processInstances.documents!=null? processInstances.documents:[],
      sla: 0,
      previousStatus: null,
      moduleName: processInstances.businessService
    };
  });
  let requestBody = {
    RequestInfo: body.RequestInfo,
    ProcessInstances: processInstances
  };
  logger.debug("requestBody", JSON.stringify(requestBody));

  let workflowResponse = await httpRequest({
    hostURL: envVariables.EGOV_WORKFLOW_HOST,
    endPoint: envVariables.EGOV_WORKFLOW_TRANSITION_ENDPOINT,
    requestBody
  });
  
  return workflowResponse;
};

export const searchWorkflow = async (requestInfo, tenantId,businessIds) => {
  let requestBody = {
    RequestInfo: requestInfo
  };  
  
  let workflowResponse = await httpRequest({
    hostURL: envVariables.EGOV_WORKFLOW_HOST,
    endPoint: `${envVariables.EGOV_WORKFLOW_SEARCH_ENDPOINT
    }?tenantId=${tenantId}&businessIds=${businessIds}&limit=${envVariables.EGOV_WORKFLOW_DEFAULT_LIMIT}`,
    requestBody
  });  
  
  return workflowResponse;
};

//Pension Service
export const saveEmployees = async body => {
  let requestBody=body ;

  
  
   let pensionResponse = await httpRequest({
     hostURL: envVariables.EGOV_PENSION_HOST,
     endPoint: `${envVariables.EGOV_PENSION_CONTEXT_PATH}${
       envVariables.EGOV_PENSION_SAVE_EMPLOYEES_ENDPOINT
     }`,
     requestBody
   });   
   return pensionResponse;
 };

 export const searchEmployee = async (requestInfo, tenantId,code) => {
  let requestBody = {
    RequestInfo: requestInfo
  };    
  let employeeResponse = await httpRequest({
    hostURL: envVariables.EGOV_PENSION_HOST,
    endPoint: `${envVariables.EGOV_PENSION_CONTEXT_PATH}${
      envVariables.EGOV_PENSION_SEARCH_EMPLOYEE_ENDPOINT
    }?tenantId=${tenantId}&code=${code}`,
    requestBody
  });  
  
  return employeeResponse;
};

export const releaseWorkFlow = async body => {  
  let processInstances = body.ProcessInstances.map(processInstances => {
    return {     
      businessId: processInstances.businessId,//applicationNumber      
    };
  });
  let requestBody = {
    RequestInfo: body.RequestInfo,
    ProcessInstances: processInstances
  };  

  let releaseWorkFlowResponse = await httpRequest({
    hostURL: envVariables.EGOV_PENSION_HOST,
    endPoint: `${envVariables.EGOV_PENSION_CONTEXT_PATH}${
      envVariables.EGOV_PENSION_RELEASE_WORKFLOW_ENDPOINT
    }`,
    requestBody
  });  
  return releaseWorkFlowResponse;
};

export const searchPensionWorkflow = async (requestInfo, tenantId,businessIds) => {
  let requestBody = {
    RequestInfo: requestInfo
  };  
  
  let workflowResponse = await httpRequest({
    hostURL: envVariables.EGOV_PENSION_HOST,
    endPoint: `${envVariables.EGOV_PENSION_CONTEXT_PATH}${
      envVariables.EGOV_PENSION_SEARCH_WORKFLOW_ENDPOINT
    }?tenantId=${tenantId}&businessIds=${businessIds}`,
    requestBody
  });  
  
  return workflowResponse;
};

export const getPensionEmployees = async ( requestInfo,tenantId,code,name,dob) => {  
  let requestBody = {
    RequestInfo: requestInfo
  };  
  let queryObj=`tenantId=${tenantId}`;
  if(code){
    queryObj=`${queryObj}&code=${code}`
  }
  if(name){
    queryObj=`${queryObj}&name=${name}`
  }
  if(dob){
    queryObj=`${queryObj}&dob=${dob}`
  }
  let employeeResponse = await httpRequest({
    hostURL: envVariables.EGOV_PENSION_HOST,
    endPoint: `${envVariables.EGOV_PENSION_CONTEXT_PATH
    }${envVariables.EGOV_PENSION_GET_PENSION_EMPLOYEES_ENDPOINT
    }?${queryObj}`,
    requestBody
  });
  
  return employeeResponse;
};

export const searchPensioner = async ( requestInfo,tenantId,pensionerNumber,name,dob) => {  
  let requestBody = {
    RequestInfo: requestInfo
  };  

  let queryObj="";  

  if(tenantId){
    queryObj=`${queryObj}tenantId=${tenantId}`
  }
  if(pensionerNumber){
    queryObj=`${queryObj}&pensionerNumber=${pensionerNumber}`
  }
  if(name){
    queryObj=`${queryObj}&name=${name}`
  }
  if(dob){
    queryObj=`${queryObj}&dob=${dob}`
  }

  let response = await httpRequest({
    hostURL: envVariables.EGOV_PENSION_HOST,
    endPoint: `${envVariables.EGOV_PENSION_CONTEXT_PATH
    }${envVariables.EGOV_PENSION_SEARCH_PENSIONER_ENDPOINT
    }?${queryObj}`,
    requestBody
  });
  
  return response;
};

export const searchPensionerForPensionRevision = async ( requestInfo,tenantId,pensionerNumber) => {  
  let requestBody = {
    RequestInfo: requestInfo
  };  

  let response = await httpRequest({
    hostURL: envVariables.EGOV_PENSION_HOST,
    endPoint: `${envVariables.EGOV_PENSION_CONTEXT_PATH
    }${envVariables.EGOV_PENSION_SEARCH_PENSIONER_FOR_PENSION_REVISION_ENDPOINT
    }?tenantId=${tenantId}&pensionerNumber=${pensionerNumber}`,
    requestBody
  });
  
  return response;
};

export const getPensionRevisions = async ( requestInfo,tenantId,pensionerNumber) => {  
  let requestBody = {
    RequestInfo: requestInfo
  };  

  let response = await httpRequest({
    hostURL: envVariables.EGOV_PENSION_HOST,
    endPoint: `${envVariables.EGOV_PENSION_CONTEXT_PATH
    }${envVariables.EGOV_PENSION_GET_PENSION_REVISIONS_ENDPOINT
    }?tenantId=${tenantId}&pensionerNumber=${pensionerNumber}`,
    requestBody
  });
  
  return response;
};

export const closeWorkflowByUser = async body => { 
  let processInstances = body.ProcessInstances.map(processInstances => {
    return {
      tenantId: processInstances.tenantId,
      businessService: processInstances.businessService,
      businessId: processInstances.businessId,
      dateOfContingent: processInstances.employeeOtherDetails.dateOfContingent,//employeeOtherDetails object
      moduleName: processInstances.businessService,
      workflowHeaderId: "",
      pensionEmployeeId: "",
      pensionerId: "",    
      employeeOtherDetailsAuditId: "",
      auditDetails: null
    };
  });
    
   let requestBody = {
    RequestInfo: body.RequestInfo,
    ProcessInstances: processInstances
   };

   logger.debug(JSON.stringify(requestBody));

   let pensionResponse = await httpRequest({
     hostURL: envVariables.EGOV_PENSION_HOST,
     endPoint: `${envVariables.EGOV_PENSION_CONTEXT_PATH}${
       envVariables.EGOV_PENSION_CLOSE_WORKFLOW_BY_USER_ENDPOINT
     }`,
     requestBody
   });   
   logger.debug(JSON.stringify(pensionResponse));
   return pensionResponse;
 };
 
 export const saveEmployeeToPensionNotificationRegister = async body => {
  let requestBody=body ;
   let pensionResponse = await httpRequest({
     hostURL: envVariables.EGOV_PENSION_HOST,
     endPoint: `${envVariables.EGOV_PENSION_CONTEXT_PATH}${
       envVariables.EGOV_PENSION_SAVE_EMPLOYEE_TO_PENSION_NOTIFICATION_REGISTER_ENDPOINT
     }`,
     requestBody
   });
   
   return pensionResponse;
 };

 export const getEmployeeDisability = async ( requestInfo,tenantId,code) => {  
  let requestBody = {
    RequestInfo: requestInfo
  };  

  let response = await httpRequest({
    hostURL: envVariables.EGOV_PENSION_HOST,
    endPoint: `${envVariables.EGOV_PENSION_CONTEXT_PATH
    }${envVariables.EGOV_PENSION_GET_EMPLOYEE_DISABILITY_ENDPOINT
    }?tenantId=${tenantId}&code=${code}`,
    requestBody
  });
  
  return response;
};

export const searchClosedApplication = async ( requestInfo,tenantId,businessService,businessId) => {  
  let requestBody = {
    RequestInfo: requestInfo
  };  
  let queryObj=`tenantId=${tenantId}`;
  
  if(businessService){
    queryObj=`${queryObj}&businessService=${businessService}`
  }
  if(businessId){
    queryObj=`${queryObj}&businessId=${businessId}`
  }
  
  let closedApplicationResponse = await httpRequest({
    hostURL: envVariables.EGOV_PENSION_HOST,
    endPoint: `${envVariables.EGOV_PENSION_CONTEXT_PATH
    }${envVariables.EGOV_PENSION_SEARCH_CLOSED_APPLICATION_ENDPOINT
    }?${queryObj}`,
    requestBody
  });
  
  return closedApplicationResponse;
};

export const searchApplication = async ( requestInfo,tenantId,code,businessId,businessService) => {  
  let requestBody = {
    RequestInfo: requestInfo
  };  
  let queryObj="";  

  if(tenantId){
    queryObj=`${queryObj}tenantId=${tenantId}`
  }  
  if(code){
    queryObj=`${queryObj}&code=${code}`
  }
  if(businessId){
    queryObj=`${queryObj}&businessId=${businessId}`
  }
  if(businessService){
    queryObj=`${queryObj}&businessService=${businessService}`
  }
  
  let closedApplicationResponse = await httpRequest({
    hostURL: envVariables.EGOV_PENSION_HOST,
    endPoint: `${envVariables.EGOV_PENSION_CONTEXT_PATH
    }${envVariables.EGOV_PENSION_SEARCH_APPLICATION_ENDPOINT
    }?${queryObj}`,
    requestBody
  });
  
  return closedApplicationResponse;
};

//HRMS Service
export const getEmployeeDetails = async ( requestInfo,tenantId,codes="",names="",departments="") => {  
  let requestBody = {
    RequestInfo: requestInfo
  };
  let query="";   
  if(codes!=""){
    query=`${query}&codes=${codes}`;
  }
  if(names!=""){
    query=`${query}&names=${names}`;
  }
  if(departments!=""){
    query=`${query}&departments=${departments}`;
  }
  let employeeResponse = await httpRequest({
    hostURL: envVariables.EGOV_HRMS_HOST,
    endPoint: `${envVariables.EGOV_HRMS_CONTEXT_PATH
    }${envVariables.EGOV_HRMS_EMPLOYEE_SEARCH_ENDPOINT      
    }?limit=${envVariables.EGOV_HRMS_DEFAULT_LIMIT}&tenantId=${tenantId}${query}`,
    requestBody
  });
  
  return employeeResponse;
};

//File Service
export const getFileDetails = async ( tenantId,fileStoreIds,requestInfo) => {  
  if (String(tenantId).includes(".")){
    let index=String(tenantId).indexOf(".");
    tenantId=String(tenantId).substring(0,index);
  }
  /*
  let headers = [];
  headers.push({
    "auth-token":requestInfo.authToken
    }    
  );
  */
  let fileResponse = await httpGetRequest({
    hostURL: envVariables.EGOV_FILESTORE_HOST,
    endPoint: `${envVariables.EGOV_FILESTORE_CONTEXT_PATH
    }${envVariables.EGOV_FILESTORE_URL_ENDPOINT      
    }?tenantId=${tenantId}&fileStoreIds=${fileStoreIds}`//,
    //headers
  });
  
  return fileResponse;
};

//User Event Service
export const createUserEventToUser = async (body,tenantId,eventName,eventDescription,uuid) => {    
  let today=new Date();
  let fromDate=`${today.getFullYear()}-${today.getMonth()+1}-${today.getDate()+1}`;
  let toDate=`${today.getFullYear()}-${today.getMonth()+1}-${today.getDate()+8}`;
  
  let events=[];
  events.push(
    {
    tenantId: tenantId,
    eventType: envVariables.EGOV_USER_EVENT_TYPE,
    description: eventDescription,
    name: eventName,
    source: envVariables.EGOV_USER_EVENT_NAME_SOURCE,
    actions: {
      actionUrls: []
    },
    eventDetails: {
      fromDate: convertDateToEpoch(fromDate,"dob"),
      toDate: convertDateToEpoch(toDate,"dob")
    },
    recepient: {
      toRoles: [],
      toUsers: [uuid]        
    }
    }
  );
  let requestBody = {
    RequestInfo: body.RequestInfo,
    events: events
  };
  logger.debug("eventRequestBody", JSON.stringify(requestBody));

  let eventResponse = await httpRequest({
    hostURL: envVariables.EGOV_USER_EVENT_HOST,
    endPoint: `${envVariables.EGOV_USER_EVENT_CONTEXT_PATH}${
      envVariables.EGOV_USER_EVENT_CREATE_ENDPOINT
    }`,
    requestBody
  });
  
  return eventResponse;
};

export const createUserEventToRole = async (body,tenantId,eventName,eventDescription,roleCode) => {    
  let today=new Date();
  let fromDate=`${today.getFullYear()}-${today.getMonth()+1}-${today.getDate()+1}`;
  let toDate=`${today.getFullYear()}-${today.getMonth()+1}-${today.getDate()+8}`;
  
  let events=[];
  events.push(
    {
      tenantId: tenantId,
      eventType: envVariables.EGOV_USER_EVENT_TYPE,
      description: eventDescription,
      name: eventName,
      source: envVariables.EGOV_USER_EVENT_NAME_SOURCE,
      actions: {
        actionUrls: []
      },
      eventDetails: {
        fromDate: convertDateToEpoch(fromDate,"dob"),
        toDate: convertDateToEpoch(toDate,"dob")
      },
      recepient: {
        toRoles: [roleCode],
        toUsers: []        
      }
    }
  ); 
  let requestBody = {
    RequestInfo: body.RequestInfo,
    events: events
  };
  

  let eventResponse = await httpRequest({
    hostURL: envVariables.EGOV_USER_EVENT_HOST,
    endPoint: `${envVariables.EGOV_USER_EVENT_CONTEXT_PATH}${
      envVariables.EGOV_USER_EVENT_CREATE_ENDPOINT
    }`,
    requestBody
  });
  
  return eventResponse;
};

export const getUserEventDetails = async ( requestInfo,tenantId,recepients) => {  
  let requestBody = {
    RequestInfo: requestInfo
  };  

  let userEventResponse = await httpRequest({
    hostURL: envVariables.EGOV_USER_EVENT_HOST,
    endPoint: `${envVariables.EGOV_USER_EVENT_CONTEXT_PATH
    }${envVariables.EGOV_USER_EVENT_SEARCH_ENDPOINT      
    }?tenantId=${tenantId}&recepients=${recepients}`,
    requestBody
  });
  
  return userEventResponse;
};

//Pension Rule Engine
export const calculateBenefit = async body => {  
  let processInstances = body.ProcessInstances.map(processInstances => {
    return {     
      tenantId: processInstances.tenantId,
      employee: processInstances.employee 
    };
  });
  let requestBody = {    
    RequestInfo: body.RequestInfo,
    ProcessInstances: processInstances
  };  
  logger.debug("requestBody", JSON.stringify(requestBody));
  
  let ruleEngineResponse = await httpRequest({
    hostURL: envVariables.EGOV_PENSION_RULE_ENGINE_HOST,
    endPoint: `${envVariables.EGOV_PENSION_RULE_ENGINE_CONTEXT_PATH}${
      envVariables.EGOV_PENSION_RULE_ENGINE_CALCULATE_BENEFIT_ENDPOINT
    }`,
    requestBody
  });
  

  
  return ruleEngineResponse;
};


export const getDependentEligibilityForBenefit = async body => {  
  let processInstances = body.ProcessInstances.map(processInstances => {
    return {     
      tenantId: processInstances.tenantId,
      dependents: processInstances.dependents     
    };
  });
  let requestBody = {    
    RequestInfo: body.RequestInfo,
    ProcessInstances: processInstances
  };  
  logger.debug("requestBody", JSON.stringify(requestBody));
  
  let ruleEngineResponse = await httpRequest({
    hostURL: envVariables.EGOV_PENSION_RULE_ENGINE_HOST,
    endPoint: `${envVariables.EGOV_PENSION_RULE_ENGINE_CONTEXT_PATH}${
      envVariables.EGOV_PENSION_RULE_ENGINE_GET_DEPENDENT_ELIGIBILITY_FOR_BENEFIT_ENDPOINT
    }`,
    requestBody
  });
  

  
  
  return ruleEngineResponse;
};

export const calculateRevisedPension = async body => {  
  let processInstances = body.ProcessInstances.map(processInstances => {
    return {     
      tenantId: processInstances.tenantId,
      pensionRevision: processInstances.pensionRevision 
    };
  });
  let requestBody = {    
    RequestInfo: body.RequestInfo,
    ProcessInstances: processInstances
  };  
  logger.debug("requestBody", JSON.stringify(requestBody));
  
  let ruleEngineResponse = await httpRequest({
    hostURL: envVariables.EGOV_PENSION_RULE_ENGINE_HOST,
    endPoint: `${envVariables.EGOV_PENSION_RULE_ENGINE_CONTEXT_PATH}${
      envVariables.EGOV_PENSION_RULE_ENGINE_CALCULATE_REVISED_PENSION_ENDPOINT
    }`,
    requestBody
  });
  

  
  
  return ruleEngineResponse;
};

//Schedular
export const loginRequest = async (username,password,grant_type,scope,tenantId,userType) => {  
  const loginInstance = axios.create({
    baseURL: envVariables.EGOV_USER_HOST,//window.location.origin,
    headers: {
      "Content-Type": "application/x-www-form-urlencoded",
      Authorization: "Basic ZWdvdi11c2VyLWNsaWVudDplZ292LXVzZXItc2VjcmV0",
    },
  });

  let apiError = "Api Error";
  var params = new URLSearchParams();
  params.append("username",username );
  params.append("password", password);  
  params.append("grant_type",grant_type );
  params.append("scope", scope);
  params.append("tenantId", tenantId);  
  params.append("userType", userType);

  try {
    const response = await loginInstance.post(`${envVariables.EGOV_USER_CONTEXT_PATH}${
      envVariables.EGOV_USER_GENERATE_ACCESS_TOKEN_ENDPOINT
    }`, params);
      
    const responseStatus = parseInt(response.status, 10);
    if (responseStatus === 200 || responseStatus === 201) {
      return response.data;
    }
  } catch (error) {
    const { data, status } = error.response;
    if (status === 400) {
      apiError = (data.hasOwnProperty("error_description") && data.error_description) || apiError;
    }
  }

  throw new Error(apiError);
};

export const pushEmployeesToPensionNotificationRegister = async body => {
  let requestBody=body ;
   let response = await httpRequest({
     hostURL: envVariables.EGOV_PENSION_HOST,
     endPoint: `${envVariables.EGOV_PENSION_CONTEXT_PATH}${
       envVariables.EGOV_PENSION_PUSH_EMPLOYEES_TO_PENSION_NOTIFICATION_REGISTER_ENDPOINT
     }`,
     requestBody
   });
   
   return response;
 };

 export const createMonthlyPensionRegister = async body => {
  let processInstances=[];
  processInstances.push({
    tenantId: envVariables.EGOV_PENSION_SCHEDULAR_TENANTID,
    effectiveYear: new Date().getFullYear(),
    effectiveMonth: new Date().getMonth()+1
    }
  );    
   let requestBody = {
    RequestInfo: body.RequestInfo,
    ProcessInstances: processInstances
   };

    
      
  let response = await httpRequest({
    hostURL: envVariables.EGOV_PENSION_HOST,
    endPoint: `${envVariables.EGOV_PENSION_CONTEXT_PATH}${
      envVariables.EGOV_PENSION_CREATE_MONTHLY_PENSION_REGISTER_ENDPOINT
    }`,
    requestBody
  });
   
   return response;
 };

 export const updatePensionRevisionBulk = async body => {
  let parameters={
    tenantId: envVariables.EGOV_PENSION_SCHEDULAR_TENANTID,
    effectiveYear: new Date().getFullYear(),
    effectiveMonth: new Date().getMonth()+1,
    modifyDA: envVariables.EGOV_PENSION_UPDATE_PENSION_REVISION_BULK_SCHEDULAR_IS_DA_MODIFIABLE,
    modifyIR: envVariables.EGOV_PENSION_UPDATE_PENSION_REVISION_BULK_SCHEDULAR_IS_IR_MODIFIABLE,
    modifyFMA: envVariables.EGOV_PENSION_UPDATE_PENSION_REVISION_BULK_SCHEDULAR_IS_FMA_MODIFIABLE,
    FMA: Number(envVariables.EGOV_PENSION_UPDATE_PENSION_REVISION_BULK_SCHEDULAR_MODIFIED_FMA)
    };
   let requestBody = {
    RequestInfo: body.RequestInfo,
    Parameters: parameters
   };

    
      
  let response = await httpRequest({
    hostURL: envVariables.EGOV_PENSION_HOST,
    endPoint: `${envVariables.EGOV_PENSION_CONTEXT_PATH}${
      envVariables.EGOV_PENSION_UPDATE_PENSION_REVISION_BULK_ENDPOINT
    }`,
    requestBody
  });
   
   return response;
 };



export const convertEpochToDate = dateEpoch => {  
  const dateFromApi = new Date(dateEpoch);  
  let month = dateFromApi.getMonth() + 1;
  let day = dateFromApi.getDate();
  let year = dateFromApi.getFullYear();
  month = (month > 9 ? "" : "0") + month;
  day = (day > 9 ? "" : "0") + day;
  return `${day}/${month}/${year}`;
};

export const convertDateToEpoch = (dateString, dayStartOrEnd = "dayend") => {
  //example input format : "2018-10-02"
  try {
    
    const parts = dateString.match(/(\d{4})-(\d{1,2})-(\d{1,2})/);
    const DateObj = new Date(Date.UTC(parts[1], parts[2] - 1, parts[3]));
    DateObj.setMinutes(DateObj.getMinutes() + DateObj.getTimezoneOffset());
    
    if (dayStartOrEnd === "dayend") {
      DateObj.setHours(DateObj.getHours() + 24);
      DateObj.setSeconds(DateObj.getSeconds() - 1);
    }
    let et = DateObj.getTime();

    //let etAdjusted = adjust530SubForYMD(et);

    return et;

  } catch (e) {
    return dateString;
  }
};

export const convertDateToEpochForDeathDate = (dateString, dayStartOrEnd = "dayend") => {
  //example input format : "2018-10-02"
  try {
    
    const parts = dateString.match(/(\d{4})-(\d{1,2})-(\d{1,2})/);
    const DateObj = new Date(Date.UTC(parts[1], parts[2] - 1, parts[3]));
    DateObj.setMinutes(DateObj.getMinutes() + DateObj.getTimezoneOffset());
    
    if (dayStartOrEnd === "dayend") {
      DateObj.setHours(DateObj.getHours() + 24);
      DateObj.setSeconds(DateObj.getSeconds() - 1);
    }
    let et = DateObj.getTime();

    let etAdjustedForDeathDate = adjust530AddForDeathDate(et);

    return etAdjustedForDeathDate;

  } catch (e) {
    return dateString;
  }
};

export const convertDateToEpochForMigration = (dateString, dayStartOrEnd = "dayend") => {
  //example input format : "2018-10-02"
  try {
    
    const parts = dateString.match(/(\d{4})-(\d{1,2})-(\d{1,2})/);
    const DateObj = new Date(Date.UTC(parts[1], parts[2] - 1, parts[3]));
    DateObj.setMinutes(DateObj.getMinutes() + DateObj.getTimezoneOffset());
    
    if (dayStartOrEnd === "dayend") {
      DateObj.setHours(DateObj.getHours() + 24);
      DateObj.setSeconds(DateObj.getSeconds() - 1);
    }
    let et = DateObj.getTime();

    let etAdjusted = adjust530SubForMigration(et);

    return etAdjusted;

  } catch (e) {
    return dateString;
  }
};

export const getEpochForDate = date => {
  const dateSplit = date.split("/");
  return new Date(dateSplit[2], dateSplit[1] - 1, dateSplit[0]).getTime();
};

export const adjust530 = (actualDateNum) => {
  /* let modifiedDate = new Date(Number(actualDateNum));
  if(modifiedDate.getHours()>0){
  modifiedDate.setHours(modifiedDate.getHours() + 5);
  modifiedDate.setMinutes(modifiedDate.getMinutes() + 30);
  }
  let modifiedDateNum = Number(modifiedDate);
  return modifiedDateNum; */
  return actualDateNum;
}

export const adjust530AddForYMD = (actualDateNum) => {
  /* let modifiedDate = new Date(Number(actualDateNum));
  if(modifiedDate.getHours()>0){
  modifiedDate.setHours(modifiedDate.getHours() + 5);
  modifiedDate.setMinutes(modifiedDate.getMinutes() + 30);
  }
  let modifiedDateNum = Number(modifiedDate);
  return modifiedDateNum;  */
  return actualDateNum;
}

export const adjust530AddForDeathRegistration = (actualDateNum) => {
  let modifiedDate = new Date(Number(actualDateNum));
  if(modifiedDate.getHours()>0){
  modifiedDate.setHours(modifiedDate.getHours() + 5);
  modifiedDate.setMinutes(modifiedDate.getMinutes() + 30);
  }
  let modifiedDateNum = Number(modifiedDate);
  return modifiedDateNum;  
  //return actualDateNum;
}

export const adjust530AddForDob = (actualDateNum) => {
  let modifiedDate = new Date(Number(actualDateNum));
  if(modifiedDate.getHours()>0){
  modifiedDate.setHours(modifiedDate.getHours() + 5);
  modifiedDate.setMinutes(modifiedDate.getMinutes() + 30);
  }
  let modifiedDateNum = Number(modifiedDate);
  return modifiedDateNum;  
  //return actualDateNum;
}

export const adjust530SubForYMD = (actualDateNum) => {
  /* let modifiedDate = new Date(Number(actualDateNum));
  if(modifiedDate.getHours()==0){
  modifiedDate.setHours(modifiedDate.getHours() - 5);
  modifiedDate.setMinutes(modifiedDate.getMinutes() - 30);
  }
  let modifiedDateNum = Number(modifiedDate);
  return modifiedDateNum;  */
  return actualDateNum;
}

export const adjust530AddForDeathDate = (actualDateNum) => {
  /* let modifiedDate = new Date(Number(actualDateNum));
  if(modifiedDate.getHours()==0){
  modifiedDate.setHours(modifiedDate.getHours() + 18);
  modifiedDate.setMinutes(modifiedDate.getMinutes() + 30);
  }
  let modifiedDateNum = Number(modifiedDate);
  return modifiedDateNum;  */
  return actualDateNum;
}


export const adjust530SubForMigration = (actualDateNum) => {
  /* let modifiedDate = new Date(Number(actualDateNum));
  if(modifiedDate.getHours()==0){
  modifiedDate.setHours(modifiedDate.getHours() - 5);
  modifiedDate.setMinutes(modifiedDate.getMinutes() - 30);
  }
  //let modifiedDateNum = Number(modifiedDate); */
  //return modifiedDateNum;  
  return actualDateNum;
}

export const epochToYmd = et => {
  // Return null if et already null
  if (!et) return null;
  // Return the same format if et is already a string (boundary case)
  if (typeof et === "string") return et;
  
  let etAdjusted = adjust530AddForYMD(et);
  let date = new Date(etAdjusted);
  //let hours = date.getHours();
  //if(hours>0){
    //date = addDays(date, 1);
  //}
  let day = date.getDate() < 10 ? `0${date.getDate()}` : date.getDate();
  let month =
    date.getMonth() + 1 < 10 ? `0${date.getMonth() + 1}` : date.getMonth() + 1;
  // date = `${date.getFullYear()}-${month}-${day}`;
  var formatted_date = date.getFullYear() + "-" + month + "-" + day;
  return formatted_date;
};

export const epochToDmy = et => {
  // Return null if et already null
  if (!et) return null;
  // Return the same format if et is already a string (boundary case)
  if (typeof et === "string") return et;
  let date = new Date(et);
  let day = date.getDate() < 10 ? `0${date.getDate()}` : date.getDate();
  let month =
    date.getMonth() + 1 < 10 ? `0${date.getMonth() + 1}` : date.getMonth() + 1;
  // date = `${date.getFullYear()}-${month}-${day}`;
  var formatted_date =day + "/" +  month + "/" + date.getFullYear();
  return formatted_date;
};



