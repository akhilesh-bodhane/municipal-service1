package org.egov.waterconnection.service;

import java.util.List;

import org.egov.common.contract.request.RequestInfo;
import org.egov.waterconnection.model.SearchCriteria;
import org.egov.waterconnection.model.SearchTotalCollectionCriteria;
import org.egov.waterconnection.model.WaterConnection;
import org.egov.waterconnection.model.WaterConnectionCount;
import org.egov.waterconnection.model.WaterConnectionRequest;
import org.egov.waterconnection.model.WaterNotificationRequest;
import org.egov.waterconnection.model.WaterTotalCollections;
import org.egov.waterconnection.model.metrics;

public interface WaterService {

	public List<WaterConnection> createWaterConnection(WaterConnectionRequest waterConnectionRequest);

	public List<WaterConnection> search(SearchCriteria criteria, RequestInfo requestInfo);
	
	public List<WaterConnectionCount> searchCount(SearchCriteria criteria, RequestInfo requestInfo);
	
	public List<WaterConnection> updateWaterConnection(WaterConnectionRequest waterConnectionRequest);

	public List<WaterConnection> deleteConnectionMapping(WaterConnectionRequest waterConnectionRequest);

	public List<WaterConnection> deactivateConnection(WaterConnectionRequest waterConnectionRequest);

	public List<WaterConnection> addConnectionMapping(WaterConnectionRequest waterConnectionRequest);
	
	public void sendSms(WaterNotificationRequest waterNotificationRequest);
	
	public metrics searchTotalCollectionCountNIUA(
			SearchTotalCollectionCriteria searchTotalCollectionCriteria, RequestInfo requestInfo);

}
