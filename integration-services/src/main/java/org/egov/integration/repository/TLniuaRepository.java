
package org.egov.integration.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.egov.integration.model.MinistryMaster;
import org.egov.integration.model.RequestData;
import org.egov.integration.model.RtiRequestInfoWrapper;
import org.egov.integration.model.TLDashboardRequestInfoWrapper;
import org.egov.integration.model.TLPublicDashboard;
import org.egov.integration.model.TLPublicDashboardRequest;
import org.egov.integration.repository.builder.RtiQueryBuilder;
import org.egov.integration.repository.builder.TLQueryBuilderNIUA;
import org.egov.integration.repository.rowmapper.RtiRowMapper;
import org.egov.integration.repository.rowmapper.TLPublicDashboardRowMapper;
import org.egov.integration.repository.rowmapper.TLRowMapperNIUA;
import org.egov.integration.model.Metrics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TLniuaRepository {
	private JdbcTemplate jdbcTemplate;

	private RtiRowMapper rowMapper;

	@Autowired
	private TLQueryBuilderNIUA queryBuilder;

	@Autowired
	private TLRowMapperNIUA rowMapperNIUA;

	@Autowired
	private TLPublicDashboardRowMapper dashboardRowMapper;

	@Autowired
	public NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Autowired
	public TLniuaRepository(JdbcTemplate jdbcTemplate, RtiRowMapper rowMapper) {
		this.jdbcTemplate = jdbcTemplate;
		this.rowMapper = rowMapper;
	}

	public Metrics getLicensesNIUA(RequestData criteria) {
		List<Object> preparedStmtList = new ArrayList<>();
		String query = queryBuilder.getTLSearchQuery(criteria, preparedStmtList);
//	        log.info("Query: " + query);
		Metrics query2 = jdbcTemplate.query(query, preparedStmtList.toArray(), rowMapperNIUA);
//	        sortChildObjectsById(licenses);
		return query2;
	}

	public TLPublicDashboard publicDashboard(TLPublicDashboardRequest tlPublicDashboardRequest) {
		TLPublicDashboard dashboard = null;
		List<Object> preparedStmtList = new ArrayList<>();
		String query = queryBuilder.getTLPublicDashboardSearchQuery(tlPublicDashboardRequest, preparedStmtList);
		dashboard = jdbcTemplate.query(query, preparedStmtList.toArray(), dashboardRowMapper);
		return dashboard;
	}
}
