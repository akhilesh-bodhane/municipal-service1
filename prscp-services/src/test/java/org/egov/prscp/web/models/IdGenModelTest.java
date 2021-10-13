package org.egov.prscp.web.models;

import org.junit.*;
import static org.junit.Assert.*;

public class IdGenModelTest {

	@Test
	public void testIdGenModel_1()
		throws Exception {

		IdGenModel result = new IdGenModel();

		assertNotNull(result);
		assertEquals(null, result.getId());
		assertEquals(null, result.getCount());
		assertEquals(null, result.getIdName());
		assertEquals(null, result.getTenantId());
	}

	@Test
	public void testIdGenModel_2()
		throws Exception {
		Integer count = new Integer(1);
		String idName = "";
		String tenantId = "";
		String id = "";

		IdGenModel result = new IdGenModel(count, idName, tenantId, id);

		assertNotNull(result);
		assertEquals("", result.getId());
		assertEquals(new Integer(1), result.getCount());
		assertEquals("", result.getIdName());
		assertEquals("", result.getTenantId());
	}


	@Test
	public void testBuilder_1()
		throws Exception {

		IdGenModel.IdGenModelBuilder result = IdGenModel.builder();

		assertNotNull(result);
		assertEquals("IdGenModel.IdGenModelBuilder(count=null, idName=null, tenantId=null, id=null)", result.toString());
	}


	@Test
	public void testGetCount_1()
		throws Exception {
		IdGenModel fixture = new IdGenModel(new Integer(1), "", "", "");

		Integer result = fixture.getCount();

		assertNotNull(result);
		assertEquals("1", result.toString());
		assertEquals((byte) 1, result.byteValue());
		assertEquals((short) 1, result.shortValue());
		assertEquals(1, result.intValue());
		assertEquals(1L, result.longValue());
		assertEquals(1.0f, result.floatValue(), 1.0f);
		assertEquals(1.0, result.doubleValue(), 1.0);
	}

	
	@Test
	public void testGetId_1()
		throws Exception {
		IdGenModel fixture = new IdGenModel(new Integer(1), "", "", "");

		String result = fixture.getId();

		assertEquals("", result);
	}

	
	@Test
	public void testGetIdName_1()
		throws Exception {
		IdGenModel fixture = new IdGenModel(new Integer(1), "", "", "");

		String result = fixture.getIdName();

		assertEquals("", result);
	}

	@Test
	public void testGetTenantId_1()
		throws Exception {
		IdGenModel fixture = new IdGenModel(new Integer(1), "", "", "");

		String result = fixture.getTenantId();

		assertEquals("", result);
	}


	@Test
	public void testSetCount_1()
		throws Exception {
		IdGenModel fixture = new IdGenModel(new Integer(1), "", "", "");
		Integer count = new Integer(1);

		fixture.setCount(count);

	}

	
	@Test
	public void testSetId_1()
		throws Exception {
		IdGenModel fixture = new IdGenModel(new Integer(1), "", "", "");
		String id = "";

		fixture.setId(id);

	}

	
	@Test
	public void testSetIdName_1()
		throws Exception {
		IdGenModel fixture = new IdGenModel(new Integer(1), "", "", "");
		String idName = "";

		fixture.setIdName(idName);

	}

	@Test
	public void testSetTenantId_1()
		throws Exception {
		IdGenModel fixture = new IdGenModel(new Integer(1), "", "", "");
		String tenantId = "";

		fixture.setTenantId(tenantId);

	}

	
	@Before
	public void setUp()
		throws Exception {
		
	}


	@After
	public void tearDown()
		throws Exception {
		
	}


	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(IdGenModelTest.class);
	}
}