package org.egov.integration.repository.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.egov.integration.common.CommonConstants;
import org.egov.integration.model.AuditDetails;
import org.egov.integration.model.FireNoc;
import org.egov.tracer.model.CustomException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

@Component
public class FireNocApplicationDumpRowMapper implements ResultSetExtractor<List<FireNoc>> {

	@Override
	public List<FireNoc> extractData(ResultSet rs) throws SQLException, DataAccessException {
		Map<String, FireNoc> map = new HashMap<>();
		List<FireNoc> result = new ArrayList<FireNoc>();
		JSONParser jsonParser = new JSONParser();
		AuditDetails auditDetails = AuditDetails.builder().build();
		try {
			while (rs.next()) {
				FireNoc fireNoc = new FireNoc();
				fireNoc.setUuid(rs.getString("uuid"));
				String jsonData = rs.getString("data");
				if (jsonData != null && !jsonData.isEmpty()) {
					JSONObject parse = (JSONObject) jsonParser.parse(jsonData);
					if (parse != null)
						fireNoc.setData(parse);
				}

//				fireNoc.setIsActive(Boolean.parseBoolean(rs.getString("is_active")));

				auditDetails.setCreatedBy(rs.getString("created_by"));
				auditDetails.setCreatedTime(Long.parseLong(rs.getString("created_time")));
				auditDetails.setLastModifiedBy(rs.getString("last_modified_by"));
				auditDetails.setLastModifiedTime(Long.parseLong(rs.getString("last_modified_time")));
				fireNoc.setAuditDetails(auditDetails);
				map.put(fireNoc.getUuid(), fireNoc);

			}

			result = map.entrySet().stream().map(Map.Entry::getValue).collect(Collectors.toList());

		} catch (Exception e) {
			throw new CustomException(CommonConstants.FIR_NOC_EXCEPTION_CODE, e.getMessage());
		}
		return result;
	}
}
