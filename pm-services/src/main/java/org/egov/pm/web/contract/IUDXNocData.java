package org.egov.pm.web.contract;

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
public class IUDXNocData {

	@JsonProperty("cityName")
	private String cityName;

	@JsonProperty("services")
	private IUDXServiceData services;
}