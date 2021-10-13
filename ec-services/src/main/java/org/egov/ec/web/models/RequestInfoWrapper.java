package org.egov.ec.web.models;

import org.egov.common.contract.request.RequestInfo;
import org.egov.ec.web.models.AuditDetails;

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
public class RequestInfoWrapper {

	@JsonProperty("RequestInfo")
	private RequestInfo requestInfo;	
	
	@JsonProperty("RequestBody")
	private Object requestBody;
	
	
	@JsonProperty("AuditDetails")
	private AuditDetails auditDetails;
	

}
