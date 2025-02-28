package org.egov.pgr.controller;

import java.util.Map;

import javax.validation.Valid;

import org.egov.pgr.model.GrievanceReport;
import org.egov.pgr.model.RequestInfoWrapper;
import org.egov.pgr.service.NIUADataPushService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("PGR/v1/Scheduler")
public class NIUADataPushController {

	private final NIUADataPushService niuaDataPushService;

	@Autowired
	public NIUADataPushController(NIUADataPushService niuaDataPushService) {
		this.niuaDataPushService = niuaDataPushService;
	}

	@PostMapping("/_NIUAData")
	public Object fetchAndPushData(@Valid @RequestBody RequestInfoWrapper request) {
	    try {
	        GrievanceReport grievanceReport = niuaDataPushService.fetchDataFromProduction(request);

	        if (grievanceReport == null) {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No data found from Production API.");
	        }

	        // Call pushDataToNIUA which now returns a ResponseEntity<String>
	         ResponseEntity<Map> response = niuaDataPushService.pushDataToNIUA(grievanceReport);

	        // Return the exact response from the pushDataToNIUA method
	        return response;

	    } catch (Exception e) {
	        e.printStackTrace();
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred: " + e.getMessage());
	    }
	}
}
