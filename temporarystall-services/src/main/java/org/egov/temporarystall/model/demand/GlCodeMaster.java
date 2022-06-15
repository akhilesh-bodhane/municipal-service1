package org.egov.temporarystall.model.demand;

import javax.validation.constraints.NotNull;

import org.egov.temporarystall.model.AuditDetails;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GlCodeMaster {

	private String id;

	@NotNull
	private String tenantId;
	@NotNull
	private String taxHead;
	@NotNull
	private String service;
	@NotNull
	private String glCode;
	@NotNull
	private Long fromDate;
	@NotNull
	private Long toDate;
	
	private AuditDetails auditDetails;
}
