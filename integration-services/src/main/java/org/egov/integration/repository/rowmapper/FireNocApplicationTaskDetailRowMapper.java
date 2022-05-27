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
import org.egov.integration.model.FireNocDaoApplicationTasks;
import org.egov.tracer.model.CustomException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

@Component
public class FireNocApplicationTaskDetailRowMapper implements ResultSetExtractor<List<FireNocDaoApplicationTasks>> {

	@Override
	public List<FireNocDaoApplicationTasks> extractData(ResultSet rs) throws SQLException, DataAccessException {
		Map<String, FireNocDaoApplicationTasks> map = new HashMap<>();
		List<FireNocDaoApplicationTasks> result = new ArrayList<>();
		JSONParser jsonParser = new JSONParser();
		AuditDetails auditDetails = AuditDetails.builder().build();
		try {
			while (rs.next()) {
				FireNocDaoApplicationTasks fireNocDaoApplicationTasks = new FireNocDaoApplicationTasks();

				fireNocDaoApplicationTasks.setAppTaskDetailUuid(rs.getString("app_task_detail_uuid"));
				fireNocDaoApplicationTasks.setApplicationId(rs.getString("application_id"));
				fireNocDaoApplicationTasks.setApplicationStatus(rs.getString("application_status"));

				fireNocDaoApplicationTasks.setActionTaken(rs.getString("action_taken"));
				fireNocDaoApplicationTasks.setExecutedTime(rs.getString("executed_time"));
				fireNocDaoApplicationTasks.setTaskId(rs.getString("task_id"));
				fireNocDaoApplicationTasks.setTaskName(rs.getString("task_name"));

				String jsonData1 = rs.getString("action_taken_user_detail");
				if (jsonData1 != null && !jsonData1.isEmpty()) {
					JSONObject parse = (JSONObject) jsonParser.parse(jsonData1);
					if (parse != null)
						fireNocDaoApplicationTasks.setActionTakenUserDetail(parse);
				}

				String jsonData2 = rs.getString("official_form_details");
				if (jsonData2 != null && !jsonData2.isEmpty()) {
					JSONObject parse = (JSONObject) jsonParser.parse(jsonData2);
					if (parse != null)
						fireNocDaoApplicationTasks.setOfficialFormDetails(parse);
				}

				auditDetails.setCreatedBy(rs.getString("created_by"));
				auditDetails.setCreatedTime(Long.parseLong(rs.getString("created_time")));
				auditDetails.setLastModifiedBy(rs.getString("last_modified_by"));
				auditDetails.setLastModifiedTime(Long.parseLong(rs.getString("last_modified_time")));
				fireNocDaoApplicationTasks.setAuditDetails(auditDetails);

				map.put(fireNocDaoApplicationTasks.getAppTaskDetailUuid(), fireNocDaoApplicationTasks);
			}
			result = map.entrySet().stream().map(Map.Entry::getValue).collect(Collectors.toList());

		} catch (Exception e) {
			throw new CustomException(CommonConstants.FIR_NOC_EXCEPTION_CODE, e.getMessage());
		}
		return result;
	}
}
