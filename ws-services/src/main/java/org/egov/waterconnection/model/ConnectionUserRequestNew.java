package org.egov.waterconnection.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.egov.common.contract.request.RequestInfo;

@AllArgsConstructor
@Getter
@NoArgsConstructor
@Builder
@Setter
public class ConnectionUserRequestNew {
    @JsonProperty("requestInfo")
    private RequestInfo requestInfo;
    
    @JsonProperty("user")
    private Property user;
}
