package org.egov.pgr.model;

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
public class DiscriptionReport {
	 private String lastassignedto ;
	 private String servicecode ;
	 private String department ;
	 private String Type ;
	 private String locality  ;
	 private String complaintNo ;
	 private String date ;
	 private String name ;
	 private String phone ;
	 private String landmark ;
	 private String address ;
	 private String description ;
	 private String complaintraisedby ;
	 private String slaHours ;
	 private String lastactiondate ;
	 private String status ;
	 private String autoescalated ;
	 private String servicerequestid;
	 private String tenantid;
	 private Long slaendtime;
	 private String source;
	 private Long createdtime ;
	 private String feedback;
	 private String rating;
	 private String comments;
}
