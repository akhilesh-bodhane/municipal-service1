package org.egov.nulm.repository.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.egov.nulm.common.CommonConstants;
import org.egov.nulm.model.AuditDetails;
import org.egov.nulm.model.SusvApplication;
import org.egov.nulm.model.SusvApplicationCount;
import org.egov.nulm.model.SusvApplicationDocument;
import org.egov.nulm.model.SusvApplicationFamilyDetails;
import org.egov.tracer.model.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class SusvRowMapperCount implements ResultSetExtractor<List<SusvApplicationCount>> {

	@Autowired
	private ObjectMapper mapper;

	@Override
	public List<SusvApplicationCount> extractData(ResultSet rs) throws SQLException, DataAccessException {
		Map<String, SusvApplicationCount> susvMap = new HashMap<>();
		List<SusvApplicationCount> susvList = new ArrayList<>();

		try {
			while (rs.next()) {
				String id = rs.getString("application_uuid");
				
				if (!susvMap.containsKey(id)) {
					AuditDetails audit = AuditDetails.builder().createdBy(rs.getString("created_by"))
							.createdTime(rs.getLong("created_time")).lastModifiedBy(rs.getString("last_modified_by"))
							.lastModifiedTime(rs.getLong("last_modified_time")).build();
					
					
					SusvApplicationCount susvapp = SusvApplicationCount.builder().auditDetails(audit)
							.applicationStatus(SusvApplicationCount.StatusEnum.fromValue(rs.getString("application_status")))
							.build();
					susvMap.put(id, susvapp);
					susvList.add(susvapp);
				}
			}

		} catch (Exception e) {
			throw new CustomException(CommonConstants.SUSV_APPLICATION_EXCEPTION_CODE, e.getMessage());
		}
		return susvList;
	}

}
