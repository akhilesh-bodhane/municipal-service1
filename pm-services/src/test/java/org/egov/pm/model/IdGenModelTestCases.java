package org.egov.pm.model;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import junit.framework.Assert;

@RunWith(MockitoJUnitRunner.class)
public class IdGenModelTestCases {

	@InjectMocks
	private IdGenModel idGenModel;

	@Test
	public void testBuilder() {
		IdGenModel genModel = IdGenModel.builder().tenantId("ch").build();
		IdGenModel genMode2 = IdGenModel.builder().tenantId("ch").build();
		Assert.assertEquals(genModel.getTenantId(), genMode2.getTenantId());
	}

	@Test
	public void testGetCount() {
		idGenModel.setCount(1);
		Assert.assertEquals(Integer.valueOf(1), idGenModel.getCount());
	}

	@Test
	public void testGetIdName() {
		idGenModel.setIdName("Names");
		Assert.assertEquals("Names", idGenModel.getIdName());
	}

	@Test
	public void testGetTenantId() {
		idGenModel.setTenantId("ch");
		Assert.assertEquals("ch", idGenModel.getTenantId());
	}

	@Test
	public void testGetId() {
		idGenModel.setId("12345");
		Assert.assertEquals("12345", idGenModel.getId());
	}

	@Test
	public void testIdGenModelIntegerStringStringString() {
		idGenModel = new IdGenModel(123, "Names", "ch", "56779");
		IdGenModel idGenModel2 = new IdGenModel(123, "Names", "ch", "56779");
		Assert.assertEquals(idGenModel.getIdName(), idGenModel2.getIdName());
	}

	@Test
	public void testIdGenModel() {
		IdGenModel.IdGenModelBuilder str1 = new IdGenModel.IdGenModelBuilder();
		str1.count(12345);
		str1.id("45678");
		str1.idName("idName");
		str1.toString();
		IdGenModel.IdGenModelBuilder str2 = new IdGenModel.IdGenModelBuilder();
		str2.count(12345);
		str2.id("45678");
		str2.idName("idName");
		str2.toString();
		Assert.assertEquals(str1.getClass(), str2.getClass());

		IdGenModel i1 = new IdGenModel();
		i1.setCount(455);
		Assert.assertEquals(Integer.valueOf(455), i1.getCount());
	}

}
