package org.egov.integration.repository.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

@Component
public class IdleKillConnectionsRowMapper implements ResultSetExtractor<String> {

	@Override
	public String extractData(ResultSet rs) throws SQLException, DataAccessException {
		
		String idlekillConnections= "";
		
		while (rs.next()) {
			
			idlekillConnections=rs.getString("idlekillconnections");
		
		}
		return idlekillConnections;
	}

}
