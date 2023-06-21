package org.egov.pgr.contract;

import org.json.simple.JSONObject;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class IUDXData {

	@JsonProperty("cityName")
	private String cityName;

	@JsonProperty("category")
	private JSONObject category;
}
