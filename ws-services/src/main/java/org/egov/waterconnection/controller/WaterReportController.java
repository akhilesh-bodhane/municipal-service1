package org.egov.waterconnection.controller;

import java.util.List;

import javax.validation.Valid;

import org.egov.waterconnection.model.BillGeneration;
import org.egov.waterconnection.model.BillGenerationRequest;
import org.egov.waterconnection.model.BillGenerationResponse;
import org.egov.waterconnection.model.RequestInfoWrapper;
import org.egov.waterconnection.service.WaterReportService;
import org.egov.waterconnection.util.ResponseInfoFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wsreport")
public class WaterReportController {

	@Autowired
	private WaterReportService waterReportService;

	@Autowired
	private  ResponseInfoFactory responseInfoFactory;

	@RequestMapping(value = "/_getBillReportData", method = RequestMethod.POST)
	public ResponseEntity<BillGenerationResponse> getBillData(@Valid @RequestBody RequestInfoWrapper requestInfoWrapper,
			@Valid @RequestBody BillGenerationRequest waterReportRequest) {
		List<BillGeneration> waterReport = waterReportService.getPiechartData(waterReportRequest);
		BillGenerationResponse response = BillGenerationResponse.builder().billGeneration(waterReport)
				.responseInfo(responseInfoFactory.createResponseInfoFromRequestInfo(requestInfoWrapper.getRequestInfo(),
						true))
				.build();
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	
	
}
