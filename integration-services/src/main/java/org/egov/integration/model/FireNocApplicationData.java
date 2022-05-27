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
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class FireNocApplicationData {

	@JsonProperty("applied_by")
	private String appliedBy;

	@JsonProperty("appl_id")
	private String applicationId;

	@JsonProperty("service_id")
	private String serviceId;

	@JsonProperty("appl_ref_no")
	private String applicationRefNo;

	@JsonProperty("service_name")
	private String serviceName;

	@JsonProperty("department_id")
	private String departmentId;

	@JsonProperty("department_name")
	private String departmentName;

	@JsonProperty("submission_date")
	private String submissionDate;

	@JsonProperty("submission_mode")
	private String submissionMode;

	@JsonProperty("attribute_details")
	private JSONObject attributeDetails;

	@JsonProperty("submission_location")
	private String submissionLocation;
}
