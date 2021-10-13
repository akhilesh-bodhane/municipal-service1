package org.egov.prscp.web.models;

import org.junit.*;
import static org.junit.Assert.*;

public class InviteGuestTest {
	
	@Test
	public void testInviteGuest_1()
		throws Exception {

		InviteGuest result = new InviteGuest();

		assertNotNull(result);
		assertEquals("InviteGuest(tenantId=null, moduleCode=null, eventGuestUuid=null, eventDetailUuid=null, externalFileStoreId=null, eventGuestType=null, departmentName=null, departmentUuid=null, notificationTemplateUuid=null, userUuid=null, guestName=null, guestEmail=null, guestMobile=null, sentFlag=false, isActive=false, createdBy=null, lastModifiedBy=null, createdTime=null, lastModifiedTime=null, sourceUuid=null)", result.toString());
		assertEquals(null, result.getLastModifiedTime());
		assertEquals(false, result.isActive());
		assertEquals(null, result.getCreatedTime());
		assertEquals(null, result.getTenantId());
		assertEquals(null, result.getModuleCode());
		assertEquals(null, result.getCreatedBy());
		assertEquals(null, result.getGuestName());
		assertEquals(null, result.getUserUuid());
		assertEquals(null, result.getGuestMobile());
		assertEquals(null, result.getSourceUuid());
		assertEquals(null, result.getGuestEmail());
		assertEquals(false, result.isSentFlag());
		assertEquals(null, result.getDepartmentName());
		assertEquals(null, result.getEventDetailUuid());
		assertEquals(null, result.getDepartmentUuid());
		assertEquals(null, result.getEventGuestUuid());
		assertEquals(null, result.getNotificationTemplateUuid());
		assertEquals(null, result.getEventGuestType());
		assertEquals(null, result.getExternalFileStoreId());
		assertEquals(null, result.getLastModifiedBy());
	}

	
	@Test
	public void testInviteGuest_2()
		throws Exception {
		String tenantId = "";
		String moduleCode = "";
		String eventGuestUuid = "";
		String eventDetailUuid = "";
		String externalFileStoreId = "";
		String eventGuestType = "";
		String departmentName = "";
		String departmentUuid = "";
		String notificationTemplateUuid = "";
		String userUuid = "";
		String guestName = "";
		String guestEmail = "";
		String guestMobile = "";
		boolean sentFlag = true;
		boolean isActive = true;
		String createdBy = "";
		String lastModifiedBy = "";
		Long createdTime = new Long(1L);
		Long lastModifiedTime = new Long(1L);
		String sourceUuid = "";

		InviteGuest result = new InviteGuest(tenantId, moduleCode, eventGuestUuid, eventDetailUuid, externalFileStoreId, eventGuestType, departmentName, departmentUuid, notificationTemplateUuid, userUuid, guestName, guestEmail, guestMobile, sentFlag, isActive, createdBy, lastModifiedBy, createdTime, lastModifiedTime, sourceUuid);

		assertNotNull(result);
		assertEquals("InviteGuest(tenantId=, moduleCode=, eventGuestUuid=, eventDetailUuid=, externalFileStoreId=, eventGuestType=, departmentName=, departmentUuid=, notificationTemplateUuid=, userUuid=, guestName=, guestEmail=, guestMobile=, sentFlag=true, isActive=true, createdBy=, lastModifiedBy=, createdTime=1, lastModifiedTime=1, sourceUuid=)", result.toString());
		assertEquals(new Long(1L), result.getLastModifiedTime());
		assertEquals(true, result.isActive());
		assertEquals(new Long(1L), result.getCreatedTime());
		assertEquals("", result.getTenantId());
		assertEquals("", result.getModuleCode());
		assertEquals("", result.getCreatedBy());
		assertEquals("", result.getGuestName());
		assertEquals("", result.getUserUuid());
		assertEquals("", result.getGuestMobile());
		assertEquals("", result.getSourceUuid());
		assertEquals("", result.getGuestEmail());
		assertEquals(true, result.isSentFlag());
		assertEquals("", result.getDepartmentName());
		assertEquals("", result.getEventDetailUuid());
		assertEquals("", result.getDepartmentUuid());
		assertEquals("", result.getEventGuestUuid());
		assertEquals("", result.getNotificationTemplateUuid());
		assertEquals("", result.getEventGuestType());
		assertEquals("", result.getExternalFileStoreId());
		assertEquals("", result.getLastModifiedBy());
	}


