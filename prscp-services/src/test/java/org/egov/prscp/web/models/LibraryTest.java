package org.egov.prscp.web.models;

import java.util.ArrayList;
import org.junit.*;
import static org.junit.Assert.*;

public class LibraryTest {
	
	@Test
	public void testLibrary_1()
		throws Exception {

		Library result = new Library();

		// add additional test code here
		assertNotNull(result);
		assertEquals(null, result.getLastModifiedTime());
		assertEquals(false, result.isActive());
		assertEquals(null, result.getDocumentType());
		assertEquals(null, result.getLibraryUuid());
		assertEquals(null, result.getDocumentList());
		assertEquals(null, result.getCreatedTime());
		assertEquals(null, result.getCreatedBy());
		assertEquals(null, result.getSourceUuid());
		assertEquals(null, result.getDocumentId());
		assertEquals(null, result.getModuleCode());
		assertEquals(null, result.getTenantId());
		assertEquals(null, result.getEventDetailUuid());
		assertEquals(null, result.getLastModifiedBy());
	}

	
	@Test
	public void testLibrary_2()
		throws Exception {
		String libraryUuid = "";
		String eventDetailUuid = "";
		ArrayList<DocumentList> documentList = new ArrayList();
		String documentId = "";
		String documentType = "";
		boolean isActive = true;
		String tenantId = "";
		String moduleCode = "";
		String createdBy = "";
		String lastModifiedBy = "";
		Long createdTime = new Long(1L);
		Long lastModifiedTime = new Long(1L);
		String sourceUuid = "";

		Library result = new Library(libraryUuid, eventDetailUuid, documentList, documentId, documentType, isActive, tenantId, moduleCode, createdBy, lastModifiedBy, createdTime, lastModifiedTime, sourceUuid);

		// add additional test code here
		assertNotNull(result);
		assertEquals(new Long(1L), result.getLastModifiedTime());
		assertEquals(true, result.isActive());
		assertEquals("", result.getDocumentType());
		assertEquals("", result.getLibraryUuid());
		assertEquals(new Long(1L), result.getCreatedTime());
		assertEquals("", result.getCreatedBy());
		assertEquals("", result.getSourceUuid());
		assertEquals("", result.getDocumentId());
		assertEquals("", result.getModuleCode());
		assertEquals("", result.getTenantId());
		assertEquals("", result.getEventDetailUuid());
		assertEquals("", result.getLastModifiedBy());
	}

	
	@Test
	public void testBuilder_1()
		throws Exception {

		Library.LibraryBuilder result = Library.builder();

		// add additional test code here
		assertNotNull(result);
		assertEquals("Library.LibraryBuilder(libraryUuid=null, eventDetailUuid=null, documentList=null, documentId=null, documentType=null, isActive=false, tenantId=null, moduleCode=null, createdBy=null, lastModifiedBy=null, createdTime=null, lastModifiedTime=null, sourceUuid=null)", result.toString());
	}


