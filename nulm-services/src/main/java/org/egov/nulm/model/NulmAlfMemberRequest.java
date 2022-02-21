package org.egov.nulm.model;

import java.util.List;

import javax.validation.Valid;

import org.egov.common.contract.request.RequestInfo;

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
public class NulmAlfMemberRequest {

	@JsonProperty("RequestInfo")
	private RequestInfo requestInfo;

	@Valid
	@JsonProperty("smidAlfMemberApplication")
	private List<SmidAlfMemberApplication> smidAlfMemberApplication;

	@JsonProperty("AuditDetails")
	AuditDetails auditDetails;



}
