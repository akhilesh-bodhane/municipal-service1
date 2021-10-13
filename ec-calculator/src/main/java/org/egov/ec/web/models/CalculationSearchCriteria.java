package org.egov.ec.web.models;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class CalculationSearchCriteria {

    @NotNull
    private String tenantId;

    private String aplicationNumber;

}