	@Test
	public void testBuilder_1()
		throws Exception {

		InviteGuest.InviteGuestBuilder result = InviteGuest.builder();

		assertNotNull(result);
		assertEquals("InviteGuest.InviteGuestBuilder(tenantId=null, moduleCode=null, eventGuestUuid=null, eventDetailUuid=null, externalFileStoreId=null, eventGuestType=null, departmentName=null, departmentUuid=null, notificationTemplateUuid=null, userUuid=null, guestName=null, guestEmail=null, guestMobile=null, sentFlag=false, isActive=false, createdBy=null, lastModifiedBy=null, createdTime=null, lastModifiedTime=null, sourceUuid=null)", result.toString());
	}


	@Test
	public void testGetCreatedBy_1()
		throws Exception {
		InviteGuest fixture = new InviteGuest("", "", "", "", "", "", "", "", "", "", "", "", "", true, true, "", "", new Long(1L), new Long(1L), "");

		String result = fixture.getCreatedBy();

		assertEquals("", result);
	}


	@Test
	public void testGetCreatedTime_1()
		throws Exception {
		InviteGuest fixture = new InviteGuest("", "", "", "", "", "", "", "", "", "", "", "", "", true, true, "", "", new Long(1L), new Long(1L), "");

		Long result = fixture.getCreatedTime();

		assertNotNull(result);
		assertEquals("1", result.toString());
		assertEquals((byte) 1, result.byteValue());
		assertEquals((short) 1, result.shortValue());
		assertEquals(1, result.intValue());
		assertEquals(1L, result.longValue());
		assertEquals(1.0f, result.floatValue(), 1.0f);
		assertEquals(1.0, result.doubleValue(), 1.0);
	}

	
	@Test
	public void testGetDepartmentName_1()
		throws Exception {
		InviteGuest fixture = new InviteGuest("", "", "", "", "", "", "", "", "", "", "", "", "", true, true, "", "", new Long(1L), new Long(1L), "");

		String result = fixture.getDepartmentName();

		assertEquals("", result);
	}

	
	@Test
	public void testGetDepartmentUuid_1()
		throws Exception {
		InviteGuest fixture = new InviteGuest("", "", "", "", "", "", "", "", "", "", "", "", "", true, true, "", "", new Long(1L), new Long(1L), "");

		String result = fixture.getDepartmentUuid();

		assertEquals("", result);
	}

	@Test
	public void testGetEventDetailUuid_1()
		throws Exception {
		InviteGuest fixture = new InviteGuest("", "", "", "", "", "", "", "", "", "", "", "", "", true, true, "", "", new Long(1L), new Long(1L), "");

		String result = fixture.getEventDetailUuid();

		assertEquals("", result);
	}

	
	@Test
	public void testGetEventGuestType_1()
		throws Exception {
		InviteGuest fixture = new InviteGuest("", "", "", "", "", "", "", "", "", "", "", "", "", true, true, "", "", new Long(1L), new Long(1L), "");

		String result = fixture.getEventGuestType();

		assertEquals("", result);
	}

	@Test
	public void testGetEventGuestUuid_1()
		throws Exception {
		InviteGuest fixture = new InviteGuest("", "", "", "", "", "", "", "", "", "", "", "", "", true, true, "", "", new Long(1L), new Long(1L), "");

		String result = fixture.getEventGuestUuid();

		assertEquals("", result);
	}


