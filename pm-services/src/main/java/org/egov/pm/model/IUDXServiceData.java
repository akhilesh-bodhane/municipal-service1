package org.egov.pm.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class IUDXServiceData {

	@JsonProperty("sellmeatNoc")
	private IUDXData sellmeat;

	@JsonProperty("petNoc")
	private IUDXData petNoc;

	@JsonProperty("roadcutNoc")
	private IUDXData roadcutNoc;

	@JsonProperty("advertisementNoc")
	private IUDXData advertisementNoc;

	@JsonProperty("utroadcutNoc")
	private IUDXData utroadcutNoc;
}
