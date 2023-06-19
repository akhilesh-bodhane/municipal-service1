package org.egov.pm.repository;

import org.egov.pm.model.IUDXRequestData;
import org.egov.pm.model.IUDXServiceData;
import org.egov.pm.repository.querybuilder.QueryBuilder;
import org.egov.pm.repository.rowmapper.IUDXDataRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class GeneralReportNocRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private IUDXDataRowMapper iudxDataRowMapper;

	public IUDXServiceData getIUDXNOCDATARepository(IUDXRequestData iudxRequestData) {
		return jdbcTemplate.query(QueryBuilder.SELECT_IUDX_NOC_DATA_QUERY,
				new Object[] { iudxRequestData.getRequestData().getTenantId(),
						iudxRequestData.getRequestData().getFromDate(), iudxRequestData.getRequestData().getToDate() },
				iudxDataRowMapper);
	}
}
