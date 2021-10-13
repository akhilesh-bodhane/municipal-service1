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
package org.egov.assets.service;

import static org.springframework.util.StringUtils.isEmpty;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.egov.assets.common.Constants;
import org.egov.assets.common.DomainService;
import org.egov.assets.common.MdmsRepository;
import org.egov.assets.common.Pagination;
import org.egov.assets.common.exception.CustomBindException;
import org.egov.assets.common.exception.ErrorCode;
import org.egov.assets.common.exception.InvalidDataException;
import org.egov.assets.model.Department;
import org.egov.assets.model.Indent;
import org.egov.assets.model.IndentSearch;
import org.egov.assets.model.Location;
import org.egov.assets.model.MaterialIssue;
import org.egov.assets.model.MaterialIssueSearchContract;
import org.egov.assets.model.MaterialReceipt;
import org.egov.assets.model.MaterialReceiptSearch;
import org.egov.assets.model.PurchaseOrder;
import org.egov.assets.model.PurchaseOrderSearch;
import org.egov.assets.model.Store;
import org.egov.assets.model.StoreGetRequest;
import org.egov.assets.model.StoreRequest;
import org.egov.assets.model.StoreResponse;
import org.egov.assets.repository.IndentJdbcRepository;
import org.egov.assets.repository.MaterialIssueJdbcRepository;
import org.egov.assets.repository.MaterialReceiptJdbcRepository;
import org.egov.assets.repository.PurchaseOrderJdbcRepository;
import org.egov.assets.repository.StoreJdbcRepository;
import org.egov.assets.repository.entity.StoreEntity;
import org.egov.common.contract.request.RequestInfo;
import org.egov.tracer.kafka.LogAwareKafkaTemplate;
import org.egov.tracer.model.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

import net.minidev.json.JSONArray;

@Service
public class StoreService extends DomainService {

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private StoreJdbcRepository storeJdbcRepository;

	@Value("${inv.store.save.topic}")
	private String createTopic;

	@Value("${inv.store.update.topic}")
	private String updateTopic;

	@Value("${inv.store.save.key}")
	private String createKey;

	@Value("${inv.store.update.key}")
	private String updateKey;

	@Autowired
	private LogAwareKafkaTemplate<String, Object> kafkaTemplate;

	@Autowired
	private MdmsRepository mdmsRepository;

	@Autowired
	private IndentJdbcRepository indentJdbcRepository;

	@Autowired
	private PurchaseOrderJdbcRepository purchaseOrderJdbcRepository;

	@Autowired
	private MaterialReceiptJdbcRepository materialReceiptJdbcRepository;

	@Autowired
	private MaterialIssueJdbcRepository materialIssueJdbcRepository;

	public StoreResponse create(StoreRequest storeRequest, String tenantId) {
		try {
			StoreRequest fetchRelated = fetchRelated(storeRequest, tenantId);
			validate(fetchRelated.getStores(), Constants.ACTION_CREATE, tenantId);
			List<String> sequenceNos = storeJdbcRepository.getSequence(Store.class.getSimpleName(),
					storeRequest.getStores().size());
			int i = 0;
			for (Store store : storeRequest.getStores()) {
				store.setId(sequenceNos.get(i));

				if (isEmpty(store.getTenantId())) {
					store.setTenantId(tenantId);
				}
				i++;
				store.setAuditDetails(mapAuditDetails(storeRequest.getRequestInfo()));
			}
			kafkaTemplate.send(createTopic, createKey, storeRequest);
			StoreResponse response = new StoreResponse();
			response.setStores(storeRequest.getStores());
			response.setResponseInfo(getResponseInfo(storeRequest.getRequestInfo()));
			return response;
		} catch (CustomBindException e) {
			throw new CustomException("STORE_EXCEPTION", e.getMessage());
		}
	}

