package org.egov.prscp.web.models;

import org.junit.*;
import static org.junit.Assert.*;


public class NotificationContentTest {
	
	@Test
	public void testNotificationContent_1()
		throws Exception {
		String receiverName = "";
		String receiverEmail = "";
		String receiverMobile = "";
		String emailSubjectContent = "";
		String emailBodyContent = "";
		String emailAttachment = "";
		String smsContent = "";

		NotificationContent result = new NotificationContent(receiverName, receiverEmail, receiverMobile, emailSubjectContent, emailBodyContent, emailAttachment, smsContent);

		assertNotNull(result);
		assertEquals("", result.getReceiverName());
		assertEquals("", result.getSmsContent());
		assertEquals("", result.getReceiverEmail());
		assertEquals("", result.getReceiverMobile());
		assertEquals("", result.getEmailSubjectContent());
		assertEquals("", result.getEmailBodyContent());
		assertEquals("", result.getEmailAttachment());
	}

	@Test
	public void testBuilder_1()
		throws Exception {

		NotificationContent.NotificationContentBuilder result = NotificationContent.builder();

		assertNotNull(result);
		assertEquals("NotificationContent.NotificationContentBuilder(receiverName=null, receiverEmail=null, receiverMobile=null, emailSubjectContent=null, emailBodyContent=null, emailAttachment=null, smsContent=null)", result.toString());
	}

	@Test
	public void testGetEmailAttachment_1()
		throws Exception {
		NotificationContent fixture = new NotificationContent("", "", "", "", "", "", "");

		String result = fixture.getEmailAttachment();

		assertEquals("", result);
	}

	
	@Test
	public void testGetEmailBodyContent_1()
		throws Exception {
		NotificationContent fixture = new NotificationContent("", "", "", "", "", "", "");

		String result = fixture.getEmailBodyContent();

		assertEquals("", result);
	}

	
	@Test
	public void testGetEmailSubjectContent_1()
		throws Exception {
		NotificationContent fixture = new NotificationContent("", "", "", "", "", "", "");

		String result = fixture.getEmailSubjectContent();

		assertEquals("", result);
	}

	@Test
	public void testGetReceiverEmail_1()
		throws Exception {
		NotificationContent fixture = new NotificationContent("", "", "", "", "", "", "");

		String result = fixture.getReceiverEmail();

		assertEquals("", result);
	}


	@Test
	public void testGetReceiverMobile_1()
		throws Exception {
		NotificationContent fixture = new NotificationContent("", "", "", "", "", "", "");

		String result = fixture.getReceiverMobile();

		assertEquals("", result);
	}

	
	@Test
	public void testGetReceiverName_1()
		throws Exception {
		NotificationContent fixture = new NotificationContent("", "", "", "", "", "", "");

		String result = fixture.getReceiverName();

		assertEquals("", result);
	}

	@Test
	public void testGetSmsContent_1()
		throws Exception {
		NotificationContent fixture = new NotificationContent("", "", "", "", "", "", "");

		String result = fixture.getSmsContent();

		assertEquals("", result);
	}

	@Test
	public void testSetEmailAttachment_1()
		throws Exception {
		NotificationContent fixture = new NotificationContent("", "", "", "", "", "", "");
		String emailAttachment = "";

		fixture.setEmailAttachment(emailAttachment);

	}


	@Test
	public void testSetEmailBodyContent_1()
		throws Exception {
		NotificationContent fixture = new NotificationContent("", "", "", "", "", "", "");
		String emailBodyContent = "";

		fixture.setEmailBodyContent(emailBodyContent);

	}

	@Test
	public void testSetEmailSubjectContent_1()
		throws Exception {
		NotificationContent fixture = new NotificationContent("", "", "", "", "", "", "");
		String emailSubjectContent = "";

		fixture.setEmailSubjectContent(emailSubjectContent);

	}


	@Test
	public void testSetReceiverEmail_1()
		throws Exception {
		NotificationContent fixture = new NotificationContent("", "", "", "", "", "", "");
		String receiverEmail = "";

		fixture.setReceiverEmail(receiverEmail);

	}


	@Test
	public void testSetReceiverMobile_1()
		throws Exception {
		NotificationContent fixture = new NotificationContent("", "", "", "", "", "", "");
		String receiverMobile = "";

		fixture.setReceiverMobile(receiverMobile);

	}


	@Test
	public void testSetReceiverName_1()
		throws Exception {
		NotificationContent fixture = new NotificationContent("", "", "", "", "", "", "");
		String receiverName = "";

		fixture.setReceiverName(receiverName);

	}


	@Test
	public void testSetSmsContent_1()
		throws Exception {
		NotificationContent fixture = new NotificationContent("", "", "", "", "", "", "");
		String smsContent = "";

		fixture.setSmsContent(smsContent);

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
		new org.junit.runner.JUnitCore().run(NotificationContentTest.class);
	}
}