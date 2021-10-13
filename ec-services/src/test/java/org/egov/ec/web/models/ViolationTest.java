package org.egov.ec.web.models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Date;
import java.util.List;

import org.egov.ec.web.models.ChallanDetails;
import org.egov.ec.web.models.Document;
import org.egov.ec.web.models.EcPayment;
import org.egov.ec.web.models.NotificationTemplate;
import org.egov.ec.web.models.Violation;
import org.egov.ec.web.models.ViolationItem;
import org.junit.Assert;
import org.junit.Test;

public class ViolationTest {

	@Test
	public void testViolation_1() throws Exception {

		Violation result = new Violation();

		assertNotNull(result);
		assertEquals(null, result.getViolationUuid());
		assertEquals(null, result.getChallanId());
		assertEquals(null, result.getTenantId());
		assertEquals(null, result.getNumberOfViolation());
		assertEquals(null, result.getChallanId());
		assertEquals(null, result.getEncroachmentType());
		assertEquals(null, result.getViolationDate());
		assertEquals(null, result.getViolationTime());
		assertEquals(null, result.getViolatorName());
		assertEquals(null, result.getSector());
		assertEquals(null, result.getAddress());
		assertEquals(null, result.getEmailId());
		assertEquals(null, result.getFatherName());
		assertEquals(null, result.getContactNumber());
		assertEquals(null, result.getLicenseNoCov());
		assertEquals(null, result.getNatureOfViolation());
		assertEquals(null, result.getLocation());
		assertEquals(null, result.getPaymentMode());
		assertEquals(null, result.getChallanAmount());
		assertEquals(null, result.getFineAmount());
		assertEquals(null, result.getPenaltyAmount());
		assertEquals(null, result.getGstAmount());
		assertEquals(null, result.getTotalChallanAmount());
		assertEquals(null, result.getSiName());
		assertEquals(null, result.getStatus());
		assertEquals(null, result.getIsActive());
		assertEquals(null, result.getLastModifiedTime());
		assertEquals(null, result.getCreatedBy());
		assertEquals(null, result.getCreatedTime());
		assertEquals(null, result.getLastModifiedBy());
		assertEquals(null, result.getDocument());
		assertEquals(null, result.getViolationItem());
		assertEquals(null, result.getNotificationTemplate());
		assertEquals(null, result.getChallanDetails());
		assertEquals(null, result.getPaymentDetails());
		assertEquals(null, result.getSourceUuid());
		assertEquals(null, result.getFromDate());
		assertEquals(null, result.getToDate());
	}

	@Test
	public void testViolation_2() throws Exception {
		String violationUuid = "";
		String challanUuid = "";
		String tenantId = "";
		String numberOfViolation = "";
		String challanId = "";
		String encroachmentType = "";
		String violationDate = "";
		String violationTime = "";
		String violatorName = "";
		String sector = "";
		String address = "";
		String emailId = "";
		String fatherName = "";
		String contactNumber = "";
		String licenseNoCov = "";
		String natureOfViolation = "";
		String paymentMode = "";
		String location = "";
		String challanAmount = null;
		String fineAmount = null;
		String penaltyAmount = null;
		String gstAmount = null;
		String totalChallanAmount = null;
		String siName = "";
		String status = "";
		Boolean isActive = new Boolean(true);
		Long lastModifiedTime = new Long(1L);
		String createdBy = "";
		Long createdTime = new Long(1L);
		String lastModifiedBy = "";
		List<Document> document = null;
		List<ViolationItem> violationItem = null;
		NotificationTemplate notificationTemplate = null;
		List<ChallanDetails> challanDetails = null;
		EcPayment paymentDetails = null;
		String sourceUuid="";
		Date fromDate=null;
		Date toDate=null;
		Violation result = new Violation(violationUuid, challanUuid, tenantId, numberOfViolation, challanId,
				encroachmentType, violationDate, violationTime, violatorName, sector, address, emailId, fatherName,
				contactNumber, licenseNoCov, natureOfViolation, location, paymentMode, challanAmount, fineAmount,
				penaltyAmount, gstAmount, totalChallanAmount, siName, status, isActive, createdBy, createdTime,
				lastModifiedBy, lastModifiedTime, document, violationItem, notificationTemplate, challanDetails,
				paymentDetails, sourceUuid, fromDate, toDate);

		assertNotNull(result);
		assertEquals("", result.getViolationUuid());
		assertEquals("", result.getChallanUuid());
		assertEquals("", result.getTenantId());
		assertEquals("", result.getNumberOfViolation());
		assertEquals("", result.getChallanId());
		assertEquals("", result.getEncroachmentType());
		assertEquals("", result.getViolationDate());
		assertEquals("", result.getViolationTime());
		assertEquals("", result.getViolatorName());
		assertEquals("", result.getSector());
		assertEquals("", result.getAddress());
		assertEquals("", result.getEmailId());
		assertEquals("", result.getFatherName());
		assertEquals("", result.getContactNumber());
		assertEquals("", result.getLicenseNoCov());
		assertEquals("", result.getNatureOfViolation());
		assertEquals("", result.getLocation());
		assertEquals("", result.getPaymentMode());
		assertEquals(null, result.getChallanAmount());
		assertEquals(null, result.getFineAmount());
		assertEquals(null, result.getPenaltyAmount());
		assertEquals(null, result.getGstAmount());
		assertEquals(null, result.getTotalChallanAmount());
		assertEquals("", result.getSiName());
		assertEquals("", result.getStatus());
		assertEquals(Boolean.TRUE, result.getIsActive());
		assertEquals("", result.getLastModifiedBy());
		assertEquals(new Long(1L), (result.getLastModifiedTime()));
		assertEquals("", result.getCreatedBy());
		assertEquals(new Long(1L), result.getCreatedTime());
		assertEquals("", result.getLastModifiedBy());
		assertEquals(null, result.getDocument());
		assertEquals(null, result.getViolationItem());
		assertEquals(null, result.getNotificationTemplate());
		assertEquals(null, result.getChallanDetails());
		assertEquals(null, result.getPaymentDetails());
		assertEquals("", result.getSourceUuid());
		assertEquals(null, result.getFromDate());
		assertEquals(null, result.getToDate());

	}

