package org.egov.ec.web.models.ec;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

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
public class EcDetail {

	// Common Fields

	@JsonProperty("challanNumber")
	private String challanNumber = null;

	@JsonProperty("tenantId")
	private String tenantId = null;

	@JsonProperty("financialYear")
	private String financialYear = null;

	@JsonProperty("fineAmout")
	private String fineAmout = null;

	@JsonProperty("penaltyAmount")
	private String penaltyAmount = null;

	@NotNull
	@JsonProperty("owners")
	@Valid
	private List<OwnerInfo> owners = new ArrayList<>();
	
	@JsonProperty("uuid")
	private String uuid = null;

}
