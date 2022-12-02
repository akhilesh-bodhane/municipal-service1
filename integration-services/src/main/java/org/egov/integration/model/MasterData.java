package org.egov.integration.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;

import org.egov.common.contract.response.ResponseInfo;
//import org.egov.waterconnection.model.pendingConnections;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Builder;

/**
 * Contract class to send response. Array of tradelicense items are used in case of search results or response for create, whereas single tradelicense item is used for update
 */
@ApiModel(description = "Contract class to send response. Array of tradelicense items are used in case of search results or response for create, whereas single tradelicense item is used for update")
@Validated
@javax.annotation.Generated(value = "org.egov.codegen.SpringBootCodegen", date = "2018-09-18T17:06:11.263+05:30")

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MasterData   {
    @JsonProperty("financialYear")
    @Valid
    private String financialYear ;
    
    @JsonProperty("module")
    @Valid
    private String module;
    
    @JsonProperty("ulb")
    @Valid
    private String ulb ;
    
    @JsonProperty("region")
    @Valid
    private String region ;
    
    @JsonProperty("state")
    @Valid
    private String state ;
    
    @JsonProperty("metrics")
    @Valid
    private metricsDomainWise metrics ;


      
}

