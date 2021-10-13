package org.egov.prscp.web.models;

import org.junit.*;
import static org.junit.Assert.*;

public class EmailAttachmentTest {

	@Test
	public void testEmailAttachment_1()
		throws Exception {

		EmailAttachment result = new EmailAttachment();

		
		assertNotNull(result);
		assertEquals("EmailAttachment(name=null, url=null, mimeType=null)", result.toString());
		assertEquals(null, result.getName());
		assertEquals(null, result.getUrl());
		assertEquals(null, result.getMimeType());
	}


	@Test
	public void testEmailAttachment_2()
		throws Exception {
		String name = "";
		String url = "";
		String mimeType = "";

		EmailAttachment result = new EmailAttachment(name, url, mimeType);

	
		assertNotNull(result);
		assertEquals("EmailAttachment(name=, url=, mimeType=)", result.toString());
		assertEquals("", result.getName());
		assertEquals("", result.getUrl());
		assertEquals("", result.getMimeType());
	}


	@Test
	public void testBuilder_1()
		throws Exception {

		EmailAttachment.EmailAttachmentBuilder result = EmailAttachment.builder();

		
		assertNotNull(result);
		assertEquals("EmailAttachment.EmailAttachmentBuilder(name=null, url=null, mimeType=null)", result.toString());
	}

	
	@Test
	public void testCanEqual_1()
		throws Exception {
		EmailAttachment fixture = new EmailAttachment("", "", "");
		Object other = new Object();

		boolean result = fixture.canEqual(other);

		
		assertEquals(false, result);
	}


	@Test
	public void testCanEqual_2()
		throws Exception {
		EmailAttachment fixture = new EmailAttachment("", "", "");
		Object other = new Object();

		boolean result = fixture.canEqual(other);

		// add additional test code here
		assertEquals(false, result);
	}

	
	@Test
	public void testEquals_1()
		throws Exception {
		EmailAttachment fixture = new EmailAttachment("", "", "");
		Object o = new EmailAttachment("", "", "");

		boolean result = fixture.equals(o);

		assertEquals(true, result);
	}

	
	@Test
	public void testEquals_2()
		throws Exception {
		EmailAttachment fixture = new EmailAttachment("", "", "");
		Object o = new Object();

		boolean result = fixture.equals(o);

	
		assertEquals(false, result);
	}

	
	@Test
	public void testEquals_3()
		throws Exception {
		EmailAttachment fixture = new EmailAttachment("", "", "");
		Object o = new EmailAttachment("", "", "");

		boolean result = fixture.equals(o);

		assertEquals(true, result);
	}

	
	@Test
	public void testEquals_4()
		throws Exception {
		EmailAttachment fixture = new EmailAttachment("", "", "");
		Object o = new EmailAttachment("", "", "");

		boolean result = fixture.equals(o);

		assertEquals(true, result);
	}

	
	@Test
	public void testEquals_5()
		throws Exception {
		EmailAttachment fixture = new EmailAttachment("", "", "");
		Object o = new EmailAttachment("", "", "");

		boolean result = fixture.equals(o);

		
		assertEquals(true, result);
	}

	@Test
	public void testEquals_6()
		throws Exception {
		EmailAttachment fixture = new EmailAttachment("", "", "");
		Object o = new EmailAttachment("", "", "");

		boolean result = fixture.equals(o);

	
		assertEquals(true, result);
	}

	@Test
	public void testEquals_7()
		throws Exception {
		EmailAttachment fixture = new EmailAttachment("", "", (String) null);
		Object o = new EmailAttachment("", "", (String) null);

		boolean result = fixture.equals(o);

	
		assertEquals(true, result);
	}

	
	@Test
	public void testEquals_8()
		throws Exception {
		EmailAttachment fixture = new EmailAttachment("", "", "");
		Object o = new EmailAttachment("", "", "");

		boolean result = fixture.equals(o);

	
		assertEquals(true, result);
	}

	@Test
	public void testGetMimeType_1()
		throws Exception {
		EmailAttachment fixture = new EmailAttachment("", "", "");

		String result = fixture.getMimeType();

	
		assertEquals("", result);
	}

	
	@Test
	public void testGetName_1()
		throws Exception {
		EmailAttachment fixture = new EmailAttachment("", "", "");

		String result = fixture.getName();

		
		assertEquals("", result);
	}

	
	@Test
	public void testGetUrl_1()
		throws Exception {
		EmailAttachment fixture = new EmailAttachment("", "", "");

		String result = fixture.getUrl();

		
		assertEquals("", result);
	}

	
	@Test
	public void testHashCode_1()
		throws Exception {
		EmailAttachment fixture = new EmailAttachment((String) null, "", "");

		int result = fixture.hashCode();

	
		assertEquals(355062, result);
	}

	@Test
	public void testHashCode_2()
		throws Exception {
		EmailAttachment fixture = new EmailAttachment("", (String) null, (String) null);

		int result = fixture.hashCode();

		
		assertEquals(207959, result);
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
		new org.junit.runner.JUnitCore().run(EmailAttachmentTest.class);
	}
}