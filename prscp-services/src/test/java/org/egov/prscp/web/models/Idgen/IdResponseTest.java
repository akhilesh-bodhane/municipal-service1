package org.egov.prscp.web.models.Idgen;

import org.junit.*;
import static org.junit.Assert.*;

/**
 * The class <code>IdResponseTest</code> contains tests for the class <code>{@link IdResponse}</code>.
 *
 * @generatedBy CodePro at 25/5/20 3:54 PM
 * @author Aniket.Marathe
 * @version $Revision: 1.0 $
 */
public class IdResponseTest {
	/**
	 * Run the IdResponse() constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:54 PM
	 */
	@Test
	public void testIdResponse_1()
		throws Exception {

		IdResponse result = new IdResponse();

		// add additional test code here
		assertNotNull(result);
		assertEquals("IdResponse(id=null)", result.toString());
		assertEquals(null, result.getId());
	}

	/**
	 * Run the IdResponse(String) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:54 PM
	 */
	@Test
	public void testIdResponse_2()
		throws Exception {
		String id = "";

		IdResponse result = new IdResponse(id);

		// add additional test code here
		assertNotNull(result);
		assertEquals("IdResponse(id=)", result.toString());
		assertEquals("", result.getId());
	}

	/**
	 * Run the IdResponse.IdResponseBuilder builder() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:54 PM
	 */
	@Test
	public void testBuilder_1()
		throws Exception {

		IdResponse.IdResponseBuilder result = IdResponse.builder();

		// add additional test code here
		assertNotNull(result);
		assertEquals("IdResponse.IdResponseBuilder(id=null)", result.toString());
	}

	/**
	 * Run the boolean canEqual(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:54 PM
	 */
	@Test
	public void testCanEqual_1()
		throws Exception {
		IdResponse fixture = new IdResponse("");
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
	 * @generatedBy CodePro at 25/5/20 3:54 PM
	 */
	@Test
	public void testCanEqual_2()
		throws Exception {
		IdResponse fixture = new IdResponse("");
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
	 * @generatedBy CodePro at 25/5/20 3:54 PM
	 */
	@Test
	public void testEquals_1()
		throws Exception {
		IdResponse fixture = new IdResponse("");
		Object o = new IdResponse("");

		boolean result = fixture.equals(o);

		// add additional test code here
		assertEquals(true, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:54 PM
	 */
	@Test
	public void testEquals_2()
		throws Exception {
		IdResponse fixture = new IdResponse("");
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
	 * @generatedBy CodePro at 25/5/20 3:54 PM
	 */
	@Test
	public void testEquals_3()
		throws Exception {
		IdResponse fixture = new IdResponse("");
		Object o = new IdResponse("");

		boolean result = fixture.equals(o);

		// add additional test code here
		assertEquals(true, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:54 PM
	 */
	@Test
	public void testEquals_4()
		throws Exception {
		IdResponse fixture = new IdResponse("");
		Object o = new IdResponse("");

		boolean result = fixture.equals(o);

		// add additional test code here
		assertEquals(true, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:54 PM
	 */
	@Test
	public void testEquals_5()
		throws Exception {
		IdResponse fixture = new IdResponse((String) null);
		Object o = new IdResponse((String) null);

		boolean result = fixture.equals(o);

		// add additional test code here
		assertEquals(true, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:54 PM
	 */
	@Test
	public void testEquals_6()
		throws Exception {
		IdResponse fixture = new IdResponse("");
		Object o = new IdResponse("");

		boolean result = fixture.equals(o);

		// add additional test code here
		assertEquals(true, result);
	}

	/**
	 * Run the String getId() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:54 PM
	 */
	@Test
	public void testGetId_1()
		throws Exception {
		IdResponse fixture = new IdResponse("");

		String result = fixture.getId();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the int hashCode() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:54 PM
	 */
	@Test
	public void testHashCode_1()
		throws Exception {
		IdResponse fixture = new IdResponse("");

		int result = fixture.hashCode();

		// add additional test code here
		assertEquals(59, result);
	}

	/**
	 * Run the int hashCode() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:54 PM
	 */
	@Test
	public void testHashCode_2()
		throws Exception {
		IdResponse fixture = new IdResponse((String) null);

		int result = fixture.hashCode();

		// add additional test code here
		assertEquals(102, result);
	}

	/**
	 * Run the void setId(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:54 PM
	 */
	@Test
	public void testSetId_1()
		throws Exception {
		IdResponse fixture = new IdResponse("");
		String id = "";

		fixture.setId(id);

		// add additional test code here
	}

	/**
	 * Perform pre-test initialization.
	 *
	 * @throws Exception
	 *         if the initialization fails for some reason
	 *
	 * @generatedBy CodePro at 25/5/20 3:54 PM
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
	 * @generatedBy CodePro at 25/5/20 3:54 PM
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
	 * @generatedBy CodePro at 25/5/20 3:54 PM
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(IdResponseTest.class);
	}
}