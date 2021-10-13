package org.egov.hc.service;




import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

import org.egov.common.contract.request.RequestInfo;
import org.egov.common.contract.request.User;
import org.egov.common.contract.response.ResponseInfo;

import org.egov.hc.consumer.HCNotificationConsumer;
import org.egov.hc.contract.Action;
import org.egov.hc.contract.AuditDetails;
import org.egov.hc.contract.RequestInfoWrapper;
import org.egov.hc.contract.ServiceRequest;

import org.egov.hc.model.ActionInfo;
import org.egov.hc.model.DeviceSources;
import org.egov.hc.model.ProcessInstance;
import org.egov.hc.model.ProcessInstanceRequest;
import org.egov.hc.model.RequestData;
import org.egov.hc.model.ServiceRequestData;

import org.egov.hc.model.State;
import org.egov.hc.producer.HCConfiguration;
import org.egov.hc.producer.HCProducer;

import org.egov.hc.repository.IdGenRepository;
import org.egov.hc.repository.ServiceRepository;
import org.egov.hc.utils.HCConstants;
import org.egov.hc.utils.HCUtils;
import org.egov.hc.utils.ResponseInfoFactory;
import org.egov.hc.workflow.Document;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;

import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;


import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(MockitoJUnitRunner.class)

public class ServiceRequestServiceTest {
	
	@Mock
	private ResponseInfoFactory factory;

	@Mock
	private HCUtils hCUtils;
	

	@Mock
	private HCProducer hCProducer;

	@Mock
	private ServiceRepository serviceRepository;

	@Mock
	private ObjectMapper objectMapper;
	
	@Mock
	private HCConfiguration hcConfiguration;
	
	@Mock
	private HCNotificationConsumer notificationConsumer;
	
	@Mock
	private IdGenRepository idgenrepository;
	
	@InjectMocks
	private ServiceRequestService requestService;
	

	

	@Test
	public void testsearchRequest() throws Exception {
		RequestData requestData = RequestData.builder().service_request_id("CH-HC-2020-06-14-001432_1").build();
		
		
		RequestData requestdata = RequestData.builder().service_request_id("CH-HC-2020-06-14-001432_1").serviceType("PRUNING OF TREES GIRTH GREATER THAN 90 CMS").serviceRequestStatus("INITIATED")
		                            .requestInfo(RequestInfo.builder().userInfo(User.builder().uuid("b059cc54-f521-4612-a12e-7c423f29d4ce").tenantId("ch").build()).build()).build();             
				
		RequestInfo requestInfo = RequestInfo.builder().apiId("Rainmaker").did("1").ver(".01").authToken("5000921c-b0f5-401e-a553-7c607d29f152")
				                  .msgId("20170310130900|en_IN").userInfo(User.builder().id(94L).tenantId("ch").build()).build();
		
		Mockito.when(objectMapper.convertValue(requestdata, RequestData.class)).thenReturn(requestData);
		Mockito.when(serviceRepository.findRequest(requestdata)).thenReturn(new ArrayList<ServiceRequestData>());
//		Assert.assertEquals(HttpStatus.OK, requestService.searchRequest(requestdata, requestInfo).getStatusCode());
	}

	
	@Test
	public void testgetServiceRequestDetails() throws Exception {
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("service_request_id", "CH-HC-2020-06-14-001432_1");
		jsonObject.put("serviceType", "dead tree");
		jsonObject.put("serviceRequestStatus", "INITIATED");
		JSONArray array = new JSONArray();
		array.add(jsonObject);
	
		RequestData requestdata = RequestData.builder().service_request_id("CH-HC-2020-06-14-001432_1").serviceType("PRUNING OF TREES GIRTH GREATER THAN 90 CMS").serviceRequestStatus("INITIATED")
                .requestInfo(RequestInfo.builder().userInfo(User.builder().tenantId("ch").build()).build()).build(); 
		
		Mockito.when(objectMapper.convertValue(requestdata, RequestData.class)).thenReturn(requestdata);
		Mockito.when(serviceRepository.getServiceRequest(requestdata)).thenReturn(array);
//		Assert.assertEquals(HttpStatus.OK, requestService.getServiceRequestDetails(RequestData.builder().build()).getStatusCode());
	}
	

	
	
