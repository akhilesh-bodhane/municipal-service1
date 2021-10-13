package org.egov.ec.web.models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.egov.ec.web.models.VendorRegistration;
import org.junit.Assert;
import org.junit.Test;

public class VendorRegistrationTest {

	/**
	 * Run the VendorRegistration() constructor test.
	 *
	 * @throws Exception
	 *
	 *                   at 30/4/20 5:39 AM
	 */
	@Test
	public void testVendorRegistration_1() throws Exception {

		VendorRegistration result = new VendorRegistration();

		assertNotNull(result);
		assertEquals(null, result.getVendorUuid());
		assertEquals(null, result.getPassNo());
		assertEquals(null, result.getCovNo());
		assertEquals(null, result.getName());
		assertEquals(null, result.getFatherSpouseName());
		assertEquals(null, result.getAddress());
		assertEquals(null, result.getContactNumber());
		assertEquals(null, result.getVendorCategory());
		assertEquals(null, result.getStreetVendorArea());
		assertEquals(null, result.getTransportMode());
		assertEquals(null, result.getIsActive());
		assertEquals(null, result.getCreatedBy());
		assertEquals(null, result.getCreatedTime());
		assertEquals(null, result.getLastModifiedBy());
		assertEquals(null, result.getLastModifiedTime());
		assertEquals(null, result.getTenantId());
		assertEquals(null, result.getVendorRegistrationList());
		assertEquals(null, result.getSourceUuid());
		assertEquals(null, result.getNumberOfViolation());
	}

	/**
	 * Run the
	 * VendorRegistration(String,String,String,String,Long,String,Long,Boolean,String)
	 * constructor test.
	 *
	 * @throws Exception
	 *
	 *                   at 30/04/20 1:32 PM
	 */
	@Test
	public void testVendorRegistration_2() throws Exception {
		String vendorUuid = "";
		String passNo = "";
		String covNo = "";
		String name = "";
		String fatherSpouseName = null;
		String address = null;
		String contactNumber = null;
		String vendorCategory = null;
		String streetVendorArea = null;
		String transportMode = null;
		Boolean isActive = new Boolean(true);
		Long lastModifiedTime = new Long(1L);
		String createdBy = "";
		Long createdTime = new Long(1L);
		String lastModifiedBy = "";
		String tenantId = "";
		String sourceUuid="";
		List<VendorRegistration> vendorRegistrationList = null;
		String numberOfViolation="";

		VendorRegistration result = new VendorRegistration(vendorUuid, passNo, covNo, name, fatherSpouseName, address,
				contactNumber, vendorCategory, streetVendorArea, transportMode, isActive, createdBy, createdTime,
				lastModifiedBy, lastModifiedTime, vendorRegistrationList, tenantId, sourceUuid, numberOfViolation);

		assertNotNull(result);
		assertEquals("", result.getVendorUuid());
		assertEquals("", result.getPassNo());
		assertEquals("", result.getCovNo());
		assertEquals("", result.getName());
		assertEquals(null, result.getFatherSpouseName());
		assertEquals(null, result.getAddress());
		assertEquals(null, result.getContactNumber());
		assertEquals(null, result.getVendorCategory());
		assertEquals(null, result.getStreetVendorArea());
		assertEquals(null, result.getTransportMode());
		assertEquals(Boolean.TRUE, result.getIsActive());
		assertEquals("", result.getLastModifiedBy());
		assertEquals(new Long(1L), (result.getLastModifiedTime()));
		assertEquals("", result.getCreatedBy());
		assertEquals(new Long(1L), result.getCreatedTime());
		assertEquals("", result.getLastModifiedBy());
		assertEquals(null, result.getVendorRegistrationList());
		assertEquals("", result.getTenantId());
		assertEquals("", result.getSourceUuid());
		assertEquals("", result.getNumberOfViolation());
	}

	/**
	 * Run the VendorRegistration.VendorRegistrationBuilder builder() method test.
	 *
	 * @throws Exception
	 *
	 *                   at 30/04/20 1:32 PM
	 */
	@Test
	public void testBuilder_1() throws Exception {

		VendorRegistration.VendorRegistrationBuilder result = VendorRegistration.builder();

		assertNotNull(result);
		assertEquals(
				"VendorRegistration.VendorRegistrationBuilder(vendorUuid=null, passNo=null, covNo=null, name=null, fatherSpouseName=null, address=null, contactNumber=null, vendorCategory=null, streetVendorArea=null, transportMode=null, isActive=null, createdBy=null, createdTime=null, lastModifiedBy=null, lastModifiedTime=null, vendorRegistrationList=null, tenantId=null, sourceUuid=null, numberOfViolation=null)",
				result.toString());
	}

