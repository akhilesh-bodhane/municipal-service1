package org.egov.ec.web.models;

import org.junit.*;
import static org.junit.Assert.*;

import org.egov.ec.web.models.ChallanDetails;

public class ChallanDetailsTest {

	/**
	 * Run the ChallanDetails() constructor test.
	 *
	 * @throws Exception
	 *
	 *                   at 30/4/20 5:39 AM
	 */
	@Test
	public void testChallanDetails_1() throws Exception {

		ChallanDetails result = new ChallanDetails();

		assertNotNull(result);
		assertEquals(null, result.getChallanDetailUuid());
		assertEquals(null, result.getChallanUuid());
		assertEquals(null, result.getTenantId());
		assertEquals(null, result.getBudgetHead());
		assertEquals(null, result.getHeadAmount());
		assertEquals(null, result.getIsActive());
		assertEquals(null, result.getLastModifiedTime());
		assertEquals(null, result.getCreatedBy());
		assertEquals(null, result.getCreatedTime());
		assertEquals(null, result.getLastModifiedBy());
	}

	/**
	 * Run the
	 * ChallanDetails(String,String,String,String,Long,String,Long,Boolean,String)
	 * constructor test.
	 *
	 * @throws Exception
	 *
	 *                   at 30/04/20 1:32 PM
	 */
	@Test
	public void testChallanDetails_2() throws Exception {
		String challanDetailUuid = "";
		String challanUuid = "";
		String tenantId = "";
		String budgetHead = "";
		String headAmount = null;
		Boolean isActive = new Boolean(true);
		Long lastModifiedTime = new Long(1L);
		String createdBy = "";
		Long createdTime = new Long(1L);
		String lastModifiedBy = "";

		ChallanDetails result = new ChallanDetails(challanDetailUuid, challanUuid, tenantId, budgetHead, headAmount,
				isActive, createdBy, createdTime, lastModifiedBy, lastModifiedTime);

		assertNotNull(result);
		assertEquals("", result.getChallanDetailUuid());
		assertEquals("", result.getChallanUuid());
		assertEquals("", result.getTenantId());
		assertEquals("", result.getBudgetHead());
		assertEquals(null, result.getHeadAmount());
		assertEquals(Boolean.TRUE, result.getIsActive());
		assertEquals("", result.getLastModifiedBy());
		assertEquals(new Long(1L), (result.getLastModifiedTime()));
		assertEquals("", result.getCreatedBy());
		assertEquals(new Long(1L), result.getCreatedTime());
		assertEquals("", result.getLastModifiedBy());

	}

	/**
	 * Run the ChallanDetails.ChallanDetailsBuilder builder() method test.
	 *
	 * @throws Exception
	 *
	 *                   at 30/04/20 1:32 PM
	 */
	@Test
	public void testBuilder_1() throws Exception {

		ChallanDetails.ChallanDetailsBuilder result = ChallanDetails.builder();

		assertNotNull(result);
		assertEquals(
				"ChallanDetails.ChallanDetailsBuilder(challanDetailUuid=null, challanUuid=null, tenantId=null, budgetHead=null, headAmount=null, isActive=null, createdBy=null, createdTime=null, lastModifiedBy=null, lastModifiedTime=null)",
				result.toString());
	}

	/**
	 * Run the ChallanDetails.ChallanDetailsBuilder builder() method test.
	 *
	 * @throws Exception
	 *
	 *  at 30/04/20 1:32 PM
	 */
	@Test
	public void testBuilder_2()
		throws Exception {

		ChallanDetails.ChallanDetailsBuilder builder = new ChallanDetails.ChallanDetailsBuilder();
		builder.challanDetailUuid(null);
		builder.challanUuid(null);
		builder.tenantId(null);
		builder.budgetHead(null);
		builder.headAmount(null);
		builder.isActive(null);
		builder.createdBy(null);
		builder.createdTime(null);
		builder.lastModifiedBy(null);
		builder.lastModifiedTime(null);
		builder.build();

		ChallanDetails.ChallanDetailsBuilder builder2 = new ChallanDetails.ChallanDetailsBuilder();
		builder2.challanDetailUuid(null);
		builder2.challanUuid(null);
		builder2.tenantId(null);
		builder2.budgetHead(null);
		builder2.headAmount(null);
		builder2.isActive(null);
		builder2.createdBy(null);
		builder2.createdTime(null);
		builder2.lastModifiedBy(null);
		builder2.lastModifiedTime(null);
		builder2.build();

		Assert.assertEquals(builder2.toString(), builder.toString());
	}

	
	@Test
	public void testGetChallanDetailUuid_1() throws Exception {
		ChallanDetails fixture = new ChallanDetails("","","","",null, new Boolean(true),null, new Long(1L), "", new Long(1L));
		String result = fixture.getChallanDetailUuid();
		assertEquals("", result);
	}
	
