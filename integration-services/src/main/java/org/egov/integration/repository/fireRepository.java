package org.egov.integration.repository;

import java.util.HashMap;
import java.util.Map;

import org.egov.integration.config.FireConfiguration;
import org.egov.integration.config.PtConfiguration;
import org.egov.integration.model.FireNoc;
import org.egov.integration.model.FireRequest;
import org.egov.integration.model.PtMapping;
import org.egov.integration.model.PtMappingRequest;
import org.egov.integration.model.PtMappingRequestInfoWrapper;
import org.egov.integration.producer.Producer;
import org.egov.integration.repository.builder.PtMappingQueryBuilder;
import org.egov.integration.repository.rowmapper.PtMappingRowMapper;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class fireRepository {

	@Autowired
	private Producer producer;

	@Autowired
	private FireConfiguration config;

	public void saveFireData(FireNoc fire) {
	
		FireRequest infoWrapper = FireRequest.builder().fireNocRequest(fire).build();
		producer.push(config.getFireDataSaveTopic(), infoWrapper);
	}

	public void saveFireDetailsData(FireNoc data) {

		FireRequest infoWrapper = FireRequest.builder().fireNocRequest(data).build();
		producer.push(config.getFireDataDetailsSaveTopic(), infoWrapper);

	}

	public void saveFireExecutionDetailsData(FireNoc data) {
       
		FireRequest infoWrapper = FireRequest.builder().fireNocRequest(data).build();
		producer.push(config.getFireExecutionDataSaveTopic(), infoWrapper);

	}

}
