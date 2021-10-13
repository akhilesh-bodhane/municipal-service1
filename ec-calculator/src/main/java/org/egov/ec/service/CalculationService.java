package org.egov.ec.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.egov.common.contract.request.RequestInfo;
import org.egov.ec.config.ECConfigs;
import org.egov.ec.kafka.broker.ECProducer;
import org.egov.ec.repository.CalculationRepository;
import org.egov.ec.repository.ServiceRequestRepository;
import org.egov.ec.utils.CalculationUtils;
import org.egov.ec.web.models.Calculation;
import org.egov.ec.web.models.CalculationReq;
import org.egov.ec.web.models.CalculationRes;
import org.egov.ec.web.models.CalulationCriteria;
import org.egov.ec.web.models.demand.Category;
import org.egov.ec.web.models.demand.TaxHeadEstimate;
import org.egov.ec.web.models.ec.EcDetail;
import org.egov.ec.web.models.ec.EstimatesAndSlabs;
import org.egov.tracer.model.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CalculationService {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private ECConfigs config;

	@Autowired
	private ServiceRequestRepository serviceRequestRepository;

	@Autowired
	private CalculationUtils utils;

	@Autowired
	private DemandService demandService;

	@Autowired
	private ECProducer producer;

	@Autowired
	private MDMSService mdmsService;

	@Autowired
	private CalculationRepository calculationRepository;

	public List<Calculation> calculate(CalculationReq calculationReq) {

		String tenantId = calculationReq.getCalulationCriteria().get(0).getTenantId();

		Object mdmsData = mdmsService.mDMSCall(calculationReq.getRequestInfo(), tenantId);

		List<Calculation> calculations = getCalculation(calculationReq.getRequestInfo(),
				calculationReq.getCalulationCriteria(), mdmsData);

		demandService.generateDemand(calculationReq.getRequestInfo(), calculations, mdmsData);

		CalculationRes calculationRes = CalculationRes.builder().calculations(calculations).build();
		return calculations;

	}

	public List<Calculation> getCalculation(RequestInfo requestInfo, List<CalulationCriteria> criterias,
			Object mdmsData) {

		List<Calculation> calculations = new LinkedList<>();
		for (CalulationCriteria criteria : criterias) {
			EcDetail ec;
			if (criteria.getEcDetail() != null && criteria.getChallanNumber() != null) {
				ec = criteria.getEcDetail();
				criteria.setEcDetail(ec);
			} else {
				new CustomException("EC_DETAILS", "No EC details found");
			}

			EstimatesAndSlabs estimatesAndSlabs = getTaxHeadEstimates(criteria, requestInfo, mdmsData);
			List<TaxHeadEstimate> taxHeadEstimates = estimatesAndSlabs.getEstimates();

			Calculation calculation = new Calculation();
			calculation.setChallanNumber(criteria.getChallanNumber());
			calculation.setEcDetail(criteria.getEcDetail());
			calculation.setTenantId(criteria.getTenantId());
			calculation.setTaxHeadEstimates(taxHeadEstimates);
			calculations.add(calculation);
		}
		return calculations;
	}

	private EstimatesAndSlabs getTaxHeadEstimates(CalulationCriteria calulationCriteria, RequestInfo requestInfo,
			Object mdmsData) {
		// 1. Test Base Tax from MDMS -
		// 2. Get calculated amount for types
		List<TaxHeadEstimate> taxHeadEstimates = new ArrayList<>();

		EstimatesAndSlabs estimatesAndSlabs = getBaseTax(calulationCriteria, requestInfo, mdmsData);
		List<TaxHeadEstimate> tax = estimatesAndSlabs.getEstimates();

		TaxHeadEstimate estimate = new TaxHeadEstimate();
		estimate.setCategory(Category.FEE);

			BigDecimal amount = getChallanFee(calulationCriteria.getEcDetail());
			estimate.setTaxHeadCode(config.getBaseEcFeeHead());
			estimate.setEstimateAmount(amount.setScale(0, BigDecimal.ROUND_UP));

			for (TaxHeadEstimate taxHeadEstimate : tax) {
				BigDecimal taxValue = taxHeadEstimate.getEstimateAmount();
				taxValue = taxValue.compareTo(BigDecimal.ZERO) < -1 ? BigDecimal.valueOf(1) : taxValue;
				taxHeadEstimate.setEstimateAmount(taxValue.setScale(0, BigDecimal.ROUND_UP));
				taxHeadEstimates.add(taxHeadEstimate);
			}

		taxHeadEstimates.add(estimate);
		estimatesAndSlabs.setEstimates(taxHeadEstimates);

		return estimatesAndSlabs;
	}

	private EstimatesAndSlabs getBaseTax(CalulationCriteria calulationCriteria, RequestInfo requestInfo,
			Object mdmsData) {

		// This will get all taxes from mdm

		EstimatesAndSlabs estimatesAndSlabs = new EstimatesAndSlabs();
		TaxHeadEstimate estimate = new TaxHeadEstimate();

		// Need add MDM Tax data
		BigDecimal totalTax = getChallanPenalty(calulationCriteria.getEcDetail());

		// add type wise tax head
			estimate.setTaxHeadCode(config.getBaseEcPenaltyHead());
			estimate.setEstimateAmount(totalTax);
		

		estimate.setCategory(Category.TAX);

		estimatesAndSlabs.setEstimates(Collections.singletonList(estimate));
		return estimatesAndSlabs;
	}

	private BigDecimal getChallanFee(EcDetail ecDetail) {

		BigDecimal results = BigDecimal.ZERO;

		Double calData = calculationRepository.getFineAmount(ecDetail.getChallanNumber(), ecDetail.getTenantId());

				results = new BigDecimal(calData);

		return results.setScale(0, BigDecimal.ROUND_UP);
	}
	
	private BigDecimal getChallanPenalty(EcDetail ecDetail) {

		BigDecimal results = BigDecimal.ZERO;

			Double calData = calculationRepository.getPenaltyAmount(ecDetail.getChallanNumber(), ecDetail.getTenantId());

				results = new BigDecimal(calData);

		return results.setScale(0, BigDecimal.ROUND_UP);
	}
}
