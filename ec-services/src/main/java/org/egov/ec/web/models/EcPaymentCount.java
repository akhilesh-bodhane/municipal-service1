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
public class EcPaymentCount {



	@Size(max = 256)
	@JsonProperty("paymentStatus")
	@NotNull(message = "paymentStatus should not be empty or null")
	@NotBlank(message = "paymentStatus should not be empty or null")
	private String paymentStatus;
	
	@Size(max = 256)
	@JsonProperty("paymentMode")
	@NotNull(message = "paymentMode should not be empty or null")
	@NotBlank(message = "paymentMode should not be empty or null")
	private String paymentMode;

	
}
