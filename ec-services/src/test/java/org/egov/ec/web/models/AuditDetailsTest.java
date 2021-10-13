package org.egov.ec.web.models;

import org.junit.*;
import static org.junit.Assert.*;

import org.egov.ec.web.models.AuditDetails;

public class AuditDetailsTest {
	
	/**
	 * Run the AuditDetails() constructor test.
	 *
	 * @throws Exception
	 *
	 *  at 30/4/20 5:39 AM
	 */
	@Test
	public void testAuditDetails_1()
		throws Exception {

		AuditDetails result = new AuditDetails();

		
		assertNotNull(result);
		assertEquals(null, result.getLastModifiedTime());
		assertEquals(null, result.getCreatedBy());
		assertEquals(null, result.getCreatedTime());
		assertEquals(null, result.getLastModifiedBy());
		assertEquals(null, result.getUserRole());
	}
	
	/**
	 * Run the AuditDetails(String,String,String,String,Long,String,Long,Boolean,String) constructor test.
	 *
	 * @throws Exception
	 *
	 *  at 30/04/20 1:32 PM
	 */
	@Test
	public void testAuditDetails_2()
		throws Exception {
		String userRole = "";
		String createdBy = "";
		Long createdTime = new Long(1L);
		String lastModifiedBy = "";
		Long lastModifiedTime = new Long(1L);


		AuditDetails result = new AuditDetails(createdBy,lastModifiedBy,createdTime,lastModifiedTime,userRole);

		
		assertNotNull(result);
		assertEquals(new Long(1L), (result.getLastModifiedTime()));
		assertEquals("", result.getCreatedBy());
		assertEquals(new Long(1L), result.getCreatedTime());
		assertEquals("", result.getLastModifiedBy());
		assertEquals("", result.getUserRole());
	}
	
	/**
	 * Run the AuditDetails.AuditDetailsBuilder builder() method test.
	 *
	 * @throws Exception
	 *
	 *  at 30/04/20 1:32 PM
	 */
	@Test
	public void testBuilder_1()
		throws Exception {

		AuditDetails.AuditDetailsBuilder result = AuditDetails.builder();

		
		assertNotNull(result);
		assertEquals("AuditDetails.AuditDetailsBuilder(createdBy=null, lastModifiedBy=null, createdTime=null, lastModifiedTime=null, userRole=null)", result.toString());
	}
	
	/**
	 * Run the AuditDetails.AuditDetailsBuilder builder() method test.
	 *
	 * @throws Exception
	 *
	 *  at 30/04/20 1:32 PM
	 */
	@Test
	public void testBuilder_2()
		throws Exception {

		AuditDetails.AuditDetailsBuilder builder = new AuditDetails.AuditDetailsBuilder();

		builder.createdBy(null);
		builder.createdTime(null);
		builder.lastModifiedBy(null);
		builder.lastModifiedTime(null);
		builder.userRole(null);
		builder.build();

		AuditDetails.AuditDetailsBuilder builder2 = new AuditDetails.AuditDetailsBuilder();
		builder2.createdBy(null);
		builder2.createdTime(null);
		builder2.lastModifiedBy(null);
		builder2.lastModifiedTime(null);
		builder2.userRole(null);
		builder2.build();

		Assert.assertEquals(builder2.toString(), builder.toString());
	}
	
	
	/**
	 * Run the String getCreatedBy() method test.
	 *
	 * @throws Exception
	 *
	 *  at 30/04/20 1:32 PM
	 */
	@Test
	public void testGetCreatedBy_1()
		throws Exception {
		AuditDetails fixture = new AuditDetails(null,"", new Long(1L),new Long(1L),"");

		String result = fixture.getCreatedBy();

		
		assertEquals(null, result);
	}

	/**
	 * Run the Long getCreatedTime() method test.
	 *
	 * @throws Exception
	 *
	 *  at 30/04/20 1:32 PM
	 */
	@Test
	public void testGetCreatedTime_1()
		throws Exception {
		AuditDetails fixture = new AuditDetails(null,"", new Long(1L),new Long(1L),"");

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

	/**
	 * Run the String getLastModifiedBy() method test.
	 *
	 * @throws Exception
	 *
	 *  at 30/04/20 1:32 PM
	 */
	@Test
	public void testGetLastModifiedBy_1()
		throws Exception {
		AuditDetails fixture = new AuditDetails(null,"", new Long(1L),new Long(1L),"");

		String result = fixture.getLastModifiedBy();

		
		assertEquals("", result);
	}

	/**
	 * Run the Long getLastModifiedTime() method test.
	 *
	 * @throws Exception
	 *
	 *  at 30/04/20 1:32 PM
	 */
	@Test
	public void testGetLastModifiedTime_1()
		throws Exception {
		AuditDetails fixture = new AuditDetails(null,"", new Long(1L),new Long(1L),"");

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

	/**
	 * Run the String getUserRole() method test.
	 *
	 * @throws Exception
	 *
	 *  at 30/04/20 1:32 PM
	 */
	@Test
	public void testGetUserRole_1()
		throws Exception {
		AuditDetails fixture = new AuditDetails(null,"", new Long(1L),new Long(1L),"");

		String result = fixture.getUserRole();
		assertEquals("", result);
	}
	
	
	/**
	 * Run the void setCreatedBy(String) method test.
	 *
	 * @throws Exception
	 *
	 *  at 30/04/20 1:32 PM
	 */
	@Test
	public void testSetCreatedBy_1()
		throws Exception {
		AuditDetails fixture = new AuditDetails(null,"", new Long(1L),new Long(1L),"");
		String createdBy = "";

		fixture.setCreatedBy(createdBy);

		
	}

	/**
	 * Run the void setCreatedTime(Long) method test.
	 *
	 * @throws Exception
	 *
	 *  at 30/04/20 1:32 PM
	 */
	@Test
	public void testSetCreatedTime_1()
		throws Exception {
		AuditDetails fixture = new AuditDetails(null,"", new Long(1L),new Long(1L),"");
		Long createdTime = new Long(1L);

		fixture.setCreatedTime(createdTime);

		
	}


	/**
	 * Run the void setLastModifiedBy(String) method test.
	 *
	 * @throws Exception
	 *
	 *  at 30/04/20 1:32 PM
	 */
	@Test
	public void testSetLastModifiedBy_1()
		throws Exception {
		AuditDetails fixture = new AuditDetails(null,"", new Long(1L),new Long(1L),"");
		String lastModifiedBy = "";
		fixture.setLastModifiedBy(lastModifiedBy);

		
	}

	/**
	 * Run the void setLastModifiedTime(Long) method test.
	 *
	 * @throws Exception
	 *
	 *  at 30/04/20 1:32 PM
	 */
	@Test
	public void testSetLastModifiedTime_1()
		throws Exception {
		AuditDetails fixture = new AuditDetails(null,"", new Long(1L),new Long(1L),"");
		Long lastModifiedTime = new Long(1L);
		fixture.setLastModifiedTime(lastModifiedTime);

		
	}

	/**
	 * Run the void setUserRole(String) method test.
	 *
	 * @throws Exception
	 *
	 *  at 30/04/20 1:32 PM
	 */
	@Test
	public void testSetUserRole_1()
		throws Exception {
		AuditDetails fixture = new AuditDetails(null,"", new Long(1L),new Long(1L),"");
		String userRole = "";
		fixture.setUserRole(userRole);

		
	}


}
