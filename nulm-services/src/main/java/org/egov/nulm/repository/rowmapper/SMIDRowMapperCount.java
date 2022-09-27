package org.egov.nulm.repository.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.egov.nulm.common.CommonConstants;
import org.egov.nulm.model.AuditDetails;
import org.egov.nulm.model.SmidApplication;
import org.egov.nulm.model.SmidApplicationCount;
import org.egov.tracer.model.CustomException;
import org.json.simple.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class SMIDRowMapperCount implements ResultSetExtractor<List<SmidApplicationCount>> {

	@Autowired
	private ObjectMapper mapper;

	@Override
	public List<SmidApplicationCount> extractData(ResultSet rs) throws SQLException, DataAccessException {
		Map<String, SmidApplicationCount> smidMap = new HashMap<>();
		List<SmidApplicationCount> listSMIDApplication = new ArrayList<>();

		try {
			while (rs.next()) {
				String id = rs.getString("application_uuid");
				new SmidApplication();

				if (!smidMap.containsKey(id)) {
					AuditDetails audit = AuditDetails.builder().createdBy(rs.getString("created_by"))
							.createdTime(rs.getLong("created_time")).lastModifiedBy(rs.getString("last_modified_by"))
							.lastModifiedTime(rs.getLong("last_modified_time")).build();

					SmidApplicationCount smidapp = SmidApplicationCount.builder().auditDetails(audit)
							
							.applicationStatus(SmidApplicationCount.StatusEnum.fromValue(rs.getString("application_status")))
							.build();
					smidMap.put(id, smidapp);
					listSMIDApplication.add(smidapp);
				}
			}

		} catch (Exception e) {
			throw new CustomException(CommonConstants.SMID_APPLICATION_EXCEPTION_CODE, e.getMessage());
		}
		return listSMIDApplication;
	}

}
