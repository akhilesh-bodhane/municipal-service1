package org.egov.temporarystall.model.demand;

import java.math.BigDecimal;

import org.egov.temporarystall.model.enums.Category;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaxHeadMasterFields {

	
	private Category category;
	
	private String service;
	
	private String name;
	
	private String code;
	
	private boolean isDebit;
	
	private boolean isActualDemand;
	
	private BigDecimal order;
	
	private boolean isRequired;
	
	
	//private BigDecimal taxAmount;
	
	private BigDecimal feesperday;

	
	private BigDecimal facilitationCharge;
	
	
}
