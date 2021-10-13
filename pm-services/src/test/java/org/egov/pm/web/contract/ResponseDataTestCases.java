package org.egov.pm.web.contract;

import static org.junit.Assert.*;

import org.egov.common.contract.response.ResponseInfo;
import org.egov.pm.model.AuditDetail;
import org.json.simple.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import junit.framework.Assert;

@RunWith(MockitoJUnitRunner.Silent.class)
public class ResponseDataTestCases {

	@InjectMocks
	private ResponseData responseData;

	@Test
	public void testBuilder() {
		responseData.builder().build();
	}

	@Test
	public void testGetResponseInfo() {
		responseData.setResponseInfo(ResponseInfo.builder().status("success").build());
		Assert.assertEquals("success", responseData.getResponseInfo().getStatus());
	}

	@Test
	public void testGetApplicationType() {
		responseData.setApplicationType("NOCTYPE");
		Assert.assertEquals("NOCTYPE", responseData.getApplicationType());
	}

	@Test
	public void testGetTenantId() {
		responseData.setTenantId("ch");
		Assert.assertEquals("ch", responseData.getTenantId());
	}

	@Test
	public void testGetApplicationStatus() {
		responseData.setApplicationStatus("APPROVED");
		Assert.assertEquals("APPROVED", responseData.getApplicationStatus());
	}

	@Test
	public void testGetApplicationId() {
		responseData.setApplicationId("PMS-12-12-2020-15454");
		Assert.assertEquals("PMS-12-12-2020-15454", responseData.getApplicationId());
	}

	@Test
	public void testGetDataPayload() {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("applicantName", "Prakash Hadgal");
		responseData.setDataPayload(jsonObject);
		Assert.assertEquals("Prakash Hadgal", responseData.getDataPayload().get("applicantName"));
	}

	@Test
	public void testGetAuditDetails() {
		AuditDetail auditDetails = new AuditDetail();
		auditDetails.setCreatedBy("123456");
		responseData.setAuditDetails(auditDetails);
		Assert.assertEquals("123456", responseData.getAuditDetails().getCreatedBy());
	}

	@Test
	public void testResponseDataResponseInfoStringStringStringStringJSONObjectAuditDetail() {
		ResponseData.ResponseDataBuilder builder = new ResponseData.ResponseDataBuilder();
		builder.applicationId("PMS-12-12-2020-215455");
		builder.applicationStatus("APPROVED");
		builder.applicationType("NOCTYPE");
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("applicantName", "Prakash Hadgal");
		builder.dataPayload(jsonObject);
		builder.auditDetails(null);
		builder.tenantId("ch");
		builder.responseInfo(ResponseInfo.builder().status("success").build());

		ResponseData.ResponseDataBuilder builder2 = new ResponseData.ResponseDataBuilder();
		builder2.applicationId("PMS-12-12-2020-215455");
		builder2.applicationStatus("APPROVED");
		builder2.applicationType("NOCTYPE");
		builder2.dataPayload(jsonObject);
		builder2.auditDetails(null);
		builder2.tenantId("ch");
		builder2.responseInfo(ResponseInfo.builder().status("success").build());
		Assert.assertEquals(builder.toString(), builder2.toString());
	}

	@Test
	public void testResponseData() {
		ResponseData data = new ResponseData();
		data.setApplicationId("PMS-12-12-2020-15454");
		responseData.setApplicationId("PMS-12-12-2020-15454");
		Assert.assertEquals(responseData.getApplicationId(), data.getApplicationId());
	}

}
