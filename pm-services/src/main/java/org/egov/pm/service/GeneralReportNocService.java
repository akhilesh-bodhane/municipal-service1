package org.egov.pm.service;

import org.egov.common.contract.response.ResponseInfo;
import org.egov.pm.model.IUDXRequestData;
import org.egov.pm.repository.GeneralReportNocRepository;
import org.egov.pm.util.CommonConstants;
import org.egov.pm.web.contract.IUDXNocData;
import org.egov.pm.web.contract.IUDXNocResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class GeneralReportNocService {

	@Autowired
	private GeneralReportNocRepository generalReportNocRepository;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public ResponseEntity<IUDXNocResponse> getIUDXNOCDATA(IUDXRequestData iudxRequestData) {
		if (iudxRequestData.getRequestData() != null && iudxRequestData.getRequestData().getTenantId() != null
				&& !iudxRequestData.getRequestData().getTenantId().isEmpty()
				&& iudxRequestData.getRequestData().getFromDate() != null
				&& iudxRequestData.getRequestData().getToDate() != null) {
			IUDXNocData data = IUDXNocData.builder()
					.services(generalReportNocRepository.getIUDXNOCDATARepository(iudxRequestData))
					.cityName("chandigarh").build();
			return new ResponseEntity(IUDXNocResponse.builder()
					.resposneInfo(ResponseInfo.builder().status(CommonConstants.SUCCESS).build()).iudxNocData(data)
					.build(), HttpStatus.OK);
		} else {
			return new ResponseEntity(
					IUDXNocResponse.builder()
							.resposneInfo(ResponseInfo.builder().status(CommonConstants.FAIL)
									.msgId("tenant id, from date, todate are mandatory").build())
							.build(),
					HttpStatus.OK);
		}
	}
}
