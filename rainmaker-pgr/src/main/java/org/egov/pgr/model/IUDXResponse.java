package org.egov.pgr.model;

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
public class IUDXResponse {

	@JsonProperty("department")
	public String department;

	@JsonProperty("wardName")
	public String wardName;

	@JsonProperty("observationDateTime")
	public String observationDateTime;

	@JsonProperty("reportID")
	public String reportID;

	@JsonProperty("reportingMode")
	public String reportingMode;

	@JsonProperty("category")
	public String category;

	@JsonProperty("description")
	public String description;

	@JsonProperty("address")
	public String address;

	@JsonProperty("location")
	public Location location;

	@JsonProperty("status")
	public String status;
	
	@JsonProperty("comments")
	public String comments;

	@JsonProperty("media")
	public String media;

}