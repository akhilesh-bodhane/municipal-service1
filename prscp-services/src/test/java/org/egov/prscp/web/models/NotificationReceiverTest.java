package org.egov.prscp.web.models;

import java.util.List;
import org.easymock.EasyMock;
import org.junit.*;
import static org.junit.Assert.*;


public class NotificationReceiverTest {
	
	@Test
	public void testNotificationReceiver_1()
		throws Exception {

		NotificationReceiver result = new NotificationReceiver();

		assertNotNull(result);
		assertEquals("NotificationReceiver(tenantId=null, moduleCode=null, receiverType=null, receiverUuid=null, senderUuid=null, contactDetails=null)", result.toString());
		assertEquals(null, result.getSenderUuid());
		assertEquals(null, result.getReceiverUuid());
		assertEquals(null, result.getReceiverType());
		assertEquals(null, result.getTenantId());
		assertEquals(null, result.getModuleCode());
		assertEquals(null, result.getContactDetails());
	}


	@Test
	public void testNotificationReceiver_2()
		throws Exception {
		String tenantId = "";
		String moduleCode = "";
		String receiverType = "";
		String receiverUuid = "";
		String senderUuid = "";
		List<ContactDetails> contactDetails = EasyMock.createMock(List.class);
	
		EasyMock.replay(contactDetails);

		NotificationReceiver result = new NotificationReceiver(tenantId, moduleCode, receiverType, receiverUuid, senderUuid, contactDetails);

	
		EasyMock.verify(contactDetails);
		assertNotNull(result);
		assertEquals("NotificationReceiver(tenantId=, moduleCode=, receiverType=, receiverUuid=, senderUuid=, contactDetails=EasyMock for interface java.util.List)", result.toString());
		assertEquals("", result.getSenderUuid());
		assertEquals("", result.getReceiverUuid());
		assertEquals("", result.getReceiverType());
		assertEquals("", result.getTenantId());
		assertEquals("", result.getModuleCode());
	}


	@Test
	public void testBuilder_1()
		throws Exception {

		NotificationReceiver.NotificationReceiverBuilder result = NotificationReceiver.builder();

		// add additional test code here
		assertNotNull(result);
		assertEquals("NotificationReceiver.NotificationReceiverBuilder(tenantId=null, moduleCode=null, receiverType=null, receiverUuid=null, senderUuid=null, contactDetails=null)", result.toString());
	}


	@Test
	public void testGetContactDetails_1()
		throws Exception {
		NotificationReceiver fixture = new NotificationReceiver("", "", "", "", "", EasyMock.createNiceMock(List.class));

		List<ContactDetails> result = fixture.getContactDetails();

		assertNotNull(result);
		assertEquals(0, result.size());
	}


	@Test
	public void testGetModuleCode_1()
		throws Exception {
		NotificationReceiver fixture = new NotificationReceiver("", "", "", "", "", EasyMock.createNiceMock(List.class));

		String result = fixture.getModuleCode();

		assertEquals("", result);
	}


	@Test
	public void testGetReceiverType_1()
		throws Exception {
		NotificationReceiver fixture = new NotificationReceiver("", "", "", "", "", EasyMock.createNiceMock(List.class));

		String result = fixture.getReceiverType();

		assertEquals("", result);
	}

	@Test
	public void testGetReceiverUuid_1()
		throws Exception {
		NotificationReceiver fixture = new NotificationReceiver("", "", "", "", "", EasyMock.createNiceMock(List.class));

		String result = fixture.getReceiverUuid();

		assertEquals("", result);
	}


	@Test
	public void testGetSenderUuid_1()
		throws Exception {
		NotificationReceiver fixture = new NotificationReceiver("", "", "", "", "", EasyMock.createNiceMock(List.class));

		String result = fixture.getSenderUuid();

		assertEquals("", result);
	}

	
	@Test
	public void testGetTenantId_1()
		throws Exception {
		NotificationReceiver fixture = new NotificationReceiver("", "", "", "", "", EasyMock.createNiceMock(List.class));

		String result = fixture.getTenantId();

		assertEquals("", result);
	}


	@Test
	public void testSetContactDetails_1()
		throws Exception {
		NotificationReceiver fixture = new NotificationReceiver("", "", "", "", "", EasyMock.createNiceMock(List.class));
		List<ContactDetails> contactDetails = EasyMock.createMock(List.class);
		

		EasyMock.replay(contactDetails);

		fixture.setContactDetails(contactDetails);

		EasyMock.verify(contactDetails);
	}

	
	@Test
	public void testSetModuleCode_1()
		throws Exception {
		NotificationReceiver fixture = new NotificationReceiver("", "", "", "", "", EasyMock.createNiceMock(List.class));
		String moduleCode = "";

		fixture.setModuleCode(moduleCode);

	}


	@Test
	public void testSetReceiverType_1()
		throws Exception {
		NotificationReceiver fixture = new NotificationReceiver("", "", "", "", "", EasyMock.createNiceMock(List.class));
		String receiverType = "";

		fixture.setReceiverType(receiverType);

	}


	@Test
	public void testSetReceiverUuid_1()
		throws Exception {
		NotificationReceiver fixture = new NotificationReceiver("", "", "", "", "", EasyMock.createNiceMock(List.class));
		String receiverUuid = "";

		fixture.setReceiverUuid(receiverUuid);

	
	}

	
	@Test
	public void testSetSenderUuid_1()
		throws Exception {
		NotificationReceiver fixture = new NotificationReceiver("", "", "", "", "", EasyMock.createNiceMock(List.class));
		String senderUuid = "";

		fixture.setSenderUuid(senderUuid);

	}

	@Test
	public void testSetTenantId_1()
		throws Exception {
		NotificationReceiver fixture = new NotificationReceiver("", "", "", "", "", EasyMock.createNiceMock(List.class));
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
		new org.junit.runner.JUnitCore().run(NotificationReceiverTest.class);
	}
}