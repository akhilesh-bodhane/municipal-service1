package org.egov.temporarystall.model.demand;

import java.math.BigDecimal;

import org.egov.temporarystall.model.AuditDetails;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * A object holds a demand and collection values for a tax head and period.
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DemandDetail   {
	
        @JsonProperty("id")
        private String id;
        
        @JsonProperty("demandId")
        private String demandId;

        @JsonProperty("taxHeadMasterCode")
        private String taxHeadMasterCode;

		
		  @JsonProperty("taxAmount") 
		  private double taxAmount;
		 
        
        @JsonProperty("feesperday")
        private BigDecimal feesperday;

        @JsonProperty("collectionAmount")
        private double collectionAmount;

        @JsonProperty("additionalDetails")
        private Object additionalDetails;

        @JsonProperty("auditDetails")
        private AuditDetails auditDetails;

        @JsonProperty("tenantId")
        private String tenantId;
        
        @JsonProperty("totalAmount")
        private double totalAmount;


}

