package org.egov.integration.web.controller;

import org.egov.integration.model.RequestInfoWrapper;
import org.egov.integration.model.UserChargesReport;
import org.egov.integration.service.NIUADataPushService;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

import javax.validation.Valid;

@RestController
@RequestMapping("/MCOLLECT/v1/Scheduler")
public class NIUADataPushController {
	
	@Autowired
	private final NIUADataPushService niuaDataPushService;
	
	public NIUADataPushController(NIUADataPushService niuaDataPushService) {
		this.niuaDataPushService = niuaDataPushService;
	}
	
  

	@PostMapping("/NIUASearch")
	 public Object fetchAndPushData(@Valid @RequestBody RequestInfoWrapper request) {
        try {
            UserChargesReport data = niuaDataPushService.fetchDataFromProduction(request);

            if (data != null && data.getMetrics() != null) {
                ResponseEntity<Map> response = niuaDataPushService.pushDataToNIUA(data);
                System.out.println("NIUA API Response: " + response.getBody());
                return response;
            } else {
                System.out.println("Metrics is null");
                return ((BodyBuilder) ResponseEntity.notFound()).body("Metrics/Data is null....Skipping Data Push");
            }
        } catch (Exception e) {
            System.out.println("Error occurred while fetching and pushing data: " + e.getMessage());
            e.printStackTrace();
            return ResponseEntity.status(500).body("An unexpected error occurred.");
        }
    }

}