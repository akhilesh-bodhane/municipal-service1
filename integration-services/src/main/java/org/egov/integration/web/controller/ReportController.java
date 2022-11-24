package org.egov.integration.web.controller;

import java.text.ParseException;

import javax.validation.Valid;

import org.egov.integration.common.ModuleNameConstants;
import org.egov.integration.model.ReportRequest;
import org.egov.integration.model.RequestInfoWrapper;
import org.egov.integration.model.ResponseInfoWrapper;
import org.egov.integration.model.ServiceReqSearchCriteria;
import org.egov.integration.model.UserChargesReport;
import org.egov.integration.service.ReportService;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/report/v1")
public class ReportController {
	private final ReportService service;

	@Autowired
	public ReportController(ReportService service) {
		this.service = service;
	}

	@PostMapping(value = "/_generate")
	public ResponseEntity<ResponseInfoWrapper> getData(@RequestBody ReportRequest request)
			throws JSONException, ParseException {

		ResponseEntity<ResponseInfoWrapper> rs = null;
		if (request.getRequestBody().getServiceType().equalsIgnoreCase(ModuleNameConstants.SERVICETYPEGENERIC)) {
			rs = service.getData(request);
		}
		return rs;
	}

	@PostMapping("/_usercharges")
	@ResponseBody
	private ResponseEntity<?> getUserChangesReport(@RequestBody @Valid RequestInfoWrapper requestInfoWrapper,
			@ModelAttribute @Valid ServiceReqSearchCriteria serviceReqSearchCriteria) {
		UserChargesReport grievenceReport = service.getUserChangesReport(requestInfoWrapper.getRequestInfo(),
				serviceReqSearchCriteria);
		return new ResponseEntity<>(grievenceReport, HttpStatus.OK);
	}

}
