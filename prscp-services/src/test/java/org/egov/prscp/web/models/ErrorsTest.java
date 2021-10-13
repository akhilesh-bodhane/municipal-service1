package org.egov.prscp.web.models;

import java.util.List;
import org.easymock.EasyMock;
import org.egov.common.contract.response.ResponseInfo;
import org.junit.*;
import static org.junit.Assert.*;


public class ErrorsTest {
	
	@Test
	public void testErrors_1()
		throws Exception {

		Errors result = new Errors();

		
		assertNotNull(result);
		assertEquals("Errors(responseInfo=null, error=null)", result.toString());
		assertEquals(null, result.getError());
		assertEquals(null, result.getResponseInfo());
	}

	
	@Test
	public void testErrors_2()
		throws Exception {
		ResponseInfo responseInfo = new ResponseInfo();
		List<ErrorResponseInfo> error = EasyMock.createMock(List.class);
		

		EasyMock.replay(error);

		Errors result = new Errors(responseInfo, error);

		
		EasyMock.verify(error);
		assertNotNull(result);
		assertEquals("Errors(responseInfo=ResponseInfo(apiId=null, ver=null, ts=null, resMsgId=null, msgId=null, status=null), error=EasyMock for interface java.util.List)", result.toString());
	}

	
	@Test
	public void testBuilder_1()
		throws Exception {

		Errors.ErrorsBuilder result = Errors.builder();

		
		assertNotNull(result);
		assertEquals("Errors.ErrorsBuilder(responseInfo=null, error=null)", result.toString());
	}

	
	@Test
	public void testGetError_1()
		throws Exception {
		Errors fixture = new Errors(new ResponseInfo(), EasyMock.createNiceMock(List.class));

		List<ErrorResponseInfo> result = fixture.getError();

		assertNotNull(result);
		assertEquals(0, result.size());
	}

	
	@Test
	public void testGetResponseInfo_1()
		throws Exception {
		Errors fixture = new Errors(new ResponseInfo(), EasyMock.createNiceMock(List.class));

		ResponseInfo result = fixture.getResponseInfo();

		assertNotNull(result);
		assertEquals("ResponseInfo(apiId=null, ver=null, ts=null, resMsgId=null, msgId=null, status=null)", result.toString());
		assertEquals(null, result.getStatus());
		assertEquals(null, result.getVer());
		assertEquals(null, result.getResMsgId());
		assertEquals(null, result.getMsgId());
		assertEquals(null, result.getApiId());
		assertEquals(null, result.getTs());
	}

	
	@Test
	public void testSetError_1()
		throws Exception {
		Errors fixture = new Errors(new ResponseInfo(), EasyMock.createNiceMock(List.class));
		List<ErrorResponseInfo> error = EasyMock.createMock(List.class);
		EasyMock.replay(error);

		fixture.setError(error);

		EasyMock.verify(error);
	}


	@Test
	public void testSetResponseInfo_1()
		throws Exception {
		Errors fixture = new Errors(new ResponseInfo(), EasyMock.createNiceMock(List.class));
		ResponseInfo responseInfo = new ResponseInfo();

		fixture.setResponseInfo(responseInfo);

	
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
		new org.junit.runner.JUnitCore().run(ErrorsTest.class);
	}
}