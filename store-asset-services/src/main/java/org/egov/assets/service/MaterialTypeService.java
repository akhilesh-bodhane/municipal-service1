package org.egov.assets.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.egov.assets.common.DomainService;
import org.egov.assets.common.MdmsRepository;
import org.egov.assets.common.exception.CustomBindException;
import org.egov.assets.model.MaterialType;
import org.egov.assets.model.MaterialTypeRequest;
import org.egov.assets.model.MaterialTypeResponse;
import org.egov.assets.model.MaterialTypeSearch;
import org.egov.assets.model.MaterialTypeStoreMapping;
import org.egov.assets.model.MaterialTypeStoreMappingSearch;
import org.egov.assets.model.MaterialTypeStoreRequest;
import org.egov.assets.model.StoreGetRequest;
import org.egov.assets.model.StoreMapping;
import org.egov.assets.model.StoreResponse;
import org.egov.common.contract.request.RequestInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class MaterialTypeService extends DomainService {

	@Autowired
	private MaterialTypeStoreMappingService materialTypeStoreMappingService;

	@Autowired
	private MdmsRepository mdmsRepository;

	@Autowired
	private StoreService storeService;

	public MaterialTypeResponse save(MaterialTypeRequest materialTypeRequest, String tenantId) {

		try {
			materialTypeStoreMappingService.create(buildMaterialTypeStoreRequest(materialTypeRequest), tenantId);
			MaterialTypeResponse response = new MaterialTypeResponse();
			response.materialTypes((materialTypeRequest.getMaterialTypes()))
					.responseInfo(getResponseInfo(materialTypeRequest.getRequestInfo()));

			return response;
		} catch (CustomBindException e) {
			throw e;
		}
	}

	public MaterialTypeResponse update(MaterialTypeRequest materialTypeRequest, String tenantId) {

		try {

			materialTypeStoreMappingService.update(buildMaterialTypeStoreRequest(materialTypeRequest), tenantId);

			MaterialTypeResponse response = new MaterialTypeResponse();
			response.materialTypes((materialTypeRequest.getMaterialTypes()))
					.responseInfo(getResponseInfo(materialTypeRequest.getRequestInfo()));

			return response;
		} catch (CustomBindException e) {
			throw e;
		}
	}

	public MaterialTypeResponse search(MaterialTypeSearch materialTypeSearch, RequestInfo requestInfo) {

		MaterialTypeResponse response = new MaterialTypeResponse();

		List<MaterialType> materialTypes = new ArrayList<>();

		List<MaterialType> materialTypeMap = getMaterialTypeFromMdms(materialTypeSearch.getTenantId(),
				materialTypeSearch.getCode(), requestInfo);

		for (MaterialType materialType : materialTypeMap) {

			List<StoreMapping> storeMappings = new ArrayList<>();
			MaterialTypeStoreMappingSearch materialTypeStoreMappingSearch = MaterialTypeStoreMappingSearch.builder()
					.tenantId(materialTypeSearch.getTenantId()).build();
			List<MaterialTypeStoreMapping> materialTypeStoreMappings = materialTypeStoreMappingService
					.search(materialTypeStoreMappingSearch).getMaterialTypeStores();

			if (materialTypeStoreMappings.size() > 0) {
				if (!materialTypeStoreMappings.isEmpty()) {
					for (MaterialTypeStoreMapping materialStoreMapping : materialTypeStoreMappings) {

						StoreGetRequest storeGetRequest = StoreGetRequest.builder()
								.tenantId(materialTypeSearch.getTenantId())
								.code(Arrays.asList(materialStoreMapping.getStore().getCode())).build();
						StoreResponse storeResponse = storeService.search(storeGetRequest);

						StoreMapping storeMapping = StoreMapping.builder().id(materialStoreMapping.getId())
								.chartofAccount(materialStoreMapping.getChartofAccount())
								.active(materialStoreMapping.getActive())
								.store((storeResponse != null && !storeResponse.getStores().isEmpty())
										? storeResponse.getStores().get(0)
										: materialStoreMapping.getStore())
								.auditDetails(materialStoreMapping.getAuditDetails()).build();
						storeMappings.add(storeMapping);

					}
					materialType.setStoreMapping(storeMappings);
					materialTypes.add(materialType);
				} else {
					materialType.setStoreMapping(Collections.EMPTY_LIST);
					materialTypes.add(materialType);
				}
			}

			response.materialTypes(materialTypes).responseInfo(null);
		}

		return response;
	}

	private List<MaterialTypeStoreMapping> buildMaterialStoreMapping(List<MaterialType> materialTypes) {
		List<MaterialTypeStoreMapping> materialTypeStoreMappings = new ArrayList<>();

		for (MaterialType materialType : materialTypes) {
			for (StoreMapping storeMapping : materialType.getStoreMapping()) {
				MaterialTypeStoreMapping materialTypeStoreMapping = new MaterialTypeStoreMapping();

				materialTypeStoreMapping.id(storeMapping.getId()).store(storeMapping.getStore())
						.materialType(buildMaterialType(materialType.getCode())).active(storeMapping.getActive())
						.chartofAccount(storeMapping.getChartofAccount()).auditDetails(storeMapping.getAuditDetails())
						.delete(storeMapping.getDelete()).materialType(materialType);

				materialTypeStoreMappings.add(materialTypeStoreMapping);
			}
		}
		return materialTypeStoreMappings;
	}

	private MaterialType buildMaterialType(String materialTypeCode) {
		MaterialType materialType = new MaterialType();
		return materialType.code(materialTypeCode);
	}
	// private MaterialType buildMaterialType(String materialTypeCode) {
	// MaterialType materialType = new MaterialType();
	// return materialType.code(materialTypeCode);
	// }

	private MaterialTypeStoreRequest buildMaterialTypeStoreRequest(MaterialTypeRequest materialTypeRequest) {
		MaterialTypeStoreRequest materialTypeStoreRequest = new MaterialTypeStoreRequest();
		return materialTypeStoreRequest.requestInfo(materialTypeRequest.getRequestInfo())
				.materialTypeStores(buildMaterialStoreMapping(materialTypeRequest.getMaterialTypes()));
	}

	private List<MaterialType> getMaterialTypeFromMdms(String tenantId, String code, RequestInfo requestInfo) {

		List<Object> objectList = new ArrayList<>();

		if (!StringUtils.isEmpty(code)) {
			objectList = mdmsRepository.fetchObjectList(tenantId, "store-asset", "MaterialType", "code", code,
					MaterialType.class, requestInfo);
		} else {
			objectList = mdmsRepository.fetchObjectList(tenantId, "store-asset", "MaterialType", null, null,
					MaterialType.class, requestInfo);
		}

		List<MaterialType> hashMap = new ArrayList<>();
		ObjectMapper mapper = new ObjectMapper();
		if (objectList != null && objectList.size() > 0) {
			for (Object object : objectList) {
				MaterialType materialType = mapper.convertValue(object, MaterialType.class);
				hashMap.add(materialType);
			}
		}
		return hashMap;
	}

	/*
	 * private HashMap<String, MaterialType> getMaterialTypeFromMdms(String
	 * tenantId, String code) {
	 * 
	 * List<Object> objectList = new ArrayList<>();
	 * 
	 * if(!StringUtils.isEmpty(code)){ objectList =
	 * mdmsRepository.fetchObjectList(tenantId, "inventory", "MaterialType", "code",
	 * code, MaterialType.class); }else{ objectList =
	 * mdmsRepository.fetchObjectList(tenantId, "inventory", "MaterialType", null,
	 * null, MaterialType.class); }
	 * 
	 * HashMap<String, MaterialType> hashMap = new HashMap<>(); ObjectMapper mapper
	 * = new ObjectMapper(); if (objectList != null && objectList.size() > 0) { for
	 * (Object object : objectList) { MaterialType materialType =
	 * mapper.convertValue(object, MaterialType.class);
	 * hashMap.put(materialType.getCode(), materialType); } } return hashMap; }
	 */
}