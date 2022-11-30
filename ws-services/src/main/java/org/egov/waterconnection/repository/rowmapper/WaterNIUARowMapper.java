package org.egov.waterconnection.repository.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.egov.waterconnection.model.AuditDetails;
import org.egov.waterconnection.model.WaterTotalCollections;
import org.egov.waterconnection.model.buckets;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

@Component
public class WaterNIUARowMapper implements ResultSetExtractor<List<buckets>> {

	@Override
	public List<buckets> extractData(ResultSet rs) throws SQLException, DataAccessException {
		
		
		List<buckets> currentWaterConnection = new ArrayList<>();
		
		while (rs.next()) {
			
			buckets watertotalcollections = new buckets();
			
			watertotalcollections = watertotalcollections.builder().build();
			
			
			watertotalcollections.setName(rs.getString("name"));
			
			watertotalcollections.setValue(rs.getInt("value"));
			
				currentWaterConnection.add(watertotalcollections);
		
		}
		return currentWaterConnection;
	}

}
