package org.egov.integration.web.controller;

import javax.validation.Valid;

import org.egov.integration.model.EawasRequestInfoWrapper;
import org.egov.integration.model.ResponseInfoWrapper;
import org.egov.integration.service.EawasService;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/eawas/v1")
public class EawasController {


	private final EawasService service;
	
	@Autowired
	public EawasController(EawasService service) {
		this.service = service;
	} 
	
	
	@PostMapping(value = "/_get")
	public ResponseEntity<ResponseInfoWrapper> get(@Valid @RequestBody  EawasRequestInfoWrapper request) throws JSONException {		 
		return service.get(request);		
	}
}
