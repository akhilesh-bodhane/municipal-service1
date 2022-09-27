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
import org.egov.nulm.model.SuhApplication;
import org.egov.nulm.model.SuhApplicationCount;
import org.egov.nulm.model.SuhFacilitiesDetails;
import org.egov.nulm.model.SuhRecordMaintenance;
import org.egov.nulm.model.SuhStaffMaintenance;
import org.egov.tracer.model.CustomException;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class SuhRowMapperCount implements ResultSetExtractor<List<SuhApplicationCount>> {

	@Autowired
	private ObjectMapper mapper;

	@Override
	public List<SuhApplicationCount> extractData(ResultSet rs) throws SQLException, DataAccessException {
		Map<String, SuhApplicationCount> suhMap = new HashMap<>();
		List<SuhApplicationCount> suhList = new ArrayList<>();
	
		try {
			while (rs.next()) {
				String id = rs.getString("suh_uuid");
				if (!suhMap.containsKey(id)) {
					AuditDetails audit = AuditDetails.builder().createdBy(rs.getString("created_by"))
							.createdTime(rs.getLong("created_time")).lastModifiedBy(rs.getString("last_modified_by"))
							.lastModifiedTime(rs.getLong("last_modified_time")).build();
					

					SuhApplicationCount suhapp = SuhApplicationCount.builder().auditDetails(audit)
							
							.applicationStatus(SuhApplicationCount.StatusEnum.fromValue(rs.getString("application_status")))
							.build();
					
					suhMap.put(id, suhapp);
					suhList.add(suhapp);
				}
			}

		} catch (Exception e) {
			throw new CustomException(CommonConstants.SUH_APPLICATION_EXCEPTION_CODE, e.getMessage());
		}
		return suhList;
	}

}
