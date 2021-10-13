package org.egov.pm.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class EmailColumns {

	@JsonProperty("ColumnMaps")
	private EmailColumnMaps columnMaps;

}
