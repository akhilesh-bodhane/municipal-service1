package org.egov.integration.model;

import java.math.BigDecimal;
import java.util.List;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

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

public class FireNocDaoApplicationTasks {

	private String appTaskDetailUuid;
//	private String applicationUuid;

	private String applicationId;
	private String taskId;
	private String taskName;
	private String actionTaken;
	private String executedTime;
	private String applicationStatus;
	private JSONObject officialFormDetails;
	private JSONObject actionTakenUserDetail;

	@JsonProperty("auditDetails")
	private AuditDetails auditDetails;
}