	/**
	 * Run the VendorRegistration.VendorRegistrationBuilder builder() method test.
	 *
	 * @throws Exception
	 *
	 *                   at 30/04/20 1:32 PM
	 */
	@Test
	public void testBuilder_2() throws Exception {

		VendorRegistration.VendorRegistrationBuilder builder = new VendorRegistration.VendorRegistrationBuilder();
		builder.vendorUuid(null);
		builder.passNo(null);
		builder.covNo(null);
		builder.name(null);
		builder.fatherSpouseName(null);
		builder.address(null);
		builder.contactNumber(null);
		builder.vendorCategory(null);
		builder.streetVendorArea(null);
		builder.transportMode(null);
		builder.isActive(null);
		builder.createdBy(null);
		builder.createdTime(null);
		builder.lastModifiedBy(null);
		builder.lastModifiedTime(null);
		builder.vendorRegistrationList(null);
		builder.tenantId(null);
		builder.sourceUuid(null);
		builder.numberOfViolation(null);
		builder.build();

		VendorRegistration.VendorRegistrationBuilder builder2 = new VendorRegistration.VendorRegistrationBuilder();
		builder2.vendorUuid(null);
		builder2.passNo(null);
		builder2.covNo(null);
		builder2.name(null);
		builder2.fatherSpouseName(null);
		builder2.address(null);
		builder2.contactNumber(null);
		builder2.vendorCategory(null);
		builder2.streetVendorArea(null);
		builder2.transportMode(null);
		builder2.isActive(null);
		builder2.createdBy(null);
		builder2.createdTime(null);
		builder2.lastModifiedBy(null);
		builder2.lastModifiedTime(null);
		builder2.vendorRegistrationList(null);
		builder2.tenantId(null);
		builder2.sourceUuid(null);
		builder2.numberOfViolation(null);
		builder2.build();

		Assert.assertEquals(builder2.toString(), builder.toString());
	}

	@Test
	public void testGetVendorUuid_1() throws Exception {
		VendorRegistration fixture = new VendorRegistration("", "", "", "", null, null, null, null, null, null,
				new Boolean(true), null, new Long(1L), "", new Long(1L), null,null,"","");
		String result = fixture.getVendorUuid();
		assertEquals("", result);
	}

	@Test
	public void testGetPassNo_1() throws Exception {
		VendorRegistration fixture = new VendorRegistration("", "", "", "", null, null, null, null, null, null,
				new Boolean(true), null, new Long(1L), "", new Long(1L), null,null,"","");
		String result = fixture.getPassNo();
		assertEquals("", result);
	}

	@Test
	public void testGetCovNo_1() throws Exception {
		VendorRegistration fixture = new VendorRegistration("", "", "", "", null, null, null, null, null, null,
				new Boolean(true), null, new Long(1L), "", new Long(1L), null,null,"","");
		String result = fixture.getCovNo();
		assertEquals("", result);
	}

	@Test
	public void testGetName_1() throws Exception {
		VendorRegistration fixture = new VendorRegistration("", "", "", "", null, null, null, null, null, null,
				new Boolean(true), null, new Long(1L), "", new Long(1L), null,null,"","");
		String result = fixture.getName();
		assertEquals("", result);
	}

	@Test
	public void testGetFatherSpouseName_1() throws Exception {
		VendorRegistration fixture = new VendorRegistration("", "", "", "", null, null, null, null, null, null,
				new Boolean(true), null, new Long(1L), "", new Long(1L), null,null,"","");
		String result = fixture.getFatherSpouseName();
		assertEquals(null, result);
	}

	@Test
	public void testGetAddress_1() throws Exception {
		VendorRegistration fixture = new VendorRegistration("", "", "", "", null, null, null, null, null, null,
				new Boolean(true), null, new Long(1L), "", new Long(1L), null,null,"","");
		String result = fixture.getAddress();
		assertEquals(null, result);
	}

	@Test
	public void testGetVendorCategory_1() throws Exception {
		VendorRegistration fixture = new VendorRegistration("", "", "", "", null, null, null, null, null, null,
				new Boolean(true), null, new Long(1L), "", new Long(1L), null,null,"","");
		String result = fixture.getVendorCategory();
		assertEquals(null, result);
	}

	@Test
	public void testGetStreetVendorArea_1() throws Exception {
		VendorRegistration fixture = new VendorRegistration("", "", "", "", null, null, null, null, null, null,
				new Boolean(true), null, new Long(1L), "", new Long(1L), null,null,"","");
		String result = fixture.getStreetVendorArea();
		assertEquals(null, result);
	}

	@Test
	public void testGetTransportMode_1() throws Exception {
		VendorRegistration fixture = new VendorRegistration("", "", "", "", null, null, null, null, null, null,
				new Boolean(true), null, new Long(1L), "", new Long(1L), null,null,"","");
		String result = fixture.getTransportMode();
		assertEquals(null, result);
	}

