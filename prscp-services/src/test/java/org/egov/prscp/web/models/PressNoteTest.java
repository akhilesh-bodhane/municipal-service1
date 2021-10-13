package org.egov.prscp.web.models;

import java.util.List;
import org.easymock.EasyMock;
import org.json.simple.JSONArray;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * The class <code>PressNoteTest</code> contains tests for the class <code>{@link PressNote}</code>.
 *
 * @generatedBy CodePro at 25/5/20 3:46 PM
 * @author Aniket.Marathe
 * @version $Revision: 1.0 $
 */
public class PressNoteTest {
	/**
	 * Run the PressNote() constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:46 PM
	 */
	@Test
	public void testPressNote_1()
		throws Exception {

		PressNote result = new PressNote();

		// add additional test code here
		assertNotNull(result);
		assertEquals(null, result.getLastModifiedTime());
		assertEquals(false, result.isActive());
		assertEquals(null, result.getTenantId());
		assertEquals(null, result.getModuleCode());
		assertEquals(null, result.getSmsContent());
		assertEquals(null, result.getFileNumber());
		assertEquals(null, result.getTemplateType());
		assertEquals(null, result.getCreatedBy());
		assertEquals(null, result.getEmailContent());
		assertEquals(null, result.getToDate());
		assertEquals(false, result.isDefaultGrid());
		assertEquals(null, result.getPressNoteUuid());
		assertEquals(null, result.getSourceUuid());
		assertEquals(null, result.getFromDate());
		assertEquals(null, result.getPressNoteDate());
		assertEquals(null, result.getNoteContent());
		assertEquals(null, result.getPublicList());
		assertEquals(null, result.getCreatedTime());
		assertEquals(null, result.getLastModifiedBy());
		assertEquals(null, result.getNotifiactionTemplateUuid());
		assertEquals(null, result.getPublicationList());
		assertEquals(null, result.getPressNoteSubject());
		assertEquals(null, result.getDocumentAttachment());
	}

	/**
	 * Run the PressNote(String,String,String,String,String,JSONArray,String,List<PublicationList>,String,String,boolean,String,String,String,Long,Long,JSONArray,String,String,String,String,boolean,String) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:46 PM
	 */
	@Test
	public void testPressNote_2()
		throws Exception {
		String pressNoteUuid = "";
		String pressNoteSubject = "";
		String pressNoteDate = "";
		String fileNumber = "";
		String noteContent = "";
		JSONArray emailContent = new JSONArray();
		JSONArray noteDocument = new JSONArray();
		String smsContent = "";
		List<PublicationList> publicationList = EasyMock.createMock(List.class);
		String templateType = "";
		String publicList = "";
		boolean isActive = true;
		String tenantId = "";
		String createdBy = "";
		String lastModifiedBy = "";
		Long createdTime = new Long(1L);
		Long lastModifiedTime = new Long(1L);
		JSONArray documentAttachment = new JSONArray();
		String notifiactionTemplateUuid = "";
		String moduleCode = "";
		String fromDate = "";
		String toDate = "";
		boolean defaultGrid = true;
		String sourceUuid = "";
		// add mock object expectations here

		EasyMock.replay(publicationList);

		PressNote result = new PressNote(pressNoteUuid, pressNoteSubject, pressNoteDate, fileNumber, noteContent, emailContent, noteDocument, smsContent, publicationList, templateType, publicList, isActive, tenantId, createdBy, lastModifiedBy, createdTime, lastModifiedTime, documentAttachment, notifiactionTemplateUuid, moduleCode, fromDate, toDate, defaultGrid, sourceUuid);

		// add additional test code here
		EasyMock.verify(publicationList);
		assertNotNull(result);
		assertEquals(new Long(1L), result.getLastModifiedTime());
		assertEquals(true, result.isActive());
		assertEquals("", result.getTenantId());
		assertEquals("", result.getModuleCode());
		assertEquals("", result.getSmsContent());
		assertEquals("", result.getFileNumber());
		assertEquals("", result.getTemplateType());
		assertEquals("", result.getCreatedBy());
		assertEquals("", result.getToDate());
		assertEquals(true, result.isDefaultGrid());
		assertEquals("", result.getPressNoteUuid());
		assertEquals("", result.getSourceUuid());
		assertEquals("", result.getFromDate());
		assertEquals("", result.getPressNoteDate());
		assertEquals("", result.getNoteContent());
		assertEquals("", result.getPublicList());
		assertEquals(new Long(1L), result.getCreatedTime());
		assertEquals("", result.getLastModifiedBy());
		assertEquals("", result.getNotifiactionTemplateUuid());
		assertEquals("", result.getPressNoteSubject());
	}

