package org.egov.waterconnection.model.users;

import java.util.List;

import org.egov.common.contract.response.ResponseInfo;
import org.egov.waterconnection.model.ConnectionHolderInfo;
import org.egov.waterconnection.model.ConnectionHolderInfoV2;
import org.egov.waterconnection.model.Property;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class UserDetailResponseNew {
    @JsonProperty("responseInfo")
    ResponseInfo responseInfo;
    
    @JsonProperty("user")
    List<Property> user;
    
}
