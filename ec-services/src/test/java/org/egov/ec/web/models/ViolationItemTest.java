package org.egov.ec.web.models;

import org.junit.*;
import static org.junit.Assert.*;

import org.egov.ec.web.models.ViolationItem;

public class ViolationItemTest {

	/**
	 * Run the ViolationItem() constructor test.
	 *
	 * @throws Exception
	 *
	 *                   at 30/4/20 5:39 AM
	 */
	@Test
	public void testViolationItem_1() throws Exception {

		ViolationItem result = new ViolationItem();

		assertNotNull(result);
		assertEquals(null, result.getViolationItemUuid());
		assertEquals(null, result.getViolationUuid());
		assertEquals(null, result.getItemUuid());
		assertEquals(null, result.getTenantId());
		assertEquals(null, result.getItemName());
		assertEquals(null, result.getItemType());
		assertEquals(null, result.getQuantity());
		assertEquals(null, result.getVehicleNumber());
		assertEquals(null, result.getChallanId());		
		assertEquals(null, result.getIsActive());
		assertEquals(null, result.getLastModifiedTime());
		assertEquals(null, result.getCreatedBy());
		assertEquals(null, result.getCreatedTime());
		assertEquals(null, result.getLastModifiedBy());
	}

	/**
	 * Run the
	 * ViolationItem(String,String,String,String,Long,String,Long,Boolean,String)
	 * constructor test.
	 *
	 * @throws Exception
	 *
	 *                   at 30/04/20 1:32 PM
	 */
	@Test
	public void testViolationItem_2() throws Exception {
		String violationItemUuid = "";
		String violationUuid = "";
		String itemUuid = "";
		String tenantId = "";
		String itemName = "";
		String itemType = "";
		Integer quanity= null;
		String remark="";
		String vehicleNumber="";
		String challanId="";
		Boolean isActive = new Boolean(true);
		Long lastModifiedTime = new Long(1L);
		String createdBy = "";
		Long createdTime = new Long(1L);
		String lastModifiedBy = "";

		ViolationItem result = new ViolationItem(violationItemUuid, violationUuid, itemUuid, tenantId, itemName, itemType, quanity,
				remark, vehicleNumber, challanId, isActive, createdBy, createdTime, lastModifiedBy, lastModifiedTime);

		assertNotNull(result);
		assertEquals("", result.getViolationItemUuid());
		assertEquals("", result.getViolationUuid());
		assertEquals("", result.getItemUuid());
		assertEquals("", result.getTenantId());
		assertEquals("", result.getItemName());
		assertEquals("", result.getItemType());
		assertEquals(null, result.getQuantity());
		assertEquals("", result.getRemark());
		assertEquals("", result.getVehicleNumber());
		assertEquals("", result.getChallanId());
		assertEquals(Boolean.TRUE, result.getIsActive());
		assertEquals("", result.getLastModifiedBy());
		assertEquals(new Long(1L), (result.getLastModifiedTime()));
		assertEquals("", result.getCreatedBy());
		assertEquals(new Long(1L), result.getCreatedTime());
		assertEquals("", result.getLastModifiedBy());

	}

	/**
	 * Run the ViolationItem.ViolationItemBuilder builder() method test.
	 *
	 * @throws Exception
	 *
	 *                   at 30/04/20 1:32 PM
	 */
	@Test
	public void testBuilder_1() throws Exception {

		ViolationItem.ViolationItemBuilder result = ViolationItem.builder();

		assertNotNull(result);
		assertEquals(
				"ViolationItem.ViolationItemBuilder(violationItemUuid=null, violationUuid=null, itemUuid=null, tenantId=null, itemName=null, itemType=null, quantity=null, remark=null, vehicleNumber=null, challanId=null, isActive=null, createdBy=null, createdTime=null, lastModifiedBy=null, lastModifiedTime=null)",
				result.toString());
	}

