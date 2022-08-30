package org.egov.swservice.repository.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.egov.swservice.model.AuditDetails;
import org.egov.swservice.model.Connection.StatusEnum;
import org.egov.swservice.model.ConnectionHolderInfo;
import org.egov.swservice.model.Document;
import org.egov.swservice.model.PlumberInfo;
import org.egov.swservice.model.Relationship;
import org.egov.swservice.model.SWProperty;
import org.egov.swservice.model.SewerageConnection;
import org.egov.swservice.model.SewerageConnectionCount;
import org.egov.swservice.model.Status;
import org.egov.swservice.model.workflow.ProcessInstance;
import org.egov.swservice.util.SWConstants;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

@Component
public class SewerageCountRowMapper implements ResultSetExtractor<List<SewerageConnectionCount>> {

	@Override
	public List<SewerageConnectionCount> extractData(ResultSet rs) throws SQLException, DataAccessException {
		Map<String, SewerageConnectionCount> connectionListMap = new HashMap<>();
		SewerageConnectionCount sewarageConnection = new SewerageConnectionCount();
		while (rs.next()) {
			String Id = rs.getString("connection_Id");
			if (connectionListMap.getOrDefault(Id, null) == null) {
				sewarageConnection = new SewerageConnectionCount();
				sewarageConnection.setApplicationStatus(rs.getString("applicationstatus"));
				sewarageConnection.setPaymentmode(rs.getString("paymentmode"));
				sewarageConnection.setTotalAmountPaid(rs.getString("total_amount_paid"));
				sewarageConnection.setSubdiv(rs.getString("subdiv"));
				AuditDetails auditdetails = AuditDetails.builder().createdBy(rs.getString("sw_createdBy"))
						.createdTime(rs.getLong("sw_createdTime")).lastModifiedBy(rs.getString("sw_lastModifiedBy"))
						.lastModifiedTime(rs.getLong("sw_lastModifiedTime")).build();
				sewarageConnection.setAuditDetails(auditdetails);

			}
			connectionListMap.put(Id, sewarageConnection);
		}
		return new ArrayList<>(connectionListMap.values());
	}


}
