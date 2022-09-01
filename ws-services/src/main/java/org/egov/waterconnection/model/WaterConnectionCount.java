package org.egov.waterconnection.model;

import java.math.BigDecimal;
import java.util.Objects;

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
public class WaterConnectionCount {

	

	@JsonProperty("ConnectionType")
	private String connectionType = null;
	
	@JsonProperty("PaymentDate")
	private Long PaymentDate;
	
	@JsonProperty("ApplicationStatus")
	private String applicationStatus = null;
	
	
	@JsonProperty("WaterApplicationType")
	private String waterApplicationType = null;
	
	@JsonProperty("PaymentMODE")
	private String paymentMODE = null;
	
	@JsonProperty("Subdiv")
	private String subdiv = null;
	
	@JsonProperty("TotalAmountPaid")
	private String totalAmountPaid = null;
	
	@JsonProperty("AuditDetails")
	private AuditDetails auditDetails = null;

	

	

	

	

	
}
