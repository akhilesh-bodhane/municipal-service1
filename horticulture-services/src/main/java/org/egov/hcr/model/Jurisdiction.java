package org.egov.hcr.model;

import java.util.List;

import org.egov.common.contract.response.ResponseInfo;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Jurisdiction{
    public String id;
    public String hierarchy;
    public String boundary;
    public String boundaryType;
    public String tenantId;
    public AuditDetails auditDetails;
    public Boolean isActive;
}