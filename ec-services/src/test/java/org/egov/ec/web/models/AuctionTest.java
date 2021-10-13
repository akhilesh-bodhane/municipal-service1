package org.egov.ec.web.models;

import org.egov.ec.web.models.Auction;
import org.junit.*;
import static org.junit.Assert.*;

import java.util.List;

public class AuctionTest {

	/**
	 * Run the Auction() constructor test.
	 *
	 * @throws Exception
	 *
	 *                   at 30/4/20 5:39 AM
	 */
	@Test
	public void testAuction_1() throws Exception {

		Auction result = new Auction();

		assertNotNull(result);
		assertEquals(null, result.getAuctionUuid());
		assertEquals(null, result.getStoreItemUuid());
		assertEquals(null, result.getPurchaserName());
		assertEquals(null, result.getChallanId());
		assertEquals(null, result.getAuctionAmount());
		assertEquals(null, result.getAuctionQuantity());
		assertEquals(null, result.getChallanUuid());
		assertEquals(null, result.getViolationItemUuid());
		assertEquals(null, result.getViolationUuid());
		assertEquals(null, result.getIsAuctioned());
		assertEquals(null, result.getStatus());
		assertEquals(null, result.getLastModifiedTime());
		assertEquals(null, result.getCreatedBy());
		assertEquals(null, result.getCreatedTime());
		assertEquals(null, result.getTenantId());
		assertEquals(null, result.getLastModifiedBy());
		assertEquals(null, result.getIsActive());
		assertEquals(null, result.getAuctionList());
		assertEquals(null, result.getSourceUuid());
		assertEquals(null, result.getPurchaserContactNo());
		assertEquals(null, result.getAuctionDate());
		assertEquals(null, result.getEncroachmentType());
		assertEquals(null, result.getViolationDate());
		assertEquals(null, result.getViolatorName());
		assertEquals(null, result.getContactNumber());
		assertEquals(null, result.getSiName());
		assertEquals(null, result.getSector());
		assertEquals(null, result.getItemName());
	}

	/**
	 * Run the Auction(String,String,String,String,Long,String,Long,Boolean,String)
	 * constructor test.
	 *
	 * @throws Exception
	 *
	 *                   at 30/04/20 1:32 PM
	 */
	@Test
	public void testAuction_2() throws Exception {
		String auctionUuid = "";
		String auctionDetailUuid="";
		String storeItemUuid = "";
		String purchaserName = "";
		String challanId = "";
		String auctionAmount = null;
		Integer auctionQuantity = null;
		String challanUuid = "";
		String tenantId = "";
		String violationItemUuid = "";
		String violationUuid = "";
		Boolean isActive = new Boolean(true);
		Boolean isAuctioned = new Boolean(true);
		String createdBy = "";
		Long createdTime = new Long(1L);
		String lastModifiedBy = "";
		String status = "";
		Long lastModifiedTime = new Long(1L);
		String sourceUuid="";
		List<Auction> auctionList = null;
		String purchaseContactNo="";
		String auctionDate="";
		String encroachmentType="";
		String violationDate="";
		String violatorName="";
		String contactNumber="";
		String siName="";
		String sector="";
		String itemName="";

		Auction result = new Auction(auctionUuid, auctionDetailUuid, storeItemUuid, purchaserName, challanId, auctionAmount,
				auctionQuantity, challanUuid, tenantId, violationItemUuid, violationUuid, isActive, isAuctioned,
				createdBy, createdTime, lastModifiedBy, status, lastModifiedTime, sourceUuid, auctionList, purchaseContactNo, auctionDate,
				encroachmentType, violationDate, violatorName, contactNumber, siName, sector, itemName);

		assertNotNull(result);
		assertEquals(new Long(1L), (result.getLastModifiedTime()));
		assertEquals(Boolean.TRUE, result.getIsActive());
		assertEquals(Boolean.TRUE, result.getIsAuctioned());
		assertEquals("", result.getCreatedBy());
		assertEquals(new Long(1L), result.getCreatedTime());
		assertEquals("", result.getTenantId());
		assertEquals("", result.getLastModifiedBy());
		assertEquals("", result.getAuctionUuid());
		assertEquals("", result.getStoreItemUuid());
		assertEquals("", result.getPurchaserName());
		assertEquals("", result.getChallanId());
		assertEquals(null, result.getAuctionAmount());
		assertEquals(null, result.getAuctionQuantity());
		assertEquals("", result.getChallanUuid());
		assertEquals("", result.getViolationItemUuid());
		assertEquals("", result.getViolationUuid());
		assertEquals("", result.getStatus());
		assertEquals(null, result.getAuctionList());
		assertEquals("", result.getSourceUuid());
		assertEquals("", result.getAuctionDetailUuid());
		assertEquals("", result.getAuctionDate());
		assertEquals("", result.getPurchaserContactNo());
		assertEquals("", result.getEncroachmentType());
		assertEquals("", result.getViolationDate());
		assertEquals("", result.getViolatorName());
		assertEquals("", result.getContactNumber());
		assertEquals("", result.getSiName());
		assertEquals("", result.getSector());
		assertEquals("", result.getItemName());
	}

