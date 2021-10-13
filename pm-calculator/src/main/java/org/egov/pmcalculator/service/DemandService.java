package org.egov.pmcalculator.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.egov.common.contract.request.RequestInfo;
import org.egov.common.contract.request.User;
import org.egov.pmcalculator.config.PMCalculatorConfigs;
import org.egov.pmcalculator.repository.CalculationRepository;
import org.egov.pmcalculator.repository.DemandRepository;
import org.egov.pmcalculator.repository.ServiceRequestRepository;
import org.egov.pmcalculator.repository.builder.CalculationQueryBuilder;
import org.egov.pmcalculator.utils.CalculationUtils;
import org.egov.pmcalculator.utils.PMCalculatorConstants;
import org.egov.pmcalculator.web.models.Calculation;
import org.egov.pmcalculator.web.models.RequestInfoWrapper;
import org.egov.pmcalculator.web.models.demand.Demand;
import org.egov.pmcalculator.web.models.demand.DemandDetail;
import org.egov.pmcalculator.web.models.demand.DemandResponse;
import org.egov.pmcalculator.web.models.demand.TaxHeadEstimate;
import org.egov.pmcalculator.web.models.pm.PMDetail;
import org.egov.tracer.model.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class DemandService {

	@Autowired
	private CalculationService calculationService;

	@Autowired
	private CalculationUtils utils;

	@Autowired
	private PMCalculatorConfigs config;

	@Autowired
	private ServiceRequestRepository serviceRequestRepository;

	@Autowired
	private ObjectMapper mapper;

	@Autowired
	private DemandRepository demandRepository;

	@Autowired
	private MDMSService mdmsService;

	@Autowired
	private CalculationRepository calculationRepository;

	@Autowired
	private CalculationQueryBuilder calculationQueryBuilder;

	public void generateDemand(RequestInfo requestInfo, List<Calculation> calculations, Object mdmsData) {

		// List that will contain Calculation for new demands
		List<Calculation> createCalculations = new LinkedList<>();

		// List that will contain Calculation for old demands
		List<Calculation> updateCalculations = new LinkedList<>();

		if (!CollectionUtils.isEmpty(calculations)) {

			// Collect required parameters for demand search
			String tenantId = calculations.get(0).getTenantId();
			Set<String> applicationNumbers = calculations.stream()
					.map(calculation -> calculation.getOpmsDetail().getApplicationNumber()).collect(Collectors.toSet());

			String applicationType = calculations.stream()
					.map(calculation -> calculation.getOpmsDetail().getApplicationType()).findAny().orElse("");

			List<Demand> demands = searchDemand(tenantId, applicationNumbers, requestInfo, applicationType,
					calculations.get(0).getOpmsDetail().getRoadCutDivision());
			Set<String> applicationNumbersFromDemands = new HashSet<>();
			if (!CollectionUtils.isEmpty(demands))
				applicationNumbersFromDemands = demands.stream().map(Demand::getConsumerCode)
						.collect(Collectors.toSet());

			// If demand already exists add it updateCalculations else createCalculations
			for (Calculation calculation : calculations) {
				if (!applicationNumbersFromDemands.contains(calculation.getOpmsDetail().getApplicationNumber()))
					createCalculations.add(calculation);
				else
					updateCalculations.add(calculation);
			}
		}

		if (!CollectionUtils.isEmpty(createCalculations))
			createDemand(requestInfo, createCalculations, mdmsData);

		if (!CollectionUtils.isEmpty(updateCalculations))
			updateDemand(requestInfo, updateCalculations);
	}

	private List<Demand> createDemand(RequestInfo requestInfo, List<Calculation> calculations, Object mdmsData) {
		List<Demand> demands = new LinkedList<>();
		for (Calculation calculation : calculations) {
			PMDetail pMDetail = null;

			if (calculation.getOpmsDetail() != null)
				pMDetail = calculation.getOpmsDetail();
			else
				new CustomException("PM_DETAILS_EXCEPTION", "No OPMS details found");

			if (pMDetail == null)
				throw new CustomException("INVALID_APPLICATIONNUMBER_EXCEPTION",
						"Demand cannot be generated for applicationNumber " + calculation.getApplicationNumber()
								+ " OPMS Noc with this number does not exist ");

			String tenantId = calculation.getTenantId();
			String consumerCode = calculation.getOpmsDetail().getApplicationNumber();

			User owner = pMDetail.getOwners().get(0).toCommonUser();
			List<DemandDetail> demandDetails = new LinkedList<>();
			calculation.getTaxHeadEstimates().forEach(taxHeadEstimate -> {
				demandDetails.add(DemandDetail.builder().taxAmount(taxHeadEstimate.getEstimateAmount())
						.taxHeadMasterCode(taxHeadEstimate.getTaxHeadCode()).collectionAmount(BigDecimal.ZERO)
						.tenantId(tenantId).build());
			});

			Map<String, Long> taxPeriods = mdmsService.getTaxPeriods(requestInfo, pMDetail, mdmsData);

			StringBuilder businessService = new StringBuilder();

			businessService.append(config.getBusinessService()).append(".")
					.append(calculation.getOpmsDetail().getRoadCutDivision() != null
							? calculation.getOpmsDetail().getApplicationType() + "_"
									+ calculation.getOpmsDetail().getRoadCutDivision()
							: calculation.getOpmsDetail().getApplicationType());

			demands.add(Demand.builder().consumerCode(consumerCode).demandDetails(demandDetails).payer(owner)
					.minimumAmountPayable(config.getMinimumPayableAmount()).tenantId(tenantId)
					.taxPeriodFrom(taxPeriods.get(PMCalculatorConstants.MDMS_STARTDATE))
					.taxPeriodTo(taxPeriods.get(PMCalculatorConstants.MDMS_ENDDATE))
					.consumerType(pMDetail.getApplicationType()).businessService(businessService.toString()).build());
		}
		return demandRepository.saveDemand(requestInfo, demands);
	}

	private List<Demand> updateDemand(RequestInfo requestInfo, List<Calculation> calculations) {
		List<Demand> demands = new LinkedList<>();
		for (Calculation calculation : calculations) {

			List<Demand> searchResult = searchDemand(calculation.getTenantId(),
					Collections.singleton(calculation.getOpmsDetail().getApplicationNumber()), requestInfo,
					calculation.getOpmsDetail().getApplicationType(), calculation.getOpmsDetail().getRoadCutDivision());

			if (CollectionUtils.isEmpty(searchResult))
				throw new CustomException("INVALID UPDATE", "No demand exists for applicationNumber: "
						+ calculation.getOpmsDetail().getApplicationNumber());

			Demand demand = searchResult.get(0);
			List<DemandDetail> demandDetails = demand.getDemandDetails();
			List<DemandDetail> updatedDemandDetails = getUpdatedDemandDetails(calculation, demandDetails);
			demand.setDemandDetails(updatedDemandDetails);
			demands.add(demand);
		}
		return demandRepository.updateDemand(requestInfo, demands);
	}

	private List<Demand> searchDemand(String tenantId, Set<String> consumerCodes, RequestInfo requestInfo,
			String applicationType, String division) {
		StringBuilder businessService = new StringBuilder();
		// businessService.append(config.getBusinessService()).append(".").append(applicationType);

		businessService.append(config.getBusinessService()).append(".")
				.append(division != null ? applicationType + "_" + division : applicationType);

		String uri = utils.getDemandSearchURL();
		uri = uri.replace("{1}", tenantId);
		uri = uri.replace("{2}", businessService);
		uri = uri.replace("{3}", StringUtils.join(consumerCodes, ','));

		Object result = serviceRequestRepository.fetchResult(new StringBuilder(uri),
				RequestInfoWrapper.builder().requestInfo(requestInfo).build());

		DemandResponse response;
		try {
			response = mapper.convertValue(result, DemandResponse.class);
		} catch (IllegalArgumentException e) {
			throw new CustomException("PARSING ERROR", "Failed to parse response from Demand Search");
		}

		if (CollectionUtils.isEmpty(response.getDemands()))
			return null;

		else
			return response.getDemands();

	}

	private List<DemandDetail> getUpdatedDemandDetails(Calculation calculation, List<DemandDetail> demandDetails) {

		List<DemandDetail> newDemandDetails = new ArrayList<>();
		Map<String, List<DemandDetail>> taxHeadToDemandDetail = new HashMap<>();

		demandDetails.forEach(demandDetail -> {
			if (!taxHeadToDemandDetail.containsKey(demandDetail.getTaxHeadMasterCode())) {
				List<DemandDetail> demandDetailList = new LinkedList<>();
				demandDetailList.add(demandDetail);
				taxHeadToDemandDetail.put(demandDetail.getTaxHeadMasterCode(), demandDetailList);
			} else
				taxHeadToDemandDetail.get(demandDetail.getTaxHeadMasterCode()).add(demandDetail);
		});

		BigDecimal diffInTaxAmount;
		List<DemandDetail> demandDetailList;
		BigDecimal total;

		for (TaxHeadEstimate taxHeadEstimate : calculation.getTaxHeadEstimates()) {
			if (!taxHeadToDemandDetail.containsKey(taxHeadEstimate.getTaxHeadCode()))
				newDemandDetails.add(DemandDetail.builder().taxAmount(taxHeadEstimate.getEstimateAmount())
						.taxHeadMasterCode(taxHeadEstimate.getTaxHeadCode()).tenantId(calculation.getTenantId())
						.collectionAmount(BigDecimal.ZERO).build());
			else {
				demandDetailList = taxHeadToDemandDetail.get(taxHeadEstimate.getTaxHeadCode());
				total = demandDetailList.stream().map(DemandDetail::getTaxAmount).reduce(BigDecimal.ZERO,
						BigDecimal::add);
				diffInTaxAmount = taxHeadEstimate.getEstimateAmount().subtract(total);
				if (diffInTaxAmount.compareTo(BigDecimal.ZERO) != 0) {
					newDemandDetails.add(DemandDetail.builder().taxAmount(diffInTaxAmount)
							.taxHeadMasterCode(taxHeadEstimate.getTaxHeadCode()).tenantId(calculation.getTenantId())
							.collectionAmount(BigDecimal.ZERO).build());
				}
			}
		}
		List<DemandDetail> combinedBillDetials = new LinkedList<>(demandDetails);
		combinedBillDetials.addAll(newDemandDetails);

		return combinedBillDetials;
	}

}
