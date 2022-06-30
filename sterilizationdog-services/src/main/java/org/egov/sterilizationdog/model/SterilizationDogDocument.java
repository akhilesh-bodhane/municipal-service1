package org.egov.sterilizationdog.model;



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
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SterilizationDogDocument {
	
	private String documnetUuid ;
	
	private String applicationUuid ;
	
	private String pickfilestoreId ;
	
	@JsonProperty("pickpicture")
	private String pickpicture ;
	
	private String dropfilestoreId ;
	
	@JsonProperty("droppicture")
	private String droppicture ;
	
	
	@JsonProperty("tenantId")
	private String tenantId ;
	
	@JsonProperty("isActive")
	private Boolean isActive ;
	
	@JsonProperty("auditDetails")
	private AuditDetails auditDetails ;

}
