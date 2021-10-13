package org.egov.prscp.web.models;

import org.junit.*;
import static org.junit.Assert.*;

public class CommitteeMemberTest {
	@Test
	public void testCommitteeMember_1()
		throws Exception {

		CommitteeMember result = new CommitteeMember();

		assertNotNull(result);
		assertEquals("CommitteeMember(committeeMemberUuid=null, userUuid=null, departmentUuid=null, departmentName=null, committeeUuid=null, isActive=false, tenantId=null, moduleCode=null, createdBy=null, lastModifiedBy=null, createdTime=null, lastModifiedTime=null)", result.toString());
		assertEquals(null, result.getLastModifiedTime());
		assertEquals(false, result.isActive());
		assertEquals(null, result.getCommitteeUuid());
		assertEquals(null, result.getModuleCode());
		assertEquals(null, result.getLastModifiedBy());
		assertEquals(null, result.getUserUuid());
		assertEquals(null, result.getCommitteeMemberUuid());
		assertEquals(null, result.getDepartmentUuid());
		assertEquals(null, result.getDepartmentName());
		assertEquals(null, result.getTenantId());
		assertEquals(null, result.getCreatedBy());
		assertEquals(null, result.getCreatedTime());
	}

	@Test
	public void testCommitteeMember_2()
		throws Exception {
		String committeeMemberUuid = "";
		String userUuid = "";
		String departmentUuid = "";
		String departmentName = "";
		String committeeUuid = "";
		boolean isActive = true;
		String tenantId = "";
		String moduleCode = "";
		String createdBy = "";
		String lastModifiedBy = "";
		Long createdTime = new Long(1L);
		Long lastModifiedTime = new Long(1L);

		CommitteeMember result = new CommitteeMember(committeeMemberUuid, userUuid, departmentUuid, departmentName, committeeUuid, isActive, tenantId, moduleCode, createdBy, lastModifiedBy, createdTime, lastModifiedTime);

		
		assertNotNull(result);
		assertEquals("CommitteeMember(committeeMemberUuid=, userUuid=, departmentUuid=, departmentName=, committeeUuid=, isActive=true, tenantId=, moduleCode=, createdBy=, lastModifiedBy=, createdTime=1, lastModifiedTime=1)", result.toString());
		assertEquals(new Long(1L), result.getLastModifiedTime());
		assertEquals(true, result.isActive());
		assertEquals("", result.getCommitteeUuid());
		assertEquals("", result.getModuleCode());
		assertEquals("", result.getLastModifiedBy());
		assertEquals("", result.getUserUuid());
		assertEquals("", result.getCommitteeMemberUuid());
		assertEquals("", result.getDepartmentUuid());
		assertEquals("", result.getDepartmentName());
		assertEquals("", result.getTenantId());
		assertEquals("", result.getCreatedBy());
		assertEquals(new Long(1L), result.getCreatedTime());
	}

	
	@Test
	public void testBuilder_1()
		throws Exception {

		CommitteeMember.CommitteeMemberBuilder result = CommitteeMember.builder();

		
		assertNotNull(result);
		assertEquals("CommitteeMember.CommitteeMemberBuilder(committeeMemberUuid=null, userUuid=null, departmentUuid=null, departmentName=null, committeeUuid=null, isActive=false, tenantId=null, moduleCode=null, createdBy=null, lastModifiedBy=null, createdTime=null, lastModifiedTime=null)", result.toString());
	}

	
	@Test
	public void testGetCommitteeMemberUuid_1()
		throws Exception {
		CommitteeMember fixture = new CommitteeMember("", "", "", "", "", true, "", "", "", "", new Long(1L), new Long(1L));

		String result = fixture.getCommitteeMemberUuid();

		assertEquals("", result);
	}

	
	@Test
	public void testGetCommitteeUuid_1()
		throws Exception {
		CommitteeMember fixture = new CommitteeMember("", "", "", "", "", true, "", "", "", "", new Long(1L), new Long(1L));

		String result = fixture.getCommitteeUuid();

		assertEquals("", result);
	}