	/**
	 * Run the Auction.AuctionBuilder builder() method test.
	 *
	 * @throws Exception
	 *
	 *                   at 30/04/20 1:32 PM
	 */
	@Test
	public void testBuilder_1() throws Exception {

		Auction.AuctionBuilder result = Auction.builder();

		assertNotNull(result);
		assertEquals(
				"Auction.AuctionBuilder(auctionUuid=null, auctionDetailUuid=null, storeItemUuid=null, purchaserName=null, challanId=null, auctionAmount=null, auctionQuantity=null, challanUuid=null, tenantId=null, violationItemUuid=null, violationUuid=null, isActive=null, isAuctioned=null, createdBy=null, createdTime=null, lastModifiedBy=null, status=null, lastModifiedTime=null, sourceUuid=null, auctionList=null, auctionDate=null, purchaserContactNo=null, encroachmentType=null, violationDate=null, violatorName=null, contactNumber=null, siName=null, sector=null, itemName=null)",
				result.toString());
	}

	/**
	 * Run the Auction.AuctionBuilder builder() method test.
	 *
	 * @throws Exception
	 *
	 *                   at 30/04/20 1:32 PM
	 */
	@Test
	public void testBuilder_2() throws Exception {

		Auction.AuctionBuilder builder = new Auction.AuctionBuilder();
		builder.auctionUuid(null);
		builder.auctionDetailUuid(null);
		builder.storeItemUuid(null);
		builder.purchaserName(null);
		builder.challanId(null);
		builder.auctionAmount(null);
		builder.auctionQuantity(null);
		builder.challanUuid(null);
		builder.tenantId(null);
		builder.violationItemUuid(null);
		builder.violationUuid(null);
		builder.isActive(null);
		builder.isAuctioned(null);
		builder.createdBy(null);
		builder.createdTime(null);
		builder.status(null);
		builder.lastModifiedBy(null);
		builder.lastModifiedTime(null);
		builder.sourceUuid(null);
		builder.auctionList(null);
		builder.purchaserContactNo(null);
		builder.auctionDate(null);
		builder.encroachmentType(null);
		builder.violationDate(null);
		builder.violatorName(null);
		builder.siName(null);
		builder.sector(null);
		builder.contactNumber(null);
		builder.itemName(null);
		builder.build();

		Auction.AuctionBuilder builder2 = new Auction.AuctionBuilder();
		builder2.auctionUuid(null);
		builder2.auctionDetailUuid(null);
		builder2.storeItemUuid(null);
		builder2.purchaserName(null);
		builder2.challanId(null);
		builder2.auctionAmount(null);
		builder2.auctionQuantity(null);
		builder2.challanUuid(null);
		builder2.tenantId(null);
		builder2.violationItemUuid(null);
		builder2.violationUuid(null);
		builder2.isActive(null);
		builder2.isAuctioned(null);
		builder2.createdBy(null);
		builder2.createdTime(null);
		builder2.status(null);
		builder2.lastModifiedBy(null);
		builder2.lastModifiedTime(null);
		builder2.sourceUuid(null);
		builder2.auctionList(null);
		builder2.purchaserContactNo(null);
		builder2.auctionDate(null);
		builder2.encroachmentType(null);
		builder2.violationDate(null);
		builder2.violatorName(null);
		builder2.siName(null);
		builder2.sector(null);
		builder2.contactNumber(null);
		builder2.itemName(null);
		builder2.build();

		Assert.assertEquals(builder2.toString(), builder.toString());
	}


