package org.egov.assets.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.egov.assets.model.MaterialStoreMappingRequest;
import org.egov.assets.model.MaterialStoreMappingResponse;
import org.egov.assets.model.MaterialStoreMappingSearch;
import org.egov.assets.service.MaterialStoreMappingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping(value = "/materialstoremapping")
public class MaterialStoreMappingApiController {

	private static final Logger log = LoggerFactory.getLogger(MaterialStoreMappingApiController.class);

	private MaterialStoreMappingService materialStoreMappingService;

	private final ObjectMapper objectMapper;

	private final HttpServletRequest request;

	@Autowired
	public MaterialStoreMappingApiController(ObjectMapper objectMapper, HttpServletRequest request,
			MaterialStoreMappingService materialStoreMappingService) {
		this.objectMapper = objectMapper;
		this.request = request;
		this.materialStoreMappingService = materialStoreMappingService;
	}

	@PostMapping(value = "/_create", produces = { "application/json" }, consumes = { "application/json" })
	public ResponseEntity<MaterialStoreMappingResponse> materialstoremappingCreatePost(
			@NotNull @Valid @RequestParam(value = "tenantId", required = true) String tenantId,
			@Valid @RequestBody MaterialStoreMappingRequest materialStoreMappingRequest,
			@RequestHeader(value = "Accept", required = false) String accept, BindingResult errors) throws Exception {

		return new ResponseEntity<>(materialStoreMappingService.create(materialStoreMappingRequest, tenantId),
				HttpStatus.OK);
	}

	@PostMapping(value = "/_search", produces = { "application/json" }, consumes = { "application/json" })
	public ResponseEntity<MaterialStoreMappingResponse> materialstoremappingSearchPost(
			@NotNull @RequestParam(value = "tenantId", required = true) String tenantId,
			@Valid @RequestBody org.egov.common.contract.request.RequestInfo requestInfo,
			@Size(max = 50) @RequestParam(value = "ids", required = false) List<String> ids,
			@RequestParam(value = "material", required = false) String material,
			@RequestParam(value = "store", required = false) String store,
			@RequestParam(value = "active", required = false) Boolean active,
			@Min(0) @Max(100) @RequestParam(value = "pageSize", required = false, defaultValue = "20") Integer pageSize,
			@RequestParam(value = "offset", required = false) Integer offset,
			@RequestParam(value = "pageNumber", required = false, defaultValue = "1") Integer pageNumber,
			@RequestParam(value = "sortBy", required = false) String sortBy,
			@RequestHeader(value = "Accept", required = false) String accept, BindingResult errors) throws Exception {
		MaterialStoreMappingSearch materialStoreMappingSearch = MaterialStoreMappingSearch.builder().ids(ids)
				.store(store).material(material).active(active).pageSize(pageSize).offset(offset).sortBy(sortBy)
				.tenantId(tenantId).build();
		return new ResponseEntity<>(materialStoreMappingService.search(materialStoreMappingSearch, requestInfo),
				HttpStatus.OK);
	}

	@PostMapping(value = "/_update", produces = { "application/json" }, consumes = { "application/json" })
	public ResponseEntity<MaterialStoreMappingResponse> materialstoremappingUpdatePost(
			@NotNull @Valid @RequestParam(value = "tenantId", required = true) String tenantId,
			@Valid @RequestBody MaterialStoreMappingRequest materialStoreMappingRequest,
			@RequestHeader(value = "Accept", required = false) String accept, BindingResult errors) throws Exception {

		return new ResponseEntity<>(materialStoreMappingService.update(materialStoreMappingRequest, tenantId),
				HttpStatus.OK);
	}

}
