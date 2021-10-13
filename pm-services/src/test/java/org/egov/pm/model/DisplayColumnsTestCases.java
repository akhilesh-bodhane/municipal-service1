package org.egov.pm.model;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import junit.framework.Assert;

@RunWith(MockitoJUnitRunner.Silent.class)
public class DisplayColumnsTestCases {

	@InjectMocks
	private DisplayColumns displayColumns;

	@Test
	public void testHashCode() {
		DisplayColumns displayColumns2 = new DisplayColumns("", "", "", "");
		int value = displayColumns2.hashCode();
		Assert.assertEquals(value, displayColumns2.hashCode());
	}

	@Test
	public void testEqualsObject() {
		DisplayColumns displayColumns2 = new DisplayColumns("", "", "", "");
		Assert.assertEquals(true, displayColumns2.equals(displayColumns2));
	}

	@Test
	public void testDisplayColumns() {
		DisplayColumns columns = DisplayColumns.builder().build();
	}

	@Test
	public void testBuilder() {
		displayColumns.builder();
		// Assert.assertEquals(displayColumns.builder(), displayColumns.builder());
	}

	@Test
	public void testGetTenantId() {
		displayColumns.setTenantId("ch");
		Assert.assertEquals("ch", displayColumns.getTenantId());
	}

	@Test
	public void testGetColumns() {
		displayColumns.setColumns("demoColumns");
		Assert.assertEquals("demoColumns", displayColumns.getColumns());
	}

	@Test
	public void testGetRoles() {
		displayColumns.setRoles("role");
		Assert.assertEquals("role", displayColumns.getRoles());
	}

	@Test
	public void testGetApplicationType() {
		displayColumns.setApplicationType("NOCTYPE");
		Assert.assertEquals("NOCTYPE", displayColumns.getApplicationType());
	}

	@Test
	public void testBuilder_2() {
		DisplayColumns.DisplayColumnsBuilder builder = new DisplayColumns.DisplayColumnsBuilder();
		builder.applicationType("NOCTYPE");
		builder.columns("columns");
		builder.roles("SI");
		builder.tenantId("ch");
		builder.build();

		String str = builder.toString();

		Assert.assertEquals(str, builder.toString());
	}
}
