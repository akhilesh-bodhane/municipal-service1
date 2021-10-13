package org.egov.prscp.web.models;

import org.junit.*;
import static org.junit.Assert.*;

public class NotificationTemplateTest {

	@Test
	public void testNotificationTemplate_1()
		throws Exception {

		NotificationTemplate result = new NotificationTemplate();

		assertNotNull(result);
		assertEquals(null, result.getLastModifiedTime());
		assertEquals(null, result.getTemplateType());
		assertEquals(null, result.getEmailContent());
		assertEquals(null, result.getSmsContent());
		assertEquals(null, result.getSetdoc());
		assertEquals(null, result.getLastModifiedBy());
		assertEquals(null, result.getCreatedBy());
		assertEquals(null, result.getTenantId());
		assertEquals(null, result.getModuleCode());
		assertEquals(null, result.getCreatedTime());
		assertEquals(null, result.getNotificationTemplateUuid());
		assertEquals(null, result.getEventDetailUuid());
		assertEquals(null, result.getTemplateMappedUuid());
	}


	@Test
	public void testNotificationTemplate_2()
		throws Exception {
		String tenantId = "";
		String moduleCode = "";
		String notificationTemplateUuid = "";
		String eventDetailUuid = "";
		String emailContent = "";
		String smsContent = "";
		String templateType = "";
		String templateMappedUuid = "";
		String setdoc = "";
		String createdBy = "";
		String lastModifiedBy = "";
		Long createdTime = new Long(1L);
		Long lastModifiedTime = new Long(1L);

		NotificationTemplate result = new NotificationTemplate(tenantId, moduleCode, notificationTemplateUuid, eventDetailUuid, emailContent, smsContent, templateType, templateMappedUuid, setdoc, createdBy, lastModifiedBy, createdTime, lastModifiedTime);

		assertNotNull(result);
		assertEquals(new Long(1L), result.getLastModifiedTime());
		assertEquals("", result.getTemplateType());
		assertEquals("", result.getEmailContent());
		assertEquals("", result.getSmsContent());
		assertEquals("", result.getSetdoc());
		assertEquals("", result.getLastModifiedBy());
		assertEquals("", result.getCreatedBy());
		assertEquals("", result.getTenantId());
		assertEquals("", result.getModuleCode());
		assertEquals(new Long(1L), result.getCreatedTime());
		assertEquals("", result.getNotificationTemplateUuid());
		assertEquals("", result.getEventDetailUuid());
		assertEquals("", result.getTemplateMappedUuid());
	}

	
	@Test
	public void testBuilder_1()
		throws Exception {

		NotificationTemplate.NotificationTemplateBuilder result = NotificationTemplate.builder();

	
		assertNotNull(result);
		assertEquals("NotificationTemplate.NotificationTemplateBuilder(tenantId=null, moduleCode=null, notificationTemplateUuid=null, eventDetailUuid=null, emailContent=null, smsContent=null, templateType=null, templateMappedUuid=null, setdoc=null, createdBy=null, lastModifiedBy=null, createdTime=null, lastModifiedTime=null)", result.toString());
	}

	
	@Test
	public void testGetCreatedBy_1()
		throws Exception {
		NotificationTemplate fixture = new NotificationTemplate("", "", "", "", "", "", "", "", "", "", "", new Long(1L), new Long(1L));

		String result = fixture.getCreatedBy();

		
		assertEquals("", result);
	}

	
	@Test
	public void testGetCreatedTime_1()
		throws Exception {
		NotificationTemplate fixture = new NotificationTemplate("", "", "", "", "", "", "", "", "", "", "", new Long(1L), new Long(1L));

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
	public void testGetEmailContent_1()
		throws Exception {
		NotificationTemplate fixture = new NotificationTemplate("", "", "", "", "", "", "", "", "", "", "", new Long(1L), new Long(1L));

		String result = fixture.getEmailContent();

		
		assertEquals("", result);
	}

	
	@Test
	public void testGetEventDetailUuid_1()
		throws Exception {
		NotificationTemplate fixture = new NotificationTemplate("", "", "", "", "", "", "", "", "", "", "", new Long(1L), new Long(1L));

		String result = fixture.getEventDetailUuid();

		
		assertEquals("", result);
	}

	
	@Test
	public void testGetLastModifiedBy_1()
		throws Exception {
		NotificationTemplate fixture = new NotificationTemplate("", "", "", "", "", "", "", "", "", "", "", new Long(1L), new Long(1L));

		String result = fixture.getLastModifiedBy();

		
		assertEquals("", result);
	}

	
	@Test
	public void testGetLastModifiedTime_1()
		throws Exception {
		NotificationTemplate fixture = new NotificationTemplate("", "", "", "", "", "", "", "", "", "", "", new Long(1L), new Long(1L));

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
		NotificationTemplate fixture = new NotificationTemplate("", "", "", "", "", "", "", "", "", "", "", new Long(1L), new Long(1L));

		String result = fixture.getModuleCode();

		
		assertEquals("", result);
	}

	
	@Test
	public void testGetNotificationTemplateUuid_1()
		throws Exception {
		NotificationTemplate fixture = new NotificationTemplate("", "", "", "", "", "", "", "", "", "", "", new Long(1L), new Long(1L));

		String result = fixture.getNotificationTemplateUuid();

		
		assertEquals("", result);
	}

	@Test
	public void testGetSetdoc_1()
		throws Exception {
		NotificationTemplate fixture = new NotificationTemplate("", "", "", "", "", "", "", "", "", "", "", new Long(1L), new Long(1L));

		String result = fixture.getSetdoc();

		
		assertEquals("", result);
	}


	@Test
	public void testGetSmsContent_1()
		throws Exception {
		NotificationTemplate fixture = new NotificationTemplate("", "", "", "", "", "", "", "", "", "", "", new Long(1L), new Long(1L));

		String result = fixture.getSmsContent();

		
		assertEquals("", result);
	}


	@Test
	public void testGetTemplateMappedUuid_1()
		throws Exception {
		NotificationTemplate fixture = new NotificationTemplate("", "", "", "", "", "", "", "", "", "", "", new Long(1L), new Long(1L));

		String result = fixture.getTemplateMappedUuid();

		
		assertEquals("", result);
	}

	
	@Test
	public void testGetTemplateType_1()
		throws Exception {
		NotificationTemplate fixture = new NotificationTemplate("", "", "", "", "", "", "", "", "", "", "", new Long(1L), new Long(1L));

		String result = fixture.getTemplateType();

		
		assertEquals("", result);
	}

	@Test
	public void testGetTenantId_1()
		throws Exception {
		NotificationTemplate fixture = new NotificationTemplate("", "", "", "", "", "", "", "", "", "", "", new Long(1L), new Long(1L));

		String result = fixture.getTenantId();

		
		assertEquals("", result);
	}

	
	@Test
	public void testSetCreatedBy_1()
		throws Exception {
		NotificationTemplate fixture = new NotificationTemplate("", "", "", "", "", "", "", "", "", "", "", new Long(1L), new Long(1L));
		String createdBy = "";

		fixture.setCreatedBy(createdBy);

		
	}

	
	@Test
	public void testSetCreatedTime_1()
		throws Exception {
		NotificationTemplate fixture = new NotificationTemplate("", "", "", "", "", "", "", "", "", "", "", new Long(1L), new Long(1L));
		Long createdTime = new Long(1L);

		fixture.setCreatedTime(createdTime);

		
	}

	
	@Test
	public void testSetEmailContent_1()
		throws Exception {
		NotificationTemplate fixture = new NotificationTemplate("", "", "", "", "", "", "", "", "", "", "", new Long(1L), new Long(1L));
		String emailContent = "";

		fixture.setEmailContent(emailContent);

		
	}

	
	@Test
	public void testSetEventDetailUuid_1()
		throws Exception {
		NotificationTemplate fixture = new NotificationTemplate("", "", "", "", "", "", "", "", "", "", "", new Long(1L), new Long(1L));
		String eventDetailUuid = "";

		fixture.setEventDetailUuid(eventDetailUuid);

		
	}

	
	@Test
	public void testSetLastModifiedBy_1()
		throws Exception {
		NotificationTemplate fixture = new NotificationTemplate("", "", "", "", "", "", "", "", "", "", "", new Long(1L), new Long(1L));
		String lastModifiedBy = "";

		fixture.setLastModifiedBy(lastModifiedBy);

		
	}

	
	@Test
	public void testSetLastModifiedTime_1()
		throws Exception {
		NotificationTemplate fixture = new NotificationTemplate("", "", "", "", "", "", "", "", "", "", "", new Long(1L), new Long(1L));
		Long lastModifiedTime = new Long(1L);

		fixture.setLastModifiedTime(lastModifiedTime);

		
	}

	@Test
	public void testSetModuleCode_1()
		throws Exception {
		NotificationTemplate fixture = new NotificationTemplate("", "", "", "", "", "", "", "", "", "", "", new Long(1L), new Long(1L));
		String moduleCode = "";

		fixture.setModuleCode(moduleCode);

		
	}


	@Test
	public void testSetNotificationTemplateUuid_1()
		throws Exception {
		NotificationTemplate fixture = new NotificationTemplate("", "", "", "", "", "", "", "", "", "", "", new Long(1L), new Long(1L));
		String notificationTemplateUuid = "";

		fixture.setNotificationTemplateUuid(notificationTemplateUuid);

		
	}


	@Test
	public void testSetSetdoc_1()
		throws Exception {
		NotificationTemplate fixture = new NotificationTemplate("", "", "", "", "", "", "", "", "", "", "", new Long(1L), new Long(1L));
		String setdoc = "";

		fixture.setSetdoc(setdoc);

		
	}


	@Test
	public void testSetSmsContent_1()
		throws Exception {
		NotificationTemplate fixture = new NotificationTemplate("", "", "", "", "", "", "", "", "", "", "", new Long(1L), new Long(1L));
		String smsContent = "";

		fixture.setSmsContent(smsContent);

		
	}


	@Test
	public void testSetTemplateMappedUuid_1()
		throws Exception {
		NotificationTemplate fixture = new NotificationTemplate("", "", "", "", "", "", "", "", "", "", "", new Long(1L), new Long(1L));
		String templateMappedUuid = "";

		fixture.setTemplateMappedUuid(templateMappedUuid);

		
	}


	@Test
	public void testSetTemplateType_1()
		throws Exception {
		NotificationTemplate fixture = new NotificationTemplate("", "", "", "", "", "", "", "", "", "", "", new Long(1L), new Long(1L));
		String templateType = "";

		fixture.setTemplateType(templateType);

		
	}

	
	@Test
	public void testSetTenantId_1()
		throws Exception {
		NotificationTemplate fixture = new NotificationTemplate("", "", "", "", "", "", "", "", "", "", "", new Long(1L), new Long(1L));
		String tenantId = "";

		fixture.setTenantId(tenantId);

		
	}


	public void setUp()
		throws Exception {
		
	}

	
	@After
	public void tearDown()
		throws Exception {
		
	}


	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(NotificationTemplateTest.class);
	}
}