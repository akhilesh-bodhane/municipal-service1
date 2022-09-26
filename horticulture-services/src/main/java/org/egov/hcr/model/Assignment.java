package org.egov.hcr.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Assignment{
    public String id;
    public Integer position;
    public String designation;
    public String department;
    public Long fromDate;
    public Object toDate;
    public String govtOrderNumber;
    public String tenantid;
    public String reportingTo;
    public AuditDetails auditDetails;
    public Boolean isHOD;
    public Boolean isCurrentAssignment;
    public Boolean isPrimaryAssignment;
    public Integer postDetailId;
}