package org.egov.waterconnection.repository;

import java.util.List;

import org.egov.common.contract.request.RequestInfo;
import org.egov.waterconnection.model.BillGeneration;
import org.egov.waterconnection.model.PublicDashBoardSearchCritieria;
import org.egov.waterconnection.model.ResponseData;
import org.egov.waterconnection.model.SearchCriteria;
import org.egov.waterconnection.model.SearchTotalCollectionCriteria;
import org.egov.waterconnection.model.WaterConnection;
import org.egov.waterconnection.model.WaterConnectionCount;
import org.egov.waterconnection.model.WaterConnectionRequest;
import org.egov.waterconnection.model.WaterTotalCollections;
import org.egov.waterconnection.model.metrics;
import org.egov.waterconnection.model.collection.PaymentRequest;

public interface WaterDao {
	public void saveWaterConnection(WaterConnectionRequest waterConnectionRequest);

	public List<WaterConnection> getWaterConnectionList(SearchCriteria criteria,RequestInfo requestInfo);
	
	public List<WaterConnection> getAPI(SearchCriteria criteria,RequestInfo requestInfo);
	
	public List<WaterConnectionCount> getWaterConnectionListCount(SearchCriteria criteria,RequestInfo requestInfo);
	public void updateWaterConnection(WaterConnectionRequest waterConnectionRequest, boolean isStateUpdatable);

	public void addConnectionMapping(WaterConnectionRequest waterConnectionRequest);

	public void deleteConnectionMapping(WaterConnectionRequest waterConnectionRequest);

	public void updatebillingstatus(BillGeneration bill);
	
	public metrics getWaterConnectionTotalCollectionListCountNIUA(SearchTotalCollectionCriteria SearchTotalCollectionCriteria,RequestInfo requestInfo);
	
	public ResponseData searchPublicDashBoardCount(PublicDashBoardSearchCritieria SearchTotalCollectionCriteria);

	public List<WaterConnection> getWaterConnectionListCitizen(SearchCriteria criteria,RequestInfo requestInfo);

}
