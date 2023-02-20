package org.egov.streetvendor.model;

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
public class StreetVendorDocument {
	
    @JsonProperty("documentUuid")
	private String documentUuid;
    
    @JsonProperty("filestoreId")
    private String filestoreId;
    
    @JsonProperty("documentType")
    private String documentType;
    
    @JsonProperty("vendorUuid")
    private String vendorUuid;
    
    @JsonProperty("tenantId")
    private String tenantId;
    
    @JsonProperty("isActive")
    private String isActive;
    
    @JsonProperty("auditDetails")
	private AuditDetails auditDetails ;

}
