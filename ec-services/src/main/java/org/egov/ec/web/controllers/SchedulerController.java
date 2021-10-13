package org.egov.ec.web.controllers;

import javax.validation.Valid;

import org.egov.ec.service.EcSchedulerService;
import org.egov.ec.web.models.EcSearchCriteria;
import org.egov.ec.web.models.RequestInfoWrapper;
import org.egov.ec.web.models.ResponseInfoWrapper;
import org.egov.ec.web.models.ResponseInfoWrapper.ResponseInfoWrapperBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/scheduler")
public class SchedulerController {

	private final EcSchedulerService ecSchedulerService;

	@Autowired
	public SchedulerController( EcSchedulerService ecSchedulerService) {
		this.ecSchedulerService = ecSchedulerService;

	}

	@PostMapping(value = "/_updatePenalty")
	public ResponseEntity<?> updateFineAmount(@Valid @RequestBody RequestInfoWrapper requestInfoWrapper, 
			@ModelAttribute @Valid EcSearchCriteria ecSearchCriteria) {
		ResponseEntity<ResponseInfoWrapper> res = ecSchedulerService.updateFineAmount(requestInfoWrapper,ecSearchCriteria);
		
		return new ResponseEntity<>(res, HttpStatus.CREATED);
	}

	@PostMapping(value = "/_auctionReminder")
	public ResponseEntity<?> fetchAuctionReport(@Valid @RequestBody RequestInfoWrapper requestInfoWrapper, 
			@ModelAttribute @Valid EcSearchCriteria ecSearchCriteria) {
		ResponseEntity<ResponseInfoWrapper> res = ecSchedulerService.fetchAuctionReport(requestInfoWrapper,ecSearchCriteria);
		return new ResponseEntity<>(res, HttpStatus.CREATED);
	}

	@PostMapping(value = "/_updateChallanStatus")
	public ResponseEntity<?> updateChallanStatus(@Valid @RequestBody RequestInfoWrapper requestInfoWrapper, 
			@ModelAttribute @Valid EcSearchCriteria ecSearchCriteria) {
		ResponseEntity<ResponseInfoWrapper> res = ecSchedulerService.updateChallanStatus(requestInfoWrapper,ecSearchCriteria);
		return new ResponseEntity<>(res, HttpStatus.CREATED);
	}
	
	@PostMapping(value = "/_updateAuctionStatus")
	public ResponseEntity<?> updateAuctionStatus(@Valid @RequestBody RequestInfoWrapper requestInfoWrapper, 
			@ModelAttribute @Valid EcSearchCriteria ecSearchCriteria) {
		ResponseEntity<ResponseInfoWrapper> res = ecSchedulerService.updateAuctionStatus(requestInfoWrapper,ecSearchCriteria);
		return new ResponseEntity<>(res, HttpStatus.CREATED);
	}
	


}
