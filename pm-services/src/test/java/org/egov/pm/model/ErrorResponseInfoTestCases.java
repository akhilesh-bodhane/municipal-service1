package org.egov.pm.model;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import junit.framework.Assert;

@RunWith(MockitoJUnitRunner.class)
public class ErrorResponseInfoTestCases {

	@InjectMocks
	private ErrorResponseInfo errorResponseInfo;

	@Test
	public void testErrorResponseInfoBuilder() {
		ErrorResponseInfo.ErrorResponseInfoBuilder as1 = new ErrorResponseInfo.ErrorResponseInfoBuilder();
		as1.code("code");
		as1.description("description");
		as1.message("message");
		as1.params("params");
		as1.toString();
		ErrorResponseInfo.ErrorResponseInfoBuilder as2 = new ErrorResponseInfo.ErrorResponseInfoBuilder();
		as2.code("code");
		as2.description("description");
		as2.message("message");
		as2.params("params");
		as2.toString();
		Assert.assertEquals(as1.getClass(), as2.getClass());
	}

	@Test
	public void testBuilder() {
		ErrorResponseInfo a = errorResponseInfo.builder().code("code").build();
		Assert.assertEquals("code", a.getCode());
	}

	@Test
	public void testGetCode() {
		errorResponseInfo.setCode("code");
		Assert.assertEquals("code", errorResponseInfo.getCode());
	}

	@Test
	public void testGetMessage() {
		errorResponseInfo.setMessage("message");
		Assert.assertEquals("message", errorResponseInfo.getMessage());
	}

	@Test
	public void testGetDescription() {
		errorResponseInfo.setDescription("description");
		Assert.assertEquals("description", errorResponseInfo.getDescription());
	}

	@Test
	public void testGetParams() {
		errorResponseInfo.setParams("params");
		org.junit.Assert.assertEquals("params", errorResponseInfo.getParams());
	}

}
