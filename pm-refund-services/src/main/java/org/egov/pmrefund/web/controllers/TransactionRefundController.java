package org.egov.pmrefund.web.controllers;


import javax.servlet.http.HttpServletRequest;

import org.egov.pmrefund.service.TransactionRefund;
import org.egov.pmrefund.util.ResponseInfoFactory;
import org.egov.pmrefund.web.models.RequestInfoWrapper;
import org.egov.pmrefund.web.models.ResponseInfoWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/v1")
public class TransactionRefundController {

	private final ObjectMapper objectMapper;

	private final HttpServletRequest request;

	private final TransactionRefund transactionRefund;

	private final ResponseInfoFactory responseInfoFactory;

	@Autowired
	public TransactionRefundController(ObjectMapper objectMapper, HttpServletRequest request,
			TransactionRefund transactionRefund, ResponseInfoFactory responseInfoFactory) {
		this.objectMapper = objectMapper;
		this.request = request;
		this.transactionRefund = transactionRefund;
		this.responseInfoFactory = responseInfoFactory;
	}

	@RequestMapping(value = "/_refund", method = RequestMethod.POST)
	public ResponseEntity<ResponseInfoWrapper> initiateRefund(@RequestBody RequestInfoWrapper requestInfoWrapper,
			@ModelAttribute("withdrawType") String withdrawType) {
		return transactionRefund.enrichRefundRequest(requestInfoWrapper,withdrawType);
	}
}
