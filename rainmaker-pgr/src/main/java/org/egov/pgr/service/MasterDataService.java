package org.egov.pgr.service;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.egov.common.contract.request.RequestInfo;
import org.egov.pgr.contract.AutoroutingMapReqSearchCriteria;
import org.egov.pgr.contract.AutoroutingMapRequest;
import org.egov.pgr.contract.AutoroutingMapResponse;
import org.egov.pgr.model.AuditDetails;
import org.egov.pgr.model.AutoroutingMap;
import org.egov.pgr.model.user.Role;
import org.egov.pgr.model.user.User;
import org.egov.pgr.model.user.UserRequest;
import org.egov.pgr.model.user.UserResponses;
import org.egov.pgr.model.user.UserSearchRequest;
import org.egov.pgr.producer.PGRProducer;
import org.egov.pgr.repository.MasterDataRepository;
import org.egov.pgr.repository.ServiceRequestRepository;
import org.egov.pgr.utils.ErrorConstants;
import org.egov.pgr.utils.PGRConstants;
import org.egov.pgr.utils.PGRUtils;
import org.egov.pgr.utils.ResponseInfoFactory;
import org.egov.tracer.model.CustomException;
import org.postgresql.util.PGobject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.CollectionUtils;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;

import lombok.extern.slf4j.Slf4j;

@org.springframework.stereotype.Service
@Slf4j
public class MasterDataService {

	@Value("${kafka.topics.save.autorouting}")
	private String saveTopic;

	@Value("${kafka.topics.update.autorouting}")
	private String updateTopic;
	
	@Value("${egov.user.host}")
	private String userBasePath;
	
	@Value("${egov.user.search.endpoint}")
	private String userSearchEndPoint;
	
	@Value("${egov.user.update.endpoint}")
	private String userUpdateEndpoint;

	@Autowired
	private ResponseInfoFactory factory;

	@Autowired
	private PGRUtils pGRUtils;

	@Autowired
	private PGRProducer pGRProducer;

	@Autowired
	private ServiceRequestRepository serviceRequestRepository;
	
	@Autowired
	private MasterDataRepository masterDataRepository;

	@Autowired
    private ObjectMapper objectMapper;

	/***
	 * Asynchronous method performs business logic if any and adds the data to
	 * persister queue on create topic
	 * 
	 * @param AutoroutingMapRequest
	 * @return AutoroutingMapResponse
	 */
	public AutoroutingMapResponse create(AutoroutingMapRequest autoroutingMapRequest) {
		log.info("Master Data layer to create autorouting");
		enrichAutoroutingMapRequestForCreate(autoroutingMapRequest);
		pGRProducer.push(saveTopic, autoroutingMapRequest);
		return getAutoroutingMapResponse(autoroutingMapRequest);
	}

	/**
	 * Update autorouting data and adds the data to
	 * persister queue on update topic
	 * 
	 * @param AutoroutingMapRequest
	 * @return AutoroutingMapResponse
	 */
	public AutoroutingMapResponse update(AutoroutingMapRequest autoroutingMapRequest) {
		log.info("Master Data layer to update autorouting");
		enrichAutoroutingMapRequestForUpdate(autoroutingMapRequest);
		pGRProducer.push(updateTopic, autoroutingMapRequest);
		return getAutoroutingMapResponse(autoroutingMapRequest);
	}
	
	/**
	 * Get autorouting data from database as per criteria
	 * 
	 * @param RequestInfo
	 * @param AutoroutingMapReqSearchCriteria
	 * @return AutoroutingMapResponse
	 */
	public AutoroutingMapResponse getAutoroutingData(RequestInfo requestInfo, AutoroutingMapReqSearchCriteria criteria) {
		log.info("Get Autorouting data from database");
		Map<String, String> errorMap = new HashMap<>();
		AutoroutingMap autoroutingMap = masterDataRepository.getAutoRoutingData(criteria.getTenantId());
		if(null == autoroutingMap) {
			errorMap.put(ErrorConstants.NO_DATA_FOUND_CODE, ErrorConstants.NO_DATA_FOUND_MSG);
		}else {	
			autoroutingMap.setAutorouting(
					getFilterAutoroutingData(autoroutingMap.getAutorouting(), criteria.getTenantId(), criteria.getCategory(), criteria.getSector()));
		}
		if (!errorMap.isEmpty()) {
			throw new CustomException(errorMap);
		}
		AutoroutingMapRequest autoroutingMapRequest = AutoroutingMapRequest.builder().requestInfo(requestInfo).autoroutingMap(autoroutingMap).build();
		return getAutoroutingMapResponse(autoroutingMapRequest);
	}
	
