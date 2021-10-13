package org.egov.pm.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class EmailColumn {
	@JsonProperty("applicationType")
	private String applicationType;

	@JsonProperty("status")
	public List<String> status;

	@JsonProperty("template")
	private String template;
	
	@JsonProperty("smsTemplate")
	private String smsTemplate;
	
	@JsonProperty("emailSubject")
	private String emailSubject;
	
	@JsonProperty("roles")
	private List<String> roles;
}
