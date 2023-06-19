package org.egov.pm.model;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class IUDXData {

	@JsonProperty("applicationCount")
	private Integer applicationCount;

	@JsonProperty("totalRevenueCollection")
	private BigDecimal totalRevenueCollection;

}
