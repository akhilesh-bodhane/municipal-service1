package org.egov.pm.model;

import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.Silent.class)
public class ColumnsTestCases {

	@InjectMocks
	private Columns columns;

	@Test
	public void testGetColumnMaps() {
		List<String> tenantId = new ArrayList<>();
		tenantId.add("ch");
		ColumnsMaps columnMaps = new ColumnsMaps();
		columnMaps.setTenantId(tenantId);
		columns.setColumnMaps(columnMaps);
		Assert.assertEquals(columnMaps, columns.getColumnMaps());
	}

	@Test
	public void testToString() {
		String str = columns.toString();
		Assert.assertEquals(str, columns.toString());
	}

}
