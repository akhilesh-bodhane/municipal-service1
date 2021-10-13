package org.egov.ec.web.models;

import org.junit.*;
import static org.junit.Assert.*;

import org.egov.ec.web.models.Document;

public class DocumentTest {
	
	/**
	 * Run the Document() constructor test.
	 *
	 * @throws Exception
	 *
	 *  at 30/4/20 5:39 AM
	 */
	@Test
	public void testDocument_1()
		throws Exception {

		Document result = new Document();

		
		assertNotNull(result);
		assertEquals(null, result.getDocumentUuid());
		assertEquals(null, result.getViolationUuid());
		assertEquals(null, result.getDocumentType());
		assertEquals(null, result.getFileStoreId());
		assertEquals(null, result.getFileStoreId());
		assertEquals(null, result.getChallanId());
		assertEquals(null, result.getLastModifiedTime());
		assertEquals(null, result.getCreatedBy());
		assertEquals(null, result.getCreatedTime());
		assertEquals(null, result.getTenantId());
		assertEquals(null, result.getLastModifiedBy());
		assertEquals(null, result.getIsActive());
	}
	
	/**
	 * Run the Document(String,String,String,String,Long,String,Long,Boolean,String) constructor test.
	 *
	 * @throws Exception
	 *
	 *  at 30/04/20 1:32 PM
	 */
	@Test
	public void testDocument_2()
		throws Exception {
		String documentUuid="";
		String violationUuid="";
		String documentType = "";
		String fileStoreId = "";
		String challanId = "";
		String tenantId = "";
		Boolean isActive = new Boolean(true);
		String itemUuid = "";
		String createdBy = "";
		Long createdTime = new Long(1L);
		String lastModifiedBy = "";
		Long lastModifiedTime = new Long(1L);


		Document result = new Document(documentUuid,violationUuid,isActive,tenantId,documentType,fileStoreId,challanId,createdBy,createdTime,lastModifiedBy,lastModifiedTime);

		
		assertNotNull(result);
		assertEquals(new Long(1L), (result.getLastModifiedTime()));
		assertEquals(Boolean.TRUE, result.getIsActive());
		assertEquals("", result.getCreatedBy());
		assertEquals(new Long(1L), result.getCreatedTime());
		assertEquals("", result.getTenantId());
		assertEquals("", result.getLastModifiedBy());
		assertEquals("", result.getDocumentUuid());
		assertEquals("", result.getViolationUuid());
		assertEquals("", result.getDocumentType());
		assertEquals("", result.getFileStoreId());
		assertEquals("", result.getChallanId());
	}
	
	/**
	 * Run the Document.DocumentBuilder builder() method test.
	 *
	 * @throws Exception
	 *
	 *  at 30/04/20 1:32 PM
	 */
	@Test
	public void testBuilder_1()
		throws Exception {

		Document.DocumentBuilder result = Document.builder();
		
		assertNotNull(result);
		assertEquals("Document.DocumentBuilder(documentUuid=null, violationUuid=null, isActive=null, tenantId=null, documentType=null, fileStoreId=null, challanId=null, createdBy=null, createdTime=null, lastModifiedBy=null, lastModifiedTime=null)", result.toString());
	}
	
	/**
	 * Run the Document.DocumentBuilder builder() method test.
	 *
	 * @throws Exception
	 *
	 *  at 30/04/20 1:32 PM
	 */
	@Test
	public void testBuilder_2()
		throws Exception {

		Document.DocumentBuilder builder = new Document.DocumentBuilder();
		builder.documentUuid(null);
		builder.violationUuid(null);
		builder.createdBy(null);
		builder.createdTime(null);
		builder.documentType(null);
		builder.isActive(null);
		builder.lastModifiedBy(null);
		builder.lastModifiedTime(null);
		builder.fileStoreId(null);
		builder.challanId(null);
		builder.tenantId(null);
		builder.build();

		Document.DocumentBuilder builder2 = new Document.DocumentBuilder();
		builder2.documentUuid(null);
		builder2.violationUuid(null);
		builder2.createdBy(null);
		builder2.createdTime(null);
		builder2.documentType(null);
		builder2.isActive(null);
		builder2.lastModifiedBy(null);
		builder2.lastModifiedTime(null);
		builder2.fileStoreId(null);
		builder2.challanId(null);
		builder2.tenantId(null);
		builder2.build();

		Assert.assertEquals(builder2.toString(), builder.toString());
	}
	

	/**
	 * Run the String getDocumentUuid() method test.
	 *
	 * @throws Exception
	 *
	 *  at 30/04/20 1:32 PM
	 */
	@Test
	public void testGetDocumentUuid_1()
		throws Exception {
		Document fixture = new Document("", "", new Boolean(true), "", "", "", "", null, new Long(1L),"",new Long(1L));

		String result = fixture.getDocumentUuid();		
		assertEquals("", result);
	}
	
