package org.egov.prscp.web.models;

import org.junit.*;
import static org.junit.Assert.*;

/**
 * The class <code>PressNoteMapTest</code> contains tests for the class <code>{@link PressNoteMap}</code>.
 *
 * @generatedBy CodePro at 25/5/20 3:44 PM
 * @author Aniket.Marathe
 * @version $Revision: 1.0 $
 */
public class PressNoteMapTest {
	/**
	 * Run the PressNoteMap() constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:44 PM
	 */
	@Test
	public void testPressNoteMap_1()
		throws Exception {

		PressNoteMap result = new PressNoteMap();

		// add additional test code here
		assertNotNull(result);
		assertEquals(null, result.getLastModifiedTime());
		assertEquals(null, result.getCreatedTime());
		assertEquals(null, result.getTenantId());
		assertEquals(null, result.getPressNoteUuid());
		assertEquals(false, result.isNotifyStatus());
		assertEquals(null, result.getModuleCode());
		assertEquals(null, result.getIsActive());
		assertEquals(null, result.getCreatedBy());
		assertEquals(null, result.getLastModifiedBy());
		assertEquals(null, result.getPressMasterUuid());
		assertEquals(null, result.getMapPressNoteUuid());
	}

	/**
	 * Run the PressNoteMap(String,String,String,boolean,String,String,Boolean,String,String,Long,Long) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:44 PM
	 */
	@Test
	public void testPressNoteMap_2()
		throws Exception {
		String mapPressNoteUuid = "";
		String pressMasterUuid = "";
		String pressNoteUuid = "";
		boolean notifyStatus = true;
		String moduleCode = "";
		String tenantId = "";
		Boolean isActive = new Boolean(true);
		String createdBy = "";
		String lastModifiedBy = "";
		Long createdTime = new Long(1L);
		Long lastModifiedTime = new Long(1L);

		PressNoteMap result = new PressNoteMap(mapPressNoteUuid, pressMasterUuid, pressNoteUuid, notifyStatus, moduleCode, tenantId, isActive, createdBy, lastModifiedBy, createdTime, lastModifiedTime);

		// add additional test code here
		assertNotNull(result);
		assertEquals(new Long(1L), result.getLastModifiedTime());
		assertEquals(new Long(1L), result.getCreatedTime());
		assertEquals("", result.getTenantId());
		assertEquals("", result.getPressNoteUuid());
		assertEquals(true, result.isNotifyStatus());
		assertEquals("", result.getModuleCode());
		assertEquals(Boolean.TRUE, result.getIsActive());
		assertEquals("", result.getCreatedBy());
		assertEquals("", result.getLastModifiedBy());
		assertEquals("", result.getPressMasterUuid());
		assertEquals("", result.getMapPressNoteUuid());
	}

	/**
	 * Run the PressNoteMap.PressNoteMapBuilder builder() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:44 PM
	 */
	@Test
	public void testBuilder_1()
		throws Exception {

		PressNoteMap.PressNoteMapBuilder result = PressNoteMap.builder();

		// add additional test code here
		assertNotNull(result);
		assertEquals("PressNoteMap.PressNoteMapBuilder(mapPressNoteUuid=null, pressMasterUuid=null, pressNoteUuid=null, notifyStatus=false, moduleCode=null, tenantId=null, isActive=null, createdBy=null, lastModifiedBy=null, createdTime=null, lastModifiedTime=null)", result.toString());
	}

