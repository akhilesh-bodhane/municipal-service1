package org.egov.prscp.web.models;

import org.junit.*;
import static org.junit.Assert.*;

/**
 * The class <code>PressMasterTest</code> contains tests for the class <code>{@link PressMaster}</code>.
 *
 * @generatedBy CodePro at 25/5/20 3:45 PM
 * @author Aniket.Marathe
 * @version $Revision: 1.0 $
 */
public class PressMasterTest {
	/**
	 * Run the PressMaster() constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:45 PM
	 */
	@Test
	public void testPressMaster_1()
		throws Exception {

		PressMaster result = new PressMaster();

		// add additional test code here
		assertNotNull(result);
		assertEquals(null, result.getLastModifiedTime());
		assertEquals(false, result.isActive());
		assertEquals(null, result.getLastModifiedBy());
		assertEquals(null, result.getPressMasterUuid());
		assertEquals(null, result.getPublicationName());
		assertEquals(null, result.getEmail());
		assertEquals(null, result.getTenantId());
		assertEquals(null, result.getCreatedBy());
		assertEquals(null, result.getModuleCode());
		assertEquals(null, result.getMobile());
		assertEquals(null, result.getPressType());
		assertEquals(null, result.getCreatedTime());
		assertEquals(false, result.isDefaultGrid());
		assertEquals(null, result.getPersonnelName());
	}

	/**
	 * Run the PressMaster(String,String,String,String,String,String,String,String,boolean,String,String,Long,Long,boolean) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:45 PM
	 */
	@Test
	public void testPressMaster_2()
		throws Exception {
		String tenantId = "";
		String moduleCode = "";
		String pressMasterUuid = "";
		String personnelName = "";
		String pressType = "";
		String publicationName = "";
		String email = "";
		String mobile = "";
		boolean isActive = true;
		String createdBy = "";
		String lastModifiedBy = "";
		Long createdTime = new Long(1L);
		Long lastModifiedTime = new Long(1L);
		boolean defaultGrid = true;

		PressMaster result = new PressMaster(tenantId, moduleCode, pressMasterUuid, personnelName, pressType, publicationName, email, mobile, isActive, createdBy, lastModifiedBy, createdTime, lastModifiedTime, defaultGrid);

		// add additional test code here
		assertNotNull(result);
		assertEquals(new Long(1L), result.getLastModifiedTime());
		assertEquals(true, result.isActive());
		assertEquals("", result.getLastModifiedBy());
		assertEquals("", result.getPressMasterUuid());
		assertEquals("", result.getPublicationName());
		assertEquals("", result.getEmail());
		assertEquals("", result.getTenantId());
		assertEquals("", result.getCreatedBy());
		assertEquals("", result.getModuleCode());
		assertEquals("", result.getMobile());
		assertEquals("", result.getPressType());
		assertEquals(new Long(1L), result.getCreatedTime());
		assertEquals(true, result.isDefaultGrid());
		assertEquals("", result.getPersonnelName());
	}

	/**
	 * Run the PressMaster.PressMasterBuilder builder() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:45 PM
	 */
	@Test
	public void testBuilder_1()
		throws Exception {

		PressMaster.PressMasterBuilder result = PressMaster.builder();

		// add additional test code here
		assertNotNull(result);
		assertEquals("PressMaster.PressMasterBuilder(tenantId=null, moduleCode=null, pressMasterUuid=null, personnelName=null, pressType=null, publicationName=null, email=null, mobile=null, isActive=false, createdBy=null, lastModifiedBy=null, createdTime=null, lastModifiedTime=null, defaultGrid=false)", result.toString());
	}

