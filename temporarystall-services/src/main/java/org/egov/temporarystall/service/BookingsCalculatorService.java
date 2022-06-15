package org.egov.temporarystall.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;


import org.egov.common.contract.request.RequestInfo;
import org.egov.temporarystall.model.StallRequest;
import org.egov.temporarystall.model.demand.Demand;
import org.egov.temporarystall.model.demand.TaxHeadEstimate;
import org.egov.temporarystall.model.demand.TaxHeadMasterFields;


// TODO: Auto-generated Javadoc
/**
 * The Interface BookingsCalculatorService.
 */
public interface BookingsCalculatorService {

	
	
	/**
	 * Gets the tax head estimate.
	 *
	 * @param bookingsRequest the bookings request
	 * @param taxHeadCode1 the tax head code 1
	 * @param taxHeadCode2 the tax head code 2
	 * @return the tax head estimate
	 */
	public List<TaxHeadEstimate> getTaxHeadEstimate(StallRequest bookingsRequest, String taxHeadCode1,
			String taxHeadCode2);

	
	
	/**
	 * Gets the tax head master data.
	 *
	 * @param bookingsRequest the bookings request
	 * @param bussinessService the bussiness service
	 * @return the tax head master data
	 */
	public List<TaxHeadMasterFields> getTaxHeadMasterData(StallRequest bookingsRequest, String bussinessService);
	

}
