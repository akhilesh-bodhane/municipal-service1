package org.egov.pgr.repository.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.egov.pgr.model.AuditDetails;
import org.egov.pgr.model.SwatchBharat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class SwatchBharatRowMapper implements ResultSetExtractor<List<SwatchBharat>> {

	@Autowired
	private ObjectMapper mapper;

	public List<SwatchBharat> extractData(ResultSet rs) throws SQLException, DataAccessException {

		Map<String, SwatchBharat> swatchBharatMap = new HashMap<>();

		while (rs.next()) {
			String id = rs.getString("uuid");
			SwatchBharat currentSwatchBharat = swatchBharatMap.get(id);

			if (currentSwatchBharat == null) {
				AuditDetails auditDetails = AuditDetails.builder()
						.createdBy(rs.getObject("createdby") != null ? rs.getObject("createdby").toString() : "")
						.createdTime(Long.parseLong(
								rs.getObject("createddate") != null ? rs.getObject("createddate").toString() : ""))
						.lastModifiedBy(rs.getObject("updatedby") != null ? rs.getObject("updatedby").toString() : "")
						.lastModifiedTime(Long.parseLong(
								rs.getObject("updateddate") != null ? rs.getObject("updateddate").toString() : ""))
						.build();

				currentSwatchBharat = SwatchBharat.builder().useruuid(rs.getObject("useruuid").toString())
						.fileid(rs.getObject("fileid").toString()).uuid(rs.getObject("uuid").toString())
						.isvalidimage(Boolean.parseBoolean(rs.getObject("isvalidimage").toString()))
						.auditDetails(auditDetails).build();
				swatchBharatMap.put(id, currentSwatchBharat);
			}
		}
		return new ArrayList<>(swatchBharatMap.values());
	}
}
