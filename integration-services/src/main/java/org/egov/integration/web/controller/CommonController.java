package org.egov.integration.web.controller;


import javax.validation.Valid;

import org.egov.integration.model.CommonMetrics;
import org.egov.integration.model.CommonMetricsResponse;
import org.egov.integration.model.RequestInfoWrapper;
import org.egov.integration.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@RestController
@RequestMapping("/comm")
public class CommonController {
	
	@Autowired
	private CommonService commonService;
	
	
	@RequestMapping(value = "/_searchTotalcollectionCountNIUA", method = RequestMethod.POST)
	public ResponseEntity<CommonMetricsResponse> searchTotalCollectionCountNIUA(@Valid @RequestBody RequestInfoWrapper requestInfoWrapper) {
			CommonMetrics searchTotalCollectionCountNIUA = commonService.searchTotalCollectionCountNIUA(requestInfoWrapper.getRequestInfo());			
			CommonMetricsResponse metricsresponse = CommonMetricsResponse.builder().metrics(searchTotalCollectionCountNIUA).build();

         return new ResponseEntity<>( metricsresponse , HttpStatus.OK);
	}

}
