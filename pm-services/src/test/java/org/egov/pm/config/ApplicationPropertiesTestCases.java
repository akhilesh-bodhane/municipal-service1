package org.egov.pm.config;

import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.core.env.Environment;

@RunWith(MockitoJUnitRunner.Silent.class)
public class ApplicationPropertiesTestCases {

	@InjectMocks
	private ApplicationProperties applicationProperties;

	@Test
	public void testGetEnvironment() {
		Environment env = applicationProperties.getEnvironment();
	}

	@Test
	public void testToString() {
		applicationProperties.toString();
	}

}
