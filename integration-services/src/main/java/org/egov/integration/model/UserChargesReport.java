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
public class UserChargesReport {

	@JsonProperty("date")
	public String date;

	@JsonProperty("module")
	public String module;

	@JsonProperty("ward")
	public String ward;

	@JsonProperty("ulb")
	public String ulb;

	@JsonProperty("state")
	public String state;

	@JsonProperty("region")
	public String region;

	@JsonProperty("metrics")
	public Metric metrics;

}