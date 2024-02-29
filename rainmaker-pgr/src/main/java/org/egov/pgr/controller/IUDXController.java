package org.egov.pgr.controller;

import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.egov.pgr.contract.RequestInfoWrapper;
import org.egov.pgr.contract.ServiceReqSearchCriteria;
import org.egov.pgr.model.IUDXResponse;
import org.egov.pgr.service.IUDXService;
import org.egov.pgr.utils.ErrorConstants;
import org.egov.tracer.model.CustomException;
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
@RequestMapping(value = "/v1/iudx/")
public class IUDXController {

	@Autowired
	private IUDXService service;

	@PostMapping("_search")
	@ResponseBody
	private ResponseEntity<?> search(@RequestBody RequestInfoWrapper requestInfoWrapper,
			@ModelAttribute ServiceReqSearchCriteria serviceReqSearchCriteria) {
		validateDate(serviceReqSearchCriteria);
		List<IUDXResponse> iudxResponse = service.search(requestInfoWrapper.getRequestInfo(), serviceReqSearchCriteria);
		return new ResponseEntity<>(iudxResponse, HttpStatus.OK);
	}

	private void validateDate(ServiceReqSearchCriteria serviceReqSearchCriteria) {
		Map<String, String> errorMap = new HashMap<>();
		if (serviceReqSearchCriteria.getStartDate() == null || serviceReqSearchCriteria.getStartDate() <= 0
				|| serviceReqSearchCriteria.getEndDate() == null || serviceReqSearchCriteria.getEndDate() <= 0) {
			errorMap.put(ErrorConstants.INVALID_START_END_DATE_CODE, ErrorConstants.INVALID_START_END_DATE_MSG);
			errorMap.put(ErrorConstants.INVALID_START_END_DATE_CODE_EMPTY,
					ErrorConstants.INVALID_START_END_DATE_MSG_EMPTY);
		}

		if (!errorMap.isEmpty())
			throw new CustomException(errorMap);

	}
}
