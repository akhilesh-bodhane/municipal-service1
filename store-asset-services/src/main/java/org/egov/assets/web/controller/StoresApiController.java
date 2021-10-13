/*
 * eGov suite of products aim to improve the internal efficiency,transparency,
 *    accountability and the service delivery of the government  organizations.
 *
 *     Copyright (C) <2015>  eGovernments Foundation
 *
 *     The updated version of eGov suite of products as by eGovernments Foundation
 *     is available at http://www.egovernments.org
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with this program. If not, see http://www.gnu.org/licenses/ or
 *     http://www.gnu.org/licenses/gpl.html .
 *
 *     In addition to the terms of the GPL license to be adhered to in using this
 *     program, the following additional terms are to be complied with:
 *
 *         1) All versions of this program, verbatim or modified must carry this
 *            Legal Notice.
 *
 *         2) Any misrepresentation of the origin of the material is prohibited. It
 *            is required that all modified versions of this material be marked in
 *            reasonable ways as different from the original version.
 *
 *         3) This license does not grant any rights to any user of the program
 *            with regards to rights under trademark law for use of the trade names
 *            or trademarks of eGovernments Foundation.
 *
 *   In case of any queries, you can reach eGovernments Foundation at contact@egovernments.org.
 */
package org.egov.assets.web.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.egov.assets.model.StoreGetRequest;
import org.egov.assets.model.StoreRequest;
import org.egov.assets.model.StoreResponse;
import org.egov.assets.model.TransactionUsedResponse;
import org.egov.assets.service.StoreService;
import org.egov.common.contract.request.RequestInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping(value = "/stores")
public class StoresApiController {

	@Autowired
	private StoreService storesService;

	private final ObjectMapper objectMapper;

	public StoresApiController(ObjectMapper objectMapper) {
		this.objectMapper = objectMapper;
	}

	@PostMapping(value = "/_create", produces = { "application/json" }, consumes = {
			"application/json" })
	public ResponseEntity<StoreResponse> storesCreatePost(
			@Valid @RequestParam(value = "tenantId", required = true) String tenantId,
			@Valid @RequestBody StoreRequest storeRequest,
			@RequestHeader(value = "Accept", required = false) String accept) {
		StoreResponse storeResponse = storesService.create(storeRequest, tenantId);
		return new ResponseEntity(storeResponse, HttpStatus.OK);
	}

	@PostMapping(value = "/_search", produces = { "application/json" }, consumes = {
			"application/json" })
	public ResponseEntity<StoreResponse> storesSearchPost(
			@NotNull @Valid @RequestParam(value = "tenantId", required = true) String tenantId,
			@Valid @RequestBody org.egov.common.contract.request.RequestInfo requestInfo,
			@Size(max = 50) @Valid @RequestParam(value = "ids", required = false) List<String> ids,
			@Valid @RequestParam(value = "codes", required = false) List<String> codes,
			@Valid @RequestParam(value = "name", required = false) String name,
			@Valid @RequestParam(value = "searchPurpose", required = false) String searchPurpose,
			@Valid @RequestParam(value = "description", required = false) String description,
			@Valid @RequestParam(value = "department", required = false) String department,
			@Valid @RequestParam(value = "billingAddress", required = false) String billingAddress,
			@Valid @RequestParam(value = "deliveryAddress", required = false) String deliveryAddress,
			@Valid @RequestParam(value = "contactNo1", required = false) String contactNo1,
			@Valid @RequestParam(value = "contactNo2", required = false) String contactNo2,
			@Valid @RequestParam(value = "officelocation", required = false) String officelocation,
			@Valid @RequestParam(value = "email", required = false) String email,
			@Valid @RequestParam(value = "storeInCharge", required = false) String storeInCharge,
			@Valid @RequestParam(value = "isCentralStore", required = false) Boolean isCentralStore,
			@Valid @RequestParam(value = "active", required = false) Boolean active,
			@Valid @RequestParam(value = "pageSize", required = false) Integer pageSize,
			@Valid @RequestParam(value = "offset", required = false) Integer offset,
			@Valid @RequestParam(value = "sortBy", required = false) String sortBy,
			@RequestHeader(value = "Accept", required = false) String accept) {

		StoreGetRequest storeGetRequest = new StoreGetRequest(ids, codes, name, searchPurpose, description, department,
				contactNo1, officelocation, billingAddress, deliveryAddress, contactNo2, email, isCentralStore,
				storeInCharge, active, sortBy, pageSize, offset, tenantId);
		StoreResponse response = storesService.search(storeGetRequest);

		return new ResponseEntity(response, HttpStatus.OK);
	}

	@PostMapping(value = "/_update", produces = { "application/json" }, consumes = {
			"application/json" })
	public ResponseEntity<StoreResponse> storesUpdatePost(
			@NotNull @Valid @RequestParam(value = "tenantId", required = true) String tenantId,
			@Valid @RequestBody StoreRequest storeRequest,
			@RequestHeader(value = "Accept", required = false) String accept) {
		StoreResponse storeResponse = storesService.update(storeRequest, tenantId);
		return new ResponseEntity(storeResponse, HttpStatus.OK);
	}

	@PostMapping(value = "/_transactionused", produces = { "application/json" }, consumes = {
			"application/json" })
	public ResponseEntity<TransactionUsedResponse> storesTransactionusedPost(
			@NotNull @RequestParam(value = "tenantId", required = true) String tenantId,
			@Valid @RequestBody RequestInfo requestInfo, @RequestParam(value = "code", required = true) String code) {
		boolean usedInTransaction = storesService.checkStoreUsedInTransaction(code, tenantId);
		TransactionUsedResponse transactionUsedResponse = new TransactionUsedResponse();
		transactionUsedResponse.responseInfo(null).transactionUsed(usedInTransaction);
		return new ResponseEntity<>(transactionUsedResponse, HttpStatus.OK);
	}
	
}
