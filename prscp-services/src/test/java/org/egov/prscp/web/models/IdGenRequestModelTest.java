package org.egov.prscp.web.models;

import java.util.List;
import org.easymock.EasyMock;
import org.egov.common.contract.request.RequestInfo;
import org.junit.*;
import static org.junit.Assert.*;

public class IdGenRequestModelTest {
	
	@Test
	public void testIdGenRequestModel_1()
		throws Exception {

		IdGenRequestModel result = new IdGenRequestModel();

		
		assertNotNull(result);
		assertEquals(null, result.getRequestInfo());
		assertEquals(null, result.getIdRequests());
	}


	@Test
	public void testIdGenRequestModel_2()
		throws Exception {
		RequestInfo requestInfo = new RequestInfo();
		List<IdGenModel> idRequests = EasyMock.createMock(List.class);
		
		EasyMock.replay(idRequests);

		IdGenRequestModel result = new IdGenRequestModel(requestInfo, idRequests);

		
		EasyMock.verify(idRequests);
		assertNotNull(result);
	}

	
	@Test
	public void testBuilder_1()
		throws Exception {

		IdGenRequestModel.IdGenRequestModelBuilder result = IdGenRequestModel.builder();

		assertNotNull(result);
		assertEquals("IdGenRequestModel.IdGenRequestModelBuilder(requestInfo=null, idRequests=null)", result.toString());
	}

	
	@Test
	public void testGetIdRequests_1()
		throws Exception {
		IdGenRequestModel fixture = new IdGenRequestModel(new RequestInfo(), EasyMock.createNiceMock(List.class));

		List<IdGenModel> result = fixture.getIdRequests();

		assertNotNull(result);
		assertEquals(0, result.size());
	}

	
	@Test
	public void testGetRequestInfo_1()
		throws Exception {
		IdGenRequestModel fixture = new IdGenRequestModel(new RequestInfo(), EasyMock.createNiceMock(List.class));

		RequestInfo result = fixture.getRequestInfo();

		assertNotNull(result);
		assertEquals("RequestInfo(apiId=null, ver=null, ts=null, action=null, did=null, key=null, msgId=null, authToken=null, correlationId=null, userInfo=null)", result.toString());
		assertEquals(null, result.getKey());
		assertEquals(null, result.getUserInfo());
		assertEquals(null, result.getAction());
		assertEquals(null, result.getApiId());
		assertEquals(null, result.getMsgId());
		assertEquals(null, result.getDid());
		assertEquals(null, result.getCorrelationId());
		assertEquals(null, result.getAuthToken());
		assertEquals(null, result.getVer());
		assertEquals(null, result.getTs());
	}

	
	@Test
	public void testSetIdRequests_1()
		throws Exception {
		IdGenRequestModel fixture = new IdGenRequestModel(new RequestInfo(), EasyMock.createNiceMock(List.class));
		List<IdGenModel> idRequests = EasyMock.createMock(List.class);
		

		EasyMock.replay(idRequests);

		fixture.setIdRequests(idRequests);

		EasyMock.verify(idRequests);
	}


	@Test
	public void testSetRequestInfo_1()
		throws Exception {
		IdGenRequestModel fixture = new IdGenRequestModel(new RequestInfo(), EasyMock.createNiceMock(List.class));
		RequestInfo requestInfo = new RequestInfo();

		fixture.setRequestInfo(requestInfo);

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
		new org.junit.runner.JUnitCore().run(IdGenRequestModelTest.class);
	}
}