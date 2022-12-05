package org.egov.integration.web.controller;

import java.util.List;

import javax.validation.Valid;

import org.egov.integration.model.DomainWiseRequestInfoWrapper;
import org.egov.integration.model.MasterData;
import org.egov.integration.model.MasterDataResponse;
import org.egov.integration.model.RequestInfoWrapper;
//import org.egov.integration.model.RequestInfoWrapper;
import org.egov.integration.service.DomainWiseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/TLL/v1")
public class DomainWiseNiuaController {

//@Autowired
private final DomainWiseService domainWiseService;

//private final RequestInfoWrapper requestInfoWrapper;
	
	
//private final EawasService service;

@Autowired
public DomainWiseNiuaController(DomainWiseService domainWiseService ) {
	this.domainWiseService = domainWiseService;
//	this.requestInfoWrapper = requestInfoWrapper;
} 
	
	
	   @RequestMapping(value = {"/_searchDomainWise"}, method = RequestMethod.POST)
	    public ResponseEntity<MasterDataResponse> searchNIUADoaminWise(@Valid @RequestBody DomainWiseRequestInfoWrapper requestInfoWrapper,
	    		@RequestParam(name="tenantId", required = false, defaultValue = "ch.chandigarh") String tenantId  ) {
	       List<MasterData> searchNIUADoaminWise = domainWiseService.searchNIUADoaminWise( requestInfoWrapper.getRequestInfo(), tenantId);

	       MasterDataResponse metricsResponseBody = MasterDataResponse.builder().MasterData(searchNIUADoaminWise).build();

	       return new ResponseEntity<>( metricsResponseBody , HttpStatus.OK);
	    

	}
}
