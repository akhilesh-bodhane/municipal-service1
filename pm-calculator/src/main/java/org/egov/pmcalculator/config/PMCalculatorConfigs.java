package org.egov.pmcalculator.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;

@Configuration
@Data
public class PMCalculatorConfigs {

	@Value("${egov.billingservice.host}")
	private String billingHost;

	@Value("${egov.taxhead.search.endpoint}")
	private String taxHeadSearchEndpoint;

	@Value("${egov.taxperiod.search.endpoint}")
	private String taxPeriodSearchEndpoint;

	@Value("${egov.demand.create.endpoint}")
	private String demandCreateEndpoint;

	@Value("${egov.demand.update.endpoint}")
	private String demandUpdateEndpoint;

	@Value("${egov.demand.search.endpoint}")
	private String demandSearchEndpoint;

	@Value("${egov.bill.gen.endpoint}")
	private String billGenerateEndpoint;

	@Value("${egov.demand.minimum.payable.amount}")
	private BigDecimal minimumPayableAmount;

	@Value("${egov.demand.businessservice}")
	private String businessService;

	// TaxHeads
	@Value("${egov.taxhead.baseadvertisementtax}")
	private String baseAdvertisementTaxHead;

	@Value("${egov.taxhead.baseadvertisementfee}")
	private String baseAdvertisementFeeHead;

	@Value("${egov.taxhead.basepettax}")
	private String basePetTaxHead;

	@Value("${egov.taxhead.basepetfee}")
	private String basePetFeeHead;
	
	@Value("${egov.taxhead.basesellmeatfee}")
	private String baseSellMeatFeeHead;
	
	/*@Value("${egov.taxhead.basesellmeattax}")
	private String baseSellMeatTaxHead;*/

	@Value("${egov.taxhead.baseroadcuttax}")
	private String baseRoadCutTaxHead;

	@Value("${egov.taxhead.baseroadcutfee}")
	private String baseRoadCutFeeHead;

	@Value("${egov.taxhead.baseroadcutfeebank}")
	private String baseRoadCutFeeBankHead;

	// MDMS
	@Value("${egov.mdms.host}")
	private String mdmsHost;

	@Value("${egov.mdms.search.endpoint}")
	private String mdmsSearchEndpoint;
}
