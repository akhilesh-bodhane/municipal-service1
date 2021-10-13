package org.egov.ec.web.controllers;

import javax.validation.Valid;

import org.egov.ec.service.AuctionService;
import org.egov.ec.web.models.RequestInfoWrapper;
import org.egov.ec.web.models.ResponseInfoWrapper;
import org.egov.ec.workflow.WorkflowIntegrator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.jaegertracing.thriftjava.Log;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/auction")
@Slf4j
public class AuctionController {

	private final AuctionService auctionService;

	@Autowired
	public AuctionController(AuctionService auctionService) {
		this.auctionService = auctionService;
	}

	/**
	* create  auction controller
	* 
	* @param RequestInfoWrapper List of auction items
	* @param requestHeader for saving device information
	* @return HTTP status 200 on success
	*/
	@PostMapping(value = "/_create")
	public ResponseEntity<ResponseInfoWrapper> addAuction(@Valid @RequestBody RequestInfoWrapper requestInfoWrapper,@RequestHeader("User-Agent") String requestHeader) {
		log.info("Entering: " + Thread.currentThread().getStackTrace()[1].getClassName()
				+ "."+ Thread.currentThread().getStackTrace()[1].getMethodName());
		return auctionService.addAuction(requestInfoWrapper,requestHeader);
	}

	/**
	* update  auction controller
	* 
	* @param RequestInfoWrapper object  of auction items
	* @return HTTP status 200 on success
	*/
	@PostMapping(value = "/_update")
	public ResponseEntity<ResponseInfoWrapper> updateAuction(
			@Valid @RequestBody RequestInfoWrapper requestInfoWrapper) {
		log.info("Entering: " + Thread.currentThread().getStackTrace()[1].getClassName()
				+ "."+ Thread.currentThread().getStackTrace()[1].getMethodName());
		return auctionService.updateAuction(requestInfoWrapper);
	}

	/**
	* get  auction controller
	* 
	* @param RequestInfoWrapper object  of EcSearchCriteria
	* @return HTTP status 200 on success
	*/
	@PostMapping(value = "/_get")
	public ResponseEntity<ResponseInfoWrapper> getAuction(@Valid @RequestBody RequestInfoWrapper requestInfoWrapper) {
		log.info("Entering: " + Thread.currentThread().getStackTrace()[1].getClassName()
				+ "."+ Thread.currentThread().getStackTrace()[1].getMethodName());
		return auctionService.getAuction(requestInfoWrapper);
	}
	
	/**
	* get  auction challan controller
	* 
	* @param RequestInfoWrapper object  of EcSearchCriteria
	* @return HTTP status 200 on success
	*/
	@PostMapping(value = "/_getChallan")
	public ResponseEntity<ResponseInfoWrapper> getAuctionChallan(@Valid @RequestBody RequestInfoWrapper requestInfoWrapper) {
		log.info("Entering: " + Thread.currentThread().getStackTrace()[1].getClassName()
				+ "."+ Thread.currentThread().getStackTrace()[1].getMethodName());
		return auctionService.getAuctionChallan(requestInfoWrapper);
	}

}
