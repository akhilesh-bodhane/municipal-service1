package org.egov.prscp.web.models;

import org.junit.*;
import static org.junit.Assert.*;

/**
 * The class <code>SMSRequestTest</code> contains tests for the class <code>{@link SMSRequest}</code>.
 *
 * @generatedBy CodePro at 25/5/20 3:50 PM
 * @author Aniket.Marathe
 * @version $Revision: 1.0 $
 */
public class SMSRequestTest {
	/**
	 * Run the SMSRequest(String,String) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:50 PM
	 */
	@Test
	public void testSMSRequest_1()
		throws Exception {
		String mobileNumber = "";
		String message = "";

		SMSRequest result = new SMSRequest(mobileNumber, message);

		// add additional test code here
		assertNotNull(result);
		assertEquals("", result.getMessage());
		assertEquals("", result.getMobileNumber());
	}

	/**
	 * Run the SMSRequest.SMSRequestBuilder builder() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:50 PM
	 */
	@Test
	public void testBuilder_1()
		throws Exception {

		SMSRequest.SMSRequestBuilder result = SMSRequest.builder();

		// add additional test code here
		assertNotNull(result);
		assertEquals("SMSRequest.SMSRequestBuilder(mobileNumber=null, message=null)", result.toString());
	}

	/**
	 * Run the String getMessage() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:50 PM
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
	 * @generatedBy CodePro at 25/5/20 3:50 PM
	 */
	@Test
	public void testGetMobileNumber_1()
		throws Exception {
		SMSRequest fixture = new SMSRequest("", "");

		String result = fixture.getMobileNumber();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the void setMessage(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:50 PM
	 */
	@Test
	public void testSetMessage_1()
		throws Exception {
		SMSRequest fixture = new SMSRequest("", "");
		String message = "";

		fixture.setMessage(message);

		// add additional test code here
	}

	/**
	 * Run the void setMobileNumber(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:50 PM
	 */
	@Test
	public void testSetMobileNumber_1()
		throws Exception {
		SMSRequest fixture = new SMSRequest("", "");
		String mobileNumber = "";

		fixture.setMobileNumber(mobileNumber);

		// add additional test code here
	}

	/**
	 * Run the Sms toDomain() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:50 PM
	 */
	@Test
	public void testToDomain_1()
		throws Exception {
		SMSRequest fixture = new SMSRequest("", "");

		Sms result = fixture.toDomain();

		// add additional test code here
		assertNotNull(result);
		assertEquals("Sms(mobileNumber=, message=, priority=high)", result.toString());
		assertEquals("", result.getMessage());
		assertEquals(false, result.isValid());
		assertEquals("", result.getMobileNumber());
	}

	/**
	 * Perform pre-test initialization.
	 *
	 * @throws Exception
	 *         if the initialization fails for some reason
	 *
	 * @generatedBy CodePro at 25/5/20 3:50 PM
	 */
	@Before
	public void setUp()
		throws Exception {
		// add additional set up code here
	}

	/**
	 * Perform post-test clean-up.
	 *
	 * @throws Exception
	 *         if the clean-up fails for some reason
	 *
	 * @generatedBy CodePro at 25/5/20 3:50 PM
	 */
	@After
	public void tearDown()
		throws Exception {
		// Add additional tear down code here
	}

	/**
	 * Launch the test.
	 *
	 * @param args the command line arguments
	 *
	 * @generatedBy CodePro at 25/5/20 3:50 PM
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(SMSRequestTest.class);
	}
}