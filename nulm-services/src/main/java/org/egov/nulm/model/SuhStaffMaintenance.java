package org.egov.nulm.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.json.simple.JSONArray;

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

public class SuhStaffMaintenance {

	private String suhUuid;

	private String staffUuid;

	@JsonProperty("isManager")
	private Boolean isManager;

	@JsonProperty("managerRemark")
	private String managerRemark;

	@JsonProperty("isSecurityStaff")
	private Boolean isSecurityStaff;

	@JsonProperty("securityStaffRemark")
	private String securityStaffRemark;

	@JsonProperty("isCleaner")
	private Boolean isCleaner;

	@JsonProperty("cleanerRemark")
	private String cleanerRemark;

	
	@NotNull
	@JsonProperty("tenantId")
	private String tenantId;

	@JsonProperty("isActive")
	private Boolean isActive;

	@JsonProperty("auditDetails")
	private AuditDetails auditDetails;

}
