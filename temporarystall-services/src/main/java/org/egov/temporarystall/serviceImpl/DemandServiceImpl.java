package org.egov.temporarystall.serviceImpl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.egov.common.contract.request.RequestInfo;
import org.egov.temporarystall.common.CommonConstants;
import org.egov.temporarystall.config.StallConfiguration;
import org.egov.temporarystall.model.StallRequest;
import org.egov.temporarystall.model.demand.Demand;
import org.egov.temporarystall.model.demand.Demand.StatusEnum;
import org.egov.temporarystall.model.demand.DemandDetail;
import org.egov.temporarystall.model.demand.TaxHeadEstimate;
import org.egov.temporarystall.repository.DemandRepository;
import org.egov.temporarystall.service.BookingsCalculatorService;
import org.egov.temporarystall.service.DemandService;
import org.egov.temporarystall.service.MDMSService;
import org.egov.tracer.model.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;


import com.fasterxml.jackson.databind.ObjectMapper;

// TODO: Auto-generated Javadoc
/**
 * The Class DemandServiceImpl.
 */
@Service
public class DemandServiceImpl implements DemandService {

	/** The demand repository. */
	@Autowired
	DemandRepository demandRepository;

	/** The config. */
	@Autowired
	private StallConfiguration config;

	

	/** The bookings calculator service. */
	@Autowired
	BookingsCalculatorService bookingsCalculatorService;

	

	/** The mapper. */
	@Autowired
	private ObjectMapper mapper;

	/** The bookings calculator. */
	@Autowired
	BookingsCalculatorService bookingsCalculator;

	@Autowired
	MDMSService mdmsService;
	
	
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.egov.bookings.service.DemandService#createDemand(org.egov.bookings.web.
	 * models.BookingsRequest)
	 */
	@Override
	public void createDemand(StallRequest stallRequest) {

		List<Demand> demands = new ArrayList<>();
		
		demands = getDemandsForBwt(stallRequest);

		

		 demandRepository.saveDemand(stallRequest.getRequestInfo(), demands);

	}
	
	
	/**
	 * Creates the and get calculation and demand for bwt.
	 *
	 * @param bookingsRequest the bookings request
	 * @return the list
	 */
	public List<Demand> getDemandsForBwt(StallRequest bookingsRequest) {

		List<Demand> demands = new LinkedList<>();
		List<DemandDetail> demandDetails = new ArrayList<>();
		try {
			String tenantId = bookingsRequest.getStallApplicationRequest().getTenantId();

			String taxHeadCode = CommonConstants.STALL_TAX_HEAD_CODE;
			
			//demandDetails.
			//demandDetails.add(DemandDetail.builder().totalAmount(bookingsRequest.getStallApplicationRequest().getTotalamount()));

			/*String taxHeadCode2 = CommonConstants.BWT_TAXHEAD_CODE_2;
			
			  List<TaxHeadEstimate> taxHeadEstimate1 =
			  bookingsCalculator.getTaxHeadEstimate(bookingsRequest, taxHeadCode1,
			  taxHeadCode2);
			 

			
			  taxHeadEstimate1.forEach(taxHeadEstimate -> {
			  demandDetails.add(DemandDetail.builder().feesperday(taxHeadEstimate.
			  getEstimateAmount())
			  .taxHeadMasterCode(taxHeadEstimate.getTaxHeadCode()).collectionAmount(
			  BigDecimal.ZERO) .tenantId(tenantId).build()); });*/
			  
			  
			  demandDetails.add(DemandDetail.builder().taxAmount(bookingsRequest.getStallApplicationRequest().getTotalamount())
			  .taxHeadMasterCode(taxHeadCode).collectionAmount(0) 
			  .tenantId(tenantId).demandId(bookingsRequest.getStallApplicationRequest().getApplicationId())
			  .auditDetails(bookingsRequest.getAuditDetails()).id(UUID.randomUUID().toString()).build());
			  
			
			 
			 

/*			Long taxPeriodFrom = 1554057000000L;
			Long taxPeriodTo = 1869676199000L;
*/			
			 //Object mdmsData = mdmsService.mDMSCall(bookingsRequest.getRequestInfo(), tenantId);
			 
			 //Object mdmsData = mdmsService.mDMSCall(bookingsRequest.getRequestInfo(), bookingsRequest.getStallApplicationRequest().getTenantId());

            Long taxPeriodFrom = System.currentTimeMillis();
            Long taxPeriodTo = System.currentTimeMillis();

           // Map<String, Long> taxPeriods = mdmsService.getTaxPeriods(bookingsRequest.getRequestInfo(), bookingsRequest.getStallApplicationRequest(), mdmsData);
           // taxPeriodFrom = taxPeriods.get(CommonConstants.MDMS_STARTDATE);
            //taxPeriodTo = taxPeriods.get(CommonConstants.MDMS_ENDDATE);
            
			List<String> combinedBillingSlabs = new LinkedList<>();

			Demand singleDemand = Demand.builder().status(StatusEnum.ACTIVE)
					.consumerCode(bookingsRequest.getStallApplicationRequest().getApplicationId())
					.demandDetails(demandDetails).payer(bookingsRequest.getRequestInfo().getUserInfo())
					.minimumAmountPayable(config.getMinimumPayableAmount())
					.tenantId(tenantId).taxPeriodFrom(taxPeriodFrom)
					.taxPeriodTo(taxPeriodTo).consumerType("bookings")
					.businessService("TEMPORARY_STALL_CHARGES_BOOKING")
					.additionalDetails(Collections.singletonMap("calculationDes1cription", combinedBillingSlabs))
					.build();

			demands.add(singleDemand);
		} catch (Exception e) {
			throw new CustomException("DEMAND_ERROR", e.getLocalizedMessage());
		}
		return demands;

	}
	

	
	}

		
	
	
	
	


	
	
	

	
	


