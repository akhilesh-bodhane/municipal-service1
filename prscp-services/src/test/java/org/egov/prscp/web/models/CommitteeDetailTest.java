package org.egov.prscp.web.models;

import java.util.List;
import org.easymock.EasyMock;
import org.junit.*;
import static org.junit.Assert.*;

public class CommitteeDetailTest {

	@Test
	public void testCommitteeDetail_1()
		throws Exception {

		CommitteeDetail result = new CommitteeDetail();

		assertNotNull(result);
		assertEquals(null, result.getLastModifiedTime());
		assertEquals(false, result.isActive());
		assertEquals(null, result.getCommitteeUuid());
		assertEquals(null, result.getCommitteeName());
		assertEquals(null, result.getModuleCode());
		assertEquals(null, result.getLastModifiedBy());
		assertEquals(null, result.getCommitteeMember());
		assertEquals(null, result.getCommitteeDescription());
		assertEquals(null, result.getTenantId());
		assertEquals(null, result.getCreatedBy());
		assertEquals(null, result.getCreatedTime());
	}


	@Test
	public void testCommitteeDetail_2()
		throws Exception {
		String committeeUuid = "";
		String committeeName = "";
		String committeeDescription = "";
		boolean isActive = true;
		List<CommitteeMember> committeeMember = EasyMock.createMock(List.class);
		String tenantId = "";
		String moduleCode = "";
		String createdBy = "";
		String lastModifiedBy = "";
		Long createdTime = new Long(1L);
		Long lastModifiedTime = new Long(1L);
			EasyMock.replay(committeeMember);

		CommitteeDetail result = new CommitteeDetail(committeeUuid, committeeName, committeeDescription, isActive, lastModifiedBy, lastModifiedBy, lastModifiedBy, committeeMember, tenantId, moduleCode, createdBy, lastModifiedBy, createdTime, lastModifiedTime);
		EasyMock.verify(committeeMember);
		assertNotNull(result);
		assertEquals(new Long(1L), result.getLastModifiedTime());
		assertEquals(true, result.isActive());
		assertEquals("", result.getCommitteeUuid());
		assertEquals("", result.getCommitteeName());
		assertEquals("", result.getModuleCode());
		assertEquals("", result.getLastModifiedBy());
		assertEquals("", result.getCommitteeDescription());
		assertEquals("", result.getTenantId());
		assertEquals("", result.getCreatedBy());
		assertEquals(new Long(1L), result.getCreatedTime());
	}

	@Test
	public void testBuilder_1()
		throws Exception {

		CommitteeDetail.CommitteeDetailBuilder result = CommitteeDetail.builder();
	assertNotNull(result);
		//assertEquals("CommitteeDetail.CommitteeDetailBuilder(committeeUuid=null, committeeName=null, committeeDescription=null, isActive=false, committeeMember=null, tenantId=null, moduleCode=null, createdBy=null, lastModifiedBy=null, createdTime=null, lastModifiedTime=null)", result.toString());
	}

	@Test
	public void testGetCommitteeDescription_1()
		throws Exception {
		CommitteeDetail fixture = new CommitteeDetail("", "", "", true, null, null, null, EasyMock.createNiceMock(List.class), "", "", "", "", new Long(1L), new Long(1L));

		String result = fixture.getCommitteeDescription();

		assertEquals("", result);
	}

	@Test
	public void testGetCommitteeMember_1()
		throws Exception {
		CommitteeDetail fixture = new CommitteeDetail("", "", "", true, null, null, null, EasyMock.createNiceMock(List.class), "", "", "", "", new Long(1L), new Long(1L));

		List<CommitteeMember> result = fixture.getCommitteeMember();

	
		assertNotNull(result);
		assertEquals(0, result.size());
	}

	@Test
	public void testGetCommitteeName_1()
		throws Exception {
		CommitteeDetail fixture = new CommitteeDetail("", "", "", true, null, null, null, EasyMock.createNiceMock(List.class), "", "", "", "", new Long(1L), new Long(1L));

		String result = fixture.getCommitteeName();

		assertEquals("", result);
	}

	@Test
	public void testGetCommitteeUuid_1()
		throws Exception {
		CommitteeDetail fixture = new CommitteeDetail("", "", "", true, null, null, null, EasyMock.createNiceMock(List.class), "", "", "", "", new Long(1L), new Long(1L));

		String result = fixture.getCommitteeUuid();

		assertEquals("", result);
	}

	@Test
	public void testGetCreatedBy_1()
		throws Exception {
		CommitteeDetail fixture = new CommitteeDetail("", "", "", true, null, null, null, EasyMock.createNiceMock(List.class), "", "", "", "", new Long(1L), new Long(1L));

		String result = fixture.getCreatedBy();
		assertEquals("", result);
	}

