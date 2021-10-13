
package org.egov.nulm.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.egov.common.contract.request.Role;
import org.egov.nulm.common.CommonConstants;
import org.egov.nulm.config.NULMConfiguration;
import org.egov.nulm.model.NulmSusvRequest;
import org.egov.nulm.model.SmidShgGroup;
import org.egov.nulm.model.SuhApplication;
import org.egov.nulm.model.SusvApplication;
import org.egov.nulm.producer.Producer;
import org.egov.nulm.repository.builder.NULMQueryBuilder;
import org.egov.nulm.repository.rowmapper.SusvRowMapper;
import org.egov.tracer.model.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class SusvRepository {

	private JdbcTemplate jdbcTemplate;

	private Producer producer;

	private NULMConfiguration config;

	private SusvRowMapper susvrowMapper;
	
	@Autowired
	public NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Autowired
	public SusvRepository(JdbcTemplate jdbcTemplate, Producer producer, NULMConfiguration config,
			SusvRowMapper susvrowMapper) {
		this.jdbcTemplate = jdbcTemplate;
		this.producer = producer;
		this.config = config;
		this.susvrowMapper = susvrowMapper;
	}

	public void createSusvApplication(SusvApplication susvApplication) {
		NulmSusvRequest infoWrapper = NulmSusvRequest.builder().nulmSusvRequest(susvApplication).build();
		producer.push(config.getSusvApplicationSaveTopic(), infoWrapper);
	}
	
	public void updateSusvApplication(SusvApplication susvApplication) {
		NulmSusvRequest infoWrapper = NulmSusvRequest.builder().nulmSusvRequest(susvApplication).build();
		producer.push(config.getSusvApplicationUpdateTopic(), infoWrapper);
	}
	public void updateSusvApplicationStatus(SusvApplication susvApplication) {
		NulmSusvRequest infoWrapper = NulmSusvRequest.builder().nulmSusvRequest(susvApplication).build();
		producer.push(config.getSusvApplicationUpdateStatusTopic(), infoWrapper);
	}
	
	public List<SusvApplication> getSusvApplication(SusvApplication request, List<Role> role,
			Long userId) {
		List<SusvApplication> susv = new ArrayList<>();
		Map<String, Object> paramValues = new HashMap<>();
		paramValues.put("tenantId", request.getTenantId());
		paramValues.put("fromDate", request.getFromDate());
		paramValues.put("toDate", request.getToDate());
		paramValues.put("nameOfApplicant", request.getNameOfApplicant());
		try {
			for (Role roleobj : role) {
				if ((roleobj.getCode()).equalsIgnoreCase(config.getRoleCitizenUser())) {
					
					paramValues.put("createdBy",userId.toString());
					paramValues.put("applicationId", request.getApplicationId());
					List<Object> statusEmplyee = new ArrayList<>();
					if (request.getApplicationStatus() == null) {
						statusEmplyee.add(SusvApplication.StatusEnum.APPROVED.toString());
						statusEmplyee.add(SusvApplication.StatusEnum.DRAFTED.toString());
						statusEmplyee.add(SusvApplication.StatusEnum.REJECTED.toString());
						statusEmplyee.add(SusvApplication.StatusEnum.CREATED.toString());
						statusEmplyee.add(SusvApplication.StatusEnum.FORWARDEDTOACMC.toString());
						statusEmplyee.add(SusvApplication.StatusEnum.FORWARDEDTOJA.toString());
						statusEmplyee.add(SusvApplication.StatusEnum.FORWARDEDTOSDO.toString());
						statusEmplyee.add(SusvApplication.StatusEnum.REASSIGNTOJA.toString());
						statusEmplyee.add(SusvApplication.StatusEnum.REASSIGNTOSDO.toString());
						statusEmplyee.add(SusvApplication.StatusEnum.REASSIGNTOCITIZEN.toString());
						
					} else {
						statusEmplyee.add(request.getApplicationStatus().toString());
					}
					paramValues.put("applicationStaus",statusEmplyee);
					return susv = namedParameterJdbcTemplate.query(NULMQueryBuilder.GET_SUSV_QUERY, paramValues,
							susvrowMapper);
				}
			}
			List<Object> statusEmplyee = new ArrayList<>();
			if (request.getApplicationStatus() == null) {
				statusEmplyee.add(SusvApplication.StatusEnum.APPROVED.toString());
				statusEmplyee.add(SusvApplication.StatusEnum.REJECTED.toString());
				statusEmplyee.add(SusvApplication.StatusEnum.CREATED.toString());
				statusEmplyee.add(SusvApplication.StatusEnum.FORWARDEDTOACMC.toString());
				statusEmplyee.add(SusvApplication.StatusEnum.FORWARDEDTOJA.toString());
				statusEmplyee.add(SusvApplication.StatusEnum.FORWARDEDTOSDO.toString());
				statusEmplyee.add(SusvApplication.StatusEnum.REASSIGNTOJA.toString());
				statusEmplyee.add(SusvApplication.StatusEnum.REASSIGNTOSDO.toString());
				statusEmplyee.add(SusvApplication.StatusEnum.REASSIGNTOCITIZEN.toString());
				
			} else {
				statusEmplyee.add(request.getApplicationStatus().toString());
			}
			paramValues.put("applicationStaus",statusEmplyee);
			paramValues.put("createdBy","");
			paramValues.put("applicationId", request.getApplicationId());
			return susv = namedParameterJdbcTemplate.query(NULMQueryBuilder.GET_SUSV_QUERY, paramValues, susvrowMapper);
		

		} catch (Exception e) {
			e.printStackTrace();
			throw new CustomException(CommonConstants.ROLE, e.getMessage());
		}

	}
}
