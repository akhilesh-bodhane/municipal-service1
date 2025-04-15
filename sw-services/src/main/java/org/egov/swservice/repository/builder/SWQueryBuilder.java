package org.egov.swservice.repository.builder;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.egov.common.contract.request.RequestInfo;
import org.egov.swservice.config.SWConfiguration;
import org.egov.swservice.model.Property;
import org.egov.swservice.model.PublicDashBoardSearchCritieria;
import org.egov.swservice.model.SearchCriteria;
import org.egov.swservice.model.SearchTotalCollectionCriteria;
import org.egov.swservice.util.SewerageServicesUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;


@Component
public class SWQueryBuilder {

	@Autowired
	private SewerageServicesUtil sewerageServicesUtil;

	@Autowired
	private SWConfiguration config;

	private static final String INNER_JOIN_STRING = " INNER JOIN ";
	 private static final String LEFT_OUTER_JOIN_STRING = " LEFT OUTER JOIN ";
	//private static final String Offset_Limit_String = "OFFSET ? LIMIT ?";
	
	private final static String noOfConnectionSearchQuery = "SELECT count(*) FROM eg_sw_connection WHERE";
	private static String holderSelectValues = "connectionholder.tenantid as holdertenantid, connectionholder.connectionid as holderapplicationId, userid, connectionholder.status as holderstatus, isprimaryholder, connectionholdertype,connectionholder.correspondance_address as holdercorrepondanceaddress, holdershippercentage, connectionholder.relationship as holderrelationship,connectionholder.name as holdername, connectionholder.createdby as holdercreatedby, connectionholder.createdtime as holdercreatedtime, connectionholder.lastmodifiedby as holderlastmodifiedby, connectionholder.lastmodifiedtime as holderlastmodifiedtime, connectionholder.mobile_no as holdermobileno, connectionholder.gender as holdergender, connectionholder.guardian_name as holderguardianname ";
	private final static String SEWERAGE_SEARCH_QUERY = "SELECT "
			/*+ " conn.*, sc.*, document.*, plumber.*, "*/
			+ " sc.connectionExecutionDate, sc.noOfWaterClosets, sc.noOfToilets,sc.proposedWaterClosets, sc.proposedToilets, sc.connectionType, sc.connection_id as connection_Id, sc.appCreatedDate,"
			+ " sc.metercount,sc.meterrentcode,sc.mfrcode,sc.meterdigits,sc.meterunit,sc.sanctionedcapacity,sc.detailsprovidedby, sc.estimationfileStoreId , sc.sanctionfileStoreId , sc.estimationLetterDate,"
			+ " conn.id as conn_id, conn.tenantid, conn.applicationNo, conn.applicationStatus, conn.status, conn.connectionNo, conn.oldConnectionNo, conn.property_id,py.paymentmode,"
			+ " conn.aadharNo, conn.ferruleSize, conn.cccode,conn.div,conn.subdiv,conn.ledger_no,conn.ledgergroup,conn.billgroup,conn.contract_value,conn.roadcuttingarea, conn.action, conn.adhocpenalty, conn.adhocrebate, conn.createdBy as sw_createdBy,"
			+ " conn.lastModifiedBy as sw_lastModifiedBy, conn.createdTime as sw_createdTime, conn.lastModifiedTime as sw_lastModifiedTime, "
			+ " conn.adhocpenaltyreason, conn.adhocpenaltycomment, conn.adhocrebatereason, conn.adhocrebatecomment,"
			+ " conn.roadtype,conn.total_amount_paid, conn.additionalcharges,conn.location,document.id as doc_Id, document.documenttype, document.filestoreid, document.active as doc_active, plumber.id as plumber_id, plumber.name as plumber_name, plumber.licenseno, property.usagesubcategory,pta.doorno as propertyplotno,pta.locality as propertysectorno ,"
			+ " plumber.mobilenumber as plumber_mobileNumber, plumber.gender as plumber_gender, plumber.fatherorhusbandname, plumber.correspondenceaddress, plumber.relationship, "
			+ " property.id as seweragepropertyid, property.usagecategory, property.usagesubcategory, " +holderSelectValues
			+ " FROM eg_sw_connection conn "
			+  LEFT_OUTER_JOIN_STRING 
			+ "egcl_bill bl  on  conn.applicationno = bl.consumercode"
			+  LEFT_OUTER_JOIN_STRING
			+ "egcl_paymentdetail pyd on pyd.billid = bl.id"
			+  LEFT_OUTER_JOIN_STRING
			+ "egcl_payment py on py.id= pyd.paymentid"	
			+  INNER_JOIN_STRING 
			+" eg_sw_service sc ON sc.connection_id = conn.id"
			+  INNER_JOIN_STRING 
			+ "eg_pt_address pta ON conn.property_id = pta.propertyid"
			+  INNER_JOIN_STRING
			+ "eg_sw_property property ON property.swid = conn.id"
			+  LEFT_OUTER_JOIN_STRING
			+ "eg_sw_applicationdocument document ON document.swid = conn.id" 
			+  LEFT_OUTER_JOIN_STRING
			+ "eg_sw_plumberinfo plumber ON plumber.swid = conn.id"
			+ LEFT_OUTER_JOIN_STRING
		    + "eg_sw_connectionholder connectionholder ON connectionholder.connectionid = conn.id";

