package org.egov.ec.web.controllers;

import javax.validation.Valid;

import org.egov.ec.service.VendorRegistrationService;
import org.egov.ec.web.models.RequestInfoWrapper;
import org.egov.ec.web.models.ResponseInfoWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/vendor")
@Slf4j
public class VendorRegistrationContorller {

	private final VendorRegistrationService vendorService;

	@Autowired
	public VendorRegistrationContorller(VendorRegistrationService vendorService) {
		this.vendorService = vendorService;
	}

	/**
	* get  vendorMaster  controller
	* 
	* @param RequestInfoWrapper Object of EcSearchCriteria
	* @return HTTP status 200 on success
	*/
	@PostMapping(value = "/_get")
	public ResponseEntity<ResponseInfoWrapper> getChallan(@Valid @RequestBody RequestInfoWrapper requestInfoWrapper) {
		log.info("Entering: " + Thread.currentThread().getStackTrace()[1].getClassName()
				+ "."+ Thread.currentThread().getStackTrace()[1].getMethodName());
		return vendorService.getVendor(requestInfoWrapper);
	}
	
	/**
	* create  vendorMaster  controller
	* 
	* @param RequestInfoWrapper List of vendorMaster
	* @param requestHeader for saving device information
	* @return HTTP status 200 on success
	*/
	@PostMapping(value = "/_create")
	public ResponseEntity<ResponseInfoWrapper> generateChallan(
			@Valid @RequestBody RequestInfoWrapper requestInfoWrapper,@RequestHeader("User-Agent") String requestHeader) {
		log.info("Entering: " + Thread.currentThread().getStackTrace()[1].getClassName()
				+ "."+ Thread.currentThread().getStackTrace()[1].getMethodName());
		return vendorService.createVendor(requestInfoWrapper,requestHeader);
	}

	/**
	* update  vendorMaster  controller
	* 
	* @param RequestInfoWrapper Object of vendorMaster
	* @return HTTP status 200 on success
	*/
	@PostMapping(value = "/_update")
	public ResponseEntity<ResponseInfoWrapper> updateChallan(
			@Valid @RequestBody RequestInfoWrapper requestInfoWrapper) {
		log.info("Entering: " + Thread.currentThread().getStackTrace()[1].getClassName()
				+ "."+ Thread.currentThread().getStackTrace()[1].getMethodName());
		return vendorService.updateVendor(requestInfoWrapper);
	}

}
