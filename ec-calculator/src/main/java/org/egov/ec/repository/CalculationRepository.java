package org.egov.ec.repository;

import org.egov.ec.repository.builder.CalculationQueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class CalculationRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public Double getFineAmount(String challanNumber, String tenantId) {
		System.out.println("Challan"+challanNumber);
		System.out.println("TEN"+tenantId);
		Double fine= jdbcTemplate.queryForObject(CalculationQueryBuilder.GET_CHALLAN_FINE,
				new Object[] { challanNumber }, Double.class);
		return fine;
	}
	
	public Double getPenaltyAmount(String challanNumber, String tenantId) {
		System.out.println("Challan"+challanNumber);
		System.out.println("TEN"+tenantId);
		Double fine= jdbcTemplate.queryForObject(CalculationQueryBuilder.GET_CHALLAN_PENALTY,
				new Object[] { challanNumber }, Double.class);
		return fine;
	}

}
