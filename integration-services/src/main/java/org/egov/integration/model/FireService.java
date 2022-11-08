package org.egov.integration.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FireService {

	@JsonProperty("uuid")
	public String uuid;

	@JsonProperty("service_name")
	public String service_name;

	@JsonProperty("service_id")
	public Integer service_id;

	@JsonProperty("delivered")
	public Integer delivered;

	@JsonProperty("submitted")
	public Integer submitted;

	@JsonProperty("rejected")
	public Integer rejected;

	@JsonProperty("createdBy")
	public Integer pending;

	@JsonProperty("createdBy")
	private String createdBy = null;

	@JsonProperty("lastModifiedBy")
	private String lastModifiedBy = null;

	@JsonProperty("createdTime")
	private Long createdTime = null;

	@JsonProperty("lastModifiedTime")
	private Long lastModifiedTime = null;
}
