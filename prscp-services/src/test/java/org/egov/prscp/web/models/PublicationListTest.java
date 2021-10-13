//package org.egov.prscp.web.models;
//
//import org.junit.*;
//import static org.junit.Assert.*;
//
///**
// * The class <code>PublicationListTest</code> contains tests for the class <code>{@link PublicationList}</code>.
// *
// * @generatedBy CodePro at 25/5/20 3:52 PM
// * @author Aniket.Marathe
// * @version $Revision: 1.0 $
// */
//public class PublicationListTest {
//	/**
//	 * Run the PublicationList() constructor test.
//	 *
//	 * @throws Exception
//	 *
//	 * @generatedBy CodePro at 25/5/20 3:52 PM
//	 */
//	@Test
//	public void testPublicationList_1()
//		throws Exception {
//
//		PublicationList result = new PublicationList();
//
//		// add additional test code here
//		assertNotNull(result);
//		assertEquals(null, result.getEmail());
//		assertEquals(null, result.getPersonnelName());
//		assertEquals(null, result.getPressType());
//		assertEquals(null, result.getMobile());
//		assertEquals(null, result.getPressMasterUuid());
//		assertEquals(null, result.getPublicationName());
//	}
//
//	/**
//	 * Run the PublicationList(String,String,String,String,String,String) constructor test.
//	 *
//	 * @throws Exception
//	 *
//	 * @generatedBy CodePro at 25/5/20 3:52 PM
//	 */
//	@Test
//	public void testPublicationList_2()
//		throws Exception {
//		String pressMasterUuid = "";
//		String personnelName = "";
//		String pressType = "";
//		String publicationName = "";
//		String email = "";
//		String mobile = "";
//
//		PublicationList result = new PublicationList(pressMasterUuid, personnelName, pressType, publicationName, email, mobile);
//
//		// add additional test code here
//		assertNotNull(result);
//		assertEquals("", result.getEmail());
//		assertEquals("", result.getPersonnelName());
//		assertEquals("", result.getPressType());
//		assertEquals("", result.getMobile());
//		assertEquals("", result.getPressMasterUuid());
//		assertEquals("", result.getPublicationName());
//	}
//
//	/**
//	 * Run the PublicationList.PublicationListBuilder builder() method test.
//	 *
//	 * @throws Exception
//	 *
//	 * @generatedBy CodePro at 25/5/20 3:52 PM
//	 */
//	@Test
//	public void testBuilder_1()
//		throws Exception {
//
//		PublicationList.PublicationListBuilder result = PublicationList.builder();
//
//		// add additional test code here
//		assertNotNull(result);
//		assertEquals("PublicationList.PublicationListBuilder(pressMasterUuid=null, personnelName=null, pressType=null, publicationName=null, email=null, mobile=null)", result.toString());
//	}
//
//	/**
//	 * Run the boolean canEqual(Object) method test.
//	 *
//	 * @throws Exception
//	 *
//	 * @generatedBy CodePro at 25/5/20 3:52 PM
//	 */
//	@Test
//	public void testCanEqual_1()
//		throws Exception {
//		PublicationList fixture = new PublicationList("", "", "", "", "", "");
//		Object other = new Object();
//
//		boolean result = fixture.canEqual(other);
//
//		// add additional test code here
//		assertEquals(false, result);
//	}
//
//	/**
//	 * Run the boolean canEqual(Object) method test.
//	 *
//	 * @throws Exception
//	 *
//	 * @generatedBy CodePro at 25/5/20 3:52 PM
//	 */
//	@Test
//	public void testCanEqual_2()
//		throws Exception {
//		PublicationList fixture = new PublicationList("", "", "", "", "", "");
//		Object other = new Object();
//
//		boolean result = fixture.canEqual(other);
//
//		// add additional test code here
//		assertEquals(false, result);
//	}
//
//	/**
//	 * Run the boolean equals(Object) method test.
//	 *
//	 * @throws Exception
//	 *
//	 * @generatedBy CodePro at 25/5/20 3:52 PM
//	 */
//	@Test
//	public void testEquals_1()
//		throws Exception {
//		PublicationList fixture = new PublicationList("", "", "", "", "", "");
//		Object o = new PublicationList("", "", "", "", "", "");
//
//		boolean result = fixture.equals(o);
//
//		// add additional test code here
//		assertEquals(true, result);
//	}
//
//	/**
//	 * Run the boolean equals(Object) method test.
//	 *
//	 * @throws Exception
//	 *
//	 * @generatedBy CodePro at 25/5/20 3:52 PM
//	 */
//	@Test
//	public void testEquals_2()
//		throws Exception {
//		PublicationList fixture = new PublicationList("", "", "", "", "", "");
//		Object o = new Object();
//
//		boolean result = fixture.equals(o);
//
//		// add additional test code here
//		assertEquals(false, result);
//	}
//
//	/**
//	 * Run the boolean equals(Object) method test.
//	 *
//	 * @throws Exception
//	 *
//	 * @generatedBy CodePro at 25/5/20 3:52 PM
//	 */
//	@Test
//	public void testEquals_3()
//		throws Exception {
//		PublicationList fixture = new PublicationList("", "", "", "", "", "");
//		Object o = new PublicationList("", "", "", "", "", "");
//
//		boolean result = fixture.equals(o);
//
//		// add additional test code here
//		assertEquals(true, result);
//	}
//
//	/**
//	 * Run the boolean equals(Object) method test.
//	 *
//	 * @throws Exception
//	 *
//	 * @generatedBy CodePro at 25/5/20 3:52 PM
//	 */
//	@Test
//	public void testEquals_4()
//		throws Exception {
//		PublicationList fixture = new PublicationList("", "", "", "", "", "");
//		Object o = new PublicationList("", "", "", "", "", "");
//
//		boolean result = fixture.equals(o);
//
//		// add additional test code here
//		assertEquals(true, result);
//	}
//
//	/**
//	 * Run the boolean equals(Object) method test.
//	 *
//	 * @throws Exception
//	 *
//	 * @generatedBy CodePro at 25/5/20 3:52 PM
//	 */
//	@Test
//	public void testEquals_5()
//		throws Exception {
//		PublicationList fixture = new PublicationList("", "", "", "", "", "");
//		Object o = new PublicationList("", "", "", "", "", "");
//
//		boolean result = fixture.equals(o);
//
//		// add additional test code here
//		assertEquals(true, result);
//	}
//
//	/**
//	 * Run the boolean equals(Object) method test.
//	 *
//	 * @throws Exception
//	 *
//	 * @generatedBy CodePro at 25/5/20 3:52 PM
//	 */
//	@Test
//	public void testEquals_6()
//		throws Exception {
//		PublicationList fixture = new PublicationList("", "", "", "", "", "");
//		Object o = new PublicationList("", "", "", "", "", "");
//
//		boolean result = fixture.equals(o);
//
//		// add additional test code here
//		assertEquals(true, result);
//	}
//
//	/**
//	 * Run the boolean equals(Object) method test.
//	 *
//	 * @throws Exception
//	 *
//	 * @generatedBy CodePro at 25/5/20 3:52 PM
//	 */
//	@Test
//	public void testEquals_7()
//		throws Exception {
//		PublicationList fixture = new PublicationList("", "", "", "", "", "");
//		Object o = new PublicationList("", "", "", "", "", "");
//
//		boolean result = fixture.equals(o);
//
//		// add additional test code here
//		assertEquals(true, result);
//	}
//
//	/**
//	 * Run the boolean equals(Object) method test.
//	 *
//	 * @throws Exception
//	 *
//	 * @generatedBy CodePro at 25/5/20 3:52 PM
//	 */
//	@Test
//	public void testEquals_8()
//		throws Exception {
//		PublicationList fixture = new PublicationList("", "", "", "", "", "");
//		Object o = new PublicationList("", "", "", "", "", "");
//
//		boolean result = fixture.equals(o);
//
//		// add additional test code here
//		assertEquals(true, result);
//	}
//
//	/**
//	 * Run the boolean equals(Object) method test.
//	 *
//	 * @throws Exception
//	 *
//	 * @generatedBy CodePro at 25/5/20 3:52 PM
//	 */
//	@Test
//	public void testEquals_9()
//		throws Exception {
//		PublicationList fixture = new PublicationList("", "", "", "", "", "");
//		Object o = new PublicationList("", "", "", "", "", "");
//
//		boolean result = fixture.equals(o);
//
//		// add additional test code here
//		assertEquals(true, result);
//	}
//
//	/**
//	 * Run the boolean equals(Object) method test.
//	 *
//	 * @throws Exception
//	 *
//	 * @generatedBy CodePro at 25/5/20 3:52 PM
//	 */
//	@Test
//	public void testEquals_10()
//		throws Exception {
//		PublicationList fixture = new PublicationList("", "", "", "", "", (String) null);
//		Object o = new PublicationList("", "", "", "", "", (String) null);
//
//		boolean result = fixture.equals(o);
//
//		// add additional test code here
//		assertEquals(true, result);
//	}
//
//	/**
//	 * Run the boolean equals(Object) method test.
//	 *
//	 * @throws Exception
//	 *
//	 * @generatedBy CodePro at 25/5/20 3:52 PM
//	 */
//	@Test
//	public void testEquals_11()
//		throws Exception {
//		PublicationList fixture = new PublicationList("", "", "", "", "", "");
//		Object o = new PublicationList("", "", "", "", "", "");
//
//		boolean result = fixture.equals(o);
//
//		// add additional test code here
//		assertEquals(true, result);
//	}
//
//	/**
//	 * Run the String getEmail() method test.
//	 *
//	 * @throws Exception
//	 *
//	 * @generatedBy CodePro at 25/5/20 3:52 PM
//	 */
//	@Test
//	public void testGetEmail_1()
//		throws Exception {
//		PublicationList fixture = new PublicationList("", "", "", "", "", "");
//
//		String result = fixture.getEmail();
//
//		// add additional test code here
//		assertEquals("", result);
//	}
//
//	/**
//	 * Run the String getMobile() method test.
//	 *
//	 * @throws Exception
//	 *
//	 * @generatedBy CodePro at 25/5/20 3:52 PM
//	 */
//	@Test
//	public void testGetMobile_1()
//		throws Exception {
//		PublicationList fixture = new PublicationList("", "", "", "", "", "");
//
//		String result = fixture.getMobile();
//
//		// add additional test code here
//		assertEquals("", result);
//	}
//
//	/**
//	 * Run the String getPersonnelName() method test.
//	 *
//	 * @throws Exception
//	 *
//	 * @generatedBy CodePro at 25/5/20 3:52 PM
//	 */
//	@Test
//	public void testGetPersonnelName_1()
//		throws Exception {
//		PublicationList fixture = new PublicationList("", "", "", "", "", "");
//
//		String result = fixture.getPersonnelName();
//
//		// add additional test code here
//		assertEquals("", result);
//	}
//
//	/**
//	 * Run the String getPressMasterUuid() method test.
//	 *
//	 * @throws Exception
//	 *
//	 * @generatedBy CodePro at 25/5/20 3:52 PM
//	 */
//	@Test
//	public void testGetPressMasterUuid_1()
//		throws Exception {
//		PublicationList fixture = new PublicationList("", "", "", "", "", "");
//
//		String result = fixture.getPressMasterUuid();
//
//		// add additional test code here
//		assertEquals("", result);
//	}
//
//	/**
//	 * Run the String getPressType() method test.
//	 *
//	 * @throws Exception
//	 *
//	 * @generatedBy CodePro at 25/5/20 3:52 PM
//	 */
//	@Test
//	public void testGetPressType_1()
//		throws Exception {
//		PublicationList fixture = new PublicationList("", "", "", "", "", "");
//
//		String result = fixture.getPressType();
//
//		// add additional test code here
//		assertEquals("", result);
//	}
//
//	/**
//	 * Run the String getPublicationName() method test.
//	 *
//	 * @throws Exception
//	 *
//	 * @generatedBy CodePro at 25/5/20 3:52 PM
//	 */
//	@Test
//	public void testGetPublicationName_1()
//		throws Exception {
//		PublicationList fixture = new PublicationList("", "", "", "", "", "");
//
//		String result = fixture.getPublicationName();
//
//		// add additional test code here
//		assertEquals("", result);
//	}
//
//	/**
//	 * Run the int hashCode() method test.
//	 *
//	 * @throws Exception
//	 *
//	 * @generatedBy CodePro at 25/5/20 3:52 PM
//	 */
//	@Test
//	public void testHashCode_1()
//		throws Exception {
//		PublicationList fixture = new PublicationList((String) null, (String) null, (String) null, "", "", "");
//
//		int result = fixture.hashCode();
//
//		// add additional test code here
//		assertEquals(437712286, result);
//	}
//
//	/**
//	 * Run the int hashCode() method test.
//	 *
//	 * @throws Exception
//	 *
//	 * @generatedBy CodePro at 25/5/20 3:52 PM
//	 */
//	@Test
//	public void testHashCode_2()
//		throws Exception {
//		PublicationList fixture = new PublicationList("", "", "", (String) null, (String) null, (String) null);
//
//		int result = fixture.hashCode();
//
//		// add additional test code here
//		assertEquals(-768987056, result);
//	}
//
//	/**
//	 * Run the void setEmail(String) method test.
//	 *
//	 * @throws Exception
//	 *
//	 * @generatedBy CodePro at 25/5/20 3:52 PM
//	 */
//	@Test
//	public void testSetEmail_1()
//		throws Exception {
//		PublicationList fixture = new PublicationList("", "", "", "", "", "");
//		String email = "";
//
//		fixture.setEmail(email);
//
//		// add additional test code here
//	}
//
//	/**
//	 * Run the void setMobile(String) method test.
//	 *
//	 * @throws Exception
//	 *
//	 * @generatedBy CodePro at 25/5/20 3:52 PM
//	 */
//	@Test
//	public void testSetMobile_1()
//		throws Exception {
//		PublicationList fixture = new PublicationList("", "", "", "", "", "");
//		String mobile = "";
//
//		fixture.setMobile(mobile);
//
//		// add additional test code here
//	}
//
//	/**
//	 * Run the void setPersonnelName(String) method test.
//	 *
//	 * @throws Exception
//	 *
//	 * @generatedBy CodePro at 25/5/20 3:52 PM
//	 */
//	@Test
//	public void testSetPersonnelName_1()
//		throws Exception {
//		PublicationList fixture = new PublicationList("", "", "", "", "", "");
//		String personnelName = "";
//
//		fixture.setPersonnelName(personnelName);
//
//		// add additional test code here
//	}
//
//	/**
//	 * Run the void setPressMasterUuid(String) method test.
//	 *
//	 * @throws Exception
//	 *
//	 * @generatedBy CodePro at 25/5/20 3:52 PM
//	 */
//	@Test
//	public void testSetPressMasterUuid_1()
//		throws Exception {
//		PublicationList fixture = new PublicationList("", "", "", "", "", "");
//		String pressMasterUuid = "";
//
//		fixture.setPressMasterUuid(pressMasterUuid);
//
//		// add additional test code here
//	}
//
//	/**
//	 * Run the void setPressType(String) method test.
//	 *
//	 * @throws Exception
//	 *
//	 * @generatedBy CodePro at 25/5/20 3:52 PM
//	 */
//	@Test
//	public void testSetPressType_1()
//		throws Exception {
//		PublicationList fixture = new PublicationList("", "", "", "", "", "");
//		String pressType = "";
//
//		fixture.setPressType(pressType);
//
//		// add additional test code here
//	}
//
//	/**
//	 * Run the void setPublicationName(String) method test.
//	 *
//	 * @throws Exception
//	 *
//	 * @generatedBy CodePro at 25/5/20 3:52 PM
//	 */
//	@Test
//	public void testSetPublicationName_1()
//		throws Exception {
//		PublicationList fixture = new PublicationList("", "", "", "", "", "");
//		String publicationName = "";
//
//		fixture.setPublicationName(publicationName);
//
//		// add additional test code here
//	}
//
//	/**
//	 * Perform pre-test initialization.
//	 *
//	 * @throws Exception
//	 *         if the initialization fails for some reason
//	 *
//	 * @generatedBy CodePro at 25/5/20 3:52 PM
//	 */
//	@Before
//	public void setUp()
//		throws Exception {
//		// add additional set up code here
//	}
//
//	/**
//	 * Perform post-test clean-up.
//	 *
//	 * @throws Exception
//	 *         if the clean-up fails for some reason
//	 *
//	 * @generatedBy CodePro at 25/5/20 3:52 PM
//	 */
//	@After
//	public void tearDown()
//		throws Exception {
//		// Add additional tear down code here
//	}
//
//	/**
//	 * Launch the test.
//	 *
//	 * @param args the command line arguments
//	 *
//	 * @generatedBy CodePro at 25/5/20 3:52 PM
//	 */
//	public static void main(String[] args) {
//		new org.junit.runner.JUnitCore().run(PublicationListTest.class);
//	}
//}