	@Test
	public void testGetExternalFileStoreId_1()
		throws Exception {
		InviteGuest fixture = new InviteGuest("", "", "", "", "", "", "", "", "", "", "", "", "", true, true, "", "", new Long(1L), new Long(1L), "");

		String result = fixture.getExternalFileStoreId();

		assertEquals("", result);
	}

	
	@Test
	public void testGetGuestEmail_1()
		throws Exception {
		InviteGuest fixture = new InviteGuest("", "", "", "", "", "", "", "", "", "", "", "", "", true, true, "", "", new Long(1L), new Long(1L), "");

		String result = fixture.getGuestEmail();

		assertEquals("", result);
	}


	@Test
	public void testGetGuestMobile_1()
		throws Exception {
		InviteGuest fixture = new InviteGuest("", "", "", "", "", "", "", "", "", "", "", "", "", true, true, "", "", new Long(1L), new Long(1L), "");

		String result = fixture.getGuestMobile();

		assertEquals("", result);
	}

	
	@Test
	public void testGetGuestName_1()
		throws Exception {
		InviteGuest fixture = new InviteGuest("", "", "", "", "", "", "", "", "", "", "", "", "", true, true, "", "", new Long(1L), new Long(1L), "");

		String result = fixture.getGuestName();

		assertEquals("", result);
	}

	
	@Test
	public void testGetLastModifiedBy_1()
		throws Exception {
		InviteGuest fixture = new InviteGuest("", "", "", "", "", "", "", "", "", "", "", "", "", true, true, "", "", new Long(1L), new Long(1L), "");

		String result = fixture.getLastModifiedBy();

		assertEquals("", result);
	}

	
	@Test
	public void testGetLastModifiedTime_1()
		throws Exception {
		InviteGuest fixture = new InviteGuest("", "", "", "", "", "", "", "", "", "", "", "", "", true, true, "", "", new Long(1L), new Long(1L), "");

		Long result = fixture.getLastModifiedTime();

		assertNotNull(result);
		assertEquals("1", result.toString());
		assertEquals((byte) 1, result.byteValue());
		assertEquals((short) 1, result.shortValue());
		assertEquals(1, result.intValue());
		assertEquals(1L, result.longValue());
		assertEquals(1.0f, result.floatValue(), 1.0f);
		assertEquals(1.0, result.doubleValue(), 1.0);
	}

	@Test
	public void testGetModuleCode_1()
		throws Exception {
		InviteGuest fixture = new InviteGuest("", "", "", "", "", "", "", "", "", "", "", "", "", true, true, "", "", new Long(1L), new Long(1L), "");

		String result = fixture.getModuleCode();

		assertEquals("", result);
	}

	
	@Test
	public void testGetNotificationTemplateUuid_1()
		throws Exception {
		InviteGuest fixture = new InviteGuest("", "", "", "", "", "", "", "", "", "", "", "", "", true, true, "", "", new Long(1L), new Long(1L), "");

		String result = fixture.getNotificationTemplateUuid();

		assertEquals("", result);
	}

	
	@Test
	public void testGetSourceUuid_1()
		throws Exception {
		InviteGuest fixture = new InviteGuest("", "", "", "", "", "", "", "", "", "", "", "", "", true, true, "", "", new Long(1L), new Long(1L), "");

		String result = fixture.getSourceUuid();

		assertEquals("", result);
	}

	
	@Test
	public void testGetTenantId_1()
		throws Exception {
		InviteGuest fixture = new InviteGuest("", "", "", "", "", "", "", "", "", "", "", "", "", true, true, "", "", new Long(1L), new Long(1L), "");

		String result = fixture.getTenantId();

		assertEquals("", result);
	}

	
	@Test
	public void testGetUserUuid_1()
		throws Exception {
		InviteGuest fixture = new InviteGuest("", "", "", "", "", "", "", "", "", "", "", "", "", true, true, "", "", new Long(1L), new Long(1L), "");

		String result = fixture.getUserUuid();

		assertEquals("", result);
	}

	
	@Test
	public void testIsActive_1()
		throws Exception {
		InviteGuest fixture = new InviteGuest("", "", "", "", "", "", "", "", "", "", "", "", "", true, true, "", "", new Long(1L), new Long(1L), "");

		boolean result = fixture.isActive();

		assertEquals(true, result);
	}

	
	@Test
	public void testIsActive_2()
		throws Exception {
		InviteGuest fixture = new InviteGuest("", "", "", "", "", "", "", "", "", "", "", "", "", true, false, "", "", new Long(1L), new Long(1L), "");

		boolean result = fixture.isActive();

		assertEquals(false, result);
	}