	@Test
	public void testGetCreatedTime_1()
		throws Exception {
		CommitteeDetail fixture = new CommitteeDetail("", "", "", true, null, null, null, EasyMock.createNiceMock(List.class), "", "", "", "", new Long(1L), new Long(1L));

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
	public void testGetLastModifiedBy_1()
		throws Exception {
		CommitteeDetail fixture = new CommitteeDetail("", "", "", true, null, null, null, EasyMock.createNiceMock(List.class), "", "", "", "", new Long(1L), new Long(1L));

		String result = fixture.getLastModifiedBy();

		assertEquals("", result);
	}
	@Test
	public void testGetLastModifiedTime_1()
		throws Exception {
		CommitteeDetail fixture = new CommitteeDetail("", "", "", true, null, null, null, EasyMock.createNiceMock(List.class), "", "", "", "", new Long(1L), new Long(1L));

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
		CommitteeDetail fixture = new CommitteeDetail("", "", "", true, null, null, null, EasyMock.createNiceMock(List.class), "", "", "", "", new Long(1L), new Long(1L));

		String result = fixture.getModuleCode();
	assertEquals("", result);
	}

		@Test
	public void testGetTenantId_1()
		throws Exception {
		CommitteeDetail fixture = new CommitteeDetail("", "", "", true, null, null, null, EasyMock.createNiceMock(List.class), "", "", "", "", new Long(1L), new Long(1L));

		String result = fixture.getTenantId();
		assertEquals("", result);
	}

	@Test
	public void testIsActive_1()
		throws Exception {
		CommitteeDetail fixture = new CommitteeDetail("", "", "", true, null, null, null, EasyMock.createNiceMock(List.class), "", "", "", "", new Long(1L), new Long(1L));

		boolean result = fixture.isActive();

		assertEquals(true, result);
	}

	@Test
	public void testIsActive_2()
		throws Exception {
		CommitteeDetail fixture = new CommitteeDetail("", "", "", false, null, null, null, EasyMock.createNiceMock(List.class), "", "", "", "", new Long(1L), new Long(1L));

		boolean result = fixture.isActive();

		assertEquals(false, result);
	}

	@Test
	public void testSetActive_1()
		throws Exception {
		CommitteeDetail fixture = new CommitteeDetail("", "", "", true, null, null, null, EasyMock.createNiceMock(List.class), "", "", "", "", new Long(1L), new Long(1L));
		boolean isActive = true;

		fixture.setActive(isActive);

	}

	@Test
	public void testSetCommitteeDescription_1()
		throws Exception {
		CommitteeDetail fixture = new CommitteeDetail("", "", "", true, null, null, null, EasyMock.createNiceMock(List.class), "", "", "", "", new Long(1L), new Long(1L));
		String committeeDescription = "";

		fixture.setCommitteeDescription(committeeDescription);

	}

	
	@Test
	public void testSetCommitteeMember_1()
		throws Exception {
		CommitteeDetail fixture = new CommitteeDetail("", "", "", true, null, null, null, EasyMock.createNiceMock(List.class), "", "", "", "", new Long(1L), new Long(1L));
		List<CommitteeMember> committeeMember = EasyMock.createMock(List.class);
		EasyMock.replay(committeeMember);

		fixture.setCommitteeMember(committeeMember);
		EasyMock.verify(committeeMember);
	}

	@Test
	public void testSetCommitteeName_1()
		throws Exception {
		CommitteeDetail fixture = new CommitteeDetail("", "", "", true, null, null, null, EasyMock.createNiceMock(List.class), "", "", "", "", new Long(1L), new Long(1L));
		String committeeName = "";

		fixture.setCommitteeName(committeeName);

	}

	@Test
	public void testSetCommitteeUuid_1()
		throws Exception {
		CommitteeDetail fixture = new CommitteeDetail("", "", "", true, null, null, null, EasyMock.createNiceMock(List.class), "", "", "", "", new Long(1L), new Long(1L));
		String committeeUuid = "";

		fixture.setCommitteeUuid(committeeUuid);

	}

	
	@Test
	public void testSetCreatedBy_1()
		throws Exception {
		CommitteeDetail fixture = new CommitteeDetail("", "", "", true, null, null, null, EasyMock.createNiceMock(List.class), "", "", "", "", new Long(1L), new Long(1L));
		String createdBy = "";

		fixture.setCreatedBy(createdBy);

	}

	
	@Test
	public void testSetCreatedTime_1()
		throws Exception {
		CommitteeDetail fixture = new CommitteeDetail("", "", "", true, null, null, null, EasyMock.createNiceMock(List.class), "", "", "", "", new Long(1L), new Long(1L));
		Long createdTime = new Long(1L);

		fixture.setCreatedTime(createdTime);

	}

	
	@Test
	public void testSetLastModifiedBy_1()
		throws Exception {
		CommitteeDetail fixture = new CommitteeDetail("", "", "", true, null, null, null, EasyMock.createNiceMock(List.class), "", "", "", "", new Long(1L), new Long(1L));
		String lastModifiedBy = "";

		fixture.setLastModifiedBy(lastModifiedBy);

		
	}

	
	@Test
	public void testSetLastModifiedTime_1()
		throws Exception {
		CommitteeDetail fixture = new CommitteeDetail("", "", "", true, null, null, null, EasyMock.createNiceMock(List.class), "", "", "", "", new Long(1L), new Long(1L));
		Long lastModifiedTime = new Long(1L);

		fixture.setLastModifiedTime(lastModifiedTime);

	}

	@Test
	public void testSetModuleCode_1()
		throws Exception {
		CommitteeDetail fixture = new CommitteeDetail("", "", "", true, null, null, null, EasyMock.createNiceMock(List.class), "", "", "", "", new Long(1L), new Long(1L));
		String moduleCode = "";

		fixture.setModuleCode(moduleCode);

	}

	@Test
	public void testSetTenantId_1()
		throws Exception {
		CommitteeDetail fixture = new CommitteeDetail("", "", "", true, null, null, null, EasyMock.createNiceMock(List.class), "", "", "", "", new Long(1L), new Long(1L));
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
		new org.junit.runner.JUnitCore().run(CommitteeDetailTest.class);
	}
}