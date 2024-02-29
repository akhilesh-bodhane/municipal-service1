package org.egov.pgr.repository.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.egov.pgr.model.IUDXResponse;
import org.egov.pgr.model.Location;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

@Component
public class IUDXRowMapper implements ResultSetExtractor<List<IUDXResponse>> {

	List<IUDXResponse> list = new ArrayList<IUDXResponse>();

	@Override
	public List<IUDXResponse> extractData(ResultSet rs) throws SQLException {
		while (rs.next()) {
			list.add(IUDXResponse.builder().category(rs.getString("category") != null ? rs.getString("category") : "")
					.department(rs.getString("department") != null ? rs.getString("department") : "")
					.description(rs.getString("description") != null ? rs.getString("description") : "")
					.address(rs.getString("address") != null ? rs.getString("address") : "")
					.location(Location.builder().type("Location")
							.coordinates(Arrays.asList(rs.getString("latitude") != null ? rs.getString("latitude") : "",
									rs.getString("longitude") != null ? rs.getString("longitude") : ""))
							.build())
					.media(null)
					.observationDateTime(
							rs.getString("lastmodifiedtime") != null ? rs.getString("lastmodifiedtime") : "")
					.reportID(rs.getString("servicerequestid") != null ? rs.getString("servicerequestid") : "")
					.reportingMode(rs.getString("source") != null ? rs.getString("source") : "")
					.status(rs.getString("status") != null ? rs.getString("status") : "")
					.wardName(rs.getString("locality") != null ? rs.getString("locality") : "").build());
		}
		return list;
	}
}
