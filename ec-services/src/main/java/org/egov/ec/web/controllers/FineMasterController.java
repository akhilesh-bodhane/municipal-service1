package org.egov.ec.web.controllers;

import javax.validation.Valid;

import org.egov.ec.service.FineService;
import org.egov.ec.web.models.RequestInfoWrapper;
import org.egov.ec.web.models.ResponseInfoWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/fine")
@Slf4j
public class FineMasterController {

	private final FineService service;

	@Autowired
	public FineMasterController(FineService service) {
		this.service = service;
	}

	/**
	* create  Fine Master  controller
	* 
	* @param RequestInfoWrapper List of FineMaster
	* @param requestHeader for saving device information
	* @return HTTP status 200 on success
	*/
	@PostMapping("/_create")
	@ResponseBody
	public ResponseEntity<ResponseInfoWrapper> createFineMaster(
			@RequestBody @Valid @Validated RequestInfoWrapper requestInfoWrapper,@RequestHeader("User-Agent") String requestHeader) {
		log.info("Entering: " + Thread.currentThread().getStackTrace()[1].getClassName()
				+ "."+ Thread.currentThread().getStackTrace()[1].getMethodName());
		return service.saveFine(requestInfoWrapper,requestHeader);
	}

	/**
	* Get  Item Master  controller
	* 
	* @param RequestInfoWrapper object of EcSearchCriteria
	* @return HTTP status 200 on success
	*/
	@PostMapping("/_get")
	@ResponseBody
	public ResponseEntity<ResponseInfoWrapper> getFineMaster(
			@Valid @RequestBody RequestInfoWrapper requestInfoWrapper) {

		log.info("Entering: " + Thread.currentThread().getStackTrace()[1].getClassName()
				+ "."+ Thread.currentThread().getStackTrace()[1].getMethodName());
		return service.getFine(requestInfoWrapper);
	}

	/**
	* Get  Item Master  controller
	* 
	* @param RequestInfoWrapper object of FineMaster
	* @return HTTP status 200 on success
	*/
	@PostMapping("/_update")
	@ResponseBody
	public ResponseEntity<ResponseInfoWrapper> updateFineMaster(
			@RequestBody @Valid @Validated RequestInfoWrapper requestInfoWrapper) {
		log.info("Entering: " + Thread.currentThread().getStackTrace()[1].getClassName()
				+ "."+ Thread.currentThread().getStackTrace()[1].getMethodName());
		return service.updateFine(requestInfoWrapper);
	}

}
