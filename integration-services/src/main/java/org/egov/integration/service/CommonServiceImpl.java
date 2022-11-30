package org.egov.integration.service;

import org.egov.common.contract.request.RequestInfo;
import org.egov.integration.model.CommonMetrics;
import org.egov.integration.repository.CommonDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class CommonServiceImpl implements CommonService {
	
	@Autowired
	private CommonDao commonDao;
	
	public CommonMetrics searchTotalCollectionCountNIUA(RequestInfo requestInfo) {
		CommonMetrics ConnectionList;
		ConnectionList = getCommonTotalCollectionListCountNIUA(requestInfo);
		return ConnectionList;
	}
	
	public CommonMetrics getCommonTotalCollectionListCountNIUA(RequestInfo requestInfo) {
		return commonDao.getCommonTotalCollectionListCountNIUA(requestInfo);
	}

}
