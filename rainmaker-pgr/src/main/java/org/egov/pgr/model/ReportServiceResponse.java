package org.egov.pgr.model;

import java.util.List;

import org.egov.common.contract.request.RequestInfo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReportServiceResponse{
    public String tenantId;
    public List<ReportResponse> reportResponses;
}