	/**
	 * 
	 * @param criteria on search criteria
	 * @param preparedStatement preparedStatement
	 * @param requestInfo
	 * @return
	 */
	
	
	private final String paginationWrapper = "SELECT * FROM " +
            "(SELECT *, DENSE_RANK() OVER (ORDER BY conn_id) offset_ FROM " +
            "({})" +
            " result) result_offset " +
            "WHERE offset_ > ? AND offset_ <= ?";
	
	
	
	private static final String SEWERAGE_SEARCH_QUERY_EG_PG_TOTAL_COLLECTION_COUNT = "   SELECT distinct    \r\n"
			+ "      count(conn.applicationno) as totatconnections,       \r\n"
			+ "      COALESCE(SUM(ept.txn_amount),0) as totalcollections\r\n"
			+ "	  FROM \r\n"
			+ "			eg_sw_connection conn \r\n"
			+ "			INNER JOIN eg_pg_transactions ept on conn.applicationno  = ept.consumer_code\r\n"
			+ "			INNER JOIN eg_sw_property property ON property.swid = conn.id\r\n"
			+ "			 WHERE ept.consumer_code  LIKE 'SW_AP%' and conn.applicationno  LIKE 'SW_AP%' \r\n"
			+ "			 and ept.txn_status = 'SUCCESS' and ept.txn_status_msg  = 'Transaction successful' ";
	
	private static final String SEWERAGE_SEARCH_QUERY_EG_CL_TOTAL_COLLECTION_COUNT = " SELECT  distinct    \r\n"
			+ "      count(conn.applicationno)  as totatconnections,  \r\n"
			+ "     COALESCE(SUM(py.totaldue),0) as totalcollections\r\n"
			+ "	  FROM \r\n"
			+ "			eg_sw_connection conn \r\n"
			+ "			INNER JOIN egcl_bill bl  on  conn.applicationno  = bl.consumercode \r\n"
			+ "			INNER JOIN egcl_paymentdetail pyd on pyd.billid = bl.id\r\n"
			+ "			INNER JOIN egcl_payment py on py.id= pyd.paymentid\r\n"
			+ "			INNER JOIN eg_sw_property property ON property.swid  = conn.id\r\n"
			+ "			 WHERE  conn.applicationno  LIKE 'SW_AP%'  AND bl.consumercode  LIKE 'SW_AP%'  \r\n"
			+ "			 and py.totaldue  !=0 ";
	
    private static final String PUBLIC_DASHBOARD_SEWERAGE_APPLICATION_RECEIVIED_COUNT = "select count(*) from eg_sw_connection esc ";
	
	private static final String PUBLIC_DASHBOARD_SEWERAGE_SEARCH_APPROVED = "select SUM(case when esc.applicationstatus in ('CONNECTION_ACTIVATED','SEWERAGE_CONNECTION_ACTIVATED') then 1 else 0 end) \r\n"
			+ "from eg_sw_connection esc ";
	
	private static final String PUBLIC_DASHBOARD_SEWERAGE_SEARCH_TIME_TAKEN_APPROVED = "SELECT \r\n"
			+ "SUM(CEIL(\r\n"
			+ "        EXTRACT(EPOCH FROM (TO_TIMESTAMP(esc.lastmodifiedtime / 1000) - TO_TIMESTAMP(esc.createdtime / 1000))) / 3600 / 24\r\n"
			+ "    )) AS approveddays\r\n"
			+ " from eg_sw_connection esc ";
	
