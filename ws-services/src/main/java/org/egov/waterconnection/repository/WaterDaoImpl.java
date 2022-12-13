package org.egov.waterconnection.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.egov.common.contract.request.RequestInfo;
import org.egov.waterconnection.config.WSConfiguration;
import org.egov.waterconnection.constants.WCConstants;
import org.egov.waterconnection.model.BillGeneration;
import org.egov.waterconnection.model.BillGenerationRequest;
import org.egov.waterconnection.model.SearchCriteria;
import org.egov.waterconnection.model.SearchTotalCollectionCriteria;
import org.egov.waterconnection.model.WaterConnection;
import org.egov.waterconnection.model.WaterConnectionCount;
import org.egov.waterconnection.model.WaterConnectionRequest;
import org.egov.waterconnection.model.WaterTotalCollections;
import org.egov.waterconnection.model.buckets;
import org.egov.waterconnection.model.connectionsCreated;
import org.egov.waterconnection.model.metrics;
import org.egov.waterconnection.model.pendingConnections;
import org.egov.waterconnection.model.sewerageConnections;
import org.egov.waterconnection.model.todaysCollection;
import org.egov.waterconnection.model.waterConnections;
import org.egov.waterconnection.producer.WaterConnectionProducer;
import org.egov.waterconnection.repository.builder.WsQueryBuilder;
import org.egov.waterconnection.repository.rowmapper.WaterGetAPIRowMapper;
import org.egov.waterconnection.repository.rowmapper.WaterNIUARowMapper;
import org.egov.waterconnection.repository.rowmapper.WaterRowMapper;
import org.egov.waterconnection.repository.rowmapper.WaterRowMapperCount;
import org.javers.common.collections.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.google.gson.Gson;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class WaterDaoImpl implements WaterDao {

	@Autowired
	private WaterConnectionProducer waterConnectionProducer;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private WsQueryBuilder wsQueryBuilder;

	@Autowired
	private WaterRowMapper waterRowMapper;

	@Autowired
	private WaterNIUARowMapper waterNIUARowMapper ;
	

	@Autowired
	private WaterGetAPIRowMapper waterGetAPIRowMapper ;
	
	
	@Autowired
	private WaterRowMapperCount waterRowMapperCount;
	
	@Autowired
	private WSConfiguration wsConfiguration;
	
	

	@Value("${egov.waterservice.createwaterconnection}")
	private String createWaterConnection;

	@Value("${egov.waterservice.updatewaterconnection}")
	private String updateWaterConnection;
	
	@Value("${egov.waterservice.createwatersubactivity}")
	private String createWaterSubActivity;

	
	
	@Override
	public void saveWaterConnection(WaterConnectionRequest waterConnectionRequest) {
		waterConnectionProducer.push(createWaterConnection, waterConnectionRequest);
	}

	@Override
	public List<WaterConnection> getWaterConnectionList(SearchCriteria criteria,
			RequestInfo requestInfo) {
		List<Object> preparedStatement = new ArrayList<>();
		String query = wsQueryBuilder.getSearchQueryString(criteria, preparedStatement, requestInfo);
		
		//log.info("Query-->"+query);
		
		StringBuilder str = new StringBuilder("Water query: ").append(query);
		//log.info(str.toString());
		if (query == null)
			return Collections.emptyList();
//		if (log.isDebugEnabled()) {
	//		StringBuilder str = new StringBuilder("Water query: ").append(query);
//			log.info(str.toString());
//		}
		
	//	log.info(jdbcTemplate.query(query, preparedStatement.toArray(),waterRowMapper).toString());
		
		List<WaterConnection> waterConnectionList = jdbcTemplate.query(query, preparedStatement.toArray(),
				waterRowMapper);
		
		//System.out.println(preparedStatement.toArray());
		//System.out.println(preparedStatement);
		//System.out.println(waterRowMapper.toString());
		if (waterConnectionList == null) {
			return Collections.emptyList();
		}

		return waterConnectionList;
	}
	
	@Override
	public List<WaterConnectionCount> getWaterConnectionListCount(SearchCriteria criteria,
			RequestInfo requestInfo) {
		List<Object> preparedStatement = new ArrayList<>();
		String query = wsQueryBuilder.getSearchQueryStringCount(criteria, preparedStatement, requestInfo);
		
	
		
		StringBuilder str = new StringBuilder("Water query: ").append(query);
		
		if (query == null)
			return Collections.emptyList();

		
		List<WaterConnectionCount> waterConnectionList = jdbcTemplate.query(query, preparedStatement.toArray(),
				waterRowMapperCount);
		
		
		if (waterConnectionList == null) {
			return Collections.emptyList();
		}

		return waterConnectionList;
	}

	@Override
	public void updateWaterConnection(WaterConnectionRequest waterConnectionRequest, boolean isStateUpdatable) {
		if(log.isInfoEnabled()) {
			log.info("UpdateWaterConnection: isStateUpdatable ? {}, WaterConnection: {}",isStateUpdatable, waterConnectionRequest.getWaterConnection());
		}
		if (isStateUpdatable) {
			waterConnectionProducer.push(updateWaterConnection, waterConnectionRequest);
		} else {
			waterConnectionProducer.push(wsConfiguration.getWorkFlowUpdateTopic(), waterConnectionRequest);
		}
	}
	
	/**
	 * push object to create meter reading
	 * 
	 * @param waterConnectionRequest
	 */
	public void postForMeterReading(WaterConnectionRequest waterConnectionRequest) {
		log.info("Posting request to kafka topic - " + wsConfiguration.getCreateMeterReading());
		waterConnectionProducer.push(wsConfiguration.getCreateMeterReading(), waterConnectionRequest);
	}

	/**
	 * push object for edit notification
	 * 
	 * @param waterConnectionRequest
	 */
	public void pushForEditNotification(WaterConnectionRequest waterConnectionRequest) {
		if (!WCConstants.EDIT_NOTIFICATION_STATE
				.contains(waterConnectionRequest.getWaterConnection().getProcessInstance().getAction())) {
			//to uncommentte in commit
			waterConnectionProducer.push(wsConfiguration.getEditNotificationTopic(), waterConnectionRequest);
		}
	}
	
	/**
	 * Enrich file store Id's
	 * 
	 * @param waterConnectionRequest
	 */
	public void enrichFileStoreIds(WaterConnectionRequest waterConnectionRequest) {
		waterConnectionProducer.push(wsConfiguration.getFileStoreIdsTopic(), waterConnectionRequest);
	}
	
	/**
	 * Save file store Id's
	 * 
	 * @param waterConnectionRequest
	 */
	public void saveFileStoreIds(WaterConnectionRequest waterConnectionRequest) {
		waterConnectionProducer.push(wsConfiguration.getSaveFileStoreIdsTopic(), waterConnectionRequest);
	}

	@Override
	public void addConnectionMapping(WaterConnectionRequest waterConnectionRequest) {
		waterConnectionProducer.push(wsConfiguration.getAddConnectionMapping(), waterConnectionRequest);
		
	}

	@Override
	public void deleteConnectionMapping(WaterConnectionRequest waterConnectionRequest) {
		waterConnectionProducer.push(wsConfiguration.getDeleteConnectionMapping(), waterConnectionRequest);		
	}

	@Override
	public void updatebillingstatus(BillGeneration billingData) {
		BillGenerationRequest billReq = BillGenerationRequest.builder().billGeneration(billingData).build();
		waterConnectionProducer.push(wsConfiguration.getUpdateBillPayment(), billReq);
		
	}
	

	
	
	
	@Override
	public  metrics getWaterConnectionTotalCollectionListCountNIUA(SearchTotalCollectionCriteria SearchTotalCollectionCriteria,
			RequestInfo requestInfo) {
		List<Object> preparedStatement = new ArrayList<>();
		
	
		List<String> myList = new ArrayList<>();
		
		List<String> connectionsCreated = new ArrayList<>();
		connectionsCreated.add("channelType");
		connectionsCreated.add("connectionType");
		myList.addAll(connectionsCreated);
		
		
		List<String> todaysCollection = new ArrayList<String>();
		todaysCollection.add("usageType");
		todaysCollection.add("paymentChannelType");
		todaysCollection.add("taxHeads");
		todaysCollection.add("connectionType");
		myList.addAll(todaysCollection);
		
		List<String> sewerageConnections = new ArrayList<String>();
		sewerageConnections.add("channelType");
		sewerageConnections.add("usageType");
		myList.addAll(sewerageConnections);
		
		List<String> waterConnections = new ArrayList<String>();
		waterConnections.add("channelType");
		waterConnections.add("usageType");
		waterConnections.add("meterType");
		myList.addAll(waterConnections);
		
		List<String> pendingConnections = new ArrayList<String>();
		pendingConnections.add("duration");
		myList.addAll(pendingConnections);
		
		
		List<List<String>> seprate = new ArrayList<List<String>>();
		seprate.add(connectionsCreated);
		seprate.add(todaysCollection);
		seprate.add(sewerageConnections);
		seprate.add(waterConnections);
		seprate.add(pendingConnections);
		
		List<String> sepratee = new ArrayList<String>();
		sepratee.add("connectionsCreated");
		sepratee.add("todaysCollection");
		sepratee.add("sewerageConnections");
		sepratee.add("waterConnections");
		sepratee.add("pendingConnections");
		
		metrics buildd = new metrics();
		
		List<connectionsCreated> build3 = new ArrayList<>();
		List<todaysCollection> build4 = new ArrayList<>();
		List<sewerageConnections> build5 = new ArrayList<>();
		List<waterConnections> build6 = new ArrayList<>();
		List<pendingConnections> build7 = new ArrayList<>();
		
		
		for (int i = 0; i < seprate.size(); i++) {
			String string2 = sepratee.get(i); 
			
			 			
			List<String> list2 = seprate.get(i);
			
			
			for (String string : list2) {
				
				if (string2.equalsIgnoreCase("connectionsCreated")) {
					
				connectionsCreated connection = new connectionsCreated();
				String groupByName = "connectionsCreated";
					
					List<buckets> query2 = data(string, groupByName,  SearchTotalCollectionCriteria, preparedStatement, requestInfo);
					
				connection.setGroupBy(string);
				connection.setBuckets(query2);
				build3.add(connection);
				
			}
				
				else if (string2.equalsIgnoreCase("todaysCollection")) {
					
					todaysCollection connection = new todaysCollection();
					String groupByName = "todaysCollection";

					List<buckets> query2 = data(string, groupByName , SearchTotalCollectionCriteria, preparedStatement, requestInfo);
					
				connection.setGroupBy(string);
				connection.setBuckets(query2);
				build4.add(connection);
				
			}
				
				else if (string2.equalsIgnoreCase("sewerageConnections")) {
					
					sewerageConnections connection = new sewerageConnections();
					String groupByName = "sewerageConnections";
						
						List<buckets> query2 = data(string, groupByName , SearchTotalCollectionCriteria, preparedStatement, requestInfo);
						
					connection.setGroupBy(string);
					connection.setBuckets(query2);
					build5.add(connection);
					
				}
				
				else if (string2.equalsIgnoreCase("waterConnections")) {
					
					waterConnections connection = new waterConnections();
					String groupByName = "waterConnections";
						
						List<buckets> query2 = data(string, groupByName,  SearchTotalCollectionCriteria, preparedStatement, requestInfo);
						
					connection.setGroupBy(string);
					connection.setBuckets(query2);
					build6.add(connection);
					
				}
				
				else if (string2.equalsIgnoreCase("pendingConnections")) {
					
					pendingConnections connection = new pendingConnections();
					String groupByName = "pendingConnections";
						
						List<buckets> query2 = data(string, groupByName , SearchTotalCollectionCriteria, preparedStatement, requestInfo);
						
					connection.setGroupBy(string);
					connection.setBuckets(query2);
					build7.add(connection);
					
				}

			}
		}

		int transactions1 = 0;
		String transactions = "transactions";
		String todaysTotalApplications = "todaysTotalApplications";
		String todaysClosedApplications = "todaysClosedApplications";
		metrics build = metrics.builder().connectionsCreated(build3).todaysCollection(build4).sewerageConnections(build5)
				.waterConnections(build6).pendingConnections(build7).transactions(trsa(transactions ,SearchTotalCollectionCriteria, preparedStatement, requestInfo))
				.slaCompliance(transactions1).todaysTotalApplications(trsa(todaysTotalApplications ,SearchTotalCollectionCriteria, preparedStatement, requestInfo))
				.todaysClosedApplications(trsa(todaysClosedApplications ,SearchTotalCollectionCriteria, preparedStatement, requestInfo))
				.todaysCompletedApplicationsWithinSLA(transactions1)
				.build();
		
		Gson gson = new Gson();
        String json = gson.toJson(build);
		


		return build;
	}

	private int  trsa(String str , SearchTotalCollectionCriteria searchTotalCollectionCriteria,
			List<Object> preparedStatement, RequestInfo requestInfo) {
		
		
		
		List<buckets> query2 = data(str, str , searchTotalCollectionCriteria, preparedStatement, requestInfo);
		  int value = query2.get(0).getValue();
		  
		
		return value;
	}
	
	private List<buckets> data(String string, String groupByName, SearchTotalCollectionCriteria searchTotalCollectionCriteria,
			List<Object> preparedStatement, RequestInfo requestInfo) {
		
		String query = wsQueryBuilder.getSearchQueryStringTotalCollectionCountNIUA(string , groupByName , searchTotalCollectionCriteria , preparedStatement, requestInfo);
//		
			List<buckets> query2 = jdbcTemplate.query(query, preparedStatement.toArray(),waterNIUARowMapper);
		
		
		
		return query2;
	}
	
	
	@Override
	public List<WaterConnection> getAPI(SearchCriteria criteria,
			RequestInfo requestInfo) {
		List<Object> preparedStatement = new ArrayList<>();
		String query = wsQueryBuilder.getAPI(criteria, preparedStatement, requestInfo);
		
	//	log.info("Query-->"+query);
	//	log.info("preparedStatement-->"+preparedStatement);
		
		StringBuilder str = new StringBuilder("Water query: ").append(query);
		//log.info(str.toString());
		if (query == null)
			return Collections.emptyList();
//		if (log.isDebugEnabled()) {
	//		StringBuilder str = new StringBuilder("Water query: ").append(query);
//			log.info(str.toString());
//		}
		
	//	log.info(jdbcTemplate.query(query, preparedStatement.toArray(),waterRowMapper).toString());
		
		List<WaterConnection> waterConnectionList = jdbcTemplate.query(query, preparedStatement.toArray(),
				waterGetAPIRowMapper);
		
		//System.out.println(preparedStatement.toArray());
		//System.out.println(preparedStatement);
		//System.out.println(waterRowMapper.toString());
		if (waterConnectionList == null) {
			return Collections.emptyList();
		}

		return waterConnectionList;
	}
	

}
