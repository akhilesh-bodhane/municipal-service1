import { Router } from "express";
import { calculateBenefit,getNotifications,getEmployeeType} from "../utils/calculationManager";
import { getNQSYear,getNQSMonth,getNQSDay, getGQSYear,getGQSMonth,getGQSDay} from "../utils/calculationHelper";
import envVariables from "../envVariables";
import { requestInfoToResponseInfo} from "../utils";
import mdmsData from "../utils/mdmsData";
import isEmpty from "lodash/isEmpty";
import set from "lodash/set";
import get from "lodash/get";
const asyncHandler = require("express-async-handler");


export default () => {
  let api = Router();
  api.post(
    "/_calculateBenefit",
    asyncHandler(async ({ body }, res, next) => {
    
    
    
    
    
    let mdms = await mdmsData(body.RequestInfo, body.ProcessInstances[0].tenantId);
    const pensionBenefits=get(mdms,"MdmsRes.pension.benefits");    
    
    let rules={
        benefits: pensionBenefits
    };
    
    
    let employee=body.ProcessInstances[0].employee;
    //employee type should be as per rules
    let employeeType=getEmployeeType(employee,mdms);
    employee.employeeType=employeeType;
    
            
    let benefits=calculateBenefit(rules,employee,mdms);
    
    let notifications=getNotifications(employee,mdms);
    let notificationText="";
    for (var i = 0; i < notifications.length; i++) {    
      notificationText=`${notificationText}${notifications[i].notificationText} `
    }
      
    let pensionCalculationDetails={
      nqsYearSystem: getNQSYear(employee),
      nqsMonthSystem: getNQSMonth(employee),
      nqsDaySystem: getNQSDay(employee),
      basicPensionSystem: 0,
      pensionDeductionsSystem: 0,
      additionalPensionSystem: 0,
      commutedPensionSystem: 0,
      commutedValueSystem: 0,
      familyPensionISystem: 0,
      familyPensionIISystem: 0,
      dcrgSystem: 0,
      netDeductionsSystem: 0,
      totalPensionSystem: 0,
      finalCalculatedPensionSystem: 0,
      interimReliefSystem: 0,
      interimReliefLpdSystem: 0,
      daSystem: 0,
      daLpdSystem: 0,
      duesDeductionsSystem: 0,
      compassionatePensionSystem: 0,
      compensationPensionSystem: 0,
      terminalBenefitSystem: 0,
      finalCalculatedGratuitySystem: 0,        
      familyPensionIStartDateSystem: null,
      familyPensionIEndDateSystem: null,
      familyPensionIIStartDateSystem: null,
      exGratiaSystem: 0,
      pensionerFamilyPensionSystem: 0,
      additionalPensionerFamilyPensionSystem: 0,
      totalPensionSystem: 0,
      provisionalPensionSystem: 0,
      invalidPensionSystem: 0,
      woundExtraordinaryPensionSystem: 0,
      attendantAllowanceSystem: 0,
      gqsYearSystem: getGQSYear(employee),
      gqsMonthSystem: getGQSMonth(employee),
      gqsDaySystem: getGQSDay(employee),   
      notificationTextSystem: notificationText    
    };
    
    
    let employeeBenefits=[];
    employeeBenefits.push({
      benefits: benefits,
      pensionCalculationDetails: pensionCalculationDetails//,
      //notifications: notifications

    });
     
    let response = {        
      ResponseInfo: requestInfoToResponseInfo(body.RequestInfo, true),
      EmployeeBenefits:employeeBenefits
    };
    res.json(response);
           
    })
  );
  return api;
};
