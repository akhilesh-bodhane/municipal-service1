package org.egov.waterconnection.service;


import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.egov.common.contract.request.RequestInfo;
import org.egov.tracer.model.CustomException;
import org.egov.waterconnection.config.WSConfiguration;
import org.egov.waterconnection.constants.WCConstants;
import org.egov.waterconnection.model.AuditDetails;
import org.egov.waterconnection.model.Property;
import org.egov.waterconnection.model.PublicDashBoardSearchCritieria;
import org.egov.waterconnection.model.ResponseData;
import org.egov.waterconnection.model.SMSRequest;
import org.egov.waterconnection.model.SMSRequest.SMSRequestBuilder;
import org.egov.waterconnection.model.SearchCriteria;
import org.egov.waterconnection.model.SearchTotalCollectionCriteria;
import org.egov.waterconnection.model.WaterApplication;
import org.egov.waterconnection.model.WaterConnection;
import org.egov.waterconnection.model.WaterConnectionCount;
import org.egov.waterconnection.model.WaterConnectionRequest;
import org.egov.waterconnection.model.WaterNotication;
import org.egov.waterconnection.model.WaterNotificationRequest;
import org.egov.waterconnection.model.WaterTotalCollections;
import org.egov.waterconnection.model.metrics;
import org.egov.waterconnection.model.workflow.BusinessService;
import org.egov.waterconnection.producer.WaterConnectionProducer;
import org.egov.waterconnection.repository.WaterDao;
import org.egov.waterconnection.repository.WaterDaoImpl;
import org.egov.waterconnection.util.NotificationUtil;
import org.egov.waterconnection.util.WaterServicesUtil;
import org.egov.waterconnection.validator.ActionValidator;
import org.egov.waterconnection.validator.MDMSValidator;
import org.egov.waterconnection.validator.ValidateProperty;
import org.egov.waterconnection.validator.WaterConnectionValidator;
import org.egov.waterconnection.workflow.WorkflowIntegrator;
import org.egov.waterconnection.workflow.WorkflowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class WaterServiceImpl implements WaterService {

	@Autowired
	private WaterDao waterDao;
	
	@Autowired
	private WaterConnectionValidator waterConnectionValidator;

	@Autowired
	private ValidateProperty validateProperty;
	
	@Autowired
	private MDMSValidator mDMSValidator;

	@Autowired
	private EnrichmentService enrichmentService;
	
	@Autowired
	private WorkflowIntegrator wfIntegrator;
	
	@Autowired
	private WSConfiguration config;
	
	@Autowired
	private WorkflowService workflowService;
	
	@Autowired
	private ActionValidator actionValidator;
	
	@Autowired
	private WaterServicesUtil waterServiceUtil;
	
	@Autowired
	private CalculationService calculationService;
	
	@Autowired
	private WaterDaoImpl waterDaoImpl;
	
	@Autowired
	private ObjectMapper mapper;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private WaterServicesUtil wsUtil;
	
	@Autowired
	private WaterConnectionProducer wcProducer;
	
	@Autowired
	private NotificationUtil notificationUtil;
	
	public static final String TEMPLATE_NAME_SITE_INSPECTOR="siteInspector";
	public static final String TEMPLATE_NAME_CITIZEN_CASE1="citizen.case1";
	public static final String TEMPLATE_NAME_CITIZEN_CASE2="citizen.case2";
	public static final String TEMPLATE_NAME_CITIZEN_CASE3="citizen.case3";
	
	/**
	 * 
	 * @param waterConnectionRequest WaterConnectionRequest contains water connection to be created
	 * @return List of WaterConnection after create
	 */
	@Override
	public List<WaterConnection> createWaterConnection(WaterConnectionRequest waterConnectionRequest) {
		waterConnectionValidator.validateWaterConnection(waterConnectionRequest, false);
		Property property = validateProperty.getOrValidateProperty(waterConnectionRequest);
		enrichmentService.enrichWaterConnection(waterConnectionRequest);
		userService.createUser(waterConnectionRequest);
		// call work-flow
		if (config.getIsExternalWorkFlowEnabled())
			wfIntegrator.callWorkFlow(waterConnectionRequest, property);
		waterConnectionRequest.getWaterConnection().getWaterApplication().setApplicationStatus(
				waterConnectionRequest.getWaterConnection().getApplicationStatus());
		waterDao.saveWaterConnection(waterConnectionRequest);
		return Arrays.asList(waterConnectionRequest.getWaterConnection());
	}
	/**
	 * 
	 * @param criteria WaterConnectionSearchCriteria contains search criteria on water connection
	 * @param requestInfo 
	 * @return List of matching water connection
	 */
	public List<WaterConnection> search(SearchCriteria criteria, RequestInfo requestInfo) {
		List<WaterConnection> waterConnectionList;
		waterConnectionList = getWaterConnectionsList(criteria, requestInfo);
		waterConnectionValidator.validatePropertyForConnection(waterConnectionList);
		enrichmentService.enrichConnectionHolderDeatils(waterConnectionList, criteria, requestInfo);
		return waterConnectionList;
	}
	/**
	 * 
	 * @param criteria WaterConnectionSearchCriteria contains search criteria on water connection
	 * @param requestInfo 
	 * @return List of matching water connection
	 */
	public List<WaterConnection> getWaterConnectionsList(SearchCriteria criteria,
			RequestInfo requestInfo) {
		return waterDao.getWaterConnectionList(criteria, requestInfo);
	}
	/**
	 * 
	 * @param criteria WaterConnectionSearchCriteria contains search criteria on water connection
	 * @param requestInfo 
	 * @return List(Count) of matching water connection
	 */
	public List<WaterConnectionCount> searchCount(SearchCriteria criteria, RequestInfo requestInfo) {
		List<WaterConnectionCount> waterConnectionList;
		waterConnectionList = getWaterConnectionsListCount(criteria, requestInfo);
		return waterConnectionList;
	}
	/**
	 * 
	 * @param criteria WaterConnectionSearchCriteria contains search criteria on water connection
	 * @param requestInfo 
	 * @return List(Count) of matching water connection
	 */
	public List<WaterConnectionCount> getWaterConnectionsListCount(SearchCriteria criteria,
			RequestInfo requestInfo) {
		return waterDao.getWaterConnectionListCount(criteria, requestInfo);
	}
	/**
	 * 
	 * @param waterConnectionRequest WaterConnectionRequest contains water connection to be updated
	 * @return List of WaterConnection after update
	 */
	@Override
	public List<WaterConnection> updateWaterConnection(WaterConnectionRequest waterConnectionRequest) {
		log.info("Update WaterConnection: {}", waterConnectionRequest.getWaterConnection());
		waterConnectionValidator.validateWaterConnection(waterConnectionRequest, true);
		mDMSValidator.validateMasterData(waterConnectionRequest);
		
		if(null==waterConnectionRequest.getWaterConnection().getWaterProperty().getUsageCategory() ||
				waterConnectionRequest.getWaterConnection().getWaterProperty().getUsageCategory().isEmpty()) {
			waterConnectionRequest.getWaterConnection().getWaterProperty().setUsageCategory("TEMPORARY_CONSTRUCTION");
		}
		
		Property property = validateProperty.getOrValidateProperty(waterConnectionRequest);
		waterConnectionRequest.getWaterConnection().setProperty(property);
		validateProperty.validatePropertyCriteria(property);
		boolean isStateUpdatable = true;
		BusinessService businessService = null;
		if (WCConstants.ACTION_INITIATE.equalsIgnoreCase(
				waterConnectionRequest.getWaterConnection().getProcessInstance().getAction())) {
			waterConnectionRequest.getWaterConnection().setDocuments(null);
			enrichmentService.enrichWaterApplication(waterConnectionRequest);
			enrichmentService.enrichUpdateWaterConnection(waterConnectionRequest);
			waterConnectionRequest.getWaterConnection().setApplicationStatus(WCConstants.STATUS_INITIATED);
		}else {
			businessService = workflowService.getBusinessService(waterConnectionRequest.getWaterConnection().getTenantId(), 
					waterConnectionRequest.getRequestInfo(), waterConnectionRequest.getWaterConnection().getActivityType());
			log.info("businessService: {},Business: {}",businessService.getBusinessService(),businessService.getBusiness());
			WaterConnection searchResult = getConnectionForUpdateRequest(waterConnectionRequest.getWaterConnection().getWaterApplication().getId(), waterConnectionRequest.getRequestInfo());
			String previousApplicationStatus = workflowService.getApplicationStatus(waterConnectionRequest.getRequestInfo(),
					waterConnectionRequest.getWaterConnection().getApplicationNo(),
					waterConnectionRequest.getWaterConnection().getTenantId(),wfIntegrator.getBusinessService(waterConnectionRequest.getWaterConnection().getActivityType()));
			enrichmentService.enrichUpdateWaterConnection(waterConnectionRequest);
			actionValidator.validateUpdateRequest(waterConnectionRequest, businessService, previousApplicationStatus);
			waterConnectionValidator.validateUpdate(waterConnectionRequest, searchResult);
			calculationService.calculateFeeAndGenerateDemand(waterConnectionRequest, property);		
			//check for edit and send edit notification
			waterDaoImpl.pushForEditNotification(waterConnectionRequest);
			//Enrich file store Id After payment
			enrichmentService.enrichFileStoreIds(waterConnectionRequest);
			// Comment in Local
			userService.updateUser(waterConnectionRequest, searchResult);
			isStateUpdatable = waterServiceUtil.getStatusForUpdate(businessService, previousApplicationStatus);
		}
		//Call workflow
		//Comment in Local
		wfIntegrator.callWorkFlow(waterConnectionRequest, property);
	        if(WCConstants.WS_APPLY_FOR_TEMPORARY_CON.equalsIgnoreCase(waterConnectionRequest.getWaterConnection().getActivityType())) {
			enrichmentService.postStatusEnrichment(waterConnectionRequest, property);
		}
	
		waterConnectionRequest.getWaterConnection().getWaterApplication().setApplicationStatus(
				waterConnectionRequest.getWaterConnection().getApplicationStatus());
		waterConnectionRequest.getWaterConnection().getWaterApplication().setAction(
				waterConnectionRequest.getWaterConnection().getProcessInstance().getAction());
		
		log.info("Next applicationStatus: {}",waterConnectionRequest.getWaterConnection().getApplicationStatus());
		
		boolean isTerminateState = workflowService.isTerminateState(waterConnectionRequest.getWaterConnection().getApplicationStatus(), businessService);
		if(isTerminateState) {
			waterConnectionRequest.getWaterConnection().setInWorkflow(false);
		}
		waterDao.updateWaterConnection(waterConnectionRequest, isStateUpdatable);
		
	//	enrichmentService.postForMeterReading(waterConnectionRequest);
		return Arrays.asList(waterConnectionRequest.getWaterConnection());
	}
	

	@Override
	public List<WaterConnection> deactivateConnection(WaterConnectionRequest waterConnectionRequest) {

		waterDao.updateWaterConnection(waterConnectionRequest, false);
		
		return  Arrays.asList(waterConnectionRequest.getWaterConnection());
	}
	
	/**
	 * Search Water connection to be update
	 * 
	 * @param id
	 * @param requestInfo
	 * @return water connection
	 */
	public WaterConnection getConnectionForUpdateRequest(String id, RequestInfo requestInfo) {
		log.info("Water Application Id:{}",id);
		Set<String> ids = new HashSet<>(Arrays.asList(id));
		SearchCriteria criteria = new SearchCriteria();
		criteria.setIds(ids);
		List<WaterConnection> connections = getWaterConnectionsList(criteria, requestInfo);
		if (CollectionUtils.isEmpty(connections)) {
			StringBuilder builder = new StringBuilder();
			builder.append("WATER CONNECTION NOT FOUND FOR: ").append(id).append(" :ID");
			throw new CustomException("INVALID_WATERCONNECTION_SEARCH", builder.toString());
		}
			
		return connections.get(0);
	}
	@Override
	public List<WaterConnection> deleteConnectionMapping(WaterConnectionRequest waterConnectionRequest) {
		waterDao.deleteConnectionMapping(waterConnectionRequest);
		return  Arrays.asList(waterConnectionRequest.getWaterConnection());
	}
	@Override
	public List<WaterConnection> addConnectionMapping(WaterConnectionRequest waterConnectionRequest) {
		//Added Application Data for changes in water connection holder changes 
		AuditDetails auditDetails = wsUtil
				.getAuditDetails(waterConnectionRequest.getRequestInfo().getUserInfo().getUuid(), true);		 
		waterConnectionRequest.getWaterConnection().setAuditDetails(auditDetails);
		WaterApplication waterApplication = new WaterApplication();
		waterApplication.setId(UUID.randomUUID().toString());
		waterConnectionRequest.getWaterConnection().setWaterApplication(waterApplication);
		waterDao.addConnectionMapping(waterConnectionRequest);
		
		return  Arrays.asList(waterConnectionRequest.getWaterConnection());
	}
	
	@Override
	public void sendSms(WaterNotificationRequest waterNotificationRequest) {
		WaterNotication wn  = waterNotificationRequest.getWaterNotication();
//		String template = config.getNotificationTemplate();
//		template  = template.replace("<#var1>", wn.getApplication_no()).replace("<#var2>", wn.getConsumer_name()).replace("<#var3>",
//				wn.getHouse_no()).replace("<#var4>", wn.getSector_village()).replace("<#var5>", wn.getPhone_no()).replace("<#var6>", wn.getApplication_type())
//				.replace("<#var7>",wn.getApplication_status()).replace("<#var8>", wn.getAmount());
		String template=getTemplate(wn);
		SMSRequest smsTemplate = SMSRequest.builder().message(template).mobileNumber(wn.getPhone_no()).build();
		notificationUtil.sendSMS(Arrays.asList(smsTemplate));
	}
	
	private String getTemplate(WaterNotication wn) {
		String template = null;
		
		if(wn.getTemplateName()==null) {
			template = config.getNotificationTemplate();
			template  = template.replace("<#var1>", wn.getApplication_no()).replace("<#var2>", wn.getConsumer_name()).replace("<#var3>",
					wn.getHouse_no()).replace("<#var4>", wn.getSector_village()).replace("<#var5>", wn.getPhone_no()).replace("<#var6>", wn.getApplication_type())
					.replace("<#var7>",wn.getApplication_status()).replace("<#var8>", wn.getAmount());
		}else {
			switch (wn.getTemplateName()) {
			case TEMPLATE_NAME_SITE_INSPECTOR:
				template=config.getNotificationTemplateSiteInspector();
				template  = template.replace("<#var1>", wn.getApplication_no()).replace("<#var2>", wn.getConsumer_name()).replace("<#var3>",
						wn.getHouse_no()).replace("<#var4>", wn.getSector_village()).replace("<#var5>", wn.getPhone_no()).replace("<#var6>", wn.getApplication_type())
						.replace("<#var7>",wn.getApplication_status()).replace("<#var8>", wn.getAmount());
				break;
			case TEMPLATE_NAME_CITIZEN_CASE1:
				template=config.getNotificationTemplateCitizenCase1();
				template=template.replace("<#var1>", wn.getApplication_no()).replaceAll("<#var2>", wn.getSubdivision());
				break;
			case TEMPLATE_NAME_CITIZEN_CASE2:
				template=config.getNotificationTemplateCitizenCase2();
				template=template.replace("<#var1>", wn.getAmount()).replace("<#var2>", wn.getApplication_no());
				break;
			case TEMPLATE_NAME_CITIZEN_CASE3:
				template=config.getNotificationTemplateCitizenCase3();
				template=template.replace("<#var1>", wn.getApplication_no());
				break;
			}
		}
		
		return template;
	}
	

	
	/**
	 * 
	 * @param criteria WaterConnectionSearchCriteria contains search criteria on water & sewerage connection
	 * @param requestInfo 
	 * @return List(Count) of matching water & sewerage connection
	 */
	public metrics searchTotalCollectionCountNIUA(SearchTotalCollectionCriteria SearchTotalCollectionCriteria, RequestInfo requestInfo) {
		metrics waterConnectionList;
		waterConnectionList = getWaterConnectionsTotalCollectionListCountNIUA(SearchTotalCollectionCriteria, requestInfo);
		return waterConnectionList;
	}
	
	/**
	 * 
	 * @param criteria WaterConnectionSearchCriteria contains search criteria on water & sewerage connection
	 * @param requestInfo 
	 * @return List(Count) of matching water & sewerage connection
	 */
	public metrics getWaterConnectionsTotalCollectionListCountNIUA(SearchTotalCollectionCriteria SearchTotalCollectionCriteria,
			RequestInfo requestInfo) {
		return waterDao.getWaterConnectionTotalCollectionListCountNIUA(SearchTotalCollectionCriteria, requestInfo);
	}
	
	
	/**
	 * 
	 * @param criteria WaterConnectionSearchCriteria contains search criteria on water connection
	 * @param requestInfo 
	 * @return List of matching water connection
	 */
	public List<WaterConnection> getAPI(SearchCriteria criteria, RequestInfo requestInfo) {
		List<WaterConnection> waterConnectionList;
		waterConnectionList = getWaterConnectionsListForGetAPI(criteria, requestInfo);
		waterConnectionValidator.validatePropertyForConnection(waterConnectionList);
		enrichmentService.enrichConnectionHolderDeatils(waterConnectionList, criteria, requestInfo);
		return waterConnectionList;
	}
	/**
	 * 
	 * @param criteria WaterConnectionSearchCriteria contains search criteria on water connection
	 * @param requestInfo 
	 * @return List of matching water connection
	 */
	public List<WaterConnection> getWaterConnectionsListForGetAPI(SearchCriteria criteria,
			RequestInfo requestInfo) {
		return waterDao.getAPI(criteria, requestInfo);
	}
	
	
	/**
	 * 
	 * @param criteria WaterConnectionSearchCriteria contains search criteria on water & sewerage connection
	 * @param requestInfo 
	 * @return List(Count) of matching water & sewerage connection
	 */
	public ResponseData searchPublicDashBoardCount(PublicDashBoardSearchCritieria SearchTotalCollectionCriteria) {
		ResponseData waterConnectionList;
		waterConnectionList = getPublicDashBoardSearchCount(SearchTotalCollectionCriteria);
		return waterConnectionList;
	}
	
	/**
	 * 
	 * @param criteria WaterConnectionSearchCriteria contains search criteria on water & sewerage connection
	 * @param requestInfo 
	 * @return List(Count) of matching water & sewerage connection
	 */
	public ResponseData getPublicDashBoardSearchCount(PublicDashBoardSearchCritieria SearchTotalCollectionCriteria) {
		return waterDao.searchPublicDashBoardCount(SearchTotalCollectionCriteria);
	}
}
