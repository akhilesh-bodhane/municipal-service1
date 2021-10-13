package org.egov.assets.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.egov.common.contract.request.RequestInfo;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.ToString;

/**
 * Contract class for web request. Array of MaterialIssue items are used in case
 * of create or update
 */
@ToString
public class MaterialIssueRequest {
	@JsonProperty("RequestInfo")
	private RequestInfo requestInfo = null;

	@JsonProperty("materialIssues")
	private List<MaterialIssue> materialIssues = new ArrayList<MaterialIssue>();

	
	@JsonProperty("workFlowDetails")
	private WorkFlowDetails workFlowDetails;

	public MaterialIssueRequest workFlowDetails(WorkFlowDetails workFlowDetails) {
		this.workFlowDetails = workFlowDetails;
		return this;
	}

	public WorkFlowDetails getWorkFlowDetails() {
		return workFlowDetails;
	}

	public void setWorkFlowDetails(WorkFlowDetails workFlowDetails) {
		this.workFlowDetails = workFlowDetails;
	}

	public MaterialIssueRequest requestInfo(RequestInfo requestInfo) {
		this.requestInfo = requestInfo;
		return this;
	}

	/**
	 * Get requestInfo
	 * 
	 * @return requestInfo
	 **/

	@NotNull
	@Valid
	public RequestInfo getRequestInfo() {
		return requestInfo;
	}

	public void setRequestInfo(RequestInfo requestInfo) {
		this.requestInfo = requestInfo;
	}

	public MaterialIssueRequest materialIssues(List<MaterialIssue> materialIssues) {
		this.materialIssues = materialIssues;
		return this;
	}

	public MaterialIssueRequest addMaterialIssuesItem(MaterialIssue materialIssuesItem) {
		this.materialIssues.add(materialIssuesItem);
		return this;
	}

	/**
	 * Used for search result and create only
	 * 
	 * @return materialIssues
	 **/

	@NotNull
	@Valid
	public List<MaterialIssue> getMaterialIssues() {
		return materialIssues;
	}

	public void setMaterialIssues(List<MaterialIssue> materialIssues) {
		this.materialIssues = materialIssues;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		MaterialIssueRequest materialIssueRequest = (MaterialIssueRequest) o;
		return Objects.equals(this.requestInfo, materialIssueRequest.requestInfo)
				&& Objects.equals(this.materialIssues, materialIssueRequest.materialIssues);
	}

	@Override
	public int hashCode() {
		return Objects.hash(requestInfo, materialIssues);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class MaterialIssueRequest {\n");

		sb.append("    requestInfo: ").append(toIndentedString(requestInfo)).append("\n");
		sb.append("    materialIssues: ").append(toIndentedString(materialIssues)).append("\n");
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
