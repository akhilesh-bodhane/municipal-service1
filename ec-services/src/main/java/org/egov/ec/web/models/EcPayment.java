package org.egov.ec.web.models;

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
public class EcPayment {

	@Size(max = 64)
	@JsonProperty("paymentUuid")
	private String paymentUuid;
	
	@Size(max = 64)
	@JsonProperty("paymentReceiptUuid")
	@NotNull(message = "paymentReceiptUuid should not be empty or null")
	@NotBlank(message = "paymentReceiptUuid should not be empty or null")
	private String paymentReceiptUuid;

	@Size(max = 64)
	@JsonProperty("paymentMode")
	private String paymentMode;

	@Size(max = 256)
	@JsonProperty("paymentStatus")
	@NotNull(message = "paymentStatus should not be empty or null")
	@NotBlank(message = "paymentStatus should not be empty or null")
	private String paymentStatus;

	@JsonProperty("paymentAmount")
	@NotNull(message = "paymentAmount should not be empty or null")
	@NotBlank(message = "paymentAmount should not be empty or null")
	private String paymentAmount;

	@Size(max = 128)
	@JsonProperty("transactionId")
	private String transactionId;
	
	@Size(max = 64)
	@NotNull(message = "challanUuid should not be empty or null")
	@NotBlank(message = "challanUuid should not be empty or null")
	@JsonProperty("challanUuid")
	private String challanUuid;
	
	@Size(max = 64)
	@JsonProperty("challanId")
	@NotNull(message = "challanId should not be empty or null")
	@NotBlank(message = "challanId should not be empty or null")
	private String challanId;
	
	@Size(max = 64)
	@JsonProperty("violationUuid")
	@NotNull(message = "violationUuid should not be empty or null")
	@NotBlank(message = "violationUuid should not be empty or null")
	private String violationUuid;

	@Size(max = 256)
	@JsonProperty("paymentGateway")
	private String paymentGateway;

	@Size(max = 64)
	@JsonProperty("pgStatus")
	private String pgStatus;

	@NotNull(message = "Tenant Id should not be empty or null")
	@NotBlank(message = "Tenant Id should not be empty or null")
	@JsonProperty("tenantId")
	private String tenantId;

	@JsonProperty("isActive")
	@NotNull(message = "isActive should not be empty or null")
	private Boolean isActive;

	@Size(max = 256)
	@JsonProperty("createdBy")
	private String createdBy;

	@JsonProperty("createdTime")
	@NotNull(message = "createdTime should not be empty or null")
	private Long createdTime;

	@Size(max = 256)
	@JsonProperty("lastModifiedBy")
	private String lastModifiedBy;

	@JsonProperty("lastModifiedTime")
	@NotNull(message = "lastModifiedTime should not be empty or null")
	private Long lastModifiedTime;
	
	@JsonProperty("sourceUuid")
	private String sourceUuid;
}
