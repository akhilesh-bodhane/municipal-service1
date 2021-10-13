package org.egov.pgr.repository.rowmapper;

import static java.util.Objects.isNull;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.egov.pgr.model.AuditDetails;
import org.egov.pgr.model.AutoroutingMap;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class AutoRoutingMapRowmapper implements RowMapper<AutoroutingMap> {

    @Override
    public AutoroutingMap mapRow(final ResultSet rs, final int rowNum) throws SQLException {
    	AuditDetails auditDetails = populateAddress(rs);
        return AutoroutingMap.builder().id(rs.getString("id")).tenantId(rs.getString("tenantid"))
        		.autorouting(rs.getObject("autorouting")).active(rs.getBoolean("active"))
        		.auditDetails(auditDetails).build();
    }
    
    private AuditDetails populateAddress(ResultSet rs) throws SQLException {

    	AuditDetails auditDetails = AuditDetails.builder()
    			.createdBy(rs.getString("createdBy")).createdTime(rs.getLong("createdTime"))
                .lastModifiedBy(rs.getString("lastModifiedBy")).lastModifiedTime(rs.getLong("lastModifiedTime"))
                .build();
    	
        return auditDetails;
    }
}
