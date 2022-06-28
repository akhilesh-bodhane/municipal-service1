package org.egov.temporarystall.repository.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.egov.temporarystall.common.CommonConstants;
import org.egov.temporarystall.model.AuditDetails;
import org.egov.temporarystall.model.StallApplication;
import org.egov.temporarystall.model.StallApplicationDocument;
import org.egov.tracer.model.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class STALLRowMapper  implements ResultSetExtractor<List<StallApplication>> {
	
	@Autowired
	private ObjectMapper mapper;
	
	
	@Override
	public List<StallApplication> extractData(ResultSet rs) throws SQLException, DataAccessException {
		Map<String, StallApplication> sepMap = new HashMap<>();
		
		List<StallApplication> listSTALLApplication = new ArrayList<>();

		try {
			while (rs.next()) {
				String id = rs.getString("id");
				StallApplication stallapp = new StallApplication();
				
				stallapp = stallapp.builder().build();
				if (!sepMap.containsKey(id)) {
					AuditDetails audit = AuditDetails.builder().createdBy(rs.getString("created_by"))
							.createdTime(rs.getLong("created_time")).lastModifiedBy(rs.getString("last_modified_by"))
							.lastModifiedTime(rs.getLong("last_modified_time")).build();
					stallapp.setApplicationUuid(rs.getString("id"));
					stallapp.setApplicationId(rs.getString("applicationn_id"));
					stallapp.setName(rs.getString("name"));
					stallapp.setMobileno(rs.getString("mobile_no"));
					stallapp.setFestival(rs.getString("festival"));
					stallapp.setFromdate(rs.getString("from_date"));
					stallapp.setTodate(rs.getString("to_date"));
					stallapp.setSector(rs.getString("sector"));
					stallapp.setStallsize(rs.getString("stall_size"));
					stallapp.setAddress(rs.getString("address_details"));
					stallapp.setLandmark(rs.getString("landmark"));
					stallapp.setTenantId(rs.getString("tenant_id"));
					stallapp.setTotalamount(rs.getInt("total_amount"));					
					stallapp.setIsActive(rs.getBoolean("is_active"));
					stallapp.setNoofdays(rs.getInt("no_o_days"));
					stallapp.setFeesperday(rs.getInt("fees_per_day"));
					stallapp.setApplicationstatus(rs.getString("application_status"));
					stallapp.setAmount(rs.getInt("main_amount"));
					stallapp.setGstamount(rs.getInt("gst_amont"));
					stallapp.setNomineename(rs.getString("nominee_name"));
					stallapp.setRelation(rs.getString("relation"));
					stallapp.setAuditDetails(audit);

					List<StallApplicationDocument> documentAttachment = null;
					if (rs.getString("document") != null) {
						documentAttachment = Arrays
								.asList(mapper.readValue(rs.getString("document"), StallApplicationDocument[].class));
					}
					stallapp.setApplicationDocument(documentAttachment);
					sepMap.put(id, stallapp);
					listSTALLApplication.add(stallapp);
				}
			}

		} catch (Exception e) {
			throw new CustomException(CommonConstants.STALL_APPLICATION_EXCEPTION_CODE, e.getMessage());
		}
		return listSTALLApplication;
	}

}
