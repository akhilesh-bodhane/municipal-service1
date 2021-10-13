package org.egov.pm.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.easymock.EasyMock;
import org.egov.common.contract.request.RequestInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import junit.framework.Assert;

@RunWith(MockitoJUnitRunner.class)
public class NOCDetailsRequestDataTest {

	@Test
	public void testNOCDetailsRequestData_1() throws Exception {

		NOCDetailsRequestData result = new NOCDetailsRequestData();

		assertNotNull(result);
		assertEquals(null, result.getRequestInfo());
		assertEquals(null, result.getNocApplicationDetails());
	}

	@Test
	public void testNOCDetailsRequestData_2() throws Exception {
		RequestInfo requestInfo = new RequestInfo();
		List<NOCApplicationDetail> nocApplicationDetails = EasyMock.createMock(List.class);

		EasyMock.replay(nocApplicationDetails);

		NOCDetailsRequestData result = new NOCDetailsRequestData(requestInfo, nocApplicationDetails);

		EasyMock.verify(nocApplicationDetails);
		assertNotNull(result);
	}

	@Test
	public void testBuilder_1() throws Exception {

		NOCDetailsRequestData.NOCDetailsRequestDataBuilder result = NOCDetailsRequestData.builder();

		assertNotNull(result);
		assertEquals("NOCDetailsRequestData.NOCDetailsRequestDataBuilder(requestInfo=null, nocApplicationDetails=null)",
				result.toString());
	}

	@Test
	public void testGetNocApplicationDetails_1() throws Exception {
		NOCDetailsRequestData fixture = new NOCDetailsRequestData(new RequestInfo(),
				EasyMock.createNiceMock(List.class));

		List<NOCApplicationDetail> result = fixture.getNocApplicationDetails();

		assertNotNull(result);
		assertEquals(0, result.size());
	}

	@Test
	public void testGetRequestInfo_1() throws Exception {
		NOCDetailsRequestData fixture = new NOCDetailsRequestData(new RequestInfo(),
				EasyMock.createNiceMock(List.class));

		RequestInfo result = fixture.getRequestInfo();

		assertNotNull(result);
		assertEquals(
				"RequestInfo(apiId=null, ver=null, ts=null, action=null, did=null, key=null, msgId=null, authToken=null, correlationId=null, userInfo=null)",
				result.toString());
		assertEquals(null, result.getKey());
		assertEquals(null, result.getUserInfo());
		assertEquals(null, result.getAction());
		assertEquals(null, result.getApiId());
		assertEquals(null, result.getDid());
		assertEquals(null, result.getMsgId());
		assertEquals(null, result.getVer());
		assertEquals(null, result.getAuthToken());
		assertEquals(null, result.getCorrelationId());
		assertEquals(null, result.getTs());
	}

	@Test
	public void testSetNocApplicationDetails_1() throws Exception {
		NOCDetailsRequestData fixture = new NOCDetailsRequestData(new RequestInfo(),
				EasyMock.createNiceMock(List.class));
		List<NOCApplicationDetail> nocApplicationDetails = EasyMock.createMock(List.class);

		EasyMock.replay(nocApplicationDetails);

		fixture.setNocApplicationDetails(nocApplicationDetails);

		EasyMock.verify(nocApplicationDetails);
	}

	@Test
	public void testSetRequestInfo_1() throws Exception {
		NOCDetailsRequestData fixture = new NOCDetailsRequestData(new RequestInfo(),
				EasyMock.createNiceMock(List.class));
		RequestInfo requestInfo = new RequestInfo();

		fixture.setRequestInfo(requestInfo);
	}

	@Test
	public void testNOCDetailsRequestData_5() throws Exception {
		NOCDetailsRequestData.NOCDetailsRequestDataBuilder builder = new NOCDetailsRequestData.NOCDetailsRequestDataBuilder();
		builder.requestInfo(RequestInfo.builder().action("Request").build());
		List<NOCApplicationDetail> nocApplicationDetails = new ArrayList<>();
		builder.nocApplicationDetails(nocApplicationDetails);
		builder.build();

		NOCDetailsRequestData.NOCDetailsRequestDataBuilder builder2 = new NOCDetailsRequestData.NOCDetailsRequestDataBuilder();
		builder2.requestInfo(RequestInfo.builder().action("Request").build());
		builder2.nocApplicationDetails(nocApplicationDetails);
		builder2.build();
		Assert.assertEquals(builder2.toString(), builder.toString());
	}
}