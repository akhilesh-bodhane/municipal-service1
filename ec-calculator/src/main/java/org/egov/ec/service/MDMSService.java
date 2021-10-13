package org.egov.ec.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.egov.common.contract.request.RequestInfo;
import org.egov.ec.config.ECConfigs;
import org.egov.ec.repository.ServiceRequestRepository;
import org.egov.ec.utils.ECConstants;
import org.egov.ec.web.models.ec.EcDetail;
import org.egov.mdms.model.MasterDetail;
import org.egov.mdms.model.MdmsCriteria;
import org.egov.mdms.model.MdmsCriteriaReq;
import org.egov.mdms.model.ModuleDetail;
import org.egov.tracer.model.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jayway.jsonpath.JsonPath;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MDMSService {

	private ECConfigs config;

	private ServiceRequestRepository serviceRequestRepository;

	@Autowired
	public MDMSService(ECConfigs config, ServiceRequestRepository serviceRequestRepository) {
		this.config = config;
		this.serviceRequestRepository = serviceRequestRepository;
	}

	private MdmsCriteriaReq getMDMSRequest(RequestInfo requestInfo, String tenantId) {

		List<MasterDetail> fyMasterDetails = new ArrayList<>();

		final String filterCodeForUom = "$.[?(@.active==true)]";

		fyMasterDetails.add(MasterDetail.builder().name(ECConstants.MDMS_FINANCIALYEAR)
				.filter(filterCodeForUom).build());

		ModuleDetail fyModuleDtls = ModuleDetail.builder().masterDetails(fyMasterDetails)
				.moduleName(ECConstants.MDMS_EGF_MASTER).build();

		List<MasterDetail> billMasterDetails = new ArrayList<>();
		billMasterDetails.add(MasterDetail.builder().name(ECConstants.MDMS_TAXHEADMASTER).build());
		ModuleDetail billModuleDtls = ModuleDetail.builder().masterDetails(billMasterDetails)
				.moduleName(ECConstants.MDMS_BILLINGSERVICE).build();

		List<ModuleDetail> moduleDetails = new ArrayList<>();
		moduleDetails.add(fyModuleDtls);
		moduleDetails.add(billModuleDtls);

		MdmsCriteria mdmsCriteria = MdmsCriteria.builder().moduleDetails(moduleDetails).tenantId(tenantId).build();

		return MdmsCriteriaReq.builder().requestInfo(requestInfo).mdmsCriteria(mdmsCriteria).build();
	}

	public Map<String, Long> getTaxPeriods(RequestInfo requestInfo, EcDetail ecDetail, Object mdmsData) {
		Map<String, Long> taxPeriods = new HashMap<>();
		try {
			String jsonPath = ECConstants.MDMS_FINACIALYEAR_PATH.replace("{}",
					ecDetail.getFinancialYear());

			List<Map<String, Object>> jsonOutput = JsonPath.read(mdmsData, jsonPath);
			for (Map<String, Object> financialYearProperties : jsonOutput) {
				if (financialYearProperties.get("module").equals("EC")) {
					// Map<String, Object> financialYearProperties = jsonOutput.get(0);
					Object startDate = financialYearProperties.get(ECConstants.MDMS_STARTDATE);
					Object endDate = financialYearProperties.get(ECConstants.MDMS_ENDDATE);
					taxPeriods.put(ECConstants.MDMS_STARTDATE, (Long) startDate);
					taxPeriods.put(ECConstants.MDMS_ENDDATE, (Long) endDate);
					break;
				}
			}

		} catch (Exception e) {
			log.error("Error while fetvhing MDMS data", e);
			throw new CustomException("INVALID FINANCIALYEAR",
					"No data found for the financialYear: " + ecDetail.getFinancialYear());
		}
		return taxPeriods;
	}

	public BigDecimal getTaxAmount(RequestInfo requestInfo, EcDetail ecDetail, Object mdmsData) {
		HashMap<String, Object> calculationType = new HashMap<>();
		BigDecimal taxAmount = BigDecimal.ZERO;
		try {

			LinkedHashMap opmsData = JsonPath.read(mdmsData, ECConstants.MDMS_PM_PATH);
			if (opmsData.size() == 0)
				return BigDecimal.ZERO;

			List jsonOutput = JsonPath.read(mdmsData, ECConstants.MDMS_TAXHEAD_PATH);

			for (Object entry : jsonOutput) {
				HashMap<String, Object> map = (HashMap<String, Object>) entry;

				String name = ((String) map.get("name"));
				if (name != null && name.equalsIgnoreCase(ecDetail.getChallanNumber())) {
					taxAmount = new BigDecimal(map.get("taxAmount").toString());
					break;
				}
			}

		} catch (Exception e) {
			throw new CustomException("MDMS ERROR", "Failed to get calculationType");
		}

		return taxAmount;
	}

	public Object mDMSCall(RequestInfo requestInfo, String tenantId) {
		MdmsCriteriaReq mdmsCriteriaReq = getMDMSRequest(requestInfo, tenantId);
		StringBuilder url = getMdmsSearchUrl();
		Object result = serviceRequestRepository.fetchResult(url, mdmsCriteriaReq);
		return result;
	}

	/**
	 * Creates and returns the url for mdms search endpoint
	 *
	 * @return MDMS Search URL
	 */
	private StringBuilder getMdmsSearchUrl() {
		return new StringBuilder().append(config.getMdmsHost()).append(config.getMdmsSearchEndpoint());
	}

}
