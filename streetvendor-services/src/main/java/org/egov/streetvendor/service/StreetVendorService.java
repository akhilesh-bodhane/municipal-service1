package org.egov.streetvendor.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.egov.common.contract.response.ResponseInfo;
import org.egov.streetvendor.common.CommonConstants;
import org.egov.streetvendor.model.RequestInfoWrapper;
import org.egov.streetvendor.model.ResponseInfoWrapper;
import org.egov.streetvendor.model.StreetVendorData;
import org.egov.streetvendor.repository.StreetVendorRepository;
import org.egov.streetvendor.util.AuditDetailsUtil;
import org.egov.tracer.model.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class StreetVendorService {
	
	private final ObjectMapper objectMapper;
	
	private AuditDetailsUtil auditDetailsUtil;
	
	private StreetVendorRepository repository;
	
	@Autowired
	public StreetVendorService(ObjectMapper objectMapper,AuditDetailsUtil auditDetailsUtil,StreetVendorRepository repository) {
		this.objectMapper = objectMapper;
		this.auditDetailsUtil=auditDetailsUtil;
		this.repository=repository;
	}
	
	public ResponseEntity<ResponseInfoWrapper> createStreetVendorData(RequestInfoWrapper requestInfoWrapper) {
		try {
			StreetVendorData streetvendordata = objectMapper.convertValue(requestInfoWrapper.getRequestBody(),
					StreetVendorData.class);
					
			streetvendordata.getStreetvendorDataRequest().stream().forEach((c) -> {
				/*
				 * c.setCreatedBy(requestInfoWrapper.getAuditDetails().getCreatedBy());
				 * c.setCreatedTime(requestInfoWrapper.getAuditDetails().getCreatedTime());
				 * c.setLastModifiedBy(requestInfoWrapper.getAuditDetails().getLastModifiedBy())
				 * ; c.setLastModifiedTime(requestInfoWrapper.getAuditDetails().
				 * getLastModifiedTime());
				 */				
				c.setAuditDetails(auditDetailsUtil.getAuditDetails(requestInfoWrapper.getRequestInfo(), CommonConstants.ACTION_CREATE));
				c.setApplicationStatus(CommonConstants.ACTION_CREATE);
				c.setVendorUuid(UUID.randomUUID().toString());
			});
			
			requestInfoWrapper.setRequestBody(streetvendordata);
					
			repository.createstreetVendor(streetvendordata);

			return new ResponseEntity<>(ResponseInfoWrapper.builder()
					.responseInfo(ResponseInfo.builder().status(CommonConstants.SUCCESS).build())
					.responseBody(streetvendordata).build(), HttpStatus.CREATED);
			
		} catch (Exception e) {
			throw new CustomException(CommonConstants.STREET_VENDOR_CREATION_EXCEPTION_CODE, e.getMessage());
		}
	}

}
