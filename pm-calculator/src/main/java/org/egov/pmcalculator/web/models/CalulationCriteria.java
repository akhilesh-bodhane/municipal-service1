package org.egov.pmcalculator.web.models;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.egov.pmcalculator.web.models.pm.PMDetail;
import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Either tradelicense object or the application number is mandatory apart from
 * tenantid.
 */
@ApiModel(description = "Either tradelicense object or the application number is mandatory apart from tenantid.")
@Validated
@javax.annotation.Generated(value = "org.egov.codegen.SpringBootCodegen", date = "2018-09-27T14:56:03.454+05:30")

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class CalulationCriteria {
	@JsonProperty("opmsDetail")
	@Valid
	private PMDetail opmsDetail = null;

	@JsonProperty("applicationNumber")
	@Size(min = 2, max = 64)
	private String applicationNumber = null;

	@JsonProperty("tenantId")
	@NotNull
	@Size(min = 2, max = 256)
	private String tenantId = null;

}
