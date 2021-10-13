package org.egov.ec.web.models;

import org.junit.*;
import static org.junit.Assert.*;

import org.egov.ec.web.models.ItemMaster;

public class ItemMasterTest {
	
	/**
	 * Run the ItemMaster() constructor test.
	 *
	 * @throws Exception
	 *
	 *  at 30/4/20 5:39 AM
	 */
	@Test
	public void testItemMaster_1()
		throws Exception {

		ItemMaster result = new ItemMaster();

		
		assertNotNull(result);
		assertEquals(null, result.getItemName());
		assertEquals(null, result.getLastModifiedTime());
		assertEquals(null, result.getCreatedBy());
		assertEquals(null, result.getCreatedTime());
		assertEquals(null, result.getTenantId());
		assertEquals(null, result.getLastModifiedBy());
		assertEquals(null, result.getApprovalStatus());
		assertEquals(null, result.getItemUuid());
		assertEquals(null, result.getDescription());
		assertEquals(null, result.getIsActive());
		assertEquals(null, result.getSourceUuid());
	}
	
	/**
	 * Run the ItemMaster(String,String,String,String,Long,String,Long,Boolean,String) constructor test.
	 *
	 * @throws Exception
	 *
	 *  at 30/04/20 1:32 PM
	 */
	@Test
	public void testItemMaster_2()
		throws Exception {
		String tenantId = "";
		String itemName="";
		String description = "";
		String approvalStatus = "";
		Boolean isActive = new Boolean(true);
		String itemUuid = "";
		String createdBy = "";
		Long createdTime = new Long(1L);
		String lastModifiedBy = "";
		Long lastModifiedTime = new Long(1L);
		String sourceUuid="";


		ItemMaster result = new ItemMaster(tenantId,itemName,description,approvalStatus,isActive,itemUuid,createdBy,createdTime,lastModifiedBy,lastModifiedTime, sourceUuid);

		
		assertNotNull(result);
		assertEquals(new Long(1L), (result.getLastModifiedTime()));
		assertEquals(Boolean.TRUE, result.getIsActive());
		assertEquals("", result.getCreatedBy());
		assertEquals(new Long(1L), result.getCreatedTime());
		assertEquals("", result.getTenantId());
		assertEquals("", result.getLastModifiedBy());
		assertEquals("", result.getItemName());
		assertEquals("", result.getApprovalStatus());
		assertEquals("", result.getItemUuid());
		assertEquals("", result.getDescription());
		assertEquals("", result.getSourceUuid());
	}
	
	/**
	 * Run the ItemMaster.ItemMasterBuilder builder() method test.
	 *
	 * @throws Exception
	 *
	 *  at 30/04/20 1:32 PM
	 */
	@Test
	public void testBuilder_1()
		throws Exception {

		ItemMaster.ItemMasterBuilder result = ItemMaster.builder();

		
		assertNotNull(result);
		assertEquals("ItemMaster.ItemMasterBuilder(tenantId=null, itemName=null, description=null, approvalStatus=null, isActive=null, itemUuid=null, createdBy=null, createdTime=null, lastModifiedBy=null, lastModifiedTime=null, sourceUuid=null)", result.toString());
	}
	
