package org.egov.ec.web.models;

import org.junit.*;
import static org.junit.Assert.*;

import org.egov.ec.web.models.DeviceSources;

public class DeviceSourcesTest {
	
	/**
	 * Run the DeviceSources() constructor test.
	 *
	 * @throws Exception
	 *
	 *  at 30/4/20 5:39 AM
	 */
	@Test
	public void testDeviceSources_1()
		throws Exception {

		DeviceSources result = new DeviceSources(null, null, null, null, null, null, null);

		
		assertNotNull(result);
		assertEquals(null, result.getCreatedBy());
		assertEquals(null, result.getCreatedTime());
		assertEquals(null, result.getTenantId());
		assertEquals(null, result.getModuleType());
		assertEquals(null, result.getDeviceType());
		assertEquals(null, result.getDeviceDetails());
		assertEquals(null, result.getSourceUuid());
	}
	
	/**
	 * Run the DeviceSources(String,String,String,String,Long,String,Long,Boolean,String) constructor test.
	 *
	 * @throws Exception
	 *
	 *  at 30/04/20 1:32 PM
	 */
	@Test
	public void testDeviceSources_2()
		throws Exception {
		String tenantId = "";
		String moduleType="";
		String deviceType = "";
		String deviceDetails = "";
		String createdBy = "";
		Long createdTime = new Long(1L);
		String sourceUuid="";


		DeviceSources result = new DeviceSources(tenantId,sourceUuid,moduleType,deviceType,deviceDetails,createdBy,createdTime);

		
		assertNotNull(result);
		assertEquals("", result.getCreatedBy());
		assertEquals(new Long(1L), result.getCreatedTime());
		assertEquals("", result.getTenantId());
		assertEquals("", result.getModuleType());
		assertEquals("", result.getDeviceType());
		assertEquals("", result.getDeviceDetails());
		assertEquals("", result.getSourceUuid());
	}
	
	/**
	 * Run the DeviceSources.DeviceSourcesBuilder builder() method test.
	 *
	 * @throws Exception
	 *
	 *  at 30/04/20 1:32 PM
	 */
	@Test
	public void testBuilder_1()
		throws Exception {

		DeviceSources.DeviceSourcesBuilder result = DeviceSources.builder();

		
		assertNotNull(result);
		assertEquals("DeviceSources.DeviceSourcesBuilder(tenantId=null, sourceUuid=null, moduleType=null, deviceType=null, deviceDetails=null, createdBy=null, createdTime=null)", result.toString());
	}
	
	/**
	 * Run the DeviceSources.DeviceSourcesBuilder builder() method test.
	 *
	 * @throws Exception
	 *
	 *  at 30/04/20 1:32 PM
	 */
	@Test
	public void testBuilder_2()
		throws Exception {

		DeviceSources.DeviceSourcesBuilder builder = new DeviceSources.DeviceSourcesBuilder();
		builder.deviceType(null);
		builder.deviceDetails(null);
		builder.createdBy(null);
		builder.createdTime(null);
		builder.moduleType(null);
		builder.tenantId(null);
		builder.sourceUuid(null);
		builder.build();

		DeviceSources.DeviceSourcesBuilder builder2 = new DeviceSources.DeviceSourcesBuilder();
		builder2.deviceType(null);
		builder2.deviceDetails(null);
		builder2.createdBy(null);
		builder2.createdTime(null);
		builder2.moduleType(null);
		builder2.tenantId(null);
		builder2.sourceUuid(null);
		builder2.build();

		Assert.assertEquals(builder2.toString(), builder.toString());
	}
	

	/**
	 * Run the String getApprovalStatus() method test.
	 *
	 * @throws Exception
	 *
	 *  at 30/04/20 1:32 PM
	 */
	@Test
	public void testGetModuleType_1()
		throws Exception {
		DeviceSources fixture = new DeviceSources("","","","","",null, new Long(1L));

		String result = fixture.getModuleType();		
		assertEquals("", result);
	}
	
	/**
	 * Run the String getItemUuid() method test.
	 *
	 * @throws Exception
	 *
	 *  at 30/04/20 1:32 PM
	 */
	@Test
	public void testGetDeviceType_1()
		throws Exception {
		DeviceSources fixture = new DeviceSources("","","","","",null, new Long(1L));

		String result = fixture.getDeviceType();	
		assertEquals("", result);
	}

