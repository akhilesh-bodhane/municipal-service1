package org.egov.sterilizationdog.web.controller;

import javax.validation.Valid;

import org.egov.sterilizationdog.model.ResponseInfoWrapper;
import org.egov.sterilizationdog.model.SterilizationDogApplication;
import org.egov.sterilizationdog.model.SterilizationDogRequest;
import org.egov.sterilizationdog.service.SterilizationDogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sterilizationdog")
public class SterilizationDogController {

	private final SterilizationDogService sterilizationdogService;

	@Autowired
	public SterilizationDogController(SterilizationDogService sterilizationdogService) {
		this.sterilizationdogService = sterilizationdogService;
	}

	@PostMapping(value = "/_pick")
	public ResponseEntity<ResponseInfoWrapper> createSterilizationDogApplication(
			@Valid @RequestBody SterilizationDogRequest sterilizationdogrequest) {
		return sterilizationdogService.createSterilizationDogApplication(sterilizationdogrequest);
	}

	
	  @PostMapping(value = "/_get") 
	  public ResponseEntity<ResponseInfoWrapper>getSterilizationDogApplication(@ModelAttribute SterilizationDogApplication sterilizationdogServi) {
	  return sterilizationdogService.getSterilizationDogApplication(sterilizationdogServi);
	  }
	  
}
