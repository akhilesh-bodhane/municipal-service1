package org.egov.ec.web.models;

import org.junit.*;
import static org.junit.Assert.*;

import org.egov.ec.web.models.EcPayment;

/**
 * The class <code>EcPaymentTest</code> contains tests for the class <code>{@link EcPayment}</code>.
 *
 * @generated at 17/5/20 2:11 PM
 * @version $Revision: 1.0 $
 */
public class EcPaymentTest {
	/**
	 * Run the EcPayment() constructor test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:11 PM
	 */
	@Test
	public void testEcPayment_1()
		throws Exception {

		EcPayment result = new EcPayment();

		
		assertNotNull(result);
		assertEquals(null, result.getLastModifiedTime());
		assertEquals(null, result.getIsActive());
		assertEquals(null, result.getTenantId());
		assertEquals(null, result.getCreatedTime());
		assertEquals(null, result.getCreatedBy());
		assertEquals(null, result.getPaymentGateway());
		assertEquals(null, result.getPaymentReceiptUuid());
		assertEquals(null, result.getViolationUuid());
		assertEquals(null, result.getPaymentMode());
		assertEquals(null, result.getChallanId());
		assertEquals(null, result.getPaymentUuid());
		assertEquals(null, result.getPaymentStatus());
		assertEquals(null, result.getPaymentAmount());
		assertEquals(null, result.getTransactionId());
		assertEquals(null, result.getChallanUuid());
		assertEquals(null, result.getPgStatus());
		assertEquals(null, result.getLastModifiedBy());
		assertEquals(null, result.getSourceUuid());
	}

	/**
	 * Run the EcPayment(String,String,String,String,Integer,String,String,String,String,String,String,String,boolean,String,long,String,long) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:11 PM
	 */
	@Test
	public void testEcPayment_2()
		throws Exception {
		String paymentUuid = "";
		String paymentReceiptUuid = "";
		String paymentMode = "";
		String paymentStatus = "";
		String paymentAmount = "";
		String transactionId = "";
		String challanUuid = "";
		String challanId = "";
		String violationUuid = "";
		String paymentGateway = "";
		String pgStatus = "";
		String tenantId = "";
		boolean isActive = true;
		String createdBy = "";
		long createdTime = 1L;
		String lastModifiedBy = "";
		long lastModifiedTime = 1L;
		String sourceUuid="";


		EcPayment result = new EcPayment(paymentUuid, paymentReceiptUuid, paymentMode, paymentStatus, paymentAmount, transactionId, challanUuid, challanId, violationUuid, paymentGateway, pgStatus, tenantId, isActive, createdBy, createdTime, lastModifiedBy, lastModifiedTime, sourceUuid);

		
		assertNotNull(result);
		assertEquals(new Long(1L), result.getLastModifiedTime());
		assertEquals(true, result.getIsActive());
		assertEquals("", result.getTenantId());
		assertEquals(new Long(1L), result.getCreatedTime());
		assertEquals("", result.getCreatedBy());
		assertEquals("", result.getPaymentGateway());
		assertEquals("", result.getPaymentReceiptUuid());
		assertEquals("", result.getViolationUuid());
		assertEquals("", result.getPaymentMode());
		assertEquals("", result.getChallanId());
		assertEquals("", result.getPaymentUuid());
		assertEquals("", result.getPaymentStatus());
		assertEquals("", result.getPaymentAmount());
		assertEquals("", result.getTransactionId());
		assertEquals("", result.getChallanUuid());
		assertEquals("", result.getPgStatus());
		assertEquals("", result.getLastModifiedBy());
		assertEquals("", result.getSourceUuid());
	}

	/**
	 * Run the EcPayment.EcPaymentBuilder builder() method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:11 PM
	 */
	@Test
	public void testBuilder_1()
		throws Exception {

		EcPayment.EcPaymentBuilder result = EcPayment.builder();

		
		assertNotNull(result);
		assertEquals("EcPayment.EcPaymentBuilder(paymentUuid=null, paymentReceiptUuid=null, paymentMode=null, paymentStatus=null, paymentAmount=null, transactionId=null, challanUuid=null, challanId=null, violationUuid=null, paymentGateway=null, pgStatus=null, tenantId=null, isActive=null, createdBy=null, createdTime=null, lastModifiedBy=null, lastModifiedTime=null, sourceUuid=null)", result.toString());
	}
	
