import get from "lodash/get";
import some from "lodash/some";

const pensionNotificationRegisterSearchSchema = require("../model/pensionNotificationRegisterSearch.js");
const workflowSearchSchema = require("../model/workflowSearch");

const getAjvInstance = () => {
  const Ajv = require("ajv");
  const ajv = new Ajv({ allErrors: true });
  return ajv;
};



export const validatePensionNotificationRegisterSearchModel = data => {
  const ajv = getAjvInstance();
  let validate = ajv.compile(pensionNotificationRegisterSearchSchema);
  var valid = validate(data);
  let errors = [];
  if (!valid) {
    errors = validate.errors;
  }
  return errors;
};

export const validateWorkflowSearchModel = data => {
  const ajv = getAjvInstance();
  let validate = ajv.compile(workflowSearchSchema);
  var valid = validate(data);
  let errors = [];
  if (!valid) {
    errors = validate.errors;
  }
  return errors;
};
