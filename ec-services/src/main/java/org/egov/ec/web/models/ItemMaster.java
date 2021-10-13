package org.egov.ec.web.models;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Validated
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ItemMaster {
	
	@Size(max = 256,message="Size Cannot be more than 256 characters")
	@NotNull(message = "Tenant Id should not be empty or null")
	@NotBlank(message = "Tenant Id should not be empty or null")
	@JsonProperty("tenantId")
	private String tenantId;
	
	@Size(max = 256,message="Size Cannot be more than 256 characters")
	@NotNull(message = "Item Name should not be empty or null")
	@NotBlank(message = "Item Name should not be empty or null")
	@JsonProperty("itemName")
	private String itemName;
	
	@Size(max = 256,message="Size Cannot be more than 256 characters")
	@NotNull(message = "Item Description should not be empty or null")
	@NotBlank(message = "Item Description should not be empty or null")
	@JsonProperty("description")
	private String description;
	
	@Size(max = 64,message="Size Cannot be more than 256 characters")
	@NotNull(message = "Approval Status should not be empty or null")
	@NotBlank(message = "Approval Status should not be empty or null")
	@JsonProperty("approvalStatus")
	private String approvalStatus;
	
	@NotNull(message = "isActive should not be empty or null")
	@JsonProperty("isActive")
	private Boolean isActive;
	
	@Size(max = 64)
	@JsonProperty("itemUuid")
	private String itemUuid;
	
	@Size(max = 256)
	@JsonProperty("createdBy")
	private String createdBy;
	
	@NotNull(message = "Created Time should not be empty or null")
	@JsonProperty("createdTime")
	private Long createdTime;
	
	@Size(max = 256)
	@JsonProperty("lastModifiedBy")
	private String lastModifiedBy;
	
	@NotNull(message = "LastModified Time should not be empty or null")
	@JsonProperty("lastModifiedTime")
	private Long lastModifiedTime;
	
	@JsonProperty("sourceUuid")
	private String sourceUuid;

}
