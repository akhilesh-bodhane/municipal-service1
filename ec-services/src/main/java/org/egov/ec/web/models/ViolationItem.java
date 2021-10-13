package org.egov.ec.web.models;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Validated
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ViolationItem {
	
	@Size(max = 64)
	@JsonProperty("violationItemUuid")
	private String violationItemUuid;
	
	@Size(max = 64)
	@JsonProperty("violationUuid")
	private String violationUuid;
	
	@Size(max = 64)
	@JsonProperty("itemUuid")
	private String itemUuid;
	
	@Size(max = 256)
	@NotNull(message = "tenantId  should not be empty or null")
	@NotBlank(message = "tenantId  should not be empty or null")
	@JsonProperty("tenantId")
	private String tenantId;
	
	@Size(max = 256)
	@NotNull(message = "itemName  should not be empty or null")
	@NotBlank(message = "itemName  should not be empty or null")
	@JsonProperty("itemName")
	private String itemName;
	
	@Size(max = 64)
	@JsonProperty("itemType")
	private String itemType;
	
	@JsonProperty("quantity")
	private Integer quantity;
	
	@Size(max = 256)
	@JsonProperty("remark")
	private String remark;
	
	@Size(max = 256)
	@JsonProperty("vehicleNumber")
	private String vehicleNumber;
	
	@Size(max = 256)
	@JsonProperty("challanId")
	private String challanId;
	
	@JsonProperty("isActive")
	private Boolean isActive;
	
	@Size(max = 256)
	@JsonProperty("createdBy")
	private String createdBy;
	
	@JsonProperty("createdTime")
	private Long createdTime;
	
	@Size(max = 256)
	@JsonProperty("lastModifiedBy")
	private String lastModifiedBy;
	
	@JsonProperty("lastModifiedTime")
	private Long lastModifiedTime;

	
	
	
}

