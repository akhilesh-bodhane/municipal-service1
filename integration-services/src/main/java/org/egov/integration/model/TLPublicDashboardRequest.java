package org.egov.integration.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TLPublicDashboardRequest {

	@JsonProperty("servicename")
	private String servicename;

	@JsonProperty("fromDate")
	private Long fromDate = null;

	@JsonProperty("toDate")
	private Long toDate = null;

}
