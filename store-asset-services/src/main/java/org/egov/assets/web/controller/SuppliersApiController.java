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

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.egov.assets.model.SupplierGetRequest;
import org.egov.assets.model.SupplierRequest;
import org.egov.assets.model.SupplierResponse;
import org.egov.assets.model.TransactionUsedResponse;
import org.egov.assets.service.SupplierService;
import org.egov.common.contract.request.RequestInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping(value = "/suppliers")
public class SuppliersApiController {

	private SupplierService supplierService;

	private static final Logger log = LoggerFactory.getLogger(SuppliersApiController.class);

	private final ObjectMapper objectMapper;

	private final HttpServletRequest request;

	@Autowired
	public SuppliersApiController(ObjectMapper objectMapper, HttpServletRequest request,
			SupplierService supplierService) {
		this.objectMapper = objectMapper;
		this.request = request;
		this.supplierService = supplierService;
	}

	// @PostMapping(value = "/_create", produces = { "application/json" }, consumes
	// = { "application/json" })
	// public ResponseEntity<SupplierResponse> suppliersCreatePost(
	// @NotNull @Valid @RequestParam(value = "tenantId", required = true) String
	// tenantId,
	// @Valid @RequestBody SupplierRequest supplierRequest,
	// @RequestHeader(value = "Accept", required = false) String accept) {
	// SupplierResponse supplierResponse = supplierService.create(supplierRequest,
	// tenantId);
	// return new ResponseEntity(supplierResponse, HttpStatus.OK);
	// }

	@PostMapping(value = "/_search", produces = { "application/json" }, consumes = { "application/json" })
	public ResponseEntity<SupplierResponse> suppliersSearchPost(
			@NotNull @RequestParam(value = "tenantId", required = true) String tenantId,
			@Valid @RequestBody org.egov.common.contract.request.RequestInfo requestInfo,
			@RequestParam(value = "codes", required = false) String codes,
			@RequestParam(value = "name", required = false) String name) {
		SupplierGetRequest supplierGetRequest = new SupplierGetRequest(null, codes, name, null, null, null, null, null,
				null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
				null, tenantId);
		SupplierResponse response = supplierService.search(supplierGetRequest);
		return new ResponseEntity(response, HttpStatus.OK);
	}

	// @PostMapping(value = "/_update", produces = { "application/json" }, consumes
	// = { "application/json" })
	// public ResponseEntity<SupplierResponse> suppliersUpdatePost(
	// @NotNull @Valid @RequestParam(value = "tenantId", required = true) String
	// tenantId,
	// @Valid @RequestBody SupplierRequest supplierRequest,
	// @RequestHeader(value = "Accept", required = false) String accept) {
	// SupplierResponse supplierResponse = supplierService.update(supplierRequest,
	// tenantId);
	// return new ResponseEntity(supplierResponse, HttpStatus.OK);
	// }
	//
	// @PostMapping(value = "/_transactionused", produces = { "application/json" },
	// consumes = { "application/json" })
	// public ResponseEntity<TransactionUsedResponse> suppliersTransactionusedPost(
	// @NotNull @RequestParam(value = "tenantId", required = true) String tenantId,
	// @Valid @RequestBody RequestInfo requestInfo, @RequestParam(value = "code",
	// required = true) String code) {
	// boolean usedInTransaction =
	// supplierService.checkSupplierUsedInTransaction(code, tenantId);
	// TransactionUsedResponse transactionUsedResponse = new
	// TransactionUsedResponse();
	// transactionUsedResponse.responseInfo(null).transactionUsed(usedInTransaction);
	// return new ResponseEntity<>(transactionUsedResponse, HttpStatus.OK);
	// }

}