package org.egov.waterconnection.model;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.Size;

//import org.egov.waterconnection.model.Property;
//import org.egov.wscalculation.model.CalculationCriteria;
//import org.egov.wscalculation.model.WaterConnection;
import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * WaterConnection
 */
@Validated

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-11T12:10:14.583+05:30[Asia/Kolkata]")
public class metrics {
	
	@JsonProperty("transactions")
    @Valid
    private int transactions ;

	
	@JsonProperty("connectionsCreated")
	@Valid
	private List<connectionsCreated> connectionsCreated = null;
	
	@JsonProperty("todaysCollection")
	@Valid
	private List<todaysCollection> todaysCollection = null;
	
	@JsonProperty("sewerageConnections")
	@Valid
	private List<sewerageConnections> sewerageConnections = null;
	
	@JsonProperty("waterConnections")
	@Valid
	private List<waterConnections> waterConnections = null;
	
	@JsonProperty("pendingConnections")
	@Valid
	private List<pendingConnections> pendingConnections = null;
	
	
	@JsonProperty("slaCompliance")
    @Valid
    private int slaCompliance ;
	
	@JsonProperty("todaysTotalApplications")
    @Valid
    private int todaysTotalApplications ;
	
	@JsonProperty("todaysClosedApplications")
    @Valid
    private int todaysClosedApplications ;
	
	@JsonProperty("todaysCompletedApplicationsWithinSLA")
    @Valid
    private int todaysCompletedApplicationsWithinSLA ;
	
	@JsonProperty("avgDaysForApplicationApproval")
    @Valid
	private int avgDaysForApplicationApproval;
	
	@JsonProperty("StipulatedDays")
    @Valid
	private int StipulatedDays;
	
	
	

	
	
}
