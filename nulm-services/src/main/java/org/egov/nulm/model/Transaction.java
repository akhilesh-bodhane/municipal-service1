package org.egov.nulm.model;

import java.math.BigDecimal;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.json.simple.JSONArray;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Transaction {

	private String uuid;
	
	@JsonProperty("transactionType")
	private String transactionType;
	
	@JsonProperty("amount")
	private String amount;

	@JsonProperty("modeOfPayment")
	private String modeOfPayment;
	
	@JsonProperty("paymentDetails")
	private String paymentDetails;
	
	@JsonProperty("donationReceivedFrom")
	private String donationReceivedFrom;
	
	@JsonProperty("donorDetails")
	private String donorDetails;
	
	@JsonProperty("expenditureType")
	private String expenditureType ;
	
	@JsonProperty("expenditureDetails")
	private String expenditureDetails ;
	
	
	@JsonProperty("emailId")
	private String emailId ;
	
	@JsonProperty("comments")
	private String comments ;

	@JsonProperty("isActive")
	private Boolean isActive;


	@JsonProperty("supportingDocument")
	private List<SupportingDocument> supportingDocument;
	
	@JsonProperty("tenantId")
	private String tenantId ;
	
	@JsonProperty("auditDetails")
	private AuditDetails auditDetails;

	@JsonProperty("remark")
	private String remark;

	@JsonProperty("fromDate")
	private String fromDate;

	@JsonProperty("toDate")
	private String toDate;
}
