package org.egov.integration.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.egov.common.contract.request.RequestInfo;
import org.egov.common.contract.response.ResponseInfo;
import org.egov.integration.common.CommonConstants;
import org.egov.integration.config.EawasConfiguration;
import org.egov.integration.model.Bucket;
import org.egov.integration.model.EawasRequestInfoWrapper;
//import org.egov.tl.web.models.TradeLicense;
//import org.egov.tl.web.models.TradeLicenseSearchCriteria;
import org.egov.integration.model.Metrics;
import org.egov.integration.model.RequestData;
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
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

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
//	        List<TradeLicense> licenses;
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

			List<TLBucket> paymentChannelTypeTodaysCollectionBucket = paymentChannel.stream()
					.collect(Collectors.groupingBy(TLNIUAModel::getGateway,
							Collectors.summingDouble(TLNIUAModel::getTransactions)))
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

}
