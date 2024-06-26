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
import org.egov.waterconnection.model.Connection.StatusEnum;
import org.egov.waterconnection.model.ConnectionHolderInfo;
import org.egov.waterconnection.model.OwnerInfo;
import org.egov.waterconnection.model.Property;
import org.egov.waterconnection.model.PublicDashBoardSearchCritieria;
import org.egov.waterconnection.model.PublicDashboardFilestore;
import org.egov.waterconnection.model.PublicDashboardFilestoreRequest;
import org.egov.waterconnection.model.ResponseData;
import org.egov.waterconnection.model.SMSRequest;
import org.egov.waterconnection.model.SMSRequest.SMSRequestBuilder;
import org.egov.waterconnection.model.SearchCriteria;
import org.egov.waterconnection.model.SearchTotalCollectionCriteria;
import org.egov.waterconnection.model.Status;
import org.egov.waterconnection.model.WaterApplication;
import org.egov.waterconnection.model.WaterConnection;
import org.egov.waterconnection.model.WaterConnectionCount;
import org.egov.waterconnection.model.WaterConnectionRequest;
import org.egov.waterconnection.model.WaterNotication;
import org.egov.waterconnection.model.WaterNotificationRequest;
import org.egov.waterconnection.model.WaterTotalCollections;
import org.egov.waterconnection.model.metrics;
import org.egov.waterconnection.model.users.UserDetailResponse;
import org.egov.waterconnection.model.users.UserDetailResponseConMap;
import org.egov.waterconnection.model.users.UserDetailResponseNew;
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

	public static final String TEMPLATE_NAME_SITE_INSPECTOR = "siteInspector";
	public static final String TEMPLATE_NAME_CITIZEN_CASE1 = "citizen.case1";
	public static final String TEMPLATE_NAME_CITIZEN_CASE2 = "citizen.case2";
	public static final String TEMPLATE_NAME_CITIZEN_CASE3 = "citizen.case3";

	/**
	 * 
	 * @param waterConnectionRequest WaterConnectionRequest contains water
	 *                               connection to be created
	 * @return List of WaterConnection after create
	 */
	@Override
	public List<WaterConnection> createWaterConnection(WaterConnectionRequest waterConnectionRequest) {
		waterConnectionValidator.validateWaterConnection(waterConnectionRequest, false);
		Property property = validateProperty.getOrValidateProperty(waterConnectionRequest);
		enrichmentService.enrichWaterConnection(waterConnectionRequest);
		userService.createUser(waterConnectionRequest);

		System.out.println("Water Connection Request : " + waterConnectionRequest.toString());
		// call work-flow
		if (config.getIsExternalWorkFlowEnabled())
			wfIntegrator.callWorkFlow(waterConnectionRequest, property);
		waterDao.saveWaterConnection(waterConnectionRequest);
		return Arrays.asList(waterConnectionRequest.getWaterConnection());
	}
	
	@Override
	public PublicDashboardFilestore saveFilestoreId(PublicDashboardFilestoreRequest publicDashboardFilestoreRequest) {
		enrichmentService.enrichPublicDashboardFileStore(publicDashboardFilestoreRequest);
		waterDao.savePublicDashboardFileStore(publicDashboardFilestoreRequest);
		System.out.println("Public Dashboard Request : " + publicDashboardFilestoreRequest.toString());
		return publicDashboardFilestoreRequest.getPublicDashboardFilestore();
	}

	/**
	 * 
	 * @param criteria    WaterConnectionSearchCriteria contains search criteria on
	 *                    water connection
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
	 * @param criteria    WaterConnectionSearchCriteria contains search criteria on
	 *                    water connection
	 * @param requestInfo
	 * @return List of matching water connection
	 */
	public List<WaterConnection> searchCitizen(SearchCriteria criteria, RequestInfo requestInfo) {
		List<WaterConnection> waterConnectionList;
		waterConnectionList = getWaterConnectionsListCitizen(criteria, requestInfo);		
		if(CollectionUtils.isEmpty(waterConnectionList)) {
			System.out.println("Inside search empty water connection list");
			waterConnectionList = search(criteria, requestInfo);
			System.out.println("Water Connection List : " + waterConnectionList.toString());
			System.out.println("Ws Application id Old : " + waterConnectionList.get(0).getConnectionHolders().get(0).getWs_application_id());
			waterConnectionList.get(0).getConnectionHolders().get(0).setWs_application_id(waterConnectionList.get(0).getWaterApplication().getId());
			System.out.println("Ws Application id New : " + waterConnectionList.get(0).getConnectionHolders().get(0).getWs_application_id());
		}
		waterConnectionValidator.validatePropertyForConnection(waterConnectionList);
		enrichmentService.enrichConnectionHolderDeatils(waterConnectionList, criteria, requestInfo);
		return waterConnectionList;
	}

	/**
	 * 
	 * @param criteria    WaterConnectionSearchCriteria contains search criteria on
	 *                    water connection
	 * @param requestInfo
	 * @return List of matching water connection
	 */
	public List<WaterConnection> getWaterConnectionsList(SearchCriteria criteria, RequestInfo requestInfo) {
		return waterDao.getWaterConnectionList(criteria, requestInfo);
	}
	
	
	public List<WaterConnection> getWaterDuplicateConnectionList(SearchCriteria criteria, RequestInfo requestInfo) {
		return waterDao.getWaterDuplicateConnectionList(criteria, requestInfo);
	}
	
	

	/**
	 * 
	 * @param criteria    WaterConnectionSearchCriteria contains search criteria on
	 *                    water connection
	 * @param requestInfo
	 * @return List of matching water connection
	 */
	public List<WaterConnection> getWaterConnectionsListCitizen(SearchCriteria criteria, RequestInfo requestInfo) {
		return waterDao.getWaterConnectionListCitizen(criteria, requestInfo);
	}

	/**
	 * 
	 * @param criteria    WaterConnectionSearchCriteria contains search criteria on
	 *                    water connection
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
	 * @param criteria    WaterConnectionSearchCriteria contains search criteria on
	 *                    water connection
	 * @param requestInfo
	 * @return List(Count) of matching water connection
	 */
	public List<WaterConnectionCount> getWaterConnectionsListCount(SearchCriteria criteria, RequestInfo requestInfo) {
		return waterDao.getWaterConnectionListCount(criteria, requestInfo);
	}

	/**
	 * 
	 * @param waterConnectionRequest WaterConnectionRequest contains water
	 *                               connection to be updated
	 * @return List of WaterConnection after update
	 */
	@SuppressWarnings("unlikely-arg-type")
	@Override
	public List<WaterConnection> updateWaterConnection(WaterConnectionRequest waterConnectionRequest) {
		log.info("Update WaterConnection: {}", waterConnectionRequest.getWaterConnection());		
		System.out.println("Connectholder uuid water request : " + waterConnectionRequest.getWaterConnection().getConnectionHolders().get(0).getUuid());
		waterConnectionValidator.validateWaterConnection(waterConnectionRequest, true);
		mDMSValidator.validateMasterData(waterConnectionRequest);

		if (null == waterConnectionRequest.getWaterConnection().getWaterProperty().getUsageCategory()
				|| waterConnectionRequest.getWaterConnection().getWaterProperty().getUsageCategory().isEmpty()) {
			waterConnectionRequest.getWaterConnection().getWaterProperty().setUsageCategory("TEMPORARY_CONSTRUCTION");
		}

		Property property = validateProperty.getOrValidateProperty(waterConnectionRequest);
		waterConnectionRequest.getWaterConnection().setProperty(property);
		validateProperty.validatePropertyCriteria(property);
		waterConnectionRequest.getWaterConnection()
				.setSameuservalid(waterConnectionRequest.getWaterConnection().getSameuservalid());
		waterConnectionRequest.getWaterConnection()
				.setSubmitBy(waterConnectionRequest.getWaterConnection().getSubmitBy());
		waterConnectionRequest.getWaterConnection()
				.setSubmitByName(waterConnectionRequest.getWaterConnection().getSubmitByName());

		waterConnectionRequest.getWaterConnection().getConnectionHolders().get(0)
				.setSameuservalid(waterConnectionRequest.getWaterConnection().getSameuservalid());
		waterConnectionRequest.getWaterConnection().getConnectionHolders().get(0)
				.setSubmitBy(waterConnectionRequest.getWaterConnection().getSubmitBy());
		waterConnectionRequest.getWaterConnection().getConnectionHolders().get(0)
				.setSubmitByName(waterConnectionRequest.getWaterConnection().getSubmitByName());
		boolean isStateUpdatable = true;
		BusinessService businessService = null;

		if (WCConstants.ACTION_CHANGE_CONNECTION_HOLDER
				.equalsIgnoreCase(waterConnectionRequest.getWaterConnection().getProcessInstance().getAction())) {
			waterConnectionRequest.getWaterConnection().setProposedName(
					waterConnectionRequest.getWaterConnection().getConnectionHolders().get(0).getProposedName());
			waterConnectionRequest.getWaterConnection().setProposedMobileNo(
					waterConnectionRequest.getWaterConnection().getConnectionHolders().get(0).getProposedMobileNo());
			waterDao.deactiveConnectionHolder(waterConnectionRequest, false);
		}

		if (WCConstants.ACTION_TEMPORARY_CLOSE_CONNECTION
				.equalsIgnoreCase(waterConnectionRequest.getWaterConnection().getProcessInstance().getAction())) {
			waterDao.deactiveConnectionHolder(waterConnectionRequest, true);
		}

		if (WCConstants.ACTION_INITIATE
				.equalsIgnoreCase(waterConnectionRequest.getWaterConnection().getProcessInstance().getAction())) {
			System.out.println("Inside initiate state if condition");
			waterConnectionRequest.getWaterConnection().setDocuments(null);
			enrichmentService.enrichWaterApplication(waterConnectionRequest);
			enrichmentService.enrichUpdateWaterConnection(waterConnectionRequest);
			waterConnectionRequest.getWaterConnection().getConnectionHolders().get(0).setWs_application_id(waterConnectionRequest.getWaterConnection().getWaterApplication().getId());
			System.out.println("ws_application_id : " + waterConnectionRequest.getWaterConnection().getConnectionHolders().get(0).getWs_application_id().toString());
			waterConnectionRequest.getWaterConnection()
					.setSameuservalid(waterConnectionRequest.getWaterConnection().getSameuservalid());
			waterConnectionRequest.getWaterConnection()
					.setSubmitBy(waterConnectionRequest.getRequestInfo().getUserInfo().getUuid());
			waterConnectionRequest.getWaterConnection()
					.setSubmitByName(waterConnectionRequest.getRequestInfo().getUserInfo().getName());
			/*
			 * waterConnectionRequest.getWaterConnection().getConnectionHolders().get(0)
			 * .setUuid(waterConnectionRequest.getRequestInfo().getUserInfo().getUuid());
			 */
			waterConnectionRequest.getWaterConnection().getConnectionHolders().get(0).setTenantId(waterConnectionRequest.getWaterConnection().getTenantId());
			
			System.out.println("Water Application Tenant Id : " + waterConnectionRequest.getWaterConnection().getTenantId());			
			System.out.println("Connection Holder uuid : " + waterConnectionRequest.getWaterConnection().getConnectionHolders().get(0).getUuid());
			waterConnectionRequest.getWaterConnection().setApplicationStatus(WCConstants.STATUS_INITIATED);
			waterConnectionRequest.getWaterConnection().getConnectionHolders().get(0).setStatus(Status.ACTIVE);
		} else {
			businessService = workflowService.getBusinessService(
					waterConnectionRequest.getWaterConnection().getTenantId(), waterConnectionRequest.getRequestInfo(),
					waterConnectionRequest.getWaterConnection().getActivityType());
			log.info("businessService: {},Business: {}", businessService.getBusinessService(),
					businessService.getBusiness());
			WaterConnection searchResult = getConnectionForUpdateRequest(
					waterConnectionRequest.getWaterConnection().getWaterApplication().getId(),
					waterConnectionRequest.getRequestInfo());
			
						
			
			System.out.println("Search Result 1 : " + searchResult.toString());
			
			String previousApplicationStatus = workflowService.getApplicationStatus(
					waterConnectionRequest.getRequestInfo(),
					waterConnectionRequest.getWaterConnection().getApplicationNo(),
					waterConnectionRequest.getWaterConnection().getTenantId(),
					wfIntegrator.getBusinessService(waterConnectionRequest.getWaterConnection().getActivityType()));
			enrichmentService.enrichUpdateWaterConnection(waterConnectionRequest);
			actionValidator.validateUpdateRequest(waterConnectionRequest, businessService, previousApplicationStatus);
			waterConnectionValidator.validateUpdate(waterConnectionRequest, searchResult);
			
			boolean isConnectionPresent = getConnectionNo(waterConnectionRequest.getWaterConnection().getConnectionNo(), waterConnectionRequest.getRequestInfo());
			
			System.out.println("isConnectionPresent : " + isConnectionPresent + "Activity Type : " + waterConnectionRequest.getWaterConnection().getActivityType() + "Action : " + waterConnectionRequest.getWaterConnection().getProcessInstance().getAction());
			
			if (isConnectionPresent
					&& WCConstants.ACTIVITY_TYPE_NEW_CONN
							.equals(waterConnectionRequest.getWaterConnection().getActivityType())
					&& WCConstants.ACTIVATE_CONNECTION
							.equals(waterConnectionRequest.getWaterConnection().getProcessInstance().getAction())) {
				List<WaterConnection> searchResult2 = getConnectionNoExist(
						waterConnectionRequest.getWaterConnection().getConnectionNo(),
						waterConnectionRequest.getRequestInfo());
				System.out.println("Search Result 2 : " + searchResult2.toString());
				
				for(WaterConnection waterConn : searchResult2) {
					waterConnectionValidator.validateConnectionNo(waterConnectionRequest, waterConn);
					WaterConnectionRequest waterConnectionRequest2 = new WaterConnectionRequest();
					waterConnectionRequest2.setRequestInfo(waterConnectionRequest.getRequestInfo());
					waterConnectionRequest2.setWaterConnection(waterConn);
					waterConnectionRequest2.getWaterConnection().setStatus(StatusEnum.INACTIVE);
					System.out.println("Water Connection Request 2 : " + waterConnectionRequest2.toString());
					waterDao.updateWaterConnection(waterConnectionRequest2, isStateUpdatable);
				}				
			}
						
			
			calculationService.calculateFeeAndGenerateDemand(waterConnectionRequest, property);
			// check for edit and send edit notification
			waterDaoImpl.pushForEditNotification(waterConnectionRequest);
			// Enrich file store Id After payment
			enrichmentService.enrichFileStoreIds(waterConnectionRequest);
			// Comment in Local
			userService.updateUser(waterConnectionRequest, searchResult);
			isStateUpdatable = waterServiceUtil.getStatusForUpdate(businessService, previousApplicationStatus);
		}
		// Call workflow
		// Comment in Local
		wfIntegrator.callWorkFlow(waterConnectionRequest, property);
		if (WCConstants.WS_APPLY_FOR_TEMPORARY_CON
				.equalsIgnoreCase(waterConnectionRequest.getWaterConnection().getActivityType())) {
			enrichmentService.postStatusEnrichment(waterConnectionRequest, property);
		}

		waterConnectionRequest.getWaterConnection().getWaterApplication()
				.setApplicationStatus(waterConnectionRequest.getWaterConnection().getApplicationStatus());
		waterConnectionRequest.getWaterConnection().getWaterApplication()
				.setAction(waterConnectionRequest.getWaterConnection().getProcessInstance().getAction());

		log.info("Next applicationStatus: {}", waterConnectionRequest.getWaterConnection().getApplicationStatus());

		boolean isTerminateState = workflowService
				.isTerminateState(waterConnectionRequest.getWaterConnection().getApplicationStatus(), businessService);
		if (isTerminateState) {
			waterConnectionRequest.getWaterConnection().setInWorkflow(false);
		}
		
		System.out.println("ws_application_id : " + waterConnectionRequest.getWaterConnection().getConnectionHolders().get(0).getWs_application_id().toString());
		System.out.println("WS application number : " + waterConnectionRequest.getWaterConnection().getApplicationNo());
		System.out.println("Water Connection Request Before Update : " + waterConnectionRequest.getWaterConnection().getConnectionHolders().toString());
		waterDao.updateWaterConnection(waterConnectionRequest, isStateUpdatable);

		// enrichmentService.postForMeterReading(waterConnectionRequest);
		return Arrays.asList(waterConnectionRequest.getWaterConnection());
	}

	@Override
	public List<WaterConnection> deactivateConnection(WaterConnectionRequest waterConnectionRequest) {

		waterDao.updateWaterConnection(waterConnectionRequest, false);

		return Arrays.asList(waterConnectionRequest.getWaterConnection());
	}

	/**
	 * Search Water connection to be update
	 * 
	 * @param id
	 * @param requestInfo
	 * @return water connection
	 */
	public WaterConnection getConnectionForUpdateRequest(String id, RequestInfo requestInfo) {
		log.info("Water Application Id:{}", id);
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
	
	public boolean getConnectionNo(String connectionNo, RequestInfo requestInfo) {
		//log.info("Water Application Id:{}", id);
		//Set<String> ids = new HashSet<>(Arrays.asList(id));
		SearchCriteria criteria = new SearchCriteria();
		criteria.setConnectionNumber(connectionNo);
		List<WaterConnection> connections = getWaterConnectionsList(criteria, requestInfo);	
		if (CollectionUtils.isEmpty(connections)) {
			return false;
		} else {
			return true;
		}		
	}
	
	public List<WaterConnection> getConnectionNoExist(String connectionNo, RequestInfo requestInfo) {
		//log.info("Water Application Id:{}", id);
		//Set<String> ids = new HashSet<>(Arrays.asList(id));
		SearchCriteria criteria = new SearchCriteria();
		criteria.setConnectionNumber(connectionNo);
		List<WaterConnection> connections = getWaterDuplicateConnectionList(criteria, requestInfo);
		return connections;		
	}

	@Override
	public List<WaterConnection> deleteConnectionMapping(WaterConnectionRequest waterConnectionRequest) {
		waterDao.deleteConnectionMapping(waterConnectionRequest);
		return Arrays.asList(waterConnectionRequest.getWaterConnection());
	}

	@Override
	public List<WaterConnection> addConnectionMapping(WaterConnectionRequest waterConnectionRequest) {
		// Added Application Data for changes in water connection holder changes
		AuditDetails auditDetails = wsUtil
				.getAuditDetails(waterConnectionRequest.getRequestInfo().getUserInfo().getUuid(), true);
		waterConnectionRequest.getWaterConnection().setAuditDetails(auditDetails);
		WaterApplication waterApplication = new WaterApplication();
		waterApplication.setId(UUID.randomUUID().toString());
		waterConnectionRequest.getWaterConnection().setWaterApplication(waterApplication);
		waterConnectionRequest.getWaterConnection()
				.setSameuservalid(waterConnectionRequest.getWaterConnection().getSameuservalid());
		waterConnectionRequest.getWaterConnection()
				.setSubmitBy(waterConnectionRequest.getRequestInfo().getUserInfo().getUuid());
		waterConnectionRequest.getWaterConnection()
				.setSubmitByName(waterConnectionRequest.getRequestInfo().getUserInfo().getName());

		Property property = validateProperty.getOrValidateProperty(waterConnectionRequest);
		waterConnectionRequest.getWaterConnection().setProperty(property);
		validateProperty.validatePropertyCriteria(property);
		
		//userService.createUserNewConnection(waterConnectionRequest);
		userService.createUserConMap(waterConnectionRequest);
		waterConnectionRequest.getWaterConnection().setUserName(waterConnectionRequest.getWaterConnection().getUserName());

		if (waterConnectionRequest.getWaterConnection().getSameuservalid().equals(true)) {
			if (waterConnectionRequest.getWaterConnection().getMobileNumberOwner() != null) {
				waterConnectionRequest.getWaterConnection().setMobileNumberOwner(waterConnectionRequest.getWaterConnection().getMobileNumberOwner());
				waterConnectionRequest.getWaterConnection().setConnectionOwnerName(waterConnectionRequest.getWaterConnection().getConnectionOwnerName());
				UserDetailResponseConMap userCheckResponse = userService.userExistsNewConnectionMap(waterConnectionRequest.getRequestInfo(),waterConnectionRequest.getWaterConnection().getConnectionOwnerName(),waterConnectionRequest.getWaterConnection().getMobileNumberOwner());
				
				System.out.println("User Check Response : " + userCheckResponse.toString());
				if (CollectionUtils.isEmpty(userCheckResponse.getUser())) {
					System.out.println("Inside Username set to mobile number method");
					waterConnectionRequest.getWaterConnection().setUserName2(waterConnectionRequest.getWaterConnection().getMobileNumberOwner());
					System.out.println("Username 2 if : " + waterConnectionRequest.getWaterConnection().getUserName2());
					waterDao.updateUserDetail(waterConnectionRequest);
				}
			} else {
				waterConnectionRequest.getWaterConnection()
						.setMobileNumberOwner(waterConnectionRequest.getWaterConnection().getUserName());
			}
		} else {
			if (waterConnectionRequest.getRequestInfo().getUserInfo().getMobileNumber() != null) {
				waterConnectionRequest.getWaterConnection().setMobileNumberOwner(waterConnectionRequest.getRequestInfo().getUserInfo().getMobileNumber());				
			} else {
				waterConnectionRequest.getWaterConnection().setMobileNumberOwner(waterConnectionRequest.getWaterConnection().getUserName());
			}
		}

		System.out.println("Water Connection Request : " + waterConnectionRequest.toString());
		waterDao.addConnectionMapping(waterConnectionRequest);

		return Arrays.asList(waterConnectionRequest.getWaterConnection());
	}

	@Override
	public void sendSms(WaterNotificationRequest waterNotificationRequest) {
		WaterNotication wn = waterNotificationRequest.getWaterNotication();
//		String template = config.getNotificationTemplate();
//		template  = template.replace("<#var1>", wn.getApplication_no()).replace("<#var2>", wn.getConsumer_name()).replace("<#var3>",
//				wn.getHouse_no()).replace("<#var4>", wn.getSector_village()).replace("<#var5>", wn.getPhone_no()).replace("<#var6>", wn.getApplication_type())
//				.replace("<#var7>",wn.getApplication_status()).replace("<#var8>", wn.getAmount());
		String template = getTemplate(wn);
		SMSRequest smsTemplate = SMSRequest.builder().message(template).mobileNumber(wn.getPhone_no()).build();
		notificationUtil.sendSMS(Arrays.asList(smsTemplate));
	}

	private String getTemplate(WaterNotication wn) {
		String template = null;

		if (wn.getTemplateName() == null) {
			template = config.getNotificationTemplate();
			template = template.replace("<#var1>", wn.getApplication_no()).replace("<#var2>", wn.getConsumer_name())
					.replace("<#var3>", wn.getHouse_no()).replace("<#var4>", wn.getSector_village())
					.replace("<#var5>", wn.getPhone_no()).replace("<#var6>", wn.getApplication_type())
					.replace("<#var7>", wn.getApplication_status()).replace("<#var8>", wn.getAmount());
		} else {
			switch (wn.getTemplateName()) {
			case TEMPLATE_NAME_SITE_INSPECTOR:
				template = config.getNotificationTemplateSiteInspector();
				template = template.replace("<#var1>", wn.getApplication_no()).replace("<#var2>", wn.getConsumer_name())
						.replace("<#var3>", wn.getHouse_no()).replace("<#var4>", wn.getSector_village())
						.replace("<#var5>", wn.getPhone_no()).replace("<#var6>", wn.getApplication_type())
						.replace("<#var7>", wn.getApplication_status()).replace("<#var8>", wn.getAmount());
				break;
			case TEMPLATE_NAME_CITIZEN_CASE1:
				template = config.getNotificationTemplateCitizenCase1();
				template = template.replace("<#var1>", wn.getApplication_no()).replaceAll("<#var2>",
						wn.getSubdivision());
				break;
			case TEMPLATE_NAME_CITIZEN_CASE2:
				template = config.getNotificationTemplateCitizenCase2();
				template = template.replace("<#var1>", wn.getAmount()).replace("<#var2>", wn.getApplication_no());
				break;
			case TEMPLATE_NAME_CITIZEN_CASE3:
				template = config.getNotificationTemplateCitizenCase3();
				template = template.replace("<#var1>", wn.getApplication_no());
				break;
			}
		}

		return template;
	}

	/**
	 * 
	 * @param criteria    WaterConnectionSearchCriteria contains search criteria on
	 *                    water & sewerage connection
	 * @param requestInfo
	 * @return List(Count) of matching water & sewerage connection
	 */
	public metrics searchTotalCollectionCountNIUA(SearchTotalCollectionCriteria SearchTotalCollectionCriteria,
			RequestInfo requestInfo) {
		metrics waterConnectionList;
		waterConnectionList = getWaterConnectionsTotalCollectionListCountNIUA(SearchTotalCollectionCriteria,
				requestInfo);
		return waterConnectionList;
	}

	/**
	 * 
	 * @param criteria    WaterConnectionSearchCriteria contains search criteria on
	 *                    water & sewerage connection
	 * @param requestInfo
	 * @return List(Count) of matching water & sewerage connection
	 */
	public metrics getWaterConnectionsTotalCollectionListCountNIUA(
			SearchTotalCollectionCriteria SearchTotalCollectionCriteria, RequestInfo requestInfo) {
		return waterDao.getWaterConnectionTotalCollectionListCountNIUA(SearchTotalCollectionCriteria, requestInfo);
	}

	/**
	 * 
	 * @param criteria    WaterConnectionSearchCriteria contains search criteria on
	 *                    water connection
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
	 * @param criteria    WaterConnectionSearchCriteria contains search criteria on
	 *                    water connection
	 * @param requestInfo
	 * @return List of matching water connection
	 */
	public List<WaterConnection> getWaterConnectionsListForGetAPI(SearchCriteria criteria, RequestInfo requestInfo) {
		return waterDao.getAPI(criteria, requestInfo);
	}

	/**
	 * 
	 * @param criteria    WaterConnectionSearchCriteria contains search criteria on
	 *                    water & sewerage connection
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
	 * @param criteria    WaterConnectionSearchCriteria contains search criteria on
	 *                    water & sewerage connection
	 * @param requestInfo
	 * @return List(Count) of matching water & sewerage connection
	 */
	public ResponseData getPublicDashBoardSearchCount(PublicDashBoardSearchCritieria SearchTotalCollectionCriteria) {
		return waterDao.searchPublicDashBoardCount(SearchTotalCollectionCriteria);
	}
}
