package org.egov.pm.model;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import junit.framework.Assert;

@RunWith(MockitoJUnitRunner.class)
public class EmailTemplateModelTestCases {

	@InjectMocks
	private EmailTemplateModel emailTemplateModel;

	@Test
	public void testHashCode() {
		emailTemplateModel.setApplicationType("NOCTYPE");
		emailTemplateModel.setTenantId("ch");
		emailTemplateModel.setStatus("APPROVED");
		int hash = emailTemplateModel.hashCode();
		Assert.assertEquals(hash, emailTemplateModel.hashCode());
	}

	@Test
	public void testEqualsObject() {
		emailTemplateModel.setApplicationType("NOCTYPE");
		emailTemplateModel.setTenantId("ch");
		emailTemplateModel.setStatus("APPROVED");

		boolean retVal = emailTemplateModel.equals(emailTemplateModel);
		Assert.assertEquals(retVal, emailTemplateModel.equals(emailTemplateModel));
	}

	@Test
	public void testBuilder() {
		EmailTemplateModel test = emailTemplateModel.builder().tenantId("ch").build();
		Assert.assertEquals(test, emailTemplateModel.builder().tenantId("ch").build());
	}

	@Test
	public void testGetTenantId() {
		emailTemplateModel.setTenantId("ch");
		Assert.assertEquals("ch", emailTemplateModel.getTenantId());
	}

	@Test
	public void testGetTemplate() {
		emailTemplateModel.setTemplate("template");
		Assert.assertEquals("template", emailTemplateModel.getTemplate());
	}

	@Test
	public void testGetStatus() {
		emailTemplateModel.setStatus("APPROVE");
		Assert.assertEquals("APPROVE", emailTemplateModel.getStatus());
	}

	@Test
	public void testGetRoles() {
		emailTemplateModel.setRoles("ROLE");
		Assert.assertEquals("ROLE", emailTemplateModel.getRoles());
	}

	@Test
	public void testGetApplicationType() {
		emailTemplateModel.setApplicationType("NOCTYPE");
		Assert.assertEquals("NOCTYPE", emailTemplateModel.getApplicationType());
	}

	@Test
	public void testGetSmsTemplate() {
		emailTemplateModel.setSmsTemplate("smsTemplate");
		Assert.assertEquals("smsTemplate", emailTemplateModel.getSmsTemplate());
	}

	@Test
	public void testGetEmailSubject() {
		emailTemplateModel.setEmailSubject("emailSubject");
		Assert.assertEquals("emailSubject", emailTemplateModel.getEmailSubject());
	}

	@Test
	public void testEmailTemplateModelStringStringStringStringStringStringString() {
		EmailTemplateModel em = EmailTemplateModel.builder().tenantId("ch").build();
		Assert.assertEquals(em, EmailTemplateModel.builder().tenantId("ch").build());
	}

	@Test
	public void testEmailTemplateModel() {
		EmailTemplateModel.EmailTemplateModelBuilder builder1 = new EmailTemplateModel.EmailTemplateModelBuilder();
		builder1.applicationType("NOCTYPE");
		builder1.emailSubject("emailSubject");
		builder1.roles("Roles");
		builder1.smsTemplate("smsTemplate");
		builder1.status("APPROVE");
		builder1.template("template");
		builder1.build();
		builder1.toString();

		EmailTemplateModel.EmailTemplateModelBuilder builder2 = new EmailTemplateModel.EmailTemplateModelBuilder();
		builder2.applicationType("NOCTYPE");
		builder2.emailSubject("emailSubject");
		builder2.roles("Roles");
		builder2.smsTemplate("smsTemplate");
		builder2.status("APPROVE");
		builder2.template("template");
		builder2.build();
		builder2.toString();
		Assert.assertEquals(builder1.getClass(), builder2.getClass());
	}

	@Test
	public void testToString() {
		String str = emailTemplateModel.toString();
		Assert.assertEquals(str, emailTemplateModel.toString());
	}

}
