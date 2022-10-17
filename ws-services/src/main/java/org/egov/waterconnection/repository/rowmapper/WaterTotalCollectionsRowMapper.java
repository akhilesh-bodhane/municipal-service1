package org.egov.waterconnection.repository.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.egov.waterconnection.model.AuditDetails;
import org.egov.waterconnection.model.WaterTotalCollections;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

@Component
public class WaterTotalCollectionsRowMapper implements ResultSetExtractor<List<WaterTotalCollections>> {

	@Override
	public List<WaterTotalCollections> extractData(ResultSet rs) throws SQLException, DataAccessException {
		//Map<String, WaterTotalCollections> connectionListMap = new HashMap<>();
		
		List<WaterTotalCollections> currentWaterConnection = new ArrayList<>();
		
		while (rs.next()) {
			//String applicationNo = rs.getString("connection_Id");
			
			WaterTotalCollections watertotalcollections = new WaterTotalCollections();
			
			watertotalcollections = watertotalcollections.builder().build();
			
			
			watertotalcollections.setTotatconnections(rs.getString("totatconnections"));
			
			watertotalcollections.setTotalcollections(rs.getString("totalcollections"));
				
			/*
			 * AuditDetails auditdetails = AuditDetails.builder()
			 * .createdBy(rs.getString("ws_createdBy"))
			 * .createdTime(rs.getLong("ws_createdTime"))
			 * .lastModifiedBy(rs.getString("ws_lastModifiedBy"))
			 * .lastModifiedTime(rs.getLong("ws_lastModifiedTime")) .build();
			 * watertotalcollections.setAuditDetails(auditdetails);
			 */
							 
				//connectionListMap.put(applicationNo, watertotalcollections);
				currentWaterConnection.add(watertotalcollections);
		
		}
		return currentWaterConnection;
	}

}
