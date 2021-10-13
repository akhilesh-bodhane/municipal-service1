package org.egov.pm.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReportModel {

	private String tenantId;
	private String applicationType;
	private String totalAverage;
	private String totalAveragePending10DayasTo30Days;
	private String totalAveragePendingGreaterThan30Days;
}