	@Test
	public void testGetChallanUuid_1() throws Exception {
		ChallanDetails fixture = new ChallanDetails("","","","",null, new Boolean(true),null, new Long(1L), "", new Long(1L));
		String result = fixture.getChallanUuid();
		assertEquals("", result);
	}
	
	@Test
	public void testGetTenantId_1() throws Exception {
		ChallanDetails fixture = new ChallanDetails("","","","",null, new Boolean(true),null, new Long(1L), "", new Long(1L));
		String result = fixture.getTenantId();
		assertEquals("", result);
	}
	
	@Test
	public void testGetBudgetHead_1() throws Exception {
		ChallanDetails fixture = new ChallanDetails("","","","",null, new Boolean(true),null, new Long(1L), "", new Long(1L));
		String result = fixture.getBudgetHead();
		assertEquals("", result);
	}
	
	@Test
	public void testGetHeadAmount_1() throws Exception {
		ChallanDetails fixture = new ChallanDetails("","","","",null, new Boolean(true),null, new Long(1L), "", new Long(1L));
		String result = fixture.getHeadAmount();
		assertEquals(null, result);
	}
	
	@Test
	public void testGetIsActive_1() throws Exception {
		ChallanDetails fixture = new ChallanDetails("","","","",null, new Boolean(true),null, new Long(1L), "", new Long(1L));
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
		ChallanDetails fixture = new ChallanDetails("","","","",null, new Boolean(true),null, new Long(1L), "", new Long(1L));

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
		ChallanDetails fixture =  new ChallanDetails("","","","",null, new Boolean(true),null, new Long(1L), "", new Long(1L));

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
		ChallanDetails fixture =  new ChallanDetails("","","","",null, new Boolean(true),null, new Long(1L), "", new Long(1L));

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
		ChallanDetails fixture =  new ChallanDetails("","","","",null, new Boolean(true),null, new Long(1L), "", new Long(1L));

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
	public void testSetChallanDetailUuid_1() throws Exception {
		ChallanDetails fixture =  new ChallanDetails("","","","",null, new Boolean(true),null, new Long(1L), "", new Long(1L));
		String challanDetailUuid = "";
		fixture.setChallanDetailUuid(challanDetailUuid);

	}
	
	@Test
	public void testSetChallanUuid_1() throws Exception {
		ChallanDetails fixture =  new ChallanDetails("","","","",null, new Boolean(true),null, new Long(1L), "", new Long(1L));
		String challanUuid = "";
		fixture.setChallanUuid(challanUuid);

	}
	
	@Test
	public void testSetTenantId_1() throws Exception {
		ChallanDetails fixture =  new ChallanDetails("","","","",null, new Boolean(true),null, new Long(1L), "", new Long(1L));
		String tenantId = "";
		fixture.setTenantId(tenantId);

	}
	
	@Test
	public void testSetBudgetHead_1() throws Exception {
		ChallanDetails fixture =  new ChallanDetails("","","","",null, new Boolean(true),null, new Long(1L), "", new Long(1L));
		String budgetHead = "";
		fixture.setBudgetHead(budgetHead);

	}
	
	@Test
	public void testSetHeadAmount_1() throws Exception {
		ChallanDetails fixture =  new ChallanDetails("","","","",null, new Boolean(true),null, new Long(1L), "", new Long(1L));
		String headAmount = null;
		fixture.setHeadAmount(headAmount);

	}
	
	@Test
	public void testSetIsActive_1() throws Exception {
		ChallanDetails fixture =  new ChallanDetails("","","","",null, new Boolean(true),null, new Long(1L), "", new Long(1L));
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
		ChallanDetails fixture =  new ChallanDetails("","","","",null, new Boolean(true),null, new Long(1L), "", new Long(1L));
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
		ChallanDetails fixture =  new ChallanDetails("","","","",null, new Boolean(true),null, new Long(1L), "", new Long(1L));
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
		ChallanDetails fixture =  new ChallanDetails("","","","",null, new Boolean(true),null, new Long(1L), "", new Long(1L));
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
		ChallanDetails fixture =  new ChallanDetails("","","","",null, new Boolean(true),null, new Long(1L), "", new Long(1L));
		Long lastModifiedTime = new Long(1L);
		fixture.setLastModifiedTime(lastModifiedTime);

	}

}
