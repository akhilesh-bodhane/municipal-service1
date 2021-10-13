package org.egov.prscp.web.models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ErrorResponseInfoTest {

	@Test
	public void testErrorResponseInfo_1()
		throws Exception {

		ErrorResponseInfo result = new ErrorResponseInfo();

		
		assertNotNull(result);
		assertEquals("ErrorResponseInfo(code=null, message=null, description=null, params=null)", result.toString());
		assertEquals(null, result.getMessage());
		assertEquals(null, result.getParams());
		assertEquals(null, result.getCode());
		assertEquals(null, result.getDescription());
	}

	
	@Test
	public void testErrorResponseInfo_2()
		throws Exception {
		String code = "";
		String message = "";
		String description = "";
		String params = "";

		ErrorResponseInfo result = new ErrorResponseInfo(code, message, description, params);

		assertNotNull(result);
		assertEquals("ErrorResponseInfo(code=, message=, description=, params=)", result.toString());
		assertEquals("", result.getMessage());
		assertEquals("", result.getParams());
		assertEquals("", result.getCode());
		assertEquals("", result.getDescription());
	}


	@Test
	public void testBuilder_1()
		throws Exception {

		ErrorResponseInfo.ErrorResponseInfoBuilder result = ErrorResponseInfo.builder();

	
		assertNotNull(result);
		assertEquals("ErrorResponseInfo.ErrorResponseInfoBuilder(code=null, message=null, description=null, params=null)", result.toString());
	}

	@Test
	public void testGetCode_1()
		throws Exception {
		ErrorResponseInfo fixture = new ErrorResponseInfo("", "", "", "");

		String result = fixture.getCode();

		
		assertEquals("", result);
	}


	@Test
	public void testGetDescription_1()
		throws Exception {
		ErrorResponseInfo fixture = new ErrorResponseInfo("", "", "", "");

		String result = fixture.getDescription();

		
		assertEquals("", result);
	}

	
	@Test
	public void testGetMessage_1()
		throws Exception {
		ErrorResponseInfo fixture = new ErrorResponseInfo("", "", "", "");

		String result = fixture.getMessage();

		assertEquals("", result);
	}

	
	@Test
	public void testGetParams_1()
		throws Exception {
		ErrorResponseInfo fixture = new ErrorResponseInfo("", "", "", "");

		String result = fixture.getParams();

		
		assertEquals("", result);
	}

	
	@Test
	public void testSetCode_1()
		throws Exception {
		ErrorResponseInfo fixture = new ErrorResponseInfo("", "", "", "");
		String code = "";

		fixture.setCode(code);

	}


	@Test
	public void testSetDescription_1()
		throws Exception {
		ErrorResponseInfo fixture = new ErrorResponseInfo("", "", "", "");
		String description = "";

		fixture.setDescription(description);

		
	}

	
	@Test
	public void testSetMessage_1()
		throws Exception {
		ErrorResponseInfo fixture = new ErrorResponseInfo("", "", "", "");
		String message = "";

		fixture.setMessage(message);

	}


	@Test
	public void testSetParams_1()
		throws Exception {
		ErrorResponseInfo fixture = new ErrorResponseInfo("", "", "", "");
		String params = "";

		fixture.setParams(params);

		
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
		new org.junit.runner.JUnitCore().run(ErrorResponseInfoTest.class);
	}
}