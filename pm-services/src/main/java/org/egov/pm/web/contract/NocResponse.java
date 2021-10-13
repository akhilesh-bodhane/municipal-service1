package org.egov.pm.web.contract;
import java.util.ArrayList;

import org.egov.common.contract.response.ResponseInfo;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * PetsResponse
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NocResponse {

	@JsonProperty("ResposneInfo")
	private ResponseInfo resposneInfo;

	@JsonProperty("nocApplicationDetail")
	private Object nocApplicationDetail = new ArrayList<>();

}