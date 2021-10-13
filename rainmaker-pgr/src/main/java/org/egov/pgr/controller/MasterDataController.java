package org.egov.pgr.controller;

import javax.validation.Valid;

import org.egov.pgr.contract.AutoroutingMapReqSearchCriteria;
import org.egov.pgr.contract.AutoroutingMapRequest;
import org.egov.pgr.contract.AutoroutingMapResponse;
import org.egov.pgr.contract.RequestInfoWrapper;
import org.egov.pgr.contract.ServiceReqSearchCriteria;
import org.egov.pgr.service.MasterDataService;
import org.egov.pgr.validator.MasterRequestValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/v1/masters/")
public class MasterDataController {

	@Autowired
	private MasterDataService service;
	

	@Autowired
	private MasterRequestValidator masterRequestValidator;
	
	/**
	 * enpoint to create autorouting data
	 * 
	 * @param AutoroutingMapRequest
	 * @author Tonmoy
	 */
	@PostMapping("autorouting/_create")
	@ResponseBody
	private ResponseEntity<?> create(@RequestBody @Valid AutoroutingMapRequest autoroutingMapRequest) {
		masterRequestValidator.validateAutoRoutingRequest(autoroutingMapRequest, true);
		AutoroutingMapResponse response = service.create(autoroutingMapRequest);
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}

	/**
	 * enpoint to update autorouting data
	 * 
	 * @param AutoroutingMapRequest
	 * @author Tonmoy
	 */
	@PostMapping("autorouting/_update")
	@ResponseBody
	private ResponseEntity<?> update(@RequestBody @Valid AutoroutingMapRequest autoroutingMapRequest) {
		masterRequestValidator.validateAutoRoutingRequest(autoroutingMapRequest, false);
		AutoroutingMapResponse response = service.update(autoroutingMapRequest);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	

	/**
	 * Controller endpoint to fetch service requests
	 * 
	 * @param requestInfoWrapper
	 * @param serviceReqSearchCriteria
	 * @return ResponseEntity<?>
	 * @author vishal
	 */
	@PostMapping("autorouting/_fetch")
	@ResponseBody
	private ResponseEntity<?> fetch(@RequestBody @Valid RequestInfoWrapper requestInfoWrapper,
			@ModelAttribute @Valid AutoroutingMapReqSearchCriteria autoroutingMapReqSearchCriteria) {
		masterRequestValidator.validateSearch(autoroutingMapReqSearchCriteria, requestInfoWrapper.getRequestInfo());
		AutoroutingMapResponse response = service.getAutoroutingData(requestInfoWrapper.getRequestInfo(),autoroutingMapReqSearchCriteria);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

}
