package org.egov.wscalculation.service;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.egov.common.contract.request.RequestInfo;
import org.egov.tracer.model.CustomException;
import org.egov.wscalculation.constants.WSCalculationConstant;
import org.egov.wscalculation.model.BillGeneration;
import org.egov.wscalculation.model.BillGenerationRequest;
import org.egov.wscalculation.model.Calculation;
import org.egov.wscalculation.model.CalculationCriteria;
import org.egov.wscalculation.model.Category;
import org.egov.wscalculation.model.TaxHeadEstimate;
import org.egov.wscalculation.model.TaxHeadMaster;
import org.egov.wscalculation.model.WaterConnection;
import org.egov.wscalculation.repository.BillingRepository;
import org.egov.wscalculation.util.CalculatorUtil;
import org.egov.wscalculation.util.WSCalculationUtil;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;
import net.minidev.json.JSONArray;

@Service
@Slf4j
public class BillingService {

	@Autowired
	private BillingRepository billingRepository;

	@Autowired
	private MasterDataService masterDataService;

	@Autowired
	private ObjectMapper mapper;

	@Autowired
	private WSCalculationUtil wSCalculationUtil;

	@Autowired
	private CalculatorUtil calculatorUtil;

	@Autowired
	private DemandService demandService;

	public List<BillGeneration> getBillingEstimation(BillGenerationRequest billGenerationRequest) {
		List<BillGeneration> billList = new ArrayList<BillGeneration>();
		BillGeneration bill = billingRepository
				.getBillingEstimation(billGenerationRequest.getBillGeneration().getConsumerCode());
		if (bill == null) {
			return billList;
		}
		bill.setConsumerCode(bill.getDivSdiv() + bill.getConsumerCode());
		Map<String, Object> masterMap = masterDataService.loadMasterData(billGenerationRequest.getRequestInfo(),
				billGenerationRequest.getBillGeneration().getTenantId());

		String paymentMode = billGenerationRequest.getBillGeneration().getPaymentMode();
		SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy");
		SimpleDateFormat dateFormatter1 = new SimpleDateFormat("yyyy-MM-dd");
		Date todayDate = null;
		Date dueDateCheque = null;
		Date dueDateCash = null;
		try {
			todayDate = dateFormatter.parse(dateFormatter.format(new Date()));

			dueDateCheque = dateFormatter1.parse(bill.getDueDateCheque());
			dueDateCash = dateFormatter1.parse(bill.getDueDateCash());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (paymentMode.equalsIgnoreCase(WSCalculationConstant.payment_cheque)) {
			if (todayDate.compareTo(dueDateCheque) > 0) {

				enrichWaterCalculation(billGenerationRequest, bill, masterMap, true);

			} else {
				enrichWaterCalculation(billGenerationRequest, bill, masterMap, false);

			}
		} else {
			if (todayDate.compareTo(dueDateCash) > 0) {

				enrichWaterCalculation(billGenerationRequest, bill, masterMap, true);

			} else {
				enrichWaterCalculation(billGenerationRequest, bill, masterMap, false);
			}
		}
		if (billGenerationRequest.getBillGeneration().isGenerateDemand()) {
			List<Calculation> calculations = new ArrayList<Calculation>();
			bill.getCalculation().setTenantId(billGenerationRequest.getBillGeneration().getTenantId());
			calculations.add(bill.getCalculation());

			demandService.generateDemand(billGenerationRequest.getRequestInfo(), calculations, masterMap, true);

		}
		billList.add(bill);

		return billList;
	}

	private void enrichWaterCalculation(BillGenerationRequest billGenerationRequest, BillGeneration bill,
			Map<String, Object> masterMap, boolean isPenalty) {

		WaterConnection connection = calculatorUtil.getWaterConnection(billGenerationRequest.getRequestInfo(),
				bill.getConsumerCode(), billGenerationRequest.getBillGeneration().getTenantId());

		if (connection == null) {
			throw new CustomException("CONNECTION_NOT_FOUND", "water connection not found for consumer id ");
		} else {

			List<TaxHeadEstimate> estimates = new ArrayList<>();

			estimates.add(TaxHeadEstimate.builder().taxHeadCode(WSCalculationConstant.WS_CHARGE)
					.estimateAmount(new BigDecimal(bill.getNetAmount())).build());

			if (isPenalty) {
				estimates.add(TaxHeadEstimate.builder().taxHeadCode(WSCalculationConstant.WS_TIME_PENALTY)
						.estimateAmount(new BigDecimal(bill.getSurcharge())).build());
			}
			Map<String, List> estimatesAndBillingSlabs = new HashMap<>();
			estimatesAndBillingSlabs.put("estimates", estimates);
			Calculation calculation = getCalculation(estimatesAndBillingSlabs, masterMap, bill, connection);
			CalculationCriteria criteria = CalculationCriteria.builder().waterConnection(connection)
					.from(bill.getFromDate()).to(bill.getToDate()).build();
			ArrayList<?> billingFrequencyMap = (ArrayList<?>) masterMap
					.get(WSCalculationConstant.Billing_Period_Master);
			masterDataService.enrichBillingPeriod(criteria, billingFrequencyMap, masterMap);
			// enrichBillingPeriod(bill, masterMap,billGenerationRequest.getRequestInfo());
			bill.setCalculation(calculation);

		}

	}

	public Map<String, Object> enrichBillingPeriod(BillGeneration billGeneration, Map<String, Object> masterMap,
			RequestInfo requestInfo) {

		Map<String, Object> billingPeriod = new HashMap<>();
		List<Map<String, Object>> taxPeriods = (List<Map<String, Object>>) masterMap
				.get(WSCalculationConstant.TAXPERIOD_MASTER_KEY);
		JsonNode node = mapper.convertValue(taxPeriods.get(0), JsonNode.class);
		billingPeriod.put(WSCalculationConstant.STARTING_DATE_APPLICABLES, node.get("fromDate"));
		billingPeriod.put(WSCalculationConstant.ENDING_DATE_APPLICABLES,
				System.currentTimeMillis() + WSCalculationConstant.APPLICATION_FEE_DEMAND_END_DATE);
		billingPeriod.put(WSCalculationConstant.Demand_Expiry_Date_String,
				WSCalculationConstant.APPLICATION_FEE_DEMAND_EXP_DATE);

		masterMap.put(WSCalculationConstant.BILLING_PERIOD, billingPeriod);
		return masterMap;
	}

	@SuppressWarnings("unchecked")
	private Calculation getCalculation(Map<String, List> estimatesAndBillingSlabs, Map<String, Object> masterMap,
			BillGeneration billGeneration, WaterConnection connection) {
		List<TaxHeadEstimate> estimates = estimatesAndBillingSlabs.get("estimates");
		Map<String, Category> taxHeadCategoryMap = new HashMap<String, Category>();
		for (TaxHeadMaster master : (List<TaxHeadMaster>) masterMap
				.get(WSCalculationConstant.TAXHEADMASTER_MASTER_KEY)) {
			if (null != master.getCategory()) {
				taxHeadCategoryMap.put(master.getCode(), master.getCategory());
			} else {
				log.info("Category is null in TaxHeadMaster for code {}", master.getCategory());
			}
		}

		BigDecimal taxAmt = BigDecimal.ZERO;
		BigDecimal waterCharge = BigDecimal.ZERO;
		BigDecimal penalty = BigDecimal.ZERO;
		BigDecimal exemption = BigDecimal.ZERO;
		BigDecimal rebate = BigDecimal.ZERO;
		BigDecimal fee = BigDecimal.ZERO;

		for (TaxHeadEstimate estimate : estimates) {

			Category category = taxHeadCategoryMap.get(estimate.getTaxHeadCode());
			estimate.setCategory(category);

			switch (category) {

			case CHARGES:
				waterCharge = waterCharge.add(estimate.getEstimateAmount());
				break;

			case PENALTY:
				penalty = penalty.add(estimate.getEstimateAmount());
				break;

			case REBATE:
				rebate = rebate.add(estimate.getEstimateAmount());
				break;

			case EXEMPTION:
				exemption = exemption.add(estimate.getEstimateAmount());
				break;
			case FEE:
				fee = fee.add(estimate.getEstimateAmount());
				break;
			default:
				taxAmt = taxAmt.add(estimate.getEstimateAmount());
				break;
			}
		}

		BigDecimal totalAmount = taxAmt.add(penalty).add(rebate).add(exemption).add(waterCharge).add(fee);

		Calculation cal = Calculation.builder().totalAmount(totalAmount).taxAmount(taxAmt).penalty(penalty)
				.exemption(exemption).charge(waterCharge).fee(fee).rebate(rebate).tenantId(billGeneration.getTenantId())
				.taxHeadEstimates(estimates).connectionNo(billGeneration.getBillGenerationId())
				.waterConnection(connection).build();

		return cal;
	}
}
