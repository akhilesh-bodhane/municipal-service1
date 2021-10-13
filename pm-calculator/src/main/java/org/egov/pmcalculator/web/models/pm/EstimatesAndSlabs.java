package org.egov.pmcalculator.web.models.pm;

import java.util.List;

import org.egov.pmcalculator.web.models.demand.TaxHeadEstimate;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class EstimatesAndSlabs {

    @JsonProperty("estimates")
    private List<TaxHeadEstimate> estimates;

//    @JsonProperty("nocTypeFeeAndBillingSlabIds")
//    private FeeAndBillingSlabIds nocTypeFeeAndBillingSlabIds;

//    @JsonProperty("accessoryFeeAndBillingSlabIds")
//    private FeeAndBillingSlabIds accessoryFeeAndBillingSlabIds;

 

}
