package org.egov.integration.model;

import java.util.List;

import javax.validation.Valid;

//import org.egov.tl.web.models.buckets;

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
public class todaysCollection {

	@JsonProperty("groupBy")
	private String groupBy = null;
	
	@JsonProperty("buckets")
	@Valid
	private List<buckets> buckets = null;
}