
package org.egov.prscp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.egov.common.contract.response.ResponseInfo;
import org.egov.prscp.repository.EventPressMasterRepository;
import org.egov.prscp.util.CommonConstants;
import org.egov.prscp.util.PrScpUtil;
import org.egov.prscp.web.models.EventDetail;
import org.egov.prscp.web.models.PressMaster;
import org.egov.prscp.web.models.RequestInfoWrapper;
import org.egov.prscp.web.models.ResponseInfoWrapper;
import org.egov.tracer.model.CustomException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

@Service
public class EventPressMasterService {

	private final ObjectMapper objectMapper;

	private EventPressMasterRepository repository;
	
	private PrScpUtil prScpUtil;
	

	@Autowired
	public EventPressMasterService(EventPressMasterRepository repository, ObjectMapper objectMapper,PrScpUtil prScpUtil) {
		this.objectMapper = objectMapper;
		this.repository = repository;
		this.prScpUtil = prScpUtil;
	}
	/**
	 * Creates press master for the given criteria
	 * @param requestInfoWrapper to create press master 
	 * @return press master Response
	 */
	public ResponseEntity<ResponseInfoWrapper> createPress(RequestInfoWrapper requestInfoWrapper) {
		try {
			PressMaster pressMaster = objectMapper.convertValue(requestInfoWrapper.getRequestBody(), PressMaster.class);
			String responseValidate = "";
			
			Gson gson = new Gson();
			String payloadData = gson.toJson(pressMaster, PressMaster.class);
			
			responseValidate = prScpUtil.validateJsonAddUpdateData(payloadData,CommonConstants.PRESSMASTERCREATE);
			if (responseValidate.equals("")) 
			{
			
				pressMaster.setActive(true);
				pressMaster.setCreatedBy(requestInfoWrapper.getAuditDetails().getCreatedBy());
				pressMaster.setCreatedTime(requestInfoWrapper.getAuditDetails().getCreatedTime());
				pressMaster.setLastModifiedBy(requestInfoWrapper.getAuditDetails().getLastModifiedBy());
				pressMaster.setLastModifiedTime(requestInfoWrapper.getAuditDetails().getLastModifiedTime());
	
				String pressMasterUuid = UUID.randomUUID().toString();
				pressMaster.setPressMasterUuid(pressMasterUuid);
				repository.createPress(pressMaster);
	
				return new ResponseEntity<>(ResponseInfoWrapper.builder()
						.responseInfo(ResponseInfo.builder().status(CommonConstants.SUCCESS).build())
						.responseBody(pressMaster).build(), HttpStatus.CREATED);
			}
			else
			{
				throw new CustomException(CommonConstants.PRESS_MASTER_EXCEPTION_CODE, responseValidate);
			}
			

		} catch (Exception e) {
			throw new CustomException(CommonConstants.PRESS_MASTER_EXCEPTION_CODE, e.getMessage());
		}
	}

	/**
	 * update press master for the given criteria
	 * @param requestInfoWrapper to update press master 
	 * @return press master Response
	 */
	public ResponseEntity<ResponseInfoWrapper> updatePress(RequestInfoWrapper requestInfoWrapper) {
		try {
			PressMaster pressMaster = objectMapper.convertValue(requestInfoWrapper.getRequestBody(), PressMaster.class);
			String responseValidate = "";
			
			Gson gson = new Gson();
			String payloadData = gson.toJson(pressMaster, PressMaster.class);
			
			responseValidate = prScpUtil.validateJsonAddUpdateData(payloadData,CommonConstants.PRESSMASTERUPDATE);
			
			if (responseValidate.equals("")) 
			{
				pressMaster.setActive(true);
				pressMaster.setLastModifiedBy(requestInfoWrapper.getAuditDetails().getCreatedBy());
				pressMaster.setLastModifiedTime(requestInfoWrapper.getAuditDetails().getCreatedTime());
				pressMaster.setCreatedTime(requestInfoWrapper.getAuditDetails().getCreatedTime());
				
				repository.updatePress(pressMaster);
	
				return new ResponseEntity<>(ResponseInfoWrapper.builder()
						.responseInfo(ResponseInfo.builder().status(CommonConstants.SUCCESS).build())
						.responseBody(pressMaster).build(), HttpStatus.OK);
			}
			else
			{
				throw new CustomException(CommonConstants.PRESS_MASTER_EXCEPTION_CODE, responseValidate);
			}

		} catch (Exception e) {
			throw new CustomException(CommonConstants.PRESS_MASTER_EXCEPTION_CODE, e.getMessage());
		}
	}

	/**
	 * Get press master for the given criteria
	 * @param requestInfoWrapper to get press master 
	 * @return press master Response
	 */
	public ResponseEntity<ResponseInfoWrapper> getPress(RequestInfoWrapper requestInfoWrapper) {
		try {
			PressMaster pressMaster = objectMapper.convertValue(requestInfoWrapper.getRequestBody(), PressMaster.class);
			String responseValidate = "";
			
			Gson gson = new Gson();
			String payloadData = gson.toJson(pressMaster, PressMaster.class);
			
			responseValidate = prScpUtil.validateJsonAddUpdateData(payloadData,CommonConstants.PRESSMASTERGET);
			List<PressMaster> existingPress =new ArrayList<PressMaster>();
			if (responseValidate.equals("")) 
			{
				existingPress = repository.getPress(pressMaster);
				return new ResponseEntity<>(ResponseInfoWrapper.builder()
						.responseInfo(ResponseInfo.builder().status(CommonConstants.SUCCESS).build())
						.responseBody(existingPress).build(), HttpStatus.OK);
			}
			else
			{
				throw new CustomException(CommonConstants.PRESS_MASTER_EXCEPTION_CODE, responseValidate);
			}

		} catch (Exception e) {
			throw new CustomException(CommonConstants.PRESS_MASTER_EXCEPTION_CODE, e.getMessage());
		}
	}
	/**
	 * Delete press master for the given criteria
	 * @param requestInfoWrapper to Delete press master 
	 * @return press master Response
	 */
	public ResponseEntity<ResponseInfoWrapper> deletePress(RequestInfoWrapper requestInfoWrapper) {
		try {
			PressMaster pressMaster = objectMapper.convertValue(requestInfoWrapper.getRequestBody(), PressMaster.class);
			String responseValidate = "";
			
			Gson gson = new Gson();
			String payloadData = gson.toJson(pressMaster, PressMaster.class);
			
			responseValidate = prScpUtil.validateJsonAddUpdateData(payloadData,CommonConstants.PRESSMASTERDELETE);
			if (responseValidate.equals("")) 
			{
				pressMaster.setActive(false);
				pressMaster.setLastModifiedBy(requestInfoWrapper.getAuditDetails().getCreatedBy());
				pressMaster.setLastModifiedTime(requestInfoWrapper.getAuditDetails().getCreatedTime());
	
				repository.deletePress(pressMaster);
	
				return new ResponseEntity<>(ResponseInfoWrapper.builder()
						.responseInfo(ResponseInfo.builder().status(CommonConstants.SUCCESS).build())
						.responseBody(pressMaster).build(), HttpStatus.OK);
			}
			else
			{
				throw new CustomException(CommonConstants.PRESS_MASTER_EXCEPTION_CODE, responseValidate);
			}

		} catch (Exception e) {
			throw new CustomException(CommonConstants.PRESS_MASTER_EXCEPTION_CODE, e.getMessage());
		}
	}

}