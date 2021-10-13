package org.egov.pm.model;

import org.junit.*;
import static org.junit.Assert.*;


public class NOCApplicationRemarkTest {

	@Test
	public void testNOCApplicationRemark_1()
		throws Exception {

		NOCApplicationRemark result = new NOCApplicationRemark();

		// add additional test code here
		assertNotNull(result);
		assertEquals(null, result.getLastModifiedTime());
		assertEquals(null, result.getTenantId());
		assertEquals(null, result.getRemarkId());
		assertEquals(null, result.getRemarkBy());
		assertEquals(null, result.getRemark());
		assertEquals(null, result.getDocumentId());
		assertEquals(null, result.getApplicationStatus());
		assertEquals(null, result.getCreatedBy());
		assertEquals(null, result.getCreatedTime());
		assertEquals(null, result.getIsActive());
		assertEquals(null, result.getApplicationUuid());
		assertEquals(null, result.getPreviousRemarkId());
		assertEquals(null, result.getLastModifiedBy());
	}

	
	@Test
	public void testNOCApplicationRemark_2()
		throws Exception {
		String remarkId = "";
		String applicationUuid = "";
		String applicationStatus = "";
		String remark = "";
		String remarkBy = "";
		Boolean isActive = new Boolean(true);
		String createdBy = "";
		Long createdTime = new Long(1L);
		String lastModifiedBy = "";
		Long lastModifiedTime = new Long(1L);
		String documentId = "";
		String tenantId = "";
		String previousRemarkId = "";

		NOCApplicationRemark result = new NOCApplicationRemark(remarkId, applicationUuid, applicationStatus, remark, remarkBy, isActive, createdBy, createdTime, lastModifiedBy, lastModifiedTime, documentId, tenantId, previousRemarkId);

		// add additional test code here
		assertNotNull(result);
		assertEquals(new Long(1L), result.getLastModifiedTime());
		assertEquals("", result.getTenantId());
		assertEquals("", result.getRemarkId());
		assertEquals("", result.getRemarkBy());
		assertEquals("", result.getRemark());
		assertEquals("", result.getDocumentId());
		assertEquals("", result.getApplicationStatus());
		assertEquals("", result.getCreatedBy());
		assertEquals(new Long(1L), result.getCreatedTime());
		assertEquals(Boolean.TRUE, result.getIsActive());
		assertEquals("", result.getApplicationUuid());
		assertEquals("", result.getPreviousRemarkId());
		assertEquals("", result.getLastModifiedBy());
	}

	
	@Test
	public void testBuilder_1()
		throws Exception {

		NOCApplicationRemark.NOCApplicationRemarkBuilder result = NOCApplicationRemark.builder();

		// add additional test code here
		assertNotNull(result);
		assertEquals("NOCApplicationRemark.NOCApplicationRemarkBuilder(remarkId=null, applicationUuid=null, applicationStatus=null, remark=null, remarkBy=null, isActive=null, createdBy=null, createdTime=null, lastModifiedBy=null, lastModifiedTime=null, documentId=null, tenantId=null, previousRemarkId=null)", result.toString());
	}

	
	@Test
	public void testGetApplicationStatus_1()
		throws Exception {
		NOCApplicationRemark fixture = new NOCApplicationRemark("", "", "", "", "", new Boolean(true), "", new Long(1L), "", new Long(1L), "", "", "");

		String result = fixture.getApplicationStatus();

		// add additional test code here
		assertEquals("", result);
	}

	
	@Test
	public void testGetApplicationUuid_1()
		throws Exception {
		NOCApplicationRemark fixture = new NOCApplicationRemark("", "", "", "", "", new Boolean(true), "", new Long(1L), "", new Long(1L), "", "", "");

		String result = fixture.getApplicationUuid();

		// add additional test code here
		assertEquals("", result);
	}

	
	@Test
	public void testGetCreatedBy_1()
		throws Exception {
		NOCApplicationRemark fixture = new NOCApplicationRemark("", "", "", "", "", new Boolean(true), "", new Long(1L), "", new Long(1L), "", "", "");

		String result = fixture.getCreatedBy();

		// add additional test code here
		assertEquals("", result);
	}

	
	@Test
	public void testGetCreatedTime_1()
		throws Exception {
		NOCApplicationRemark fixture = new NOCApplicationRemark("", "", "", "", "", new Boolean(true), "", new Long(1L), "", new Long(1L), "", "", "");

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

	@Test
	public void testGetDocumentId_1()
		throws Exception {
		NOCApplicationRemark fixture = new NOCApplicationRemark("", "", "", "", "", new Boolean(true), "", new Long(1L), "", new Long(1L), "", "", "");

		String result = fixture.getDocumentId();

		// add additional test code here
		assertEquals("", result);
	}

	
	@Test
	public void testGetIsActive_1()
		throws Exception {
		NOCApplicationRemark fixture = new NOCApplicationRemark("", "", "", "", "", new Boolean(true), "", new Long(1L), "", new Long(1L), "", "", "");

		Boolean result = fixture.getIsActive();

		// add additional test code here
		assertNotNull(result);
		assertEquals("true", result.toString());
		assertEquals(true, result.booleanValue());
	}

	
	@Test
	public void testGetLastModifiedBy_1()
		throws Exception {
		NOCApplicationRemark fixture = new NOCApplicationRemark("", "", "", "", "", new Boolean(true), "", new Long(1L), "", new Long(1L), "", "", "");

		String result = fixture.getLastModifiedBy();

		// add additional test code here
		assertEquals("", result);
	}

	
	@Test
	public void testGetLastModifiedTime_1()
		throws Exception {
		NOCApplicationRemark fixture = new NOCApplicationRemark("", "", "", "", "", new Boolean(true), "", new Long(1L), "", new Long(1L), "", "", "");

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

	
	@Test
	public void testGetPreviousRemarkId_1()
		throws Exception {
		NOCApplicationRemark fixture = new NOCApplicationRemark("", "", "", "", "", new Boolean(true), "", new Long(1L), "", new Long(1L), "", "", "");

		String result = fixture.getPreviousRemarkId();

		// add additional test code here
		assertEquals("", result);
	}

	
	@Test
	public void testGetRemark_1()
		throws Exception {
		NOCApplicationRemark fixture = new NOCApplicationRemark("", "", "", "", "", new Boolean(true), "", new Long(1L), "", new Long(1L), "", "", "");

		String result = fixture.getRemark();

		// add additional test code here
		assertEquals("", result);
	}

	
	@Test
	public void testGetRemarkBy_1()
		throws Exception {
		NOCApplicationRemark fixture = new NOCApplicationRemark("", "", "", "", "", new Boolean(true), "", new Long(1L), "", new Long(1L), "", "", "");

		String result = fixture.getRemarkBy();

		// add additional test code here
		assertEquals("", result);
	}


	@Test
	public void testGetRemarkId_1()
		throws Exception {
		NOCApplicationRemark fixture = new NOCApplicationRemark("", "", "", "", "", new Boolean(true), "", new Long(1L), "", new Long(1L), "", "", "");

		String result = fixture.getRemarkId();

		// add additional test code here
		assertEquals("", result);
	}

	
	@Test
	public void testGetTenantId_1()
		throws Exception {
		NOCApplicationRemark fixture = new NOCApplicationRemark("", "", "", "", "", new Boolean(true), "", new Long(1L), "", new Long(1L), "", "", "");

		String result = fixture.getTenantId();

		// add additional test code here
		assertEquals("", result);
	}

	
	@Test
	public void testSetApplicationStatus_1()
		throws Exception {
		NOCApplicationRemark fixture = new NOCApplicationRemark("", "", "", "", "", new Boolean(true), "", new Long(1L), "", new Long(1L), "", "", "");
		String applicationStatus = "";

		fixture.setApplicationStatus(applicationStatus);

		// add additional test code here
	}

	
	@Test
	public void testSetApplicationUuid_1()
		throws Exception {
		NOCApplicationRemark fixture = new NOCApplicationRemark("", "", "", "", "", new Boolean(true), "", new Long(1L), "", new Long(1L), "", "", "");
		String applicationUuid = "";

		fixture.setApplicationUuid(applicationUuid);

		// add additional test code here
	}


	@Test
	public void testSetCreatedBy_1()
		throws Exception {
		NOCApplicationRemark fixture = new NOCApplicationRemark("", "", "", "", "", new Boolean(true), "", new Long(1L), "", new Long(1L), "", "", "");
		String createdBy = "";

		fixture.setCreatedBy(createdBy);

		// add additional test code here
	}

	
	@Test
	public void testSetCreatedTime_1()
		throws Exception {
		NOCApplicationRemark fixture = new NOCApplicationRemark("", "", "", "", "", new Boolean(true), "", new Long(1L), "", new Long(1L), "", "", "");
		Long createdTime = new Long(1L);

		fixture.setCreatedTime(createdTime);

		// add additional test code here
	}

	
	@Test
	public void testSetDocumentId_1()
		throws Exception {
		NOCApplicationRemark fixture = new NOCApplicationRemark("", "", "", "", "", new Boolean(true), "", new Long(1L), "", new Long(1L), "", "", "");
		String documentId = "";

		fixture.setDocumentId(documentId);

		// add additional test code here
	}


	@Test
	public void testSetIsActive_1()
		throws Exception {
		NOCApplicationRemark fixture = new NOCApplicationRemark("", "", "", "", "", new Boolean(true), "", new Long(1L), "", new Long(1L), "", "", "");
		Boolean isActive = new Boolean(true);

		fixture.setIsActive(isActive);

		// add additional test code here
	}

	
	@Test
	public void testSetLastModifiedBy_1()
		throws Exception {
		NOCApplicationRemark fixture = new NOCApplicationRemark("", "", "", "", "", new Boolean(true), "", new Long(1L), "", new Long(1L), "", "", "");
		String lastModifiedBy = "";

		fixture.setLastModifiedBy(lastModifiedBy);

		// add additional test code here
	}


	@Test
	public void testSetLastModifiedTime_1()
		throws Exception {
		NOCApplicationRemark fixture = new NOCApplicationRemark("", "", "", "", "", new Boolean(true), "", new Long(1L), "", new Long(1L), "", "", "");
		Long lastModifiedTime = new Long(1L);

		fixture.setLastModifiedTime(lastModifiedTime);

		// add additional test code here
	}

	
	@Test
	public void testSetPreviousRemarkId_1()
		throws Exception {
		NOCApplicationRemark fixture = new NOCApplicationRemark("", "", "", "", "", new Boolean(true), "", new Long(1L), "", new Long(1L), "", "", "");
		String previousRemarkId = "";

		fixture.setPreviousRemarkId(previousRemarkId);

		// add additional test code here
	}

	
	@Test
	public void testSetRemark_1()
		throws Exception {
		NOCApplicationRemark fixture = new NOCApplicationRemark("", "", "", "", "", new Boolean(true), "", new Long(1L), "", new Long(1L), "", "", "");
		String remark = "";

		fixture.setRemark(remark);

		// add additional test code here
	}

	
	@Test
	public void testSetRemarkBy_1()
		throws Exception {
		NOCApplicationRemark fixture = new NOCApplicationRemark("", "", "", "", "", new Boolean(true), "", new Long(1L), "", new Long(1L), "", "", "");
		String remarkBy = "";

		fixture.setRemarkBy(remarkBy);

		// add additional test code here
	}

		@Test
	public void testSetRemarkId_1()
		throws Exception {
		NOCApplicationRemark fixture = new NOCApplicationRemark("", "", "", "", "", new Boolean(true), "", new Long(1L), "", new Long(1L), "", "", "");
		String remarkId = "";

		fixture.setRemarkId(remarkId);

		// add additional test code here
	}

	@Test
	public void testSetTenantId_1()
		throws Exception {
		NOCApplicationRemark fixture = new NOCApplicationRemark("", "", "", "", "", new Boolean(true), "", new Long(1L), "", new Long(1L), "", "", "");
		String tenantId = "";

		fixture.setTenantId(tenantId);

		// add additional test code here
	}

	
	@Before
	public void setUp()
		throws Exception {
		// add additional set up code here
	}

	
	@After
	public void tearDown()
		throws Exception {
		// Add additional tear down code here
	}

	
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(NOCApplicationRemarkTest.class);
	}
}