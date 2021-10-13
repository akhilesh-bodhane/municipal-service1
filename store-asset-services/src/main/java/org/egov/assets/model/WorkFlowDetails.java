package org.egov.assets.model;

import java.util.List;
import java.util.Objects;

import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * An Object to hold the Application workflow details for a given Object like
 * Indent, Material Transfer, Purchase Order, Material Issue, Outward Notice,
 * Inward Notice etc.
 */
@javax.annotation.Generated(value = "org.egov.inv.codegen.languages.SpringCodegen", date = "2017-11-08T13:51:07.770Z")

public class WorkFlowDetails {
	@JsonProperty("type")
	private String type = null;

	@JsonProperty("businessId")
	private String businessId = null;


	@JsonProperty("businessService")
	private String businessService = null;

	@JsonProperty("tenantId")
	private String tenantId = null;

	@JsonProperty("assignee")
	private List<String> assignee = null;
	

	@JsonProperty("action")
	private String action = null;

	@JsonProperty("status")
	private String status = null;

	@JsonProperty("comments")
	private String comments = null;

	@JsonProperty("senderName")
	private String senderName = null;

	@JsonProperty("details")
	private String details = null;


    @JsonProperty("wfDocuments")
    private List<Document> wfDocuments;

	@JsonProperty("stateId")
	private String stateId = null;

	public WorkFlowDetails type(String type) {
		this.type = type;
		return this;
	}

	/**
	 * Workflow type to be processed for an application the Inventory Object
	 * 
	 * @return type
	 **/

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public WorkFlowDetails businessId(String businessId) {
		this.businessId = businessId;
		return this;
	}

	/**
	 * businessId of the workflow processing application
	 * 
	 * @return businessId
	 **/

	public String getBusinessId() {
		return businessId;
	}

	public void setBusinessId(String businessId) {
		this.businessId = businessId;
	}

	
	public WorkFlowDetails wfDocuments(List<Document> wfDocuments) {
		this.wfDocuments = wfDocuments;
		return this;
	}

	/**
	 * businessId of the workflow processing application
	 * 
	 * @return businessId
	 **/

	public List<Document> getWfDocuments() {
		return wfDocuments;
	}

	public void setWfDocuments(List<Document> wfDocuments) {
		this.wfDocuments = wfDocuments;
	}

	public WorkFlowDetails businessService(String businessService) {
		this.businessService = businessService;
		return this;
	}

	/**
	 * Department of the workflow processing authority
	 * 
	 * @return department
	 **/

	public String getBusinessService() {
		return businessService;
	}

	public void setBusinessService(String businessService) {
		this.businessService = businessService;
	}

	public WorkFlowDetails tenantId(String tenantId) {
		this.tenantId = tenantId;
		return this;
	}

	/**
	 * tenantId of the workflow 
	 * 
	 * @return designation
	 **/

	public String getTenantId() {
		return tenantId;
	}

	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}

	public WorkFlowDetails assignee(List<String> assignee) {
		this.assignee = assignee;
		return this;
	}

	/**
	 * Assignee id
	 * 
	 * @return assignee
	 **/

	public List<String> getAssignee() {
		return assignee;
	}

	public void setAssignee(List<String> assignee) {
		this.assignee = assignee;
	}

	public WorkFlowDetails action(String action) {
		this.action = action;
		return this;
	}

	/**
	 * Action to be taken for processing workflow
	 * 
	 * @return action
	 **/

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public WorkFlowDetails status(String status) {
		this.status = status;
		return this;
	}

	/**
	 * Status of the application
	 * 
	 * @return status
	 **/
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public WorkFlowDetails comments(String comments) {
		this.comments = comments;
		return this;
	}

	/**
	 * Comments given by the workflow processing person
	 * 
	 * @return comments
	 **/
	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public WorkFlowDetails senderName(String senderName) {
		this.senderName = senderName;
		return this;
	}

	/**
	 * Name of the workflow processing person
	 * 
	 * @return senderName
	 **/
	public String getSenderName() {
		return senderName;
	}

	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}

	public WorkFlowDetails details(String details) {
		this.details = details;
		return this;
	}

	/**
	 * Details about the workflow process
	 * 
	 * @return details
	 **/
	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public WorkFlowDetails stateId(String stateId) {
		this.stateId = stateId;
		return this;
	}

	/**
	 * State id of the workflow
	 * 
	 * @return stateId
	 **/
	public String getStateId() {
		return stateId;
	}

	public void setStateId(String stateId) {
		this.stateId = stateId;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		WorkFlowDetails workFlowDetails = (WorkFlowDetails) o;
		return Objects.equals(this.type, workFlowDetails.type)
				&& Objects.equals(this.businessId, workFlowDetails.businessId)
				&& Objects.equals(this.businessService, workFlowDetails.businessService)
				&& Objects.equals(this.tenantId, workFlowDetails.tenantId)
				&& Objects.equals(this.assignee, workFlowDetails.assignee)
				&& Objects.equals(this.action, workFlowDetails.action)
				&& Objects.equals(this.status, workFlowDetails.status)
				&& Objects.equals(this.comments, workFlowDetails.comments)
				&& Objects.equals(this.senderName, workFlowDetails.senderName)
				&& Objects.equals(this.details, workFlowDetails.details)
				&& Objects.equals(this.stateId, workFlowDetails.stateId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(type, businessId, businessService, tenantId, assignee, action, status, comments, senderName,
				details, stateId);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class WorkFlowDetails {\n");

		sb.append("    type: ").append(toIndentedString(type)).append("\n");
		sb.append("    businessId: ").append(toIndentedString(businessId)).append("\n");
		sb.append("    businessService: ").append(toIndentedString(businessService)).append("\n");
		sb.append("    tenantId: ").append(toIndentedString(tenantId)).append("\n");
		sb.append("    assignee: ").append(toIndentedString(assignee)).append("\n");
		sb.append("    action: ").append(toIndentedString(action)).append("\n");
		sb.append("    status: ").append(toIndentedString(status)).append("\n");
		sb.append("    comments: ").append(toIndentedString(comments)).append("\n");
		sb.append("    senderName: ").append(toIndentedString(senderName)).append("\n");
		sb.append("    details: ").append(toIndentedString(details)).append("\n");
		sb.append("    stateId: ").append(toIndentedString(stateId)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	/**
	 * Convert the given object to string with each line indented by 4 spaces
	 * (except the first line).
	 */
	private String toIndentedString(java.lang.Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}
}
