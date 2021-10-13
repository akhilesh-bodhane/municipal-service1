package org.egov.pgr.repository.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.egov.pgr.model.DiscriptionReport;
import org.egov.tracer.model.CustomException;
import org.json.simple.JSONArray;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class ColumnsRowMapper implements ResultSetExtractor<List<DiscriptionReport>> {
	@Override
	public List<DiscriptionReport> extractData(ResultSet rs) throws SQLException, DataAccessException {
		Map<String, DiscriptionReport> map = new HashMap<>();
		List<DiscriptionReport> list = new ArrayList<>();

		try {
			while (rs.next()) {
				String id = rs.getString("servicerequestid");
				
				if (!map.containsKey(id)) {
					
					DiscriptionReport master = DiscriptionReport.builder()
							.address(rs.getString("address"))
							.autoescalated(rs.getString("autoescalated"))
							.complaintNo(rs.getString("complaintno"))
							.complaintraisedby(rs.getString("complaintraisedby"))
							.date(rs.getString("date"))
							.description(rs.getString("description"))
							.landmark(rs.getString("landmark"))
							.name(rs.getString("name"))
							.status(rs.getString("status"))
							.lastactiondate(rs.getString("lastactiondate")).
							 lastassignedto(rs.getString("lastassignedto"))
							.locality(rs.getString("locality"))
							.phone(rs.getString("phone"))
							.servicerequestid(rs.getString("servicerequestid"))
							.servicecode(rs.getString("servicecode").replaceAll(" ", "_"))
							.slaHours(rs.getString("slahours"))
							.tenantid(rs.getString("tenantid"))
							.slaendtime(rs.getLong("slaendtime"))
							.source(rs.getString("source"))
							.createdtime(rs.getLong("createdtime"))
							.comments(rs.getString("comments"))
							.rating(rs.getString("rating"))
							.feedback(rs.getString("feedback"))
							.build();
					
					
					map.put(id, master);
					list.add(master);
				}
			}

		} catch (Exception e) {
			throw new CustomException("SCHEDULER_EXCEPTION", e.getMessage());
		}
		return list;
	}
}
