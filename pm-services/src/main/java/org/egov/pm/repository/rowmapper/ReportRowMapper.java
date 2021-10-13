package org.egov.pm.repository.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.egov.pm.model.ReportModel;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class ReportRowMapper implements ResultSetExtractor<List<ReportModel>> {

	@Override
	public List<ReportModel> extractData(ResultSet rs) throws SQLException {
		List<ReportModel> reportModelList = new ArrayList<>();
		while (rs.next()) {
			ReportModel reportModel = ReportModel.builder().build();
			reportModel.setTenantId(rs.getString("tenantid"));
			reportModel.setApplicationType(rs.getString("application_type"));
			reportModel.setTotalAverage(rs.getString("totalaverage"));
			reportModel.setTotalAveragePending10DayasTo30Days(rs.getString("totalaveragepending10dayasto30days"));
			reportModel.setTotalAveragePendingGreaterThan30Days(rs.getString("totalaveragependinggreaterthan30days"));
			reportModelList.add(reportModel);
		}
		return reportModelList;
	}
}
