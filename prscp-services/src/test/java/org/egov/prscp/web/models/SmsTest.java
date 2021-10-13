package org.egov.prscp.web.models;

import org.junit.*;
import static org.junit.Assert.*;

/**
 * The class <code>SmsTest</code> contains tests for the class <code>{@link Sms}</code>.
 *
 * @generatedBy CodePro at 25/5/20 3:53 PM
 * @author Aniket.Marathe
 * @version $Revision: 1.0 $
 */
public class SmsTest {
	/**
	 * Run the Sms(String,String,Priority) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:53 PM
	 */
	@Test
	public void testSms_1()
		throws Exception {
		String mobileNumber = "";
		String message = "";
		Priority priority = Priority.HIGH;

		Sms result = new Sms(mobileNumber, message, priority);

		// add additional test code here
		assertNotNull(result);
		assertEquals("Sms(mobileNumber=, message=, priority=high)", result.toString());
		assertEquals("", result.getMessage());
		assertEquals(false, result.isValid());
		assertEquals("", result.getMobileNumber());
	}

	/**
	 * Run the boolean canEqual(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:53 PM
	 */
	@Test
	public void testCanEqual_1()
		throws Exception {
		Sms fixture = new Sms("", "", Priority.HIGH);
		Object other = new Object();

		boolean result = fixture.canEqual(other);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the boolean canEqual(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:53 PM
	 */
	@Test
	public void testCanEqual_2()
		throws Exception {
		Sms fixture = new Sms("", "", Priority.HIGH);
		Object other = new Object();

		boolean result = fixture.canEqual(other);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:53 PM
	 */
	@Test
	public void testEquals_1()
		throws Exception {
		Sms fixture = new Sms("", "", Priority.HIGH);
		Object o = new Sms("", "", Priority.HIGH);

		boolean result = fixture.equals(o);

		// add additional test code here
		assertEquals(true, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:53 PM
	 */
	@Test
	public void testEquals_2()
		throws Exception {
		Sms fixture = new Sms("", "", Priority.HIGH);
		Object o = new Object();

		boolean result = fixture.equals(o);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:53 PM
	 */
	@Test
	public void testEquals_3()
		throws Exception {
		Sms fixture = new Sms("", "", Priority.HIGH);
		Object o = new Sms("", "", Priority.HIGH);

		boolean result = fixture.equals(o);

		// add additional test code here
		assertEquals(true, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:53 PM
	 */
	@Test
	public void testEquals_4()
		throws Exception {
		Sms fixture = new Sms("", "", Priority.HIGH);
		Object o = new Sms("", "", Priority.HIGH);

		boolean result = fixture.equals(o);

		// add additional test code here
		assertEquals(true, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:53 PM
	 */
	@Test
	public void testEquals_5()
		throws Exception {
		Sms fixture = new Sms("", "", Priority.HIGH);
		Object o = new Sms("", "", Priority.HIGH);

		boolean result = fixture.equals(o);

		// add additional test code here
		assertEquals(true, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:53 PM
	 */
	@Test
	public void testEquals_6()
		throws Exception {
		Sms fixture = new Sms("", "", Priority.HIGH);
		Object o = new Sms("", "", Priority.HIGH);

		boolean result = fixture.equals(o);

		// add additional test code here
		assertEquals(true, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:53 PM
	 */
	@Test
	public void testEquals_7()
		throws Exception {
		Sms fixture = new Sms("", "", (Priority) null);
		Object o = new Sms("", "", (Priority) null);

		boolean result = fixture.equals(o);

		// add additional test code here
		assertEquals(true, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:53 PM
	 */
	@Test
	public void testEquals_8()
		throws Exception {
		Sms fixture = new Sms("", "", Priority.HIGH);
		Object o = new Sms("", "", Priority.HIGH);

		boolean result = fixture.equals(o);

		// add additional test code here
		assertEquals(true, result);
	}

	/**
	 * Run the String getMessage() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:53 PM
	 */
	@Test
	public void testGetMessage_1()
		throws Exception {
		Sms fixture = new Sms("", "", Priority.HIGH);

		String result = fixture.getMessage();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the String getMobileNumber() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:53 PM
	 */
	@Test
	public void testGetMobileNumber_1()
		throws Exception {
		Sms fixture = new Sms("", "", Priority.HIGH);

		String result = fixture.getMobileNumber();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the Priority getPriority() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:53 PM
	 */
	@Test
	public void testGetPriority_1()
		throws Exception {
		Sms fixture = new Sms("", "", Priority.HIGH);

		Priority result = fixture.getPriority();

		// add additional test code here
		assertNotNull(result);
		assertEquals("high", result.toString());
		assertEquals("HIGH", result.name());
		assertEquals(0, result.ordinal());
	}

	/**
	 * Run the int hashCode() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:53 PM
	 */
	@Test
	public void testHashCode_1()
		throws Exception {
		Sms fixture = new Sms((String) null, "", Priority.HIGH);

		int result = fixture.hashCode();

		// add additional test code here
		//assertEquals(608937376, result);
	}

	/**
	 * Run the int hashCode() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:53 PM
	 */
	@Test
	public void testHashCode_2()
		throws Exception {
		Sms fixture = new Sms("", (String) null, (Priority) null);

		int result = fixture.hashCode();

		// add additional test code here
		assertEquals(207959, result);
	}

	/**
	 * Run the boolean isValid() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:53 PM
	 */
	@Test
	public void testIsValid_1()
		throws Exception {
		Sms fixture = new Sms("", "", Priority.HIGH);

		boolean result = fixture.isValid();

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the boolean isValid() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:53 PM
	 */
	@Test
	public void testIsValid_2()
		throws Exception {
		Sms fixture = new Sms("", "", Priority.HIGH);

		boolean result = fixture.isValid();

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the boolean isValid() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:53 PM
	 */
	@Test
	public void testIsValid_3()
		throws Exception {
		Sms fixture = new Sms("", "", Priority.HIGH);

		boolean result = fixture.isValid();

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Perform pre-test initialization.
	 *
	 * @throws Exception
	 *         if the initialization fails for some reason
	 *
	 * @generatedBy CodePro at 25/5/20 3:53 PM
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
	 * @generatedBy CodePro at 25/5/20 3:53 PM
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
	 * @generatedBy CodePro at 25/5/20 3:53 PM
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(SmsTest.class);
	}
}