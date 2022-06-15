package org.egov.temporarystall.service;

import org.egov.temporarystall.model.StallRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// TODO: Auto-generated Javadoc
/**
 * The Class EnrichmentService.
 */
@Service
public class EnrichmentService {

	/** The bookings calculator service. */
	@Autowired
	BookingsCalculatorService bookingsCalculatorService;

	/** The bookings service. *//*
								 * @Autowired BookingsService bookingsService;
								 */

	/** The demand service. */
	@Autowired
	DemandService demandService;

	/**
	 * Generate demand.
	 *
	 * @param bookingsRequest the bookings request
	 */
	public void generateDemand(StallRequest stallrequest) {

		demandService.createDemand(stallrequest);

		/*
		 * if
		 * (!BookingsConstants.BUSINESS_SERVICE_BWT.equals(stallrequest.getBookingsModel
		 * ().getBusinessService())) { if
		 * (!bookingsService.isBookingExists(bookingsRequest.getBookingsModel().
		 * getBkApplicationNumber())) { demandService.createDemand(bookingsRequest); }
		 * else demandService.updateDemand(bookingsRequest); } else { if
		 * (!bookingsService.isBookingExists(bookingsRequest.getBookingsModel().
		 * getBkApplicationNumber())) { demandService.createDemand(bookingsRequest); } }
		 */

	}
	
	
	

}