	@Test
	public void testGetCreatedBy_1()
		throws Exception {
		CommitteeMember fixture = new CommitteeMember("", "", "", "", "", true, "", "", "", "", new Long(1L), new Long(1L));

		String result = fixture.getCreatedBy();

		assertEquals("", result);
	}

	
	@Test
	public void testGetCreatedTime_1()
		throws Exception {
		CommitteeMember fixture = new CommitteeMember("", "", "", "", "", true, "", "", "", "", new Long(1L), new Long(1L));

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
	public void testGetDepartmentName_1()
		throws Exception {
		CommitteeMember fixture = new CommitteeMember("", "", "", "", "", true, "", "", "", "", new Long(1L), new Long(1L));

		String result = fixture.getDepartmentName();

		// add additional test code here
		assertEquals("", result);
	}


	@Test
	public void testGetDepartmentUuid_1()
		throws Exception {
		CommitteeMember fixture = new CommitteeMember("", "", "", "", "", true, "", "", "", "", new Long(1L), new Long(1L));

		String result = fixture.getDepartmentUuid();

		// add additional test code here
		assertEquals("", result);
	}


	@Test
	public void testGetLastModifiedBy_1()
		throws Exception {
		CommitteeMember fixture = new CommitteeMember("", "", "", "", "", true, "", "", "", "", new Long(1L), new Long(1L));

		String result = fixture.getLastModifiedBy();

	
		assertEquals("", result);
	}


	@Test
	public void testGetLastModifiedTime_1()
		throws Exception {
		CommitteeMember fixture = new CommitteeMember("", "", "", "", "", true, "", "", "", "", new Long(1L), new Long(1L));

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
	public void testGetModuleCode_1()
		throws Exception {
		CommitteeMember fixture = new CommitteeMember("", "", "", "", "", true, "", "", "", "", new Long(1L), new Long(1L));

		String result = fixture.getModuleCode();

		
		assertEquals("", result);
	}

	
	@Test
	public void testGetTenantId_1()
		throws Exception {
		CommitteeMember fixture = new CommitteeMember("", "", "", "", "", true, "", "", "", "", new Long(1L), new Long(1L));

		String result = fixture.getTenantId();

		// add additional test code here
		assertEquals("", result);
	}

	
	@Test
	public void testGetUserUuid_1()
		throws Exception {
		CommitteeMember fixture = new CommitteeMember("", "", "", "", "", true, "", "", "", "", new Long(1L), new Long(1L));

		String result = fixture.getUserUuid();

		assertEquals("", result);
	}

	
	@Test
	public void testIsActive_1()
		throws Exception {
		CommitteeMember fixture = new CommitteeMember("", "", "", "", "", true, "", "", "", "", new Long(1L), new Long(1L));

		boolean result = fixture.isActive();

		assertEquals(true, result);
	}

	
	@Test
	public void testIsActive_2()
		throws Exception {
		CommitteeMember fixture = new CommitteeMember("", "", "", "", "", false, "", "", "", "", new Long(1L), new Long(1L));

		boolean result = fixture.isActive();

	
		assertEquals(false, result);
	}

	
	@Test
	public void testSetActive_1()
		throws Exception {
		CommitteeMember fixture = new CommitteeMember("", "", "", "", "", true, "", "", "", "", new Long(1L), new Long(1L));
		boolean isActive = true;

		fixture.setActive(isActive);

		
	}

	
	@Test
	public void testSetCommitteeMemberUuid_1()
		throws Exception {
		CommitteeMember fixture = new CommitteeMember("", "", "", "", "", true, "", "", "", "", new Long(1L), new Long(1L));
		String committeeMemberUuid = "";

		fixture.setCommitteeMemberUuid(committeeMemberUuid);

	
	}

	
	@Test
	public void testSetCommitteeUuid_1()
		throws Exception {
		CommitteeMember fixture = new CommitteeMember("", "", "", "", "", true, "", "", "", "", new Long(1L), new Long(1L));
		String committeeUuid = "";

		fixture.setCommitteeUuid(committeeUuid);

	
	}

	
	public void testSetCreatedBy_1()
		throws Exception {
		CommitteeMember fixture = new CommitteeMember("", "", "", "", "", true, "", "", "", "", new Long(1L), new Long(1L));
		String createdBy = "";

		fixture.setCreatedBy(createdBy);

	}

	
	@Test
	public void testSetCreatedTime_1()
		throws Exception {
		CommitteeMember fixture = new CommitteeMember("", "", "", "", "", true, "", "", "", "", new Long(1L), new Long(1L));
		Long createdTime = new Long(1L);

		fixture.setCreatedTime(createdTime);

	}

	
	@Test
	public void testSetDepartmentName_1()
		throws Exception {
		CommitteeMember fixture = new CommitteeMember("", "", "", "", "", true, "", "", "", "", new Long(1L), new Long(1L));
		String departmentName = "";

		fixture.setDepartmentName(departmentName);

	}

	
	@Test
	public void testSetDepartmentUuid_1()
		throws Exception {
		CommitteeMember fixture = new CommitteeMember("", "", "", "", "", true, "", "", "", "", new Long(1L), new Long(1L));
		String departmentUuid = "";

		fixture.setDepartmentUuid(departmentUuid);

	}

	
	@Test
	public void testSetLastModifiedBy_1()
		throws Exception {
		CommitteeMember fixture = new CommitteeMember("", "", "", "", "", true, "", "", "", "", new Long(1L), new Long(1L));
		String lastModifiedBy = "";

		fixture.setLastModifiedBy(lastModifiedBy);

	}

	
	@Test
	public void testSetLastModifiedTime_1()
		throws Exception {
		CommitteeMember fixture = new CommitteeMember("", "", "", "", "", true, "", "", "", "", new Long(1L), new Long(1L));
		Long lastModifiedTime = new Long(1L);

		fixture.setLastModifiedTime(lastModifiedTime);

	}

	
	@Test
	public void testSetModuleCode_1()
		throws Exception {
		CommitteeMember fixture = new CommitteeMember("", "", "", "", "", true, "", "", "", "", new Long(1L), new Long(1L));
		String moduleCode = "";

		fixture.setModuleCode(moduleCode);

	}

	
	@Test
	public void testSetTenantId_1()
		throws Exception {
		CommitteeMember fixture = new CommitteeMember("", "", "", "", "", true, "", "", "", "", new Long(1L), new Long(1L));
		String tenantId = "";

		fixture.setTenantId(tenantId);

	}

	
	@Test
	public void testSetUserUuid_1()
		throws Exception {
		CommitteeMember fixture = new CommitteeMember("", "", "", "", "", true, "", "", "", "", new Long(1L), new Long(1L));
		String userUuid = "";

		fixture.setUserUuid(userUuid);

	
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
		new org.junit.runner.JUnitCore().run(CommitteeMemberTest.class);
	}
}