	/**
	 * Run the String getAuctionUuid() method test.
	 *
	 * @throws Exception
	 *
	 *                   at 30/04/20 1:32 PM
	 */
	@Test
	public void testGetAuctionUuid_1() throws Exception {
		Auction fixture = new Auction("", "", "", "", "", null, null, "", "", "", "", new Boolean(true), new Boolean(true),
				"", new Long(1L), "", "", new Long(1L), "", null,"","","","","","","","","");

		String result = fixture.getAuctionUuid();
		assertEquals("", result);
	}
	
	@Test
	public void testGetItemName_1() throws Exception {
		Auction fixture = new Auction("", "", "", "", "", null, null, "", "", "", "", new Boolean(true), new Boolean(true),
				"", new Long(1L), "", "", new Long(1L), "", null,"","","","","","","","","");

		String result = fixture.getItemName();
		assertEquals("", result);
	}

	/**
	 * Run the String getStoreItemUuid() method test.
	 *
	 * @throws Exception
	 *
	 *                   at 30/04/20 1:32 PM
	 */
	@Test
	public void testGetStoreItemUuid_1() throws Exception {
		Auction fixture = new Auction("", "", "", "", "", null, null, "", "", "", "", new Boolean(true), new Boolean(true),
				"", new Long(1L), "", "", new Long(1L), "", null,"","","","","","","","","");

		String result = fixture.getStoreItemUuid();
		assertEquals("", result);
	}

	/**
	 * Run the String getPurchaserName() method test.
	 *
	 * @throws Exception
	 *
	 *                   at 30/04/20 1:32 PM
	 */
	@Test
	public void testGetPurchaserName_1() throws Exception {
		Auction fixture = new Auction("", "", "", "", "", null, null, "", "", "", "", new Boolean(true), new Boolean(true),
				"", new Long(1L), "", "", new Long(1L), "", null,"","","","","","","","","");

		String result = fixture.getPurchaserName();
		assertEquals("", result);
	}
	
	/**
	 * Run the String getChallanId() method test.
	 *
	 * @throws Exception
	 *
	 *                   at 30/04/20 1:32 PM
	 */
	@Test
	public void testGetChallanId_1() throws Exception {
		Auction fixture = new Auction("", "", "", "", "", null, null, "", "", "", "", new Boolean(true), new Boolean(true),
				"", new Long(1L), "", "", new Long(1L), "", null,"","","","","","","","","");

		String result = fixture.getChallanId();
		assertEquals("", result);
	}
	
	/**
	 * Run the String getAuctionAmount() method test.
	 *
	 * @throws Exception
	 *
	 *                   at 30/04/20 1:32 PM
	 */
	@Test
	public void testGetAuctionAmount_1() throws Exception {
		Auction fixture = new Auction("", "", "", "", "", null, null, "", "", "", "", new Boolean(true), new Boolean(true),
				"", new Long(1L), "", "", new Long(1L), "", null,"","","","","","","","","");
		String result = fixture.getAuctionAmount();
		assertEquals(null, result);
	}
	
	/**
	 * Run the String getAuctionQuantity() method test.
	 *
	 * @throws Exception
	 *
	 *                   at 30/04/20 1:32 PM
	 */
	@Test
	public void testGetAuctionQuantity_1() throws Exception {
		Auction fixture = new Auction("", "", "", "", "", null, null, "", "", "", "", new Boolean(true), new Boolean(true),
				"", new Long(1L), "", "", new Long(1L), "", null,"","","","","","","","","");

		Integer result = fixture.getAuctionQuantity();
		assertEquals(null, result);
	}
	
