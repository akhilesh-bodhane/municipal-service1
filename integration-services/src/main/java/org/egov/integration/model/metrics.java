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
public class metrics   {

        @JsonProperty("transactions")
        @Valid
        private String transactions = null;
        
        @JsonProperty("todaysApplications")
        @Valid
        private String todaysApplications = null;
        
        @JsonProperty("tlTax")
        @Valid
        private String tlTax = null;
        
        @JsonProperty("adhocPenalty")
        @Valid
        private String adhocPenalty = null;
        
        @JsonProperty("adhocRebate")
        @Valid
        private String adhocRebate = null;
        
        @JsonProperty("todaysLicenseIssuedWithinSLA")
        @Valid
        private String todaysLicenseIssuedWithinSLA = null;
        
        @JsonProperty("todaysCollection")
    	@Valid
    	private List<todaysCollection> todaysCollection = null;
    	
    	
    	@JsonProperty("todaysTradeLicenses")
    	@Valid
    	private List<todaysTradeLicenses> todaysTradeLicenses = null;
    	
    	@JsonProperty("applicationsMovedToday")
    	@Valid
    	private List<applicationsMovedToday> applicationsMovedToday = null;
        
        


      
}

