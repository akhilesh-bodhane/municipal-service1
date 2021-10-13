
package org.egov.nulm.repository;

import java.util.ArrayList;
import java.util.List;

import org.egov.common.contract.request.Role;
import org.egov.nulm.common.CommonConstants;
import org.egov.nulm.config.NULMConfiguration;
import org.egov.nulm.model.NulmSepRequest;
import org.egov.nulm.model.NulmSmidRequest;
import org.egov.nulm.model.SepApplication;
import org.egov.nulm.model.SmidApplication;
import org.egov.nulm.producer.Producer;
import org.egov.nulm.repository.builder.NULMQueryBuilder;
import org.egov.nulm.repository.rowmapper.SMIDRowMapper;
import org.egov.tracer.model.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class SmidRepository {

	private JdbcTemplate jdbcTemplate;

	private Producer producer;

	private NULMConfiguration config;

	private SMIDRowMapper smidrowMapper;

	@Autowired
	public SmidRepository(JdbcTemplate jdbcTemplate, Producer producer, NULMConfiguration config,
			SMIDRowMapper smidrowMapper) {
		this.jdbcTemplate = jdbcTemplate;
		this.producer = producer;
		this.config = config;
		this.smidrowMapper = smidrowMapper;
	}

	public void createSMIDApplication(SmidApplication smidApplication) {
		NulmSmidRequest infoWrapper = NulmSmidRequest.builder().nulmSmidRequest(smidApplication).build();
		producer.push(config.getSMIDApplicationSaveTopic(), infoWrapper);
	}

	public void updateSMIDApplication(SmidApplication smidApplication) {
		NulmSmidRequest infoWrapper = NulmSmidRequest.builder().nulmSmidRequest(smidApplication).build();
		producer.push(config.getSMIDApplicationUpdateTopic(), infoWrapper);
	}

	public List<SmidApplication> getSMIDApplication(SmidApplication smidApplication, List<Role> role, Long userId) {
		List<SmidApplication> smid = new ArrayList<>();
		try {
			for (Role roleobj : role) {
				if ((roleobj.getCode()).equalsIgnoreCase(config.getRoleEmployee())) {
					return smid = jdbcTemplate.query(NULMQueryBuilder.GET_SMID_APPLICATION_QUERY,
							new Object[] { smidApplication.getApplicationId(), smidApplication.getApplicationId(),
									"", "", smidApplication.getTenantId(),
									smidApplication.getApplicationStatus() == null ? ""
											: smidApplication.getApplicationStatus().toString(),
									smidApplication.getApplicationStatus() == null ? ""
											: smidApplication.getApplicationStatus().toString(),
									smidApplication.getFromDate(), smidApplication.getFromDate(),
									smidApplication.getToDate(), smidApplication.getToDate(),
									smidApplication.getName(),smidApplication.getName(),
									smidApplication.getApplicationStatus() == null ? SmidApplication.StatusEnum.DRAFTED.toString()
											: ""},
							smidrowMapper);
				}
			}

			return smid = jdbcTemplate.query(NULMQueryBuilder.GET_SMID_APPLICATION_QUERY,
					new Object[] { smidApplication.getApplicationId(), smidApplication.getApplicationId(),
							userId.toString(), userId.toString(), smidApplication.getTenantId(),
							smidApplication.getApplicationStatus() == null ? ""
									: smidApplication.getApplicationStatus().toString(),
							smidApplication.getApplicationStatus() == null ? ""
									: smidApplication.getApplicationStatus().toString(),
							smidApplication.getFromDate(), smidApplication.getFromDate(), smidApplication.getToDate(),
							smidApplication.getToDate(),smidApplication.getName(),smidApplication.getName(),"" },
					smidrowMapper);

		} catch (Exception e) {
			e.printStackTrace();
			throw new CustomException(CommonConstants.ROLE, e.getMessage());
		}

	}

	public void updateSMIDApplicationStatus(SmidApplication smidapplication) {
		NulmSmidRequest infoWrapper = NulmSmidRequest.builder().nulmSmidRequest(smidapplication).build();
		producer.push(config.getSMIDApplicationUpdateStatusTopic(), infoWrapper);
	}
}
