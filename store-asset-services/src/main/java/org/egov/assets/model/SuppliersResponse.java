package org.egov.assets.model;

import lombok.*;

import org.egov.assets.common.Pagination;
import org.egov.common.contract.response.ResponseInfo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SuppliersResponse {

	@JsonProperty("ResponseInfo")
	private ResponseInfo responseInfo;

	@JsonProperty("ResponseBody")
	private List<Supplier> responseBody;
}