package org.egov.pgr.model;

import java.math.BigDecimal;

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
public class Grievance {

	@JsonProperty("sequencenum")
	public Integer sequencenum;

	@JsonProperty("servicecode")
	public String servicecode;

	@JsonProperty("category")
	public String category;

	@JsonProperty("status")
	public String status;

	@JsonProperty("source")
	public String source;

	@JsonProperty("allcomplaints")
	public Integer allcomplaints;

	@JsonProperty("open")
	public Integer open;

	@JsonProperty("reopen")
	public Integer reopen;

	@JsonProperty("assigned")
	public Integer assigned;

	@JsonProperty("rejected")
	public Integer rejected;

	@JsonProperty("reassignrequested")
	public Integer reassignrequested;

	@JsonProperty("closed")
	public Integer closed;

	@JsonProperty("escalatedlevel2pending")
	public Integer escalatedlevel2pending;

	@JsonProperty("escalatedlevel1pending")
	public Integer escalatedlevel1pending;

	@JsonProperty("resolved")
	public Integer resolved;

	@JsonProperty("closedcomplaints")
	public Integer closedcomplaints;

	@JsonProperty("resolvedcomplaints")
	public Integer resolvedcomplaints;

	@JsonProperty("totalComplaints")
	public Integer totalComplaints;

	@JsonProperty("completionDaysResolved")
	public Integer completionDaysResolved;

	@JsonProperty("completionDaysClosed")
	public Integer completionDaysClosed;

}