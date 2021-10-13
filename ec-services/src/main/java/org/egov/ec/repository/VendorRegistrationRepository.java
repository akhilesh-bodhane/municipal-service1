package org.egov.ec.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.egov.ec.config.EchallanConfiguration;
import org.egov.ec.producer.Producer;
import org.egov.ec.repository.builder.EcQueryBuilder;
import org.egov.ec.repository.rowmapper.ViolationDetailRowMapper;
import org.egov.ec.web.models.EcSearchCriteria;
import org.egov.ec.web.models.RequestInfoWrapper;
import org.egov.ec.web.models.VendorRegistration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class VendorRegistrationRepository {

	private JdbcTemplate jdbcTemplate;

	private Producer producer;

	private EchallanConfiguration config;
	

	@Autowired
	public NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	public VendorRegistrationRepository(JdbcTemplate jdbcTemplate, Producer producer, EchallanConfiguration config,
			ViolationDetailRowMapper rowMapper) {
		this.jdbcTemplate = jdbcTemplate;
		this.producer = producer;
		this.config = config;
	}
	
	/**
     * fetches the list of vendor details
     *
     * @param searchCriteria Search criteria to apply filter
     * @return Returns the list of vendor details
     */

	public List<VendorRegistration> getVendor(EcSearchCriteria searchCriteria) {
		log.info("VendorRegistration Repository - getVendor Method");
		List<VendorRegistration> vendor;
		Map<String, Object> paramValues = new HashMap<>();
		String parameter = "%" + searchCriteria.getSearchText() + "%";

		if (null != searchCriteria.getSearchText() && !searchCriteria.getSearchText().isEmpty() ) {

			vendor = jdbcTemplate.query(EcQueryBuilder.GET_VENDOR_DETAIL_SEARCH,
					new Object[] { parameter, parameter, parameter },
					new BeanPropertyRowMapper<VendorRegistration>(VendorRegistration.class));
			return vendor;
		} else {
			List<Object> covNo = new ArrayList<>();
			if(searchCriteria.getCovNo()!=null && !searchCriteria.getCovNo().isEmpty()) {
	        String[] values = searchCriteria.getCovNo().split(",");
			for (String sc:values ) {  
				covNo.add(sc);
			}
			paramValues.put("covNo", covNo);
			vendor = namedParameterJdbcTemplate.query(EcQueryBuilder.GET_VENDOR_DETAIL_COV, paramValues,
					new BeanPropertyRowMapper<VendorRegistration>(VendorRegistration.class));
			}
			else {
				vendor = namedParameterJdbcTemplate.query(EcQueryBuilder.GET_VENDOR_DETAIL, paramValues,
						new BeanPropertyRowMapper<VendorRegistration>(VendorRegistration.class));
			}
			
			return vendor;

		}

	}

	 /**
     * Pushes the request in createVendor topic to save vendor data 
     *
     * @param vendorRegistration VendorRegistration model
     */
	public void saveVendor(@Valid VendorRegistration vendorRegistration) {
		log.info("VendorRegistration Repository - saveVendor Method");
		RequestInfoWrapper infoWrapper = RequestInfoWrapper.builder().requestBody(vendorRegistration).build();
		producer.push(config.getCreateVendorTopic(), infoWrapper);

	}

	 /**
    * Pushes the request in updateVendor topic to update vendor data 
    *
    * @param vendorRegistration VendorRegistration model
    */
	public void updateVendor(@Valid VendorRegistration vendorRegistration) {
		log.info("VendorRegistration Repository - updateVendor Method");

		RequestInfoWrapper infoWrapper = RequestInfoWrapper.builder().requestBody(vendorRegistration).build();
		producer.push(config.getUpdateVendorTopic(), infoWrapper);

	}

}
