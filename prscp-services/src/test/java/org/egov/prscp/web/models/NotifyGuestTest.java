package org.egov.prscp.web.models;

import org.junit.*;
import static org.junit.Assert.*;

public class NotifyGuestTest {

	@Test
	public void testNotifyGuest_1()
		throws Exception {

		NotifyGuest result = new NotifyGuest();

		assertNotNull(result);
		assertEquals(false, result.isActive());
		assertEquals(null, result.getEventId());
		assertEquals(null, result.getNotifyUuid());
		assertEquals(null, result.getGuestType());
		assertEquals(null, result.getGuestName());
		assertEquals(null, result.getUserUuid());
		assertEquals(null, result.getGuestMobile());
		assertEquals(null, result.getGuestEmail());
		assertEquals(false, result.isSentFlag());
		assertEquals(null, result.getEventDetailUuid());
		assertEquals(null, result.getDepartmentUuid());
		assertEquals(null, result.getNotificationTemplateUuid());
	}

	@Test
	public void testNotifyGuest_2()
		throws Exception {
		String notifyUuid = "";
		String eventId = "";
		String eventDetailUuid = "";
		String guestType = "";
		String departmentUuid = "";
		String userUuid = "";
		String guestName = "";
		String guestEmail = "";
		String guestMobile = "";
		String notificationTemplateUuid = "";
		boolean sentFlag = true;
		boolean isActive = true;

		NotifyGuest result = new NotifyGuest(notifyUuid, eventId, eventDetailUuid, guestType, departmentUuid, userUuid, guestName, guestEmail, guestMobile, notificationTemplateUuid, sentFlag, isActive);

		assertNotNull(result);
		assertEquals(true, result.isActive());
		assertEquals("", result.getEventId());
		assertEquals("", result.getNotifyUuid());
		assertEquals("", result.getGuestType());
		assertEquals("", result.getGuestName());
		assertEquals("", result.getUserUuid());
		assertEquals("", result.getGuestMobile());
		assertEquals("", result.getGuestEmail());
		assertEquals(true, result.isSentFlag());
		assertEquals("", result.getEventDetailUuid());
		assertEquals("", result.getDepartmentUuid());
		assertEquals("", result.getNotificationTemplateUuid());
	}

	
	@Test
	public void testBuilder_1()
		throws Exception {

		NotifyGuest.NotifyGuestBuilder result = NotifyGuest.builder();

		assertNotNull(result);
		assertEquals("NotifyGuest.NotifyGuestBuilder(notifyUuid=null, eventId=null, eventDetailUuid=null, guestType=null, departmentUuid=null, userUuid=null, guestName=null, guestEmail=null, guestMobile=null, notificationTemplateUuid=null, sentFlag=false, isActive=false)", result.toString());
	}


	@Test
	public void testGetDepartmentUuid_1()
		throws Exception {
		NotifyGuest fixture = new NotifyGuest("", "", "", "", "", "", "", "", "", "", true, true);

		String result = fixture.getDepartmentUuid();

		assertEquals("", result);
	}


	@Test
	public void testGetEventDetailUuid_1()
		throws Exception {
		NotifyGuest fixture = new NotifyGuest("", "", "", "", "", "", "", "", "", "", true, true);

		String result = fixture.getEventDetailUuid();

		assertEquals("", result);
	}

	@Test
	public void testGetEventId_1()
		throws Exception {
		NotifyGuest fixture = new NotifyGuest("", "", "", "", "", "", "", "", "", "", true, true);

		String result = fixture.getEventId();

		assertEquals("", result);
	}


	@Test
	public void testGetGuestEmail_1()
		throws Exception {
		NotifyGuest fixture = new NotifyGuest("", "", "", "", "", "", "", "", "", "", true, true);

		String result = fixture.getGuestEmail();

		assertEquals("", result);
	}


	@Test
	public void testGetGuestMobile_1()
		throws Exception {
		NotifyGuest fixture = new NotifyGuest("", "", "", "", "", "", "", "", "", "", true, true);

		String result = fixture.getGuestMobile();

		assertEquals("", result);
	}

	
	@Test
	public void testGetGuestName_1()
		throws Exception {
		NotifyGuest fixture = new NotifyGuest("", "", "", "", "", "", "", "", "", "", true, true);

		String result = fixture.getGuestName();

		assertEquals("", result);
	}

	@Test
	public void testGetGuestType_1()
		throws Exception {
		NotifyGuest fixture = new NotifyGuest("", "", "", "", "", "", "", "", "", "", true, true);

		String result = fixture.getGuestType();

		
		assertEquals("", result);
	}


