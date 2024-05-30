package org.egov.integration.model;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class TLPublicDashboard {

	@JsonProperty("totalApplicationsReceived")
	private String totalApplicationsReceived;

	@JsonProperty("totalApplicationsApproved")
	private String totalApplicationsApproved;

	@JsonProperty("timeTakenForApproval")
	private String timeTakenForApproval;
	
	@JsonProperty("totalCollection")
	private BigDecimal totalCollection;
}