	@Test
	public void testBuilder_2()
		throws Exception {

		EcPayment.EcPaymentBuilder builder = new EcPayment.EcPaymentBuilder();
		builder.paymentUuid(null);
		builder.paymentReceiptUuid(null);
		builder.createdBy(null);
		builder.paymentMode(null);
		builder.paymentStatus(null);
		builder.paymentAmount(null);
		builder.transactionId(null);
		builder.challanUuid(null);
		builder.challanId(null);
		builder.violationUuid(null);
		builder.paymentGateway(null);
		builder.pgStatus(null);
		builder.lastModifiedBy(null);
		builder.createdBy(null);
		builder.createdTime(null);
		builder.lastModifiedTime(null);
		builder.tenantId(null);
		builder.isActive(null);
		builder.sourceUuid(null);
		builder.build();

		EcPayment.EcPaymentBuilder builder2 = new EcPayment.EcPaymentBuilder();
		builder2.paymentUuid(null);
		builder2.paymentReceiptUuid(null);
		builder2.createdBy(null);
		builder2.paymentMode(null);
		builder2.paymentStatus(null);
		builder2.paymentAmount(null);
		builder2.transactionId(null);
		builder2.challanUuid(null);
		builder2.challanId(null);
		builder2.violationUuid(null);
		builder2.paymentGateway(null);
		builder2.pgStatus(null);
		builder2.lastModifiedBy(null);
		builder2.createdBy(null);
		builder2.createdTime(null);
		builder2.lastModifiedTime(null);
		builder2.tenantId(null);
		builder2.isActive(null);
		builder2.sourceUuid(null);
		builder2.build();

		Assert.assertEquals(builder2.toString(), builder.toString());
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
		EcPayment fixture = new EcPayment("", "", "", "", "", "", "", "", "", "", "", "", true, "", 1L, "", 1L, "");

		String result = fixture.getChallanId();

		
		assertEquals("", result);
	}

	/**
	 * Run the String getChallanUuid() method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:11 PM
	 */
	@Test
	public void testGetChallanUuid_1()
		throws Exception {
		EcPayment fixture = new EcPayment("", "", "", "", "", "", "", "", "", "", "", "", true, "", 1L, "", 1L, "");

		String result = fixture.getChallanUuid();

		
		assertEquals("", result);
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
		EcPayment fixture = new EcPayment("", "", "", "", "", "", "", "", "", "", "", "", true, "", 1L, "", 1L, "");

		String result = fixture.getCreatedBy();

		
		assertEquals("", result);
	}

	/**
	 * Run the long getCreatedTime() method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:11 PM
	 */
	@Test
	public void testGetCreatedTime_1()
		throws Exception {
		EcPayment fixture = new EcPayment("", "", "", "", "", "", "", "", "", "", "", "", true, "", 1L, "", 1L, "");

		long result = fixture.getCreatedTime();

		
		assertEquals(1L, result);
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
		EcPayment fixture = new EcPayment("", "", "", "", "", "", "", "", "", "", "", "", true, "", 1L, "", 1L, "");

		String result = fixture.getLastModifiedBy();

		
		assertEquals("", result);
	}

	/**
	 * Run the long getLastModifiedTime() method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:11 PM
	 */
	@Test
	public void testGetLastModifiedTime_1()
		throws Exception {
		EcPayment fixture = new EcPayment("", "", "", "", "", "", "", "", "", "", "", "", true, "", 1L, "", 1L, "");

		long result = fixture.getLastModifiedTime();

		
		assertEquals(1L, result);
	}

	/**
	 * Run the Integer getPaymentAmount() method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:11 PM
	 */
	@Test
	public void testGetPaymentAmount_1()
		throws Exception {
		EcPayment fixture = new EcPayment("", "", "", "", "", "", "", "", "", "", "", "", true, "", 1L, "", 1L, "");

		String result = fixture.getPaymentAmount();

		
		assertNotNull(result);
		assertEquals("", result.toString());		
	}

	/**
	 * Run the String getPaymentGateway() method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:11 PM
	 */
	@Test
	public void testGetPaymentGateway_1()
		throws Exception {
		EcPayment fixture = new EcPayment("", "", "", "", "", "", "", "", "", "", "", "", true, "", 1L, "", 1L, "");

		String result = fixture.getPaymentGateway();

		
		assertEquals("", result);
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
		EcPayment fixture = new EcPayment("", "", "", "", "", "", "", "", "", "", "", "", true, "", 1L, "", 1L, "");

		String result = fixture.getPaymentMode();

		
		assertEquals("", result);
	}

