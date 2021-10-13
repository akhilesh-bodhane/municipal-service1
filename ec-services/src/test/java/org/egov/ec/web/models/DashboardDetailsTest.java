package org.egov.ec.web.models;

import org.junit.*;
import static org.junit.Assert.*;

import org.egov.ec.web.models.DashboardDetails;

public class DashboardDetailsTest {

	/**
	 * Run the DashboardDetails() constructor test.
	 *
	 * @throws Exception
	 *
	 *                   at 30/4/20 5:39 AM
	 */
	@Test
	public void testDashboardDetails_1() throws Exception {

		DashboardDetails result = new DashboardDetails();

		assertNotNull(result);
		assertEquals(null, result.getFineCount());
		assertEquals(null, result.getChallanCount());
		assertEquals(null, result.getTenantId());
		assertEquals(null, result.getAuctionCount());
		assertEquals(null, result.getRoleCode());
	}

	/**
	 * Run the
	 * DashboardDetails(String,String,String,String,Long,String,Long,Boolean,String)
	 * constructor test.
	 *
	 * @throws Exception
	 *
	 *                   at 30/04/20 1:32 PM
	 */
	@Test
	public void testDashboardDetails_2() throws Exception {
		Integer fineCount = null;
		Integer challanCount = null;
		String tenantId = "";
		Integer auctionCount = null;
		String roleCode="";

		DashboardDetails result = new DashboardDetails(fineCount, challanCount, auctionCount, roleCode, tenantId);

		assertNotNull(result);
		assertEquals(null, result.getChallanCount());
		assertEquals(null, result.getFineCount());
		assertEquals("", result.getTenantId());
		assertEquals(null, result.getAuctionCount());
		assertEquals("", result.getRoleCode());

	}

	/**
	 * Run the DashboardDetails.DashboardDetailsBuilder builder() method test.
	 *
	 * @throws Exception
	 *
	 *                   at 30/04/20 1:32 PM
	 */
	@Test
	public void testBuilder_1() throws Exception {

		DashboardDetails.DashboardDetailsBuilder result = DashboardDetails.builder();

		assertNotNull(result);
		assertEquals(
				"DashboardDetails.DashboardDetailsBuilder(fineCount=null, challanCount=null, auctionCount=null, roleCode=null, tenantId=null)",
				result.toString());
	}

	/**
	 * Run the DashboardDetails.DashboardDetailsBuilder builder() method test.
	 *
	 * @throws Exception
	 *
	 *  at 30/04/20 1:32 PM
	 */
	@Test
	public void testBuilder_2()
		throws Exception {

		DashboardDetails.DashboardDetailsBuilder builder = new DashboardDetails.DashboardDetailsBuilder();
		builder.fineCount(null);
		builder.challanCount(null);
		builder.auctionCount(null);
		builder.roleCode(null);
		builder.tenantId(null);
		builder.build();

		DashboardDetails.DashboardDetailsBuilder builder2 = new DashboardDetails.DashboardDetailsBuilder();
		builder2.fineCount(null);
		builder2.challanCount(null);
		builder2.auctionCount(null);
		builder2.roleCode(null);
		builder2.tenantId(null);		
		builder2.build();

		Assert.assertEquals(builder2.toString(), builder.toString());
	}

	
	@Test
	public void testGetFineCount_1() throws Exception {
		DashboardDetails fixture = new DashboardDetails(null, null, null,"","");
		Integer result = fixture.getFineCount();
		assertEquals(null, result);
	}
	
	@Test
	public void testGetChallanCount_1() throws Exception {
		DashboardDetails fixture = new DashboardDetails(null, null, null,"","");
		Integer result = fixture.getChallanCount();
		assertEquals(null, result);
	}
	
	@Test
	public void testGetAuctionCount_1() throws Exception {
		DashboardDetails fixture = new DashboardDetails(null, null, null,"","");
		Integer result = fixture.getAuctionCount();
		assertEquals(null, result);
	}
	
	@Test
	public void testGetRoleCode_1() throws Exception {
		DashboardDetails fixture = new DashboardDetails(null, null, null,"","");
		String result = fixture.getRoleCode();
		assertEquals("", result);
	}
	
	@Test
	public void testGetTenantId_1() throws Exception {
		DashboardDetails fixture = new DashboardDetails(null, null, null,"","");
		String result = fixture.getTenantId();
		assertEquals("", result);
	}
	
		
	@Test
	public void testSetRoleCode_1() throws Exception {
		DashboardDetails fixture =  new DashboardDetails(null, null, null,"","");
		String roleCode = "";
		fixture.setRoleCode(roleCode);

	}
	
	@Test
	public void testSetFineCount_1() throws Exception {
		DashboardDetails fixture =  new DashboardDetails(null, null, null,"","");
		Integer fineCount = null;
		fixture.setFineCount(fineCount);

	}
	
	@Test
	public void testSetChallanCount_1() throws Exception {
		DashboardDetails fixture =  new DashboardDetails(null, null, null,"","");
		Integer challanCount = null;
		fixture.setChallanCount(challanCount);

	}
	
	@Test
	public void testSetAuctionCount_1() throws Exception {
		DashboardDetails fixture =  new DashboardDetails(null, null, null,"","");
		Integer auctionCount = null;
		fixture.setAuctionCount(auctionCount);

	}
	
	@Test
	public void testSetTenantId_1() throws Exception {
		DashboardDetails fixture =  new DashboardDetails(null, null, null,"","");
		String tenantId = "";
		fixture.setTenantId(tenantId);

	}
}
