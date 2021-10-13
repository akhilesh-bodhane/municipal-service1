package org.egov.ec.web.models.Idgen;

import org.junit.*;
import static org.junit.Assert.*;

import org.egov.ec.web.models.Idgen.IdResponse;

/**
 * The class <code>IdResponseTest</code> contains tests for the class <code>{@link IdResponse}</code>.
 *
 * @generated at 17/5/20 2:10 PM
 * @version $Revision: 1.0 $
 */
public class IdResponseTest {
	/**
	 * Run the IdResponse() constructor test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:10 PM
	 */
	@Test
	public void testIdResponse_1()
		throws Exception {

		IdResponse result = new IdResponse();

		
		assertNotNull(result);
		assertEquals("IdResponse(id=null)", result.toString());
		assertEquals(null, result.getId());
	}

	/**
	 * Run the IdResponse(String) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:10 PM
	 */
	@Test
	public void testIdResponse_2()
		throws Exception {
		String id = "";

		IdResponse result = new IdResponse(id);

		
		assertNotNull(result);
		assertEquals("IdResponse(id=)", result.toString());
		assertEquals("", result.getId());
	}

	/**
	 * Run the IdResponse.IdResponseBuilder builder() method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:10 PM
	 */
	@Test
	public void testBuilder_1()
		throws Exception {

		IdResponse.IdResponseBuilder result = IdResponse.builder();

		
		assertNotNull(result);
		assertEquals("IdResponse.IdResponseBuilder(id=null)", result.toString());
	}

	@Test
	public void testBuilder_2()
		throws Exception {

		IdResponse.IdResponseBuilder builder = IdResponse.builder();
		builder.id(null);
		builder.build();
		
		IdResponse.IdResponseBuilder builder2 = IdResponse.builder();
		builder2.id(null);
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
		IdResponse fixture = new IdResponse("");
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
		IdResponse fixture = new IdResponse("");
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
		IdResponse fixture = new IdResponse("");
		Object o = new IdResponse("");

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
		IdResponse fixture = new IdResponse("");
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
		IdResponse fixture = new IdResponse("");
		Object o = new IdResponse("");

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
		IdResponse fixture = new IdResponse("");
		Object o = new IdResponse("");

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
		IdResponse fixture = new IdResponse((String) null);
		Object o = new IdResponse((String) null);

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
		IdResponse fixture = new IdResponse("");
		Object o = new IdResponse("");

		boolean result = fixture.equals(o);

		
		assertEquals(true, result);
	}

	/**
	 * Run the String getId() method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:10 PM
	 */
	@Test
	public void testGetId_1()
		throws Exception {
		IdResponse fixture = new IdResponse("");

		String result = fixture.getId();

		
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
		IdResponse fixture = new IdResponse("");

		int result = fixture.hashCode();

		
		assertEquals(59, result);
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
		IdResponse fixture = new IdResponse((String) null);

		int result = fixture.hashCode();

		
		assertEquals(102, result);
	}

	/**
	 * Run the void setId(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:10 PM
	 */
	@Test
	public void testSetId_1()
		throws Exception {
		IdResponse fixture = new IdResponse("");
		String id = "";

		fixture.setId(id);

		
	}
}