package org.egov.pgr.validator;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.egov.common.contract.request.RequestInfo;
import org.egov.pgr.contract.AutoroutingMapReqSearchCriteria;
import org.egov.pgr.contract.AutoroutingMapRequest;
import org.egov.pgr.contract.ServiceReqSearchCriteria;
import org.egov.pgr.utils.ErrorConstants;
import org.egov.tracer.model.CustomException;
import org.springframework.beans.factory.annotation.Autowired;

import lombok.extern.slf4j.Slf4j;

@org.springframework.stereotype.Service
@Slf4j
public class MasterRequestValidator {
	
	@Autowired
	private PGRRequestValidator pgrRequestValidator;
	
	/**
	 * validates the create Request based on the following cirtera:
	 * 
	 * 1. Checks if the tenantid not null.
	 * 2. Checks if autorouting is not null.
	 * 
	 * @param serviceRequest
	 */
	public void validateAutoRoutingRequest(AutoroutingMapRequest autoroutingMapRequest, boolean isCreate) {
		log.info("Validating autorouting request");
		Map<String, String> errorMap = new HashMap<>();
		validateDataSanity(autoroutingMapRequest, errorMap, isCreate);
		
		if (!errorMap.isEmpty())
			throw new CustomException(errorMap);
	}

	/**
	 * @param AutoroutingMapRequest
	 * @param errorMap
	 */
	public void validateDataSanity(AutoroutingMapRequest autoroutingMapRequest, Map<String, String> errorMap, boolean isCreate) {
		
		if(StringUtils.isEmpty(autoroutingMapRequest.getAutoroutingMap().getTenantId())) {
			errorMap.put(ErrorConstants.INVALID_REQUESTS_ON_TENANT_CODE, ErrorConstants.INVALID_REQUESTS_ON_TENANT_MSG);
		}
		if(null == autoroutingMapRequest.getAutoroutingMap().getAutorouting()) {
			errorMap.put(ErrorConstants.INVALID_AUTOROUTING_CODE, ErrorConstants.INVALID_AUTOROUTING_MSG);
		}
		/*if(!isCreate && StringUtils.isEmpty(autoroutingMapRequest.getAutoroutingMap().getId())) {
			errorMap.put(ErrorConstants.INVALID_ID_CODE, ErrorConstants.INVALID_ID_MSG);
		}*/
		if (!errorMap.isEmpty())
			throw new CustomException(errorMap);
	}
	
	/**
	 * validates the legality of the search criteria given
	 * 
	 * @param criteria
	 * @param requestInfo
	 */
	public void validateSearch(AutoroutingMapReqSearchCriteria criteria, RequestInfo requestInfo) {
		Map<String, String> errorMap = new HashMap<>();
		if(StringUtils.isEmpty(criteria.getTenantId())) {
			errorMap.put(ErrorConstants.INVALID_REQUESTS_ON_TENANT_CODE, ErrorConstants.INVALID_REQUESTS_ON_TENANT_MSG);
		}

		if (!errorMap.isEmpty())
			throw new CustomException(errorMap);
	}
}
