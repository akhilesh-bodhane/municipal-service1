package org.egov.waterconnection.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.egov.common.contract.request.RequestInfo;
import org.egov.waterconnection.model.users.User;

@AllArgsConstructor
@Getter
@NoArgsConstructor
@Builder
@Setter
public class ConnectionUserRequestNewCon {
    @JsonProperty("requestInfo")
    private RequestInfo requestInfo;
    
    @JsonProperty("user")
    private User user;
}
