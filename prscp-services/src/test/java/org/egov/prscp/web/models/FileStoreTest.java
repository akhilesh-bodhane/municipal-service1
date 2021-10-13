package org.egov.prscp.web.models;

import java.util.List;
import org.easymock.EasyMock;
import org.junit.*;
import static org.junit.Assert.*;


public class FileStoreTest {
	
	@Test
	public void testGetFileStoreIds_1()
		throws Exception {
		FileStore fixture = new FileStore();
		fixture.setFileStoreIds(EasyMock.createNiceMock(List.class));

		List<Files> result = fixture.getFileStoreIds();

		assertNotNull(result);
		assertEquals(0, result.size());
	}

	@Test
	public void testSetFileStoreIds_1()
		throws Exception {
		FileStore fixture = new FileStore();
		fixture.setFileStoreIds(EasyMock.createNiceMock(List.class));
		List<Files> fileStoreIds = EasyMock.createMock(List.class);
	
		EasyMock.replay(fileStoreIds);

		fixture.setFileStoreIds(fileStoreIds);

		EasyMock.verify(fileStoreIds);
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
		new org.junit.runner.JUnitCore().run(FileStoreTest.class);
	}
}