	@Test
	public void testcreate() throws Exception {
		
		
		ServiceRequestData request = ServiceRequestData.builder().ownerName("dhanaji").email("dhanaji@gmail.com").contactNumber("1234567890").treeCount(10L)
                
				 	.service_request_status("SUBMITED").tenantId("ch").service_request_id("CH-HC-2020-06-14-001432_1")
					.description("dry tree")
					.createdTime(1588550400000L)
					.lastModifiedTime(1588636800000L)
					.active(true)
					.auditDetails(new AuditDetails())
					.build();
		
		ServiceRequest servicerequest = ServiceRequest.builder().requestInfo(RequestInfo.builder().userInfo(User.builder().userName("9865845654").emailId("abcd@gmail.com").mobileNumber("1234567890").name("Nikunj")
                
				.type("CITIZEN").tenantId("ch").uuid("65a14e00-ba5e-4347-be81-08fc04bb0529").build())
				.build())
				.services(new LinkedList<ServiceRequestData>())
				.actionInfo(new LinkedList<ActionInfo>())
				.requestBody(new Object())
				.auditDetails(new  org.egov.hc.contract.AuditDetails())
				.build();
		
	    RequestData requestdata = RequestData.builder().service_request_id("CH-HC-2020-06-14-001432_1").serviceType("PRUNING OF TREES GIRTH GREATER THAN 90 CMS").serviceRequestStatus("INITIATED")
                .requestInfo(RequestInfo.builder().userInfo(User.builder().tenantId("ch").build()).build()).build(); 
	    
	    ServiceRequest.builder().responseInfo(ResponseInfo.builder().status("Success").build())
		.responseBody(request).build();
	    
	    Mockito.when(objectMapper.convertValue(request, ServiceRequest.class)).thenReturn(servicerequest);
	    RequestInfoWrapper infoWrapper = new RequestInfoWrapper();
	    List<ServiceRequestData> applicatinFormList = new ArrayList<>();
	    List<ActionInfo> actionInfos = new ArrayList<>();
	    ActionInfo newActionInfo = ActionInfo.builder().uuid(UUID.randomUUID().toString())

				.action("open").assignee("EE")
				.by("").when(1588550400000L)
				.tenantId("ch").status("open")
				.build();
		actionInfos.add(newActionInfo);
	    infoWrapper = RequestInfoWrapper.builder().services(applicatinFormList).actionInfo(actionInfos)
				.requestInfo(servicerequest.getRequestInfo())
				.requestBody(servicerequest.getServices()).build();
	    hCProducer.push(hcConfiguration.getSaveTopic(), infoWrapper);
	}
	
	@Test
	public void testUpdate()throws Exception {
		
		ServiceRequestData updateRequest = new ServiceRequestData();
		updateRequest.setService_request_id("CH-HC-2020-06-14-001432_1");
		updateRequest.setCreatedTime(1588550400000L);
		updateRequest.setLastModifiedTime(1588636800000L);
		updateRequest.setTenantId("ch");
		updateRequest.setService_request_status("APPROVED");
		updateRequest.setServiceMedia("");
		updateRequest.setCurrent_assignee("EE");
		
		ServiceRequest seerviceRequest = new ServiceRequest();
		//ServicerequestTest service = new ServicerequestTest();
		
		RequestInfoWrapper infowraperforupdate = RequestInfoWrapper.builder().requestBody(updateRequest).build();
		RequestInfo requestInfo = seerviceRequest.getRequestInfo();
		List<ActionInfo> actionInfos = new ArrayList<>();
		
		ActionInfo newActionInfo = ActionInfo.builder().uuid(UUID.randomUUID().toString())
				.businessKey("1")
				.action("APPROVED")
				.assignee("EE")
				.tenantId("ch")
				.status("APPROVED").build();
		actionInfos.add(newActionInfo);
		
		infowraperforupdate = RequestInfoWrapper.builder().actionInfo(actionInfos).requestInfo(requestInfo)
				.requestBody(updateRequest).services(seerviceRequest.getServices()).build();

		hCProducer.push(hcConfiguration.getUpdateTopic(), infowraperforupdate);
		
		
	}
	
	@Test
	public void testScheduler()throws Exception {
		String role = "EE";
		String serviceRequestId="CH-HC-2020-06-14-001432_1";
		ServiceRequestData request = new ServiceRequestData();
		String tenantId = "ch";
		int days = 2;
		
		Mockito.when(objectMapper.convertValue(request, ServiceRequestData.class)).thenReturn(request);
		//Mockito.when(sendReminderOverdueSlaNotification(role,serviceRequestId,HCConstants.REMINDER,request.getService_request_date(),tenantId,request.getServiceType(),days)).thenReturn(request);
		
		//sendReminderOverdueSlaNotification(role,serviceRequestId,HCConstants.REMINDER,request.getService_request_date(),tenantId,request.getServiceType(),days);

	}
	
