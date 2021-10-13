package org.egov.assets.web.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.egov.assets.model.MaterialTypeStoreMappingSearch;
import org.egov.assets.model.MaterialTypeStoreRequest;
import org.egov.assets.model.MaterialTypeStoreResponse;
import org.egov.assets.service.MaterialTypeStoreMappingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/materialtypestoremapping")
public class MaterialtypestoremappingsApiController {

	@Autowired
	private MaterialTypeStoreMappingService materialTypeStoreMappingService;

	@PostMapping(value = "/_create", produces = { "application/json" }, consumes = { "application/json" })
	public ResponseEntity<MaterialTypeStoreResponse> materialtypestoremappingsCreatePost(
			@NotNull @RequestParam(value = "tenantId", required = true) String tenantId,
			@Valid @RequestBody MaterialTypeStoreRequest materialtypestoreRequest) {
		return new ResponseEntity<>(materialTypeStoreMappingService.create(materialtypestoreRequest, tenantId),
				HttpStatus.OK);
	}

	@PostMapping(value = "/_search", produces = { "application/json" }, consumes = { "application/json" })
	public ResponseEntity<MaterialTypeStoreResponse> materialstoremappingSearchPost(
			@NotNull @RequestParam(value = "tenantId", required = true) String tenantId,
			@Valid @RequestBody org.egov.common.contract.request.RequestInfo requestInfo,
			@Size(max = 50) @RequestParam(value = "ids", required = false) List<String> ids,
			@RequestParam(value = "materialType", required = false) String materialType,
			@RequestParam(value = "store", required = false) String store,
			@RequestParam(value = "active", required = false) Boolean active,
			@Min(0) @Max(100) @RequestParam(value = "pageSize", required = false, defaultValue = "20") Integer pageSize,
			@RequestParam(value = "offset", required = false) Integer offset,
			@RequestParam(value = "pageNumber", required = false, defaultValue = "1") Integer pageNumber,
			@RequestParam(value = "sortBy", required = false) String sortBy,
			@RequestHeader(value = "Accept", required = false) String accept, BindingResult errors) throws Exception {
		MaterialTypeStoreMappingSearch materialTypeStoreMappingSearch = MaterialTypeStoreMappingSearch.builder()
				.ids(ids).store(store).materialType(materialType).active(active).pageSize(pageSize).sortBy(sortBy)
				.tenantId(tenantId).build();
		return new ResponseEntity<>(materialTypeStoreMappingService.search(materialTypeStoreMappingSearch),
				HttpStatus.OK);
	}

	@PostMapping(value = "/_update", produces = { "application/json" }, consumes = { "application/json" })
	public ResponseEntity<MaterialTypeStoreResponse> materialtypestoremappingsUpdatePost(
			@NotNull @RequestParam(value = "tenantId", required = true) String tenantId,
			@Valid @RequestBody MaterialTypeStoreRequest materialtypestoreRequest) {
		return new ResponseEntity<>(materialTypeStoreMappingService.update(materialtypestoreRequest, tenantId),
				HttpStatus.OK);
	}

}
