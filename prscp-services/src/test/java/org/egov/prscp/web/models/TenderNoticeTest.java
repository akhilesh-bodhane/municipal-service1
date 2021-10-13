package org.egov.prscp.web.models;

import java.util.ArrayList;
import java.util.List;
import org.easymock.EasyMock;
import org.json.simple.JSONArray;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * The class <code>TenderNoticeTest</code> contains tests for the class <code>{@link TenderNotice}</code>.
 *
 * @generatedBy CodePro at 25/5/20 3:51 PM
 * @author Aniket.Marathe
 * @version $Revision: 1.0 $
 */
public class TenderNoticeTest {
	/**
	 * Run the TenderNotice() constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:51 PM
	 */
	@Test
	public void testTenderNotice_1()
		throws Exception {

		TenderNotice result = new TenderNotice();

		// add additional test code here
		assertNotNull(result);
		assertEquals(null, result.getLastModifiedTime());
		assertEquals(false, result.isActive());
		assertEquals(null, result.getModuleCode());
		assertEquals(null, result.getTenantId());
		assertEquals(null, result.getSmsContent());
		assertEquals(null, result.getTenderSubject());
		assertEquals(null, result.getFileNumber());
		assertEquals(null, result.getTenderDetail());
		assertEquals(null, result.getUserType());
		assertEquals(null, result.getTenderDate());
		assertEquals(null, result.getCreatedByName());
		assertEquals(null, result.getCreatedBy());
		assertEquals(null, result.getFromDate());
		assertEquals(null, result.getCreatedTime());
		assertEquals(false, result.isDefaultGrid());
		assertEquals(null, result.getToDate());
		assertEquals(null, result.getSourceUuid());
		assertEquals(null, result.getNoteContent());
		assertEquals(null, result.getPublicationList());
		assertEquals(null, result.getEmailContentData());
		assertEquals(null, result.getLastModifiedBy());
		assertEquals(null, result.getTenderDocument());
		assertEquals(null, result.getPublicationSize());
		assertEquals(null, result.getTenderNoticeUuid());
		assertEquals(null, result.getEmailContentJson());
		assertEquals(null, result.getTenderNoticeId());
		assertEquals(null, result.getTenderDocumentList());
		assertEquals(null, result.getNotificationTemplateList());
		assertEquals(null, result.getNotificationTemplateUuid());
		assertEquals(null, result.getTenderNoticeStatus());
	}

	/**
	 * Run the TenderNotice(String,String,String,String,String,String,String,String,boolean,String,String,String,String,String,String,Long,Long,String,JSONArray,String,String,List<PublicationList>,JSONArray,String,String,ArrayList<NotificationTemplate>,String,String,boolean,String) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:51 PM
	 */
	@Test
	public void testTenderNotice_2()
		throws Exception {
		String tenderNoticeUuid = "";
		String tenderSubject = "";
		String tenderDate = "";
		String fileNumber = "";
		String tenderDetail = "";
		String publicationSize = "";
		String userType = "";
		String tenderNoticeStatus = "";
		boolean isActive = true;
		String tenantId = "";
		String tenderNoticeId = "";
		String createdBy = "";
		String createdByName = "";
		String notificationTemplateUuid = "";
		String lastModifiedBy = "";
		Long createdTime = new Long(1L);
		Long lastModifiedTime = new Long(1L);
		String noteContent = "";
		JSONArray tenderDocument = new JSONArray();
		String tenderDocumentList = "";
		String moduleCode = "";
		List<PublicationList> publicationList = EasyMock.createMock(List.class);
		JSONArray emailContentJson = new JSONArray();
		String emailContentData = "";
		String smsContent = "";
		ArrayList<NotificationTemplate> notificationTemplateList = new ArrayList();
		String fromDate = "";
		String toDate = "";
		boolean defaultGrid = true;
		String sourceUuid = "";
		// add mock object expectations here

		EasyMock.replay(publicationList);

		TenderNotice result = new TenderNotice(tenderNoticeUuid, tenderSubject, tenderDate, fileNumber, tenderDetail, publicationSize, userType, tenderNoticeStatus, isActive, tenantId, tenderNoticeId, createdBy, createdByName, notificationTemplateUuid, lastModifiedBy, createdTime, lastModifiedTime, noteContent, tenderDocument, tenderDocumentList, moduleCode, publicationList, emailContentJson, emailContentData, smsContent, notificationTemplateList, fromDate, toDate, defaultGrid, sourceUuid);

		// add additional test code here
		EasyMock.verify(publicationList);
		assertNotNull(result);
		assertEquals(new Long(1L), result.getLastModifiedTime());
		assertEquals(true, result.isActive());
		assertEquals("", result.getModuleCode());
		assertEquals("", result.getTenantId());
		assertEquals("", result.getSmsContent());
		assertEquals("", result.getTenderSubject());
		assertEquals("", result.getFileNumber());
		assertEquals("", result.getTenderDetail());
		assertEquals("", result.getUserType());
		assertEquals("", result.getTenderDate());
		assertEquals("", result.getCreatedByName());
		assertEquals("", result.getCreatedBy());
		assertEquals("", result.getFromDate());
		assertEquals(new Long(1L), result.getCreatedTime());
		assertEquals(true, result.isDefaultGrid());
		assertEquals("", result.getToDate());
		assertEquals("", result.getSourceUuid());
		assertEquals("", result.getNoteContent());
		assertEquals("", result.getEmailContentData());
		assertEquals("", result.getLastModifiedBy());
		assertEquals("", result.getPublicationSize());
		assertEquals("", result.getTenderNoticeUuid());
		assertEquals("", result.getTenderNoticeId());
		assertEquals("", result.getTenderDocumentList());
		assertEquals("", result.getNotificationTemplateUuid());
		assertEquals("", result.getTenderNoticeStatus());
	}

