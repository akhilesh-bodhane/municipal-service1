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
public class ColumnsMapsTestCases {

	@InjectMocks
	private ColumnsMaps columnsMaps;

	@Test
	public void testGetTenantId() {
		List<String> tenantId = new ArrayList<>();
		tenantId.add("ch");
		columnsMaps.setTenantId(tenantId);
		Assert.assertEquals(tenantId, columnsMaps.getTenantId());
	}

	@Test
	public void testGetColumnConfig() {
		Column column = new Column();
		column.setApplicationType("NOCTYPE");
		List<Column> columnConfig = new ArrayList<Column>();
		columnConfig.add(column);

		columnsMaps.setColumnConfig(columnConfig);
		org.junit.Assert.assertEquals(columnConfig, columnsMaps.getColumnConfig());
	}

	@Test
	public void testGetDocumentConfig() {
		DocumentColumn document = new DocumentColumn();
		document.setApplicationType("NOCTYPE");
		List<DocumentColumn> documentConfig = new ArrayList<>();
		documentConfig.add(document);
		columnsMaps.setDocumentConfig(documentConfig);
		org.junit.Assert.assertEquals(documentConfig, columnsMaps.getDocumentConfig());
	}

	@Test
	public void testToString() {
		String str = columnsMaps.toString();
		Assert.assertEquals(str, columnsMaps.toString());
	}

}
