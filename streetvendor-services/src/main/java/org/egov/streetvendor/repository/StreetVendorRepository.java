package org.egov.streetvendor.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.validation.Valid;

import org.egov.common.contract.request.RequestInfo;
import org.egov.streetvendor.config.StreetVendorConfiguration;
import org.egov.streetvendor.model.RequestInfoWrapper;
import org.egov.streetvendor.model.StreetVendorData;
import org.egov.streetvendor.model.StreetVendorRequest;
import org.egov.streetvendor.producer.Producer;
import org.egov.streetvendor.repository.builder.StreetvendorQueryBuilder;
import org.egov.streetvendor.repository.rowmapper.StreetVendorDetailsRowMapper;
import org.egov.streetvendor.repository.rowmapper.StreetVendorRowMapper;
import org.egov.streetvendor.service.StreetVendorService;
import org.egov.tracer.model.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class StreetVendorRepository {

	private Producer producer;

	private StreetVendorConfiguration config;

	private StreetVendorRowMapper streetVendorRowMapper;

	private StreetVendorDetailsRowMapper streetVendorDetailsRowMapper;

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private StreetvendorQueryBuilder streetvendorQueryBuilder;

	@Autowired
	public StreetVendorRepository(Producer producer, StreetVendorConfiguration config,
			StreetVendorRowMapper streetVendorRowMapper, JdbcTemplate jdbcTemplate,
			StreetVendorDetailsRowMapper streetVendorDetailsRowMapper) {
		this.producer = producer;
		this.config = config;
		this.streetVendorRowMapper = streetVendorRowMapper;
		this.jdbcTemplate = jdbcTemplate;
		this.streetVendorDetailsRowMapper = streetVendorDetailsRowMapper;
	}

	public void createstreetVendor(@Valid StreetVendorData streetVendorData) {
		RequestInfoWrapper infoWrapper = RequestInfoWrapper.builder().requestBody(streetVendorData).build();
		producer.push(config.getStreetVendorDataSaveTopic(), infoWrapper);
	}

	
	public List<StreetVendorData> getStreetVendorList(StreetVendorData streetVendorData,
			RequestInfo requestInfo) {
		List<Object> preparedStatement = new ArrayList<>();
		String query =streetvendorQueryBuilder.getSearchQueryStringCount(streetVendorData, preparedStatement, requestInfo);
		

		StringBuilder str = new StringBuilder("Streetvendor query: ").append(query);
		
		if (query == null)
			return Collections.emptyList();
	
		List<StreetVendorData> streetVendorDataList = jdbcTemplate.query(query, preparedStatement.toArray(),
				streetVendorRowMapper);
		
		
		if (streetVendorDataList == null) {
			return Collections.emptyList();
		}

		return streetVendorDataList;
	}

	public StreetVendorData getStreetVendorDetails(StreetVendorData streetVendorData) {
		try {
			return jdbcTemplate.query(StreetvendorQueryBuilder.GET_DETAILS_STREET_VENDOR_DATA_QUERY,
					new Object[] { streetVendorData.getCovNo() },
					streetVendorDetailsRowMapper);
		} catch (Exception e) {
			e.printStackTrace();
			throw new CustomException("Exception", e.getMessage());
		}
	}
	
	public void updateStreetVendor(StreetVendorData StreetVendorData) {
		StreetVendorRequest infoWrapper = StreetVendorRequest.builder().streetvendorData(StreetVendorData).build();
		producer.push(config.getStreetVendorDataUpdateTopic(), infoWrapper);
		
	}
	
	

}
