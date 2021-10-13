package org.egov.integration.service;

import org.egov.common.contract.response.ResponseInfo;
import org.egov.integration.common.CommonConstants;
import org.egov.integration.config.ApiConfiguration;
import org.egov.integration.model.IntegrationRequestInfoWrapper;
import org.egov.integration.model.ResponseInfoWrapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
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

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class IntegrationService {

	@Autowired
	private  RestTemplate rest;

	@Autowired
	private ApiConfiguration config;

	public ResponseEntity<ResponseInfoWrapper> get(IntegrationRequestInfoWrapper request)  {
		JSONObject responseInfo =new JSONObject();
			
		HttpHeaders http = new HttpHeaders();
		http.setContentType(MediaType.APPLICATION_JSON);
		http.add("Authorization", "Bearer "+config.getUrlShortnerKey());
		MultiValueMap<String, Object> mmap = new LinkedMultiValueMap<String, Object>();
		mmap.add("url", request.getIntegrationRequest().getUrl());
		JSONObject object=new JSONObject();
		object.put("url",  request.getIntegrationRequest().getUrl());
		HttpEntity<MultiValueMap<String, Object>> entity = new HttpEntity(object, http);
		log.info("integration-services logs :: url shortner() :: Before calling urlshortner APi");
		JsonNode response = rest.postForObject(config.getUrlShortnerHost().concat(config.getUrlShortnerPath()),entity,
				JsonNode.class);
				if (response!=null) {
					ObjectMapper mapper = new ObjectMapper();
					log.info("ShortURL Success : " + response);
					 responseInfo = mapper.convertValue(response.get("data"), JSONObject.class);
					
					
				} else {
					log.info("ShortURL Failed : Reason " + response);
				}

		

		Gson gson = new Gson();
		
		return new ResponseEntity<>(ResponseInfoWrapper.builder()
				.responseInfo(ResponseInfo.builder().status(CommonConstants.SUCCESS).build()).responseBody(responseInfo)
				.build(), HttpStatus.OK);
	}

}
