package org.egov.integration.model;

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
public class CommonMetrics {

	@JsonProperty("status")
	private String status = null;
	
	@JsonProperty("onboardedUlbsCount")
	private Integer onboardedUlbsCount = null;
	
	@JsonProperty("totalCitizensCount")
	private Integer totalCitizensCount = null;
	
	@JsonProperty("totalLiveUlbsCount")
	private Integer totalLiveUlbsCount = null;
	
	@JsonProperty("totalUlbCount")
	private Integer totalUlbCount = null;
	
	@JsonProperty("slaAchievement")
	private Integer slaAchievement = null;
	
	@JsonProperty("liveUlbsCount")
	@Valid
	private List<LiveUlbsCount> liveUlbsCount = null;
	
}
