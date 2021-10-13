package org.egov.nulm.web.controller;

import javax.validation.Valid;

import org.egov.nulm.model.NulmSepRequest;
import org.egov.nulm.model.ResponseInfoWrapper;
import org.egov.nulm.service.SepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/sep")
public class SepController {

	private final SepService sepService;

	@Autowired
	public SepController(SepService sepService) {
		this.sepService = sepService;
	}
	
	@PostMapping(value = "/_create")
	public ResponseEntity<ResponseInfoWrapper> createSEPApplication(@Valid @RequestBody NulmSepRequest seprequest) {
		return sepService.createSEPApplication(seprequest);
	}
	
	@PostMapping(value = "/_get")
	public ResponseEntity<ResponseInfoWrapper> getSEPApplication(@RequestBody NulmSepRequest seprequest) {
		return sepService.getSEPApplication(seprequest);
	}
	
	@PostMapping(value = "/_update")
	public ResponseEntity<ResponseInfoWrapper> updateSEPApplication(@Valid @RequestBody NulmSepRequest seprequest) {
		return sepService.updateSEPApplication(seprequest);
	}
	
	@PostMapping(value = "/_updateAppStatus")
	public ResponseEntity<ResponseInfoWrapper> updateSEPApplicationStatus(@Valid @RequestBody NulmSepRequest seprequest) {
		return sepService.updateSEPApplicationStatus(seprequest);
	}
   
}
