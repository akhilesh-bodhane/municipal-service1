
package org.egov.nulm.repository;

import java.util.ArrayList;
import java.util.List;

import org.egov.common.contract.request.Role;
import org.egov.nulm.common.CommonConstants;
import org.egov.nulm.config.NULMConfiguration;
import org.egov.nulm.model.NulmSuhLogRequest;
import org.egov.nulm.model.SuhLogMaintenance;
import org.egov.nulm.producer.Producer;
import org.egov.nulm.repository.builder.NULMQueryBuilder;
import org.egov.nulm.repository.rowmapper.SuhLogRowMapper;
import org.egov.nulm.repository.rowmapper.SuhRowMapper;
import org.egov.tracer.model.CustomException;
import org.omg.PortableInterceptor.USER_EXCEPTION;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class SuhLogRepository {

	private JdbcTemplate jdbcTemplate;

	private Producer producer;

	private NULMConfiguration config;

	private SuhLogRowMapper suhLogrowMapper;
	@Autowired
	public NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Autowired
	public SuhLogRepository(JdbcTemplate jdbcTemplate, Producer producer, NULMConfiguration config,
			SuhLogRowMapper suhLogrowMapper) {
		this.jdbcTemplate = jdbcTemplate;
		this.producer = producer;
		this.config = config;
		this.suhLogrowMapper = suhLogrowMapper;
	}

	public void createSuhLog(SuhLogMaintenance log) {
		NulmSuhLogRequest infoWrapper = NulmSuhLogRequest.builder().nulmSuhLogRequest(log).build();
		producer.push(config.getSuhLogSaveTopic(), infoWrapper);
	}
	public List<SuhLogMaintenance> getSuhLog(SuhLogMaintenance suhLog, List<Role> role, Long userId) {
		List<SuhLogMaintenance> log = new ArrayList<>();
		try {
			for (Role roleobj : role) {
				if ((roleobj.getCode()).equalsIgnoreCase(config.getRoleEmployee())) {
					return log = jdbcTemplate.query(NULMQueryBuilder.GET_SUH_LOG_QUERY,
							new Object[] {suhLog.getLogUuid(),suhLog.getLogUuid(),"","",
									suhLog.getName(),suhLog.getName(),suhLog.getNameOfShelter(),suhLog.getNameOfShelter(),
									suhLog.getFromDate(),suhLog.getFromDate(),suhLog.getToDate(),suhLog.getToDate(),
									suhLog.getTenantId() },
							suhLogrowMapper);				}
			}

			return	log = jdbcTemplate.query(NULMQueryBuilder.GET_SUH_LOG_QUERY,
					new Object[] {suhLog.getLogUuid(),suhLog.getLogUuid(),userId.toString(),userId.toString(),
							suhLog.getName(),suhLog.getName(),suhLog.getNameOfShelter(),suhLog.getNameOfShelter(),
							suhLog.getFromDate(),suhLog.getFromDate(),suhLog.getToDate(),suhLog.getToDate(),
							suhLog.getTenantId() },
					suhLogrowMapper);
		} catch (Exception e) {
			e.printStackTrace();
			throw new CustomException(CommonConstants.ROLE, e.getMessage());
		}

	}
	public void deleteSuhLog(SuhLogMaintenance log) {
		NulmSuhLogRequest infoWrapper = NulmSuhLogRequest.builder().nulmSuhLogRequest(log).build();
		producer.push(config.getSuhLogDeleteTopic(), infoWrapper);
	}
	
	
	
}
