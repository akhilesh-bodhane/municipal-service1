package org.egov.temporarystall.repository;

import java.util.List;
import org.egov.common.contract.request.RequestInfo;
import org.egov.temporarystall.config.StallConfiguration;
import org.egov.temporarystall.model.demand.Demand;
import org.egov.temporarystall.model.demand.DemandRequest;
import org.egov.temporarystall.model.demand.DemandResponse;
import org.egov.tracer.model.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

// TODO: Auto-generated Javadoc
/**
 * The Class DemandRepository.
 */
@Repository
public class DemandRepository {

	
	/** The config. */
	@Autowired
	private StallConfiguration config;
	
	/** The service request repository. */
	@Autowired
	ServiceRequestRepository serviceRequestRepository;
	
	 /** The mapper. */
 	@Autowired
	    private ObjectMapper mapper;
	
	/**
	 * Save demand.
	 *
	 * @param requestInfo the request info
	 * @param demands the demands
	 * @return the list
	 */
	public List<Demand> saveDemand(RequestInfo requestInfo, List<Demand> demands) {
		StringBuilder url = new StringBuilder(config.getBillingHost());
        url.append(config.getDemandCreateEndpoint());
        DemandRequest request = new DemandRequest(requestInfo,demands);
        Object result = serviceRequestRepository.fetchResult(url,request);
        DemandResponse response = null;
        try{
            response = mapper.convertValue(result,DemandResponse.class);
        }
        catch(IllegalArgumentException e){
            throw new CustomException("PARSING ERROR","Failed to parse response of create demand");
        }
        return response.getDemands();
	}
	


}
