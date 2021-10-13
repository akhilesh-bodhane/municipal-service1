package org.egov.prscp.web.models;

import org.egov.common.contract.request.RequestInfo;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * The class <code>RequestInfoWrapperTest</code> contains tests for the class <code>{@link RequestInfoWrapper}</code>.
 *
 * @generatedBy CodePro at 25/5/20 3:50 PM
 * @author Aniket.Marathe
 * @version $Revision: 1.0 $
 */
public class RequestInfoWrapperTest {
	/**
	 * Run the RequestInfoWrapper() constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:50 PM
	 */
	@Test
	public void testRequestInfoWrapper_1()
		throws Exception {

		RequestInfoWrapper result = new RequestInfoWrapper();

		// add additional test code here
		assertNotNull(result);
		assertEquals("RequestInfoWrapper(requestInfo=null, requestBody=null, auditDetails=null, applicationType=null, tenantId=null, applicationStatus=null, applicationId=null, actions=null)", result.toString());
		assertEquals(null, result.getActions());
		assertEquals(null, result.getApplicationId());
		assertEquals(null, result.getApplicationType());
		assertEquals(null, result.getApplicationStatus());
		assertEquals(null, result.getTenantId());
		assertEquals(null, result.getRequestInfo());
		assertEquals(null, result.getAuditDetails());
		assertEquals(null, result.getRequestBody());
	}

	/**
	 * Run the RequestInfoWrapper(RequestInfo,Object,AuditDetails,String,String,String,String,String) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:50 PM
	 */
	@Test
	public void testRequestInfoWrapper_2()
		throws Exception {
		RequestInfo requestInfo = new RequestInfo();
		Object requestBody = new Object();
		AuditDetails auditDetails = new AuditDetails();
		String applicationType = "";
		String tenantId = "";
		String applicationStatus = "";
		String applicationId = "";
		String actions = "";

		RequestInfoWrapper result = new RequestInfoWrapper(requestInfo, requestBody, auditDetails, applicationType, tenantId, applicationStatus, applicationId, actions);

		// add additional test code here
		assertNotNull(result);
		//assertEquals("RequestInfoWrapper(requestInfo=RequestInfo(apiId=null, ver=null, ts=null, action=null, did=null, key=null, msgId=null, authToken=null, correlationId=null, userInfo=null), requestBody=java.lang.Object@63a36337, auditDetails=org.egov.prscp.web.models.AuditDetails@6d649133, applicationType=, tenantId=, applicationStatus=, applicationId=, actions=)", result.toString());
		assertEquals("", result.getActions());
		assertEquals("", result.getApplicationId());
		assertEquals("", result.getApplicationType());
		assertEquals("", result.getApplicationStatus());
		assertEquals("", result.getTenantId());
		//assertEquals(new Object(), result.getRequestBody());
	}

	/**
	 * Run the RequestInfoWrapper.RequestInfoWrapperBuilder builder() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:50 PM
	 */
	@Test
	public void testBuilder_1()
		throws Exception {

		RequestInfoWrapper.RequestInfoWrapperBuilder result = RequestInfoWrapper.builder();

		// add additional test code here
		assertNotNull(result);
		assertEquals("RequestInfoWrapper.RequestInfoWrapperBuilder(requestInfo=null, requestBody=null, auditDetails=null, applicationType=null, tenantId=null, applicationStatus=null, applicationId=null, actions=null)", result.toString());
	}

