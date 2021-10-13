package org.egov.pmcalculator.repository.rowmapper;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.SortedMap;
import java.util.TreeMap;

import org.json.simple.JSONObject;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class PriceBookRowMapper implements ResultSetExtractor<SortedMap<Integer, JSONObject>> {
	@Override
	public SortedMap<Integer, JSONObject> extractData(ResultSet rs) throws SQLException {
		SortedMap<Integer, JSONObject> map = new TreeMap<>();
		ResultSetMetaData rsmd = rs.getMetaData();
		while (rs.next()) {
			int numColumns = rsmd.getColumnCount();

			JSONObject obj = new JSONObject();
			Integer calculationSequence = null;
			for (int i = 1; i <= numColumns; i++) {
				String columnName = rsmd.getColumnName(i);
				if (!columnName.equalsIgnoreCase("calculation_sequence")) {
					obj.put(columnName, (rs.getObject(columnName) == null ? "" : rs.getObject(columnName).toString()));
				} else {
					calculationSequence = Integer
							.parseInt(rs.getObject(columnName) == null ? "0" : rs.getObject(columnName).toString());
				}
			}
			if (calculationSequence != null)
				map.put(calculationSequence, obj);
		}

		log.debug("converting map to list object ::: " + map);
		return map;
	}
}
