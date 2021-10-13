package org.egov.ec.web.models;

import org.egov.common.contract.request.RequestInfo;
import org.egov.ec.web.models.AuditDetails;
import org.egov.ec.web.models.RequestInfoWrapper;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * The class <code>RequestInfoWrapperTest</code> contains tests for the class <code>{@link RequestInfoWrapper}</code>.
 *
 * @generated at 17/5/20 2:10 PM
 * @version $Revision: 1.0 $
 */
public class RequestInfoWrapperTest {
	/**
	 * Run the RequestInfoWrapper() constructor test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:10 PM
	 */
	@Test
	public void testRequestInfoWrapper_1()
		throws Exception {

		RequestInfoWrapper result = new RequestInfoWrapper();

		
		assertNotNull(result);
		assertEquals(null, result.getRequestInfo());
		assertEquals(null, result.getAuditDetails());
		assertEquals(null, result.getRequestBody());
	}

	/**
	 * Run the RequestInfoWrapper(RequestInfo,Object,AuditDetails) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:10 PM
	 */
	@Test
	public void testRequestInfoWrapper_2()
		throws Exception {
		RequestInfo requestInfo = new RequestInfo();
		Object requestBody = new Object();
		AuditDetails auditDetails = new AuditDetails();

		RequestInfoWrapper result = new RequestInfoWrapper(requestInfo, requestBody, auditDetails);

		
		assertNotNull(result);
	}

	/**
	 * Run the RequestInfoWrapper.RequestInfoWrapperBuilder builder() method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:10 PM
	 */
	@Test
	public void testBuilder_1()
		throws Exception {

		RequestInfoWrapper.RequestInfoWrapperBuilder result = RequestInfoWrapper.builder();

		
		assertNotNull(result);
		assertEquals("RequestInfoWrapper.RequestInfoWrapperBuilder(requestInfo=null, requestBody=null, auditDetails=null)", result.toString());
	}
	
	@Test
	public void testBuilder_2()
		throws Exception {

		RequestInfoWrapper.RequestInfoWrapperBuilder builder = RequestInfoWrapper.builder();
		builder.requestInfo(null);
		builder.requestBody(null);
		builder.auditDetails(null);
		builder.build();
		
		RequestInfoWrapper.RequestInfoWrapperBuilder builder2 = RequestInfoWrapper.builder();
		builder2.requestInfo(null);
		builder2.requestBody(null);
		builder2.auditDetails(null);
		builder2.build();
		
		Assert.assertEquals(builder2.toString(), builder.toString());
	}

	/**
	 * Run the AuditDetails getAuditDetails() method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:10 PM
	 */
	@Test
	public void testGetAuditDetails_1()
		throws Exception {
		RequestInfoWrapper fixture = new RequestInfoWrapper(new RequestInfo(), new Object(), new AuditDetails());

		AuditDetails result = fixture.getAuditDetails();

		
		assertNotNull(result);
		assertEquals(null, result.getLastModifiedTime());
		assertEquals(null, result.getUserRole());
		assertEquals(null, result.getCreatedTime());
		assertEquals(null, result.getCreatedBy());
		assertEquals(null, result.getLastModifiedBy());
	}

	/**
	 * Run the Object getRequestBody() method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:10 PM
	 */
	@Test
	public void testGetRequestBody_1()
		throws Exception {
		RequestInfoWrapper fixture = new RequestInfoWrapper(new RequestInfo(), new Object(), new AuditDetails());

		Object result = fixture.getRequestBody();

		
		assertNotNull(result);
	}

	/**
	 * Run the RequestInfo getRequestInfo() method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:10 PM
	 */
	@Test
	public void testGetRequestInfo_1()
		throws Exception {
		RequestInfoWrapper fixture = new RequestInfoWrapper(new RequestInfo(), new Object(), new AuditDetails());

		RequestInfo result = fixture.getRequestInfo();

		
		assertNotNull(result);
		assertEquals("RequestInfo(apiId=null, ver=null, ts=null, action=null, did=null, key=null, msgId=null, authToken=null, correlationId=null, userInfo=null)", result.toString());
		assertEquals(null, result.getKey());
		assertEquals(null, result.getUserInfo());
		assertEquals(null, result.getAction());
		assertEquals(null, result.getDid());
		assertEquals(null, result.getAuthToken());
		assertEquals(null, result.getVer());
		assertEquals(null, result.getCorrelationId());
		assertEquals(null, result.getApiId());
		assertEquals(null, result.getTs());
		assertEquals(null, result.getMsgId());
	}

	/**
	 * Run the void setAuditDetails(AuditDetails) method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:10 PM
	 */
	@Test
	public void testSetAuditDetails_1()
		throws Exception {
		RequestInfoWrapper fixture = new RequestInfoWrapper(new RequestInfo(), new Object(), new AuditDetails());
		AuditDetails auditDetails = new AuditDetails();

		fixture.setAuditDetails(auditDetails);

		
	}

	/**
	 * Run the void setRequestBody(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:10 PM
	 */
	@Test
	public void testSetRequestBody_1()
		throws Exception {
		RequestInfoWrapper fixture = new RequestInfoWrapper(new RequestInfo(), new Object(), new AuditDetails());
		Object requestBody = new Object();

		fixture.setRequestBody(requestBody);

		
	}

	/**
	 * Run the void setRequestInfo(RequestInfo) method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:10 PM
	 */
	@Test
	public void testSetRequestInfo_1()
		throws Exception {
		RequestInfoWrapper fixture = new RequestInfoWrapper(new RequestInfo(), new Object(), new AuditDetails());
		RequestInfo requestInfo = new RequestInfo();

		fixture.setRequestInfo(requestInfo);

		
	}
}