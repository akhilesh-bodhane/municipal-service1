package org.egov.waterconnection.validator;


import java.util.HashMap;
import java.util.Map;

import org.egov.tracer.model.CustomException;
import org.egov.waterconnection.constants.WCConstants;
import org.egov.waterconnection.model.WaterConnection;
import org.egov.waterconnection.model.WaterConnectionRequest;
import org.egov.waterconnection.model.workflow.BusinessService;
import org.egov.waterconnection.service.CalculationService;
import org.egov.waterconnection.workflow.WorkflowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class ActionValidator {
	
	@Autowired
	private WorkflowService workflowService;

	/**
	 * Validate update request
	 * 
	 * @param request
	 * @param businessService
	 */
	public void validateUpdateRequest(WaterConnectionRequest request, BusinessService businessService, String applicationStatus) {
		validateDocumentsForUpdate(request);
		validateIds(request, businessService, applicationStatus);
		validateConnectionNoForRibbon(request);
	}

	/**
	 * Validate documents for water connection
	 * 
	 * @param request water connection request
	 */
	private void validateDocumentsForUpdate(WaterConnectionRequest request) {
		if (WCConstants.WS_NEWCONNECTION.equalsIgnoreCase(request.getWaterConnection().getActivityType())
				&& WCConstants.ACTION_INITIATE.equalsIgnoreCase(request.getWaterConnection().getProcessInstance().getAction())				
				&& request.getWaterConnection().getDocuments() != null) {
			throw new CustomException("INVALID STATUS",
					"Status cannot be INITIATE when application document are provided");
		}
	}
	
	/**
	 * Validate Id's if update is not in updateable state
	 * 
	 * @param request
	 * @param businessService
	 */
	private void validateIds(WaterConnectionRequest request, BusinessService businessService, String applicationStatus) {
		WaterConnection connection = request.getWaterConnection();
		Map<String, String> errorMap = new HashMap<>();
		//log.info("workflowService:"+workflowService+",applicationStatus:"+applicationStatus+",businessService:"+businessService);
		if (!workflowService.isStateUpdatable(applicationStatus, businessService)) {
			if (connection.getId() == null)
				errorMap.put("INVALID_UPDATE", "Id of waterConnection cannot be null");
			if (!CollectionUtils.isEmpty(connection.getDocuments())) {
				connection.getDocuments().forEach(document -> {
					if (document.getId() == null)
						errorMap.put("INVALID_UPDATE", "Id of document cannot be null");
				});
			}
		}
		if (!errorMap.isEmpty())
			throw new CustomException(errorMap);
	}
	
	
	//Validating length and Null for Conneciton Number
	private void validateConnectionNoForRibbon(WaterConnectionRequest request) {
		
	
		if ((
			(WCConstants.WS_NEWCONNECTION.equalsIgnoreCase(request.getWaterConnection().getActivityType())
				&& WCConstants.PENDING_FOR_CONNECTION_NUMBER_BY_SUPERINTENDENT.equalsIgnoreCase(request.getWaterConnection().getApplicationStatus()))||
				
			(WCConstants.WS_APPLY_FOR_TEMPORARY_CON_BILLING.equalsIgnoreCase(request.getWaterConnection().getActivityType())
					&& WCConstants.PENDING_FOR_CONNECTION_NUMBER_BY_SUPERINTENDENT.equalsIgnoreCase(request.getWaterConnection().getApplicationStatus())))){
			
			if((null==request.getWaterConnection().getConnectionNo())||(request.getWaterConnection().getConnectionNo().isEmpty())||
					(request.getWaterConnection().getConnectionNo().length()<WCConstants.MIN_LENGTH)) {
			throw new CustomException("Invalid Connection Number",
					"Connection Number Provided is Empty or length of the Connection Number is lesser than 14 characters ");
		}
			
		}
			
	}
}
