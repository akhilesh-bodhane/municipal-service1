package org.egov.prscp.web.models;

import java.util.List;
import org.easymock.EasyMock;
import org.egov.common.contract.response.ResponseInfo;
import org.junit.*;
import static org.junit.Assert.*;

public class NotifyGuestResponseTest {
	
	@Test
	public void testNotifyGuestResponse_1()
		throws Exception {

		NotifyGuestResponse result = new NotifyGuestResponse();

		assertNotNull(result);
		assertEquals(null, result.getResponseInfo());
		assertEquals(null, result.getNotifyGuest());
	}

	
	@Test
	public void testNotifyGuestResponse_2()
		throws Exception {
		ResponseInfo responseInfo = new ResponseInfo();
		List<NotifyGuest> notifyGuest = EasyMock.createMock(List.class);
	

		EasyMock.replay(notifyGuest);

		NotifyGuestResponse result = new NotifyGuestResponse(responseInfo, notifyGuest);

		EasyMock.verify(notifyGuest);
		assertNotNull(result);
	}

	@Test
	public void testBuilder_1()
		throws Exception {

		NotifyGuestResponse.NotifyGuestResponseBuilder result = NotifyGuestResponse.builder();

		assertNotNull(result);
		assertEquals("NotifyGuestResponse.NotifyGuestResponseBuilder(responseInfo=null, notifyGuest=null)", result.toString());
	}

	
	@Test
	public void testGetNotifyGuest_1()
		throws Exception {
		NotifyGuestResponse fixture = new NotifyGuestResponse(new ResponseInfo(), EasyMock.createNiceMock(List.class));

		List<NotifyGuest> result = fixture.getNotifyGuest();

	
		assertNotNull(result);
		assertEquals(0, result.size());
	}

	
	@Test
	public void testGetResponseInfo_1()
		throws Exception {
		NotifyGuestResponse fixture = new NotifyGuestResponse(new ResponseInfo(), EasyMock.createNiceMock(List.class));

		ResponseInfo result = fixture.getResponseInfo();

		
		assertNotNull(result);
		assertEquals("ResponseInfo(apiId=null, ver=null, ts=null, resMsgId=null, msgId=null, status=null)", result.toString());
		assertEquals(null, result.getStatus());
		assertEquals(null, result.getMsgId());
		assertEquals(null, result.getTs());
		assertEquals(null, result.getApiId());
		assertEquals(null, result.getResMsgId());
		assertEquals(null, result.getVer());
	}

	
	@Test
	public void testSetNotifyGuest_1()
		throws Exception {
		NotifyGuestResponse fixture = new NotifyGuestResponse(new ResponseInfo(), EasyMock.createNiceMock(List.class));
		List<NotifyGuest> notifyGuest = EasyMock.createMock(List.class);
		
		EasyMock.replay(notifyGuest);

		fixture.setNotifyGuest(notifyGuest);

		
		EasyMock.verify(notifyGuest);
	}

	
	@Test
	public void testSetResponseInfo_1()
		throws Exception {
		NotifyGuestResponse fixture = new NotifyGuestResponse(new ResponseInfo(), EasyMock.createNiceMock(List.class));
		ResponseInfo responseInfo = new ResponseInfo();

		fixture.setResponseInfo(responseInfo);

	}


	@Before
	public void setUp()
		throws Exception {
	}

	
	@After
	public void tearDown()
		throws Exception {
	}

	
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(NotifyGuestResponseTest.class);
	}
}