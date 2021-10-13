package org.egov.ec.web.models.Idgen;

import org.junit.*;
import static org.junit.Assert.*;

import org.egov.ec.web.models.Idgen.IdRequest;

/**
 * The class <code>IdRequestTest</code> contains tests for the class <code>{@link IdRequest}</code>.
 *
 * @generated at 17/5/20 2:10 PM
 * @version $Revision: 1.0 $
 */
public class IdRequestTest {
	/**
	 * Run the IdRequest() constructor test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:10 PM
	 */
	@Test
	public void testIdRequest_1()
		throws Exception {

		IdRequest result = new IdRequest();

		
		assertNotNull(result);
		assertEquals("IdRequest(idName=null, tenantId=null, format=null)", result.toString());
		assertEquals(null, result.getFormat());
		assertEquals(null, result.getTenantId());
		assertEquals(null, result.getIdName());
	}

	/**
	 * Run the IdRequest(String,String,String) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:10 PM
	 */
	@Test
	public void testIdRequest_2()
		throws Exception {
		String idName = "";
		String tenantId = "";
		String format = "";

		IdRequest result = new IdRequest(idName, tenantId, format);

		
		assertNotNull(result);
		assertEquals("IdRequest(idName=, tenantId=, format=)", result.toString());
		assertEquals("", result.getFormat());
		assertEquals("", result.getTenantId());
		assertEquals("", result.getIdName());
	}

	/**
	 * Run the IdRequest.IdRequestBuilder builder() method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:10 PM
	 */
	@Test
	public void testBuilder_1()
		throws Exception {

		IdRequest.IdRequestBuilder result = IdRequest.builder();

		
		assertNotNull(result);
		assertEquals("IdRequest.IdRequestBuilder(idName=null, tenantId=null, format=null)", result.toString());
	}
	
	@Test
	public void testBuilder_2()
		throws Exception {

		IdRequest.IdRequestBuilder builder = IdRequest.builder();
		builder.idName(null);
		builder.tenantId(null);
		builder.format(null);
		builder.build();
		
		IdRequest.IdRequestBuilder builder2 = IdRequest.builder();
		builder2.idName(null);
		builder2.tenantId(null);
		builder2.format(null);
		builder2.build();
		
		Assert.assertEquals(builder2.toString(), builder.toString());
	}

	/**
	 * Run the boolean canEqual(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:10 PM
	 */
	@Test
	public void testCanEqual_1()
		throws Exception {
		IdRequest fixture = new IdRequest("", "", "");
		Object other = new Object();

		boolean result = fixture.canEqual(other);

		
		assertEquals(false, result);
	}

	/**
	 * Run the boolean canEqual(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:10 PM
	 */
	@Test
	public void testCanEqual_2()
		throws Exception {
		IdRequest fixture = new IdRequest("", "", "");
		Object other = new Object();

		boolean result = fixture.canEqual(other);

		
		assertEquals(false, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:10 PM
	 */
	@Test
	public void testEquals_1()
		throws Exception {
		IdRequest fixture = new IdRequest("", "", "");
		Object o = new IdRequest("", "", "");

		boolean result = fixture.equals(o);

		
		assertEquals(true, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:10 PM
	 */
	@Test
	public void testEquals_2()
		throws Exception {
		IdRequest fixture = new IdRequest("", "", "");
		Object o = new Object();

		boolean result = fixture.equals(o);

		
		assertEquals(false, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:10 PM
	 */
	@Test
	public void testEquals_3()
		throws Exception {
		IdRequest fixture = new IdRequest("", "", "");
		Object o = new IdRequest("", "", "");

		boolean result = fixture.equals(o);

		
		assertEquals(true, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:10 PM
	 */
	@Test
	public void testEquals_4()
		throws Exception {
		IdRequest fixture = new IdRequest("", "", "");
		Object o = new IdRequest("", "", "");

		boolean result = fixture.equals(o);

		
		assertEquals(true, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:10 PM
	 */
	@Test
	public void testEquals_5()
		throws Exception {
		IdRequest fixture = new IdRequest("", "", "");
		Object o = new IdRequest("", "", "");

		boolean result = fixture.equals(o);

		
		assertEquals(true, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:10 PM
	 */
	@Test
	public void testEquals_6()
		throws Exception {
		IdRequest fixture = new IdRequest("", "", "");
		Object o = new IdRequest("", "", "");

		boolean result = fixture.equals(o);

		
		assertEquals(true, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:10 PM
	 */
	@Test
	public void testEquals_7()
		throws Exception {
		IdRequest fixture = new IdRequest("", "", (String) null);
		Object o = new IdRequest("", "", (String) null);

		boolean result = fixture.equals(o);

		
		assertEquals(true, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:10 PM
	 */
	@Test
	public void testEquals_8()
		throws Exception {
		IdRequest fixture = new IdRequest("", "", "");
		Object o = new IdRequest("", "", "");

		boolean result = fixture.equals(o);

		
		assertEquals(true, result);
	}

	/**
	 * Run the String getFormat() method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:10 PM
	 */
	@Test
	public void testGetFormat_1()
		throws Exception {
		IdRequest fixture = new IdRequest("", "", "");

		String result = fixture.getFormat();

		
		assertEquals("", result);
	}

	/**
	 * Run the String getIdName() method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:10 PM
	 */
	@Test
	public void testGetIdName_1()
		throws Exception {
		IdRequest fixture = new IdRequest("", "", "");

		String result = fixture.getIdName();

		
		assertEquals("", result);
	}

	/**
	 * Run the String getTenantId() method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:10 PM
	 */
	@Test
	public void testGetTenantId_1()
		throws Exception {
		IdRequest fixture = new IdRequest("", "", "");

		String result = fixture.getTenantId();

		
		assertEquals("", result);
	}

	/**
	 * Run the int hashCode() method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:10 PM
	 */
	@Test
	public void testHashCode_1()
		throws Exception {
		IdRequest fixture = new IdRequest((String) null, "", "");

		int result = fixture.hashCode();

		
		assertEquals(355062, result);
	}

	/**
	 * Run the int hashCode() method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:10 PM
	 */
	@Test
	public void testHashCode_2()
		throws Exception {
		IdRequest fixture = new IdRequest("", (String) null, (String) null);

		int result = fixture.hashCode();

		
		assertEquals(207959, result);
	}

	/**
	 * Run the void setFormat(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:10 PM
	 */
	@Test
	public void testSetFormat_1()
		throws Exception {
		IdRequest fixture = new IdRequest("", "", "");
		String format = "";

		fixture.setFormat(format);

		
	}

	/**
	 * Run the void setIdName(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:10 PM
	 */
	@Test
	public void testSetIdName_1()
		throws Exception {
		IdRequest fixture = new IdRequest("", "", "");
		String idName = "";

		fixture.setIdName(idName);

		
	}

	/**
	 * Run the void setTenantId(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:10 PM
	 */
	@Test
	public void testSetTenantId_1()
		throws Exception {
		IdRequest fixture = new IdRequest("", "", "");
		String tenantId = "";

		fixture.setTenantId(tenantId);

		
	}

}