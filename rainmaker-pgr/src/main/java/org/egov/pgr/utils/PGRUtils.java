package org.egov.pgr.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.egov.common.contract.request.RequestInfo;
import org.egov.common.contract.request.Role;
import org.egov.mdms.model.MasterDetail;
import org.egov.mdms.model.MdmsCriteria;
import org.egov.mdms.model.MdmsCriteriaReq;
import org.egov.mdms.model.ModuleDetail;
import org.egov.pgr.contract.CountResponse;
import org.egov.pgr.contract.ParamValue;
import org.egov.pgr.contract.ReportRequest;
import org.egov.pgr.contract.RequestInfoWrapper;
import org.egov.pgr.contract.SMSRequest;
import org.egov.pgr.contract.SearcherRequest;
import org.egov.pgr.contract.ServiceReqSearchCriteria;
import org.egov.pgr.contract.ServiceRequestComplaints;
import org.egov.pgr.contract.ServiceResponse;
import org.egov.pgr.model.ActionHistory;
import org.egov.pgr.model.ActionInfo;
import org.egov.pgr.model.AuditDetails;
import org.egov.pgr.model.SearchParam;
import org.egov.pgr.model.Service;
import org.egov.pgr.producer.PGRProducer;
import org.egov.pgr.repository.ServiceRequestRepository;
import org.egov.tracer.model.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.jayway.jsonpath.JsonPath;

import lombok.extern.slf4j.Slf4j;
import net.minidev.json.JSONObject;

@Component
@Slf4j
public class PGRUtils {

	private static Map<Integer, String> employeeRolesPrecedenceMap = prepareEmployeeRolesPrecedenceMap();

	@Value("${egov.infra.searcher.host}")
	private String searcherHost;

	@Value("${egov.infra.searcher.endpoint}")
	private String searcherEndpoint;

	@Value("${egov.report.host}")
	private String reportHost;

	@Value("${egov.report.pgr.search.endpoint}")
	private String reportEndpoint;

	@Value("${egov.mdms.host}")
	private String mdmsHost;

	@Value("${egov.mdms.search.endpoint}")
	private String mdmsEndpoint;

	@Value("${egov.hr.employee.v2.host}")
	private String hrEmployeeV2Host;

	@Value("${egov.hr.employee.v2.search.endpoint}")
	private String hrEmployeeSearchEndpoint;

	@Value("${egov.common.masters.host}")
	private String commonMasterHost;

	@Value("${egov.common.masters.search.endpoint}")
	private String commonMasterSearchEndpoint;

	@Value("${egov.localization.host}")
	private String localizationHost;

	@Value("${egov.localization.search.endpoint}")
	private String localizationSearchEndpoint;
	
	@Value("${egov.user.host}")
	private String egovUserHost;

	@Value("${egov.user.search.endpoint}")
	private String egovUserSearchEndpoint;

	@Value("${egov.location.host}")
	private String locationHost;

	@Value("${egov.location.search.endpoint}")
	private String locationSearchEndpoint;

	@Value("${egov.hrms.host}")
	private String egovHRMShost;

	@Value("${egov.hrms.search.endpoint}")
	private String egovHRMSSearchEndpoint;

	@Value("${are.inactive.complaintcategories.enabled}")
	private Boolean areInactiveComplaintCategoriesEnabled;
	
	 @Value("${kafka.topics.notification.sms}")
	 private String smsNotifTopic;

	@Autowired
	private ResponseInfoFactory factory;

	@Autowired
	private ServiceRequestRepository serviceRequestRepository;

	private static final String MODULE_NAME = "{moduleName}";

	private static final String SEARCH_NAME = "{searchName}";
	
	@Autowired
    private PGRProducer pGRProducer;

	/**
	 * Prepares request and uri for service code search from MDMS
	 * 
	 * @param uri
	 * @param tenantId
	 * @param department
	 * @param requestInfo
	 * @return MdmsCriteriaReq
	 * @author vishal
	 */
	public MdmsCriteriaReq prepareSearchRequestForServiceCodes(StringBuilder uri, String tenantId,
			List<String> departments, RequestInfo requestInfo) {
		uri.append(mdmsHost).append(mdmsEndpoint);
		StringBuilder depts = new StringBuilder();
		depts.append("[");
		for (int i = 0; i < departments.size(); i++) {
			depts.append("'" + departments.get(i) + "'");
			if (i < departments.size() - 1)
				depts.append(",");
		}
		depts.append("]");
		MasterDetail masterDetail = org.egov.mdms.model.MasterDetail.builder()
				.name(PGRConstants.MDMS_SERVICETYPE_MASTER_NAME).filter("[?(@.department IN " + depts.toString() + ")]")
				.build();
		if (!areInactiveComplaintCategoriesEnabled) {
			masterDetail.setFilter("[?((@.department IN " + depts.toString() + ") && (@.active == true))]");
		}
		List<MasterDetail> masterDetails = new ArrayList<>();
		masterDetails.add(masterDetail);
		ModuleDetail moduleDetail = ModuleDetail.builder().moduleName(PGRConstants.MDMS_PGR_MOD_NAME)
				.masterDetails(masterDetails).build();
		List<ModuleDetail> moduleDetails = new ArrayList<>();
		moduleDetails.add(moduleDetail);
		MdmsCriteria mdmsCriteria = MdmsCriteria.builder().tenantId(tenantId).moduleDetails(moduleDetails).build();
		return MdmsCriteriaReq.builder().requestInfo(requestInfo).mdmsCriteria(mdmsCriteria).build();
	}

	/**
	 * Util method to return Auditdetails for create and update processes
	 * 
	 * @param by
	 * @param isCreate
	 * @return
	 */
	public AuditDetails getAuditDetails(String by, Boolean isCreate) {

//		Long dt = new Date().getTime();
		Long dt = System.currentTimeMillis();
		if (isCreate)
			return AuditDetails.builder().createdBy(by).createdTime(dt).lastModifiedBy(by).lastModifiedTime(dt).build();
		else
			return AuditDetails.builder().lastModifiedBy(by).lastModifiedTime(dt).build();
	}

