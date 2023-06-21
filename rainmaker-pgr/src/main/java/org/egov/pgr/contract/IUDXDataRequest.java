package org.egov.pgr.contract;

import javax.validation.constraints.NotNull;

import org.egov.common.contract.request.RequestInfo;

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
public class IUDXDataRequest {

	@NotNull
	@JsonProperty("requestInfo")
	private RequestInfo requestInfo;

	@NotNull
	@JsonProperty("requestData")
	private IUDXDataFields requestData;

}
