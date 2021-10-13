package org.egov.pm.model;

import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class SMSRequestTest {

	@Test
	public void testSMSRequest_1() throws Exception {

		SMSRequest result = new SMSRequest();

		assertNotNull(result);
		assertEquals(null, result.getMessage());
		assertEquals(null, result.getMobileNumber());
	}

	@Test
	public void testSMSRequest_2() throws Exception {
		String mobileNumber = "";
		String message = "";

		SMSRequest result = new SMSRequest(mobileNumber, message);

		assertNotNull(result);
		assertEquals("", result.getMessage());
		assertEquals("", result.getMobileNumber());
	}

	@Test
	public void testGetMessage_1() throws Exception {
		SMSRequest fixture = new SMSRequest("", "");

		String result = fixture.getMessage();

		assertEquals("", result);
	}

	@Test
	public void testGetMobileNumber_1() throws Exception {
		SMSRequest fixture = new SMSRequest("", "");

		String result = fixture.getMobileNumber();
		assertEquals("", result);
	}

}