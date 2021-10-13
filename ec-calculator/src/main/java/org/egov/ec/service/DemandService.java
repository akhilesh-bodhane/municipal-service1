package org.egov.ec.service;

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
import org.egov.ec.config.ECConfigs;
import org.egov.ec.repository.CalculationRepository;
import org.egov.ec.repository.DemandRepository;
import org.egov.ec.repository.ServiceRequestRepository;
import org.egov.ec.repository.builder.CalculationQueryBuilder;
import org.egov.ec.utils.CalculationUtils;
import org.egov.ec.utils.ECConstants;
import org.egov.ec.web.models.Calculation;
import org.egov.ec.web.models.RequestInfoWrapper;
import org.egov.ec.web.models.demand.Demand;
import org.egov.ec.web.models.demand.DemandDetail;
import org.egov.ec.web.models.demand.DemandResponse;
import org.egov.ec.web.models.demand.TaxHeadEstimate;
import org.egov.ec.web.models.ec.EcDetail;
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
	private ECConfigs config;

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
					.map(calculation -> calculation.getEcDetail().getChallanNumber()).collect(Collectors.toSet());
			List<Demand> demands = searchDemand(tenantId, applicationNumbers, requestInfo);
			Set<String> applicationNumbersFromDemands = new HashSet<>();
			if (!CollectionUtils.isEmpty(demands))
				applicationNumbersFromDemands = demands.stream().map(Demand::getConsumerCode)
						.collect(Collectors.toSet());

			// If demand already exists add it updateCalculations else createCalculations
			for (Calculation calculation : calculations) {
				if (!applicationNumbersFromDemands.contains(calculation.getEcDetail().getChallanNumber()))
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
			EcDetail ecDetail = null;

			if (calculation.getEcDetail() != null)
				ecDetail = calculation.getEcDetail();
			else
				new CustomException("ECHALLAN_DETAILS", "No ECHALLAN details found");

			if (ecDetail == null)
				throw new CustomException("INVALID CHALLANNUMBER",
						"Demand cannot be generated for challanNumber " + calculation.getChallanNumber()
								+ " Echallan  with this number does not exist");

			String tenantId = calculation.getTenantId();
			String consumerCode = calculation.getEcDetail().getChallanNumber();
			String userUuid=calculation.getEcDetail().getUuid();
			List<DemandDetail> demandDetails = new LinkedList<>();
			calculation.getTaxHeadEstimates().forEach(taxHeadEstimate -> {
				demandDetails.add(DemandDetail.builder().taxAmount(taxHeadEstimate.getEstimateAmount())
						.taxHeadMasterCode(taxHeadEstimate.getTaxHeadCode()).collectionAmount(BigDecimal.ZERO)
						.tenantId(tenantId).build());
			});

			Map<String, Long> taxPeriods = mdmsService.getTaxPeriods(requestInfo, ecDetail, mdmsData);

			demands.add(Demand.builder().consumerCode(consumerCode).demandDetails(demandDetails).payer(User.builder().uuid(userUuid).build())
					.minimumAmountPayable(config.getMinimumPayableAmount()).tenantId(tenantId)
					.taxPeriodFrom(taxPeriods.get(ECConstants.MDMS_STARTDATE))
					.taxPeriodTo(taxPeriods.get(ECConstants.MDMS_ENDDATE))
					.consumerType(config.getBusinessService())
					.businessService(config.getBusinessService())
					.build());
		}
		return demandRepository.saveDemand(requestInfo, demands);
	}

	private List<Demand> updateDemand(RequestInfo requestInfo, List<Calculation> calculations) {
		List<Demand> demands = new LinkedList<>();
		for (Calculation calculation : calculations) {

			List<Demand> searchResult = searchDemand(calculation.getTenantId(),
					Collections.singleton(calculation.getEcDetail().getChallanNumber()), requestInfo);

			if (CollectionUtils.isEmpty(searchResult))
				throw new CustomException("INVALID UPDATE", "No demand exists for applicationNumber: "
						+ calculation.getEcDetail().getChallanNumber());

			Demand demand = searchResult.get(0);
			List<DemandDetail> demandDetails = demand.getDemandDetails();
			List<DemandDetail> updatedDemandDetails = getUpdatedDemandDetails(calculation, demandDetails);
			demand.setDemandDetails(updatedDemandDetails);
			demands.add(demand);
		}
		return demandRepository.updateDemand(requestInfo, demands);
	}

	private List<Demand> searchDemand(String tenantId, Set<String> consumerCodes, RequestInfo requestInfo) {
		String uri = utils.getDemandSearchURL();
		uri = uri.replace("{1}", tenantId);
		uri = uri.replace("{2}", config.getBusinessService());
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
