package org.egov.ec.web.models;

import java.util.List;

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

@Validated
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VendorRegistration {

	@Size(max = 64)
	@JsonProperty("vendorUuid")
	private String vendorUuid;
	
	@JsonProperty("passNo")
	private String passNo;
	
	@JsonProperty("covNo")
	@NotNull(message = "covNo should not be empty or null")
	@NotBlank(message = "covNo should not be empty or null")
	private String covNo;
	
	@JsonProperty("name")
	@NotNull(message = "name should not be empty or null")
	@NotBlank(message = "name should not be empty or null")
	private String name;
	
	@JsonProperty("fatherSpouseName")
	@NotNull(message = "Fathers Name should not be empty or null")
	@NotBlank(message = "Fathers Name should not be empty or null")
	private String fatherSpouseName;
	
	@JsonProperty("address")
	@NotNull(message = "address should not be empty or null")
	@NotBlank(message = "address should not be empty or null")
	private String address;
	
	@JsonProperty("contactNumber")
	@NotNull(message = "contactNumber should not be empty or null")
	@NotBlank(message = "contactNumber should not be empty or null")
	private String contactNumber;
	
	@JsonProperty("vendorCategory")
	@NotNull(message = "vendorCategory should not be empty or null")
	@NotBlank(message = "vendorCategory should not be empty or null")
	private String vendorCategory;
	
	@JsonProperty("streetVendorArea")
	private String streetVendorArea;
	
	@JsonProperty("transportMode")
	private String transportMode;
	
	@JsonProperty("isActive")
	private Boolean isActive;
	
	@Size(max = 256)
	@JsonProperty("createdBy")
	private String createdBy;
	
	@JsonProperty("createdTime")
	@NotNull(message = "createdTime should not be empty or null")
	private Long createdTime;
	
	@Size(max = 256)
	@JsonProperty("lastModifiedBy")
	private String lastModifiedBy;
	
	@JsonProperty("lastModifiedTime")
	@NotNull(message = "lastModifiedTime should not be empty or null")
	private Long lastModifiedTime;
	
	@JsonProperty("vendorRegistrationList")
	private List<VendorRegistration> vendorRegistrationList;
	
	@JsonProperty("tenantId")
	private String tenantId;
	
	@JsonProperty("sourceUuid")
	private String sourceUuid;
	
	@JsonProperty("numberOfViolation")
	private String numberOfViolation;
}

