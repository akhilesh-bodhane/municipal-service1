package org.egov.integration.model;

import org.json.simple.JSONObject;

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

public class FireNocDaoApplication {

	private String appDetailUuid;
	private String applicationId;
	private String serviceId;
	private String applicationRefNo;
	private String serviceName;
	private String departmentId;
	private String departmentName;
	private String submissionDate;
	private String submissionMode;
	private String applicationStatus;
	private String typeOfOccupancyUse;
	private JSONObject attributeDetails;
	private String submissionLocation;

	@JsonProperty("auditDetails")
	private AuditDetails auditDetails;

}
