package org.egov.integration.model;

import java.util.List;

import javax.validation.Valid;

//import org.egov.waterconnection.model.buckets;
//import org.egov.waterconnection.model.pendingConnections;
import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Contract class to send response. Array of tradelicense items are used in case
 * of search results or response for create, whereas single tradelicense item is
 * used for update
 */
@ApiModel(description = "Contract class to send response. Array of tradelicense items are used in case of search results or response for create, whereas single tradelicense item is used for update")
@Validated
@javax.annotation.Generated(value = "org.egov.codegen.SpringBootCodegen", date = "2018-09-18T17:06:11.263+05:30")

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class todaysCollection {

	@JsonProperty("groupBy")
	private String groupBy = null;

	@JsonProperty("buckets")
	@Valid
	private List<buckets> buckets = null;

}
