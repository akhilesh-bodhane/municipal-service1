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
import org.egov.temporarystall.model.demand.DemandDetail;
import org.egov.tracer.model.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class DemandDetailRowMapper  implements ResultSetExtractor<List<DemandDetail>> {
	
	@Autowired
	private ObjectMapper mapper;
	
	
	@Override
	public List<DemandDetail> extractData(ResultSet rs) throws SQLException, DataAccessException {
		Map<String, DemandDetail> sepMap = new HashMap<>();
		
		List<DemandDetail> listSTALLApplication = new ArrayList<>();
		DemandDetail stallapp = new DemandDetail();
	
		while (rs.next()) {
				String id = rs.getString("id");
				
				
				stallapp = stallapp.builder().build();
				if (!sepMap.containsKey(id)) {
					
					stallapp.setId(rs.getString("id"));
					
					stallapp.setTaxHeadMasterCode(rs.getString("taxheadcode"));
					
					

					
					
					sepMap.put(id, stallapp);
					
					listSTALLApplication.add(stallapp);
					
				}
		}

		
		return listSTALLApplication;
	}

}
