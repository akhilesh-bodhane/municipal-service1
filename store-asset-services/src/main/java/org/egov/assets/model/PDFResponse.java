package org.egov.assets.model;

import java.util.List;

import org.egov.common.contract.response.ResponseInfo;
import org.json.simple.JSONArray;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PDFResponse {

	@JsonProperty("responseInfo")
	private ResponseInfo responseInfo;

	@JsonProperty("message")
	private String message;

	@JsonProperty("filestoreIds")
	private List<String> filestoreIds;

	@JsonProperty("jobid")
	private String jobid;

	@JsonProperty("createdtime")
	private Long createdtime;

	@JsonProperty("endime")
	private Long endime;

	@JsonProperty("tenantid")
	private String tenantid;

	@JsonProperty("totalcount")
	private int totalcount;

	@JsonProperty("printData")
	private Object printData;

}