	private static final String PUBLIC_DASHBOARD_SEWERAGE_TOTAL_COLLECTION = "select sum(ept.txn_amount) from eg_sw_connection esc inner join eg_pg_transactions ept\r\n"
			+ "on esc.applicationno  = ept.consumer_code ";
	
	private static final String PUBLIC_DASHBOARD_SEWERAGE_SEARCH_MINIMUM_TIME_TAKEN_APPROVED = "SELECT \r\n"
			+ "MIN(CEIL(\r\n"
			+ "        EXTRACT(EPOCH FROM (TO_TIMESTAMP(esc.lastmodifiedtime / 1000) - TO_TIMESTAMP(esc.createdtime / 1000))) / 3600 / 24\r\n"
			+ "    )) AS minimum_approved_days\r\n"
			+ " FROM eg_sw_connection esc";
	
	private static final String PUBLIC_DASHBOARD_SEWERAGE_SEARCH_MAXIMUM_TIME_TAKEN_APPROVED = "SELECT \r\n"
			+ "MAX(CEIL(\r\n"
			+ "        EXTRACT(EPOCH FROM (TO_TIMESTAMP(esc.lastmodifiedtime / 1000) - TO_TIMESTAMP(esc.createdtime / 1000))) / 3600 / 24\r\n"
			+ "    )) AS maximum_approved_days\r\n"
			+ " FROM eg_sw_connection esc";
	
	public static final String PUBLIC_DASHBOARD_SEWERAGE_SEARCH__APPROVED_DAYS = "SELECT    \r\n"
			+ "CEIL(\r\n"
			+ "        EXTRACT(EPOCH FROM (TO_TIMESTAMP(esc.lastmodifiedtime / 1000) - TO_TIMESTAMP(esc.createdtime / 1000))) / 3600 / 24\r\n"
			+ "    ) AS approveddays\r\n"
			+ " FROM eg_sw_connection esc";
	
	
	
