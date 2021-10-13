package org.egov.pm.model;

import static org.springframework.util.ObjectUtils.isEmpty;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder(toBuilder = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
	
	private Long id;
	private String uuid;
	private String tenantId;
	private String username;
	private String title;
	private String password;
	private String salutation;
	private String guardian;
	private String name;
	private String mobileNumber;
	private String emailId;
	private String altContactNumber;
	private String pan;
	private String aadhaarNumber;
	private Boolean active;
	private String locale = "en_IN";
	private String identificationMark;
	private String signature;
	private String photo;
	private Boolean accountLocked;
	private Long accountLockedDate;
	private String otpReference;
	private Long createdBy;
	private Long lastModifiedBy;
	private Long loggedInUserId;
	private boolean otpValidationMandatory;
	private boolean mobileValidationMandatory = true;




	public boolean isOtpReferenceAbsent() {
		return otpValidationMandatory && isEmpty(otpReference);
	}


	public boolean isActiveIndicatorAbsent() {
		return isEmpty(active);
	}

	public boolean isMobileNumberAbsent() {
		return mobileValidationMandatory && isEmpty(mobileNumber);
	}

	public boolean isNameAbsent() {
		return isEmpty(name);
	}

	public boolean isUsernameAbsent() {
		return isEmpty(username);
	}

	public boolean isTenantIdAbsent() {
		return isEmpty(tenantId);
	}	
	
	public boolean isPasswordAbsent(){
		return isEmpty(password);
	}


	public boolean isIdAbsent() {
		return id == null;
	}


	public boolean isLoggedInUserDifferentFromUpdatedUser() {
		return !id.equals(loggedInUserId);
	}

	public void updatePassword(String newPassword) {
		password = newPassword;
	}

	public void setActive(boolean isActive) {
		active = isActive;
	}
}


