package org.egov.assets.web.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.egov.assets.model.MaterialRequest;
import org.egov.assets.model.MaterialResponse;
import org.egov.assets.model.MaterialSearchRequest;
import org.egov.assets.service.MaterialService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping(value = "/materials")
public class MaterialsApiController {
	private final ObjectMapper objectMapper;

	private MaterialService materialService;

	public MaterialsApiController(ObjectMapper objectMapper, MaterialService materialService) {
		this.objectMapper = objectMapper;
		this.materialService = materialService;
	}

	@PostMapping(value = "/_create", produces = { "application/json" }, consumes = { "application/json" })
	public ResponseEntity<MaterialResponse> materialsCreatePost(
			@NotNull @Valid @RequestParam(value = "tenantId", required = true) String tenantId,
			@Valid @RequestBody MaterialRequest materialRequest,
			@RequestHeader(value = "Accept", required = false) String accept) {
		return new ResponseEntity<>(materialService.save(materialRequest, tenantId), HttpStatus.OK);
	}

	@PostMapping(value = "/_search", produces = { "application/json" }, consumes = { "application/json" })
	public ResponseEntity<MaterialResponse> materialsSearchPost(
			@NotNull @Valid @RequestParam(value = "tenantId", required = true) String tenantId,
			@Valid @RequestBody org.egov.common.contract.request.RequestInfo requestInfo,
			@Size(max = 50) @Valid @RequestParam(value = "ids", required = false) List<String> ids,
			@Valid @RequestParam(value = "code", required = false) String code,
			@Valid @RequestParam(value = "store", required = false) String store,
			@Valid @RequestParam(value = "name", required = false) String name,
			@Valid @RequestParam(value = "description", required = false) String description,
			@Valid @RequestParam(value = "oldCode", required = false) String oldCode,
			@Valid @RequestParam(value = "materialType", required = false) String materialType,
			@Valid @RequestParam(value = "baseUom", required = false) Long baseUom,
			@Valid @RequestParam(value = "inventoryType", required = false) String inventoryType,
			@Valid @RequestParam(value = "status", required = false) String status,
			@Valid @RequestParam(value = "purchaseUom", required = false) Long purchaseUom,
			@Valid @RequestParam(value = "expenseAccount", required = false) Long expenseAccount,
			@Valid @RequestParam(value = "minQuantity", required = false) Long minQuantity,
			@Valid @RequestParam(value = "maxQuantity", required = false) Long maxQuantity,
			@Valid @RequestParam(value = "staockingUom", required = false) Long staockingUom,
			@Valid @RequestParam(value = "materialClass", required = false) String materialClass,
			@Valid @RequestParam(value = "reorderLevel", required = false) Long reorderLevel,
			@Valid @RequestParam(value = "reorderQuantity", required = false) Long reorderQuantity,
			@Valid @RequestParam(value = "materialControlType", required = false) String materialControlType,
			@Valid @RequestParam(value = "model", required = false) String model,
			@Valid @RequestParam(value = "manufacturePartNo", required = false) String manufacturePartNo,
			@Valid @RequestParam(value = "techincalSpecs", required = false) String techincalSpecs,
			@Valid @RequestParam(value = "termsOfDelivery", required = false) String termsOfDelivery,
			@Valid @RequestParam(value = "overrideMaterialControlType", required = false) Boolean overrideMaterialControlType,
			@Valid @RequestParam(value = "pageSize", required = false) Integer pageSize,
			@Valid @RequestParam(value = "offset", required = false) Integer offset,
			@Valid @RequestParam(value = "sortBy", required = false) String sortBy,
			@RequestHeader(value = "Accept", required = false) String accept) {

		MaterialSearchRequest materialSearchRequest = MaterialSearchRequest.builder().tenantId(tenantId).ids(ids)
				.code(code).store(store).name(name).description(description).oldCode(oldCode).materialType(materialType)
				.inventoryType(inventoryType).status(status).materialClass(materialClass)
				.materialControlType(materialControlType).model(model).manufacturePartNo(manufacturePartNo)
				.pageSize(pageSize).offSet(offset).sortBy(sortBy).build();

		return new ResponseEntity<>(materialService.search(materialSearchRequest, requestInfo), HttpStatus.OK);
	}

	@PostMapping(value = "/_update", produces = { "application/json" }, consumes = { "application/json" })
	public ResponseEntity<MaterialResponse> materialsUpdatePost(
			@NotNull @Valid @RequestParam(value = "tenantId", required = true) String tenantId,
			@Valid @RequestBody MaterialRequest materialRequest,
			@RequestHeader(value = "Accept", required = false) String accept) {

		return new ResponseEntity<>(materialService.update(materialRequest, tenantId), HttpStatus.OK);
	}

}
