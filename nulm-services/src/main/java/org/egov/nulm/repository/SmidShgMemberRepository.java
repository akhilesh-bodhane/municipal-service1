
package org.egov.nulm.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.egov.common.contract.request.Role;
import org.egov.nulm.common.CommonConstants;
import org.egov.nulm.config.NULMConfiguration;
import org.egov.nulm.model.NulmShgMemberRequest;
import org.egov.nulm.model.SmidShgGroup;
import org.egov.nulm.model.SmidShgMemberApplication;
import org.egov.nulm.model.SuhApplication;
import org.egov.nulm.producer.Producer;
import org.egov.nulm.repository.builder.NULMQueryBuilder;
import org.egov.nulm.repository.rowmapper.ColumnsRowMapper;
import org.egov.nulm.repository.rowmapper.SMIDRowMapper;
import org.egov.nulm.repository.rowmapper.ShgMemberRowMapper;
import org.egov.tracer.model.CustomException;
import org.json.simple.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class SmidShgMemberRepository {

	private JdbcTemplate jdbcTemplate;

	private Producer producer;

	private NULMConfiguration config;

	private ShgMemberRowMapper shgMemberRowMapper;
	private ColumnsRowMapper columnsRowMapper;

	@Autowired
	public NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Autowired
	public SmidShgMemberRepository(JdbcTemplate jdbcTemplate, Producer producer, NULMConfiguration config,
			ShgMemberRowMapper shgMemberRowMapper, ColumnsRowMapper columnsRowMapper) {
		this.jdbcTemplate = jdbcTemplate;
		this.producer = producer;
		this.config = config;
		this.shgMemberRowMapper = shgMemberRowMapper;
		this.columnsRowMapper = columnsRowMapper;
	}

	public void createMembers(SmidShgMemberApplication smidApplication) {
		NulmShgMemberRequest infoWrapper = NulmShgMemberRequest.builder().SmidShgMemberApplication(smidApplication)
				.build();
		producer.push(config.getSmidShgMemberSaveTopic(), infoWrapper);
	}

	public void updateMembers(SmidShgMemberApplication smidApplication) {
		NulmShgMemberRequest infoWrapper = NulmShgMemberRequest.builder().SmidShgMemberApplication(smidApplication)
				.build();
		producer.push(config.getSmidShgMemberUpdateTopic(), infoWrapper);
	}

	public void deleteMembers(SmidShgMemberApplication smidApplication) {
		NulmShgMemberRequest infoWrapper = NulmShgMemberRequest.builder().SmidShgMemberApplication(smidApplication)
				.build();
		producer.push(config.getSmidShgMemberDeleteTopic(), infoWrapper);
	}
	public void hardDeleteMembers(SmidShgMemberApplication smidApplication) {
		NulmShgMemberRequest infoWrapper = NulmShgMemberRequest.builder().SmidShgMemberApplication(smidApplication)
				.build();
		producer.push(config.getSmidShgMemberHardDeleteTopic(), infoWrapper);
	}
	
	public void checkShgUuid(SmidShgMemberApplication smidapplication) {
		Map<String, String> errorMap = new HashMap<>();
		int i = 0;
		i = jdbcTemplate.queryForObject(NULMQueryBuilder.SHG_UUID_EXIST_QUERY,
				new Object[] { smidapplication.getShgUuid(), smidapplication.getTenantId() }, Integer.class);

		if (i == 0) {
			errorMap.put(CommonConstants.INVALID_SHG_UUID, CommonConstants.INVALID_SHG_UUID_MESSAGE);
			throw new CustomException(errorMap);
		}
	}

	public void checkMemberUuid(SmidShgMemberApplication smidapplication) {
		Map<String, String> errorMap = new HashMap<>();
		int i = 0;
		i = jdbcTemplate.queryForObject(NULMQueryBuilder.MEMBER_UUID_EXIST_QUERY,
				new Object[] { smidapplication.getApplicationUuid(), smidapplication.getTenantId() }, Integer.class);

		if (i == 0) {
			errorMap.put(CommonConstants.INVALID_MEMBER_UUID, CommonConstants.INVALID_MEMBER_UUID_MESSAGE);
			throw new CustomException(errorMap);
		}
	}

	public JSONArray getMemmberStatus(SmidShgMemberApplication shg) {
		JSONArray smid = new JSONArray();
		Map<String, Object> paramValues = new HashMap<>();

		try {
			paramValues.put("tenantId", shg.getTenantId());
			paramValues.put("applicationUuid", shg.getApplicationUuid());

			return smid = namedParameterJdbcTemplate.query(NULMQueryBuilder.GET_MEMBER_STATUS_QUERY, paramValues,
					columnsRowMapper);

		} catch (Exception e) {
			throw new CustomException(CommonConstants.ROLE, e.getMessage());
		}

	}

	public List<SmidShgMemberApplication> getMembers(SmidShgMemberApplication memberrequest, List<Role> role,
			Long userId) {
		List<SmidShgMemberApplication> smid = new ArrayList<>();
		try {
			for (Role roleobj : role) {
				if ((roleobj.getCode()).equalsIgnoreCase(config.getRoleEmployee())) {
					return smid = jdbcTemplate.query(NULMQueryBuilder.GET_SHG_MEMBER_QUERY,
							new Object[] { memberrequest.getApplicationId(), memberrequest.getApplicationId(), "",
									"", memberrequest.getTenantId(),
									memberrequest.getApplicationStatus() == null ? ""
											: memberrequest.getApplicationStatus().toString(),
									memberrequest.getApplicationStatus() == null ? ""
											: memberrequest.getApplicationStatus().toString(),
											memberrequest.getFromDate(), memberrequest.getFromDate(),
											memberrequest.getToDate(), memberrequest.getToDate(),
											memberrequest.getGroupName(),memberrequest.getGroupName(),
											memberrequest.getName(),memberrequest.getName(),
											memberrequest.getShgId(),memberrequest.getShgId()},
							shgMemberRowMapper);

				}
			}
			return smid = jdbcTemplate.query(NULMQueryBuilder.GET_SHG_MEMBER_QUERY,
					new Object[] { memberrequest.getApplicationId(), memberrequest.getApplicationId(),
							userId.toString(), userId.toString(), memberrequest.getTenantId(),
							memberrequest.getApplicationStatus() == null ? ""
									: memberrequest.getApplicationStatus().toString(),
							memberrequest.getApplicationStatus() == null ? ""
									: memberrequest.getApplicationStatus().toString(),
									memberrequest.getFromDate(), memberrequest.getFromDate(),
									memberrequest.getToDate(), memberrequest.getToDate(),
									memberrequest.getGroupName(),memberrequest.getGroupName(),
									memberrequest.getName(),memberrequest.getName(),
									memberrequest.getShgId(),memberrequest.getShgId()},
					shgMemberRowMapper);

		} catch (Exception e) {
			e.printStackTrace();
			throw new CustomException(CommonConstants.ROLE, e.getMessage());
		}

	}
	
	public List<SmidShgMemberApplication> getMemberCount(SmidShgMemberApplication member) {
		List<SmidShgMemberApplication> suhApp = new ArrayList<>();
		Map<String, Object> paramValues = new HashMap<>();
		paramValues.put("tenantId", member.getTenantId());
		paramValues.put("shgUuid", member.getShgUuid());
				try {
					return suhApp = namedParameterJdbcTemplate.query(NULMQueryBuilder.GET_MEMBER_COUNT_QUERY, paramValues,
							columnsRowMapper);

				
		} catch (Exception e) {
			e.printStackTrace();
			throw new CustomException(CommonConstants.ROLE, e.getMessage());
		}

	}
}
