package org.egov.ec.web.models;

import java.util.List;

import org.egov.ec.web.models.Document;
import org.egov.ec.web.models.StoreItemRegister;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * The class <code>StoreItemRegisterTest</code> contains tests for the class <code>{@link StoreItemRegister}</code>.
 *
 * @generated at 17/5/20 2:11 PM
 * @version $Revision: 1.0 $
 */
public class StoreItemRegisterTest {
	/**
	 * Run the StoreItemRegister() constructor test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:11 PM
	 */
	@Test
	public void testStoreItemRegister_1()
		throws Exception {

		StoreItemRegister result = new StoreItemRegister();

		
		assertNotNull(result);
		assertEquals(null, result.getLastModifiedTime());
		assertEquals(null, result.getStatus());
		assertEquals(null, result.getRemark());
		assertEquals(null, result.getItemUuid());
		assertEquals(null, result.getItemName());
		assertEquals(null, result.getIsAuctioned());
		assertEquals(null, result.getStoreItemUuid());
		assertEquals(null, result.getIsActive());
		assertEquals(null, result.getIsVerified());
		assertEquals(null, result.getQuantity());
		assertEquals(null, result.getTenantId());
		assertEquals(null, result.getCreatedTime());
		assertEquals(null, result.getCreatedBy());
		assertEquals(null, result.getViolationItemUuid());
		assertEquals(null, result.getItemStoreDepositDate());
		assertEquals(null, result.getAuctionedQuantity());
		assertEquals(null, result.getStoreItemRegister());
		assertEquals(null, result.getViolationUuid());
		assertEquals(null, result.getPaymentMode());
		assertEquals(null, result.getChallanId());
		assertEquals(null, result.getLastModifiedBy());
		assertEquals(null, result.getSourceUuid());
		assertEquals(null, result.getDocument());
		assertEquals(null, result.getDamagedQuantity());
	}
	
	/**
	 * Run the StoreItemRegister(String,String,String,String,String,Long,Long,Boolean,Boolean,String,String,String,String,Boolean,String,Long,String,String,String,Long,List<StoreItemRegister>) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:11 PM
	 */
	@Test
	public void testStoreItemRegister_2()
		throws Exception {
		String storeItemUuid = "";
		String tenantId = "";
		String challanId = "";
		String itemUuid = "";
		String itemName = "";
		Long quantity = new Long(1L);
		Long auctionedQuantity = new Long(1L);
		Boolean isVerified = new Boolean(true);
		Boolean isAuctioned = new Boolean(true);
		String remark = "";
		String itemStoreDepositDate = "";
		String violationItemUuid = "";
		String violationUuid = "";
		Boolean isActive = new Boolean(true);
		String createdBy = "";
		Long createdTime = new Long(1L);
		String lastModifiedBy = "";
		String status = "";
		String paymentMode = "";
		String challanUuid="";
		Boolean isReturned = new Boolean(true);
		Long lastModifiedTime = new Long(1L);
		String sourceUuid="";
		List<StoreItemRegister> storeItemRegister = null;
		List<Document> document = null;
		Long damagedQuantity= new Long(1L);

		StoreItemRegister result = new StoreItemRegister(storeItemUuid, tenantId, challanId, challanUuid, itemUuid, itemName, quantity, auctionedQuantity, isVerified, isAuctioned, isReturned, remark, itemStoreDepositDate, violationItemUuid, violationUuid, isActive, createdBy, createdTime, lastModifiedBy, status, paymentMode, lastModifiedTime, sourceUuid, storeItemRegister, document, damagedQuantity);

		assertNotNull(result);
		assertEquals(new Long(1L), result.getLastModifiedTime());
		assertEquals("", result.getStatus());
		assertEquals("", result.getRemark());
		assertEquals("", result.getItemUuid());
		assertEquals("", result.getItemName());
		assertEquals(Boolean.TRUE, result.getIsAuctioned());
		assertEquals("", result.getStoreItemUuid());
		assertEquals(Boolean.TRUE, result.getIsActive());
		assertEquals(Boolean.TRUE, result.getIsVerified());
		assertEquals(Boolean.TRUE, result.getIsReturned());
		assertEquals(new Long(1L), result.getQuantity());
		assertEquals("", result.getTenantId());
		assertEquals(new Long(1L), result.getCreatedTime());
		assertEquals("", result.getCreatedBy());
		assertEquals("", result.getViolationItemUuid());
		assertEquals("", result.getItemStoreDepositDate());
		assertEquals(new Long(1L), result.getAuctionedQuantity());
		assertEquals("", result.getViolationUuid());
		assertEquals("", result.getPaymentMode());
		assertEquals("", result.getChallanId());
		assertEquals("", result.getChallanUuid());
		assertEquals("", result.getLastModifiedBy());
		assertEquals("", result.getSourceUuid());
		assertEquals(null, result.getDocument());
		assertEquals(new Long(1L), result.getDamagedQuantity());
	}

