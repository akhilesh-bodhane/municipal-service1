package org.egov.swservice.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;

import org.egov.common.contract.response.ResponseInfo;
import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Contains the ResponseHeader and the created/updated property
 */
@ApiModel(description = "Contains the ResponseHeader and the created/updated property")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-10-24T10:29:25.253+05:30[Asia/Kolkata]")

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Builder
public class SewerageCountConnectionResponse {
	@JsonProperty("ResponseInfo")
	private ResponseInfo responseInfo = null;

	@JsonProperty("sewerageCountConnections")
	@Valid
	private List<SewerageConnectionCount> sewerageCountConnections = null;

	public SewerageCountConnectionResponse responseInfo(ResponseInfo responseInfo) {
		this.responseInfo = responseInfo;
		return this;
	}

	/**
	 * Get responseInfo
	 * 
	 * @return responseInfo
	 **/
	@ApiModelProperty(value = "")

	@Valid
	public ResponseInfo getResponseInfo() {
		return responseInfo;
	}

	public void setResponseInfo(ResponseInfo responseInfo) {
		this.responseInfo = responseInfo;
	}

	public SewerageCountConnectionResponse sewerageCountConnections(List<SewerageConnectionCount> sewerageCountConnections) {
		this.sewerageCountConnections = sewerageCountConnections;
		return this;
	}

	public SewerageCountConnectionResponse addsewerageCountConnectionsItem(SewerageConnectionCount sewerageCountConnectionsItem) {
		if (this.sewerageCountConnections == null) {
			this.sewerageCountConnections = new ArrayList<SewerageConnectionCount>();
		}
		this.sewerageCountConnections.add(sewerageCountConnectionsItem);
		return this;
	}

	/**
	 * Get sewerageCountConnections
	 * 
	 * @return sewerageCountConnections
	 **/
	@ApiModelProperty(value = "")
	@Valid
	public List<SewerageConnectionCount> getsewerageCountConnections() {
		return sewerageCountConnections;
	}

	public void setsewerageCountConnections(List<SewerageConnectionCount> sewerageCountConnections) {
		this.sewerageCountConnections = sewerageCountConnections;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		SewerageCountConnectionResponse sewerageConnectionResponse = (SewerageCountConnectionResponse) o;
		return Objects.equals(this.responseInfo, sewerageConnectionResponse.responseInfo)
				&& Objects.equals(this.sewerageCountConnections, sewerageConnectionResponse.sewerageCountConnections);
	}

	@Override
	public int hashCode() {
		return Objects.hash(responseInfo, sewerageCountConnections);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class SewerageConnectionResponse {\n");

		sb.append("    responseInfo: ").append(toIndentedString(responseInfo)).append("\n");
		sb.append("    sewerageCountConnections: ").append(toIndentedString(sewerageCountConnections)).append("\n");
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
