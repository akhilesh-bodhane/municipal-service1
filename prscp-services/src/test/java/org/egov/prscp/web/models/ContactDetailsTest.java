package org.egov.prscp.web.models;

import org.junit.*;
import static org.junit.Assert.*;

public class ContactDetailsTest {

	@Test
	public void testContactDetails_1()
		throws Exception {

		ContactDetails result = new ContactDetails();

		assertNotNull(result);
		assertEquals(null, result.getReceiverName());
		assertEquals(null, result.getModuleName());
		assertEquals(null, result.getResentBy());
		assertEquals(null, result.getReceiverUuid());
		assertEquals(null, result.getReceiverEmail());
		assertEquals(0L, result.getResentTime());
		assertEquals(null, result.getReceiverMobile());
		assertEquals(null, result.getNotificationMappedUuid());
		assertEquals(null, result.getNotificationResendUuid());
		assertEquals(null, result.getModuleCode());
		assertEquals(null, result.getTenantId());
	}

	
	@Test
	public void testContactDetails_2()
		throws Exception {
		String notificationResendUuid = "";
		String moduleCode = "";
		String notificationMappedUuid = "";
		String moduleName = "";
		String receiverUuid = "";
		String receiverName = "";
		String receiverEmail = "";
		String receiverMobile = "";
		String tenantId = "";
		String resentBy = "";
		long resentTime = 1L;

		ContactDetails result = new ContactDetails(notificationResendUuid, moduleCode, notificationMappedUuid, moduleName, receiverUuid, receiverName, receiverEmail, receiverMobile, tenantId, resentBy, resentTime);

	
		assertNotNull(result);
		assertEquals("", result.getReceiverName());
		assertEquals("", result.getModuleName());
		assertEquals("", result.getResentBy());
		assertEquals("", result.getReceiverUuid());
		assertEquals("", result.getReceiverEmail());
		assertEquals(1L, result.getResentTime());
		assertEquals("", result.getReceiverMobile());
		assertEquals("", result.getNotificationMappedUuid());
		assertEquals("", result.getNotificationResendUuid());
		assertEquals("", result.getModuleCode());
		assertEquals("", result.getTenantId());
	}

	
	@Test
	public void testBuilder_1()
		throws Exception {

		ContactDetails.ContactDetailsBuilder result = ContactDetails.builder();

		
		assertNotNull(result);
		assertEquals("ContactDetails.ContactDetailsBuilder(notificationResendUuid=null, moduleCode=null, notificationMappedUuid=null, moduleName=null, receiverUuid=null, receiverName=null, receiverEmail=null, receiverMobile=null, tenantId=null, resentBy=null, resentTime=0)", result.toString());
	}

	
	@Test
	public void testGetModuleCode_1()
		throws Exception {
		ContactDetails fixture = new ContactDetails("", "", "", "", "", "", "", "", "", "", 1L);

		String result = fixture.getModuleCode();

	
		assertEquals("", result);
	}

	
	@Test
	public void testGetModuleName_1()
		throws Exception {
		ContactDetails fixture = new ContactDetails("", "", "", "", "", "", "", "", "", "", 1L);

		String result = fixture.getModuleName();

		assertEquals("", result);
	}

	@Test
	public void testGetNotificationMappedUuid_1()
		throws Exception {
		ContactDetails fixture = new ContactDetails("", "", "", "", "", "", "", "", "", "", 1L);

		String result = fixture.getNotificationMappedUuid();

		
		assertEquals("", result);
	}

	
	@Test
	public void testGetNotificationResendUuid_1()
		throws Exception {
		ContactDetails fixture = new ContactDetails("", "", "", "", "", "", "", "", "", "", 1L);

		String result = fixture.getNotificationResendUuid();

		assertEquals("", result);
	}

	
	@Test
	public void testGetReceiverEmail_1()
		throws Exception {
		ContactDetails fixture = new ContactDetails("", "", "", "", "", "", "", "", "", "", 1L);

		String result = fixture.getReceiverEmail();

		assertEquals("", result);
	}

	@Test
	public void testGetReceiverMobile_1()
		throws Exception {
		ContactDetails fixture = new ContactDetails("", "", "", "", "", "", "", "", "", "", 1L);

		String result = fixture.getReceiverMobile();

		assertEquals("", result);
	}

