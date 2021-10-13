package org.egov.nulm.web.controller;

import javax.validation.Valid;

import org.egov.nulm.model.NulmSuhRequest;
import org.egov.nulm.model.ResponseInfoWrapper;
import org.egov.nulm.service.SuhService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/suh")
public class SuhController {

	private final SuhService service;

	@Autowired
	public SuhController(SuhService service) {
		this.service = service;
	}
	
	@PostMapping(value = "/_create")
	public ResponseEntity<ResponseInfoWrapper> createSuhApplication(@Valid @RequestBody NulmSuhRequest request) {
		return service.createSuhApplication(request);
	}
	
	@PostMapping(value = "/_update")
	public ResponseEntity<ResponseInfoWrapper> updateSuhApplication(@Valid @RequestBody NulmSuhRequest request) {
		return service.updateSuhApplication(request);
	}
	@PostMapping(value = "/_updateAppStatus")
	public ResponseEntity<ResponseInfoWrapper> updateSuhApplicationStatus(@Valid @RequestBody NulmSuhRequest request) {
		return service.updateSuhApplicationStatus(request);
	}
	@PostMapping(value = "/_get")
	public ResponseEntity<ResponseInfoWrapper> getSuhApplication( @RequestBody NulmSuhRequest request) {
		return service.getSuhApplication(request);
	}
	
	@PostMapping(value = "/_getShelterName")
	public ResponseEntity<ResponseInfoWrapper> getShelterName( @RequestBody NulmSuhRequest request) {
		return service.getShelterName(request);
	}
	
	
	
}
