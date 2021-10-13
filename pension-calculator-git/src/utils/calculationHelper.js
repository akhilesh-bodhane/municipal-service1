import uniqBy from "lodash/uniqBy";
import uniq from "lodash/uniq";
import get from "lodash/get";
import filter from "lodash/filter";
import findIndex from "lodash/findIndex";
import isEmpty from "lodash/isEmpty";
import lte from "lodash/lte";
import gte from "lodash/gte";
import orderBy from "lodash/orderBy";
import { httpRequest, httpGetRequest } from "./api";
import envVariables from "../envVariables";
import { from } from "linq";
const math=require("mathjs");
var DateDiff=require("date-diff")

export const getYearOfService = (employee) => { 
    let yearsOfService=getNQSYear(employee);     
    return yearsOfService;
};

export const getHalfYearOfService = (employee) => { 
  let halfYearsOfService=getNQSYear(employee)*2;
  let nqsMonth=getNQSMonth(employee);
  if(nqsMonth>=3){
    halfYearsOfService +=1;
    if(nqsMonth>=9){
      halfYearsOfService +=1;
    };
  };
    
  return halfYearsOfService;
};

export const getNQSYear = (employee) => { 
  let nqsYear=0;
  
  let nqs=getNQS(employee);
  if(nqs){
    nqsYear=Number(nqs.split("|")[0]);
  }
  
  return nqsYear;
};

export const getNQSMonth = (employee) => { 
  let nqsMonths=0;
  
  let nqs=getNQS(employee);
  if(nqs){
    nqsMonths=Number(nqs.split("|")[1]);
  }
  
  return nqsMonths;
};

export const getNQSDay = (employee) => { 
  let nqsDay=0;
  
  let nqs=getNQS(employee);
  if(nqs){
    nqsDay=Number(nqs.split("|")[2]);
  }
  
  return nqsDay;
};

//Net Qualifying Service as Years|Months|Days
export const getNQS = (employee) => { 
  let nqs="";
 
  let gqs=getGQS(employee);
  let gqsDays=Number(gqs.split("|")[2]);
  let gqsMonths=Number(gqs.split("|")[1]);
  let gqsYears=Number(gqs.split("|")[0]);
  let days=gqsDays;
  let months=gqsMonths;
  let years=gqsYears;
    
  let totalNoPayLeavesDays=employee.totalNoPayLeavesDays?Number(employee.totalNoPayLeavesDays):0;
  let totalNoPayLeavesMonths=employee.totalNoPayLeavesMonths?Number(employee.totalNoPayLeavesMonths):0;
  let totalNoPayLeavesYears=employee.totalNoPayLeavesYears?Number(employee.totalNoPayLeavesYears):0;

  if(days>=totalNoPayLeavesDays){
    days=days-totalNoPayLeavesDays;
  }
  else{
    if(months>0){      
      days=days+30-totalNoPayLeavesDays;      
      months=months-1;
    }
    else{
      years=years-1;
      months=months+12;
      days=days+30-totalNoPayLeavesDays; 
      months=months-1;
    }
  }
  if(months>=totalNoPayLeavesMonths){
    months=months-totalNoPayLeavesMonths;
  }
  else{   
    months=months+12-totalNoPayLeavesMonths;
    years=years-1;
  }
  years=years-totalNoPayLeavesYears;
  
  

  //years=Math.trunc(months/12) ;
  //months -=(years*12);
  nqs=`${years}|${months}|${days}`;
  
  return nqs;
};

//Gross Qualifying Service as Years|Months|Days
export const getGQS = (employee) => { 
  let gqs="";
  let years=0;
  let months=0;
  let days=0;  

  let serviceHistory=employee.serviceHistory[0];
  let dtStart=new Date(serviceHistory.serviceFrom) ;
  dtStart=new Date(dtStart.getFullYear(),dtStart.getMonth(),dtStart.getDate()+1); 
  let dtEnd=new Date(serviceHistory.serviceTo?serviceHistory.serviceTo:employee.dateOfRetirement);  
  switch(employee.reasonForRetirement) {
    case "DEATH_AS_EMPLOYEE":
      dtEnd=new Date(employee.dateOfDeath);
      break;    
  }      
  let monthsDaysInRange=getMonthsDaysInRange(dtStart,dtEnd);
  months = Number(monthsDaysInRange.split("|")[0]);
  days = Number(monthsDaysInRange.split("|")[1]);    
  
  if(days>=30){
      months+=1;
      days-=30;
  }
  
  years=Math.trunc(months/12) ;
  months -=(years*12);

  gqs=`${years}|${months}|${days}`;
  
  return gqs;
};

