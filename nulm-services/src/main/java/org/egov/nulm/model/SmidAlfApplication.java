package org.egov.nulm.model;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.egov.nulm.model.SepApplication.StatusEnum;
import org.hibernate.validator.constraints.NotEmpty;
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

public class SmidAlfApplication {
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("uuid")
	private String uuid;
	
	@JsonProperty("id")
	private String id;
	
	@JsonProperty("dateOfFormation")
	private String dateOfFormation ;
	
	@JsonProperty("registerationDate")
	private String registerationDate ;
	
	@JsonProperty("address")
	private String address;
	
	@JsonProperty("accountNumber")
	private String accountNumber;
	
	@JsonProperty("bankName")
	private String bankName;
		
	@JsonProperty("branchName")
	private String branchName;
	
	@JsonProperty("contactNumber")
	private String contactNumber;
	
	@NotNull
	@JsonProperty("tenantId")
	private String tenantId;

	@JsonProperty("isActive")
	private Boolean isActive;

	@JsonProperty("auditDetails")
	private AuditDetails auditDetails;
	
	@JsonProperty("fromDate")
	private String fromDate;

	@JsonProperty("toDate")
	private String toDate;
	
	
	@JsonProperty("adhaarNumber")
	private String adhaarNumber;
	
	@JsonProperty("dateOfOpeningAccount")
	private String dateOfOpeningAccount;
	
	@JsonProperty("alfFormatedThrough")
	private String alfFormatedThrough;
	
	@JsonProperty("applicationDocument")
	private List<ALFApplicationDocument> applicationDocument;
}
