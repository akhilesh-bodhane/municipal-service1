package org.egov.integration.web.controller;

import javax.validation.Valid;

import org.egov.integration.model.EawasRequestInfoWrapper;
import org.egov.integration.model.RequestData;
import org.egov.integration.model.ResponseInfoWrapper;
import org.egov.integration.model.TLDashboardRequestInfoWrapper;
import org.egov.integration.model.TLPublicDashboardResponseInfo;
import org.egov.integration.service.EawasService;
//import org.egov.tl.web.models.RequestInfoWrapper;
//import org.egov.tl.web.models.TradeLicenseSearchCriteria;
import org.egov.integration.model.Metrics;
import org.egov.integration.model.metricsResponse;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/TL/v1")
public class TLniuaController {

	private final EawasService service;

	@Autowired
	public TLniuaController(EawasService service) {
		this.service = service;
	}

//	@PostMapping(value = "/_get")
//	public ResponseEntity<ResponseInfoWrapper> get(@Valid @RequestBody  EawasRequestInfoWrapper request) throws JSONException {		 
//		return service.get(request);		
//	}

	@RequestMapping(value = { "/_searchNIUA" }, method = RequestMethod.POST)
	public ResponseEntity<metricsResponse> searchNIUA(@Valid @RequestBody EawasRequestInfoWrapper requestInfoWrapper,
			@Valid @ModelAttribute RequestData criteria, @PathVariable(required = false) String servicename) {
		Metrics licenses = service.searchNIUA(criteria, requestInfoWrapper.getRequestInfo(), servicename);

		metricsResponse vvv = metricsResponse.builder().Metrics(licenses).build();

		return new ResponseEntity<>(vvv, HttpStatus.OK);

	}

	@RequestMapping(value = { "/_publicDashboard" }, method = RequestMethod.POST)
	public ResponseEntity<TLPublicDashboardResponseInfo> publicDashboard(
			@Valid @RequestBody TLDashboardRequestInfoWrapper dashboardRequestInfoWrapper) {
		TLPublicDashboardResponseInfo dashboardResponseInfo = service.publicDashboard(dashboardRequestInfoWrapper);
		return new ResponseEntity<>(dashboardResponseInfo, HttpStatus.OK);
	}
}
