package org.egov.pgr.service;

import java.util.List;

import org.egov.common.contract.request.RequestInfo;
import org.egov.pgr.contract.ServiceReqSearchCriteria;
import org.egov.pgr.model.IUDXResponse;
import org.egov.pgr.repository.IUDXRepository;
import org.springframework.beans.factory.annotation.Autowired;

import lombok.extern.slf4j.Slf4j;

@org.springframework.stereotype.Service
@Slf4j
public class IUDXService {

	@Autowired
	private IUDXRepository iudxRepository;

	public List<IUDXResponse> search(RequestInfo requestInfo, ServiceReqSearchCriteria serviceReqSearchCriteria) {
		return iudxRepository.search(requestInfo, serviceReqSearchCriteria);
	}
}
