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
public class Metric {

	@JsonProperty("slaAchievement")
	public List<SlaAchievement> slaAchievement;

	@JsonProperty("completionRate")
	public List<CompletionRate> completionRate;

	@JsonProperty("uniqueCitizens")
	public Integer uniqueCitizens;

	@JsonProperty("averageSolutionTime")
	public List<AverageSolutionTime> averageSolutionTime;

	@JsonProperty("todaysReassignRequestedComplaints")
	public List<TodaysReassignRequestedComplaints> todaysReassignRequestedComplaints;

	@JsonProperty("todaysClosedComplaints")
	public List<TodaysClosedComplaints> todaysClosedComplaints;

	@JsonProperty("todaysResolvedComplaints")
	public List<TodaysResolvedComplaints> todaysResolvedComplaints;

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

	@JsonProperty("avgDaysForApplication")
	public Integer avgDaysForApplication;

	@JsonProperty("stipulatedDays")
	public Integer stipulatedDays;

}