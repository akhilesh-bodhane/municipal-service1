package org.egov.waterconnection.model;

import java.math.BigDecimal;

import org.egov.waterconnection.model.WaterConnection.WaterConnectionBuilder;

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
public class PublicDashboardFilestore {
	
	@JsonProperty("id")
	private String id = null;

	@JsonProperty("fileStoreId")
	private String fileStoreId = null;
	
	@JsonProperty("createdBy")
	private String createdBy;

	@JsonProperty("lastModifiedBy")
	private String lastModifiedBy;

	@JsonProperty("createdTime")
	private Long createdTime;

	@JsonProperty("lastModifiedTime")
	private Long lastModifiedTime;

}