	/**
	 * Run the ViolationItem.ViolationItemBuilder builder() method test.
	 *
	 * @throws Exception
	 *
	 *  at 30/04/20 1:32 PM
	 */
	@Test
	public void testBuilder_2()
		throws Exception {

		ViolationItem.ViolationItemBuilder builder = new ViolationItem.ViolationItemBuilder();
		builder.violationItemUuid(null);
		builder.violationUuid(null);
		builder.itemUuid(null);
		builder.tenantId(null);
		builder.itemName(null);
		builder.itemType(null);
		builder.quantity(null);
		builder.remark(null);
		builder.vehicleNumber(null);
		builder.challanId(null);
		builder.isActive(null);
		builder.createdBy(null);
		builder.createdTime(null);
		builder.lastModifiedBy(null);
		builder.lastModifiedTime(null);
		builder.build();

		ViolationItem.ViolationItemBuilder builder2 = new ViolationItem.ViolationItemBuilder();
		builder2.violationItemUuid(null);
		builder2.violationUuid(null);
		builder2.itemUuid(null);
		builder2.tenantId(null);
		builder2.itemName(null);
		builder2.itemType(null);
		builder2.quantity(null);
		builder2.remark(null);
		builder2.vehicleNumber(null);
		builder2.challanId(null);
		builder2.isActive(null);
		builder2.createdBy(null);
		builder2.createdTime(null);
		builder2.lastModifiedBy(null);
		builder2.lastModifiedTime(null);
		builder2.build();

		Assert.assertEquals(builder2.toString(), builder.toString());
	}

	
	@Test
	public void testGetViolationItemUuid_1() throws Exception {
		ViolationItem fixture = new ViolationItem("","","","","","",null,"","","", new Boolean(true),null, new Long(1L), "", new Long(1L));
		String result = fixture.getViolationItemUuid();
		assertEquals("", result);
	}
	
	@Test
	public void testGetViolationUuid_1() throws Exception {
		ViolationItem fixture = new ViolationItem("","","","","","",null,"","","", new Boolean(true),null, new Long(1L), "", new Long(1L));
		String result = fixture.getViolationUuid();
		assertEquals("", result);
	}
	
	@Test
	public void testGetItemUuid_1() throws Exception {
		ViolationItem fixture = new ViolationItem("","","","","","",null,"","","", new Boolean(true),null, new Long(1L), "", new Long(1L));
		String result = fixture.getItemUuid();
		assertEquals("", result);
	}
	
	@Test
	public void testGetTenantId_1() throws Exception {
		ViolationItem fixture = new ViolationItem("","","","","","",null,"","","", new Boolean(true),null, new Long(1L), "", new Long(1L));
		String result = fixture.getTenantId();
		assertEquals("", result);
	}
	
	@Test
	public void testGetItemName_1() throws Exception {
		ViolationItem fixture = new ViolationItem("","","","","","",null,"","","", new Boolean(true),null, new Long(1L), "", new Long(1L));
		String result = fixture.getItemName();
		assertEquals("", result);
	}
	
	@Test
	public void testGetItemType_1() throws Exception {
		ViolationItem fixture = new ViolationItem("","","","","","",null,"","","", new Boolean(true),null, new Long(1L), "", new Long(1L));
		String result = fixture.getItemType();
		assertEquals("", result);
	}
	
	@Test
	public void testGetQuantity_1() throws Exception {
		ViolationItem fixture = new ViolationItem("","","","","","",null,"","","", new Boolean(true),null, new Long(1L), "", new Long(1L));
		Integer result = fixture.getQuantity();
		assertEquals(null, result);
	}
	
	@Test
	public void testGetRemark_1() throws Exception {
		ViolationItem fixture = new ViolationItem("","","","","","",null,"","","", new Boolean(true),null, new Long(1L), "", new Long(1L));
		String result = fixture.getRemark();
		assertEquals("", result);
	}
	
