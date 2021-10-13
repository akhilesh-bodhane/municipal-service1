package org.egov.ec.web.models.workflow;

import java.util.List;
import org.egov.common.contract.request.RequestInfo;
import org.egov.ec.web.models.workflow.ProcessInstance;
import org.egov.ec.web.models.workflow.ProcessInstanceRequest;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * The class <code>ProcessInstanceRequestTest</code> contains tests for the class <code>{@link ProcessInstanceRequest}</code>.
 *
 * @generated at 17/5/20 2:11 PM
 * @version $Revision: 1.0 $
 */
public class ProcessInstanceRequestTest {
	/**
	 * Run the ProcessInstanceRequest() constructor test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:11 PM
	 */
	@Test
	public void testProcessInstanceRequest_1()
		throws Exception {

		ProcessInstanceRequest result = new ProcessInstanceRequest();

		
		assertNotNull(result);
		assertEquals("ProcessInstanceRequest(requestInfo=null, processInstances=null)", result.toString());
		assertEquals(null, result.getRequestInfo());
		assertEquals(null, result.getProcessInstances());
	}

	/**
	 * Run the ProcessInstanceRequest(RequestInfo,List<ProcessInstance>) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:11 PM
	 */
	@Test
	public void testProcessInstanceRequest_2()
		throws Exception {
		RequestInfo requestInfo = new RequestInfo();
		List<ProcessInstance> processInstances = null;
		
		ProcessInstanceRequest result = new ProcessInstanceRequest(requestInfo, processInstances);

		assertNotNull(result);
		assertEquals("ProcessInstanceRequest(requestInfo=RequestInfo(apiId=null, ver=null, ts=null, action=null, did=null, key=null, msgId=null, authToken=null, correlationId=null, userInfo=null), processInstances=null)", result.toString());
	}

	/**
	 * Run the ProcessInstanceRequest addProcessInstanceItem(ProcessInstance) method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:11 PM
	 */
	@Test
	public void testAddProcessInstanceItem_1()
		throws Exception {
		ProcessInstanceRequest fixture = new ProcessInstanceRequest(new RequestInfo(), (List<ProcessInstance>) null);
		ProcessInstance processInstanceItem = new ProcessInstance();

		ProcessInstanceRequest result = fixture.addProcessInstanceItem(processInstanceItem);

		
		assertNotNull(result);
		assertEquals("ProcessInstanceRequest(requestInfo=RequestInfo(apiId=null, ver=null, ts=null, action=null, did=null, key=null, msgId=null, authToken=null, correlationId=null, userInfo=null), processInstances=[ProcessInstance(id=null, tenantId=null, businessService=null, businessId=null, action=null, moduleName=null, state=null, comment=null, documents=null, assigner=null, assignee=null, nextActions=null, stateSla=null, businesssServiceSla=null, previousStatus=null, entity=null, auditDetails=null)])", result.toString());
	}

	/**
	 * Run the ProcessInstanceRequest addProcessInstanceItem(ProcessInstance) method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:11 PM
	 */
	@Test
	public void testAddProcessInstanceItem_2()
		throws Exception {
		ProcessInstanceRequest fixture = new ProcessInstanceRequest(new RequestInfo(),null);
		ProcessInstance processInstanceItem = new ProcessInstance();

		ProcessInstanceRequest result = fixture.addProcessInstanceItem(processInstanceItem);

		
		assertNotNull(result);
		assertEquals("ProcessInstanceRequest(requestInfo=RequestInfo(apiId=null, ver=null, ts=null, action=null, did=null, key=null, msgId=null, authToken=null, correlationId=null, userInfo=null), processInstances=[ProcessInstance(id=null, tenantId=null, businessService=null, businessId=null, action=null, moduleName=null, state=null, comment=null, documents=null, assigner=null, assignee=null, nextActions=null, stateSla=null, businesssServiceSla=null, previousStatus=null, entity=null, auditDetails=null)])", result.toString());
	}

	/**
	 * Run the ProcessInstanceRequest.ProcessInstanceRequestBuilder builder() method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:11 PM
	 */
	@Test
	public void testBuilder_1()
		throws Exception {

		ProcessInstanceRequest.ProcessInstanceRequestBuilder result = ProcessInstanceRequest.builder();

		
		assertNotNull(result);
		assertEquals("ProcessInstanceRequest.ProcessInstanceRequestBuilder(requestInfo=null, processInstances=null)", result.toString());
	}

	@Test
	public void testBuilder_2()
		throws Exception {

		ProcessInstanceRequest.ProcessInstanceRequestBuilder builder = ProcessInstanceRequest.builder();
		builder.processInstances(null);
		builder.requestInfo(null);
		builder.build();
		
		ProcessInstanceRequest.ProcessInstanceRequestBuilder builder2 = ProcessInstanceRequest.builder();
		builder2.processInstances(null);
		builder2.requestInfo(null);
		builder2.build();
		
		Assert.assertEquals(builder2.toString(), builder.toString());
	}
	/**
	 * Run the List<ProcessInstance> getProcessInstances() method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:11 PM
	 */
	@Test
	public void testGetProcessInstances_1()
		throws Exception {
		ProcessInstanceRequest fixture = new ProcessInstanceRequest(new RequestInfo(),null) ; 

		List<ProcessInstance> result = fixture.getProcessInstances();
		assertEquals(null, result);
	}

	/**
	 * Run the RequestInfo getRequestInfo() method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:11 PM
	 */
	@Test
	public void testGetRequestInfo_1()
		throws Exception {
		ProcessInstanceRequest fixture = new ProcessInstanceRequest(new RequestInfo(),null);

		RequestInfo result = fixture.getRequestInfo();

		
		assertNotNull(result);
		assertEquals("RequestInfo(apiId=null, ver=null, ts=null, action=null, did=null, key=null, msgId=null, authToken=null, correlationId=null, userInfo=null)", result.toString());
		assertEquals(null, result.getKey());
		assertEquals(null, result.getUserInfo());
		assertEquals(null, result.getAction());
		assertEquals(null, result.getDid());
		assertEquals(null, result.getVer());
		assertEquals(null, result.getAuthToken());
		assertEquals(null, result.getApiId());
		assertEquals(null, result.getTs());
		assertEquals(null, result.getMsgId());
		assertEquals(null, result.getCorrelationId());
	}

	/**
	 * Run the void setProcessInstances(List<ProcessInstance>) method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:11 PM
	 */
	@Test
	public void testSetProcessInstances_1()
		throws Exception {
		ProcessInstanceRequest fixture = new ProcessInstanceRequest(new RequestInfo(),null);
		List<ProcessInstance> processInstances = null;
		fixture.setProcessInstances(processInstances);
		
	}

	/**
	 * Run the void setRequestInfo(RequestInfo) method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:11 PM
	 */
	@Test
	public void testSetRequestInfo_1()
		throws Exception {
		ProcessInstanceRequest fixture = new ProcessInstanceRequest(new RequestInfo(),null);
		RequestInfo requestInfo = new RequestInfo();

		fixture.setRequestInfo(requestInfo);

		
	}
}