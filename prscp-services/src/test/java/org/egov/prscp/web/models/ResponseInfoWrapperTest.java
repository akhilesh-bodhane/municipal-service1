package org.egov.prscp.web.models;

import org.egov.common.contract.response.ResponseInfo;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * The class <code>ResponseInfoWrapperTest</code> contains tests for the class <code>{@link ResponseInfoWrapper}</code>.
 *
 * @generatedBy CodePro at 25/5/20 3:50 PM
 * @author Aniket.Marathe
 * @version $Revision: 1.0 $
 */
public class ResponseInfoWrapperTest {
	/**
	 * Run the ResponseInfoWrapper() constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:50 PM
	 */
	@Test
	public void testResponseInfoWrapper_1()
		throws Exception {

		ResponseInfoWrapper result = new ResponseInfoWrapper();

		// add additional test code here
		assertNotNull(result);
		assertEquals(null, result.getResponseBody());
		assertEquals(null, result.getResponseInfo());
	}

	/**
	 * Run the ResponseInfoWrapper(ResponseInfo,Object) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:50 PM
	 */
	@Test
	public void testResponseInfoWrapper_2()
		throws Exception {
		ResponseInfo responseInfo = new ResponseInfo();
		Object responseBody = new Object();

		ResponseInfoWrapper result = new ResponseInfoWrapper(responseInfo, responseBody);

		// add additional test code here
		assertNotNull(result);
	//	assertEquals(new Object(), result.getResponseBody());
	}

	/**
	 * Run the ResponseInfoWrapper.ResponseInfoWrapperBuilder builder() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:50 PM
	 */
	@Test
	public void testBuilder_1()
		throws Exception {

		ResponseInfoWrapper.ResponseInfoWrapperBuilder result = ResponseInfoWrapper.builder();

		// add additional test code here
		assertNotNull(result);
		assertEquals("ResponseInfoWrapper.ResponseInfoWrapperBuilder(responseInfo=null, responseBody=null)", result.toString());
	}

	/**
	 * Run the Object getResponseBody() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:50 PM
	 */
	@Test
	public void testGetResponseBody_1()
		throws Exception {
		ResponseInfoWrapper fixture = new ResponseInfoWrapper(new ResponseInfo(), new Object());

		Object result = fixture.getResponseBody();

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the ResponseInfo getResponseInfo() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:50 PM
	 */
	@Test
	public void testGetResponseInfo_1()
		throws Exception {
		ResponseInfoWrapper fixture = new ResponseInfoWrapper(new ResponseInfo(), new Object());

		ResponseInfo result = fixture.getResponseInfo();

		// add additional test code here
		assertNotNull(result);
		assertEquals("ResponseInfo(apiId=null, ver=null, ts=null, resMsgId=null, msgId=null, status=null)", result.toString());
		assertEquals(null, result.getStatus());
		assertEquals(null, result.getApiId());
		assertEquals(null, result.getVer());
		assertEquals(null, result.getTs());
		assertEquals(null, result.getMsgId());
		assertEquals(null, result.getResMsgId());
	}

	/**
	 * Run the void setResponseBody(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:50 PM
	 */
	@Test
	public void testSetResponseBody_1()
		throws Exception {
		ResponseInfoWrapper fixture = new ResponseInfoWrapper(new ResponseInfo(), new Object());
		Object responseBody = new Object();

		fixture.setResponseBody(responseBody);

		// add additional test code here
	}

	/**
	 * Run the void setResponseInfo(ResponseInfo) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:50 PM
	 */
	@Test
	public void testSetResponseInfo_1()
		throws Exception {
		ResponseInfoWrapper fixture = new ResponseInfoWrapper(new ResponseInfo(), new Object());
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
		new org.junit.runner.JUnitCore().run(ResponseInfoWrapperTest.class);
	}
}