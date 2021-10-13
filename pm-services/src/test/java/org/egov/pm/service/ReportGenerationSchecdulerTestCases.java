package org.egov.pm.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.egov.pm.model.ReportModel;
import org.egov.pm.repository.NocRepository;
import org.egov.pm.repository.rowmapper.ReportRowMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

@RunWith(MockitoJUnitRunner.class)
public class ReportGenerationSchecdulerTestCases {

	@InjectMocks
	ReportGenerationSchecduler reportGenerationSchecduler;

	@Mock
	private JdbcTemplate jdbcTemplate;

	@Mock
	private ReportRowMapper reportRowMapper;

	@InjectMocks
	private NocRepository nocRepository;

	@Test
	public void testScheduleTask() {

		ReportModel value = ReportModel.builder().build();
		value.setTotalAveragePendingGreaterThan30Days("12");
		value.setTotalAveragePending10DayasTo30Days("154");
		value.setTotalAverage("154");
		value.setTenantId("ch");
		value.setApplicationType("NOCTYPE");
		List<ReportModel> listOfResult = new ArrayList<>();

		when(jdbcTemplate.query(Matchers.anyString(), any(Object[].class), any(ReportRowMapper.class)))
				.thenReturn(listOfResult);

		reportGenerationSchecduler.scheduleTask();

	}

}
