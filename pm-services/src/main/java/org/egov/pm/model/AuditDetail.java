package org.egov.pm.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



/**
* A Object holds the basic data for Audit
*/
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AuditDetail {

	private String createdBy;

	private String lastModifiedBy;

	private Long createdTime;

	private Long lastModifiedTime;
}
