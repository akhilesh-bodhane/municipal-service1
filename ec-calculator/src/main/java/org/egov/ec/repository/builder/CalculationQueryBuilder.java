package org.egov.ec.repository.builder;

import org.springframework.stereotype.Component;

@Component
public class CalculationQueryBuilder {

	public static final String GET_CHALLAN_FINE = "select head_amount from egec_challan_master challan, egec_challan_detail detail where challan.challan_uuid=detail.challan_uuid and challan.challan_id=? and budget_head='FINE_AMOUNT'";
	public static final String GET_CHALLAN_PENALTY = "select head_amount from egec_challan_master challan, egec_challan_detail detail where challan.challan_uuid=detail.challan_uuid and challan.challan_id=? and budget_head='PENALTY_AMOUNT'";
	
}
