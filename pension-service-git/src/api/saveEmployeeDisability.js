import { Router } from "express";
import producer from "../kafka/producer";
import { requestInfoToResponseInfo,getPensionEmployees} from "../utils";
import { addUUIDAndAuditDetailsDisabilityRegistration } from "../utils/create";
import envVariables from "../envVariables";
import mdmsData from "../utils/mdmsData";
import { Message} from "../utils/message";
import isEmpty from "lodash/isEmpty";
import set from "lodash/set";
import get from "lodash/get";
import filter from "lodash/filter";
import { intConversion} from "../utils/search";
const asyncHandler = require("express-async-handler");

export default ({ config, db }) => {
  let api = Router();
  api.post(
    "/_saveEmployeeDisability",
    asyncHandler(async ({ body }, res, next) => {
      let payloads = [];
      //getting mdms data      
         
       //getting mdms data
       let mdms = await mdmsData(body.RequestInfo, body.Employees[0].tenantId);
       
       const mdmsDisability=get(mdms,"MdmsRes.pension.Disability");  
       let disability=filter(mdmsDisability,function(x){return x.code==body.Employees[0].severityOfDisability;});
       if(disability.length==0){

        const message=Message();                  
        
        let errors = message.DISABILITY_PERCENTAGE_NOT_SET;
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
      
       let disabilityPercentage=Number(disability[0].value);
       body.Employees[0].disabilityPercentage=disabilityPercentage;

       let pensionEmployeeId="";
       let pensionResponse=await getPensionEmployees(body.RequestInfo,body.Employees[0].tenantId,body.Employees[0].code);
       let pensionEmployeesList=pensionResponse.Employees;
       if(pensionEmployeesList.length>0){
        pensionEmployeeId=pensionEmployeesList[0].uuid;
        body.Employees[0].uuid=pensionEmployeeId;
       }
       
       body = await addUUIDAndAuditDetailsDisabilityRegistration(body);

       payloads.push({
        topic: envVariables.KAFKA_TOPICS_SAVE_DISABILITY_DETAILS,
        messages: JSON.stringify(body)
      });
      producer.send(payloads, function(err, data) {
        let response = {
          ResponseInfo: requestInfoToResponseInfo(body.RequestInfo, true),
          Employees: body.Employees
        };
        res.json(response);
      });
       

     
    })
  );
  return api;
};