	@Test
	public void testGetIsActive_1() throws Exception {
		VendorRegistration fixture = new VendorRegistration("", "", "", "", null, null, null, null, null, null,
				new Boolean(true), null, new Long(1L), "", new Long(1L), null,null,"","");
		Boolean result = fixture.getIsActive();

		assertNotNull(result);
		assertEquals("true", result.toString());
		assertEquals(true, result.booleanValue());
	}

	@Test
	public void testGetCreatedBy_1() throws Exception {
		VendorRegistration fixture = new VendorRegistration("", "", "", "", null, null, null, null, null, null,
				new Boolean(true), null, new Long(1L), "", new Long(1L), null,null,"","");

		String result = fixture.getCreatedBy();

		assertEquals(null, result);
	}

	@Test
	public void testGetCreatedTime_1() throws Exception {
		VendorRegistration fixture = new VendorRegistration("", "", "", "", null, null, null, null, null, null,
				new Boolean(true), null, new Long(1L), "", new Long(1L), null,null,"","");

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
		VendorRegistration fixture = new VendorRegistration("", "", "", "", null, null, null, null, null, null,
				new Boolean(true), null, new Long(1L), "", new Long(1L), null,null,"","");

		String result = fixture.getLastModifiedBy();

		assertEquals("", result);
	}

