package org.egov.pm.model;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
* A Object holds the data for a for NOC with remark and details
*/
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Component
public class NOCApplication {

	private String applicationUuid;
	private String tenantId;
	private String nocNumber;
	private String appliedBy;
	private String appliedDate;
	private String applicationType;
	private String applicationStatus;
	private Boolean isActive;
	private String createdBy;
	private String lastModifiedBy;
	private Long createdTime;
	private Long lastModifiedTime;
	private String applicantName;
	private String houseNo;
	private String sector;
	private BigDecimal amount;
	private BigDecimal gstAmount;
	private BigDecimal performanceBankGuarantee;
	private String badgeNumber;
	private BigDecimal totalamount;
	private NOCApplicationDetail nocApplicationDetails;
	private NOCApplicationRemark nocApplicationRemark;
	private String assignee;
}
