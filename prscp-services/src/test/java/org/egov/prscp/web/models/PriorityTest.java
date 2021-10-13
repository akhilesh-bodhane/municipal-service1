package org.egov.prscp.web.models;

import org.junit.*;
import static org.junit.Assert.*;

/**
 * The class <code>PriorityTest</code> contains tests for the class <code>{@link Priority}</code>.
 *
 * @generatedBy CodePro at 25/5/20 3:44 PM
 * @author Aniket.Marathe
 * @version $Revision: 1.0 $
 */
public class PriorityTest {
	/**
	 * Run the String toString() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:44 PM
	 */
	@Test
	public void testToString_1()
		throws Exception {
		Priority fixture = Priority.HIGH;

		String result = fixture.toString();

		// add additional test code here
		assertEquals("high", result);
	}

	/**
	 * Perform pre-test initialization.
	 *
	 * @throws Exception
	 *         if the initialization fails for some reason
	 *
	 * @generatedBy CodePro at 25/5/20 3:44 PM
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
	 * @generatedBy CodePro at 25/5/20 3:44 PM
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
	 * @generatedBy CodePro at 25/5/20 3:44 PM
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(PriorityTest.class);
	}
}