	/**
	 * Run the String getCreatedBy() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:45 PM
	 */
	@Test
	public void testGetCreatedBy_1()
		throws Exception {
		PressMaster fixture = new PressMaster("", "", "", "", "", "", "", "", true, "", "", new Long(1L), new Long(1L), true);

		String result = fixture.getCreatedBy();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the Long getCreatedTime() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:45 PM
	 */
	@Test
	public void testGetCreatedTime_1()
		throws Exception {
		PressMaster fixture = new PressMaster("", "", "", "", "", "", "", "", true, "", "", new Long(1L), new Long(1L), true);

		Long result = fixture.getCreatedTime();

		// add additional test code here
		assertNotNull(result);
		assertEquals("1", result.toString());
		assertEquals((byte) 1, result.byteValue());
		assertEquals((short) 1, result.shortValue());
		assertEquals(1, result.intValue());
		assertEquals(1L, result.longValue());
		assertEquals(1.0f, result.floatValue(), 1.0f);
		assertEquals(1.0, result.doubleValue(), 1.0);
	}

	/**
	 * Run the String getEmail() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:45 PM
	 */
	@Test
	public void testGetEmail_1()
		throws Exception {
		PressMaster fixture = new PressMaster("", "", "", "", "", "", "", "", true, "", "", new Long(1L), new Long(1L), true);

		String result = fixture.getEmail();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the String getLastModifiedBy() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:45 PM
	 */
	@Test
	public void testGetLastModifiedBy_1()
		throws Exception {
		PressMaster fixture = new PressMaster("", "", "", "", "", "", "", "", true, "", "", new Long(1L), new Long(1L), true);

		String result = fixture.getLastModifiedBy();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the Long getLastModifiedTime() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:45 PM
	 */
	@Test
	public void testGetLastModifiedTime_1()
		throws Exception {
		PressMaster fixture = new PressMaster("", "", "", "", "", "", "", "", true, "", "", new Long(1L), new Long(1L), true);

		Long result = fixture.getLastModifiedTime();

		// add additional test code here
		assertNotNull(result);
		assertEquals("1", result.toString());
		assertEquals((byte) 1, result.byteValue());
		assertEquals((short) 1, result.shortValue());
		assertEquals(1, result.intValue());
		assertEquals(1L, result.longValue());
		assertEquals(1.0f, result.floatValue(), 1.0f);
		assertEquals(1.0, result.doubleValue(), 1.0);
	}

	/**
	 * Run the String getMobile() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:45 PM
	 */
	@Test
	public void testGetMobile_1()
		throws Exception {
		PressMaster fixture = new PressMaster("", "", "", "", "", "", "", "", true, "", "", new Long(1L), new Long(1L), true);

		String result = fixture.getMobile();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the String getModuleCode() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:45 PM
	 */
	@Test
	public void testGetModuleCode_1()
		throws Exception {
		PressMaster fixture = new PressMaster("", "", "", "", "", "", "", "", true, "", "", new Long(1L), new Long(1L), true);

		String result = fixture.getModuleCode();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the String getPersonnelName() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:45 PM
	 */
	@Test
	public void testGetPersonnelName_1()
		throws Exception {
		PressMaster fixture = new PressMaster("", "", "", "", "", "", "", "", true, "", "", new Long(1L), new Long(1L), true);

		String result = fixture.getPersonnelName();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the String getPressMasterUuid() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:45 PM
	 */
	@Test
	public void testGetPressMasterUuid_1()
		throws Exception {
		PressMaster fixture = new PressMaster("", "", "", "", "", "", "", "", true, "", "", new Long(1L), new Long(1L), true);

		String result = fixture.getPressMasterUuid();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the String getPressType() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:45 PM
	 */
	@Test
	public void testGetPressType_1()
		throws Exception {
		PressMaster fixture = new PressMaster("", "", "", "", "", "", "", "", true, "", "", new Long(1L), new Long(1L), true);

		String result = fixture.getPressType();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the String getPublicationName() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:45 PM
	 */
	@Test
	public void testGetPublicationName_1()
		throws Exception {
		PressMaster fixture = new PressMaster("", "", "", "", "", "", "", "", true, "", "", new Long(1L), new Long(1L), true);

		String result = fixture.getPublicationName();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the String getTenantId() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:45 PM
	 */
	@Test
	public void testGetTenantId_1()
		throws Exception {
		PressMaster fixture = new PressMaster("", "", "", "", "", "", "", "", true, "", "", new Long(1L), new Long(1L), true);

		String result = fixture.getTenantId();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the boolean isActive() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:45 PM
	 */
	@Test
	public void testIsActive_1()
		throws Exception {
		PressMaster fixture = new PressMaster("", "", "", "", "", "", "", "", true, "", "", new Long(1L), new Long(1L), true);

		boolean result = fixture.isActive();

		// add additional test code here
		assertEquals(true, result);
	}

	/**
	 * Run the boolean isActive() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:45 PM
	 */
	@Test
	public void testIsActive_2()
		throws Exception {
		PressMaster fixture = new PressMaster("", "", "", "", "", "", "", "", false, "", "", new Long(1L), new Long(1L), true);

		boolean result = fixture.isActive();

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the boolean isDefaultGrid() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:45 PM
	 */
	@Test
	public void testIsDefaultGrid_1()
		throws Exception {
		PressMaster fixture = new PressMaster("", "", "", "", "", "", "", "", true, "", "", new Long(1L), new Long(1L), true);

		boolean result = fixture.isDefaultGrid();

		// add additional test code here
		assertEquals(true, result);
	}

	/**
	 * Run the boolean isDefaultGrid() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:45 PM
	 */
	@Test
	public void testIsDefaultGrid_2()
		throws Exception {
		PressMaster fixture = new PressMaster("", "", "", "", "", "", "", "", true, "", "", new Long(1L), new Long(1L), false);

		boolean result = fixture.isDefaultGrid();

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the void setActive(boolean) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:45 PM
	 */
	@Test
	public void testSetActive_1()
		throws Exception {
		PressMaster fixture = new PressMaster("", "", "", "", "", "", "", "", true, "", "", new Long(1L), new Long(1L), true);
		boolean isActive = true;

		fixture.setActive(isActive);

		// add additional test code here
	}

	/**
	 * Run the void setCreatedBy(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:45 PM
	 */
	@Test
	public void testSetCreatedBy_1()
		throws Exception {
		PressMaster fixture = new PressMaster("", "", "", "", "", "", "", "", true, "", "", new Long(1L), new Long(1L), true);
		String createdBy = "";

		fixture.setCreatedBy(createdBy);

		// add additional test code here
	}

	/**
	 * Run the void setCreatedTime(Long) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:45 PM
	 */
	@Test
	public void testSetCreatedTime_1()
		throws Exception {
		PressMaster fixture = new PressMaster("", "", "", "", "", "", "", "", true, "", "", new Long(1L), new Long(1L), true);
		Long createdTime = new Long(1L);

		fixture.setCreatedTime(createdTime);

		// add additional test code here
	}

	/**
	 * Run the void setDefaultGrid(boolean) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:45 PM
	 */
	@Test
	public void testSetDefaultGrid_1()
		throws Exception {
		PressMaster fixture = new PressMaster("", "", "", "", "", "", "", "", true, "", "", new Long(1L), new Long(1L), true);
		boolean defaultGrid = true;

		fixture.setDefaultGrid(defaultGrid);

		// add additional test code here
	}

	/**
	 * Run the void setEmail(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:45 PM
	 */
	@Test
	public void testSetEmail_1()
		throws Exception {
		PressMaster fixture = new PressMaster("", "", "", "", "", "", "", "", true, "", "", new Long(1L), new Long(1L), true);
		String email = "";

		fixture.setEmail(email);

		// add additional test code here
	}

	/**
	 * Run the void setLastModifiedBy(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:45 PM
	 */
	@Test
	public void testSetLastModifiedBy_1()
		throws Exception {
		PressMaster fixture = new PressMaster("", "", "", "", "", "", "", "", true, "", "", new Long(1L), new Long(1L), true);
		String lastModifiedBy = "";

		fixture.setLastModifiedBy(lastModifiedBy);

		// add additional test code here
	}

	/**
	 * Run the void setLastModifiedTime(Long) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:45 PM
	 */
	@Test
	public void testSetLastModifiedTime_1()
		throws Exception {
		PressMaster fixture = new PressMaster("", "", "", "", "", "", "", "", true, "", "", new Long(1L), new Long(1L), true);
		Long lastModifiedTime = new Long(1L);

		fixture.setLastModifiedTime(lastModifiedTime);

		// add additional test code here
	}

	/**
	 * Run the void setMobile(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:45 PM
	 */
	@Test
	public void testSetMobile_1()
		throws Exception {
		PressMaster fixture = new PressMaster("", "", "", "", "", "", "", "", true, "", "", new Long(1L), new Long(1L), true);
		String mobile = "";

		fixture.setMobile(mobile);

		// add additional test code here
	}

	/**
	 * Run the void setModuleCode(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:45 PM
	 */
	@Test
	public void testSetModuleCode_1()
		throws Exception {
		PressMaster fixture = new PressMaster("", "", "", "", "", "", "", "", true, "", "", new Long(1L), new Long(1L), true);
		String moduleCode = "";

		fixture.setModuleCode(moduleCode);

		// add additional test code here
	}

	/**
	 * Run the void setPersonnelName(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:45 PM
	 */
	@Test
	public void testSetPersonnelName_1()
		throws Exception {
		PressMaster fixture = new PressMaster("", "", "", "", "", "", "", "", true, "", "", new Long(1L), new Long(1L), true);
		String personnelName = "";

		fixture.setPersonnelName(personnelName);

		// add additional test code here
	}

	/**
	 * Run the void setPressMasterUuid(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:45 PM
	 */
	@Test
	public void testSetPressMasterUuid_1()
		throws Exception {
		PressMaster fixture = new PressMaster("", "", "", "", "", "", "", "", true, "", "", new Long(1L), new Long(1L), true);
		String pressMasterUuid = "";

		fixture.setPressMasterUuid(pressMasterUuid);

		// add additional test code here
	}

	/**
	 * Run the void setPressType(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:45 PM
	 */
	@Test
	public void testSetPressType_1()
		throws Exception {
		PressMaster fixture = new PressMaster("", "", "", "", "", "", "", "", true, "", "", new Long(1L), new Long(1L), true);
		String pressType = "";

		fixture.setPressType(pressType);

		// add additional test code here
	}

	/**
	 * Run the void setPublicationName(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:45 PM
	 */
	@Test
	public void testSetPublicationName_1()
		throws Exception {
		PressMaster fixture = new PressMaster("", "", "", "", "", "", "", "", true, "", "", new Long(1L), new Long(1L), true);
		String publicationName = "";

		fixture.setPublicationName(publicationName);

		// add additional test code here
	}

	/**
	 * Run the void setTenantId(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:45 PM
	 */
	@Test
	public void testSetTenantId_1()
		throws Exception {
		PressMaster fixture = new PressMaster("", "", "", "", "", "", "", "", true, "", "", new Long(1L), new Long(1L), true);
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
	 * @generatedBy CodePro at 25/5/20 3:45 PM
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
	 * @generatedBy CodePro at 25/5/20 3:45 PM
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
	 * @generatedBy CodePro at 25/5/20 3:45 PM
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(PressMasterTest.class);
	}
}