	/**
	 * Prepares request and uri for service type search from MDMS
	 * 
	 * @param uri
	 * @param tenantId
	 * @param department
	 * @param requestInfo
	 * @return MdmsCriteriaReq
	 * @author vishal
	 */
	public MdmsCriteriaReq prepareSearchRequestForServiceType(StringBuilder uri, String tenantId, String serviceCode,
			RequestInfo requestInfo) {
		uri.append(mdmsHost).append(mdmsEndpoint);
		MasterDetail masterDetail = org.egov.mdms.model.MasterDetail.builder()
				.name(PGRConstants.MDMS_SERVICETYPE_MASTER_NAME).filter("[?(@.serviceCode=='" + serviceCode + "')]")
				.build();
		if (!areInactiveComplaintCategoriesEnabled) {
			masterDetail.setFilter("[?((@.serviceCode=='" + serviceCode + "') && (@.active == true))]");
		}
		log.info("serviceCode:" + serviceCode);
		List<MasterDetail> masterDetails = new ArrayList<>();
		masterDetails.add(masterDetail);
		ModuleDetail moduleDetail = ModuleDetail.builder().moduleName(PGRConstants.MDMS_PGR_MOD_NAME)
				.masterDetails(masterDetails).build();
		List<ModuleDetail> moduleDetails = new ArrayList<>();
		moduleDetails.add(moduleDetail);
		MdmsCriteria mdmsCriteria = MdmsCriteria.builder().tenantId(tenantId).moduleDetails(moduleDetails).build();
		return MdmsCriteriaReq.builder().requestInfo(requestInfo).mdmsCriteria(mdmsCriteria).build();
	}

	/**
	 * Prepares request and uri for service type search from MDMS
	 * 
	 * @param uri
	 * @param tenantId
	 * @param department
	 * @param requestInfo
	 * @return MdmsCriteriaReq
	 * @author vishal
	 */
	public MdmsCriteriaReq prepareMdMsRequest(String tenantId, String fieldName, String values,
			RequestInfo requestInfo) {

		MasterDetail masterDetail = org.egov.mdms.model.MasterDetail.builder()
				.name(PGRConstants.MDMS_SERVICETYPE_MASTER_NAME)
				.filter("[?(@." + fieldName + " IN " + values + ")]." + PGRConstants.SERVICE_CODES).build();
		if (!areInactiveComplaintCategoriesEnabled) {
			masterDetail.setFilter(
					"[?((@." + fieldName + " IN " + values + ") && (@.active == true))]." + PGRConstants.SERVICE_CODES);
		}
		List<MasterDetail> masterDetails = new ArrayList<>();
		masterDetails.add(masterDetail);
		ModuleDetail moduleDetail = ModuleDetail.builder().moduleName(PGRConstants.MDMS_PGR_MOD_NAME)
				.masterDetails(masterDetails).build();
		List<ModuleDetail> moduleDetails = new ArrayList<>();
		moduleDetails.add(moduleDetail);
		MdmsCriteria mdmsCriteria = MdmsCriteria.builder().tenantId(tenantId).moduleDetails(moduleDetails).build();
		return MdmsCriteriaReq.builder().requestInfo(requestInfo).mdmsCriteria(mdmsCriteria).build();
	}

	public MdmsCriteriaReq prepareMdMsRequestForDept(StringBuilder uri, String tenantId, List<String> codes,
			RequestInfo requestInfo) {
		uri.append(mdmsHost).append(mdmsEndpoint);
		MasterDetail masterDetail = org.egov.mdms.model.MasterDetail.builder()
				.name(PGRConstants.MDMS_DEPT_MASTERS_MASTER_NAME).filter("[?(@.code IN " + codes + ")].name").build();
		List<MasterDetail> masterDetails = new ArrayList<>();
		masterDetails.add(masterDetail);
		ModuleDetail moduleDetail = ModuleDetail.builder().moduleName(PGRConstants.MDMS_COMMON_MASTERS_MODULE_NAME)
				.masterDetails(masterDetails).build();
		List<ModuleDetail> moduleDetails = new ArrayList<>();
		moduleDetails.add(moduleDetail);
		MdmsCriteria mdmsCriteria = MdmsCriteria.builder().tenantId(tenantId).moduleDetails(moduleDetails).build();
		return MdmsCriteriaReq.builder().requestInfo(requestInfo).mdmsCriteria(mdmsCriteria).build();
	}

	public MdmsCriteriaReq prepareMdMsRequestForDesignation(StringBuilder uri, String tenantId, String code,
			RequestInfo requestInfo) {
		uri.append(mdmsHost).append(mdmsEndpoint);
		MasterDetail masterDetail = org.egov.mdms.model.MasterDetail.builder()
				.name(PGRConstants.MDMS_DESIGNATION_MASTERS_MASTER_NAME).filter("[?(@.code=='" + code + "')].name")
				.build();
		List<MasterDetail> masterDetails = new ArrayList<>();
		masterDetails.add(masterDetail);
		ModuleDetail moduleDetail = ModuleDetail.builder().moduleName(PGRConstants.MDMS_COMMON_MASTERS_MODULE_NAME)
				.masterDetails(masterDetails).build();
		List<ModuleDetail> moduleDetails = new ArrayList<>();
		moduleDetails.add(moduleDetail);
		MdmsCriteria mdmsCriteria = MdmsCriteria.builder().tenantId(tenantId).moduleDetails(moduleDetails).build();
		return MdmsCriteriaReq.builder().requestInfo(requestInfo).mdmsCriteria(mdmsCriteria).build();
	}

