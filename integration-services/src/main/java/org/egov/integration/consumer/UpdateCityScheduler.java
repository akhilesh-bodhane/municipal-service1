package org.egov.integration.consumer;

import java.util.ArrayList;
import java.util.List;

import org.egov.integration.repository.builder.QueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class UpdateCityScheduler {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private QueryBuilder QueryBuilder;
	
	
	@Scheduled(cron = "0 */5 * * * *", zone = "Asia/Calcutta")
	public void updateCity() {
		System.out.println("updateCity Cro Started");
				
		try {
			
			int updateCitycount = updateCityCount();
			System.out.println("updateCitycount :"+updateCitycount);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public int updateCityCount() {
		List<Object> preparedStatement = new ArrayList<>();
		
		String query = QueryBuilder.updatecity(preparedStatement);
				
		int updatecity = jdbcTemplate.update(query);

		return updatecity;
	}

}
