package org.egov.integration.service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.egov.common.contract.request.RequestInfo;
import org.egov.integration.config.ApiConfiguration;
import org.egov.integration.model.McollectNiuaSchedulerLog;
import org.egov.integration.model.McollectNiuaSchedulerRequest;
import org.egov.integration.model.RequestInfoWrapper;
import org.egov.integration.model.UserChargesReport;
import org.egov.integration.producer.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Service
public class NIUADataPushService {

	private final RestTemplate restTemplate = new RestTemplate();
	private final ApiConfiguration apiConfiguration;
	private static final String TENANT_ID = "ch.chandigarh";
	
	@Autowired
	private Producer producer;
	
	private final ObjectMapper objectMapper;
	
	
	@Autowired
	public NIUADataPushService(ApiConfiguration apiConfiguration,ObjectMapper objectMapper) {
		super();
		this.apiConfiguration = apiConfiguration;
		this.objectMapper = objectMapper;
	}

	public UserChargesReport fetchDataFromProduction(RequestInfoWrapper request) {
		try {
			LocalDate today = LocalDate.now();
			ZonedDateTime fromDateTime = today.atStartOfDay(ZoneId.of("Asia/Kolkata"));
			ZonedDateTime toDateTime = today.plusDays(1).atStartOfDay(ZoneId.of("Asia/Kolkata"));

			long fromDateMillis = fromDateTime.toInstant().toEpochMilli();
			long toDateMillis = toDateTime.toInstant().toEpochMilli();

			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);

			RequestInfo requestInfo = request.getRequestInfo();
			HttpEntity<RequestInfo> requestInfo2 = new HttpEntity<>(requestInfo, headers);

			String integrationHost = apiConfiguration.getIntegrationHost();
			String servicePath = apiConfiguration.getNIUAMCollectServiceDataPath();

			StringBuilder uri = new StringBuilder(integrationHost);
			uri.append(servicePath);
			String url = uri.toString();

			String finalUrl = UriComponentsBuilder.fromHttpUrl(url).queryParam("tenantId", TENANT_ID)
					.queryParam("startDate", fromDateMillis).queryParam("endDate", toDateMillis).toUriString();

			System.out.println("Final url for fetching is :" + finalUrl);

			UserChargesReport response = restTemplate.postForObject(finalUrl, request, UserChargesReport.class);

			System.out.println("fromDate in Epoch Millis: " + fromDateMillis);
			System.out.println("ToDate in Epoch Millis: " + toDateMillis);
			System.out.println(
					"Response of Production API: " + new GsonBuilder().setPrettyPrinting().create().toJson(response));

			if (response.getMetrics() != null) {
				// Process the valid response
				System.out.println("User Charges Report Received");
				System.out.println("Response of Production API: "
						+ new GsonBuilder().setPrettyPrinting().create().toJson(response));
				return response;
			} else {
				// Handle null response
				System.out.println("Received null response from the API.");

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public ResponseEntity<Map> pushDataToNIUA(UserChargesReport finalData) {
		Map<String, Object> requestBody = new LinkedHashMap<>();
		Map<String, Object> requestInfo = new LinkedHashMap<>();

		requestInfo.put("apiId", "asset-services");
		requestInfo.put("msgId", "search with from and to values");
		requestInfo.put("authToken", "655bf367-e365-49d8-a54a-60f7aac5ca24");

		Map<String, Object> userInfo = new LinkedHashMap<>();
		userInfo.put("id", 10229);
		userInfo.put("uuid", "c499b45b-7d65-418f-b003-5ce5db2220d2");
		userInfo.put("userName", "679087|sSTvGEwvzXtWV07onOvUHilYqNe01RSLLQ==");
		userInfo.put("name", "CHD NDA USER");
		userInfo.put("mobileNumber", "9999999943");
		userInfo.put("type", "SYSTEM");

		List<Map<String, String>> roles = new ArrayList<>();
		Map<String, String> role = new LinkedHashMap<>();
		role.put("name", "National Dashboard Systeme user");
		role.put("code", "NDA_SYSTEM");
		role.put("tenantId", "chd.municipalcorporationchandigarh");
		roles.add(role);

		userInfo.put("roles", roles);
		userInfo.put("active", true);
		userInfo.put("tenantId", "chd.municipalcorporationchandigarh");
		requestInfo.put("userInfo", userInfo);
		requestBody.put("RequestInfo", requestInfo);
		
		String todayDate = LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));

		List<UserChargesReport> data = new ArrayList<>();
		finalData.setDate(todayDate);
		finalData.setModule("MCOLLECT");
		finalData.setWard("Chandigarh");
		finalData.setUlb("chd.municipalcorporationchandigarh");
		finalData.setState("Chandigarh");
		finalData.setRegion("Chandigarh");
		data.add(finalData);
		requestBody.put("Data", data);

		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		System.out.println("Formatted Request Body for NIUA API: \n" + gson.toJson(requestBody));

		String url = apiConfiguration.getUpyogniuaHost() + apiConfiguration.getUpyogniuaingestPath();

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<Map<String, Object>> requestEntity = new HttpEntity<>(requestBody, headers);
		
		
		String uuid = UUID.randomUUID().toString();
		McollectNiuaSchedulerLog mcollectSchedulerlog = new McollectNiuaSchedulerLog();
		mcollectSchedulerlog.setId(uuid);
		mcollectSchedulerlog.setTenantid(TENANT_ID);
	    
		McollectNiuaSchedulerRequest mcollectNiuaSchedulerRequest = new McollectNiuaSchedulerRequest();
		mcollectNiuaSchedulerRequest.setMcollectNiuaSchedulerRequest(mcollectSchedulerlog);

		try {
			ResponseEntity<Map> response = restTemplate.exchange(url, HttpMethod.POST, requestEntity, Map.class);
					
			if (response.getStatusCode().is2xxSuccessful()) {
				System.out.println("Data successfully pushed to MCOLLECT NIUA API");
				
				mcollectSchedulerlog.setStatus("SUCCESS");            
                mcollectSchedulerlog.setDescription(objectMapper.writeValueAsString(response.getBody()) + " - Status Code: " + response.getStatusCode());
                producer.push(apiConfiguration.getMCOLLECTNIUASchedulerLogSaveTopic(), mcollectNiuaSchedulerRequest);
				return response;
			} else {
				System.out.println("Failed to push data. HTTP Status: " + response.getStatusCode());
				
				mcollectSchedulerlog.setStatus("FAILED");
				mcollectSchedulerlog.setDescription("Failed to post MCOLLECT data::"+"-"+"Status Code::"+response.getStatusCode());
                producer.push(apiConfiguration.getMCOLLECTNIUASchedulerLogSaveTopic(), mcollectNiuaSchedulerRequest);
				
				return ResponseEntity.status(response.getStatusCode()).body(Collections.singletonMap("error", "Failed to push data to NIUA API"));
			}
		} catch (HttpStatusCodeException e) {
			System.out.println("HTTP Error: " + e.getStatusCode());
			System.out.println("Response Body: " + e.getResponseBodyAsString());
			
			mcollectSchedulerlog.setStatus("FAILED");
			mcollectSchedulerlog.setDescription("Failed to post MCOLLECT data HTTPStatusCodeException::"+"-"+"Response Body::"+e.getResponseBodyAsString()+"-"+"Status Code::"+e.getStatusCode());
            producer.push(apiConfiguration.getMCOLLECTNIUASchedulerLogSaveTopic(), mcollectNiuaSchedulerRequest);
			
			 return ResponseEntity.status(e.getStatusCode()).body(Collections.singletonMap("Error from NIUA API:", e.getResponseBodyAsString()));
		} catch (Exception e) {
			System.out.println("Unexpected Error: " + e.getMessage());
			e.printStackTrace();
			mcollectSchedulerlog.setStatus("FAILED");
			mcollectSchedulerlog.setDescription("Failed to post MCOLLECT data Exception::"+e.getMessage());
	        producer.push(apiConfiguration.getMCOLLECTNIUASchedulerLogSaveTopic(), mcollectNiuaSchedulerRequest);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Collections.singletonMap("error", "An unexpected error occurred while pushing data."));
		}
	}
}
