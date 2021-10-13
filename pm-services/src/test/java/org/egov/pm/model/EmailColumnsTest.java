package org.egov.pm.model;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import junit.framework.Assert;

@RunWith(MockitoJUnitRunner.Silent.class)
public class EmailColumnsTest {

	@InjectMocks
	private EmailColumns emailColumns;

	@Test
	public void testGetColumnMaps() {
		EmailColumnMaps columnMaps = new EmailColumnMaps();
		emailColumns.setColumnMaps(columnMaps);
		Assert.assertEquals(columnMaps, emailColumns.getColumnMaps());
	}

	@Test
	public void testToString() {
		String str = emailColumns.toString();
		Assert.assertEquals(str, emailColumns.toString());
	}

}
