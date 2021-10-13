package org.egov.integration.web.controller;

import javax.validation.Valid;

import org.egov.integration.model.ResponseInfoWrapper;
import org.egov.integration.service.FireService;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fire/v1")
public class FireController {

	private final FireService service;
	
	@Autowired
	public FireController(FireService service) {
		this.service = service;
	}
	
	/**
	 * post data of fire
	 * @param requestInfoWrapper 
	 * @return Fire Response
	 */
	@PostMapping(value = "/_pushData")
	public ResponseEntity<ResponseInfoWrapper> postData(@Valid @RequestBody JSONObject request) {		 
		return service.postData(request);		
	}
	
}