	@Test
	public void testGetCreatedBy_1()
		throws Exception {
		Library fixture = new Library("", "", new ArrayList(), "", "", true, "", "", "", "", new Long(1L), new Long(1L), "");

		String result = fixture.getCreatedBy();

		assertEquals("", result);
	}

	
	@Test
	public void testGetCreatedTime_1()
		throws Exception {
		Library fixture = new Library("", "", new ArrayList(), "", "", true, "", "", "", "", new Long(1L), new Long(1L), "");

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
	public void testGetDocumentId_1()
		throws Exception {
		Library fixture = new Library("", "", new ArrayList(), "", "", true, "", "", "", "", new Long(1L), new Long(1L), "");

		String result = fixture.getDocumentId();

		assertEquals("", result);
	}

	
	@Test
	public void testGetDocumentList_1()
		throws Exception {
		Library fixture = new Library("", "", new ArrayList(), "", "", true, "", "", "", "", new Long(1L), new Long(1L), "");

		ArrayList<DocumentList> result = (ArrayList<DocumentList>) fixture.getDocumentList();

		
		assertNotNull(result);
		assertEquals(0, result.size());
	}

	
	@Test
	public void testGetDocumentType_1()
		throws Exception {
		Library fixture = new Library("", "", new ArrayList(), "", "", true, "", "", "", "", new Long(1L), new Long(1L), "");

		String result = fixture.getDocumentType();

		assertEquals("", result);
	}

	
	@Test
	public void testGetEventDetailUuid_1()
		throws Exception {
		Library fixture = new Library("", "", new ArrayList(), "", "", true, "", "", "", "", new Long(1L), new Long(1L), "");

		String result = fixture.getEventDetailUuid();

		assertEquals("", result);
	}

	@Test
	public void testGetLastModifiedBy_1()
		throws Exception {
		Library fixture = new Library("", "", new ArrayList(), "", "", true, "", "", "", "", new Long(1L), new Long(1L), "");

		String result = fixture.getLastModifiedBy();

	
		assertEquals("", result);
	}

	
	@Test
	public void testGetLastModifiedTime_1()
		throws Exception {
		Library fixture = new Library("", "", new ArrayList(), "", "", true, "", "", "", "", new Long(1L), new Long(1L), "");

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
	public void testGetLibraryUuid_1()
		throws Exception {
		Library fixture = new Library("", "", new ArrayList(), "", "", true, "", "", "", "", new Long(1L), new Long(1L), "");

		String result = fixture.getLibraryUuid();

		assertEquals("", result);
	}

	
	@Test
	public void testGetModuleCode_1()
		throws Exception {
		Library fixture = new Library("", "", new ArrayList(), "", "", true, "", "", "", "", new Long(1L), new Long(1L), "");

		String result = fixture.getModuleCode();

		assertEquals("", result);
	}

	@Test
	public void testGetSourceUuid_1()
		throws Exception {
		Library fixture = new Library("", "", new ArrayList(), "", "", true, "", "", "", "", new Long(1L), new Long(1L), "");

		String result = fixture.getSourceUuid();

		assertEquals("", result);
	}


	@Test
	public void testGetTenantId_1()
		throws Exception {
		Library fixture = new Library("", "", new ArrayList(), "", "", true, "", "", "", "", new Long(1L), new Long(1L), "");

		String result = fixture.getTenantId();

		assertEquals("", result);
	}


	@Test
	public void testIsActive_1()
		throws Exception {
		Library fixture = new Library("", "", new ArrayList(), "", "", true, "", "", "", "", new Long(1L), new Long(1L), "");

		boolean result = fixture.isActive();

		assertEquals(true, result);
	}

	
	@Test
	public void testIsActive_2()
		throws Exception {
		Library fixture = new Library("", "", new ArrayList(), "", "", false, "", "", "", "", new Long(1L), new Long(1L), "");

		boolean result = fixture.isActive();

		assertEquals(false, result);
	}


	@Test
	public void testSetActive_1()
		throws Exception {
		Library fixture = new Library("", "", new ArrayList(), "", "", true, "", "", "", "", new Long(1L), new Long(1L), "");
		boolean isActive = true;

		fixture.setActive(isActive);

	}

	
	@Test
	public void testSetCreatedBy_1()
		throws Exception {
		Library fixture = new Library("", "", new ArrayList(), "", "", true, "", "", "", "", new Long(1L), new Long(1L), "");
		String createdBy = "";

		fixture.setCreatedBy(createdBy);

	}

	@Test
	public void testSetCreatedTime_1()
		throws Exception {
		Library fixture = new Library("", "", new ArrayList(), "", "", true, "", "", "", "", new Long(1L), new Long(1L), "");
		Long createdTime = new Long(1L);

		fixture.setCreatedTime(createdTime);

	}


	@Test
	public void testSetDocumentId_1()
		throws Exception {
		Library fixture = new Library("", "", new ArrayList(), "", "", true, "", "", "", "", new Long(1L), new Long(1L), "");
		String documentId = "";

		fixture.setDocumentId(documentId);

	}


	@Test
	public void testSetDocumentList_1()
		throws Exception {
		Library fixture = new Library("", "", new ArrayList(), "", "", true, "", "", "", "", new Long(1L), new Long(1L), "");
		ArrayList<DocumentList> documentList = new ArrayList();

		fixture.setDocumentList(documentList);

	}

	
	@Test
	public void testSetDocumentType_1()
		throws Exception {
		Library fixture = new Library("", "", new ArrayList(), "", "", true, "", "", "", "", new Long(1L), new Long(1L), "");
		String documentType = "";

		fixture.setDocumentType(documentType);

	}

	
	@Test
	public void testSetEventDetailUuid_1()
		throws Exception {
		Library fixture = new Library("", "", new ArrayList(), "", "", true, "", "", "", "", new Long(1L), new Long(1L), "");
		String eventDetailUuid = "";

		fixture.setEventDetailUuid(eventDetailUuid);

	}

	
	@Test
	public void testSetLastModifiedBy_1()
		throws Exception {
		Library fixture = new Library("", "", new ArrayList(), "", "", true, "", "", "", "", new Long(1L), new Long(1L), "");
		String lastModifiedBy = "";

		fixture.setLastModifiedBy(lastModifiedBy);

	}

	
	@Test
	public void testSetLastModifiedTime_1()
		throws Exception {
		Library fixture = new Library("", "", new ArrayList(), "", "", true, "", "", "", "", new Long(1L), new Long(1L), "");
		Long lastModifiedTime = new Long(1L);

		fixture.setLastModifiedTime(lastModifiedTime);

	}

	@Test
	public void testSetLibraryUuid_1()
		throws Exception {
		Library fixture = new Library("", "", new ArrayList(), "", "", true, "", "", "", "", new Long(1L), new Long(1L), "");
		String libraryUuid = "";

		fixture.setLibraryUuid(libraryUuid);

	}

	@Test
	public void testSetModuleCode_1()
		throws Exception {
		Library fixture = new Library("", "", new ArrayList(), "", "", true, "", "", "", "", new Long(1L), new Long(1L), "");
		String moduleCode = "";

		fixture.setModuleCode(moduleCode);

	}

	
	@Test
	public void testSetSourceUuid_1()
		throws Exception {
		Library fixture = new Library("", "", new ArrayList(), "", "", true, "", "", "", "", new Long(1L), new Long(1L), "");
		String sourceUuid = "";

		fixture.setSourceUuid(sourceUuid);

	}

	
	@Test
	public void testSetTenantId_1()
		throws Exception {
		Library fixture = new Library("", "", new ArrayList(), "", "", true, "", "", "", "", new Long(1L), new Long(1L), "");
		String tenantId = "";

		fixture.setTenantId(tenantId);

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
		new org.junit.runner.JUnitCore().run(LibraryTest.class);
	}
}