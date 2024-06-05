package org.egov.waterconnection.model;

import java.util.List;

import javax.validation.Valid;

import org.egov.common.contract.response.ResponseInfo;
import org.egov.waterconnection.model.WaterConnectionResponse.WaterConnectionResponseBuilder;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Builder
public class PublicDashboardFilestoreResponse {

	@JsonProperty("PublicDashboardFilestore")
	@Valid
	private PublicDashboardFilestore publicDashboardFilestore = null;

}
