package org.egov.pm.model;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import junit.framework.Assert;

@RunWith(MockitoJUnitRunner.Silent.class)
public class EmailColumnTestCases {

	@InjectMocks
	private EmailColumn emailColumn;

	@Test
	public void testGetApplicationType() {
		emailColumn.setApplicationType("NOCTYPE");
		Assert.assertEquals("NOCTYPE", emailColumn.getApplicationType());
	}

	@Test
	public void testGetStatus() {
		List<String> status = new ArrayList<String>();
		status.add("PIAD");
		emailColumn.setStatus(status);
		Assert.assertEquals(status, emailColumn.getStatus());
	}

	@Test
	public void testGetTemplate() {
		emailColumn.setTemplate("template");
		Assert.assertEquals("template", emailColumn.getTemplate());
	}

	@Test
	public void testGetSmsTemplate() {
		emailColumn.setSmsTemplate("smsTemplate");
		Assert.assertEquals("smsTemplate", emailColumn.getSmsTemplate());
	}

	@Test
	public void testGetEmailSubject() {
		emailColumn.setEmailSubject("emailSubject");
		Assert.assertEquals("emailSubject", emailColumn.getEmailSubject());
	}

	@Test
	public void testGetRoles() {
		List<String> roles = new ArrayList<>();
		roles.add("roles");
		emailColumn.setRoles(roles);
		Assert.assertEquals(roles, emailColumn.getRoles());
	}

	@Test
	public void testToString() {
		String str = emailColumn.toString();
		Assert.assertEquals(str, emailColumn.toString());
	}

}