	/*
	 * public void testBuilder_1() throws Exception {
	 * 
	 * Violation.ViolationBuilder result = Violation.builder();
	 * 
	 * assertNotNull(result); assertEquals(
	 * "Violation.ViolationBuilder(violationUuid=null, challanUuid=null, tenantId=null, numberOfViolation=null, challanId=null, encroachmentType=null, violationDate=null, violationTime=null, violatorName=null, sector=null, address=null, emailId=null, fatherName=null, contactNumber=null, licenseNoCov=null, natureOfViolation=null, location=null, paymentMode=null, challanAmount=null, fineAmount=null, penaltyAmount=null, gstAmount=null, totalChallanAmount=null, siName=null, status=null, isActive=null, createdBy=null, createdTime=null, lastModifiedBy=null, lastModifiedTime=null, document=null, violationItem=null, notificationTemplate=null, challanDetails=null, paymentDetails=null, sourceUuid=null)"
	 * , result.toString()); }
	 */

	@Test
	public void testBuilder_2() throws Exception {

		Violation.ViolationBuilder builder = new Violation.ViolationBuilder();
		builder.violationUuid(null);
		builder.challanUuid(null);
		builder.tenantId(null);
		builder.numberOfViolation(null);
		builder.challanId(null);
		builder.encroachmentType(null);
		builder.violationDate(null);
		builder.violationTime(null);
		builder.violatorName(null);
		builder.sector(null);
		builder.address(null);
		builder.emailId(null);
		builder.fatherName(null);
		builder.contactNumber(null);
		builder.licenseNoCov(null);
		builder.natureOfViolation(null);
		builder.location(null);
		builder.paymentMode(null);
		builder.challanAmount(null);
		builder.fineAmount(null);
		builder.penaltyAmount(null);
		builder.gstAmount(null);
		builder.totalChallanAmount(null);
		builder.siName(null);
		builder.status(null);
		builder.isActive(null);
		builder.lastModifiedBy(null);
		builder.lastModifiedTime(null);
		builder.createdBy(null);
		builder.createdTime(null);
		builder.lastModifiedBy(null);
		builder.document(null);
		builder.violationItem(null);
		builder.notificationTemplate(null);
		builder.challanDetails(null);
		builder.paymentDetails(null);
		builder.sourceUuid(null);
		builder.fromDate(null);
		builder.toDate(null);
		builder.build();

		Violation.ViolationBuilder builder2 = new Violation.ViolationBuilder();
		builder2.violationUuid(null);
		builder2.challanUuid(null);
		builder2.tenantId(null);
		builder2.numberOfViolation(null);
		builder2.challanId(null);
		builder2.encroachmentType(null);
		builder2.violationDate(null);
		builder2.violationTime(null);
		builder2.violatorName(null);
		builder2.sector(null);
		builder2.address(null);
		builder2.emailId(null);
		builder2.fatherName(null);
		builder2.contactNumber(null);
		builder2.licenseNoCov(null);
		builder2.natureOfViolation(null);
		builder2.location(null);
		builder2.paymentMode(null);
		builder2.challanAmount(null);
		builder2.fineAmount(null);
		builder2.penaltyAmount(null);
		builder2.gstAmount(null);
		builder2.totalChallanAmount(null);
		builder2.siName(null);
		builder2.status(null);
		builder2.isActive(null);
		builder2.lastModifiedBy(null);
		builder2.lastModifiedTime(null);
		builder2.createdBy(null);
		builder2.createdTime(null);
		builder2.lastModifiedBy(null);
		builder2.document(null);
		builder2.violationItem(null);
		builder2.notificationTemplate(null);
		builder2.challanDetails(null);
		builder2.paymentDetails(null);
		builder2.sourceUuid(null);
		builder2.fromDate(null);
		builder2.toDate(null);
		builder2.build();

		Assert.assertEquals(builder2.toString(), builder.toString());
	}