	public StoreResponse update(StoreRequest storeRequest, String tenantId) {

		try {
			StoreRequest fetchRelated = fetchRelated(storeRequest, tenantId);
			validate(fetchRelated.getStores(), Constants.ACTION_UPDATE, tenantId);

			List<Store> storeList = new ArrayList<>();
			for (Store store : storeRequest.getStores()) {
				boolean storeUsed = checkStoreUsedInTransaction(store.getCode(), store.getTenantId());
				if (storeUsed) {
					throw new CustomException("Invalid Action", "Can't Update Store Used in Transaction");
					/*
					 * Boolean active = store.getActive(); StoreEntity storeEntity = new
					 * StoreEntity(); storeEntity.setId(store.getId());
					 * storeEntity.setTenantId(tenantId); StoreEntity storeResult = (StoreEntity)
					 * storeJdbcRepository.findById(storeEntity, StoreEntity.class.getSimpleName());
					 * 
					 * store = storeResult.toDomain(); store.setActive(active);
					 * storeList.add(store);
					 */
				} else {
					if (isEmpty(store.getTenantId())) {
						store.setTenantId(tenantId);
					}
					store.setAuditDetails(mapAuditDetailsForUpdate(storeRequest.getRequestInfo()));
					storeList.add(store);
				}
			}
			storeRequest.setStores(storeList);
			kafkaTemplate.send(updateTopic, updateKey, storeRequest);
			StoreResponse response = new StoreResponse();
			response.setStores(storeRequest.getStores());
			response.setResponseInfo(getResponseInfo(storeRequest.getRequestInfo()));
			return response;
		} catch (CustomBindException e) {
			throw new CustomException("STORE_EXCEPTION", e.getMessage());
		}
	}

	public StoreResponse search(StoreGetRequest storeGetRequest) {

		StoreResponse storeResponse = new StoreResponse();
		Pagination<Store> search = storeJdbcRepository.search(storeGetRequest);
		if (!search.getPagedData().isEmpty()) {

			Map<String, Department> departmentMap = getDepartment(storeGetRequest.getTenantId());
			Map<String, Location> locationMap = getLocation(storeGetRequest.getTenantId());

			for (Store store : search.getPagedData()) {
				store.setDepartment(departmentMap.get(store.getDepartment().getCode()));
				store.setOfficeLocation(locationMap.get(store.getOfficeLocation().getCode()));
			}

			storeResponse.setResponseInfo(null);
			storeResponse.setStores(search.getPagedData());
			return storeResponse;
		} else {
			storeResponse.setResponseInfo(null);
			storeResponse.setStores(Collections.EMPTY_LIST);
			return storeResponse;
		}
	}

	private void validate(List<Store> stores, String method, String tenantId) {
		InvalidDataException errors = new InvalidDataException();

		try {
			switch (method) {

			case Constants.ACTION_CREATE: {
				if (stores == null) {
					throw new InvalidDataException("stores", ErrorCode.NOT_NULL.getCode(), null);
				}
			}
				break;

			case Constants.ACTION_UPDATE: {
				if (stores == null) {
					throw new InvalidDataException("stores", ErrorCode.NOT_NULL.getCode(), null);
				}
				for (Store store : stores) {
					if (store.getId() == null) {
						throw new InvalidDataException("id", ErrorCode.MANDATORY_VALUE_MISSING.getCode(),
								store.getCode());
					}

					if (isEmpty(store.getTenantId())) {
						store.setTenantId(tenantId);
					}

				}
			}
				break;
			}

			for (Store store : stores) {
				if (isEmpty(store.getTenantId())) {
					store.setTenantId(tenantId);
				}
				if (!storeJdbcRepository.uniqueCheck("code", new StoreEntity().toEntity(store))) {
					errors.addDataError(ErrorCode.CODE_ALREADY_EXISTS.getCode(), "Store", store.getCode());

				}

				if (!storeJdbcRepository.uniqueCheck("name", new StoreEntity().toEntity(store))) {
					errors.addDataError(ErrorCode.NAME_ALREADY_EXISTS.getCode(), "Store", store.getName());

				}
			}

		} catch (IllegalArgumentException e) {
			throw new CustomException("STORE_EXCEPTION", e.getMessage());
		}
		if (!errors.getValidationErrors().isEmpty())
			throw errors;
	}

