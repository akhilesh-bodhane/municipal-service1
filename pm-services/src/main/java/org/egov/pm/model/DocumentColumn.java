package org.egov.pm.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class DocumentColumn {
	private String tenantId;
	@JsonProperty("applicationType")
	private String applicationType;

	@JsonProperty("certificateDataQuery")
	private String certificateDataQuery;
	
	@JsonProperty("receiptDataQuery")
	private String receiptDataQuery;


}
