package org.egov.integration.repository.rowmapper;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.egov.integration.model.Metrics;
import org.egov.integration.model.TLNIUAModel;
import org.egov.integration.model.applicationsMovedToday;
import org.egov.integration.model.buckets;
import org.egov.integration.model.TodaysCollection;
import org.egov.integration.model.todaysTradeLicenses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

//import static org.egov.tl.util.TLConstants.*;

@Component
public class TLRowMapperNIUAUpdated implements ResultSetExtractor<List<TLNIUAModel>> {

	public List<TLNIUAModel> extractData(ResultSet rs) throws SQLException, DataAccessException {

		List<TLNIUAModel> tlniuaModels = new ArrayList<TLNIUAModel>();

		while (rs.next()) {
			TLNIUAModel model = TLNIUAModel.builder().build();

			model.setTradeType(rs.getString("tradeType") != null ? rs.getString("tradeType") : "");
			model.setStatus(rs.getString("status") != null ? rs.getString("status") : "");
			model.setGateway(rs.getString("gateway") != null ? rs.getString("gateway") : "");

			model.setApplicationsMovedToday(Integer.parseInt(
					rs.getString("applicationsMovedToday") != null ? rs.getString("applicationsMovedToday") : "0"));
			model.setApprovedCompletionDaysLicense(
					Integer.parseInt(rs.getString("approvedCompletionDaysLicense") != null
							? rs.getString("approvedCompletionDaysLicense")
							: "0"));
			model.setApprovedLicense(
					Integer.parseInt(rs.getString("approvedLicense") != null ? rs.getString("approvedLicense") : "0"));
			model.setAvgDaysForApplicationApproval(
					Integer.parseInt(rs.getString("avgDaysForApplicationApproval") != null
							? rs.getString("avgDaysForApplicationApproval")
							: "0"));
			model.setTodaysApprovedApplications(Integer.parseInt(
					rs.getString("todaysApprovedApplications") != null ? rs.getString("todaysApprovedApplications")
							: "0"));
			model.setTodaysApprovedApplicationsWithinSLA(
					Integer.parseInt(rs.getString("todaysApprovedApplicationsWithinSLA") != null
							? rs.getString("todaysApprovedApplicationsWithinSLA")
							: "0"));
			model.setTodaysTradeLicenses(Integer
					.parseInt(rs.getString("todaysTradeLicenses") != null ? rs.getString("todaysTradeLicenses") : "0"));

			model.setTransactions(new Double(
					rs.getString("transactions") != null ? rs.getString("transactions") : "0"));
			model.setPenaltyAmount(
					new Double(rs.getString("penaltyAmount") != null ? rs.getString("penaltyAmount") : "0"));
			model.setTaxAmount(new Double(rs.getString("taxAmount") != null ? rs.getString("taxAmount") : "0"));
			model.setTodaysCollection(
					new Double(rs.getString("todaysCollection") != null ? rs.getString("todaysCollection") : "0"));

			tlniuaModels.add(model);
		}

		return tlniuaModels;

	}

}
