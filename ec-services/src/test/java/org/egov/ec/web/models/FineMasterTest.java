
package org.egov.ec.web.models;

import org.junit.*;
import static org.junit.Assert.*;

import org.egov.ec.web.models.FineMaster;

public class FineMasterTest {

	/**
	 * Run the FineMaster() constructor test.
	 *
	 * @throws Exception
	 *
	 *                   at 30/4/20 5:39 AM
	 */

	@Test
	public void testFineMaster_1() throws Exception {

		FineMaster result = new FineMaster();

		assertNotNull(result);
		assertEquals(null, result.getEncroachmentType());
		assertEquals(null, result.getLastModifiedTime());
		assertEquals(null, result.getCreatedBy());
		assertEquals(null, result.getCreatedTime());
		assertEquals(null, result.getTenantId());
		assertEquals(null, result.getLastModifiedBy());
		assertEquals(null, result.getApprovalStatus());
		assertEquals(null, result.getFineUuid());
		assertEquals(null, result.getNumberOfViolation());
		assertEquals(null, result.getPenaltyAmount());
		assertEquals(null, result.getIsActive());
		assertEquals(null, result.getStorageCharges());
		assertEquals(null, result.getViolationUuid());
		assertEquals(null, result.getSourceUuid());
		assertEquals(null, result.getEffectiveStartDate());
		assertEquals(null, result.getEffectiveEndDate());
		assertEquals(null, result.getChallanUuid());
	}

	/**
	 * Run the
	 * FineMaster(String,String,String,String,Long,String,Long,Boolean,String)
	 * constructor test.
	 *
	 * @throws Exception
	 *
	 *                   at 30/04/20 1:32 PM
	 */

	@Test
	public void testFineMaster_2() throws Exception {
		String tenantId = "";
		String encroachmentType = "";
		String violationUuid="";
		String numberOfViolation = "";
		String approvalStatus = "";
		Boolean isActive = new Boolean(true);
		String fineUuid = "";
		String penaltyAmount = "";
		String createdBy = "";
		Long createdTime = new Long(1L);
		String lastModifiedBy = "";
		Long lastModifiedTime = new Long(1L);
		String sourceUuid="";
		String storageCharges = "";
		String effectiveStartDate="";
		String effectiveEndate="";
		String challanUuid="";

		FineMaster result = new FineMaster(fineUuid, encroachmentType, numberOfViolation, violationUuid, penaltyAmount, approvalStatus,
				tenantId, isActive, effectiveEndate, effectiveStartDate, createdBy, createdTime, lastModifiedBy, lastModifiedTime, storageCharges, sourceUuid,challanUuid);

		assertNotNull(result);
		assertEquals(new Long(1L), (result.getLastModifiedTime()));
		assertEquals(Boolean.TRUE, result.getIsActive());
		assertEquals("", result.getCreatedBy());
		assertEquals(new Long(1L), result.getCreatedTime());
		assertEquals("", result.getTenantId());
		assertEquals("", result.getLastModifiedBy());
		assertEquals("", result.getEncroachmentType());
		assertEquals("", result.getApprovalStatus());
		assertEquals("", result.getFineUuid());
		assertEquals("", result.getPenaltyAmount());
		assertEquals("", result.getStorageCharges());
		assertEquals("", result.getNumberOfViolation());
		assertEquals("", result.getSourceUuid());
		assertEquals("", result.getEffectiveStartDate());
		assertEquals("", result.getChallanUuid());
	}

	/**
	 * Run the ItemMaster.FineMasterBuilder builder() method test.
	 *
	 * @throws Exception
	 *
	 *                   at 30/04/20 1:32 PM
	 */

	@Test
	public void testBuilder_1() throws Exception {

		FineMaster.FineMasterBuilder result = FineMaster.builder();

		assertNotNull(result);
		assertEquals(
				"FineMaster.FineMasterBuilder(fineUuid=null, encroachmentType=null, numberOfViolation=null, violationUuid=null, penaltyAmount=null, approvalStatus=null, tenantId=null, isActive=null, effectiveStartDate=null, effectiveEndDate=null, createdBy=null, createdTime=null, lastModifiedBy=null, lastModifiedTime=null, storageCharges=null, sourceUuid=null, challanUuid=null)",
				result.toString());
	}

	/**
	 * Run the ItemMaster.ItemMasterBuilder builder() method test.
	 *
	 * @throws Exception
	 *
	 *                   at 30/04/20 1:32 PM
	 */