	public String getSearchQueryString(SearchCriteria criteria, List<Object> preparedStatement,
			RequestInfo requestInfo) {
		if(criteria.isEmpty())
			return null;
		StringBuilder query = new StringBuilder(SEWERAGE_SEARCH_QUERY);
		if (!StringUtils.isEmpty(criteria.getMobileNumber())) {

			addClauseIfRequired(preparedStatement, query);
			query.append(" connectionholder.mobile_no = ? ");
			preparedStatement.add(criteria.getMobileNumber());
		}
		if (!StringUtils.isEmpty(criteria.getTenantId())) {
			addClauseIfRequired(preparedStatement, query);
			query.append(" conn.tenantid = ? ");
			preparedStatement.add(criteria.getTenantId());
		}
		if (!CollectionUtils.isEmpty(criteria.getIds())) {
			addClauseIfRequired(preparedStatement, query);
			query.append(" conn.id in (").append(createQuery(criteria.getIds())).append(" )");
			addToPreparedStatement(preparedStatement, criteria.getIds());
		}

//		if (!StringUtils.isEmpty(criteria.getPropertyId())) {
//			addClauseIfRequired(preparedStatement, query);
//			query.append(" conn.property_id = ? ");
//			preparedStatement.add(criteria.getPropertyId());
//		}
		if (!StringUtils.isEmpty(criteria.getOldConnectionNumber())) {
			addClauseIfRequired(preparedStatement, query);
			query.append(" conn.oldconnectionno = ? ");
			preparedStatement.add(criteria.getOldConnectionNumber());
		}
		if (!StringUtils.isEmpty(criteria.getPlotNo())) {
			addClauseIfRequired(preparedStatement, query);
			query.append(" pta.doorno = ? ");
			preparedStatement.add(criteria.getPlotNo());
		}
		if (!StringUtils.isEmpty(criteria.getSectorNo())) {
			addClauseIfRequired(preparedStatement, query);
			query.append(" pta.locality = ? ");
			preparedStatement.add(criteria.getSectorNo());
		}
		if (!StringUtils.isEmpty(criteria.getGroupNo())) {
			addClauseIfRequired(preparedStatement, query);
			query.append(" conn.billgroup = ? ");
			preparedStatement.add(criteria.getGroupNo());
		}
		if (!StringUtils.isEmpty(criteria.getConnectionNumber())) {
			addClauseIfRequired(preparedStatement, query);
			query.append(" conn.connectionno = ? ");
			preparedStatement.add(criteria.getConnectionNumber());
		}
		if (!StringUtils.isEmpty(criteria.getStatus())) {
			addClauseIfRequired(preparedStatement, query);
			query.append(" conn.status = ? ");
			preparedStatement.add(criteria.getStatus());
		}
		if (!StringUtils.isEmpty(criteria.getApplicationNumber())) {
			addClauseIfRequired(preparedStatement, query);
			query.append(" conn.applicationno = ? ");
			preparedStatement.add(criteria.getApplicationNumber());
		}
		if (!StringUtils.isEmpty(criteria.getApplicationNumberSearch())) {
			addClauseIfRequired(preparedStatement, query);
			query.append(" conn.applicationno ilike ? ");
			preparedStatement.add("%"+criteria.getApplicationNumberSearch());
		}
		if (!StringUtils.isEmpty(criteria.getSubDivision())) {
			addClauseIfRequired(preparedStatement, query);
			query.append(" conn.subdiv = ? ");
			preparedStatement.add(criteria.getSubDivision());
		}
		if (!StringUtils.isEmpty(criteria.getDivision())) {
			addClauseIfRequired(preparedStatement, query);
			query.append(" conn.div = ? ");
			preparedStatement.add(criteria.getDivision());
		}
		if (!StringUtils.isEmpty(criteria.getApplicationStatus())) {
			addClauseIfRequired(preparedStatement, query);
			query.append(" conn.applicationStatus = ? ");
			preparedStatement.add(criteria.getApplicationStatus());
		}
		if (criteria.getFromDate() != null) {
			addClauseIfRequired(preparedStatement, query);
			query.append("  sc.appCreatedDate >= ? ");
			preparedStatement.add(criteria.getFromDate());
		}
		if (criteria.getToDate() != null) {
			addClauseIfRequired(preparedStatement, query);
			query.append("  sc.appCreatedDate <= ? ");
			preparedStatement.add(criteria.getToDate());
		}
		//Add OrderBy clause
		query.append(" ORDER BY sc.appCreatedDate DESC");
		
		if (query.toString().indexOf("WHERE") > -1)
			 return addPaginationWrapper(query.toString(), preparedStatement, criteria);
		return query.toString();
	}
	
	
	public String getSearchQueryStringCount(SearchCriteria criteria, List<Object> preparedStatement,
			RequestInfo requestInfo) {
		if(criteria.isEmpty())
			return null;
		StringBuilder query = new StringBuilder(SEWERAGE_SEARCH_QUERY);
		
		if (!StringUtils.isEmpty(criteria.getTenantId())) {
			addClauseIfRequired(preparedStatement, query);
			query.append(" conn.tenantid = ? ");
			preparedStatement.add(criteria.getTenantId());
		}
		

		if (criteria.getFromDate() != null) {
			addClauseIfRequired(preparedStatement, query);
			query.append("  sc.appCreatedDate >= ? ");
			preparedStatement.add(criteria.getFromDate());
		}
		if (criteria.getToDate() != null) {
			addClauseIfRequired(preparedStatement, query);
			query.append("  sc.appCreatedDate <= ? ");
			preparedStatement.add(criteria.getToDate());
		}
		//Add OrderBy clause
		query.append(" ORDER BY sc.appCreatedDate DESC");
		
		
		return query.toString();
	}

	private void addClauseIfRequired(List<Object> values, StringBuilder queryString) {
		if (values.isEmpty())
			queryString.append(" WHERE ");
		else {
			queryString.append(" AND");
		}
	}

	private String createQuery(Set<String> ids) {
		StringBuilder builder = new StringBuilder();
		int length = ids.size();
		for (int i = 0; i < length; i++) {
			builder.append(" ?");
			if (i != length - 1)
				builder.append(",");
		}
		return builder.toString();
	}

	private void addToPreparedStatement(List<Object> preparedStatement, Set<String> ids) {
		ids.forEach(id -> {
			preparedStatement.add(id);
		});
	}


