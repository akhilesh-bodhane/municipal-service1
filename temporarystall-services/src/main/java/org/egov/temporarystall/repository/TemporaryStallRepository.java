package org.egov.temporarystall.repository;


import java.util.ArrayList;
import java.util.List;

import org.egov.temporarystall.config.StallConfiguration;
import org.egov.temporarystall.model.StallApplication;
import org.egov.temporarystall.model.StallRequest;
import org.egov.temporarystall.model.demand.DemandDetail;
import org.egov.temporarystall.producer.Producer;
import org.egov.temporarystall.repository.builder.STALLQueryBuilder;
import org.egov.temporarystall.repository.rowmapper.DemandDetailRowMapper;
import org.egov.temporarystall.repository.rowmapper.DemandRowMapper;
import org.egov.temporarystall.repository.rowmapper.PaymentStatusRowMapper;
import org.egov.temporarystall.repository.rowmapper.STALLRowMapper;
import org.egov.tracer.model.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TemporaryStallRepository {
	
	private Producer producer;
	
	private StallConfiguration config;
	
	private JdbcTemplate jdbcTemplate;
	
	private STALLRowMapper tempstallRowMapper;
	
	@Autowired
	private DemandRowMapper demandRowMapper;
	
	
	@Autowired
	private DemandDetailRowMapper demandDetailRowMapper;

	
	@Autowired
	private PaymentStatusRowMapper paymentStatusRowMapper;
	
	@Autowired
	public TemporaryStallRepository(Producer producer, StallConfiguration config,JdbcTemplate jdbcTemplate,STALLRowMapper tempstallRowMapper) {
		this.producer = producer;
		this.config = config;
		this.jdbcTemplate=jdbcTemplate;
		this.tempstallRowMapper=tempstallRowMapper;
	}
	
	public void createSTALLApplication(StallApplication stallApplication) {
		StallRequest infoWrapper = StallRequest.builder().stallApplicationRequest(stallApplication).build();
		producer.push(config.getSTALLApplicationSaveTopic(), infoWrapper);
	}
	
	
	
	public List<StallApplication> getStallApplication(StallApplication stallApplication) {
		List<StallApplication> stall = new ArrayList<>();
		
		
		try {
			return stall = jdbcTemplate.query(STALLQueryBuilder.GET_STALL_APPLICATION_QUERY,
					new Object[] {  stallApplication.getApplicationId(), 
							        stallApplication.getApplicationId(), 				
							        stallApplication.getMobileno(), 
							        stallApplication.getMobileno()			
								 }, tempstallRowMapper);
		} catch (Exception e) {
			e.printStackTrace();
			throw new CustomException("Exception",e.getMessage());
		}

	}
	
	public StallApplication getStallDemand(StallApplication stallApplication) {
		StallApplication stall = new StallApplication();
		
		
		
			return jdbcTemplate.query(STALLQueryBuilder.GET_STALL_DEMAND_QUERY,
					new Object[] {  stallApplication.getApplicationId(), 
							        stallApplication.getApplicationId()				
							        		
								 }, demandRowMapper);
		
	}
	
	public StallApplication getStallDemandDetailId(StallApplication stallApplication) {
		StallApplication stall = new StallApplication();
		
		
		
			return jdbcTemplate.query(STALLQueryBuilder.GET_STALL_DEMAND_DETAIL_QUERY,
					new Object[] {  stallApplication.getApplicationId(), 
							        stallApplication.getApplicationId()				
							        		
								 }, demandDetailRowMapper);
		
	}
	
	public StallApplication getStallPaymentStatus(StallApplication stallApplication) {
		StallApplication stall = new StallApplication();
		
		
		
			return jdbcTemplate.query(STALLQueryBuilder.GET_STALL_PAYMENT_STATUS_QUERY,
					new Object[] {  stallApplication.getApplicationId(), 
							        stallApplication.getApplicationId()				
							        		
								 }, paymentStatusRowMapper);
		
	}
	
	public StringBuilder getBillingUpdateUrl() {
		return new StringBuilder().append(config.getBillingHost()).append(config.getBillingUpdateUrl());
	}
	
	public void updateSTALLApplication(StallApplication stallApplication) {
		StallRequest infoWrapper = StallRequest.builder().stallApplicationRequest(stallApplication).build();
		producer.push(config.getSTALLApplicationUpdateTopic(), infoWrapper);
		
	}
	
	 
	
	public StringBuilder searchcollectionpaymentstatus() {
		return new StringBuilder().append(config.getCollectionSearcheUrl()).append(config.getCollectionHostSerach());
	}

}
