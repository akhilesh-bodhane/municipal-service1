package org.egov.assets.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.egov.common.contract.request.RequestInfo;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * Contract class for web request. Array of Disposal items are used in case of
 * create or update
 */
@AllArgsConstructor
@NoArgsConstructor
public class DisposalRequest {
	@JsonProperty("RequestInfo")
	private RequestInfo requestInfo = null;

	@JsonProperty("disposals")
	private List<Disposal> disposals = new ArrayList<Disposal>();

	public DisposalRequest requestInfo(RequestInfo requestInfo) {
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

	public DisposalRequest disposals(List<Disposal> disposals) {
		this.disposals = disposals;
		return this;
	}

	public DisposalRequest addDisposalsItem(Disposal disposalsItem) {
		this.disposals.add(disposalsItem);
		return this;
	}

	/**
	 * Used for search result and create only
	 * 
	 * @return disposals
	 **/

	@NotNull

	@Valid

	public List<Disposal> getDisposals() {
		return disposals;
	}

	public void setDisposals(List<Disposal> disposals) {
		this.disposals = disposals;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		DisposalRequest disposalRequest = (DisposalRequest) o;
		return Objects.equals(this.requestInfo, disposalRequest.requestInfo)
				&& Objects.equals(this.disposals, disposalRequest.disposals);
	}

	@Override
	public int hashCode() {
		return Objects.hash(requestInfo, disposals);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class DisposalRequest {\n");

		sb.append("    requestInfo: ").append(toIndentedString(requestInfo)).append("\n");
		sb.append("    disposals: ").append(toIndentedString(disposals)).append("\n");
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
