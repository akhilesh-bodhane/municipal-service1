package org.egov.integration.model;

import org.json.simple.JSONObject;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class FireNoc {

	@JsonProperty("uuid")
	private String uuid;

	@JsonProperty("data")
	private JSONObject data;

	@JsonProperty("isActive")
	private Boolean isActive;

	@JsonProperty("auditDetails")
	private AuditDetails auditDetails;

}
