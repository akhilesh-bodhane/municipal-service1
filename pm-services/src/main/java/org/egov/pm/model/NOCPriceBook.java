package org.egov.pm.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/**
* A Object holds the data for a for PriceBook
*/

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NOCPriceBook {
	private String priceBookId;
	private String applicationType;
	private String categoryId;
	private String subCategoryId;
	private Long minSqft;
	private Long maxSqft;
	private Long perDayPrice;
	private Long perWeekPrice;
	private Long perMonthPrice;
	private Long annualPrice;
	private Long fixedPrice;
	private String effectiveFromDate;
	private String effectiveToDate;
	private String tenantId;
	private boolean isActive;
	private String createdBy;
	private Long createdTime;
	private String lastModifiedBy;
	private Long lastModifiedTime;
    private Integer calculationSequence;
    private String calculationType;
}
