package org.egov.streetvendor.repository;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import org.egov.streetvendor.config.StreetVendorConfiguration;
import org.egov.streetvendor.model.RequestInfoWrapper;
import org.egov.streetvendor.model.StreetVendorData;
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

	public List<StreetVendorData> getStreetVendorList(StreetVendorData streetVendorData) {
		List<StreetVendorData> streetVendorDataList = new ArrayList<>();

		try {
			return streetVendorDataList = jdbcTemplate.query(StreetvendorQueryBuilder.GET_STREET_VENDOR_DATA_QUERY,
					new Object[] { streetVendorData.getCovNo(), streetVendorData.getCovNo(),
							streetVendorData.getVendorName(), streetVendorData.getVendorName(),
							streetVendorData.getCategory(), streetVendorData.getCategory() },
					streetVendorRowMapper);
		} catch (Exception e) {
			e.printStackTrace();
			throw new CustomException("Exception", e.getMessage());
		}

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

}
