package org.egov.prscp.web.models;

import java.util.List;
import org.easymock.EasyMock;
import org.egov.common.contract.request.RequestInfo;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * The class <code>ProcessInstanceRequestTest</code> contains tests for the class <code>{@link ProcessInstanceRequest}</code>.
 *
 * @generatedBy CodePro at 25/5/20 3:48 PM
 * @author Aniket.Marathe
 * @version $Revision: 1.0 $
 */
public class ProcessInstanceRequestTest {
	/**
	 * Run the ProcessInstanceRequest() constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:48 PM
	 */
	@Test
	public void testProcessInstanceRequest_1()
		throws Exception {

		ProcessInstanceRequest result = new ProcessInstanceRequest();

		// add additional test code here
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
	 * @generatedBy CodePro at 25/5/20 3:48 PM
	 */
	@Test
	public void testProcessInstanceRequest_2()
		throws Exception {
		RequestInfo requestInfo = new RequestInfo();
		List<ProcessInstance> processInstances = EasyMock.createMock(List.class);
		// add mock object expectations here

		EasyMock.replay(processInstances);

		ProcessInstanceRequest result = new ProcessInstanceRequest(requestInfo, processInstances);

		// add additional test code here
		EasyMock.verify(processInstances);
		assertNotNull(result);
		assertEquals("ProcessInstanceRequest(requestInfo=RequestInfo(apiId=null, ver=null, ts=null, action=null, did=null, key=null, msgId=null, authToken=null, correlationId=null, userInfo=null), processInstances=EasyMock for interface java.util.List)", result.toString());
	}

	/**
	 * Run the ProcessInstanceRequest addProcessInstanceItem(ProcessInstance) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:48 PM
	 */
	@Test
	public void testAddProcessInstanceItem_1()
		throws Exception {
		ProcessInstanceRequest fixture = new ProcessInstanceRequest(new RequestInfo(), (List<ProcessInstance>) null);
		ProcessInstance processInstanceItem = new ProcessInstance();

		ProcessInstanceRequest result = fixture.addProcessInstanceItem(processInstanceItem);

		// add additional test code here
		assertNotNull(result);
		assertEquals("ProcessInstanceRequest(requestInfo=RequestInfo(apiId=null, ver=null, ts=null, action=null, did=null, key=null, msgId=null, authToken=null, correlationId=null, userInfo=null), processInstances=[ProcessInstance(id=null, tenantId=null, businessService=null, businessId=null, action=null, moduleName=null, state=null, comment=null, documents=null, assigner=null, assignee=null, nextActions=null, stateSla=null, businesssServiceSla=null, previousStatus=null, entity=null, auditDetails=null)])", result.toString());
	}

	/**
	 * Run the ProcessInstanceRequest addProcessInstanceItem(ProcessInstance) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:48 PM
	 */
	@Test
	public void testAddProcessInstanceItem_2()
		throws Exception {
		ProcessInstanceRequest fixture = new ProcessInstanceRequest(new RequestInfo(), EasyMock.createNiceMock(List.class));
		ProcessInstance processInstanceItem = new ProcessInstance();

		ProcessInstanceRequest result = fixture.addProcessInstanceItem(processInstanceItem);

		// add additional test code here
		assertNotNull(result);
		assertEquals("ProcessInstanceRequest(requestInfo=RequestInfo(apiId=null, ver=null, ts=null, action=null, did=null, key=null, msgId=null, authToken=null, correlationId=null, userInfo=null), processInstances=EasyMock for interface java.util.List)", result.toString());
	}

	/**
	 * Run the ProcessInstanceRequest.ProcessInstanceRequestBuilder builder() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:48 PM
	 */
	@Test
	public void testBuilder_1()
		throws Exception {

		ProcessInstanceRequest.ProcessInstanceRequestBuilder result = ProcessInstanceRequest.builder();

		// add additional test code here
		assertNotNull(result);
		assertEquals("ProcessInstanceRequest.ProcessInstanceRequestBuilder(requestInfo=null, processInstances=null)", result.toString());
	}

	/**
	 * Run the List<ProcessInstance> getProcessInstances() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:48 PM
	 */
	@Test
	public void testGetProcessInstances_1()
		throws Exception {
		ProcessInstanceRequest fixture = new ProcessInstanceRequest(new RequestInfo(), EasyMock.createNiceMock(List.class));

		List<ProcessInstance> result = fixture.getProcessInstances();

		// add additional test code here
		assertNotNull(result);
		assertEquals(0, result.size());
	}

	/**
	 * Run the RequestInfo getRequestInfo() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:48 PM
	 */
	@Test
	public void testGetRequestInfo_1()
		throws Exception {
		ProcessInstanceRequest fixture = new ProcessInstanceRequest(new RequestInfo(), EasyMock.createNiceMock(List.class));

		RequestInfo result = fixture.getRequestInfo();

		// add additional test code here
		assertNotNull(result);
		assertEquals("RequestInfo(apiId=null, ver=null, ts=null, action=null, did=null, key=null, msgId=null, authToken=null, correlationId=null, userInfo=null)", result.toString());
		assertEquals(null, result.getKey());
		assertEquals(null, result.getUserInfo());
		assertEquals(null, result.getAction());
		assertEquals(null, result.getDid());
		assertEquals(null, result.getMsgId());
		assertEquals(null, result.getAuthToken());
		assertEquals(null, result.getCorrelationId());
		assertEquals(null, result.getVer());
		assertEquals(null, result.getTs());
		assertEquals(null, result.getApiId());
	}

	/**
	 * Run the void setProcessInstances(List<ProcessInstance>) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:48 PM
	 */
	@Test
	public void testSetProcessInstances_1()
		throws Exception {
		ProcessInstanceRequest fixture = new ProcessInstanceRequest(new RequestInfo(), EasyMock.createNiceMock(List.class));
		List<ProcessInstance> processInstances = EasyMock.createMock(List.class);
		// add mock object expectations here

		EasyMock.replay(processInstances);

		fixture.setProcessInstances(processInstances);

		// add additional test code here
		EasyMock.verify(processInstances);
	}

	/**
	 * Run the void setRequestInfo(RequestInfo) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:48 PM
	 */
	@Test
	public void testSetRequestInfo_1()
		throws Exception {
		ProcessInstanceRequest fixture = new ProcessInstanceRequest(new RequestInfo(), EasyMock.createNiceMock(List.class));
		RequestInfo requestInfo = new RequestInfo();

		fixture.setRequestInfo(requestInfo);

		// add additional test code here
	}

	/**
	 * Perform pre-test initialization.
	 *
	 * @throws Exception
	 *         if the initialization fails for some reason
	 *
	 * @generatedBy CodePro at 25/5/20 3:48 PM
	 */
	@Before
	public void setUp()
		throws Exception {
		// add additional set up code here
	}

	/**
	 * Perform post-test clean-up.
	 *
	 * @throws Exception
	 *         if the clean-up fails for some reason
	 *
	 * @generatedBy CodePro at 25/5/20 3:48 PM
	 */
	@After
	public void tearDown()
		throws Exception {
		// Add additional tear down code here
	}

	/**
	 * Launch the test.
	 *
	 * @param args the command line arguments
	 *
	 * @generatedBy CodePro at 25/5/20 3:48 PM
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(ProcessInstanceRequestTest.class);
	}
}