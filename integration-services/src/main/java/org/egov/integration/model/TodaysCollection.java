package org.egov.integration.model;

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
public class TodaysCollection {

	@JsonProperty("groupBy")
	public String groupBy;
	@JsonProperty("buckets")
	public List<Bucket> buckets;
}