	/**
	 * Run the PressNote.PressNoteBuilder builder() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:46 PM
	 */
	@Test
	public void testBuilder_1()
		throws Exception {

		PressNote.PressNoteBuilder result = PressNote.builder();

		// add additional test code here
		assertNotNull(result);
		assertEquals("PressNote.PressNoteBuilder(pressNoteUuid=null, pressNoteSubject=null, pressNoteDate=null, fileNumber=null, noteContent=null, noteDocument=null, emailContent=null, smsContent=null, publicationList=null, templateType=null, publicList=null, isActive=false, tenantId=null, createdBy=null, lastModifiedBy=null, createdTime=null, lastModifiedTime=null, documentAttachment=null, notifiactionTemplateUuid=null, moduleCode=null, fromDate=null, toDate=null, defaultGrid=false, sourceUuid=null)", result.toString());
	}

	/**
	 * Run the String getCreatedBy() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:46 PM
	 */
	@Test
	public void testGetCreatedBy_1()
		throws Exception {
		PressNote fixture = new PressNote("", "", "", "", "", new JSONArray(), new JSONArray(),"", EasyMock.createNiceMock(List.class), "", "", true, "", "", "", new Long(1L), new Long(1L), new JSONArray(), "", "", "", "", true, "");

		String result = fixture.getCreatedBy();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the Long getCreatedTime() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:46 PM
	 */
	@Test
	public void testGetCreatedTime_1()
		throws Exception {
		PressNote fixture = new PressNote("", "", "", "", "", new JSONArray(),new JSONArray(), "", EasyMock.createNiceMock(List.class), "", "", true, "", "", "", new Long(1L), new Long(1L), new JSONArray(), "", "", "", "", true, "");

		Long result = fixture.getCreatedTime();

		// add additional test code here
		assertNotNull(result);
		assertEquals("1", result.toString());
		assertEquals((byte) 1, result.byteValue());
		assertEquals((short) 1, result.shortValue());
		assertEquals(1, result.intValue());
		assertEquals(1L, result.longValue());
		assertEquals(1.0f, result.floatValue(), 1.0f);
		assertEquals(1.0, result.doubleValue(), 1.0);
	}

	/**
	 * Run the JSONArray getDocumentAttachment() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:46 PM
	 */
	@Test
	public void testGetDocumentAttachment_1()
		throws Exception {
		PressNote fixture = new PressNote("", "", "", "", "", new JSONArray(),new JSONArray(), "", EasyMock.createNiceMock(List.class), "", "", true, "", "", "", new Long(1L), new Long(1L), new JSONArray(), "", "", "", "", true, "");

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
	 * @generatedBy CodePro at 25/5/20 3:46 PM
	 */
	@Test
	public void testGetEmailContent_1()
		throws Exception {
		PressNote fixture = new PressNote("", "", "", "", "", new JSONArray(),new JSONArray(), "", EasyMock.createNiceMock(List.class), "", "", true, "", "", "", new Long(1L), new Long(1L), new JSONArray(), "", "", "", "", true, "");

		JSONArray result = fixture.getEmailContent();

		// add additional test code here
		assertNotNull(result);
		assertEquals(0, result.size());
	}

	/**
	 * Run the String getFileNumber() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:46 PM
	 */
	@Test
	public void testGetFileNumber_1()
		throws Exception {
		PressNote fixture = new PressNote("", "", "", "", "", new JSONArray(), new JSONArray(),"", EasyMock.createNiceMock(List.class), "", "", true, "", "", "", new Long(1L), new Long(1L), new JSONArray(), "", "", "", "", true, "");

		String result = fixture.getFileNumber();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the String getFromDate() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:46 PM
	 */
	@Test
	public void testGetFromDate_1()
		throws Exception {
		PressNote fixture = new PressNote("", "", "", "", "", new JSONArray(), new JSONArray(),"", EasyMock.createNiceMock(List.class), "", "", true, "", "", "", new Long(1L), new Long(1L), new JSONArray(), "", "", "", "", true, "");

		String result = fixture.getFromDate();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the String getLastModifiedBy() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:46 PM
	 */
	@Test
	public void testGetLastModifiedBy_1()
		throws Exception {
		PressNote fixture = new PressNote("", "", "", "", "", new JSONArray(),new JSONArray(), "", EasyMock.createNiceMock(List.class), "", "", true, "", "", "", new Long(1L), new Long(1L), new JSONArray(), "", "", "", "", true, "");

		String result = fixture.getLastModifiedBy();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the Long getLastModifiedTime() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:46 PM
	 */
	@Test
	public void testGetLastModifiedTime_1()
		throws Exception {
		PressNote fixture = new PressNote("", "", "", "", "", new JSONArray(),new JSONArray(), "", EasyMock.createNiceMock(List.class), "", "", true, "", "", "", new Long(1L), new Long(1L), new JSONArray(), "", "", "", "", true, "");

		Long result = fixture.getLastModifiedTime();

		// add additional test code here
		assertNotNull(result);
		assertEquals("1", result.toString());
		assertEquals((byte) 1, result.byteValue());
		assertEquals((short) 1, result.shortValue());
		assertEquals(1, result.intValue());
		assertEquals(1L, result.longValue());
		assertEquals(1.0f, result.floatValue(), 1.0f);
		assertEquals(1.0, result.doubleValue(), 1.0);
	}

	/**
	 * Run the String getModuleCode() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:46 PM
	 */
	@Test
	public void testGetModuleCode_1()
		throws Exception {
		PressNote fixture = new PressNote("", "", "", "", "", new JSONArray(),new JSONArray(), "", EasyMock.createNiceMock(List.class), "", "", true, "", "", "", new Long(1L), new Long(1L), new JSONArray(), "", "", "", "", true, "");

		String result = fixture.getModuleCode();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the String getNoteContent() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:46 PM
	 */
	@Test
	public void testGetNoteContent_1()
		throws Exception {
		PressNote fixture = new PressNote("", "", "", "", "", new JSONArray(),new JSONArray(), "", EasyMock.createNiceMock(List.class), "", "", true, "", "", "", new Long(1L), new Long(1L), new JSONArray(), "", "", "", "", true, "");

		String result = fixture.getNoteContent();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the String getNotifiactionTemplateUuid() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:46 PM
	 */
	@Test
	public void testGetNotifiactionTemplateUuid_1()
		throws Exception {
		PressNote fixture = new PressNote("", "", "", "", "", new JSONArray(),new JSONArray(), "", EasyMock.createNiceMock(List.class), "", "", true, "", "", "", new Long(1L), new Long(1L), new JSONArray(), "", "", "", "", true, "");

		String result = fixture.getNotifiactionTemplateUuid();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the String getPressNoteDate() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:46 PM
	 */
	@Test
	public void testGetPressNoteDate_1()
		throws Exception {
		PressNote fixture = new PressNote("", "", "", "", "", new JSONArray(),new JSONArray(), "", EasyMock.createNiceMock(List.class), "", "", true, "", "", "", new Long(1L), new Long(1L), new JSONArray(), "", "", "", "", true, "");

		String result = fixture.getPressNoteDate();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the String getPressNoteSubject() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:46 PM
	 */
	@Test
	public void testGetPressNoteSubject_1()
		throws Exception {
		PressNote fixture = new PressNote("", "", "", "", "", new JSONArray(), new JSONArray(),"", EasyMock.createNiceMock(List.class), "", "", true, "", "", "", new Long(1L), new Long(1L), new JSONArray(), "", "", "", "", true, "");

		String result = fixture.getPressNoteSubject();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the String getPressNoteUuid() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:46 PM
	 */
	@Test
	public void testGetPressNoteUuid_1()
		throws Exception {
		PressNote fixture = new PressNote("", "", "", "", "", new JSONArray(), new JSONArray(),"", EasyMock.createNiceMock(List.class), "", "", true, "", "", "", new Long(1L), new Long(1L), new JSONArray(), "", "", "", "", true, "");

		String result = fixture.getPressNoteUuid();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the String getPublicList() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:46 PM
	 */
	@Test
	public void testGetPublicList_1()
		throws Exception {
		PressNote fixture = new PressNote("", "", "", "", "", new JSONArray(), new JSONArray(),"", EasyMock.createNiceMock(List.class), "", "", true, "", "", "", new Long(1L), new Long(1L), new JSONArray(), "", "", "", "", true, "");

		String result = fixture.getPublicList();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the List<PublicationList> getPublicationList() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:46 PM
	 */
	@Test
	public void testGetPublicationList_1()
		throws Exception {
		PressNote fixture = new PressNote("", "", "", "", "", new JSONArray(),new JSONArray(), "", EasyMock.createNiceMock(List.class), "", "", true, "", "", "", new Long(1L), new Long(1L), new JSONArray(), "", "", "", "", true, "");

		List<PublicationList> result = fixture.getPublicationList();

		// add additional test code here
		assertNotNull(result);
		assertEquals(0, result.size());
	}

	/**
	 * Run the String getSmsContent() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:46 PM
	 */
	@Test
	public void testGetSmsContent_1()
		throws Exception {
		PressNote fixture = new PressNote("", "", "", "", "", new JSONArray(),new JSONArray(), "", EasyMock.createNiceMock(List.class), "", "", true, "", "", "", new Long(1L), new Long(1L), new JSONArray(), "", "", "", "", true, "");

		String result = fixture.getSmsContent();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the String getSourceUuid() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:46 PM
	 */
	@Test
	public void testGetSourceUuid_1()
		throws Exception {
		PressNote fixture = new PressNote("", "", "", "", "", new JSONArray(),new JSONArray(), "", EasyMock.createNiceMock(List.class), "", "", true, "", "", "", new Long(1L), new Long(1L), new JSONArray(), "", "", "", "", true, "");

		String result = fixture.getSourceUuid();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the String getTemplateType() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:46 PM
	 */
	@Test
	public void testGetTemplateType_1()
		throws Exception {
		PressNote fixture = new PressNote("", "", "", "", "", new JSONArray(),new JSONArray(), "", EasyMock.createNiceMock(List.class), "", "", true, "", "", "", new Long(1L), new Long(1L), new JSONArray(), "", "", "", "", true, "");

		String result = fixture.getTemplateType();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the String getTenantId() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:46 PM
	 */
	@Test
	public void testGetTenantId_1()
		throws Exception {
		PressNote fixture = new PressNote("", "", "", "", "", new JSONArray(),new JSONArray(), "", EasyMock.createNiceMock(List.class), "", "", true, "", "", "", new Long(1L), new Long(1L), new JSONArray(), "", "", "", "", true, "");

		String result = fixture.getTenantId();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the String getToDate() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:46 PM
	 */
	@Test
	public void testGetToDate_1()
		throws Exception {
		PressNote fixture = new PressNote("", "", "", "", "", new JSONArray(), new JSONArray(),"", EasyMock.createNiceMock(List.class), "", "", true, "", "", "", new Long(1L), new Long(1L), new JSONArray(), "", "", "", "", true, "");

		String result = fixture.getToDate();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the boolean isActive() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:46 PM
	 */
	@Test
	public void testIsActive_1()
		throws Exception {
		PressNote fixture = new PressNote("", "", "", "", "", new JSONArray(),new JSONArray(), "", EasyMock.createNiceMock(List.class), "", "", true, "", "", "", new Long(1L), new Long(1L), new JSONArray(), "", "", "", "", true, "");

		boolean result = fixture.isActive();

		// add additional test code here
		assertEquals(true, result);
	}

	/**
	 * Run the boolean isActive() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:46 PM
	 */
	@Test
	public void testIsActive_2()
		throws Exception {
		PressNote fixture = new PressNote("", "", "", "", "", new JSONArray(), new JSONArray(),"", EasyMock.createNiceMock(List.class), "", "", false, "", "", "", new Long(1L), new Long(1L), new JSONArray(), "", "", "", "", true, "");

		boolean result = fixture.isActive();

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the boolean isDefaultGrid() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:46 PM
	 */
	@Test
	public void testIsDefaultGrid_1()
		throws Exception {
		PressNote fixture = new PressNote("", "", "", "", "", new JSONArray(),new JSONArray(), "", EasyMock.createNiceMock(List.class), "", "", true, "", "", "", new Long(1L), new Long(1L), new JSONArray(), "", "", "", "", true, "");

		boolean result = fixture.isDefaultGrid();

		// add additional test code here
		assertEquals(true, result);
	}

	/**
	 * Run the boolean isDefaultGrid() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:46 PM
	 */
	@Test
	public void testIsDefaultGrid_2()
		throws Exception {
		PressNote fixture = new PressNote("", "", "", "", "", new JSONArray(),new JSONArray(), "", EasyMock.createNiceMock(List.class), "", "", true, "", "", "", new Long(1L), new Long(1L), new JSONArray(), "", "", "", "", false, "");

		boolean result = fixture.isDefaultGrid();

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the void setActive(boolean) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:46 PM
	 */
	@Test
	public void testSetActive_1()
		throws Exception {
		PressNote fixture = new PressNote("", "", "", "", "", new JSONArray(), new JSONArray(),"", EasyMock.createNiceMock(List.class), "", "", true, "", "", "", new Long(1L), new Long(1L), new JSONArray(), "", "", "", "", true, "");
		boolean isActive = true;

		fixture.setActive(isActive);

		// add additional test code here
	}

	/**
	 * Run the void setCreatedBy(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:46 PM
	 */
	@Test
	public void testSetCreatedBy_1()
		throws Exception {
		PressNote fixture = new PressNote("", "", "", "", "", new JSONArray(),new JSONArray(), "", EasyMock.createNiceMock(List.class), "", "", true, "", "", "", new Long(1L), new Long(1L), new JSONArray(), "", "", "", "", true, "");
		String createdBy = "";

		fixture.setCreatedBy(createdBy);

		// add additional test code here
	}

	/**
	 * Run the void setCreatedTime(Long) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:46 PM
	 */
	@Test
	public void testSetCreatedTime_1()
		throws Exception {
		PressNote fixture = new PressNote("", "", "", "", "", new JSONArray(),new JSONArray(), "", EasyMock.createNiceMock(List.class), "", "", true, "", "", "", new Long(1L), new Long(1L), new JSONArray(), "", "", "", "", true, "");
		Long createdTime = new Long(1L);

		fixture.setCreatedTime(createdTime);

		// add additional test code here
	}

	/**
	 * Run the void setDefaultGrid(boolean) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:46 PM
	 */
	@Test
	public void testSetDefaultGrid_1()
		throws Exception {
		PressNote fixture = new PressNote("", "", "", "", "", new JSONArray(), new JSONArray(),"", EasyMock.createNiceMock(List.class), "", "", true, "", "", "", new Long(1L), new Long(1L), new JSONArray(), "", "", "", "", true, "");
		boolean defaultGrid = true;

		fixture.setDefaultGrid(defaultGrid);

		// add additional test code here
	}

	/**
	 * Run the void setDocumentAttachment(JSONArray) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:46 PM
	 */
	@Test
	public void testSetDocumentAttachment_1()
		throws Exception {
		PressNote fixture = new PressNote("", "", "", "", "", new JSONArray(),new JSONArray(), "", EasyMock.createNiceMock(List.class), "", "", true, "", "", "", new Long(1L), new Long(1L), new JSONArray(), "", "", "", "", true, "");
		JSONArray documentAttachment = new JSONArray();

		fixture.setDocumentAttachment(documentAttachment);

		// add additional test code here
	}

	/**
	 * Run the void setEmailContent(JSONArray) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:46 PM
	 */
	@Test
	public void testSetEmailContent_1()
		throws Exception {
		PressNote fixture = new PressNote("", "", "", "", "", new JSONArray(),new JSONArray(), "", EasyMock.createNiceMock(List.class), "", "", true, "", "", "", new Long(1L), new Long(1L), new JSONArray(), "", "", "", "", true, "");
		JSONArray emailContent = new JSONArray();

		fixture.setEmailContent(emailContent);

		// add additional test code here
	}

	/**
	 * Run the void setFileNumber(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:46 PM
	 */
	@Test
	public void testSetFileNumber_1()
		throws Exception {
		PressNote fixture = new PressNote("", "", "", "", "", new JSONArray(),new JSONArray(), "", EasyMock.createNiceMock(List.class), "", "", true, "", "", "", new Long(1L), new Long(1L), new JSONArray(), "", "", "", "", true, "");
		String fileNumber = "";

		fixture.setFileNumber(fileNumber);

		// add additional test code here
	}

	/**
	 * Run the void setFromDate(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:46 PM
	 */
	@Test
	public void testSetFromDate_1()
		throws Exception {
		PressNote fixture = new PressNote("", "", "", "", "", new JSONArray(),new JSONArray(), "", EasyMock.createNiceMock(List.class), "", "", true, "", "", "", new Long(1L), new Long(1L), new JSONArray(), "", "", "", "", true, "");
		String fromDate = "";

		fixture.setFromDate(fromDate);

		// add additional test code here
	}

	/**
	 * Run the void setLastModifiedBy(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:46 PM
	 */
	@Test
	public void testSetLastModifiedBy_1()
		throws Exception {
		PressNote fixture = new PressNote("", "", "", "", "", new JSONArray(),new JSONArray(), "", EasyMock.createNiceMock(List.class), "", "", true, "", "", "", new Long(1L), new Long(1L), new JSONArray(), "", "", "", "", true, "");
		String lastModifiedBy = "";

		fixture.setLastModifiedBy(lastModifiedBy);

		// add additional test code here
	}

	/**
	 * Run the void setLastModifiedTime(Long) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:46 PM
	 */
	@Test
	public void testSetLastModifiedTime_1()
		throws Exception {
		PressNote fixture = new PressNote("", "", "", "", "", new JSONArray(),new JSONArray(), "", EasyMock.createNiceMock(List.class), "", "", true, "", "", "", new Long(1L), new Long(1L), new JSONArray(), "", "", "", "", true, "");
		Long lastModifiedTime = new Long(1L);

		fixture.setLastModifiedTime(lastModifiedTime);

		// add additional test code here
	}

	/**
	 * Run the void setModuleCode(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:46 PM
	 */
	@Test
	public void testSetModuleCode_1()
		throws Exception {
		PressNote fixture = new PressNote("", "", "", "", "", new JSONArray(),new JSONArray(), "", EasyMock.createNiceMock(List.class), "", "", true, "", "", "", new Long(1L), new Long(1L), new JSONArray(), "", "", "", "", true, "");
		String moduleCode = "";

		fixture.setModuleCode(moduleCode);

		// add additional test code here
	}

	/**
	 * Run the void setNoteContent(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:46 PM
	 */
	@Test
	public void testSetNoteContent_1()
		throws Exception {
		PressNote fixture = new PressNote("", "", "", "", "", new JSONArray(), new JSONArray(),"", EasyMock.createNiceMock(List.class), "", "", true, "", "", "", new Long(1L), new Long(1L), new JSONArray(), "", "", "", "", true, "");
		String noteContent = "";

		fixture.setNoteContent(noteContent);

		// add additional test code here
	}

	/**
	 * Run the void setNotifiactionTemplateUuid(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:46 PM
	 */
	@Test
	public void testSetNotifiactionTemplateUuid_1()
		throws Exception {
		PressNote fixture = new PressNote("", "", "", "", "", new JSONArray(),new JSONArray(), "", EasyMock.createNiceMock(List.class), "", "", true, "", "", "", new Long(1L), new Long(1L), new JSONArray(), "", "", "", "", true, "");
		String notifiactionTemplateUuid = "";

		fixture.setNotifiactionTemplateUuid(notifiactionTemplateUuid);

		// add additional test code here
	}

	/**
	 * Run the void setPressNoteDate(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:46 PM
	 */
	@Test
	public void testSetPressNoteDate_1()
		throws Exception {
		PressNote fixture = new PressNote("", "", "", "", "", new JSONArray(),new JSONArray(), "", EasyMock.createNiceMock(List.class), "", "", true, "", "", "", new Long(1L), new Long(1L), new JSONArray(), "", "", "", "", true, "");
		String pressNoteDate = "";

		fixture.setPressNoteDate(pressNoteDate);

		// add additional test code here
	}

	/**
	 * Run the void setPressNoteSubject(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:46 PM
	 */
	@Test
	public void testSetPressNoteSubject_1()
		throws Exception {
		PressNote fixture = new PressNote("", "", "", "", "", new JSONArray(),new JSONArray(), "", EasyMock.createNiceMock(List.class), "", "", true, "", "", "", new Long(1L), new Long(1L), new JSONArray(), "", "", "", "", true, "");
		String pressNoteSubject = "";

		fixture.setPressNoteSubject(pressNoteSubject);

		// add additional test code here
	}

	/**
	 * Run the void setPressNoteUuid(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:46 PM
	 */
	@Test
	public void testSetPressNoteUuid_1()
		throws Exception {
		PressNote fixture = new PressNote("", "", "", "", "", new JSONArray(),new JSONArray(), "", EasyMock.createNiceMock(List.class), "", "", true, "", "", "", new Long(1L), new Long(1L), new JSONArray(), "", "", "", "", true, "");
		String pressNoteUuid = "";

		fixture.setPressNoteUuid(pressNoteUuid);

		// add additional test code here
	}

	/**
	 * Run the void setPublicList(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:46 PM
	 */
	@Test
	public void testSetPublicList_1()
		throws Exception {
		PressNote fixture = new PressNote("", "", "", "", "", new JSONArray(),new JSONArray(), "", EasyMock.createNiceMock(List.class), "", "", true, "", "", "", new Long(1L), new Long(1L), new JSONArray(), "", "", "", "", true, "");
		String publicList = "";

		fixture.setPublicList(publicList);

		// add additional test code here
	}

	/**
	 * Run the void setPublicationList(List<PublicationList>) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:46 PM
	 */
	@Test
	public void testSetPublicationList_1()
		throws Exception {
		PressNote fixture = new PressNote("", "", "", "", "", new JSONArray(),new JSONArray(), "", EasyMock.createNiceMock(List.class), "", "", true, "", "", "", new Long(1L), new Long(1L), new JSONArray(), "", "", "", "", true, "");
		List<PublicationList> publicationList = EasyMock.createMock(List.class);
		// add mock object expectations here

		EasyMock.replay(publicationList);

		fixture.setPublicationList(publicationList);

		// add additional test code here
		EasyMock.verify(publicationList);
	}

	/**
	 * Run the void setSmsContent(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:46 PM
	 */
	@Test
	public void testSetSmsContent_1()
		throws Exception {
		PressNote fixture = new PressNote("", "", "", "", "", new JSONArray(),new JSONArray(), "", EasyMock.createNiceMock(List.class), "", "", true, "", "", "", new Long(1L), new Long(1L), new JSONArray(), "", "", "", "", true, "");
		String smsContent = "";

		fixture.setSmsContent(smsContent);

		// add additional test code here
	}

	/**
	 * Run the void setSourceUuid(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:46 PM
	 */
	@Test
	public void testSetSourceUuid_1()
		throws Exception {
		PressNote fixture = new PressNote("", "", "", "", "", new JSONArray(),new JSONArray(),"", EasyMock.createNiceMock(List.class), "", "", true, "", "", "", new Long(1L), new Long(1L), new JSONArray(), "", "", "", "", true, "");
		String sourceUuid = "";

		fixture.setSourceUuid(sourceUuid);

		// add additional test code here
	}

	/**
	 * Run the void setTemplateType(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:46 PM
	 */
	@Test
	public void testSetTemplateType_1()
		throws Exception {
		PressNote fixture = new PressNote("", "", "", "", "", new JSONArray(), new JSONArray(),"", EasyMock.createNiceMock(List.class), "", "", true, "", "", "", new Long(1L), new Long(1L), new JSONArray(), "", "", "", "", true, "");
		String templateType = "";

		fixture.setTemplateType(templateType);

		// add additional test code here
	}

	/**
	 * Run the void setTenantId(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:46 PM
	 */
	@Test
	public void testSetTenantId_1()
		throws Exception {
		PressNote fixture = new PressNote("", "", "", "", "", new JSONArray(),new JSONArray(), "", EasyMock.createNiceMock(List.class), "", "", true, "", "", "", new Long(1L), new Long(1L), new JSONArray(), "", "", "", "", true, "");
		String tenantId = "";

		fixture.setTenantId(tenantId);

		// add additional test code here
	}

	/**
	 * Run the void setToDate(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:46 PM
	 */
	@Test
	public void testSetToDate_1()
		throws Exception {
		PressNote fixture = new PressNote("", "", "", "", "", new JSONArray(), new JSONArray(),"", EasyMock.createNiceMock(List.class), "", "", true, "", "", "", new Long(1L), new Long(1L), new JSONArray(), "", "", "", "", true, "");
		String toDate = "";

		fixture.setToDate(toDate);

		// add additional test code here
	}

	/**
	 * Perform pre-test initialization.
	 *
	 * @throws Exception
	 *         if the initialization fails for some reason
	 *
	 * @generatedBy CodePro at 25/5/20 3:46 PM
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
	 * @generatedBy CodePro at 25/5/20 3:46 PM
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
	 * @generatedBy CodePro at 25/5/20 3:46 PM
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(PressNoteTest.class);
	}
}