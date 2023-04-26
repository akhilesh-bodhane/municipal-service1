package org.egov.streetvendor.model;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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
public class StreetVendorData {
	
	@JsonProperty("vendorUuid")
	private String vendorUuid;
	
	@JsonProperty("covNo")
	private String covNo;
	
	@JsonProperty("vendorName")
	private String vendorName;
	
	@JsonProperty("vendorAadharNo")
	private String vendorAadharNo;
	
	@JsonProperty("fatherName")
	private String fatherName;
	
	@JsonProperty("spouseName")
	private String spouseName;
	
	@JsonProperty("nomineeName")
	private String nomineeName;
	
	@JsonProperty("nomineeAadharNo")
	private String nomineeAadharNo;
	
	@JsonProperty("nameOfFamilyMember1")
	private String nameOfFamilyMember1;
		
	@JsonProperty("nameOfFamilyMember2")
	private String nameOfFamilyMember2;
	
	@JsonProperty("mobileNo")
	private String mobileNo;
	
	@JsonProperty("alternateMobileNo")
	private String alternateMobileNo;
	
	@JsonProperty("category")
	private String category;
	
	@JsonProperty("tradeOfVending")
	private String tradeOfVending;
	
	@JsonProperty("typeOfVending")
	private String typeOfVending;
	
	@JsonProperty("permanentAddress")
	private String permanentAddress;
	
	@JsonProperty("presentAddress")
	private String presentAddress;
	
	@JsonProperty("streetVendingIdCardIssue")
	private String streetVendingIdCardIssue;
	
	@JsonProperty("surveyLocation")
	private String surveyLocation;
	
	@JsonProperty("surveyLocality")
	private String surveyLocality;
	
	@JsonProperty("statusOfOccupancyStreet")
	private String statusOfOccupancyStreet; 
	
	@JsonProperty("pmSvanidhiLoan")
	private String pmSvanidhiLoan;
	
	@JsonProperty("enrollmentInPMSBY")
	private String enrollmentInPMSBY;
	
	@JsonProperty("enrollmentInPMJJBY")
	private String enrollmentInPMJJBY;
	
	@JsonProperty("bankAccountNo")
	private String bankAccountNo;
	
	@JsonProperty("bankHolderName")
	private String bankHolderName;
	
	@JsonProperty("bankName")
	private String bankName;
	
	@JsonProperty("ifscCode")
	private String ifscCode;
	
	@JsonProperty("tenantId")
	private String tenantId;
	
	@JsonProperty("isActive")
	private Boolean isActive;
	
	@JsonProperty("applicationStatus")
	private String applicationStatus;
	
	@JsonProperty("landmark")
	private String landmark;
	
	@JsonProperty("gender")
	private String gender;
	
	@JsonProperty("religion")
	private String religion;
	
	@JsonProperty("remarks")
	private String remarks;
	
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
	

	@JsonProperty("streetvendorDataList")
	private List<StreetVendorData> streetvendorDataList;
	
	@JsonProperty("streetVendorDocument")
	private List<StreetVendorDocument> streetVendorDocument;
	
	@JsonProperty("auditDetails")
	private AuditDetails auditDetails ;

}
