package org.egov.pgr.model;

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
public class GrievanceReport {

	@JsonProperty("date")
	public String date;

	@JsonProperty("module")
	public String module;

	@JsonProperty("ulb")
	public String ulb;

	@JsonProperty("ward")
	public String ward;

	@JsonProperty("state")
	public String state;

	@JsonProperty("region")
	public String region;
	
	@JsonProperty("metrics")
	public Metric metrics;

}