	/**
	 * 
	 * @param query
	 *            The
	 * @param preparedStmtList
	 *            Array of object for preparedStatement list
	 * @return It's returns query
	 */
	private String addPaginationWrapper(String query, List<Object> preparedStmtList, SearchCriteria criteria) {
//		query = query + " " + Offset_Limit_String;
		Integer limit = config.getDefaultLimit();
		Integer offset = config.getDefaultOffset();

		if (criteria.getLimit() != null && criteria.getLimit() <= config.getDefaultLimit())
			limit = criteria.getLimit();

		if (criteria.getLimit() != null && criteria.getLimit() > config.getDefaultOffset())
			limit = config.getDefaultLimit();

		if (criteria.getOffset() != null)
			offset = criteria.getOffset();

		preparedStmtList.add(offset);
		preparedStmtList.add(limit + offset);
		return paginationWrapper.replace("{}",query);
	}
	
	public String getNoOfSewerageConnectionQuery(Set<String> connectionIds, List<Object> preparedStatement) {
		StringBuilder query = new StringBuilder(noOfConnectionSearchQuery);
		Set<String> listOfIds = new HashSet<>();
		connectionIds.forEach(id -> listOfIds.add(id));
		query.append(" connectionno in (").append(createQuery(connectionIds)).append(" )");
		addToPreparedStatement(preparedStatement, listOfIds);
		return query.toString();
	}
	
	
	
	/**
	 * 
	 * @param criteria
	 *            The SewerageCriteria
	 * @param preparedStatement
	 *            The Array Of Object
	 * @param requestInfo
	 *            The Request Info
	 * @return query as a string
	 */
	public String getSearchQueryStringTotalCollectionCount(SearchTotalCollectionCriteria SearchTotalCollectionCriteria, List<Object> preparedStatement,
			RequestInfo requestInfo) {
		StringBuilder query;
		if (SearchTotalCollectionCriteria.isEmpty())
				return null;
		
		if((SearchTotalCollectionCriteria.getPaymentchannel() != null || SearchTotalCollectionCriteria.getPaymentchannel() != "") 
		 && ("ONLINE".equals(SearchTotalCollectionCriteria.getConnectionchannel())) ) {
		 query = new StringBuilder(SEWERAGE_SEARCH_QUERY_EG_PG_TOTAL_COLLECTION_COUNT);	
		}
		else {
		 query = new StringBuilder(SEWERAGE_SEARCH_QUERY_EG_CL_TOTAL_COLLECTION_COUNT);	
		}
		
		//boolean propertyIdsPresent = false;	
		
		if (!StringUtils.isEmpty(SearchTotalCollectionCriteria.getTenantId())) {
			//addClauseIfRequired(preparedStatement, query);
			query.append(" AND conn.tenantid = ? ");
			preparedStatement.add(SearchTotalCollectionCriteria.getTenantId());
		}
		
		if (!StringUtils.isEmpty(SearchTotalCollectionCriteria.getPaymentchannel())) {
			//addClauseIfRequired(preparedStatement, query);
			query.append(" ept.gateway = ? ");
			preparedStatement.add(SearchTotalCollectionCriteria.getPaymentchannel());
		}
		
		if (SearchTotalCollectionCriteria.getUsagetype() != null) {
			addClauseIfRequired(preparedStatement, query);
			query.append(" property.usagecategory = ? ");
			preparedStatement.add(SearchTotalCollectionCriteria.getUsagetype());
		}
		if(!"ONLINE".equals(SearchTotalCollectionCriteria.getConnectionchannel()) &&
				!StringUtils.isEmpty(SearchTotalCollectionCriteria.getConnectionchannel())) {
			addClauseIfRequired(preparedStatement, query);
			query.append(" py.paymentmode = ? ");
			preparedStatement.add(SearchTotalCollectionCriteria.getConnectionchannel());
		}
		if (SearchTotalCollectionCriteria.getFromDate() != null) {
			addClauseIfRequired(preparedStatement, query);
			query.append(" conn.lastmodifiedtime >= ? ");
			preparedStatement.add(SearchTotalCollectionCriteria.getFromDate());
		}
		if (SearchTotalCollectionCriteria.getToDate() != null) {
			addClauseIfRequired(preparedStatement, query);
			query.append(" conn.lastmodifiedtime <= ? ");
			preparedStatement.add(SearchTotalCollectionCriteria.getToDate());
		}
		/*
		 * if(SearchTotalCollectionCriteria.getConnectionchannel().equals("CASH")) {
		 * addClauseIfRequired(preparedStatement, query);
		 * query.append(" py.paymentmode = 'CASH' ");
		 * preparedStatement.add(SearchTotalCollectionCriteria.getConnectionchannel());
		 * }
		 */
		
		//query.append(ORDER_BY_CLAUSE);
		return query.toString() ;
	}
	
