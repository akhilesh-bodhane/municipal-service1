package org.egov.pmcalculator.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.egov.common.contract.request.RequestInfo;
import org.egov.mdms.model.MasterDetail;
import org.egov.mdms.model.MdmsCriteria;
import org.egov.mdms.model.MdmsCriteriaReq;
import org.egov.mdms.model.ModuleDetail;
import org.egov.pmcalculator.config.PMCalculatorConfigs;
import org.egov.pmcalculator.repository.ServiceRequestRepository;
import org.egov.pmcalculator.utils.PMCalculatorConstants;
import org.egov.pmcalculator.web.models.pm.PMDetail;
import org.egov.tracer.model.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jayway.jsonpath.JsonPath;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MDMSService {

	private PMCalculatorConfigs config;

	private ServiceRequestRepository serviceRequestRepository;

	@Autowired
	public MDMSService(PMCalculatorConfigs config, ServiceRequestRepository serviceRequestRepository) {
		this.config = config;
		this.serviceRequestRepository = serviceRequestRepository;
	}

	private MdmsCriteriaReq getMDMSRequest(RequestInfo requestInfo, String tenantId) {

		List<MasterDetail> fyMasterDetails = new ArrayList<>();

		final String filterCodeForUom = "$.[?(@.active==true)]";

		fyMasterDetails.add(
				MasterDetail.builder().name(PMCalculatorConstants.MDMS_FINANCIALYEAR).filter(filterCodeForUom).build());

		ModuleDetail fyModuleDtls = ModuleDetail.builder().masterDetails(fyMasterDetails)
				.moduleName(PMCalculatorConstants.MDMS_EGF_MASTER).build();

		List<MasterDetail> billMasterDetails = new ArrayList<>();
		billMasterDetails.add(MasterDetail.builder().name(PMCalculatorConstants.MDMS_TAXHEADMASTER).build());
		ModuleDetail billModuleDtls = ModuleDetail.builder().masterDetails(billMasterDetails)
				.moduleName(PMCalculatorConstants.MDMS_BILLINGSERVICE).build();

		List<ModuleDetail> moduleDetails = new ArrayList<>();
		moduleDetails.add(fyModuleDtls);
		moduleDetails.add(billModuleDtls);

		MdmsCriteria mdmsCriteria = MdmsCriteria.builder().moduleDetails(moduleDetails).tenantId(tenantId).build();

		return MdmsCriteriaReq.builder().requestInfo(requestInfo).mdmsCriteria(mdmsCriteria).build();
	}

	public Map<String, Long> getTaxPeriods(RequestInfo requestInfo, PMDetail pMDetail, Object mdmsData) {
		Map<String, Long> taxPeriods = new HashMap<>();
		try {
			String jsonPath = PMCalculatorConstants.MDMS_FINACIALYEAR_PATH.replace("{}", pMDetail.getFinancialYear());

			List<Map<String, Object>> jsonOutput = JsonPath.read(mdmsData, jsonPath);
			for (Map<String, Object> financialYearProperties : jsonOutput) {
				if (financialYearProperties.get("module").equals("OPMS")) {
					// Map<String, Object> financialYearProperties = jsonOutput.get(0);
					Object startDate = financialYearProperties.get(PMCalculatorConstants.MDMS_STARTDATE);
					Object endDate = financialYearProperties.get(PMCalculatorConstants.MDMS_ENDDATE);
					taxPeriods.put(PMCalculatorConstants.MDMS_STARTDATE, (Long) startDate);
					taxPeriods.put(PMCalculatorConstants.MDMS_ENDDATE, (Long) endDate);
					break;
				}
			}
		} catch (Exception e) {
			log.error("Error while fetvhing MDMS data", e);
			throw new CustomException("INVALID FINANCIALYEAR",
					"No data found for the financialYear: " + pMDetail.getFinancialYear());
		}
		return taxPeriods;
	}

	public BigDecimal getTaxAmount(RequestInfo requestInfo, PMDetail pMDetail, Object mdmsData) {
		BigDecimal taxAmount = BigDecimal.ZERO;
		try {

			LinkedHashMap opmsData = JsonPath.read(mdmsData, PMCalculatorConstants.MDMS_PM_PATH);
			if (opmsData.size() == 0)
				return BigDecimal.ZERO;

			List jsonOutput = JsonPath.read(mdmsData, PMCalculatorConstants.MDMS_TAXHEAD_PATH);

			for (Object entry : jsonOutput) {
				HashMap<String, Object> map = (HashMap<String, Object>) entry;

				String type = ((String) map.get("service")).split("\\.")[0];
				if (type.equals("OPMS")) {
					type = ((String) map.get("service")).split("\\.")[1];
					if (type != null && type.equalsIgnoreCase(pMDetail.getApplicationType())) {
						taxAmount = new BigDecimal(map.get("taxAmount").toString());
						break;
					}
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
