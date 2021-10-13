package org.egov.prscp.web.models;

import java.util.List;
import org.easymock.EasyMock;
import org.junit.*;
import static org.junit.Assert.*;


public class GuestsTest {

	@Test
	public void testGuests_1()
		throws Exception {

		Guests result = new Guests();

		assertNotNull(result);
		assertEquals(null, result.getEventDetailUuid());
		assertEquals(null, result.getTenantId());
		assertEquals(null, result.getModuleCode());
		assertEquals(null, result.getInviteGuest());
	}

	
	@Test
	public void testGuests_2()
		throws Exception {
		String tenantId = "";
		String moduleCode = "";
		String eventDetailUuid = "";
		List<InviteGuest> inviteGuest = EasyMock.createMock(List.class);
	
		EasyMock.replay(inviteGuest);

		Guests result = new Guests(tenantId, moduleCode, eventDetailUuid, inviteGuest);

		EasyMock.verify(inviteGuest);
		assertNotNull(result);
		assertEquals("", result.getEventDetailUuid());
		assertEquals("", result.getTenantId());
		assertEquals("", result.getModuleCode());
	}


	@Test
	public void testBuilder_1()
		throws Exception {

		Guests.GuestsBuilder result = Guests.builder();

		assertNotNull(result);
		assertEquals("Guests.GuestsBuilder(tenantId=null, moduleCode=null, eventDetailUuid=null, inviteGuest=null)", result.toString());
	}

	
	@Test
	public void testGetEventDetailUuid_1()
		throws Exception {
		Guests fixture = new Guests("", "", "", EasyMock.createNiceMock(List.class));

		String result = fixture.getEventDetailUuid();

		assertEquals("", result);
	}

	@Test
	public void testGetInviteGuest_1()
		throws Exception {
		Guests fixture = new Guests("", "", "", EasyMock.createNiceMock(List.class));

		List<InviteGuest> result = fixture.getInviteGuest();

		assertNotNull(result);
		assertEquals(0, result.size());
	}


	@Test
	public void testGetModuleCode_1()
		throws Exception {
		Guests fixture = new Guests("", "", "", EasyMock.createNiceMock(List.class));

		String result = fixture.getModuleCode();

		assertEquals("", result);
	}

	
	@Test
	public void testGetTenantId_1()
		throws Exception {
		Guests fixture = new Guests("", "", "", EasyMock.createNiceMock(List.class));

		String result = fixture.getTenantId();

		assertEquals("", result);
	}


	@Test
	public void testSetEventDetailUuid_1()
		throws Exception {
		Guests fixture = new Guests("", "", "", EasyMock.createNiceMock(List.class));
		String eventDetailUuid = "";

		fixture.setEventDetailUuid(eventDetailUuid);

	}


	@Test
	public void testSetInviteGuest_1()
		throws Exception {
		Guests fixture = new Guests("", "", "", EasyMock.createNiceMock(List.class));
		List<InviteGuest> inviteGuest = EasyMock.createMock(List.class);
	

		EasyMock.replay(inviteGuest);

		fixture.setInviteGuest(inviteGuest);

		EasyMock.verify(inviteGuest);
	}

	
	@Test
	public void testSetModuleCode_1()
		throws Exception {
		Guests fixture = new Guests("", "", "", EasyMock.createNiceMock(List.class));
		String moduleCode = "";

		fixture.setModuleCode(moduleCode);

		
	}

	
	@Test
	public void testSetTenantId_1()
		throws Exception {
		Guests fixture = new Guests("", "", "", EasyMock.createNiceMock(List.class));
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
		new org.junit.runner.JUnitCore().run(GuestsTest.class);
	}
}