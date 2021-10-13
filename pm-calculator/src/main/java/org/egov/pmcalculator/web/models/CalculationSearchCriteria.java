package org.egov.pmcalculator.web.models;

import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotNull;

@Data
@ToString
public class CalculationSearchCriteria {

    @NotNull
    private String tenantId;

    private String aplicationNumber;

}
