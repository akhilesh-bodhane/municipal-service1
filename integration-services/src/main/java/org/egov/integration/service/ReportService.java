package org.egov.integration.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import org.egov.common.contract.response.ResponseInfo;
import org.egov.integration.PreApplicationRunnerImpl;
import org.egov.integration.common.CommonConstants;
import org.egov.integration.common.ModuleNameConstants;
import org.egov.integration.config.ApiConfiguration;
import org.egov.integration.model.DisplayColumns;
import org.egov.integration.model.ReportModel;
import org.egov.integration.model.ReportRequest;
import org.egov.integration.model.RequestData;
import org.egov.integration.model.ResponseInfoWrapper;
import org.egov.tracer.model.ServiceCallException;
import org.json.JSONException;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.google.gson.Gson;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ReportService {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private ApiConfiguration config;

	@SuppressWarnings("unchecked")
	public ResponseEntity<ResponseInfoWrapper> getData(ReportRequest request) throws JSONException, ParseException {

		DisplayColumns redata = PreApplicationRunnerImpl.getSqlQuery(request.getRequestBody().getModuleName());

		JSONObject dataPayload = new JSONObject();
		JSONObject resData1 = new JSONObject();
		Gson gson = new Gson();
		long fromdate = 0;
		long todate = 0;
		List<ReportModel> responseArray=new ArrayList<>();
	//	JSONArray responseArray = new JSONArray();
		RequestData requests = new RequestData();
		if (redata.getParameter1Format().equalsIgnoreCase("Long")) {
			ZonedDateTime zdt = LocalDate.now(ZoneId.of("Etc/UTC")).atTime(LocalTime.MIDNIGHT)
					.atZone(ZoneId.of("Etc/UTC"));
			fromdate = zdt.toInstant().toEpochMilli();
			ZonedDateTime zdt1 = zdt.plusDays(1);
			todate = zdt1.toInstant().toEpochMilli();

		}
		if (redata.getParameter1Format().equalsIgnoreCase("yyyy-mm-dd")) {

			dataPayload.put(redata.getParameter1(), LocalDate.now());
			dataPayload.put(redata.getParameter2(), LocalDate.now());

		}

		if (request.getRequestBody().getModuleName().equalsIgnoreCase(ModuleNameConstants.OPMS)) {
			StringBuilder url = new StringBuilder(config.getOPMSHost()).append(redata.getEndPoint());
			dataPayload.put(redata.getParameter1(), fromdate);
			dataPayload.put(redata.getParameter2(), todate);
			requests = new RequestData(request.getRequestInfo(), ModuleNameConstants.PETNOC, null, null, dataPayload,
					null);
			log.info("req" + requests);
			JsonNode result = fetchResult(url, requests);

			if (result != null) {
				for (JsonNode userInfo : result.get("nocApplicationDetail")) {
					LocalDate date = Instant.ofEpochMilli(userInfo.get("createdTime").asLong())
							.atZone(ZoneId.systemDefault()).toLocalDate();
					ReportModel response=ReportModel.builder().applicantId(userInfo.get("applicationId")).applicantSector(userInfo.get("sector"))
							.applicantSubmissionDate(date.toString()).serviceName( ModuleNameConstants.PETNOC).build();
				responseArray.add(response);
				}
			}
			requests = new RequestData(request.getRequestInfo(), ModuleNameConstants.SELLMEATNOC, null, null,
					dataPayload, null);
			log.info("req" + requests);
			JsonNode resultSellMeat = fetchResult(url, requests);
			if (resultSellMeat != null) {
				for (JsonNode userInfo : resultSellMeat.get("nocApplicationDetail")) {
					LocalDate date = Instant.ofEpochMilli(userInfo.get("createdTime").asLong())
							.atZone(ZoneId.systemDefault()).toLocalDate();
					ReportModel response=ReportModel.builder().applicantId(userInfo.get("applicationId")).applicantSector(userInfo.get("sector"))
							.applicantSubmissionDate(date.toString()).serviceName( ModuleNameConstants.SELLMEATNOC).build();
					
					responseArray.add(response);
				}
			}
			requests = new RequestData(request.getRequestInfo(), ModuleNameConstants.ADVERTISEMENTNOC, null, null,
					dataPayload, null);
			log.info("req" + requests);
			JsonNode resultAdv= fetchResult(url, requests);
			if (resultAdv != null) {
				for (JsonNode userInfo : resultAdv.get("nocApplicationDetail")) {
					LocalDate date = Instant.ofEpochMilli(userInfo.get("createdTime").asLong())
							.atZone(ZoneId.systemDefault()).toLocalDate();
					ReportModel response=ReportModel.builder().applicantId(userInfo.get("applicationId")).applicantSector(userInfo.get("sector"))
							.applicantSubmissionDate(date.toString()).serviceName( ModuleNameConstants.ADVERTISEMENTNOC).build();
					
					responseArray.add(response);
				}
			}
		}
		if (request.getRequestBody().getModuleName().equalsIgnoreCase(ModuleNameConstants.HORTICULTURE)) {
			StringBuilder url = new StringBuilder(config.getHortiHost()).append(redata.getEndPoint());
			requests = new RequestData(request.getRequestInfo(), request.getRequestBody().getModuleName(), fromdate,
					todate, null, null);
			log.info("url " + url);
			JsonNode result = fetchResult(url, requests);

			if (result != null) {
				for (JsonNode userInfo : result.get("services")) {
					String startDateString = userInfo.get("createdtime").toString().replaceAll("\"", "");
					SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
					SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
					ReportModel response=ReportModel.builder().applicantId(userInfo.get("service_request_id")).applicantSector(userInfo.get("locality"))
							.applicantSubmissionDate(sdf2.format(sdf.parse(startDateString))).serviceName( ModuleNameConstants.HORTICULTURE).build();
				
					responseArray.add(response);
				}
			}
		}
		if (request.getRequestBody().getModuleName().equalsIgnoreCase(ModuleNameConstants.ECHALLAN)) {
			StringBuilder url = new StringBuilder(config.getEchallanHost()).append(redata.getEndPoint());

			dataPayload.put("tenantId", "ch.chandigarh");
			dataPayload.put("encroachmentType", "");
			dataPayload.put("sector", "");
			dataPayload.put("siName", "");
			dataPayload.put("status", "");
			Object req = gson.fromJson(dataPayload.toString(), Object.class);
			log.info("before call" + request.getRequestInfo());
			requests = new RequestData(request.getRequestInfo(), request.getRequestBody().getModuleName(), null, null,
					null, req);

			JsonNode result = fetchResult(url, requests);

			if (result != null) {
				for (JsonNode userInfo : result.get("ResponseBody")) {
					LocalDate date = Instant.ofEpochMilli(userInfo.get("createdTime").longValue())
							.atZone(ZoneId.systemDefault()).toLocalDate();
					ReportModel response=ReportModel.builder().applicantId(userInfo.get("challanId")).applicantSector(userInfo.get("sector"))
							.applicantSubmissionDate(date.toString()).serviceName( ModuleNameConstants.ECHALLAN).build();
					responseArray.add(response);
				}
			}

		}

		return new ResponseEntity<>(ResponseInfoWrapper.builder()
				.responseInfo(ResponseInfo.builder().status(CommonConstants.SUCCESS).build())
				.responseBody(responseArray).build(), HttpStatus.OK);
	}

	public JsonNode fetchResult(StringBuilder uri, Object request) {
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
		JsonNode response = null;
		log.info("URI: " + uri.toString());
		try {
			log.info("Request: " + mapper.writeValueAsString(request));
			response = restTemplate.postForObject(uri.toString(), request, JsonNode.class);
		} catch (HttpClientErrorException e) {
			log.error("External Service threw an Exception: ", e);
			throw new ServiceCallException(e.getResponseBodyAsString());
		} catch (Exception e) {
			log.error("Exception while fetching from searcher: ", e);
		}

		return response;

	}
}
