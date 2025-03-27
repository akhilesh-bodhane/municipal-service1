package org.egov.swservice.repository;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.egov.common.contract.request.RequestInfo;
import org.egov.swservice.config.SWConfiguration;
import org.egov.swservice.model.PublicDashBoardSearchCritieria;
import org.egov.swservice.model.ResponseData;
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
import org.egov.swservice.validator.MDMSValidator;
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
	
	@Autowired
	private MDMSValidator MDMSValidator;

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
	
	private int publicDashBoardAppicationReceived(PublicDashBoardSearchCritieria SearchTotalCollectionCriteria,
			List<Object> preparedStatement) {

		String query = swQueryBuilder.getSearchQueryStringPublicDashBoard(SearchTotalCollectionCriteria,
				preparedStatement);

		Integer applicationreceivedcount = jdbcTemplate.queryForObject(query, preparedStatement.toArray(),
				Integer.class);

		return applicationreceivedcount;
	}
	
	private int publicDashBoardApproved(PublicDashBoardSearchCritieria SearchTotalCollectionCriteria,
			List<Object> preparedStatement) {

		String query = swQueryBuilder.getSearchQueryStringPublicDashBoardApproved(SearchTotalCollectionCriteria,
				preparedStatement);

		Integer applicationapprovedcount = jdbcTemplate.queryForObject(query, preparedStatement.toArray(),
				Integer.class);

		if (applicationapprovedcount == null) {
			applicationapprovedcount = 0;
		}

		return applicationapprovedcount;
	}
	
	private BigDecimal publicDashBoardTotalCollection(PublicDashBoardSearchCritieria SearchTotalCollectionCriteria,
			List<Object> preparedStatement) {
		
		String query = swQueryBuilder.getSearchQueryStringPublicDashBoardTotalCollection(SearchTotalCollectionCriteria,
				preparedStatement);
		System.out.println("query::" + query);
		BigDecimal applicationtotalcollection = jdbcTemplate.queryForObject(query, preparedStatement.toArray(),
				BigDecimal.class);
		System.out.println("publicDashBoardTimeTaken::" + applicationtotalcollection);
		if (applicationtotalcollection == null) {
			applicationtotalcollection = BigDecimal.ZERO;
		}

		return applicationtotalcollection;
		
	}
	
	private Double publicDashBoardTimeTaken(PublicDashBoardSearchCritieria SearchTotalCollectionCriteria,
			List<Object> preparedStatement) {

		String query = swQueryBuilder.getSearchQueryStringPublicDashBoardTimeTaken(SearchTotalCollectionCriteria,
				preparedStatement);
		System.out.println("query::" + query);
		Double applicationapprovedtimetaken = jdbcTemplate.queryForObject(query, preparedStatement.toArray(),
				Double.class);
		System.out.println("publicDashBoardTimeTaken::" + applicationapprovedtimetaken);
		if (applicationapprovedtimetaken == null) {
			applicationapprovedtimetaken = 0.0;
		}

		return applicationapprovedtimetaken;
	}
	
	private int publicDashBoardMinimumTimeTaken(PublicDashBoardSearchCritieria SearchTotalCollectionCriteria,
			List<Object> preparedStatement) {

		String query = swQueryBuilder.getSearchQueryStringPublicDashBoardMinimumTimeTaken(SearchTotalCollectionCriteria,
				preparedStatement);
		System.out.println("query::" + query);
		Integer applicationapprovedminimumtimetaken = jdbcTemplate.queryForObject(query, preparedStatement.toArray(),
				Integer.class);
		System.out.println("publicDashBoardMinimumTimeTaken::" + applicationapprovedminimumtimetaken);
		if (applicationapprovedminimumtimetaken == null) {
			applicationapprovedminimumtimetaken = 0;
		}

		return applicationapprovedminimumtimetaken;
	}
	
	private int publicDashBoardMaximumTimeTaken(PublicDashBoardSearchCritieria SearchTotalCollectionCriteria,
			List<Object> preparedStatement) {

		String query = swQueryBuilder.getSearchQueryStringPublicDashBoardMaxmimumTimeTaken(SearchTotalCollectionCriteria,
				preparedStatement);
		System.out.println("query::" + query);
		Integer applicationapprovedmaximumtimetaken = jdbcTemplate.queryForObject(query, preparedStatement.toArray(),
				Integer.class);
		System.out.println("publicDashBoardMaximumTimeTaken::" + applicationapprovedmaximumtimetaken);
		if (applicationapprovedmaximumtimetaken == null) {
			applicationapprovedmaximumtimetaken = 0;
		}

		return applicationapprovedmaximumtimetaken;
	}
	
	private List<Integer> publicDashBoardgetApprovedDays(PublicDashBoardSearchCritieria SearchTotalCollectionCriteria,
			List<Object> preparedStatement) {

		String query = swQueryBuilder.getSearchQueryStringPublicDashBoardApprovedDays(SearchTotalCollectionCriteria,
				preparedStatement);
		System.out.println("query::" + query);
		
		// Execute query and retrieve results	    
	    List<Integer> applicationApprovedDays = jdbcTemplate.query(query, preparedStatement.toArray(), 
	            (rs, rowNum) -> rs.getInt(1));

	    System.out.println("publicDashBoardApprovedDays::" + applicationApprovedDays);

	    // Return an empty list if no results are found
	    return applicationApprovedDays != null ? applicationApprovedDays : new ArrayList<>();
	}
	
	@Override
	public ResponseData searchPublicDashBoardCount(PublicDashBoardSearchCritieria SearchTotalCollectionCriteria) {
		List<Object> preparedStatement = new ArrayList<>();

		int ApplicationReceived = publicDashBoardAppicationReceived(SearchTotalCollectionCriteria, preparedStatement);

		int ApplicationApproved = publicDashBoardApproved(SearchTotalCollectionCriteria, preparedStatement);
		
		BigDecimal TotalCollection = publicDashBoardTotalCollection(SearchTotalCollectionCriteria, preparedStatement);
		
		//String filestoreId = getpublicDashboardFilestoreId(SearchTotalCollectionCriteria, preparedStatement);
		
		//Long filestoreCreatedTime = getpublicDashboardFilestoreCreatedtime(SearchTotalCollectionCriteria, preparedStatement);

		double ApplicationApprovedTimeTaken = publicDashBoardTimeTaken(SearchTotalCollectionCriteria,
				preparedStatement);
		System.out.println("ApplicationApprovedTimeTaken::" + ApplicationApprovedTimeTaken);
		double ApplicationTimeTaken = 0.0;
		int timeTakenForApproval = 0;
		if (ApplicationApproved > 0) {
			ApplicationTimeTaken = ApplicationApprovedTimeTaken / ApplicationApproved;
			System.out.println("ApplicationTimeTaken::" + ApplicationTimeTaken);
			timeTakenForApproval = (int) Math.ceil(ApplicationTimeTaken);
			System.out.println("timeTakenForApproval::" + timeTakenForApproval);
		}
		
		int minimumTimeTakenForApproved = publicDashBoardMinimumTimeTaken(SearchTotalCollectionCriteria,
				preparedStatement);
				
		int maximumTimeTakenForApproved = publicDashBoardMaximumTimeTaken(SearchTotalCollectionCriteria,
				preparedStatement);
		
		List<Integer> approvedDays = publicDashBoardgetApprovedDays(SearchTotalCollectionCriteria,
				preparedStatement);
		
		double median = calculateMedianUsingFormula(approvedDays);
		System.out.println("Median using formula: " + median);
		
		BigDecimal AverageFeeTaken = BigDecimal.ZERO;
	    if (ApplicationApproved > 0) {
	        AverageFeeTaken = TotalCollection.divide(BigDecimal.valueOf(ApplicationApproved), 2, RoundingMode.HALF_UP);
	    }
	    
	    String waterConnectionValue = MDMSValidator.getSewerageConnectionValue(SearchTotalCollectionCriteria.getRequestInfo(), SearchTotalCollectionCriteria.getRequestInfo().getUserInfo().getTenantId());


		ResponseData rs = new ResponseData();

		rs.setTotalApplicationReceived(ApplicationReceived);
		rs.setTotalApplicationsApproved(ApplicationApproved);
		rs.setTimeTakenForApproval(timeTakenForApproval);
		rs.setTotalCollection(TotalCollection);
		rs.setFilestoreId(null);
		rs.setCreatedTime(null);
		rs.setMinimumTimeTakenForApproval(minimumTimeTakenForApproved);
		rs.setMaximumTimeTakenForApproval(maximumTimeTakenForApproved);
		rs.setMedianTimeTakenForApproval(median);
		rs.setAverageFeeTaken(AverageFeeTaken);
		rs.setPublicServiceGuaranteeAct(waterConnectionValue);
		return rs;
	}
	
	private double calculateMedianUsingFormula(List<Integer> approvedDays) {
	    if (approvedDays == null || approvedDays.isEmpty()) {
	        throw new IllegalArgumentException("List is empty or null");
	    }

	    // Sort the list
	    Collections.sort(approvedDays);

	    int n = approvedDays.size();

	    if (n % 2 != 0) {
	        // If n is odd, using the formula: Median = (n + 1) / 2th term
	        int medianIndex = (n + 1) / 2 - 1; // -1 for zero-based index
	        return approvedDays.get(medianIndex);
	    } else {
	        // If n is even, using the formula: Median = [(n/2)th term + ((n/2) + 1)th term] / 2
	        int mid1Index = (n / 2) - 1;  // Zero-based index
	        int mid2Index = (n / 2);
	        return (approvedDays.get(mid1Index) + approvedDays.get(mid2Index)) / 2.0;
	    }
	}
	
	

}
