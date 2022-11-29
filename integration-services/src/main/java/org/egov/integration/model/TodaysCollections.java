package org.egov.integration.model;

import java.util.List;

import javax.validation.Valid;

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
public class TodaysCollections {

	@JsonProperty("groupBy")
	private String groupBy = null;

	@JsonProperty("buckets")
	@Valid
	private List<Bucket> buckets = null;

}
