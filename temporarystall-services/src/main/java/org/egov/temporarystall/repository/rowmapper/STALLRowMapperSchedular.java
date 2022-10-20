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
import org.egov.temporarystall.model.StallApplicationSchedular;
import org.egov.tracer.model.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class STALLRowMapperSchedular  implements ResultSetExtractor<List<StallApplicationSchedular>> {
	
	@Autowired
	private ObjectMapper mapper;
	
	
	@Override
	public List<StallApplicationSchedular> extractData(ResultSet rs) throws SQLException, DataAccessException {
		Map<String, StallApplicationSchedular> sepMap = new HashMap<>();
		
		List<StallApplicationSchedular> listSTALLApplication = new ArrayList<>();

		try {
			while (rs.next()) {
				String id = rs.getString("id");
				StallApplicationSchedular stallapp = new StallApplicationSchedular();
				
				stallapp = stallapp.builder().build();
				if (!sepMap.containsKey(id)) {
					
					stallapp.setApplicationId(rs.getString("applicationn_id"));
					
					stallapp.setPaymentstatus(rs.getString("paymentstatus"));
					
					stallapp.setApplicationstatus(rs.getString("application_status"));
					

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
