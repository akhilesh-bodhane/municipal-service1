package org.egov.tl.web.models;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * User role carries the tenant related role information for the user. A user
 * can have multiple roles per tenant based on the need of the tenant. A user
 * may also have multiple roles for multiple tenants.
 */
@ApiModel(description = "User role carries the tenant related role information for the user. A user can have multiple roles per tenant based on the need of the tenant. A user may also have multiple roles for multiple tenants.")
@Validated
@javax.annotation.Generated(value = "org.egov.codegen.SpringBootCodegen", date = "2018-09-18T17:06:11.263+05:30")

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TLRevenueCollections {

	@JsonProperty("totalApplications")
	private String totalApplications = null;

	@JsonProperty("totalCollections")
	private String totalCollections = null;
}
