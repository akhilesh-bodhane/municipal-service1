package org.egov.ec.web.models;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.egov.ec.web.models.VendorRegistration.VendorRegistrationBuilder;
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
public class SMPKVendorDetail2 {

	
	@JsonProperty("covNo")
	@NotNull(message = "covNo should not be empty or null")
	@NotBlank(message = "covNo should not be empty or null")
	private int covNo;
	
	@JsonProperty("vendorName")
	private String vendorName;
	
	@JsonProperty("tradeType")
	private String tradeType;
	
	@JsonProperty("location")
	private String location;
	
	@JsonProperty("status")
	private String status;
	
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
	
	@JsonProperty("noOfViolation")
	private String noOfViolation;
	
	@JsonProperty("responseMessage")
	private String responseMessage;
	

}
