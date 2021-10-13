package org.egov.prscp.web.models.Idgen;

import java.util.List;
import org.easymock.EasyMock;
import org.egov.common.contract.request.RequestInfo;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * The class <code>IdGenerationRequestTest</code> contains tests for the class <code>{@link IdGenerationRequest}</code>.
 *
 * @generatedBy CodePro at 25/5/20 3:54 PM
 * @author Aniket.Marathe
 * @version $Revision: 1.0 $
 */
public class IdGenerationRequestTest {
	/**
	 * Run the IdGenerationRequest() constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:54 PM
	 */
	@Test
	public void testIdGenerationRequest_1()
		throws Exception {

		IdGenerationRequest result = new IdGenerationRequest();

		// add additional test code here
		assertNotNull(result);
		assertEquals("IdGenerationRequest(requestInfo=null, idRequests=null)", result.toString());
		assertEquals(null, result.getRequestInfo());
		assertEquals(null, result.getIdRequests());
	}

	/**
	 * Run the IdGenerationRequest(RequestInfo,List<IdRequest>) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:54 PM
	 */
	@Test
	public void testIdGenerationRequest_2()
		throws Exception {
		RequestInfo requestInfo = new RequestInfo();
		List<IdRequest> idRequests = EasyMock.createMock(List.class);
		// add mock object expectations here

		EasyMock.replay(idRequests);

		IdGenerationRequest result = new IdGenerationRequest(requestInfo, idRequests);

		// add additional test code here
		EasyMock.verify(idRequests);
		assertNotNull(result);
		assertEquals("IdGenerationRequest(requestInfo=RequestInfo(apiId=null, ver=null, ts=null, action=null, did=null, key=null, msgId=null, authToken=null, correlationId=null, userInfo=null), idRequests=EasyMock for interface java.util.List)", result.toString());
	}

	/**
	 * Run the IdGenerationRequest.IdGenerationRequestBuilder builder() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:54 PM
	 */
	@Test
	public void testBuilder_1()
		throws Exception {

		IdGenerationRequest.IdGenerationRequestBuilder result = IdGenerationRequest.builder();

		// add additional test code here
		assertNotNull(result);
		assertEquals("IdGenerationRequest.IdGenerationRequestBuilder(requestInfo=null, idRequests=null)", result.toString());
	}

