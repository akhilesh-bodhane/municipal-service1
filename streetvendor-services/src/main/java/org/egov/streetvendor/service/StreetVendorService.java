package org.egov.streetvendor.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.egov.common.contract.response.ResponseInfo;
import org.egov.streetvendor.common.CommonConstants;
import org.egov.streetvendor.model.RequestInfoWrapper;
import org.egov.streetvendor.model.ResponseInfoWrapper;
import org.egov.streetvendor.model.StreetVendorData;
import org.egov.streetvendor.model.StreetVendorDocument;
import org.egov.streetvendor.model.StreetVendorRequest;
import org.egov.streetvendor.repository.StreetVendorRepository;
import org.egov.streetvendor.util.AuditDetailsUtil;
import org.egov.streetvendor.workflow.WorkflowIntegrator;
import org.egov.tracer.model.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

@Service
public class StreetVendorService {

	private final ObjectMapper objectMapper;

	private AuditDetailsUtil auditDetailsUtil;

	private StreetVendorRepository repository;

	private WorkflowIntegrator wfIntegrator;

	@Autowired
	public StreetVendorService(ObjectMapper objectMapper, AuditDetailsUtil auditDetailsUtil,
			StreetVendorRepository repository, WorkflowIntegrator wfIntegrator) {
		this.objectMapper = objectMapper;
		this.auditDetailsUtil = auditDetailsUtil;
		this.repository = repository;
		this.wfIntegrator = wfIntegrator;
	}

	public ResponseEntity<ResponseInfoWrapper> createStreetVendorData(RequestInfoWrapper requestInfoWrapper) {
		try {

			StreetVendorData streetvendordata = objectMapper.convertValue(requestInfoWrapper.getRequestBody(),
					StreetVendorData.class);

			String responseValidate = "";

			Gson gson = new Gson();
			String payloadData = gson.toJson(streetvendordata, StreetVendorData.class);

			responseValidate = wfIntegrator.validateJsonAddUpdateData(payloadData, CommonConstants.ACTION_CREATE);
			if (responseValidate.equals("")) {

				streetvendordata.getStreetvendorDataList().stream().forEach((c) -> {
					c.setApplicationStatus(CommonConstants.ACTION_CREATE);
					c.setVendorUuid(UUID.randomUUID().toString());
					c.setIsActive(true);
					c.setAuditDetails(auditDetailsUtil.getAuditDetails(requestInfoWrapper.getRequestInfo(),
							CommonConstants.ACTION_CREATE));
				});

				requestInfoWrapper.setRequestBody(streetvendordata);

				repository.createstreetVendor(streetvendordata);

				return new ResponseEntity<>(ResponseInfoWrapper.builder()
						.responseInfo(ResponseInfo.builder().status(CommonConstants.SUCCESS).build())
						.responseBody(streetvendordata).build(), HttpStatus.CREATED);
			} else {
				throw new CustomException(CommonConstants.STREET_VENDOR_CREATION_EXCEPTION_CODE, responseValidate);
			}
		} catch (Exception e) {
			throw new CustomException(CommonConstants.STREET_VENDOR_CREATION_EXCEPTION_CODE, e.getMessage());
		}
	}

	public ResponseEntity<ResponseInfoWrapper> getStreetVendorDataList(StreetVendorData streetvendordata) {
		try {
			List<StreetVendorData> StreetVendorList = repository.getStreetVendorList(streetvendordata);
			return new ResponseEntity<>(ResponseInfoWrapper.builder()
					.responseInfo(ResponseInfo.builder().status(CommonConstants.SUCCESS).build())
					.responseBody(StreetVendorList).build(), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			throw new CustomException(CommonConstants.STREET_VENDOR_GET_EXCEPTION_CODE, e.getMessage());
		}
	}

	public ResponseEntity<ResponseInfoWrapper> getStreetVendorDataDataDetails(StreetVendorData streetVendorData) {
		try {

			if (streetVendorData.getCovNo().isEmpty() || streetVendorData.getCovNo() == null) {
				return new ResponseEntity<>(
						ResponseInfoWrapper.builder().responseInfo(ResponseInfo.builder()
								.resMsgId("COV No. is null or empty.").status(CommonConstants.FAIL).build()).build(),
						HttpStatus.OK);
			}
			StreetVendorData StreetVendorList = repository.getStreetVendorDetails(streetVendorData);
			return new ResponseEntity<>(ResponseInfoWrapper.builder()
					.responseInfo(ResponseInfo.builder().status(CommonConstants.SUCCESS).build())
					.responseBody(StreetVendorList).build(), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			throw new CustomException(CommonConstants.STREET_VENDOR_GET_DETAILS_EXCEPTION_CODE, e.getMessage());
		}
	}
	
	public ResponseEntity<ResponseInfoWrapper> updateStreetVendorData(StreetVendorRequest streetVendorRequest) {
		StreetVendorData streetVendorData = objectMapper.convertValue(streetVendorRequest.getStreetvendorData(),
				StreetVendorData.class);			
		
		streetVendorData.setAuditDetails(
				auditDetailsUtil.getAuditDetails(streetVendorRequest.getRequestInfo(), CommonConstants.ACTION_UPDATE));
		streetVendorData.setApplicationStatus(CommonConstants.ACTION_UPDATE);
		// Update document to Streetvendor_data_document table
					List<StreetVendorDocument> streetvendordoc = new ArrayList<>();
					for (StreetVendorDocument docobj : streetVendorData.getStreetVendorDocument()) {
						StreetVendorDocument document = new StreetVendorDocument();
						if("".equals(docobj.getDocumentUuid()) || docobj.getDocumentUuid()==null) {
						document.setDocumentUuid(UUID.randomUUID().toString());
						}else {
							document.setDocumentUuid(docobj.getDocumentUuid());	
						}
						document.setDocumentType(docobj.getDocumentType());
						document.setVendorUuid(docobj.getVendorUuid());
						document.setFilestoreId(docobj.getFilestoreId());
						document.setAuditDetails(
								auditDetailsUtil.getAuditDetails(streetVendorRequest.getRequestInfo(), CommonConstants.ACTION_UPDATE));
						streetvendordoc.add(document);
					}
					
					streetVendorData.setStreetVendorDocument(streetvendordoc);
					
					repository.updateStreetVendor(streetVendorData);
		
					return new ResponseEntity<>(ResponseInfoWrapper.builder()
							.responseInfo(ResponseInfo.builder().status(CommonConstants.SUCCESS).build())
							.responseBody(streetVendorData).build(), HttpStatus.CREATED);
		
		
	}

}
