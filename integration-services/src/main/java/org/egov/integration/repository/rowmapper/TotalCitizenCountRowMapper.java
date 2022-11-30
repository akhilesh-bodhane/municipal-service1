package org.egov.integration.repository.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.egov.integration.model.CommonMetrics;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

@Component
public class TotalCitizenCountRowMapper implements ResultSetExtractor<List<CommonMetrics>> {

	@Override
	public List<CommonMetrics> extractData(ResultSet rs) throws SQLException, DataAccessException {
		//Map<String, WaterTotalCollections> connectionListMap = new HashMap<>();
				
		List<CommonMetrics> commonCollections = new ArrayList<>();
		
		while (rs.next()) {
			//String applicationNo = rs.getString("connection_Id");
			
			CommonMetrics commontotalcitizenscount = new CommonMetrics();
			
			commontotalcitizenscount = commontotalcitizenscount.builder().build();		
			
			commontotalcitizenscount.setTotalCitizensCount(rs.getInt("totalCitizensCount"));
				
			/*
			 * AuditDetails auditdetails = AuditDetails.builder()
			 * .createdBy(rs.getString("ws_createdBy"))
			 * .createdTime(rs.getLong("ws_createdTime"))
			 * .lastModifiedBy(rs.getString("ws_lastModifiedBy"))
			 * .lastModifiedTime(rs.getLong("ws_lastModifiedTime")) .build();
			 * watertotalcollections.setAuditDetails(auditdetails);
			 */
							 
				//connectionListMap.put(applicationNo, watertotalcollections);
			commonCollections.add(commontotalcitizenscount);
		
		}
		return commonCollections;
	}

}
