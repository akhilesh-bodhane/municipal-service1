package org.egov.integration.model;

import javax.validation.constraints.NotNull;

import org.egov.common.contract.request.RequestInfo;
import org.egov.integration.model.ObpsNiuaSchedulerRequest.ObpsNiuaSchedulerRequestBuilder;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class ObpsNiuaSchedulerLog {
	
	@NotNull
	@JsonProperty("id")
	private String id ;
	
	@JsonProperty("status")
	private String status;
	
	@JsonProperty("description")
	private String description;
	
	@JsonProperty("tenantid")
	private String tenantid;

}
