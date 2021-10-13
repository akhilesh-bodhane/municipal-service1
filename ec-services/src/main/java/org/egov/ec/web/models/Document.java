package org.egov.ec.web.models;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * A Object holds the basic data for a Public relation
 */
@ApiModel(description = "A Object holds the basic data for a EChallan")
@Validated
@javax.annotation.Generated(value = "org.egov.codegen.SpringBootCodegen", date = "2018-09-18T17:06:11.263+05:30")

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Document   {

        @Size(max=64)
        @JsonProperty("documentUuid")
        private String documentUuid;
	  
        @Size(max=64)
        @JsonProperty("violationUuid")
        @NotNull(message = "violation Uuid should not be empty or null")
        @NotBlank(message = "violation Uuid should not be empty or null")
        private String violationUuid;

        @JsonProperty("isActive")
        @NotNull(message = "isActive should not be empty or null")
        private Boolean isActive;

        @Size(max=64)
        @NotNull(message = "Tenant Id should not be empty or null")
        @NotBlank(message = "Tenant Id should not be empty or null")
        @JsonProperty("tenantId")
        private String tenantId = null;

        @Size(max=64)
        @JsonProperty("documentType")
        @NotNull(message = "Document Type should not be empty or null")
        @NotBlank(message = "Document Type should not be empty or null")
        private String documentType = null;

        @JsonProperty("fileStoreId")
        @NotNull(message = "file StoreId should not be empty or null")
        @NotBlank(message = "file StoreId should not be empty or null")
        private String fileStoreId = null;

        @Size(max=64)
        @JsonProperty("challanId")
        @NotNull(message = "challan Id should not be empty or null")
        @NotBlank(message = "challan Id should not be empty or null")
        private String challanId;

    	@Size(max = 256)
    	@JsonProperty("createdBy")
    	private String createdBy;
    	
    	@JsonProperty("createdTime")
    	@NotNull(message = "Created Time should not be empty or null")
    	private Long createdTime;
    	
    	@Size(max = 256)
    	@NotNull(message = "Last Modified Time should not be empty or null")
    	@JsonProperty("lastModifiedBy")
    	private String lastModifiedBy;
    	
    	@JsonProperty("lastModifiedTime")
    	private Long lastModifiedTime;

		

    	

}

