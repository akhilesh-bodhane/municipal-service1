package org.egov.ec.web.models.Idgen;

import java.util.List;
import org.egov.common.contract.request.RequestInfo;
import org.egov.ec.web.models.Idgen.IdGenerationRequest;
import org.egov.ec.web.models.Idgen.IdRequest;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * The class <code>IdGenerationRequestTest</code> contains tests for the class <code>{@link IdGenerationRequest}</code>.
 *
 * @generated at 17/5/20 2:10 PM
 * @version $Revision: 1.0 $
 */
public class IdGenerationRequestTest {
	/**
	 * Run the IdGenerationRequest() constructor test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:10 PM
	 */
	@Test
	public void testIdGenerationRequest_1()
		throws Exception {

		IdGenerationRequest result = new IdGenerationRequest();

		
		assertNotNull(result);
		assertEquals("IdGenerationRequest(requestInfo=null, idRequests=null)", result.toString());
		assertEquals(null, result.getIdRequests());
		assertEquals(null, result.getRequestInfo());
	}

	/**
	 * Run the IdGenerationRequest(RequestInfo,List<IdRequest>) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:10 PM
	 */
	@Test
	public void testIdGenerationRequest_2()
		throws Exception {
		RequestInfo requestInfo = new RequestInfo();
		List<IdRequest> idRequests = null;

		IdGenerationRequest result = new IdGenerationRequest(requestInfo, idRequests);
		assertNotNull(result);
		assertEquals("IdGenerationRequest(requestInfo=RequestInfo(apiId=null, ver=null, ts=null, action=null, did=null, key=null, msgId=null, authToken=null, correlationId=null, userInfo=null), idRequests=null)", result.toString());
	}

	/**
	 * Run the IdGenerationRequest.IdGenerationRequestBuilder builder() method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:10 PM
	 */
	@Test
	public void testBuilder_1()
		throws Exception {

		IdGenerationRequest.IdGenerationRequestBuilder result = IdGenerationRequest.builder();

		
		assertNotNull(result);
		assertEquals("IdGenerationRequest.IdGenerationRequestBuilder(requestInfo=null, idRequests=null)", result.toString());
	}
	
	@Test
	public void testBuilder_2()
		throws Exception {
		IdGenerationRequest.IdGenerationRequestBuilder builder = new IdGenerationRequest.IdGenerationRequestBuilder();
		builder.requestInfo(null);
		builder.idRequests(null);
		builder.build();

		IdGenerationRequest.IdGenerationRequestBuilder builder2 = new IdGenerationRequest.IdGenerationRequestBuilder();
		builder2.requestInfo(null);
		builder2.idRequests(null);
		builder2.build();

		Assert.assertEquals(builder2.toString(), builder.toString());
	}

	/**
	 * Run the boolean canEqual(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:10 PM
	 */
	@Test
	public void testCanEqual_1()
		throws Exception {
		IdGenerationRequest fixture = new IdGenerationRequest(new RequestInfo(), null);
		Object other = new Object();

		boolean result = fixture.canEqual(other);

		
		assertEquals(false, result);
	}

	/**
	 * Run the boolean canEqual(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:10 PM
	 */
	@Test
	public void testCanEqual_2()
		throws Exception {
		IdGenerationRequest fixture = new IdGenerationRequest(new RequestInfo(), null);
		Object other = new Object();

		boolean result = fixture.canEqual(other);

		
		assertEquals(false, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:10 PM
	 */
	@Test
	public void testEquals_2()
		throws Exception {
		IdGenerationRequest fixture = new IdGenerationRequest(new RequestInfo(), null);
		Object o = new Object();

		boolean result = fixture.equals(o);

		
		assertEquals(false, result);
	}


	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:10 PM
	 */
	@Test
	public void testEquals_6()
		throws Exception {
		IdGenerationRequest fixture = new IdGenerationRequest(new RequestInfo(), (List<IdRequest>) null);
		Object o = new IdGenerationRequest(new RequestInfo(), (List<IdRequest>) null);

		boolean result = fixture.equals(o);

		
		assertEquals(true, result);
	}
	
	@Test
	public void testEqualsObject() {
		IdGenerationRequest state1=new IdGenerationRequest();
		IdGenerationRequest state2=new IdGenerationRequest();
		Assert.assertEquals(state1,state2);
	}

	/**
	 * Run the List<IdRequest> getIdRequests() method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:10 PM
	 */
	@Test
	public void testGetIdRequests_1()
		throws Exception {
		IdGenerationRequest fixture = new IdGenerationRequest(new RequestInfo(), null);

		List<IdRequest> result = fixture.getIdRequests();
		assertEquals(null, result);
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
		IdGenerationRequest fixture = new IdGenerationRequest(new RequestInfo(), null);

		RequestInfo result = fixture.getRequestInfo();

		
		assertNotNull(result);
		assertEquals("RequestInfo(apiId=null, ver=null, ts=null, action=null, did=null, key=null, msgId=null, authToken=null, correlationId=null, userInfo=null)", result.toString());
		assertEquals(null, result.getKey());
		assertEquals(null, result.getUserInfo());
		assertEquals(null, result.getAction());
		assertEquals(null, result.getApiId());
		assertEquals(null, result.getCorrelationId());
		assertEquals(null, result.getDid());
		assertEquals(null, result.getAuthToken());
		assertEquals(null, result.getTs());
		assertEquals(null, result.getVer());
		assertEquals(null, result.getMsgId());
	}

	/**
	 * Run the int hashCode() method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:10 PM
	 */
	@Test
	public void testHashCode_1()
		throws Exception {
		IdGenerationRequest fixture = new IdGenerationRequest((RequestInfo) null, null);
		IdGenerationRequest fixture1 = new IdGenerationRequest((RequestInfo) null, null);
		int result = fixture.hashCode();
		assertEquals(result, fixture1.hashCode());
	}


	/**
	 * Run the void setIdRequests(List<IdRequest>) method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:10 PM
	 */
	@Test
	public void testSetIdRequests_1()
		throws Exception {
		IdGenerationRequest fixture = new IdGenerationRequest(new RequestInfo(), null);
		List<IdRequest> idRequests = null;

		fixture.setIdRequests(idRequests);

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
		IdGenerationRequest fixture = new IdGenerationRequest(new RequestInfo(), null);
		RequestInfo requestInfo = new RequestInfo();

		fixture.setRequestInfo(requestInfo);

		
	}
}