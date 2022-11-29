package org.egov.integration.repository.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.egov.integration.model.UserCharges;
import org.egov.tracer.model.CustomException;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

@Component
public class UserChargesDataRowMapper implements ResultSetExtractor<List<UserCharges>> {

	@Override
	public List<UserCharges> extractData(ResultSet rs) throws SQLException, DataAccessException {
		Map<Integer, UserCharges> map = new HashMap<>();
		try {

			while (rs.next()) {

				UserCharges userCharges = new UserCharges();
				userCharges.setSequencenum(Integer.parseInt(rs.getString("sequencenum")));

				userCharges.setAllRecords(Integer.parseInt(rs.getString("allrecords")));
				userCharges.setTodaysCollections(Integer.parseInt(rs.getString("todayscollections")));
				userCharges.setIsChallan(Boolean.valueOf(rs.getString("ischallan").toString()));
				userCharges.setPaymentStatus(rs.getString("paymentstatus"));
				userCharges.setCategory(rs.getString("category"));
				userCharges.setPaymentMode(rs.getString("paymentmode"));

				map.put(userCharges.getSequencenum(), userCharges);

			}

			return map.entrySet().stream().map(Map.Entry::getValue).collect(Collectors.toList());

		} catch (Exception e) {
			throw new CustomException("GRIEVENCE ERROR", e.getMessage());
		}
	}
}
