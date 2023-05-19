package org.egov.waterconnection.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class PublicDashboardSearch {
	
	@JsonProperty("fromDate")
	private Long fromDate;
	
	@JsonProperty("toDate")
	private Long toDate;
	
	@JsonProperty("servicename")
	private String servicename;
	
	@JsonProperty("servicetype")
	private String servicetype;

}
