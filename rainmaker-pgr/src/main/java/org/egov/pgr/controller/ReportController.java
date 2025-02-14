package org.egov.pgr.controller;

import javax.validation.Valid;

import org.egov.pgr.contract.IUDXDataRequest;
import org.egov.pgr.contract.ReportRequest;
import org.egov.pgr.contract.ServiceReqSearchCriteria;
import org.egov.pgr.model.GrievanceReport;
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
	public ResponseEntity<ResponseInfoWrapper> process(@Valid @RequestBody RequestInfoWrapper request,
			@ModelAttribute @Valid ServiceReqSearchCriteria serviceReqSearchCriteria) throws JSONException {
		return service.process(request, serviceReqSearchCriteria);
	}

	@PostMapping("_grievance")
	@ResponseBody
	private ResponseEntity<?> getGrievanceReport(@RequestBody @Valid RequestInfoWrapper requestInfoWrapper,
			@ModelAttribute @Valid ServiceReqSearchCriteria serviceReqSearchCriteria) {
		pgrRequestValidator.validateSearch(serviceReqSearchCriteria, requestInfoWrapper.getRequestInfo());
		GrievanceReport grievenceReport = service.getGrievanceReport(requestInfoWrapper.getRequestInfo(),
				serviceReqSearchCriteria);
		return new ResponseEntity<>(grievenceReport, HttpStatus.OK);
	}

	@PostMapping("/iudx/_get")
	@ResponseBody
	public ResponseEntity<?> getIUDXDataReports(@RequestBody @Valid IUDXDataRequest iudxDataRequest) {
		return service.getIUDXDataReports(iudxDataRequest);
	}
	
	@PostMapping(value = "/_smsLevelThreejobscheduler")
	public ResponseEntity<ResponseInfoWrapper> smsLevelThreeprocess(@Valid @RequestBody RequestInfoWrapper request) throws JSONException {
		return service.LevelThreeprocess(request);
	}
	
	@PostMapping(value = "/_smsLevelfourjobscheduler")
	public ResponseEntity<ResponseInfoWrapper> smsLevelfourprocess(@Valid @RequestBody RequestInfoWrapper request) throws JSONException {
		return service.Levelfourprocess(request);
	}
	
	@PostMapping(value = "/_smsLevelfivejobscheduler")
	public ResponseEntity<ResponseInfoWrapper> smsLevelfiveprocess(@Valid @RequestBody RequestInfoWrapper request) throws JSONException {
		return service.Levelfiveprocess(request);
	}
	
	@PostMapping(value = "/_smsescalateofficeronejobscheduler")
	public ResponseEntity<ResponseInfoWrapper> smsescalateofficeroneprocess(@Valid @RequestBody RequestInfoWrapper request) throws JSONException {
		return service.smsescalateofficeroneprocess(request);
	}
	
	@PostMapping(value = "/_smsescalateofficertwojobscheduler")
	public ResponseEntity<ResponseInfoWrapper> smsescalateofficertwoprocess(@Valid @RequestBody RequestInfoWrapper request) throws JSONException {
		return service.smsescalateofficertwoprocess(request);
	}

}
