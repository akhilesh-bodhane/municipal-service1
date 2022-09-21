package org.egov.waterconnection.repository.rowmapper;

import org.apache.commons.lang3.StringUtils;
import org.egov.waterconnection.constants.WCConstants;
import org.egov.waterconnection.model.*;
import org.egov.waterconnection.model.Connection.StatusEnum;
import org.egov.waterconnection.model.enums.Status;
import org.egov.waterconnection.model.workflow.ProcessInstance;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class WaterRowMapperCount implements ResultSetExtractor<List<WaterConnectionCount>> {

	@Override
	public List<WaterConnectionCount> extractData(ResultSet rs) throws SQLException, DataAccessException {
		Map<String, WaterConnectionCount> connectionListMap = new HashMap<>();
		WaterConnectionCount currentWaterConnection = new WaterConnectionCount();
		WaterApplicationList waterrAppList = new WaterApplicationList();
		
		while (rs.next()) {
			String applicationNo = rs.getString("connection_Id");

			if (connectionListMap.getOrDefault(applicationNo, null) == null) {
				currentWaterConnection = new WaterConnectionCount();
				currentWaterConnection.setConnectionType(rs.getString("connectionType"));
				currentWaterConnection.setPaymentDate(rs.getLong("paymentdate"));
				currentWaterConnection.setTotalAmountPaid(rs.getString("total_amount_paid"));
				currentWaterConnection.setApplicationStatus(rs.getString("applicationstatus"));
				currentWaterConnection.setPaymentMODE(rs.getString("paymentmode"));
                currentWaterConnection.setSubdiv(rs.getString("subdiv"));
				
				AuditDetails auditdetails = AuditDetails.builder()
	                        .createdBy(rs.getString("ws_createdBy"))
	                        .createdTime(rs.getLong("ws_createdTime"))
	                        .lastModifiedBy(rs.getString("ws_lastModifiedBy"))
	                        .lastModifiedTime(rs.getLong("ws_lastModifiedTime"))
	                        .build();
				 currentWaterConnection.setAuditDetails(auditdetails);
				 
				 
				 WaterApplicationList waterrAppListt =  WaterApplicationList.builder()
						 .applicationNo(rs.getString("app_applicationno"))
						 .applicationStatus(rs.getString("app_applicationstatus")).build();
				
//						 waterrAppList.setActivityType(rs.getString("app_applicationno"));
//				 waterrAppList.setApplicationStatus(rs.getString("app_applicationstatus"));
				 
				 currentWaterConnection.setWaterApplicationList(waterrAppListt);
				 
				 
				 
				connectionListMap.put(applicationNo, currentWaterConnection);
			}
		}
		return new ArrayList<>(connectionListMap.values());
	}

}
