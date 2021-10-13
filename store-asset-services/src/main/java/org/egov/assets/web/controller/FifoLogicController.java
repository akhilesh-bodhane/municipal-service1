package org.egov.assets.web.controller;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.egov.assets.model.FifoRequest;
import org.egov.assets.model.FifoResponse;
import org.egov.assets.service.MaterialIssueReceiptFifoLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/fifologic")
public class FifoLogicController {

	@Autowired
	private MaterialIssueReceiptFifoLogic materialIssueReceiptFifoLogic;

	@PostMapping(value = "/_stock")
	@ResponseBody
	public ResponseEntity<FifoResponse> getStockAvailableAsPerMaterial(
			@NotNull @Valid @RequestParam(value = "tenantId", required = true) String tenantId,
			@Valid @RequestBody FifoRequest fifoRequest) {
		FifoResponse fifoResponse = materialIssueReceiptFifoLogic.getTotalStockAsPerMaterial(fifoRequest);
		return new ResponseEntity(fifoResponse, HttpStatus.OK);
	}

	@PostMapping(value = "/_unitrate")
	@ResponseBody
	public ResponseEntity<FifoResponse> getUnitPrice(
			@NotNull @Valid @RequestParam(value = "tenantId", required = true) String tenantId,
			@Valid @RequestBody FifoRequest fifoRequest) {
		FifoResponse fifoResponse = materialIssueReceiptFifoLogic.getUnitRate(fifoRequest);
		return new ResponseEntity(fifoResponse, HttpStatus.OK);
	}

}
