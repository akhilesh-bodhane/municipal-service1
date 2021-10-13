
package org.egov.ec.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.egov.common.contract.request.RequestInfo;
import org.egov.common.contract.request.Role;
import org.egov.ec.config.EchallanConfiguration;
import org.egov.ec.producer.Producer;
import org.egov.ec.repository.IdGenRepository;
import org.egov.ec.web.models.EcSearchCriteria;
import org.egov.ec.web.models.RequestInfoWrapper;
import org.egov.ec.web.models.Idgen.IdGenerationRequest;
import org.egov.ec.web.models.Idgen.IdGenerationResponse;
import org.egov.ec.web.models.Idgen.IdRequest;
import org.egov.tracer.model.CustomException;
import org.egov.tracer.model.ServiceCallException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.client.RestTemplate;

@RunWith(MockitoJUnitRunner.class)
public class IdGenRepositoryTest {

	@InjectMocks
	private IdGenRepository repository;

	@Mock
	private JdbcTemplate jdbcTemplate;

	@Mock
	private Producer producer;

	@Mock
	private EchallanConfiguration config;
	
	@Mock
	private RestTemplate restTemplate;

	@Test
	public void testGetIdGen1() {
		int count = 10;
		List<IdRequest> reqList = new ArrayList<>();
		RequestInfo requestInfo = RequestInfo.builder().build();
		for (int i = 0; i < count; i++) {
			reqList.add(IdRequest.builder().idName("xyz").format("xyz").tenantId("ch").build());
		}
		
		IdGenerationRequest req = IdGenerationRequest.builder().idRequests(reqList).requestInfo(requestInfo).build();
		IdGenerationResponse response = null;
		
		Mockito.when(restTemplate.postForObject("test", req, IdGenerationResponse.class)).thenReturn(response);
		
		response = repository.getId(requestInfo, "test", "test", "test", count);
		
	}

}