	/**
	 * Run the String getCreatedBy() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:44 PM
	 */
	@Test
	public void testGetCreatedBy_1()
		throws Exception {
		PressNoteMap fixture = new PressNoteMap("", "", "", true, "", "", new Boolean(true), "", "", new Long(1L), new Long(1L));

		String result = fixture.getCreatedBy();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the Long getCreatedTime() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:44 PM
	 */
	@Test
	public void testGetCreatedTime_1()
		throws Exception {
		PressNoteMap fixture = new PressNoteMap("", "", "", true, "", "", new Boolean(true), "", "", new Long(1L), new Long(1L));

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
	 * Run the Boolean getIsActive() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:44 PM
	 */
	@Test
	public void testGetIsActive_1()
		throws Exception {
		PressNoteMap fixture = new PressNoteMap("", "", "", true, "", "", new Boolean(true), "", "", new Long(1L), new Long(1L));

		Boolean result = fixture.getIsActive();

		// add additional test code here
		assertNotNull(result);
		assertEquals("true", result.toString());
		assertEquals(true, result.booleanValue());
	}

	/**
	 * Run the String getLastModifiedBy() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:44 PM
	 */
	@Test
	public void testGetLastModifiedBy_1()
		throws Exception {
		PressNoteMap fixture = new PressNoteMap("", "", "", true, "", "", new Boolean(true), "", "", new Long(1L), new Long(1L));

		String result = fixture.getLastModifiedBy();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the Long getLastModifiedTime() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:44 PM
	 */
	@Test
	public void testGetLastModifiedTime_1()
		throws Exception {
		PressNoteMap fixture = new PressNoteMap("", "", "", true, "", "", new Boolean(true), "", "", new Long(1L), new Long(1L));

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
	 * Run the String getMapPressNoteUuid() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:44 PM
	 */
	@Test
	public void testGetMapPressNoteUuid_1()
		throws Exception {
		PressNoteMap fixture = new PressNoteMap("", "", "", true, "", "", new Boolean(true), "", "", new Long(1L), new Long(1L));

		String result = fixture.getMapPressNoteUuid();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the String getModuleCode() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:44 PM
	 */
	@Test
	public void testGetModuleCode_1()
		throws Exception {
		PressNoteMap fixture = new PressNoteMap("", "", "", true, "", "", new Boolean(true), "", "", new Long(1L), new Long(1L));

		String result = fixture.getModuleCode();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the String getPressMasterUuid() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:44 PM
	 */
	@Test
	public void testGetPressMasterUuid_1()
		throws Exception {
		PressNoteMap fixture = new PressNoteMap("", "", "", true, "", "", new Boolean(true), "", "", new Long(1L), new Long(1L));

		String result = fixture.getPressMasterUuid();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the String getPressNoteUuid() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:44 PM
	 */
	@Test
	public void testGetPressNoteUuid_1()
		throws Exception {
		PressNoteMap fixture = new PressNoteMap("", "", "", true, "", "", new Boolean(true), "", "", new Long(1L), new Long(1L));

		String result = fixture.getPressNoteUuid();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the String getTenantId() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:44 PM
	 */
	@Test
	public void testGetTenantId_1()
		throws Exception {
		PressNoteMap fixture = new PressNoteMap("", "", "", true, "", "", new Boolean(true), "", "", new Long(1L), new Long(1L));

		String result = fixture.getTenantId();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the boolean isNotifyStatus() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:44 PM
	 */
	@Test
	public void testIsNotifyStatus_1()
		throws Exception {
		PressNoteMap fixture = new PressNoteMap("", "", "", true, "", "", new Boolean(true), "", "", new Long(1L), new Long(1L));

		boolean result = fixture.isNotifyStatus();

		// add additional test code here
		assertEquals(true, result);
	}

	/**
	 * Run the boolean isNotifyStatus() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:44 PM
	 */
	@Test
	public void testIsNotifyStatus_2()
		throws Exception {
		PressNoteMap fixture = new PressNoteMap("", "", "", false, "", "", new Boolean(true), "", "", new Long(1L), new Long(1L));

		boolean result = fixture.isNotifyStatus();

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the void setCreatedBy(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:44 PM
	 */
	@Test
	public void testSetCreatedBy_1()
		throws Exception {
		PressNoteMap fixture = new PressNoteMap("", "", "", true, "", "", new Boolean(true), "", "", new Long(1L), new Long(1L));
		String createdBy = "";

		fixture.setCreatedBy(createdBy);

		// add additional test code here
	}

	/**
	 * Run the void setCreatedTime(Long) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:44 PM
	 */
	@Test
	public void testSetCreatedTime_1()
		throws Exception {
		PressNoteMap fixture = new PressNoteMap("", "", "", true, "", "", new Boolean(true), "", "", new Long(1L), new Long(1L));
		Long createdTime = new Long(1L);

		fixture.setCreatedTime(createdTime);

		// add additional test code here
	}

	/**
	 * Run the void setIsActive(Boolean) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:44 PM
	 */
	@Test
	public void testSetIsActive_1()
		throws Exception {
		PressNoteMap fixture = new PressNoteMap("", "", "", true, "", "", new Boolean(true), "", "", new Long(1L), new Long(1L));
		Boolean isActive = new Boolean(true);

		fixture.setIsActive(isActive);

		// add additional test code here
	}

	/**
	 * Run the void setLastModifiedBy(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:44 PM
	 */
	@Test
	public void testSetLastModifiedBy_1()
		throws Exception {
		PressNoteMap fixture = new PressNoteMap("", "", "", true, "", "", new Boolean(true), "", "", new Long(1L), new Long(1L));
		String lastModifiedBy = "";

		fixture.setLastModifiedBy(lastModifiedBy);

		// add additional test code here
	}

	/**
	 * Run the void setLastModifiedTime(Long) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:44 PM
	 */
	@Test
	public void testSetLastModifiedTime_1()
		throws Exception {
		PressNoteMap fixture = new PressNoteMap("", "", "", true, "", "", new Boolean(true), "", "", new Long(1L), new Long(1L));
		Long lastModifiedTime = new Long(1L);

		fixture.setLastModifiedTime(lastModifiedTime);

		// add additional test code here
	}

	/**
	 * Run the void setMapPressNoteUuid(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:44 PM
	 */
	@Test
	public void testSetMapPressNoteUuid_1()
		throws Exception {
		PressNoteMap fixture = new PressNoteMap("", "", "", true, "", "", new Boolean(true), "", "", new Long(1L), new Long(1L));
		String mapPressNoteUuid = "";

		fixture.setMapPressNoteUuid(mapPressNoteUuid);

		// add additional test code here
	}

	/**
	 * Run the void setModuleCode(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:44 PM
	 */
	@Test
	public void testSetModuleCode_1()
		throws Exception {
		PressNoteMap fixture = new PressNoteMap("", "", "", true, "", "", new Boolean(true), "", "", new Long(1L), new Long(1L));
		String moduleCode = "";

		fixture.setModuleCode(moduleCode);

		// add additional test code here
	}

	/**
	 * Run the void setNotifyStatus(boolean) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:44 PM
	 */
	@Test
	public void testSetNotifyStatus_1()
		throws Exception {
		PressNoteMap fixture = new PressNoteMap("", "", "", true, "", "", new Boolean(true), "", "", new Long(1L), new Long(1L));
		boolean notifyStatus = true;

		fixture.setNotifyStatus(notifyStatus);

		// add additional test code here
	}

	/**
	 * Run the void setPressMasterUuid(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:44 PM
	 */
	@Test
	public void testSetPressMasterUuid_1()
		throws Exception {
		PressNoteMap fixture = new PressNoteMap("", "", "", true, "", "", new Boolean(true), "", "", new Long(1L), new Long(1L));
		String pressMasterUuid = "";

		fixture.setPressMasterUuid(pressMasterUuid);

		// add additional test code here
	}

	/**
	 * Run the void setPressNoteUuid(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:44 PM
	 */
	@Test
	public void testSetPressNoteUuid_1()
		throws Exception {
		PressNoteMap fixture = new PressNoteMap("", "", "", true, "", "", new Boolean(true), "", "", new Long(1L), new Long(1L));
		String pressNoteUuid = "";

		fixture.setPressNoteUuid(pressNoteUuid);

		// add additional test code here
	}

	/**
	 * Run the void setTenantId(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:44 PM
	 */
	@Test
	public void testSetTenantId_1()
		throws Exception {
		PressNoteMap fixture = new PressNoteMap("", "", "", true, "", "", new Boolean(true), "", "", new Long(1L), new Long(1L));
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
		new org.junit.runner.JUnitCore().run(PressNoteMapTest.class);
	}
}