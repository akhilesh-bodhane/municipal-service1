package org.egov.integration.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class FireApplicationDetails {

	@JsonProperty("totalApplicationsReceived")
	private String totalApplicationsReceived;

	@JsonProperty("totalApplicationsUnderProcess")
	private String totalApplicationsUnderProcess;

	@JsonProperty("totalApplicationsRejected")
	private String totalApplicationsRejected;

	@JsonProperty("totalApplicationsDelivered")
	private String totalApplicationsDelivered;

	@JsonProperty("applicationReferenceNumber")
	private String applicationReferenceNumber;

	@JsonProperty("applicationStatus")
	private String applicationStatus;
}
