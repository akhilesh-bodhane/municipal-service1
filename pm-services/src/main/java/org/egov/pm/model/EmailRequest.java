package org.egov.pm.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EmailRequest {
	private String email;
	private String subject;
	private String body;
	@JsonProperty("isHTML")
	private boolean isHTML;

}
