package org.egov.pm.util;

import java.util.Arrays;

import org.egov.common.contract.request.RequestInfo;
import org.egov.pm.model.ErrorResponseInfo;
import org.egov.pm.model.Errors;
import org.egov.pm.model.RequestData;
import org.egov.pm.model.RequestInfoWrapper;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class UserUtil {

	@Autowired
	RestTemplate restTemplate;

	@Value("${egov.user.hostname}")
	private String host;

	@Value("${egov.user.uri}")
	private String path;

	@Value("${egov.hrms.hostname}")
	private String hrms_host;

	@Value("${egov.hrms.uri}")
	private String hrms_path;

	public Errors validateUser(RequestData requestData) {
		String url = host + path;

		Errors er =Errors.builder().build();
		ErrorResponseInfo res = ErrorResponseInfo.builder().build();
		JSONObject userSearchRequest = new JSONObject();
		userSearchRequest.put("uuid", Arrays.asList(requestData.getRequestInfo().getUserInfo().getUuid()));
		try {
			JsonNode response = restTemplate.postForObject(url, userSearchRequest, JsonNode.class);
			if (response.get("user").size() > 0) {
				res.setMessage("success");

			} else {
				res.setCode("Invalid User");
				res.setMessage(
						"No user found for the uuids: [" + requestData.getRequestInfo().getUserInfo().getUuid() + "]");
			}
		} catch (Exception e) {
			res.setMessage("Error While Connecing user sevice");
		}
		er.setError(res);
		return er;
	}

	public JsonNode getUser(RequestInfo requestInfo,String userId) {
		String url = host + path;
		JsonNode response = null;
		ErrorResponseInfo res = ErrorResponseInfo.builder().build();
		JSONObject userSearchRequest = new JSONObject();
		userSearchRequest.put("uuid", Arrays.asList(userId));
		userSearchRequest.put("RequestInfo",requestInfo);
		try {
			response = restTemplate.postForObject(url, userSearchRequest, JsonNode.class);
		} catch (Exception e) {
			res.setMessage("Error While Connecing user sevice");
		}
		return response;
	}

	public JsonNode getUserByRole(RequestInfo requestInfo, String role, String tenantId) {
		String url = hrms_host + hrms_path;
		JsonNode response = null;
		try {
			UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url).queryParam("roles", role)
					.queryParam("tenantId", tenantId);
			response = restTemplate.postForObject(builder.toUriString(),
					RequestInfoWrapper.builder().requestInfo(requestInfo).build(), JsonNode.class);
		} catch (Exception e) {
			log.info("Error While Connecing HRMS sevice");
		}
		return response;
	}
	
}