	@Test
	public void testGetViolationUuid_1() throws Exception {
		Violation fixture = new Violation("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", null,
				null, null, null, null, "", "", new Boolean(true), null, new Long(1L), "", new Long(1L), null, null,
				null, null, null,"", null, null);
		String result = fixture.getViolationUuid();
		assertEquals("", result);
	}

	@Test
	public void testGetChallanUuid_1() throws Exception {
		Violation fixture = new Violation("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", null,
				null, null, null, null, "", "", new Boolean(true), null, new Long(1L), "", new Long(1L), null, null,
				null, null, null,"", null, null);
		String result = fixture.getChallanUuid();
		assertEquals("", result);
	}

	@Test
	public void testGetTenantId_1() throws Exception {
		Violation fixture = new Violation("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", null,
				null, null, null, null, "", "", new Boolean(true), null, new Long(1L), "", new Long(1L), null, null,
				null, null, null,"", null, null);
		String result = fixture.getTenantId();
		assertEquals("", result);
	}

	@Test
	public void testGetNumberOfViolation_1() throws Exception {
		Violation fixture = new Violation("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", null,
				null, null, null, null, "", "", new Boolean(true), null, new Long(1L), "", new Long(1L), null, null,
				null, null, null,"", null, null);
		String result = fixture.getNumberOfViolation();
		assertEquals("", result);
	}

	@Test
	public void testGetChallanId_1() throws Exception {
		Violation fixture = new Violation("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", null,
				null, null, null, null, "", "", new Boolean(true), null, new Long(1L), "", new Long(1L), null, null,
				null, null, null,"", null, null);
		String result = fixture.getChallanId();
		assertEquals("", result);
	}

	@Test
	public void testGetEncroachmentType_1() throws Exception {
		Violation fixture = new Violation("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", null,
				null, null, null, null, "", "", new Boolean(true), null, new Long(1L), "", new Long(1L), null, null,
				null, null, null,"", null, null);
		String result = fixture.getEncroachmentType();
		assertEquals("", result);
	}

	@Test
	public void testGetViolationDate_1() throws Exception {
		Violation fixture = new Violation("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", null,
				null, null, null, null, "", "", new Boolean(true), null, new Long(1L), "", new Long(1L), null, null,
				null, null, null,"", null, null);
		String result = fixture.getViolationDate();
		assertEquals("", result);
	}

	@Test
	public void testGetViolationTime_1() throws Exception {
		Violation fixture = new Violation("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", null,
				null, null, null, null, "", "", new Boolean(true), null, new Long(1L), "", new Long(1L), null, null,
				null, null, null,"", null, null);
		String result = fixture.getViolationTime();
		assertEquals("", result);
	}

	@Test
	public void testGetViolatorName_1() throws Exception {
		Violation fixture = new Violation("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", null,
				null, null, null, null, "", "", new Boolean(true), null, new Long(1L), "", new Long(1L), null, null,
				null, null, null,"", null, null);
		String result = fixture.getViolatorName();
		assertEquals("", result);
	}

	@Test
	public void testGetSector_1() throws Exception {
		Violation fixture = new Violation("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", null,
				null, null, null, null, "", "", new Boolean(true), null, new Long(1L), "", new Long(1L), null, null,
				null, null, null,"", null, null);
		String result = fixture.getSector();
		assertEquals("", result);
	}