	@Test
	public void testGetVehicleNumber_1() throws Exception {
		ViolationItem fixture = new ViolationItem("","","","","","",null,"","","", new Boolean(true),null, new Long(1L), "", new Long(1L));
		String result = fixture.getVehicleNumber();
		assertEquals("", result);
	}
	
	@Test
	public void testGetChallanId_1() throws Exception {
		ViolationItem fixture = new ViolationItem("","","","","","",null,"","","", new Boolean(true),null, new Long(1L), "", new Long(1L));
		String result = fixture.getChallanId();
		assertEquals("", result);
	}
	
	@Test
	public void testGetIsActive_1() throws Exception {
		ViolationItem fixture = new ViolationItem("","","","","","",null,"","","", new Boolean(true),null, new Long(1L), "", new Long(1L));
	Boolean result = fixture.getIsActive();

	assertNotNull(result);
	assertEquals("true", result.toString());
	assertEquals(true, result.booleanValue());
	}
	
	
	/**
	 * Run the String getCreatedBy() method test.
	 *
	 * @throws Exception
	 *
	 *                   at 30/04/20 1:32 PM
	 */
	@Test
	public void testGetCreatedBy_1() throws Exception {
		ViolationItem fixture = new ViolationItem("","","","","","",null,"","","", new Boolean(true),null, new Long(1L), "", new Long(1L));

		String result = fixture.getCreatedBy();

		assertEquals(null, result);
	}

