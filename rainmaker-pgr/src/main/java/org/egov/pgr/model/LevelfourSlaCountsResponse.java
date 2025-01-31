package org.egov.pgr.model;

import java.util.Map;

public class LevelfourSlaCountsResponse {
	
	 private Map<String, Integer> CECounts;
	    private Map<String, Integer> JCMC1Counts;
	    private Map<String, Integer> JCMC2Counts;
	    private Map<String, Integer> JCMC3Counts;

	    // Constructor
	    public LevelfourSlaCountsResponse(Map<String, Integer> CECounts, Map<String, Integer> JCMC1Counts,
	                             Map<String, Integer> JCMC2Counts, Map<String, Integer> JCMC3Counts) {
	        this.CECounts = CECounts;
	        this.JCMC1Counts = JCMC1Counts;
	        this.JCMC2Counts = JCMC2Counts;
	        this.JCMC3Counts = JCMC3Counts;
	    }


		public Map<String, Integer> getCECounts() {
			return CECounts;
		}
		public Map<String, Integer> getJCMC1Counts() {
			return JCMC1Counts;
		}
		public Map<String, Integer> getJCMC2Counts() {
			return JCMC2Counts;
		}
		public Map<String, Integer> getJCMC3Counts() {
			return JCMC3Counts;
		}


}
