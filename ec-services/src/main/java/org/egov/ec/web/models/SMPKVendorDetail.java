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
public class SMPKVendorDetail {

	
	@JsonProperty("covNo")
	@NotNull(message = "covNo should not be empty or null")
	@NotBlank(message = "covNo should not be empty or null")
	private int covNo;
	
	@JsonProperty("sovNo")
	private int sovNo;
	
	@JsonProperty("vendorName")
	private String vendorName;
	
	@JsonProperty("tradeType")
	private String tradeType;
	
	@JsonProperty("location")
	private String location;
	
	@JsonProperty("feesOutstanding")
	private String feesOutstanding;
	
	@JsonProperty("status")
	private String status;
	
	@JsonProperty("licenseCancelTillDate")
	private String licenseCancelTillDate;
	
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
	
	@JsonProperty("totalTerminated")
	private String totalTerminated;
	
	@JsonProperty("lastTerminatedOn")
	@NotNull(message = "lastTerminatedOn should not be empty or null")
	private Long lastTerminatedOn;
	
	@JsonProperty("spicVendorDataList")
 	private List<SMPKVendorDetail> spicVendorDataList;
}
