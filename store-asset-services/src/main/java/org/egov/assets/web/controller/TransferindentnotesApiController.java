package org.egov.assets.web.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.egov.assets.model.TransferIndentNoteRequest;
import org.egov.assets.model.TransferIndentNoteResponse;
import org.egov.common.contract.request.RequestInfo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/transferindentnotes")
public class TransferindentnotesApiController {

	@PostMapping(value = "/_create", produces = { "application/json" }, consumes = { "application/json" })
	public ResponseEntity<TransferIndentNoteResponse> transferindentnotesCreatePost(
			@NotNull @RequestParam(value = "tenantId", required = true) String tenantId,
			@Valid @RequestBody TransferIndentNoteRequest transferIndentNoteRequest) {
		// do some magic!
		return new ResponseEntity<TransferIndentNoteResponse>(HttpStatus.OK);
	}

	@PostMapping(value = "/_search", produces = { "application/json" }, consumes = { "application/json" })
	public ResponseEntity<TransferIndentNoteResponse> transferindentnotesSearchPost(
			@NotNull @RequestParam(value = "tenantId", required = true) String tenantId,
			@Valid @RequestBody RequestInfo requestInfo,
			@Size(max = 50) @RequestParam(value = "ids", required = false) List<String> ids,
			@RequestParam(value = "indentNumber", required = false) String indentNumber,
			@RequestParam(value = "indentStore", required = false) Long indentStore,
			@RequestParam(value = "stateId", required = false) Long stateId,
			@Min(0) @Max(100) @RequestParam(value = "pageSize", required = false, defaultValue = "20") Integer pageSize,
			@RequestParam(value = "pageNumber", required = false, defaultValue = "1") Integer pageNumber,
			@RequestParam(value = "sortBy", required = false, defaultValue = "id") String sortBy) {
		// do some magic!
		return new ResponseEntity<TransferIndentNoteResponse>(HttpStatus.OK);
	}

	@PostMapping(value = "/_update", produces = { "application/json" }, consumes = { "application/json" })
	public ResponseEntity<TransferIndentNoteResponse> transferindentnotesUpdatePost(
			@NotNull @RequestParam(value = "tenantId", required = true) String tenantId,
			@Valid @RequestBody TransferIndentNoteRequest transferIndentNoteRequest) {
		// do some magic!
		return new ResponseEntity<TransferIndentNoteResponse>(HttpStatus.OK);
	}

}