	/**
	 * Run the String getActions() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:50 PM
	 */
	@Test
	public void testGetActions_1()
		throws Exception {
		RequestInfoWrapper fixture = new RequestInfoWrapper(new RequestInfo(), new Object(), new AuditDetails(), "", "", "", "", "");

		String result = fixture.getActions();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the String getApplicationId() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:50 PM
	 */
	@Test
	public void testGetApplicationId_1()
		throws Exception {
		RequestInfoWrapper fixture = new RequestInfoWrapper(new RequestInfo(), new Object(), new AuditDetails(), "", "", "", "", "");

		String result = fixture.getApplicationId();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the String getApplicationStatus() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:50 PM
	 */
	@Test
	public void testGetApplicationStatus_1()
		throws Exception {
		RequestInfoWrapper fixture = new RequestInfoWrapper(new RequestInfo(), new Object(), new AuditDetails(), "", "", "", "", "");

		String result = fixture.getApplicationStatus();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the String getApplicationType() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:50 PM
	 */
	@Test
	public void testGetApplicationType_1()
		throws Exception {
		RequestInfoWrapper fixture = new RequestInfoWrapper(new RequestInfo(), new Object(), new AuditDetails(), "", "", "", "", "");

		String result = fixture.getApplicationType();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the AuditDetails getAuditDetails() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:50 PM
	 */
	@Test
	public void testGetAuditDetails_1()
		throws Exception {
		RequestInfoWrapper fixture = new RequestInfoWrapper(new RequestInfo(), new Object(), new AuditDetails(), "", "", "", "", "");

		AuditDetails result = fixture.getAuditDetails();

		// add additional test code here
		assertNotNull(result);
		assertEquals(null, result.getLastModifiedTime());
		assertEquals(null, result.getCreatedTime());
		assertEquals(null, result.getLastModifiedBy());
		assertEquals(null, result.getCreatedBy());
	}

	/**
	 * Run the Object getRequestBody() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:50 PM
	 */
	@Test
	public void testGetRequestBody_1()
		throws Exception {
		RequestInfoWrapper fixture = new RequestInfoWrapper(new RequestInfo(), new Object(), new AuditDetails(), "", "", "", "", "");

		Object result = fixture.getRequestBody();

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the RequestInfo getRequestInfo() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:50 PM
	 */
	@Test
	public void testGetRequestInfo_1()
		throws Exception {
		RequestInfoWrapper fixture = new RequestInfoWrapper(new RequestInfo(), new Object(), new AuditDetails(), "", "", "", "", "");

		RequestInfo result = fixture.getRequestInfo();

		// add additional test code here
		assertNotNull(result);
		assertEquals("RequestInfo(apiId=null, ver=null, ts=null, action=null, did=null, key=null, msgId=null, authToken=null, correlationId=null, userInfo=null)", result.toString());
		assertEquals(null, result.getKey());
		assertEquals(null, result.getUserInfo());
		assertEquals(null, result.getAction());
		assertEquals(null, result.getApiId());
		assertEquals(null, result.getVer());
		assertEquals(null, result.getTs());
		assertEquals(null, result.getMsgId());
		assertEquals(null, result.getDid());
		assertEquals(null, result.getAuthToken());
		assertEquals(null, result.getCorrelationId());
	}

	/**
	 * Run the String getTenantId() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:50 PM
	 */
	@Test
	public void testGetTenantId_1()
		throws Exception {
		RequestInfoWrapper fixture = new RequestInfoWrapper(new RequestInfo(), new Object(), new AuditDetails(), "", "", "", "", "");

		String result = fixture.getTenantId();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the void setActions(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:50 PM
	 */
	@Test
	public void testSetActions_1()
		throws Exception {
		RequestInfoWrapper fixture = new RequestInfoWrapper(new RequestInfo(), new Object(), new AuditDetails(), "", "", "", "", "");
		String actions = "";

		fixture.setActions(actions);

		// add additional test code here
	}

	/**
	 * Run the void setApplicationId(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:50 PM
	 */
	@Test
	public void testSetApplicationId_1()
		throws Exception {
		RequestInfoWrapper fixture = new RequestInfoWrapper(new RequestInfo(), new Object(), new AuditDetails(), "", "", "", "", "");
		String applicationId = "";

		fixture.setApplicationId(applicationId);

		// add additional test code here
	}

	/**
	 * Run the void setApplicationStatus(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:50 PM
	 */
	@Test
	public void testSetApplicationStatus_1()
		throws Exception {
		RequestInfoWrapper fixture = new RequestInfoWrapper(new RequestInfo(), new Object(), new AuditDetails(), "", "", "", "", "");
		String applicationStatus = "";

		fixture.setApplicationStatus(applicationStatus);

		// add additional test code here
	}

	/**
	 * Run the void setApplicationType(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:50 PM
	 */
	@Test
	public void testSetApplicationType_1()
		throws Exception {
		RequestInfoWrapper fixture = new RequestInfoWrapper(new RequestInfo(), new Object(), new AuditDetails(), "", "", "", "", "");
		String applicationType = "";

		fixture.setApplicationType(applicationType);

		// add additional test code here
	}

	/**
	 * Run the void setAuditDetails(AuditDetails) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:50 PM
	 */
	@Test
	public void testSetAuditDetails_1()
		throws Exception {
		RequestInfoWrapper fixture = new RequestInfoWrapper(new RequestInfo(), new Object(), new AuditDetails(), "", "", "", "", "");
		AuditDetails auditDetails = new AuditDetails();

		fixture.setAuditDetails(auditDetails);

		// add additional test code here
	}

	/**
	 * Run the void setRequestBody(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:50 PM
	 */
	@Test
	public void testSetRequestBody_1()
		throws Exception {
		RequestInfoWrapper fixture = new RequestInfoWrapper(new RequestInfo(), new Object(), new AuditDetails(), "", "", "", "", "");
		Object requestBody = new Object();

		fixture.setRequestBody(requestBody);

		// add additional test code here
	}

	/**
	 * Run the void setRequestInfo(RequestInfo) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:50 PM
	 */
	@Test
	public void testSetRequestInfo_1()
		throws Exception {
		RequestInfoWrapper fixture = new RequestInfoWrapper(new RequestInfo(), new Object(), new AuditDetails(), "", "", "", "", "");
		RequestInfo requestInfo = new RequestInfo();

		fixture.setRequestInfo(requestInfo);

		// add additional test code here
	}

	/**
	 * Run the void setTenantId(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:50 PM
	 */
	@Test
	public void testSetTenantId_1()
		throws Exception {
		RequestInfoWrapper fixture = new RequestInfoWrapper(new RequestInfo(), new Object(), new AuditDetails(), "", "", "", "", "");
		String tenantId = "";

		fixture.setTenantId(tenantId);

		// add additional test code here
	}

	/**
	 * Perform pre-test initialization.
	 *
	 * @throws Exception
	 *         if the initialization fails for some reason
	 *
	 * @generatedBy CodePro at 25/5/20 3:50 PM
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
	 * @generatedBy CodePro at 25/5/20 3:50 PM
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
	 * @generatedBy CodePro at 25/5/20 3:50 PM
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(RequestInfoWrapperTest.class);
	}
}