	/**
	 * Run the boolean canEqual(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:54 PM
	 */
	@Test
	public void testCanEqual_1()
		throws Exception {
		IdGenerationRequest fixture = new IdGenerationRequest(new RequestInfo(), EasyMock.createNiceMock(List.class));
		Object other = new Object();

		boolean result = fixture.canEqual(other);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the boolean canEqual(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:54 PM
	 */
	@Test
	public void testCanEqual_2()
		throws Exception {
		IdGenerationRequest fixture = new IdGenerationRequest(new RequestInfo(), EasyMock.createNiceMock(List.class));
		Object other = new Object();

		boolean result = fixture.canEqual(other);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:54 PM
	 */
	@Test
	public void testEquals_1()
		throws Exception {
		IdGenerationRequest fixture = new IdGenerationRequest(new RequestInfo(), EasyMock.createNiceMock(List.class));
		Object o = new IdGenerationRequest(new RequestInfo(), EasyMock.createNiceMock(List.class));

		boolean result = fixture.equals(o);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:54 PM
	 */
	@Test
	public void testEquals_2()
		throws Exception {
		IdGenerationRequest fixture = new IdGenerationRequest(new RequestInfo(), EasyMock.createNiceMock(List.class));
		Object o = new Object();

		boolean result = fixture.equals(o);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:54 PM
	 */
	@Test
	public void testEquals_3()
		throws Exception {
		IdGenerationRequest fixture = new IdGenerationRequest(new RequestInfo(), EasyMock.createNiceMock(List.class));
		Object o = new IdGenerationRequest(new RequestInfo(), EasyMock.createNiceMock(List.class));

		boolean result = fixture.equals(o);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:54 PM
	 */
	@Test
	public void testEquals_4()
		throws Exception {
		IdGenerationRequest fixture = new IdGenerationRequest(new RequestInfo(), EasyMock.createNiceMock(List.class));
		Object o = new IdGenerationRequest(new RequestInfo(), EasyMock.createNiceMock(List.class));

		boolean result = fixture.equals(o);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:54 PM
	 */
	@Test
	public void testEquals_5()
		throws Exception {
		IdGenerationRequest fixture = new IdGenerationRequest(new RequestInfo(), EasyMock.createNiceMock(List.class));
		Object o = new IdGenerationRequest(new RequestInfo(), EasyMock.createNiceMock(List.class));

		boolean result = fixture.equals(o);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:54 PM
	 */
	@Test
	public void testEquals_6()
		throws Exception {
		IdGenerationRequest fixture = new IdGenerationRequest(new RequestInfo(), (List<IdRequest>) null);
		Object o = new IdGenerationRequest(new RequestInfo(), (List<IdRequest>) null);

		boolean result = fixture.equals(o);

		// add additional test code here
		assertEquals(true, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:54 PM
	 */
	@Test
	public void testEquals_7()
		throws Exception {
		IdGenerationRequest fixture = new IdGenerationRequest(new RequestInfo(), EasyMock.createNiceMock(List.class));
		Object o = new IdGenerationRequest(new RequestInfo(), EasyMock.createNiceMock(List.class));

		boolean result = fixture.equals(o);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the List<IdRequest> getIdRequests() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:54 PM
	 */
	@Test
	public void testGetIdRequests_1()
		throws Exception {
		IdGenerationRequest fixture = new IdGenerationRequest(new RequestInfo(), EasyMock.createNiceMock(List.class));

		List<IdRequest> result = fixture.getIdRequests();

		// add additional test code here
		assertNotNull(result);
		assertEquals(0, result.size());
	}

	/**
	 * Run the RequestInfo getRequestInfo() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:54 PM
	 */
	@Test
	public void testGetRequestInfo_1()
		throws Exception {
		IdGenerationRequest fixture = new IdGenerationRequest(new RequestInfo(), EasyMock.createNiceMock(List.class));

		RequestInfo result = fixture.getRequestInfo();

		// add additional test code here
		assertNotNull(result);
		assertEquals("RequestInfo(apiId=null, ver=null, ts=null, action=null, did=null, key=null, msgId=null, authToken=null, correlationId=null, userInfo=null)", result.toString());
		assertEquals(null, result.getKey());
		assertEquals(null, result.getUserInfo());
		assertEquals(null, result.getAction());
		assertEquals(null, result.getMsgId());
		assertEquals(null, result.getVer());
		assertEquals(null, result.getApiId());
		assertEquals(null, result.getTs());
		assertEquals(null, result.getDid());
		assertEquals(null, result.getAuthToken());
		assertEquals(null, result.getCorrelationId());
	}

	/**
	 * Run the int hashCode() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:54 PM
	 */
	@Test
	public void testHashCode_1()
		throws Exception {
		IdGenerationRequest fixture = new IdGenerationRequest((RequestInfo) null, EasyMock.createNiceMock(List.class));

		int result = fixture.hashCode();

		// add additional test code here
		//assertEquals(1635866830, result);
	}

	/**
	 * Run the int hashCode() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:54 PM
	 */
	@Test
	public void testHashCode_2()
		throws Exception {
		IdGenerationRequest fixture = new IdGenerationRequest(new RequestInfo(), (List<IdRequest>) null);

		int result = fixture.hashCode();

		// add additional test code here
		assertEquals(651857139, result);
	}

	/**
	 * Run the void setIdRequests(List<IdRequest>) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:54 PM
	 */
	@Test
	public void testSetIdRequests_1()
		throws Exception {
		IdGenerationRequest fixture = new IdGenerationRequest(new RequestInfo(), EasyMock.createNiceMock(List.class));
		List<IdRequest> idRequests = EasyMock.createMock(List.class);
		// add mock object expectations here

		EasyMock.replay(idRequests);

		fixture.setIdRequests(idRequests);

		// add additional test code here
		EasyMock.verify(idRequests);
	}

	/**
	 * Run the void setRequestInfo(RequestInfo) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:54 PM
	 */
	@Test
	public void testSetRequestInfo_1()
		throws Exception {
		IdGenerationRequest fixture = new IdGenerationRequest(new RequestInfo(), EasyMock.createNiceMock(List.class));
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
	 * @generatedBy CodePro at 25/5/20 3:54 PM
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
	 * @generatedBy CodePro at 25/5/20 3:54 PM
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
	 * @generatedBy CodePro at 25/5/20 3:54 PM
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(IdGenerationRequestTest.class);
	}
}