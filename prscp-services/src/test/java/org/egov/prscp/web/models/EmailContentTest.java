package org.egov.prscp.web.models;

import org.junit.*;
import static org.junit.Assert.*;

public class EmailContentTest {
	
	@Test
	public void testEmailContent_1()
		throws Exception {

		EmailContent result = new EmailContent();

		assertNotNull(result);
		assertEquals("EmailContent(emailSubject=null, emailBody=null)", result.toString());
		assertEquals(null, result.getEmailBody());
		assertEquals(null, result.getEmailSubject());
	}

	@Test
	public void testEmailContent_2()
		throws Exception {
		String emailSubject = "";
		String emailBody = "";

		EmailContent result = new EmailContent(emailSubject, emailBody);

	
		assertNotNull(result);
		assertEquals("EmailContent(emailSubject=, emailBody=)", result.toString());
		assertEquals("", result.getEmailBody());
		assertEquals("", result.getEmailSubject());
	}

	
	@Test
	public void testBuilder_1()
		throws Exception {

		EmailContent.EmailContentBuilder result = EmailContent.builder();

	
		assertNotNull(result);
		assertEquals("EmailContent.EmailContentBuilder(emailSubject=null, emailBody=null)", result.toString());
	}

	
	@Test
	public void testGetEmailBody_1()
		throws Exception {
		EmailContent fixture = new EmailContent("", "");

		String result = fixture.getEmailBody();

	
		assertEquals("", result);
	}

	@Test
	public void testGetEmailSubject_1()
		throws Exception {
		EmailContent fixture = new EmailContent("", "");

		String result = fixture.getEmailSubject();

		
		assertEquals("", result);
	}

	
	@Test
	public void testSetEmailBody_1()
		throws Exception {
		EmailContent fixture = new EmailContent("", "");
		String emailBody = "";

		fixture.setEmailBody(emailBody);

		
	}

	
	@Test
	public void testSetEmailSubject_1()
		throws Exception {
		EmailContent fixture = new EmailContent("", "");
		String emailSubject = "";

		fixture.setEmailSubject(emailSubject);

	
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
		new org.junit.runner.JUnitCore().run(EmailContentTest.class);
	}
}