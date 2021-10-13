package org.egov.prscp.web.models;

import org.junit.*;
import static org.junit.Assert.*;


public class DeviceSourcesTest {

	
	@Test
	public void testDeviceSources_1()
		throws Exception {
		String tenantId = "";
		String moduleCode = "";
		String sourceUuid = "";
		String moduleType = "";
		String deviceType = "";
		String deviceDetails = "";
		String createdBy = "";
		Long createdTime = new Long(1L);

		DeviceSources result = new DeviceSources(tenantId, moduleCode, sourceUuid, moduleType, deviceType, deviceDetails, createdBy, createdTime);

		assertNotNull(result);
		assertEquals("", result.getModuleType());
		assertEquals("", result.getModuleCode());
		assertEquals("", result.getDeviceType());
		assertEquals("", result.getDeviceDetails());
		assertEquals("", result.getSourceUuid());
		assertEquals(new Long(1L), result.getCreatedTime());
		assertEquals("", result.getCreatedBy());
		assertEquals("", result.getTenantId());
	}

	
	@Test
	public void testBuilder_1()
		throws Exception {

		DeviceSources.DeviceSourcesBuilder result = DeviceSources.builder();

	
		assertNotNull(result);
		assertEquals("DeviceSources.DeviceSourcesBuilder(tenantId=null, moduleCode=null, sourceUuid=null, moduleType=null, deviceType=null, deviceDetails=null, createdBy=null, createdTime=null)", result.toString());
	}

	
	@Test
	public void testGetCreatedBy_1()
		throws Exception {
		DeviceSources fixture = new DeviceSources("", "", "", "", "", "", "", new Long(1L));

		String result = fixture.getCreatedBy();

		assertEquals("", result);
	}

	
	@Test
	public void testGetCreatedTime_1()
		throws Exception {
		DeviceSources fixture = new DeviceSources("", "", "", "", "", "", "", new Long(1L));

		Long result = fixture.getCreatedTime();

		
		assertNotNull(result);
		assertEquals("1", result.toString());
		assertEquals((byte) 1, result.byteValue());
		assertEquals((short) 1, result.shortValue());
		assertEquals(1, result.intValue());
		assertEquals(1L, result.longValue());
		assertEquals(1.0f, result.floatValue(), 1.0f);
		assertEquals(1.0, result.doubleValue(), 1.0);
	}

	

	@Test
	public void testGetDeviceDetails_1()
		throws Exception {
		DeviceSources fixture = new DeviceSources("", "", "", "", "", "", "", new Long(1L));

		String result = fixture.getDeviceDetails();

		
		assertEquals("", result);
	}

	
	@Test
	public void testGetDeviceType_1()
		throws Exception {
		DeviceSources fixture = new DeviceSources("", "", "", "", "", "", "", new Long(1L));

		String result = fixture.getDeviceType();

		
		assertEquals("", result);
	}

	
	@Test
	public void testGetModuleCode_1()
		throws Exception {
		DeviceSources fixture = new DeviceSources("", "", "", "", "", "", "", new Long(1L));

		String result = fixture.getModuleCode();

		
		assertEquals("", result);
	}

	@Test
	public void testGetModuleType_1()
		throws Exception {
		DeviceSources fixture = new DeviceSources("", "", "", "", "", "", "", new Long(1L));

		String result = fixture.getModuleType();

		
		assertEquals("", result);
	}

	
	@Test
	public void testGetSourceUuid_1()
		throws Exception {
		DeviceSources fixture = new DeviceSources("", "", "", "", "", "", "", new Long(1L));

		String result = fixture.getSourceUuid();

		
		assertEquals("", result);
	}


	@Test
	public void testGetTenantId_1()
		throws Exception {
		DeviceSources fixture = new DeviceSources("", "", "", "", "", "", "", new Long(1L));

		String result = fixture.getTenantId();

		
		assertEquals("", result);
	}


	@Test
	public void testSetCreatedBy_1()
		throws Exception {
		DeviceSources fixture = new DeviceSources("", "", "", "", "", "", "", new Long(1L));
		String createdBy = "";

		fixture.setCreatedBy(createdBy);

		
	}


	@Test
	public void testSetCreatedTime_1()
		throws Exception {
		DeviceSources fixture = new DeviceSources("", "", "", "", "", "", "", new Long(1L));
		Long createdTime = new Long(1L);

		fixture.setCreatedTime(createdTime);

		
	}

	@Test
	public void testSetDeviceDetails_1()
		throws Exception {
		DeviceSources fixture = new DeviceSources("", "", "", "", "", "", "", new Long(1L));
		String deviceDetails = "";

		fixture.setDeviceDetails(deviceDetails);

		
	}

	
	@Test
	public void testSetDeviceType_1()
		throws Exception {
		DeviceSources fixture = new DeviceSources("", "", "", "", "", "", "", new Long(1L));
		String deviceType = "";

		fixture.setDeviceType(deviceType);

		
	}

	@Test
	public void testSetModuleCode_1()
		throws Exception {
		DeviceSources fixture = new DeviceSources("", "", "", "", "", "", "", new Long(1L));
		String moduleCode = "";

		fixture.setModuleCode(moduleCode);

		
	}

	@Test
	public void testSetModuleType_1()
		throws Exception {
		DeviceSources fixture = new DeviceSources("", "", "", "", "", "", "", new Long(1L));
		String moduleType = "";

		fixture.setModuleType(moduleType);

		
	}

	@Test
	public void testSetSourceUuid_1()
		throws Exception {
		DeviceSources fixture = new DeviceSources("", "", "", "", "", "", "", new Long(1L));
		String sourceUuid = "";

		fixture.setSourceUuid(sourceUuid);

		
	}

	
	@Test
	public void testSetTenantId_1()
		throws Exception {
		DeviceSources fixture = new DeviceSources("", "", "", "", "", "", "", new Long(1L));
		String tenantId = "";

		fixture.setTenantId(tenantId);

		
	}

	
	@Before
	public void setUp()
		throws Exception {
		
	}

	
	@After
	public void tearDown()
		throws Exception {
		
	}

	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(DeviceSourcesTest.class);
	}
}