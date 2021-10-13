package org.egov.ec.web.models;

import java.io.File;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Validated
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class EcPaymentData {

	
	@JsonProperty("challanId")
	private String challanId;
		
	@Size(max = 256)
	@JsonProperty("paymentGateway")
	private String paymentGateway;
	
	@Size(max = 64)
	@JsonProperty("paymentMode")
	private String paymentMode;
	
	
	@Size(max = 256)
	@JsonProperty("pgStatus")
	@NotNull(message = "pgStatus should not be empty or null")
	@NotBlank(message = "pgStatus should not be empty or null")
	private String pgStatus;

	
	@Size(max = 256)
	@JsonProperty("paymentStatus")
	@NotNull(message = "paymentStatus should not be empty or null")
	@NotBlank(message = "paymentStatus should not be empty or null")
	private String paymentStatus;

	@Size(max = 128)
	@JsonProperty("transactionId")
	private String transactionId;


	@Size(max = 256)
	@JsonProperty("lastModifiedBy")
	private String lastModifiedBy;

	@JsonProperty("lastModifiedTime")
	@NotNull(message = "lastModifiedTime should not be empty or null")
	private Long lastModifiedTime;
	

}
