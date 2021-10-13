package org.egov.waterconnection.model;

import java.util.List;

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
public class BillingPersister {

	@JsonProperty("billGeneration")
	private List<BillGeneration> billGeneration ;
	
	@JsonProperty("billGenerationFile")
	private BillGenerationFile billGenerationFile ;
}
