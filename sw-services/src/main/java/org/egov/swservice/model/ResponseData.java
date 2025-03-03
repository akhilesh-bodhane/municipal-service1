package org.egov.swservice.model;

import java.math.BigDecimal;

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
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-11T12:10:14.583+05:30[Asia/Kolkata]")
public class ResponseData {
	
	@JsonProperty("totalApplicationsReceived")
    private int totalApplicationReceived;
	
	@JsonProperty("totalApplicationsApproved")
    private int totalApplicationsApproved;
	
	@JsonProperty("timeTakenForApproval")
    private int timeTakenForApproval;
	
	@JsonProperty("totalCollection")
    private BigDecimal totalCollection;
	
	@JsonProperty("filestoreId")
    private String filestoreId;
	
	@JsonProperty("createdTime")
    private Long createdTime;

}
