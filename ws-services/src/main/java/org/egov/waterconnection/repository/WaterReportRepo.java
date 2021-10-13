package org.egov.waterconnection.repository;

import java.util.List;

import org.egov.waterconnection.model.BillGeneration;
import org.egov.waterconnection.repository.builder.WsQueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class WaterReportRepo {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private WsQueryBuilder wsQueryBuilder;

	public List<BillGeneration> getPiechartData(BillGeneration waterReport) {
		List<BillGeneration> waterReportList;

		waterReportList = jdbcTemplate.query(wsQueryBuilder.GET_PIECHART_DATA, new Object[] {waterReport.getFromDate(),waterReport.getToDate()},
			new BeanPropertyRowMapper<BillGeneration>(BillGeneration.class));
	return waterReportList;}
}
