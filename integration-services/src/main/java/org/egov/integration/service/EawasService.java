package org.egov.integration.service;

import org.egov.common.contract.response.ResponseInfo;
import org.egov.integration.common.CommonConstants;
import org.egov.integration.config.EawasConfiguration;
import org.egov.integration.model.EawasRequestInfoWrapper;
import org.egov.integration.model.ResponseInfoWrapper;
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

}
