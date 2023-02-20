package org.egov.streetvendor.repository;


import org.egov.streetvendor.config.StreetVendorConfiguration;
import org.egov.streetvendor.model.RequestInfoWrapper;
import org.egov.streetvendor.model.StreetVendorData;
import org.egov.streetvendor.producer.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class StreetVendorRepository {
	
private Producer producer;
	
private StreetVendorConfiguration config;
	

	
	@Autowired
	public StreetVendorRepository(Producer producer, StreetVendorConfiguration config) {
		this.producer = producer;
		this.config = config;
	}
	
	public void createstreetVendor(StreetVendorData streetVendorData) {
		RequestInfoWrapper infoWrapper = RequestInfoWrapper.builder().requestBody(streetVendorData).build();
		producer.push(config.getStreetVendorDataSaveTopic(), infoWrapper);
	}

}
