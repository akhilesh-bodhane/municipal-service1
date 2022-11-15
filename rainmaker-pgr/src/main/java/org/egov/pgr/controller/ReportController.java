package org.egov.pgr.controller;

import javax.validation.Valid;

import org.egov.pgr.contract.ReportRequest;
import org.egov.pgr.contract.ServiceReqSearchCriteria;
import org.egov.pgr.model.GrievenceReport;
import org.egov.pgr.model.RequestInfoWrapper;
import org.egov.pgr.model.ResponseInfoWrapper;
import org.egov.pgr.service.ReportService;
import org.egov.pgr.validator.PGRRequestValidator;
import org.json.JSONException;
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
@RequestMapping(value = "/v1/reports/")
public class ReportController {

	@Autowired
	private ReportService service;

	@Autowired
	private PGRRequestValidator pgrRequestValidator;

	@PostMapping("_get")
	@ResponseBody
	public ResponseEntity<?> getReports(@RequestBody @Valid ReportRequest reportRequest) {
		Object response = service.getReports(reportRequest);
		return new ResponseEntity<>(response, HttpStatus.OK);

	}

	@PostMapping(value = "/_jobscheduler")
	public ResponseEntity<ResponseInfoWrapper> process(@Valid @RequestBody RequestInfoWrapper request)
			throws JSONException {
		return service.process(request);
	}

	@PostMapping("_grivence")
	@ResponseBody
	private ResponseEntity<?> getGrienceReport(@RequestBody @Valid RequestInfoWrapper requestInfoWrapper,
			@ModelAttribute @Valid ServiceReqSearchCriteria serviceReqSearchCriteria) {
		pgrRequestValidator.validateSearch(serviceReqSearchCriteria, requestInfoWrapper.getRequestInfo());
		GrievenceReport grievenceReport = service.getGrienceReport(requestInfoWrapper.getRequestInfo(),
				serviceReqSearchCriteria);
		return new ResponseEntity<>(grievenceReport, HttpStatus.OK);
	}
}
