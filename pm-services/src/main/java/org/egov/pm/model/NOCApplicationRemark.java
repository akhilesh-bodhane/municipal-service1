package org.egov.pm.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
* A Object holds the data for a for NOC remark data
*/

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NOCApplicationRemark {

	private String remarkId;
	private String applicationUuid;
	private String applicationStatus;
	private String remark;
	private String remarkBy;
	private Boolean isActive;
	private String createdBy;
	private Long createdTime;
	private String lastModifiedBy;
	private Long lastModifiedTime;
	private String documentId;
	private String tenantId;
	private String previousRemarkId;
}
