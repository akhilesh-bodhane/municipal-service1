package org.egov.integration.repository;

import org.egov.common.contract.request.RequestInfo;
import org.egov.integration.model.CommonMetrics;

public interface CommonDao {
	
	public CommonMetrics getCommonTotalCollectionListCountNIUA(RequestInfo requestInfo);

}
