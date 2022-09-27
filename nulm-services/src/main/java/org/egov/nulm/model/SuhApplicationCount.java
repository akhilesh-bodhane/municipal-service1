package org.egov.nulm.model;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.egov.nulm.model.SepApplication.StatusEnum;
import org.hibernate.validator.constraints.NotEmpty;
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

public class SuhApplicationCount {

	private String suhUuid;
	

	
	@NotNull
	@JsonProperty("applicationStatus")
	private StatusEnum applicationStatus ;

	public enum StatusEnum {
	    DRAFTED("Drafted"),
	    CREATED("Created"),
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
