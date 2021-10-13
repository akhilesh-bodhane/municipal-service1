package org.egov.prscp.web.models;

import java.util.List;
import org.easymock.EasyMock;
import org.junit.*;
import static org.junit.Assert.*;

public class EmailRequestTest {

	@Test
	public void testEmailRequest_1()
		throws Exception {

		EmailRequest result = new EmailRequest();

		
		assertNotNull(result);
		assertEquals(null, result.getSubject());
		assertEquals(null, result.getBody());
		assertEquals(null, result.getEmail());
		assertEquals(false, result.isHTML());
		assertEquals(null, result.getAttachments());
	}

	@Test
	public void testEmailRequest_2()
		throws Exception {
		String email = "";
		String subject = "";
		String body = "";
		boolean isHTML = true;
		List<EmailAttachment> attachments = EasyMock.createMock(List.class);
	

		EasyMock.replay(attachments);

		EmailRequest result = new EmailRequest(email, subject, body, isHTML, attachments);

		
		EasyMock.verify(attachments);
		assertNotNull(result);
		assertEquals("", result.getSubject());
		assertEquals("", result.getBody());
		assertEquals("", result.getEmail());
		assertEquals(true, result.isHTML());
	}

	
	@Test
	public void testBuilder_1()
		throws Exception {

		EmailRequest.EmailRequestBuilder result = EmailRequest.builder();

		
		assertNotNull(result);
		assertEquals("EmailRequest.EmailRequestBuilder(email=null, subject=null, body=null, isHTML=false, attachments=null)", result.toString());
	}

	@Test
	public void testGetAttachments_1()
		throws Exception {
		EmailRequest fixture = new EmailRequest("", "", "", true, EasyMock.createNiceMock(List.class));

		List<EmailAttachment> result = fixture.getAttachments();

		
		assertNotNull(result);
		assertEquals(0, result.size());
	}


	@Test
	public void testGetBody_1()
		throws Exception {
		EmailRequest fixture = new EmailRequest("", "", "", true, EasyMock.createNiceMock(List.class));

		String result = fixture.getBody();

		
		assertEquals("", result);
	}


	@Test
	public void testGetEmail_1()
		throws Exception {
		EmailRequest fixture = new EmailRequest("", "", "", true, EasyMock.createNiceMock(List.class));

		String result = fixture.getEmail();

		assertEquals("", result);
	}

	
	@Test
	public void testGetSubject_1()
		throws Exception {
		EmailRequest fixture = new EmailRequest("", "", "", true, EasyMock.createNiceMock(List.class));

		String result = fixture.getSubject();

		assertEquals("", result);
	}

	
	@Test
	public void testIsHTML_1()
		throws Exception {
		EmailRequest fixture = new EmailRequest("", "", "", true, EasyMock.createNiceMock(List.class));

		boolean result = fixture.isHTML();

		
		assertEquals(true, result);
	}

	@Test
	public void testIsHTML_2()
		throws Exception {
		EmailRequest fixture = new EmailRequest("", "", "", false, EasyMock.createNiceMock(List.class));

		boolean result = fixture.isHTML();

		
		assertEquals(false, result);
	}

	
	@Test
	public void testSetAttachments_1()
		throws Exception {
		EmailRequest fixture = new EmailRequest("", "", "", true, EasyMock.createNiceMock(List.class));
		List<EmailAttachment> attachments = EasyMock.createMock(List.class);
		

		EasyMock.replay(attachments);

		fixture.setAttachments(attachments);

		EasyMock.verify(attachments);
	}

	
	@Test
	public void testSetBody_1()
		throws Exception {
		EmailRequest fixture = new EmailRequest("", "", "", true, EasyMock.createNiceMock(List.class));
		String body = "";

		fixture.setBody(body);
		
	}

	
	@Test
	public void testSetEmail_1()
		throws Exception {
		EmailRequest fixture = new EmailRequest("", "", "", true, EasyMock.createNiceMock(List.class));
		String email = "";

		fixture.setEmail(email);

	
	}


	@Test
	public void testSetHTML_1()
		throws Exception {
		EmailRequest fixture = new EmailRequest("", "", "", true, EasyMock.createNiceMock(List.class));
		boolean isHTML = true;

		fixture.setHTML(isHTML);

	}

	
	@Test
	public void testSetSubject_1()
		throws Exception {
		EmailRequest fixture = new EmailRequest("", "", "", true, EasyMock.createNiceMock(List.class));
		String subject = "";

		fixture.setSubject(subject);

	}


	@Test
	public void testToDomain_1()
		throws Exception {
		EmailRequest fixture = new EmailRequest("", "", "", true, EasyMock.createNiceMock(List.class));

		Email result = fixture.toDomain();

		assertNotNull(result);
		assertEquals("", result.getSubject());
		assertEquals("", result.getBody());
		assertEquals(true, result.isHtml());
		assertEquals("", result.getToAddress());
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
		new org.junit.runner.JUnitCore().run(EmailRequestTest.class);
	}
}