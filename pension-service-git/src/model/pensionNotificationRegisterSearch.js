const PensionNotificationRegisterSearchRequest = {
  summary: "Get the list of Employee(s) defined in the system.",
  description:
    "1. Search and get Employee(s) based on defined search criteria.",
  properties: {
    tenantId: {
      type: "string",
      minLength: 2,
      maxLength: 250
    },
    pageNumber: {
      type: "integer",
    },   
    code: {
      type: "string",
      minLength: 2,
      maxLength: 250
    },
    name: {
      type: "string",
      minLength: 2,
      maxLength: 250
    },
    dob: {
      type: "string",
      minLength: 2,
      maxLength: 64
    }
  },
  required: ["tenantId"]
};

module.exports = PensionNotificationRegisterSearchRequest;
