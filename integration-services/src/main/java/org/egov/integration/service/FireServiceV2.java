
package org.egov.integration.service;

import java.util.List;

import org.egov.common.contract.response.ResponseInfo;
import org.egov.integration.common.CommonConstants;
import org.egov.integration.model.FireApplicationPendingDetailSearch;
import org.egov.integration.model.FireService;
import org.egov.integration.model.FireServiceSearch;
import org.egov.integration.model.ResponseFireV2;
import org.egov.integration.model.ResponseInfoWrapper;
import org.egov.integration.repository.FireRepositoryV2;
import org.egov.integration.util.AuditDetailsUtil;
import org.egov.tracer.model.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class FireServiceV2 {

	@Autowired
	private AuditDetailsUtil auditDetailsUtil;

	@Autowired
	private FireRepositoryV2 repository;

	@Autowired
	private ObjectMapper objectMapper;

	public ResponseEntity<ResponseInfoWrapper> getServiceWiseData(FireServiceSearch fireServiceSearch) {
		try {
			List<FireService> serviceWiseData = repository.getServiceWiseData(fireServiceSearch);

			return new ResponseEntity<>(ResponseInfoWrapper.builder()
					.responseInfo(ResponseInfo.builder().status(CommonConstants.SUCCESS).build())
					.responseBody(serviceWiseData).build(), HttpStatus.OK);

		} catch (Exception e) {
			throw new CustomException(CommonConstants.FIR_NOC_EXCEPTION_CODE, e.getMessage());
		}

	}

	public ResponseEntity<ResponseFireV2> getApplicationPendingDetails(FireApplicationPendingDetailSearch request) {
		try {
			if (request.getReferenceNo() != null && !request.getReferenceNo().isEmpty()) {
				return new ResponseEntity<>(
						ResponseFireV2.builder()
								.responseInfo(ResponseInfo.builder().status(CommonConstants.SUCCESS).build())
								.applicationPendingDetails(repository.getApplicationPendingDetails(request)).build(),
						HttpStatus.OK);
			}
			throw new CustomException(CommonConstants.FIR_NOC_EXCEPTION_CODE, "Reference No is blank or empty.");
		} catch (Exception e) {
			throw new CustomException(CommonConstants.FIR_NOC_EXCEPTION_CODE, e.getMessage());
		}
	}

}