	/**
	 * Run the String getItemName() method test.
	 *
	 * @throws Exception
	 *
	 *  at 30/04/20 1:32 PM
	 */
	@Test
	public void testGetDeviceDetails_1()
		throws Exception {
		DeviceSources fixture = new DeviceSources("","","","","",null, new Long(1L));

		String result = fixture.getDeviceDetails()	;
		assertEquals("", result);
	}

	
	/**
	 * Run the String getCreatedBy() method test.
	 *
	 * @throws Exception
	 *
	 *  at 30/04/20 1:32 PM
	 */
	@Test
	public void testGetCreatedBy_1()
		throws Exception {
		DeviceSources fixture = new DeviceSources("","","","","",null, new Long(1L));

		String result = fixture.getCreatedBy();

		
		assertEquals(null, result);
	}

	/**
	 * Run the Long getCreatedTime() method test.
	 *
	 * @throws Exception
	 *
	 *  at 30/04/20 1:32 PM
	 */
	@Test
	public void testGetCreatedTime_1()
		throws Exception {
		DeviceSources fixture = new DeviceSources("","","","","",null, new Long(1L));

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


	/**
	 * Run the String getTenantId() method test.
	 *
	 * @throws Exception
	 *
	 *  at 30/04/20 1:32 PM
	 */
	@Test
	public void testGetTenantId_1()
		throws Exception {
		DeviceSources fixture = new DeviceSources("","","","","",null, new Long(1L));

		String result = fixture.getTenantId();

		
		assertEquals("", result);
	}
	
	/**
	 * Run the String getApprovalStatus() method test.
	 *
	 * @throws Exception
	 *
	 *  at 30/04/20 1:32 PM
	 */
	@Test
	public void testSetModuleType_1()
		throws Exception {
		DeviceSources fixture = new DeviceSources("","","","","",null, new Long(1L));
		String moduleType ="" ;		
		fixture.setModuleType(moduleType);
	}
	
	/**
	 * Run the String getItemUuid() method test.
	 *
	 * @throws Exception
	 *
	 *  at 30/04/20 1:32 PM
	 */
	@Test
	public void testSetDeviceType_1()
		throws Exception {
		DeviceSources fixture = new DeviceSources("","","","","",null, new Long(1L));
		String deviceType ="" ;		
		fixture.setDeviceType(deviceType);
	}

	/**
	 * Run the String setItemName() method test.
	 *
	 * @throws Exception
	 *
	 *  at 30/04/20 1:32 PM
	 */
	@Test
	public void testSetDeviceDetails_1()
		throws Exception {
		DeviceSources fixture = new DeviceSources("","","","","",null, new Long(1L));
		String deviceDetails ="" ;		
		fixture.setDeviceDetails(deviceDetails);
	}
	
	/**
	 * Run the void setCreatedBy(String) method test.
	 *
	 * @throws Exception
	 *
	 *  at 30/04/20 1:32 PM
	 */
	@Test
	public void testSetCreatedBy_1()
		throws Exception {
		DeviceSources fixture = new DeviceSources("","","","","",null, new Long(1L));
		String createdBy = "";

		fixture.setCreatedBy(createdBy);

		
	}

	/**
	 * Run the void setCreatedTime(Long) method test.
	 *
	 * @throws Exception
	 *
	 *  at 30/04/20 1:32 PM
	 */
	@Test
	public void testSetCreatedTime_1()
		throws Exception {
		DeviceSources fixture = new DeviceSources("","","","","",null, new Long(1L));
		Long createdTime = new Long(1L);

		fixture.setCreatedTime(createdTime);

		
	}


	/**
	 * Run the void setTenantId(String) method test.
	 *
	 * @throws Exception
	 *
	 *  at 30/04/20 1:32 PM
	 */
	@Test
	public void testSetTenantId_1()
		throws Exception {
		DeviceSources fixture = new DeviceSources("","","","","",null, new Long(1L));
		String tenantId = "";
		fixture.setTenantId(tenantId);

		
	}
	
	@Test
	public void testSetSourceUuid_1() throws Exception {
		DeviceSources fixture = new DeviceSources("","","","","",null, new Long(1L));
		String sourceUuid = "";
		fixture.setSourceUuid(sourceUuid);

	}
	
	@Test
	public void testGetSourceUuid_1() throws Exception {
		DeviceSources fixture = new DeviceSources("","","","","",null, new Long(1L));

		String result = fixture.getSourceUuid();

		assertEquals("", result);
	}


}
