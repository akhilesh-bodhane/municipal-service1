package org.egov.waterconnection.repository.rowmapper;

import org.apache.commons.lang3.StringUtils;
import org.egov.waterconnection.constants.WCConstants;
import org.egov.waterconnection.model.*;
import org.egov.waterconnection.model.Connection.StatusEnum;
import org.egov.waterconnection.model.enums.Status;
import org.egov.waterconnection.model.workflow.ProcessInstance;
import org.springframework.dao.DataAccessException;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.threeten.bp.format.DateTimeFormatter;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class WaterGetAPIRowMapper implements ResultSetExtractor<List<WaterConnection>> {

	@Override
	public List<WaterConnection> extractData(ResultSet rs) throws SQLException, DataAccessException {
		Map<String, WaterConnection> connectionListMap = new HashMap<>();
		List<WaterConnection> currentWaterConnectionlist =new ArrayList<>();
		
		//DateTimeFormatter dt=DateTimeFormatter.ofPattern("dd/mm/yyy HH:mm:ss");
		LocalDateTime now=LocalDateTime.now();		
		System.out.println(now+" start while");
		while (rs.next()) {
			String applicationNo = rs.getString("connection_Id");

			/* if (connectionListMap.getOrDefault(applicationNo, null) == null) { */
			WaterConnection currentWaterConnection = new WaterConnection();
				currentWaterConnection.setTenantId(rs.getString("tenantid"));
				currentWaterConnection.setConnectionType(rs.getString("connectionType"));
				currentWaterConnection.setId(rs.getString("connection_Id"));
				//currentWaterConnection.setWaterSource(rs.getString("waterSource"));
//				
				currentWaterConnection.setApplicationNo(rs.getString("app_applicationno"));
				//currentWaterConnection.setApplicationStatus(rs.getString("applicationstatus"));
				
				//currentWaterConnection.setStatus(StatusEnum.fromValue(rs.getString("status")));
				currentWaterConnection.setConnectionNo(rs.getString("connectionNo"));
				//currentWaterConnection.setProposedPipeSize(rs.getString("proposedPipeSize"));
				//currentWaterConnection.setWaterApplicationType(rs.getString("waterApplicationType"));
				//currentWaterConnection.setInWorkflow(rs.getBoolean("inWorkflow"));
				currentWaterConnection.setActivityType(rs.getString("app_activitytype"));
				currentWaterConnection.setPropertyId(rs.getString("property_id"));
				//currentWaterConnection.setApplicationType(rs.getString("applicationType"));
				currentWaterConnection.setDiv(rs.getString("div"));
                currentWaterConnection.setSubdiv(rs.getString("subdiv"));
				 
				 String applicationId=rs.getString("application_id");
				if (!StringUtils.isEmpty(applicationId)) {
					WaterApplication app = new WaterApplication();
					app.setId(rs.getString("application_id"));
					app.setApplicationNo(rs.getString("app_applicationno"));
					app.setActivityType(rs.getString("app_activitytype"));
					app.setApplicationStatus(rs.getString("app_applicationstatus"));
					app.setTotalAmountPaid(rs.getString("paidamount"));
					//app.setAction(rs.getString("app_action"));
					//app.setComments(rs.getString("app_comments"));
				 
					currentWaterConnection.setWaterApplication(app);
				}
					
				String waterpropertyid=rs.getString("waterpropertyid");
				if (!StringUtils.isEmpty(waterpropertyid)) {
					WaterProperty property = new WaterProperty();
					property.setId(rs.getString("waterpropertyid"));
					//property.setUsageCategory(rs.getString("usagecategory"));
					//property.setUsageSubCategory(rs.getString("usagesubcategory"));

					property.setPlotNo(rs.getString("propertyplotno"));
					
					//property.setPloatAreaTT(rs.getString("ploatAreaTT"));

					property.setSectorNo(rs.getString("propertysectorno"));
					
					currentWaterConnection.setWaterProperty(property);
				}
				 
				connectionListMap.put(applicationNo, currentWaterConnection);
				
			/*}*/
			addChildrenToProperty(rs, currentWaterConnection);
			currentWaterConnectionlist.add(currentWaterConnection);
		}
		LocalDateTime now1=LocalDateTime.now();		
		System.out.println(now1+"  end while");
		return currentWaterConnectionlist;
	}


    private void addChildrenToProperty(ResultSet rs, WaterConnection waterConnection) throws SQLException {
        addHoldersDeatilsToWaterConnection(rs, waterConnection);
        addWaterApplicationList(rs, waterConnection);
    }

    private void addWaterApplicationList(ResultSet rs, WaterConnection waterConnection) throws SQLException {
    	 
		 String applicationId=rs.getString("application_id");
		if (!StringUtils.isEmpty(applicationId)) {
			WaterApplication app = new WaterApplication();
			app.setId(rs.getString("application_id"));
			app.setApplicationNo(rs.getString("app_applicationno"));
			app.setActivityType(rs.getString("app_activitytype"));
			app.setApplicationStatus(rs.getString("app_applicationstatus"));
			//app.setAction(rs.getString("app_action"));
			/*
			 * AuditDetails auditdetails1 = AuditDetails.builder()
			 * .createdBy(rs.getString("app_createdBy"))
			 * .createdTime(rs.getLong("app_createdTime"))
			 * .lastModifiedBy(rs.getString("app_lastModifiedBy"))
			 * .lastModifiedTime(rs.getLong("app_lastModifiedTime")) .build();
			 * app.setAuditDetails(auditdetails1);
			 */
		 
			waterConnection.addWaterApplication(app);
		}
    }


    private void addHoldersDeatilsToWaterConnection(ResultSet rs, WaterConnection waterConnection) throws SQLException {
        String uuid = rs.getString("userid");
        //String WSuuid = rs.getString("ws_application_id");
        List<ConnectionHolderInfo> connectionHolders = waterConnection.getConnectionHolders();

        //Commented for Connection Holder changes
		
		/*
		 * if (!CollectionUtils.isEmpty(connectionHolders)) { //
		 * System.out.println(connectionHolders.size()); for (ConnectionHolderInfo
		 * connectionHolderInfo : connectionHolders) {
		 * 
		 * if(!StringUtils.isEmpty(connectionHolderInfo.getUuid())
		 * &&!StringUtils.isEmpty(uuid) //&& connectionHolderInfo.getUuid().equals(uuid)
		 * ) { if (!StringUtils.isEmpty(connectionHolderInfo.getWs_application_id())
		 * &&!StringUtils.isEmpty(WSuuid) &&
		 * connectionHolderInfo.getWs_application_id().equals(WSuuid)) {
		 * 
		 * return; } }
		 * 
		 * } }
		 */
		 
        if(!StringUtils.isEmpty(uuid)){
			/*
			 * Double holderShipPercentage = rs.getDouble("holdershippercentage"); if
			 * (rs.wasNull()) { holderShipPercentage = null; } Boolean isPrimaryOwner =
			 * rs.getBoolean("isprimaryholder"); if (rs.wasNull()) { isPrimaryOwner = null;
			 * }
			 */
            ConnectionHolderInfo connectionHolderInfo = ConnectionHolderInfo.builder()
                    //.relationship(Relationship.fromValue(rs.getString("holderrelationship")))
                    //.status(org.egov.waterconnection.model.Status.fromValue(rs.getString("holderstatus")))
                    //.tenantId(rs.getString("holdertenantid"))
                    //.ownerType(rs.getString("connectionholdertype"))
                    //.isPrimaryOwner(isPrimaryOwner)
            		.uuid(uuid)
            		//.name(rs.getString("holdername"))
                    .correspondenceAddress(rs.getString("holdercorrepondanceaddress"))
                    //.proposedCorrespondanceAddress(rs.getString("proposedCorrespondanceAddress"))
                    //.proposedGender(rs.getString("proposedGender"))
                    //.proposedGuardianName(rs.getString("proposedGuardianName"))
                    //.proposedMobileNo(rs.getString("proposedMobileNo"))
                   // .proposedName(rs.getString("proposedName"))
                    //.ws_application_id(rs.getString("ws_application_id"))
                    //.lastModifiedDate(rs.getLong("holderlastmodifiedtime"))
                    .build();
            
            waterConnection.addConnectionHolderInfoForConnectionHolderChanges(connectionHolderInfo);
        }
    }
}
