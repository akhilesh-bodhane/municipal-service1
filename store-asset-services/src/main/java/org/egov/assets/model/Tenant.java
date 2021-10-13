package org.egov.assets.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class Tenant {

	private Long id;
	private String code;
	private String name;
	private String description;
	private String logoId;
	private String imageId;
	private String domainUrl;
	private String type;
	private String twitterUrl;
	private String facebookUrl;
	private String emailId;
	private String address;
	private String contactNumber;
	private String helpLineNumber;
	private City city;

}