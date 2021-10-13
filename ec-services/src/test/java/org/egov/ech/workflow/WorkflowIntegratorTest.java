package org.egov.ech.workflow;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.egov.common.contract.request.RequestInfo;
import org.egov.common.contract.request.Role;
import org.egov.common.contract.response.ResponseInfo;
import org.egov.ec.config.EchallanConfiguration;
import org.egov.ec.web.models.RequestInfoWrapper;
import org.egov.ec.web.models.workflow.ProcessInstance;
import org.egov.ec.web.models.workflow.ProcessInstanceRequest;
import org.egov.ec.workflow.WorkflowIntegrator;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;

@RunWith(MockitoJUnitRunner.class)
public class WorkflowIntegratorTest {
	
	@InjectMocks
	private WorkflowIntegrator service;
	
	@Mock
	RestTemplate restTemplate;
	
	@Autowired
	EchallanConfiguration config;
	
	 
	
	@Test
	public void testWorkflowIntegrator_1()
		throws Exception {
		RestTemplate rest = new RestTemplate();
		EchallanConfiguration config = new EchallanConfiguration();

		WorkflowIntegrator result = new WorkflowIntegrator(rest, config);

		assertNotNull(result);
	}

	/**
	 * Run the void callWorkFlow(ProcessInstanceRequest) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy  at 24/5/20 2:10 PM
	 */
	@Test
	public void testCallWorkFlow_1()
		throws Exception {
		ProcessInstance processInstance = new ProcessInstance();
		processInstance.setBusinessId(UUID.randomUUID().toString());
		processInstance.setTenantId("ch.chandigarh");
		processInstance.setBusinessService("CHALLAN WORKFLOW");
		processInstance.setAction("CHALLAN ISSUED");
		processInstance.setModuleName("ECHALLAN");
		List<ProcessInstance> processList = Arrays.asList(processInstance);
		org.egov.common.contract.request.User userInfo = new org.egov.common.contract.request.User();
		userInfo.setTenantId("ch.chandigarh");
		userInfo.setUuid("e6f989cb-34bc-42fc-9ef9-cd76c3cce00b");
		userInfo.setRoles(Arrays.asList(Role.builder().code("challanSI").name("challanSI").build()));
		
		EchallanConfiguration echallanConfiguration =  EchallanConfiguration.builder().wfHost("http://localhost:8098/")
				.wfTransitionPath("egov-workflow-v2/egov-wf/process/_transition").build(); 
		WorkflowIntegrator fixture = new WorkflowIntegrator(new RestTemplate(), echallanConfiguration);
		ProcessInstanceRequest workFlowRequest = ProcessInstanceRequest.builder().processInstances(processList)
				.requestInfo(RequestInfo.builder().userInfo(userInfo).build()).build();
		
		/*
		 * when(fixture.callWorkFlow(workFlowRequest))
		 * .thenReturn(ResponseInfo.builder().status("successful").msgId("hvhjvj").build
		 * ());
		 */
		fixture.callWorkFlow(workFlowRequest);

	}
	
	
	@Test
	public void testCallWorkFlow_3()
		throws Exception {
		ProcessInstance processInstance = new ProcessInstance();
		processInstance.setBusinessId(UUID.randomUUID().toString());
		processInstance.setTenantId("ch.chandigarh");
		processInstance.setBusinessService("CHALLAN WORKFLOW");
		processInstance.setAction("CHALLAN ISSUED");
		processInstance.setModuleName("ECHALLAN");
		List<ProcessInstance> processList = Arrays.asList(processInstance);
		org.egov.common.contract.request.User userInfo = new org.egov.common.contract.request.User();
		userInfo.setTenantId("ch.chandigarh");
		userInfo.setUuid("e6f989cb-34bc-42fc-9ef9-cd76c3cce00b");
		userInfo.setRoles(Arrays.asList(Role.builder().code("challanSM").name("challanSM").build()));
		
		EchallanConfiguration echallanConfiguration =  EchallanConfiguration.builder().wfHost("http://localhost:8098/")
				.wfTransitionPath("egov-workflow-v2/egov-wf/process/_transition").build(); 
		WorkflowIntegrator fixture = new WorkflowIntegrator(new RestTemplate(), echallanConfiguration);
		ProcessInstanceRequest workFlowRequest = ProcessInstanceRequest.builder().processInstances(processList)
				.requestInfo(RequestInfo.builder().userInfo(userInfo).build()).build();
		
		fixture.callWorkFlow(workFlowRequest);

	}
	
	@Test
	public void testCallWorkFlow_2()
		throws Exception {
		ProcessInstance processInstance = new ProcessInstance();
		processInstance.setBusinessId("dskvkkdkbk");
		processInstance.setTenantId("ch.chandigarh");
		processInstance.setBusinessService("CHALLAN WORKFLOW");
		processInstance.setAction("CHALLAN ISSUED");
		processInstance.setModuleName("ECHALLAN");
		List<ProcessInstance> processList = Arrays.asList(processInstance);
		org.egov.common.contract.request.User userInfo = new org.egov.common.contract.request.User();
		userInfo.setTenantId("ch.chandigarh");
		userInfo.setUuid("e6f989cb-34bc-42fc-9ef9-cd76c3cce00b");
		userInfo.setRoles(Arrays.asList(Role.builder().code("challanSI").name("challanSI").build()));
		
		EchallanConfiguration echallanConfiguration =  EchallanConfiguration.builder().wfHost("http://localhost:8098/")
				.wfTransitionPath("egov-workflow-v2/egov-wf/process/_transition").build(); 
		WorkflowIntegrator fixture = new WorkflowIntegrator(new RestTemplate(), echallanConfiguration);
		ProcessInstanceRequest workFlowRequest = ProcessInstanceRequest.builder().processInstances(processList)
				.requestInfo(RequestInfo.builder().userInfo(userInfo).build()).build();
		
		service.callWorkFlow(workFlowRequest);

	}

}
