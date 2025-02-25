package org.egov.integration.service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.egov.common.contract.request.RequestInfo;
import org.egov.common.contract.response.ResponseInfo;
import org.egov.integration.common.CommonConstants;
import org.egov.integration.config.ApiConfiguration;
import org.egov.integration.config.EawasConfiguration;
import org.egov.integration.model.Bucket;
import org.egov.integration.model.EawasRequestInfoWrapper;
//import org.egov.tl.web.models.TradeLicense;
//import org.egov.tl.web.models.TradeLicenseSearchCriteria;
import org.egov.integration.model.Metrics;
import org.egov.integration.model.RequestData;
import org.egov.integration.model.RequestInfoWrap;
import org.egov.integration.model.RequestInfoWrapper;
import org.egov.integration.model.ResponseInfoWrapper;
import org.egov.integration.model.TLBucket;
import org.egov.integration.model.TLDashboardRequestInfoWrapper;
import org.egov.integration.model.TLNIUAModel;
import org.egov.integration.model.TLPublicDashboard;
import org.egov.integration.model.TLPublicDashboardResponseInfo;
import org.egov.integration.model.TodaysCollection;
import org.egov.integration.model.applicationsMovedToday;
import org.egov.integration.model.todaysTradeLicenses;
import org.egov.integration.repository.TLniuaRepository;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class EawasService {

	@Autowired
	private RequestFactory requestFactory;

	@Autowired
	private TLniuaRepository tLniuaRepository;

	@Autowired
	private EawasConfiguration config;
	
	@Autowired
	private ApiConfiguration apiConfiguration;

	public ResponseEntity<ResponseInfoWrapper> get(EawasRequestInfoWrapper request) throws JSONException {
		RestTemplate restTemplate = requestFactory.getRestTemplate();
		HttpHeaders http = new HttpHeaders();
		http.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		MultiValueMap<String, Object> mmap = new LinkedMultiValueMap<String, Object>();
		mmap.add("wsmsconstrant", config.getWsmsconstrant());
		HttpEntity<MultiValueMap<String, Object>> entity = new HttpEntity(mmap, http);
		String responses = restTemplate.postForObject(config.getEwawsHost(), entity, String.class);
		Object obj = new Object();
		JSONObject xmlJSONObj = new JSONObject();
		JSONObject objDAtanew2 = new JSONObject();
		try {

			if (null != responses) {
				xmlJSONObj = XML.toJSONObject(responses);
				if (xmlJSONObj.has("DataSet")) {
					JSONObject objDAta = xmlJSONObj.getJSONObject("DataSet");
					if (objDAta.has("diffgr:diffgram")) {
						JSONObject objDAtanew = objDAta.getJSONObject("diffgr:diffgram");
						if (objDAtanew.has("NewDataSet")) {
							JSONObject objDAtanew1 = objDAtanew.getJSONObject("NewDataSet");
							if (objDAtanew1.has("Table")) {
								objDAtanew2 = objDAtanew1.getJSONObject("Table");
							}
						}
					}
				}

			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		Gson gson = new Gson();

		// Converting json to object

		Object organisation = gson.fromJson(objDAtanew2.toString(), Object.class);
		return new ResponseEntity<>(ResponseInfoWrapper.builder()
				.responseInfo(ResponseInfo.builder().status(CommonConstants.SUCCESS).build()).responseBody(organisation)
				.build(), HttpStatus.OK);
	}

	public Metrics searchNIUA(RequestData criteria, RequestInfo requestInfo, String serviceFromPath) {
		Metrics licensesForNIUA = getLicensesForNIUA(criteria, requestInfo);
		return licensesForNIUA;
	}

	public Metrics getLicensesForNIUA(RequestData criteria, RequestInfo requestInfo) {
		List<TLNIUAModel> licensesNIUA = tLniuaRepository.getLicensesNIUAUpdated(criteria);

		Metrics metrics = Metrics.builder().build();

		if (!licensesNIUA.isEmpty()) {

			List<TLBucket> tradeTypeTodaysCollectionBucket = licensesNIUA.stream().collect(Collectors
					.groupingBy(TLNIUAModel::getTradeType, Collectors.summingDouble(TLNIUAModel::getTransactions)))
					.entrySet().stream().map(e -> {
						return new TLBucket(e.getKey(), e.getValue());
					}).collect(Collectors.toList());

			List<TLNIUAModel> paymentChannel = licensesNIUA.stream()
					.filter(e -> e.getGateway() != null && !e.getGateway().isEmpty()).collect(Collectors.toList());

			List<TLBucket> paymentChannelTypeTodaysCollectionBucket = paymentChannel.stream().collect(Collectors
					.groupingBy(TLNIUAModel::getGateway, Collectors.summingDouble(TLNIUAModel::getTodaysCollection)))
					.entrySet().stream().map(e -> {
						return new TLBucket(e.getKey(), e.getValue());
					}).collect(Collectors.toList());

			TodaysCollection todaysCollectionTradeType = TodaysCollection.builder().groupBy("tradeType")
					.buckets(tradeTypeTodaysCollectionBucket).build();

			TodaysCollection todaysCollectionPaymentChannelType = TodaysCollection.builder()
					.groupBy("paymentChannelType").buckets(paymentChannelTypeTodaysCollectionBucket).build();

			List<TodaysCollection> todaysCollectionList = new ArrayList<TodaysCollection>();
			todaysCollectionList.add(todaysCollectionTradeType);
			todaysCollectionList.add(todaysCollectionPaymentChannelType);

			metrics.setTodaysCollection(todaysCollectionList);

			List<TLBucket> todaysTradeLicensesCollectionBucket = licensesNIUA.stream()
					.collect(Collectors.groupingBy(TLNIUAModel::getStatus,
							Collectors.summingDouble(TLNIUAModel::getTodaysTradeLicenses)))
					.entrySet().stream().map(e -> {
						return new TLBucket(e.getKey(), e.getValue());
					}).collect(Collectors.toList());

			todaysTradeLicenses todaysTradeLicensesBucket = todaysTradeLicenses.builder().groupBy("status")
					.buckets(todaysTradeLicensesCollectionBucket).build();

			List<todaysTradeLicenses> todaysTradeLicensesList = new ArrayList<todaysTradeLicenses>();
			todaysTradeLicensesList.add(todaysTradeLicensesBucket);
			metrics.setTodaysTradeLicenses(todaysTradeLicensesList);

			List<TLBucket> applicationsMovedTodayCollectionBucket = licensesNIUA.stream()
					.collect(Collectors.groupingBy(TLNIUAModel::getStatus,
							Collectors.summingDouble(TLNIUAModel::getApplicationsMovedToday)))
					.entrySet().stream().map(e -> {
						return new TLBucket(e.getKey(), e.getValue());
					}).collect(Collectors.toList());

			applicationsMovedToday applicationsMovedTodays = applicationsMovedToday.builder().groupBy("status")
					.buckets(applicationsMovedTodayCollectionBucket).build();

			List<applicationsMovedToday> applicationsMovedTodayList = new ArrayList<applicationsMovedToday>();
			applicationsMovedTodayList.add(applicationsMovedTodays);
			metrics.setApplicationsMovedToday(applicationsMovedTodayList);

			Double transactions = licensesNIUA.stream().map(TLNIUAModel::getTransactions).reduce(0.0, Double::sum);
			Integer todaysApprovedApplicationsWithinSLA = licensesNIUA.stream()
					.map(TLNIUAModel::getTodaysApprovedApplicationsWithinSLA).reduce(0, Integer::sum);
			Integer todaysApplications = licensesNIUA.stream().map(TLNIUAModel::getTodaysTradeLicenses).reduce(0,
					Integer::sum);
			Double tlTax = licensesNIUA.stream().map(TLNIUAModel::getTaxAmount).reduce(0.0, Double::sum);
			Double adhocPenalty = licensesNIUA.stream().map(TLNIUAModel::getPenaltyAmount).reduce(0.0, Double::sum);

			Integer todaysApprovedApplications = licensesNIUA.stream().map(TLNIUAModel::getTodaysApprovedApplications)
					.reduce(0, Integer::sum);

			Integer avgDaysForApplicationApproval = licensesNIUA.stream()
					.map(TLNIUAModel::getAvgDaysForApplicationApproval).reduce(0, Integer::sum);

			metrics.setTransactions(transactions);
			metrics.setTodaysLicenseIssuedWithinSLA(todaysApprovedApplicationsWithinSLA);
			metrics.setTodaysApplications(todaysApplications);
			metrics.setTlTax(tlTax);
			metrics.setAdhocPenalty(adhocPenalty);
			metrics.setAdhocRebate(0.0);
			metrics.setTodaysLicenseIssuedWithinSLA(todaysApprovedApplicationsWithinSLA);
			metrics.setTodaysApprovedApplications(todaysApprovedApplications);
			metrics.setTodaysApprovedApplicationsWithinSLA(todaysApprovedApplicationsWithinSLA);
			metrics.setAvgDaysForApplicationApproval(avgDaysForApplicationApproval);

			Integer approvedLicense = licensesNIUA.stream().map(TLNIUAModel::getApprovedLicense).reduce(0,
					Integer::sum);

			Integer approvedCompletionDaysLicense = licensesNIUA.stream()
					.map(TLNIUAModel::getApprovedCompletionDaysLicense).reduce(0, Integer::sum);

			metrics.setStipulatedDays(approvedLicense > 0 ? approvedCompletionDaysLicense / approvedLicense : 0);

		}

		return metrics;
	}

	public TLPublicDashboardResponseInfo publicDashboard(TLDashboardRequestInfoWrapper dashboardRequestInfoWrapper) {

		try {
			TLPublicDashboard tlPublicDashboard = tLniuaRepository
					.publicDashboard(dashboardRequestInfoWrapper.getDataPayload());

			if (tlPublicDashboard == null)
				return TLPublicDashboardResponseInfo.builder()
						.responseInfo(ResponseInfo.builder().status("Failed").msgId("No Data Available.").build())
						.build();

			return TLPublicDashboardResponseInfo.builder()
					.responseInfo(ResponseInfo.builder().status("Success").build()).tlPublicDashboard(tlPublicDashboard)
					.build();
		} catch (Exception e) {
			return TLPublicDashboardResponseInfo.builder()
					.responseInfo(ResponseInfo.builder().status("Failed").msgId(e.getMessage()).build()).build();
		}
	}
	
	public  Map<String, Object> searchNIUAScheduler(RequestInfoWrapper request) {
		 Map<String, Object> licensesForNIUA = getTLNIUAData(request);
		return licensesForNIUA;
	}
	
	
	public  Map<String, Object> getTLNIUAData(RequestInfoWrapper request) {

	    LocalDate today = LocalDate.now();
	    ZonedDateTime fromDateTime = today.atStartOfDay(ZoneId.of("Asia/Kolkata"));
	    ZonedDateTime toDateTime = today.plusDays(1).atStartOfDay(ZoneId.of("Asia/Kolkata"));

	    long fromDateMillis = fromDateTime.toInstant().toEpochMilli();
	    long toDateMillis = toDateTime.toInstant().toEpochMilli();
	    
	    StringBuilder uri = new StringBuilder(apiConfiguration.getIntegrationHost());
		uri.append(apiConfiguration.getNIUASearchServiceDataPath());
		
		String queryParams = String.format("?tenantId=ch.chandigarh&fromDate=%d&toDate=%d", fromDateMillis, toDateMillis);
		uri.append(queryParams);
		String url = uri.toString();
	    
	    RestTemplate restTemplate = requestFactory.getRestTemplate();
	    //Object response;
	    try {	    	
	    	 ObjectMapper mapper = new ObjectMapper();
	       //response =  restTemplate.postForObject(url, request, Object.class);
	       Map<String, Object> responseMap = restTemplate.postForObject(url, request, Map.class);
	      
	        
	       if (responseMap != null && !responseMap.isEmpty()) {
	        	
	        	 // Convert response to Map
	           
	           // Map<String, Object> responseMap = mapper.convertValue(response, Map.class);
	            Map<String, Object> metrics = (Map<String, Object>) responseMap.get("metrics");

	            // Extract "todaysApplications" value
	            if (metrics != null) {
	            	int todaysApplications = (int) metrics.getOrDefault("todaysApplications", 0);
	                System.out.println("Today's Applications: " + todaysApplications);
	                postToNIUADashboard(request,responseMap,todaysApplications);		                
	            }else {
	            System.out.println("Metrics not found in the response.");
	            }
	            return responseMap;
	        } else {
	            System.out.println("Response is null or empty.");
	            return new HashMap<>();
	        }
	        
	    } catch (HttpStatusCodeException e) {
	        System.out.println("HTTP Status Code: " + e.getStatusCode());
	        System.out.println("Response Body: " + e.getResponseBodyAsString());
	        e.printStackTrace();
	    } catch (Exception e) {
	        e.printStackTrace();
	    } 
	    return new HashMap<>();
	}
	
	public void postToNIUADashboard(RequestInfoWrapper request, Map<String, Object> responseData, int todaysApplications) {

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
	    userInfo.put("tenantId", "chd.municipalcorporationchandigarh");
	    userInfo.put("permanentCity", null);

	    Map<String, Object> role = new LinkedHashMap<>();
	    role.put("name", "National Dashboard Systeme user");
	    role.put("code", "NDA_SYSTEM");
	    role.put("tenantId", "chd.municipalcorporationchandigarh");

	    userInfo.put("roles", Collections.singletonList(role));
	    userInfo.put("active", true);

	    requestInfo.put("userInfo", userInfo);
	    requestBody.put("RequestInfo", requestInfo); // Ensure RequestInfo is first in the body

	    Map<String, Object> dataEntry = new LinkedHashMap<>();

	    String todayDate = LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
	    dataEntry.put("date", todayDate);
	    dataEntry.put("module", "TL");
	    dataEntry.put("ward", "Chandigarh");
	    dataEntry.put("ulb", "chd.municipalcorporationchandigarh");
	    dataEntry.put("region", "Chandigarh");
	    dataEntry.put("state", "Chandigarh");

	    if (responseData != null && responseData.containsKey("metrics")) {
	        dataEntry.put("metrics", responseData.get("metrics"));
	    } else {
	        dataEntry.put("metrics", responseData); 
	    }

	    requestBody.put("Data", Collections.singletonList(dataEntry)); // Add Data after RequestInfo
	    
	    StringBuilder uri = new StringBuilder(apiConfiguration.getUpyogniuaHost());
		uri.append(apiConfiguration.getUpyogniuaingestPath());
		String url = uri.toString();

	    // Use RestTemplate to make the POST request
	    RestTemplate restTemplate = requestFactory.getRestTemplate();
	    try {
	        if (todaysApplications > 0) {
	        	ResponseEntity<Map> response = restTemplate.postForEntity(url, requestBody, Map.class);
	            System.out.println("upyog response:::"+response.getBody());
	            if (response.getStatusCode().is2xxSuccessful()) {
	                System.out.println("Successfully posted data to NIUA Dashboard");
	            } else {
	                System.out.println("Failed to post data. Status: " + response.getStatusCode());
	            }
	        } else {
	        	System.out.println("No applications today. Skipping data post.");
	        }
	    } catch (HttpStatusCodeException e) {
	        System.out.println("HTTP Status Code: " + e.getStatusCode());
	        System.out.println("Response Body: " + e.getResponseBodyAsString());
	        e.printStackTrace();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
	
	public  Map<String, Object> searchOBPSNIUAScheduler(RequestInfoWrap request) {
		 Map<String, Object> OBPSForNIUA = getOBPSNIUAData(request);
		return OBPSForNIUA;
	}
	
	
	public  Map<String, Object> getOBPSNIUAData(RequestInfoWrap request) {
	    
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	    
	 // Get current date as fromDate
        String fromDate = LocalDate.now().format(formatter);
        System.out.println("From Date: " + fromDate);
        
     // Get the next date as toDate
        String toDate = LocalDate.now().plusDays(1).format(formatter);
        System.out.println("To Date: " + toDate);
	    	    
	    StringBuilder uri = new StringBuilder(apiConfiguration.getObpsHost());
		uri.append(apiConfiguration.getNIUASearchOBPSDataPath());
		
		String queryParams = String.format("?tenantId=ch.chandigarh&fromDate=%s&toDate=%s", fromDate, toDate);
		uri.append(queryParams);
		String url = uri.toString();
	    
	    RestTemplate restTemplate = requestFactory.getRestTemplate();
	    //Object response;
	    try {	    	
	    	 ObjectMapper mapper = new ObjectMapper();
	       //response =  restTemplate.postForObject(url, request, Object.class);
	       Map<String, Object> responseMap = restTemplate.postForObject(url, request, Map.class);
	       
	       Map<String, Object> processOBPSData = processOBPSData(responseMap);
	      
	        
	       if (processOBPSData != null && !processOBPSData.isEmpty()) {
	        	
	            Map<String, Object> metrics = (Map<String, Object>) processOBPSData.get("metrics");

	            // Extract "todaysApplications" value
	            if (metrics != null) {
	            	int applicationsSubmitted = (int) metrics.getOrDefault("applicationsSubmitted", 0);
	                System.out.println("Today's Applications Submitted: " + applicationsSubmitted);
	                postToOBPSNIUADashboard(request,processOBPSData,applicationsSubmitted);		                
	            }else {
	            System.out.println("Metrics not found in the response.");
	            }
	            return responseMap;
	            
	        } else {
	            System.out.println("Response is null or empty.");
	            return new HashMap<>();
	        }
	        
	    } catch (HttpStatusCodeException e) {
	        System.out.println("HTTP Status Code: " + e.getStatusCode());
	        System.out.println("Response Body: " + e.getResponseBodyAsString());
	        e.printStackTrace();
	    } catch (Exception e) {
	        e.printStackTrace();
	    } 
	    return new HashMap<>();
	}
	

	public Map<String, Object> processOBPSData(Map<String, Object> responseMap) {
	    if (responseMap == null || responseMap.isEmpty()) {
	        System.out.println("Response map is null or empty.");
	        return responseMap;
	    }

	    // Step 1: Replace "NA" with "0" for specific keys
	    Map<String, Object> metrics = (Map<String, Object>) responseMap.get("metrics");
	    if (metrics != null) {
	        replaceNAWithZero(metrics, "todaysCompletedApplicationsWithinSLAOC");
	        replaceNAWithZero(metrics, "todaysCompletedApplicationsWithinSLAPermit");
	        replaceNAWithZero(metrics, "slaComplianceOC");
	        replaceNAWithZero(metrics, "slaCompliancePermit");
	    }

	    // Step 2: Convert groupBy keys to camel case
	    List<Map<String, Object>> permitsIssued = (List<Map<String, Object>>) metrics.get("permitsIssued");
	    if (permitsIssued != null) {
	        for (Map<String, Object> group : permitsIssued) {
	            String groupBy = (String) group.get("groupBy");
	            if (groupBy != null) {
	                group.put("groupBy", toCamelCase(groupBy));
	            }
	        }
	    }

	    return responseMap;
	}

	private void replaceNAWithZero(Map<String, Object> map, String key) {
	    if (map.containsKey(key) && "NA".equals(map.get(key))) {
	        map.put(key, "0");
	    }
	}

	private String toCamelCase(String input) {
	    if (input == null || input.isEmpty()) {
	        return input;
	    }
	    String[] parts = input.split("(?=[A-Z])"); // Split by uppercase letters
	    String result = parts[0].toLowerCase();
	    for (int i = 1; i < parts.length; i++) {
	        result += parts[i].substring(0, 1).toUpperCase() + parts[i].substring(1).toLowerCase();
	    }
	    return result;
	}
	
	
	public void postToOBPSNIUADashboard(RequestInfoWrap request, Map<String, Object> responseData, int todaysApplications) {

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
	    userInfo.put("tenantId", "chd.municipalcorporationchandigarh");
	    userInfo.put("permanentCity", null);

	    Map<String, Object> role = new LinkedHashMap<>();
	    role.put("name", "National Dashboard Systeme user");
	    role.put("code", "NDA_SYSTEM");
	    role.put("tenantId", "chd.municipalcorporationchandigarh");

	    userInfo.put("roles", Collections.singletonList(role));
	    userInfo.put("active", true);

	    requestInfo.put("userInfo", userInfo);
	    requestBody.put("RequestInfo", requestInfo); // Ensure RequestInfo is first in the body

	    Map<String, Object> dataEntry = new LinkedHashMap<>();

	    String todayDate = LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
	    dataEntry.put("date", todayDate);
	    dataEntry.put("module", "OBPS");
	    dataEntry.put("ward", "Chandigarh");
	    dataEntry.put("ulb", "chd.municipalcorporationchandigarh");
	    dataEntry.put("region", "Chandigarh");
	    dataEntry.put("state", "Chandigarh");

	    if (responseData != null && responseData.containsKey("metrics")) {
	        dataEntry.put("metrics", responseData.get("metrics"));
	    } else {
	        dataEntry.put("metrics", responseData); 
	    }

	    requestBody.put("Data", Collections.singletonList(dataEntry)); // Add Data after RequestInfo
	    
	    StringBuilder uri = new StringBuilder(apiConfiguration.getUpyogniuaHost());
		uri.append(apiConfiguration.getUpyogniuaingestPath());
		String url = uri.toString();

	    // Use RestTemplate to make the POST request
	    RestTemplate restTemplate = requestFactory.getRestTemplate();
	    try {
	        if (todaysApplications > 0) {
	        	ResponseEntity<Map> response = restTemplate.postForEntity(url, requestBody, Map.class);
	            System.out.println("upyog OBPS response:::"+response.getBody());
	            if (response.getStatusCode().is2xxSuccessful()) {
	                System.out.println("Successfully posted OBPS data to NIUA Dashboard");
	            } else {
	                System.out.println("Failed to post OBPS data. Status: " + response.getStatusCode());
	            }
	        } else {
	        	System.out.println("No OBPS applications today. Skipping data post.");
	        }
	    } catch (HttpStatusCodeException e) {
	        System.out.println("HTTP Status Code: " + e.getStatusCode());
	        System.out.println("Response Body: " + e.getResponseBodyAsString());
	        e.printStackTrace();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

	
	
	

}
