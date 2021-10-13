package org.egov.assets.web.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.egov.assets.model.DisposalRequest;
import org.egov.assets.model.DisposalResponse;
import org.egov.assets.model.DisposalSearchContract;
import org.egov.assets.service.DisposalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/disposals")
public class DisposalsApiController {

	@Autowired
	private DisposalService disposalService;

	@PostMapping(value = "/_create", produces = { "application/json" }, consumes = { "application/json" })
	public ResponseEntity<DisposalResponse> disposalsCreatePost(
			@NotNull @RequestParam(value = "tenantId", required = true) String tenantId,
			@Valid @RequestBody DisposalRequest disposalRequest) {
		DisposalResponse disposalResponse = disposalService.create(disposalRequest, tenantId);
		return new ResponseEntity(disposalResponse, HttpStatus.OK);
	}

	@PostMapping(value = "/_search", produces = { "application/json" }, consumes = { "application/json" })
	public ResponseEntity<DisposalResponse> disposalsSearchPost(
			@NotNull @RequestParam(value = "tenantId", required = true) String tenantId,
			@Valid @RequestBody org.egov.common.contract.request.RequestInfo requestInfo,
			@Size(max = 50) @RequestParam(value = "ids", required = false) List<String> ids,
			@RequestParam(value = "store", required = false) String store,
			@RequestParam(value = "disposalNumber", required = false) String disposalNumber,
			@RequestParam(value = "disposalDate", required = false) Long disposalDate,
			@RequestParam(value = "handOverTo", required = false) String handOverTo,
			@RequestParam(value = "auctionNumber", required = false) String auctionNumber,
			@RequestParam(value = "disposalStatus", required = false) String disposalStatus,
			@RequestParam(value = "stateId", required = false) String stateId,
			@RequestParam(value = "totalDisposalValue", required = false) Double totalDisposalValue,
			@Min(0) @Max(100) @RequestParam(value = "pageSize", required = false) Integer pageSize,
			@RequestParam(value = "pageNumber", required = false) Integer pageNumber,
			@RequestParam(value = "sortBy", required = false) String sortBy,
			@RequestParam(value = "purpose", required = false) String purpose) {

		DisposalSearchContract disposalSearchContract = new DisposalSearchContract(ids, tenantId, store, disposalNumber,
				disposalDate, handOverTo, auctionNumber, disposalStatus, stateId, totalDisposalValue, pageSize,
				pageNumber, sortBy, purpose);
		DisposalResponse disposalResponse = disposalService.search(disposalSearchContract);
		return new ResponseEntity(disposalResponse, HttpStatus.OK);
	}

	@PostMapping(value = "/_update", produces = { "application/json" }, consumes = { "application/json" })
	public ResponseEntity<DisposalResponse> disposalsUpdatePost(
			@NotNull @RequestParam(value = "tenantId", required = true) String tenantId,
			@Valid @RequestBody DisposalRequest disposalRequest) {
		DisposalResponse disposalResponse = disposalService.update(disposalRequest, tenantId);
		return new ResponseEntity(disposalResponse, HttpStatus.OK);
	}

	@PostMapping(value = "/_preparedisposalfromscraps", produces = { "application/json" }, consumes = {
			"application/json" })
	public ResponseEntity<DisposalResponse> prepareDisposalFromScrap(
			@NotNull @Valid @RequestParam(value = "tenantId", required = true) String tenantId,
			@RequestBody DisposalRequest disposalRequest) {
		DisposalResponse disposalResponse = disposalService.prepareDisposalFromScrap(disposalRequest, tenantId);
		return new ResponseEntity(disposalResponse, HttpStatus.OK);
	}

}