	@Test
	public void testGetNotificationTemplateUuid_1()
		throws Exception {
		NotifyGuest fixture = new NotifyGuest("", "", "", "", "", "", "", "", "", "", true, true);

		String result = fixture.getNotificationTemplateUuid();

		assertEquals("", result);
	}

	
	@Test
	public void testGetNotifyUuid_1()
		throws Exception {
		NotifyGuest fixture = new NotifyGuest("", "", "", "", "", "", "", "", "", "", true, true);

		String result = fixture.getNotifyUuid();

		assertEquals("", result);
	}

	
	@Test
	public void testGetUserUuid_1()
		throws Exception {
		NotifyGuest fixture = new NotifyGuest("", "", "", "", "", "", "", "", "", "", true, true);

		String result = fixture.getUserUuid();

		assertEquals("", result);
	}

	
	@Test
	public void testIsActive_1()
		throws Exception {
		NotifyGuest fixture = new NotifyGuest("", "", "", "", "", "", "", "", "", "", true, true);

		boolean result = fixture.isActive();

		assertEquals(true, result);
	}

	
	@Test
	public void testIsActive_2()
		throws Exception {
		NotifyGuest fixture = new NotifyGuest("", "", "", "", "", "", "", "", "", "", true, false);

		boolean result = fixture.isActive();

		assertEquals(false, result);
	}

	
	@Test
	public void testIsSentFlag_1()
		throws Exception {
		NotifyGuest fixture = new NotifyGuest("", "", "", "", "", "", "", "", "", "", true, true);

		boolean result = fixture.isSentFlag();

		assertEquals(true, result);
	}

	
	@Test
	public void testIsSentFlag_2()
		throws Exception {
		NotifyGuest fixture = new NotifyGuest("", "", "", "", "", "", "", "", "", "", false, true);

		boolean result = fixture.isSentFlag();

		assertEquals(false, result);
	}

	
	@Test
	public void testSetActive_1()
		throws Exception {
		NotifyGuest fixture = new NotifyGuest("", "", "", "", "", "", "", "", "", "", true, true);
		boolean isActive = true;

		fixture.setActive(isActive);

	
	}

	@Test
	public void testSetDepartmentUuid_1()
		throws Exception {
		NotifyGuest fixture = new NotifyGuest("", "", "", "", "", "", "", "", "", "", true, true);
		String departmentUuid = "";

		fixture.setDepartmentUuid(departmentUuid);

	
	}

	
	@Test
	public void testSetEventDetailUuid_1()
		throws Exception {
		NotifyGuest fixture = new NotifyGuest("", "", "", "", "", "", "", "", "", "", true, true);
		String eventDetailUuid = "";

		fixture.setEventDetailUuid(eventDetailUuid);

		
	}

	
	@Test
	public void testSetEventId_1()
		throws Exception {
		NotifyGuest fixture = new NotifyGuest("", "", "", "", "", "", "", "", "", "", true, true);
		String eventId = "";

		fixture.setEventId(eventId);

	
	}


	@Test
	public void testSetGuestEmail_1()
		throws Exception {
		NotifyGuest fixture = new NotifyGuest("", "", "", "", "", "", "", "", "", "", true, true);
		String guestEmail = "";

		fixture.setGuestEmail(guestEmail);

	
	}

	
	@Test
	public void testSetGuestMobile_1()
		throws Exception {
		NotifyGuest fixture = new NotifyGuest("", "", "", "", "", "", "", "", "", "", true, true);
		String guestMobile = "";

		fixture.setGuestMobile(guestMobile);

	
	}

	
	@Test
	public void testSetGuestName_1()
		throws Exception {
		NotifyGuest fixture = new NotifyGuest("", "", "", "", "", "", "", "", "", "", true, true);
		String guestName = "";

		fixture.setGuestName(guestName);

	
	}

	
	@Test
	public void testSetGuestType_1()
		throws Exception {
		NotifyGuest fixture = new NotifyGuest("", "", "", "", "", "", "", "", "", "", true, true);
		String guestType = "";

		fixture.setGuestType(guestType);

	
	}

	@Test
	public void testSetNotificationTemplateUuid_1()
		throws Exception {
		NotifyGuest fixture = new NotifyGuest("", "", "", "", "", "", "", "", "", "", true, true);
		String notificationTemplateUuid = "";

		fixture.setNotificationTemplateUuid(notificationTemplateUuid);

	
	}


	@Test
	public void testSetNotifyUuid_1()
		throws Exception {
		NotifyGuest fixture = new NotifyGuest("", "", "", "", "", "", "", "", "", "", true, true);
		String notifyUuid = "";

		fixture.setNotifyUuid(notifyUuid);

	
	}

	
	@Test
	public void testSetSentFlag_1()
		throws Exception {
		NotifyGuest fixture = new NotifyGuest("", "", "", "", "", "", "", "", "", "", true, true);
		boolean sentFlag = true;

		fixture.setSentFlag(sentFlag);

	
	}

	
	@Test
	public void testSetUserUuid_1()
		throws Exception {
		NotifyGuest fixture = new NotifyGuest("", "", "", "", "", "", "", "", "", "", true, true);
		String userUuid = "";

		fixture.setUserUuid(userUuid);

	
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
		new org.junit.runner.JUnitCore().run(NotifyGuestTest.class);
	}
}