export const getGQSYear = (employee) => { 
  let gqsYears=0;
  
  let gqs=getGQS(employee);
  if(gqs){
    gqsYears=Number(gqs.split("|")[0]);
  }
  
  return gqsYears;
};

export const getGQSMonth = (employee) => { 
  let gqsMonths=0;
  
  let gqs=getGQS(employee);
  if(gqs){
    gqsMonths=Number(gqs.split("|")[1]);
  }
  
  return gqsMonths;
};

export const getGQSDay = (employee) => { 
  let gqsDays=0;
  
  let gqs=getGQS(employee);
  if(gqs){
    gqsDays=Number(gqs.split("|")[2]);
  }
  
  return gqsDays;
};

export const getMonthsDaysInRange = (dtStart,dtEnd) => { 
  let startDate=new Date(dtStart);
  let endDate=new Date(dtEnd);
  let days = 0;
  let months = 0;  
  let tempMonth = 0;
  let tempYear = 0;
  let Months=0;
  let Days=0;  
  
  if (startDate.getDate() == 1 && isDateLastDayOfMonth(endDate))
  {
      
      Months = (endDate.getFullYear()*12+endDate.getMonth())-(startDate.getFullYear()*12+startDate.getMonth()-1);
      Days = 0;
  }
  else
  {      
      if (endDate.getDate() < startDate.getDate())
      {
          days = (endDate.getDate() + 30 + 1) - startDate.getDate();
          tempMonth = endDate.getMonth() - 1;

          if (tempMonth < startDate.getMonth())
          {
              tempMonth = tempMonth + 12;
              tempYear = endDate.getFullYear() - 1;
              months += tempMonth - startDate.getMonth();
              months += (tempYear - startDate.getFullYear()) * 12;
          }
          else
          {
              months += tempMonth - startDate.getMonth();
              months += (endDate.getFullYear() - startDate.getFullYear()) * 12;
          }                    
      }
      else
      {
          days = (endDate.getDate() + 1) - startDate.getDate();
          tempMonth = endDate.getMonth();

          if (tempMonth < startDate.getMonth())
          {
              tempMonth = tempMonth+ 12;
              tempYear = endDate.getFullYear() - 1;
              months += tempMonth - startDate.getMonth();
              months += (tempYear - startDate.getFullYear()) * 12;
          }
          else
          {
              months += tempMonth - startDate.getMonth();
              months += (endDate.getFullYear()  - startDate.getFullYear()) * 12;
          }
      }
      
      Months = months;
      Days = days;      
      /*
      let LastDayofMonth = lastDayOfMonth(endDate.getMonth(), endDate.getFullYear());      
      if (Days >= LastDayofMonth)
      {
          Months = Months +1;
          Days = Days- LastDayofMonth;
      } 
      */     
  } 

  let monthDays=`${Months}|${Days}`;
  
  return monthDays;

};

export const isDateLastDayOfMonth = (date) => {
  let isDateLastDayOfMonth=false;
  if(new Date(date).getDate()==lastDayOfMonth(new Date(date).getMonth()+1,new Date(date).getFullYear())){
    isDateLastDayOfMonth=true;
  }
  return isDateLastDayOfMonth;
};

export const lastDayOfMonth = (month,year) => {
  let lastDayOfMonth=30;
  switch (month)
  {
      case 1:
      case 3:
      case 5:
      case 7:
      case 8:
      case 10:
      case 12:
        lastDayOfMonth = 31;
          break;
      case 4:
      case 6:
      case 9:
      case 11:
        lastDayOfMonth = 30;
          break;
      case 2:
          if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0))
          {
            lastDayOfMonth = 29;
          }
          else
          {
            lastDayOfMonth = 28;
          }
          break;

  }
  return lastDayOfMonth;
};

export const getDAPercentage = (employee,mdms) => { 
  let value=0;
  const mdmsDAPercentage=get(mdms,"MdmsRes.pension.DAPercentage");  
  //const mdmsDAPercentage=get(mdms,"DAPercentage");  

  let daPercentageList;
  if(employee.businessService=="RRP_SERVICE"){
    daPercentageList=filter(mdmsDAPercentage,function(x){return gte(new Date(employee.dateOfRetirement),new Date(x.startDate)) 
      && ((lte(new Date(employee.dateOfRetirement),new Date(x.endDate)) && x.endDate!=null) || x.endDate==null);});
  }else{

  daPercentageList=filter(mdmsDAPercentage,function(x){return gte(new Date(employee.dateOfDeath),new Date(x.startDate)) 
    && ((lte(new Date(employee.dateOfDeath),new Date(x.endDate)) && x.endDate!=null) || x.endDate==null);});
  }

  if(daPercentageList && daPercentageList.length>0){
    value=daPercentageList[0]? daPercentageList[0].value:0;
  }
  else{
    /* daPercentageList=filter(mdmsDAPercentage,function(x){return gte(new Date(employee.dateOfRetirement),new Date(x.startDate)) 
     && x.endDate==null;});

    if(daPercentageList && daPercentageList.length>0){
      value=daPercentageList[0]? daPercentageList[0].value:0;
    } */
value=0;
  }
  
  return value;
};

