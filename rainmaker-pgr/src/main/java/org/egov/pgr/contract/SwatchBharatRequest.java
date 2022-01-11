package org.egov.pgr.contract;

import java.util.LinkedList;
import java.util.List;

import javax.validation.Valid;

import org.egov.common.contract.request.RequestInfo;
import org.egov.pgr.model.SwatchBharat;
import org.egov.pgr.model.SwatchBharatSearch;
import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Validated
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SwatchBharatRequest {

	@JsonProperty("RequestInfo")
	private RequestInfo requestInfo = null;

	@JsonProperty("swatchBharat")
	@Valid
	private List<SwatchBharat> swatchBharat = new LinkedList<SwatchBharat>();

	@JsonProperty("swatchBharatSearch")
	@Valid
	private SwatchBharatSearch swatchBharatSearch = new SwatchBharatSearch();

}
