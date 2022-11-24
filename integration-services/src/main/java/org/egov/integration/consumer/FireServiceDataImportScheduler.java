package org.egov.integration.consumer;

import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import java.util.UUID;
import java.util.stream.Collectors;

import org.egov.integration.config.ApiConfiguration;
import org.egov.integration.model.FireService;
import org.egov.integration.model.FireServiceSearch;
import org.egov.integration.repository.FireRepositoryV2;
import org.egov.integration.service.FireServiceV2;
import org.egov.tracer.model.CustomException;
import org.egov.tracer.model.ServiceCallException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class FireServiceDataImportScheduler {

	@Autowired
	private ApiConfiguration apiConfiguration;

	@Autowired
	private FireRepositoryV2 fireRepositoryV2;

	@Autowired
	private FireServiceV2 fireServiceV2;

	@Autowired
	private ObjectMapper mapper;

	@Autowired
	private RestTemplate restTemplate;

	/// @Scheduled(fixedDelay = 1000) //(cron="1 0 0 * * *") // Every day at 01:01
	/// AM
	@Scheduled(cron = "0 0 0 * * *", zone = "Asia/Calcutta") // Every day at 01:01 AM
	public void importServiceData() {
		System.out.println("Cro Started ");
		StringBuilder uri = new StringBuilder(apiConfiguration.getFireHost());
		uri.append(apiConfiguration.getFireServiceDataPath());
		FireServiceSearch fireServiceSearch = FireServiceSearch.builder().serviceId(apiConfiguration.getFireServiceId())
				.build();
		Object fetchResult = fetchResult(uri, fireServiceSearch);
		List<FireService> fireService = null;
		try {
			fireService = mapper.convertValue(fetchResult, new TypeReference<List<FireService>>() {
			});
		} catch (IllegalArgumentException e) {
			throw new CustomException("PARSING ERROR", "Failed to parse response of pull fire service data");
		}

		if (fireService != null) {
			fireService = fireService.stream().map(e -> {
				e.setUuid(UUID.randomUUID().toString());
				e.setCreatedBy("AutoScheduler");
				e.setCreatedTime(new Date().getTime());
				e.setLastModifiedBy("AutoScheduler");
				e.setLastModifiedTime(new Date().getTime());
				return e;
			}).collect(Collectors.toList());

			fireRepositoryV2.saveFireData(fireService);
		}
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