	public String getSearchQueryStringPublicDashBoard(PublicDashBoardSearchCritieria SearchTotalCollectionCriteria,
			List<Object> preparedStatement) {
		preparedStatement.clear();
		StringBuilder query = null;
		query = new StringBuilder(PUBLIC_DASHBOARD_SEWERAGE_APPLICATION_RECEIVIED_COUNT);
		if(SearchTotalCollectionCriteria.getDataPayload() !=null) {
		if (SearchTotalCollectionCriteria.getDataPayload().getFromDate() != null) {
			addClauseIfRequired(preparedStatement, query);
			query.append("  esc.createdtime >= ?  ");
			preparedStatement.add(SearchTotalCollectionCriteria.getDataPayload().getFromDate());
		}
		if (SearchTotalCollectionCriteria.getDataPayload().getToDate() != null) {
			addClauseIfRequired(preparedStatement, query);
			query.append("  esc.createdtime <= ? ");
			preparedStatement.add(SearchTotalCollectionCriteria.getDataPayload().getToDate());
		}
		}

		return query.toString();

	}
	
	public String getSearchQueryStringPublicDashBoardApproved(
			PublicDashBoardSearchCritieria SearchTotalCollectionCriteria, List<Object> preparedStatement) {
		preparedStatement.clear();
		StringBuilder query = null;
		query = new StringBuilder(PUBLIC_DASHBOARD_SEWERAGE_SEARCH_APPROVED);
		if(SearchTotalCollectionCriteria.getDataPayload() !=null) {
		if (SearchTotalCollectionCriteria.getDataPayload().getFromDate() != null) {
			addClauseIfRequired(preparedStatement, query);
			query.append("  esc.createdtime >= ?  ");
			preparedStatement.add(SearchTotalCollectionCriteria.getDataPayload().getFromDate());
		}
		if (SearchTotalCollectionCriteria.getDataPayload().getToDate() != null) {
			addClauseIfRequired(preparedStatement, query);
			query.append("  esc.createdtime <= ? ");
			preparedStatement.add(SearchTotalCollectionCriteria.getDataPayload().getToDate());
		}
		}
		
		addClauseIfRequired(preparedStatement, query);
		query.append(" esc.applicationstatus in ('CONNECTION_ACTIVATED','SEWERAGE_CONNECTION_ACTIVATED')");
				
		return query.toString();

	}
	
	public String getSearchQueryStringPublicDashBoardTimeTaken(
			PublicDashBoardSearchCritieria SearchTotalCollectionCriteria, List<Object> preparedStatement) {
		preparedStatement.clear();
		StringBuilder query = null;
		query = new StringBuilder(PUBLIC_DASHBOARD_SEWERAGE_SEARCH_TIME_TAKEN_APPROVED);
		if (SearchTotalCollectionCriteria.getDataPayload().getFromDate() != null) {
			addClauseIfRequired(preparedStatement, query);
			query.append("  esc.createdtime >= ?  ");
			preparedStatement.add(SearchTotalCollectionCriteria.getDataPayload().getFromDate());
		}
		if (SearchTotalCollectionCriteria.getDataPayload().getToDate() != null) {
			addClauseIfRequired(preparedStatement, query);
			query.append("  esc.createdtime <= ? ");
			preparedStatement.add(SearchTotalCollectionCriteria.getDataPayload().getToDate());
		}
		
		addClauseIfRequired(preparedStatement, query);
		query.append(" esc.applicationstatus in ('CONNECTION_ACTIVATED','SEWERAGE_CONNECTION_ACTIVATED')");

		return query.toString();

	}
	
