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
public class FireNocExecutionData {

	@JsonProperty("task_details")
	private FireNocTaskDetail taskDetails;

	@JsonProperty("official_form_details")
	private JSONObject officialFormDetails;

	@JsonProperty("applicant_task_details")
	private JSONObject applicantTaskDetails;

}
