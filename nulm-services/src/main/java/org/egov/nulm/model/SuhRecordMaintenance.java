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

public class SuhRecordMaintenance {

	private String suhUuid;

	private String recordUuid;
	
	@JsonProperty("isAssetInventoryRegister")
	private Boolean isAssetInventoryRegister;

	@JsonProperty("assetInventoryRegisterRemark")
	private String assetInventoryRegisterRemark;

	@JsonProperty("isAccountRegister")
	private Boolean isAccountRegister;

	@JsonProperty("accountRegisterRemark")
	private String accountRegisterRemark;

	@JsonProperty("isAttendanceRegisterOfStaff")
	private Boolean isAttendanceRegisterOfStaff;

	@JsonProperty("attendanceRegisterOfStaffRemark")
	private String attendanceRegisterOfStaffRemark;

	@JsonProperty("isShelterManagementCommitteeRegister")
	private Boolean isShelterManagementCommitteeRegister;

	@JsonProperty("shelterManagementCommitteeRegisteRemark")
	private String shelterManagementCommitteeRegisteRemark;

	@JsonProperty("isPersonnelAndSalaryRegister")
	private Boolean isPersonnelAndSalaryRegister;

	@JsonProperty("personnelAndSalaryRegisterRemark")
	private String personnelAndSalaryRegisterRemark;

	@JsonProperty("isHousekeepingAndMaintenanceRegister")
	private Boolean isHousekeepingAndMaintenanceRegister;

	@JsonProperty("housekeepingAndMaintenanceRegisterRemark")
	private String housekeepingAndMaintenanceRegisterRemark;

	@JsonProperty("isComplaintAndSuggestionRegister")
	private Boolean isComplaintAndSuggestionRegister;

	@JsonProperty("complaintAndSuggestionRegisterRemark")
	private String complaintAndSuggestionRegisterRemark;

	@JsonProperty("isVisitorRegister")
	private Boolean isVisitorRegister;

	@JsonProperty("visitorRegisterRemark")
	private String visitorRegisterRemark;

	@JsonProperty("isProfileRegister")
	private Boolean isProfileRegister;

	@JsonProperty("profileRegisterRemark")
	private String profileRegisterRemark;

	@NotNull
	@JsonProperty("tenantId")
	private String tenantId;

	@JsonProperty("isActive")
	private Boolean isActive;

	@JsonProperty("auditDetails")
	private AuditDetails auditDetails;

}