	/**
	 * Run the ItemMaster.ItemMasterBuilder builder() method test.
	 *
	 * @throws Exception
	 *
	 *  at 30/04/20 1:32 PM
	 */
	@Test
	public void testBuilder_2()
		throws Exception {

		ItemMaster.ItemMasterBuilder builder = new ItemMaster.ItemMasterBuilder();
		builder.approvalStatus(null);
		builder.itemName(null);
		builder.createdBy(null);
		builder.createdTime(null);
		builder.description(null);
		builder.isActive(null);
		builder.lastModifiedBy(null);
		builder.lastModifiedTime(null);
		builder.itemUuid(null);
		builder.tenantId(null);
		builder.sourceUuid(null);
		builder.build();

		ItemMaster.ItemMasterBuilder builder2 = new ItemMaster.ItemMasterBuilder();
		builder2.approvalStatus(null);
		builder2.itemName(null);
		builder2.createdBy(null);
		builder2.createdTime(null);
		builder2.description(null);
		builder2.isActive(null);
		builder2.lastModifiedBy(null);
		builder2.lastModifiedTime(null);
		builder2.itemUuid(null);
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
	public void testGetApprovalStatus_1()
		throws Exception {
		ItemMaster fixture = new ItemMaster("","","","",new Boolean(true),"",null, new Long(1L),"",new Long(1L),"");

		String result = fixture.getApprovalStatus();		
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
	public void testGetItemUuid_1()
		throws Exception {
		ItemMaster fixture = new ItemMaster("","","","",new Boolean(true),"",null, new Long(1L),"",new Long(1L),"");

		String result = fixture.getItemUuid();		
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
	public void testGetItemName_1()
		throws Exception {
		ItemMaster fixture = new ItemMaster("","","","",new Boolean(true),"",null, new Long(1L),"",new Long(1L),"");

		String result = fixture.getItemName();		
		assertEquals("", result);
	}
	
	/**
	 * Run the String getDescription() method test.
	 *
	 * @throws Exception
	 *
	 *  at 30/04/20 1:32 PM
	 */
	@Test
	public void testGetDescription_1()
		throws Exception {
		ItemMaster fixture = new ItemMaster("","","","",new Boolean(true),"",null, new Long(1L),"",new Long(1L),"");

		String result = fixture.getDescription();		
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
		ItemMaster fixture = new ItemMaster("","","","",new Boolean(true),"",null, new Long(1L),"",new Long(1L),"");

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
		ItemMaster fixture = new ItemMaster("","","","",new Boolean(true),"",null, new Long(1L),"",new Long(1L),"");

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
	 * Run the Boolean getIsActive() method test.
	 *
	 * @throws Exception
	 *
	 *  at 30/04/20 1:32 PM
	 */
	@Test
	public void testGetIsActive_1()
		throws Exception {
		ItemMaster fixture = new ItemMaster("","","","",new Boolean(true),"",null, new Long(1L),"",new Long(1L),"");

		Boolean result = fixture.getIsActive();

		
		assertNotNull(result);
		assertEquals("true", result.toString());
		assertEquals(true, result.booleanValue());
	}

	/**
	 * Run the String getLastModifiedBy() method test.
	 *
	 * @throws Exception
	 *
	 *  at 30/04/20 1:32 PM
	 */
	@Test
	public void testGetLastModifiedBy_1()
		throws Exception {
		ItemMaster fixture = new ItemMaster("","","","",new Boolean(true),"",null, new Long(1L),"",new Long(1L),"");

		String result = fixture.getLastModifiedBy();

		
		assertEquals("", result);
	}

	/**
	 * Run the Long getLastModifiedTime() method test.
	 *
	 * @throws Exception
	 *
	 *  at 30/04/20 1:32 PM
	 */
	@Test
	public void testGetLastModifiedTime_1()
		throws Exception {
		ItemMaster fixture = new ItemMaster("","","","",new Boolean(true),"",null, new Long(1L),"",new Long(1L),"");

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
		ItemMaster fixture = new ItemMaster("","","","",new Boolean(true),"",null, new Long(1L),"",new Long(1L),"");

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
	public void testSetApprovalStatus_1()
		throws Exception {
		ItemMaster fixture = new ItemMaster("","","","",new Boolean(true),"",null, new Long(1L),"",new Long(1L),"");
		String approvalStatus ="" ;		
		fixture.setApprovalStatus(approvalStatus);
	}
	
	/**
	 * Run the String getItemUuid() method test.
	 *
	 * @throws Exception
	 *
	 *  at 30/04/20 1:32 PM
	 */
	@Test
	public void testSetItemUuid_1()
		throws Exception {
		ItemMaster fixture = new ItemMaster("","","","",new Boolean(true),"",null, new Long(1L),"",new Long(1L),"");
		String itemUuid ="" ;		
		fixture.setItemUuid(itemUuid);
	}

	/**
	 * Run the String setItemName() method test.
	 *
	 * @throws Exception
	 *
	 *  at 30/04/20 1:32 PM
	 */
	@Test
	public void testSetItemName_1()
		throws Exception {
		ItemMaster fixture = new ItemMaster("","","","",new Boolean(true),"",null, new Long(1L),"",new Long(1L),"");
		String itemName ="" ;		
		fixture.setItemName(itemName);
	}
	
	/**
	 * Run the String getDescription() method test.
	 *
	 * @throws Exception
	 *
	 *  at 30/04/20 1:32 PM
	 */
	@Test
	public void testSetDescription_1()
		throws Exception {
		ItemMaster fixture = new ItemMaster("","","","",new Boolean(true),"",null, new Long(1L),"",new Long(1L),"");
		String description ="" ;		
		fixture.setDescription(description);
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
		ItemMaster fixture = new ItemMaster("","","","",new Boolean(true),"",null, new Long(1L),"",new Long(1L),"");
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
		ItemMaster fixture = new ItemMaster("","","","",new Boolean(true),"",null, new Long(1L),"",new Long(1L),"");
		Long createdTime = new Long(1L);

		fixture.setCreatedTime(createdTime);

		
	}

	/**
	 * Run the void setIsActive(Boolean) method test.
	 *
	 * @throws Exception
	 *
	 *  at 30/04/20 1:32 PM
	 */
	@Test
	public void testSetIsActive_1()
		throws Exception {
		ItemMaster fixture = new ItemMaster("","","","",new Boolean(true),"",null, new Long(1L),"",new Long(1L),"");
		Boolean isActive = new Boolean(true);
		fixture.setIsActive(isActive);

		
	}

	/**
	 * Run the void setLastModifiedBy(String) method test.
	 *
	 * @throws Exception
	 *
	 *  at 30/04/20 1:32 PM
	 */
	@Test
	public void testSetLastModifiedBy_1()
		throws Exception {
		ItemMaster fixture = new ItemMaster("","","","",new Boolean(true),"",null, new Long(1L),"",new Long(1L),"");
		String lastModifiedBy = "";
		fixture.setLastModifiedBy(lastModifiedBy);

		
	}

	/**
	 * Run the void setLastModifiedTime(Long) method test.
	 *
	 * @throws Exception
	 *
	 *  at 30/04/20 1:32 PM
	 */
	@Test
	public void testSetLastModifiedTime_1()
		throws Exception {
		ItemMaster fixture = new ItemMaster("","","","",new Boolean(true),"",null, new Long(1L),"",new Long(1L),"");
		Long lastModifiedTime = new Long(1L);
		fixture.setLastModifiedTime(lastModifiedTime);

		
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
		ItemMaster fixture = new ItemMaster("","","","",new Boolean(true),"",null, new Long(1L),"",new Long(1L),"");
		String tenantId = "";
		fixture.setTenantId(tenantId);

		
	}
	
	@Test
	public void testSetSourceUuid_1() throws Exception {
		ItemMaster fixture = new ItemMaster("","","","",new Boolean(true),"",null, new Long(1L),"",new Long(1L),"");
		String sourceUuid = "";
		fixture.setSourceUuid(sourceUuid);

	}
	
	@Test
	public void testGetSourceUuid_1() throws Exception {
		ItemMaster fixture = new ItemMaster("","","","",new Boolean(true),"",null, new Long(1L),"",new Long(1L),"");

		String result = fixture.getSourceUuid();

		assertEquals("", result);
	}


}
