package org.egov.swservice.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.egov.common.contract.request.RequestInfo;
import org.egov.swservice.config.SWConfiguration;
import org.egov.swservice.model.SearchCriteria;
import org.egov.swservice.model.SearchTotalCollectionCriteria;
import org.egov.swservice.model.SewerageConnection;
import org.egov.swservice.model.SewerageConnectionCount;
import org.egov.swservice.model.SewerageConnectionRequest;
import org.egov.swservice.model.SewerageTotalCollections;
import org.egov.swservice.producer.SewarageConnectionProducer;
import org.egov.swservice.repository.builder.SWQueryBuilder;
import org.egov.swservice.repository.rowmapper.SewerageCountRowMapper;
import org.egov.swservice.repository.rowmapper.SewerageRowMapper;
import org.egov.swservice.repository.rowmapper.SewerageTotalCollectionsRowMapper;
import org.egov.swservice.util.SWConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class SewarageDaoImpl implements SewarageDao {

	@Autowired
	private SewarageConnectionProducer sewarageConnectionProducer;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private SWQueryBuilder swQueryBuilder;

	@Autowired
	private SewerageRowMapper sewarageRowMapper;

	
	@Autowired
	private SewerageCountRowMapper sewarageCountRowMapper;
	
	
	@Autowired
	private SewerageTotalCollectionsRowMapper sewerageTotalCollectionRowMapper;
	
	
	@Autowired
	private SWConfiguration swConfiguration;

	@Value("${egov.sewarageservice.createconnection}")
	private String createSewarageConnection;

	@Value("${egov.sewarageservice.updateconnection}")
	private String updateSewarageConnection;

	@Override
	public void saveSewerageConnection(SewerageConnectionRequest sewerageConnectionRequest) {
		sewarageConnectionProducer.push(createSewarageConnection, sewerageConnectionRequest);
	}

	@Override
	public List<SewerageConnection> getSewerageConnectionList(SearchCriteria criteria, RequestInfo requestInfo) {
		List<Object> preparedStatement = new ArrayList<>();
		String query = swQueryBuilder.getSearchQueryString(criteria, preparedStatement, requestInfo);
		if (query == null)
			return Collections.emptyList();
		// if (log.isDebugEnabled()) {
			StringBuilder str = new StringBuilder("Sewerage query : ").append(query);
			log.info(str.toString());
		// }
		List<SewerageConnection> sewarageConnectionList = jdbcTemplate.query(query, preparedStatement.toArray(),
				sewarageRowMapper);
		
		if (sewarageConnectionList == null) {
			return Collections.emptyList();
		}else {
			log.info("Sewerage search result size:{}",sewarageConnectionList.size());
		}
		return sewarageConnectionList;
	}
	
	@Override
	public List<SewerageConnectionCount> getSewerageConnectionListCount(SearchCriteria criteria, RequestInfo requestInfo) {
		List<Object> preparedStatement = new ArrayList<>();
		String query = swQueryBuilder.getSearchQueryStringCount(criteria, preparedStatement, requestInfo);
		if (query == null)
			return Collections.emptyList();
		// if (log.isDebugEnabled()) {
			StringBuilder str = new StringBuilder("Sewerage query : ").append(query);
			log.info(str.toString());
		// }
		List<SewerageConnectionCount> sewarageConnectionCount = jdbcTemplate.query(query, preparedStatement.toArray(),
				sewarageCountRowMapper);
		
		if (sewarageConnectionCount == null) {
			return Collections.emptyList();
		}else {
			log.info("Sewerage search result size:{}",sewarageConnectionCount.size());
		}
		return sewarageConnectionCount;
	}

	public void updateSewerageConnection(SewerageConnectionRequest sewerageConnectionRequest,
			boolean isStateUpdatable) {
		if (isStateUpdatable) {
			sewarageConnectionProducer.push(updateSewarageConnection, sewerageConnectionRequest);
		} else {
			sewarageConnectionProducer.push(swConfiguration.getWorkFlowUpdateTopic(), sewerageConnectionRequest);
		}
	}

	/**
	 * push object for edit notification
	 * 
	 * @param sewerageConnectionRequest
	 */
	public void pushForEditNotification(SewerageConnectionRequest sewerageConnectionRequest) {
		if (!SWConstants.EDIT_NOTIFICATION_STATE
				.contains(sewerageConnectionRequest.getSewerageConnection().getProcessInstance().getAction())) {
			sewarageConnectionProducer.push(swConfiguration.getEditNotificationTopic(), sewerageConnectionRequest);
		}
	}

	/**
	 * Enrich file store Id's
	 * 
	 * @param sewerageConnectionRequest
	 */
	public void enrichFileStoreIds(SewerageConnectionRequest sewerageConnectionRequest) {
		sewarageConnectionProducer.push(swConfiguration.getFileStoreIdsTopic(), sewerageConnectionRequest);
	}

	/**
	 * Save file store Id's
	 * 
	 * @param sewerageConnectionRequest
	 */
	public void saveFileStoreIds(SewerageConnectionRequest sewerageConnectionRequest) {
		sewarageConnectionProducer.push(swConfiguration.getSaveFileStoreIdsTopic(), sewerageConnectionRequest);
	}
	
	
	@Override
	public List<SewerageTotalCollections> getSewerageConnectionTotalCollectionListCount(SearchTotalCollectionCriteria SearchTotalCollectionCriteria,
			RequestInfo requestInfo) {
		List<Object> preparedStatement = new ArrayList<>();
		String query = swQueryBuilder.getSearchQueryStringTotalCollectionCount(SearchTotalCollectionCriteria, preparedStatement, requestInfo);
		
		
		StringBuilder str = new StringBuilder("Sewerage query: ").append(query);
		
		if (query == null)
			return Collections.emptyList();

		
		List<SewerageTotalCollections> sewerageConnectionList = jdbcTemplate.query(query, preparedStatement.toArray(),
				sewerageTotalCollectionRowMapper);
		
		
		if (sewerageConnectionList == null) {
			return Collections.emptyList();
		}

		return sewerageConnectionList;
	}

}
