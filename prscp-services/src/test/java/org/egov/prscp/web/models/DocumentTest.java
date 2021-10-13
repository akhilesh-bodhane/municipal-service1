package org.egov.prscp.web.models;

import org.junit.*;
import static org.junit.Assert.*;

public class DocumentTest {

	@Test
	public void testDocument_1()
		throws Exception {

		Document result = new Document();

		assertNotNull(result);
		assertEquals(null, result.getId());
		assertEquals(null, result.getDocumentType());
		assertEquals(null, result.getFileStoreId());
		assertEquals(null, result.getDocumentUid());
		assertEquals(null, result.getAuditDetails());
		assertEquals(null, result.getTenantId());
	}

	
	@Test
	public void testDocument_2()
		throws Exception {
		String id = "";
		String tenantId = "";
		String documentType = "";
		String fileStoreId = "";
		String documentUid = "";
		AuditDetails auditDetails = new AuditDetails();

		Document result = new Document(id, tenantId, documentType, fileStoreId, documentUid, auditDetails);

		assertNotNull(result);
		assertEquals("", result.getId());
		assertEquals("", result.getDocumentType());
		assertEquals("", result.getFileStoreId());
		assertEquals("", result.getDocumentUid());
		assertEquals("", result.getTenantId());
	}


	@Test
	public void testBuilder_1()
		throws Exception {

		Document.DocumentBuilder result = Document.builder();

		// add additional test code here
		assertNotNull(result);
		assertEquals("Document.DocumentBuilder(id=null, tenantId=null, documentType=null, fileStoreId=null, documentUid=null, auditDetails=null)", result.toString());
	}


	@Test
	public void testCanEqual_1()
		throws Exception {
		Document fixture = new Document("", "", "", "", "", new AuditDetails());
		Object other = new Object();

		boolean result = fixture.canEqual(other);

	
		assertEquals(false, result);
	}

	
	@Test
	public void testCanEqual_2()
		throws Exception {
		Document fixture = new Document("", "", "", "", "", new AuditDetails());
		Object other = new Object();

		boolean result = fixture.canEqual(other);

		
		assertEquals(false, result);
	}

	
	@Test
	public void testEquals_1()
		throws Exception {
		Document fixture = new Document("", "", "", "", "", new AuditDetails());
		Object o = new Document("", "", "", "", "", new AuditDetails());

		boolean result = fixture.equals(o);

		
		assertEquals(true, result);
	}

	
	@Test
	public void testEquals_2()
		throws Exception {
		Document fixture = new Document("", "", "", "", "", new AuditDetails());
		Object o = new Object();

		boolean result = fixture.equals(o);

		
		assertEquals(false, result);
	}

	
	@Test
	public void testEquals_3()
		throws Exception {
		Document fixture = new Document("", "", "", "", "", new AuditDetails());
		Object o = new Document("", "", "", "", "", new AuditDetails());

		boolean result = fixture.equals(o);

		
		assertEquals(true, result);
	}

	
	@Test
	public void testEquals_4()
		throws Exception {
		Document fixture = new Document("", "", "", "", "", new AuditDetails());
		Object o = new Document("", "", "", "", "", new AuditDetails());

		boolean result = fixture.equals(o);

		assertEquals(true, result);
	}

	
	@Test
	public void testEquals_5()
		throws Exception {
		Document fixture = new Document((String) null, "", "", "", "", new AuditDetails());
		Object o = new Document((String) null, "", "", "", "", new AuditDetails());

		boolean result = fixture.equals(o);

	
		assertEquals(true, result);
	}

	
	@Test
	public void testEquals_6()
		throws Exception {
		Document fixture = new Document("", "", "", "", "", new AuditDetails());
		Object o = new Document("", "", "", "", "", new AuditDetails());

		boolean result = fixture.equals(o);

		assertEquals(true, result);
	}

	@Test
	public void testGetAuditDetails_1()
		throws Exception {
		Document fixture = new Document("", "", "", "", "", new AuditDetails());

		AuditDetails result = fixture.getAuditDetails();

		assertNotNull(result);
		assertEquals(null, result.getLastModifiedTime());
		assertEquals(null, result.getLastModifiedBy());
		assertEquals(null, result.getCreatedTime());
		assertEquals(null, result.getCreatedBy());
	}

	@Test
	public void testGetDocumentType_1()
		throws Exception {
		Document fixture = new Document("", "", "", "", "", new AuditDetails());

		String result = fixture.getDocumentType();

		assertEquals("", result);
	}

	@Test
	public void testGetDocumentUid_1()
		throws Exception {
		Document fixture = new Document("", "", "", "", "", new AuditDetails());

		String result = fixture.getDocumentUid();

		assertEquals("", result);
	}

	@Test
	public void testGetFileStoreId_1()
		throws Exception {
		Document fixture = new Document("", "", "", "", "", new AuditDetails());

		String result = fixture.getFileStoreId();

		// add additional test code here
		assertEquals("", result);
	}

	@Test
	public void testGetId_1()
		throws Exception {
		Document fixture = new Document("", "", "", "", "", new AuditDetails());

		String result = fixture.getId();

		assertEquals("", result);
	}

	
	@Test
	public void testGetTenantId_1()
		throws Exception {
		Document fixture = new Document("", "", "", "", "", new AuditDetails());

		String result = fixture.getTenantId();

	
		assertEquals("", result);
	}

	@Test
	public void testHashCode_1()
		throws Exception {
		Document fixture = new Document("", "", "", "", "", new AuditDetails());

		int result = fixture.hashCode();

		assertEquals(59, result);
	}

	@Test
	public void testHashCode_2()
		throws Exception {
		Document fixture = new Document((String) null, "", "", "", "", new AuditDetails());

		int result = fixture.hashCode();

		assertEquals(102, result);
	}

	@Test
	public void testSetAuditDetails_1()
		throws Exception {
		Document fixture = new Document("", "", "", "", "", new AuditDetails());
		AuditDetails auditDetails = new AuditDetails();

		fixture.setAuditDetails(auditDetails);

	}

	
	@Test
	public void testSetDocumentType_1()
		throws Exception {
		Document fixture = new Document("", "", "", "", "", new AuditDetails());
		String documentType = "";

		fixture.setDocumentType(documentType);

	}

	
	@Test
	public void testSetDocumentUid_1()
		throws Exception {
		Document fixture = new Document("", "", "", "", "", new AuditDetails());
		String documentUid = "";

		fixture.setDocumentUid(documentUid);

	}


	@Test
	public void testSetFileStoreId_1()
		throws Exception {
		Document fixture = new Document("", "", "", "", "", new AuditDetails());
		String fileStoreId = "";

		fixture.setFileStoreId(fileStoreId);

	}

		@Test
	public void testSetId_1()
		throws Exception {
		Document fixture = new Document("", "", "", "", "", new AuditDetails());
		String id = "";

		fixture.setId(id);

	}

	
	@Test
	public void testSetTenantId_1()
		throws Exception {
		Document fixture = new Document("", "", "", "", "", new AuditDetails());
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
		new org.junit.runner.JUnitCore().run(DocumentTest.class);
	}
}