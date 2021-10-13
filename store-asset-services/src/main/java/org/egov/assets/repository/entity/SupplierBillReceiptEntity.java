package org.egov.assets.repository.entity;

import org.egov.assets.model.AuditDetails;
import org.egov.assets.model.MaterialReceipt;
import org.egov.assets.model.SupplierBillReceipt;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SupplierBillReceiptEntity {

    private String id;

    private String tenantId;

    private String supplierBill;

    private String materialReceipt;

    private String createdBy;

    private Long createdTime;

    private String lastmodifiedBy;

    private Long lastmodifiedTime;

    public SupplierBillReceipt toDomain() {

        AuditDetails auditDetails = new AuditDetails();
        auditDetails.createdBy(createdBy)
                .createdTime(createdTime)
                .lastModifiedBy(lastmodifiedBy)
                .lastModifiedTime(lastmodifiedTime);

        SupplierBillReceipt supplierBillReceipt = new SupplierBillReceipt();
        return supplierBillReceipt.id(id)
                .tenantId(tenantId)
                .supplierBill(supplierBill)
                .materialReceipt(new MaterialReceipt().id(materialReceipt))
                .auditDetails(auditDetails);
    }
}
