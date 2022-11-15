package org.egov.pgr.model;

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
public class GrievenceReport {

	@JsonProperty("ulb")
	public String ulb;

	@JsonProperty("ward")
	public String ward;

	@JsonProperty("state")
	public String state;

	@JsonProperty("region")
	public String region;

	@JsonProperty("closedComplaints")
	public Integer closedComplaints;

	@JsonProperty("slaAchievement")
	public String slaAchievement;

	@JsonProperty("completionRate")
	public BigDecimal completionRate;

	@JsonProperty("uniqueCitizens")
	public Integer uniqueCitizens;

	@JsonProperty("resolvedComplaints")
	public Integer resolvedComplaints;

	@JsonProperty("todaysComplaints")
	public List<TodaysComplaint> todaysComplaints;

	@JsonProperty("todaysReopenedComplaints")
	public List<TodaysReopenedComplaint> todaysReopenedComplaints;

	@JsonProperty("todaysOpenComplaints")
	public List<TodaysOpenComplaint> todaysOpenComplaints;

	@JsonProperty("todaysAssignedComplaints")
	public List<TodaysAssignedComplaint> todaysAssignedComplaints;

	@JsonProperty("todaysRejectedComplaints")
	public List<TodaysRejectedComplaint> todaysRejectedComplaints;

	@JsonProperty("todaysReassignedComplaints")
	public List<TodaysReassignedComplaint> todaysReassignedComplaints;
}