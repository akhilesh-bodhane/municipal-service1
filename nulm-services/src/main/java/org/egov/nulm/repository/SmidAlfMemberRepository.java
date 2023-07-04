
package org.egov.nulm.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.egov.common.contract.request.Role;
import org.egov.nulm.common.CommonConstants;
import org.egov.nulm.config.NULMConfiguration;
import org.egov.nulm.model.NulmAlfMemberRequest;
import org.egov.nulm.model.SmidAlfMemberApplication;
import org.egov.nulm.producer.Producer;
import org.egov.nulm.repository.builder.NULMQueryBuilder;
import org.egov.nulm.repository.rowmapper.ColumnsRowMapper;
import org.egov.nulm.repository.rowmapper.AlfMemberRowMapper;
//import org.egov.prscp.repository.builder.PrQueryBuilder;
//import org.egov.prscp.web.models.InviteGuest;
//import org.egov.prscp.web.models.RequestInfoWrapper;
import org.egov.tracer.model.CustomException;
import org.json.simple.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class SmidAlfMemberRepository {

	private JdbcTemplate jdbcTemplate;

	private Producer producer;

	private NULMConfiguration config;

	private AlfMemberRowMapper alfMemberRowMapper;
	private ColumnsRowMapper columnsRowMapper;

	@Autowired
	public NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Autowired
	public SmidAlfMemberRepository(JdbcTemplate jdbcTemplate, Producer producer, NULMConfiguration config,
			AlfMemberRowMapper alfMemberRowMapper, ColumnsRowMapper columnsRowMapper) {
		this.jdbcTemplate = jdbcTemplate;
		this.producer = producer;
		this.config = config;
		this.alfMemberRowMapper = alfMemberRowMapper;
		this.columnsRowMapper = columnsRowMapper;
	}
	
public List<SmidAlfMemberApplication> saveGuest(List<SmidAlfMemberApplication> userList, NulmAlfMemberRequest memberrequest) {

//	public void saveGuest(List<SmidShgMemberApplication> userList, NulmShgMemberRequest memberrequest) {

//		List<SmidShgMemberApplication> existingList = jdbcTemplate.query(PrQueryBuilder.GET_INVITATION_GUEST,
//				new Object[] { tenantId, moduleCode, eventDetailUuid, userId }, invitationGuestRowMapper);
//
//		List<InviteGuest> existing = existingList.stream()
//				.filter(exits -> inviteGuests.stream()
//						.filter(nwList -> (exits.getGuestEmail().equalsIgnoreCase(nwList.getGuestEmail())
//								&& exits.getGuestMobile().equalsIgnoreCase(nwList.getGuestMobile())
//								&& exits.getGuestName().equalsIgnoreCase(nwList.getGuestName())
//								&& exits.getEventGuestType().equalsIgnoreCase(nwList.getEventGuestType()))
//								&& exits.getModuleCode().equalsIgnoreCase(nwList.getModuleCode()))
//						.findFirst().isPresent())
//				.collect(Collectors.toList());
//
//		existingList.stream().forEach(
//				exits -> inviteGuests.removeIf(nwList -> (exits.getGuestEmail().equalsIgnoreCase(nwList.getGuestEmail())
//						&& exits.getGuestMobile().equalsIgnoreCase(nwList.getGuestMobile())
//						&& exits.getGuestName().equalsIgnoreCase(nwList.getGuestName())
//						&& exits.getEventGuestType().equalsIgnoreCase(nwList.getEventGuestType())
//						&& exits.getModuleCode().equalsIgnoreCase(nwList.getModuleCode()))));

//		RequestInfoWrapper infoWrapper = RequestInfoWrapper.builder().requestBody(inviteGuests).build();
//		producer.push(config.getInvitationSaveGuestTopic(), infoWrapper);
		
//		SmidShgMemberApplication smidApplication =null;
//		NulmShgMemberRequest infoWrapper = NulmShgMemberRequest.builder().SmidShgMemberApplication(userList);
	memberrequest.setSmidAlfMemberApplication(userList);
	producer.push(config.getSmidAlfMemberSaveTopic(), memberrequest);

////		inviteGuests.addAll(existing);
	return userList;
}

	public void createMembers(SmidAlfMemberApplication smidApplication) {
		List<SmidAlfMemberApplication> list = new ArrayList<>();
		list.add(smidApplication);
		
		NulmAlfMemberRequest infoWrapper = NulmAlfMemberRequest.builder().smidAlfMemberApplication(list).auditDetails(smidApplication.getAuditDetails())
				.build();
		producer.push(config.getSmidShgMemberSaveTopic(), infoWrapper);
	}

	public void updateMembers(SmidAlfMemberApplication smidApplication) {
		List<SmidAlfMemberApplication> list = new ArrayList<>();
		list.add(smidApplication);
		NulmAlfMemberRequest infoWrapper = NulmAlfMemberRequest.builder().smidAlfMemberApplication(list)
				.build();
		producer.push(config.getSmidShgMemberUpdateTopic(), infoWrapper);
	}

	public void deleteMembers(SmidAlfMemberApplication smidApplication) {
		List<SmidAlfMemberApplication> list = new ArrayList<>();
		list.add(smidApplication);
		NulmAlfMemberRequest infoWrapper = NulmAlfMemberRequest.builder().smidAlfMemberApplication(list)
				.build();
		producer.push(config.getSmidShgMemberDeleteTopic(), infoWrapper);
	}
	public void hardDeleteMembers(SmidAlfMemberApplication smidApplication) {
		List<SmidAlfMemberApplication> list = new ArrayList<>();
		list.add(smidApplication);
		NulmAlfMemberRequest infoWrapper = NulmAlfMemberRequest.builder().smidAlfMemberApplication(list)
				.build();
		producer.push(config.getSmidShgMemberHardDeleteTopic(), infoWrapper);
	}
	
	public void checkShgUuid(SmidAlfMemberApplication smidapplication) {
		Map<String, String> errorMap = new HashMap<>();
		int i = 0;
		i = jdbcTemplate.queryForObject(NULMQueryBuilder.ALF_UUID_EXIST_QUERY,
				new Object[] { smidapplication.getAlfUuid(), smidapplication.getTenantId() }, Integer.class);

		if (i == 0) {
			errorMap.put(CommonConstants.INVALID_SHG_UUID, CommonConstants.INVALID_SHG_UUID_MESSAGE);
			throw new CustomException(errorMap);
		}
	}

	public void checkMemberUuid(SmidAlfMemberApplication smidapplication) {
		Map<String, String> errorMap = new HashMap<>();
		int i = 0;
		i = jdbcTemplate.queryForObject(NULMQueryBuilder.MEMBER_UUID_EXIST_QUERY,
				new Object[] { smidapplication.getApplicationUuid(), smidapplication.getTenantId() }, Integer.class);

		if (i == 0) {
			errorMap.put(CommonConstants.INVALID_MEMBER_UUID, CommonConstants.INVALID_MEMBER_UUID_MESSAGE);
			throw new CustomException(errorMap);
		}
	}

	public JSONArray getMemmberStatus(SmidAlfMemberApplication shg) {
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

	public List<SmidAlfMemberApplication> getMembers(SmidAlfMemberApplication shg, List<Role> role,
			Long userId) {
		List<SmidAlfMemberApplication> smid = new ArrayList<>();
		try {
			for (Role roleobj : role) {
				if ((roleobj.getCode()).equalsIgnoreCase(config.getRoleEmployee())) {
					 smid = jdbcTemplate.query(NULMQueryBuilder.GET_SHG_MEMBER_QUERYY,
//							new Object[] { memberrequest.getApplicationId(), memberrequest.getApplicationId(), "",
									new Object[] { shg.getApplicationId(), shg.getApplicationId(), "",
//							new Object[] { shg[0].getShgUuid(), shg[0].getShgUuid(), "",
									"",
										/* shg.getTenantId(), */
									
									shg.getApplicationStatus() == null ? ""
											: shg.getApplicationStatus().toString(),
									shg.getApplicationStatus() == null ? ""
											: shg.getApplicationStatus().toString(),
											shg.getFromDate(), shg.getFromDate(),
											shg.getToDate(), shg.getToDate(),
											shg.getGroupName(),shg.getGroupName(),
											shg.getName(),shg.getName(),
											shg.getShgId(),shg.getShgId()
											},
									alfMemberRowMapper);
						List<SmidAlfMemberApplication> smidd = new ArrayList<>(); 
				
				for (SmidAlfMemberApplication smidShgMemberApplication : smid) {
					String shgUuid = smidShgMemberApplication.getAlfUuid();
					String shgId = smidShgMemberApplication.getShgId();
					if (shgUuid.equals(shg.getAlfUuid()) ) {
						
						smidd.add(smidShgMemberApplication);
						
					}
					
				}
				for (SmidAlfMemberApplication smidShgMemberApplication : smidd) {
					System.out.println(smidShgMemberApplication.getName());
				}

							  
					
					return smidd;

				}
			}
			return smid = jdbcTemplate.query(NULMQueryBuilder.GET_SHG_MEMBER_QUERYY,
//					new Object[] { memberrequest.getApplicationId(), memberrequest.getApplicationId(),
					new Object[] { shg.getAlfUuid(), shg.getAlfUuid(),
							userId.toString(), userId.toString(), shg.getTenantId(),
							shg.getApplicationStatus() == null ? ""
									: shg.getApplicationStatus().toString(),
							shg.getApplicationStatus() == null ? ""
									: shg.getApplicationStatus().toString(),
									shg.getFromDate(), shg.getFromDate(),
									shg.getToDate(), shg.getToDate(),
									shg.getGroupName(),shg.getGroupName(),
									shg.getName(),shg.getName(),
									shg.getShgId(),shg.getShgId()},
					alfMemberRowMapper);

		} catch (Exception e) {
			e.printStackTrace();
			throw new CustomException(CommonConstants.ROLE, e.getMessage());
		}

	}
	
	public List<SmidAlfMemberApplication> getMemberCount(SmidAlfMemberApplication member) {
		List<SmidAlfMemberApplication> suhApp = new ArrayList<>();
		Map<String, Object> paramValues = new HashMap<>();
		paramValues.put("tenantId", member.getTenantId());
		paramValues.put("shgUuid", member.getAlfUuid());
				try {
					return suhApp = namedParameterJdbcTemplate.query(NULMQueryBuilder.GET_MEMBER_COUNT_QUERY, paramValues,
							columnsRowMapper);

				
		} catch (Exception e) {
			e.printStackTrace();
			throw new CustomException(CommonConstants.ROLE, e.getMessage());
		}

	}

//	public List<SmidShgMemberApplication> saveGuest(List<SmidShgMemberApplication> userList) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	
}
