package org.egov.assets.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.egov.common.contract.request.RequestInfo;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Contract class for web request. Array of Scrap items are used in case of
 * create or update
 */

public class ScrapRequest {
	@JsonProperty("RequestInfo")
	private RequestInfo requestInfo = null;

	@JsonProperty("scraps")
	private List<Scrap> scraps = new ArrayList<Scrap>();

	public ScrapRequest requestInfo(RequestInfo requestInfo) {
		this.requestInfo = requestInfo;
		return this;
	}

	/**
	 * Get requestInfo
	 * 
	 * @return requestInfo
	 **/
	
	@NotNull

	public RequestInfo getRequestInfo() {
		return requestInfo;
	}

	public void setRequestInfo(RequestInfo requestInfo) {
		this.requestInfo = requestInfo;
	}

	public ScrapRequest scraps(List<Scrap> scraps) {
		this.scraps = scraps;
		return this;
	}

	public ScrapRequest addScrapsItem(Scrap scrapsItem) {
		this.scraps.add(scrapsItem);
		return this;
	}

	/**
	 * Used for search result and create only
	 * 
	 * @return scraps
	 **/
	
	@NotNull

	@Valid

	public List<Scrap> getScraps() {
		return scraps;
	}

	public void setScraps(List<Scrap> scraps) {
		this.scraps = scraps;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		ScrapRequest scrapRequest = (ScrapRequest) o;
		return Objects.equals(this.requestInfo, scrapRequest.requestInfo)
				&& Objects.equals(this.scraps, scrapRequest.scraps);
	}

	@Override
	public int hashCode() {
		return Objects.hash(requestInfo, scraps);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ScrapRequest {\n");

		sb.append("    requestInfo: ").append(toIndentedString(requestInfo)).append("\n");
		sb.append("    scraps: ").append(toIndentedString(scraps)).append("\n");
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
