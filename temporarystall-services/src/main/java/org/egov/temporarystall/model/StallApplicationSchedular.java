package org.egov.temporarystall.model;

import java.math.BigDecimal;
import java.util.List;

import javax.validation.constraints.NotNull;

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
public class StallApplicationSchedular {
	
	private String applicationUuid ;
	
	private String applicationId ;
	
	
	
	/*
	 * @JsonProperty("fee") private String fee;
	 */
	
	
	
	@JsonProperty("applicationstatus")
	private String applicationstatus;
	
	
	
	@JsonProperty("paymentstatus")
	private String paymentstatus;
	
	@JsonProperty("AuditDetails")
	AuditDetails auditDetails;
	
	
	

	
	
	;
	

}
