package org.egov.assets.web.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.egov.assets.model.MaterialTypeRequest;
import org.egov.assets.model.MaterialTypeResponse;
import org.egov.assets.model.MaterialTypeSearch;
import org.egov.assets.service.MaterialTypeService;
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
@RequestMapping(value = "/materialtypes")
public class MaterialtypesApiController {

	@Autowired
	private MaterialTypeService materialTypeService;

	@PostMapping(value = "/_create", produces = { "application/json" }, consumes = { "application/json" })
	public ResponseEntity<MaterialTypeResponse> materialtypesCreatePost(
			@NotNull @RequestParam(value = "tenantId", required = true) String tenantId,
			@Valid @RequestBody MaterialTypeRequest materialTypeRequest) {

		return new ResponseEntity<>(materialTypeService.save(materialTypeRequest, tenantId), HttpStatus.OK);
	}

	@PostMapping(value = "/_search", produces = { "application/json" }, consumes = { "application/json" })
	public ResponseEntity<MaterialTypeResponse> materialtypesSearchPost(
			@NotNull @RequestParam(value = "tenantId", required = true) String tenantId,
			@Valid @RequestBody RequestInfo requestInfo,
			@Size(max = 50) @RequestParam(value = "ids", required = false) List<String> ids,
			@RequestParam(value = "code", required = false) String code,
			@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "store", required = false) String store,
			@RequestParam(value = "active", required = false, defaultValue = "true") Boolean active,
			@Min(0) @Max(100) @RequestParam(value = "pageSize", required = false, defaultValue = "20") Integer pageSize,
			@RequestParam(value = "pageNumber", required = false, defaultValue = "1") Integer pageNumber,
			@RequestParam(value = "sortBy", required = false, defaultValue = "id") String sortBy) {

		MaterialTypeSearch materialTypeSearch = MaterialTypeSearch.builder().code(code).ids(ids).name(name).store(store)
				.active(active).tenantId(tenantId).build();
		return new ResponseEntity<>(materialTypeService.search(materialTypeSearch, requestInfo), HttpStatus.OK);
	}

	@PostMapping(value = "/_update", produces = { "application/json" }, consumes = { "application/json" })
	public ResponseEntity<MaterialTypeResponse> materialtypesUpdatePost(
			@NotNull @RequestParam(value = "tenantId", required = true) String tenantId,
			@Valid @RequestBody MaterialTypeRequest materialTypeRequest) {

		return new ResponseEntity<>(materialTypeService.update(materialTypeRequest, tenantId), HttpStatus.OK);
	}

}
