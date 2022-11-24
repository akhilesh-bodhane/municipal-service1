package org.egov.integration.model;

import java.util.List;

import org.egov.common.contract.response.ResponseInfo;

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

	@JsonProperty("todaysCollection")
	public Integer numberOfCategories;

	@JsonProperty("todaysCollection")
	public List<TodaysCollections> todaysCollection;

	@JsonProperty("todaysCollection")
	public List<NumberOfReceipts> numberOfReceipts;

	@JsonProperty("todaysCollection")
	public List<NumberOfChallans> numberOfChallans;
}