	@Test
	public void testGetAddress_1() throws Exception {
		Violation fixture = new Violation("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", null,
				null, null, null, null, "", "", new Boolean(true), null, new Long(1L), "", new Long(1L), null, null,
				null, null, null,"", null, null);
		String result = fixture.getAddress();
		assertEquals("", result);
	}

	@Test
	public void testGetEmailId_1() throws Exception {
		Violation fixture = new Violation("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", null,
				null, null, null, null, "", "", new Boolean(true), null, new Long(1L), "", new Long(1L), null, null,
				null, null, null,"", null, null);
		String result = fixture.getEmailId();
		assertEquals("", result);
	}

	@Test
	public void testGetFatherName_1() throws Exception {
		Violation fixture = new Violation("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", null,
				null, null, null, null, "", "", new Boolean(true), null, new Long(1L), "", new Long(1L), null, null,
				null, null, null,"", null, null);
		String result = fixture.getFatherName();
		assertEquals("", result);
	}

	@Test
	public void testGetContactNumber_1() throws Exception {
		Violation fixture = new Violation("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", null,
				null, null, null, null, "", "", new Boolean(true), null, new Long(1L), "", new Long(1L), null, null,
				null, null, null,"", null, null);
		String result = fixture.getContactNumber();
		assertEquals("", result);
	}

	@Test
	public void testGetLicenseNoCov_1() throws Exception {
		Violation fixture = new Violation("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", null,
				null, null, null, null, "", "", new Boolean(true), null, new Long(1L), "", new Long(1L), null, null,
				null, null, null,"", null, null);
		String result = fixture.getLicenseNoCov();
		assertEquals("", result);
	}

	@Test
	public void testGetNatureOfViolation_1() throws Exception {
		Violation fixture = new Violation("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", null,
				null, null, null, null, "", "", new Boolean(true), null, new Long(1L), "", new Long(1L), null, null,
				null, null, null,"", null, null);
		String result = fixture.getNatureOfViolation();
		assertEquals("", result);
	}

	@Test
	public void testGetLocation_1() throws Exception {
		Violation fixture = new Violation("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", null,
				null, null, null, null, "", "", new Boolean(true), null, new Long(1L), "", new Long(1L), null, null,
				null, null, null,"", null, null);
		String result = fixture.getLocation();
		assertEquals("", result);
	}

	@Test
	public void testGetPaymentMode_1() throws Exception {
		Violation fixture = new Violation("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", null,
				null, null, null, null, "", "", new Boolean(true), null, new Long(1L), "", new Long(1L), null, null,
				null, null, null,"", null, null);
		String result = fixture.getPaymentMode();
		assertEquals("", result);
	}

	@Test
	public void testGetChallanAmount_1() throws Exception {
		Violation fixture = new Violation("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", null,
				null, null, null, null, "", "", new Boolean(true), null, new Long(1L), "", new Long(1L), null, null,
				null, null, null,"", null, null);
		String result = fixture.getChallanAmount();
		assertEquals(null, result);
	}

	@Test
	public void testGetFineAmount_1() throws Exception {
		Violation fixture = new Violation("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", null,
				null, null, null, null, "", "", new Boolean(true), null, new Long(1L), "", new Long(1L), null, null,
				null, null, null,"", null, null);
		String result = fixture.getFineAmount();
		assertEquals(null, result);
	}
	
	

	@Test
	public void testGetGstAmount_1() throws Exception {
		Violation fixture = new Violation("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", null,
				null, null, null, null, "", "", new Boolean(true), null, new Long(1L), "", new Long(1L), null, null,
				null, null, null,"", null, null);
		String result = fixture.getGstAmount();
		assertEquals(null, result);
	}

	@Test
	public void testGetTotalChallanAmount_1() throws Exception {
		Violation fixture = new Violation("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", null,
				null, null, null, null, "", "", new Boolean(true), null, new Long(1L), "", new Long(1L), null, null,
				null, null, null,"", null, null);
		String result = fixture.getTotalChallanAmount();
		assertEquals(null, result);
	}

	@Test
	public void testGetSiName_1() throws Exception {
		Violation fixture = new Violation("","","","","","","","","","", "", "", "", "", "", "", "", "",
				null, null, null, null, null, "", "", new Boolean(true),null, new Long(1L), "", new Long(1L), null, null, null, null, null,"", null, null);
		String result = fixture.getSiName();
		assertEquals("", result);
	}
	
