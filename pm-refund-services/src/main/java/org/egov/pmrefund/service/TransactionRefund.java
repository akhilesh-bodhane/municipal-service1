
package org.egov.pmrefund.service;

import org.egov.common.contract.response.ResponseInfo;
import org.egov.pmrefund.config.PMRefundConfiguration;
import org.egov.pmrefund.producer.Producer;
import org.egov.pmrefund.util.CommonConstants;
import org.egov.pmrefund.util.PaymentUtil;
import org.egov.pmrefund.web.models.NOCApplication;
import org.egov.pmrefund.web.models.RequestInfoWrapper;
import org.egov.pmrefund.web.models.ResponseInfoWrapper;
import org.egov.tracer.model.CustomException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class TransactionRefund {

	private PMRefundConfiguration config;

	private ObjectMapper objectMapper;

	private Producer producer;

	private PaymentUtil paymentUtil;

	@Autowired
	public TransactionRefund( PMRefundConfiguration config,
			ObjectMapper objectMapper, Producer producer, PaymentUtil paymentUtil) {
		this.config = config;
		this.objectMapper = objectMapper;
		this.producer = producer;
		this.paymentUtil = paymentUtil;
	}

	public ResponseEntity<ResponseInfoWrapper> enrichRefundRequest(RequestInfoWrapper requestInfoWrapper,
			String withdrawType) {
		try {
			NOCApplication nocDetail = objectMapper.convertValue(requestInfoWrapper.getRequestBody(),
					NOCApplication.class);
			Double amountToRefund = 0.0;
			if (withdrawType.equals(CommonConstants.FULL_REFUND)) {
				amountToRefund = nocDetail.getTotalamount();
				log.info("Full Refund is  Inititated for application Id:" + nocDetail.getNocnumber() + " for Amount :"
						+ amountToRefund);
				return new ResponseEntity<>(ResponseInfoWrapper.builder()
						.responseInfo(ResponseInfo.builder().status("Success").build()).build(), HttpStatus.OK);
			} else if (withdrawType.equals(CommonConstants.PARTIAL_REFUND)) {
				JSONObject applicationDetail = (JSONObject) new JSONParser().parse((nocDetail.getApplicationdetail()));
				amountToRefund = Double
						.parseDouble(applicationDetail.get(CommonConstants.WITHDRAWAPPROVALAMOUNT).toString());
				log.info("Partial Refund is  Inititated for application Id:" + nocDetail.getNocnumber()
						+ " for Amount :" + amountToRefund);
				return new ResponseEntity<>(ResponseInfoWrapper.builder()
						.responseInfo(ResponseInfo.builder().status("Success").build()).build(), HttpStatus.OK);
			}
			return new ResponseEntity<>(
					ResponseInfoWrapper.builder().responseInfo(ResponseInfo.builder().status("Failed").build()).build(),
					HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			e.printStackTrace();
			throw new CustomException("EXCEPTION", e.getMessage());
		}
	}
}