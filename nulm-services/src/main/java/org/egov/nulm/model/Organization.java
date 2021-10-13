package org.egov.nulm.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

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

public class Organization {

	private String organizationUuid;
	private Long userId;

	@NotNull
	@JsonProperty("tenantId")
	private String tenantId;

	@JsonProperty("organizationName")
	private String organizationName;

	@JsonProperty("address")
	private String address;

	@Size(max = 128)
	@Pattern(regexp = "^$|^(?=^.{1,64}$)((([^<>()\\[\\]\\\\.,;:\\s$*@'\"]+(\\.[^<>()\\[\\]\\\\.,;:\\s@'\"]+)*)|(\".+\"))@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,})))$", message = "Invalid emailId")

	@JsonProperty("emailId")
	private String emailId;

	@JsonProperty("representativeName")
	private String representativeName;

	@Pattern(regexp = "^[6-9][0-9]{9}$", message = "Invalid mobile number")
	@JsonProperty("mobileNo")
	private String mobileNo;

	@JsonProperty("registrationNo")
	private String registrationNo;

	@JsonProperty("isActive")
	private Boolean isActive;

	@JsonProperty("auditDetails")
	private AuditDetails auditDetails;
	
	@JsonProperty("fromDate")
	private String fromDate;

	@JsonProperty("toDate")
	private String toDate;

}
