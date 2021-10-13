package org.egov.ec.service.validator;

public interface CustomBeanValidator {
	public <T> void validateFields(T object);
}
