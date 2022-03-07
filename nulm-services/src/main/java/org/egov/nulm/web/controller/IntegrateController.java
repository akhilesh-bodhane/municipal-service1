package org.egov.nulm.web.controller;

import javax.validation.Valid;

import org.egov.nulm.model.NulmSepRequest;
import org.egov.nulm.model.NulmSmidRequest;
import org.egov.nulm.model.SmidApplicationy;
import org.egov.nulm.model.NulmSusvRequest;
import org.egov.nulm.model.NulmSuhRequest;
import org.egov.nulm.model.Integratrequest;
import org.egov.nulm.model.IntegratrequestPayload;
import org.egov.nulm.model.ResponseInfoWrapper;
import org.egov.nulm.service.SepService;
import org.egov.nulm.service.IntegrateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.models.auth.In;

@RestController
@RequestMapping("/v1/Nulm")
public class IntegrateController {

	private final IntegrateService service;

	@Autowired
	public IntegrateController(IntegrateService service) {
		this.service = service;
	}
	

	
	@PostMapping(value = "/_get")
	public ResponseEntity<Integratrequest> getSMIDApplication(@RequestBody IntegratrequestPayload smidrequests) {

		return service.getSMIDApplication(smidrequests);
	}
	
	
	
   
}
