package org.egov.hcr.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Employee{
    public Integer id;
    public String uuid;
    public String code;
    public String employeeStatus;
    public String employeeType;
    public Long dateOfAppoIntegerment;
    public Object dateOfSuperannuation;
//    public List<Jurisdiction> jurisdictions;
//    public List<Assignment> assignments;
//    public List<ServiceHistory> serviceHistory;
//    public List<Education> education;
//    public List<Object> tests;
    public String tenantId;
//    public List<Object> documents;ōōō
//    public List<Object> deactivationDetails;
    public AuditDetails auditDetails;
    public User user;
    public Integer postDetailId;
    public Object hrmsCode;
    public Boolean isActive;
}