	@Test
	public void testIsSentFlag_1()
		throws Exception {
		InviteGuest fixture = new InviteGuest("", "", "", "", "", "", "", "", "", "", "", "", "", true, true, "", "", new Long(1L), new Long(1L), "");

		boolean result = fixture.isSentFlag();

		assertEquals(true, result);
	}

	
	@Test
	public void testIsSentFlag_2()
		throws Exception {
		InviteGuest fixture = new InviteGuest("", "", "", "", "", "", "", "", "", "", "", "", "", false, true, "", "", new Long(1L), new Long(1L), "");

		boolean result = fixture.isSentFlag();

		assertEquals(false, result);
	}

	
	@Test
	public void testSetActive_1()
		throws Exception {
		InviteGuest fixture = new InviteGuest("", "", "", "", "", "", "", "", "", "", "", "", "", true, true, "", "", new Long(1L), new Long(1L), "");
		boolean isActive = true;

		fixture.setActive(isActive);

	}

	
	@Test
	public void testSetCreatedBy_1()
		throws Exception {
		InviteGuest fixture = new InviteGuest("", "", "", "", "", "", "", "", "", "", "", "", "", true, true, "", "", new Long(1L), new Long(1L), "");
		String createdBy = "";

		fixture.setCreatedBy(createdBy);

	}

	
	@Test
	public void testSetCreatedTime_1()
		throws Exception {
		InviteGuest fixture = new InviteGuest("", "", "", "", "", "", "", "", "", "", "", "", "", true, true, "", "", new Long(1L), new Long(1L), "");
		Long createdTime = new Long(1L);

		fixture.setCreatedTime(createdTime);

	
	}

	
	@Test
	public void testSetDepartmentName_1()
		throws Exception {
		InviteGuest fixture = new InviteGuest("", "", "", "", "", "", "", "", "", "", "", "", "", true, true, "", "", new Long(1L), new Long(1L), "");
		String departmentName = "";

		fixture.setDepartmentName(departmentName);
		// add additional test code here
	}

	@Test
	public void testSetDepartmentUuid_1()
		throws Exception {
		InviteGuest fixture = new InviteGuest("", "", "", "", "", "", "", "", "", "", "", "", "", true, true, "", "", new Long(1L), new Long(1L), "");
		String departmentUuid = "";

		fixture.setDepartmentUuid(departmentUuid);

	}

	
	@Test
	public void testSetEventDetailUuid_1()
		throws Exception {
		InviteGuest fixture = new InviteGuest("", "", "", "", "", "", "", "", "", "", "", "", "", true, true, "", "", new Long(1L), new Long(1L), "");
		String eventDetailUuid = "";

		fixture.setEventDetailUuid(eventDetailUuid);

	}

	
	@Test
	public void testSetEventGuestType_1()
		throws Exception {
		InviteGuest fixture = new InviteGuest("", "", "", "", "", "", "", "", "", "", "", "", "", true, true, "", "", new Long(1L), new Long(1L), "");
		String eventGuestType = "";

		fixture.setEventGuestType(eventGuestType);

	}

	
	@Test
	public void testSetEventGuestUuid_1()
		throws Exception {
		InviteGuest fixture = new InviteGuest("", "", "", "", "", "", "", "", "", "", "", "", "", true, true, "", "", new Long(1L), new Long(1L), "");
		String eventGuestUuid = "";

		fixture.setEventGuestUuid(eventGuestUuid);

	}

