package org.egov.pm.model;

import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import junit.framework.Assert;

@RunWith(MockitoJUnitRunner.Silent.class)
public class EmailColumnMapsTestCases {

	@InjectMocks
	private EmailColumnMaps emailColumnMaps;

	@Test
	public void testGetTenantId() {
		List<String> tenantId = new ArrayList<String>();
		tenantId.add("ch");
		emailColumnMaps.setTenantId(tenantId);
		Assert.assertEquals(tenantId, emailColumnMaps.getTenantId());
	}

	@Test
	public void testGetColumnConfig() {
		EmailColumn e = new EmailColumn();
		e.setApplicationType("NOCTYPE");
		List<EmailColumn> columnConfig = new ArrayList<>();
		columnConfig.add(e);
		emailColumnMaps.setColumnConfig(columnConfig);
		Assert.assertEquals(columnConfig, emailColumnMaps.getColumnConfig());
	}

	@Test
	public void testToString() {
		String str = emailColumnMaps.toString();
		Assert.assertEquals(str, emailColumnMaps.toString());
	}

}
