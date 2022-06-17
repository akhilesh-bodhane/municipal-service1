package org.egov.temporarystall.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.egov.common.contract.request.RequestInfo;
import org.egov.mdms.model.MasterDetail;
import org.egov.mdms.model.MdmsCriteria;
import org.egov.mdms.model.MdmsCriteriaReq;
import org.egov.mdms.model.ModuleDetail;
import org.egov.temporarystall.common.CommonConstants;
import org.egov.temporarystall.config.StallConfiguration;
import org.egov.temporarystall.model.StallApplication;
import org.egov.temporarystall.model.StallRequest;
import org.egov.temporarystall.repository.ServiceRequestRepository;
import org.egov.tracer.model.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jayway.jsonpath.JsonPath;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MDMSService {
	
	private StallConfiguration config;
	
	private ServiceRequestRepository serviceRequestRepository;
	
	
	@Autowired
	public MDMSService(StallConfiguration config, ServiceRequestRepository serviceRequestRepository) {
		this.config = config;
		this.serviceRequestRepository = serviceRequestRepository;
	}
	
	public Object mDMSCall(RequestInfo requestInfo, String tenantId) {
		MdmsCriteriaReq mdmsCriteriaReq = getMDMSRequest(requestInfo, tenantId);
		StringBuilder url = getMdmsSearchUrl();
		Object result = serviceRequestRepository.fetchResult(url, mdmsCriteriaReq);
		return result;
	}
	
	
	
	private MdmsCriteriaReq getMDMSRequest(RequestInfo requestInfo, String tenantId) {

		/*
		 * List<MasterDetail> fyMasterDetails = new ArrayList<>();
		 * 
		 * final String filterCodeForUom = "$.[?(@.active==true)]";
		 */
		
		List<MasterDetail> fyMasterDetails = new ArrayList<>();
		
		final String filterCodeForUom = "$.[?(@.active==true)]";

		fyMasterDetails.add(
				MasterDetail.builder().name(CommonConstants.MDMS_FINANCIALYEAR).filter(filterCodeForUom).build());

		ModuleDetail fyModuleDtls = ModuleDetail.builder().masterDetails(fyMasterDetails)
				.moduleName(CommonConstants.MDMS_EGF_MASTER).build();
		
		List<MasterDetail> billMasterDetails = new ArrayList<>();
		billMasterDetails.add(MasterDetail.builder().name(CommonConstants.MDMS_FESTIVAL).build());
		billMasterDetails.add(MasterDetail.builder().name(CommonConstants.SIZE).build());
		billMasterDetails.add(MasterDetail.builder().name(CommonConstants.STALLCONFIG).build());
		ModuleDetail billModuleDtls = ModuleDetail.builder().masterDetails(billMasterDetails)
				.moduleName(CommonConstants.MDMS_TEMPORARYSTALL).build();
		
		
		/*
		 * List<MasterDetail> stallSize = new ArrayList<>();
		 * stallSize.add(MasterDetail.builder().name(CommonConstants.SIZE).build());
		 * ModuleDetail stallsizeDetails =
		 * ModuleDetail.builder().masterDetails(stallSize)
		 * .moduleName(CommonConstants.MDMS_TEMPORARYSTALL).build();
		 */
		 
		
		List<ModuleDetail> moduleDetails = new ArrayList<>();
		moduleDetails.add(fyModuleDtls);
		moduleDetails.add(billModuleDtls);
		//moduleDetails.add(stallsizeDetails);

		MdmsCriteria mdmsCriteria = MdmsCriteria.builder().moduleDetails(moduleDetails).tenantId(tenantId).build();

		return MdmsCriteriaReq.builder().requestInfo(requestInfo).mdmsCriteria(mdmsCriteria).build();
	}
	
	private StringBuilder getMdmsSearchUrl() {
		
		return new StringBuilder().append(config.getMdmsHost()).append(config.getMdmsSearchEndpoint());
	}
	
	/*
	 * public Map<String,Long> getTaxPeriods(RequestInfo
	 * requestInfo,StallApplication stallrequest,Object mdmsData){ Map<String,Long>
	 * taxPeriods = new HashMap<>(); try { String jsonPath =
	 * CommonConstants.MDMS_FINANCIALYEAR.replace("{}",stallrequest.getFinancialyear
	 * ()); List<Map<String,Object>> jsonOutput = JsonPath.read(mdmsData, jsonPath);
	 * Map<String,Object> financialYearProperties = jsonOutput.get(0); Object
	 * startDate = financialYearProperties.get(CommonConstants.MDMS_STARTDATE);
	 * Object endDate = financialYearProperties.get(CommonConstants.MDMS_ENDDATE);
	 * taxPeriods.put(CommonConstants.MDMS_STARTDATE,(Long) startDate);
	 * taxPeriods.put(CommonConstants.MDMS_ENDDATE,(Long) endDate);
	 * 
	 * } catch (Exception e) { log.error("Error while fetvhing MDMS data", e); throw
	 * new CustomException("INVALID FINANCIALYEAR",
	 * "No data found for the financialYear: "+stallrequest.getFinancialyear()); }
	 * return taxPeriods; }
	 */

}
