package org.egov.prscp.web.models;

import org.junit.*;
import static org.junit.Assert.*;

/**
 * The class <code>SendInvitationTest</code> contains tests for the class <code>{@link SendInvitation}</code>.
 *
 * @generatedBy CodePro at 25/5/20 3:50 PM
 * @author Aniket.Marathe
 * @version $Revision: 1.0 $
 */
public class SendInvitationTest {
	/**
	 * Run the SendInvitation(String,String,String,String,String,String) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:50 PM
	 */
	@Test
	public void testSendInvitation_1()
		throws Exception {
		String tenantId = "";
		String moduleCode = "";
		String eventDetailUuid = "";
		String smsContent = "";
		String emailContent = "";
		String templateType = "";

		SendInvitation result = new SendInvitation(tenantId, moduleCode, eventDetailUuid, smsContent, emailContent, templateType);

		// add additional test code here
		assertNotNull(result);
		assertEquals("", result.getEventDetailUuid());
		assertEquals("", result.getModuleCode());
		assertEquals("", result.getEmailContent());
		assertEquals("", result.getTemplateType());
		assertEquals("", result.getTenantId());
		assertEquals("", result.getSmsContent());
	}

	/**
	 * Run the SendInvitation.SendInvitationBuilder builder() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:50 PM
	 */
	@Test
	public void testBuilder_1()
		throws Exception {

		SendInvitation.SendInvitationBuilder result = SendInvitation.builder();

		// add additional test code here
		assertNotNull(result);
		assertEquals("SendInvitation.SendInvitationBuilder(tenantId=null, moduleCode=null, eventDetailUuid=null, smsContent=null, emailContent=null, templateType=null)", result.toString());
	}

	/**
	 * Run the String getEmailContent() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:50 PM
	 */
	@Test
	public void testGetEmailContent_1()
		throws Exception {
		SendInvitation fixture = new SendInvitation("", "", "", "", "", "");

		String result = fixture.getEmailContent();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the String getEventDetailUuid() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:50 PM
	 */
	@Test
	public void testGetEventDetailUuid_1()
		throws Exception {
		SendInvitation fixture = new SendInvitation("", "", "", "", "", "");

		String result = fixture.getEventDetailUuid();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the String getModuleCode() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:50 PM
	 */
	@Test
	public void testGetModuleCode_1()
		throws Exception {
		SendInvitation fixture = new SendInvitation("", "", "", "", "", "");

		String result = fixture.getModuleCode();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the String getSmsContent() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:50 PM
	 */
	@Test
	public void testGetSmsContent_1()
		throws Exception {
		SendInvitation fixture = new SendInvitation("", "", "", "", "", "");

		String result = fixture.getSmsContent();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the String getTemplateType() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:50 PM
	 */
	@Test
	public void testGetTemplateType_1()
		throws Exception {
		SendInvitation fixture = new SendInvitation("", "", "", "", "", "");

		String result = fixture.getTemplateType();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the String getTenantId() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:50 PM
	 */
	@Test
	public void testGetTenantId_1()
		throws Exception {
		SendInvitation fixture = new SendInvitation("", "", "", "", "", "");

		String result = fixture.getTenantId();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the void setEmailContent(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:50 PM
	 */
	@Test
	public void testSetEmailContent_1()
		throws Exception {
		SendInvitation fixture = new SendInvitation("", "", "", "", "", "");
		String emailContent = "";

		fixture.setEmailContent(emailContent);

		// add additional test code here
	}

	/**
	 * Run the void setEventDetailUuid(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:50 PM
	 */
	@Test
	public void testSetEventDetailUuid_1()
		throws Exception {
		SendInvitation fixture = new SendInvitation("", "", "", "", "", "");
		String eventDetailUuid = "";

		fixture.setEventDetailUuid(eventDetailUuid);

		// add additional test code here
	}

	/**
	 * Run the void setModuleCode(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:50 PM
	 */
	@Test
	public void testSetModuleCode_1()
		throws Exception {
		SendInvitation fixture = new SendInvitation("", "", "", "", "", "");
		String moduleCode = "";

		fixture.setModuleCode(moduleCode);

		// add additional test code here
	}

	/**
	 * Run the void setSmsContent(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:50 PM
	 */
	@Test
	public void testSetSmsContent_1()
		throws Exception {
		SendInvitation fixture = new SendInvitation("", "", "", "", "", "");
		String smsContent = "";

		fixture.setSmsContent(smsContent);

		// add additional test code here
	}

	/**
	 * Run the void setTemplateType(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:50 PM
	 */
	@Test
	public void testSetTemplateType_1()
		throws Exception {
		SendInvitation fixture = new SendInvitation("", "", "", "", "", "");
		String templateType = "";

		fixture.setTemplateType(templateType);

		// add additional test code here
	}

	/**
	 * Run the void setTenantId(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:50 PM
	 */
	@Test
	public void testSetTenantId_1()
		throws Exception {
		SendInvitation fixture = new SendInvitation("", "", "", "", "", "");
		String tenantId = "";

		fixture.setTenantId(tenantId);

		// add additional test code here
	}

	/**
	 * Perform pre-test initialization.
	 *
	 * @throws Exception
	 *         if the initialization fails for some reason
	 *
	 * @generatedBy CodePro at 25/5/20 3:50 PM
	 */
	@Before
	public void setUp()
		throws Exception {
		// add additional set up code here
	}

	/**
	 * Perform post-test clean-up.
	 *
	 * @throws Exception
	 *         if the clean-up fails for some reason
	 *
	 * @generatedBy CodePro at 25/5/20 3:50 PM
	 */
	@After
	public void tearDown()
		throws Exception {
		// Add additional tear down code here
	}

	/**
	 * Launch the test.
	 *
	 * @param args the command line arguments
	 *
	 * @generatedBy CodePro at 25/5/20 3:50 PM
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(SendInvitationTest.class);
	}
}