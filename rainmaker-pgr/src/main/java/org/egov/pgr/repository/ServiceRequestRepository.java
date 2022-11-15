package org.egov.pgr.repository;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.egov.pgr.contract.ServiceReqSearchCriteria;
import org.egov.pgr.model.Grievence;
import org.egov.pgr.repository.rowmapper.GrivenceDataRowMapper;
import org.egov.tracer.model.CustomException;
import org.egov.tracer.model.ServiceCallException;
import org.json.JSONArray;
import org.postgresql.util.PGobject;
import org.postgresql.util.PSQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class ServiceRequestRepository {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Autowired
	private GrivenceDataRowMapper grivenceDataRowMapper;

	public static final String SERVICE_SEARCH_WITH_DETAILS = "select array_to_json(array_agg(row_to_json(serviceRequests))) from (select (select (select (row_to_json(services)) from ( select *, (select (select row_to_json(auditDetails) from (select createdtime, lastmodifiedtime, createdby, lastmodifiedby from eg_pgr_service where svc.serviceRequestId=eg_pgr_service.serviceRequestId) auditDetails) as auditDetails), (select (select (row_to_json(addressDetail)) from (select * from eg_pgr_address where eg_pgr_address.uuid=eg_pgr_service.addressid) addressDetail) as addressDetail) from eg_pgr_service svc where svc.serviceRequestId=eg_pgr_service.serviceRequestId order by createdtime desc) services) as services),(select (select array_to_json(array_agg(row_to_json(actionHistory))) from ( select * from eg_pgr_action where businessKey=eg_pgr_service.serviceRequestId order by \"when\" desc) actionHistory) as actionHistory) from eg_pgr_service WHERE ";

	public static final String SERVICE_SEARCH_WITH_COUNT = "select array_to_json(array_agg(row_to_json(services))) from (select (row_to_json(services)) from ( select count(*) from eg_pgr_service where ";

	public static final String GRIEVENCE_SEARCH = "select row_number() over(order by servicecode,category,status,\"source\") sequencenum, servicecode,category,status,\"source\",\r\n"
			+ "SUM(case when to_date(TO_CHAR(to_timestamp(lastmodifiedtime / 1000), 'DD/MM/YYYY'),'DD/MM/YYYY') = NOW()::date or to_date(TO_CHAR(to_timestamp(createdtime / 1000), 'DD/MM/YYYY'),'DD/MM/YYYY') = NOW()::date then 1 else 0 end)  allComplaints,\r\n"
			+ "SUM(case when status = 'open' and to_date(TO_CHAR(to_timestamp(createdtime / 1000), 'DD/MM/YYYY'),'DD/MM/YYYY') = NOW()::date then 1 else 0 end)  open,\r\n"
			+ "SUM(case when status = 'reopen' and to_date(TO_CHAR(to_timestamp(lastmodifiedtime / 1000), 'DD/MM/YYYY'),'DD/MM/YYYY') = NOW()::date then 1 else 0 end)  reopen,\r\n"
			+ "SUM(case when status = 'assigned' and to_date(TO_CHAR(to_timestamp(lastmodifiedtime / 1000), 'DD/MM/YYYY'),'DD/MM/YYYY') = NOW()::date then 1 else 0 end)  assigned,\r\n"
			+ "SUM(case when status = 'rejected' and to_date(TO_CHAR(to_timestamp(lastmodifiedtime / 1000), 'DD/MM/YYYY'),'DD/MM/YYYY') = NOW()::date then 1 else 0 end)  rejected,\r\n"
			+ "SUM(case when status = 'reassignrequested' and to_date(TO_CHAR(to_timestamp(lastmodifiedtime / 1000), 'DD/MM/YYYY'),'DD/MM/YYYY') = NOW()::date then 1 else 0 end)  reassignrequested,\r\n"
			+ "SUM(case when status = 'closed' and to_date(TO_CHAR(to_timestamp(lastmodifiedtime / 1000), 'DD/MM/YYYY'),'DD/MM/YYYY') = NOW()::date then 1 else 0 end)  closed,\r\n"
			+ "SUM(case when status = 'escalatedlevel2pending' and to_date(TO_CHAR(to_timestamp(lastmodifiedtime / 1000), 'DD/MM/YYYY'),'DD/MM/YYYY') = NOW()::date then 1 else 0 end)  escalatedlevel2pending,\r\n"
			+ "SUM(case when status = 'escalatedlevel1pending' and to_date(TO_CHAR(to_timestamp(lastmodifiedtime / 1000), 'DD/MM/YYYY'),'DD/MM/YYYY') = NOW()::date then 1 else 0 end)  escalatedlevel1pending,\r\n"
			+ "SUM(case when status = 'resolved' and to_date(TO_CHAR(to_timestamp(lastmodifiedtime / 1000), 'DD/MM/YYYY'),'DD/MM/YYYY') = NOW()::date then 1 else 0 end)  resolved,\r\n"
			+ "SUM(case when status = 'closed' then 1 else 0 end)  closedComplaints, SUM(case when status = 'resolved' then 1 else 0 end)  resolvedComplaints, count(1) totalComplaints, 0 slaAchievement from eg_pgr_service where ";

	/**
	 * Fetches results from searcher framework based on the uri and request that
	 * define what is to be searched.
	 * 
	 * @param requestInfo
	 * @param serviceReqSearchCriteria
	 * @return Object
	 * @author vishal
	 */
	public Object fetchResult(StringBuilder uri, Object request) {
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
		Object response = null;
		try {
			response = restTemplate.postForObject(uri.toString(), request, Map.class);
		} catch (HttpClientErrorException e) {
			log.error("External Service threw an Exception: ", e);
			throw new ServiceCallException(e.getResponseBodyAsString());
		} catch (Exception e) {
			log.error("Exception while fetching from searcher: ", e);
		}

		return response;

	}

	public Map<String, Object> fetchData(ServiceReqSearchCriteria serviceReqSearchCriteria) {
		Map<String, Object> preparedStatementValues = new HashMap<>();
		String query = getPGRQuery(serviceReqSearchCriteria);
		List<PGobject> maps = null;
		try {

			maps = namedParameterJdbcTemplate.queryForList(query, preparedStatementValues, PGobject.class);
		} catch (DataAccessResourceFailureException ex) {
			log.info("Query Execution Failed Due To Timeout: ", ex);
			PSQLException cause = (PSQLException) ex.getCause();
			if (cause != null && cause.getSQLState().equals("57014")) {
				throw new CustomException("QUERY_EXECUTION_TIMEOUT", "Query failed, as it took more than expected");
			} else {
				throw ex;
			}
		} catch (Exception e) {
			log.info("Query Execution Failed: ", e);
			throw e;
		}

		List<String> convertPGOBjects = convertPGOBjects(maps);
		Map<String, Object> result = new HashMap<>();
		if (convertPGOBjects != null) {
			Type type = new TypeToken<ArrayList<Map<String, Object>>>() {
			}.getType();
			Gson gson = new Gson();
			List<Map<String, Object>> data = gson.fromJson(convertPGOBjects.toString(), type);
			result.put("services", data);
			return result;
		}
		return null;
	}

	/**
	 * Formatter util for PG objects.
	 * 
	 * @param maps
	 * @return
	 */
	public List<String> convertPGOBjects(List<PGobject> maps) {
		List<String> result = new ArrayList<>();
		if (null != maps || !maps.isEmpty()) {
			for (PGobject obj : maps) {
				if (null == obj.getValue())
					break;
				String tuple = obj.toString();
				if (tuple.startsWith("[") && tuple.endsWith("]")) {
					try {
						JSONArray jsonArray = new JSONArray(tuple);
						for (int i = 0; i < jsonArray.length(); i++) {
							result.add(jsonArray.get(i).toString());
						}
					} catch (Exception e) {
						log.error("Error while building json array!", e);
					}
				} else {
					try {
						result.add(obj.getValue());
					} catch (Exception e) {
						throw e;
					}
				}
			}
		}

		if (result.isEmpty())
			return null;

		return result;
	}

	public String getPGRQuery(ServiceReqSearchCriteria serviceReqSearchCriteria) {
		String query = SERVICE_SEARCH_WITH_DETAILS;
		StringBuilder whereStr = new StringBuilder();

		if (serviceReqSearchCriteria.getTenantId() != null && !serviceReqSearchCriteria.getTenantId().isEmpty()) {
			whereStr.append(" tenantid=").append("'" + serviceReqSearchCriteria.getTenantId() + "'");
		}

		if (serviceReqSearchCriteria.getActive() != null) {
			whereStr.append(" and active=").append(serviceReqSearchCriteria.getActive());
		} else {
			whereStr.append(" and active=").append(serviceReqSearchCriteria.getActive());
		}

		if (serviceReqSearchCriteria.getServiceRequestId() != null
				&& !serviceReqSearchCriteria.getServiceRequestId().isEmpty()) {
			StringBuilder serviceRequestId = new StringBuilder("[");
			serviceReqSearchCriteria.getServiceRequestId().stream()
					.forEach(p -> serviceRequestId.append("'%").append(p).append("%',"));
			serviceRequestId.deleteCharAt(serviceRequestId.length() - 1);
			serviceRequestId.append("]");
			whereStr.append(" and serviceRequestId LIKE ANY(ARRAY").append(serviceRequestId).append(")");
		}

		if (serviceReqSearchCriteria.getPhone() != null && !serviceReqSearchCriteria.getPhone().isEmpty()) {
			whereStr.append(" and phone=").append("'" + serviceReqSearchCriteria.getPhone() + "'");
		}

		if (serviceReqSearchCriteria.getStartDate() != null && serviceReqSearchCriteria.getStartDate() != 0) {
			whereStr.append(" and to_timestamp(cast(createdtime/1000 as bigint))::date >=")
					.append("to_timestamp(cast(" + serviceReqSearchCriteria.getStartDate() + "/1000 as bigint))::date");
		}
		if (serviceReqSearchCriteria.getEndDate() != null && serviceReqSearchCriteria.getEndDate() != 0) {
			whereStr.append(" and to_timestamp(cast(createdtime/1000 as bigint))::date <=")
					.append("to_timestamp(cast(" + serviceReqSearchCriteria.getEndDate() + "/1000 as bigint))::date");
		}
		if (serviceReqSearchCriteria.getStatus() != null && !serviceReqSearchCriteria.getStatus().isEmpty()) {
			StringBuilder status = new StringBuilder("(");
			serviceReqSearchCriteria.getStatus().stream().forEach(p -> status.append("'").append(p).append("',"));
			status.deleteCharAt(status.length() - 1);
			status.append(")");
			whereStr.append(" and status in ").append(status);
		}
		if (serviceReqSearchCriteria.getCategory() != null && !serviceReqSearchCriteria.getCategory().isEmpty()) {
			StringBuilder category = new StringBuilder("(");
			serviceReqSearchCriteria.getCategory().stream().forEach(p -> category.append("'").append(p).append("',"));
			category.deleteCharAt(category.length() - 1);
			category.append(")");
			whereStr.append(" and category in ").append(category);
		}

		whereStr.append(" order by createdtime desc LIMIT ");
		if (serviceReqSearchCriteria.getNoOfRecords() != null && serviceReqSearchCriteria.getNoOfRecords() != 0) {
			whereStr.append(" serviceReqSearchCriteria.getNoOfRecords() ");
		} else {
			whereStr.append(" 200 ");
		}

		whereStr.append(" OFFSET ");
		if (serviceReqSearchCriteria.getOffset() != null && serviceReqSearchCriteria.getOffset() != 0) {
			whereStr.append(" serviceReqSearchCriteria.getOffset() ");
		} else {
			whereStr.append(" 0 ");
		}

		whereStr.append(") serviceRequests");
		query = query + whereStr.toString();
		log.info("Complaint Type wise report query: " + query);
		return query;

	}

	public Object fetchDataCount(ServiceReqSearchCriteria serviceReqSearchCriteria) {

		Map<String, Object> preparedStatementValues = new HashMap<>();
		String query = getPGRCountQuery(serviceReqSearchCriteria);
		List<PGobject> maps = null;
		try {

			maps = namedParameterJdbcTemplate.queryForList(query, preparedStatementValues, PGobject.class);
		} catch (DataAccessResourceFailureException ex) {
			log.info("Query Execution Failed Due To Timeout: ", ex);
			PSQLException cause = (PSQLException) ex.getCause();
			if (cause != null && cause.getSQLState().equals("57014")) {
				throw new CustomException("QUERY_EXECUTION_TIMEOUT", "Query failed, as it took more than expected");
			} else {
				throw ex;
			}
		} catch (Exception e) {
			log.info("Query Execution Failed: ", e);
			throw e;
		}

		List<String> convertPGOBjects = convertPGOBjects(maps);
		Map<String, Object> result = new HashMap<>();
		if (convertPGOBjects != null) {
			Type type = new TypeToken<ArrayList<Map<String, Object>>>() {
			}.getType();
			Gson gson = new Gson();
			List<Map<String, Object>> data = gson.fromJson(convertPGOBjects.toString(), type);
			result.put("count", data);
		}
		return result;

	}

	public String getPGRCountQuery(ServiceReqSearchCriteria serviceReqSearchCriteria) {
		String query = SERVICE_SEARCH_WITH_COUNT;
		StringBuilder whereStr = new StringBuilder();

		if (serviceReqSearchCriteria.getTenantId() != null && !serviceReqSearchCriteria.getTenantId().isEmpty()) {
			whereStr.append(" tenantid=").append("'" + serviceReqSearchCriteria.getTenantId() + "'");
		}

		if (serviceReqSearchCriteria.getActive() != null) {
			whereStr.append(" and active=").append(serviceReqSearchCriteria.getActive());
		} else {
			whereStr.append(" and active=").append(serviceReqSearchCriteria.getActive());
		}

		if (serviceReqSearchCriteria.getServiceRequestId() != null
				&& !serviceReqSearchCriteria.getServiceRequestId().isEmpty()) {
			StringBuilder serviceRequestId = new StringBuilder("[");
			serviceReqSearchCriteria.getServiceRequestId().stream()
					.forEach(p -> serviceRequestId.append("'%").append(p).append("%',"));
			serviceRequestId.deleteCharAt(serviceRequestId.length() - 1);
			serviceRequestId.append("]");
			whereStr.append(" and serviceRequestId LIKE ANY(ARRAY").append(serviceRequestId).append(")");
		}

		if (serviceReqSearchCriteria.getPhone() != null && !serviceReqSearchCriteria.getPhone().isEmpty()) {
			whereStr.append(" and phone=").append("'" + serviceReqSearchCriteria.getPhone() + "'");
		}

		if (serviceReqSearchCriteria.getStartDate() != null && serviceReqSearchCriteria.getStartDate() != 0) {
			whereStr.append(" and to_timestamp(cast(createdtime/1000 as bigint))::date >=")
					.append("to_timestamp(cast(" + serviceReqSearchCriteria.getStartDate() + "/1000 as bigint))::date");
		}
		if (serviceReqSearchCriteria.getEndDate() != null && serviceReqSearchCriteria.getEndDate() != 0) {
			whereStr.append(" and to_timestamp(cast(createdtime/1000 as bigint))::date <=")
					.append("to_timestamp(cast(" + serviceReqSearchCriteria.getEndDate() + "/1000 as bigint))::date");
		}
		if (serviceReqSearchCriteria.getStatus() != null && !serviceReqSearchCriteria.getStatus().isEmpty()) {
			StringBuilder status = new StringBuilder("(");
			serviceReqSearchCriteria.getStatus().stream().forEach(p -> status.append("'").append(p).append("',"));
			status.deleteCharAt(status.length() - 1);
			status.append(")");
			whereStr.append(" and status in ").append(status);
		}
		if (serviceReqSearchCriteria.getCategory() != null && !serviceReqSearchCriteria.getCategory().isEmpty()) {
			StringBuilder category = new StringBuilder("(");
			serviceReqSearchCriteria.getCategory().stream().forEach(p -> category.append("'").append(p).append("',"));
			category.deleteCharAt(category.length() - 1);
			category.append(")");
			whereStr.append(" and category in ").append(category);
		}

		whereStr.append(") as services) services");
		query = query + whereStr.toString();
		log.info("Complaint Type wise report Count query: " + query);
		return query;
	}

	public List<Grievence> fetchGrievenceDetails(ServiceReqSearchCriteria serviceReqSearchCriteria) {
		Map<String, Object> preparedStatementValues = new HashMap<>();
		String query = getGrievenceDetailsQuery(serviceReqSearchCriteria);
		List<Grievence> grivence = null;
		try {
			grivence = namedParameterJdbcTemplate.query(query, preparedStatementValues, grivenceDataRowMapper);
		} catch (DataAccessResourceFailureException ex) {
			log.info("Query Execution Failed Due To Timeout: ", ex);
			PSQLException cause = (PSQLException) ex.getCause();
			if (cause != null && cause.getSQLState().equals("57014")) {
				throw new CustomException("QUERY_EXECUTION_TIMEOUT", "Query failed, as it took more than expected");
			} else {
				throw ex;
			}
		} catch (Exception e) {
			log.info("Query Execution Failed: ", e);
			throw e;
		}
		return grivence;

	}

	public String getGrievenceDetailsQuery(ServiceReqSearchCriteria serviceReqSearchCriteria) {
		String query = GRIEVENCE_SEARCH;
		StringBuilder whereStr = new StringBuilder();

		if (serviceReqSearchCriteria.getTenantId() != null && !serviceReqSearchCriteria.getTenantId().isEmpty()) {
			whereStr.append(" tenantid=").append("'" + serviceReqSearchCriteria.getTenantId() + "'");
		}
		if (serviceReqSearchCriteria.getStartDate() != null && serviceReqSearchCriteria.getStartDate() != 0) {
			whereStr.append(" and to_timestamp(cast(createdtime/1000 as bigint))::date >=")
					.append("to_timestamp(cast(" + serviceReqSearchCriteria.getStartDate() + "/1000 as bigint))::date");
		}
		if (serviceReqSearchCriteria.getEndDate() != null && serviceReqSearchCriteria.getEndDate() != 0) {
			whereStr.append(" and to_timestamp(cast(createdtime/1000 as bigint))::date <=")
					.append("to_timestamp(cast(" + serviceReqSearchCriteria.getEndDate() + "/1000 as bigint))::date");
		}

		if (serviceReqSearchCriteria.getTenantId() != null && !serviceReqSearchCriteria.getTenantId().isEmpty()) {
			whereStr.append(" and \"source\" is not null");
		}

		if (serviceReqSearchCriteria.getTenantId() != null && !serviceReqSearchCriteria.getTenantId().isEmpty()) {
			whereStr.append(" and category is not null ");
		}
		whereStr.append(" group by servicecode,category,status,\"source\" ");
		query = query + whereStr.toString();
		log.info("Grience Report query: " + query);
		return query;
	}
}
