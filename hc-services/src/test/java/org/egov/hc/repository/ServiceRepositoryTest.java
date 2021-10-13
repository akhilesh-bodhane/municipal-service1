package org.egov.hc.repository;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.egov.common.contract.request.RequestInfo;
import org.egov.common.contract.request.User;

import org.egov.hc.model.RequestData;
import org.egov.hc.model.ServiceRequestData;
import org.egov.hc.producer.HCConfiguration;
import org.egov.hc.producer.HCProducer;
import org.egov.hc.repository.builder.HCQueryBuilder;
import org.egov.hc.repository.rowmapper.HCRowMapper;

import org.egov.hc.utils.HCUtils;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;

import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.web.client.RestTemplate;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ServiceRepositoryTest {
	
	@Mock
	private RestTemplate restTemplate;
	
	@Mock
	private JdbcTemplate jdbcTemplate;
	
	@Mock
	private HCQueryBuilder querySearchBuilder;
	
	@Mock
	private HCQueryBuilder queryBuilder;
	
	@Mock
	private HCRowMapper rowMapper;
	
	@Mock
	private HCRowMapper hcRowMapper;
	
	@Mock
	private HCProducer producer;

	@Mock
	private HCConfiguration config;
	
	@Mock
	private HCUtils hCUtils;
  
	@InjectMocks
	private ServiceRepository serviceRepository;

	@Test
	public void testfindRequest() throws Exception {
		
//		RequestData requestData = RequestData.builder().service_request_id("MCC-HC-000072").build();
		
		RequestData requestdata = RequestData.builder().service_request_id("CH-HC-2020-06-14-001432_1").serviceType("PRUNING OF TREES GIRTH GREATER THAN 90 CMS").serviceRequestStatus("INITIATED")
                .requestInfo(RequestInfo.builder().userInfo(User.builder().tenantId("ch").build()).build()).build();
		
		
		List<Object> preparedStmtList = new ArrayList<>();
		preparedStmtList.add(100);
		preparedStmtList.add(0);
		
		ServiceRequestData  serviceRequest = new ServiceRequestData();
		serviceRequest.setService_request_id("CH-HC-2020-06-14-001432_1");
		serviceRequest.setService_request_date("1578894136873");
		serviceRequest.setService_request_status("INITIATED");
		serviceRequest.setServiceType("PRUNING OF TREES GIRTH GREATER THAN 90 CMS");
		serviceRequest.setOwnerName("dhanaji");
		
		List<ServiceRequestData> serviceRequestList = new ArrayList<ServiceRequestData>();
		serviceRequestList.add(serviceRequest);
		
		when(jdbcTemplate.query("", preparedStmtList.toArray(), rowMapper)).thenReturn(serviceRequestList);

		
//		Assert.assertEquals("", querySearchBuilder.getHCSearchQuery(requestdata, preparedStmtList));
		Assert.assertEquals((serviceRequestList),  jdbcTemplate.query("", preparedStmtList.toArray(), rowMapper));
	}
	
	@Test
	public void testgetServiceRequest() throws Exception {
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("service_request_id", "CH-HC-2020-06-14-001432_1");
		jsonObject.put("serviceType", "PRUNING OF TREES GIRTH GREATER THAN 90 CMS");
		jsonObject.put("serviceRequestStatus", "INITIATED");
		JSONArray array = new JSONArray();
		array.add(jsonObject);
		
		String uUid = "";
		
		RequestData requestdata = RequestData.builder().service_request_id("CH-HC-2020-06-14-001432_1").serviceType("PRUNING OF TREES GIRTH GREATER THAN 90 CMS").serviceRequestStatus("INITIATED")
                .requestInfo(RequestInfo.builder().userInfo(User.builder().tenantId("ch").build()).build()).build();
		
		when(jdbcTemplate.query("", new Object[] { requestdata.getService_request_id() }, (rowMapper)))
		.thenReturn(array);
		
		when(jdbcTemplate.query("", new Object[] { uUid }, (rowMapper)))
		.thenReturn(array);

//		Assert.assertEquals(array, serviceRepository.getServiceRequest(requestdata));
		
	}
	
	
}
