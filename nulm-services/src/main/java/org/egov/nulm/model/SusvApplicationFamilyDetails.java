package org.egov.nulm.model;



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
public class SusvApplicationFamilyDetails {
	
	private String uuid ;
	
	private String applicationUuid ;

	
	@JsonProperty("name")
	private String name ;
	
	@JsonProperty("age")
	private String age ;
	
	@JsonProperty("relation")
	private String relation ;
		
	@JsonProperty("tenantId")
	private String tenantId ;
	
	@JsonProperty("isActive")
	private Boolean isActive ;
	
	@JsonProperty("auditDetails")
	private AuditDetails auditDetails ;

}
