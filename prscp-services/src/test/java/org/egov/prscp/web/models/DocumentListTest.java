package org.egov.prscp.web.models;

import org.json.simple.JSONArray;
import org.junit.*;
import static org.junit.Assert.*;

public class DocumentListTest {

	@Test
	public void testDocumentList_1()
		throws Exception {

		DocumentList result = new DocumentList();

		
		assertNotNull(result);
		assertEquals(null, result.getDocumentType());
		assertEquals(null, result.getFileStoreId());
		assertEquals(null, result.getDocumentId());
	}

	
	@Test
	public void testDocumentList_2()
		throws Exception {
		String documentType = "";
		JSONArray documentId = new JSONArray();
		String fileStoreId = "";

		DocumentList result = new DocumentList(documentType, documentId, fileStoreId);

		
		assertNotNull(result);
		assertEquals("", result.getDocumentType());
		assertEquals("", result.getFileStoreId());
	}

	
	@Test
	public void testBuilder_1()
		throws Exception {

		DocumentList.DocumentListBuilder result = DocumentList.builder();

		
		assertNotNull(result);
		assertEquals("DocumentList.DocumentListBuilder(documentType=null, documentId=null, fileStoreId=null)", result.toString());
	}

	
	@Test
	public void testCanEqual_1()
		throws Exception {
		DocumentList fixture = new DocumentList("", new JSONArray(), "");
		Object other = new Object();

		boolean result = fixture.canEqual(other);

		
		assertEquals(false, result);
	}


	@Test
	public void testCanEqual_2()
		throws Exception {
		DocumentList fixture = new DocumentList("", new JSONArray(), "");
		Object other = new Object();

		boolean result = fixture.canEqual(other);

		
		assertEquals(false, result);
	}

	
	@Test
	public void testEquals_1()
		throws Exception {
		DocumentList fixture = new DocumentList("", new JSONArray(), "");
		Object o = new DocumentList("", new JSONArray(), "");

		boolean result = fixture.equals(o);

		
		assertEquals(true, result);
	}

	
	@Test
	public void testEquals_2()
		throws Exception {
		DocumentList fixture = new DocumentList("", new JSONArray(), "");
		Object o = new Object();

		boolean result = fixture.equals(o);

		
		assertEquals(false, result);
	}


	@Test
	public void testEquals_3()
		throws Exception {
		DocumentList fixture = new DocumentList("", new JSONArray(), "");
		Object o = new DocumentList("", new JSONArray(), "");

		boolean result = fixture.equals(o);

		
		assertEquals(true, result);
	}

	
	@Test
	public void testEquals_4()
		throws Exception {
		DocumentList fixture = new DocumentList("", new JSONArray(), "");
		Object o = new DocumentList("", new JSONArray(), "");

		boolean result = fixture.equals(o);

		
		assertEquals(true, result);
	}

	@Test
	public void testEquals_5()
		throws Exception {
		DocumentList fixture = new DocumentList("", new JSONArray(), "");
		Object o = new DocumentList("", new JSONArray(), "");

		boolean result = fixture.equals(o);

		
		assertEquals(true, result);
	}

	
	@Test
	public void testEquals_6()
		throws Exception {
		DocumentList fixture = new DocumentList("", new JSONArray(), "");
		Object o = new DocumentList("", new JSONArray(), "");

		boolean result = fixture.equals(o);

		
		assertEquals(true, result);
	}

	
	@Test
	public void testEquals_7()
		throws Exception {
		DocumentList fixture = new DocumentList("", new JSONArray(), (String) null);
		Object o = new DocumentList("", new JSONArray(), (String) null);

		boolean result = fixture.equals(o);

		
		assertEquals(true, result);
	}

	
	
	@Test
	public void testEquals_8()
		throws Exception {
		DocumentList fixture = new DocumentList("", new JSONArray(), "");
		Object o = new DocumentList("", new JSONArray(), "");

		boolean result = fixture.equals(o);

		
		assertEquals(true, result);
	}

	
	@Test
	public void testGetDocumentId_1()
		throws Exception {
		DocumentList fixture = new DocumentList("", new JSONArray(), "");

		JSONArray result = fixture.getDocumentId();

		
		assertNotNull(result);
		assertEquals(0, result.size());
	}

	
	@Test
	public void testGetDocumentType_1()
		throws Exception {
		DocumentList fixture = new DocumentList("", new JSONArray(), "");

		String result = fixture.getDocumentType();

		
		assertEquals("", result);
	}

	
	@Test
	public void testGetFileStoreId_1()
		throws Exception {
		DocumentList fixture = new DocumentList("", new JSONArray(), "");

		String result = fixture.getFileStoreId();

		
		assertEquals("", result);
	}


	@Test
	public void testHashCode_1()
		throws Exception {
		DocumentList fixture = new DocumentList((String) null, new JSONArray(), "");

		int result = fixture.hashCode();

		
		assertEquals(355121, result);
	}

	
	@Test
	public void testHashCode_2()
		throws Exception {
		DocumentList fixture = new DocumentList("", (JSONArray) null, (String) null);

		int result = fixture.hashCode();

		
		assertEquals(207959, result);
	}

	
	@Test
	public void testSetDocumentId_1()
		throws Exception {
		DocumentList fixture = new DocumentList("", new JSONArray(), "");
		JSONArray documentId = new JSONArray();

		fixture.setDocumentId(documentId);

		
	}

	
	@Test
	public void testSetDocumentType_1()
		throws Exception {
		DocumentList fixture = new DocumentList("", new JSONArray(), "");
		String documentType = "";

		fixture.setDocumentType(documentType);

		
	}

	
	@Test
	public void testSetFileStoreId_1()
		throws Exception {
		DocumentList fixture = new DocumentList("", new JSONArray(), "");
		String fileStoreId = "";

		fixture.setFileStoreId(fileStoreId);

		
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
		new org.junit.runner.JUnitCore().run(DocumentListTest.class);
	}
}