	@Test
	public void testBuilder_2() throws Exception {

		FineMaster.FineMasterBuilder builder = new FineMaster.FineMasterBuilder();
		builder.approvalStatus(null);
		builder.encroachmentType(null);
		builder.createdBy(null);
		builder.createdTime(null);
		builder.numberOfViolation(null);
		builder.isActive(null);
		builder.lastModifiedBy(null);
		builder.lastModifiedTime(null);
		builder.storageCharges(null);
		builder.fineUuid(null);
		builder.tenantId(null);
		builder.penaltyAmount(null);
		builder.violationUuid(null);
		builder.sourceUuid(null);
		builder.effectiveStartDate(null);
		builder.effectiveEndDate(null);
		builder.challanUuid(null);
		builder.build();

		FineMaster.FineMasterBuilder builder2 = new FineMaster.FineMasterBuilder();
		builder2.approvalStatus(null);
		builder2.encroachmentType(null);
		builder2.createdBy(null);
		builder2.createdTime(null);
		builder2.numberOfViolation(null);
		builder2.isActive(null);
		builder2.lastModifiedBy(null);
		builder2.lastModifiedTime(null);
		builder2.storageCharges(null);
		builder2.fineUuid(null);
		builder2.tenantId(null);
		builder2.violationUuid(null);
		builder2.penaltyAmount(null);
		builder2.sourceUuid(null);
		builder.effectiveStartDate(null);
		builder.effectiveEndDate(null);
		builder2.challanUuid(null);
		Assert.assertEquals(builder2.toString(), builder.toString());
	}

	/**
	 * Run the String getApprovalStatus() method test.
	 *
	 * @throws Exception
	 *
	 *                   at 30/04/20 1:32 PM
	 */

	@Test
	public void testGetApprovalStatus_1() throws Exception {
		FineMaster fixture = new FineMaster("", "", "", null, null, "", "", new Boolean(true), "","",null, new Long(1L), "", new Long(1L), null, "","");

		String result = fixture.getApprovalStatus();
		assertEquals("", result);
	}
	
	@Test
	public void testGetViolationUuid_1() throws Exception {
		FineMaster fixture = new FineMaster("", "", "", null, null, "", "", new Boolean(true), "","",null, new Long(1L), "", new Long(1L), null, "","");

		String result = fixture.getViolationUuid();
		assertEquals(null, result);
	}

	/**
	 * Run the String getItemUuid() method test.
	 *
	 * @throws Exception
	 *
	 *                   at 30/04/20 1:32 PM
	 */

	@Test
	public void testGetFineUuid_1() throws Exception {
		FineMaster fixture = new FineMaster("", "", "", null, null, "", "", new Boolean(true), "","",null, new Long(1L), "", new Long(1L), null, "","");

		String result = fixture.getFineUuid();
		assertEquals("", result);
	}

	/**
	 * Run the String getItemName() method test.
	 *
	 * @throws Exception
	 *
	 *                   at 30/04/20 1:32 PM
	 */

	@Test
	public void testGetEncroachmentType_1() throws Exception {
		FineMaster fixture = new FineMaster("", "", "", null, null, "", "", new Boolean(true), "","",null, new Long(1L), "", new Long(1L), null, "","");

		String result = fixture.getEncroachmentType();
		assertEquals("", result);
	}

	/**
	 * Run the String getDescription() method test.
	 *
	 * @throws Exception
	 *
	 *                   at 30/04/20 1:32 PM
	 */

