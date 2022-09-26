package org.egov.hcr.model;

import java.util.List;

import org.egov.common.contract.response.ResponseInfo;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeDetails{
    @JsonProperty("ResponseInfo") 
    public ResponseInfo responseInfo;
    @JsonProperty("Employees") 
    public List<Employee> employees;
}