	/**
	 * Prepares request and uri for service request search
	 * 
	 * @param uri
	 * @param serviceReqSearchCriteria
	 * @param requestInfo
	 * @return SearcherRequest
	 * @author vishal
	 * @throws JsonProcessingException
	 */
	public SearcherRequest prepareSearchRequestWithDetails(StringBuilder uri,
			ServiceReqSearchCriteria serviceReqSearchCriteria, RequestInfo requestInfo) {
		uri.append(searcherHost);
		String endPoint = searcherEndpoint.replace(MODULE_NAME, PGRConstants.SEARCHER_PGR_MOD_NAME).replace(SEARCH_NAME,
				PGRConstants.SEARCHER_SRSEARCH_DEF_NAME);
		uri.append(endPoint);
		serviceReqSearchCriteria.setNoOfRecords(
				null == serviceReqSearchCriteria.getNoOfRecords() ? 30L : serviceReqSearchCriteria.getNoOfRecords()); // be
																														// default
																														// we
																														// retrieve
																														// 200
																														// records.
		serviceReqSearchCriteria
				.setOffset(null == serviceReqSearchCriteria.getOffset() ? 0L : serviceReqSearchCriteria.getOffset());
		/**
		 * This if block is to support substring search on servicerequestid without
		 * changing the contract. Query uses an IN clause which doesn't support
		 * substring search, therefore a new temp variable is added.
		 */
		if (!CollectionUtils.isEmpty(serviceReqSearchCriteria.getServiceRequestId())
				&& serviceReqSearchCriteria.getServiceRequestId().size() == 1) {
			ObjectMapper mapper = getObjectMapper();
			Map<String, Object> mapOfValues = mapper.convertValue(serviceReqSearchCriteria, Map.class);
			mapOfValues.put("complaintId", serviceReqSearchCriteria.getServiceRequestId().get(0));
			mapOfValues.put("serviceRequestId", null);
			return SearcherRequest.builder().requestInfo(requestInfo).searchCriteria(mapOfValues).build();
		} else {
			return SearcherRequest.builder().requestInfo(requestInfo).searchCriteria(serviceReqSearchCriteria).build();
		}
	}

	/**
	 * Prepares request and uri for service request search
	 * 
	 * @param uri
	 * @param serviceReqSearchCriteria
	 * @param requestInfo
	 * @return SearcherRequest
	 * @author vishal
	 * @throws JsonProcessingException
	 */
	public SearcherRequest preparePlainSearchReq(StringBuilder uri, ServiceReqSearchCriteria serviceReqSearchCriteria,
			RequestInfo requestInfo) {
		uri.append(searcherHost);
		String endPoint = searcherEndpoint.replace(MODULE_NAME, PGRConstants.SEARCHER_PGR_MOD_NAME).replace(SEARCH_NAME,
				PGRConstants.SEARCHER_PLAINSEARCH_DEF_NAME);
		uri.append(endPoint);
		serviceReqSearchCriteria.setNoOfRecords(
				null == serviceReqSearchCriteria.getNoOfRecords() ? 200L : serviceReqSearchCriteria.getNoOfRecords()); // be
																														// default
																														// we
																														// retrieve
																														// 200
																														// records.
		serviceReqSearchCriteria
				.setOffset(null == serviceReqSearchCriteria.getOffset() ? 0L : serviceReqSearchCriteria.getOffset());
		return SearcherRequest.builder().requestInfo(requestInfo).searchCriteria(serviceReqSearchCriteria).build();
	}

	/**
	 * Prepares request and uri for service request search
	 * 
	 * @param uri
	 * @param serviceReqSearchCriteria
	 * @param requestInfo
	 * @return SearcherRequest
	 * @author vishal
	 */
	public SearcherRequest prepareSearchRequestForAssignedTo(StringBuilder uri,
			ServiceReqSearchCriteria serviceReqSearchCriteria, RequestInfo requestInfo) {
		uri.append(searcherHost);
		String endPoint = searcherEndpoint.replace(MODULE_NAME, PGRConstants.SEARCHER_PGR_MOD_NAME).replace(SEARCH_NAME,
				PGRConstants.SEARCHER_SRID_ASSIGNEDTO_DEF_NAME);
		uri.append(endPoint);
		return SearcherRequest.builder().requestInfo(requestInfo).searchCriteria(serviceReqSearchCriteria).build();
	}

	/**
	 * Prepares request and uri for service request search
	 * 
	 * @param uri
	 * @param serviceReqSearchCriteria
	 * @param requestInfo
	 * @return SearcherRequest
	 * @author vishal
	 */
	public SearcherRequest prepareCountRequestWithDetails(StringBuilder uri,
			ServiceReqSearchCriteria serviceReqSearchCriteria, RequestInfo requestInfo) {
		uri.append(searcherHost);
		String endPoint = searcherEndpoint.replace(MODULE_NAME, PGRConstants.SEARCHER_PGR_MOD_NAME).replace(SEARCH_NAME,
				PGRConstants.SEARCHER_COUNT_DEF_NAME);
		uri.append(endPoint);
		return SearcherRequest.builder().requestInfo(requestInfo).searchCriteria(serviceReqSearchCriteria).build();
	}

	public MdmsCriteriaReq prepareServiceDefSearchMdmsRequest(StringBuilder uri, String tenantId,
			RequestInfo requestInfo) {
		uri.append(mdmsHost).append(mdmsEndpoint);
		MasterDetail masterDetail = org.egov.mdms.model.MasterDetail.builder()
				.name(PGRConstants.MDMS_SERVICETYPE_MASTER_NAME).build();
		if (!areInactiveComplaintCategoriesEnabled) {
			masterDetail.setFilter("[?(@.active == true)]");
		}
		List<MasterDetail> masterDetails = new ArrayList<>();
		masterDetails.add(masterDetail);
		ModuleDetail moduleDetail = ModuleDetail.builder().moduleName(PGRConstants.MDMS_PGR_MOD_NAME)
				.masterDetails(masterDetails).build();
		List<ModuleDetail> moduleDetails = new ArrayList<>();
		moduleDetails.add(moduleDetail);
		MdmsCriteria mdmsCriteria = MdmsCriteria.builder().tenantId(tenantId).moduleDetails(moduleDetails).build();
		return MdmsCriteriaReq.builder().requestInfo(requestInfo).mdmsCriteria(mdmsCriteria).build();
	}

	public RequestInfoWrapper prepareRequestForEmployeeSearch(StringBuilder uri, RequestInfo requestInfo,
			ServiceReqSearchCriteria serviceReqSearchCriteria) {
		RequestInfoWrapper requestInfoWrapper = new RequestInfoWrapper();
		requestInfoWrapper.setRequestInfo(requestInfo);
		uri.append(egovHRMShost).append(egovHRMSSearchEndpoint).append("?ids=" + requestInfo.getUserInfo().getId())
				.append("&tenantId=" + serviceReqSearchCriteria.getTenantId());

		return requestInfoWrapper;
	}

