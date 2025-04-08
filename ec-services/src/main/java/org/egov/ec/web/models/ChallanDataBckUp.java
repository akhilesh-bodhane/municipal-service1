package org.egov.ec.web.models;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.json.simple.JSONArray;
import org.springframework.validation.annotation.Validated;

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
public class ChallanDataBckUp {

	
	@JsonProperty("egWfProcessinstanceV2")
	private JSONArray egWfProcessinstanceV2 ;
	
	@JsonProperty("egecDocument")
	private JSONArray egecDocument ;
	
	@JsonProperty("egecStoreItemRegister")
	private JSONArray egecStoreItemRegister ;
	
	
	@JsonProperty("egecPayment")
	private JSONArray egecPayment ;
	
	@JsonProperty("egecChallanDetail")
	private JSONArray egecChallanDetail ;
	
	@JsonProperty("egecChallanMaster")
	private JSONArray egecChallanMaster ;
	
	@JsonProperty("egecViolationDetail")
	private JSONArray egecViolationDetail ;
	
	@JsonProperty("egecViolationMaster")
	private JSONArray egecViolationMaster ;
	
	
	@NotNull(message = "challanId  should not be empty or null")
	@NotBlank(message = "challanId  should not be empty or null")
	@JsonProperty("challanId")
	private String challanId ;
	
	@NotNull(message = "comment  should not be empty or null")
	@NotBlank(message = "comment  should not be empty or null")
	@JsonProperty("comment")
	private String comment ;
	
	@NotNull(message = "referenceChallanNo  should not be empty or null")
	@NotBlank(message = "referenceChallanNo  should not be empty or null")
	@JsonProperty("referenceChallanNo")
	private String referenceChallanNo ;
	
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
}
