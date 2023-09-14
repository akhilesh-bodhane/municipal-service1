
package org.egov.nulm.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.egov.common.contract.request.Role;
import org.egov.nulm.common.CommonConstants;
import org.egov.nulm.config.NULMConfiguration;
import org.egov.nulm.model.Organization;
import org.egov.nulm.model.OrganizationRequest;
import org.egov.nulm.producer.Producer;
import org.egov.nulm.repository.builder.NULMQueryBuilder;
import org.egov.nulm.repository.rowmapper.OrganizationRowMapper;
import org.egov.tracer.model.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class OrganizationRepository {

	private JdbcTemplate jdbcTemplate;

	private Producer producer;

	private NULMConfiguration config;
	
	private OrganizationRowMapper organizationRowMapper;
	
	@Autowired
	public OrganizationRepository(JdbcTemplate jdbcTemplate, Producer producer, NULMConfiguration config, OrganizationRowMapper organizationRowMapper

	) {
		this.jdbcTemplate = jdbcTemplate;
		this.producer = producer;
		this.config = config;
		this.organizationRowMapper=organizationRowMapper;

	}

	public void createOrganization(Organization request) {
		OrganizationRequest infoWrapper = OrganizationRequest.builder().organizationRequest(request).build();
		producer.push(config.getOrganizationCreateTopic(), infoWrapper);
	}

	public void checkMobileNo(Organization request) {
		Map<String, String> errorMap = new HashMap<>();
		int i = 0;
		i = jdbcTemplate.queryForObject(NULMQueryBuilder.GET_ORGANIZATION_MOBILE_NO_QUERY,
				new Object[] { request.getTenantId(), request.getMobileNo() }, Integer.class);

		if (i > 0) {
			errorMap.put(CommonConstants.INVALID_ORGANIZATION_REQUEST,
					CommonConstants.INVALID_ORGANIZATION_REQUEST_MOBILE_MESSAGE);
			throw new CustomException(errorMap);
		}
	}

	public void checkOrganizationName(Organization request) {
		Map<String, String> errorMap = new HashMap<>();
		int i = 0;
		i = jdbcTemplate.queryForObject(NULMQueryBuilder.GET_ORGANIZATION_NAME_QUERY,
				new Object[] { request.getTenantId(), request.getOrganizationName() }, Integer.class);

		if (i > 0) {
			errorMap.put(CommonConstants.INVALID_ORGANIZATION_REQUEST,
					CommonConstants.INVALID_ORGANIZATION_REQUEST_ORG_NAME_MESSAGE);
			throw new CustomException(errorMap);
		}
	}
	public List<Organization> getOrganization(Organization request, List<Role> role,
			Long userId) {
		List<Organization> smid = new ArrayList<>();
		try {
			for (Role roleobj : role) {
				if ((roleobj.getCode()).equalsIgnoreCase(config.getRoleEmployee())) {
					 smid = jdbcTemplate.query(NULMQueryBuilder.GET_ORGANIZATION_QUERY,
							new Object[] { request.getTenantId(),request.getOrganizationUuid(),request.getOrganizationUuid(),
									request.getOrganizationName(),request.getOrganizationName(),
									request.getRegistrationNo(),request.getRegistrationNo(),
									request.getFromDate(),request.getFromDate(),
									request.getToDate(),request.getToDate()},
							organizationRowMapper);

				}
			}
			

		} catch (Exception e) {
			e.printStackTrace();
			throw new CustomException(CommonConstants.ROLE, e.getMessage());
		}
		return smid;

	}

}