	private StoreRequest fetchRelated(StoreRequest storeRequest, String tenantId) {

		List<Store> stores = storeRequest.getStores();

		for (Store store : stores) {
			// fetch and set department
			if (null != store && !isEmpty(store.getDepartment().getCode())) {
				Object object = mdmsRepository.fetchObject(tenantId, "store-asset", "Department", "code",
						store.getDepartment().getCode(), Department.class, storeRequest.getRequestInfo());
				store.setDepartment((Department) object);
			}

			// fetch and add office location
			if (null != store && !isEmpty(store.getOfficeLocation().getCode())) {
				Object object = mdmsRepository.fetchObject(tenantId, "store-asset", "Location", "code",
						store.getOfficeLocation().getCode(), Location.class, storeRequest.getRequestInfo());

				store.setOfficeLocation((Location) object);
			}

			if (store != null && store.getCode() != null)
				store.setCode(store.getCode().toUpperCase());
		}

		return storeRequest;
	}

	public boolean checkStoreUsedInTransaction(String code, String tenantId) {
		IndentSearch indentSearch = new IndentSearch();
		indentSearch.setIssueStore(code);
		indentSearch.setTenantId(tenantId);

		Pagination<Indent> indents = indentJdbcRepository.search(indentSearch);
		if (!indents.getPagedData().isEmpty()) {
			return true;
		}

		PurchaseOrderSearch purchaseOrderSearch = new PurchaseOrderSearch();
		purchaseOrderSearch.setStore(code);
		purchaseOrderSearch.setTenantId(tenantId);

		Pagination<PurchaseOrder> purchaseOrders = purchaseOrderJdbcRepository.search(purchaseOrderSearch);

		if (!purchaseOrders.getPagedData().isEmpty()) {
			return true;
		}

		MaterialReceiptSearch issueStoreSearch = new MaterialReceiptSearch();
		issueStoreSearch.setIssueingStore(code);
		issueStoreSearch.setTenantId(tenantId);

		Pagination<MaterialReceipt> issueStoreMaterialReceipt = materialReceiptJdbcRepository.search(issueStoreSearch);

		if (!issueStoreMaterialReceipt.getPagedData().isEmpty()) {
			return true;
		}

		MaterialReceiptSearch receivingStoreSearch = new MaterialReceiptSearch();
		receivingStoreSearch.setIssueingStore(code);
		receivingStoreSearch.setTenantId(tenantId);

		Pagination<MaterialReceipt> receivingStoreMaterialReceipt = materialReceiptJdbcRepository
				.search(receivingStoreSearch);

		if (!receivingStoreMaterialReceipt.getPagedData().isEmpty()) {
			return true;
		}

		MaterialIssueSearchContract fromStoreIssue = new MaterialIssueSearchContract();
		fromStoreIssue.setFromStore(code);
		fromStoreIssue.setTenantId(tenantId);

		Pagination<MaterialIssue> fromStoreSearch = materialIssueJdbcRepository.search(fromStoreIssue, null);

		if (!fromStoreSearch.getPagedData().isEmpty()) {
			return true;
		}

		MaterialIssueSearchContract toStoreIssue = new MaterialIssueSearchContract();
		toStoreIssue.setToStore(code);
		toStoreIssue.setTenantId(tenantId);

		Pagination<MaterialIssue> toStoreSearch = materialIssueJdbcRepository.search(toStoreIssue, null);

		if (!toStoreSearch.getPagedData().isEmpty()) {
			return true;
		}

		return false;
	}

	private Map<String, Department> getDepartment(String tenantId) {
		JSONArray responseJSONArray = mdmsRepository.getByCriteria(tenantId, "store-asset", "Department", null, null,
				new RequestInfo());
		Map<String, Department> departmentMap = new HashMap<>();
		ObjectMapper mapper = new ObjectMapper();
		if (responseJSONArray != null && !responseJSONArray.isEmpty()) {
			for (int i = 0; i < responseJSONArray.size(); i++) {
				Department department = mapper.convertValue(responseJSONArray.get(i), Department.class);
				departmentMap.put(department.getCode(), department);
			}
		}
		return departmentMap;
	}

	private Map<String, Location> getLocation(String tenantId) {
		JSONArray responseJSONArray = mdmsRepository.getByCriteria(tenantId, "store-asset", "Location", null, null,
				new RequestInfo());

		Map<String, Location> locationMap = new HashMap<>();
		ObjectMapper mapper = new ObjectMapper();
		if (responseJSONArray != null && !responseJSONArray.isEmpty()) {
			for (int i = 0; i < responseJSONArray.size(); i++) {
				Location location = mapper.convertValue(responseJSONArray.get(i), Location.class);
				locationMap.put(location.getCode(), location);
			}
		}
		return locationMap;
	}

}
