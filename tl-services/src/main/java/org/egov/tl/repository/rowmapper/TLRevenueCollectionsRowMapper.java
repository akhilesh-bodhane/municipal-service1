package org.egov.tl.repository.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.egov.tl.web.models.TLRevenueCollections;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

@Component
public class TLRevenueCollectionsRowMapper implements ResultSetExtractor<TLRevenueCollections> {

	public TLRevenueCollections extractData(ResultSet rs) throws SQLException, DataAccessException {

		TLRevenueCollections revenueCollections = TLRevenueCollections.builder().build();

		while (rs.next()) {
			String totalApplications = rs.getString("totalapplications");
			String totalCollections = rs.getString("totalcollections");
			revenueCollections.setTotalApplications(totalApplications);
			revenueCollections.setTotalCollections(totalCollections);
		}
		return revenueCollections;
	}

}
