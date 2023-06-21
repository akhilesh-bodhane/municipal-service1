package org.egov.pgr.repository.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.egov.pgr.contract.IUDXData;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class IUDXDataRowMapper implements ResultSetExtractor<IUDXData> {

	@SuppressWarnings("unchecked")
	@Override
	public IUDXData extractData(ResultSet rs) throws SQLException {
		IUDXData iudxServiceData = IUDXData.builder().build();
		JSONObject jsonObject = new JSONObject();
		JSONParser jsonParser = new JSONParser();
		while (rs.next()) {
			String category = rs.getString("category") != null ? rs.getString("category") : "";
			String statusWiseCount = rs.getString("statusWiseCount") == null ? "" : rs.getString("statusWiseCount");

			if (category != null && !jsonObject.containsKey(category)) {
				Object parse = null;
				try {
					parse = jsonParser.parse(statusWiseCount);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				jsonObject.put(category, parse);
			}
		}
		iudxServiceData.setCategory(jsonObject);
		return iudxServiceData;
	}

}
