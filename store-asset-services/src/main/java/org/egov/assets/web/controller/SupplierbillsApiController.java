package org.egov.assets.web.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.egov.assets.model.SupplierBillRequest;
import org.egov.assets.model.SupplierBillResponse;
import org.egov.assets.model.SupplierBillSearch;
import org.egov.assets.service.SupplierBillService;
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
@RequestMapping(value = "/supplierbills")
public class SupplierbillsApiController {

	private SupplierBillService supplierBillService;

	@Autowired
	public SupplierbillsApiController(SupplierBillService supplierBillService) {
		this.supplierBillService = supplierBillService;
	}

	@PostMapping(value = "/_create", produces = { "application/json" }, consumes = { "application/json" })
	public ResponseEntity<SupplierBillResponse> supplierbillsCreatePost(
			@NotNull @RequestParam(value = "tenantId", required = true) String tenantId,
			@Valid @RequestBody SupplierBillRequest supplierBillRequest) {
		return new ResponseEntity<SupplierBillResponse>(supplierBillService.create(supplierBillRequest, tenantId),
				HttpStatus.OK);
	}

	@PostMapping(value = "/_search", produces = { "application/json" }, consumes = { "application/json" })
	public ResponseEntity<SupplierBillResponse> supplierbillsSearchPost(
			@Valid @RequestBody org.egov.common.contract.request.RequestInfo requestInfo,
			@NotNull @RequestParam(value = "tenantId", required = true) String tenantId,
			@Size(max = 50) @RequestParam(value = "ids", required = false) List<String> ids,
			@RequestParam(value = "store", required = false) String store,
			@RequestParam(value = "invoiceNumber", required = false) String invoiceNumber,
			@RequestParam(value = "invoiceDate", required = false) Long invoiceDate,
			@RequestParam(value = "approvedDate", required = false) Long approvedDate,
			@Min(0) @Max(100) @RequestParam(value = "pageSize", required = false, defaultValue = "20") Integer pageSize,
			@RequestParam(value = "pageNumber", required = false, defaultValue = "1") Integer pageNumber,
			@RequestParam(value = "sortBy", required = false, defaultValue = "id") String sortBy) {
		SupplierBillSearch supplierBillSearch = SupplierBillSearch.builder().ids(ids).invoiceDate(invoiceDate)
				.invoiceNumber(invoiceNumber).approvedDate(approvedDate).pageSize(pageSize).store(store)
				.tenantId(tenantId).pageNumber(pageNumber).build();

		return new ResponseEntity<SupplierBillResponse>(supplierBillService.search(supplierBillSearch), HttpStatus.OK);
	}

	@PostMapping(value = "/_update", produces = { "application/json" }, consumes = { "application/json" })
	public ResponseEntity<SupplierBillResponse> supplierbillsUpdatePost(
			@NotNull @RequestParam(value = "tenantId", required = true) String tenantId,
			@Valid @RequestBody SupplierBillRequest supplierBillRequest) {
		return new ResponseEntity<SupplierBillResponse>(supplierBillService.update(supplierBillRequest, tenantId),
				HttpStatus.OK);
	}

}
