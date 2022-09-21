package org.egov.waterconnection.model;

import java.util.Objects;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Validated

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-01-22T12:39:45.543+05:30[Asia/Kolkata]")
public class WaterApplicationList {
	

	@JsonProperty("applicationNo")
	private String applicationNo = null;

	@JsonProperty("applicationStatus")
	private String applicationStatus = null;

	

	


	public String getapplicationNo() {
		return applicationNo;
	}

	public void setapplicationNo(String applicationNo) {
		this.applicationNo = applicationNo;
	}

	public String getApplicationStatus() {
		return applicationStatus;
	}

	public void setApplicationStatus(String applicationStatus) {
		this.applicationStatus = applicationStatus;
	}


	
}
