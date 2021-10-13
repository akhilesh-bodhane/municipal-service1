package org.egov.ec.web.models;

import org.junit.*;
import static org.junit.Assert.*;

import org.egov.ec.web.models.SMSRequest;

/**
 * The class <code>SMSRequestTest</code> contains tests for the class <code>{@link SMSRequest}</code>.
 *
 * @generated at 17/5/20 2:10 PM
 * @version $Revision: 1.0 $
 */
public class SMSRequestTest {
	/**
	 * Run the SMSRequest() constructor test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:10 PM
	 */
	@Test
	public void testSMSRequest_1()
		throws Exception {

		SMSRequest result = new SMSRequest();

		// add additional test code here
		assertNotNull(result);
		assertEquals("SMSRequest(mobileNumber=null, message=null)", result.toString());
		assertEquals(null, result.getMessage());
		assertEquals(null, result.getMobileNumber());
	}

	/**
	 * Run the SMSRequest(String,String) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:10 PM
	 */
	@Test
	public void testSMSRequest_2()
		throws Exception {
		String mobileNumber = "";
		String message = "";

		SMSRequest result = new SMSRequest(mobileNumber, message);

		// add additional test code here
		assertNotNull(result);
		assertEquals("SMSRequest(mobileNumber=, message=)", result.toString());
		assertEquals("", result.getMessage());
		assertEquals("", result.getMobileNumber());
	}

	/**
	 * Run the SMSRequest.SMSRequestBuilder builder() method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:10 PM
	 */
	@Test
	public void testBuilder_1()
		throws Exception {

		SMSRequest.SMSRequestBuilder result = SMSRequest.builder();

		// add additional test code here
		assertNotNull(result);
		assertEquals("SMSRequest.SMSRequestBuilder(mobileNumber=null, message=null)", result.toString());
	}
	
	@Test
	public void testBuilder_2()
		throws Exception {

		SMSRequest.SMSRequestBuilder builder = SMSRequest.builder();
		builder.mobileNumber(null);
		builder.message(null);
		builder.build();
		
		SMSRequest.SMSRequestBuilder builder2 = SMSRequest.builder();
		builder2.mobileNumber(null);
		builder2.message(null);
		builder2.build();
		
		Assert.assertEquals(builder2.toString(), builder.toString());
	}

	/**
	 * Run the String getMessage() method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:10 PM
	 */
	@Test
	public void testGetMessage_1()
		throws Exception {
		SMSRequest fixture = new SMSRequest("", "");

		String result = fixture.getMessage();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the String getMobileNumber() method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:10 PM
	 */
	@Test
	public void testGetMobileNumber_1()
		throws Exception {
		SMSRequest fixture = new SMSRequest("", "");

		String result = fixture.getMobileNumber();

		// add additional test code here
		assertEquals("", result);
	}
}