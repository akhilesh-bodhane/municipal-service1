package org.egov.pmcalculator.web.models.pm;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.egov.common.contract.response.ResponseInfo;
import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Validated
@javax.annotation.Generated(value = "org.egov.codegen.SpringBootCodegen", date = "2018-09-18T17:06:11.263+05:30")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class PMDetailResponse {
	@JsonProperty("ResponseInfo")
	private ResponseInfo responseInfo = null;

	@JsonProperty("opmsDetail")
	@Valid
	private List<PMDetail> pMDetail = null;

	public PMDetailResponse addLicensesItem(PMDetail opmsDetailItems) {
		if (this.pMDetail == null) {
			this.pMDetail = new ArrayList<>();
		}
		this.pMDetail.add(opmsDetailItems);
		return this;
	}

}
