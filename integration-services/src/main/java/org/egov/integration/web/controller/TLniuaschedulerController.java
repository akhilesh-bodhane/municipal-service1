package org.egov.integration.web.controller;

import java.util.Map;

import javax.validation.Valid;

import org.egov.integration.model.RequestInfoWrapper;
import org.egov.integration.service.EawasService;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/TL/v1/Scheduler")
public class TLniuaschedulerController {
	
	private final EawasService service;
	
	@Autowired
	public TLniuaschedulerController(EawasService service) {
		this.service = service;
	}
	
	@PostMapping(value = "/NIUASearch")
	public Object NIUASearch(@Valid @RequestBody RequestInfoWrapper request) throws JSONException {
		
		 Map<String, Object> searchNIUAScheduler = service.searchNIUAScheduler(request);

		return searchNIUAScheduler;
	}

}
