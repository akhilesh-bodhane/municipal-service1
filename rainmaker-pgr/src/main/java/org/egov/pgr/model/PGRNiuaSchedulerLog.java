package org.egov.pgr.model;

import javax.validation.constraints.NotNull;

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
public class PGRNiuaSchedulerLog {
	
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
