
package org.egov.integration.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.egov.common.contract.response.ResponseInfo;
import org.egov.integration.common.CommonConstants;
import org.egov.integration.model.AuditDetails;
import org.egov.integration.model.FireApplicationDetails;
import org.egov.integration.model.FireDataRequest;
import org.egov.integration.model.FireNoc;
import org.egov.integration.model.FireNocDaoApplication;
import org.egov.integration.model.RequestInfoFire;
import org.egov.integration.model.ResponseInfoFire;
import org.egov.integration.model.ResponseInfoWrapper;
import org.egov.integration.repository.fireRepository;
import org.egov.integration.util.AuditDetailsUtil;
import org.egov.tracer.model.CustomException;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class FireService {

	@Autowired
	private AuditDetailsUtil auditDetailsUtil;
	
	@Autowired
	private fireRepository repository;
	
	@Autowired
	private  ObjectMapper objectMapper;



	public ResponseEntity<ResponseInfoWrapper> postData(JSONObject request){
		try {
		//	FireNoc data = objectMapper.convertValue(request.getFireRequest(), FireNoc.class);
			FireNoc data =new FireNoc();
			String uuid = UUID.randomUUID().toString();
			data.setUuid(uuid);
			data.setData(request);
			data.setIsActive(true);
			AuditDetails auditDetails = new AuditDetails();
			auditDetails.setCreatedBy("0");
			auditDetails.setLastModifiedBy("0");
			auditDetails.createdTime(new Date().getTime());
			auditDetails.lastModifiedTime(new Date().getTime());
			data.setAuditDetails(auditDetails);
			
			repository.saveFireData(data);
			
			return new ResponseEntity<>(ResponseInfoWrapper.builder()
					.responseInfo(ResponseInfo.builder().status(CommonConstants.SUCCESS).build()).responseBody(data)
					.build(), HttpStatus.CREATED);

		} catch (Exception e) {
			throw new CustomException(CommonConstants.FIR_NOC_EXCEPTION_CODE, e.getMessage());
		}

		
	}	
	
	public ResponseEntity<ResponseInfoFire> getData(RequestInfoFire request) {
		List<FireApplicationDetails> list = new ArrayList<>();
		FireApplicationDetails fireApplicationDetails = new FireApplicationDetails();
		try {
			validateFireRequest(request.getFireDataRequest());
			if (request.getFireDataRequest().getApplicationReferenceNumber() != null
					&& !request.getFireDataRequest().getApplicationReferenceNumber().isEmpty()) {

				List<FireNocDaoApplication> applicationStatus = repository.getApplicationStatus(
						request.getFireDataRequest().getFromDate(), request.getFireDataRequest().getToDate(),
						request.getFireDataRequest().getTypeOfOccupancy(),
						request.getFireDataRequest().getApplicationReferenceNumber());
				if (applicationStatus != null && !applicationStatus.isEmpty()) {
					fireApplicationDetails
							.setApplicationReferenceNumber(applicationStatus.get(0).getApplicationRefNo());
					fireApplicationDetails.setApplicationStatus(applicationStatus.get(0).getApplicationStatus());
				} else {
					throw new CustomException(CommonConstants.FIR_NOC_EXCEPTION_CODE,
							"Application Reference No does not exits.");
				}
			} else {
				fireApplicationDetails = repository.getApplicationCounts(request.getFireDataRequest().getFromDate(),
						request.getFireDataRequest().getToDate(), request.getFireDataRequest().getTypeOfOccupancy());
			}
			list.add(fireApplicationDetails);
			return new ResponseEntity<>(ResponseInfoFire.builder()
					.responseInfo(ResponseInfo.builder().status(CommonConstants.SUCCESS).build())
					.fireApplicationDetails(list).build(), HttpStatus.OK);
		} catch (Exception e) {
			throw new CustomException(CommonConstants.FIR_NOC_EXCEPTION_CODE, e.getMessage());
		}

	}

	private void validateFireRequest(FireDataRequest fireDataRequest) {
		Map<String, String> errors = new HashMap<>();
		if ((fireDataRequest.getApplicationReferenceNumber() == null
				|| fireDataRequest.getApplicationReferenceNumber().isEmpty())
				&& (fireDataRequest.getFromDate() == null || fireDataRequest.getFromDate().isEmpty())
				&& (fireDataRequest.getToDate() == null || fireDataRequest.getToDate().isEmpty())) {
			errors.put("InvaliData", "Application Reference number or From date and To date is must");
		} else {
			if (fireDataRequest.getApplicationReferenceNumber() == null
					|| fireDataRequest.getApplicationReferenceNumber().isEmpty()) {
				if ((fireDataRequest.getFromDate() == null || fireDataRequest.getFromDate().isEmpty())
						|| (fireDataRequest.getToDate() == null || fireDataRequest.getToDate().isEmpty())) {
					errors.put("InvalidData", "From date or To date is empty");
				}
			}
		}
		if (!errors.isEmpty())
			throw new CustomException(errors);
	}
}