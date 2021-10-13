package org.egov.hc.model;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ServicerequestTest {

	@InjectMocks
	private ServiceRequestData servicerequest;

	AuditDetails audit = new AuditDetails("94", "94", 1589648251485L, 1589648251485L);

	@Test
	public void testService_request_uuid() {
		servicerequest.setService_request_uuid("c1d197d5-17c0-40d0-afc6-3096339575ad");
		Assert.assertEquals("c1d197d5-17c0-40d0-afc6-3096339575ad", servicerequest.getService_request_uuid());
	}

	@Test
	public void testOwnerName() {
		servicerequest.setOwnerName("dhanaji");
		Assert.assertEquals("dhanaji", servicerequest.getOwnerName());
	}

	@Test
	public void testTenantId() {
		servicerequest.setTenantId("ch");
		Assert.assertEquals("ch", servicerequest.getTenantId());
	}

	@Test
	public void testAddress() {
		servicerequest.setAddress("pune");
		Assert.assertEquals("pune", servicerequest.getAddress());
	}

	@Test
	public void testLatitude() {
		servicerequest.setLatitude("30.743085");
		Assert.assertEquals("30.743085", servicerequest.getLatitude());
	}

	@Test
	public void testLongitude() {
		servicerequest.setLongitude("76.786507");
		Assert.assertEquals("76.786507", servicerequest.getLongitude());
	}

	@Test
	public void testCity() {
		servicerequest.setHouseNoAndStreetName("AMBEDKAR_AWAS_YOJNA");
		Assert.assertEquals("AMBEDKAR_AWAS_YOJNA", servicerequest.getHouseNoAndStreetName());
	}

	@Test
	public void testMohalla() {
		servicerequest.setMohalla("AMBEDKAR_AWAS_YOJNA");
		Assert.assertEquals("AMBEDKAR_AWAS_YOJNA", servicerequest.getMohalla());
	}

	@Test
	public void testLandmark() {
		servicerequest.setLandmark("TEst landmark");
		Assert.assertEquals("TEst landmark", servicerequest.getLandmark());
	}

	@Test
	public void testContactNumber() {
		servicerequest.setContactNumber("9811165595");
		Assert.assertEquals("9811165595", servicerequest.getContactNumber());
	}

	@Test
	public void testEmail() {
		servicerequest.setContactNumber("9811165595");
		Assert.assertEquals("9811165595", servicerequest.getContactNumber());
	}

	@Test
	public void testTreeCount() {
		servicerequest.setTreeCount(new Long(8));
		Assert.assertEquals(new Long(8), servicerequest.getTreeCount());
	}

	@Test
	public void testService_request_date() {
		servicerequest.setService_request_date("13/05/2020");
		Assert.assertEquals("13/05/2020", servicerequest.getService_request_date());
	}

	@Test
	public void testService_request_status() {
		servicerequest.setService_request_status("INITIATED");
		Assert.assertEquals("INITIATED", servicerequest.getService_request_status());
	}

	@Test
	public void testService_request_id() {
		servicerequest.setService_request_id("123114");
		Assert.assertEquals("123114", servicerequest.getService_request_id());
	}

	@Test
	public void testServiceType() {
		servicerequest.setServiceType("dead tree");
		Assert.assertEquals("dead tree", servicerequest.getServiceType());
	}

	@Test
	public void testDescription() {
		servicerequest.setDescription("Testing of Complaint");
		Assert.assertEquals("Testing of Complaint", servicerequest.getDescription());
	}


	@Test
	public void testGetCreatedBy() {
		servicerequest.setCreatedBy("pqr");
		Assert.assertEquals("pqr", servicerequest.getCreatedBy());
	}

	@Test
	public void testGetLastModifiedBy() {
		servicerequest.setLastModifiedBy("pqr");
		Assert.assertEquals("pqr", servicerequest.getLastModifiedBy());
	}

	@Test
	public void testGetAccountId() {
		servicerequest.setAccountId("sdal1244");
		Assert.assertEquals("sdal1244", servicerequest.getAccountId());
	}

	@Test
	public void testAddressDetail() {
		servicerequest.setAddressDetail(new AddressDetail());
		Assert.assertEquals(new AddressDetail(), servicerequest.getAddressDetail());
	}

	/*
	 * @Test public void testServiceRequestAddtionalDetails() {
	 * servicerequest.setServiceRequestAddtionalDetails("dead tree");
	 * Assert.assertEquals("dead tree",
	 * servicerequest.getServiceRequestAddtionalDetails()); }
	 */

	@Test
	public void testActive() {
		servicerequest.setActive(true);
		Assert.assertEquals(true, servicerequest.getActive());
	}

}