	public RequestInfoWrapper prepareRequestForLocalization(StringBuilder uri, RequestInfo requestInfo, String locale,
			String tenantId, String module) {
		RequestInfoWrapper requestInfoWrapper = new RequestInfoWrapper();
		requestInfoWrapper.setRequestInfo(requestInfo);
		uri.append(localizationHost).append(localizationSearchEndpoint).append("?tenantId=" + tenantId)
				.append("&module=" + module).append("&locale=" + locale);

		return requestInfoWrapper;
	}

	public RequestInfoWrapper prepareRequestForLocation(StringBuilder uri, RequestInfo requestInfo, String boundaryType,
			String tenantId, String hierarchyType, List<String> mohallaCodes) {
		RequestInfoWrapper requestInfoWrapper = new RequestInfoWrapper();
		requestInfoWrapper.setRequestInfo(requestInfo);
		String codes = mohallaCodes.toString().substring(1, mohallaCodes.toString().length() - 1);
		uri.append(locationHost).append(locationSearchEndpoint).append("?tenantId=" + tenantId)
				.append("&hierarchyTypeCode=" + hierarchyType).append("&boundaryType=" + boundaryType)
				.append("&codes=" + codes);

		return requestInfoWrapper;
	}

	public Map<String, Object> prepareRequestForUserSearch(StringBuilder uri, RequestInfo requestInfo, String userId,
			String tenantId) {
		Map<String, Object> userServiceRequest = new HashMap();
		String[] userIds = { userId };
		userServiceRequest.put("RequestInfo", requestInfo);
		userServiceRequest.put("tenantId", tenantId);
		userServiceRequest.put("id", Arrays.asList(userIds));
		userServiceRequest.put("userType", PGRConstants.ROLE_CITIZEN);

		uri.append(egovUserHost).append(egovUserSearchEndpoint);

		return userServiceRequest;
	}

	/**
	 * Default response is responseInfo with error status and empty lists
	 * 
	 * @param requestInfo
	 * @return ServiceResponse
	 */
	public ServiceResponse getDefaultServiceResponse(RequestInfo requestInfo) {
		return new ServiceResponse(factory.createResponseInfoFromRequestInfo(requestInfo, false),
				new ArrayList<Service>(), new ArrayList<ActionHistory>(), new ArrayList<ServiceRequestComplaints>());
	}

	/**
	 * Default response is responseInfo with error status and zero count
	 * 
	 * @param requestInfo
	 * @return CountResponse
	 */
	public CountResponse getDefaultCountResponse(RequestInfo requestInfo) {
		return new CountResponse(factory.createResponseInfoFromRequestInfo(requestInfo, false), 0D);
	}

	/**
	 * Returns mapper with all the appropriate properties reqd in our
	 * functionalities.
	 * 
	 * @return ObjectMapper
	 */
	public ObjectMapper getObjectMapper() {
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);

