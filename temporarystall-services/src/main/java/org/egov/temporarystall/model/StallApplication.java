package org.egov.temporarystall.model;

import java.math.BigDecimal;
import java.util.List;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

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
public class StallApplication {
	
	private String applicationUuid ;
	
	private String applicationId ;
	
	@NotNull
	@JsonProperty("tenantId")
	private String tenantId ;
	
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("mobileno")
	private String mobileno;
	
	@JsonProperty("festival")
	private String festival;
	
	@JsonProperty("fromdate")
	private String fromdate;
	
	@JsonProperty("todate")
	private String todate;
	
	@JsonProperty("sector")
	private String sector;
	
	@JsonProperty("stallsize")
	private String stallsize;
	
	@JsonProperty("address")
	private String address;
	
	@JsonProperty("landmark")
	private String landmark;
	
	/*
	 * @JsonProperty("fee") private String fee;
	 */
	
	@JsonProperty("isActive")
	private Boolean isActive ;
	
	@JsonProperty("noofdays")
	private int noofdays;
	
	@JsonProperty("feesperday")
	private int feesperday;
	
	@JsonProperty("totalamount")
	private double totalamount;
	
	@JsonProperty("applicationstatus")
	private String applicationstatus;
	
	
	@JsonProperty("financialyear")
	private String financialyear;
	
	@JsonProperty("demanid")
	private String demanid;
	
	@JsonProperty("demaniddetailid")
	private String demaniddetailid;

	@JsonProperty("financialBusinessService")
	private String financialBusinessService;
	
	@JsonProperty("businessservice")
	private String businessservice;
	
	@JsonProperty("applicationDocument")
	private List<StallApplicationDocument> applicationDocument;
	
	@JsonProperty("auditDetails")
	private AuditDetails auditDetails ;
	

}
