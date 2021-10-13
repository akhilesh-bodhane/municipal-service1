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
public class NOCRemarksRequestDataTest {

	@Test
	public void testNOCRemarksRequestData_1() throws Exception {

		NOCRemarksRequestData result = new NOCRemarksRequestData();

		assertNotNull(result);
		assertEquals(null, result.getRequestInfo());
		assertEquals(null, result.getNocApplicationRamarks());
	}

	@Test
	public void testNOCRemarksRequestData_2() throws Exception {
		RequestInfo requestInfo = new RequestInfo();
		List<NOCApplicationRemark> nocApplicationRamarks = EasyMock.createMock(List.class);

		EasyMock.replay(nocApplicationRamarks);

		NOCRemarksRequestData result = new NOCRemarksRequestData(requestInfo, nocApplicationRamarks);

		EasyMock.verify(nocApplicationRamarks);
		assertNotNull(result);
	}

	@Test
	public void testBuilder_1() throws Exception {

		NOCRemarksRequestData.NOCRemarksRequestDataBuilder result = NOCRemarksRequestData.builder();

		assertNotNull(result);
		assertEquals("NOCRemarksRequestData.NOCRemarksRequestDataBuilder(requestInfo=null, nocApplicationRamarks=null)",
				result.toString());
	}

	@Test
	public void testGetNocApplicationRamarks_1() throws Exception {
		NOCRemarksRequestData fixture = new NOCRemarksRequestData(new RequestInfo(),
				EasyMock.createNiceMock(List.class));

		List<NOCApplicationRemark> result = fixture.getNocApplicationRamarks();

		assertNotNull(result);
		assertEquals(0, result.size());
	}

	@Test
	public void testGetRequestInfo_1() throws Exception {
		NOCRemarksRequestData fixture = new NOCRemarksRequestData(new RequestInfo(),
				EasyMock.createNiceMock(List.class));

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
	public void testSetNocApplicationRamarks_1() throws Exception {
		NOCRemarksRequestData fixture = new NOCRemarksRequestData(new RequestInfo(),
				EasyMock.createNiceMock(List.class));
		List<NOCApplicationRemark> nocApplicationRamarks = EasyMock.createMock(List.class);

		EasyMock.replay(nocApplicationRamarks);

		fixture.setNocApplicationRamarks(nocApplicationRamarks);

		EasyMock.verify(nocApplicationRamarks);
	}

	@Test
	public void testSetRequestInfo_1() throws Exception {
		NOCRemarksRequestData fixture = new NOCRemarksRequestData(new RequestInfo(),
				EasyMock.createNiceMock(List.class));
		RequestInfo requestInfo = new RequestInfo();

		fixture.setRequestInfo(requestInfo);

	}

	@Test
	public void testSetRequestInfoNocRemarksBuilder_1() throws Exception {
		NOCRemarksRequestData.NOCRemarksRequestDataBuilder builder = new NOCRemarksRequestData.NOCRemarksRequestDataBuilder();
		List<NOCApplicationRemark> nocApplicationRamarks = new ArrayList<NOCApplicationRemark>();
		builder.nocApplicationRamarks(nocApplicationRamarks);
		builder.requestInfo(RequestInfo.builder().action("request").build());
		builder.build();

		NOCRemarksRequestData.NOCRemarksRequestDataBuilder builder2 = new NOCRemarksRequestData.NOCRemarksRequestDataBuilder();
		builder2.nocApplicationRamarks(nocApplicationRamarks);
		builder2.requestInfo(RequestInfo.builder().action("request").build());
		builder2.build();
		Assert.assertEquals(builder2.toString(), builder.toString());
	}

}