	@Test
	public void testgetNumberOfViolation_1() throws Exception {
		FineMaster fixture = new FineMaster("", "", "", null, null, "", "", new Boolean(true), "","",null, new Long(1L), "", new Long(1L), null, "","");

		String result = fixture.getNumberOfViolation();
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
		FineMaster fixture = new FineMaster("", "", "", null, null, "", "", new Boolean(true), "","",null, new Long(1L), "", new Long(1L), null, "","");

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
		FineMaster fixture = new FineMaster("", "", "", null, null, "", "", new Boolean(true), "","",null, new Long(1L), "", new Long(1L), null, "","");

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
		FineMaster fixture = new FineMaster("", "", "", null, null, "", "", new Boolean(true), "","",null, new Long(1L), "", new Long(1L), null, "","");

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
	 *                   at 30/04/20 1:32 PM
	 */

	@Test
	public void testGetLastModifiedBy_1() throws Exception {
		FineMaster fixture = new FineMaster("", "", "", null, null, "", "", new Boolean(true), "","",null, new Long(1L), "", new Long(1L), null, "","");

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
		FineMaster fixture = new FineMaster("", "", "", null, null, "", "", new Boolean(true), "","",null, new Long(1L), "", new Long(1L), null, "","");

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
	 *                   at 30/04/20 1:32 PM
	 */

	@Test
	public void testGetTenantId_1() throws Exception {
		FineMaster fixture = new FineMaster("", "", "", null, null, "", "", new Boolean(true), "","",null, new Long(1L), "", new Long(1L), null, "","");

		String result = fixture.getTenantId();

		assertEquals("", result);
	}

	/**
	 * Run the String getActionFlag() method test.
	 *
	 * @throws Exception
	 *
	 *                   at 30/04/20 1:32 PM
	 */

	@Test
	public void testGetPenaltyAmount_1() throws Exception {
		FineMaster fixture = new FineMaster("", "", "", null, null, "", "", new Boolean(true), "","",null, new Long(1L), "", new Long(1L), null, "","");

		String result = fixture.getPenaltyAmount();

		assertEquals(null, result);
	}

	/**
	 * Run the String getActionFlag() method test.
	 *
	 * @throws Exception
	 *
	 *                   at 30/04/20 1:32 PM
	 */

	@Test
	public void testGetStorageCharges_1() throws Exception {
		FineMaster fixture = new FineMaster("", "", "", null, null, "", "", new Boolean(true), "","",null, new Long(1L), "", new Long(1L), null, "","");
		String result = fixture.getStorageCharges();
		assertEquals(null, result);
	}
	
	@Test
	public void testGetChallanUuid_1() throws Exception {
		FineMaster fixture = new FineMaster("", "", "", null, null, "", "", new Boolean(true), "","",null, new Long(1L), "", new Long(1L), null, "","");
		String result = fixture.getChallanUuid();
		assertEquals("", result);
	}

	/**
	 * Run the String getApprovalStatus() method test.
	 *
	 * @throws Exception
	 *
	 *                   at 30/04/20 1:32 PM
	 */

	@Test
	public void testSetApprovalStatus_1() throws Exception {
		FineMaster fixture = new FineMaster("", "", "", null, null, "", "", new Boolean(true), "","",null, new Long(1L), "", new Long(1L), null, "","");
		String approvalStatus = "";
		fixture.setApprovalStatus(approvalStatus);
	}

	/**
	 * Run the String getItemUuid() method test.
	 *
	 * @throws Exception
	 *
	 *                   at 30/04/20 1:32 PM
	 */

	@Test
	public void testSetFineUuid_1() throws Exception {
		FineMaster fixture = new FineMaster("", "", "", null, null, "", "", new Boolean(true), "","",null, new Long(1L), "", new Long(1L), null, "","");
		String fineUuid = "";
		fixture.setFineUuid(fineUuid);
	}
	
	@Test
	public void testSetViolationUuid_1() throws Exception {
		FineMaster fixture = new FineMaster("", "", "", null, null, "", "", new Boolean(true), "","",null, new Long(1L), "", new Long(1L), null, "","");
		String violationUuid = "";
		fixture.setViolationUuid(violationUuid);
	}

	/**
	 * Run the String SetEncroachmentType() method test.
	 *
	 * @throws Exception
	 *
	 *                   at 30/04/20 1:32 PM
	 */

	@Test
	public void testSetEncroachmentType_1() throws Exception {
		FineMaster fixture = new FineMaster("", "", "", null, null, "", "", new Boolean(true), "","",null, new Long(1L), "", new Long(1L), null, "","");
		String encroachmentType = "";
		fixture.setEncroachmentType(encroachmentType);
	}

	/**
	 * Run the String SetNumberOfViolation() method test.
	 *
	 * @throws Exception
	 *
	 *                   at 30/04/20 1:32 PM
	 */

	@Test
	public void testSetNumberOfViolation_1() throws Exception {
		FineMaster fixture = new FineMaster("", "", "", null, null, "", "", new Boolean(true), "","",null, new Long(1L), "", new Long(1L), null, "","");
		String numberOfViolation = "";
		fixture.setNumberOfViolation(numberOfViolation);
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
		FineMaster fixture = new FineMaster("", "", "", null, null, "", "", new Boolean(true), "","",null, new Long(1L), "", new Long(1L), null, "","");
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
		FineMaster fixture = new FineMaster("", "", "", null, null, "", "", new Boolean(true), "","",null, new Long(1L), "", new Long(1L), null, "","");
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
		FineMaster fixture = new FineMaster("", "", "", null, null, "", "", new Boolean(true), "","",null, new Long(1L), "", new Long(1L), null, "","");
		Boolean isActive = new Boolean(true);
		fixture.setIsActive(isActive);

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
		FineMaster fixture = new FineMaster("", "", "", null, null, "", "", new Boolean(true), "","",null, new Long(1L), "", new Long(1L), null, "","");
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
		FineMaster fixture = new FineMaster("", "", "", null, null, "", "", new Boolean(true), "","",null, new Long(1L), "", new Long(1L), null, "","");
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
		FineMaster fixture = new FineMaster("", "", "", null, null, "", "", new Boolean(true), "","",null, new Long(1L), "", new Long(1L), null, "","");
		String tenantId = "";
		fixture.setTenantId(tenantId);

	}

	/**
	 * Run the String SetPenaltyAmount() method test.
	 *
	 * @throws Exception
	 *
	 *                   at 30/04/20 1:32 PM
	 */

	@Test
	public void testSetPenaltyAmount_1() throws Exception {
		FineMaster fixture = new FineMaster("", "", "", null, null, "", "", new Boolean(true), "","",null, new Long(1L), "", new Long(1L), null, "","");

		String penaltyAmount = null;
		fixture.setPenaltyAmount(penaltyAmount);
	}

	/**
	 * Run the String SetStorageCharges() method test.
	 *
	 * @throws Exception
	 *
	 *                   at 30/04/20 1:32 PM
	 */
	@Test
	public void testSetStorageCharges_1() throws Exception {
		FineMaster fixture = new FineMaster("", "", "", null, null, "", "", new Boolean(true), "","",null, new Long(1L), "", new Long(1L), null, "","");

		String storageCharges = null;
		fixture.setStorageCharges(storageCharges);
	}
	
	@Test
	public void testSetSourceUuid_1() throws Exception {
		FineMaster fixture = new FineMaster("", "", "", null, null, "", "", new Boolean(true), "","",null, new Long(1L), "", new Long(1L), null, "","");
		String sourceUuid = "";
		fixture.setSourceUuid(sourceUuid);

	}
	
	@Test
	public void testGetSourceUuid_1() throws Exception {
		FineMaster fixture = new FineMaster("", "", "", null, null, "", "", new Boolean(true), "","",null, new Long(1L), "", new Long(1L), null, "","");

		String result = fixture.getSourceUuid();

		assertEquals("", result);
	}
	
	@Test
	public void testGetEffectiveStartDate_1() throws Exception {
		FineMaster fixture = new FineMaster("", "", "", null, null, "", "", new Boolean(true), "","",null, new Long(1L), "", new Long(1L), null, "","");

		String result = fixture.getEffectiveStartDate();
		assertEquals("", result);
	}
	
	@Test
	public void testGetEffectiveEndDate_1() throws Exception {
		FineMaster fixture = new FineMaster("", "", "", null, null, "", "", new Boolean(true), "","",null, new Long(1L), "", new Long(1L), null, "","");

		String result = fixture.getEffectiveEndDate();
		assertEquals("", result);
	}
	
	@Test
	public void testSetEffectiveEndDate_1() throws Exception {
		FineMaster fixture = new FineMaster("", "", "", null, null, "", "", new Boolean(true), "","",null, new Long(1L), "", new Long(1L), null, "","");
		String effectiveEndDate = "";
		fixture.setEffectiveEndDate(effectiveEndDate);

	}
	
	@Test
	public void testSetEffectiveStartDate_1() throws Exception {
		FineMaster fixture = new FineMaster("", "", "", null, null, "", "", new Boolean(true), "","",null, new Long(1L), "", new Long(1L), null, "","");
		String effectiveStartDate = "";
		fixture.setEffectiveStartDate(effectiveStartDate);

	}
	
	@Test
	public void testSetChallanUuid_1() throws Exception {
		FineMaster fixture = new FineMaster("", "", "", null, null, "", "", new Boolean(true), "","",null, new Long(1L), "", new Long(1L), null, "","");
		String challanUuid = "";
		fixture.setChallanUuid(challanUuid);

	}

}
