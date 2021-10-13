package org.egov.pm.model;

import java.util.List;


import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class ColumnsMaps {
	
	@JsonProperty("tenantId")
	private List<String> tenantId;

	@JsonProperty("columnConfig")
	private List<Column> columnConfig;

	@JsonProperty("documentConfig")
	private List<DocumentColumn> documentConfig;
}
