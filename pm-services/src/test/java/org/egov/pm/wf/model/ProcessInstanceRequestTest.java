package org.egov.pm.wf.model;

import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.egov.common.contract.request.RequestInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import junit.framework.Assert;

@RunWith(MockitoJUnitRunner.Silent.class)
public class ProcessInstanceRequestTest {

	@InjectMocks
	private ProcessInstanceRequest process;

	@Test
	public void testAddProcessInstanceItem() {
		process.addProcessInstanceItem(new ProcessInstance());
	}

	@Test
	public void testBuilder() {
		process.builder();
	}

	@Test
	public void testGetRequestInfo() {
		process.setRequestInfo(RequestInfo.builder().action("action").build());
		Assert.assertEquals("action", process.getRequestInfo().getAction());
	}

	@Test
	public void testGetProcessInstances() {
		List<ProcessInstance> processInstances = new ArrayList<ProcessInstance>();
		process.setProcessInstances(processInstances);
		Assert.assertEquals(processInstances, process.getProcessInstances());
	}

	@Test
	public void testProcessInstanceRequestRequestInfoListOfProcessInstance() {
		ProcessInstanceRequest process2 = new ProcessInstanceRequest(RequestInfo.builder().action("action").build(),
				new ArrayList<ProcessInstance>());
		Assert.assertEquals("action", process2.getRequestInfo().getAction());
	}

	@Test
	public void testProcessInstanceRequest() {
		ProcessInstanceRequest process2 = new ProcessInstanceRequest();
		process2.setRequestInfo(RequestInfo.builder().action("action").build());
		Assert.assertEquals("action", process2.getRequestInfo().getAction());
	}

	@Test
	public void testToString() {
		process.toString();
	}

	@Test
	public void testProcessInstanceRequestBuilder() {
		List<ProcessInstance> p = new ArrayList<>();
		RequestInfo in = RequestInfo.builder().action("action").build();
		ProcessInstanceRequest.ProcessInstanceRequestBuilder process2 = new ProcessInstanceRequest.ProcessInstanceRequestBuilder();
		process2.processInstances(p);
		process2.requestInfo(in);
		process2.build();

		ProcessInstanceRequest.ProcessInstanceRequestBuilder process3 = new ProcessInstanceRequest.ProcessInstanceRequestBuilder();
		process3.processInstances(p);
		process3.requestInfo(in);
		process3.build();

		Assert.assertEquals(process2.toString(), process3.toString());
	}

}
