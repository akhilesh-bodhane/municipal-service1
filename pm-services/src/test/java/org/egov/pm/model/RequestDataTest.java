package org.egov.pm.model;

import static org.junit.Assert.*;

import org.egov.common.contract.request.RequestInfo;
import org.json.simple.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import junit.framework.Assert;

@RunWith(MockitoJUnitRunner.Silent.class)
public class RequestDataTest {

	@InjectMocks
	private RequestData requestData;

	@Test
	public void testBuilder() {
		RequestData requestData2 = RequestData.builder().build();
	}

	@Test
	public void testGetRequestInfo() {
		requestData.setRequestInfo(RequestInfo.builder().action("request").build());
		Assert.assertEquals("request", requestData.getRequestInfo().getAction());
	}

	@Test
	public void testGetApplicationType() {
		requestData.setApplicationType("NOCTYPE");
		Assert.assertEquals("NOCTYPE", requestData.getApplicationType());
	}

	@Test
	public void testGetTenantId() {
		requestData.setTenantId("ch");
		Assert.assertEquals("ch", requestData.getTenantId());
	}

	@Test
	public void testGetApplicationStatus() {
		requestData.setApplicationStatus("APPROVED");
		Assert.assertEquals("APPROVED", requestData.getApplicationStatus());
	}

	@Test
	public void testGetApplicationId() {
		requestData.setApplicationId("asdff3iu2hficnu39");
		Assert.assertEquals("asdff3iu2hficnu39", requestData.getApplicationId());
	}

	@Test
	public void testGetActions() {
		requestData.setActions("actions");
		Assert.assertEquals("actions", requestData.getActions());
	}

	@Test
	public void testGetDataPayload() {
		JSONObject dataPayload = new JSONObject();
		requestData.setDataPayload(dataPayload);
		Assert.assertEquals(dataPayload, requestData.getDataPayload());
	}

	@Test
	public void testGetAuditDetails() {
		AuditDetail auditDetails = new AuditDetail();
		requestData.setAuditDetails(auditDetails);
		Assert.assertEquals(auditDetails, requestData.getAuditDetails());
	}

	@Test
	public void testRequestDataRequestInfoStringStringStringStringStringJSONObjectAuditDetail() {
		RequestData requestData2 = new RequestData(null, "NOCTYPE", "", "", "", "", null, null, null);
		Assert.assertEquals("NOCTYPE", requestData2.getApplicationType());
	}

	@Test
	public void testRequestData() {
		RequestData requestData2 = new RequestData();
		requestData2.setApplicationType("NOCTYPE");
		Assert.assertEquals("NOCTYPE", requestData2.getApplicationType());
	}

	@Test
	public void testBuilder_2() {
		RequestData.RequestDataBuilder requestData2 = new RequestData.RequestDataBuilder();
		requestData2.actions("actions");
		requestData2.tenantId("ch");
		requestData2.applicationId("asfasf23f4f");
		requestData2.applicationStatus("APPROVED");
		requestData2.applicationType("APPROVED");
		requestData2.auditDetails(new AuditDetail());
		requestData2.dataPayload(new JSONObject());
		requestData2.requestInfo(RequestInfo.builder().build());
		requestData2.build();

		String str = requestData2.toString();
		Assert.assertEquals(str, requestData2.toString());

	}
}
