package org.egov.nulm.repository.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.egov.nulm.common.CommonConstants;
import org.egov.nulm.model.AuditDetails;
import org.egov.nulm.model.ApplicationCountt;
//import org.egov.nulm.model.ApplicationCount;
import org.egov.nulm.model.ApplicationCountt.StatusEnum;
import org.egov.nulm.model.SepApplicationDocument;
import org.egov.tracer.model.CustomException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class ApplicationCount implements ResultSetExtractor<List<ApplicationCountt>> {

	@Autowired
	private ObjectMapper mapper;

	@Override
	public List<ApplicationCountt> extractData(ResultSet rs) throws SQLException, DataAccessException {
		Map<String, ApplicationCountt> sepMap = new HashMap<>();
		
		List<ApplicationCountt> listSEPApplication = new ArrayList<>();

		try {
			while (rs.next()) {
				String id = rs.getString("application_uuid");
				ApplicationCountt sepapp = new ApplicationCountt();
				
//				sepapp = sepapp.builder().build();
				if (!sepMap.containsKey(id)) {
					AuditDetails audit = AuditDetails.builder().createdBy(rs.getString("created_by"))
							.createdTime(rs.getLong("created_time")).lastModifiedBy(rs.getString("last_modified_by"))
							.lastModifiedTime(rs.getLong("last_modified_time")).build();
					
					sepapp.setApplicationStatus(
							ApplicationCountt.StatusEnum.fromValue(rs.getString("application_status")));
					sepapp.setAuditDetails(audit);
					
										sepMap.put(id, sepapp);
					listSEPApplication.add(sepapp);
				}
			}

		} catch (Exception e) {
			throw new CustomException(CommonConstants.SEP_APPLICATION_EXCEPTION_CODE, e.getMessage());
		}
		return listSEPApplication;
	}

	

}