export const getCommutationPercentage = (employee,mdms) => { 
  let value=0;
  const mdmsCommutationPercentage=get(mdms,"MdmsRes.pension.CommutationPercentage");  
  //const mdmsCommutationPercentage=get(mdms,"CommutationPercentage");  
  let commutationPercentageList=filter(mdmsCommutationPercentage,function(x){return gte(new Date(employee.dateOfRetirement),new Date(x.startDate)) 
    && lte(new Date(employee.dateOfRetirement),new Date(x.endDate)) && x.endDate!=null;});

  if(commutationPercentageList && commutationPercentageList.length>0){
    value=commutationPercentageList[0]? commutationPercentageList[0].value:0;
  }
  else{
    commutationPercentageList=filter(mdmsCommutationPercentage,function(x){return gte(new Date(employee.dateOfRetirement),new Date(x.startDate)) 
      && x.endDate==null;});

    if(commutationPercentageList && commutationPercentageList.length>0){
      value=commutationPercentageList[0]? commutationPercentageList[0].value:0;
    }

  }
  
  return value;
};

export const getCommutationMultiplier = (employee,mdms) => { 
  let value=0;    
  //let age=getAge(employee.dob);
  let age=getAgeOnRetirementDate(employee.dob,employee.dateOfRetirement);
  let ageOnNextBirthDay=age+1;  
  
  const mdmsCommutationMultiplier=get(mdms,"MdmsRes.pension.CommutationMultiplier");  
  //const mdmsCommutationMultiplier=get(mdms,"CommutationMultiplier"); 
  let commutationMultiplierList=filter(mdmsCommutationMultiplier,function(x){return x.ageOnNextBirthDay==ageOnNextBirthDay;});

  if(commutationMultiplierList && commutationMultiplierList.length>0){
    value=commutationMultiplierList[0]? commutationMultiplierList[0].value:0;
  }
  
  
  return value;
};

export const getIRPercentage = (employee,mdms) => { 
  let value=0;
  const mdmsIRPercentage=get(mdms,"MdmsRes.pension.IRPercentage");  
  //const mdmsIRPercentage=get(mdms,"IRPercentage");  


  let irPercentageList;

  if(employee.businessService=="RRP_SERVICE"){
    irPercentageList=filter(mdmsIRPercentage,function(x){return gte(new Date(employee.dateOfRetirement),new Date(x.startDate)) 
      && ((lte(new Date(employee.dateOfRetirement),new Date(x.endDate)) && x.endDate!=null) || x.endDate==null);});

  }
  else{
    irPercentageList=filter(mdmsIRPercentage,function(x){return gte(new Date(employee.dateOfDeath),new Date(x.startDate)) 
      && ((lte(new Date(employee.dateOfDeath),new Date(x.endDate)) && x.endDate!=null) || x.endDate==null);});
  }
  
  if(irPercentageList && irPercentageList.length>0){
    value=irPercentageList[0]? irPercentageList[0].value:0;
  }
  else{
    /* irPercentageList=filter(mdmsIRPercentage,function(x){return gte(new Date(employee.dateOfRetirement),new Date(x.startDate)) 
      && x.endDate==null;});

    if(irPercentageList && irPercentageList.length>0){
      value=irPercentageList[0]? irPercentageList[0].value:0;
    } */

    value=0;

  }
  
  return value;
};

