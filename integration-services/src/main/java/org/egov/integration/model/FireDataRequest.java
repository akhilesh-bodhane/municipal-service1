package org.egov.integration.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class FireDataRequest {

	@JsonProperty("typeOfOccupancy")
	private String typeOfOccupancy;

	@JsonProperty("fromDate")
	private String fromDate;

	@JsonProperty("toDate")
	private String toDate;

	@JsonProperty("applicationReferenceNumber")
	private String applicationReferenceNumber;

}
