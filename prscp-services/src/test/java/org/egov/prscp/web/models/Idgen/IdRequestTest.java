package org.egov.prscp.web.models.Idgen;

import org.junit.*;
import static org.junit.Assert.*;

/**
 * The class <code>IdRequestTest</code> contains tests for the class <code>{@link IdRequest}</code>.
 *
 * @generatedBy CodePro at 25/5/20 3:53 PM
 * @author Aniket.Marathe
 * @version $Revision: 1.0 $
 */
public class IdRequestTest {
	/**
	 * Run the IdRequest() constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:53 PM
	 */
	@Test
	public void testIdRequest_1()
		throws Exception {

		IdRequest result = new IdRequest();

		// add additional test code here
		assertNotNull(result);
		assertEquals("IdRequest(idName=null, tenantId=null, format=null)", result.toString());
		assertEquals(null, result.getFormat());
		assertEquals(null, result.getIdName());
		assertEquals(null, result.getTenantId());
	}

	/**
	 * Run the IdRequest(String,String,String) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:53 PM
	 */
	@Test
	public void testIdRequest_2()
		throws Exception {
		String idName = "";
		String tenantId = "";
		String format = "";

		IdRequest result = new IdRequest(idName, tenantId, format);

		// add additional test code here
		assertNotNull(result);
		assertEquals("IdRequest(idName=, tenantId=, format=)", result.toString());
		assertEquals("", result.getFormat());
		assertEquals("", result.getIdName());
		assertEquals("", result.getTenantId());
	}

	/**
	 * Run the IdRequest.IdRequestBuilder builder() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:53 PM
	 */
	@Test
	public void testBuilder_1()
		throws Exception {

		IdRequest.IdRequestBuilder result = IdRequest.builder();

		// add additional test code here
		assertNotNull(result);
		assertEquals("IdRequest.IdRequestBuilder(idName=null, tenantId=null, format=null)", result.toString());
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
		IdRequest fixture = new IdRequest("", "", "");
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
		IdRequest fixture = new IdRequest("", "", "");
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
		IdRequest fixture = new IdRequest("", "", "");
		Object o = new IdRequest("", "", "");

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
		IdRequest fixture = new IdRequest("", "", "");
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
		IdRequest fixture = new IdRequest("", "", "");
		Object o = new IdRequest("", "", "");

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
		IdRequest fixture = new IdRequest("", "", "");
		Object o = new IdRequest("", "", "");

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
		IdRequest fixture = new IdRequest("", "", "");
		Object o = new IdRequest("", "", "");

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
		IdRequest fixture = new IdRequest("", "", "");
		Object o = new IdRequest("", "", "");

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
		IdRequest fixture = new IdRequest("", "", (String) null);
		Object o = new IdRequest("", "", (String) null);

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
		IdRequest fixture = new IdRequest("", "", "");
		Object o = new IdRequest("", "", "");

		boolean result = fixture.equals(o);

		// add additional test code here
		assertEquals(true, result);
	}

	/**
	 * Run the String getFormat() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:53 PM
	 */
	@Test
	public void testGetFormat_1()
		throws Exception {
		IdRequest fixture = new IdRequest("", "", "");

		String result = fixture.getFormat();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the String getIdName() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:53 PM
	 */
	@Test
	public void testGetIdName_1()
		throws Exception {
		IdRequest fixture = new IdRequest("", "", "");

		String result = fixture.getIdName();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the String getTenantId() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:53 PM
	 */
	@Test
	public void testGetTenantId_1()
		throws Exception {
		IdRequest fixture = new IdRequest("", "", "");

		String result = fixture.getTenantId();

		// add additional test code here
		assertEquals("", result);
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
		IdRequest fixture = new IdRequest((String) null, "", "");

		int result = fixture.hashCode();

		// add additional test code here
		assertEquals(355062, result);
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
		IdRequest fixture = new IdRequest("", (String) null, (String) null);

		int result = fixture.hashCode();

		// add additional test code here
		assertEquals(207959, result);
	}

	/**
	 * Run the void setFormat(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:53 PM
	 */
	@Test
	public void testSetFormat_1()
		throws Exception {
		IdRequest fixture = new IdRequest("", "", "");
		String format = "";

		fixture.setFormat(format);

		// add additional test code here
	}

	/**
	 * Run the void setIdName(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:53 PM
	 */
	@Test
	public void testSetIdName_1()
		throws Exception {
		IdRequest fixture = new IdRequest("", "", "");
		String idName = "";

		fixture.setIdName(idName);

		// add additional test code here
	}

	/**
	 * Run the void setTenantId(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:53 PM
	 */
	@Test
	public void testSetTenantId_1()
		throws Exception {
		IdRequest fixture = new IdRequest("", "", "");
		String tenantId = "";

		fixture.setTenantId(tenantId);

		// add additional test code here
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
		new org.junit.runner.JUnitCore().run(IdRequestTest.class);
	}
}