export const getAdditionalPensionPercentage = (employee,mdms) => { 
  let value=0;
  //let age=getAge(employee.dob);
  let age=getAgeOnRetirementDate(employee.dob,employee.dateOfRetirement);
  const mdmsAdditionalPensionPercentage=get(mdms,"MdmsRes.pension.AdditionalPensionPercentage");  
  //const mdmsAdditionalPensionPercentage=get(mdms,"AdditionalPensionPercentage");
  let additionalPensionPercentageList=filter(mdmsAdditionalPensionPercentage,function(x){return gte(age,x.fromAge) 
                        && lte(age,Number(x.toAge)) && x.toAge!=null;});

  if(additionalPensionPercentageList && additionalPensionPercentageList.length>0){
    value=additionalPensionPercentageList[0].value;
  }
  else{
    additionalPensionPercentageList=filter(mdmsAdditionalPensionPercentage,function(x){return gte(age,x.fromAge)
      && x.toAge==null;});

    if(additionalPensionPercentageList && additionalPensionPercentageList.length>0){
      value=additionalPensionPercentageList[0].value;
    }

  }
  
  return value;
};

export const getPensionConfigurationValue = (key,mdms) => { 
  let value="";    
  
  const mdmsConfigurations=get(mdms,"MdmsRes.pension.PensionConfig");  
  //const mdmsConfigurations=get(mdms,"configurations");
  let configurationsList=filter(mdmsConfigurations,function(x){return x.key==key;});

  if(configurationsList && configurationsList.length>0){
    value=configurationsList[0].value;
  }
  
  return value;
};

export const getDOJ = (employee) => { 
  let doj="";
  let serviceHistory=employee.serviceHistory[0];
  doj=serviceHistory.serviceFrom;     
  return doj;
};

export const getAge = (dob) => { 
  let age=0;  
  let currentDateTime=new Date();
  let today=new Date(currentDateTime.getFullYear(),currentDateTime.getMonth(),currentDateTime.getDate());
  let currentYearDOB=new Date(today.getFullYear(),new Date(dob).getMonth(),new Date(dob).getDate());
  if(currentYearDOB>today){
    age=today.getFullYear()-new Date(dob).getFullYear()-1;
  }
  else{
    age=today.getFullYear()-new Date(dob).getFullYear();
  }
  
  
  return age;
};

export const getAgeOnRetirementDate = (dob,dateOfRetirement) => { 
  let age=0;  
  //let currentDateTime=new Date();
  let today=new Date(dateOfRetirement);
  let dobOnRetirementYear=new Date(today.getFullYear(),new Date(dob).getMonth(),new Date(dob).getDate());

  if(dobOnRetirementYear>today){
    age=today.getFullYear()-new Date(dob).getFullYear()-1;
  }
  else{
    age=today.getFullYear()-new Date(dob).getFullYear();
  }
  
  
  return age;
};

export const isEldestDependent = (dependent,dependents) => { 
  let isEldestDependent=false;
  let dependentAge=getAge(dependent.dob);  

  let eligibleDependents=filter(dependents,function(x){return (x.relationship=="SON" || x.relationship=="DAUGHTER") && x.isEligibleForGratuity==true; });
  if(eligibleDependents && eligibleDependents.length==1){
    isEldestDependent=true;
  }
  else{
    for (var i = 0; i < eligibleDependents.length; i++) { 
      eligibleDependents[i].age=getAge(eligibleDependents[i].dob);           
    }
    let eldestGratuityEligibleDependent=orderBy(eligibleDependents,['age'],['desc']);
    if(eldestGratuityEligibleDependent[0].dob==dependent.dob 
      && eldestGratuityEligibleDependent[0].name==dependent.name
      && eldestGratuityEligibleDependent[0].relationship==dependent.relationship){
        isEldestDependent=true;
      }

  }
 
  
  return isEldestDependent;
};

export const getAdditionalPensionPercentageForFamily = (dependents,mdms) => { 
  let value=0;
  let pensionEligibleDependents=filter(dependents, function(x){return x.isEligibleForPension==true;});

  if(pensionEligibleDependents && pensionEligibleDependents.length>0){
    let dependent=pensionEligibleDependents[0];
    let age=getAge(dependent.dob);
    const mdmsAdditionalPensionPercentage=get(mdms,"MdmsRes.pension.AdditionalPensionPercentage");  
    //const mdmsAdditionalPensionPercentage=get(mdms,"AdditionalPensionPercentage");
    let additionalPensionPercentageList=filter(mdmsAdditionalPensionPercentage,function(x){return gte(age,x.fromAge)
      && x.toAge==null;});

      if(additionalPensionPercentageList && additionalPensionPercentageList.length>0){
        value=additionalPensionPercentageList[0].value;
      }
      else{
        additionalPensionPercentageList=filter(mdmsAdditionalPensionPercentage,function(x){return gte(age,x.fromAge)
          && x.toAge==null;});
    
        if(additionalPensionPercentageList && additionalPensionPercentageList.length>0){
          value=additionalPensionPercentageList[0].value;
        }    
      }    
  }
  

  
  
  return value;
};