	@Test
	public void testSetExternalFileStoreId_1()
		throws Exception {
		InviteGuest fixture = new InviteGuest("", "", "", "", "", "", "", "", "", "", "", "", "", true, true, "", "", new Long(1L), new Long(1L), "");
		String externalFileStoreId = "";

		fixture.setExternalFileStoreId(externalFileStoreId);

	}

	@Test
	public void testSetGuestEmail_1()
		throws Exception {
		InviteGuest fixture = new InviteGuest("", "", "", "", "", "", "", "", "", "", "", "", "", true, true, "", "", new Long(1L), new Long(1L), "");
		String guestEmail = "";

		fixture.setGuestEmail(guestEmail);

	}

	
	@Test
	public void testSetGuestMobile_1()
		throws Exception {
		InviteGuest fixture = new InviteGuest("", "", "", "", "", "", "", "", "", "", "", "", "", true, true, "", "", new Long(1L), new Long(1L), "");
		String guestMobile = "";

		fixture.setGuestMobile(guestMobile);

	}

	
	@Test
	public void testSetGuestName_1()
		throws Exception {
		InviteGuest fixture = new InviteGuest("", "", "", "", "", "", "", "", "", "", "", "", "", true, true, "", "", new Long(1L), new Long(1L), "");
		String guestName = "";

		fixture.setGuestName(guestName);

	}

	
	@Test
	public void testSetLastModifiedBy_1()
		throws Exception {
		InviteGuest fixture = new InviteGuest("", "", "", "", "", "", "", "", "", "", "", "", "", true, true, "", "", new Long(1L), new Long(1L), "");
		String lastModifiedBy = "";

		fixture.setLastModifiedBy(lastModifiedBy);

	}

	@Test
	public void testSetLastModifiedTime_1()
		throws Exception {
		InviteGuest fixture = new InviteGuest("", "", "", "", "", "", "", "", "", "", "", "", "", true, true, "", "", new Long(1L), new Long(1L), "");
		Long lastModifiedTime = new Long(1L);

		fixture.setLastModifiedTime(lastModifiedTime);

	}


	@Test
	public void testSetModuleCode_1()
		throws Exception {
		InviteGuest fixture = new InviteGuest("", "", "", "", "", "", "", "", "", "", "", "", "", true, true, "", "", new Long(1L), new Long(1L), "");
		String moduleCode = "";

		fixture.setModuleCode(moduleCode);

	
	}

	@Test
	public void testSetNotificationTemplateUuid_1()
		throws Exception {
		InviteGuest fixture = new InviteGuest("", "", "", "", "", "", "", "", "", "", "", "", "", true, true, "", "", new Long(1L), new Long(1L), "");
		String notificationTemplateUuid = "";

		fixture.setNotificationTemplateUuid(notificationTemplateUuid);

	}

	
	@Test
	public void testSetSentFlag_1()
		throws Exception {
		InviteGuest fixture = new InviteGuest("", "", "", "", "", "", "", "", "", "", "", "", "", true, true, "", "", new Long(1L), new Long(1L), "");
		boolean sentFlag = true;

		fixture.setSentFlag(sentFlag);

	}

	@Test
	public void testSetSourceUuid_1()
		throws Exception {
		InviteGuest fixture = new InviteGuest("", "", "", "", "", "", "", "", "", "", "", "", "", true, true, "", "", new Long(1L), new Long(1L), "");
		String sourceUuid = "";

		fixture.setSourceUuid(sourceUuid);

	}

	
	@Test
	public void testSetTenantId_1()
		throws Exception {
		InviteGuest fixture = new InviteGuest("", "", "", "", "", "", "", "", "", "", "", "", "", true, true, "", "", new Long(1L), new Long(1L), "");
		String tenantId = "";

		fixture.setTenantId(tenantId);

	}

	@Test
	public void testSetUserUuid_1()
		throws Exception {
		InviteGuest fixture = new InviteGuest("", "", "", "", "", "", "", "", "", "", "", "", "", true, true, "", "", new Long(1L), new Long(1L), "");
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
		// Add additional tear down code here
	}

	
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(InviteGuestTest.class);
	}
}