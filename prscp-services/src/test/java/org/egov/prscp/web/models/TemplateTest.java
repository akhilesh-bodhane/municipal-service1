package org.egov.prscp.web.models;

import org.json.simple.JSONArray;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * The class <code>TemplateTest</code> contains tests for the class <code>{@link Template}</code>.
 *
 * @generatedBy CodePro at 25/5/20 3:52 PM
 * @author Aniket.Marathe
 * @version $Revision: 1.0 $
 */
public class TemplateTest {
	/**
	 * Run the Template() constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:52 PM
	 */
	@Test
	public void testTemplate_1()
		throws Exception {

		Template result = new Template();

		// add additional test code here
		assertNotNull(result);
		assertEquals(null, result.getTemplateMappedUuid());
		assertEquals(null, result.getEventDetailUuid());
		assertEquals(null, result.getTenderNoticeUuid());
		assertEquals(null, result.getDocumentAttachment());
		assertEquals(null, result.getModuleName());
		assertEquals(null, result.getEmailContent());
		assertEquals(null, result.getSmsContent());
		assertEquals(null, result.getModuleCode());
		assertEquals(null, result.getTemplateType());
		assertEquals(null, result.getTenantId());
	}

	/**
	 * Run the Template(String,String,String,String,String,String,String,JSONArray,JSONArray,String) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:52 PM
	 */
	@Test
	public void testTemplate_2()
		throws Exception {
		String tenantId = "";
		String moduleCode = "";
		String moduleName = "";
		String templateMappedUuid = "";
		String eventDetailUuid = "";
		String tenderNoticeUuid = "";
		String smsContent = "";
		JSONArray emailContent = new JSONArray();
		JSONArray documentAttachment = new JSONArray();
		String templateType = "";

		Template result = new Template(tenantId, moduleCode, moduleName, templateMappedUuid, eventDetailUuid, tenderNoticeUuid, smsContent, emailContent, documentAttachment, templateType);

		// add additional test code here
		assertNotNull(result);
		assertEquals("", result.getTemplateMappedUuid());
		assertEquals("", result.getEventDetailUuid());
		assertEquals("", result.getTenderNoticeUuid());
		assertEquals("", result.getModuleName());
		assertEquals("", result.getSmsContent());
		assertEquals("", result.getModuleCode());
		assertEquals("", result.getTemplateType());
		assertEquals("", result.getTenantId());
	}

	/**
	 * Run the Template.TemplateBuilder builder() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:52 PM
	 */
	@Test
	public void testBuilder_1()
		throws Exception {

		Template.TemplateBuilder result = Template.builder();

		// add additional test code here
		assertNotNull(result);
		assertEquals("Template.TemplateBuilder(tenantId=null, moduleCode=null, moduleName=null, templateMappedUuid=null, eventDetailUuid=null, tenderNoticeUuid=null, smsContent=null, emailContent=null, documentAttachment=null, templateType=null)", result.toString());
	}

	/**
	 * Run the JSONArray getDocumentAttachment() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:52 PM
	 */
	@Test
	public void testGetDocumentAttachment_1()
		throws Exception {
		Template fixture = new Template("", "", "", "", "", "", "", new JSONArray(), new JSONArray(), "");

		JSONArray result = fixture.getDocumentAttachment();

		// add additional test code here
		assertNotNull(result);
		assertEquals(0, result.size());
	}

	/**
	 * Run the JSONArray getEmailContent() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:52 PM
	 */
	@Test
	public void testGetEmailContent_1()
		throws Exception {
		Template fixture = new Template("", "", "", "", "", "", "", new JSONArray(), new JSONArray(), "");

		JSONArray result = fixture.getEmailContent();

		// add additional test code here
		assertNotNull(result);
		assertEquals(0, result.size());
	}