	/**
	 * Run the String getPaymentReceiptUuid() method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:11 PM
	 */
	@Test
	public void testGetPaymentReceiptUuid_1()
		throws Exception {
		EcPayment fixture = new EcPayment("", "", "", "", "", "", "", "", "", "", "", "", true, "", 1L, "", 1L, "");

		String result = fixture.getPaymentReceiptUuid();

		
		assertEquals("", result);
	}

	/**
	 * Run the String getPaymentStatus() method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:11 PM
	 */
	@Test
	public void testGetPaymentStatus_1()
		throws Exception {
		EcPayment fixture = new EcPayment("", "", "", "", "", "", "", "", "", "", "", "", true, "", 1L, "", 1L, "");

		String result = fixture.getPaymentStatus();

		
		assertEquals("", result);
	}

	/**
	 * Run the String getPaymentUuid() method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:11 PM
	 */
	@Test
	public void testGetPaymentUuid_1()
		throws Exception {
		EcPayment fixture = new EcPayment("", "", "", "", "", "", "", "", "", "", "", "", true, "", 1L, "", 1L, "");

		String result = fixture.getPaymentUuid();

		
		assertEquals("", result);
	}

	/**
	 * Run the String getPgStatus() method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:11 PM
	 */
	@Test
	public void testGetPgStatus_1()
		throws Exception {
		EcPayment fixture = new EcPayment("", "", "", "", "", "", "", "", "", "", "", "", true, "", 1L, "", 1L, "");

		String result = fixture.getPgStatus();

		
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
		EcPayment fixture = new EcPayment("", "", "", "", "", "", "", "", "", "", "", "", true, "", 1L, "", 1L, "");

		String result = fixture.getTenantId();

		
		assertEquals("", result);
	}

	/**
	 * Run the String getTransactionId() method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:11 PM
	 */
	@Test
	public void testGetTransactionId_1()
		throws Exception {
		EcPayment fixture = new EcPayment("", "", "", "", "", "", "", "", "", "", "", "", true, "", 1L, "", 1L, "");

		String result = fixture.getTransactionId();

		
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
		EcPayment fixture = new EcPayment("", "", "", "", "", "", "", "", "", "", "", "", true, "", 1L, "", 1L, "");

		String result = fixture.getViolationUuid();

		
		assertEquals("", result);
	}

	/**
	 * Run the boolean isActive() method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:11 PM
	 */
	@Test
	public void testIsActive_1()
		throws Exception {
		EcPayment fixture = new EcPayment("", "", "", "", "", "", "", "", "", "", "", "", true, "", 1L, "", 1L, "");

		boolean result = fixture.getIsActive();

		
		assertEquals(true, result);
	}

	/**
	 * Run the boolean isActive() method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:11 PM
	 */
	@Test
	public void testIsActive_2()
		throws Exception {
		EcPayment fixture = new EcPayment("", "", "", "", "", "", "", "", "", "", "", "", false, "", 1L, "", 1L, "");

		boolean result = fixture.getIsActive();

		
		assertEquals(false, result);
	}

	/**
	 * Run the void setActive(boolean) method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:11 PM
	 */
	@Test
	public void testSetActive_1()
		throws Exception {
		EcPayment fixture = new EcPayment("", "", "", "", "", "", "", "", "", "", "", "", true, "", 1L, "", 1L, "");
		boolean isActive = true;

		fixture.setIsActive(isActive);

		
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
		EcPayment fixture = new EcPayment("", "", "", "", "", "", "", "", "", "", "", "", true, "", 1L, "", 1L, "");
		String challanId = "";

		fixture.setChallanId(challanId);

		
	}

	/**
	 * Run the void setChallanUuid(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:11 PM
	 */
	@Test
	public void testSetChallanUuid_1()
		throws Exception {
		EcPayment fixture = new EcPayment("", "", "", "", "", "", "", "", "", "", "", "", true, "", 1L, "", 1L, "");
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
		EcPayment fixture = new EcPayment("", "", "", "", "", "", "", "", "", "", "", "", true, "", 1L, "", 1L, "");
		String createdBy = "";

		fixture.setCreatedBy(createdBy);

		
	}

	/**
	 * Run the void setCreatedTime(long) method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:11 PM
	 */
	@Test
	public void testSetCreatedTime_1()
		throws Exception {
		EcPayment fixture = new EcPayment("", "", "", "", "", "", "", "", "", "", "", "", true, "", 1L, "", 1L, "");
		long createdTime = 1L;

		fixture.setCreatedTime(createdTime);

		
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
		EcPayment fixture = new EcPayment("", "", "", "", "", "", "", "", "", "", "", "", true, "", 1L, "", 1L, "");
		String lastModifiedBy = "";

		fixture.setLastModifiedBy(lastModifiedBy);

		
	}

