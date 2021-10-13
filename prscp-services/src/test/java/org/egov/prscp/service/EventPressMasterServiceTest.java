package org.egov.prscp.service;

import java.util.ArrayList;

import org.egov.prscp.repository.EventPressMasterRepository;
import org.egov.prscp.util.CommonConstants;
import org.egov.prscp.util.PrScpUtil;
import org.egov.prscp.web.models.AuditDetails;
import org.egov.prscp.web.models.InviteGuest;
import org.egov.prscp.web.models.PressMaster;
import org.egov.prscp.web.models.RequestInfoWrapper;
import org.egov.prscp.web.models.Template;
import org.egov.tracer.model.CustomException;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

@RunWith(MockitoJUnitRunner.class)
public class EventPressMasterServiceTest {

	@Mock
	private ObjectMapper objectMapper;

	@Mock
	private EventPressMasterRepository repository;

	@InjectMocks
	private EventPressMasterService eventPressMasterService;
	
	@Mock
	private PrScpUtil prScpUtil;
	

	@Test
	public void testCreatePress() throws ParseException {

		PressMaster pressMaster = PressMaster.builder().personnelName("Test").build();
		AuditDetails auditDetails = AuditDetails.builder().createdBy("1").createdTime(1546515646L).lastModifiedBy("1")
				.lastModifiedTime(15645455L).build();
		RequestInfoWrapper infoWrapper = RequestInfoWrapper.builder().auditDetails(auditDetails)
				.requestBody(pressMaster).build();
		Mockito.when(objectMapper.convertValue(infoWrapper.getRequestBody(), PressMaster.class))
				.thenReturn(pressMaster);
		
		Gson gson = new Gson();
		String payloadData = gson.toJson(pressMaster, PressMaster.class);
		
		Mockito.when(prScpUtil.validateJsonAddUpdateData(payloadData,CommonConstants.PRESSMASTERCREATE)).thenReturn("");
	
	
		Assert.assertEquals(HttpStatus.CREATED, eventPressMasterService.createPress(infoWrapper).getStatusCode());

	}

	@Test(expected = CustomException.class)
	public void testCreatePress_1() {
		RequestInfoWrapper infoWrapper = RequestInfoWrapper.builder().auditDetails(null).requestBody(null).build();
		eventPressMasterService.createPress(infoWrapper);
	}

	@Test
	public void testUpdatePress() throws ParseException {

		PressMaster pressMaster = PressMaster.builder().personnelName("Test")
				.pressMasterUuid("aasdjiasdu8ahs89asdy8a9h").build();
		AuditDetails auditDetails = AuditDetails.builder().createdBy("1").createdTime(1546515646L).lastModifiedBy("1")
				.lastModifiedTime(15645455L).build();
		RequestInfoWrapper infoWrapper = RequestInfoWrapper.builder().auditDetails(auditDetails)
				.requestBody(pressMaster).build();
		Mockito.when(objectMapper.convertValue(infoWrapper.getRequestBody(), PressMaster.class))
				.thenReturn(pressMaster);
		
		Gson gson = new Gson();
		String payloadData = gson.toJson(pressMaster, PressMaster.class);
		
		Mockito.when(prScpUtil.validateJsonAddUpdateData(payloadData,CommonConstants.PRESSMASTERUPDATE)).thenReturn("");
	
		Assert.assertEquals(HttpStatus.OK, eventPressMasterService.updatePress(infoWrapper).getStatusCode());
	}

	@Test(expected = CustomException.class)
	public void testUpdatePress_1() {
		RequestInfoWrapper infoWrapper = RequestInfoWrapper.builder().auditDetails(null).requestBody(null).build();
		eventPressMasterService.updatePress(infoWrapper);
	}

	@Test
	public void testGetPress() throws ParseException {

		PressMaster pressMaster = PressMaster.builder().pressMasterUuid("aasdjiasdu8ahs89asdy8a9h")
				.personnelName("Test").build();
		RequestInfoWrapper infoWrapper = RequestInfoWrapper.builder().requestBody(pressMaster).build();
		Mockito.when(objectMapper.convertValue(infoWrapper.getRequestBody(), PressMaster.class))
				.thenReturn(pressMaster);

		Mockito.when(repository.getPress(pressMaster)).thenReturn(new ArrayList<PressMaster>());
		
		Gson gson = new Gson();
		String payloadData = gson.toJson(pressMaster, PressMaster.class);
		
		Mockito.when(prScpUtil.validateJsonAddUpdateData(payloadData,CommonConstants.PRESSMASTERGET)).thenReturn("");
		
		Assert.assertEquals(HttpStatus.OK, eventPressMasterService.getPress(infoWrapper).getStatusCode());
	}

	@Test(expected = CustomException.class)
	public void testGetPress_1() {
		eventPressMasterService.getPress(null);
	}

	@Test
	public void testDeletePress() throws ParseException {
		PressMaster pressMaster = PressMaster.builder().pressMasterUuid("aasdjiasdu8ahs89asdy8a9h")
				.personnelName("Test").build();
		AuditDetails auditDetails = AuditDetails.builder().createdBy("1").createdTime(1546515646L).lastModifiedBy("1")
				.lastModifiedTime(15645455L).build();
		RequestInfoWrapper infoWrapper = RequestInfoWrapper.builder().auditDetails(auditDetails)
				.requestBody(pressMaster).build();
		Mockito.when(objectMapper.convertValue(infoWrapper.getRequestBody(), PressMaster.class))
				.thenReturn(pressMaster);
		
		Gson gson = new Gson();
		String payloadData = gson.toJson(pressMaster, PressMaster.class);
		
		Mockito.when(prScpUtil.validateJsonAddUpdateData(payloadData,CommonConstants.PRESSMASTERDELETE)).thenReturn("");
		
		Assert.assertEquals(HttpStatus.OK, eventPressMasterService.deletePress(infoWrapper).getStatusCode());
	}

	@Test(expected = CustomException.class)
	public void testDeletePress_1() {
		RequestInfoWrapper infoWrapper = RequestInfoWrapper.builder().auditDetails(null).requestBody(null).build();
		eventPressMasterService.deletePress(infoWrapper);
	}
}