	@Test
	public void testGetReceiverName_1()
		throws Exception {
		ContactDetails fixture = new ContactDetails("", "", "", "", "", "", "", "", "", "", 1L);

		String result = fixture.getReceiverName();

		assertEquals("", result);
	}

	
	@Test
	public void testGetReceiverUuid_1()
		throws Exception {
		ContactDetails fixture = new ContactDetails("", "", "", "", "", "", "", "", "", "", 1L);

		String result = fixture.getReceiverUuid();

		assertEquals("", result);
	}

	
	@Test
	public void testGetResentBy_1()
		throws Exception {
		ContactDetails fixture = new ContactDetails("", "", "", "", "", "", "", "", "", "", 1L);

		String result = fixture.getResentBy();

		assertEquals("", result);
	}

	@Test
	public void testGetResentTime_1()
		throws Exception {
		ContactDetails fixture = new ContactDetails("", "", "", "", "", "", "", "", "", "", 1L);

		long result = fixture.getResentTime();

	
		assertEquals(1L, result);
	}


	@Test
	public void testGetTenantId_1()
		throws Exception {
		ContactDetails fixture = new ContactDetails("", "", "", "", "", "", "", "", "", "", 1L);

		String result = fixture.getTenantId();

		assertEquals("", result);
	}

	
	@Test
	public void testSetModuleCode_1()
		throws Exception {
		ContactDetails fixture = new ContactDetails("", "", "", "", "", "", "", "", "", "", 1L);
		String moduleCode = "";

		fixture.setModuleCode(moduleCode);

	}

	@Test
	public void testSetModuleName_1()
		throws Exception {
		ContactDetails fixture = new ContactDetails("", "", "", "", "", "", "", "", "", "", 1L);
		String moduleName = "";

		fixture.setModuleName(moduleName);

	}

	
	@Test
	public void testSetNotificationMappedUuid_1()
		throws Exception {
		ContactDetails fixture = new ContactDetails("", "", "", "", "", "", "", "", "", "", 1L);
		String notificationMappedUuid = "";

		fixture.setNotificationMappedUuid(notificationMappedUuid);

	}

	
	@Test
	public void testSetNotificationResendUuid_1()
		throws Exception {
		ContactDetails fixture = new ContactDetails("", "", "", "", "", "", "", "", "", "", 1L);
		String notificationResendUuid = "";

		fixture.setNotificationResendUuid(notificationResendUuid);

	}

	
	@Test
	public void testSetReceiverEmail_1()
		throws Exception {
		ContactDetails fixture = new ContactDetails("", "", "", "", "", "", "", "", "", "", 1L);
		String receiverEmail = "";

		fixture.setReceiverEmail(receiverEmail);

	}

	
	@Test
	public void testSetReceiverMobile_1()
		throws Exception {
		ContactDetails fixture = new ContactDetails("", "", "", "", "", "", "", "", "", "", 1L);
		String receiverMobile = "";

		fixture.setReceiverMobile(receiverMobile);

	}

	
	@Test
	public void testSetReceiverName_1()
		throws Exception {
		ContactDetails fixture = new ContactDetails("", "", "", "", "", "", "", "", "", "", 1L);
		String receiverName = "";

		fixture.setReceiverName(receiverName);
		
	}

	
	@Test
	public void testSetReceiverUuid_1()
		throws Exception {
		ContactDetails fixture = new ContactDetails("", "", "", "", "", "", "", "", "", "", 1L);
		String receiverUuid = "";

		fixture.setReceiverUuid(receiverUuid);

	}

	
	@Test
	public void testSetResentBy_1()
		throws Exception {
		ContactDetails fixture = new ContactDetails("", "", "", "", "", "", "", "", "", "", 1L);
		String resentBy = "";

		fixture.setResentBy(resentBy);

	}

	@Test
	public void testSetResentTime_1()
		throws Exception {
		ContactDetails fixture = new ContactDetails("", "", "", "", "", "", "", "", "", "", 1L);
		long resentTime = 1L;

		fixture.setResentTime(resentTime);

	}

	
	@Test
	public void testSetTenantId_1()
		throws Exception {
		ContactDetails fixture = new ContactDetails("", "", "", "", "", "", "", "", "", "", 1L);
		String tenantId = "";

		fixture.setTenantId(tenantId);

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
		new org.junit.runner.JUnitCore().run(ContactDetailsTest.class);
	}
}