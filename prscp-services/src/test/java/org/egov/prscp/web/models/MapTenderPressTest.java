package org.egov.prscp.web.models;

import org.json.simple.JSONArray;
import org.junit.*;
import static org.junit.Assert.*;


public class MapTenderPressTest {
	
	@Test
	public void testMapTenderPress_1()
		throws Exception {

		MapTenderPress result = new MapTenderPress();

		assertNotNull(result);
		assertEquals(null, result.getLastModifiedTime());
		assertEquals(false, result.isActive());
		assertEquals(null, result.getDocumentAttachment());
		assertEquals(null, result.getPressMasterUuid());
		assertEquals(null, result.getNotifiactionTemplateUuid());
		assertEquals(null, result.getMapTenderPressUuid());
		assertEquals(null, result.getLastModifiedBy());
		assertEquals(null, result.getTenderNoticeUuid());
		assertEquals(null, result.getCreatedBy());
		assertEquals(null, result.getTenantId());
		assertEquals(false, result.isNotifyStatus());
		assertEquals(null, result.getModuleCode());
		assertEquals(null, result.getCreatedTime());
	}

	
	@Test
	public void testMapTenderPress_2()
		throws Exception {
		String mapTenderPressUuid = "";
		String pressMasterUuid = "";
		String tenderNoticeUuid = "";
		boolean isActive = true;
		String tenantId = "";
		String createdBy = "";
		String lastModifiedBy = "";
		Long createdTime = new Long(1L);
		Long lastModifiedTime = new Long(1L);
		JSONArray documentAttachment = new JSONArray();
		String notifiactionTemplateUuid = "";
		String moduleCode = "";
		boolean notifyStatus = true;

		MapTenderPress result = new MapTenderPress(mapTenderPressUuid, pressMasterUuid, tenderNoticeUuid, isActive, tenantId, createdBy, lastModifiedBy, createdTime, lastModifiedTime, documentAttachment, notifiactionTemplateUuid, moduleCode, notifyStatus);

		assertNotNull(result);
		assertEquals(new Long(1L), result.getLastModifiedTime());
		assertEquals(true, result.isActive());
		assertEquals("", result.getPressMasterUuid());
		assertEquals("", result.getNotifiactionTemplateUuid());
		assertEquals("", result.getMapTenderPressUuid());
		assertEquals("", result.getLastModifiedBy());
		assertEquals("", result.getTenderNoticeUuid());
		assertEquals("", result.getCreatedBy());
		assertEquals("", result.getTenantId());
		assertEquals(true, result.isNotifyStatus());
		assertEquals("", result.getModuleCode());
		assertEquals(new Long(1L), result.getCreatedTime());
	}

	
	@Test
	public void testBuilder_1()
		throws Exception {

		MapTenderPress.MapTenderPressBuilder result = MapTenderPress.builder();

		assertNotNull(result);
		assertEquals("MapTenderPress.MapTenderPressBuilder(mapTenderPressUuid=null, pressMasterUuid=null, tenderNoticeUuid=null, isActive=false, tenantId=null, createdBy=null, lastModifiedBy=null, createdTime=null, lastModifiedTime=null, documentAttachment=null, notifiactionTemplateUuid=null, moduleCode=null, notifyStatus=false)", result.toString());
	}

	
	@Test
	public void testGetCreatedBy_1()
		throws Exception {
		MapTenderPress fixture = new MapTenderPress("", "", "", true, "", "", "", new Long(1L), new Long(1L), new JSONArray(), "", "", true);

		String result = fixture.getCreatedBy();

		assertEquals("", result);
	}

	
	@Test
	public void testGetCreatedTime_1()
		throws Exception {
		MapTenderPress fixture = new MapTenderPress("", "", "", true, "", "", "", new Long(1L), new Long(1L), new JSONArray(), "", "", true);

		Long result = fixture.getCreatedTime();

		
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
	public void testGetDocumentAttachment_1()
		throws Exception {
		MapTenderPress fixture = new MapTenderPress("", "", "", true, "", "", "", new Long(1L), new Long(1L), new JSONArray(), "", "", true);

		JSONArray result = fixture.getDocumentAttachment();

		assertNotNull(result);
		assertEquals(0, result.size());
	}

	
	@Test
	public void testGetLastModifiedBy_1()
		throws Exception {
		MapTenderPress fixture = new MapTenderPress("", "", "", true, "", "", "", new Long(1L), new Long(1L), new JSONArray(), "", "", true);

		String result = fixture.getLastModifiedBy();

		assertEquals("", result);
	}


	@Test
	public void testGetLastModifiedTime_1()
		throws Exception {
		MapTenderPress fixture = new MapTenderPress("", "", "", true, "", "", "", new Long(1L), new Long(1L), new JSONArray(), "", "", true);

		Long result = fixture.getLastModifiedTime();

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
	public void testGetMapTenderPressUuid_1()
		throws Exception {
		MapTenderPress fixture = new MapTenderPress("", "", "", true, "", "", "", new Long(1L), new Long(1L), new JSONArray(), "", "", true);

		String result = fixture.getMapTenderPressUuid();
		assertEquals("", result);
	}


	@Test
	public void testGetModuleCode_1()
		throws Exception {
		MapTenderPress fixture = new MapTenderPress("", "", "", true, "", "", "", new Long(1L), new Long(1L), new JSONArray(), "", "", true);

		String result = fixture.getModuleCode();

		assertEquals("", result);
	}

	@Test
	public void testGetNotifiactionTemplateUuid_1()
		throws Exception {
		MapTenderPress fixture = new MapTenderPress("", "", "", true, "", "", "", new Long(1L), new Long(1L), new JSONArray(), "", "", true);

		String result = fixture.getNotifiactionTemplateUuid();

		assertEquals("", result);
	}

	
	@Test
	public void testGetPressMasterUuid_1()
		throws Exception {
		MapTenderPress fixture = new MapTenderPress("", "", "", true, "", "", "", new Long(1L), new Long(1L), new JSONArray(), "", "", true);

		String result = fixture.getPressMasterUuid();

		assertEquals("", result);
	}

	
	@Test
	public void testGetTenantId_1()
		throws Exception {
		MapTenderPress fixture = new MapTenderPress("", "", "", true, "", "", "", new Long(1L), new Long(1L), new JSONArray(), "", "", true);

		String result = fixture.getTenantId();

		assertEquals("", result);
	}

	@Test
	public void testGetTenderNoticeUuid_1()
		throws Exception {
		MapTenderPress fixture = new MapTenderPress("", "", "", true, "", "", "", new Long(1L), new Long(1L), new JSONArray(), "", "", true);

		String result = fixture.getTenderNoticeUuid();

		assertEquals("", result);
	}

	
	@Test
	public void testIsActive_1()
		throws Exception {
		MapTenderPress fixture = new MapTenderPress("", "", "", true, "", "", "", new Long(1L), new Long(1L), new JSONArray(), "", "", true);

		boolean result = fixture.isActive();

		assertEquals(true, result);
	}

	
	@Test
	public void testIsActive_2()
		throws Exception {
		MapTenderPress fixture = new MapTenderPress("", "", "", false, "", "", "", new Long(1L), new Long(1L), new JSONArray(), "", "", true);

		boolean result = fixture.isActive();

		assertEquals(false, result);
	}

	
	@Test
	public void testIsNotifyStatus_1()
		throws Exception {
		MapTenderPress fixture = new MapTenderPress("", "", "", true, "", "", "", new Long(1L), new Long(1L), new JSONArray(), "", "", true);

		boolean result = fixture.isNotifyStatus();

		assertEquals(true, result);
	}

	
	@Test
	public void testIsNotifyStatus_2()
		throws Exception {
		MapTenderPress fixture = new MapTenderPress("", "", "", true, "", "", "", new Long(1L), new Long(1L), new JSONArray(), "", "", false);

		boolean result = fixture.isNotifyStatus();

		assertEquals(false, result);
	}

	
	@Test
	public void testSetActive_1()
		throws Exception {
		MapTenderPress fixture = new MapTenderPress("", "", "", true, "", "", "", new Long(1L), new Long(1L), new JSONArray(), "", "", true);
		boolean isActive = true;

		fixture.setActive(isActive);

	}

	@Test
	public void testSetCreatedBy_1()
		throws Exception {
		MapTenderPress fixture = new MapTenderPress("", "", "", true, "", "", "", new Long(1L), new Long(1L), new JSONArray(), "", "", true);
		String createdBy = "";

		fixture.setCreatedBy(createdBy);

	}

	@Test
	public void testSetCreatedTime_1()
		throws Exception {
		MapTenderPress fixture = new MapTenderPress("", "", "", true, "", "", "", new Long(1L), new Long(1L), new JSONArray(), "", "", true);
		Long createdTime = new Long(1L);

		fixture.setCreatedTime(createdTime);

	}

	@Test
	public void testSetDocumentAttachment_1()
		throws Exception {
		MapTenderPress fixture = new MapTenderPress("", "", "", true, "", "", "", new Long(1L), new Long(1L), new JSONArray(), "", "", true);
		JSONArray documentAttachment = new JSONArray();

		fixture.setDocumentAttachment(documentAttachment);

		
	}

	@Test
	public void testSetLastModifiedBy_1()
		throws Exception {
		MapTenderPress fixture = new MapTenderPress("", "", "", true, "", "", "", new Long(1L), new Long(1L), new JSONArray(), "", "", true);
		String lastModifiedBy = "";

		fixture.setLastModifiedBy(lastModifiedBy);

	}

	
	@Test
	public void testSetLastModifiedTime_1()
		throws Exception {
		MapTenderPress fixture = new MapTenderPress("", "", "", true, "", "", "", new Long(1L), new Long(1L), new JSONArray(), "", "", true);
		Long lastModifiedTime = new Long(1L);

		fixture.setLastModifiedTime(lastModifiedTime);

	}

	@Test
	public void testSetMapTenderPressUuid_1()
		throws Exception {
		MapTenderPress fixture = new MapTenderPress("", "", "", true, "", "", "", new Long(1L), new Long(1L), new JSONArray(), "", "", true);
		String mapTenderPressUuid = "";

		fixture.setMapTenderPressUuid(mapTenderPressUuid);

	}

	
	@Test
	public void testSetModuleCode_1()
		throws Exception {
		MapTenderPress fixture = new MapTenderPress("", "", "", true, "", "", "", new Long(1L), new Long(1L), new JSONArray(), "", "", true);
		String moduleCode = "";

		fixture.setModuleCode(moduleCode);

	}

	@Test
	public void testSetNotifiactionTemplateUuid_1()
		throws Exception {
		MapTenderPress fixture = new MapTenderPress("", "", "", true, "", "", "", new Long(1L), new Long(1L), new JSONArray(), "", "", true);
		String notifiactionTemplateUuid = "";

		fixture.setNotifiactionTemplateUuid(notifiactionTemplateUuid);

	}

	@Test
	public void testSetNotifyStatus_1()
		throws Exception {
		MapTenderPress fixture = new MapTenderPress("", "", "", true, "", "", "", new Long(1L), new Long(1L), new JSONArray(), "", "", true);
		boolean notifyStatus = true;

		fixture.setNotifyStatus(notifyStatus);

	}

	@Test
	public void testSetPressMasterUuid_1()
		throws Exception {
		MapTenderPress fixture = new MapTenderPress("", "", "", true, "", "", "", new Long(1L), new Long(1L), new JSONArray(), "", "", true);
		String pressMasterUuid = "";

		fixture.setPressMasterUuid(pressMasterUuid);

	}

	@Test
	public void testSetTenantId_1()
		throws Exception {
		MapTenderPress fixture = new MapTenderPress("", "", "", true, "", "", "", new Long(1L), new Long(1L), new JSONArray(), "", "", true);
		String tenantId = "";

		fixture.setTenantId(tenantId);

	}

	@Test
	public void testSetTenderNoticeUuid_1()
		throws Exception {
		MapTenderPress fixture = new MapTenderPress("", "", "", true, "", "", "", new Long(1L), new Long(1L), new JSONArray(), "", "", true);
		String tenderNoticeUuid = "";

		fixture.setTenderNoticeUuid(tenderNoticeUuid);

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
		new org.junit.runner.JUnitCore().run(MapTenderPressTest.class);
	}
}