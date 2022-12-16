package org.egov.ec.repository.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.egov.tracer.model.CustomException;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

@Component
public class ReceiptNoRowMapper  implements ResultSetExtractor<String> {
		
	
	@Override
	public String extractData(ResultSet rs) throws SQLException, DataAccessException {
		
		String getreceiptno ="";
		try {
			while (rs.next()) {
				getreceiptno=rs.getString("receiptnumber");
			}
		} catch (Exception e) {
			throw new CustomException("GET_VIOLATION_EXCEPTION", e.getMessage());
		}
		return getreceiptno;
	}

}
