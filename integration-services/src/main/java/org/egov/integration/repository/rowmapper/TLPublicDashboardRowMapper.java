package org.egov.integration.repository.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.egov.integration.model.TLPublicDashboard;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

@Component
public class TLPublicDashboardRowMapper implements ResultSetExtractor<TLPublicDashboard> {

	public TLPublicDashboard extractData(ResultSet rs) throws SQLException, DataAccessException {

		TLPublicDashboard publicDashboard = null;
		while (rs.next()) {

			publicDashboard = TLPublicDashboard.builder().build();

			publicDashboard.setTotalApplicationsReceived(
					rs.getString("totalApplicationsReceived") != null ? rs.getString("totalApplicationsReceived")
							: "0");
			publicDashboard.setTotalApplicationsApproved(
					rs.getString("totalApplicationsApproved") != null ? rs.getString("totalApplicationsApproved")
							: "0");
			publicDashboard.setTimeTakenForApproval(
					rs.getString("timeTakenForApproval") != null ? rs.getString("timeTakenForApproval") : "0");
		}
		return publicDashboard;
	}
}
