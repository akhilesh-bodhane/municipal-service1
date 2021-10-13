package org.egov.waterconnection.service;

import java.util.List;

import org.egov.waterconnection.model.BillGeneration;
import org.egov.waterconnection.model.BillGenerationRequest;
import org.egov.waterconnection.repository.WaterReportRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class WaterReportService {

	@Autowired
	private WaterReportRepo waterReportRepo;

	public List<BillGeneration> getPiechartData(BillGenerationRequest billGenerationRequest) {


		return waterReportRepo.getPiechartData(billGenerationRequest.getBillGeneration());
		 
	}
}
