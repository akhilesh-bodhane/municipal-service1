package org.egov.prscp.web.models;

import java.util.List;
import org.easymock.EasyMock;
import org.junit.*;
import static org.junit.Assert.*;

public class EmailTest {

	@Test
	public void testEmail_1()
		throws Exception {
		String toAddress = "";
		String subject = "";
		String body = "";
		boolean html = true;
		List<EmailAttachment> attachments = EasyMock.createMock(List.class);
	
		EasyMock.replay(attachments);

		Email result = new Email(toAddress, subject, body, html, attachments);

		EasyMock.verify(attachments);
		assertNotNull(result);
		assertEquals("", result.getSubject());
		assertEquals("", result.getToAddress());
		assertEquals("", result.getBody());
		assertEquals(true, result.isHtml());
	}

	
	@Test
	public void testBuilder_1()
		throws Exception {

		Email.EmailBuilder result = Email.builder();

		
		assertNotNull(result);
		assertEquals("Email.EmailBuilder(toAddress=null, subject=null, body=null, html=false, attachments=null)", result.toString());
	}


	@Test
	public void testCanEqual_1()
		throws Exception {
		Email fixture = new Email("", "", "", true, EasyMock.createNiceMock(List.class));
		Object other = new Object();

		boolean result = fixture.canEqual(other);

	
		assertEquals(false, result);
	}

	@Test
	public void testCanEqual_2()
		throws Exception {
		Email fixture = new Email("", "", "", true, EasyMock.createNiceMock(List.class));
		Object other = new Object();

		boolean result = fixture.canEqual(other);

	
		assertEquals(false, result);
	}

	@Test
	public void testEquals_1()
		throws Exception {
		Email fixture = new Email("", "", "", true, EasyMock.createNiceMock(List.class));
		Object o = new Email("", "", "", true, EasyMock.createNiceMock(List.class));

		boolean result = fixture.equals(o);

		assertEquals(false, result);
	}

	
	@Test
	public void testEquals_2()
		throws Exception {
		Email fixture = new Email("", "", "", true, EasyMock.createNiceMock(List.class));
		Object o = new Object();

		boolean result = fixture.equals(o);

		assertEquals(false, result);
	}


	@Test
	public void testEquals_3()
		throws Exception {
		Email fixture = new Email("", "", "", true, EasyMock.createNiceMock(List.class));
		Object o = new Email("", "", "", true, EasyMock.createNiceMock(List.class));

		boolean result = fixture.equals(o);

		assertEquals(false, result);
	}

	@Test
	public void testEquals_4()
		throws Exception {
		Email fixture = new Email("", "", "", true, EasyMock.createNiceMock(List.class));
		Object o = new Email("", "", "", true, EasyMock.createNiceMock(List.class));

		boolean result = fixture.equals(o);

		assertEquals(false, result);
	}

	
	@Test
	public void testEquals_5()
		throws Exception {
		Email fixture = new Email("", "", "", true, EasyMock.createNiceMock(List.class));
		Object o = new Email("", "", "", true, EasyMock.createNiceMock(List.class));

		boolean result = fixture.equals(o);

		assertEquals(false, result);
	}


	@Test
	public void testEquals_6()
		throws Exception {
		Email fixture = new Email("", "", "", true, EasyMock.createNiceMock(List.class));
		Object o = new Email("", "", "", true, EasyMock.createNiceMock(List.class));

		boolean result = fixture.equals(o);

		assertEquals(false, result);
	}


	@Test
	public void testEquals_7()
		throws Exception {
		Email fixture = new Email("", "", "", true, EasyMock.createNiceMock(List.class));
		Object o = new Email("", "", "", true, EasyMock.createNiceMock(List.class));

		boolean result = fixture.equals(o);

		assertEquals(false, result);
	}

	
	@Test
	public void testEquals_8()
		throws Exception {
		Email fixture = new Email("", "", "", true, EasyMock.createNiceMock(List.class));
		Object o = new Email("", "", "", true, EasyMock.createNiceMock(List.class));

		boolean result = fixture.equals(o);

		assertEquals(false, result);
	}

	
	@Test
	public void testEquals_9()
		throws Exception {
		Email fixture = new Email("", "", "", true, (List<EmailAttachment>) null);
		Object o = new Email("", "", "", true, (List<EmailAttachment>) null);

		boolean result = fixture.equals(o);

		assertEquals(true, result);
	}

	
	@Test
	public void testEquals_10()
		throws Exception {
		Email fixture = new Email("", "", "", true, EasyMock.createNiceMock(List.class));
		Object o = new Email("", "", "", true, EasyMock.createNiceMock(List.class));

		boolean result = fixture.equals(o);

		assertEquals(false, result);
	}

	
	@Test
	public void testGetAttachments_1()
		throws Exception {
		Email fixture = new Email("", "", "", true, EasyMock.createNiceMock(List.class));

		List<EmailAttachment> result = fixture.getAttachments();

		
		assertNotNull(result);
		assertEquals(0, result.size());
	}

	
	@Test
	public void testGetBody_1()
		throws Exception {
		Email fixture = new Email("", "", "", true, EasyMock.createNiceMock(List.class));

		String result = fixture.getBody();

	
		assertEquals("", result);
	}

	
	@Test
	public void testGetSubject_1()
		throws Exception {
		Email fixture = new Email("", "", "", true, EasyMock.createNiceMock(List.class));

		String result = fixture.getSubject();

		assertEquals("", result);
	}


	@Test
	public void testGetToAddress_1()
		throws Exception {
		Email fixture = new Email("", "", "", true, EasyMock.createNiceMock(List.class));

		String result = fixture.getToAddress();

		
		assertEquals("", result);
	}

	@Test
	public void testHashCode_1()
		throws Exception {
		Email fixture = new Email((String) null, (String) null, "", false, EasyMock.createNiceMock(List.class));

		int result = fixture.hashCode();

	
//		assertEquals(-1064662267, result);
	}

	
	@Test
	public void testHashCode_2()
		throws Exception {
		Email fixture = new Email("", "", (String) null, true, (List<EmailAttachment>) null);

		int result = fixture.hashCode();

		
		assertEquals(715078686, result);
	}

	
	@Test
	public void testIsHtml_1()
		throws Exception {
		Email fixture = new Email("", "", "", true, EasyMock.createNiceMock(List.class));

		boolean result = fixture.isHtml();

	
		assertEquals(true, result);
	}

	
	@Test
	public void testIsHtml_2()
		throws Exception {
		Email fixture = new Email("", "", "", false, EasyMock.createNiceMock(List.class));

		boolean result = fixture.isHtml();

		
		assertEquals(false, result);
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
		new org.junit.runner.JUnitCore().run(EmailTest.class);
	}
}