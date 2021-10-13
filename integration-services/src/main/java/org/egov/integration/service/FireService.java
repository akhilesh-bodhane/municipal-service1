
package org.egov.integration.service;

import java.util.Date;
import java.util.UUID;

import org.egov.common.contract.response.ResponseInfo;
import org.egov.integration.common.CommonConstants;
import org.egov.integration.model.AuditDetails;
import org.egov.integration.model.FireNoc;
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
	
	
}