	/**
	 * Run the String getViolationUuid() method test.
	 *
	 * @throws Exception
	 *
	 *  at 30/04/20 1:32 PM
	 */
	@Test
	public void testGetViolationUuid_1()
		throws Exception {
		Document fixture = new Document("", "", new Boolean(true), "", "", "", "", null, new Long(1L),"",new Long(1L));

		String result = fixture.getViolationUuid();		
		assertEquals("", result);
	}

	/**
	 * Run the String getItemName() method test.
	 *
	 * @throws Exception
	 *
	 *  at 30/04/20 1:32 PM
	 */
	@Test
	public void testGetDocumentType_1()
		throws Exception {
		Document fixture = new Document("", "", new Boolean(true), "", "", "", "", null, new Long(1L),"",new Long(1L));

		String result = fixture.getDocumentType();		
		assertEquals("", result);
	}
	
	/**
	 * Run the String getFileStoreId() method test.
	 *
	 * @throws Exception
	 *
	 *  at 30/04/20 1:32 PM
	 */
	@Test
	public void testGetFileStorageId()
		throws Exception {
		Document fixture = new Document("", "", new Boolean(true), "", "", "", "", null, new Long(1L),"",new Long(1L));

		String result = fixture.getFileStoreId();		
		assertEquals("", result);
	}
	
	/**
	 * Run the String getChallanId() method test.
	 *
	 * @throws Exception
	 *
	 *  at 30/04/20 1:32 PM
	 */
	@Test
	public void testGetChallanId()
		throws Exception {
		Document fixture = new Document("", "", new Boolean(true), "", "", "", "", null, new Long(1L),"",new Long(1L));

		String result = fixture.getChallanId();		
		assertEquals("", result);
	}
	
	/**
	 * Run the String getCreatedBy() method test.
	 *
	 * @throws Exception
	 *
	 *  at 30/04/20 1:32 PM
	 */
	@Test
	public void testGetCreatedBy_1()
		throws Exception {
		Document fixture = new Document("", "", new Boolean(true), "", "", "", "", null, new Long(1L),"",new Long(1L));

		String result = fixture.getCreatedBy();

		
		assertEquals(null, result);
	}

