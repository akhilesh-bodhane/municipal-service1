package org.egov.pm.service;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.egov.common.contract.request.RequestInfo;
import org.egov.pm.NocApplication;
import org.egov.pm.PreApplicationRunnerImpl;
import org.egov.pm.model.ErrorResponseInfo;
import org.egov.pm.model.IdGenModel;
import org.egov.pm.model.IdGenRequestModel;
import org.egov.pm.producer.Producer;
import org.egov.pm.repository.NocRepository;
import org.egov.pm.util.UserUtil;
import org.egov.pm.web.contract.NocResponse;
import org.egov.pm.web.contract.factory.ResponseFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import junit.framework.Assert;

@RunWith(MockitoJUnitRunner.Silent.class)
public class IDGenUtilTest {

	@Mock
	private NocRepository nocRepository;

	@InjectMocks
	private IDGenUtil iDGenUtil;

	@Mock
	private ResponseFactory responseFactory;

	@Mock
	private NocResponse nocResponse;

	@InjectMocks
	private NocApplication nocApplication;

	@Mock
	private UserUtil userUtil;

	@Mock
	private Producer producer;

	@Mock
	private PreApplicationRunnerImpl applicationRunnerImpl;

	@InjectMocks
	private ErrorResponseInfo errorResponseInfo;

	@Mock
	RestTemplate restTemplate;

	@Test
	public void testGenerateApplicationId() throws JsonProcessingException, IOException {
		String json = "{\r\n" + "   \"responseInfo\":{\r\n" + "      \"apiId\":null,\r\n" + "      \"ver\":null,\r\n"
				+ "      \"ts\":null,\r\n" + "      \"resMsgId\":null,\r\n" + "      \"msgId\":null,\r\n"
				+ "      \"status\":\"200\"\r\n" + "   },\r\n" + "   \"idResponses\":{\r\n" + "      \"id\":209,\r\n"
				+ "      \"idName\":\"7276621098\",\r\n" + "      \"tenantId\":null,\r\n"
				+ "      \"name\":\"citizen\",\r\n" + "      \"count\":124\r\n" + "   }\r\n" + "}";
		ObjectMapper objectMapper = new ObjectMapper();
		JsonNode jsonNode = objectMapper.readTree(json);

		 List<IdGenModel> idList = Arrays
		 .asList(IdGenModel.builder().count(1).idName("ch.pms").tenantId("ch").build());
		 IdGenRequestModel mcq = new IdGenRequestModel();
		 mcq.setRequestInfo(RequestInfo.builder().build());
		 mcq.setIdRequests(idList);

		

	}

	// @Test
	public void testCreateWorkflowRequest() {
		fail("Not yet implemented");
	}

}
