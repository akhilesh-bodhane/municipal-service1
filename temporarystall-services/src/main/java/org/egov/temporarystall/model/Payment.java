package org.egov.temporarystall.model;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.*;


import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
public class Payment {

    @Size(max=64)
    @JsonProperty("id")
    private String id;

    @NotNull
    @Size(max=64)
    @JsonProperty("tenantId")
    private String tenantId;

    @JsonProperty("totalDue")
    private BigDecimal totalDue;

    @NotNull
    @JsonProperty("totalAmountPaid")
    private BigDecimal totalAmountPaid;

    @Size(max=128)
    @JsonProperty("transactionNumber")
    private String transactionNumber;

    @JsonProperty("transactionDate")
    private Long transactionDate;

    

    
    @JsonProperty("instrumentDate")
    private Long instrumentDate;

    @Size(max=128)
    @JsonProperty("instrumentNumber")
    private String instrumentNumber;

    

    @Size(max=64)
    @JsonProperty("ifscCode")
    private String ifscCode;

    @JsonProperty("auditDetails")
    private AuditDetails auditDetails;

    @JsonProperty("additionalDetails")
    private JsonNode additionalDetails;

    

    @Size(max=128)
    @NotNull
    @JsonProperty("paidBy")
    private String paidBy = null;

    @Size(max=64)
    @JsonProperty("mobileNumber")
    private String mobileNumber = null;

    @Size(max=128)
    @JsonProperty("payerName")
    private String payerName = null;

    @Size(max=1024)
    @JsonProperty("payerAddress")
    private String payerAddress = null;

    @Size(max=64)
    @JsonProperty("payerEmail")
    private String payerEmail = null;

    @Size(max=64)
    @JsonProperty("payerId")
    private String payerId = null;

   

    @JsonProperty("fileStoreId")
    private String fileStoreId;


   




}
