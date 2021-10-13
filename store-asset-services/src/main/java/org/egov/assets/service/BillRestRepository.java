package org.egov.assets.service;

import org.egov.assets.model.BillRegister;
import org.egov.assets.model.BillRegisterRequest;
import org.egov.assets.model.BillRegisterResponse;
import org.egov.common.contract.request.RequestInfo;
import org.egov.tracer.model.CustomException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class BillRestRepository {

    private RestTemplate restTemplate;

    private String url;


    public BillRestRepository(RestTemplate restTemplate,
                              @Value("${egov.bill.host}") String billHost,
                              @Value("${egov.bill.create.url}") String billUrl) {
        this.restTemplate = restTemplate;
        this.url = billHost + billUrl;
    }

    public BillRegisterResponse createBillRegister(List<BillRegister> billRegisters) {
        
        BillRegisterRequest billRegisterRequest = BillRegisterRequest.builder()
                .requestInfo(new RequestInfo())
                .billRegisters(billRegisters)
                .build();
        BillRegisterResponse billRegisterResponse = restTemplate.postForObject(url, billRegisterRequest, BillRegisterResponse.class);

        if (billRegisterResponse.getBillRegisters().size() > 0) {
            return billRegisterResponse;
        } else {
            throw new CustomException("Bill Register", "Bill Register not created");
        }
    }
}