		return mapper;
	}

	/**
	 * prepares and returns a map with integer keys starting from zero and values as
	 * role codes the integer values decides the precedence by which actions should
	 * be applied among there roles
	 */
	private static Map<Integer, String> prepareEmployeeRolesPrecedenceMap() {

		Map<Integer, String> map = new TreeMap<>();

		map.put(3, PGRConstants.ROLE_EMPLOYEE);
		map.put(2, PGRConstants.ROLE_DGRO);
		map.put(1, PGRConstants.ROLE_GRO);
		map.put(0, PGRConstants.ROLE_CSR);

		return map;
	}

	/**
	 * @return employeeRolesPrecedenceMap
	 */
	public static Map<Integer, String> getEmployeeRolesPrecedenceMap() {
		return employeeRolesPrecedenceMap;
	}

	/**
	 * Helper method which returns the precedent role among all the given roles
	 * 
	 * The employee precedent map is a tree map which will have the roles ordered
	 * based on their keys precedence
	 * 
	 * The method will fail if the list of roles is null, so the parameter must be
	 * null checked
	 * 
	 * If the none of roles in the precedence map has a match in roles object then
	 * the method will return null
	 */
	public String getPrecedentRole(List<String> roles) {
		if (roles.contains(PGRConstants.ROLE_CITIZEN)) {
			return PGRConstants.ROLE_CITIZEN;
		}
		if (roles.contains(PGRConstants.ROLE_SYSTEM)) {
			return PGRConstants.ROLE_SYSTEM;
		}
		for (Entry<Integer, String> entry : PGRUtils.getEmployeeRolesPrecedenceMap().entrySet()) {
			String currentValue = entry.getValue();
			if (roles.contains(currentValue))
				return currentValue;
		}
		return null;
	}

	/**
	 * Returns the roles that need to receive notification at this status and
	 * action.
	 * 
	 * @param status
	 * @param action
	 * @return Set
	 */
	public Set<String> getReceptorsOfNotification(String status, String action) {
		Set<String> setOfRoles = new HashSet<>();
		setOfRoles.addAll(WorkFlowConfigs.getMapOfStatusAndReceptors().get(status));
		if (!StringUtils.isEmpty(action)
				&& (action.equals(WorkFlowConfigs.ACTION_REASSIGN) || action.equals(WorkFlowConfigs.ACTION_REOPEN))) {
			setOfRoles.clear();
			setOfRoles.addAll(WorkFlowConfigs.getMapOfActionAndReceptors().get(action));
		}
		return setOfRoles;
	}

	/**
	 * Splits any camelCase to human readable string
	 * 
	 * @param String
	 * @return String
	 */
	public static String splitCamelCase(String s) {
		return s.replaceAll(String.format("%s|%s|%s", "(?<=[A-Z])(?=[A-Z][a-z])", "(?<=[^A-Z])(?=[A-Z])",
				"(?<=[A-Za-z])(?=[^A-Za-z])"), " ");
	}

	public Long convertToMilliSec(Integer hours) {
		Long milliseconds = TimeUnit.SECONDS.toMillis(TimeUnit.HOURS.toSeconds(hours));
		log.info("SLA in ms: " + milliseconds);
		return milliseconds;
	}

	/**
	 * helper method which collects the service code from services obtained by
	 * databse call
	 * 
	 * @param tenantId
	 * @param inputCodes
	 * @param requestInfo
	 * @return
	 */
	public List<String> getServiceCodes(String tenantId, Set<String> inputCodes, RequestInfo requestInfo) {

		StringBuilder uri = new StringBuilder(mdmsHost).append(mdmsEndpoint);
		MdmsCriteriaReq criteriaReq = prepareMdMsRequest(tenantId.split("\\.")[0], PGRConstants.SERVICE_CODES,
				inputCodes.toString(), requestInfo);
		try {
			Object result = serviceRequestRepository.fetchResult(uri, criteriaReq);
			return JsonPath.read(result, PGRConstants.JSONPATH_SERVICEDEFS);
		} catch (Exception e) {
			log.info("Exception while fetching serviceDefs: ", e);
			throw new CustomException(ErrorConstants.INVALID_TENANT_ID_MDMS_SERVICE_CODE_KEY,
					ErrorConstants.INVALID_TENANT_ID_MDMS_SERVICE_CODE_MSG);
		}
	}

	/**
	 * returns the current status of the service
	 * 
	 * @param requestInfo
	 * @param actionInfo
	 * @param currentStatusList
	 * @return
	 */
	public String getCurrentStatus(ActionHistory history) {
		List<ActionInfo> infos = history.getActions();
		// FIXME pickup latest status another way which is not hardocoded, put query to
		// searcher to pick latest status
		// or use status from service object
		for (int i = 0; i <= infos.size() - 1; i++) {
			String status = infos.get(i).getStatus();
			if (null != status) {
				return status;
			}
		}
		return null;
	}

	/**
	 * helper method to add the errors to the error map
	 * 
	 * @param errorMsg
	 * @param key
	 * @param errorMap
	 */
	private void addError(String errorMsg, String key, Map<String, List<String>> errorMap) {

		List<String> errors = errorMap.get(key);
		if (null == errors) {
			errors = Arrays.asList(errorMsg);
			errorMap.put(key, errors);
		} else
			errors.add(errorMsg);
	}

	/**
	 * Prepares request and uri for service request search
	 * 
	 * @param uri
	 * @param tenantId
	 * @param requestInfo
	 * @return MdmsCriteriaReq
	 * @author Tonmoy
	 */
	public MdmsCriteriaReq prepareAutoroutingEscalationMapSearchMdmsRequestByCategoryAndSector(StringBuilder uri,
			String tenantId, String category, String sector, RequestInfo requestInfo) {

		uri.append(mdmsHost).append(mdmsEndpoint);
		MasterDetail masterDetail = org.egov.mdms.model.MasterDetail.builder()
				.name(PGRConstants.MDMS_AUTOROUTING_ESCALATION_MAP_MASTER_NAME).filter("[?(@.active == true)]").build();

		if (!StringUtils.isEmpty(category)) {
			masterDetail.setFilter("[?((@.category == '" + category + "') && (@.active == true))]");
		}
		List<MasterDetail> masterDetails = new ArrayList<>();
		masterDetails.add(masterDetail);
		ModuleDetail moduleDetail = ModuleDetail.builder().moduleName(PGRConstants.MDMS_PGR_MOD_NAME)
				.masterDetails(masterDetails).build();
		List<ModuleDetail> moduleDetails = new ArrayList<>();
		moduleDetails.add(moduleDetail);
		MdmsCriteria mdmsCriteria = MdmsCriteria.builder().tenantId(tenantId).moduleDetails(moduleDetails).build();
		return MdmsCriteriaReq.builder().requestInfo(requestInfo).mdmsCriteria(mdmsCriteria).build();
	}

	/**
	 * Check whether the complaint is reopened for 2nd time or not
	 * 
	 * @param actionInfo
	 * @return boolean
	 */
	public boolean checkReopen2ndTime(ActionHistory history, String action) {
		List<ActionInfo> infos = history.getActions();

		for (int i = 0; i <= infos.size() - 1; i++) {
			String status = infos.get(i).getStatus();
			if (WorkFlowConfigs.STATUS_ESCALATED_LEVEL1_PENDING.equalsIgnoreCase(status)
					&& WorkFlowConfigs.ACTION_REOPEN.equalsIgnoreCase(action)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Check whether the escalated complaint is resolving/rejecting by any employee
	 * 
	 * @param actionInfo
	 * @return boolean
	 */
	public boolean checkComplaintAlreadyEscalated(ActionHistory history, String action) {
		List<ActionInfo> infos = history.getActions();

		for (int i = 0; i <= infos.size() - 1; i++) {
			String status = infos.get(i).getStatus();
			if ((WorkFlowConfigs.STATUS_ESCALATED_LEVEL1_PENDING.equalsIgnoreCase(status)
					|| WorkFlowConfigs.STATUS_ESCALATED_LEVEL2_PENDING.equalsIgnoreCase(status))
					&& (WorkFlowConfigs.ACTION_RESOLVE.equalsIgnoreCase(action)
							|| WorkFlowConfigs.ACTION_REJECT.equalsIgnoreCase(action))) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Prepares request and uri for service request search
	 * 
	 * @param uri
	 * @param tenantId
	 * @param employeCode
	 * @param escalationOfficer
	 * @param requestInfo
	 * @return MdmsCriteriaReq
	 * @author Tonmoy
	 */
	public MdmsCriteriaReq prepareCategoryMdmsRequestByEscalationOfficer(StringBuilder uri, String tenantId,
			RequestInfo requestInfo) {

		uri.append(mdmsHost).append(mdmsEndpoint);
		MasterDetail masterDetail = org.egov.mdms.model.MasterDetail.builder()
				.name(PGRConstants.MDMS_AUTOROUTING_ESCALATION_MAP_MASTER_NAME).filter("[?(@.active == true)]").build();

		List<MasterDetail> masterDetails = new ArrayList<>();
		masterDetails.add(masterDetail);
		ModuleDetail moduleDetail = ModuleDetail.builder().moduleName(PGRConstants.MDMS_PGR_MOD_NAME)
				.masterDetails(masterDetails).build();
		List<ModuleDetail> moduleDetails = new ArrayList<>();
		moduleDetails.add(moduleDetail);
		MdmsCriteria mdmsCriteria = MdmsCriteria.builder().tenantId(tenantId).moduleDetails(moduleDetails).build();
		return MdmsCriteriaReq.builder().requestInfo(requestInfo).mdmsCriteria(mdmsCriteria).build();
	}

	/**
	 * Prepares request and uri for PGR department search from MDMS
	 * 
	 * @param uri
	 * @param tenantId
	 * @param departmentCode
	 * @param requestInfo
	 * @return MdmsCriteriaReq
	 * @author Tonmoy
	 */
	public MdmsCriteriaReq prepareSearchRequestForPgrDepartment(StringBuilder uri, String tenantId,
			String departmentCode, RequestInfo requestInfo) {
		uri.append(mdmsHost).append(mdmsEndpoint);

		MasterDetail masterDetail = org.egov.mdms.model.MasterDetail.builder()
				.name(PGRConstants.MDMS_PGR_DEPARTMENT_MASTER_NAME).build();
		masterDetail.setFilter("[?((@.code == " + departmentCode + ") && (@.active == true))]");
		List<MasterDetail> masterDetails = new ArrayList<>();
		masterDetails.add(masterDetail);
		ModuleDetail moduleDetail = ModuleDetail.builder().moduleName(PGRConstants.MDMS_PGR_MOD_NAME)
				.masterDetails(masterDetails).build();
		List<ModuleDetail> moduleDetails = new ArrayList<>();
		moduleDetails.add(moduleDetail);
		MdmsCriteria mdmsCriteria = MdmsCriteria.builder().tenantId(tenantId).moduleDetails(moduleDetails).build();
		return MdmsCriteriaReq.builder().requestInfo(requestInfo).mdmsCriteria(mdmsCriteria).build();
	}

	/**
	 * Check whether the complaint is auto escalated without resolved
	 * 
	 * @param actionInfo
	 * @return boolean
	 */
	public boolean checkAutoEscalatedWithoutResolved(ActionHistory history) {

		List<String> status = history.getActions().stream().map(ActionInfo::getStatus).collect(Collectors.toList());

		if (status.contains(WorkFlowConfigs.STATUS_ESCALATED_LEVEL1_PENDING)
				&& !status.contains(WorkFlowConfigs.STATUS_RESOLVED)) {
			return true;
		}
		return false;
	}

	public long getLastDayTime(long time) {
		log.info("Before sla end time set to midnight:" + time);
		Calendar calendar = Calendar.getInstance();
		log.info("Calender time:" + calendar.getTimeInMillis());
		calendar.setTimeInMillis(time);
		log.info("After setting time to Calender:" + calendar.getTimeInMillis());
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		calendar.set(Calendar.MILLISECOND, 999);
		log.info("After sla end time set to midnight:" + calendar.getTimeInMillis());
		return calendar.getTimeInMillis();
	}

	public long getLastDayTime(int slaDays) {

		LocalDate today = LocalDate.now(ZoneId.of("Asia/Kolkata"));
		LocalDateTime todayMidnight = today.atTime(LocalTime.MAX);
		LocalDateTime slaendMidnight = todayMidnight.plusDays(slaDays);
		log.info("SLA end Date Midnight in IST=" + slaendMidnight);
		return slaendMidnight.atZone(ZoneId.of("Asia/Kolkata")).toInstant().toEpochMilli();
	}

	public MdmsCriteriaReq prepareSearchRequestForAllServiceCodes(StringBuilder uri, String tenantId,
			RequestInfo requestInfo) {
		uri.append(mdmsHost).append(mdmsEndpoint);
		MasterDetail masterDetail = org.egov.mdms.model.MasterDetail.builder()
				.name(PGRConstants.MDMS_SERVICETYPE_MASTER_NAME).build();

		List<MasterDetail> masterDetails = new ArrayList<>();
		masterDetails.add(masterDetail);
		ModuleDetail moduleDetail = ModuleDetail.builder().moduleName(PGRConstants.MDMS_PGR_MOD_NAME)
				.masterDetails(masterDetails).build();
		List<ModuleDetail> moduleDetails = new ArrayList<>();
		moduleDetails.add(moduleDetail);
		MdmsCriteria mdmsCriteria = MdmsCriteria.builder().tenantId(tenantId).moduleDetails(moduleDetails).build();
		return MdmsCriteriaReq.builder().requestInfo(requestInfo).mdmsCriteria(mdmsCriteria).build();
	}

	public ReportRequest prepareSearchGrievancesSLAAchievement(StringBuilder uri, String tenantId, Long fromDate,
			Long toDate, RequestInfo requestInfo) {
		uri.append(reportHost).append(reportEndpoint);
		List<ParamValue> searchParams = Arrays.asList(ParamValue.builder().name("fromDate").input(fromDate).build(),
				ParamValue.builder().name("toDate").input(toDate).build());
		return ReportRequest.builder().tenantId(tenantId).reportName("SLAAchievementDepartmentWise")
				.requestInfo(requestInfo).searchParams(searchParams).build();
	}
	
	
	@SuppressWarnings("unchecked")
	@Cacheable(value = "messages", key = "#tenantId")
	public String getLocalizationMessages(String tenantId, RequestInfo requestInfo) {
		log.info("Fetching localization messages for {}", tenantId);
		LinkedHashMap<String, Object> responseMap = (LinkedHashMap<String, Object>) serviceRequestRepository
				.fetchResult(getUri(tenantId, requestInfo), requestInfo);
		String jsonString = new JSONObject(responseMap).toString();
		return jsonString;
	}
	
	private StringBuilder getUri(String tenantId, RequestInfo requestInfo) {

		tenantId = tenantId.split("\\.")[0];

		String locale = PGRConstants.NOTIFICATION_LOCALE;
		if (!StringUtils.isEmpty(requestInfo.getMsgId()) && requestInfo.getMsgId().split("|").length >= 2) {
			locale = requestInfo.getMsgId().split("\\|")[1];
		}

		StringBuilder uri = new StringBuilder();
		uri.append(localizationHost).append(localizationSearchEndpoint).append("?").append("locale=").append(locale)
				.append("&tenantId=").append(tenantId).append("&module=").append(PGRConstants.LOCALIZATION_MODULE_NAME);

		return uri;
	}
	
	// L3 SMS Template
	public String getPublicHealthTemplate(Map<String,Integer> sePublicHealthCounts, String localizationMessages) {
		String messageTemplate = getMessageTemplate(PGRConstants.LOCALIZATION_CODE_PH, localizationMessages);
	    messageTemplate = messageTemplate.replace("<count1>", String.valueOf(sePublicHealthCounts.getOrDefault("Division1", 0))+ "\n");
	    messageTemplate = messageTemplate.replace("<count2>", String.valueOf(sePublicHealthCounts.getOrDefault("Division2", 0))+ "\n");
	    messageTemplate = messageTemplate.replace("<count3>", String.valueOf(sePublicHealthCounts.getOrDefault("Division3", 0))+ "\n");
	    messageTemplate = messageTemplate.replace("<count4>", String.valueOf(sePublicHealthCounts.getOrDefault("Division4", 0))+ "\n");

	    return messageTemplate;
	}
	
	public String getBRTemplate(Map<String,Integer> seBRCounts, String localizationMessages) {
		String messageTemplate = getMessageTemplate(PGRConstants.LOCALIZATION_CODE_BR, localizationMessages);
	    messageTemplate = messageTemplate.replace("<count1>", String.valueOf(seBRCounts.getOrDefault("Division1", 0))+ "\n");
	    messageTemplate = messageTemplate.replace("<count2>", String.valueOf(seBRCounts.getOrDefault("Division2", 0))+ "\n");
	    messageTemplate = messageTemplate.replace("<count3>", String.valueOf(seBRCounts.getOrDefault("Division3", 0))+ "\n");

	    return messageTemplate;
	}
	
	public String getHETemplate(Map<String,Integer> seHECounts, String localizationMessages) {
		String messageTemplate = getMessageTemplate(PGRConstants.LOCALIZATION_CODE_HE, localizationMessages);
	    messageTemplate = messageTemplate.replace("<count1>", String.valueOf(seHECounts.getOrDefault("Horticulture 1", 0))+ "\n");
	    messageTemplate = messageTemplate.replace("<count2>", String.valueOf(seHECounts.getOrDefault("Horticulture 2", 0))+ "\n");
	    messageTemplate = messageTemplate.replace("<count3>", String.valueOf(seHECounts.getOrDefault("Electrical", 0))+ "\n");

	    return messageTemplate;
	}
	
	public String getMOHTemplate(Map<String,Integer> mohCounts, String localizationMessages) {
		String messageTemplate = getMessageTemplate(PGRConstants.LOCALIZATION_CODE_MOH, localizationMessages);
	    messageTemplate = messageTemplate.replace("<count1>", String.valueOf(mohCounts.getOrDefault("Health and sanitation", 0))+ "\n");

	    return messageTemplate;
	}
	
	// L4 SMS Template
	public String getCETemplate(Map<String,Integer> CECounts, String localizationMessages) {
		String messageTemplate = getMessageTemplate(PGRConstants.LOCALIZATION_CODE_CE, localizationMessages);
	    messageTemplate = messageTemplate.replace("<count1>", String.valueOf(CECounts.getOrDefault("SE Office B&R", 0))+ "\n");
	    messageTemplate = messageTemplate.replace("<count2>", String.valueOf(CECounts.getOrDefault("SE Office PH", 0))+ "\n");
	    messageTemplate = messageTemplate.replace("<count3>", String.valueOf(CECounts.getOrDefault("SE Office H&E", 0))+ "\n");

	    return messageTemplate;
	}
	
	public String getJCMC1Template(Map<String,Integer> JCMC1Counts, String localizationMessages) {
		String messageTemplate = getMessageTemplate(PGRConstants.LOCALIZATION_CODE_JCMC1, localizationMessages);
	    messageTemplate = messageTemplate.replace("<count1>", String.valueOf(JCMC1Counts.getOrDefault("Health and Sanitation", 0))+ "\n");
	    messageTemplate = messageTemplate.replace("<count2>", String.valueOf(JCMC1Counts.getOrDefault("Birth And Death", 0))+ "\n");
	    messageTemplate = messageTemplate.replace("<count3>", String.valueOf(JCMC1Counts.getOrDefault("Accounts Branch", 0))+ "\n");
	    messageTemplate = messageTemplate.replace("<count4>", String.valueOf(JCMC1Counts.getOrDefault("House allotment committee", 0))+ "\n");
	    messageTemplate = messageTemplate.replace("<count5>", String.valueOf(JCMC1Counts.getOrDefault("Parking Branch", 0))+ "\n");
	    messageTemplate = messageTemplate.replace("<count6>", String.valueOf(JCMC1Counts.getOrDefault("Colony Branch", 0))+ "\n");
	    messageTemplate = messageTemplate.replace("<count7>", String.valueOf(JCMC1Counts.getOrDefault("Mechanical Wing", 0))+ "\n");
	    messageTemplate = messageTemplate.replace("<count8>", String.valueOf(JCMC1Counts.getOrDefault("Pension Branch", 0))+ "\n");

	    return messageTemplate;
	}
	
	public String getJCMC2Template(Map<String,Integer> JCMC2Counts, String localizationMessages) {
		String messageTemplate = getMessageTemplate(PGRConstants.LOCALIZATION_CODE_JCMC2, localizationMessages);
	    messageTemplate = messageTemplate.replace("<count1>", String.valueOf(JCMC2Counts.getOrDefault("Fire Wing", 0))+ "\n");
	    messageTemplate = messageTemplate.replace("<count2>", String.valueOf(JCMC2Counts.getOrDefault("Enforcement Branch", 0))+ "\n");
	    messageTemplate = messageTemplate.replace("<count3>", String.valueOf(JCMC2Counts.getOrDefault("NULM", 0))+ "\n");
	    messageTemplate = messageTemplate.replace("<count4>", String.valueOf(JCMC2Counts.getOrDefault("Public relation Wing", 0))+ "\n");

	    return messageTemplate;
	}
	
	public String getJCMC3Template(Map<String,Integer> JCMC3Counts, String localizationMessages) {
		String messageTemplate = getMessageTemplate(PGRConstants.LOCALIZATION_CODE_JCMC3, localizationMessages);
	    messageTemplate = messageTemplate.replace("<count1>", String.valueOf(JCMC3Counts.getOrDefault("Sub-Office Manimajra", 0))+ "\n");
	    messageTemplate = messageTemplate.replace("<count2>", String.valueOf(JCMC3Counts.getOrDefault("Tax Branch", 0))+ "\n");
	    messageTemplate = messageTemplate.replace("<count3>", String.valueOf(JCMC3Counts.getOrDefault("Apni &Day Mandi", 0))+ "\n");
	    messageTemplate = messageTemplate.replace("<count4>", String.valueOf(JCMC3Counts.getOrDefault("Booking Branch/Advertisement", 0))+ "\n");
	    messageTemplate = messageTemplate.replace("<count5>", String.valueOf(JCMC3Counts.getOrDefault("Estate Branch", 0))+ "\n");
	    messageTemplate = messageTemplate.replace("<count6>", String.valueOf(JCMC3Counts.getOrDefault("Computer cell", 0))+ "\n");
	    messageTemplate = messageTemplate.replace("<count7>", String.valueOf(JCMC3Counts.getOrDefault("Building Branch", 0))+ "\n");

	    return messageTemplate;
	}
	
	// L5 SMS Template
		public String getCommissionerTemplate(Map<String,Integer> CommissionerCounts, String localizationMessages) {
			String messageTemplate = getMessageTemplate(PGRConstants.LOCALIZATION_CODE_COMMISSIONER, localizationMessages);
		    messageTemplate = messageTemplate.replace("<count1>", String.valueOf(CommissionerCounts.getOrDefault("CE office", 0))+ "\n");
		    messageTemplate = messageTemplate.replace("<count2>", String.valueOf(CommissionerCounts.getOrDefault("JCMCC 1", 0))+ "\n");
		    messageTemplate = messageTemplate.replace("<count3>", String.valueOf(CommissionerCounts.getOrDefault("JCMCC 2", 0))+ "\n");
		    messageTemplate = messageTemplate.replace("<count4>", String.valueOf(CommissionerCounts.getOrDefault("JCMCC 3", 0))+ "\n");

		    return messageTemplate;
		}
		
		// escalationofficerone SMS Template
		public String getEscalationofficerOneTemplate(String extractedCategory,String servicerequestid,String complaintname,
						String contact,String sector, String localizationMessages) {
					String messageTemplate = getMessageTemplate(PGRConstants.LOCALIZATION_CODE_ESCALATION_OFFICER_ONE, localizationMessages);
				    
				    messageTemplate = messageTemplate.replace("<count1>", extractedCategory != null ? extractedCategory : "N/A");
				    messageTemplate = messageTemplate.replace("<count2>", servicerequestid != null ? servicerequestid : "N/A");
				    messageTemplate = messageTemplate.replace("<count3>", complaintname != null ? complaintname : "N/A");
				    messageTemplate = messageTemplate.replace("<count4>", contact != null ? contact : "N/A");
				    messageTemplate = messageTemplate.replace("<count5>", sector != null ? sector : "N/A");

				    return messageTemplate;
				}
		
		// escalationofficertwo SMS Template
				public String getEscalationofficerTwoTemplate(String extractedCategory,String servicerequestid,String complaintname,
								String contact,String sector, String localizationMessages) {
							String messageTemplate = getMessageTemplate(PGRConstants.LOCALIZATION_CODE_ESCALATION_OFFICER_TWO, localizationMessages);
						    
						    messageTemplate = messageTemplate.replace("<count1>", extractedCategory != null ? extractedCategory : "N/A");
						    messageTemplate = messageTemplate.replace("<count2>", servicerequestid != null ? servicerequestid : "N/A");
						    messageTemplate = messageTemplate.replace("<count3>", complaintname != null ? complaintname : "N/A");
						    messageTemplate = messageTemplate.replace("<count4>", contact != null ? contact : "N/A");
						    messageTemplate = messageTemplate.replace("<count5>", sector != null ? sector : "N/A");

						    return messageTemplate;
						}
	
	@SuppressWarnings("unchecked")
	public String getMessageTemplate(String notificationCode, String localizationMessage) {
		String path = "$..messages[?(@.code==\"{}\")].message";
		path = path.replace("{}", notificationCode);
		String message = null;
		try {
			Object messageObj = JsonPath.parse(localizationMessage).read(path);
			message = ((ArrayList<String>) messageObj).get(0);
		} catch (Exception e) {
			// log.warn("Fetching from localization failed", e);
			return "" + e;
		}
		return message;
	}
	
	/**
	 * Creates sms request for the each owners
	 * 
	 * @param message                 The message for the specific ownershipTransfer
	 * @param mobileNumberToOwnerName Map of mobileNumber to OwnerName
	 * @return List of SMSRequest
	 */
	public List<SMSRequest> createSMSRequest(String message, Map<String, String> mobileNumberToOwner) {
		List<SMSRequest> smsRequest = new LinkedList<>();
		for (Map.Entry<String, String> entryset : mobileNumberToOwner.entrySet()) {
			String customizedMsg = message.replace("<1>", entryset.getValue());
			smsRequest.add(new SMSRequest(entryset.getKey(), customizedMsg,entryset.getValue()));
			//smsRequest.add(new SMSRequest(entryset.getValue(), customizedMsg));
		}
		return smsRequest;
	}
	
	public void sendSMS(List<SMSRequest> smsRequestsList, boolean isSMSEnabled) {
		if (isSMSEnabled) {
			if (CollectionUtils.isEmpty(smsRequestsList)) {
				// log.info("Messages from localization couldn't be fetched!");
			}
			for (SMSRequest smsRequest : smsRequestsList) {
				System.out.println("smsRequest ::"+smsRequest.getMobileNumber());
				///pGRProducer.push(smsNotifTopic, smsRequest);
				// log.info("MobileNumber: " + smsRequest.getMobileNumber() + " Messages: " +
				// smsRequest.getMessage());
			}
		}

	}
	
	
}
