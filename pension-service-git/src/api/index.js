import { version } from "../../package.json";
import { Router } from "express";
import saveEmployeeToPensionNotificationRegister from "./saveEmployeeToPensionNotificationRegister";
import searchPensionNotificationRegister from "./searchPensionNotificationRegister";
import processWorkflow from "./processWorkflow";
import searchWorkflow from "./searchWorkflow";
import searchEmployeeFromHRMS from "./searchEmployeeFromHRMS";
import getWorkflowAccessibility from "./getWorkflowAccessibility";
import claimWorkflow from "./claimWorkflow";
import releaseWorkflow from "./releaseWorkflow";
import saveEmployees from "./saveEmployees";
import getEpochForDate from "./getEpochForDate";
import convertDateToEpoch from "./convertDateToEpoch";
import searchEmployee from "./searchEmployee";
import closeWorkflow from "./closeWorkflow";
import calculateBenefit from "./calculateBenefit";
import checkDependentEligibilityForBenefit from "./checkDependentEligibilityForBenefit";
import getPensionEmployees from "./getPensionEmployees";
import searchPensioner from "./searchPensioner";
import searchPensionerForPensionRevision from "./searchPensionerForPensionRevision";
import updateRevisedPension from "./updateRevisedPension";
import createRevisedPension from "./createRevisedPension";
import createMonthlyPensionRegister from "./createMonthlyPensionRegister";
import searchWorkflowPaymentDetails from "./searchWorkflowPaymentDetails";
import getPensionRevisions from "./getPensionRevisions";
import closeWorkflowByUser from "./closeWorkflowByUser";
import searchPensionRegister from "./searchPensionRegister";
import pushManualRegisterToPensionNotificationRegister from "./pushManualRegisterToPensionNotificationRegister";
import saveEmployeeDisability from "./saveEmployeeDisability";
import getEmployeeDisability from "./getEmployeeDisability";
import pensionerPensionDiscontinuation from "./pensionerPensionDiscontinuation";
import searchClosedApplication from "./searchClosedApplication";
import initiateReComputation from "./initiateReComputation";
import searchApplication from "./searchApplication";
import pushEmployeesToPensionNotificationRegister from "./pushEmployeesToPensionNotificationRegister";
import saveMigratedPensioner from "./saveMigratedPensioner";
import updatePensionRevisionBulk from "./updatePensionRevisionBulk";
import searchPensionDisbursement from "./searchPensionDisbursement";


export default ({ config, db }) => {
  let api = Router();

  api.use("/pension-services/v1", saveEmployeeToPensionNotificationRegister({ config, db }));
  api.use("/pension-services/v1", searchPensionNotificationRegister({ config, db }));
  api.use("/pension-services/v1", processWorkflow({ config, db }));
  api.use("/pension-services/v1", searchWorkflow({ config, db }));
  api.use("/pension-services/v1", searchEmployeeFromHRMS({ config, db }));
  api.use("/pension-services/v1", getWorkflowAccessibility({ config, db }));
  api.use("/pension-services/v1", claimWorkflow({ config, db }));
  api.use("/pension-services/v1", releaseWorkflow({ config, db }));
  api.use("/pension-services/v1", convertDateToEpoch({ config, db }));
  api.use("/pension-services/v1", getEpochForDate({ config, db }));
  api.use("/pension-services/v1", saveEmployees({ config, db }));
  api.use("/pension-services/v1", searchEmployee({ config, db }));
  api.use("/pension-services/v1", closeWorkflow({ config, db }));
  api.use("/pension-services/v1", calculateBenefit({ config, db }));  
  api.use("/pension-services/v1", checkDependentEligibilityForBenefit({ config, db }));
  api.use("/pension-services/v1", getPensionEmployees({ config, db }));
  api.use("/pension-services/v1", searchPensioner({ config, db }));
  api.use("/pension-services/v1", searchPensionerForPensionRevision({ config, db }));
  api.use("/pension-services/v1", createRevisedPension({ config, db }));
  api.use("/pension-services/v1", updateRevisedPension({ config, db }));  
  api.use("/pension-services/v1", createMonthlyPensionRegister({ config, db }));     
  api.use("/pension-services/v1", searchWorkflowPaymentDetails({ config, db }));  
  api.use("/pension-services/v1", getPensionRevisions({ config, db }));
  api.use("/pension-services/v1", closeWorkflowByUser({ config, db }));
  api.use("/pension-services/v1", searchPensionRegister({ config, db }));
  api.use("/pension-services/v1", pushManualRegisterToPensionNotificationRegister({ config, db }));
  api.use("/pension-services/v1", saveEmployeeDisability({ config, db }));
  api.use("/pension-services/v1", getEmployeeDisability({ config, db }));
  api.use("/pension-services/v1", pensionerPensionDiscontinuation({ config, db }));
  api.use("/pension-services/v1", searchClosedApplication({ config, db }));
  api.use("/pension-services/v1", initiateReComputation({ config, db }));
  api.use("/pension-services/v1", searchApplication({ config, db }));
  api.use("/pension-services/v1", pushEmployeesToPensionNotificationRegister({ config, db }));
  api.use("/pension-services/v1", saveMigratedPensioner({ config, db }));
  api.use("/pension-services/v1", updatePensionRevisionBulk({ config, db }));
  api.use("/pension-services/v1", searchPensionDisbursement({ config, db }));
  
  // perhaps expose some API metadata at the root
  api.get("/", (req, res) => {
    res.json({ version });
  });

  return api;
};