	/**
	 * Run the StoreItemRegister.StoreItemRegisterBuilder builder() method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:11 PM
	 */
	@Test
	public void testBuilder_1()
		throws Exception {

		StoreItemRegister.StoreItemRegisterBuilder result = StoreItemRegister.builder();

		
		assertNotNull(result);
		assertEquals("StoreItemRegister.StoreItemRegisterBuilder(storeItemUuid=null, tenantId=null, challanId=null, challanUuid=null, itemUuid=null, itemName=null, quantity=null, auctionedQuantity=null, isVerified=null, isAuctioned=null, isReturned=null, remark=null, itemStoreDepositDate=null, violationItemUuid=null, violationUuid=null, isActive=null, createdBy=null, createdTime=null, lastModifiedBy=null, status=null, paymentMode=null, lastModifiedTime=null, sourceUuid=null, storeItemRegister=null, document=null, damagedQuantity=null)", result.toString());
	}
	
	@Test
	public void testBuilder_2()
		throws Exception {

		StoreItemRegister.StoreItemRegisterBuilder builder = new StoreItemRegister.StoreItemRegisterBuilder();
		builder.storeItemUuid(null);
		builder.itemName(null);
		builder.createdBy(null);
		builder.createdTime(null);
		builder.challanId(null);
		builder.itemName(null);
		builder.auctionedQuantity(null);
		builder.quantity(null);
		builder.isVerified(null);
		builder.isAuctioned(null);
		builder.remark(null);
		builder.violationItemUuid(null);
		builder.violationUuid(null);
		builder.paymentMode(null);
		builder.status(null);
		builder.storeItemRegister(null);
		builder.isActive(null);
		builder.lastModifiedBy(null);
		builder.lastModifiedTime(null);
		builder.itemUuid(null);
		builder.tenantId(null);
		builder.itemStoreDepositDate(null);
		builder.challanUuid(null);
		builder.isReturned(null);
		builder.sourceUuid(null);
		builder.document(null);
		builder.damagedQuantity(null);
		builder.build();

		StoreItemRegister.StoreItemRegisterBuilder builder2 = new StoreItemRegister.StoreItemRegisterBuilder();
		builder2.storeItemUuid(null);
		builder2.itemName(null);
		builder2.createdBy(null);
		builder2.createdTime(null);
		builder2.challanId(null);
		builder2.itemName(null);
		builder2.auctionedQuantity(null);
		builder2.quantity(null);
		builder2.isVerified(null);
		builder2.isAuctioned(null);
		builder2.remark(null);
		builder2.violationItemUuid(null);
		builder2.violationUuid(null);
		builder2.paymentMode(null);
		builder2.status(null);
		builder2.storeItemRegister(null);
		builder2.isActive(null);
		builder2.lastModifiedBy(null);
		builder2.lastModifiedTime(null);
		builder2.itemUuid(null);
		builder2.tenantId(null);
		builder2.itemStoreDepositDate(null);
		builder2.challanUuid(null);
		builder2.isReturned(null);
		builder2.sourceUuid(null);
		builder2.document(null);
		builder2.damagedQuantity(null);
		builder2.build();

		Assert.assertEquals(builder2.toString(), builder.toString());
	}

