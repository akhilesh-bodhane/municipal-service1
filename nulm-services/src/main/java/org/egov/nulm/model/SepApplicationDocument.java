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
public class SepApplicationDocument {
	
	private String documnetUuid ;
	private String filestoreId ;
	
	private String applicationUuid ;

	
	@JsonProperty("documentType")
	private String documentType ;
	
	
	@JsonProperty("tenantId")
	private String tenantId ;
	
	@JsonProperty("isActive")
	private Boolean isActive ;
	
	@JsonProperty("auditDetails")
	private AuditDetails auditDetails ;

}
