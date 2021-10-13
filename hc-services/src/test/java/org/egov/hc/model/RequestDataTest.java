package org.egov.hc.model;

import org.egov.common.contract.request.RequestInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class RequestDataTest {

	@InjectMocks
	private RequestData requestData;

	RequestInfo info = new RequestInfo();

	@Test
	public void testTenantId() {
		requestData.setTenantId("ch");
		Assert.assertEquals("ch", requestData.getTenantId());
	}

	@Test
	public void testServiceType() {
		requestData.setServiceType("Pruning of Trees Girth less than or equal to 90 cms");
		Assert.assertEquals("Pruning of Trees Girth less than or equal to 90 cms", requestData.getServiceType());

		requestData.setServiceType("Pruning of Trees Girth greater than 90 cms");
		Assert.assertEquals("Pruning of Trees Girth greater than 90 cms", requestData.getServiceType());

		requestData.setServiceType("Removal of Overgrown/Green Trees");
		Assert.assertEquals("Removal of Overgrown/Green Trees", requestData.getServiceType());

		requestData.setServiceType("Removal of Dead/Dangerous/Dry Trees");
		Assert.assertEquals("Removal of Dead/Dangerous/Dry Trees", requestData.getServiceType());
	}

	@Test
	public void testServiceRequestStatus() {
		requestData.setServiceRequestStatus("SUBMITED");
		Assert.assertEquals("SUBMITED", requestData.getServiceRequestStatus());
	}

	@Test
	public void testService_request_id() {
		requestData.setService_request_id("CH-HC-2020-06-14-001432_1");
		Assert.assertEquals("CH-HC-2020-06-14-001432_1", requestData.getService_request_id());
	}

	@Test
	public void testFromDate() {
		requestData.setFromDate(new Long(1588550400000L));
		Assert.assertEquals(new Long(1588550400000L), requestData.getFromDate());
	}

	@Test
	public void testToDate() {
		requestData.setToDate(new Long(1588550400000L));
		Assert.assertEquals(new Long(1588550400000L), requestData.getToDate());
	}

	@Test
	public void testOwnerContactNumber() {
		requestData.setOwnerContactNumber("9811165595");
		Assert.assertEquals("9811165595", requestData.getOwnerContactNumber());
	}

	@Test
	public void testStreetName() {
		requestData.setStreetName("AMBEDKAR_AWAS_YOJNA");
		Assert.assertEquals("AMBEDKAR_AWAS_YOJNA", requestData.getStreetName());
	}

	@Test
	public void testActions() {
		requestData.setActions("REJECTED");
		Assert.assertEquals("REJECTED", requestData.getActions());

		requestData.setActions("APPROVED");
		Assert.assertEquals("APPROVED", requestData.getActions());
	}

	@Test
	public void testOffset() {
		requestData.setOffset(new Integer(0));
		Assert.assertEquals(new Integer(0), requestData.getOffset());
	}

	@Test
	public void testLimit() {
		requestData.setLimit(new Integer(10));
		Assert.assertEquals(new Integer(10), requestData.getLimit());
	}

	@Test
	public void testRequestInfo() {
		requestData.setRequestInfo(info);
		Assert.assertEquals(info, requestData.getRequestInfo());
	}

}
