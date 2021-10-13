package org.egov.pm.model;

import java.util.ArrayList;
import java.util.List;

import org.egov.common.contract.request.RequestInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class IdGenRequestModelTestCases {

	@InjectMocks
	private IdGenRequestModel idGenRequestModel;

	@Test
	public void testBuilder() {
		IdGenRequestModel idGenRequestModel2 = IdGenRequestModel.builder()
				.requestInfo(RequestInfo.builder().action("Request").build()).build();
		idGenRequestModel.setRequestInfo(RequestInfo.builder().action("Request").build());
		Assert.assertEquals(idGenRequestModel.getRequestInfo().getAction(),
				idGenRequestModel2.getRequestInfo().getAction());
	}

	@Test
	public void testGetRequestInfo() {
		List<IdGenModel> idRequests = new ArrayList<IdGenModel>();
		IdGenModel genModel = new IdGenModel();
		genModel.setIdName("idName");
		idRequests.add(genModel);
		idGenRequestModel.setIdRequests(idRequests);
		Assert.assertEquals("idName", idGenRequestModel.getIdRequests().get(0).getIdName());
	}

	@Test
	public void testGetIdRequests() {
		List<IdGenModel> idRequests = new ArrayList<>();
		IdGenModel genModel = new IdGenModel();
		genModel.setTenantId("ch");
		idGenRequestModel.setIdRequests(idRequests);
		Assert.assertEquals(idRequests, idGenRequestModel.getIdRequests());
	}

	@Test
	public void testIdGenRequestModelRequestInfoListOfIdGenModel() {
		idGenRequestModel.setRequestInfo(RequestInfo.builder().action("Request").build());
		Assert.assertEquals("Request", idGenRequestModel.getRequestInfo().getAction());
	}

	@Test
	public void testIdGenRequestModel() {
		IdGenRequestModel genRequestModel = new IdGenRequestModel();
		genRequestModel.setRequestInfo(RequestInfo.builder().action("Request").build());
		Assert.assertEquals("Request", genRequestModel.getRequestInfo().getAction());
	}

	@Test
	public void testIdGenRequestModelBuilder() {
		IdGenRequestModel.IdGenRequestModelBuilder genRequestModel = new IdGenRequestModel.IdGenRequestModelBuilder();
		genRequestModel.requestInfo(RequestInfo.builder().action("Request").build());
		genRequestModel.toString();
		genRequestModel.build();
		genRequestModel.idRequests(new ArrayList<IdGenModel>());

		IdGenRequestModel.IdGenRequestModelBuilder genRequestModel2 = new IdGenRequestModel.IdGenRequestModelBuilder();
		genRequestModel2.requestInfo(RequestInfo.builder().action("Request").build());
		genRequestModel2.toString();
		genRequestModel2.idRequests(new ArrayList<IdGenModel>());

		Assert.assertEquals(genRequestModel2.toString(), genRequestModel.toString());
	}

}
