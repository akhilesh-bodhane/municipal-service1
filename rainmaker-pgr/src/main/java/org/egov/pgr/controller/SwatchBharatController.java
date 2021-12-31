package org.egov.pgr.controller;

import javax.validation.Valid;

import org.egov.pgr.contract.RequestInfoWrapper;
import org.egov.pgr.contract.SwatchBharatRequest;
import org.egov.pgr.contract.SwatchBharatResponse;
import org.egov.pgr.service.SwatchBharatService;
import org.egov.pgr.validator.PGRRequestValidator;
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
@RequestMapping(value = "/v1/swatchbharat/")
public class SwatchBharatController {

	@Autowired
	private SwatchBharatService service;

	@PostMapping("_create")
	@ResponseBody
	private ResponseEntity<?> create(@RequestBody @Valid SwatchBharatRequest swatchBharatRequest) {
		SwatchBharatResponse response = service.create(swatchBharatRequest);
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}

	/*
	 * @PostMapping("_update")
	 * 
	 * @ResponseBody private ResponseEntity<?> update(@RequestBody @Valid
	 * SwatchBharatRequest swatchBharatRequest) { SwatchBharatResponse response =
	 * service.update(swatchBharatRequest); return new ResponseEntity<>(response,
	 * HttpStatus.OK); }
	 */

	@PostMapping("_search")
	@ResponseBody
	private ResponseEntity<?> search(@RequestBody @Valid SwatchBharatRequest swatchBharatRequest) {
		SwatchBharatResponse serviceReqResponse = service.getSwatchBharatRequestDetails(swatchBharatRequest);
		return new ResponseEntity<>(serviceReqResponse, HttpStatus.OK);
	}

}
