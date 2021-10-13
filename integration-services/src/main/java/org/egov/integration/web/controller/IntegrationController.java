package org.egov.integration.web.controller;

import javax.validation.Valid;

import org.egov.integration.model.IntegrationRequestInfoWrapper;
import org.egov.integration.model.ResponseInfoWrapper;
import org.egov.integration.service.IntegrationService;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/integration/v1")
public class IntegrationController {


	private final IntegrationService service;
	
	@Autowired
	public IntegrationController(IntegrationService service) {
		this.service = service;
	} 
	
	
	@PostMapping(value = "/_getTinyUrl")
	public ResponseEntity<ResponseInfoWrapper> get( @RequestBody  IntegrationRequestInfoWrapper request) throws JSONException {		 
		return service.get(request);		
	}
}
