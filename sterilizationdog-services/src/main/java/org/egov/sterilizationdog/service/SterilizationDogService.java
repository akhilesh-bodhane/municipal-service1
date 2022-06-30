package org.egov.sterilizationdog.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.egov.common.contract.response.ResponseInfo;
import org.egov.sterilizationdog.common.CommonConstants;
import org.egov.sterilizationdog.config.SterilizationDogConfiguration;
import org.egov.sterilizationdog.idgen.model.IdGenerationResponse;
import org.egov.sterilizationdog.model.ResponseInfoWrapper;
import org.egov.sterilizationdog.model.SterilizationDogApplication;
import org.egov.sterilizationdog.model.SterilizationDogDocument;
import org.egov.sterilizationdog.model.SterilizationDogRequest;
import org.egov.sterilizationdog.repository.SterilizationDogRepository;
import org.egov.sterilizationdog.util.AuditDetailsUtil;
import org.egov.sterilizationdog.util.IdGenRepository;
import org.egov.tracer.model.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class SterilizationDogService {
	
	private final ObjectMapper objectMapper;
	
	private SterilizationDogConfiguration config;
	
	private SterilizationDogRepository repository;
	
	private IdGenRepository idgenrepository;
	
	private AuditDetailsUtil auditDetailsUtil;
	
	
	@Autowired
	public SterilizationDogService(SterilizationDogRepository repository,ObjectMapper objectMapper,IdGenRepository idgenrepository,
			SterilizationDogConfiguration config,AuditDetailsUtil auditDetailsUtil) {
		this.objectMapper = objectMapper;
		this.repository = repository;
		this.idgenrepository = idgenrepository;
		this.config = config;
		this.auditDetailsUtil=auditDetailsUtil;
	}
	
	
	public ResponseEntity<ResponseInfoWrapper> createSterilizationDogApplication(SterilizationDogRequest sterilizationdogrequest) {
		try {
			SterilizationDogApplication sterilizationdogapplication = objectMapper.convertValue(sterilizationdogrequest.getSterilizationdogApplicationRequest(),
					SterilizationDogApplication.class);
			String stallid = UUID.randomUUID().toString();
			sterilizationdogapplication.setApplicationUuid(stallid);
			sterilizationdogapplication.setPick(true);
			sterilizationdogapplication.setRelease(false);
			sterilizationdogapplication.setIsActive(true);
			sterilizationdogapplication.setAuditDetails(
					auditDetailsUtil.getAuditDetails(sterilizationdogrequest.getRequestInfo(), CommonConstants.ACTION_CREATE));
			// idgen service call to genrate event id
			IdGenerationResponse id = idgenrepository.getId(sterilizationdogrequest.getRequestInfo(), sterilizationdogapplication.getTenantId(),
					config.getSterilizationdogapplicationNumberIdgenName(), config.getSterilizationdogapplicationNumberIdgenFormat(), 1);
			if (id.getIdResponses() != null && id.getIdResponses().get(0) != null)
				sterilizationdogapplication.setApplicationId(id.getIdResponses().get(0).getId());
			else
				throw new CustomException(HttpStatus.INTERNAL_SERVER_ERROR.toString(), CommonConstants.ID_GENERATION);

			sterilizationdogapplication.setApplicationstatus(CommonConstants.ACTION_CREATE);
			// save document to sterilization_dog_application_document table
			List<SterilizationDogDocument> sterilizationdogdoc = new ArrayList<>();
			for (SterilizationDogDocument docobj : sterilizationdogapplication.getApplicationDocument()) {
				SterilizationDogDocument document = new SterilizationDogDocument();
				document.setDocumnetUuid(UUID.randomUUID().toString());
				document.setApplicationUuid(stallid);
				document.setPickpicture(docobj.getPickpicture());
				document.setPickfilestoreId(docobj.getPickfilestoreId());
				document.setAuditDetails(
						auditDetailsUtil.getAuditDetails(sterilizationdogrequest.getRequestInfo(), CommonConstants.ACTION_CREATE));
				document.setIsActive(true);
				document.setTenantId(sterilizationdogapplication.getTenantId());
				sterilizationdogdoc.add(document);

			}

			sterilizationdogapplication.setApplicationDocument(sterilizationdogdoc);
		
			repository.createSterilizationDogApplication(sterilizationdogapplication);

			return new ResponseEntity<>(ResponseInfoWrapper.builder()
					.responseInfo(ResponseInfo.builder().status(CommonConstants.SUCCESS).build())
					.responseBody(sterilizationdogapplication).build(), HttpStatus.CREATED);

		} catch (Exception e) {
			throw new CustomException(CommonConstants.STERILIZATION__DOG_APPLICATION_EXCEPTION_CODE, e.getMessage());
		}
	}
	
	
	
	public ResponseEntity<ResponseInfoWrapper> getSterilizationDogApplication(SterilizationDogApplication sterilizationdogrequest) {
		try {
					
			List<SterilizationDogApplication> SterilizationDogApplicationresult = repository.getSterilizationDogApplication(sterilizationdogrequest);
			return new ResponseEntity<>(ResponseInfoWrapper.builder()
					.responseInfo(ResponseInfo.builder().status(CommonConstants.SUCCESS).build())
					.responseBody(SterilizationDogApplicationresult).build(), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			throw new CustomException(CommonConstants.STERILIZATION__DOG_APPLICATION_EXCEPTION_CODE, e.getMessage());
		}
	}
}
