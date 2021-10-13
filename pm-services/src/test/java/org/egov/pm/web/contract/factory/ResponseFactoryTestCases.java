package org.egov.pm.web.contract.factory;

import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.egov.common.contract.request.RequestInfo;
import org.egov.common.contract.response.ErrorResponse;
import org.egov.common.contract.response.ResponseInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import junit.framework.Assert;

@RunWith(MockitoJUnitRunner.class)
public class ResponseFactoryTestCases {

	@InjectMocks
	private ResponseFactory responseFactory;

	@Test
	public void testGetResponseInfo() {
		ResponseInfo expected = responseFactory.getResponseInfo(RequestInfo.builder().action("Request").build(),
				HttpStatus.OK);
		Assert.assertEquals("200", expected.getStatus());
	}

/*	@Test
	public void testGetErrorResponse() {
		Errors errors = new Errors() {
			@Override
			public void setNestedPath(String nestedPath) {
				// TODO Auto-generated method stub

			}

			@Override
			public void rejectValue(String field, String errorCode, Object[] errorArgs, String defaultMessage) {
				// TODO Auto-generated method stub

			}

			@Override
			public void rejectValue(String field, String errorCode, String defaultMessage) {
				// TODO Auto-generated method stub

			}

			@Override
			public void rejectValue(String field, String errorCode) {
				// TODO Auto-generated method stub

			}

			@Override
			public void reject(String errorCode, Object[] errorArgs, String defaultMessage) {
				// TODO Auto-generated method stub

			}

			@Override
			public void reject(String errorCode, String defaultMessage) {
				// TODO Auto-generated method stub

			}

			@Override
			public void reject(String errorCode) {
				// TODO Auto-generated method stub

			}

			@Override
			public void pushNestedPath(String subPath) {
				// TODO Auto-generated method stub

			}

			@Override
			public void popNestedPath() throws IllegalStateException {
				// TODO Auto-generated method stub

			}

			@Override
			public boolean hasGlobalErrors() {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean hasFieldErrors(String field) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean hasFieldErrors() {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean hasErrors() {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public String getObjectName() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public String getNestedPath() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public List<ObjectError> getGlobalErrors() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public int getGlobalErrorCount() {
				// TODO Auto-generated method stub
				return 0;
			}

			@Override
			public ObjectError getGlobalError() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Object getFieldValue(String field) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Class<?> getFieldType(String field) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public List<FieldError> getFieldErrors(String field) {
				FieldError error = new FieldError("objectName", "field", "defaultMessage");
				List<FieldError> er = new ArrayList<FieldError>();
				er.add(error);
				return er;
			}

			@Override
			public List<FieldError> getFieldErrors() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public int getFieldErrorCount(String field) {
				// TODO Auto-generated method stub
				return 0;
			}

			@Override
			public int getFieldErrorCount() {
				// TODO Auto-generated method stub
				return 0;
			}

			@Override
			public FieldError getFieldError(String field) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public FieldError getFieldError() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public int getErrorCount() {
				// TODO Auto-generated method stub
				return 0;
			}

			@Override
			public List<ObjectError> getAllErrors() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public void addAllErrors(Errors errors) {
				// TODO Auto-generated method stub

			}
		};
		ErrorResponse errorResponse = responseFactory.getErrorResponse(errors,
				RequestInfo.builder().action("Request").build());
		Assert.assertEquals(errorResponse.getResponseInfo().getStatus(), errorResponse.getResponseInfo().getStatus());
	}*/

}
