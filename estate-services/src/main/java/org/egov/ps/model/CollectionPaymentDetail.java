package org.egov.ps.model;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.egov.ps.web.contracts.AuditDetails;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
public class CollectionPaymentDetail {

    @Size(max = 64)
    @JsonProperty("id")
    private String id;

    @Size(max = 64)
    @JsonProperty("tenantId")
    private String tenantId;

    @NotNull
    @JsonProperty("totalDue")
    private BigDecimal totalDue;

    @NotNull
    @JsonProperty("totalAmountPaid")
    private BigDecimal totalAmountPaid;

    @Size(max = 64)
    @JsonProperty("manualReceiptNumber")
    private String manualReceiptNumber;

    @JsonProperty("manualReceiptDate")
    private Long manualReceiptDate;

    @Size(max = 64)
    @JsonProperty("receiptNumber")
    private String receiptNumber;

    @JsonProperty("receiptDate")
    private Long receiptDate;

    @JsonProperty("receiptType")
    private String receiptType;

    @NotNull
    @Size(max = 64)
    @JsonProperty("businessService")
    private String businessService;

    @NotNull
    @Size(max = 64)
    @JsonProperty("billId")
    private String billId;

    @JsonProperty("bill")
    private BillV2 bill;

    @JsonProperty("additionalDetails")
    private JsonNode additionalDetails;

    @JsonProperty("auditDetails")
    private AuditDetails auditDetails;

}
