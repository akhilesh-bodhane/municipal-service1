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
public class ColumnTest {
	@InjectMocks
	private Column column;

	@Test
	public void testGetApplicationType() {
		column.setApplicationType("JunitType");
		Assert.assertEquals("JunitType", column.getApplicationType());
	}

	@Test
	public void testGetRoles() {
		List<String> role = new ArrayList<String>();
		role.add("TestRole");
		column.setRoles(role);
		Assert.assertEquals(role, column.getRoles());
	}

	@Test
	public void testGetColunmNames() {
		column.setColunmNames("TestColumns");
		Assert.assertEquals("TestColumns", column.getColunmNames());
	}

	@Test
	public void testToString() {
		String str = column.toString();
		org.junit.Assert.assertEquals(str, column.toString());
	}

}
