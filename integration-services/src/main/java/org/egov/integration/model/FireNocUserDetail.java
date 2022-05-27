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
public class FireNocUserDetail {

	@JsonProperty("user_name")
	private String userName;

	@JsonProperty("designation")
	private String designation;

	@JsonProperty("location_id")
	private String locationId;

	@JsonProperty("pull_user_id")
	private String pullUserId;

	@JsonProperty("location_name")
	private String locationName;

	@JsonProperty("department_level")
	private String departmentLevel;

	@JsonProperty("location_type_id")
	private String locationTypeId;
}
