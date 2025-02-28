package org.egov.pgr.service;

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
import org.egov.pgr.model.GrievanceReport;
import org.egov.pgr.model.PGRNiuaSchedulerLog;
import org.egov.pgr.model.PGRNiuaSchedulerRequest;
import org.egov.pgr.model.RequestInfoWrapper;
import org.egov.pgr.producer.PGRProducer;
import org.egov.pgr.utils.ErrorConstants;
import org.egov.pgr.utils.PGRUtils;
import org.egov.tracer.model.CustomException;
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
import com.google.gson.GsonBuilder;

@Service
public class NIUADataPushService {

	private final PGRUtils pgrUtils;

	private final RestTemplate restTemplate = new RestTemplate();

	private static final String TENANT_ID = "ch.chandigarh";
	
	@Autowired
	private PGRProducer producer;
	
	private final ObjectMapper objectMapper;

	@Autowired
	public NIUADataPushService(PGRUtils pgrUtils,ObjectMapper objectMapper) {
		super();
		this.pgrUtils = pgrUtils;
		this.objectMapper = objectMapper;
	}

	public GrievanceReport fetchDataFromProduction(RequestInfoWrapper request) {

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

			String integrationHost = pgrUtils.getNiuaServiceHost();

			String serviceHost = pgrUtils.getNiuaDataGet();

			StringBuilder uri = new StringBuilder(integrationHost);

			uri.append(serviceHost);

			String url = uri.toString();
			

			String finalUrl = UriComponentsBuilder.fromHttpUrl(url).queryParam("tenantId", TENANT_ID)
					.queryParam("startDate", fromDateMillis).queryParam("endDate", toDateMillis).toUriString();
			
			System.out.println("Final Url for Fetching is :" + finalUrl);

			System.out.println("fromDate in Epoch Millis" + fromDateMillis);
			System.out.println("ToDate in Epoch Millis" + toDateMillis);
			 
			
			GrievanceReport response = restTemplate.postForObject(finalUrl, request, GrievanceReport.class);

			if (response != null) {
		        // Process the valid response
		        System.out.println("Grievance Report received");
		        System.out.println("Response of Production API: "
						+ new GsonBuilder().setPrettyPrinting().create().toJson(response));
		        return response;
		    } else {
		        // Handle null response
		        System.out.println("Received null response from the API.");
		       
		    }
			
				
		
		} catch (Exception e) {
			throw new CustomException(ErrorConstants.ERROR_CODE_GRIVENCE, e.getMessage());
		}
		return null;
	}


	public ResponseEntity<Map> pushDataToNIUA(GrievanceReport finalData) {
	    // Using LinkedHashMap to maintain insertion order
	    Map<String, Object> requestBody = new LinkedHashMap<>();
	    Map<String, Object> requestInfo = new LinkedHashMap<>();

	    requestInfo.put("apiId", "asset-services");
	    requestInfo.put("ver", null);
	    requestInfo.put("ts", null);
	    requestInfo.put("action", null);
	    requestInfo.put("did", null);
	    requestInfo.put("key", null);
	    requestInfo.put("msgId", "search with from and to values");
	    requestInfo.put("authToken", "655bf367-e365-49d8-a54a-60f7aac5ca24");

	    Map<String, Object> userInfo = new LinkedHashMap<>();
	    userInfo.put("id", 10229);
	    userInfo.put("uuid", "c499b45b-7d65-418f-b003-5ce5db2220d2");
	    userInfo.put("userName", "679087|sSTvGEwvzXtWV07onOvUHilYqNe01RSLLQ==");
	    userInfo.put("name", "CHD NDA USER");
	    userInfo.put("mobileNumber", "9999999943");
	    userInfo.put("emailId", null);
	    userInfo.put("locale", null);
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
	    userInfo.put("permanentCity", null);

	    requestInfo.put("userInfo", userInfo);
	    requestBody.put("RequestInfo", requestInfo);
	    
	    String todayDate = LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));

	    List<GrievanceReport> data = new ArrayList<>();
	    finalData.setDate(todayDate); // Remember to add the todayDate after Testing
	    finalData.setModule("PGR");
	    finalData.setWard("Chandigarh");
	    finalData.setUlb("chd.municipalcorporationchandigarh");
	    finalData.setState("Chandigarh");
	    finalData.setRegion("Chandigarh");

	    data.add(finalData);
	    requestBody.put("Data", data);

	    System.out.println("Formatted Request Body of NIUA: "
	            + new GsonBuilder().setPrettyPrinting().create().toJson(requestBody));

	    StringBuilder uri = new StringBuilder(pgrUtils.getUpyogServiceHost());
	    uri.append(pgrUtils.getUpyogDataPost());

	    String url = uri.toString();
	    HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.APPLICATION_JSON);
	    HttpEntity<Map<String, Object>> requestEntity = new HttpEntity<>(requestBody, headers);
	    
		
		String uuid = UUID.randomUUID().toString();
		PGRNiuaSchedulerLog pgrSchedulerlog = new PGRNiuaSchedulerLog();
		pgrSchedulerlog.setId(uuid);
		pgrSchedulerlog.setTenantid(TENANT_ID);
	    
		PGRNiuaSchedulerRequest pgrNiuaSchedulerRequest = new PGRNiuaSchedulerRequest();
		pgrNiuaSchedulerRequest.setPGRNiuaSchedulerRequest(pgrSchedulerlog);

	    try {
	        ResponseEntity<Map> response = restTemplate.exchange(url, HttpMethod.POST, requestEntity, Map.class);

	        System.out.println("NIUA Response: " + response.getBody());

	        if (response.getStatusCode().is2xxSuccessful() && response.getBody() != null) {
	            System.out.println("Data successfully pushed to NIUA API");
	            //String responseBody = new Gson().toJson(response.getBody());
	            
	            pgrSchedulerlog.setStatus("SUCCESS");               
                pgrSchedulerlog.setDescription(objectMapper.writeValueAsString(response.getBody()) + " - Status Code: " + response.getStatusCode());
                producer.push(pgrUtils.getPGRNIUASchedulerLogSaveTopic(), pgrNiuaSchedulerRequest);
	            
	            return response;
	        } else {
	            System.out.println("Failed to push data: " + response.getStatusCode());
	            
	            pgrSchedulerlog.setStatus("FAILED");
	            pgrSchedulerlog.setDescription("Failed to post PGR data::"+"-"+"Status Code::"+response.getStatusCode());
	            producer.push(pgrUtils.getPGRNIUASchedulerLogSaveTopic(), pgrNiuaSchedulerRequest);
				            
	            return ResponseEntity.status(response.getStatusCode()).body(Collections.singletonMap("error", "Failed to push data to NIUA API"));
	        }
	    } catch (HttpStatusCodeException e) {
	        System.out.println("HTTP Status Code: " + e.getStatusCode());
	        System.out.println("Response Body: " + e.getResponseBodyAsString());
	        
	        pgrSchedulerlog.setStatus("FAILED");
	        pgrSchedulerlog.setDescription("Failed to post PGR data HTTPStatusCodeException::"+"-"+"Response Body::"+e.getResponseBodyAsString()+"-"+"Status Code::"+e.getStatusCode());           
            producer.push(pgrUtils.getPGRNIUASchedulerLogSaveTopic(), pgrNiuaSchedulerRequest);
            
	        return ResponseEntity.status(e.getStatusCode()).body(Collections.singletonMap("Error from PGR NIUA API:", e.getResponseBodyAsString()));
	        
	    } catch (Exception e) {
	        e.printStackTrace();
	        pgrSchedulerlog.setStatus("FAILED");
	        pgrSchedulerlog.setDescription("Failed to post PGR data Exception::"+e.getMessage());
            producer.push(pgrUtils.getPGRNIUASchedulerLogSaveTopic(), pgrNiuaSchedulerRequest);
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Collections.singletonMap("error", "An unexpected error occurred while pushing data."));
	    }
	}
}