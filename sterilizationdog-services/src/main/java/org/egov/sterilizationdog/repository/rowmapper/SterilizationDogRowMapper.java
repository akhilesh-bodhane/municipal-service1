package org.egov.sterilizationdog.repository.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.egov.sterilizationdog.common.CommonConstants;
import org.egov.sterilizationdog.model.AuditDetails;
import org.egov.sterilizationdog.model.SterilizationDogApplication;
import org.egov.sterilizationdog.model.SterilizationDogDocument;
import org.egov.tracer.model.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class SterilizationDogRowMapper  implements ResultSetExtractor<List<SterilizationDogApplication>> {
	
	@Autowired
	private ObjectMapper mapper;
	
	
	@Override
	public List<SterilizationDogApplication> extractData(ResultSet rs) throws SQLException, DataAccessException {
		Map<String, SterilizationDogApplication> sepMap = new HashMap<>();
		
		List<SterilizationDogApplication> listSterilizationDogApplication = new ArrayList<>();

		try {
			while (rs.next()) {
				String id = rs.getString("id");
				SterilizationDogApplication sterilizationDogapp = new SterilizationDogApplication();
				
				sterilizationDogapp = sterilizationDogapp.builder().build();
				if (!sepMap.containsKey(id)) {
					AuditDetails audit = AuditDetails.builder().createdBy(rs.getString("created_by"))
							.createdTime(rs.getLong("created_time")).lastModifiedBy(rs.getString("last_modified_by"))
							.lastModifiedTime(rs.getLong("last_modified_time")).build();
					sterilizationDogapp.setApplicationUuid(rs.getString("id"));
					sterilizationDogapp.setApplicationId(rs.getString("app_id"));
					sterilizationDogapp.setPicksector(rs.getString("pick_sector"));
					sterilizationDogapp.setPickgender(rs.getString("pick_gender"));
					sterilizationDogapp.setPickhouseno(rs.getString("pick_houseno"));
					sterilizationDogapp.setPicklatitude(rs.getString("pick_latitude"));
					sterilizationDogapp.setPicklongitude(rs.getString("picklongitutde"));
					sterilizationDogapp.setDogcolor(rs.getString("dog_color"));
					sterilizationDogapp.setPicktype(rs.getString("pick_type"));
					sterilizationDogapp.setTenantId(rs.getString("tenant_id"));
					
					sterilizationDogapp.setAuditDetails(audit);
					
					List<SterilizationDogDocument> documentAttachment = null;
					if (rs.getString("document") != null) {
						documentAttachment = Arrays
								.asList(mapper.readValue(rs.getString("document"), SterilizationDogDocument[].class));
					}
					sterilizationDogapp.setApplicationDocument(documentAttachment);

					sepMap.put(id, sterilizationDogapp);
					listSterilizationDogApplication.add(sterilizationDogapp);
				}
			}

		} catch (Exception e) {
			throw new CustomException(CommonConstants.STERILIZATION__DOG_APPLICATION_EXCEPTION_CODE, e.getMessage());
		}
		return listSterilizationDogApplication;
	}

}