	@Test
	public void testGetStatus_1() throws Exception {
		Violation fixture = new Violation("","","","","","","","","","", "", "", "", "", "", "", "", "",
				null, null, null, null, null, "", "", new Boolean(true),null, new Long(1L), "", new Long(1L), null, null, null, null, null,"", null, null);
		String result = fixture.getStatus();
		assertEquals("", result);
	}
	
	@Test
	public void testGetDocument_1() throws Exception {
		Violation fixture = new Violation("","","","","","","","","","", "", "", "", "", "", "", "", "",
				null, null, null, null, null, "", "", new Boolean(true),null, new Long(1L), "", new Long(1L), null, null, null, null, null,"", null, null);
		List<Document> result = fixture.getDocument();
		assertEquals(null, result);
	}
	
	@Test
	public void testGetViolationItem_1() throws Exception {
		Violation fixture = new Violation("","","","","","","","","","", "", "", "", "", "", "", "", "",
				null, null, null, null, null, "", "", new Boolean(true),null, new Long(1L), "", new Long(1L), null, null, null, null, null,"", null, null);
		List<ViolationItem> result = fixture.getViolationItem();
		assertEquals(null, result);
	}

	@Test
	public void testGetNotificationTemplate_1() throws Exception {
		Violation fixture = new Violation("","","","","","","","","","", "", "", "", "", "", "", "", "",
				null, null, null, null, null, "", "", new Boolean(true),null, new Long(1L), "", new Long(1L), null, null, null, null, null,"", null, null);
		NotificationTemplate result = fixture.getNotificationTemplate();
		assertEquals(null, result);
	}
	
	@Test
	public void testGetChallanDetails_1() throws Exception {
		Violation fixture = new Violation("","","","","","","","","","", "", "", "", "", "", "", "", "",
				null, null, null, null, null, "", "", new Boolean(true),null, new Long(1L), "", new Long(1L), null, null, null, null, null,"", null, null);
		List<ChallanDetails> result = fixture.getChallanDetails();
		assertEquals(null, result);
	}
	
	@Test
	public void testPaymentDetails_1() throws Exception {
		Violation fixture = new Violation("","","","","","","","","","", "", "", "", "", "", "", "", "",
				null, null, null, null, null, "", "", new Boolean(true),null, new Long(1L), "", new Long(1L), null, null, null, null, null,"", null, null);
		EcPayment result = fixture.getPaymentDetails();
		assertEquals(null, result);
	}

	@Test
	public void testGetIsActive_1() throws Exception {
		ViolationItem fixture = new ViolationItem("","","","","","",null,"","","", new Boolean(true),null, new Long(1L), "", new Long(1L));
	Boolean result = fixture.getIsActive();

	assertNotNull(result);
	assertEquals("true", result.toString());
	assertEquals(true, result.booleanValue());
	}
	
	@Test
	public void testGetCreatedBy_1() throws Exception {
		ViolationItem fixture = new ViolationItem("","","","","","",null,"","","", new Boolean(true),null, new Long(1L), "", new Long(1L));

		String result = fixture.getCreatedBy();

		assertEquals(null, result);
	}

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

	@Test
	public void testGetLastModifiedBy_1() throws Exception {
		ViolationItem fixture =  new ViolationItem("","","","","","",null,"","","", new Boolean(true),null, new Long(1L), "", new Long(1L));

		String result = fixture.getLastModifiedBy();

		assertEquals("", result);
	}

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
	public void testSetViolationUuid_1() throws Exception {
		Violation fixture =  new Violation("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", null,
				null, null, null, null, "", "", new Boolean(true), null, new Long(1L), "", new Long(1L), null, null,
				null, null, null,"", null, null);
		String violationUuid = "";
		fixture.setViolationUuid(violationUuid);

	}
	
@Test
	public void testSetChallanUuid_1() throws Exception {
		Violation fixture =  new Violation("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", null,
				null, null, null, null, "", "", new Boolean(true), null, new Long(1L), "", new Long(1L), null, null,
				null, null, null,"", null, null);
		String challanUuid = "";
		fixture.setChallanUuid(challanUuid);

	}

	
	@Test
	public void testSetTenantId_1() throws Exception {
		Violation fixture =  new Violation("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", null,
				null, null, null, null, "", "", new Boolean(true), null, new Long(1L), "", new Long(1L), null, null,
				null, null, null,"", null, null);
		String tenantId = "";
		fixture.setTenantId(tenantId);

	}
	
