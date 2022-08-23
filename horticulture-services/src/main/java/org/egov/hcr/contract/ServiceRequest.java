package org.egov.hcr.contract;

import java.util.LinkedList;
import java.util.List;

import javax.validation.Valid;

import org.egov.common.contract.request.RequestInfo;
import org.egov.common.contract.response.ResponseInfo;
import org.egov.hcr.model.ActionInfo;
import org.egov.hcr.model.ServiceRequestData;
import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Request object to fetch the report data
 */
@Validated
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ServiceRequest implements Cloneable {

	public ServiceRequest clone() throws CloneNotSupportedException {
		return (ServiceRequest) super.clone();
	}

	@JsonProperty("RequestInfo")
	private RequestInfo requestInfo = null;

	@JsonProperty("services")
	private List<ServiceRequestData> services = new LinkedList<ServiceRequestData>();

	@JsonProperty("actionInfo")
	private List<ActionInfo> actionInfo = new LinkedList<ActionInfo>();

	@JsonProperty("requestBody")
	private Object requestBody;

	@JsonProperty("auditDetails")
	AuditDetails auditDetails;

	@JsonProperty("status")
	String status;

	@JsonProperty("responseInfo")
	private ResponseInfo responseInfo;

	@JsonProperty("responseBody")
	private Object responseBody;

	@JsonProperty("isEditState")
	private int isEditState;

}
