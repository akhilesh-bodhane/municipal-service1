
package org.egov.nulm.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.egov.common.contract.request.Role;
import org.egov.nulm.common.CommonConstants;
import org.egov.nulm.config.NULMConfiguration;
import org.egov.nulm.model.NulmShgMemberRequest;
import org.egov.nulm.model.NulmShgRequest;
import org.egov.nulm.model.NulmSmidAlfRequest;
import org.egov.nulm.model.SepApplication;
import org.egov.nulm.model.SmidAlfApplication;
import org.egov.nulm.model.SmidShgGroup;
import org.egov.nulm.model.SmidShgMemberApplication;
import org.egov.nulm.producer.Producer;
import org.egov.nulm.repository.builder.NULMQueryBuilder;
import org.egov.nulm.repository.rowmapper.ColumnsRowMapper;
import org.egov.nulm.repository.rowmapper.ShgMemberListRowMapper;
import org.egov.nulm.repository.rowmapper.ShgMemberRowMapper;
import org.egov.nulm.repository.rowmapper.ShgRowMapper;
import org.egov.tracer.model.CustomException;
import org.json.simple.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class SmidAlfRepository {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	private Producer producer;

	private NULMConfiguration config;

	private ShgRowMapper shgrowMapper;
	private ColumnsRowMapper columnsRowMapper;
	private ShgMemberRowMapper shgMemberRowMapper;
	private ShgMemberListRowMapper shgMemberListRowMapper;
	

	@Autowired
	public SmidAlfRepository(JdbcTemplate jdbcTemplate, Producer producer, NULMConfiguration config,
			ShgRowMapper shgrowMapper,ColumnsRowMapper columnsRowMapper,ShgMemberRowMapper shgMemberRowMapper,ShgMemberListRowMapper shgMemberListRowMapper) {
		this.jdbcTemplate = jdbcTemplate;
		this.producer = producer;
		this.config = config;
		this.shgrowMapper = shgrowMapper;
		this.columnsRowMapper=columnsRowMapper;
		this.shgMemberRowMapper=shgMemberRowMapper;
		this.shgMemberListRowMapper=shgMemberListRowMapper;
	}

	public void createGroup(SmidAlfApplication shg) {
		NulmSmidAlfRequest infoWrapper = NulmSmidAlfRequest.builder().nulmSmidAlfRequest(shg).build();
		producer.push(config.getSMIDALFSaveTopic(), infoWrapper);
	}
	
	public void updateAlfApplication(SmidAlfApplication shg) {
		NulmSmidAlfRequest infoWrapper = NulmSmidAlfRequest.builder().nulmSmidAlfRequest(shg).build();
		producer.push(config.getSMIDALFUpdateTopic(), infoWrapper);
	}
	
	public List<SmidAlfApplication> getAlfApplication(SmidAlfApplication alfApplication, List<Role> role, Long userId) {
		List<SmidAlfApplication> sep = new ArrayList<>();
		boolean isEmployee=false;
		try {
			for (Role roleobj : role) {
				if ((roleobj.getCode()).equalsIgnoreCase(config.getRoleEmployee())) {
					isEmployee=true;
				}
			}
			return sep = jdbcTemplate.query(NULMQueryBuilder.GET_ALF_APPLICATION_QUERY,
					new Object[] {  alfApplication.getId(), 
							        alfApplication.getId(), 
									isEmployee ? "" : userId.toString(), 
									isEmployee ? "" : userId.toString(),
									isEmployee ? "" : alfApplication.getTenantId(),
									isEmployee ? "" : alfApplication.getTenantId(),
			                        alfApplication.getFromDate(), alfApplication.getFromDate(),alfApplication.getToDate(),alfApplication.getToDate()
								
								 }, columnsRowMapper);
		} catch (Exception e) {
			e.printStackTrace();
			throw new CustomException(CommonConstants.ROLE, e.getMessage());
		}

	}

	
	
	
}
