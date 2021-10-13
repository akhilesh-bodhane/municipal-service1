package org.egov.assets.repository;

import java.util.List;

import org.egov.assets.common.Pagination;
import org.egov.assets.model.PriceList;
import org.egov.assets.model.PriceListRequest;
import org.egov.assets.model.PriceListSearchRequest;
import org.egov.tracer.kafka.LogAwareKafkaTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class PriceListRepository {

    private LogAwareKafkaTemplate<String, Object> logAwareKafkaTemplate;

    private String priceListSaveTopicName;

    private String priceListUpdateTopicName;

    private PriceListJdbcRepository priceListJdbcRepository;

    @Autowired
    public PriceListRepository(LogAwareKafkaTemplate logAwareKafkaTemplate,
                              @Value("${inv.pricelists.save.topic}") String priceListSaveTopicName,
                              @Value("${inv.pricelists.update.topic}") String priceListsUpdateTopicName,
                              PriceListJdbcRepository priceListJdbcRepository) {
        this.logAwareKafkaTemplate = logAwareKafkaTemplate;
        this.priceListSaveTopicName = priceListSaveTopicName;
        this.priceListUpdateTopicName = priceListsUpdateTopicName;
        this.priceListJdbcRepository = priceListJdbcRepository;
    }

    public void save(PriceListRequest priceListRequest) {

        logAwareKafkaTemplate.send(priceListSaveTopicName, priceListRequest);

    }

    public void update(PriceListRequest priceListRequest) {

        logAwareKafkaTemplate.send(priceListUpdateTopicName, priceListRequest);

    }

    public Pagination<PriceList> search(PriceListSearchRequest priceListSearchRequest) {
        return priceListJdbcRepository.search(priceListSearchRequest);
    }
    
    public List<PriceList> searchPriceList(PriceListSearchRequest priceListSearchRequest) {
        return priceListJdbcRepository.searchPriceList(priceListSearchRequest);
    }


}
