package org.egov.pm.web.contract;

import java.util.ArrayList;

import org.egov.common.contract.response.ResponseInfo;
import org.egov.pm.model.IUDXServiceData;

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
public class IUDXNocResponse {

	@JsonProperty("resposneInfo")
	private ResponseInfo resposneInfo;

	@JsonProperty("cityName")
	private String cityName;

	@JsonProperty("services")
	private IUDXServiceData services;
}