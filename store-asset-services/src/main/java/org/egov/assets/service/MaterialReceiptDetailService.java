package org.egov.assets.service;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.egov.assets.common.DomainService;
import org.egov.assets.common.Pagination;
import org.egov.assets.model.MaterialReceiptAddInfoSearch;
import org.egov.assets.model.MaterialReceiptDetail;
import org.egov.assets.model.MaterialReceiptDetailAddnlinfo;
import org.egov.assets.model.MaterialReceiptDetailSearch;
import org.egov.assets.model.Uom;
import org.egov.assets.repository.MaterialReceiptDetailJdbcRepository;
import org.egov.common.contract.request.RequestInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MaterialReceiptDetailService extends DomainService {

    @Autowired
    private MaterialReceiptDetailJdbcRepository materialReceiptDetailJdbcRepository;

    @Autowired
    private MaterialReceiptDetailAddInfoService materialReceiptDetailAddInfoService;

    public Pagination<MaterialReceiptDetail> search(MaterialReceiptDetailSearch materialReceiptDetailSearch) {
        Pagination<MaterialReceiptDetail> materialReceiptDetailPagination = materialReceiptDetailJdbcRepository.search(materialReceiptDetailSearch);

        List<MaterialReceiptDetail> receiptDetails = materialReceiptDetailPagination.getPagedData();

        if (receiptDetails.size() > 0) {
            for (MaterialReceiptDetail materialReceiptDetail : receiptDetails) {
                Uom uom = getUom(materialReceiptDetail.getTenantId(), materialReceiptDetail.getUom().getCode(), new RequestInfo());

                if (null != materialReceiptDetail.getReceivedQty() && null != uom.getConversionFactor()) {
                	BigDecimal receivedQuantity = getSearchConvertedQuantity(materialReceiptDetail.getReceivedQty(), uom.getConversionFactor());
                    materialReceiptDetail.setReceivedQty(receivedQuantity);
                }

                if (null != materialReceiptDetail.getAcceptedQty() && null != uom.getConversionFactor()) {
                	BigDecimal acceptedQuantity = getSearchConvertedQuantity(materialReceiptDetail.getAcceptedQty(), uom.getConversionFactor());
                    materialReceiptDetail.setAcceptedQty(acceptedQuantity);
                }
                if (null != materialReceiptDetail.getUnitRate() && null != uom.getConversionFactor()) {
                	BigDecimal unitRate = getSearchConvertedRate((materialReceiptDetail.getUnitRate()), uom.getConversionFactor());
                    materialReceiptDetail.setUnitRate(unitRate);
                }
                MaterialReceiptAddInfoSearch materialReceiptAddInfoSearch = MaterialReceiptAddInfoSearch.builder()
                        .receiptDetailId(Arrays.asList(materialReceiptDetail.getId()))
                        .tenantId(materialReceiptDetailSearch.getTenantId())
                        .build();
                Pagination<MaterialReceiptDetailAddnlinfo> detailAddnlInfoPagination = materialReceiptDetailAddInfoService.search(materialReceiptAddInfoSearch);
                materialReceiptDetail.setReceiptDetailsAddnInfo(detailAddnlInfoPagination.getPagedData());
            }
        }

        return materialReceiptDetailPagination;
    }
}
