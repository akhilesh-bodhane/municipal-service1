package org.egov.integration.web.controller;

import javax.validation.Valid;

import org.egov.integration.model.FireApplicationPendingDetailSearch;
import org.egov.integration.model.FireServiceSearch;
import org.egov.integration.model.RequestInfoFire;
import org.egov.integration.model.ResponseFireV2;
import org.egov.integration.model.ResponseInfoFire;
import org.egov.integration.model.ResponseInfoWrapper;
import org.egov.integration.service.FireServiceV2;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fire/v2")
public class FireControllerV2 {

	private final FireServiceV2 service;

	@Autowired
	public FireControllerV2(FireServiceV2 service) {
		this.service = service;
	}

	@PostMapping(value = "/_getServiceWiseData")
	public ResponseEntity<ResponseInfoWrapper> getServiceWiseData(
			@Valid @RequestBody FireServiceSearch fireServiceSearch) {
		return service.getServiceWiseData(fireServiceSearch);
	}

	@PostMapping(value = "/_getApplicationPendingDetails")
	public ResponseEntity<ResponseFireV2> getApplicationPendingDetails(
			@Valid @RequestBody FireApplicationPendingDetailSearch request) {
		return service.getApplicationPendingDetails(request);
	}
}
