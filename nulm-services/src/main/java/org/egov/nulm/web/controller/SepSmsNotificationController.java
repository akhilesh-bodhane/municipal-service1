package org.egov.nulm.web.controller;

import javax.validation.Valid;

import org.egov.nulm.model.NulmSepRequest;
import org.egov.nulm.service.SepSmsNotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@RestController
@RequestMapping("/smsNotify")
public class SepSmsNotificationController {
	
	@Autowired
	private SepSmsNotificationService smsNotification;

	//@Autowired
	//private final ResponseInfoFactory responseInfoFactory;


	@RequestMapping(value = "/_sendsms", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<?> sepSmsNotification(@Valid @RequestBody NulmSepRequest nulm) {
		
		smsNotification.sendSms(nulm);
		NulmSepRequest req=NulmSepRequest.builder().nulmSepRequest(nulm.getNulmSepRequest()).build();
		return new ResponseEntity<>(req, HttpStatus.OK);
	}

}
