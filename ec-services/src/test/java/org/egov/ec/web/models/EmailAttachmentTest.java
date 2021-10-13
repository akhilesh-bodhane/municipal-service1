package org.egov.ec.web.models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Assert;
import org.junit.Test;

/**
 * The class <code>EmailAttachmentTest</code> contains tests for the class <code>{@link EmailAttachment}</code>.
 *
 * @generated at 17/5/20 2:11 PM
 * @version $Revision: 1.0 $
 */
public class EmailAttachmentTest {
	/**
	 * Run the EmailAttachment() constructor test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:11 PM
	 */
	@Test
	public void testEmailAttachment_1()
		throws Exception {

		EmailAttachment result = new EmailAttachment();

		
		assertNotNull(result);
		assertEquals(null, result.getName());
		assertEquals(null, result.getUrl());
		assertEquals(null, result.getMimeType());
	}

	/**
	 * Run the EmailAttachment(String,List<Role>) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:11 PM
	 */
	@Test
	public void testEmailAttachment_2()
		throws Exception {
		String name = "";
		String url="";
		String mimeType="";
	
		EmailAttachment result = new EmailAttachment(name, url, mimeType);		
		
		assertNotNull(result);
		assertEquals("", result.getName());
		assertEquals("", result.getUrl());
		assertEquals("", result.getMimeType());
	}


	/**
	 * Run the EmailAttachment.EmailAttachmentBuilder builder() method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:11 PM
	 */
	@Test
	public void testBuilder_1()
		throws Exception {

		EmailAttachment.EmailAttachmentBuilder result = EmailAttachment.builder();

		
		assertNotNull(result);
		assertEquals("EmailAttachment.EmailAttachmentBuilder(name=null, url=null, mimeType=null)", result.toString());
	}

	@Test
	public void testBuilder_2()
		throws Exception {

		EmailAttachment.EmailAttachmentBuilder builder = EmailAttachment.builder();
		builder.name(null);
		builder.url(null);
		builder.mimeType(null);
		builder.build();
		
		EmailAttachment.EmailAttachmentBuilder builder2 = EmailAttachment.builder();
		builder2.name(null);
		builder2.url(null);
		builder2.mimeType(null);
		builder2.build();
		
		Assert.assertEquals(builder2.toString(), builder.toString());
	}
	/**
	 * Run the List<Role> getName() method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:11 PM
	 */
	@Test
	public void testGetName_1()
		throws Exception {
		EmailAttachment fixture = new EmailAttachment("", "", "");

		String result = fixture.getName();	
		assertEquals("", result);
	}

	/**
	 * Run the String getUrl() method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:11 PM
	 */
	@Test
	public void testGetUrl_1()
		throws Exception {
		EmailAttachment fixture = new EmailAttachment("", "", "");

		String result = fixture.getUrl();

		
		assertEquals("", result);
	}
	
	/**
	 * Run the String getMimeType() method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:11 PM
	 */
	@Test
	public void testGetMimeType_1()
		throws Exception {
		EmailAttachment fixture = new EmailAttachment("", "", "");

		String result = fixture.getMimeType();

		
		assertEquals("", result);
	}

	/**
	 * Run the void setName(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:11 PM
	 */
	@Test
	public void testSetName_1()
		throws Exception {
		EmailAttachment fixture = new EmailAttachment("", "", "");
		String name = "";

		fixture.setName(name);		
		
	}

	/**
	 * Run the void setUrl(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:11 PM
	 */
	@Test
	public void testSetUrl_1()
		throws Exception {
		EmailAttachment fixture = new EmailAttachment("", "", "");
		String url = "";

		fixture.setUrl(url);

		
	}
	
	/**
	 * Run the void setMimeType(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:11 PM
	 */
	@Test
	public void testSetMimeType_1()
		throws Exception {
		EmailAttachment fixture = new EmailAttachment("", "", "");
		String mimeType = "";

		fixture.setMimeType(mimeType);

		
	}
}