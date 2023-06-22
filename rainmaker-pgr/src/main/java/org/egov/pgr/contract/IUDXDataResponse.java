package org.egov.pgr.contract;

import org.egov.common.contract.response.ResponseInfo;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class IUDXDataResponse {

	@JsonProperty("responseInfo")
	private ResponseInfo responseInfo;

	@JsonProperty("data")
	private IUDXData iudxData;
}
