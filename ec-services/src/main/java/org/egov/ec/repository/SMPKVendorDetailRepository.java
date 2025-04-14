package org.egov.ec.repository;

import java.util.List;

import javax.validation.Valid;

import org.egov.ec.config.EchallanConfiguration;
import org.egov.ec.producer.Producer;
import org.egov.ec.repository.builder.EcQueryBuilder;
import org.egov.ec.web.models.ItemMaster;
import org.egov.ec.web.models.RequestInfoWrapper;
import org.egov.ec.web.models.SMPKVendorDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class SMPKVendorDetailRepository {

	private JdbcTemplate jdbcTemplate;

	private Producer producer;

	private EchallanConfiguration config;

	@Autowired
	public SMPKVendorDetailRepository(JdbcTemplate jdbcTemplate, Producer producer, EchallanConfiguration config) {
		this.jdbcTemplate = jdbcTemplate;
		this.producer = producer;
		this.config = config;
	}
	

	 /**
     * Pushes the request in update Item Topic for item master update
     *
     * @param spicVendorDetail SMPKVendorDetail Update request
     */
	public void ingestSpicVendorData(@Valid SMPKVendorDetail spicVendorData) {
		log.info("SpicVendorData Repository - ingestSpicVendorData Method");
		
		RequestInfoWrapper infoWrapper = RequestInfoWrapper.builder().requestBody(spicVendorData).build();
		producer.push(config.getSpicVendorDataIngestTopic(), infoWrapper);
	}
	
	
	public void ingestSpicVendorLogData(@Valid SMPKVendorDetail spicVendorData) {
		log.info("SpicVendorData Repository - ingestSpicVendorData Method");
		
		RequestInfoWrapper infoWrapper = RequestInfoWrapper.builder().requestBody(spicVendorData).build();
		producer.push(config.getSpicVendorDataIngestTopic(), infoWrapper);
	}
	
	
	public List<SMPKVendorDetail> getSpicVendorData(SMPKVendorDetail spicVendorData) {

		log.info("SMPKVendorDetail Repository - SPIC Vendor Data Ingest Method");
		List<SMPKVendorDetail> spicVendorDataList;

		spicVendorDataList = jdbcTemplate.query(EcQueryBuilder.GET_SPIC_VENDOR_DATA_MASTER,
				new Object[] { spicVendorData.getCovNo() },

				new BeanPropertyRowMapper<SMPKVendorDetail>(SMPKVendorDetail.class));

		return spicVendorDataList;

	}

}