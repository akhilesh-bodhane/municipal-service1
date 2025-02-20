package org.egov.pgr.model;

import java.util.Map;

public class LevelThreeSlaCountsResponse {
	
	 private Map<String, Integer> sePublicHealthCounts;
	    private Map<String, Integer> seBRCounts;
	    private Map<String, Integer> seHECounts;
	    private Map<String, Integer> mohCounts;

	    // Constructor
	    public LevelThreeSlaCountsResponse(Map<String, Integer> sePublicHealthCounts, Map<String, Integer> seBRCounts,
	                             Map<String, Integer> seHECounts, Map<String, Integer> mohCounts) {
	        this.sePublicHealthCounts = sePublicHealthCounts;
	        this.seBRCounts = seBRCounts;
	        this.seHECounts = seHECounts;
	        this.mohCounts = mohCounts;
	    }

	    // Getters & Setters (Optional, needed for serialization)
	    public Map<String, Integer> getSePublicHealthCounts() { 
	    	return sePublicHealthCounts; 
	    	}
	    public Map<String, Integer> getSeBRCounts() {
	    	return seBRCounts; 
	    	}
	    public Map<String, Integer> getSeHECounts() { 
	    	return seHECounts; 
	    	}
	    public Map<String, Integer> getMohCounts() {
	    	return mohCounts; 
	    	}

}
