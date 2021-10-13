package org.egov.ps.service.calculation;

import java.util.Collections;
import java.util.List;

import org.egov.common.contract.request.RequestInfo;
import org.egov.ps.config.Configuration;
import org.egov.ps.model.BillResponseV2;
import org.egov.ps.model.BillV2;
import org.egov.ps.model.CollectionPaymentRequest;
import org.egov.ps.model.CollectionPaymentResponse;
import org.egov.ps.model.calculation.Demand;
import org.egov.ps.model.calculation.DemandRequest;
import org.egov.ps.model.calculation.DemandResponse;
import org.egov.ps.repository.ServiceRequestRepository;
import org.egov.tracer.model.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.databind.ObjectMapper;

@Repository
public class DemandRepository {

	@Autowired
	private ServiceRequestRepository serviceRequestRepository;

	@Autowired
	private Configuration config;

	@Autowired
	private ObjectMapper mapper;

	/**
	 * Creates demand
	 * 
	 * @param requestInfo The RequestInfo of the calculation Request
	 * @param demands     The demands to be created
	 * @return The list of demand created
	 */
	public List<Demand> saveDemand(RequestInfo requestInfo, List<Demand> demands) {
		StringBuilder url = new StringBuilder(config.getBillingHost());
		url.append(config.getDemandCreateEndpoint());
		DemandRequest request = new DemandRequest(requestInfo, demands);
		Object result = serviceRequestRepository.fetchResult(url, request);
		try {
			DemandResponse response = mapper.convertValue(result, DemandResponse.class);
			return response.getDemands();
		} catch (IllegalArgumentException e) {
			throw new CustomException("PARSING ERROR", "Failed to parse response of create demand");
		}
	}

	/**
	 * Updates the demand
	 * 
	 * @param requestInfo The RequestInfo of the calculation Request
	 * @param demands     The demands to be updated
	 * @return The list of demand updated
	 */
	public List<Demand> updateDemand(RequestInfo requestInfo, List<Demand> demands) {
		StringBuilder url = new StringBuilder(config.getBillingHost());
		url.append(config.getDemandUpdateEndpoint());
		DemandRequest request = new DemandRequest(requestInfo, demands);
		Object result = serviceRequestRepository.fetchResult(url, request);
		DemandResponse response = null;
		try {
			response = mapper.convertValue(result, DemandResponse.class);
		} catch (IllegalArgumentException e) {
			throw new CustomException("PARSING ERROR", "Failed to parse response of update demand");
		}
		return response.getDemands();

	}
	
	public List<BillV2> fetchBill(RequestInfo requestInfo, String tenantId, String consumerCode,
			String businessService) {
		StringBuilder url = new StringBuilder(config.getBillingHost());
		String uri = config.getBillGenerateEndpoint().replace("$tenantId", tenantId)
				.replace("$consumerCode", consumerCode).replace("$businessService", businessService);
		url.append(uri);
		Object result = serviceRequestRepository.fetchResult(url, Collections.singletonMap("requestInfo", requestInfo));
		BillResponseV2 response = null;
		try {
			response = mapper.convertValue(result, BillResponseV2.class);
		} catch (IllegalArgumentException e) {
			throw new CustomException("PARSING ERROR", "Failed to parse response of update demand");
		}
		return response.getBill();
	}

	public Object savePayment(CollectionPaymentRequest paymentRequest) {
		StringBuilder url = new StringBuilder(config.getCollectionPaymentHost());
		url.append(config.getCollectionPaymentEndPoint());
		Object result = serviceRequestRepository.fetchResult(url, paymentRequest);
		try {
			CollectionPaymentResponse response = mapper.convertValue(result, CollectionPaymentResponse.class);
			return response.getPayments();
		} catch (IllegalArgumentException e) {
			throw new CustomException("PARSING ERROR", "Failed to parse response of update demand");
		}
	}

}