		@Test
	public void testSetNumberOfViolation_1() throws Exception {
		Violation fixture =  new Violation("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", null,
				null, null, null, null, "", "", new Boolean(true), null, new Long(1L), "", new Long(1L), null, null,
				null, null, null,"", null, null);
		String numberOfViolation = "";
		fixture.setNumberOfViolation(numberOfViolation);

	}
	
			@Test
	public void testSetChallanId_1() throws Exception {
		Violation fixture =  new Violation("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", null,
				null, null, null, null, "", "", new Boolean(true), null, new Long(1L), "", new Long(1L), null, null,
				null, null, null,"", null, null);
		String challanId = "";
		fixture.setChallanId(challanId);

	}
	
				@Test
	public void testSetEncroachmentType_1() throws Exception {
		Violation fixture =  new Violation("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", null,
				null, null, null, null, "", "", new Boolean(true), null, new Long(1L), "", new Long(1L), null, null,
				null, null, null,"", null, null);
		String encroachmentType = "";
		fixture.setEncroachmentType(encroachmentType);

	}
	
	@Test
	public void testSetViolationDate_1() throws Exception {
		Violation fixture =  new Violation("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", null,
				null, null, null, null, "", "", new Boolean(true), null, new Long(1L), "", new Long(1L), null, null,
				null, null, null,"", null, null);
		String violationDate = "";
		fixture.setViolationDate(violationDate);

	}
	
		@Test
	public void testSetViolationTime_1() throws Exception {
		Violation fixture =  new Violation("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", null,
				null, null, null, null, "", "", new Boolean(true), null, new Long(1L), "", new Long(1L), null, null,
				null, null, null,"", null, null);
		String violationTime = "";
		fixture.setViolationTime(violationTime);

	}
	
	@Test
	public void testSetViolatorName_1() throws Exception {
		Violation fixture =  new Violation("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", null,
				null, null, null, null, "", "", new Boolean(true), null, new Long(1L), "", new Long(1L), null, null,
				null, null, null,"", null, null);
		String violatorName = "";
		fixture.setViolatorName(violatorName);

	}

	@Test
	public void testGetPenaltyAmount_1() throws Exception {
		Violation fixture = new Violation("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", null,
				null, null, null, null, "", "", new Boolean(true), null, new Long(1L), "", new Long(1L), null, null,
				null, null, null,"", null, null);
		String result = fixture.getPenaltyAmount();
		assertEquals(null, result);
	}
	
	@Test
	public void testSetSector_1() throws Exception {
		Violation fixture =  new Violation("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", null,
				null, null, null, null, "", "", new Boolean(true), null, new Long(1L), "", new Long(1L), null, null,
				null, null, null,"", null, null);
		String sector = "";
		fixture.setSector(sector);

	}
	
	@Test
	public void testSetAddress_1() throws Exception {
		Violation fixture =  new Violation("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", null,
				null, null, null, null, "", "", new Boolean(true), null, new Long(1L), "", new Long(1L), null, null,
				null, null, null,"", null, null);
		String address = "";
		fixture.setAddress(address);

	}
	
	@Test
	public void testSetEmailId_1() throws Exception {
		Violation fixture =  new Violation("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", null,
				null, null, null, null, "", "", new Boolean(true), null, new Long(1L), "", new Long(1L), null, null,
				null, null, null,"", null, null);
		String emailId = "";
		fixture.setEmailId(emailId);

	}
	
	@Test
	public void testSetFatherName_1() throws Exception {
		Violation fixture =  new Violation("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", null,
				null, null, null, null, "", "", new Boolean(true), null, new Long(1L), "", new Long(1L), null, null,
				null, null, null,"", null, null);
		String fatherName = "";
		fixture.setFatherName(fatherName);

	}
	
		@Test
	public void testSetContactNumber_1() throws Exception {
		Violation fixture =  new Violation("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", null,
				null, null, null, null, "", "", new Boolean(true), null, new Long(1L), "", new Long(1L), null, null,
				null, null, null,"", null, null);
		String contactNumber = "";
		fixture.setContactNumber(contactNumber);

	}
	
	@Test
	public void testSetLicenseNoCov_1() throws Exception {
		Violation fixture =  new Violation("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", null,
				null, null, null, null, "", "", new Boolean(true), null, new Long(1L), "", new Long(1L), null, null,
				null, null, null,"", null, null);
		String licenseNoCov = "";
		fixture.setLicenseNoCov(licenseNoCov);

	}
	
