package org.egov.assets.web.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.egov.assets.model.PriceListRequest;
import org.egov.assets.model.PriceListResponse;
import org.egov.assets.model.PriceListSearchRequest;
import org.egov.assets.repository.PurchaseOrderJdbcRepository;
import org.egov.assets.service.PriceListService;
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

import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping(value = "/pricelists")
public class PricelistsApiController {

	private final ObjectMapper objectMapper;

	private PriceListService priceListService;

	private PurchaseOrderJdbcRepository purchaseOrderJdbcRepository;

	@Autowired
	public PricelistsApiController(ObjectMapper objectMapper, PriceListService priceListService,
			PurchaseOrderJdbcRepository purchaseOrderJdbcRepository) {
		this.objectMapper = objectMapper;
		this.priceListService = priceListService;
		this.purchaseOrderJdbcRepository = purchaseOrderJdbcRepository;
	}

	@PostMapping(value = "/_create", produces = { "application/json" }, consumes = { "application/json" })
	public ResponseEntity<PriceListResponse> pricelistsCreatePost(
			@NotNull @RequestParam(value = "tenantId", required = true) String tenantId,
			@Valid @RequestBody PriceListRequest priceListRequest) {
		// do some magic!
		return new ResponseEntity<>(priceListService.save(priceListRequest, tenantId), HttpStatus.OK);
	}

	@PostMapping(value = "/_gettenderusedquantity", produces = { "application/json" }, consumes = {
			"application/json" })
	public ResponseEntity<PriceListResponse> pricelistsGettenderusedquantityPost(@RequestBody RequestInfo requestInfo,
			@RequestParam(value = "material", required = false) String material,
			@RequestParam(value = "priceListId", required = false) String priceListId,
			@RequestParam(value = "uom", required = false) String uom,
			@RequestParam(value = "tenantId", required = false) String tenantId) {
		// do some magic!
		return new ResponseEntity<>(
				priceListService.getTenderUsedQty(material, priceListId, uom, tenantId, requestInfo), HttpStatus.OK);
	}

	@PostMapping(value = "/_search", produces = { "application/json" }, consumes = { "application/json" })
	public ResponseEntity<PriceListResponse> pricelistsSearchPost(
			@NotNull @RequestParam(value = "tenantId", required = true) String tenantId,
			@RequestBody RequestInfo requestInfo,
			@RequestParam(value = "suppliers", required = false) List<String> suppliers,
			@RequestParam(value = "supplierName", required = false) String supplierName,
			@RequestParam(value = "ids", required = false) String ids,
			@RequestParam(value = "rateContractNumber", required = false) String rateContractNumber,
			@RequestParam(value = "agreementNumber", required = false) List<String> agreementNumber,
			@RequestParam(value = "materialCode", required = false) String materialCode,
			@RequestParam(value = "rateContractDate", required = false) Long rateContractDate,
			@RequestParam(value = "agreementDate", required = false) Long agreementDate,
			@RequestParam(value = "agreementStartDate", required = false) Long agreementStartDate,
			@RequestParam(value = "agreementEndDate", required = false) Long agreementEndDate,
			@RequestParam(value = "asOnDate", required = false) Long asOnDate,
			@RequestParam(value = "rateType", required = false) String rateType,
			@Min(0) @Max(100) @RequestParam(value = "pageSize", required = false, defaultValue = "20") Integer pageSize,
			@RequestParam(value = "pageNumber", required = false, defaultValue = "1") Integer pageNumber,
			@RequestParam(value = "sortBy", required = false, defaultValue = "id") String sortBy) {
		PriceListSearchRequest priceListSearchRequest = PriceListSearchRequest.builder().tenantId(tenantId)
				// .ids(ids)
				.suppliers(suppliers).supplierName(supplierName).rateContractNumber(rateContractNumber)
				.rateContractDate(rateContractDate).agreementNumbers(agreementNumber).agreementDate(agreementDate)
				.agreementStartDate(agreementStartDate).agreementEndDate(agreementEndDate).rateType(rateType)
				.asOnDate(asOnDate).materialCode(materialCode).pageSize(pageSize).offSet(pageNumber - 1).sortBy(sortBy)
				.build();
		return new ResponseEntity<>(priceListService.search(priceListSearchRequest, requestInfo), HttpStatus.OK);
	}

	@PostMapping(value = "/_update", produces = { "application/json" }, consumes = { "application/json" })
	public ResponseEntity<PriceListResponse> pricelistsUpdatePost(
			@NotNull @RequestParam(value = "tenantId", required = true) String tenantId,
			@Valid @RequestBody PriceListRequest pricelistRequest) {
		// do some magic!
		return new ResponseEntity<>(priceListService.update(pricelistRequest, tenantId), HttpStatus.OK);
	}

}
