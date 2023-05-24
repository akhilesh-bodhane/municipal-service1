package org.egov.integration.model;

import java.math.BigDecimal;

//import org.egov.waterconnection.model.pendingConnections;
import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Contract class to send response. Array of tradelicense items are used in case
 * of search results or response for create, whereas single tradelicense item is
 * used for update
 */
@ApiModel(description = "Contract class to send response. Array of tradelicense items are used in case of search results or response for create, whereas single tradelicense item is used for update")
@Validated
@javax.annotation.Generated(value = "org.egov.codegen.SpringBootCodegen", date = "2018-09-18T17:06:11.263+05:30")

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TLNIUAModel {

	@JsonProperty("tradeType")
	private String tradeType;

	@JsonProperty("approvedLicense")
	private Integer approvedLicense;

	@JsonProperty("status")
	private String status;

	@JsonProperty("todaysTradeLicenses")
	private Integer todaysTradeLicenses;

	@JsonProperty("applicationsMovedToday")
	private Integer applicationsMovedToday;

	@JsonProperty("transactions")
	private Double transactions;

	@JsonProperty("gateway")
	private String gateway;

	@JsonProperty("todaysApprovedApplications")
	private Integer todaysApprovedApplications;

	@JsonProperty("todaysCollection")
	private Double todaysCollection;

	@JsonProperty("approvedCompletionDaysLicense")
	private Integer approvedCompletionDaysLicense;

	@JsonProperty("todaysApprovedApplicationsWithinSLA")
	private Integer todaysApprovedApplicationsWithinSLA;

	@JsonProperty("avgDaysForApplicationApproval")
	private Integer avgDaysForApplicationApproval;

	@JsonProperty("taxAmount")
	private Double taxAmount;

	@JsonProperty("penaltyAmount")
	private Double penaltyAmount;

}