	@Test
	public void testSetNatureOfViolation_1() throws Exception {
		Violation fixture =  new Violation("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", null,
				null, null, null, null, "", "", new Boolean(true), null, new Long(1L), "", new Long(1L), null, null,
				null, null, null,"", null, null);
		String natureOfViolation = "";
		fixture.setNatureOfViolation(natureOfViolation);

	}
	
	@Test
	public void testSetLocation_1() throws Exception {
		Violation fixture =  new Violation("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", null,
				null, null, null, null, "", "", new Boolean(true), null, new Long(1L), "", new Long(1L), null, null,
				null, null, null,"", null, null);
		String location = "";
		fixture.setLocation(location);

	}
	
	@Test
	public void testSetPaymentMode_1() throws Exception {
		Violation fixture =  new Violation("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", null,
				null, null, null, null, "", "", new Boolean(true), null, new Long(1L), "", new Long(1L), null, null,
				null, null, null,"", null, null);
		String paymentMode = "";
		fixture.setPaymentMode(paymentMode);

	}
	
	@Test
	public void testSetChallanAmount_1() throws Exception {
		Violation fixture =  new Violation("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", null,
				null, null, null, null, "", "", new Boolean(true), null, new Long(1L), "", new Long(1L), null, null,
				null, null, null,"", null, null);
		String challanAmount = null;
		fixture.setChallanAmount(challanAmount);
	}
	
		@Test
	public void testSetFineAmount_1() throws Exception {
		Violation fixture =  new Violation("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", null,
				null, null, null, null, "", "", new Boolean(true), null, new Long(1L), "", new Long(1L), null, null,
				null, null, null,"", null, null);
		String fineAmount = null;
		fixture.setFineAmount(fineAmount);
	}
	
		@Test
	public void testSetPenaltyAmount_1() throws Exception {
		Violation fixture =  new Violation("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", null,
				null, null, null, null, "", "", new Boolean(true), null, new Long(1L), "", new Long(1L), null, null,
				null, null, null,"", null, null);
		String penaltyAmount = null;
		fixture.setPenaltyAmount(penaltyAmount);
	}
	
		@Test
	public void testSetGstAmount_1() throws Exception {
		Violation fixture =  new Violation("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", null,
				null, null, null, null, "", "", new Boolean(true), null, new Long(1L), "", new Long(1L), null, null,
				null, null, null,"", null, null);
		String gstAmount = null;
		fixture.setGstAmount(gstAmount);
	}
	
		@Test
	public void testSetTotalChallanAmount_1() throws Exception {
		Violation fixture =  new Violation("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", null,
				null, null, null, null, "", "", new Boolean(true), null, new Long(1L), "", new Long(1L), null, null,
				null, null, null,"", null, null);
		String totalChallanAmount = null;
		fixture.setTotalChallanAmount(totalChallanAmount);
	}
	
	@Test
	public void testSetSiName_1() throws Exception {
		Violation fixture =  new Violation("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", null,
				null, null, null, null, "", "", new Boolean(true), null, new Long(1L), "", new Long(1L), null, null,
				null, null, null,"", null, null);
		String siName = "";
		fixture.setSiName(siName);

	}
	
		@Test
	public void testSetStatus_1() throws Exception {
		Violation fixture =  new Violation("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", null,
				null, null, null, null, "", "", new Boolean(true), null, new Long(1L), "", new Long(1L), null, null,
				null, null, null,"", null, null);
		String status = "";
		fixture.setStatus(status);

	}
	
		@Test
		public void testSetIsActive_1() throws Exception {
			Violation fixture =  new Violation("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", null,
					null, null, null, null, "", "", new Boolean(true), null, new Long(1L), "", new Long(1L), null, null,
					null, null, null,"", null, null);
			Boolean isActive = new Boolean(true);
			fixture.setIsActive(isActive);

		}

		@Test
		public void testSetCreatedBy_1() throws Exception {
			Violation fixture =  new Violation("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", null,
					null, null, null, null, "", "", new Boolean(true), null, new Long(1L), "", new Long(1L), null, null,
					null, null, null,"", null, null);
			String createdBy = "";

			fixture.setCreatedBy(createdBy);

		}

		@Test
		public void testSetCreatedTime_1() throws Exception {
			Violation fixture =  new Violation("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", null,
					null, null, null, null, "", "", new Boolean(true), null, new Long(1L), "", new Long(1L), null, null,
					null, null, null,"", null, null);
			Long createdTime = new Long(1L);

			fixture.setCreatedTime(createdTime);

		}

