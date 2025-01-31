package org.egov.pgr.model;

import java.util.Map;

public class LevelfiveSlaCountsResponse {
	
	 private Map<String, Integer> CommissionerCounts;

	    // Constructor
	    public LevelfiveSlaCountsResponse(Map<String, Integer> CommissionerCounts) {
	        this.CommissionerCounts = CommissionerCounts;
	    }

		public Map<String, Integer> getCommissionerCounts() {
			return CommissionerCounts;
		}
      
}