	@Test
	public void testGetLastModifiedTime_1() throws Exception {
		VendorRegistration fixture = new VendorRegistration("", "", "", "", null, null, null, null, null, null,
				new Boolean(true), null, new Long(1L), "", new Long(1L), null,null,"","");

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
	public void testGetRegistrationList_1() throws Exception {
		VendorRegistration fixture = new VendorRegistration("", "", "", "", null, null, null, null, null, null,
				new Boolean(true), null, new Long(1L), "", new Long(1L), null,null,"","");
		List<VendorRegistration> result = fixture.getVendorRegistrationList();
		assertEquals(null, result);
	}
	
	@Test
	public void testGetTenantId_1() throws Exception {
		VendorRegistration fixture = new VendorRegistration("", "", "", "", null, null, null, null, null, null,
				new Boolean(true), null, new Long(1L), "", new Long(1L), null,null,"","");
		String result = fixture.getTenantId();
		assertEquals(null, result);
	}
	
	
	@Test
	public void testSetVendorUuid_1() throws Exception {
		VendorRegistration fixture = new VendorRegistration("", "", "", "", null, null, null, null, null, null,
				new Boolean(true), null, new Long(1L), "", new Long(1L), null,null,"","");
		String vendorUuid = "";
		fixture.setVendorUuid(vendorUuid);

	}
	
	@Test
	public void testSetPassNo_1() throws Exception {
		VendorRegistration fixture = new VendorRegistration("", "", "", "", null, null, null, null, null, null,
				new Boolean(true), null, new Long(1L), "", new Long(1L), null,null,"","");
		String passNo = "";
		fixture.setPassNo(passNo);

	}

	@Test
	public void testSetCovNo_1() throws Exception {
		VendorRegistration fixture = new VendorRegistration("", "", "", "", null, null, null, null, null, null,
				new Boolean(true), null, new Long(1L), "", new Long(1L), null,null,"","");
		String covNo = "";
		fixture.setCovNo(covNo);

	}
	
	@Test
	public void testSetName_1() throws Exception {
		VendorRegistration fixture = new VendorRegistration("", "", "", "", null, null, null, null, null, null,
				new Boolean(true), null, new Long(1L), "", new Long(1L), null,null,"","");
		String name = "";
		fixture.setName(name);
	}
	
	@Test
	public void testSetFatherSpouseName_1() throws Exception {
		VendorRegistration fixture = new VendorRegistration("", "", "", "", null, null, null, null, null, null,
				new Boolean(true), null, new Long(1L), "", new Long(1L), null,null,"","");
		String fatherSpouseName = "";
		fixture.setFatherSpouseName(fatherSpouseName);
	}
	
	@Test
	public void testSetAddress_1() throws Exception {
		VendorRegistration fixture = new VendorRegistration("", "", "", "", null, null, null, null, null, null,
				new Boolean(true), null, new Long(1L), "", new Long(1L), null,null,"","");
		String address = "";
		fixture.setAddress(address);;
	}
	
	@Test
	public void testSetContactNumber_1() throws Exception {
		VendorRegistration fixture = new VendorRegistration("", "", "", "", null, null, null, null, null, null,
				new Boolean(true), null, new Long(1L), "", new Long(1L), null,null,"","");
		String contactNumber = "";
		fixture.setContactNumber(contactNumber);
	}
	
	@Test
	public void testSetVendorCategory_1() throws Exception {
		VendorRegistration fixture = new VendorRegistration("", "", "", "", null, null, null, null, null, null,
				new Boolean(true), null, new Long(1L), "", new Long(1L), null,null,"","");
		String vendorCategory = "";
		fixture.setVendorCategory(vendorCategory);
	}
	
	@Test
	public void testSetStreetVendorArea_1() throws Exception {
		VendorRegistration fixture = new VendorRegistration("", "", "", "", null, null, null, null, null, null,
				new Boolean(true), null, new Long(1L), "", new Long(1L), null,null,"","");
		String streetVendorArea = "";
		fixture.setStreetVendorArea(streetVendorArea);
	}
	
	@Test
	public void testSetTransportMode_1() throws Exception {
		VendorRegistration fixture = new VendorRegistration("", "", "", "", null, null, null, null, null, null,
				new Boolean(true), null, new Long(1L), "", new Long(1L), null,null,"","");
		String transportMode = "";
		fixture.setTransportMode(transportMode);
	}
	
	
	@Test
	public void testSetIsActive_1() throws Exception {
		VendorRegistration fixture = new VendorRegistration("", "", "", "", null, null, null, null, null, null,
				new Boolean(true), null, new Long(1L), "", new Long(1L), null,null,"","");
		Boolean isActive = new Boolean(true);
		fixture.setIsActive(isActive);

	}


	@Test
	public void testSetCreatedBy_1() throws Exception {
		VendorRegistration fixture = new VendorRegistration("", "", "", "", null, null, null, null, null, null,
				new Boolean(true), null, new Long(1L), "", new Long(1L), null,null,"","");
		String createdBy = "";

		fixture.setCreatedBy(createdBy);

	}


	@Test
	public void testSetCreatedTime_1() throws Exception {
		VendorRegistration fixture = new VendorRegistration("", "", "", "", null, null, null, null, null, null,
				new Boolean(true), null, new Long(1L), "", new Long(1L), null,null,"","");
		Long createdTime = new Long(1L);

		fixture.setCreatedTime(createdTime);

	}


	@Test
	public void testSetLastModifiedBy_1() throws Exception {
		VendorRegistration fixture = new VendorRegistration("", "", "", "", null, null, null, null, null, null,
				new Boolean(true), null, new Long(1L), "", new Long(1L), null,null,"","");
		String lastModifiedBy = "";
		fixture.setLastModifiedBy(lastModifiedBy);

	}

	@Test
	public void testSetLastModifiedTime_1() throws Exception {
		VendorRegistration fixture = new VendorRegistration("", "", "", "", null, null, null, null, null, null,
				new Boolean(true), null, new Long(1L), "", new Long(1L), null,null,"","");
		Long lastModifiedTime = new Long(1L);
		fixture.setLastModifiedTime(lastModifiedTime);

	}
	
	@Test
	public void testSetVendorRegistrationList_1() throws Exception {
		VendorRegistration fixture = new VendorRegistration("", "", "", "", null, null, null, null, null, null,
				new Boolean(true), null, new Long(1L), "", new Long(1L), null,null,"","");
		List<VendorRegistration> vendorRegistrationList = null;
		fixture.setVendorRegistrationList(vendorRegistrationList);

	}
	
	@Test
	public void testSetTenantId_1() throws Exception {
		VendorRegistration fixture = new VendorRegistration("", "", "", "", null, null, null, null, null, null,
				new Boolean(true), null, new Long(1L), "", new Long(1L), null,null,"","");
		String tenantId = null;
		fixture.setTenantId(tenantId);

	}
	
	@Test
	public void testSetSourceUuid_1() throws Exception {
		VendorRegistration fixture = new VendorRegistration("", "", "", "", null, null, null, null, null, null,
				new Boolean(true), null, new Long(1L), "", new Long(1L), null,null,"","");
		String sourceUuid = "";
		fixture.setSourceUuid(sourceUuid);

	}
	
	@Test
	public void testGetSourceUuid_1() throws Exception {
		VendorRegistration fixture = new VendorRegistration("", "", "", "", null, null, null, null, null, null,
				new Boolean(true), null, new Long(1L), "", new Long(1L), null,null,"","");

		String result = fixture.getSourceUuid();

		assertEquals("", result);
	}
	
	@Test
	public void testSetNumberOfViolation_1() throws Exception {
		VendorRegistration fixture = new VendorRegistration("", "", "", "", null, null, null, null, null, null,
				new Boolean(true), null, new Long(1L), "", new Long(1L), null,null,"","");
		String numberOfViolation = "";
		fixture.setNumberOfViolation(numberOfViolation);

	}
	
	@Test
	public void testGetNumberOfViolation_1() throws Exception {
		VendorRegistration fixture = new VendorRegistration("", "", "", "", null, null, null, null, null, null,
				new Boolean(true), null, new Long(1L), "", new Long(1L), null,null,"","");

		String result = fixture.getNumberOfViolation();

		assertEquals("", result);
	}

}
