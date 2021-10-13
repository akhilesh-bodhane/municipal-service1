package org.egov.ec.web.controllers;

import javax.validation.Valid;

import org.egov.ec.service.StoreItemRegisterService;
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
@RequestMapping("/storeitemregister")
@Slf4j
public class StoreItemRegisterController {

	private final StoreItemRegisterService storeItemRegisterService;

	@Autowired
	public StoreItemRegisterController(StoreItemRegisterService storeItemRegisterService) {
		this.storeItemRegisterService = storeItemRegisterService;
	}

	/**
	* get  StoreItemRegister  controller
	* 
	* @param RequestInfoWrapper Object of EcSearchCriteria
	* @return HTTP status 200 on success
	*/
	
	@PostMapping(value = "/_get")
	public ResponseEntity<ResponseInfoWrapper> getStorItemRegister(
			@Valid @RequestBody RequestInfoWrapper requestInfoWrapper) {
		log.info("Entering: " + Thread.currentThread().getStackTrace()[1].getClassName()
				+ "."+ Thread.currentThread().getStackTrace()[1].getMethodName());
		return storeItemRegisterService.getStoreRegisterItem(requestInfoWrapper);
	}

	/**
	* create  StoreItemRegister  controller
	* 
	* @param RequestInfoWrapper List of StoreItemRegister
	* @param requestHeader for saving device information
	* @return HTTP status 200 on success
	*/
	@PostMapping(value = "/_create")
	public ResponseEntity<ResponseInfoWrapper> createstoreItemRegister(
			@Valid @RequestBody RequestInfoWrapper requestInfoWrapper,@RequestHeader("User-Agent") String requestHeader) {
		log.info("Entering: " + Thread.currentThread().getStackTrace()[1].getClassName()
				+ "."+ Thread.currentThread().getStackTrace()[1].getMethodName());
		return storeItemRegisterService.createStoreRegisterItem(requestInfoWrapper,requestHeader);
	}

	/**
	* update  StoreItemRegister  controller
	* 
	* @param RequestInfoWrapper Object of StoreItemRegister
	* @return HTTP status 200 on success
	*/
	@PostMapping(value = "/_update")
	public ResponseEntity<ResponseInfoWrapper> updateChallan(
			@Valid @RequestBody RequestInfoWrapper requestInfoWrapper) {
		log.info("Entering: " + Thread.currentThread().getStackTrace()[1].getClassName()
				+ "."+ Thread.currentThread().getStackTrace()[1].getMethodName());
		return storeItemRegisterService.updateStoreRegisterItem(requestInfoWrapper);
	}

	/**
	* update  StoreItemRegister payment details controller
	* 
	* @param RequestInfoWrapper Object of StoreItemRegister
	* @return HTTP status 200 on success
	*/
	@PostMapping(value = "/_updateStorePayment")
	public ResponseEntity<ResponseInfoWrapper> updateStorePayment(
			@Valid @RequestBody RequestInfoWrapper requestInfoWrapper) {
		log.info("Entering: " + Thread.currentThread().getStackTrace()[1].getClassName()
				+ "."+ Thread.currentThread().getStackTrace()[1].getMethodName());
		return storeItemRegisterService.updateStorePayment(requestInfoWrapper);
	}

}
