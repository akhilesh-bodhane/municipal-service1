package org.egov.ec.web.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DuplicateChallanDetails {
	
	@JsonProperty("encroachmentType")
	private String encroachmentType;
	
	@JsonProperty("mobileNumber")
	private String mobileNumber;
	
	@JsonProperty("numberOfViolation")
	private String numberOfViolation;
	
	private String challanId;
	
    private String challanStatus;
    
    private Double challanAmount;
    
    private String challanDate;

    private String violatorName;
    
    private String paymentMode;
    
    private String paymentStatus;
    
    private String itemNames;

}
