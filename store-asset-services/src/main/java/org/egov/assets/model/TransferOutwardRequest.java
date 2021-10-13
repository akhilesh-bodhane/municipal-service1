package org.egov.assets.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.egov.common.contract.request.RequestInfo;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Contract class for web request. Array of TransferOutward items are used in
 * case of create or update
 */
@javax.annotation.Generated(value = "org.egov.inv.codegen.languages.SpringCodegen", date = "2017-11-08T13:51:07.770Z")
public class TransferOutwardRequest {
	@JsonProperty("RequestInfo")
	private RequestInfo requestInfo = null;

	@JsonProperty("transferOutwards")
	private List<MaterialIssue> transferOutwards = new ArrayList<MaterialIssue>();

	public TransferOutwardRequest requestInfo(RequestInfo requestInfo) {
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

	public TransferOutwardRequest transferOutwards(List<MaterialIssue> transferOutwards) {
		this.transferOutwards = transferOutwards;
		return this;
	}

	public TransferOutwardRequest addTransferOutwardsItem(MaterialIssue transferOutwardsItem) {
		this.transferOutwards.add(transferOutwardsItem);
		return this;
	}

	/**
	 * Used for search result and create only
	 * 
	 * @return transferOutwards
	 **/
	@NotNull
	@Valid
	public List<MaterialIssue> getTransferOutwards() {
		return transferOutwards;
	}

	public void setTransferOutwards(List<MaterialIssue> transferOutwards) {
		this.transferOutwards = transferOutwards;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		TransferOutwardRequest transferOutwardRequest = (TransferOutwardRequest) o;
		return Objects.equals(this.requestInfo, transferOutwardRequest.requestInfo)
				&& Objects.equals(this.transferOutwards, transferOutwardRequest.transferOutwards);
	}

	@Override
	public int hashCode() {
		return Objects.hash(requestInfo, transferOutwards);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class TransferOutwardRequest {\n");

		sb.append("    requestInfo: ").append(toIndentedString(requestInfo)).append("\n");
		sb.append("    transferOutwards: ").append(toIndentedString(transferOutwards)).append("\n");
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
