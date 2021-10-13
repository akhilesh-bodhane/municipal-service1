package org.egov.ec.web.models;

import org.egov.common.contract.response.ResponseInfo;
import org.egov.ec.web.models.ResponseInfoWrapper;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * The class <code>ResponseInfoWrapperTest</code> contains tests for the class <code>{@link ResponseInfoWrapper}</code>.
 *
 * @generated at 17/5/20 2:10 PM
 * @version $Revision: 1.0 $
 */
public class ResponseInfoWrapperTest {
	/**
	 * Run the ResponseInfoWrapper() constructor test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:10 PM
	 */
	@Test
	public void testResponseInfoWrapper_1()
		throws Exception {

		ResponseInfoWrapper result = new ResponseInfoWrapper();

		
		assertNotNull(result);
		assertEquals(null, result.getResponseBody());
		assertEquals(null, result.getResponseInfo());
	}

	/**
	 * Run the ResponseInfoWrapper(ResponseInfo,Object) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:10 PM
	 */
	@Test
	public void testResponseInfoWrapper_2()
		throws Exception {
		ResponseInfo responseInfo = new ResponseInfo();
		Object responseBody = new Object();

		ResponseInfoWrapper result = new ResponseInfoWrapper(responseInfo, responseBody);

		
		assertNotNull(result);
	}

	/**
	 * Run the ResponseInfoWrapper.ResponseInfoWrapperBuilder builder() method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:10 PM
	 */
	@Test
	public void testBuilder_1()
		throws Exception {

		ResponseInfoWrapper.ResponseInfoWrapperBuilder result = ResponseInfoWrapper.builder();

		
		assertNotNull(result);
		assertEquals("ResponseInfoWrapper.ResponseInfoWrapperBuilder(responseInfo=null, responseBody=null)", result.toString());
	}

	@Test
	public void testBuilder_2()
		throws Exception {

		ResponseInfoWrapper.ResponseInfoWrapperBuilder builder = ResponseInfoWrapper.builder();
		builder.responseInfo(null);
		builder.responseBody(null);
		builder.build();
		
		ResponseInfoWrapper.ResponseInfoWrapperBuilder builder2 = ResponseInfoWrapper.builder();
		builder2.responseInfo(null);
		builder2.responseBody(null);
		builder2.build();
		
		Assert.assertEquals(builder2.toString(), builder.toString());
	}
	/**
	 * Run the Object getResponseBody() method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:10 PM
	 */
	@Test
	public void testGetResponseBody_1()
		throws Exception {
		ResponseInfoWrapper fixture = new ResponseInfoWrapper(new ResponseInfo(), new Object());

		Object result = fixture.getResponseBody();

		
		assertNotNull(result);
	}

	/**
	 * Run the ResponseInfo getResponseInfo() method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:10 PM
	 */
	@Test
	public void testGetResponseInfo_1()
		throws Exception {
		ResponseInfoWrapper fixture = new ResponseInfoWrapper(new ResponseInfo(), new Object());

		ResponseInfo result = fixture.getResponseInfo();

		
		assertNotNull(result);
		assertEquals("ResponseInfo(apiId=null, ver=null, ts=null, resMsgId=null, msgId=null, status=null)", result.toString());
		assertEquals(null, result.getStatus());
		assertEquals(null, result.getVer());
		assertEquals(null, result.getApiId());
		assertEquals(null, result.getTs());
		assertEquals(null, result.getMsgId());
		assertEquals(null, result.getResMsgId());
	}

	/**
	 * Run the void setResponseBody(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:10 PM
	 */
	@Test
	public void testSetResponseBody_1()
		throws Exception {
		ResponseInfoWrapper fixture = new ResponseInfoWrapper(new ResponseInfo(), new Object());
		Object responseBody = new Object();

		fixture.setResponseBody(responseBody);

		
	}

	/**
	 * Run the void setResponseInfo(ResponseInfo) method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:10 PM
	 */
	@Test
	public void testSetResponseInfo_1()
		throws Exception {
		ResponseInfoWrapper fixture = new ResponseInfoWrapper(new ResponseInfo(), new Object());
		ResponseInfo responseInfo = new ResponseInfo();

		fixture.setResponseInfo(responseInfo);

		
	}
}