package org.egov.nulm.web.controller;

import javax.validation.Valid;

import org.egov.nulm.model.NulmSmidAlfRequest;
import org.egov.nulm.model.ResponseInfoWrapper;
import org.egov.nulm.service.SmidALFService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/alf")
public class SmidALFController {

	private final SmidALFService service;

	@Autowired
	public SmidALFController(SmidALFService service) {
		this.service = service;
	}
	
	@PostMapping(value = "/_create")
	public ResponseEntity<ResponseInfoWrapper> createAlfApplication(@Valid @RequestBody NulmSmidAlfRequest request) {
		return service.createAlfApplication(request);
	}
	
	@PostMapping(value = "/_update")
	public ResponseEntity<ResponseInfoWrapper> updateAlfApplication(@Valid @RequestBody NulmSmidAlfRequest request) {
		return service.updateAlfApplication(request);
	}
	
	@PostMapping(value = "/_get")
	public ResponseEntity<ResponseInfoWrapper> getAlfApplication( @RequestBody NulmSmidAlfRequest request) {
		return service.getAlfApplication(request);
	}
	
	
	
	
}
