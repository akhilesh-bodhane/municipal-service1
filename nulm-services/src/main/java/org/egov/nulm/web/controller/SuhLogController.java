package org.egov.nulm.web.controller;

import org.egov.nulm.model.NulmSuhLogRequest;
import org.egov.nulm.model.ResponseInfoWrapper;
import org.egov.nulm.service.SuhLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/suh/log")
public class SuhLogController {

	private final SuhLogService service;

	@Autowired
	public SuhLogController(SuhLogService service) {
		this.service = service;
	}
	
	@PostMapping(value = "/_create")
	public ResponseEntity<ResponseInfoWrapper> createSuhLog( @RequestBody NulmSuhLogRequest request) {
		return service.createSuhLog(request);
	}
	
	@PostMapping(value = "/_get")
	public ResponseEntity<ResponseInfoWrapper> getSuhLog( @RequestBody NulmSuhLogRequest request) {
		return service.getSuhLog(request);
	}
	@PostMapping(value = "/_delete")
	public ResponseEntity<ResponseInfoWrapper> deleteSuhLog( @RequestBody NulmSuhLogRequest request) {
		return service.deleteSuhLog(request);
	}
}
