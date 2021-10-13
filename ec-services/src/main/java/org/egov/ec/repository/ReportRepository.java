package org.egov.ec.repository;

import java.util.LinkedList;
import java.util.List;

import javax.validation.Valid;

import org.egov.ec.config.EchallanConfiguration;
import org.egov.ec.producer.Producer;
import org.egov.ec.repository.builder.EcQueryBuilder;
import org.egov.ec.web.models.DashboardDetails;
import org.egov.ec.web.models.Report;
import org.egov.ec.web.models.RequestInfoWrapper;
import org.egov.ec.web.models.StoreItemRegister;
import org.egov.tracer.model.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class ReportRepository {
	private JdbcTemplate jdbcTemplate;

	private Producer producer;
	private final ObjectMapper objectMapper;
	private EchallanConfiguration config;

	@Autowired
	public ReportRepository(ObjectMapper objectMapper,JdbcTemplate jdbcTemplate, Producer producer, EchallanConfiguration config) {
		this.objectMapper = objectMapper;
		this.jdbcTemplate = jdbcTemplate;
		this.producer = producer;
		this.config = config;
	}

	/**
	 * fetches the Report details according to report type
	 *
	 * @param Report Report Model
	 * @return Returns the list of Report Details
	 */
	public List<Report> getReport(@Valid Report reportData) {
		log.info("Report Repository - getReport Method");
		List<Report> reportList = null;

		switch (reportData.getReportType()) {
		case "Payment":
			reportList = jdbcTemplate.query(EcQueryBuilder.GET_PAYMENT_REPORT,
					new Object[] { reportData.getFromDate(), reportData.getToDate(), reportData.getPaymentStatus(),
							reportData.getPaymentStatus(), reportData.getTenantId() },

					new BeanPropertyRowMapper<Report>(Report.class));
			return reportList;

		case "Seizure":
			reportList = jdbcTemplate.query(EcQueryBuilder.GET_SEIZURE_REPORT,
					new Object[] { reportData.getFromDate(), reportData.getToDate(), reportData.getSiName(),
							reportData.getSiName(), reportData.getEncroachmentType(), reportData.getEncroachmentType(),
							reportData.getSector(), reportData.getSector(), reportData.getChallanStatus(), reportData.getChallanStatus(), reportData.getTenantId() },

					new BeanPropertyRowMapper<Report>(Report.class));
			return reportList;

		case "Item Age":
			if (reportData.getItemsAgeFrom().equalsIgnoreCase("0")) {
				reportList = jdbcTemplate.query(EcQueryBuilder.GET_ITEM_AGING_REPORT1,
						new Object[] { reportData.getTenantId() },

						new BeanPropertyRowMapper<Report>(Report.class));
			}
			if (reportData.getItemsAgeFrom().equalsIgnoreCase("11")) {
				reportList = jdbcTemplate.query(EcQueryBuilder.GET_ITEM_AGING_REPORT2,
						new Object[] { reportData.getTenantId() },

						new BeanPropertyRowMapper<Report>(Report.class));
			}
			if (reportData.getItemsAgeFrom().equalsIgnoreCase("21")) {
				reportList = jdbcTemplate.query(EcQueryBuilder.GET_ITEM_AGING_REPORT3,
						new Object[] { reportData.getTenantId() },

						new BeanPropertyRowMapper<Report>(Report.class));
			}
			if (reportData.getItemsAgeFrom().equalsIgnoreCase("30")) {
				reportList = jdbcTemplate.query(EcQueryBuilder.GET_ITEM_AGING_REPORT4,
						new Object[] { reportData.getTenantId() },

						new BeanPropertyRowMapper<Report>(Report.class));
			}
			if (reportData.getItemsAgeFrom().equalsIgnoreCase("All")) {
				reportList = jdbcTemplate.query(EcQueryBuilder.GET_ITEM_AGING_REPORT5,
						new Object[] { reportData.getTenantId() },

						new BeanPropertyRowMapper<Report>(Report.class));
			}
			return reportList;

		default:
			log.error("Incorrect report type", reportData.getReportType());
			throw new CustomException("Incorrect report type", reportData.getReportType());

		}

	}

	/**
	 * fetches the details required to show on dashboard according to rolewise
	 *
	 * @param requestInfoWrapper DashboardDetails Model
	 * @return Returns the list of DashboardDetails
	 */
	public List<DashboardDetails> getDashboard(RequestInfoWrapper requestInfoWrapper) {
		log.info("Report Repository - getDashboard Method");
		DashboardDetails reportData = objectMapper.convertValue(requestInfoWrapper.getRequestBody(), DashboardDetails.class);
		List<String> roleCodes = new LinkedList<>();
		requestInfoWrapper.getRequestInfo().getUserInfo().getRoles().forEach(role -> {
			roleCodes.add(role.getCode());
		});
		List<DashboardDetails> dashboardDetails = null;
		if (roleCodes.contains("challanSI") && !roleCodes.contains("challanSM") && !roleCodes.contains("challanHOD")) {
			dashboardDetails = jdbcTemplate.query(EcQueryBuilder.GET_DASHBOARD_DETAILS_SI,
					new Object[] { reportData.getTenantId() },
					new BeanPropertyRowMapper<DashboardDetails>(DashboardDetails.class));
		}
		else if (roleCodes.contains("challanSM")&& !roleCodes.contains("challanSI") && !roleCodes.contains("challanHOD")) {
			dashboardDetails = jdbcTemplate.query(EcQueryBuilder.GET_DASHBOARD_DETAILS_SM,
					new Object[] { reportData.getTenantId(), reportData.getTenantId() },
					new BeanPropertyRowMapper<DashboardDetails>(DashboardDetails.class));
		}
		else if (roleCodes.contains("challanHOD")&& !roleCodes.contains("challanSM") && !roleCodes.contains("challanSI")) {
			dashboardDetails = jdbcTemplate.query(EcQueryBuilder.GET_DASHBOARD_DETAILS_HOD,
					new Object[] { reportData.getTenantId(), reportData.getTenantId(),
							reportData.getTenantId() },
					new BeanPropertyRowMapper<DashboardDetails>(DashboardDetails.class));
		}
		else if (roleCodes.contains("challanSI")&& roleCodes.contains("challanSM") && !roleCodes.contains("challanHOD")) {
			dashboardDetails = jdbcTemplate.query(EcQueryBuilder.GET_DASHBOARD_DETAILS_SI_SM,
					new Object[] { reportData.getTenantId(), reportData.getTenantId() },
					new BeanPropertyRowMapper<DashboardDetails>(DashboardDetails.class));
		}
		else if (roleCodes.contains("challanSI")&& roleCodes.contains("challanHOD") && !roleCodes.contains("challanSM")) {
			dashboardDetails = jdbcTemplate.query(EcQueryBuilder.GET_DASHBOARD_DETAILS_SI_HOD,
					new Object[] { reportData.getTenantId(), reportData.getTenantId(),
							reportData.getTenantId() },
					new BeanPropertyRowMapper<DashboardDetails>(DashboardDetails.class));
		}
		else if (roleCodes.contains("challanHOD")&& roleCodes.contains("challanSM") && !roleCodes.contains("challanSI")) {
			dashboardDetails = jdbcTemplate.query(EcQueryBuilder.GET_DASHBOARD_DETAILS_SM_HOD,
					new Object[] { reportData.getTenantId(), reportData.getTenantId(),
							reportData.getTenantId() ,reportData.getTenantId()},
					new BeanPropertyRowMapper<DashboardDetails>(DashboardDetails.class));
		}
		else if (roleCodes.contains("challanHOD")&&  roleCodes.contains("challanSM") &&  roleCodes.contains("challanSI")) {
			dashboardDetails = jdbcTemplate.query(EcQueryBuilder.GET_DASHBOARD_DETAILS_SI_SM_HOD,
					new Object[] { reportData.getTenantId(), reportData.getTenantId(),
							reportData.getTenantId() ,reportData.getTenantId()},
					new BeanPropertyRowMapper<DashboardDetails>(DashboardDetails.class));
		}
		return dashboardDetails;
	}
}
