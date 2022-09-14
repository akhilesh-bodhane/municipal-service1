package org.egov.hcr.controller;

import org.egov.common.contract.response.ResponseInfo;
import org.egov.hcr.contract.ResponseInfoWrapper;
import org.egov.hcr.contract.ServiceRequest;
import org.egov.hcr.contract.ServiceResponse;
import org.egov.hcr.model.RequestData;
import org.egov.hcr.service.ServiceRequestService;
import org.egov.hcr.utils.HCConstants;
import org.egov.hcr.utils.HCUtils;
import org.json.JSONException;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value = "/service/request")
public class ServiceController {

	@Autowired
	private ServiceRequestService service;

	@Autowired
	private HCUtils hcutils;

	/*
	 * enpoint to create & edit service requests
	 * 
	 * @param ServiceReqRequest
	 * 
	 * @author Prakash
	 */
	@RequestMapping(value = "/_create", method = RequestMethod.POST)
	public ResponseEntity<?> create(@RequestBody ServiceRequest serviceRequest,
			@RequestHeader("User-Agent") String request)
			throws JSONException, InterruptedException, CloneNotSupportedException {

		ObjectMapper mapper = new ObjectMapper();
		try {
			System.out.println("Create Req : " + mapper.writeValueAsString(serviceRequest));
		} catch (JsonProcessingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			hcutils.validateJsonAddUpdateData(serviceRequest, HCConstants.SERVICEREQUESTCREATE);
			if (serviceRequest.getServices().get(0).getIsEditState() == 1) {
				return new ResponseEntity<>(service.updateServiceRequest(serviceRequest, request), HttpStatus.CREATED);
			} else {
				return new ResponseEntity<>(service.create(serviceRequest, request), HttpStatus.CREATED);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(
					ResponseInfoWrapper.builder().responseInfo(ResponseInfo.builder().status(HCConstants.FAIL).build())
							.responseBody(e.getMessage()).build(),
					HttpStatus.BAD_REQUEST);
		}
	}

	/*
	 * enpoint to getDetail service requests
	 * 
	 * @param ServiceReqRequest
	 * 
	 * @author Prakash
	 */

	@PostMapping("_getDetail")
	@ResponseBody
	public ResponseEntity<?> getDetail(@RequestBody RequestData requestData) {

		log.debug(String.format("STARTED Get Details SERVICE REQUEST : %1s", requestData.toString()));
		return service.getServiceRequestDetails(requestData);

	}

	/*
	 * enpoint to get list of service requests as per the filter criteria
	 * 
	 * @param RequestInfoWrapper,RequestData
	 * 
	 * @author Prakash
	 */

	@PostMapping("_get")
	@ResponseBody
	public ResponseEntity<?> get(@RequestBody RequestData requestData) {

		log.debug(String.format("STARTED Get Details SERVICE REQUEST : %1s", requestData.toString()));
		return service.searchRequest(requestData, requestData.getRequestInfo());

	}

	/*
	 * enpoint to update service requests
	 * 
	 * @param ServiceReqRequest
	 * 
	 * @author Prakash
	 */

	@RequestMapping(value = "/_update", method = RequestMethod.POST)
	public ResponseEntity<?> update(@RequestBody ServiceRequest serviceRequest,
			@RequestHeader("User-Agent") String requestHeader) throws JSONException {
		try {
			hcutils.validateJsonAddUpdateData(serviceRequest, HCConstants.SERVICEREQUESTUPDATE);
			ServiceResponse response = service.update(serviceRequest, requestHeader);
			return new ResponseEntity<>(response, HttpStatus.CREATED);

		} catch (Exception e) {
			return new ResponseEntity<>(
					ResponseInfoWrapper.builder().responseInfo(ResponseInfo.builder().status(HCConstants.FAIL).build())
							.responseBody(e.getMessage()).build(),
					HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/_scheduler", method = RequestMethod.POST)
	public ResponseEntity<?> scheduler(@RequestParam("tenantId") String tenantId,
			@RequestBody ServiceRequest requestInfo) {

		ServiceResponse response = service.scheduler(requestInfo, tenantId);

		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/_delectDocument", method = RequestMethod.POST)
	public ResponseEntity<?> delectDocument(@RequestBody ServiceRequest serviceRequest,
			@RequestHeader("User-Agent") String requestHeader) throws JSONException, ParseException {

		return service.delectDocument(serviceRequest, requestHeader);
	}

	@RequestMapping(value = "/_sendSMS", method = RequestMethod.POST)
	public ResponseEntity<?> sendMail(@RequestBody ServiceRequest serviceRequest,
			@RequestHeader("User-Agent") String requestHeader) {

		return service.sendMail(serviceRequest);

	}

}
