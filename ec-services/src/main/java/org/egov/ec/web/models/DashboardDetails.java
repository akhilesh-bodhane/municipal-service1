package org.egov.ec.web.models;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Validated
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DashboardDetails {
	
	@JsonProperty("fineCount")
	private Integer fineCount;
	
	@JsonProperty("challanCount")
	private Integer challanCount;
	
	@JsonProperty("auctionCount")
	private Integer auctionCount;
	
	@JsonProperty("roleCode")
	private String roleCode;
	
	@Size(max = 256)
	@JsonProperty("tenantId")
	@NotNull(message = "Tenant Id should not be empty or null")
	@NotBlank(message = "Tenant Id should not be empty or null")
	private String tenantId;
}
