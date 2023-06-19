package org.egov.pm.web.controller;

import org.egov.pm.model.IUDXRequestData;
import org.egov.pm.service.GeneralReportNocService;
import org.egov.pm.web.contract.IUDXNocResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/report/noc")
public class GeneralReportNocController {

	@Autowired
	private GeneralReportNocService generalReportNocService;

	@PostMapping("/iudx/_get")
	@ResponseBody
	public ResponseEntity<IUDXNocResponse> getIUDX(@RequestBody IUDXRequestData iudxRequestData) {
		log.debug(String.format("STARTED GET IUDX DATATA REQUEST : %1s", iudxRequestData.toString()));
		return generalReportNocService.getIUDXNOCDATA(iudxRequestData);
	}
}
