package org.egov.ec.repository;

import java.util.LinkedList;
import java.util.List;

import org.egov.ec.config.EchallanConfiguration;
import org.egov.ec.producer.Producer;
import org.egov.ec.repository.builder.EcQueryBuilder;
import org.egov.ec.web.models.EcSearchCriteria;
import org.egov.ec.web.models.FineMaster;
import org.egov.ec.web.models.RequestInfoWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class FineMasterRepository {

	private JdbcTemplate jdbcTemplate;

	private Producer producer;

	private EchallanConfiguration config;

	@Autowired
	public FineMasterRepository(JdbcTemplate jdbcTemplate, Producer producer, EchallanConfiguration config) {
		this.jdbcTemplate = jdbcTemplate;
		this.producer = producer;
		this.config = config;
	}

	/**
	 * Pushes the request in save fine Topic for auction approval
	 *
	 * @param fineMaster Fine master model
	 */
	public void saveFine(FineMaster fineMaster) {
		log.info("FineMaster Repository - saveFine Method");
		RequestInfoWrapper infoWrapper = RequestInfoWrapper.builder().requestBody(fineMaster).build();
		producer.push(config.getFineMasterSaveTopic(), infoWrapper);

	}

	/**
	 * fetches the list of FineMaster according to role
	 *
	 * @param infoWrapper Requestinfowrapper with requestinfo and request body
	 * @return Returns the list of FineMaster Details
	 */
	public List<FineMaster> getFine(RequestInfoWrapper infoWrapper) {
		log.info("FineMaster Repository - getFine Method");
		List<FineMaster> finelist;

		List<String> roleCodes = new LinkedList<>();
		infoWrapper.getRequestInfo().getUserInfo().getRoles().forEach(role -> {
			roleCodes.add(role.getCode());
		});
		if (roleCodes.contains("challanEAO")) {

			finelist = jdbcTemplate.query(EcQueryBuilder.GET_FINE_MASTER,
					new Object[] { infoWrapper.getRequestInfo().getUserInfo().getTenantId() },
					new BeanPropertyRowMapper<FineMaster>(FineMaster.class));
			return finelist;

		} else {
			finelist = jdbcTemplate.query(EcQueryBuilder.GET_FINE_MASTER_PENDING,
					new Object[] { infoWrapper.getRequestInfo().getUserInfo().getTenantId() },
					new BeanPropertyRowMapper<FineMaster>(FineMaster.class));
			return finelist;
		}

	}

	/**
	 * Pushes the request in update Fine Topic for fine master update
	 *
	 * @param fineMaster FineMaster Update request
	 */
	public void updateFine(FineMaster fineMaster) {
		log.info("FineMaster Repository - updateFine Method");
		RequestInfoWrapper infoWrapper = RequestInfoWrapper.builder().requestBody(fineMaster).build();
		producer.push(config.getFineMasterupdateTopic(), infoWrapper);

	}

	/**
	 * Fetches the list of challan applicable for store charges and adds penalty
	 * amount to it.
	 * 
	 * @param ecSearchCriteria
	 *
	 */
	public void updatePenaltyAmount(EcSearchCriteria ecSearchCriteria) {
		log.info("FineMaster Repository - updatePenaltyAmount Method");
		List<FineMaster> finelist;
		finelist = jdbcTemplate.query(EcQueryBuilder.GET_PENALTY_VIOLATIONS,
				new Object[] { ecSearchCriteria.getTenantId() },
				new BeanPropertyRowMapper<FineMaster>(FineMaster.class));
		if (!finelist.isEmpty()) {
			RequestInfoWrapper infoWrapper = RequestInfoWrapper.builder().requestBody(finelist).build();
			producer.push(config.getUpdatePenaltyAmountTopic(), infoWrapper);
		}
	}

}
