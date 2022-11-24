package org.egov.integration.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserCharges {

	@JsonProperty("sequencenum")
	public Integer sequencenum;

	@JsonProperty("category")
	public String category;

	@JsonProperty("status")
	public String status;

	@JsonProperty("paymentStatus")
	public String paymentStatus;

	@JsonProperty("paymentMode")
	public String paymentMode;

	@JsonProperty("allRecords")
	public Integer allRecords;

	@JsonProperty("numberOfCategories")
	public Integer numberOfCategories;

	@JsonProperty("isChallan")
	public Boolean isChallan;

}