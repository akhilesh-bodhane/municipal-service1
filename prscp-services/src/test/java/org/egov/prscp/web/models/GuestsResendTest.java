package org.egov.prscp.web.models;

import java.util.List;
import org.easymock.EasyMock;
import org.junit.*;
import static org.junit.Assert.*;

public class GuestsResendTest {
	
	@Test
	public void testGuestsResend_1()
		throws Exception {

		GuestsResend result = new GuestsResend();

		assertNotNull(result);
		assertEquals(null, result.getModuleName());
		assertEquals(false, result.isDefaultAll());
		assertEquals(null, result.getInvitationUuid());
		assertEquals(null, result.getContactDetails());
		assertEquals(null, result.getTenantId());
		assertEquals(null, result.getModuleCode());
	}

	
	@Test
	public void testGuestsResend_2()
		throws Exception {
		String tenantId = "";
		String moduleCode = "";
		String moduleName = "";
		String invitationUuid = "";
		List<ContactDetails> contactDetails = EasyMock.createMock(List.class);
		boolean defaultAll = true;
		EasyMock.replay(contactDetails);

		GuestsResend result = new GuestsResend(tenantId, moduleCode, moduleName, invitationUuid, contactDetails, defaultAll);

		EasyMock.verify(contactDetails);
		assertNotNull(result);
		assertEquals("", result.getModuleName());
		assertEquals(true, result.isDefaultAll());
		assertEquals("", result.getInvitationUuid());
		assertEquals("", result.getTenantId());
		assertEquals("", result.getModuleCode());
	}


	@Test
	public void testBuilder_1()
		throws Exception {

		GuestsResend.GuestsResendBuilder result = GuestsResend.builder();

		assertNotNull(result);
		assertEquals("GuestsResend.GuestsResendBuilder(tenantId=null, moduleCode=null, moduleName=null, invitationUuid=null, contactDetails=null, defaultAll=false)", result.toString());
	}


	@Test
	public void testGetContactDetails_1()
		throws Exception {
		GuestsResend fixture = new GuestsResend("", "", "", "", EasyMock.createNiceMock(List.class), true);

		List<ContactDetails> result = fixture.getContactDetails();

		assertNotNull(result);
		assertEquals(0, result.size());
	}


	@Test
	public void testGetInvitationUuid_1()
		throws Exception {
		GuestsResend fixture = new GuestsResend("", "", "", "", EasyMock.createNiceMock(List.class), true);

		String result = fixture.getInvitationUuid();

		assertEquals("", result);
	}


	@Test
	public void testGetModuleCode_1()
		throws Exception {
		GuestsResend fixture = new GuestsResend("", "", "", "", EasyMock.createNiceMock(List.class), true);

		String result = fixture.getModuleCode();

		assertEquals("", result);
	}


	@Test
	public void testGetModuleName_1()
		throws Exception {
		GuestsResend fixture = new GuestsResend("", "", "", "", EasyMock.createNiceMock(List.class), true);

		String result = fixture.getModuleName();

		assertEquals("", result);
	}


	@Test
	public void testGetTenantId_1()
		throws Exception {
		GuestsResend fixture = new GuestsResend("", "", "", "", EasyMock.createNiceMock(List.class), true);

		String result = fixture.getTenantId();

		assertEquals("", result);
	}


	@Test
	public void testIsDefaultAll_1()
		throws Exception {
		GuestsResend fixture = new GuestsResend("", "", "", "", EasyMock.createNiceMock(List.class), true);

		boolean result = fixture.isDefaultAll();

		assertEquals(true, result);
	}


	@Test
	public void testIsDefaultAll_2()
		throws Exception {
		GuestsResend fixture = new GuestsResend("", "", "", "", EasyMock.createNiceMock(List.class), false);

		boolean result = fixture.isDefaultAll();

		assertEquals(false, result);
	}


	@Test
	public void testSetContactDetails_1()
		throws Exception {
		GuestsResend fixture = new GuestsResend("", "", "", "", EasyMock.createNiceMock(List.class), true);
		List<ContactDetails> contactDetails = EasyMock.createMock(List.class);
		EasyMock.replay(contactDetails);

		fixture.setContactDetails(contactDetails);

		// add additional test code here
		EasyMock.verify(contactDetails);
	}


	@Test
	public void testSetDefaultAll_1()
		throws Exception {
		GuestsResend fixture = new GuestsResend("", "", "", "", EasyMock.createNiceMock(List.class), true);
		boolean defaultAll = true;

		fixture.setDefaultAll(defaultAll);

	}


	@Test
	public void testSetInvitationUuid_1()
		throws Exception {
		GuestsResend fixture = new GuestsResend("", "", "", "", EasyMock.createNiceMock(List.class), true);
		String invitationUuid = "";

		fixture.setInvitationUuid(invitationUuid);

	}


	@Test
	public void testSetModuleCode_1()
		throws Exception {
		GuestsResend fixture = new GuestsResend("", "", "", "", EasyMock.createNiceMock(List.class), true);
		String moduleCode = "";

		fixture.setModuleCode(moduleCode);

	}


	@Test
	public void testSetModuleName_1()
		throws Exception {
		GuestsResend fixture = new GuestsResend("", "", "", "", EasyMock.createNiceMock(List.class), true);
		String moduleName = "";

		fixture.setModuleName(moduleName);

	}


	@Test
	public void testSetTenantId_1()
		throws Exception {
		GuestsResend fixture = new GuestsResend("", "", "", "", EasyMock.createNiceMock(List.class), true);
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
		new org.junit.runner.JUnitCore().run(GuestsResendTest.class);
	}
}