	/**
	 * Run the Long getCreatedTime() method test.
	 *
	 * @throws Exception
	 *
	 *  at 30/04/20 1:32 PM
	 */
	@Test
	public void testGetCreatedTime_1()
		throws Exception {
		Document fixture = new Document("", "", new Boolean(true), "", "", "", "", null, new Long(1L),"",new Long(1L));

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

	/**
	 * Run the Boolean getIsActive() method test.
	 *
	 * @throws Exception
	 *
	 *  at 30/04/20 1:32 PM
	 */
	@Test
	public void testGetIsActive_1()
		throws Exception {
		Document fixture = new Document("", "", new Boolean(true), "", "", "", "", null, new Long(1L),"",new Long(1L));

		Boolean result = fixture.getIsActive();

		
		assertNotNull(result);
		assertEquals("true", result.toString());
		assertEquals(true, result.booleanValue());
	}

	/**
	 * Run the String getLastModifiedBy() method test.
	 *
	 * @throws Exception
	 *
	 *  at 30/04/20 1:32 PM
	 */
	@Test
	public void testGetLastModifiedBy_1()
		throws Exception {
		Document fixture = new Document("", "", new Boolean(true), "", "", "", "", null, new Long(1L),"",new Long(1L));

		String result = fixture.getLastModifiedBy();

		
		assertEquals("", result);
	}

	/**
	 * Run the Long getLastModifiedTime() method test.
	 *
	 * @throws Exception
	 *
	 *  at 30/04/20 1:32 PM
	 */
	@Test
	public void testGetLastModifiedTime_1()
		throws Exception {
		Document fixture = new Document("", "", new Boolean(true), "", "", "", "", null, new Long(1L),"",new Long(1L));

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

	/**
	 * Run the String getTenantId() method test.
	 *
	 * @throws Exception
	 *
	 *  at 30/04/20 1:32 PM
	 */
	@Test
	public void testGetTenantId_1()
		throws Exception {
		Document fixture = new Document("", "", new Boolean(true), "", "", "", "", null, new Long(1L),"",new Long(1L));

		String result = fixture.getTenantId();

		
		assertEquals("", result);
	}
	
	/**
	 * Run the String setDocumentUuid() method test.
	 *
	 * @throws Exception
	 *
	 *  at 30/04/20 1:32 PM
	 */
	@Test
	public void testSetDocumntUuid_1()
		throws Exception {
		Document fixture = new Document("", "", new Boolean(true), "", "", "", "", null, new Long(1L),"",new Long(1L));
		String documentUuid ="" ;		
		fixture.setDocumentUuid(documentUuid);
	}
	
	/**
	 * Run the String setViolationUuid() method test.
	 *
	 * @throws Exception
	 *
	 *  at 30/04/20 1:32 PM
	 */
	@Test
	public void testSetViolationUuid_1()
		throws Exception {
		Document fixture = new Document("", "", new Boolean(true), "", "", "", "", null, new Long(1L),"",new Long(1L));
		String violationUuid ="" ;		
		fixture.setViolationUuid(violationUuid);
	}

	/**
	 * Run the String setDocumentType() method test.
	 *
	 * @throws Exception
	 *
	 *  at 30/04/20 1:32 PM
	 */
	@Test
	public void testDocumentType_1()
		throws Exception {
		Document fixture = new Document("", "", new Boolean(true), "", "", "", "", null, new Long(1L),"",new Long(1L));
		String documentType ="" ;		
		fixture.setDocumentType(documentType);
	}
	
	/**
	 * Run the String setFileStoreId() method test.
	 *
	 * @throws Exception
	 *
	 *  at 30/04/20 1:32 PM
	 */
	@Test
	public void testSetFileStoreId_1()
		throws Exception {
		Document fixture = new Document("", "", new Boolean(true), "", "", "", "", null, new Long(1L),"",new Long(1L));
		String fileStoreId ="" ;		
		fixture.setFileStoreId(fileStoreId);
	}
	
	/**
	 * Run the String setChallanId() method test.
	 *
	 * @throws Exception
	 *
	 *  at 30/04/20 1:32 PM
	 */
	@Test
	public void testSetChallanId_1()
		throws Exception {
		Document fixture = new Document("", "", new Boolean(true), "", "", "", "", null, new Long(1L),"",new Long(1L));
		String challanId ="" ;		
		fixture.setChallanId(challanId);
	}
	
	/**
	 * Run the void setCreatedBy(String) method test.
	 *
	 * @throws Exception
	 *
	 *  at 30/04/20 1:32 PM
	 */
	@Test
	public void testSetCreatedBy_1()
		throws Exception {
		Document fixture = new Document("", "", new Boolean(true), "", "", "", "", null, new Long(1L),"",new Long(1L));
		String createdBy = "";

		fixture.setCreatedBy(createdBy);

		
	}

	/**
	 * Run the void setCreatedTime(Long) method test.
	 *
	 * @throws Exception
	 *
	 *  at 30/04/20 1:32 PM
	 */
	@Test
	public void testSetCreatedTime_1()
		throws Exception {
		Document fixture = new Document("", "", new Boolean(true), "", "", "", "", null, new Long(1L),"",new Long(1L));
		Long createdTime = new Long(1L);

		fixture.setCreatedTime(createdTime);

		
	}

	/**
	 * Run the void setIsActive(Boolean) method test.
	 *
	 * @throws Exception
	 *
	 *  at 30/04/20 1:32 PM
	 */
	@Test
	public void testSetIsActive_1()
		throws Exception {
		Document fixture = new Document("", "", new Boolean(true), "", "", "", "", null, new Long(1L),"",new Long(1L));
		Boolean isActive = new Boolean(true);
		fixture.setIsActive(isActive);

		
	}

	/**
	 * Run the void setLastModifiedBy(String) method test.
	 *
	 * @throws Exception
	 *
	 *  at 30/04/20 1:32 PM
	 */
	@Test
	public void testSetLastModifiedBy_1()
		throws Exception {
		Document fixture = new Document("", "", new Boolean(true), "", "", "", "", null, new Long(1L),"",new Long(1L));
		String lastModifiedBy = "";
		fixture.setLastModifiedBy(lastModifiedBy);

		
	}

	/**
	 * Run the void setLastModifiedTime(Long) method test.
	 *
	 * @throws Exception
	 *
	 *  at 30/04/20 1:32 PM
	 */
	@Test
	public void testSetLastModifiedTime_1()
		throws Exception {
		Document fixture = new Document("", "", new Boolean(true), "", "", "", "", null, new Long(1L),"",new Long(1L));
		Long lastModifiedTime = new Long(1L);
		fixture.setLastModifiedTime(lastModifiedTime);

		
	}

	/**
	 * Run the void setTenantId(String) method test.
	 *
	 * @throws Exception
	 *
	 *  at 30/04/20 1:32 PM
	 */
	@Test
	public void testSetTenantId_1()
		throws Exception {
		Document fixture = new Document("", "", new Boolean(true), "", "", "", "", null, new Long(1L),"",new Long(1L));
		String tenantId = "";
		fixture.setTenantId(tenantId);

		
	}


}
