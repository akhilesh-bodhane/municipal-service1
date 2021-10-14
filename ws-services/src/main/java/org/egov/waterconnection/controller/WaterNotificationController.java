package org.egov.waterconnection.controller;

import java.util.List;

import javax.validation.Valid;

import org.egov.waterconnection.model.WaterConnection;
import org.egov.waterconnection.model.WaterConnectionRequest;
import org.egov.waterconnection.model.WaterConnectionResponse;
import org.egov.waterconnection.model.WaterNotication;
import org.egov.waterconnection.model.WaterNotificationRequest;
import org.egov.waterconnection.service.WaterService;
import org.egov.waterconnection.util.ResponseInfoFactory;
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
@RequestMapping("/notice")
public class WaterNotificationController {
	
	@Autowired
	private WaterService waterService;

	@Autowired
	private final ResponseInfoFactory responseInfoFactory;


	@RequestMapping(value = "/_sendsms", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<?> createWaterConnection(
			@Valid @RequestBody WaterNotificationRequest waterNotificationRequest) {
		
		waterService.sendSms(waterNotificationRequest);
		WaterNotificationRequest req = WaterNotificationRequest.builder().waterNotication(waterNotificationRequest.getWaterNotication()).build();
		return new ResponseEntity<>(req, HttpStatus.OK);
	}

}
