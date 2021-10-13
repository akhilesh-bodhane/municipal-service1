package org.egov.prscp.web.models;

import java.util.List;
import org.easymock.EasyMock;
import org.egov.common.contract.request.RequestInfo;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * The class <code>PrRequestTest</code> contains tests for the class <code>{@link PrRequest}</code>.
 *
 * @generatedBy CodePro at 25/5/20 3:48 PM
 * @author Aniket.Marathe
 * @version $Revision: 1.0 $
 */
public class PrRequestTest {
	/**
	 * Run the PrRequest() constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:48 PM
	 */
	@Test
	public void testPrRequest_1()
		throws Exception {

		PrRequest result = new PrRequest();

		// add additional test code here
		assertNotNull(result);
		assertEquals(null, result.getPr());
		assertEquals(null, result.getRequestInfo());
	}

	/**
	 * Run the PrRequest(RequestInfo,List<PublicRelationEvent>) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:48 PM
	 */
	@Test
	public void testPrRequest_2()
		throws Exception {
		RequestInfo requestInfo = new RequestInfo();
		List<PublicRelationEvent> pr = EasyMock.createMock(List.class);
		// add mock object expectations here

		EasyMock.replay(pr);

		PrRequest result = new PrRequest(requestInfo, pr);

		// add additional test code here
		EasyMock.verify(pr);
		assertNotNull(result);
	}

	/**
	 * Run the PrRequest.PrRequestBuilder builder() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:48 PM
	 */
	@Test
	public void testBuilder_1()
		throws Exception {

		PrRequest.PrRequestBuilder result = PrRequest.builder();

		// add additional test code here
		assertNotNull(result);
		assertEquals("PrRequest.PrRequestBuilder(requestInfo=null, pr=null)", result.toString());
	}

	/**
	 * Run the List<PublicRelationEvent> getPr() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:48 PM
	 */
	@Test
	public void testGetPr_1()
		throws Exception {
		PrRequest fixture = new PrRequest(new RequestInfo(), EasyMock.createNiceMock(List.class));

		List<PublicRelationEvent> result = fixture.getPr();

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
		PrRequest fixture = new PrRequest(new RequestInfo(), EasyMock.createNiceMock(List.class));

		RequestInfo result = fixture.getRequestInfo();

		// add additional test code here
		assertNotNull(result);
		assertEquals("RequestInfo(apiId=null, ver=null, ts=null, action=null, did=null, key=null, msgId=null, authToken=null, correlationId=null, userInfo=null)", result.toString());
		assertEquals(null, result.getKey());
		assertEquals(null, result.getUserInfo());
		assertEquals(null, result.getAction());
		assertEquals(null, result.getTs());
		assertEquals(null, result.getAuthToken());
		assertEquals(null, result.getMsgId());
		assertEquals(null, result.getCorrelationId());
		assertEquals(null, result.getVer());
		assertEquals(null, result.getDid());
		assertEquals(null, result.getApiId());
	}

	/**
	 * Run the void setPr(List<PublicRelationEvent>) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:48 PM
	 */
	@Test
	public void testSetPr_1()
		throws Exception {
		PrRequest fixture = new PrRequest(new RequestInfo(), EasyMock.createNiceMock(List.class));
		List<PublicRelationEvent> pr = EasyMock.createMock(List.class);
		// add mock object expectations here

		EasyMock.replay(pr);

		fixture.setPr(pr);

		// add additional test code here
		EasyMock.verify(pr);
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
		PrRequest fixture = new PrRequest(new RequestInfo(), EasyMock.createNiceMock(List.class));
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
		new org.junit.runner.JUnitCore().run(PrRequestTest.class);
	}
}