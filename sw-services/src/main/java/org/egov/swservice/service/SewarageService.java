package org.egov.swservice.service;

import java.util.List;

import org.egov.common.contract.request.RequestInfo;
import org.egov.swservice.model.PublicDashBoardSearchCritieria;
import org.egov.swservice.model.ResponseData;
import org.egov.swservice.model.SearchCriteria;
import org.egov.swservice.model.SearchTotalCollectionCriteria;
import org.egov.swservice.model.SewerageConnection;
import org.egov.swservice.model.SewerageConnectionCount;
import org.egov.swservice.model.SewerageConnectionRequest;
import org.egov.swservice.model.SewerageTotalCollections;

public interface SewarageService {

	public List<SewerageConnection> createSewarageConnection(SewerageConnectionRequest sewarageConnectionRequest);

	public List<SewerageConnection> search(SearchCriteria criteria, RequestInfo requestInfo);
	
	public List<SewerageConnectionCount> searchCount(SearchCriteria criteria, RequestInfo requestInfo);

	public List<SewerageConnection> updateSewarageConnection(SewerageConnectionRequest sewarageConnectionRequest);
	
	public List<SewerageTotalCollections> searchTotalCollectionCount(SearchTotalCollectionCriteria SearchTotalCollectionCriteria, RequestInfo requestInfo);
	
	public ResponseData searchPublicDashBoardCount(PublicDashBoardSearchCritieria SearchTotalCollectionCriteria);

}
