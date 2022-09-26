package org.egov.hcr.model;

import java.util.List;

import org.egov.common.contract.response.ResponseInfo;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User{
    public Integer id;
    public String uuid;
    public String userName;
    public Object password;
    public String salutation;
    public String name;
    public String gender;
    public String mobileNumber;
    public String emailId;
    public Object altContactNumber;
    public Object pan;
    public Object aadhaarNumber;
    public String permanentAddress;
    public String permanentCity;
    public Object permanentPinCode;
    public String correspondenceCity;
    public Object correspondencePinCode;
    public Object correspondenceAddress;
    public Boolean active;
    public Long dob;
    public Object pwdExpiryDate;
    public String locale;
    public String type;
    public String signature;
    public Boolean accountLocked;
    public List<Role> roles;
    public String fatherOrHusbandName;
    public Object bloodGroup;
    public String identificationMark;
    public Object photo;
    public String createdBy;
    public Object createdDate;
    public String lastModifiedBy;
    public Long lastModifiedDate;
    public Object otpReference;
    public String tenantId;
}