		@Test
		public void testSetLastModifiedBy_1() throws Exception {
			Violation fixture =  new Violation("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", null,
					null, null, null, null, "", "", new Boolean(true), null, new Long(1L), "", new Long(1L), null, null,
					null, null, null,"", null, null);
			String lastModifiedBy = "";
			fixture.setLastModifiedBy(lastModifiedBy);

		}

		@Test
		public void testSetLastModifiedTime_1() throws Exception {
			Violation fixture =  new Violation("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", null,
					null, null, null, null, "", "", new Boolean(true), null, new Long(1L), "", new Long(1L), null, null,
					null, null, null,"", null, null);
			Long lastModifiedTime = new Long(1L);
			fixture.setLastModifiedTime(lastModifiedTime);

		}
		
		@Test
		public void testSetDocument_1() throws Exception {
			Violation fixture =  new Violation("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", null,
					null, null, null, null, "", "", new Boolean(true), null, new Long(1L), "", new Long(1L), null, null,
					null, null, null,"", null, null);
			List<Document> document = null;
			fixture.setDocument(document);

		}
		
		@Test
		public void testSetViolationItem_1() throws Exception {
			Violation fixture =  new Violation("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", null,
					null, null, null, null, "", "", new Boolean(true), null, new Long(1L), "", new Long(1L), null, null,
					null, null, null,"", null, null);
			List<ViolationItem> violationItem = null;
			fixture.setViolationItem(violationItem);

		}
		
			@Test
		public void testSetNotificationTemplate_1() throws Exception {
			Violation fixture =  new Violation("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", null,
					null, null, null, null, "", "", new Boolean(true), null, new Long(1L), "", new Long(1L), null, null,
					null, null, null,"", null, null);
			NotificationTemplate notificationTemplate = null;
			fixture.setNotificationTemplate(notificationTemplate);

		}
		
		@Test
		public void testSetChallanDetails_1() throws Exception {
			Violation fixture =  new Violation("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", null,
					null, null, null, null, "", "", new Boolean(true), null, new Long(1L), "", new Long(1L), null, null,
					null, null, null,"", null, null);
			List<ChallanDetails> challanDetails = null;
			fixture.setChallanDetails(challanDetails);

		}
		
			@Test
		public void testSetPaymentDetails_1() throws Exception {
			Violation fixture =  new Violation("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", null,
					null, null, null, null, "", "", new Boolean(true), null, new Long(1L), "", new Long(1L), null, null,
					null, null, null,"", null, null);
			EcPayment paymentDetails = null;
			fixture.setPaymentDetails(paymentDetails);

		}
			
			@Test
			public void testSetSourceUuid_1() throws Exception {
				Violation fixture =  new Violation("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", null,
						null, null, null, null, "", "", new Boolean(true), null, new Long(1L), "", new Long(1L), null, null,
						null, null, null,"", null, null);
				String sourceUuid = "";
				fixture.setSourceUuid(sourceUuid);

			}
			
			@Test
			public void testGetSourceUuid_1() throws Exception {
				Violation fixture =  new Violation("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", null,
						null, null, null, null, "", "", new Boolean(true), null, new Long(1L), "", new Long(1L), null, null,
						null, null, null,"", null, null);

				String result = fixture.getSourceUuid();

				assertEquals("", result);
			}
			
			@Test
			public void testGetFromDate_1() throws Exception {
				Violation fixture =  new Violation("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", null,
						null, null, null, null, "", "", new Boolean(true), null, new Long(1L), "", new Long(1L), null, null,
						null, null, null,"", null, null);

				Date result = fixture.getFromDate();

				assertEquals(null, result);
			}
			
			@Test
			public void testGetToDate_1() throws Exception {
				Violation fixture =  new Violation();

				Date result = fixture.getToDate();

				assertEquals(null, result);
			}
			
			@Test
			public void testSetFromDate_1() throws Exception {
				Violation fixture =  new Violation();
				Date fromDate = null;
				fixture.setFromDate(fromDate);

			}
			
			@Test
			public void testSetToDate_1() throws Exception {
				Violation fixture =  new Violation("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", null,
						null, null, null, null, "", "", new Boolean(true), null, new Long(1L), "", new Long(1L), null, null,
						null, null, null,"", null, null);
				Date toDate = null;
				fixture.setToDate(toDate);

			}
		
}
