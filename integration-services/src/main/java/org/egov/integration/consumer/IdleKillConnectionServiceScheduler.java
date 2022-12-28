package org.egov.integration.consumer;

import java.util.ArrayList;
import java.util.List;

import org.egov.integration.config.ApiConfiguration;
import org.egov.integration.repository.FireRepositoryV2;
import org.egov.integration.repository.builder.QueryBuilder;
import org.egov.integration.repository.rowmapper.IdleKillConnectionsRowMapper;
import org.egov.integration.service.FireServiceV2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class IdleKillConnectionServiceScheduler {

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
	private IdleKillConnectionsRowMapper idleKillConnectionsRowMapper ;

	@Scheduled(cron = "0 */15 * * * *", zone = "Asia/Calcutta") // Every day at 01:01 AM
	public void idleKillConnectionServiceData() {
		System.out.println("idleKillConnectionServiceData Cro Started ");
				
		try {
			
			String idleKillConnectionsCount = getIdleKillConnectionsCount();
			System.out.println("Idle Connections Kill Count :"+idleKillConnectionsCount);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public String getIdleKillConnectionsCount() {
		List<Object> preparedStatement = new ArrayList<>();
		
		String query = QueryBuilder.getIdleConnectionKillCount(preparedStatement);
				
		String idleconnectioncount = jdbcTemplate.query(query, preparedStatement.toArray(),
				idleKillConnectionsRowMapper);

		return idleconnectioncount;
	}
}
