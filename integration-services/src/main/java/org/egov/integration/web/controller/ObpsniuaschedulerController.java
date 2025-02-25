package org.egov.integration.web.controller;

import java.util.Map;

import javax.validation.Valid;

import org.egov.integration.model.RequestInfoWrap;
import org.egov.integration.model.RequestInfoWrapper;
import org.egov.integration.service.EawasService;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/OBPS/NIUA/Scheduler")
public class ObpsniuaschedulerController {
	
	private final EawasService service;
	
	@Autowired
	public ObpsniuaschedulerController(EawasService service) {
		this.service = service;
	}
	
	@PostMapping(value = "/Search")
	public Object NIUASearch(@Valid @RequestBody RequestInfoWrap request) throws JSONException {
		
		 Map<String, Object> searchNIUAScheduler = service.searchOBPSNIUAScheduler(request);

		return searchNIUAScheduler;
	}

}
