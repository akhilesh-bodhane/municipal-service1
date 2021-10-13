package org.egov.integration.model;

import java.math.BigDecimal;
import java.util.List;

import org.egov.integration.model.Payment.PaymentBuilder;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Builder
public class ReportModel {

	private String applicationType;
	private String  applicantSubmissionDate;
	private JsonNode  applicantId;
	private String  serviceName;
	private JsonNode  applicantSector;
	private String  applicantGender;
	private String  applicantAge;
	private String  departmentId;
	private String  departmentName;
	private String  applicationStatus;
	private String  createdBy;
	private String  applicantDOB;
	private String  applicantName;
	
}
