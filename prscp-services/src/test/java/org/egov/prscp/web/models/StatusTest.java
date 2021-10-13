package org.egov.prscp.web.models;

import org.junit.*;
import static org.junit.Assert.*;

/**
 * The class <code>StatusTest</code> contains tests for the class <code>{@link Status}</code>.
 *
 * @generatedBy CodePro at 25/5/20 3:52 PM
 * @author Aniket.Marathe
 * @version $Revision: 1.0 $
 */
public class StatusTest {
	/**
	 * Run the Status(String) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:52 PM
	 */
	/*@Test
	public void testStatus_1()
		throws Exception {
		String value = "";

		Status result = new Status(value);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NoSuchMethodException: org.egov.prscp.web.models.Status.<init>(java.lang.String)
		//       at java.lang.Class.getConstructor0(Unknown Source)
		//       at java.lang.Class.getDeclaredConstructor(Unknown Source)
		//       at com.instantiations.eclipse.analysis.expression.model.InstanceCreationExpression.findConstructor(InstanceCreationExpression.java:572)
		//       at com.instantiations.eclipse.analysis.expression.model.InstanceCreationExpression.execute(InstanceCreationExpression.java:452)
		//       at com.instantiations.assist.eclipse.junit.execution.core.ExecutionRequest.execute(ExecutionRequest.java:286)
		//       at com.instantiations.assist.eclipse.junit.execution.communication.LocalExecutionClient$1.run(LocalExecutionClient.java:158)
		//       at java.lang.Thread.run(Unknown Source)
		assertNotNull(result);
	}
*/
	/**
	 * Run the Status fromValue(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:52 PM
	 */
	@Test
	public void testFromValue_1()
		throws Exception {
		String passedValue = "";

		Status result = Status.fromValue(passedValue);

		// add additional test code here
		assertEquals(null, result);
	}

	/**
	 * Run the Status fromValue(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:52 PM
	 */
	@Test
	public void testFromValue_2()
		throws Exception {
		String passedValue = "";

		Status result = Status.fromValue(passedValue);

		// add additional test code here
		assertEquals(null, result);
	}

	/**
	 * Run the Status fromValue(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:52 PM
	 */
	@Test
	public void testFromValue_3()
		throws Exception {
		String passedValue = "";

		Status result = Status.fromValue(passedValue);

		// add additional test code here
		assertEquals(null, result);
	}

	/**
	 * Run the String toString() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:52 PM
	 */
	@Test
	public void testToString_1()
		throws Exception {
		Status fixture = Status.ACTIVE;

		String result = fixture.toString();

		// add additional test code here
		assertEquals("ACTIVE", result);
	}

	/**
	 * Perform pre-test initialization.
	 *
	 * @throws Exception
	 *         if the initialization fails for some reason
	 *
	 * @generatedBy CodePro at 25/5/20 3:52 PM
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
	 * @generatedBy CodePro at 25/5/20 3:52 PM
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
	 * @generatedBy CodePro at 25/5/20 3:52 PM
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(StatusTest.class);
	}
}