	@Test
	public void sendReminderOverdueSlaNotification() throws Exception
	{
	
		ServiceRequestData serviceRequest = new ServiceRequestData();
		ServiceRequest serviceRequestobj= new ServiceRequest();
		List Actioninfolist= new ArrayList();
		RequestInfo requestInfoDetails =new RequestInfo();
		List<ServiceRequestData> serviceRequestList = new ArrayList<>();
		serviceRequest.setEmail("dhanaji8612@gmail.com");
		serviceRequest.setOwnerName("dhanaji");
		serviceRequest.setTenantId("ch");
		serviceRequestList.add(serviceRequest);	
    	serviceRequestobj.setServices(serviceRequestList);
    	serviceRequestobj.setActionInfo(Actioninfolist);
    	serviceRequestobj.setRequestInfo(requestInfoDetails);
    	String action = " OVERDAYS";
    	String tenantId = "ch.chandigarh";
    	int days = 7;
    	String serviceRequestDate = "10/07/2020";
    	Mockito.when(objectMapper.convertValue(serviceRequestobj, ServiceRequest.class)).thenReturn(serviceRequestobj);
    	notificationConsumer.sendSchedulerNotification(serviceRequestobj,action,serviceRequestDate,tenantId,days);
    	//Mockito.when(sendReminderOverdueSlaNotification(role,serviceRequestId,HCConstants.REMINDER,request.getService_request_date(),tenantId,request.getServiceType(),days)).thenReturn(request);
	}
	

	@Test
	public void testSaveDeviceDetails_1() {
		
		JSONObject deviceDetails = new JSONObject();
		AuditDetails auditDetails = AuditDetails.builder().createdBy("1").createdTime(1546515646L).lastModifiedBy("1")
				.lastModifiedTime(15645455L).build();
		
		deviceDetails.put("BrowserName", "BrowserName");
		deviceDetails.put("BrowserType", "BrowserType");
		deviceDetails.put("BrowserEnginee", "BrowserEnginee");
		deviceDetails.put("OperatingSystem", "OperatingSystem");
		deviceDetails.put("DeviceType", "DeviceType");

		DeviceSources deviceSources = DeviceSources.builder().sourceUuid("dkdkbkdbkd")
				.deviceDetails(deviceDetails.toJSONString())
				.deviceType("").tenantId("ch")
				.moduleType("dkhbd").createdBy(auditDetails.getCreatedBy())
				.createdTime(auditDetails.getCreatedTime()).build();
		
		String uuid=UUID.randomUUID().toString();
		RequestInfoWrapper infoWrapper = RequestInfoWrapper.builder().requestBody(deviceSources).build();				
		hCProducer.push(hcConfiguration.getRequestDeviceSource(), infoWrapper);

	}
	
	@Test
	public void testEdit() throws Exception {
		
		
	RequestData requestdata = RequestData.builder().service_request_id("CH-HC-2020-06-14-001432_1").serviceType("PRUNING OF TREES GIRTH GREATER THAN 90 CMS").serviceRequestStatus("INITIATED")
                .requestInfo(RequestInfo.builder().userInfo(User.builder().tenantId("ch").build()).build()).build(); 
	    
		
		ServiceRequestData data = ServiceRequestData.builder().ownerName("ABCD")
				.action("INITIATE").service_request_id("CH-HC-2020-06-14-001432_1").serviceType("PRUNING OF TREES GIRTH GREATER THAN 90 CMS").tenantId("ch").build();
	
		ProcessInstance process = new ProcessInstance();
		AuditDetails details = new AuditDetails();
		User user = new User();
		List<Action> list = new ArrayList<>();
		
		State state = new State();
		
		String proccessId = UUID.randomUUID().toString();
		  state.setUuid("5d89acc5-fcda-46a7-900b-dac4ba5f29d7");
		  state.setTenantId("ch.chandigarh");
		
		
		  List<Document> wfAddDocumentnew = new ArrayList<>();
		
	        process.setId(proccessId);
			process.setTenantId("ch.chandigarh");
			process.setBusinessService("PRUNING OF TREES GIRTH GREATER THAN 90 CMS");
			process.setBusinessId("CH-HC-2020-06-14-001432_1");
			process.setModuleName(HCConstants.MODULENAMEVALUE);
			process.setAction("INITIATE");
			process.setState(state);
			process.setComment("comment");
			process.setAssigner(user);
			process.setDocuments(wfAddDocumentnew);
			process.setAuditDetails(details);
	
		
		ArrayList <ProcessInstance> ProcessInstanceList = new ArrayList<>();
		List<ProcessInstance> processInstances = new ArrayList<>();
		processInstances.add(process);
		ProcessInstanceList.addAll(processInstances);
		
	
	ProcessInstanceRequest processInstanceRequest=new ProcessInstanceRequest();
	processInstanceRequest.setProcessInstances(ProcessInstanceList);
	hCProducer.push(hcConfiguration.getSaveTransitionTopic(),processInstanceRequest);
	}
	

}