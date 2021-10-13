package org.egov.hc.contract;

import java.util.LinkedList;
import java.util.List;

import javax.validation.Valid;

import org.egov.common.contract.request.RequestInfo;
import org.egov.hc.model.ActionInfo;
import org.egov.hc.model.RequestData;
import org.egov.hc.model.ServiceRequestData;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RequestInfoWrapper {
	
	@JsonProperty("RequestInfo")
	private RequestInfo requestInfo;	
	
	@JsonProperty("RequestBody")
	private Object requestBody;
	
	@JsonProperty("RequestData")
	private RequestData requestData;	
	
	
	@JsonProperty("AuditDetails")
	AuditDetails auditDetails;
	
	
	@JsonProperty("services")
	  @Valid
	  private List<ServiceRequestData> services = new LinkedList<ServiceRequestData>();

	  @JsonProperty("actionInfo")
	  @Valid
	  private List<ActionInfo> actionInfo = new LinkedList<ActionInfo>();

}
