package org.egov.pm.service;

import java.util.List;

import org.egov.pm.model.ReportModel;
import org.egov.pm.repository.NocRepository;
import org.egov.pm.repository.querybuilder.QueryBuilder;
import org.egov.pm.repository.rowmapper.ReportRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class ReportGenerationSchecduler {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private ReportRowMapper reportRowMapper;

	@Autowired
	private NocRepository nocRepository;

	public void scheduleTask() {
		log.info("Started Generate Average Processing Time Report - " + System.currentTimeMillis() / 1000);
		List<ReportModel> listOfResult = jdbcTemplate.query(QueryBuilder.GET_NOC_AVERAGE_TIME_QUERY, new Object[] {},
				reportRowMapper);
		if (!listOfResult.isEmpty())
			nocRepository.generateReport(listOfResult);
		log.info("Ended Generate Average Processing Time Report - " + System.currentTimeMillis() / 1000);
	}
}
