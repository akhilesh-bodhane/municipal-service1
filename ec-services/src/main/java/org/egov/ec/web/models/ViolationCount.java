package org.egov.ec.web.models;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Validated
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ViolationCount {
	  
	@Size(max = 64)
	@JsonProperty("violationUuid")
	private String violationUuid;
	
	
	
	
	
	
	
	
	@Size(max = 64)
	@JsonProperty("encroachmentType")
	@NotNull(message = "encroachmentType  should not be empty or null")
	@NotBlank(message = "encroachmentType  should not be empty or null")
	private String encroachmentType;
	
	@JsonProperty("violationDate")
	@NotNull(message = "violationDate  should not be empty or null")
	@NotBlank(message = "violationDate  should not be empty or null")
	private String violationDate;
	
	@JsonProperty("violationTime")
	@NotNull(message = "violationTime  should not be empty or null")
	@NotBlank(message = "violationTime  should not be empty or null")
	private String violationTime;
	
	
	
		
	@Size(max = 256)
	@NotNull(message = "siName  should not be empty or null")
	@NotBlank(message = "siName  should not be empty or null")
	@JsonProperty("siName")
	private String siName;
	
	@Size(max = 64)
	@JsonProperty("status")
	private String status;
	
	@Size(max = 64)
	@NotNull(message = "sector  should not be empty or null")
	@NotBlank(message = "sector  should not be empty or null")
	@JsonProperty("sector")
	private String sector;
	
	@JsonProperty("paymentDetails")
	private EcPaymentCount paymentDetails;
	
	
	
	@JsonProperty("createdTime")
	@NotNull(message = "createdTime  should not be empty or null")
	private Long createdTime;
	
	
	
	@JsonProperty("fromDate")
	private Date fromDate;
	
	@JsonProperty("toDate")
	private Date toDate;
	
}
