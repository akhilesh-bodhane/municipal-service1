package org.egov.integration.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.egov.common.contract.request.RequestInfo;
import org.egov.integration.model.CommonBuckets;
import org.egov.integration.model.CommonMetrics;
import org.egov.integration.model.CommonReportRequest;
import org.egov.integration.model.CommonServiceReqSearchCriteria;
import org.egov.integration.model.LiveUlbsCount;
import org.egov.integration.model.ParamValue;
import org.egov.integration.repository.builder.CommonQueryBuilder;
import org.egov.integration.repository.rowmapper.TotalCitizenCountRowMapper;
import org.egov.tracer.model.ServiceCallException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.google.gson.Gson;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class CommonDaoImpl implements CommonDao{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private CommonQueryBuilder commonQueryBuilder;
	
	@Autowired
	private TotalCitizenCountRowMapper totalCitizenCountRowMapper ;
	
	@Value("${egov.report.host}")
	private String reportHost;

	@Value("${egov.report.pgr.search.endpoint}")
	private String reportEndpoint;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public CommonMetrics getCommonTotalCollectionListCountNIUA(RequestInfo requestInfo,CommonServiceReqSearchCriteria serviceReqSearchCriteria) {
		
		List<Object> preparedStatement = new ArrayList<>();
		
		
		List<LiveUlbsCount> build3 = new ArrayList<>();
		
	    LiveUlbsCount connection = new LiveUlbsCount();
	    
	    Object response = fetchGrievancesSLAAchievement(requestInfo, serviceReqSearchCriteria);
	    
	    System.out.println("Report Response" + response);
				
		String groupby="serviceModuleCode";
					
		List<CommonBuckets> query2 = null;
		
		List<CommonMetrics> totalCitizensCount = totalCitizensCount(preparedStatement, requestInfo);
					
		//data(preparedStatement, requestInfo);
		
		query2 = Stream.of(
				           //new Buckets("SW",01),
				           new CommonBuckets("TL",01),
				           new CommonBuckets("PGR",01),
				           new CommonBuckets("WS",01)
				           //,new buckets("NOC",01),				           
				           //new Buckets("ECHALLAN",01)
				           ).collect(Collectors.toList());
					
		connection.setGroupBy(groupby);
		connection.setBuckets(query2);
		build3.add(connection);
				
		CommonMetrics build = CommonMetrics.builder().liveUlbsCount(build3).build();
		
		build.setStatus("Live");
		build.setOnboardedUlbsCount(01);
		build.setTotalCitizensCount(totalCitizensCount.get(0).getTotalCitizensCount());
		build.setTotalLiveUlbsCount(01);
		build.setTotalUlbCount(01);
		
		
		Gson gson = new Gson();
        String json = gson.toJson(build);
		
		return build;
	}
	
	
private List<CommonMetrics> totalCitizensCount(List<Object> preparedStatement, RequestInfo requestInfo) {
		
		String query = commonQueryBuilder.getSearchQueryStringTotalCitizensCount(preparedStatement, requestInfo);
		
			List<CommonMetrics> query2 = jdbcTemplate.query(query, preparedStatement.toArray(),totalCitizenCountRowMapper);
		
				
		return query2;
	}


public Object fetchGrievancesSLAAchievement(RequestInfo requestInfo,
		CommonServiceReqSearchCriteria serviceReqSearchCriteria) {
	
	System.out.println("fetchGrievancesSLAAchievement method");
	StringBuilder uri = new StringBuilder();
	CommonReportRequest reportRequest = prepareSearchGrievancesSLAAchievement(uri,
			serviceReqSearchCriteria.getTenantId(), serviceReqSearchCriteria.getStartDate(),
			serviceReqSearchCriteria.getEndDate(), requestInfo);
	Object response = null;
	try {
		response = fetchResult(uri, reportRequest);
	} catch (Exception e) {
		log.error("Exception while fetching serviceCodes: " + e);
	}
	System.out.println("fetchGrievancesSLAAchievement method response :"+ response);
	return response;

}

public CommonReportRequest prepareSearchGrievancesSLAAchievement(StringBuilder uri, String tenantId, Long fromDate,
		Long toDate, RequestInfo requestInfo) {
	uri.append(reportHost).append(reportEndpoint);
	System.out.println("URI :"+uri);
	List<ParamValue> searchParams = Arrays.asList(ParamValue.builder().name("fromDate").input(fromDate).build(),
			ParamValue.builder().name("toDate").input(toDate).build());
	return CommonReportRequest.builder().tenantId(tenantId).reportName("SLAAchievementDepartmentWise")
			.requestInfo(requestInfo).searchParams(searchParams).build();
}

public Object fetchResult(StringBuilder uri, Object request) {
	ObjectMapper mapper = new ObjectMapper();
	mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
	Object response = null;
	try {
		response = restTemplate.postForObject(uri.toString(), request, Map.class);
		System.out.println("fetchResult method response :"+response);
	} catch (HttpClientErrorException e) {
		log.error("External Service threw an Exception: ", e);
		throw new ServiceCallException(e.getResponseBodyAsString());
	} catch (Exception e) {
		log.error("Exception while fetching from searcher: ", e);
	}
	return response;

}
		
}