	/**
	 * Util method for the create to enrich the actions in the request 
	 * 
	 * @param AutoroutingMapRequest
	 */
	private void enrichAutoroutingMapRequestForCreate(AutoroutingMapRequest autoroutingMapRequest) {
		Map<String, String> errorMap = new HashMap<>();
		RequestInfo requestInfo = autoroutingMapRequest.getRequestInfo();
		AutoroutingMap autoroutingMap =autoroutingMapRequest.getAutoroutingMap();
		
		AutoroutingMap mapDataFromDB = masterDataRepository.getAutoRoutingData(autoroutingMap.getTenantId());
		if(null != mapDataFromDB) {
			errorMap.put(ErrorConstants.AUTOROUTING_DATA_EXISTS_CODE, ErrorConstants.AUTOROUTING_DATA_EXISTS_MSG);
		}else {		
			autoroutingMap.setId(UUID.randomUUID().toString());
			autoroutingMap.setActive(true);
			AuditDetails auditDetails = pGRUtils.getAuditDetails(String.valueOf(requestInfo.getUserInfo().getId()), true);
			autoroutingMap.setAuditDetails(auditDetails);
		}
		
		if (!errorMap.isEmpty()) {
			throw new CustomException(errorMap);
		}
	}
	
	/**
	 * Util method for the update to enrich the actions in the request 
	 * 
	 * @param request
	 */
	private void enrichAutoroutingMapRequestForUpdate(AutoroutingMapRequest autoroutingMapRequest) {
		Map<String, String> errorMap = new HashMap<>();
		RequestInfo requestInfo = autoroutingMapRequest.getRequestInfo();
		AutoroutingMap autoroutingMap =autoroutingMapRequest.getAutoroutingMap();
		
		AutoroutingMap mapDataFromDB = masterDataRepository.getAutoRoutingData(autoroutingMap.getTenantId());
		if(null == mapDataFromDB || null == mapDataFromDB.getAutorouting() ) {
			errorMap.put(ErrorConstants.NO_DATA_FOUND_CODE, ErrorConstants.NO_DATA_FOUND_MSG);
		}else {
			try {
				mapDataFromDB.setAutorouting(
						updateAutoroutingData(mapDataFromDB.getAutorouting(), autoroutingMap.getAutorouting(),
								autoroutingMapRequest.getRequestInfo(), autoroutingMapRequest.getAutoroutingMap().getTenantId()));
				mapDataFromDB.setActive(true);
				AuditDetails auditDetails = pGRUtils.getAuditDetails(String.valueOf(requestInfo.getUserInfo().getId()), false);
				mapDataFromDB.setAuditDetails(auditDetails);
				autoroutingMapRequest.setAutoroutingMap(mapDataFromDB);
			}catch(Exception e) {
				log.error("Unable to update autorouting data",e);
				errorMap.put(ErrorConstants.AUTOROUTING_UPDATION_FAILED_CODE, ErrorConstants.AUTOROUTING_UPDATION_FAILED_MSG);
			}
		}
		
		if (!errorMap.isEmpty()) {
			throw new CustomException(errorMap);
		}
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private Object updateAutoroutingData(Object dbAutoroutingData, Object selectedData, RequestInfo requestInfo, String tenantId) throws JsonParseException, JsonMappingException, IOException {
		String selectedCategory = JsonPath.read(selectedData, PGRConstants.AUTOROUTING_CATEGORY_JSONPATH);
		List<String> selectedEO1List = JsonPath.read(selectedData, PGRConstants.AUTOROUTING_ESCALATING_OFFICER1_JSONPATH);
		List<String> selectedEO2List = JsonPath.read(selectedData, PGRConstants.AUTOROUTING_ESCALATING_OFFICER2_JSONPATH);
		
		List dbMapData = JsonPath.read(((PGobject)dbAutoroutingData).getValue(), PGRConstants.JSONPATH_AUTOROUTING_MAP_CODES_DB);
		
		//Get all the existing leve1 officer & level2 officer list
		List<List<String>> dbEO1List = JsonPath.read(((PGobject)dbAutoroutingData).getValue(), PGRConstants.JSONPATH_ESCALATING_OFFICER1_CODES_DB);
		List<List<String>> dbEO2List = JsonPath.read(((PGobject)dbAutoroutingData).getValue(), PGRConstants.JSONPATH_ESCALATING_OFFICER2_CODES_DB);
		Map<String,String> dbEO1Map = dbEO1List.stream().flatMap(l -> l.stream()).collect(Collectors.toMap(s -> s, s -> s,(s,s1)->s1));
		Map<String,String> dbEO2Map = dbEO2List.stream().flatMap(l -> l.stream()).collect(Collectors.toMap(s -> s, s -> s,(s,s1)->s1));
		
		//replace existing category wise autorouting with newer one
		List<String> replacedEO1List = new ArrayList<String>();
		List<String> replacedEO2List = new ArrayList<String>();
		boolean isFound =false;
		for (int i = 0; i < dbMapData.size(); i++) {
			String dbCat = JsonPath.read(dbMapData.get(i), PGRConstants.AUTOROUTING_CATEGORY_JSONPATH);
			if(!StringUtils.isEmpty(dbCat) && dbCat.equalsIgnoreCase(selectedCategory)) {
				replacedEO1List = JsonPath.read(dbMapData.get(i), PGRConstants.AUTOROUTING_ESCALATING_OFFICER1_JSONPATH);
				replacedEO2List = JsonPath.read(dbMapData.get(i), PGRConstants.AUTOROUTING_ESCALATING_OFFICER2_JSONPATH);
				dbMapData.set(i, selectedData);
				isFound = true;
				break;
			}
		}
		if(!isFound) {
			dbMapData.add(selectedData);
		}
		LinkedHashMap<String, Object> finalObject = objectMapper.readValue(((PGobject)dbAutoroutingData).getValue(), LinkedHashMap.class);
		finalObject.put("AutoroutingEscalationMap", dbMapData);
		
		updateEOUserRole(selectedEO1List, selectedEO2List, dbEO1Map, dbEO2Map, replacedEO1List, replacedEO2List,
				finalObject, requestInfo, tenantId);
		
		return finalObject;
	}
	
	private Object getFilterAutoroutingData(Object map, String tenantId, String category, String sector) {
		String filter ="[?(@.active == true)]";
		if(!StringUtils.isBlank(category)) {
			filter = "[?((@.category == '" + category + "') && (@.active == true))]";
		}
		
		List filteredData = null;
		if(null != map) {
			List autoroutingData = JsonPath.read(((PGobject)map).getValue(), PGRConstants.JSONPATH_AUTOROUTING_MAP_CODES_DB);
			filteredData = JsonPath.read(autoroutingData, filter);
		}
		
		return filteredData;
	}
	
	public Object fetchAutoroutingEscalationMap(String tenantId, String category, String sector) {
		AutoroutingMap autoroutingMap = masterDataRepository.getAutoRoutingData(tenantId);
		return getFilterAutoroutingData(autoroutingMap.getAutorouting(), tenantId, category, sector);
	}
	
	private void updateEOUserRole(List<String> selectedEO1List, List<String> selectedEO2List,
			Map<String, String> dbEO1Map, Map<String, String> dbEO2Map, List<String> replacedEO1List,
			List<String> replacedEO2List, LinkedHashMap<String, Object> finalObject, RequestInfo requestInfo, String tenantId) {
		
		//Get all the updated leve1 officer & level2 officer list
		List<List<String>> updatedEO1List = JsonPath.read(finalObject, PGRConstants.JSONPATH_ESCALATING_OFFICER1_CODES_DB);
		List<List<String>> updatedEO2List = JsonPath.read(finalObject, PGRConstants.JSONPATH_ESCALATING_OFFICER2_CODES_DB);
		Map<String,String> updatedEO1Map = updatedEO1List.stream().flatMap(l -> l.stream()).collect(Collectors.toMap(s -> s, s -> s,(s,s1)->s1));
		Map<String,String> updatedEO2Map = updatedEO2List.stream().flatMap(l -> l.stream()).collect(Collectors.toMap(s -> s, s -> s,(s,s1)->s1));
				
		List<String> eo1RoleUpdateList = new ArrayList<String>();
		List<String> eo2RoleUpdateList = new ArrayList<String>();
		List<String> eo1RoleRemovedList = new ArrayList<String>();
		List<String> eo2RoleRemovedList = new ArrayList<String>();
		
		/*If selected level1 officer does not match in the existing level1 & level2 officer data, 
		 * then add this user in the level1 officer role update list 
		*/
		for(String eo1 : selectedEO1List) {
			if(!dbEO1Map.containsKey(eo1) && !dbEO2Map.containsKey(eo1)) {
				eo1RoleUpdateList.add(eo1);
			}
		}
		
		/*If selected level2 officer does not match in the existing level2 officer data, 
		 * then add this user in the level2 officer role update list 
		*/
		for(String eo2 : selectedEO2List) {
			if(!dbEO2Map.containsKey(eo2)) {
				eo2RoleUpdateList.add(eo2);
			}
		}
		
		/*If the replaced level1 officer does not match in the updated level1 & level2 officer data, 
		 * then add this user in the level1 officer role removed list 
		*/
		for(String eo1 : replacedEO1List) {
			if(!updatedEO1Map.containsKey(eo1) && !updatedEO2Map.containsKey(eo1)) {
				eo1RoleRemovedList.add(eo1);
			}
		}
		
		/*If the replaced level2 officer does not match in the updated level2 officer data, 
		 * then add this user in the level2 officer role removed list 
		*/
		for(String eo2 : replacedEO2List) {
			if(!updatedEO2Map.containsKey(eo2)) {
				eo2RoleRemovedList.add(eo2);
			}
		}
		
		for(String userName : eo1RoleUpdateList) {
			log.info("User {} needs to assign the role {}",userName,PGRConstants.ROLE_ESCALATION_OFFICER1);
			User user = getUser(requestInfo, userName, tenantId);
			if(null != user) {
				log.info("User found with username {}",userName);
				List<String> codes = user.getRoles().stream().map(Role::getCode).collect(Collectors.toList());
				if (!codes.contains(PGRConstants.ROLE_ESCALATION_OFFICER1)) {
					user.getRoles().add(Role.builder().code(PGRConstants.ROLE_ESCALATION_OFFICER1).build());
					String id= updateUser(requestInfo, user);
					log.info("User {} updated with the role {}. Id {}",userName,PGRConstants.ROLE_ESCALATION_OFFICER1,id);
				}else {
					log.info("User {} already has the role {}",userName,PGRConstants.ROLE_ESCALATION_OFFICER1);
				}
			}else {
				log.info("User not found with username {}",userName);
			}
		}
		
		for(String userName : eo2RoleUpdateList) {
			log.info("User {} needs to assign the roles {},{}",userName,PGRConstants.ROLE_ESCALATION_OFFICER1,PGRConstants.ROLE_ESCALATION_OFFICER2);
			User user = getUser(requestInfo, userName, tenantId);
			
			if(null != user) {
				log.info("User found with username {}",userName);
				List<String> codes = user.getRoles().stream().map(Role::getCode).collect(Collectors.toList());
				List<Role> newRoles = new ArrayList<Role>();
				if (!codes.contains(PGRConstants.ROLE_ESCALATION_OFFICER1)) {
					newRoles.add(Role.builder().code(PGRConstants.ROLE_ESCALATION_OFFICER1).build());
				}
				if (!codes.contains(PGRConstants.ROLE_ESCALATION_OFFICER2)) {
					newRoles.add(Role.builder().code(PGRConstants.ROLE_ESCALATION_OFFICER2).build());
				}
				
				if (!CollectionUtils.isEmpty(newRoles)) {
					user.getRoles().addAll(newRoles);
					String id= updateUser(requestInfo, user);
					log.info("User {} updated with the roles {},{}. Id {}",userName,PGRConstants.ROLE_ESCALATION_OFFICER1,PGRConstants.ROLE_ESCALATION_OFFICER2,id);
				}else {
					log.info("User {} already has the roles {},{}",userName,PGRConstants.ROLE_ESCALATION_OFFICER1,PGRConstants.ROLE_ESCALATION_OFFICER2);
				}
			}else {
				log.info("User not found with username {}",userName);
			}
		}
		
		for(String userName : eo1RoleRemovedList) {
			log.info("User {} needs to remove the role {}",userName,PGRConstants.ROLE_ESCALATION_OFFICER1);
			User user = getUser(requestInfo, userName, tenantId);
			
			if(null != user) {
				log.info("User found with username {}",userName);
				List<Role> roles = user.getRoles().stream()
						  .filter(e -> !e.getCode().startsWith(PGRConstants.ROLE_ESCALATION_OFFICER1))
						  .collect(Collectors.toList());
				user.setRoles(roles);
				String id= updateUser(requestInfo, user);
				log.info("User Role {} removed from the user {}. Id {}",PGRConstants.ROLE_ESCALATION_OFFICER1,userName,id);
			}else {
				log.info("User not found with username {}",userName);
			}
		}
		
		for(String userName : eo2RoleRemovedList) {
			log.info("User {} needs to remove the roles {},{}",userName,PGRConstants.ROLE_ESCALATION_OFFICER1,PGRConstants.ROLE_ESCALATION_OFFICER2);
			User user = getUser(requestInfo, userName, tenantId);
			
			if(null != user) {
				log.info("User found with username {}",userName);
				user.getRoles().removeIf(e -> e.getCode().equals(PGRConstants.ROLE_ESCALATION_OFFICER1));
				user.getRoles().removeIf(e -> e.getCode().equals(PGRConstants.ROLE_ESCALATION_OFFICER2));
				String id= updateUser(requestInfo, user);
				log.info("User Roles {},{} removed from the user {}. Id {}",PGRConstants.ROLE_ESCALATION_OFFICER1,PGRConstants.ROLE_ESCALATION_OFFICER2,userName,id);
			}else {
				log.info("User found with username {}",userName);
			}
		}
	}
	
	/**
	 * This method update user in user svc.
	 * 
	 * @param User
	 * @param requestInfo
	 * @param tenantId
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	private String updateUser(RequestInfo requestInfo, User user) {
		ObjectMapper mapper = pGRUtils.getObjectMapper();
		StringBuilder url = new StringBuilder(userBasePath+userUpdateEndpoint); 
		UserRequest req = UserRequest.builder().user(user).requestInfo(requestInfo).build();
		String dobFormat="yyyy-MM-dd";
		try {
			LinkedHashMap responseMap = (LinkedHashMap) serviceRequestRepository.fetchResult(url, req);
			parseResponse(responseMap,dobFormat);
			UserResponses res = mapper.convertValue(responseMap, UserResponses.class);
			if(CollectionUtils.isEmpty(res.getUser())) {
				return null;
			}else {
				return res.getUser().get(0).getId().toString();
			}
		}catch(Exception e) {
			return null;
		}
	}
	
	/**
	 * Fetches Users to be populated in the response
	 * 
	 * @param requestInfo
	 * @param userIds
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public User getUser(RequestInfo requestInfo, String userName, String tenantId) {
		ObjectMapper mapper = pGRUtils.getObjectMapper();
		UserSearchRequest searchRequest = UserSearchRequest.builder().userName(userName).tenantId(tenantId)
				.userType(PGRConstants.ROLE_EMPLOYEE).requestInfo(requestInfo).build();
		StringBuilder url = new StringBuilder();
		url.append(userBasePath).append(userSearchEndPoint);
		String dobFormat="yyyy-MM-dd";
		try {
			LinkedHashMap responseMap = (LinkedHashMap) serviceRequestRepository.fetchResult(url, searchRequest);
			parseResponse(responseMap,dobFormat);
			UserResponses res = mapper.convertValue(responseMap, UserResponses.class);
			if(CollectionUtils.isEmpty(res.getUser())) {
				return null;
			}else {
				return res.getUser().get(0);
			}
		}catch(Exception e) {
			return null;
		}
	}	
	
	/**
	 * Parses date formats to long for all users in responseMap
	 * @param responeMap LinkedHashMap got from user api response
	 * @param dobFormat dob format (required because dob is returned in different format's in search and create response in user service)
	 */
	@SuppressWarnings("all")
	private void parseResponse(LinkedHashMap responeMap,String dobFormat){
		List<LinkedHashMap> users = (List<LinkedHashMap>)responeMap.get("user");
		String format1 = "dd-MM-yyyy HH:mm:ss";
		if(users!=null){
			users.forEach( map -> {
						map.put("createdDate",dateTolong((String)map.get("createdDate"),format1));
						if((String)map.get("lastModifiedDate")!=null)
							map.put("lastModifiedDate",dateTolong((String)map.get("lastModifiedDate"),format1));
						if((String)map.get("dob")!=null)
							map.put("dob",dateTolong((String)map.get("dob"),dobFormat));
						if((String)map.get("pwdExpiryDate")!=null)
							map.put("pwdExpiryDate",dateTolong((String)map.get("pwdExpiryDate"),format1));
					}
			);
		}
	}
	
	/**
	 * Converts date to long
	 * @param date date to be parsed
	 * @param format Format of the date
	 * @return Long value of date
	 */
	private Long dateTolong(String date,String format){
		SimpleDateFormat f = new SimpleDateFormat(format);
		Date d = null;
		try {
			d = f.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return  d.getTime();
	}
	
	/**
	 * returns AutoroutingMapResponse fetched from database/built based on the given
	 * AutoroutingMapRequest
	 * 
	 * @param AutoroutingMapRequest
	 * @return AutoroutingMapResponse
	 */
	public AutoroutingMapResponse getAutoroutingMapResponse(AutoroutingMapRequest autoroutingMapRequest) {
			return AutoroutingMapResponse.builder()
					.responseInfo(factory.createResponseInfoFromRequestInfo(autoroutingMapRequest.getRequestInfo(), true))
					.autoroutingMap(autoroutingMapRequest.getAutoroutingMap()).build();
	}
}
