package org.egov.ec.repository;

import java.util.List;

import javax.validation.Valid;

import org.egov.ec.config.EchallanConfiguration;
import org.egov.ec.producer.Producer;
import org.egov.ec.repository.builder.EcQueryBuilder;
import org.egov.ec.web.models.EcPayment;
import org.egov.ec.web.models.EcSearchCriteria;
import org.egov.ec.web.models.Report;
import org.egov.ec.web.models.RequestInfoWrapper;
import org.egov.ec.web.models.StoreItemRegister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class StoreItemRegisterRepository {

	private JdbcTemplate jdbcTemplate;

	private Producer producer;

	private EchallanConfiguration config;
	
	@Autowired
	public StoreItemRegisterRepository(JdbcTemplate jdbcTemplate, Producer producer, 
			EchallanConfiguration config) {
		this.jdbcTemplate = jdbcTemplate;
		this.producer = producer;
		this.config = config;
	}

	 /**
     * Pushes the request in save store items Topic for storing seized items
     *
     * @param storeItemRegister storeItemRegister model
     */
	public void saveStoreItem(@Valid StoreItemRegister storeItemRegister) {
		log.info("StoreItemRegister Repository - saveStoreItem Method");
		RequestInfoWrapper infoWrapper = RequestInfoWrapper.builder().requestBody(storeItemRegister).build();
		producer.push(config.getCreateStoreItemTopic(), infoWrapper);
	}

	/**
     * fetches the list of items which are present in store  against challan
     *
     * @param searchCriteria Search criteria to apply filter
     * @return Returns the list of stored items detail which are present in store  against challan
     */
	public List<StoreItemRegister> getStoreItemRegister(EcSearchCriteria searchCriteria) {
		log.info("StoreItemRegister Repository - getStoreItemRegister Method");

		List<StoreItemRegister> storeItemMaster;
		
		String parameter = "%" + searchCriteria.getSearchText() + "%";

		if (null != searchCriteria.getSearchText() && !searchCriteria.getSearchText().isEmpty()) {

			storeItemMaster = jdbcTemplate.query(EcQueryBuilder.GET_STORE_ITEM_REGISTER_SEARCH,
					new Object[] { parameter, parameter, searchCriteria.getTenantId() },//rowMapper);
					new BeanPropertyRowMapper<StoreItemRegister>(StoreItemRegister.class));
			return storeItemMaster;

		} else {
			storeItemMaster = jdbcTemplate.query(EcQueryBuilder.GET_STORE_ITEM_REGISTER,
					new Object[] { searchCriteria.getTenantId() },//rowMapper);
					new BeanPropertyRowMapper<StoreItemRegister>(StoreItemRegister.class));
			return storeItemMaster;

		}
	}

	 /**
     * Pushes the request in save store items Topic for storing seized items
     *
     * @param storeItemRegister storeItemRegister model
     */
	public void updateStoreItem(@Valid StoreItemRegister storeItemRegister) {
		log.info("StoreItemRegister Repository - updateStoreItem Method");
		RequestInfoWrapper infoWrapper = RequestInfoWrapper.builder().requestBody(storeItemRegister).build();
		producer.push(config.getUpdateStoreItemTopic(), infoWrapper);
	}

	
	 /**
     * Pushes the request in updatestoreOfflineTopicTopic to update offline payment
     *
     * @param model EcPayment model
     */
	public void updateStorePayment(@Valid EcPayment ecPayment) {
		log.info("StoreItemRegister Repository - updateStorePayment Method");
		RequestInfoWrapper infoWrapper = RequestInfoWrapper.builder().requestBody(ecPayment).build();
		producer.push(config.getUpdateStoreItemOfflineTopic(), infoWrapper);

	}

	/**
     * fetches the list of items which are Eligible for auction to notify ChallanSM
     *
     * @param 
     * @return Returns the list of stored items detail which are eligible for auction
     */
	public List<Report> getStoreAuctionItem(String tenantId) {
		log.info("StoreItemRegister Repository - getStoreAuctionItem Method");
		List<Report> storeItemMaster;

		storeItemMaster = jdbcTemplate.query(EcQueryBuilder.GET_STORE_AUCTION_ITEM, new Object[] {tenantId},
				new BeanPropertyRowMapper<Report>(Report.class));
		return storeItemMaster;

	}

	/*public List<StoreItemRegister> getStoreItemRegisterForHOD(EcSearchCriteria searchCriteria) {
		
		List<StoreItemRegister> storeItemMaster;
		storeItemMaster = jdbcTemplate.query(EcQueryBuilder.GET_STORE_ITEM_REGISTER_HOD,
				new Object[] { searchCriteria.getTenantId() },
				new BeanPropertyRowMapper<StoreItemRegister>(StoreItemRegister.class));
		return storeItemMaster;
		
	}*/

}
