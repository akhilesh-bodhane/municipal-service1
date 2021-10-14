package org.egov.waterconnection.model;

import org.egov.common.contract.request.RequestInfo;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;




@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WaterNotication {
		
	
	
	@JsonProperty("application_no")
 	private String application_no;
	
	@JsonProperty("consumer_name")
 	private String consumer_name;
	
	@JsonProperty("house_no")
 	private String house_no;
	
	@JsonProperty("sector_village")
 	private String sector_village;
	
	@JsonProperty("phone_no")
 	private String phone_no;
	
	@JsonProperty("application_type")
 	private String application_type;
 	
	@JsonProperty("application_status")
 	private String application_status;
	
	
	@JsonProperty("amount")
 	private String amount;


}
