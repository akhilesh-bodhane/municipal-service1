package org.egov.pm.model;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import junit.framework.Assert;

@RunWith(MockitoJUnitRunner.class)
public class EmailRequestTestCases {

	// @InjectMocks
	private EmailRequest emailRequest = EmailRequest.builder().build();

	@Test
	public void testEmailRequest() {
		String str = emailRequest.toString();
		Assert.assertEquals(str, emailRequest.toString());
	}

	@Test
	public void testBuilder() {
		EmailRequest d = emailRequest.builder().build();
		org.junit.Assert.assertEquals(d.getClass(), emailRequest.builder().build().getClass());
	}

	@Test
	public void testGetEmail() {
		emailRequest.setEmail("email");
		Assert.assertEquals("email", emailRequest.getEmail());
	}

	@Test
	public void testGetSubject() {
		emailRequest.setSubject("subject");
		Assert.assertEquals("subject", emailRequest.getSubject());
	}

	@Test
	public void testGetBody() {
		emailRequest.setBody("body");
		Assert.assertEquals("body", emailRequest.getBody());
	}

	@Test
	public void testIsHTML() {
		emailRequest.setHTML(true);
		Assert.assertEquals(true, emailRequest.isHTML());
	}

	@Test
	public void testEmailRequestBuilder() {
		EmailRequest.EmailRequestBuilder builder = new EmailRequest.EmailRequestBuilder();
		builder.body("body text");
		builder.email("email@gmail.com");
		builder.isHTML(true);
		builder.subject("subject");
		builder.build();
		
		EmailRequest.EmailRequestBuilder builder1 = new EmailRequest.EmailRequestBuilder();
		builder1.body("body text");
		builder1.email("email@gmail.com");
		builder1.isHTML(true);
		builder1.subject("subject");
		builder1.build();
		
		Assert.assertEquals(builder1.toString(), builder.toString());
	}
	
}