	/**
	 * Run the String getEventDetailUuid() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:52 PM
	 */
	@Test
	public void testGetEventDetailUuid_1()
		throws Exception {
		Template fixture = new Template("", "", "", "", "", "", "", new JSONArray(), new JSONArray(), "");

		String result = fixture.getEventDetailUuid();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the String getModuleCode() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:52 PM
	 */
	@Test
	public void testGetModuleCode_1()
		throws Exception {
		Template fixture = new Template("", "", "", "", "", "", "", new JSONArray(), new JSONArray(), "");

		String result = fixture.getModuleCode();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the String getModuleName() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:52 PM
	 */
	@Test
	public void testGetModuleName_1()
		throws Exception {
		Template fixture = new Template("", "", "", "", "", "", "", new JSONArray(), new JSONArray(), "");

		String result = fixture.getModuleName();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the String getSmsContent() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:52 PM
	 */
	@Test
	public void testGetSmsContent_1()
		throws Exception {
		Template fixture = new Template("", "", "", "", "", "", "", new JSONArray(), new JSONArray(), "");

		String result = fixture.getSmsContent();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the String getTemplateMappedUuid() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:52 PM
	 */
	@Test
	public void testGetTemplateMappedUuid_1()
		throws Exception {
		Template fixture = new Template("", "", "", "", "", "", "", new JSONArray(), new JSONArray(), "");

		String result = fixture.getTemplateMappedUuid();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the String getTemplateType() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:52 PM
	 */
	@Test
	public void testGetTemplateType_1()
		throws Exception {
		Template fixture = new Template("", "", "", "", "", "", "", new JSONArray(), new JSONArray(), "");

		String result = fixture.getTemplateType();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the String getTenantId() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:52 PM
	 */
	@Test
	public void testGetTenantId_1()
		throws Exception {
		Template fixture = new Template("", "", "", "", "", "", "", new JSONArray(), new JSONArray(), "");

		String result = fixture.getTenantId();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the String getTenderNoticeUuid() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:52 PM
	 */
	@Test
	public void testGetTenderNoticeUuid_1()
		throws Exception {
		Template fixture = new Template("", "", "", "", "", "", "", new JSONArray(), new JSONArray(), "");

		String result = fixture.getTenderNoticeUuid();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the void setDocumentAttachment(JSONArray) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:52 PM
	 */
	@Test
	public void testSetDocumentAttachment_1()
		throws Exception {
		Template fixture = new Template("", "", "", "", "", "", "", new JSONArray(), new JSONArray(), "");
		JSONArray documentAttachment = new JSONArray();

		fixture.setDocumentAttachment(documentAttachment);

		// add additional test code here
	}

	/**
	 * Run the void setEmailContent(JSONArray) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:52 PM
	 */
	@Test
	public void testSetEmailContent_1()
		throws Exception {
		Template fixture = new Template("", "", "", "", "", "", "", new JSONArray(), new JSONArray(), "");
		JSONArray emailContent = new JSONArray();

		fixture.setEmailContent(emailContent);

		// add additional test code here
	}

	/**
	 * Run the void setEventDetailUuid(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:52 PM
	 */
	@Test
	public void testSetEventDetailUuid_1()
		throws Exception {
		Template fixture = new Template("", "", "", "", "", "", "", new JSONArray(), new JSONArray(), "");
		String eventDetailUuid = "";

		fixture.setEventDetailUuid(eventDetailUuid);

		// add additional test code here
	}

	/**
	 * Run the void setModuleCode(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:52 PM
	 */
	@Test
	public void testSetModuleCode_1()
		throws Exception {
		Template fixture = new Template("", "", "", "", "", "", "", new JSONArray(), new JSONArray(), "");
		String moduleCode = "";

		fixture.setModuleCode(moduleCode);

		// add additional test code here
	}

	/**
	 * Run the void setModuleName(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:52 PM
	 */
	@Test
	public void testSetModuleName_1()
		throws Exception {
		Template fixture = new Template("", "", "", "", "", "", "", new JSONArray(), new JSONArray(), "");
		String moduleName = "";

		fixture.setModuleName(moduleName);

		// add additional test code here
	}

	/**
	 * Run the void setSmsContent(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:52 PM
	 */
	@Test
	public void testSetSmsContent_1()
		throws Exception {
		Template fixture = new Template("", "", "", "", "", "", "", new JSONArray(), new JSONArray(), "");
		String smsContent = "";

		fixture.setSmsContent(smsContent);

		// add additional test code here
	}

	/**
	 * Run the void setTemplateMappedUuid(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:52 PM
	 */
	@Test
	public void testSetTemplateMappedUuid_1()
		throws Exception {
		Template fixture = new Template("", "", "", "", "", "", "", new JSONArray(), new JSONArray(), "");
		String templateMappedUuid = "";

		fixture.setTemplateMappedUuid(templateMappedUuid);

		// add additional test code here
	}

	/**
	 * Run the void setTemplateType(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:52 PM
	 */
	@Test
	public void testSetTemplateType_1()
		throws Exception {
		Template fixture = new Template("", "", "", "", "", "", "", new JSONArray(), new JSONArray(), "");
		String templateType = "";

		fixture.setTemplateType(templateType);

		// add additional test code here
	}

	/**
	 * Run the void setTenantId(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:52 PM
	 */
	@Test
	public void testSetTenantId_1()
		throws Exception {
		Template fixture = new Template("", "", "", "", "", "", "", new JSONArray(), new JSONArray(), "");
		String tenantId = "";

		fixture.setTenantId(tenantId);

		// add additional test code here
	}

	/**
	 * Run the void setTenderNoticeUuid(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:52 PM
	 */
	@Test
	public void testSetTenderNoticeUuid_1()
		throws Exception {
		Template fixture = new Template("", "", "", "", "", "", "", new JSONArray(), new JSONArray(), "");
		String tenderNoticeUuid = "";

		fixture.setTenderNoticeUuid(tenderNoticeUuid);

		// add additional test code here
	}

	/**
	 * Perform pre-test initialization.
	 *
	 * @throws Exception
	 *         if the initialization fails for some reason
	 *
	 * @generatedBy CodePro at 25/5/20 3:52 PM
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
	 * @generatedBy CodePro at 25/5/20 3:52 PM
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
	 * @generatedBy CodePro at 25/5/20 3:52 PM
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(TemplateTest.class);
	}
}