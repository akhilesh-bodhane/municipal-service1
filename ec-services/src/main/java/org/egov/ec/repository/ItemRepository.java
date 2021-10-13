package org.egov.ec.repository;

import java.util.List;

import javax.validation.Valid;

import org.egov.ec.config.EchallanConfiguration;
import org.egov.ec.producer.Producer;
import org.egov.ec.repository.builder.EcQueryBuilder;
import org.egov.ec.web.models.ItemMaster;
import org.egov.ec.web.models.RequestInfoWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class ItemRepository {

	private JdbcTemplate jdbcTemplate;

	private Producer producer;

	private EchallanConfiguration config;

	@Autowired
	public ItemRepository(JdbcTemplate jdbcTemplate, Producer producer, EchallanConfiguration config) {
		this.jdbcTemplate = jdbcTemplate;
		this.producer = producer;
		this.config = config;
	}
	 /**
     * Pushes the request in add Item Topic for item master update
     *
     * @param itemMaster ItemMaster add request
     */
	public void addItems(@Valid ItemMaster itemMaster) {
		log.info("ItemMaster Repository - addItems Method");
		RequestInfoWrapper infoWrapper = RequestInfoWrapper.builder().requestBody(itemMaster).build();
		producer.push(config.getItemMasterSaveTopic(), infoWrapper);

	}

	 /**
     * Pushes the request in update Item Topic for item master update
     *
     * @param itemMaster ItemMaster Update request
     */
	public void updateItem(@Valid ItemMaster itemMaster) {
		log.info("ItemMaster Repository - updateItem Method");
		RequestInfoWrapper infoWrapper = RequestInfoWrapper.builder().requestBody(itemMaster).build();
		producer.push(config.getItemMasterUpdateTopic(), infoWrapper);
	}

	/**
     * fetches the list of ItemMaster
     *
     * @param infoWrapper Requesttinforwrapper with requestinfo and request body
     * @return Returns the list of ItemMaster Details
     */
	public List<ItemMaster> getItem(RequestInfoWrapper itemMaster) {

		log.info("ItemMaster Repository - getItem Method");
		List<ItemMaster> masterItemList;

		masterItemList = jdbcTemplate.query(EcQueryBuilder.GET_ITEM_MASTER,
				new Object[] { itemMaster.getRequestInfo().getUserInfo().getTenantId() },

				new BeanPropertyRowMapper<ItemMaster>(ItemMaster.class));

		return masterItemList;

	}

}