	/**
	 * Run the void setLastModifiedTime(long) method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:11 PM
	 */
	@Test
	public void testSetLastModifiedTime_1()
		throws Exception {
		EcPayment fixture = new EcPayment("", "", "", "", "", "", "", "", "", "", "", "", true, "", 1L, "", 1L, "");
		long lastModifiedTime = 1L;

		fixture.setLastModifiedTime(lastModifiedTime);

		
	}

	/**
	 * Run the void setPaymentAmount(Integer) method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:11 PM
	 */
	@Test
	public void testSetPaymentAmount_1()
		throws Exception {
		EcPayment fixture = new EcPayment("", "", "", "", "", "", "", "", "", "", "", "", true, "", 1L, "", 1L, "");
		String paymentAmount = "";

		fixture.setPaymentAmount(paymentAmount);

		
	}

	/**
	 * Run the void setPaymentGateway(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:11 PM
	 */
	@Test
	public void testSetPaymentGateway_1()
		throws Exception {
		EcPayment fixture = new EcPayment("", "", "", "", "", "", "", "", "", "", "", "", true, "", 1L, "", 1L, "");
		String paymentGateway = "";

		fixture.setPaymentGateway(paymentGateway);

		
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
		EcPayment fixture = new EcPayment("", "", "", "", "", "", "", "", "", "", "", "", true, "", 1L, "", 1L, "");
		String paymentMode = "";

		fixture.setPaymentMode(paymentMode);

		
	}

	/**
	 * Run the void setPaymentReceiptUuid(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:11 PM
	 */
	@Test
	public void testSetPaymentReceiptUuid_1()
		throws Exception {
		EcPayment fixture = new EcPayment("", "", "", "", "", "", "", "", "", "", "", "", true, "", 1L, "", 1L, "");
		String paymentReceiptUuid = "";

		fixture.setPaymentReceiptUuid(paymentReceiptUuid);

		
	}

	/**
	 * Run the void setPaymentStatus(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:11 PM
	 */
	@Test
	public void testSetPaymentStatus_1()
		throws Exception {
		EcPayment fixture = new EcPayment("", "", "", "", "", "", "", "", "", "", "", "", true, "", 1L, "", 1L, "");
		String paymentStatus = "";

		fixture.setPaymentStatus(paymentStatus);

		
	}

	/**
	 * Run the void setPaymentUuid(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:11 PM
	 */
	@Test
	public void testSetPaymentUuid_1()
		throws Exception {
		EcPayment fixture = new EcPayment("", "", "", "", "", "", "", "", "", "", "", "", true, "", 1L, "", 1L, "");
		String paymentUuid = "";

		fixture.setPaymentUuid(paymentUuid);

		
	}

	/**
	 * Run the void setPgStatus(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:11 PM
	 */
	@Test
	public void testSetPgStatus_1()
		throws Exception {
		EcPayment fixture = new EcPayment("", "", "", "", "", "", "", "", "", "", "", "", true, "", 1L, "", 1L, "");
		String pgStatus = "";

		fixture.setPgStatus(pgStatus);

		
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
		EcPayment fixture = new EcPayment("", "", "", "", "", "", "", "", "", "", "", "", true, "", 1L, "", 1L, "");
		String tenantId = "";

		fixture.setTenantId(tenantId);

		
	}

	/**
	 * Run the void setTransactionId(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:11 PM
	 */
	@Test
	public void testSetTransactionId_1()
		throws Exception {
		EcPayment fixture = new EcPayment("", "", "", "", "", "", "", "", "", "", "", "", true, "", 1L, "", 1L, "");
		String transactionId = "";

		fixture.setTransactionId(transactionId);

		
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
		EcPayment fixture = new EcPayment("", "", "", "", "", "", "", "", "", "", "", "", true, "", 1L, "", 1L, "");
		String violationUuid = "";

		fixture.setViolationUuid(violationUuid);

		
	}
	
	@Test
	public void testSetSourceUuid_1() throws Exception {
		EcPayment fixture = new EcPayment("", "", "", "", "", "", "", "", "", "", "", "", true, "", 1L, "", 1L, "");
		String sourceUuid = "";
		fixture.setSourceUuid(sourceUuid);

	}
	
	@Test
	public void testGetSourceUuid_1() throws Exception {
		EcPayment fixture = new EcPayment("", "", "", "", "", "", "", "", "", "", "", "", true, "", 1L, "", 1L, "");

		String result = fixture.getSourceUuid();

		assertEquals("", result);
	}

}