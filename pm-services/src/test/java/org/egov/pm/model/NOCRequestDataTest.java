package org.egov.pm.model;

import java.util.ArrayList;
import java.util.List;
import org.easymock.EasyMock;
import org.egov.common.contract.request.RequestInfo;
import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class NOCRequestDataTest {

	@Test
	public void testNOCRequestData_1() throws Exception {

		NOCRequestData result = new NOCRequestData();

		assertNotNull(result);
		assertEquals(null, result.getRequestInfo());
		assertEquals(null, result.getNocApplication());
	}

	@Test
	public void testNOCRequestData_2() throws Exception {
		RequestInfo requestInfo = new RequestInfo();
		List<NOCApplication> nocApplication = EasyMock.createMock(List.class);

		EasyMock.replay(nocApplication);

		NOCRequestData result = new NOCRequestData(requestInfo, nocApplication);

		EasyMock.verify(nocApplication);
		assertNotNull(result);
	}

	@Test
	public void testBuilder_1() throws Exception {

		NOCRequestData.NOCRequestDataBuilder result = NOCRequestData.builder();

		assertNotNull(result);
		assertEquals("NOCRequestData.NOCRequestDataBuilder(requestInfo=null, nocApplication=null)", result.toString());
	}

	@Test
	public void testGetNocApplication_1() throws Exception {
		NOCRequestData fixture = new NOCRequestData(new RequestInfo(), EasyMock.createNiceMock(List.class));

		List<NOCApplication> result = fixture.getNocApplication();

		assertNotNull(result);
		assertEquals(0, result.size());
	}

	@Test
	public void testGetRequestInfo_1() throws Exception {
		NOCRequestData fixture = new NOCRequestData(new RequestInfo(), EasyMock.createNiceMock(List.class));

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
	public void testSetNocApplication_1() throws Exception {
		NOCRequestData fixture = new NOCRequestData(new RequestInfo(), EasyMock.createNiceMock(List.class));
		List<NOCApplication> nocApplication = EasyMock.createMock(List.class);

		EasyMock.replay(nocApplication);

		fixture.setNocApplication(nocApplication);

		EasyMock.verify(nocApplication);
	}

	@Test
	public void testSetRequestInfo_1() throws Exception {
		NOCRequestData fixture = new NOCRequestData(new RequestInfo(), EasyMock.createNiceMock(List.class));
		RequestInfo requestInfo = new RequestInfo();

		fixture.setRequestInfo(requestInfo);

	}

	@Test
	public void testNOCRequestData_3() throws Exception {
		NOCRequestData.NOCRequestDataBuilder builder = new NOCRequestData.NOCRequestDataBuilder();
		List<NOCApplication> nocApplication = new ArrayList<NOCApplication>();
		builder.nocApplication(nocApplication);
		builder.requestInfo(RequestInfo.builder().action("Request").build());
		builder.build();

		NOCRequestData.NOCRequestDataBuilder builder2 = new NOCRequestData.NOCRequestDataBuilder();
		builder2.nocApplication(nocApplication);
		builder2.requestInfo(RequestInfo.builder().action("Request").build());
		builder2.build();

		Assert.assertEquals(builder.toString(), builder2.toString());
	}

}