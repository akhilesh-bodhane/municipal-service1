package org.egov.pm.model;

import static org.junit.Assert.*;

import org.egov.common.contract.response.ResponseInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import junit.framework.Assert;

@RunWith(MockitoJUnitRunner.class)
public class ErrorsTestCases {

	@InjectMocks
	private Errors errors;

	@Test
	public void testErrors() {
		Errors.ErrorsBuilder arr = new Errors.ErrorsBuilder();
		arr.responseInfo(ResponseInfo.builder().status("success").build());
		arr.error(ErrorResponseInfo.builder().code("code").build());
		arr.toString();

		Errors.ErrorsBuilder arr2 = new Errors.ErrorsBuilder();
		arr2.responseInfo(ResponseInfo.builder().status("success").build());
		arr2.error(ErrorResponseInfo.builder().code("code").build());
		arr2.toString();
		Assert.assertEquals(arr.getClass(), arr2.getClass());
	}

	@Test
	public void testBuilder() {
		ResponseInfo responseInfo = new ResponseInfo();
		responseInfo.setStatus("success");
		Errors errors1 = errors.builder().responseInfo(responseInfo).build();
		Assert.assertEquals("success", errors1.getResponseInfo().getStatus());
	}

	@Test
	public void testGetResponseInfo() {
		ResponseInfo responseInfo = new ResponseInfo();
		responseInfo.setStatus("success");
		errors.setResponseInfo(responseInfo);
		Assert.assertEquals("success", errors.getResponseInfo().getStatus());
	}

	@Test
	public void testGetError() {
		ErrorResponseInfo error = new ErrorResponseInfo("code", "message", "description", "params");
		errors.setError(error);
		Assert.assertEquals("code", errors.getError().getCode());
	}

}
