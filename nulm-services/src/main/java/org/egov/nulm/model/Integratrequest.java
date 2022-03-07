package org.egov.nulm.model;

import java.util.List;

import javax.validation.Valid;

import org.egov.common.contract.request.RequestInfo;
import org.egov.common.contract.response.ResponseInfo;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Integratrequest {

	
	@JsonProperty("ResponseInfo")
	private ResponseInfo responseInfo;
	
	@Valid
	@JsonProperty("NulmSmidRequest")
	private List<SmidApplication>  nulmSmidRequest;
	
	@Valid
	@JsonProperty("NulmSuhRequest")
	private List<SuhApplication> nulmSuhRequest;
	
	@Valid
	@JsonProperty("NulmSepRequest")
	private List<SepApplication> nulmSepRequest;
		
	@Valid
	@JsonProperty("NulmSusvRequest")
	private List<SusvApplication> nulmSusvRequest;





}
