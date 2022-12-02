package org.egov.integration.repository;

import org.egov.common.contract.request.RequestInfo;
import org.egov.integration.model.CommonMetrics;
import org.egov.integration.model.CommonServiceReqSearchCriteria;

public interface CommonDao {
	
	public CommonMetrics getCommonTotalCollectionListCountNIUA(RequestInfo requestInfo,CommonServiceReqSearchCriteria serviceReqSearchCriteria);

}
