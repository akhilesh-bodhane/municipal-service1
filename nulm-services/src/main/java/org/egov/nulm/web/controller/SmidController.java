package org.egov.nulm.web.controller;

import javax.validation.Valid;

import org.egov.nulm.model.NulmSepRequest;
import org.egov.nulm.model.NulmSmidRequest;
import org.egov.nulm.model.ResponseInfoWrapper;
import org.egov.nulm.service.SepService;
import org.egov.nulm.service.SmidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/smid")
public class SmidController {

	private final SmidService service;

	@Autowired
	public SmidController(SmidService service) {
		this.service = service;
	}
	
	@PostMapping(value = "/_create")
	public ResponseEntity<ResponseInfoWrapper> createSMIDApplication(@Valid @RequestBody NulmSmidRequest smidrequest) {
		return service.createSMIDApplication(smidrequest);
	}
	
	@PostMapping(value = "/_get")
	public ResponseEntity<ResponseInfoWrapper> getSEPApplication(@RequestBody NulmSmidRequest smidrequest) {
		return service.getSMIDApplication(smidrequest);
	}
	
	@PostMapping(value = "/_update")
	public ResponseEntity<ResponseInfoWrapper> updateSMIDApplication(@Valid @RequestBody NulmSmidRequest smidrequest) {
		return service.updateSMIDApplication(smidrequest);
	}
	
	
	@PostMapping(value = "/_updateAppStatus")
	public ResponseEntity<ResponseInfoWrapper> updateSMIDApplicationStatus(@Valid @RequestBody NulmSmidRequest smidrequest) {
		return service.updateSMIDApplicationStatus(smidrequest);
	}
	
   
}
