package org.egov.nulm.model;

import java.math.BigDecimal;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.egov.nulm.workflow.model.Document;
import org.json.simple.JSONArray;

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

public class SusvApplicationCount {

	private String applicationUuid;

	

	
	@JsonProperty("applicationStatus")
	private StatusEnum applicationStatus;

	public enum StatusEnum {
		DRAFTED("Drafted"), 
		CREATED("Created"), 
		FORWARDEDTOJA("Forwarded To JA"),
		FORWARDEDTOSDO("Forwarded To SDO"), 
		FORWARDEDTOACMC("Forwarded To ACMC"),
		REASSIGNTOJA("Reassign To JA"), 
		REASSIGNTOSDO("Reassign To SDO"), 
		REASSIGNTOCITIZEN("Reassign To Citizen"), 
		APPROVED("Approved"), 
		REJECTED("Rejected");

		private String value;

		StatusEnum(String value) {
			this.value = value;
		}

		@Override
		@JsonValue
		public String toString() {
			return String.valueOf(value);
		}

		@JsonCreator
		public static StatusEnum fromValue(String text) {
			for (StatusEnum b : StatusEnum.values()) {
				if (String.valueOf(b.value).equalsIgnoreCase(text)) {
					return b;
				}
			}
			return null;
		}
	}

	

	@JsonProperty("auditDetails")
	private AuditDetails auditDetails;


}
