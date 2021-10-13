package org.egov.ec.web.models.ec;

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

@Validated
@javax.annotation.Generated(value = "org.egov.codegen.SpringBootCodegen", date = "2018-09-18T17:06:11.263+05:30")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EcDetailResponse {
	@JsonProperty("ResponseInfo")
	private ResponseInfo responseInfo = null;

	@JsonProperty("ecDetail")
	@Valid
	private List<EcDetail> ecDetail = null;

	public EcDetailResponse addLicensesItem(EcDetail ecDetailItems) {
		if (this.ecDetail == null) {
			this.ecDetail = new ArrayList<>();
		}
		this.ecDetail.add(ecDetailItems);
		return this;
	}

}
