package org.egov.swservice.repository.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.egov.swservice.model.SewerageTotalCollections;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

@Component
public class SewerageTotalCollectionsRowMapper implements ResultSetExtractor<List<SewerageTotalCollections>> {

	@Override
	public List<SewerageTotalCollections> extractData(ResultSet rs) throws SQLException, DataAccessException {
		//Map<String, WaterTotalCollections> connectionListMap = new HashMap<>();
		
		List<SewerageTotalCollections> currentsewerageConnection = new ArrayList<>();
		
		while (rs.next()) {
			//String applicationNo = rs.getString("connection_Id");
			
			SewerageTotalCollections seweragetotalcollections = new SewerageTotalCollections();
			
			seweragetotalcollections = seweragetotalcollections.builder().build();
			
			
			seweragetotalcollections.setTotatconnections(rs.getString("totatconnections"));
			
			seweragetotalcollections.setTotalcollections(rs.getString("totalcollections"));
				
			/*
			 * AuditDetails auditdetails = AuditDetails.builder()
			 * .createdBy(rs.getString("ws_createdBy"))
			 * .createdTime(rs.getLong("ws_createdTime"))
			 * .lastModifiedBy(rs.getString("ws_lastModifiedBy"))
			 * .lastModifiedTime(rs.getLong("ws_lastModifiedTime")) .build();
			 * watertotalcollections.setAuditDetails(auditdetails);
			 */
							 
				//connectionListMap.put(applicationNo, watertotalcollections);
			currentsewerageConnection.add(seweragetotalcollections);
		
		}
		return currentsewerageConnection;
	}

}
