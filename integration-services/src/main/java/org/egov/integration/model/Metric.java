package org.egov.integration.model;

import java.util.List;

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
public class Metric {

	@JsonProperty("numberOfCategories")
	public Integer numberOfCategories;

	@JsonProperty("todaysCollection")
	public List<TodaysCollections> todaysCollection;

	@JsonProperty("numberOfReceipts")
	public List<NumberOfReceipts> numberOfReceipts;

	@JsonProperty("numberOfChallans")
	public List<NumberOfChallans> numberOfChallans;
}