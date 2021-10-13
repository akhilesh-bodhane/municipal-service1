package org.egov.assets.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.egov.common.contract.request.RequestInfo;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Contract class for web request. Array of Indent items are used in case of
 * create or update
 */

public class IndentRequest {

	@JsonProperty("RequestInfo")
	private RequestInfo requestInfo = null;

	@JsonProperty("indents")
	private List<Indent> indents = new ArrayList<Indent>();

	@JsonProperty("workFlowDetails")
	private WorkFlowDetails workFlowDetails;

	public IndentRequest workFlowDetails(WorkFlowDetails workFlowDetails) {
		this.workFlowDetails = workFlowDetails;
		return this;
	}

	public WorkFlowDetails getWorkFlowDetails() {
		return workFlowDetails;
	}

	public void setWorkFlowDetails(WorkFlowDetails workFlowDetails) {
		this.workFlowDetails = workFlowDetails;
	}


	
	public IndentRequest requestInfo(RequestInfo requestInfo) {
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

	public IndentRequest indents(List<Indent> indents) {
		this.indents = indents;
		return this;
	}

	public IndentRequest addIndentsItem(Indent indentsItem) {
		this.indents.add(indentsItem);
		return this;
	}

	/**
	 * Used for search result and create only
	 * 
	 * @return indents
	 **/

	@NotNull

	@Valid

	public List<Indent> getIndents() {
		return indents;
	}

	public void setIndents(List<Indent> indents) {
		this.indents = indents;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		IndentRequest indentRequest = (IndentRequest) o;
		return Objects.equals(this.requestInfo, indentRequest.requestInfo)
				&& Objects.equals(this.indents, indentRequest.indents);
	}

	@Override
	public int hashCode() {
		return Objects.hash(requestInfo, indents);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class IndentRequest {\n");

		sb.append("    requestInfo: ").append(toIndentedString(requestInfo)).append("\n");
		sb.append("    indents: ").append(toIndentedString(indents)).append("\n");
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