	public String getSearchQueryStringPublicDashBoardMinimumTimeTaken(
			PublicDashBoardSearchCritieria SearchTotalCollectionCriteria, List<Object> preparedStatement) {
		preparedStatement.clear();
		StringBuilder query = null;
		query = new StringBuilder(PUBLIC_DASHBOARD_SEWERAGE_SEARCH_MINIMUM_TIME_TAKEN_APPROVED);
		if (SearchTotalCollectionCriteria.getDataPayload().getFromDate() != null) {
			addClauseIfRequired(preparedStatement, query);
			query.append("  esc.createdtime >= ?  ");
			preparedStatement.add(SearchTotalCollectionCriteria.getDataPayload().getFromDate());
		}
		if (SearchTotalCollectionCriteria.getDataPayload().getToDate() != null) {
			addClauseIfRequired(preparedStatement, query);
			query.append("  esc.createdtime <= ? ");
			preparedStatement.add(SearchTotalCollectionCriteria.getDataPayload().getToDate());
		}
		
		addClauseIfRequired(preparedStatement, query);
		query.append(" esc.applicationstatus in ('CONNECTION_ACTIVATED','SEWERAGE_CONNECTION_ACTIVATED')");

		return query.toString();
	}
	
	public String getSearchQueryStringPublicDashBoardMaxmimumTimeTaken(
			PublicDashBoardSearchCritieria SearchTotalCollectionCriteria, List<Object> preparedStatement) {
		preparedStatement.clear();
		StringBuilder query = null;
		query = new StringBuilder(PUBLIC_DASHBOARD_SEWERAGE_SEARCH_MAXIMUM_TIME_TAKEN_APPROVED);
		if (SearchTotalCollectionCriteria.getDataPayload().getFromDate() != null) {
			addClauseIfRequired(preparedStatement, query);
			query.append("  esc.createdtime >= ?  ");
			preparedStatement.add(SearchTotalCollectionCriteria.getDataPayload().getFromDate());
		}
		if (SearchTotalCollectionCriteria.getDataPayload().getToDate() != null) {
			addClauseIfRequired(preparedStatement, query);
			query.append("  esc.createdtime <= ? ");
			preparedStatement.add(SearchTotalCollectionCriteria.getDataPayload().getToDate());
		}
		
		addClauseIfRequired(preparedStatement, query);
		query.append(" esc.applicationstatus in ('CONNECTION_ACTIVATED','SEWERAGE_CONNECTION_ACTIVATED')");

		return query.toString();
	}
	
	public String getSearchQueryStringPublicDashBoardApprovedDays(
			PublicDashBoardSearchCritieria SearchTotalCollectionCriteria, List<Object> preparedStatement) {
		preparedStatement.clear();
		StringBuilder query = null;
		query = new StringBuilder(PUBLIC_DASHBOARD_SEWERAGE_SEARCH__APPROVED_DAYS);
		if (SearchTotalCollectionCriteria.getDataPayload().getFromDate() != null) {
			addClauseIfRequired(preparedStatement, query);
			query.append("  esc.createdtime >= ?  ");
			preparedStatement.add(SearchTotalCollectionCriteria.getDataPayload().getFromDate());
		}
		if (SearchTotalCollectionCriteria.getDataPayload().getToDate() != null) {
			addClauseIfRequired(preparedStatement, query);
			query.append("  esc.createdtime <= ? ");
			preparedStatement.add(SearchTotalCollectionCriteria.getDataPayload().getToDate());
		}
		addClauseIfRequired(preparedStatement, query);
		query.append("  esc.applicationstatus in ('CONNECTION_ACTIVATED','SEWERAGE_CONNECTION_ACTIVATED')");
		query.append(" order by approveddays asc");

		return query.toString();
	}
	
	public String getSearchQueryStringPublicDashBoardTotalCollection(
			PublicDashBoardSearchCritieria SearchTotalCollectionCriteria, List<Object> preparedStatement) {
		preparedStatement.clear();
		StringBuilder query = null;
		query = new StringBuilder(PUBLIC_DASHBOARD_SEWERAGE_TOTAL_COLLECTION);
		if(SearchTotalCollectionCriteria.getDataPayload() !=null) {
		if (SearchTotalCollectionCriteria.getDataPayload().getFromDate() != null) {
			addClauseIfRequired(preparedStatement, query);
			query.append("  esc.createdtime >= ?  ");
			preparedStatement.add(SearchTotalCollectionCriteria.getDataPayload().getFromDate());
		}
		if (SearchTotalCollectionCriteria.getDataPayload().getToDate() != null) {
			addClauseIfRequired(preparedStatement, query);
			query.append("  esc.createdtime <= ? ");
			preparedStatement.add(SearchTotalCollectionCriteria.getDataPayload().getToDate());
		}
		}		
		addClauseIfRequired(preparedStatement, query);
		query.append("  ept.txn_status = 'SUCCESS' ");

		return query.toString();

	}

}
