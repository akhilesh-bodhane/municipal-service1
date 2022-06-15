package org.egov.temporarystall.web.controller;

import javax.validation.Valid;


import org.egov.temporarystall.model.ResponseInfoWrapper;
import org.egov.temporarystall.model.StallRequest;
import org.egov.temporarystall.service.StallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stall")
public class TemporaryStallController {
	
	private final StallService stallService;
	
	@Autowired
	public TemporaryStallController(StallService stallService) {
		this.stallService = stallService;
	}
	
	@PostMapping(value = "/_create")
	public ResponseEntity<ResponseInfoWrapper>createStallApplication(@Valid @RequestBody StallRequest stallrequest){
		return stallService.createStallApplication(stallrequest);
	}
	
	@PostMapping(value = "/_get")
	public ResponseEntity<ResponseInfoWrapper> getStallApplication(@RequestBody StallRequest stallrequest) {
		return stallService.getSTALLApplication(stallrequest);
	}
	
	@PostMapping(value = "/_update")
	public ResponseEntity<ResponseInfoWrapper> updateStallApplication(@RequestBody StallRequest stallrequest) throws Exception {
		return stallService.updateStallApplication(stallrequest);
	}

}
