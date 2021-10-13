package org.egov.nulm.web.controller;

import javax.validation.Valid;

import org.egov.nulm.model.OrganizationRequest;
import org.egov.nulm.model.ResponseInfoWrapper;
import org.egov.nulm.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/organization")
public class OrganizationController {

	private final OrganizationService service;

	@Autowired
	public OrganizationController(OrganizationService service) {
		this.service = service;
	}
	
	@PostMapping(value = "/_create")
	public ResponseEntity<ResponseInfoWrapper> createOrganization(@Valid @RequestBody OrganizationRequest request) {
		return service.createOrganization(request);
	}
	
	@PostMapping(value = "/_get")
	public ResponseEntity<ResponseInfoWrapper> getOrganization(@Valid @RequestBody OrganizationRequest request) {
		return service.getOrganization(request);
	}
	
	
   
}
