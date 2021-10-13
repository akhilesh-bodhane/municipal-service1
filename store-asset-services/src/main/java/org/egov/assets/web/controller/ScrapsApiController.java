package org.egov.assets.web.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.egov.assets.model.Scrap;
import org.egov.assets.model.ScrapRequest;
import org.egov.assets.model.ScrapResponse;
import org.egov.assets.model.ScrapSearch;
import org.egov.assets.model.StatusNums.StatusEnum;
import org.egov.assets.service.ScrapService;
import org.egov.common.contract.request.RequestInfo;
import org.egov.common.contract.response.ResponseInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@javax.annotation.Generated(value = "org.egov.inv.codegen.languages.SpringCodegen", date = "2017-11-08T13:51:07.770Z")

@RestController
@RequestMapping(value = "/scraps")
public class ScrapsApiController {

	@Autowired
	private ScrapService scrapService;

	@PostMapping(value = "/_create", produces = { "application/json" }, consumes = { "application/json" })
	public ResponseEntity<ScrapResponse> scrapsCreatePost(
			@NotNull @RequestParam(value = "tenantId", required = true) String tenantId,
			@Valid @RequestBody ScrapRequest scrapRequest) {

		List<Scrap> scrap = scrapService.create(scrapRequest, tenantId);
		ScrapResponse scrapResponse = buildScrapResponse(scrap, scrapRequest.getRequestInfo());

		return new ResponseEntity<ScrapResponse>(scrapResponse, HttpStatus.OK);
	}

	@PostMapping(value = "/_search", produces = { "application/json" }, consumes = { "application/json" })
	public ResponseEntity<ScrapResponse> scrapsSearchPost(
			@NotNull @RequestParam(value = "tenantId", required = true) String tenantId,
			@Valid @RequestBody org.egov.common.contract.request.RequestInfo requestInfo,
			@Size(max = 50) @RequestParam(value = "ids", required = false) List<String> ids,
			@RequestParam(value = "store", required = false) String store,
			@RequestParam(value = "scrapNumber", required = false) List<String> scrapNumber,
			@RequestParam(value = "scrapDate", required = false) Long scrapDate,
			@RequestParam(value = "description", required = false) String description,
			@RequestParam(value = "scrapStatus", required = false) String scrapStatus,
			@RequestParam(value = "stateId", required = false) Long stateId,
			@Min(0) @Max(100) @RequestParam(value = "pageSize", required = false, defaultValue = "20") Integer pageSize,
			@RequestParam(value = "pageNumber", required = false, defaultValue = "1") Integer pageNumber,
			@RequestParam(value = "sortBy", required = false, defaultValue = "id") String sortBy) {

		ScrapSearch scrapSearch = ScrapSearch.builder().ids(ids).tenantId(tenantId).store(store)
				.scrapStatus(scrapStatus).scrapNumber(scrapNumber).pageNumber(pageNumber).pageSize(pageSize).build();
		return new ResponseEntity<>(scrapService.search(scrapSearch), HttpStatus.OK);
	}

	@PostMapping(value = "/_update", produces = { "application/json" }, consumes = { "application/json" })
	public ResponseEntity<ScrapResponse> scrapsUpdatePost(
			@NotNull @RequestParam(value = "tenantId", required = true) String tenantId,
			@Valid @RequestBody ScrapRequest scrapRequest) {
		List<Scrap> scrap = scrapService.update(scrapRequest, tenantId);
		ScrapResponse scrapResponse = buildScrapResponse(scrap, scrapRequest.getRequestInfo());
		return new ResponseEntity<ScrapResponse>(scrapResponse, HttpStatus.OK);
	}

	private ScrapResponse buildScrapResponse(List<Scrap> scrap, RequestInfo requestInfo) {
		return ScrapResponse.builder().responseInfo(getResponseInfo(requestInfo)).scraps(scrap).build();
	}

	private ResponseInfo getResponseInfo(RequestInfo requestInfo) {
		return ResponseInfo.builder().apiId(requestInfo.getApiId()).ver(requestInfo.getVer())
				.resMsgId(requestInfo.getMsgId()).resMsgId("placeholder").status(StatusEnum.SUCCESSFUL.toString())
				.build();
	}

}
