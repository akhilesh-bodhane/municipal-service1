package org.egov.pgr.contract;

import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.egov.common.contract.response.ResponseInfo;
import org.egov.pgr.model.AutoroutingMap;
import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

/**
 * Response to the autorouting request
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-07-23T08:00:37.661Z")

@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AutoroutingMapResponse   {
  @JsonProperty("ResponseInfo")
  private ResponseInfo responseInfo = null;

  @JsonProperty("autoroutingmap")
  @Valid
  private AutoroutingMap autoroutingMap;

  public AutoroutingMapResponse responseInfo(ResponseInfo responseInfo) {
    this.responseInfo = responseInfo;
    return this;
  }

  /**
   * Get responseInfo
   * @return responseInfo
  **/
  @NotNull
  @Valid
  public ResponseInfo getResponseInfo() {
    return responseInfo;
  }

  @NotNull
  @Valid
  public AutoroutingMap getAutoroutingMap() {
	  return autoroutingMap;
  }

  public void setAutoroutingMap(AutoroutingMap autoroutingMap) {
	this.autoroutingMap = autoroutingMap;
  }
 
  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AutoroutingMapResponse autoroutingMapResponse = (AutoroutingMapResponse) o;
    return Objects.equals(this.responseInfo, autoroutingMapResponse.responseInfo) &&
        Objects.equals(this.autoroutingMap, autoroutingMapResponse.autoroutingMap);
  }

  @Override
  public int hashCode() {
    return Objects.hash(responseInfo, autoroutingMap);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AutoroutingMapResponse {\n");
    
    sb.append("    responseInfo: ").append(toIndentedString(responseInfo)).append("\n");
    sb.append("    AutoroutingMapResponse: ").append(toIndentedString(autoroutingMap)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

