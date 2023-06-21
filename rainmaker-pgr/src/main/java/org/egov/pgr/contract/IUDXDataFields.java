package org.egov.pgr.contract;

import javax.validation.constraints.NotNull;

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
public class IUDXDataFields {

	@NotNull
	@JsonProperty("tenantId")
	private String tenantId;

	@NotNull
	@JsonProperty("fromDate")
	private Long fromDate;

	@NotNull
	@JsonProperty("toDate")
	private Long toDate;
}
