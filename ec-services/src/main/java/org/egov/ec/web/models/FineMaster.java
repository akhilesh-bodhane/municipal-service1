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

@ApiModel(description = "Fine Detail Model")
@Validated
@javax.annotation.Generated(value = "org.egov.codegen.SpringBootCodegen", date = "2018-09-18T17:06:11.263+05:30")

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FineMaster {
	
	@Size(max=64)
    @JsonProperty("fineUuid")
	private String fineUuid;
	
	@Size(max = 256,message="Size Cannot be more than 256 characters")
	@NotNull(message = "Encroachment Type should not be empty or null")
	@NotBlank(message = "Encroachment Type should not be empty or null")
	@JsonProperty("encroachmentType")
	private String encroachmentType;
	
	@Size(max = 256,message="Size Cannot be more than 256 characters")
	@NotNull(message = "Number Of Violation should not be empty or null")
	@NotBlank(message = "Number Of Violation should not be empty or null")
	@JsonProperty("numberOfViolation")
	private String numberOfViolation;
	
	@JsonProperty("violationUuid")
	private String violationUuid;
	
	@NotNull(message = "Penalty Amount should not be empty or null")
	@JsonProperty("penaltyAmount")
	private String penaltyAmount;
	
	@Size(max = 64,message="Size Cannot be more than 256 characters")
	@NotNull(message = "Approval Status should not be empty or null")
	@NotBlank(message = "Approval Status should not be empty or null")
    @JsonProperty("approvalStatus")
	private String approvalStatus;
	
	@NotNull(message = "Tenant Id should not be empty or null")
	@NotBlank(message = "Tenant Id should not be empty or null")
    @JsonProperty("tenantId")
	private String tenantId;
	
    @NotNull(message = "isActive should not be empty or null")
    @JsonProperty("isActive")
	private Boolean isActive;
    
    @JsonProperty("effectiveStartDate")
	@NotNull(message = "effectiveStartDate  should not be empty or null")
    @NotBlank(message = "effectiveStartDate  should not be empty or null")
	private String effectiveStartDate;
	
    
    @JsonProperty("effectiveEndDate")
	@NotNull(message = "effectiveEndDate  should not be empty or null")
    @NotBlank(message = "effectiveEndDate  should not be empty or null")
	private String effectiveEndDate;
	
    
    @JsonProperty("createdBy")
	private String createdBy;
	
    @NotNull(message = "Created Time should not be empty or null")
	@JsonProperty("createdTime")
	private Long createdTime;
	
	@JsonProperty("lastModifiedBy")
	private String lastModifiedBy;
	
	@NotNull(message = "Last Modified Time should not be empty or null")
	@JsonProperty("lastModifiedTime")
	private Long lastModifiedTime;
	
	@JsonProperty("storageCharges")
	private String storageCharges;
	
	@JsonProperty("sourceUuid")
	private String sourceUuid;

	@Size(max=64)
    @JsonProperty("challanUuid")
	private String challanUuid;
}
