package org.egov.prscp.web.models;

import org.junit.*;
import static org.junit.Assert.*;


public class FilesTest {
	
	@Test
	public void testFiles_1()
		throws Exception {

		Files result = new Files();

		assertNotNull(result);
		assertEquals(null, result.getId());
		assertEquals(null, result.getFileStoreId());
		assertEquals(null, result.getUrl());
	}


	@Test
	public void testFiles_2()
		throws Exception {
		String fileStoreId = "";
		String id = "";
		String url = "";

		Files result = new Files(fileStoreId, id, url);

		assertNotNull(result);
		assertEquals("", result.getId());
		assertEquals("", result.getFileStoreId());
		assertEquals("", result.getUrl());
	}

	
	@Test
	public void testBuilder_1()
		throws Exception {

		Files.FilesBuilder result = Files.builder();

	
		assertNotNull(result);
		assertEquals("Files.FilesBuilder(fileStoreId=null, id=null, url=null)", result.toString());
	}


	@Test
	public void testGetFileStoreId_1()
		throws Exception {
		Files fixture = new Files("", "", "");

		String result = fixture.getFileStoreId();

	
		assertEquals("", result);
	}


	@Test
	public void testGetId_1()
		throws Exception {
		Files fixture = new Files("", "", "");

		String result = fixture.getId();

		assertEquals("", result);
	}

	@Test
	public void testGetUrl_1()
		throws Exception {
		Files fixture = new Files("", "", "");

		String result = fixture.getUrl();

		assertEquals("", result);
	}

	@Test
	public void testSetFileStoreId_1()
		throws Exception {
		Files fixture = new Files("", "", "");
		String fileStoreId = "";

		fixture.setFileStoreId(fileStoreId);

	}


	@Test
	public void testSetId_1()
		throws Exception {
		Files fixture = new Files("", "", "");
		String id = "";

		fixture.setId(id);

	}

	
	@Test
	public void testSetUrl_1()
		throws Exception {
		Files fixture = new Files("", "", "");
		String url = "";

		fixture.setUrl(url);

	}

	
	@Before
	public void setUp()
		throws Exception {
	
	}

	
	@After
	public void tearDown()
		throws Exception {
		// Add additional tear down code here
	}


	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(FilesTest.class);
	}
}