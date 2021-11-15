package org.egov.nulm.web.controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.egov.nulm.common.CommonConstants;
import org.egov.nulm.model.NulmSusvRenewRequest;
import org.egov.nulm.model.ResponseInfoWrapper;
import org.egov.nulm.model.SuhApplication;
import org.egov.nulm.repository.builder.NULMQueryBuilder;
import org.egov.nulm.service.SusvRenewService;
import org.egov.tracer.model.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/susv/renew")
public class SusvRenewController {

	private final SusvRenewService service;

	@Autowired
	public SusvRenewController(SusvRenewService service) {
		this.service = service;
	}

	@PostMapping(value = "/_create")
	public ResponseEntity<ResponseInfoWrapper> createSusvRenewApplication(
			@Valid @RequestBody NulmSusvRenewRequest request) {
		return service.createSusvRenewApplication(request);
	}

	@PostMapping(value = "/_update")
	public ResponseEntity<ResponseInfoWrapper> updateSuhApplication(
			@Valid @RequestBody NulmSusvRenewRequest request) {
		return service.updateSusvRenewApplication(request);
	}

	@PostMapping(value = "/_get")
	public ResponseEntity<ResponseInfoWrapper> getSusvRenewApplication(@RequestBody NulmSusvRenewRequest request) {
		return service.getSusvRenewApplication(request);
	}
	
	@PostMapping(value = "/_checkCovNo")
	public ResponseEntity<ResponseInfoWrapper> getCheckCov(@RequestBody NulmSusvRenewRequest request) {
		return service.checkCovNo(request);
	}

    @PostMapping(value = "/_updateAppStatus")
	public ResponseEntity<ResponseInfoWrapper> updateAppStatus(@Valid @RequestBody NulmSusvRenewRequest request) {
		return service.updateAppStatus(request);
	}

}
