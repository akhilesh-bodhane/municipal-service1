
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
import org.egov.nulm.model.NulmShgMemberRequest;
import org.egov.nulm.model.SmidShgMemberApplication;
import org.egov.nulm.producer.Producer;
import org.egov.nulm.repository.builder.NULMQueryBuilder;
import org.egov.nulm.repository.rowmapper.ColumnsRowMapper;
import org.egov.nulm.repository.rowmapper.ShgMemberRowMapper;
import org.egov.tracer.model.CustomException;
import org.json.simple.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class SmidShgMemberRepository {

	private JdbcTemplate jdbcTemplate;

	private Producer producer;
	
	private final ObjectMapper objectMapper;

	private NULMConfiguration config;

	private ShgMemberRowMapper shgMemberRowMapper;
	private ColumnsRowMapper columnsRowMapper;

	@Autowired
	public NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Autowired
	public SmidShgMemberRepository(JdbcTemplate jdbcTemplate, Producer producer, NULMConfiguration config,ObjectMapper objectMapper,
			ShgMemberRowMapper shgMemberRowMapper, ColumnsRowMapper columnsRowMapper) {
		this.jdbcTemplate = jdbcTemplate;
		this.producer = producer;
		this.config = config;
		this.objectMapper = objectMapper;
		this.shgMemberRowMapper = shgMemberRowMapper;
		this.columnsRowMapper = columnsRowMapper;
	}
	
public List<SmidShgMemberApplication> saveGuest(List<SmidShgMemberApplication> userList, NulmShgMemberRequest memberrequest) {
	

		SmidShgMemberApplication[] shgg = objectMapper.convertValue(memberrequest.getSmidShgMemberApplication(),
				SmidShgMemberApplication[].class);
		SmidShgMemberApplication shg = shgg[0];
	List<SmidShgMemberApplication> smid = new ArrayList<>();
	List<SmidShgMemberApplication> finallist = new ArrayList<>();
	
		
			
				 smid = jdbcTemplate.query(NULMQueryBuilder.GET_SHG_MEMBER_QUERY,
//						new Object[] { memberrequest.getApplicationId(), memberrequest.getApplicationId(), "",
								new Object[] { shg.getApplicationId(), shg.getApplicationId(), "",
//						new Object[] { shg[0].getShgUuid(), shg[0].getShgUuid(), "",
								"", shg.getTenantId(),
								
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
						shgMemberRowMapper);
					List<SmidShgMemberApplication> smidd = new ArrayList<>(); 
			
			for (SmidShgMemberApplication smidShgMemberApplication : smid) {
				String shgUuid = smidShgMemberApplication.getShgUuid();
				String shgId = smidShgMemberApplication.getShgId();
				if (shgUuid.equals(shg.getShgUuid()) ) {
					
					smidd.add(smidShgMemberApplication);
					
				}
				
			}
			for (SmidShgMemberApplication smidShgMemberApplication : smidd) {
				System.out.println(smidShgMemberApplication.getName());
			}

					System.out.println(smidd);	  
				
					
					for (SmidShgMemberApplication smidShgMemberApplication : smidd) {
//						for (SmidShgMemberApplication smidShgMemberApplication2 : userList)
						for (int smidShgMemberApplication2 = 0; smidShgMemberApplication2 < userList.size(); smidShgMemberApplication2++) 
						{
							if((smidShgMemberApplication.getName().equalsIgnoreCase(userList.get(smidShgMemberApplication2).getName()))&&
							(smidShgMemberApplication.getAdharNo() .equalsIgnoreCase(userList.get(smidShgMemberApplication2).getAdharNo()))&&
							(smidShgMemberApplication.getMobileNo().equalsIgnoreCase(userList.get(smidShgMemberApplication2).getMobileNo()))&&
							(smidShgMemberApplication.getAddress().equalsIgnoreCase(userList.get(smidShgMemberApplication2).getAddress()))) {
								userList.remove(smidShgMemberApplication2);
							}
							else {
//								finallist.add(smidShgMemberApplication2);	
							}
						}
					}
				
					System.out.println(userList.size());
					System.out.println(smidd.size());
					

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
	memberrequest.setSmidShgMemberApplication(userList);
	producer.push(config.getSmidShgMemberSaveTopic(), memberrequest);

////		inviteGuests.addAll(existing);
	return userList;
}

	public void createMembers(SmidShgMemberApplication smidApplication) {
		List<SmidShgMemberApplication> list = new ArrayList<>();
		list.add(smidApplication);
		
		NulmShgMemberRequest infoWrapper = NulmShgMemberRequest.builder().smidShgMemberApplication(list).auditDetails(smidApplication.getAuditDetails())
				.build();
		producer.push(config.getSmidShgMemberSaveTopic(), infoWrapper);
	}

	public void updateMembers(SmidShgMemberApplication smidApplication) {
		List<SmidShgMemberApplication> list = new ArrayList<>();
		list.add(smidApplication);
		NulmShgMemberRequest infoWrapper = NulmShgMemberRequest.builder().smidShgMemberApplication(list)
				.build();
		producer.push(config.getSmidShgMemberUpdateTopic(), infoWrapper);
	}

	public void deleteMembers(SmidShgMemberApplication smidApplication) {
		List<SmidShgMemberApplication> list = new ArrayList<>();
		list.add(smidApplication);
		NulmShgMemberRequest infoWrapper = NulmShgMemberRequest.builder().smidShgMemberApplication(list)
				.build();
		producer.push(config.getSmidShgMemberDeleteTopic(), infoWrapper);
	}
	public void hardDeleteMembers(SmidShgMemberApplication smidApplication) {
		List<SmidShgMemberApplication> list = new ArrayList<>();
		list.add(smidApplication);
		NulmShgMemberRequest infoWrapper = NulmShgMemberRequest.builder().smidShgMemberApplication(list)
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

	public List<SmidShgMemberApplication> getMembers(SmidShgMemberApplication shg, List<Role> role,
			Long userId) {
		List<SmidShgMemberApplication> smid = new ArrayList<>();
		try {
			for (Role roleobj : role) {
				if ((roleobj.getCode()).equalsIgnoreCase(config.getRoleEmployee())) {
					 smid = jdbcTemplate.query(NULMQueryBuilder.GET_SHG_MEMBER_QUERY,
//							new Object[] { memberrequest.getApplicationId(), memberrequest.getApplicationId(), "",
									new Object[] { shg.getApplicationId(), shg.getApplicationId(), "",
//							new Object[] { shg[0].getShgUuid(), shg[0].getShgUuid(), "",
									"", shg.getTenantId(),
									
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
							shgMemberRowMapper);
						List<SmidShgMemberApplication> smidd = new ArrayList<>(); 
				
				for (SmidShgMemberApplication smidShgMemberApplication : smid) {
					String shgUuid = smidShgMemberApplication.getShgUuid();
					String shgId = smidShgMemberApplication.getShgId();
					if (shgUuid.equals(shg.getShgUuid()) ) {
						
						smidd.add(smidShgMemberApplication);
						
					}
					
				}
				for (SmidShgMemberApplication smidShgMemberApplication : smidd) {
					System.out.println(smidShgMemberApplication.getName());
				}

							  
					
					return smidd;

				}
			}
			return smid = jdbcTemplate.query(NULMQueryBuilder.GET_SHG_MEMBER_QUERY,
//					new Object[] { memberrequest.getApplicationId(), memberrequest.getApplicationId(),
					new Object[] { shg.getShgUuid(), shg.getShgUuid(),
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

//	public List<SmidShgMemberApplication> saveGuest(List<SmidShgMemberApplication> userList) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	
}
