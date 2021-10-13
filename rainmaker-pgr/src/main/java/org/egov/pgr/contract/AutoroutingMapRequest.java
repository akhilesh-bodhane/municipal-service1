package org.egov.pgr.contract;

import javax.validation.Valid;

import org.egov.common.contract.request.RequestInfo;
import org.egov.pgr.model.AutoroutingMap;
import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Request object to fetch the report data
 */
@Validated
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AutoroutingMapRequest   {
  @JsonProperty("RequestInfo")
  private RequestInfo requestInfo = null;

  @JsonProperty("autoroutingmap")
  @Valid
  private AutoroutingMap autoroutingMap;

}

