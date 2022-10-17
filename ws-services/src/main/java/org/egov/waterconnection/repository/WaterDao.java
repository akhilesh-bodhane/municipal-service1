package org.egov.waterconnection.repository;

import java.util.List;

import org.egov.common.contract.request.RequestInfo;
import org.egov.waterconnection.model.BillGeneration;
import org.egov.waterconnection.model.SearchCriteria;
import org.egov.waterconnection.model.SearchTotalCollectionCriteria;
import org.egov.waterconnection.model.WaterConnection;
import org.egov.waterconnection.model.WaterConnectionCount;
import org.egov.waterconnection.model.WaterConnectionRequest;
import org.egov.waterconnection.model.WaterTotalCollections;
import org.egov.waterconnection.model.collection.PaymentRequest;

public interface WaterDao {
	public void saveWaterConnection(WaterConnectionRequest waterConnectionRequest);

	public List<WaterConnection> getWaterConnectionList(SearchCriteria criteria,RequestInfo requestInfo);
	
	public List<WaterConnectionCount> getWaterConnectionListCount(SearchCriteria criteria,RequestInfo requestInfo);
	public void updateWaterConnection(WaterConnectionRequest waterConnectionRequest, boolean isStateUpdatable);

	public void addConnectionMapping(WaterConnectionRequest waterConnectionRequest);

	public void deleteConnectionMapping(WaterConnectionRequest waterConnectionRequest);

	public void updatebillingstatus(BillGeneration bill);
	
	public List<WaterTotalCollections> getWaterConnectionTotalCollectionListCount(SearchTotalCollectionCriteria SearchTotalCollectionCriteria,RequestInfo requestInfo);
}