	/**
	 * Run the Long getAuctionedQuantity() method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:11 PM
	 */
	@Test
	public void testGetAuctionedQuantity_1()
		throws Exception {
		StoreItemRegister fixture = new StoreItemRegister("", "", "", "", "", "",new Long(1L), new Long(1L), new Boolean(true), new Boolean(true), new Boolean(true), "", "", "", "", new Boolean(true), "", new Long(1L), "", "", "", new Long(1L), "", null, null, new Long(1L));

		Long result = fixture.getAuctionedQuantity();

		
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
	public void testGetDamagedQuantity_1()
		throws Exception {
		StoreItemRegister fixture = new StoreItemRegister("", "", "", "", "", "",new Long(1L), new Long(1L), new Boolean(true), new Boolean(true), new Boolean(true), "", "", "", "", new Boolean(true), "", new Long(1L), "", "", "", new Long(1L), "", null, null, new Long(1L));

		Long result = fixture.getDamagedQuantity();

		
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
	 * Run the String getChallanId() method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:11 PM
	 */
	@Test
	public void testGetChallanId_1()
		throws Exception {
		StoreItemRegister fixture = new StoreItemRegister("", "", "", "", "", "",new Long(1L), new Long(1L), new Boolean(true), new Boolean(true), new Boolean(true), "", "", "", "", new Boolean(true), "", new Long(1L), "", "", "", new Long(1L), "", null,null, new Long(1L));

		String result = fixture.getChallanId();

		
		assertEquals("", result);
	}
	
	@Test
	public void testGetDocument_1()
		throws Exception {
		StoreItemRegister fixture = new StoreItemRegister("", "", "", "", "", "",new Long(1L), new Long(1L), new Boolean(true), new Boolean(true), new Boolean(true), "", "", "", "", new Boolean(true), "", new Long(1L), "", "", "", new Long(1L), "", null,null, new Long(1L));
		List<Document> result = fixture.getDocument();
		
		assertEquals(null, result);
	}

	/**
	 * Run the String getCreatedBy() method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:11 PM
	 */
	@Test
	public void testGetCreatedBy_1()
		throws Exception {
		StoreItemRegister fixture = new StoreItemRegister("", "", "", "", "", "",new Long(1L), new Long(1L), new Boolean(true), new Boolean(true), new Boolean(true), "", "", "", "", new Boolean(true), "", new Long(1L), "", "", "", new Long(1L), "", null,null, new Long(1L));

		String result = fixture.getCreatedBy();

		
		assertEquals("", result);
	}

	/**
	 * Run the Long getCreatedTime() method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:11 PM
	 */
	@Test
	public void testGetCreatedTime_1()
		throws Exception {
		StoreItemRegister fixture = new StoreItemRegister("", "", "", "", "", "",new Long(1L), new Long(1L), new Boolean(true), new Boolean(true), new Boolean(true), "", "", "", "", new Boolean(true), "", new Long(1L), "", "", "", new Long(1L), "", null,null, new Long(1L));

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
	 * @generated at 17/5/20 2:11 PM
	 */
	@Test
	public void testGetIsActive_1()
		throws Exception {
		StoreItemRegister fixture = new StoreItemRegister("", "", "", "", "", "",new Long(1L), new Long(1L), new Boolean(true), new Boolean(true), new Boolean(true), "", "", "", "", new Boolean(true), "", new Long(1L), "", "", "", new Long(1L), "", null,null, new Long(1L));

		Boolean result = fixture.getIsActive();

		
		assertNotNull(result);
		assertEquals("true", result.toString());
		assertEquals(true, result.booleanValue());
	}

	/**
	 * Run the Boolean getIsAuctioned() method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:11 PM
	 */
	@Test
	public void testGetIsAuctioned_1()
		throws Exception {
		StoreItemRegister fixture = new StoreItemRegister("", "", "", "", "", "",new Long(1L), new Long(1L), new Boolean(true), new Boolean(true), new Boolean(true), "", "", "", "", new Boolean(true), "", new Long(1L), "", "", "", new Long(1L), "", null,null, new Long(1L));

		Boolean result = fixture.getIsAuctioned();

		
		assertNotNull(result);
		assertEquals("true", result.toString());
		assertEquals(true, result.booleanValue());
	}

	/**
	 * Run the Boolean getIsVerified() method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:11 PM
	 */
	@Test
	public void testGetIsVerified_1()
		throws Exception {
		StoreItemRegister fixture = new StoreItemRegister("", "", "", "", "", "",new Long(1L), new Long(1L), new Boolean(true), new Boolean(true), new Boolean(true), "", "", "", "", new Boolean(true), "", new Long(1L), "", "", "", new Long(1L), "", null,null, new Long(1L));

		Boolean result = fixture.getIsVerified();

		
		assertNotNull(result);
		assertEquals("true", result.toString());
		assertEquals(true, result.booleanValue());
	}

	/**
	 * Run the String getItemName() method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:11 PM
	 */
	@Test
	public void testGetItemName_1()
		throws Exception {
		StoreItemRegister fixture = new StoreItemRegister("", "", "", "", "", "",new Long(1L), new Long(1L), new Boolean(true), new Boolean(true), new Boolean(true), "", "", "", "", new Boolean(true), "", new Long(1L), "", "", "", new Long(1L), "", null,null, new Long(1L));

		String result = fixture.getItemName();

		
		assertEquals("", result);
	}

	/**
	 * Run the String getItemStoreDepositDate() method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:11 PM
	 */
	@Test
	public void testGetItemStoreDepositDate_1()
		throws Exception {
		StoreItemRegister fixture = new StoreItemRegister("", "", "", "", "", "",new Long(1L), new Long(1L), new Boolean(true), new Boolean(true), new Boolean(true), "", "", "", "", new Boolean(true), "", new Long(1L), "", "", "", new Long(1L), "", null,null, new Long(1L));

		String result = fixture.getItemStoreDepositDate();

		
		assertEquals("", result);
	}

	/**
	 * Run the String getItemUuid() method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:11 PM
	 */
	@Test
	public void testGetItemUuid_1()
		throws Exception {
		StoreItemRegister fixture = new StoreItemRegister("", "", "", "", "", "",new Long(1L), new Long(1L), new Boolean(true), new Boolean(true), new Boolean(true), "", "", "", "", new Boolean(true), "", new Long(1L), "", "", "", new Long(1L), "", null,null, new Long(1L));

		String result = fixture.getItemUuid();

		
		assertEquals("", result);
	}

	/**
	 * Run the String getLastModifiedBy() method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:11 PM
	 */
	@Test
	public void testGetLastModifiedBy_1()
		throws Exception {
		StoreItemRegister fixture = new StoreItemRegister("", "", "", "", "", "",new Long(1L), new Long(1L), new Boolean(true), new Boolean(true), new Boolean(true), "", "", "", "", new Boolean(true), "", new Long(1L), "", "", "", new Long(1L), "", null,null, new Long(1L));

		String result = fixture.getLastModifiedBy();

		
		assertEquals("", result);
	}

	/**
	 * Run the Long getLastModifiedTime() method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:11 PM
	 */
	@Test
	public void testGetLastModifiedTime_1()
		throws Exception {
		StoreItemRegister fixture = new StoreItemRegister("", "", "", "", "", "",new Long(1L), new Long(1L), new Boolean(true), new Boolean(true), new Boolean(true), "", "", "", "", new Boolean(true), "", new Long(1L), "", "", "", new Long(1L), "", null,null, new Long(1L));

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
	 * Run the String getPaymentMode() method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:11 PM
	 */
	@Test
	public void testGetPaymentMode_1()
		throws Exception {
		StoreItemRegister fixture = new StoreItemRegister("", "", "", "", "", "",new Long(1L), new Long(1L), new Boolean(true), new Boolean(true), new Boolean(true), "", "", "", "", new Boolean(true), "", new Long(1L), "", "", "", new Long(1L), "", null,null, new Long(1L));

		String result = fixture.getPaymentMode();

		
		assertEquals("", result);
	}

	/**
	 * Run the Long getQuantity() method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:11 PM
	 */
	@Test
	public void testGetQuantity_1()
		throws Exception {
		StoreItemRegister fixture = new StoreItemRegister("", "", "", "", "", "",new Long(1L), new Long(1L), new Boolean(true), new Boolean(true), new Boolean(true), "", "", "", "", new Boolean(true), "", new Long(1L), "", "", "", new Long(1L), "", null,null, new Long(1L));

		Long result = fixture.getQuantity();

		
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
	 * Run the String getRemark() method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:11 PM
	 */
	@Test
	public void testGetRemark_1()
		throws Exception {
		StoreItemRegister fixture = new StoreItemRegister("", "", "", "", "", "",new Long(1L), new Long(1L), new Boolean(true), new Boolean(true), new Boolean(true), "", "", "", "", new Boolean(true), "", new Long(1L), "", "", "", new Long(1L), "", null,null, new Long(1L));

		String result = fixture.getRemark();

		
		assertEquals("", result);
	}

	/**
	 * Run the String getStatus() method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:11 PM
	 */
	@Test
	public void testGetStatus_1()
		throws Exception {
		StoreItemRegister fixture = new StoreItemRegister("", "", "", "", "", "",new Long(1L), new Long(1L), new Boolean(true), new Boolean(true), new Boolean(true), "", "", "", "", new Boolean(true), "", new Long(1L), "", "", "", new Long(1L), "", null,null, new Long(1L));

		String result = fixture.getStatus();

		
		assertEquals("", result);
	}

	/**
	 * Run the List<StoreItemRegister> getStoreItemRegister() method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:11 PM
	 */
	@Test
	public void testGetStoreItemRegister_1()
		throws Exception {
		StoreItemRegister fixture = new StoreItemRegister("", "", "", "", "", "",new Long(1L), new Long(1L), new Boolean(true), new Boolean(true), new Boolean(true), "", "", "", "", new Boolean(true), "", new Long(1L), "", "", "", new Long(1L), "", null,null, new Long(1L));

		List<StoreItemRegister> result = fixture.getStoreItemRegister();
		assertEquals(null, result);
	}

	/**
	 * Run the String getStoreItemUuid() method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:11 PM
	 */
	@Test
	public void testGetStoreItemUuid_1()
		throws Exception {
		StoreItemRegister fixture = new StoreItemRegister("", "", "", "", "", "",new Long(1L), new Long(1L), new Boolean(true), new Boolean(true), new Boolean(true), "", "", "", "", new Boolean(true), "", new Long(1L), "", "", "", new Long(1L), "", null,null, new Long(1L));

		String result = fixture.getStoreItemUuid();

		
		assertEquals("", result);
	}

	/**
	 * Run the String getTenantId() method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:11 PM
	 */
	@Test
	public void testGetTenantId_1()
		throws Exception {
		StoreItemRegister fixture = new StoreItemRegister("", "", "", "", "", "",new Long(1L), new Long(1L), new Boolean(true), new Boolean(true), new Boolean(true), "", "", "", "", new Boolean(true), "", new Long(1L), "", "", "", new Long(1L), "", null,null, new Long(1L));

		String result = fixture.getTenantId();

		
		assertEquals("", result);
	}
	
	@Test
	public void testGetChallanUuid_1()
		throws Exception {
		StoreItemRegister fixture = new StoreItemRegister("", "", "", "", "", "",new Long(1L), new Long(1L), new Boolean(true), new Boolean(true), new Boolean(true), "", "", "", "", new Boolean(true), "", new Long(1L), "", "", "", new Long(1L), "", null,null, new Long(1L));
		String result = fixture.getChallanUuid();

		assertEquals("", result);
	}
	
	@Test
	public void testGetIsReturned_1()
		throws Exception {
		StoreItemRegister fixture = new StoreItemRegister("", "", "", "", "", "",new Long(1L), new Long(1L), new Boolean(true), new Boolean(true), new Boolean(true), "", "", "", "", new Boolean(true), "", new Long(1L), "", "", "", new Long(1L), "", null,null, new Long(1L));
		Boolean result = fixture.getIsReturned();

		assertNotNull(result);
		assertEquals("true", result.toString());
		assertEquals(true, result.booleanValue());
	}

	/**
	 * Run the String getViolationItemUuid() method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:11 PM
	 */
	@Test
	public void testGetViolationItemUuid_1()
		throws Exception {
		StoreItemRegister fixture = new StoreItemRegister("", "", "", "", "", "",new Long(1L), new Long(1L), new Boolean(true), new Boolean(true), new Boolean(true), "", "", "", "", new Boolean(true), "", new Long(1L), "", "", "", new Long(1L), "", null,null, new Long(1L));

		String result = fixture.getViolationItemUuid();

		
		assertEquals("", result);
	}

	/**
	 * Run the String getViolationUuid() method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:11 PM
	 */
	@Test
	public void testGetViolationUuid_1()
		throws Exception {
		StoreItemRegister fixture = new StoreItemRegister("", "", "", "", "", "",new Long(1L), new Long(1L), new Boolean(true), new Boolean(true), new Boolean(true), "", "", "", "", new Boolean(true), "", new Long(1L), "", "", "", new Long(1L), "", null,null, new Long(1L));

		String result = fixture.getViolationUuid();

		
		assertEquals("", result);
	}

	/**
	 * Run the void setAuctionedQuantity(Long) method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:11 PM
	 */
	@Test
	public void testSetAuctionedQuantity_1()
		throws Exception {
		StoreItemRegister fixture = new StoreItemRegister("", "", "", "", "", "",new Long(1L), new Long(1L), new Boolean(true), new Boolean(true), new Boolean(true), "", "", "", "", new Boolean(true), "", new Long(1L), "", "", "", new Long(1L), "", null,null, new Long(1L));
		Long auctionedQuantity = new Long(1L);

		fixture.setAuctionedQuantity(auctionedQuantity);

		
	}
	
	@Test
	public void testSetDamagedQuantity_1()
		throws Exception {
		StoreItemRegister fixture = new StoreItemRegister("", "", "", "", "", "",new Long(1L), new Long(1L), new Boolean(true), new Boolean(true), new Boolean(true), "", "", "", "", new Boolean(true), "", new Long(1L), "", "", "", new Long(1L), "", null,null, new Long(1L));
		Long damagedQuantity = new Long(1L);

		fixture.setDamagedQuantity(damagedQuantity);

		
	}

	/**
	 * Run the void setChallanId(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:11 PM
	 */
	@Test
	public void testSetChallanId_1()
		throws Exception {
		StoreItemRegister fixture = new StoreItemRegister("", "", "", "", "", "",new Long(1L), new Long(1L), new Boolean(true), new Boolean(true), new Boolean(true), "", "", "", "", new Boolean(true), "", new Long(1L), "", "", "", new Long(1L), "", null,null, new Long(1L));
		String challanId = "";

		fixture.setChallanId(challanId);

		
	}
	
	@Test
	public void testSetChallanUuidd_1()
		throws Exception {
		StoreItemRegister fixture = new StoreItemRegister("", "", "", "", "", "",new Long(1L), new Long(1L), new Boolean(true), new Boolean(true), new Boolean(true), "", "", "", "", new Boolean(true), "", new Long(1L), "", "", "", new Long(1L), "", null,null, new Long(1L));
		String challanUuid = "";

		fixture.setChallanUuid(challanUuid);

		
	}


	/**
	 * Run the void setCreatedBy(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:11 PM
	 */
	@Test
	public void testSetCreatedBy_1()
		throws Exception {
		StoreItemRegister fixture = new StoreItemRegister("", "", "", "", "", "",new Long(1L), new Long(1L), new Boolean(true), new Boolean(true), new Boolean(true), "", "", "", "", new Boolean(true), "", new Long(1L), "", "", "", new Long(1L), "", null,null, new Long(1L));
		String createdBy = "";

		fixture.setCreatedBy(createdBy);

		
	}

	/**
	 * Run the void setCreatedTime(Long) method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:11 PM
	 */
	@Test
	public void testSetCreatedTime_1()
		throws Exception {
		StoreItemRegister fixture = new StoreItemRegister("", "", "", "", "", "",new Long(1L), new Long(1L), new Boolean(true), new Boolean(true), new Boolean(true), "", "", "", "", new Boolean(true), "", new Long(1L), "", "", "", new Long(1L), "", null,null, new Long(1L));
		Long createdTime = new Long(1L);

		fixture.setCreatedTime(createdTime);

		
	}

	/**
	 * Run the void setIsActive(Boolean) method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:11 PM
	 */
	@Test
	public void testSetIsActive_1()
		throws Exception {
		StoreItemRegister fixture = new StoreItemRegister("", "", "", "", "", "",new Long(1L), new Long(1L), new Boolean(true), new Boolean(true), new Boolean(true), "", "", "", "", new Boolean(true), "", new Long(1L), "", "", "", new Long(1L), "", null,null, new Long(1L));
		Boolean isActive = new Boolean(true);

		fixture.setIsActive(isActive);

		
	}

	
	@Test
	public void testSetIsReturned_1()
		throws Exception {
		StoreItemRegister fixture = new StoreItemRegister("", "", "", "", "", "",new Long(1L), new Long(1L), new Boolean(true), new Boolean(true), new Boolean(true), "", "", "", "", new Boolean(true), "", new Long(1L), "", "", "", new Long(1L), "", null,null, new Long(1L));
		Boolean isReturned = new Boolean(true);

		fixture.setIsReturned(isReturned);

		
	}
	
	/**
	 * Run the void setIsAuctioned(Boolean) method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:11 PM
	 */
	@Test
	public void testSetIsAuctioned_1()
		throws Exception {
		StoreItemRegister fixture = new StoreItemRegister("", "", "", "", "", "",new Long(1L), new Long(1L), new Boolean(true), new Boolean(true), new Boolean(true), "", "", "", "", new Boolean(true), "", new Long(1L), "", "", "", new Long(1L), "", null,null, new Long(1L));
		Boolean isAuctioned = new Boolean(true);

		fixture.setIsAuctioned(isAuctioned);

		
	}

	/**
	 * Run the void setIsVerified(Boolean) method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:11 PM
	 */
	@Test
	public void testSetIsVerified_1()
		throws Exception {
		StoreItemRegister fixture = new StoreItemRegister("", "", "", "", "", "",new Long(1L), new Long(1L), new Boolean(true), new Boolean(true), new Boolean(true), "", "", "", "", new Boolean(true), "", new Long(1L), "", "", "", new Long(1L), "", null,null, new Long(1L));
		Boolean isVerified = new Boolean(true);

		fixture.setIsVerified(isVerified);

		
	}

	/**
	 * Run the void setItemName(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:11 PM
	 */
	@Test
	public void testSetItemName_1()
		throws Exception {
		StoreItemRegister fixture = new StoreItemRegister("", "", "", "", "", "",new Long(1L), new Long(1L), new Boolean(true), new Boolean(true), new Boolean(true), "", "", "", "", new Boolean(true), "", new Long(1L), "", "", "", new Long(1L), "", null,null, new Long(1L));
		String itemName = "";

		fixture.setItemName(itemName);

		
	}

	/**
	 * Run the void setItemStoreDepositDate(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:11 PM
	 */
	@Test
	public void testSetItemStoreDepositDate_1()
		throws Exception {
		StoreItemRegister fixture = new StoreItemRegister("", "", "", "", "", "",new Long(1L), new Long(1L), new Boolean(true), new Boolean(true), new Boolean(true), "", "", "", "", new Boolean(true), "", new Long(1L), "", "", "", new Long(1L), "", null,null, new Long(1L));
		String itemStoreDepositDate = "";

		fixture.setItemStoreDepositDate(itemStoreDepositDate);

		
	}

	/**
	 * Run the void setItemUuid(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:11 PM
	 */
	@Test
	public void testSetItemUuid_1()
		throws Exception {
		StoreItemRegister fixture = new StoreItemRegister("", "", "", "", "", "",new Long(1L), new Long(1L), new Boolean(true), new Boolean(true), new Boolean(true), "", "", "", "", new Boolean(true), "", new Long(1L), "", "", "", new Long(1L), "", null,null, new Long(1L));
		String itemUuid = "";

		fixture.setItemUuid(itemUuid);

		
	}

	/**
	 * Run the void setLastModifiedBy(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:11 PM
	 */
	@Test
	public void testSetLastModifiedBy_1()
		throws Exception {
		StoreItemRegister fixture = new StoreItemRegister("", "", "", "", "", "",new Long(1L), new Long(1L), new Boolean(true), new Boolean(true), new Boolean(true), "", "", "", "", new Boolean(true), "", new Long(1L), "", "", "", new Long(1L), "", null,null, new Long(1L));
		String lastModifiedBy = "";

		fixture.setLastModifiedBy(lastModifiedBy);

		
	}

	/**
	 * Run the void setLastModifiedTime(Long) method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:11 PM
	 */
	@Test
	public void testSetLastModifiedTime_1()
		throws Exception {
		StoreItemRegister fixture = new StoreItemRegister("", "", "", "", "", "",new Long(1L), new Long(1L), new Boolean(true), new Boolean(true), new Boolean(true), "", "", "", "", new Boolean(true), "", new Long(1L), "", "", "", new Long(1L), "", null,null, new Long(1L));
		Long lastModifiedTime = new Long(1L);

		fixture.setLastModifiedTime(lastModifiedTime);

		
	}

	/**
	 * Run the void setPaymentMode(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:11 PM
	 */
	@Test
	public void testSetPaymentMode_1()
		throws Exception {
		StoreItemRegister fixture = new StoreItemRegister("", "", "", "", "", "",new Long(1L), new Long(1L), new Boolean(true), new Boolean(true), new Boolean(true), "", "", "", "", new Boolean(true), "", new Long(1L), "", "", "", new Long(1L), "", null,null, new Long(1L));
		String paymentMode = "";

		fixture.setPaymentMode(paymentMode);

		
	}

	/**
	 * Run the void setQuantity(Long) method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:11 PM
	 */
	@Test
	public void testSetQuantity_1()
		throws Exception {
		StoreItemRegister fixture = new StoreItemRegister("", "", "", "", "", "",new Long(1L), new Long(1L), new Boolean(true), new Boolean(true), new Boolean(true), "", "", "", "", new Boolean(true), "", new Long(1L), "", "", "", new Long(1L), "", null,null, new Long(1L));
		Long quantity = new Long(1L);

		fixture.setQuantity(quantity);

		
	}

	/**
	 * Run the void setRemark(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:11 PM
	 */
	@Test
	public void testSetRemark_1()
		throws Exception {
		StoreItemRegister fixture = new StoreItemRegister("", "", "", "", "", "",new Long(1L), new Long(1L), new Boolean(true), new Boolean(true), new Boolean(true), "", "", "", "", new Boolean(true), "", new Long(1L), "", "", "", new Long(1L), "", null,null, new Long(1L));
		String remark = "";

		fixture.setRemark(remark);

		
	}

	/**
	 * Run the void setStatus(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:11 PM
	 */
	@Test
	public void testSetStatus_1()
		throws Exception {
		StoreItemRegister fixture = new StoreItemRegister("", "", "", "", "", "",new Long(1L), new Long(1L), new Boolean(true), new Boolean(true), new Boolean(true), "", "", "", "", new Boolean(true), "", new Long(1L), "", "", "", new Long(1L), "", null,null, new Long(1L));
		String status = "";

		fixture.setStatus(status);

		
	}

	/**
	 * Run the void setStoreItemRegister(List<StoreItemRegister>) method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:11 PM
	 */
	@Test
	public void testSetStoreItemRegister_1()
		throws Exception {
		StoreItemRegister fixture = new StoreItemRegister("", "", "", "", "", "",new Long(1L), new Long(1L), new Boolean(true), new Boolean(true), new Boolean(true), "", "", "", "", new Boolean(true), "", new Long(1L), "", "", "", new Long(1L), "", null,null, new Long(1L));
		List<StoreItemRegister> storeItemRegister = null;
		// add mock object expectations here

		

		fixture.setStoreItemRegister(storeItemRegister);

		
		
	}

	/**
	 * Run the void setStoreItemUuid(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:11 PM
	 */
	@Test
	public void testSetStoreItemUuid_1()
		throws Exception {
		StoreItemRegister fixture = new StoreItemRegister("", "", "", "", "", "",new Long(1L), new Long(1L), new Boolean(true), new Boolean(true), new Boolean(true), "", "", "", "", new Boolean(true), "", new Long(1L), "", "", "", new Long(1L), "", null,null, new Long(1L));
		String storeItemUuid = "";

		fixture.setStoreItemUuid(storeItemUuid);

		
	}

	/**
	 * Run the void setTenantId(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:11 PM
	 */
	@Test
	public void testSetTenantId_1()
		throws Exception {
		StoreItemRegister fixture = new StoreItemRegister("", "", "", "", "", "",new Long(1L), new Long(1L), new Boolean(true), new Boolean(true), new Boolean(true), "", "", "", "", new Boolean(true), "", new Long(1L), "", "", "", new Long(1L), "", null,null, new Long(1L));
		String tenantId = "";

		fixture.setTenantId(tenantId);

		
	}

	/**
	 * Run the void setViolationItemUuid(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:11 PM
	 */
	@Test
	public void testSetViolationItemUuid_1()
		throws Exception {
		StoreItemRegister fixture = new StoreItemRegister("", "", "", "", "", "",new Long(1L), new Long(1L), new Boolean(true), new Boolean(true), new Boolean(true), "", "", "", "", new Boolean(true), "", new Long(1L), "", "", "", new Long(1L), "", null,null, new Long(1L));
		String violationItemUuid = "";

		fixture.setViolationItemUuid(violationItemUuid);

		
	}

	/**
	 * Run the void setViolationUuid(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:11 PM
	 */
	@Test
	public void testSetViolationUuid_1()
		throws Exception {
		StoreItemRegister fixture = new StoreItemRegister("", "", "", "", "", "",new Long(1L), new Long(1L), new Boolean(true), new Boolean(true), new Boolean(true), "", "", "", "", new Boolean(true), "", new Long(1L), "", "", "", new Long(1L), "", null,null, new Long(1L));
		String violationUuid = "";

		fixture.setViolationUuid(violationUuid);

		
	}

	@Test
	public void testSetSourceUuid_1() throws Exception {
		StoreItemRegister fixture = new StoreItemRegister("", "", "", "", "", "",new Long(1L), new Long(1L), new Boolean(true), new Boolean(true), new Boolean(true), "", "", "", "", new Boolean(true), "", new Long(1L), "", "", "", new Long(1L), "", null,null, new Long(1L));
		String sourceUuid = "";
		fixture.setSourceUuid(sourceUuid);

	}
	
	@Test
	public void testGetSourceUuid_1() throws Exception {
		StoreItemRegister fixture = new StoreItemRegister("", "", "", "", "", "",new Long(1L), new Long(1L), new Boolean(true), new Boolean(true), new Boolean(true), "", "", "", "", new Boolean(true), "", new Long(1L), "", "", "", new Long(1L), "", null,null, new Long(1L));

		String result = fixture.getSourceUuid();

		assertEquals("", result);
	}
	
	@Test
	public void testSetDocumnt_1() throws Exception {
		StoreItemRegister fixture = new StoreItemRegister("", "", "", "", "", "",new Long(1L), new Long(1L), new Boolean(true), new Boolean(true), new Boolean(true), "", "", "", "", new Boolean(true), "", new Long(1L), "", "", "", new Long(1L), "", null,null, new Long(1L));
		List<Document> document = null;
		fixture.setDocument(document);

	}
}