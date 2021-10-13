package org.egov.pmrefund.util;

import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import org.egov.common.contract.request.RequestInfo;
import org.egov.pmrefund.config.PMRefundConfiguration;
import org.egov.pmrefund.pg.models.TransactionRequest;
import org.egov.pmrefund.pg.models.TransactionResponse;
import org.egov.tracer.model.CustomException;
import org.egov.tracer.model.ServiceCallException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Repository
public class PaymentUtil {

	private RestTemplate restTemplate;

	private PMRefundConfiguration config;

	@Autowired
	public PaymentUtil(RestTemplate restTemplate, PMRefundConfiguration config) {
		this.restTemplate = restTemplate;
		this.config = config;
	}

	/**
     * Call pg-service
     * @param requestInfo The rquestInfo of the request
     * @param tenantId The tenantiD of the publicrelation
     * @param name Name of the foramt
     * @param format Format of the ids
     * @param count Total Number of idGen ids required
     * @return
     * @throws URISyntaxException 
     */
    public TransactionResponse getId(RequestInfo requestInfo, String consumnerCode) throws URISyntaxException {

		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(config.getPgHost()+ config.getPgPath()).queryParam("consumerCode", consumnerCode);
        TransactionRequest req = TransactionRequest.builder().requestInfo(requestInfo).build();
        TransactionResponse response = null;
        try {
        	System.out.println(requestInfo.getAuthToken());
            response = restTemplate.postForObject( builder.toUriString(), req, TransactionResponse.class);
        } catch (HttpClientErrorException e) {
            throw new ServiceCallException(e.getResponseBodyAsString());
        } catch (Exception e) {
            Map<String, String> map = new HashMap<>();
            map.put(e.getCause().getClass().getName(),e.getMessage());
            throw new CustomException(map);
        }
        return response;
    }
}
