package org.egov.pgr.model;

import java.util.List;

import org.egov.common.contract.request.RequestInfo;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ReportRequest {

	public String tenantId;
	public String reportName;
	public List<SearchParam> searchParams;

	@JsonProperty("RequestInfo")
	public RequestInfo requestInfo;
}