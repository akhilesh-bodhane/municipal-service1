package org.egov.integration.repository.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.egov.integration.model.Metrics;
import org.egov.integration.model.TodaysCollection;
import org.egov.integration.model.applicationsMovedToday;
import org.egov.integration.model.buckets;
import org.egov.integration.model.todaysTradeLicenses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

//import static org.egov.tl.util.TLConstants.*;

@Component
public class TLRowMapperNIUA implements ResultSetExtractor<Metrics> {

	@Autowired
	private ObjectMapper mapper;

	public Metrics extractData(ResultSet rs) throws SQLException, DataAccessException {

		Metrics mtrcs = new Metrics();
		List<buckets> listBCKTttl = new ArrayList<>();
//    	todaysCollection
		List<buckets> listBCKTtc = new ArrayList<>();
//    	applicationsMovedToday
		List<buckets> listBCKTamt = new ArrayList<>();

		List<todaysTradeLicenses> listTTL = new ArrayList<todaysTradeLicenses>();
		List<TodaysCollection> listTC = new ArrayList<TodaysCollection>();
		List<applicationsMovedToday> listAMT = new ArrayList<applicationsMovedToday>();

		todaysTradeLicenses ttl = new todaysTradeLicenses();
		ttl.setGroupBy("status");
		TodaysCollection TC = new TodaysCollection();
		TC.setGroupBy("tradeType");
		applicationsMovedToday amt = new applicationsMovedToday();
		amt.setGroupBy("status");
//    	buckets bckt = new buckets();

		Integer approvedLicense = 0;
		Integer approvedCompletionDaysLicense = 0;
		Integer todaysApprovedApplicationsWithinSLA = 0;
		Integer avgDaysForApplicationApproval = 0;
		while (rs.next()) {

			approvedLicense = approvedLicense
					+ Integer.parseInt(rs.getString("approvedLicense") != null ? rs.getString("approvedLicense") : "0");
			approvedCompletionDaysLicense = approvedCompletionDaysLicense
					+ Integer.parseInt(rs.getString("approvedCompletionDaysLicense") != null
							? rs.getString("approvedCompletionDaysLicense")
							: "0");

//			todaysApprovedApplicationsWithinSLA = todaysApprovedApplicationsWithinSLA
//					+ Integer.parseInt(rs.getString("todaysApprovedApplicationsWithinSLA") != null
//							? rs.getString("todaysApprovedApplicationsWithinSLA")
//							: "0");
//			avgDaysForApplicationApproval = avgDaysForApplicationApproval
//					+ Integer.parseInt(rs.getString("avgDaysForApplicationApproval") != null
//							? rs.getString("avgDaysForApplicationApproval")
//							: "0");
//
//			String ccc = rs.getString("ccc");
//			String name = rs.getString("name");
//			int value = rs.getInt("value");
//			buckets bckt = new buckets();
//			if (ccc.equalsIgnoreCase("todaysTradeLicenses")) {
//
//				bckt.setName(name);
//				bckt.setValue(value);
//				listBCKTttl.add(bckt);
//
//			}
//
//			else if (ccc.equalsIgnoreCase("todaysCollection")) {
//
//				bckt.setName(name);
//				bckt.setValue(value);
//				listBCKTtc.add(bckt);
//
//			}
//
//			else if (ccc.equalsIgnoreCase("applicationsMovedToday")) {
//
//				bckt.setName(name);
//				bckt.setValue(value);
//				listBCKTamt.add(bckt);
//
//			}
//
//			else if (ccc.equalsIgnoreCase("transactions")) {
//				mtrcs.setTransactions(value);
//			} else if (ccc.equalsIgnoreCase("todaysApplications")) {
//				mtrcs.setTodaysApplications(value);
//
//			} else if (ccc.equalsIgnoreCase("tlTax")) {
//				mtrcs.setTlTax(value);
//			} else if (ccc.equalsIgnoreCase("adhocPenalty")) {
//				mtrcs.setAdhocPenalty(value);
//			} else if (ccc.equalsIgnoreCase("adhocRebate")) {
//				mtrcs.setAdhocRebate(value);
//			}
//
//			if (ccc.equalsIgnoreCase("todaysTradeLicenses")) {
//				ttl.setBuckets(listBCKTttl);
//
//			}
//
//			else if (ccc.equalsIgnoreCase("todaysCollection")) {
////				TC.setBuckets(listBCKTtc);
//
//			}
//
//			else if (ccc.equalsIgnoreCase("applicationsMovedToday")) {
//				amt.setBuckets(listBCKTamt);
//
//			}

		}
		mtrcs.setStipulatedDays(approvedLicense > 0 ? approvedCompletionDaysLicense / approvedLicense : 0);
		listTTL.add(ttl);
		mtrcs.setTodaysTradeLicenses(listTTL);
		listTC.add(TC);
		mtrcs.setTodaysCollection(listTC);
		listAMT.add(amt);
		mtrcs.setApplicationsMovedToday(listAMT);

		return mtrcs;

	}

}