	/**
	 * Run the String getChallanUuid() method test.
	 *
	 * @throws Exception
	 *
	 *                   at 30/04/20 1:32 PM
	 */
	@Test
	public void testGetChallanUuid_1() throws Exception {
		Auction fixture = new Auction("", "", "", "", "", null, null, "", "", "", "", new Boolean(true), new Boolean(true),
				"", new Long(1L), "", "", new Long(1L), "", null,"","","","","","","","","");

		String result = fixture.getChallanUuid();
		assertEquals("", result);
	}
	
	/**
	 * Run the String getTenantId() method test.
	 *
	 * @throws Exception
	 *
	 *                   at 30/04/20 1:32 PM
	 */
	@Test
	public void testGetTenantId_1() throws Exception {
		Auction fixture = new Auction("", "", "", "", "", null, null, "", "", "", "", new Boolean(true), new Boolean(true),
				"", new Long(1L), "", "", new Long(1L), "", null,"","","","","","","","","");

		String result = fixture.getTenantId();
		assertEquals("", result);
	}
	
	/**
	 * Run the String getViolationItemUuid() method test.
	 *
	 * @throws Exception
	 *
	 *                   at 30/04/20 1:32 PM
	 */
	@Test
	public void testGetViolationItemUuid_1() throws Exception {
		Auction fixture = new Auction("", "", "", "", "", null, null, "", "", "", "", new Boolean(true), new Boolean(true),
				"", new Long(1L), "", "", new Long(1L), "", null,"","","","","","","","","");

		String result = fixture.getViolationItemUuid();
		assertEquals("", result);
	}
	
