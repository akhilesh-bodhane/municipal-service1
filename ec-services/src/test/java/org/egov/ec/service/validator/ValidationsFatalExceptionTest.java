package org.egov.ec.service.validator;

import org.egov.ec.service.validator.ValidationsFatalException;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

public class ValidationsFatalExceptionTest extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@InjectMocks
	private ValidationsFatalException validationsFatalException;
	
	@Mock
	private RuntimeException runtimeException;
	
	private String message="dvhf";
	private Throwable cause=null;
	
	@Test
	public void testValidationsFatalException()
	{
		validationsFatalException=new ValidationsFatalException(message, cause);
	}

}
