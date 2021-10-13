package org.egov.prscp.web.models;

import org.junit.*;
import static org.junit.Assert.*;

public class AuditDetailsTest {

	@Test
	public void testAuditDetails_1()
		throws Exception {

		AuditDetails result = new AuditDetails();

		assertNotNull(result);
		assertEquals(null, result.getLastModifiedTime());
		assertEquals(null, result.getLastModifiedBy());
		assertEquals(null, result.getCreatedBy());
		assertEquals(null, result.getCreatedTime());
	}

	@Test
	public void testAuditDetails_2()
		throws Exception {
		String createdBy = "";
		String lastModifiedBy = "";
		Long createdTime = new Long(1L);
		Long lastModifiedTime = new Long(1L);

		AuditDetails result = new AuditDetails(createdBy, lastModifiedBy, createdTime, lastModifiedTime);

		assertNotNull(result);
		assertEquals(new Long(1L), result.getLastModifiedTime());
		assertEquals("", result.getLastModifiedBy());
		assertEquals("", result.getCreatedBy());
		assertEquals(new Long(1L), result.getCreatedTime());
	}

	@Test
	public void testBuilder_1()
		throws Exception {

		AuditDetails.AuditDetailsBuilder result = AuditDetails.builder();

		assertNotNull(result);
		assertEquals("AuditDetails.AuditDetailsBuilder(createdBy=null, lastModifiedBy=null, createdTime=null, lastModifiedTime=null)", result.toString());
	}

	
	@Test
	public void testGetCreatedBy_1()
		throws Exception {
		AuditDetails fixture = new AuditDetails("", "", new Long(1L), new Long(1L));

		String result = fixture.getCreatedBy();

		assertEquals("", result);
	}

	
	@Test
	public void testGetCreatedTime_1()
		throws Exception {
		AuditDetails fixture = new AuditDetails("", "", new Long(1L), new Long(1L));

		Long result = fixture.getCreatedTime();

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
	public void testGetLastModifiedBy_1()
		throws Exception {
		AuditDetails fixture = new AuditDetails("", "", new Long(1L), new Long(1L));

		String result = fixture.getLastModifiedBy();

		assertEquals("", result);
	}

	
	@Test
	public void testGetLastModifiedTime_1()
		throws Exception {
		AuditDetails fixture = new AuditDetails("", "", new Long(1L), new Long(1L));

		Long result = fixture.getLastModifiedTime();

	
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
	public void testSetCreatedBy_1()
		throws Exception {
		AuditDetails fixture = new AuditDetails("", "", new Long(1L), new Long(1L));
		String createdBy = "";

		fixture.setCreatedBy(createdBy);

	}

	@Test
	public void testSetCreatedTime_1()
		throws Exception {
		AuditDetails fixture = new AuditDetails("", "", new Long(1L), new Long(1L));
		Long createdTime = new Long(1L);

		fixture.setCreatedTime(createdTime);

	}

	@Test
	public void testSetLastModifiedBy_1()
		throws Exception {
		AuditDetails fixture = new AuditDetails("", "", new Long(1L), new Long(1L));
		String lastModifiedBy = "";

		fixture.setLastModifiedBy(lastModifiedBy);

	}

	@Test
	public void testSetLastModifiedTime_1()
		throws Exception {
		AuditDetails fixture = new AuditDetails("", "", new Long(1L), new Long(1L));
		Long lastModifiedTime = new Long(1L);

		fixture.setLastModifiedTime(lastModifiedTime);

		
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
		new org.junit.runner.JUnitCore().run(AuditDetailsTest.class);
	}
}