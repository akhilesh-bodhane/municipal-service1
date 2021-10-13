package org.egov.pgr.model;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AutoroutingMap   {

  @JsonProperty("id")
  private String id;
	
  @NotNull
  @JsonProperty("tenantId")
  private String tenantId;

  @NotNull
  @JsonProperty("autorouting")
  private Object autorouting;

  @JsonProperty("auditDetails")
  private AuditDetails auditDetails;
  
  @JsonProperty("active")
  private Boolean active;
}

