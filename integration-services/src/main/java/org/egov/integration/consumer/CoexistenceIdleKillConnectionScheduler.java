package org.egov.integration.consumer;

import java.util.ArrayList;
import java.util.List;

import org.egov.integration.config.ApiConfiguration;
import org.egov.integration.repository.FireRepositoryV2;
import org.egov.integration.repository.builder.QueryBuilder;
import org.egov.integration.repository.rowmapper.CoexistenceIdleKillConnectionsRowMapper;
import org.egov.integration.repository.rowmapper.IdleKillConnectionsRowMapper;
import org.egov.integration.service.FireServiceV2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class CoexistenceIdleKillConnectionScheduler {

	@Autowired
	private ApiConfiguration apiConfiguration;

	@Autowired
	private FireRepositoryV2 fireRepositoryV2;

	@Autowired
	private FireServiceV2 fireServiceV2;

	@Autowired
	private ObjectMapper mapper;

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private QueryBuilder QueryBuilder;
	
	
	@Autowired
	private CoexistenceIdleKillConnectionsRowMapper coexistenceIdleKillConnectionsRowMapper ;

	@Scheduled(cron = "0 */20 * * * *", zone = "Asia/Calcutta")
	public void coexistenceidleKillConnectionData() {
		System.out.println("coexistenceidleKillConnectionData Cro Started ");
				
		try {
			
			String idleKillConnectionsCount = getCoexistenceIdleKillConnectionsCount();
			System.out.println("Coexistence Idle Connections Kill Count :"+idleKillConnectionsCount);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public String getCoexistenceIdleKillConnectionsCount() {
		List<Object> preparedStatement = new ArrayList<>();
		
		String query = QueryBuilder.getCoexistenceIdleConnectionKillCount(preparedStatement);
				
		String idleconnectioncount = jdbcTemplate.query(query, preparedStatement.toArray(),
				coexistenceIdleKillConnectionsRowMapper);

		return idleconnectioncount;
	}
}
