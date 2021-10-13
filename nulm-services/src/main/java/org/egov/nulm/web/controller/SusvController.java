package org.egov.nulm.web.controller;

import javax.validation.Valid;

import org.egov.nulm.model.NulmSusvRequest;
import org.egov.nulm.model.ResponseInfoWrapper;
import org.egov.nulm.service.SusvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/susv")
public class SusvController {

	private final SusvService service;

	@Autowired
	public SusvController(SusvService service) {
		this.service = service;
	}
	
	@PostMapping(value = "/_create")
	public ResponseEntity<ResponseInfoWrapper> createSusvApplication(@Valid @RequestBody NulmSusvRequest request) {
		return service.createSusvApplication(request);
	}
	

	@PostMapping(value = "/_update")
	public ResponseEntity<ResponseInfoWrapper> updateSusvApplication(@Valid @RequestBody NulmSusvRequest request) {
		return service.updateSusvApplication(request);
	}
	
    @PostMapping(value = "/_updateAppStatus")
	public ResponseEntity<ResponseInfoWrapper> updateAppStatus(@Valid @RequestBody NulmSusvRequest request) {
		return service.updateAppStatus(request);
	}
    
    @PostMapping(value = "/_get")
	public ResponseEntity<ResponseInfoWrapper> getSusvApplication( @RequestBody NulmSusvRequest request) {
		return service.getSusvApplication(request);
	}
	
}
