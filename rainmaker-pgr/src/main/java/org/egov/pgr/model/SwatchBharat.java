package org.egov.pgr.model;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@Setter
@Getter
public class SwatchBharat {

	@NotNull
	@JsonProperty("uuid")
	private String uuid;

	@NotNull
	@JsonProperty("useruuid")
	private String useruuid;

	@JsonProperty("fileid")
	private String fileid;

	@JsonProperty("filedata")
	private String filedata;

	@JsonProperty("isvalidimage")
	private Boolean isvalidimage = false;

	@JsonProperty("username")
	private String username;

	@JsonProperty("workbookid")
	private Long workbookid = null;

	@JsonProperty("auditDetails")
	private AuditDetails auditDetails;

}
