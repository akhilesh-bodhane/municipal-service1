package org.egov.ec.web.models;

import org.egov.ec.web.models.NotificationTemplate;
import org.junit.*;
import static org.junit.Assert.*;

import java.util.List;

public class NotificationTemplateTest {
	
	/**
	 * Run the NotificationTemplate() constructor test.
	 *
	 * @throws Exception
	 *
	 *  at 30/4/20 5:39 AM
	 */
	@Test
	public void testNotificationTemplate_1()
		throws Exception {

		NotificationTemplate result = new NotificationTemplate();

		
		assertNotNull(result);
		assertEquals(null, result.getEmail());
		assertEquals(null, result.getSubject());
		assertEquals(null, result.getBody());
		assertEquals(null, result.getAttachments());
		assertEquals(null, result.getMobileNumber());
		assertEquals(null, result.getMessage());
		assertEquals(null, result.getIsHTML());
	}
	
	/**
	 * Run the NotificationTemplate(String,String,String,String,Long,String,Long,Boolean,String) constructor test.
	 *
	 * @throws Exception
	 *
	 *  at 30/04/20 1:32 PM
	 */
	@Test
	public void testNotificationTemplate_2()
		throws Exception {
		String email = "";
		String subject="";
		String body = "";
		List<EmailAttachment> attachments = null;
		Long mobileNumber = new Long(0);
		String message = "";
		Boolean isHTML = new Boolean(true);


		NotificationTemplate result = new NotificationTemplate(email, subject, body, attachments, mobileNumber, message, isHTML);

		
		assertNotNull(result);
		assertEquals(new Long(0L), (result.getMobileNumber()));
		assertEquals(Boolean.TRUE, result.getIsHTML());
		assertEquals("", result.getEmail());
		assertEquals("", result.getSubject());
		assertEquals("", result.getBody());
		assertEquals("", result.getMessage());
		assertEquals(null,result.getAttachments());
	}
	
	/**
	 * Run the NotificationTemplate.NotificationTemplateBuilder builder() method test.
	 *
	 * @throws Exception
	 *
	 *  at 30/04/20 1:32 PM
	 */
	@Test
	public void testBuilder_1()
		throws Exception {

		NotificationTemplate.NotificationTemplateBuilder result = NotificationTemplate.builder();

		
		assertNotNull(result);
		assertEquals("NotificationTemplate.NotificationTemplateBuilder(email=null, subject=null, body=null, attachments=null, mobileNumber=null, message=null, isHTML=null)", result.toString());
	}
	
	/**
	 * Run the NotificationTemplate.NotificationTemplateBuilder builder() method test.
	 *
	 * @throws Exception
	 *
	 *  at 30/04/20 1:32 PM
	 */
	@Test
	public void testBuilder_2()
		throws Exception {

		NotificationTemplate.NotificationTemplateBuilder builder = new NotificationTemplate.NotificationTemplateBuilder();
		builder.email(null);
		builder.subject(null);
		builder.body(null);
		builder.attachments(null);
		builder.mobileNumber(null);
		builder.message(null);
		builder.isHTML(null);
		builder.build();

		NotificationTemplate.NotificationTemplateBuilder builder2 = new NotificationTemplate.NotificationTemplateBuilder();
		builder2.email(null);
		builder2.subject(null);
		builder2.body(null);
		builder2.attachments(null);
		builder2.mobileNumber(null);
		builder2.message(null);
		builder2.isHTML(null);
		builder2.build();

		Assert.assertEquals(builder2.toString(), builder.toString());
	}
	
	@Test
	public void testGetEmail_1()
		throws Exception {
		NotificationTemplate fixture = new NotificationTemplate("","","",null,new Long(1L),"",new Boolean(true));

		String result = fixture.getEmail();		
		assertEquals("", result);
	}
	
	@Test
	public void testGetSubject_1()
		throws Exception {
		NotificationTemplate fixture = new NotificationTemplate("","","",null,new Long(1L),"",new Boolean(true));

		String result = fixture.getSubject();		
		assertEquals("", result);
	}
	
	@Test
	public void testGetBody_1()
		throws Exception {
		NotificationTemplate fixture = new NotificationTemplate("","","",null,new Long(1L),"",new Boolean(true));

		String result = fixture.getBody();	
		assertEquals("", result);
	}
	
	@Test
	public void testGetAttachmentUrls_1()
		throws Exception {
		NotificationTemplate fixture = new NotificationTemplate("","","",null,new Long(1L),"",new Boolean(true));

		List<EmailAttachment> result = fixture.getAttachments();	
		assertEquals(null, result);
	}

	
	@Test
	public void testGetMobileNumber_1()
		throws Exception {
		NotificationTemplate fixture = new NotificationTemplate("","","",null,new Long(1L),"",new Boolean(true));

		Long result = fixture.getMobileNumber();		
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
	public void testGetMessage_1()
		throws Exception {
		NotificationTemplate fixture = new NotificationTemplate("","","",null,new Long(1L),"",new Boolean(true));

		String result = fixture.getMessage();
		assertEquals("", result);
	}
	
	@Test
	public void testGetIsActive_1()
		throws Exception {
		NotificationTemplate fixture = new NotificationTemplate("","","",null,new Long(1L),"",new Boolean(true));

		Boolean result = fixture.getIsHTML();
		
		assertNotNull(result);
		assertEquals("true", result.toString());
		assertEquals(true, result.booleanValue());
	}
	
	@Test
	public void testSetEmail_1()
		throws Exception {
		NotificationTemplate fixture = new NotificationTemplate("","","",null,new Long(1L),"",new Boolean(true));
		String email ="" ;		
		fixture.setEmail(email);
	}
	
	@Test
	public void testSetSubject_1()
		throws Exception {
		NotificationTemplate fixture = new NotificationTemplate("","","",null,new Long(1L),"",new Boolean(true));
		String subject ="" ;		
		fixture.setSubject(subject);
	}
	
	@Test
	public void testSetBody_1()
		throws Exception {
		NotificationTemplate fixture = new NotificationTemplate("","","",null,new Long(1L),"",new Boolean(true));
		String body ="" ;		
		fixture.setBody(body);
	}
	
	@Test
	public void testSetAttachmentUrls_1()
		throws Exception {
		NotificationTemplate fixture = new NotificationTemplate("","","",null,new Long(1L),"",new Boolean(true));
		List<EmailAttachment> attachmentUrls =null ;		
		fixture.setAttachments(attachmentUrls);
	}
	
	@Test
	public void testSetMobileNumber_1()
		throws Exception {
		NotificationTemplate fixture = new NotificationTemplate("","","",null,new Long(1L),"",new Boolean(true));
		Long mobileNumber=new Long(1L);	
		fixture.setMobileNumber(mobileNumber);
	}
	
	@Test
	public void testSetMessage_1()
		throws Exception {
		NotificationTemplate fixture = new NotificationTemplate("","","",null,new Long(1L),"",new Boolean(true));
		String message ="" ;		
		fixture.setMessage(message);
	}

	@Test
	public void testSetIsActive_1()
		throws Exception {
		NotificationTemplate fixture = new NotificationTemplate("","","",null,new Long(1L),"",new Boolean(true));
		Boolean isHTML = new Boolean(true);
		fixture.setIsHTML(isHTML);

		
	}
}
