package org.egov.ec.web.models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.egov.ec.web.models.FileStore;
import org.junit.Assert;
import org.junit.Test;

public class FileStoreTest {

	/**
	 * Run the FileStore() constructor test.
	 *
	 * @throws Exception
	 *
	 *                   at 30/4/20 5:39 AM
	 */
	@Test
	public void testFileStore_1() throws Exception {

		FileStore result = new FileStore();

		assertNotNull(result);
		assertEquals(null, result.getFiles());
		assertEquals(null, result.getFileStoreIds());
		assertEquals(null, result.getTenantId());
		assertEquals(null, result.getFileStoreId());
		assertEquals(null, result.getId());
		assertEquals(null, result.getUrl());
		assertEquals(null, result.getModule());
		assertEquals(null, result.getTag());
	}

	/**
	 * Run the
	 * FileStore(String,String,String,String,Long,String,Long,Boolean,String)
	 * constructor test.
	 *
	 * @throws Exception
	 *
	 *                   at 30/04/20 1:32 PM
	 */
	@Test
	public void testFileStore_2() throws Exception {
		List<FileStore> files = null;
		List<FileStore> fileStoreIds = null;
		String fileStoreId = "";
		String tenantId = "";
		String id = "";
		String url="";
		String module="";
		String tag="";

		FileStore result = new FileStore(files, fileStoreIds, fileStoreId, tenantId, id, url, module, tag);

		assertNotNull(result);
		assertEquals(null, result.getFiles());
		assertEquals(null, result.getFileStoreIds());
		assertEquals("", result.getFileStoreId());
		assertEquals("", result.getTenantId());
		assertEquals("", result.getId());
		assertEquals("", result.getUrl());
		assertEquals("", result.getModule());
		assertEquals("", result.getTag());
		

	}

	/**
	 * Run the FileStore.FileStoreBuilder builder() method test.
	 *
	 * @throws Exception
	 *
	 *                   at 30/04/20 1:32 PM
	 */
	@Test
	public void testBuilder_1() throws Exception {

		FileStore.FileStoreBuilder result = FileStore.builder();

		assertNotNull(result);
		assertEquals(
				"FileStore.FileStoreBuilder(files=null, fileStoreIds=null, fileStoreId=null, tenantId=null, id=null, url=null, module=null, tag=null)",
				result.toString());
	}

	/**
	 * Run the FileStore.FileStoreBuilder builder() method test.
	 *
	 * @throws Exception
	 *
	 *  at 30/04/20 1:32 PM
	 */
	@Test
	public void testBuilder_2()
		throws Exception {

		FileStore.FileStoreBuilder builder = new FileStore.FileStoreBuilder();
		builder.files(null);
		builder.fileStoreIds(null);
		builder.fileStoreId(null);
		builder.id(null);
		builder.tenantId(null);
		builder.module(null);
		builder.url(null);
		builder.tag(null);
		builder.build();

		FileStore.FileStoreBuilder builder2 = new FileStore.FileStoreBuilder();
		builder2.files(null);
		builder2.fileStoreIds(null);
		builder2.fileStoreId(null);
		builder2.id(null);
		builder2.tenantId(null);
		builder2.module(null);
		builder2.url(null);
		builder2.tag(null);		
		builder2.build();

		Assert.assertEquals(builder2.toString(), builder.toString());
	}

	
	@Test
	public void testGetFiles_1() throws Exception {
		FileStore fixture = new FileStore(null, null, null,"","", "", "", "");
		List<FileStore> result = fixture.getFiles();
		assertEquals(null, result);
	}
	
	@Test
	public void testGetFileStoreIds_1() throws Exception {
		FileStore fixture = new FileStore(null, null, null,"","", "", "", "");
		List<FileStore> result = fixture.getFileStoreIds();
		assertEquals(null, result);
	}
	
	@Test
	public void testGetFileStoreId_1() throws Exception {
		FileStore fixture = new FileStore(null, null, "","","", "", "", "");
		String result = fixture.getFileStoreId();
		assertEquals("", result);
	}
	
	@Test
	public void testGetId_1() throws Exception {
		FileStore fixture = new FileStore(null, null, null,"","", "", "", "");
		String result = fixture.getId();
		assertEquals("", result);
	}
	
	@Test
	public void testGetModule_1() throws Exception {
		FileStore fixture = new FileStore(null, null, null,"","", "", "", "");
		String result = fixture.getModule();
		assertEquals("", result);
	}
	
	@Test
	public void testGetTenantId_1() throws Exception {
		FileStore fixture = new FileStore(null, null, null,"","", "", "", "");
		String result = fixture.getTenantId();
		assertEquals("", result);
	}
	
	@Test
	public void testGetUrl_1() throws Exception {
		FileStore fixture = new FileStore(null, null, null,"","", "", "", "");
		String result = fixture.getUrl();
		assertEquals("", result);
	}
	
	@Test
	public void testGetTag_1() throws Exception {
		FileStore fixture = new FileStore(null, null, null,"","", "", "", "");
		String result = fixture.getTag();
		assertEquals("", result);
	}
	
		
	@Test
	public void testSetUrl_1() throws Exception {
		FileStore fixture =  new FileStore(null, null, null,"","", "", "", "");
		String url = "";
		fixture.setUrl(url);

	}
	
	@Test
	public void testSetFiles_1() throws Exception {
		FileStore fixture =  new FileStore(null, null, null,"","", "", "", "");
		List<FileStore> files = null;
		fixture.setFiles(files);

	}
	
	@Test
	public void testSetFileStoreIds_1() throws Exception {
		FileStore fixture =  new FileStore(null, null, null,"","", "", "", "");
		List<FileStore> fileStoreIds = null;
		fixture.setFileStoreIds(fileStoreIds);
	}
	
	@Test
	public void testSetFileStoreId_1() throws Exception {
		FileStore fixture =  new FileStore(null, null, null,"","", "", "", "");
		String fileStoreId = null;
		fixture.setFileStoreId(fileStoreId);

	}
	
	@Test
	public void testSetId_1() throws Exception {
		FileStore fixture =  new FileStore(null, null, null,"","", "", "", "");
		String id = null;
		fixture.setId(id);

	}
	
	@Test
	public void testSetModule_1() throws Exception {
		FileStore fixture =  new FileStore(null, null, null,"","", "", "", "");
		String module = null;
		fixture.setModule(module);

	}
	
	@Test
	public void testSetTag_1() throws Exception {
		FileStore fixture =  new FileStore(null, null, null,"","", "", "", "");
		String tag = null;
		fixture.setTag(tag);

	}
	
	@Test
	public void testSetTenantId_1() throws Exception {
		FileStore fixture =  new FileStore(null, null, null,"","", "", "", "");
		String tenantId = "";
		fixture.setTenantId(tenantId);

	}
}