	/**
	 * Run the TenderNotice.TenderNoticeBuilder builder() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:51 PM
	 */
	@Test
	public void testBuilder_1()
		throws Exception {

		TenderNotice.TenderNoticeBuilder result = TenderNotice.builder();

		// add additional test code here
		assertNotNull(result);
		assertEquals("TenderNotice.TenderNoticeBuilder(tenderNoticeUuid=null, tenderSubject=null, tenderDate=null, fileNumber=null, tenderDetail=null, publicationSize=null, userType=null, tenderNoticeStatus=null, isActive=false, tenantId=null, tenderNoticeId=null, createdBy=null, createdByName=null, notificationTemplateUuid=null, lastModifiedBy=null, createdTime=null, lastModifiedTime=null, noteContent=null, tenderDocument=null, tenderDocumentList=null, moduleCode=null, publicationList=null, emailContentJson=null, emailContentData=null, smsContent=null, notificationTemplateList=null, fromDate=null, toDate=null, defaultGrid=false, sourceUuid=null)", result.toString());
	}

	/**
	 * Run the String getCreatedBy() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:51 PM
	 */
	@Test
	public void testGetCreatedBy_1()
		throws Exception {
		TenderNotice fixture = new TenderNotice("", "", "", "", "", "", "", "", true, "", "", "", "", "", "", new Long(1L), new Long(1L), "", new JSONArray(), "", "", EasyMock.createNiceMock(List.class), new JSONArray(), "", "", new ArrayList(), "", "", true, "");

		String result = fixture.getCreatedBy();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the String getCreatedByName() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:51 PM
	 */
	@Test
	public void testGetCreatedByName_1()
		throws Exception {
		TenderNotice fixture = new TenderNotice("", "", "", "", "", "", "", "", true, "", "", "", "", "", "", new Long(1L), new Long(1L), "", new JSONArray(), "", "", EasyMock.createNiceMock(List.class), new JSONArray(), "", "", new ArrayList(), "", "", true, "");

		String result = fixture.getCreatedByName();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the Long getCreatedTime() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:51 PM
	 */
	@Test
	public void testGetCreatedTime_1()
		throws Exception {
		TenderNotice fixture = new TenderNotice("", "", "", "", "", "", "", "", true, "", "", "", "", "", "", new Long(1L), new Long(1L), "", new JSONArray(), "", "", EasyMock.createNiceMock(List.class), new JSONArray(), "", "", new ArrayList(), "", "", true, "");

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
	 * Run the String getEmailContentData() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:51 PM
	 */
	@Test
	public void testGetEmailContentData_1()
		throws Exception {
		TenderNotice fixture = new TenderNotice("", "", "", "", "", "", "", "", true, "", "", "", "", "", "", new Long(1L), new Long(1L), "", new JSONArray(), "", "", EasyMock.createNiceMock(List.class), new JSONArray(), "", "", new ArrayList(), "", "", true, "");

		String result = fixture.getEmailContentData();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the JSONArray getEmailContentJson() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:51 PM
	 */
	@Test
	public void testGetEmailContentJson_1()
		throws Exception {
		TenderNotice fixture = new TenderNotice("", "", "", "", "", "", "", "", true, "", "", "", "", "", "", new Long(1L), new Long(1L), "", new JSONArray(), "", "", EasyMock.createNiceMock(List.class), new JSONArray(), "", "", new ArrayList(), "", "", true, "");

		JSONArray result = fixture.getEmailContentJson();

		// add additional test code here
		assertNotNull(result);
		assertEquals(0, result.size());
	}

	/**
	 * Run the String getFileNumber() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:51 PM
	 */
	@Test
	public void testGetFileNumber_1()
		throws Exception {
		TenderNotice fixture = new TenderNotice("", "", "", "", "", "", "", "", true, "", "", "", "", "", "", new Long(1L), new Long(1L), "", new JSONArray(), "", "", EasyMock.createNiceMock(List.class), new JSONArray(), "", "", new ArrayList(), "", "", true, "");

		String result = fixture.getFileNumber();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the String getFromDate() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:51 PM
	 */
	@Test
	public void testGetFromDate_1()
		throws Exception {
		TenderNotice fixture = new TenderNotice("", "", "", "", "", "", "", "", true, "", "", "", "", "", "", new Long(1L), new Long(1L), "", new JSONArray(), "", "", EasyMock.createNiceMock(List.class), new JSONArray(), "", "", new ArrayList(), "", "", true, "");

		String result = fixture.getFromDate();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the String getLastModifiedBy() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:51 PM
	 */
	@Test
	public void testGetLastModifiedBy_1()
		throws Exception {
		TenderNotice fixture = new TenderNotice("", "", "", "", "", "", "", "", true, "", "", "", "", "", "", new Long(1L), new Long(1L), "", new JSONArray(), "", "", EasyMock.createNiceMock(List.class), new JSONArray(), "", "", new ArrayList(), "", "", true, "");

		String result = fixture.getLastModifiedBy();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the Long getLastModifiedTime() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:51 PM
	 */
	@Test
	public void testGetLastModifiedTime_1()
		throws Exception {
		TenderNotice fixture = new TenderNotice("", "", "", "", "", "", "", "", true, "", "", "", "", "", "", new Long(1L), new Long(1L), "", new JSONArray(), "", "", EasyMock.createNiceMock(List.class), new JSONArray(), "", "", new ArrayList(), "", "", true, "");

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
	 * @generatedBy CodePro at 25/5/20 3:51 PM
	 */
	@Test
	public void testGetModuleCode_1()
		throws Exception {
		TenderNotice fixture = new TenderNotice("", "", "", "", "", "", "", "", true, "", "", "", "", "", "", new Long(1L), new Long(1L), "", new JSONArray(), "", "", EasyMock.createNiceMock(List.class), new JSONArray(), "", "", new ArrayList(), "", "", true, "");

		String result = fixture.getModuleCode();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the String getNoteContent() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:51 PM
	 */
	@Test
	public void testGetNoteContent_1()
		throws Exception {
		TenderNotice fixture = new TenderNotice("", "", "", "", "", "", "", "", true, "", "", "", "", "", "", new Long(1L), new Long(1L), "", new JSONArray(), "", "", EasyMock.createNiceMock(List.class), new JSONArray(), "", "", new ArrayList(), "", "", true, "");

		String result = fixture.getNoteContent();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the ArrayList<NotificationTemplate> getNotificationTemplateList() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:51 PM
	 */
	@Test
	public void testGetNotificationTemplateList_1()
		throws Exception {
		TenderNotice fixture = new TenderNotice("", "", "", "", "", "", "", "", true, "", "", "", "", "", "", new Long(1L), new Long(1L), "", new JSONArray(), "", "", EasyMock.createNiceMock(List.class), new JSONArray(), "", "", new ArrayList(), "", "", true, "");

		ArrayList<NotificationTemplate> result = fixture.getNotificationTemplateList();

		// add additional test code here
		assertNotNull(result);
		assertEquals(0, result.size());
	}

	/**
	 * Run the String getNotificationTemplateUuid() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:51 PM
	 */
	@Test
	public void testGetNotificationTemplateUuid_1()
		throws Exception {
		TenderNotice fixture = new TenderNotice("", "", "", "", "", "", "", "", true, "", "", "", "", "", "", new Long(1L), new Long(1L), "", new JSONArray(), "", "", EasyMock.createNiceMock(List.class), new JSONArray(), "", "", new ArrayList(), "", "", true, "");

		String result = fixture.getNotificationTemplateUuid();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the List<PublicationList> getPublicationList() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:51 PM
	 */
	@Test
	public void testGetPublicationList_1()
		throws Exception {
		TenderNotice fixture = new TenderNotice("", "", "", "", "", "", "", "", true, "", "", "", "", "", "", new Long(1L), new Long(1L), "", new JSONArray(), "", "", EasyMock.createNiceMock(List.class), new JSONArray(), "", "", new ArrayList(), "", "", true, "");

		List<PublicationList> result = fixture.getPublicationList();

		// add additional test code here
		assertNotNull(result);
		assertEquals(0, result.size());
	}

	/**
	 * Run the String getPublicationSize() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:51 PM
	 */
	@Test
	public void testGetPublicationSize_1()
		throws Exception {
		TenderNotice fixture = new TenderNotice("", "", "", "", "", "", "", "", true, "", "", "", "", "", "", new Long(1L), new Long(1L), "", new JSONArray(), "", "", EasyMock.createNiceMock(List.class), new JSONArray(), "", "", new ArrayList(), "", "", true, "");

		String result = fixture.getPublicationSize();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the String getSmsContent() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:51 PM
	 */
	@Test
	public void testGetSmsContent_1()
		throws Exception {
		TenderNotice fixture = new TenderNotice("", "", "", "", "", "", "", "", true, "", "", "", "", "", "", new Long(1L), new Long(1L), "", new JSONArray(), "", "", EasyMock.createNiceMock(List.class), new JSONArray(), "", "", new ArrayList(), "", "", true, "");

		String result = fixture.getSmsContent();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the String getSourceUuid() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:51 PM
	 */
	@Test
	public void testGetSourceUuid_1()
		throws Exception {
		TenderNotice fixture = new TenderNotice("", "", "", "", "", "", "", "", true, "", "", "", "", "", "", new Long(1L), new Long(1L), "", new JSONArray(), "", "", EasyMock.createNiceMock(List.class), new JSONArray(), "", "", new ArrayList(), "", "", true, "");

		String result = fixture.getSourceUuid();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the String getTenantId() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:51 PM
	 */
	@Test
	public void testGetTenantId_1()
		throws Exception {
		TenderNotice fixture = new TenderNotice("", "", "", "", "", "", "", "", true, "", "", "", "", "", "", new Long(1L), new Long(1L), "", new JSONArray(), "", "", EasyMock.createNiceMock(List.class), new JSONArray(), "", "", new ArrayList(), "", "", true, "");

		String result = fixture.getTenantId();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the String getTenderDate() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:51 PM
	 */
	@Test
	public void testGetTenderDate_1()
		throws Exception {
		TenderNotice fixture = new TenderNotice("", "", "", "", "", "", "", "", true, "", "", "", "", "", "", new Long(1L), new Long(1L), "", new JSONArray(), "", "", EasyMock.createNiceMock(List.class), new JSONArray(), "", "", new ArrayList(), "", "", true, "");

		String result = fixture.getTenderDate();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the String getTenderDetail() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:51 PM
	 */
	@Test
	public void testGetTenderDetail_1()
		throws Exception {
		TenderNotice fixture = new TenderNotice("", "", "", "", "", "", "", "", true, "", "", "", "", "", "", new Long(1L), new Long(1L), "", new JSONArray(), "", "", EasyMock.createNiceMock(List.class), new JSONArray(), "", "", new ArrayList(), "", "", true, "");

		String result = fixture.getTenderDetail();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the JSONArray getTenderDocument() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:51 PM
	 */
	@Test
	public void testGetTenderDocument_1()
		throws Exception {
		TenderNotice fixture = new TenderNotice("", "", "", "", "", "", "", "", true, "", "", "", "", "", "", new Long(1L), new Long(1L), "", new JSONArray(), "", "", EasyMock.createNiceMock(List.class), new JSONArray(), "", "", new ArrayList(), "", "", true, "");

		JSONArray result = fixture.getTenderDocument();

		// add additional test code here
		assertNotNull(result);
		assertEquals(0, result.size());
	}

	/**
	 * Run the String getTenderDocumentList() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:51 PM
	 */
	@Test
	public void testGetTenderDocumentList_1()
		throws Exception {
		TenderNotice fixture = new TenderNotice("", "", "", "", "", "", "", "", true, "", "", "", "", "", "", new Long(1L), new Long(1L), "", new JSONArray(), "", "", EasyMock.createNiceMock(List.class), new JSONArray(), "", "", new ArrayList(), "", "", true, "");

		String result = fixture.getTenderDocumentList();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the String getTenderNoticeId() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:51 PM
	 */
	@Test
	public void testGetTenderNoticeId_1()
		throws Exception {
		TenderNotice fixture = new TenderNotice("", "", "", "", "", "", "", "", true, "", "", "", "", "", "", new Long(1L), new Long(1L), "", new JSONArray(), "", "", EasyMock.createNiceMock(List.class), new JSONArray(), "", "", new ArrayList(), "", "", true, "");

		String result = fixture.getTenderNoticeId();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the String getTenderNoticeStatus() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:51 PM
	 */
	@Test
	public void testGetTenderNoticeStatus_1()
		throws Exception {
		TenderNotice fixture = new TenderNotice("", "", "", "", "", "", "", "", true, "", "", "", "", "", "", new Long(1L), new Long(1L), "", new JSONArray(), "", "", EasyMock.createNiceMock(List.class), new JSONArray(), "", "", new ArrayList(), "", "", true, "");

		String result = fixture.getTenderNoticeStatus();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the String getTenderNoticeUuid() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:51 PM
	 */
	@Test
	public void testGetTenderNoticeUuid_1()
		throws Exception {
		TenderNotice fixture = new TenderNotice("", "", "", "", "", "", "", "", true, "", "", "", "", "", "", new Long(1L), new Long(1L), "", new JSONArray(), "", "", EasyMock.createNiceMock(List.class), new JSONArray(), "", "", new ArrayList(), "", "", true, "");

		String result = fixture.getTenderNoticeUuid();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the String getTenderSubject() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:51 PM
	 */
	@Test
	public void testGetTenderSubject_1()
		throws Exception {
		TenderNotice fixture = new TenderNotice("", "", "", "", "", "", "", "", true, "", "", "", "", "", "", new Long(1L), new Long(1L), "", new JSONArray(), "", "", EasyMock.createNiceMock(List.class), new JSONArray(), "", "", new ArrayList(), "", "", true, "");

		String result = fixture.getTenderSubject();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the String getToDate() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:51 PM
	 */
	@Test
	public void testGetToDate_1()
		throws Exception {
		TenderNotice fixture = new TenderNotice("", "", "", "", "", "", "", "", true, "", "", "", "", "", "", new Long(1L), new Long(1L), "", new JSONArray(), "", "", EasyMock.createNiceMock(List.class), new JSONArray(), "", "", new ArrayList(), "", "", true, "");

		String result = fixture.getToDate();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the String getUserType() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:51 PM
	 */
	@Test
	public void testGetUserType_1()
		throws Exception {
		TenderNotice fixture = new TenderNotice("", "", "", "", "", "", "", "", true, "", "", "", "", "", "", new Long(1L), new Long(1L), "", new JSONArray(), "", "", EasyMock.createNiceMock(List.class), new JSONArray(), "", "", new ArrayList(), "", "", true, "");

		String result = fixture.getUserType();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the boolean isActive() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:51 PM
	 */
	@Test
	public void testIsActive_1()
		throws Exception {
		TenderNotice fixture = new TenderNotice("", "", "", "", "", "", "", "", true, "", "", "", "", "", "", new Long(1L), new Long(1L), "", new JSONArray(), "", "", EasyMock.createNiceMock(List.class), new JSONArray(), "", "", new ArrayList(), "", "", true, "");

		boolean result = fixture.isActive();

		// add additional test code here
		assertEquals(true, result);
	}

	/**
	 * Run the boolean isActive() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:51 PM
	 */
	@Test
	public void testIsActive_2()
		throws Exception {
		TenderNotice fixture = new TenderNotice("", "", "", "", "", "", "", "", false, "", "", "", "", "", "", new Long(1L), new Long(1L), "", new JSONArray(), "", "", EasyMock.createNiceMock(List.class), new JSONArray(), "", "", new ArrayList(), "", "", true, "");

		boolean result = fixture.isActive();

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the boolean isDefaultGrid() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:51 PM
	 */
	@Test
	public void testIsDefaultGrid_1()
		throws Exception {
		TenderNotice fixture = new TenderNotice("", "", "", "", "", "", "", "", true, "", "", "", "", "", "", new Long(1L), new Long(1L), "", new JSONArray(), "", "", EasyMock.createNiceMock(List.class), new JSONArray(), "", "", new ArrayList(), "", "", true, "");

		boolean result = fixture.isDefaultGrid();

		// add additional test code here
		assertEquals(true, result);
	}

	/**
	 * Run the boolean isDefaultGrid() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:51 PM
	 */
	@Test
	public void testIsDefaultGrid_2()
		throws Exception {
		TenderNotice fixture = new TenderNotice("", "", "", "", "", "", "", "", true, "", "", "", "", "", "", new Long(1L), new Long(1L), "", new JSONArray(), "", "", EasyMock.createNiceMock(List.class), new JSONArray(), "", "", new ArrayList(), "", "", false, "");

		boolean result = fixture.isDefaultGrid();

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the void setActive(boolean) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:51 PM
	 */
	@Test
	public void testSetActive_1()
		throws Exception {
		TenderNotice fixture = new TenderNotice("", "", "", "", "", "", "", "", true, "", "", "", "", "", "", new Long(1L), new Long(1L), "", new JSONArray(), "", "", EasyMock.createNiceMock(List.class), new JSONArray(), "", "", new ArrayList(), "", "", true, "");
		boolean isActive = true;

		fixture.setActive(isActive);

		// add additional test code here
	}

	/**
	 * Run the void setCreatedBy(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:51 PM
	 */
	@Test
	public void testSetCreatedBy_1()
		throws Exception {
		TenderNotice fixture = new TenderNotice("", "", "", "", "", "", "", "", true, "", "", "", "", "", "", new Long(1L), new Long(1L), "", new JSONArray(), "", "", EasyMock.createNiceMock(List.class), new JSONArray(), "", "", new ArrayList(), "", "", true, "");
		String createdBy = "";

		fixture.setCreatedBy(createdBy);

		// add additional test code here
	}

	/**
	 * Run the void setCreatedByName(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:51 PM
	 */
	@Test
	public void testSetCreatedByName_1()
		throws Exception {
		TenderNotice fixture = new TenderNotice("", "", "", "", "", "", "", "", true, "", "", "", "", "", "", new Long(1L), new Long(1L), "", new JSONArray(), "", "", EasyMock.createNiceMock(List.class), new JSONArray(), "", "", new ArrayList(), "", "", true, "");
		String createdByName = "";

		fixture.setCreatedByName(createdByName);

		// add additional test code here
	}

	/**
	 * Run the void setCreatedTime(Long) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:51 PM
	 */
	@Test
	public void testSetCreatedTime_1()
		throws Exception {
		TenderNotice fixture = new TenderNotice("", "", "", "", "", "", "", "", true, "", "", "", "", "", "", new Long(1L), new Long(1L), "", new JSONArray(), "", "", EasyMock.createNiceMock(List.class), new JSONArray(), "", "", new ArrayList(), "", "", true, "");
		Long createdTime = new Long(1L);

		fixture.setCreatedTime(createdTime);

		// add additional test code here
	}

	/**
	 * Run the void setDefaultGrid(boolean) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:51 PM
	 */
	@Test
	public void testSetDefaultGrid_1()
		throws Exception {
		TenderNotice fixture = new TenderNotice("", "", "", "", "", "", "", "", true, "", "", "", "", "", "", new Long(1L), new Long(1L), "", new JSONArray(), "", "", EasyMock.createNiceMock(List.class), new JSONArray(), "", "", new ArrayList(), "", "", true, "");
		boolean defaultGrid = true;

		fixture.setDefaultGrid(defaultGrid);

		// add additional test code here
	}

	/**
	 * Run the void setEmailContentData(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:51 PM
	 */
	@Test
	public void testSetEmailContentData_1()
		throws Exception {
		TenderNotice fixture = new TenderNotice("", "", "", "", "", "", "", "", true, "", "", "", "", "", "", new Long(1L), new Long(1L), "", new JSONArray(), "", "", EasyMock.createNiceMock(List.class), new JSONArray(), "", "", new ArrayList(), "", "", true, "");
		String emailContentData = "";

		fixture.setEmailContentData(emailContentData);

		// add additional test code here
	}

	/**
	 * Run the void setEmailContentJson(JSONArray) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:51 PM
	 */
	@Test
	public void testSetEmailContentJson_1()
		throws Exception {
		TenderNotice fixture = new TenderNotice("", "", "", "", "", "", "", "", true, "", "", "", "", "", "", new Long(1L), new Long(1L), "", new JSONArray(), "", "", EasyMock.createNiceMock(List.class), new JSONArray(), "", "", new ArrayList(), "", "", true, "");
		JSONArray emailContentJson = new JSONArray();

		fixture.setEmailContentJson(emailContentJson);

		// add additional test code here
	}

	/**
	 * Run the void setFileNumber(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:51 PM
	 */
	@Test
	public void testSetFileNumber_1()
		throws Exception {
		TenderNotice fixture = new TenderNotice("", "", "", "", "", "", "", "", true, "", "", "", "", "", "", new Long(1L), new Long(1L), "", new JSONArray(), "", "", EasyMock.createNiceMock(List.class), new JSONArray(), "", "", new ArrayList(), "", "", true, "");
		String fileNumber = "";

		fixture.setFileNumber(fileNumber);

		// add additional test code here
	}

	/**
	 * Run the void setFromDate(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:51 PM
	 */
	@Test
	public void testSetFromDate_1()
		throws Exception {
		TenderNotice fixture = new TenderNotice("", "", "", "", "", "", "", "", true, "", "", "", "", "", "", new Long(1L), new Long(1L), "", new JSONArray(), "", "", EasyMock.createNiceMock(List.class), new JSONArray(), "", "", new ArrayList(), "", "", true, "");
		String fromDate = "";

		fixture.setFromDate(fromDate);

		// add additional test code here
	}

	/**
	 * Run the void setLastModifiedBy(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:51 PM
	 */
	@Test
	public void testSetLastModifiedBy_1()
		throws Exception {
		TenderNotice fixture = new TenderNotice("", "", "", "", "", "", "", "", true, "", "", "", "", "", "", new Long(1L), new Long(1L), "", new JSONArray(), "", "", EasyMock.createNiceMock(List.class), new JSONArray(), "", "", new ArrayList(), "", "", true, "");
		String lastModifiedBy = "";

		fixture.setLastModifiedBy(lastModifiedBy);

		// add additional test code here
	}

	/**
	 * Run the void setLastModifiedTime(Long) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:51 PM
	 */
	@Test
	public void testSetLastModifiedTime_1()
		throws Exception {
		TenderNotice fixture = new TenderNotice("", "", "", "", "", "", "", "", true, "", "", "", "", "", "", new Long(1L), new Long(1L), "", new JSONArray(), "", "", EasyMock.createNiceMock(List.class), new JSONArray(), "", "", new ArrayList(), "", "", true, "");
		Long lastModifiedTime = new Long(1L);

		fixture.setLastModifiedTime(lastModifiedTime);

		// add additional test code here
	}

	/**
	 * Run the void setModuleCode(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:51 PM
	 */
	@Test
	public void testSetModuleCode_1()
		throws Exception {
		TenderNotice fixture = new TenderNotice("", "", "", "", "", "", "", "", true, "", "", "", "", "", "", new Long(1L), new Long(1L), "", new JSONArray(), "", "", EasyMock.createNiceMock(List.class), new JSONArray(), "", "", new ArrayList(), "", "", true, "");
		String moduleCode = "";

		fixture.setModuleCode(moduleCode);

		// add additional test code here
	}

	/**
	 * Run the void setNoteContent(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:51 PM
	 */
	@Test
	public void testSetNoteContent_1()
		throws Exception {
		TenderNotice fixture = new TenderNotice("", "", "", "", "", "", "", "", true, "", "", "", "", "", "", new Long(1L), new Long(1L), "", new JSONArray(), "", "", EasyMock.createNiceMock(List.class), new JSONArray(), "", "", new ArrayList(), "", "", true, "");
		String noteContent = "";

		fixture.setNoteContent(noteContent);

		// add additional test code here
	}

	/**
	 * Run the void setNotificationTemplateList(ArrayList<NotificationTemplate>) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:51 PM
	 */
	@Test
	public void testSetNotificationTemplateList_1()
		throws Exception {
		TenderNotice fixture = new TenderNotice("", "", "", "", "", "", "", "", true, "", "", "", "", "", "", new Long(1L), new Long(1L), "", new JSONArray(), "", "", EasyMock.createNiceMock(List.class), new JSONArray(), "", "", new ArrayList(), "", "", true, "");
		ArrayList<NotificationTemplate> notificationTemplateList = new ArrayList();

		fixture.setNotificationTemplateList(notificationTemplateList);

		// add additional test code here
	}

	/**
	 * Run the void setNotificationTemplateUuid(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:51 PM
	 */
	@Test
	public void testSetNotificationTemplateUuid_1()
		throws Exception {
		TenderNotice fixture = new TenderNotice("", "", "", "", "", "", "", "", true, "", "", "", "", "", "", new Long(1L), new Long(1L), "", new JSONArray(), "", "", EasyMock.createNiceMock(List.class), new JSONArray(), "", "", new ArrayList(), "", "", true, "");
		String notificationTemplateUuid = "";

		fixture.setNotificationTemplateUuid(notificationTemplateUuid);

		// add additional test code here
	}

	/**
	 * Run the void setPublicationList(List<PublicationList>) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:51 PM
	 */
	@Test
	public void testSetPublicationList_1()
		throws Exception {
		TenderNotice fixture = new TenderNotice("", "", "", "", "", "", "", "", true, "", "", "", "", "", "", new Long(1L), new Long(1L), "", new JSONArray(), "", "", EasyMock.createNiceMock(List.class), new JSONArray(), "", "", new ArrayList(), "", "", true, "");
		List<PublicationList> publicationList = EasyMock.createMock(List.class);
		// add mock object expectations here

		EasyMock.replay(publicationList);

		fixture.setPublicationList(publicationList);

		// add additional test code here
		EasyMock.verify(publicationList);
	}

	/**
	 * Run the void setPublicationSize(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:51 PM
	 */
	@Test
	public void testSetPublicationSize_1()
		throws Exception {
		TenderNotice fixture = new TenderNotice("", "", "", "", "", "", "", "", true, "", "", "", "", "", "", new Long(1L), new Long(1L), "", new JSONArray(), "", "", EasyMock.createNiceMock(List.class), new JSONArray(), "", "", new ArrayList(), "", "", true, "");
		String publicationSize = "";

		fixture.setPublicationSize(publicationSize);

		// add additional test code here
	}

	/**
	 * Run the void setSmsContent(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:51 PM
	 */
	@Test
	public void testSetSmsContent_1()
		throws Exception {
		TenderNotice fixture = new TenderNotice("", "", "", "", "", "", "", "", true, "", "", "", "", "", "", new Long(1L), new Long(1L), "", new JSONArray(), "", "", EasyMock.createNiceMock(List.class), new JSONArray(), "", "", new ArrayList(), "", "", true, "");
		String smsContent = "";

		fixture.setSmsContent(smsContent);

		// add additional test code here
	}

	/**
	 * Run the void setSourceUuid(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:51 PM
	 */
	@Test
	public void testSetSourceUuid_1()
		throws Exception {
		TenderNotice fixture = new TenderNotice("", "", "", "", "", "", "", "", true, "", "", "", "", "", "", new Long(1L), new Long(1L), "", new JSONArray(), "", "", EasyMock.createNiceMock(List.class), new JSONArray(), "", "", new ArrayList(), "", "", true, "");
		String sourceUuid = "";

		fixture.setSourceUuid(sourceUuid);

		// add additional test code here
	}

	/**
	 * Run the void setTenantId(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:51 PM
	 */
	@Test
	public void testSetTenantId_1()
		throws Exception {
		TenderNotice fixture = new TenderNotice("", "", "", "", "", "", "", "", true, "", "", "", "", "", "", new Long(1L), new Long(1L), "", new JSONArray(), "", "", EasyMock.createNiceMock(List.class), new JSONArray(), "", "", new ArrayList(), "", "", true, "");
		String tenantId = "";

		fixture.setTenantId(tenantId);

		// add additional test code here
	}

	/**
	 * Run the void setTenderDate(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:51 PM
	 */
	@Test
	public void testSetTenderDate_1()
		throws Exception {
		TenderNotice fixture = new TenderNotice("", "", "", "", "", "", "", "", true, "", "", "", "", "", "", new Long(1L), new Long(1L), "", new JSONArray(), "", "", EasyMock.createNiceMock(List.class), new JSONArray(), "", "", new ArrayList(), "", "", true, "");
		String tenderDate = "";

		fixture.setTenderDate(tenderDate);

		// add additional test code here
	}

	/**
	 * Run the void setTenderDetail(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:51 PM
	 */
	@Test
	public void testSetTenderDetail_1()
		throws Exception {
		TenderNotice fixture = new TenderNotice("", "", "", "", "", "", "", "", true, "", "", "", "", "", "", new Long(1L), new Long(1L), "", new JSONArray(), "", "", EasyMock.createNiceMock(List.class), new JSONArray(), "", "", new ArrayList(), "", "", true, "");
		String tenderDetail = "";

		fixture.setTenderDetail(tenderDetail);

		// add additional test code here
	}

	/**
	 * Run the void setTenderDocument(JSONArray) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:51 PM
	 */
	@Test
	public void testSetTenderDocument_1()
		throws Exception {
		TenderNotice fixture = new TenderNotice("", "", "", "", "", "", "", "", true, "", "", "", "", "", "", new Long(1L), new Long(1L), "", new JSONArray(), "", "", EasyMock.createNiceMock(List.class), new JSONArray(), "", "", new ArrayList(), "", "", true, "");
		JSONArray tenderDocument = new JSONArray();

		fixture.setTenderDocument(tenderDocument);

		// add additional test code here
	}

	/**
	 * Run the void setTenderDocumentList(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:51 PM
	 */
	@Test
	public void testSetTenderDocumentList_1()
		throws Exception {
		TenderNotice fixture = new TenderNotice("", "", "", "", "", "", "", "", true, "", "", "", "", "", "", new Long(1L), new Long(1L), "", new JSONArray(), "", "", EasyMock.createNiceMock(List.class), new JSONArray(), "", "", new ArrayList(), "", "", true, "");
		String tenderDocumentList = "";

		fixture.setTenderDocumentList(tenderDocumentList);

		// add additional test code here
	}

	/**
	 * Run the void setTenderNoticeId(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:51 PM
	 */
	@Test
	public void testSetTenderNoticeId_1()
		throws Exception {
		TenderNotice fixture = new TenderNotice("", "", "", "", "", "", "", "", true, "", "", "", "", "", "", new Long(1L), new Long(1L), "", new JSONArray(), "", "", EasyMock.createNiceMock(List.class), new JSONArray(), "", "", new ArrayList(), "", "", true, "");
		String tenderNoticeId = "";

		fixture.setTenderNoticeId(tenderNoticeId);

		// add additional test code here
	}

	/**
	 * Run the void setTenderNoticeStatus(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:51 PM
	 */
	@Test
	public void testSetTenderNoticeStatus_1()
		throws Exception {
		TenderNotice fixture = new TenderNotice("", "", "", "", "", "", "", "", true, "", "", "", "", "", "", new Long(1L), new Long(1L), "", new JSONArray(), "", "", EasyMock.createNiceMock(List.class), new JSONArray(), "", "", new ArrayList(), "", "", true, "");
		String tenderNoticeStatus = "";

		fixture.setTenderNoticeStatus(tenderNoticeStatus);

		// add additional test code here
	}

	/**
	 * Run the void setTenderNoticeUuid(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:51 PM
	 */
	@Test
	public void testSetTenderNoticeUuid_1()
		throws Exception {
		TenderNotice fixture = new TenderNotice("", "", "", "", "", "", "", "", true, "", "", "", "", "", "", new Long(1L), new Long(1L), "", new JSONArray(), "", "", EasyMock.createNiceMock(List.class), new JSONArray(), "", "", new ArrayList(), "", "", true, "");
		String tenderNoticeUuid = "";

		fixture.setTenderNoticeUuid(tenderNoticeUuid);

		// add additional test code here
	}

	/**
	 * Run the void setTenderSubject(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:51 PM
	 */
	@Test
	public void testSetTenderSubject_1()
		throws Exception {
		TenderNotice fixture = new TenderNotice("", "", "", "", "", "", "", "", true, "", "", "", "", "", "", new Long(1L), new Long(1L), "", new JSONArray(), "", "", EasyMock.createNiceMock(List.class), new JSONArray(), "", "", new ArrayList(), "", "", true, "");
		String tenderSubject = "";

		fixture.setTenderSubject(tenderSubject);

		// add additional test code here
	}

	/**
	 * Run the void setToDate(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:51 PM
	 */
	@Test
	public void testSetToDate_1()
		throws Exception {
		TenderNotice fixture = new TenderNotice("", "", "", "", "", "", "", "", true, "", "", "", "", "", "", new Long(1L), new Long(1L), "", new JSONArray(), "", "", EasyMock.createNiceMock(List.class), new JSONArray(), "", "", new ArrayList(), "", "", true, "");
		String toDate = "";

		fixture.setToDate(toDate);

		// add additional test code here
	}

	/**
	 * Run the void setUserType(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:51 PM
	 */
	@Test
	public void testSetUserType_1()
		throws Exception {
		TenderNotice fixture = new TenderNotice("", "", "", "", "", "", "", "", true, "", "", "", "", "", "", new Long(1L), new Long(1L), "", new JSONArray(), "", "", EasyMock.createNiceMock(List.class), new JSONArray(), "", "", new ArrayList(), "", "", true, "");
		String userType = "";

		fixture.setUserType(userType);

		// add additional test code here
	}

	/**
	 * Perform pre-test initialization.
	 *
	 * @throws Exception
	 *         if the initialization fails for some reason
	 *
	 * @generatedBy CodePro at 25/5/20 3:51 PM
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
	 * @generatedBy CodePro at 25/5/20 3:51 PM
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
	 * @generatedBy CodePro at 25/5/20 3:51 PM
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(TenderNoticeTest.class);
	}
}