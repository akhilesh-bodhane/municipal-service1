package org.egov.pm.service.updatestatus.consumer;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.egov.common.contract.request.RequestInfo;
import org.egov.common.contract.request.Role;
import org.egov.pm.model.RequestData;
import org.egov.pm.producer.Producer;
import org.egov.pm.repository.NocRepository;
import org.egov.pm.util.UserUtil;
import org.egov.pm.web.models.collection.PaymentDetail;
import org.egov.pm.web.models.collection.PaymentRequest;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UpdateStatusListener {

	@Value("${system.user.id}")
	private String userid;

	@Value("${system.user.uuid}")
	private String useruuid;

	private ObjectMapper objectMapper;
	private NocRepository nocRepository;

	@Autowired
	public UpdateStatusListener(ObjectMapper objectMapper, NocRepository nocRepository) {
		this.objectMapper = objectMapper;
		this.nocRepository = nocRepository;
	}

	@KafkaListener(topics = "${kafka.topics.receipt.create}")
	public void updateStatus(final HashMap<String, Object> data) throws IOException {
		try {
			PaymentRequest paymentRequest = objectMapper.convertValue(data, PaymentRequest.class);
			RequestInfo requestInfo = paymentRequest.getRequestInfo();
			List<PaymentDetail> paymentDetails = paymentRequest.getPayment().getPaymentDetails();
			String tenantId = paymentRequest.getPayment().getTenantId();
			RequestData requestData = new RequestData();
			requestData.setRequestInfo(paymentRequest.getRequestInfo());
			for (PaymentDetail paymentDetail : paymentDetails) {
				requestData.setApplicationId(paymentDetail.getBill().getConsumerCode());
				requestData.setTenantId(tenantId);
				requestData.setApplicationStatus("PAID");
				String applicationType = paymentDetail.getBusinessService().split("\\.")[1];
				requestData.setApplicationType(applicationType);
				if(applicationType.contains("_")) {
					requestData.setApplicationType(applicationType.split("_")[0]);
				}
				
				JSONObject datapayload = new JSONObject();
				paymentDetail.getBill().getBillDetails().forEach(detail -> {
					detail.getBillAccountDetails().forEach(billAccount -> {
						String taxHeadCode = billAccount.getTaxHeadCode();
						if (taxHeadCode.contains("FEE")) {
							datapayload.put("amount", billAccount.getAmount());
						} else if (taxHeadCode.contains("POSTAL_CHARGES") || taxHeadCode.contains("TAX")) {
							datapayload.put("gstAmount", billAccount.getAmount());
						}
					});
				});
				if (requestData.getApplicationType().contains("SELLMEATNOC")) {
					datapayload.put("gstAmount", 0);
				}
				if(requestInfo.getUserInfo().getType().equals("SYSTEM")) {
					requestInfo.getUserInfo().setId(Long.valueOf(userid));
					requestInfo.getUserInfo().setUuid(useruuid);
					Role role = Role.builder().code("SYSTEM").build();
					requestInfo.getUserInfo().getRoles().add(role);
				}
				requestData.setDataPayload(datapayload);
//				Role role = Role.builder().code("SYSTEM_PAYMENT").build();
//				requestInfo.getUserInfo().getRoles().add(role);

				nocRepository.updateAppStatus(requestData);
			}
		} catch (Exception e) {
			log.info("Exception While Updating Status ::{}", e.getMessage());
		}
	}
}
