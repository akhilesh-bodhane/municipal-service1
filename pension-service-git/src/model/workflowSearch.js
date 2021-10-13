const WorkflowSearchRequest = {
  summary: "Get pension workflow(s) details.",
  description:
    "1. Search and get pension workflow(s) based on defined search criteria.",
  properties: {
    tenantId: {
      type: "string",
      minLength: 2,
      maxLength: 250
    },
    businessIds: {
      type: "string",
      minLength: 2,
      maxLength: 1024
    }
  },
  required: ["tenantId"]
};

module.exports = WorkflowSearchRequest;
