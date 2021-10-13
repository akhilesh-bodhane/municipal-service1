package org.egov.ec.web.models;

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
	
	
	
	@JsonProperty("challanId")
	private String challanId ;
}
