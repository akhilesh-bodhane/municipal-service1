package org.egov.pgr.contract;

import java.util.List;

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
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AutoroutingMapReqSearchCriteria {
		
	@NotNull
	@JsonProperty("tenantId")
	private String tenantId;
	
	@JsonProperty("active")
	private Boolean active;
	
	@JsonProperty("category")
	private String category;
	
	@JsonProperty("sector")
	private String sector;
	
}