	/**
	 * Run the Long getCreatedTime() method test.
	 *
	 * @throws Exception
	 *
	 *                   at 30/04/20 1:32 PM
	 */
	@Test
	public void testGetCreatedTime_1() throws Exception {
		ViolationItem fixture =  new ViolationItem("","","","","","",null,"","","", new Boolean(true),null, new Long(1L), "", new Long(1L));

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
	 * Run the String getLastModifiedBy() method test.
	 *
	 * @throws Exception
	 *
	 *                   at 30/04/20 1:32 PM
	 */
	@Test
	public void testGetLastModifiedBy_1() throws Exception {
		ViolationItem fixture =  new ViolationItem("","","","","","",null,"","","", new Boolean(true),null, new Long(1L), "", new Long(1L));

		String result = fixture.getLastModifiedBy();

		assertEquals("", result);
	}

	/**
	 * Run the Long getLastModifiedTime() method test.
	 *
	 * @throws Exception
	 *
	 *                   at 30/04/20 1:32 PM
	 */
	@Test
	public void testGetLastModifiedTime_1() throws Exception {
		ViolationItem fixture =  new ViolationItem("","","","","","",null,"","","", new Boolean(true),null, new Long(1L), "", new Long(1L));

		Long result = fixture.getLastModifiedTime();

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
	public void testSetViolationItemUuid_1() throws Exception {
		ViolationItem fixture =  new ViolationItem("","","","","","",null,"","","", new Boolean(true),null, new Long(1L), "", new Long(1L));
		String violationItemUuid = "";
		fixture.setViolationItemUuid(violationItemUuid);

	}
	
	@Test
	public void testSetViolationUuid_1() throws Exception {
		ViolationItem fixture =  new ViolationItem("","","","","","",null,"","","", new Boolean(true),null, new Long(1L), "", new Long(1L));
		String violationUuid = "";
		fixture.setViolationUuid(violationUuid);

	}
	
	@Test
	public void testSetItemUuid_1() throws Exception {
		ViolationItem fixture =  new ViolationItem("","","","","","",null,"","","", new Boolean(true),null, new Long(1L), "", new Long(1L));
		String itemUuid = "";
		fixture.setItemUuid(itemUuid);

	}
	
	@Test
	public void testSetTenantId_1() throws Exception {
		ViolationItem fixture =  new ViolationItem("","","","","","",null,"","","", new Boolean(true),null, new Long(1L), "", new Long(1L));
		String tenantId = "";
		fixture.setTenantId(tenantId);

	}
	
	@Test
	public void testSetItemName_1() throws Exception {
		ViolationItem fixture =  new ViolationItem("","","","","","",null,"","","", new Boolean(true),null, new Long(1L), "", new Long(1L));
		String itemName = "";
		fixture.setItemName(itemName);

	}
	
	@Test
	public void testSetItemType_1() throws Exception {
		ViolationItem fixture =  new ViolationItem("","","","","","",null,"","","", new Boolean(true),null, new Long(1L), "", new Long(1L));
		String itemType = "";
		fixture.setItemType(itemType);

	}
	
	@Test
	public void testSetQuantity_1() throws Exception {
		ViolationItem fixture =  new ViolationItem("","","","","","",null,"","","", new Boolean(true),null, new Long(1L), "", new Long(1L));
		Integer quantity = null;
		fixture.setQuantity(quantity);

	}
	
	@Test
	public void testSetRemark_1() throws Exception {
		ViolationItem fixture =  new ViolationItem("","","","","","",null,"","","", new Boolean(true),null, new Long(1L), "", new Long(1L));
		String remark = "";
		fixture.setRemark(remark);

	}
	
	@Test
	public void testSetVehicleNumber_1() throws Exception {
		ViolationItem fixture =  new ViolationItem("","","","","","",null,"","","", new Boolean(true),null, new Long(1L), "", new Long(1L));
		String vehicleNumber = "";
		fixture.setVehicleNumber(vehicleNumber);

	}
	
	
	@Test
	public void testSetChallanId_1() throws Exception {
		ViolationItem fixture =  new ViolationItem("","","","","","",null,"","","", new Boolean(true),null, new Long(1L), "", new Long(1L));
		String challanId = "";
		fixture.setChallanId(challanId);

	}
	@Test
	public void testSetIsActive_1() throws Exception {
		ViolationItem fixture =  new ViolationItem("","","","","","",null,"","","", new Boolean(true),null, new Long(1L), "", new Long(1L));
		Boolean isActive = new Boolean(true);
		fixture.setIsActive(isActive);

	}
	/**
	 * Run the void setCreatedBy(String) method test.
	 *
	 * @throws Exception
	 *
	 *                   at 30/04/20 1:32 PM
	 */
	@Test
	public void testSetCreatedBy_1() throws Exception {
		ViolationItem fixture =  new ViolationItem("","","","","","",null,"","","", new Boolean(true),null, new Long(1L), "", new Long(1L));
		String createdBy = "";

		fixture.setCreatedBy(createdBy);

	}

	/**
	 * Run the void setCreatedTime(Long) method test.
	 *
	 * @throws Exception
	 *
	 *                   at 30/04/20 1:32 PM
	 */
	@Test
	public void testSetCreatedTime_1() throws Exception {
		ViolationItem fixture =  new ViolationItem("","","","","","",null,"","","", new Boolean(true),null, new Long(1L), "", new Long(1L));
		Long createdTime = new Long(1L);

		fixture.setCreatedTime(createdTime);

	}

	/**
	 * Run the void setLastModifiedBy(String) method test.
	 *
	 * @throws Exception
	 *
	 *                   at 30/04/20 1:32 PM
	 */
	@Test
	public void testSetLastModifiedBy_1() throws Exception {
		ViolationItem fixture =  new ViolationItem("","","","","","",null,"","","", new Boolean(true),null, new Long(1L), "", new Long(1L));
		String lastModifiedBy = "";
		fixture.setLastModifiedBy(lastModifiedBy);

	}

	/**
	 * Run the void setLastModifiedTime(Long) method test.
	 *
	 * @throws Exception
	 *
	 *                   at 30/04/20 1:32 PM
	 */
	@Test
	public void testSetLastModifiedTime_1() throws Exception {
		ViolationItem fixture =  new ViolationItem("","","","","","",null,"","","", new Boolean(true),null, new Long(1L), "", new Long(1L));
		Long lastModifiedTime = new Long(1L);
		fixture.setLastModifiedTime(lastModifiedTime);

	}

}
