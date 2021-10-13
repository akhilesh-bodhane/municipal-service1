package org.egov.ec.web.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EcSearchCriteria {


    @JsonProperty("tenantId")
    private String tenantId;

    @JsonProperty("status")
    private String status;


    @JsonProperty("challanId")
    private String challanId;

  
    @JsonProperty("mobileNumber")
    private String mobileNumber;

    @JsonProperty("action")
    private String action;


    @JsonProperty("fromDate")
    private Long fromDate = null;

    @JsonProperty("toDate")
    private Long toDate = null;


    @JsonProperty("offset")
    private Integer offset;

    @JsonProperty("limit")
    private Integer limit;
    
    @JsonProperty("orderDir")
    private String orderDir;
    
    @JsonProperty("orderColumn")
    private String orderColumn;
    
    @JsonProperty("searchText")
    private String searchText;
    
    @JsonProperty("challanUuid")
    private String challanUuid;
    
    @JsonProperty("covNo")
    private String covNo;


}