	/**
	 * Run the String getViolationUuid() method test.
	 *
	 * @throws Exception
	 *
	 *                   at 30/04/20 1:32 PM
	 */
	@Test
	public void testGetViolationUuid_1() throws Exception {
		Auction fixture = new Auction("", "", "", "", "", null, null, "", "", "", "", new Boolean(true), new Boolean(true),
				"", new Long(1L), "", "", new Long(1L), "", null,"","","","","","","","","");

		String result = fixture.getViolationUuid();
		assertEquals("", result);
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
		Auction fixture = new Auction("", "", "", "", "", null, null, "", "", "", "", new Boolean(true), new Boolean(true),
				"", new Long(1L), "", "", new Long(1L), "", null,"","","","","","","","","");

		String result = fixture.getCreatedBy();

		assertEquals("", result);
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
		Auction fixture = new Auction("", "", "", "", "", null, null, "", "", "", "", new Boolean(true), new Boolean(true),
				"", new Long(1L), "", "", new Long(1L), "", null,"","","","","","","","","");

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
	 *                   at 30/04/20 1:32 PM
	 */
	@Test
	public void testGetIsActive_1() throws Exception {
		Auction fixture = new Auction("", "", "", "", "", null, null, "", "", "", "", new Boolean(true), new Boolean(true),
				"", new Long(1L), "", "", new Long(1L), "", null,"","","","","","","","","");

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
	 *                   at 30/04/20 1:32 PM
	 */
	@Test
	public void testGetIsAuctioned_1() throws Exception {
		Auction fixture= new Auction("", "", "", "", "", null, null, "", "", "", "", new Boolean(true), new Boolean(true),
				"", new Long(1L), "", "", new Long(1L), "", null,"","","","","","","","","");

		Boolean result = fixture.getIsAuctioned();

		assertNotNull(result);
		assertEquals("true", result.toString());
		assertEquals(true, result.booleanValue());
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
		Auction fixture = new Auction("", "", "", "", "", null, null, "", "", "", "", new Boolean(true), new Boolean(true),
				"", new Long(1L), "", "", new Long(1L), "", null,"","","","","","","","","");

		String result = fixture.getLastModifiedBy();

		assertEquals("", result);
	}

	/**
	 * Run the String getStatus() method test.
	 *
	 * @throws Exception
	 *
	 *                   at 30/04/20 1:32 PM
	 */
	@Test
	public void testGetStatus_1() throws Exception {
		Auction fixture = new Auction("", "", "", "", "", null, null, "", "", "", "", new Boolean(true), new Boolean(true),
				"", new Long(1L), "", "", new Long(1L), "", null,"","","","","","","","","");

		String result = fixture.getStatus();

		assertEquals("", result);
	}
	
	@Test
	public void testGetAuctionDetailUuid_1() throws Exception {
		Auction fixture =new Auction("", "", "", "", "", null, null, "", "", "", "", new Boolean(true), new Boolean(true),
				"", new Long(1L), "", "", new Long(1L), "", null,"","","","","","","","","");

		String result = fixture.getAuctionDetailUuid();

		assertEquals("", result);
	}
	
	
	@Test
	public void testGetSourceUuid_1() throws Exception {
		Auction fixture =new Auction("", "", "", "", "", null, null, "", "", "", "", new Boolean(true), new Boolean(true),
				"", new Long(1L), "", "", new Long(1L), "", null,"","","","","","","","","");

		String result = fixture.getSourceUuid();

		assertEquals("", result);
	}
	
	@Test
	public void testGetPurchaserContactNo_1() throws Exception {
		Auction fixture =new Auction("", "", "", "", "", null, null, "", "", "", "", new Boolean(true), new Boolean(true),
				"", new Long(1L), "", "", new Long(1L), "", null,"","","","","","","","","");

		String result = fixture.getPurchaserContactNo();

		assertEquals("", result);
	}
	
	@Test
	public void testGetEncroachmentType_1() throws Exception {
		Auction fixture =new Auction("", "", "", "", "", null, null, "", "", "", "", new Boolean(true), new Boolean(true),
				"", new Long(1L), "", "", new Long(1L), "", null,"","","","","","","","","");

		String result = fixture.getEncroachmentType();

		assertEquals("", result);
	}
	
	@Test
	public void testGetViolationDate_1() throws Exception {
		Auction fixture =new Auction("", "", "", "", "", null, null, "", "", "", "", new Boolean(true), new Boolean(true),
				"", new Long(1L), "", "", new Long(1L), "", null,"","","","","","","","","");

		String result = fixture.getViolationDate();

		assertEquals("", result);
	}
	
	@Test
	public void testGetViolatorName_1() throws Exception {
		Auction fixture =new Auction("", "", "", "", "", null, null, "", "", "", "", new Boolean(true), new Boolean(true),
				"", new Long(1L), "", "", new Long(1L), "", null,"","","","","","","","","");

		String result = fixture.getViolatorName();

		assertEquals("", result);
	}
	
	@Test
	public void testGetContactNumber_1() throws Exception {
		Auction fixture =new Auction("", "", "", "", "", null, null, "", "", "", "", new Boolean(true), new Boolean(true),
				"", new Long(1L), "", "", new Long(1L), "", null,"","","","","","","","","");

		String result = fixture.getContactNumber();

		assertEquals("", result);
	}
	
	@Test
	public void testGetSector_1() throws Exception {
		Auction fixture =new Auction("", "", "", "", "", null, null, "", "", "", "", new Boolean(true), new Boolean(true),
				"", new Long(1L), "", "", new Long(1L), "", null,"","","","","","","","","");

		String result = fixture.getSector();

		assertEquals("", result);
	}
	
	@Test
	public void testGetSiName_1() throws Exception {
		Auction fixture =new Auction("", "", "", "", "", null, null, "", "", "", "", new Boolean(true), new Boolean(true),
				"", new Long(1L), "", "", new Long(1L), "", null,"","","","","","","","","");

		String result = fixture.getSiName();

		assertEquals("", result);
	}
	
	@Test
	public void testGetAuctionDate_1() throws Exception {
		Auction fixture =new Auction("", "", "", "", "", null, null, "", "", "", "", new Boolean(true), new Boolean(true),
				"", new Long(1L), "", "", new Long(1L), "", null,"","","","","","","","","");

		String result = fixture.getAuctionDate();

		assertEquals("", result);
	}
	
	/**
	 * Run the String getAuctionList() method test.
	 *
	 * @throws Exception
	 *
	 *                   at 30/04/20 1:32 PM
	 */
	@Test
	public void testGetAuctionList_1() throws Exception {
		Auction fixture = new Auction("", "", "", "", "", null, null, "", "", "", "", new Boolean(true), new Boolean(true),
				"", new Long(1L), "", "", new Long(1L), "", null,"","","","","","","","","");

		List<Auction> result = fixture.getAuctionList();

		assertEquals(null, result);
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
		Auction fixture = new Auction("", "", "", "", "", null, null, "", "", "", "", new Boolean(true), new Boolean(true),
				"", new Long(1L), "", "", new Long(1L), "", null,"","","","","","","","","");

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
	 * Run the String setAuctionUuid() method test.
	 *
	 * @throws Exception
	 *
	 *                   at 30/04/20 1:32 PM
	 */
	@Test
	public void testSetAuctionUuid_1() throws Exception {
		Auction fixture = new Auction("", "", "", "", "", null, null, "", "", "", "", new Boolean(true), new Boolean(true),
				"", new Long(1L), "", "", new Long(1L), "", null,"","","","","","","","","");
		String auctionUuid = "";
		fixture.setAuctionUuid(auctionUuid);
	}

	/**
	 * Run the String getItemUuid() method test.
	 *
	 * @throws Exception
	 *
	 *                   at 30/04/20 1:32 PM
	 */
	@Test
	public void testSetStoreItemUuid_1() throws Exception {
		Auction fixture = new Auction("", "", "", "", "", null, null, "", "", "", "", new Boolean(true), new Boolean(true),
				"", new Long(1L), "", "", new Long(1L), "", null,"","","","","","","","","");
		String storeItemUuid = "";
		fixture.setStoreItemUuid(storeItemUuid);;
	}

	/**
	 * Run the String setItemName() method test.
	 *
	 * @throws Exception
	 *
	 *                   at 30/04/20 1:32 PM
	 */
	@Test
	public void testSetPurchaserName_1() throws Exception {
		Auction fixture = new Auction("", "", "", "", "", null, null, "", "", "", "", new Boolean(true), new Boolean(true),
				"", new Long(1L), "", "", new Long(1L), "", null,"","","","","","","","","");
		String purchaserName = "";
		fixture.setPurchaserName(purchaserName);
	}

	/**
	 * Run the String setChallanId() method test.
	 *
	 * @throws Exception
	 *
	 *                   at 30/04/20 1:32 PM
	 */
	@Test
	public void testSetChallanId_1() throws Exception {
		Auction fixture =new Auction("", "", "", "", "", null, null, "", "", "", "", new Boolean(true), new Boolean(true),
				"", new Long(1L), "", "", new Long(1L), "", null,"","","","","","","","","");
		String challanId = "";
		fixture.setChallanId(challanId);
	}
	
	@Test
	public void testSetAuctionAmount_1() throws Exception {
		Auction fixture = new Auction("", "", "", "", "", null, null, "", "", "", "", new Boolean(true), new Boolean(true),
				"", new Long(1L), "", "", new Long(1L), "", null,"","","","","","","","","");
		String auctionAmount = "";
		fixture.setAuctionAmount(auctionAmount);
	}

	
	@Test
	public void testSetAuctionQuantity_1() throws Exception {
		Auction fixture = new Auction("", "", "", "", "", null, null, "", "", "", "", new Boolean(true), new Boolean(true),
				"", new Long(1L), "", "", new Long(1L), "", null,"","","","","","","","","");
		Integer auctionQuantity = null;
		fixture.setAuctionQuantity(auctionQuantity);
		
	}
	
	@Test
	public void testSetChallanUuid_1() throws Exception {
		Auction fixture = new Auction("", "", "", "", "", null, null, "", "", "", "", new Boolean(true), new Boolean(true),
				"", new Long(1L), "", "", new Long(1L), "", null,"","","","","","","","","");
		String challanUuid = null;
		fixture.setChallanUuid(challanUuid);
		
	}
	
	@Test
	public void testSetViolationItemUuid_1() throws Exception {
		Auction fixture = new Auction("", "", "", "", "", null, null, "", "", "", "", new Boolean(true), new Boolean(true),
				"", new Long(1L), "", "", new Long(1L), "", null,"","","","","","","","","");
		String violationItemUuid = null;
		fixture.setViolationItemUuid(violationItemUuid);
		
	}
	
	@Test
	public void testSetViolationUuid_1() throws Exception {
		Auction fixture =new Auction("", "", "", "", "", null, null, "", "", "", "", new Boolean(true), new Boolean(true),
				"", new Long(1L), "", "", new Long(1L), "", null,"","","","","","","","","");
		String violationUuid = null;
		fixture.setViolationUuid(violationUuid);
		
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
		Auction fixture = new Auction("", "", "", "", "", null, null, "", "", "", "", new Boolean(true), new Boolean(true),
				"", new Long(1L), "", "", new Long(1L), "", null,"","","","","","","","","");
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
		Auction fixture = new Auction("", "", "", "", "", null, null, "", "", "", "", new Boolean(true), new Boolean(true),
				"", new Long(1L), "", "", new Long(1L), "", null,"","","","","","","","","");
		Long createdTime = new Long(1L);

		fixture.setCreatedTime(createdTime);

	}

	/**
	 * Run the void setIsActive(Boolean) method test.
	 *
	 * @throws Exception
	 *
	 *                   at 30/04/20 1:32 PM
	 */
	@Test
	public void testSetIsActive_1() throws Exception {
		Auction fixture =new Auction("", "", "", "", "", null, null, "", "", "", "", new Boolean(true), new Boolean(true),
				"", new Long(1L), "", "", new Long(1L), "", null,"","","","","","","","","");
		Boolean isActive = new Boolean(true);
		fixture.setIsActive(isActive);

	}
	
	@Test
	public void testSetIsAuctioned_1() throws Exception {
		Auction fixture =new Auction("", "", "", "", "", null, null, "", "", "", "", new Boolean(true), new Boolean(true),
				"", new Long(1L), "", "", new Long(1L), "", null,"","","","","","","","","");
		Boolean isAuctioned = new Boolean(true);
		fixture.setIsAuctioned(isAuctioned);

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
		Auction fixture = new Auction("", "", "", "", "", null, null, "", "", "", "", new Boolean(true), new Boolean(true),
				"", new Long(1L), "", "", new Long(1L), "", null,"","","","","","","","","");
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
		Auction fixture = new Auction("", "", "", "", "", null, null, "", "", "", "", new Boolean(true), new Boolean(true),
				"", new Long(1L), "", "", new Long(1L), "", null,"","","","","","","","","");
		Long lastModifiedTime = new Long(1L);
		fixture.setLastModifiedTime(lastModifiedTime);

	}

	/**
	 * Run the void setTenantId(String) method test.
	 *
	 * @throws Exception
	 *
	 *                   at 30/04/20 1:32 PM
	 */
	@Test
	public void testSetTenantId_1() throws Exception {
		Auction fixture = new Auction("", "", "", "", "", null, null, "", "", "", "", new Boolean(true), new Boolean(true),
				"", new Long(1L), "", "", new Long(1L), "", null,"","","","","","","","","");
		String tenantId = "";
		fixture.setTenantId(tenantId);

	}
	
	@Test
	public void testSetStatus_1() throws Exception {
		Auction fixture = new Auction("", "", "", "", "", null, null, "", "", "", "", new Boolean(true), new Boolean(true),
				"", new Long(1L), "", "", new Long(1L), "", null,"","","","","","","","","");
		String status = "";
		fixture.setStatus(status);

	}
	
	@Test
	public void testSetAuctionDetailUuid_1() throws Exception {
		Auction fixture = new Auction("", "", "", "", "", null, null, "", "", "", "", new Boolean(true), new Boolean(true),
				"", new Long(1L), "", "", new Long(1L), "", null,"","","","","","","","","");
		String auctionDetailUuid = "";
		fixture.setAuctionDetailUuid(auctionDetailUuid);

	}
	
	@Test
	public void testSetSourceUuid_1() throws Exception {
		Auction fixture = new Auction("", "", "", "", "", null, null, "", "", "", "", new Boolean(true), new Boolean(true),
				"", new Long(1L), "", "", new Long(1L), "", null,"","","","","","","","","");
		String sourceUuid = "";
		fixture.setSourceUuid(sourceUuid);

	}
	
	@Test
	public void testSetAuctionList_1() throws Exception {
		Auction fixture = new Auction("", "", "", "", "", null, null, "", "", "", "", new Boolean(true), new Boolean(true),
				"", new Long(1L), "", "", new Long(1L), "", null,"","","","","","","","","");
		List<Auction> auctionList = null;
		fixture.setAuctionList(auctionList);

	}
	
	@Test
	public void testSetPurchaserContactNo_1() throws Exception {
		Auction fixture = new Auction("", "", "", "", "", null, null, "", "", "", "", new Boolean(true), new Boolean(true),
				"", new Long(1L), "", "", new Long(1L), "", null,"","","","","","","","","");
		String purchaserContactNo = "";
		fixture.setPurchaserContactNo(purchaserContactNo);

	}
	
	@Test
	public void testSetAuctionDate_1() throws Exception {
		Auction fixture = new Auction("", "", "", "", "", null, null, "", "", "", "", new Boolean(true), new Boolean(true),
				"", new Long(1L), "", "", new Long(1L), "", null,"","","","","","","","","");
		String auctionDate = "";
		fixture.setAuctionDate(auctionDate);

	}
	
	@Test
	public void testSetEncroachmentType_1() throws Exception {
		Auction fixture = new Auction("", "", "", "", "", null, null, "", "", "", "", new Boolean(true), new Boolean(true),
				"", new Long(1L), "", "", new Long(1L), "", null,"","","","","","","","","");
		String encroachmentType = "";
		fixture.setEncroachmentType(encroachmentType);
	}
	
	@Test
	public void testSetViolationDate_1() throws Exception {
		Auction fixture = new Auction("", "", "", "", "", null, null, "", "", "", "", new Boolean(true), new Boolean(true),
				"", new Long(1L), "", "", new Long(1L), "", null,"","","","","","","","","");
		String violationDate = "";
		fixture.setViolationDate(violationDate);
	}
	
	@Test
	public void testSetViolatorName_1() throws Exception {
		Auction fixture = new Auction("", "", "", "", "", null, null, "", "", "", "", new Boolean(true), new Boolean(true),
				"", new Long(1L), "", "", new Long(1L), "", null,"","","","","","","","","");
		String violatorName = "";
		fixture.setViolatorName(violatorName);
	}
	
	@Test
	public void testSetContactNumber_1() throws Exception {
		Auction fixture = new Auction("", "", "", "", "", null, null, "", "", "", "", new Boolean(true), new Boolean(true),
				"", new Long(1L), "", "", new Long(1L), "", null,"","","","","","","","","");
		String contactNumber = "";
		fixture.setContactNumber(contactNumber);
	}
	
	@Test
	public void testSetSector_1() throws Exception {
		Auction fixture = new Auction("", "", "", "", "", null, null, "", "", "", "", new Boolean(true), new Boolean(true),
				"", new Long(1L), "", "", new Long(1L), "", null,"","","","","","","","","");
		String sector = "";
		fixture.setSector(sector);
	}
	
	@Test
	public void testSetSiName_1() throws Exception {
		Auction fixture = new Auction("", "", "", "", "", null, null, "", "", "", "", new Boolean(true), new Boolean(true),
				"", new Long(1L), "", "", new Long(1L), "", null,"","","","","","","","","");
		String siName = "";
		fixture.setSiName(siName);
	}
	
	@Test
	public void testSetItemName_1() throws Exception {
		Auction fixture = new Auction("", "", "", "", "", null, null, "", "", "", "", new Boolean(true), new Boolean(true),
				"", new Long(1L), "", "", new Long(1L), "", null,"","","","","","","","","");
		String itemName = "";
		fixture.setItemName(itemName);
	}

}
