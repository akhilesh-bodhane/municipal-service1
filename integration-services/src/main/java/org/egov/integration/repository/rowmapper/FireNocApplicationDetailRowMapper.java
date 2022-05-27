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
import org.egov.integration.model.FireNocDaoApplication;
import org.egov.tracer.model.CustomException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

@Component
public class FireNocApplicationDetailRowMapper implements ResultSetExtractor<List<FireNocDaoApplication>> {

	@Override
	public List<FireNocDaoApplication> extractData(ResultSet rs) throws SQLException, DataAccessException {
		Map<String, FireNocDaoApplication> map = new HashMap<>();
		List<FireNocDaoApplication> result = new ArrayList<>();
		JSONParser jsonParser = new JSONParser();
		AuditDetails auditDetails = AuditDetails.builder().build();
		try {

			while (rs.next()) {
				FireNocDaoApplication fireNocDaoApplication = new FireNocDaoApplication();

				fireNocDaoApplication.setAppDetailUuid(rs.getString("app_detail_uuid"));
				fireNocDaoApplication.setApplicationId(rs.getString("application_id"));
				fireNocDaoApplication.setApplicationRefNo(rs.getString("application_ref_no"));
				fireNocDaoApplication.setApplicationStatus(rs.getString("application_status"));
				fireNocDaoApplication.setDepartmentId(rs.getString("department_id"));
				fireNocDaoApplication.setDepartmentName(rs.getString("department_name"));
				fireNocDaoApplication.setServiceId(rs.getString("service_id"));
				fireNocDaoApplication.setServiceName(rs.getString("service_name"));
				fireNocDaoApplication.setSubmissionDate(rs.getString("submission_date"));
				fireNocDaoApplication.setSubmissionLocation(rs.getString("submission_location"));
				fireNocDaoApplication.setSubmissionMode(rs.getString("submission_mode"));
				fireNocDaoApplication.setTypeOfOccupancyUse(rs.getString("type_of_occupancy_use"));

				String jsonData = rs.getString("attribute_details");
				if (jsonData != null && !jsonData.isEmpty()) {
					JSONObject parse = (JSONObject) jsonParser.parse(jsonData);
					if (parse != null)
						fireNocDaoApplication.setAttributeDetails(parse);
				}

				auditDetails.setCreatedBy(rs.getString("created_by"));
				auditDetails.setCreatedTime(Long.parseLong(rs.getString("created_time")));
				auditDetails.setLastModifiedBy(rs.getString("last_modified_by"));
				auditDetails.setLastModifiedTime(Long.parseLong(rs.getString("last_modified_time")));
				fireNocDaoApplication.setAuditDetails(auditDetails);

				map.put(fireNocDaoApplication.getAppDetailUuid(), fireNocDaoApplication);

			}

			result = map.entrySet().stream().map(Map.Entry::getValue).collect(Collectors.toList());

		} catch (Exception e) {
			throw new CustomException(CommonConstants.FIR_NOC_EXCEPTION_CODE, e.getMessage());
		}
		return result;
	}
}
