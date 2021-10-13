package org.egov.assets.web.controller;

import javax.validation.constraints.NotNull;

import org.egov.assets.model.SupplierAdvanceRequisitionRequest;
import org.egov.assets.model.SupplierAdvanceRequisitionResponse;
import org.egov.assets.model.SupplierAdvanceRequisitionSearch;
import org.egov.assets.service.SupplierAdvanceRequisitionService;
import org.egov.common.contract.request.RequestInfo;
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
@RequestMapping(value = "/supplieradvancerequisitions")
public class SupplieradvancerequisitionsApiController {

	@Autowired
	SupplierAdvanceRequisitionService supplierAdvanceRequisitionService;

	@PostMapping(value = "/_create", produces = { "application/json" }, consumes = { "application/json" })
	public ResponseEntity<SupplierAdvanceRequisitionResponse> supplieradvancerequisitionsCreatePost(
			@NotNull @RequestParam(value = "tenantId", required = true) String tenantId,
			@RequestBody SupplierAdvanceRequisitionRequest supplierAdvanceRequisitionRequest) {
		SupplierAdvanceRequisitionResponse response = supplierAdvanceRequisitionService
				.create(supplierAdvanceRequisitionRequest);
		return new ResponseEntity(response, HttpStatus.OK);
	}

	@PostMapping(value = "/_search", produces = { "application/json" }, consumes = { "application/json" })
	public ResponseEntity<SupplierAdvanceRequisitionResponse> supplieradvancerequisitionsSearchPost(
			@NotNull @RequestParam(value = "tenantId", required = true) String tenantId,
			@RequestBody RequestInfo requestInfo, @RequestParam(value = "supplier", required = false) String supplier,
			@RequestParam(value = "purchaseOrder", required = false) String purchaseOrder,
			@RequestParam(value = "sarStatus", required = false) String sarStatus,
			@RequestParam(value = "stateId", required = false) String stateId,
			@RequestParam(value = "purchaseOrderDate", required = false) Long purchaseOrderDate) {
		SupplierAdvanceRequisitionSearch sars = SupplierAdvanceRequisitionSearch.builder().supplier(supplier)
				.purchaseOrder(purchaseOrder).sarStatus(sarStatus).stateId(stateId).build();
		SupplierAdvanceRequisitionResponse response = supplierAdvanceRequisitionService.search(sars, requestInfo);
		return new ResponseEntity(response, HttpStatus.OK);
	}

	@PostMapping(value = "/_update", produces = { "application/json" }, consumes = { "application/json" })
	public ResponseEntity<SupplierAdvanceRequisitionResponse> supplieradvancerequisitionsUpdatePost(
			@NotNull @RequestParam(value = "tenantId", required = true) String tenantId,
			@RequestBody SupplierAdvanceRequisitionRequest supplierAdvanceRequisitionRequest) {
		SupplierAdvanceRequisitionResponse response = supplierAdvanceRequisitionService
				.update(supplierAdvanceRequisitionRequest);
		return new ResponseEntity(response, HttpStatus.OK);
	}
}