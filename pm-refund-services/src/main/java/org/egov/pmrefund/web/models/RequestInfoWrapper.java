package org.egov.pmrefund.web.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.egov.common.contract.request.RequestInfo;


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
