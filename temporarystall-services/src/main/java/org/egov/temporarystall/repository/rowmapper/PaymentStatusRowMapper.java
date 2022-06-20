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
public class PaymentStatusRowMapper  implements ResultSetExtractor<StallApplication> {
	
	@Autowired
	private ObjectMapper mapper;
	
	
	@Override
	public StallApplication extractData(ResultSet rs) throws SQLException, DataAccessException {
		Map<String, StallApplication> sepMap = new HashMap<>();
		
//		List<StallApplication> listSTALLApplication = new ArrayList<>();
		StallApplication stallapp = new StallApplication();
	
		while (rs.next()) {
				String id = rs.getString("id");
				
				
				stallapp = stallapp.builder().build();
				
					

					stallapp.setPaymentstatus(rs.getString("totalamountpaid"));

					
					
					sepMap.put(id, stallapp);
					
				}
		

		
		return stallapp;
	}

}
