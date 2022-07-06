package org.egov.sterilizationdog.repository;


import java.util.ArrayList;
import java.util.List;
import org.egov.sterilizationdog.config.SterilizationDogConfiguration;
import org.egov.sterilizationdog.model.SterilizationDogApplication;
import org.egov.sterilizationdog.model.SterilizationDogRequest;
import org.egov.sterilizationdog.producer.Producer;
import org.egov.sterilizationdog.repository.builder.SterilizationDogQueryBuilder;
import org.egov.sterilizationdog.repository.rowmapper.SterilizationDogRowMapper;
import org.egov.tracer.model.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class SterilizationDogRepository {
	
	private Producer producer;
	
	private SterilizationDogConfiguration config;
	
	private JdbcTemplate jdbcTemplate;
	
	
	private SterilizationDogRowMapper SterlizationDogRowMapper;
	
	
	
	@Autowired
	public SterilizationDogRepository(Producer producer, SterilizationDogConfiguration config,JdbcTemplate jdbcTemplate,SterilizationDogRowMapper SterlizationDogRowMapper ) {
		this.producer = producer;
		this.config = config;
		this.jdbcTemplate=jdbcTemplate;
		this.SterlizationDogRowMapper=SterlizationDogRowMapper;
	}
	
	public void createSterilizationDogApplication(SterilizationDogApplication sterilizationdogrequest) {
		SterilizationDogRequest infoWrapper = SterilizationDogRequest.builder().sterilizationdogApplicationRequest(sterilizationdogrequest).build();
		producer.push(config.getSterilizationDogApplicationSaveTopic(), infoWrapper);
	}
	
	
	public List<SterilizationDogApplication> getSterilizationDogApplication(SterilizationDogApplication stallApplication) {
		List<SterilizationDogApplication> sterilizationdog = new ArrayList<>();
		
		
		try {
			
			if(stallApplication.getFromDate() == null && stallApplication.getToDate() == null && stallApplication.getApplicationId() == null){
				
				return sterilizationdog = jdbcTemplate.query(SterilizationDogQueryBuilder.GET_STERILIZATION_DOG_APPLICATION_QUERY,
						new Object[] {											 		
									 }, SterlizationDogRowMapper);				
			}else {
				return sterilizationdog = jdbcTemplate.query(SterilizationDogQueryBuilder.GET_STERILIZATION_DOG_APPLICATION_ID_QUERY,
						new Object[] {  stallApplication.getApplicationId(), 
								        stallApplication.getApplicationId(),
								        stallApplication.getFromDate(),
								        stallApplication.getFromDate(),
								        stallApplication.getToDate(),
								        stallApplication.getToDate()
								        
									 }, SterlizationDogRowMapper);
			}
						
		} catch (Exception e) {
			e.printStackTrace();
			throw new CustomException("Exception",e.getMessage());
		}

	}
	
	public void updateSterilizationDogApplication(SterilizationDogApplication sterilizationdogrequest) {
		SterilizationDogRequest infoWrapper = SterilizationDogRequest.builder().sterilizationdogApplicationRequest(sterilizationdogrequest).build();
		producer.push(config.getSterilizationDogApplicationUpdateTopic(), infoWrapper);
		
	}
	
}
