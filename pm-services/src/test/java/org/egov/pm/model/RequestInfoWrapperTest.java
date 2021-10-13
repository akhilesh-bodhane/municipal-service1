package org.egov.pm.model;

import org.egov.common.contract.request.RequestInfo;
import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class RequestInfoWrapperTest {

	@Test
	public void testRequestInfoWrapper_1() throws Exception {

		RequestInfoWrapper result = new RequestInfoWrapper();

		assertNotNull(result);
		assertEquals("RequestInfoWrapper(requestInfo=null)", result.toString());
		assertEquals(null, result.getRequestInfo());
	}

	@Test
	public void testRequestInfoWrapper_2() throws Exception {
		RequestInfo requestInfo = new RequestInfo();

		RequestInfoWrapper result = new RequestInfoWrapper(requestInfo);

		assertNotNull(result);
		assertEquals(
				"RequestInfoWrapper(requestInfo=RequestInfo(apiId=null, ver=null, ts=null, action=null, did=null, key=null, msgId=null, authToken=null, correlationId=null, userInfo=null))",
				result.toString());
	}

	@Test
	public void testBuilder_1() throws Exception {

		RequestInfoWrapper.RequestInfoWrapperBuilder result = RequestInfoWrapper.builder();

		assertNotNull(result);
		assertEquals("RequestInfoWrapper.RequestInfoWrapperBuilder(requestInfo=null)", result.toString());
	}

	@Test
	public void testCanEqual_1() throws Exception {
		RequestInfoWrapper fixture = new RequestInfoWrapper(new RequestInfo());
		Object other = new Object();

		boolean result = fixture.canEqual(other);

		assertEquals(false, result);
	}

	@Test
	public void testCanEqual_2() throws Exception {
		RequestInfoWrapper fixture = new RequestInfoWrapper(new RequestInfo());
		Object other = new Object();

		boolean result = fixture.canEqual(other);

		assertEquals(false, result);
	}

	@Test
	public void testEquals_1() throws Exception {
		RequestInfoWrapper fixture = new RequestInfoWrapper(new RequestInfo());
		// Object o = new RequestInfoWrapper(new RequestInfo());

		boolean result = fixture.equals(fixture);

		assertEquals(true, result);
	}

	@Test
	public void testEquals_2() throws Exception {
		RequestInfoWrapper fixture = new RequestInfoWrapper(new RequestInfo());
		Object o = new Object();

		boolean result = fixture.equals(o);

		assertEquals(false, result);
	}

	@Test
	public void testEquals_3() throws Exception {
		RequestInfoWrapper fixture = new RequestInfoWrapper(new RequestInfo());
		Object o = new RequestInfoWrapper(new RequestInfo());

		boolean result = fixture.equals(o);

		assertEquals(true, result);
	}

	@Test
	public void testEquals_4() throws Exception {
		RequestInfoWrapper fixture = new RequestInfoWrapper(new RequestInfo());
		Object o = new RequestInfoWrapper(new RequestInfo());

		boolean result = fixture.equals(o);

		assertEquals(true, result);
	}

	@Test
	public void testEquals_5() throws Exception {
		RequestInfoWrapper fixture = new RequestInfoWrapper((RequestInfo) null);
		Object o = new RequestInfoWrapper((RequestInfo) null);

		boolean result = fixture.equals(o);

		assertEquals(true, result);
	}

	@Test
	public void testEquals_6() throws Exception {
		RequestInfoWrapper fixture = new RequestInfoWrapper(new RequestInfo());
		Object o = new RequestInfoWrapper(new RequestInfo());

		boolean result = fixture.equals(o);

		assertEquals(true, result);
	}

	@Test
	public void testGetRequestInfo_1() throws Exception {
		RequestInfoWrapper fixture = new RequestInfoWrapper(new RequestInfo());

		RequestInfo result = fixture.getRequestInfo();

		assertNotNull(result);
		assertEquals(
				"RequestInfo(apiId=null, ver=null, ts=null, action=null, did=null, key=null, msgId=null, authToken=null, correlationId=null, userInfo=null)",
				result.toString());
		assertEquals(null, result.getKey());
		assertEquals(null, result.getUserInfo());
		assertEquals(null, result.getAction());
		assertEquals(null, result.getAuthToken());
		assertEquals(null, result.getMsgId());
		assertEquals(null, result.getCorrelationId());
		assertEquals(null, result.getDid());
		assertEquals(null, result.getVer());
		assertEquals(null, result.getTs());
		assertEquals(null, result.getApiId());
	}

	@Test
	public void testHashCode_1() throws Exception {
		RequestInfoWrapper fixture = new RequestInfoWrapper(new RequestInfo());

		int result = fixture.hashCode();

		assertEquals(739008984, result);
	}

	@Test
	public void testHashCode_2() throws Exception {
		RequestInfoWrapper fixture = new RequestInfoWrapper((RequestInfo) null);

		int result = fixture.hashCode();

		assertEquals(102, result);
	}

	@Test
	public void testSetRequestInfo_1() throws Exception {
		RequestInfoWrapper fixture = new RequestInfoWrapper(new RequestInfo());
		RequestInfo requestInfo = new RequestInfo();

		fixture.setRequestInfo(requestInfo);

	}

	@Test
	public void testRequestInfoWrapper_3() throws Exception {
		RequestInfoWrapper.RequestInfoWrapperBuilder builder = new RequestInfoWrapper.RequestInfoWrapperBuilder();
		builder.requestInfo(RequestInfo.builder().action("Request").build());
		builder.build();

		RequestInfoWrapper.RequestInfoWrapperBuilder builder2 = new RequestInfoWrapper.RequestInfoWrapperBuilder();
		builder2.requestInfo(RequestInfo.builder().action("Request").build());
		builder2.build();
		Assert.assertEquals(builder.toString(), builder2.toString());

		RequestInfoWrapper infoWrapper = RequestInfoWrapper.builder().build();
		boolean ret = infoWrapper.equals(infoWrapper);
		Assert.assertEquals(true, ret);

	}
}