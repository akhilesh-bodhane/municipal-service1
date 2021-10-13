package org.egov.prscp.web.models.Idgen;

import java.util.List;
import org.easymock.EasyMock;
import org.egov.common.contract.response.ResponseInfo;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * The class <code>IdGenerationResponseTest</code> contains tests for the class <code>{@link IdGenerationResponse}</code>.
 *
 * @generatedBy CodePro at 25/5/20 3:54 PM
 * @author Aniket.Marathe
 * @version $Revision: 1.0 $
 */
public class IdGenerationResponseTest {
	/**
	 * Run the IdGenerationResponse() constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:54 PM
	 */
	@Test
	public void testIdGenerationResponse_1()
		throws Exception {

		IdGenerationResponse result = new IdGenerationResponse();

		// add additional test code here
		assertNotNull(result);
		assertEquals("IdGenerationResponse(responseInfo=null, idResponses=null)", result.toString());
		assertEquals(null, result.getIdResponses());
		assertEquals(null, result.getResponseInfo());
	}

	/**
	 * Run the IdGenerationResponse(ResponseInfo,List<IdResponse>) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:54 PM
	 */
	@Test
	public void testIdGenerationResponse_2()
		throws Exception {
		ResponseInfo responseInfo = new ResponseInfo();
		List<IdResponse> idResponses = EasyMock.createMock(List.class);
		// add mock object expectations here

		EasyMock.replay(idResponses);

		IdGenerationResponse result = new IdGenerationResponse(responseInfo, idResponses);

		// add additional test code here
		EasyMock.verify(idResponses);
		assertNotNull(result);
		assertEquals("IdGenerationResponse(responseInfo=ResponseInfo(apiId=null, ver=null, ts=null, resMsgId=null, msgId=null, status=null), idResponses=EasyMock for interface java.util.List)", result.toString());
	}

	/**
	 * Run the IdGenerationResponse.IdGenerationResponseBuilder builder() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:54 PM
	 */
	@Test
	public void testBuilder_1()
		throws Exception {

		IdGenerationResponse.IdGenerationResponseBuilder result = IdGenerationResponse.builder();

		// add additional test code here
		assertNotNull(result);
		assertEquals("IdGenerationResponse.IdGenerationResponseBuilder(responseInfo=null, idResponses=null)", result.toString());
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
		IdGenerationResponse fixture = new IdGenerationResponse(new ResponseInfo(), EasyMock.createNiceMock(List.class));
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
		IdGenerationResponse fixture = new IdGenerationResponse(new ResponseInfo(), EasyMock.createNiceMock(List.class));
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
		IdGenerationResponse fixture = new IdGenerationResponse(new ResponseInfo(), EasyMock.createNiceMock(List.class));
		Object o = new IdGenerationResponse(new ResponseInfo(), EasyMock.createNiceMock(List.class));

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
		IdGenerationResponse fixture = new IdGenerationResponse(new ResponseInfo(), EasyMock.createNiceMock(List.class));
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
		IdGenerationResponse fixture = new IdGenerationResponse(new ResponseInfo(), EasyMock.createNiceMock(List.class));
		Object o = new IdGenerationResponse(new ResponseInfo(), EasyMock.createNiceMock(List.class));

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
		IdGenerationResponse fixture = new IdGenerationResponse(new ResponseInfo(), EasyMock.createNiceMock(List.class));
		Object o = new IdGenerationResponse(new ResponseInfo(), EasyMock.createNiceMock(List.class));

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
		IdGenerationResponse fixture = new IdGenerationResponse(new ResponseInfo(), EasyMock.createNiceMock(List.class));
		Object o = new IdGenerationResponse(new ResponseInfo(), EasyMock.createNiceMock(List.class));

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
		IdGenerationResponse fixture = new IdGenerationResponse(new ResponseInfo(), (List<IdResponse>) null);
		Object o = new IdGenerationResponse(new ResponseInfo(), (List<IdResponse>) null);

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
		IdGenerationResponse fixture = new IdGenerationResponse(new ResponseInfo(), EasyMock.createNiceMock(List.class));
		Object o = new IdGenerationResponse(new ResponseInfo(), EasyMock.createNiceMock(List.class));

		boolean result = fixture.equals(o);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the List<IdResponse> getIdResponses() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:54 PM
	 */
	@Test
	public void testGetIdResponses_1()
		throws Exception {
		IdGenerationResponse fixture = new IdGenerationResponse(new ResponseInfo(), EasyMock.createNiceMock(List.class));

		List<IdResponse> result = fixture.getIdResponses();

		// add additional test code here
		assertNotNull(result);
		assertEquals(0, result.size());
	}

	/**
	 * Run the ResponseInfo getResponseInfo() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:54 PM
	 */
	@Test
	public void testGetResponseInfo_1()
		throws Exception {
		IdGenerationResponse fixture = new IdGenerationResponse(new ResponseInfo(), EasyMock.createNiceMock(List.class));

		ResponseInfo result = fixture.getResponseInfo();

		// add additional test code here
		assertNotNull(result);
		assertEquals("ResponseInfo(apiId=null, ver=null, ts=null, resMsgId=null, msgId=null, status=null)", result.toString());
		assertEquals(null, result.getStatus());
		assertEquals(null, result.getMsgId());
		assertEquals(null, result.getVer());
		assertEquals(null, result.getResMsgId());
		assertEquals(null, result.getApiId());
		assertEquals(null, result.getTs());
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
		IdGenerationResponse fixture = new IdGenerationResponse((ResponseInfo) null, EasyMock.createNiceMock(List.class));

		int result = fixture.hashCode();

		// add additional test code here
		//assertEquals(1700317734, result);
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
		IdGenerationResponse fixture = new IdGenerationResponse(new ResponseInfo(), (List<IdResponse>) null);

		int result = fixture.hashCode();

		// add additional test code here
		assertEquals(64208139, result);
	}

	/**
	 * Run the void setIdResponses(List<IdResponse>) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:54 PM
	 */
	@Test
	public void testSetIdResponses_1()
		throws Exception {
		IdGenerationResponse fixture = new IdGenerationResponse(new ResponseInfo(), EasyMock.createNiceMock(List.class));
		List<IdResponse> idResponses = EasyMock.createMock(List.class);
		// add mock object expectations here

		EasyMock.replay(idResponses);

		fixture.setIdResponses(idResponses);

		// add additional test code here
		EasyMock.verify(idResponses);
	}

	/**
	 * Run the void setResponseInfo(ResponseInfo) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:54 PM
	 */
	@Test
	public void testSetResponseInfo_1()
		throws Exception {
		IdGenerationResponse fixture = new IdGenerationResponse(new ResponseInfo(), EasyMock.createNiceMock(List.class));
		ResponseInfo responseInfo = new ResponseInfo();

		fixture.setResponseInfo(responseInfo);

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
		new org.junit.runner.JUnitCore().run(IdGenerationResponseTest.class);
	}
}