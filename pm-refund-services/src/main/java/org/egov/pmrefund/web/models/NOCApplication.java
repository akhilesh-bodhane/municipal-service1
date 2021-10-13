package org.egov.pmrefund.web.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Collection of audit related fields used by most models
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NOCApplication {

	private String applicationuuid;
	private String nocnumber;
	private String appliedBy;
	private String applicationdetail;
	private String applieddate;
	private String applicationtype;
	private String applicationstatus;
	private String applicantname;
	private String housenumber;
	private String sector;
	private Integer amount;
	private Double gstamount;
	private Double performancebankguaranteecharges;
	private Double totalamount;
}