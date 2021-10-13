package org.egov.ec.web.models.workflow;

import org.junit.*;
import static org.junit.Assert.*;

import org.egov.ec.web.models.AuditDetails;
import org.egov.ec.web.models.workflow.Document;

/**
 * The class <code>DocumentTest</code> contains tests for the class <code>{@link Document}</code>.
 *
 * @generated at 17/5/20 2:11 PM
 * @version $Revision: 1.0 $
 */
public class DocumentTest {
	/**
	 * Run the Document() constructor test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:11 PM
	 */
	@Test
	public void testDocument_1()
		throws Exception {

		Document result = new Document();

		
		assertNotNull(result);
		assertEquals(null, result.getId());
		assertEquals(null, result.getFileStoreId());
		assertEquals(null, result.getDocumentUid());
		assertEquals(null, result.getTenantId());
		assertEquals(null, result.getDocumentType());
		assertEquals(null, result.getAuditDetails());
	}

	/**
	 * Run the Document(String,String,String,String,String,AuditDetails) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:11 PM
	 */
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
		assertEquals("", result.getFileStoreId());
		assertEquals("", result.getDocumentUid());
		assertEquals("", result.getTenantId());
		assertEquals("", result.getDocumentType());
	}

	/**
	 * Run the Document.DocumentBuilder builder() method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:11 PM
	 */
	@Test
	public void testBuilder_1()
		throws Exception {

		Document.DocumentBuilder result = Document.builder();

		
		assertNotNull(result);
		assertEquals("Document.DocumentBuilder(id=null, tenantId=null, documentType=null, fileStoreId=null, documentUid=null, auditDetails=null)", result.toString());
	}
	
	@Test
	public void testBuilder_2()
		throws Exception {

		Document.DocumentBuilder builder = new Document.DocumentBuilder();
		builder.id(null);
		builder.documentType(null);
		builder.fileStoreId(null);
		builder.documentUid(null);
		builder.auditDetails(null);
		builder.tenantId(null);
		builder.build();

		Document.DocumentBuilder builder2 = new Document.DocumentBuilder();
		builder2.id(null);
		builder2.documentType(null);
		builder2.fileStoreId(null);
		builder2.documentUid(null);
		builder2.auditDetails(null);
		builder2.tenantId(null);
		builder2.build();

		Assert.assertEquals(builder2.toString(), builder.toString());

		
		
	}
	
	@Test
	public void testEqualsObject() {
		Document state1=new Document();
		Document state2=new Document();
		Assert.assertEquals(state1,state2);
	}

	/**
	 * Run the boolean canEqual(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:11 PM
	 */
	@Test
	public void testCanEqual_1()
		throws Exception {
		Document fixture = new Document("", "", "", "", "", new AuditDetails());
		Object other = new Object();

		boolean result = fixture.canEqual(other);

		
		assertEquals(false, result);
	}

	/**
	 * Run the boolean canEqual(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:11 PM
	 */
	@Test
	public void testCanEqual_2()
		throws Exception {
		Document fixture = new Document("", "", "", "", "", new AuditDetails());
		Object other = new Object();

		boolean result = fixture.canEqual(other);

		
		assertEquals(false, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:11 PM
	 */
	@Test
	public void testEquals_1()
		throws Exception {
		Document fixture = new Document("", "", "", "", "", new AuditDetails());
		Object o = new Document("", "", "", "", "", new AuditDetails());

		boolean result = fixture.equals(o);

		
		assertEquals(true, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:11 PM
	 */
	@Test
	public void testEquals_2()
		throws Exception {
		Document fixture = new Document("", "", "", "", "", new AuditDetails());
		Object o = new Object();

		boolean result = fixture.equals(o);

		
		assertEquals(false, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:11 PM
	 */
	@Test
	public void testEquals_3()
		throws Exception {
		Document fixture = new Document("", "", "", "", "", new AuditDetails());
		Object o = new Document("", "", "", "", "", new AuditDetails());

		boolean result = fixture.equals(o);

		
		assertEquals(true, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:11 PM
	 */
	@Test
	public void testEquals_4()
		throws Exception {
		Document fixture = new Document("", "", "", "", "", new AuditDetails());
		Object o = new Document("", "", "", "", "", new AuditDetails());

		boolean result = fixture.equals(o);

		
		assertEquals(true, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:11 PM
	 */
	@Test
	public void testEquals_5()
		throws Exception {
		Document fixture = new Document((String) null, "", "", "", "", new AuditDetails());
		Object o = new Document((String) null, "", "", "", "", new AuditDetails());

		boolean result = fixture.equals(o);

		
		assertEquals(true, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:11 PM
	 */
	@Test
	public void testEquals_6()
		throws Exception {
		Document fixture = new Document("", "", "", "", "", new AuditDetails());
		Object o = new Document("", "", "", "", "", new AuditDetails());

		boolean result = fixture.equals(o);

		
		assertEquals(true, result);
	}

	/**
	 * Run the AuditDetails getAuditDetails() method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:11 PM
	 */
	@Test
	public void testGetAuditDetails_1()
		throws Exception {
		Document fixture = new Document("", "", "", "", "", new AuditDetails());

		AuditDetails result = fixture.getAuditDetails();

		
		assertNotNull(result);
		assertEquals(null, result.getLastModifiedTime());
		assertEquals(null, result.getLastModifiedBy());
		assertEquals(null, result.getCreatedBy());
		assertEquals(null, result.getUserRole());
		assertEquals(null, result.getCreatedTime());
	}

	/**
	 * Run the String getDocumentType() method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:11 PM
	 */
	@Test
	public void testGetDocumentType_1()
		throws Exception {
		Document fixture = new Document("", "", "", "", "", new AuditDetails());

		String result = fixture.getDocumentType();

		
		assertEquals("", result);
	}

	/**
	 * Run the String getDocumentUid() method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:11 PM
	 */
	@Test
	public void testGetDocumentUid_1()
		throws Exception {
		Document fixture = new Document("", "", "", "", "", new AuditDetails());

		String result = fixture.getDocumentUid();

		
		assertEquals("", result);
	}

	/**
	 * Run the String getFileStoreId() method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:11 PM
	 */
	@Test
	public void testGetFileStoreId_1()
		throws Exception {
		Document fixture = new Document("", "", "", "", "", new AuditDetails());

		String result = fixture.getFileStoreId();

		
		assertEquals("", result);
	}

	/**
	 * Run the String getId() method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:11 PM
	 */
	@Test
	public void testGetId_1()
		throws Exception {
		Document fixture = new Document("", "", "", "", "", new AuditDetails());

		String result = fixture.getId();

		
		assertEquals("", result);
	}

	/**
	 * Run the String getTenantId() method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:11 PM
	 */
	@Test
	public void testGetTenantId_1()
		throws Exception {
		Document fixture = new Document("", "", "", "", "", new AuditDetails());

		String result = fixture.getTenantId();

		
		assertEquals("", result);
	}

	/**
	 * Run the int hashCode() method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:11 PM
	 */
	@Test
	public void testHashCode_1()
		throws Exception {
		Document fixture = new Document("", "", "", "", "", new AuditDetails());

		int result = fixture.hashCode();

		
		assertEquals(59, result);
	}

	/**
	 * Run the int hashCode() method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:11 PM
	 */
	@Test
	public void testHashCode_2()
		throws Exception {
		Document fixture = new Document((String) null, "", "", "", "", new AuditDetails());

		int result = fixture.hashCode();

		
		assertEquals(102, result);
	}

	/**
	 * Run the void setAuditDetails(AuditDetails) method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:11 PM
	 */
	@Test
	public void testSetAuditDetails_1()
		throws Exception {
		Document fixture = new Document("", "", "", "", "", new AuditDetails());
		AuditDetails auditDetails = new AuditDetails();

		fixture.setAuditDetails(auditDetails);

		
	}

	/**
	 * Run the void setDocumentType(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:11 PM
	 */
	@Test
	public void testSetDocumentType_1()
		throws Exception {
		Document fixture = new Document("", "", "", "", "", new AuditDetails());
		String documentType = "";

		fixture.setDocumentType(documentType);

		
	}

	/**
	 * Run the void setDocumentUid(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:11 PM
	 */
	@Test
	public void testSetDocumentUid_1()
		throws Exception {
		Document fixture = new Document("", "", "", "", "", new AuditDetails());
		String documentUid = "";

		fixture.setDocumentUid(documentUid);

		
	}

	/**
	 * Run the void setFileStoreId(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:11 PM
	 */
	@Test
	public void testSetFileStoreId_1()
		throws Exception {
		Document fixture = new Document("", "", "", "", "", new AuditDetails());
		String fileStoreId = "";

		fixture.setFileStoreId(fileStoreId);

		
	}

	/**
	 * Run the void setId(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:11 PM
	 */
	@Test
	public void testSetId_1()
		throws Exception {
		Document fixture = new Document("", "", "", "", "", new AuditDetails());
		String id = "";

		fixture.setId(id);

		
	}

	/**
	 * Run the void setTenantId(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:11 PM
	 */
	@Test
	public void testSetTenantId_1()
		throws Exception {
		Document fixture = new Document("", "", "", "", "", new AuditDetails());
		String tenantId = "";

		fixture.setTenantId(tenantId);

		
	}
}