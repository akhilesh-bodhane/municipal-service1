package org.egov.integration.model;

import java.math.BigDecimal;
import java.util.List;

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

	@JsonProperty("ulb")
	public String ulb;

	@JsonProperty("ward")
	public String ward;

	@JsonProperty("state")
	public String state;

	@JsonProperty("region")
	public String region;

	@JsonProperty("numberOfCategories")
	public Integer numberOfCategories;

	@JsonProperty("slaAchievement")
	public String slaAchievement;

	@JsonProperty("completionRate")
	public BigDecimal completionRate;

	@JsonProperty("uniqueCitizens")
	public Integer uniqueCitizens;

	@JsonProperty("resolvedComplaints")
	public Integer resolvedComplaints;

	@JsonProperty("todaysCollection")
	public List<TodaysCollections> todaysCollection;

	@JsonProperty("numberOfReceipts")
	public List<NumberOfReceipts> numberOfReceipts;

	@JsonProperty("numberOfChallans")
	public List<NumberOfChallans> numberOfChallans;

}