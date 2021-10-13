import { Router } from "express";
import producer from "../kafka/producer";
import { requestInfoToResponseInfo, createUserEventToUser,createUserEventToRole} from "../utils";
import envVariables from "../envVariables";
import mdmsData from "../utils/mdmsData";
import { Message} from "../utils/message";
import set from "lodash/set";
import get from "lodash/get";
const asyncHandler = require("express-async-handler");

export default ({ config, db }) => {
  let api = Router();
  api.post(
    "/_saveEmployeeToPensionNotificationRegister",
    asyncHandler(async ({ body }, res, next) => {
      let payloads = [];
            
      const message=Message();

      //let userEventToUserResponse=await createUserEventToUser(body,body.Employees[0].tenantId,message.EMPLOYEE_PUSHED_TO_PNR_USER_EVENT_NAME,message.EMPLOYEE_PUSHED_TO_PNR_USER_EVENT_DESCRIPTION,body.Employees[0].uuid); 
      
      if(body.Employees.length>0){
        //let userEventToRoleResponse=await createUserEventToRole(body,body.Employees[0].tenantId,message.PNR_GENERATED_USER_EVENT_NAME,message.PNR_GENERATED_USER_EVENT_DESCRIPTION,envVariables.EGOV_MONTHLY_PNR_GENERATED_USER_EVENT_ROLE); 
        
      }
     
      payloads.push({
        topic: envVariables.KAFKA_TOPICS_SAVE_EMPLOYEE_TO_PENSION_NOTIFICATION_REGISTER,
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
