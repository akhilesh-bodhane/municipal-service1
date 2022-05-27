package org.egov.pgr.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.egov.pgr.contract.SwatchBharatRequest;
import org.egov.pgr.contract.SwatchBharatResponse;
import org.egov.pgr.model.AuditDetails;
import org.egov.pgr.model.SwatchBharat;
import org.egov.pgr.producer.PGRProducer;
import org.egov.pgr.repository.SwatchBharatRepository;
import org.egov.pgr.utils.ErrorConstants;
import org.egov.pgr.utils.PGRUtils;
import org.egov.pgr.utils.ReportUtils;
import org.egov.pgr.utils.ResponseInfoFactory;
import org.egov.tracer.model.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import lombok.extern.slf4j.Slf4j;

@org.springframework.stereotype.Service
@Slf4j
public class SwatchBharatService {

	@Value("${kafka.topics.save.swatchbharatservice}")
	private String saveTopic;

//	@Value("${kafka.topics.update.swatchbharatservice}")
//	private String updateTopic;

	@Autowired
	private PGRUtils pGRUtils;

	@Autowired
	private PGRProducer pGRProducer;

	@Autowired
	private ResponseInfoFactory factory;

	@Autowired
	private ReportUtils reportUtils;

	@Autowired
	private SwatchBharatRepository swatchBharatRepository;

	public SwatchBharatResponse create(SwatchBharatRequest swatchBharatRequest) {
		Map<String, String> errorMap = new HashMap<>();
		validate(swatchBharatRequest, errorMap);

		if (!errorMap.isEmpty()) {
			throw new CustomException(errorMap);
		}

		AuditDetails auditDetails = pGRUtils
				.getAuditDetails(String.valueOf(swatchBharatRequest.getRequestInfo().getUserInfo().getId()), true);
		swatchBharatRequest.getSwatchBharat().stream().forEach(e -> {
			e.setAuditDetails(auditDetails);
			e.setUuid(UUID.randomUUID().toString());
		});

		pGRProducer.push(saveTopic, swatchBharatRequest);
		return getSwatchBharatResponse(swatchBharatRequest);
	}

	/*
	 * public SwatchBharatResponse update(SwatchBharatRequest swatchBharatRequest) {
	 * pGRProducer.push(updateTopic, swatchBharatRequest); return
	 * getSwatchBharatResponse(swatchBharatRequest); }
	 */

	public SwatchBharatResponse getSwatchBharatResponse(SwatchBharatRequest swatchBharatRequest) {
		return SwatchBharatResponse.builder()
				.responseInfo(factory.createResponseInfoFromRequestInfo(swatchBharatRequest.getRequestInfo(), true))
				.swatchBharat(swatchBharatRequest.getSwatchBharat()).build();
	}

	public SwatchBharatResponse getSwatchBharatRequestDetails(SwatchBharatRequest swatchBharatRequest) {
		SwatchBharatResponse swatchBharatResponse = new SwatchBharatResponse();
		List<SwatchBharat> dataFromDb = swatchBharatRepository.getDataFromDb(swatchBharatRequest);
//		enrichAndFormatResponse(swatchBharatResponse, dataFromDb);
		swatchBharatResponse.setSwatchBharat(dataFromDb);
		
		swatchBharatResponse
				.setResponseInfo(factory.createResponseInfoFromRequestInfo(swatchBharatRequest.getRequestInfo(), true));
		return swatchBharatResponse;
	}

	private void validate(SwatchBharatRequest swatchBharatRequest, Map<String, String> errorMap) {
		for (SwatchBharat s : swatchBharatRequest.getSwatchBharat()) {
			if (s.getUseruuid() == null || s.getUseruuid().isEmpty()) {
				errorMap.put(ErrorConstants.INVALID_SWATCHBHARATUSERID_CODE,
						ErrorConstants.INVALID_SWATCHBHARATUSERID_MSG);
			}
			if (s.getFileid() == null || s.getFileid().isEmpty()) {
				errorMap.put(ErrorConstants.INVALID_SWATCHBHARATFILEDID_CODE,
						ErrorConstants.INVALID_SWATCHBHARATFILEDID_MSG);
			}
		}
	}

	public SwatchBharatResponse enrichAndFormatResponse(SwatchBharatResponse swatchBharatResponse,
			List<Map<String, Object>> dbResponse) {
		List<SwatchBharat> sList = new ArrayList<SwatchBharat>();
		for (Map<String, Object> tuple : dbResponse) {
			AuditDetails auditDetails = AuditDetails.builder()
					.createdBy(reportUtils.splitCamelCase(tuple.get("createdby").toString()))
					.createdTime(Long.parseLong(reportUtils.splitCamelCase(tuple.get("createddate").toString())))
					.lastModifiedBy(reportUtils.splitCamelCase(tuple.get("updatedby").toString()))
					.lastModifiedTime(Long.parseLong(reportUtils.splitCamelCase(tuple.get("updateddate").toString())))
					.build();
			SwatchBharat s = SwatchBharat.builder()
					.useruuid(reportUtils.splitCamelCase(tuple.get("useruuid").toString()))
					.fileid(reportUtils.splitCamelCase(tuple.get("fileid").toString()))
					.uuid(reportUtils.splitCamelCase(tuple.get("uuid").toString()))
					.isvalidimage(Boolean.parseBoolean(tuple.get("isvalidimage").toString()))
					.username(reportUtils.splitCamelCase(tuple.get("username").toString()))
					.workbookid(Long.parseLong(reportUtils.splitCamelCase(tuple.get("workbookid").toString()))).auditDetails(auditDetails)
					.build();

			sList.add(s);
		}
		swatchBharatResponse.setSwatchBharat(sList);

		return swatchBharatResponse;
	}
}
