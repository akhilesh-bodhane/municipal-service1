package org.egov.temporarystall.serviceImpl;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.egov.common.contract.request.RequestInfo;
import org.egov.mdms.model.MdmsCriteriaReq;
import org.egov.mdms.model.MdmsResponse;
import org.egov.temporarystall.model.StallRequest;
import org.egov.temporarystall.model.demand.TaxHeadEstimate;
import org.egov.temporarystall.model.demand.TaxHeadMasterFields;
import org.egov.temporarystall.service.BookingsCalculatorService;
import org.egov.temporarystall.service.MDMSService;
import org.egov.tracer.model.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import com.fasterxml.jackson.databind.ObjectMapper;

import net.minidev.json.JSONArray;

// TODO: Auto-generated Javadoc
/**
 * The Class BookingsCalculatorServiceImpl.
 */
@Service
@Transactional
public class BookingsCalculatorServiceImpl implements BookingsCalculatorService {

	@Autowired
	private MDMSService mdmsService;

	/** The bookings calculator service. */
	@Autowired
	private BookingsCalculatorService bookingsCalculatorService;

	/** The mapper. */
	@Autowired
	private ObjectMapper mapper;

	/**
	 * Gets the tax head estimate.
	 *
	 * @param bookingsRequest the bookings request
	 * @param taxHeadCode1    the tax head code 1
	 * @param taxHeadCode2    the tax head code 2
	 * @return the tax head estimate
	 */
	/*
	 * public List<TaxHeadEstimate> getTaxHeadEstimate(StallRequest bookingsRequest,
	 * String taxHeadCode1, String taxHeadCode2) { List<TaxHeadEstimate>
	 * taxHeadEstimate1 = new ArrayList<>(); String bussinessService =
	 * bookingsRequest.getStallApplicationRequest().getBusinessservice();
	 * List<TaxHeadMasterFields> taxHeadMasterFieldList =
	 * getTaxHeadMasterData(bookingsRequest, bussinessService);
	 * 
	 * switch (bussinessService) {
	 * 
	 * 
	 * //case BookingsConstants.BUSINESS_SERVICE_BWT: //int bwtAmount = 1000;
	 * //bookingsRequest.getStallApplicationRequest().getNoofdays() * for
	 * (TaxHeadMasterFields taxHeadEstimate : taxHeadMasterFieldList) { if (true) {
	 * taxHeadEstimate1.add( new
	 * TaxHeadEstimate(bookingsRequest.getStallApplicationRequest().getFestival(),
	 * bwtAmount, taxHeadEstimate.getCategory())); } if
	 * (taxHeadEstimate.getCode().equals(taxHeadCode2)) { taxHeadEstimate1.add(new
	 * TaxHeadEstimate(taxHeadEstimate.getCode(),
	 * bwtAmount.multiply((taxHeadEstimate.getTaxAmount().divide(new
	 * BigDecimal(100)))), taxHeadEstimate.getCategory())); }
	 * 
	 * } } return taxHeadEstimate1; }
	 */

	/**
	 * Gets the tax head master data.
	 *
	 * @param bookingsRequest  the bookings request
	 * @param bussinessService the bussiness service
	 * @return the tax head master data
	 */
	public List<TaxHeadMasterFields> getTaxHeadMasterData(StallRequest bookingsRequest, String bussinessService) {

		List<TaxHeadMasterFields> taxHeadMasterFieldList = new ArrayList<>();
		JSONArray mdmsArrayList = null;
		try {
			// Object mdmsData = mdmsService.mDMSCall(stallrequest.getRequestInfo(),
			// stallapplication.getTenantId());
			// Object mdmsData =
			// bookingsUtils.prepareMdMsRequestForTaxHeadMaster(bookingsRequest);
			Object mdmsData = mdmsService.mDMSCall(bookingsRequest.getRequestInfo(),
					bookingsRequest.getStallApplicationRequest().getTenantId());
			String jsonString = mapper.writeValueAsString(mdmsData);
			MdmsResponse mdmsResponse = mapper.readValue(jsonString, MdmsResponse.class);
			Map<String, Map<String, JSONArray>> mdmsResMap = mdmsResponse.getMdmsRes();
			Map<String, JSONArray> mdmsRes = mdmsResMap.get("Temporary-Stall");
			mdmsArrayList = mdmsRes.get("Festival");
			for (int i = 0; i < mdmsArrayList.size(); i++) {
				jsonString = mapper.writeValueAsString(mdmsArrayList.get(i));
				TaxHeadMasterFields taxHeadFields = mapper.readValue(jsonString, TaxHeadMasterFields.class);
				taxHeadMasterFieldList.add(taxHeadFields);
				/*
				 * if (taxHeadFields.getService().equals(bookingsRequest.getBookingsModel().
				 * getFinanceBusinessService())) { taxHeadMasterFieldList.add(taxHeadFields); }
				 */
			}
			System.out.println("**********************");
		} catch (Exception e) {
			throw new CustomException("MDMS_MASTER_ERROR", "Error while fetching mdms TaxHeadMaster data");
		}
		return taxHeadMasterFieldList;
	}

	@Override
	public List<TaxHeadEstimate> getTaxHeadEstimate(StallRequest bookingsRequest, String taxHeadCode1,
			String taxHeadCode2) {
		// TODO Auto-generated method stub
		return null;
	}

}
