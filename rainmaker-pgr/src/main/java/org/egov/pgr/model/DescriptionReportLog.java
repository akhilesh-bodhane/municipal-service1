package org.egov.pgr.model;

import org.egov.pgr.model.DiscriptionReport.DiscriptionReportBuilder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Builder
public class DescriptionReportLog {

	String creationdate;
	String status;
	String description;
	
}
