package org.egov.integration.repository;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.egov.integration.config.ApiConfiguration;
import org.egov.integration.config.FireConfiguration;
import org.egov.integration.model.FireApplicationPendingDetail;
import org.egov.integration.model.FireApplicationPendingDetailSearch;
import org.egov.integration.model.FireApplicationReferenceNumber;
import org.egov.integration.model.FireRequestV2;
import org.egov.integration.model.FireService;
import org.egov.integration.model.FireServiceSearch;
import org.egov.integration.producer.Producer;
import org.egov.integration.repository.builder.FireNocApplicationQueryBuilder;
import org.egov.integration.repository.rowmapper.FireServiceDataRowMapper;
import org.egov.tracer.model.CustomException;
import org.egov.tracer.model.ServiceCallException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

@Repository
public class FireRepositoryV2 {

	@Autowired
	private Producer producer;

	@Autowired
	private FireConfiguration config;

	@Autowired
	private ApiConfiguration apiConfiguration;

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	public NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Autowired
	private FireServiceDataRowMapper fireServiceDataRowMapper;

	public void saveFireData(List<FireService> fireService) {
		FireRequestV2 infoWrapper = FireRequestV2.builder().fireService(fireService).build();
		producer.push(config.getFireDataSaveTopicV2(), infoWrapper);
	}

	public List<FireService> getServiceWiseData(FireServiceSearch fireServiceSearch) {
		Map<String, Object> paramValues = new HashMap<>();
		return namedParameterJdbcTemplate.query(FireNocApplicationQueryBuilder.GET_FIRE_SERVICE_DATA, paramValues,
				fireServiceDataRowMapper);
	}

	public List<FireApplicationPendingDetail> getApplicationPendingDetails(FireApplicationPendingDetailSearch request) {

		FireApplicationReferenceNumber applicationReferenceNumber = getApplicationReferenceNumber(request);
		if (applicationReferenceNumber != null && applicationReferenceNumber.getApplicationReferenceNumber() != null
				&& !applicationReferenceNumber.getApplicationReferenceNumber().isEmpty()
				&& applicationReferenceNumber.getApplicationReferenceNumber().contains(request.getReferenceNo())) {

			StringBuilder uri = new StringBuilder(apiConfiguration.getFireHost());
			uri.append(apiConfiguration.getFireApplicationPendingPath());

			Object fetchResult = fetchResult(uri, request);
			List<FireApplicationPendingDetail> applicationPendingDetails = null;
			try {
				applicationPendingDetails = objectMapper.convertValue(fetchResult,
						new TypeReference<List<FireApplicationPendingDetail>>() {
						});
			} catch (IllegalArgumentException e) {
				throw new CustomException("PARSING ERROR", "Failed to parse response of pull fire service data");
			}
			return applicationPendingDetails;
		}
		throw new CustomException("INVALID ERROR", "Invalid Application Reference Number");
	}

	public FireApplicationReferenceNumber getApplicationReferenceNumber(FireApplicationPendingDetailSearch request) {
		StringBuilder uri = new StringBuilder(apiConfiguration.getFireHost());
		uri.append(apiConfiguration.getFireApplicationReferenceNumberPath());

		request.setLocationId(apiConfiguration.getFireLocationId());
		request.setServiceId(apiConfiguration.getFireServiceId());

		Object fetchResult = fetchResult(uri, request);
		FireApplicationReferenceNumber fireApplicationReferenceNumber = null;
		try {
			objectMapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
			fireApplicationReferenceNumber = objectMapper.convertValue(fetchResult,
					new TypeReference<FireApplicationReferenceNumber>() {
					});
		} catch (IllegalArgumentException e) {
			throw new CustomException("PARSING ERROR", "Failed to parse response of pull fire service data");
		}
		return fireApplicationReferenceNumber;
	}

	public Object fetchResult(StringBuilder uri, Object request) {
		Object response = null;
		try {
			response = restTemplate.postForObject(uri.toString(), request, Object.class);
		} catch (HttpClientErrorException e) {
			throw new ServiceCallException(e.getResponseBodyAsString());
		} catch (Exception e) {
			throw new ServiceCallException(e.getMessage());
		}
		return response;
	}

}
