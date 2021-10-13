package org.egov.assets.service;

import org.egov.assets.common.DomainService;
import org.egov.assets.common.Pagination;
import org.egov.assets.model.MaterialReceiptAddInfoSearch;
import org.egov.assets.model.MaterialReceiptDetailAddnlinfo;
import org.egov.assets.repository.MaterialReceiptDetailAddInfoJdbcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MaterialReceiptDetailAddInfoService extends DomainService {

    @Autowired
    private MaterialReceiptDetailAddInfoJdbcRepository receiptDetailAddInfoJdbcRepository;

    public Pagination<MaterialReceiptDetailAddnlinfo> search(MaterialReceiptAddInfoSearch receiptAddInfoSearch) {
        return receiptDetailAddInfoJdbcRepository.search(receiptAddInfoSearch);
    }
}
