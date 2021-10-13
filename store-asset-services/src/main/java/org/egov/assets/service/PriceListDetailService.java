package org.egov.assets.service;

import java.util.Collections;

import org.egov.assets.common.DomainService;
import org.egov.assets.common.Pagination;
import org.egov.assets.model.PriceListDetails;
import org.egov.assets.model.PriceListDetailsResponse;
import org.egov.assets.model.PriceListDetailsSearchRequest;
import org.egov.assets.repository.PriceListDetailJdbcRepository;
import org.egov.assets.repository.PriceListRepository;
import org.egov.common.contract.request.RequestInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


@Service
public class PriceListDetailService extends DomainService {


    public static final String UPDATE = "UPDATE";
    public static final String CREATE = "CREATE";
    
    @Value("${inv.pricelists.save.topic}")
    private String saveTopic;

    @Value("${inv.pricelists.save.key}")
    private String saveKey;

    @Value("${inv.pricelists.update.topic}")
    private String updateTopic;

    @Value("${inv.pricelists.update.key}")
    private String updateKey;
    
    @Autowired
    private PriceListRepository priceListRepository;

    @Autowired
    private PriceListDetailJdbcRepository priceListDetailJdbcRepository;
    
    public static final String SEQ_PRICELIST = "seq_priceList";
    public static final String SEQ_PRICELISTDETAILS = "seq_pricelistdetails";
    
	public PriceListDetailsResponse search(
			PriceListDetailsSearchRequest priceListDetailSearchRequest, RequestInfo requestInfo) {

		Pagination<PriceListDetails> searchPriceListDetails = priceListDetailJdbcRepository.search(priceListDetailSearchRequest);
		
        PriceListDetailsResponse response = new PriceListDetailsResponse();
        response.setPriceListDetails(searchPriceListDetails.getPagedData().size() > 0 ? searchPriceListDetails.getPagedData() : Collections.emptyList());
		return response;
	}

}
