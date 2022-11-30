package org.egov.integration.service;

import org.egov.common.contract.request.RequestInfo;
import org.egov.integration.model.CommonMetrics;

public interface CommonService {
	
	public CommonMetrics searchTotalCollectionCountNIUA(RequestInfo requestInfo);

}
