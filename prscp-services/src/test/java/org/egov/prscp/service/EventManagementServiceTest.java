package org.egov.prscp.service;

import java.util.ArrayList;
import java.util.List;

import org.egov.prscp.config.PrScpConfiguration;
import org.egov.prscp.producer.Producer;
import org.egov.prscp.repository.EventManegementRepository;
import org.egov.prscp.util.CommonConstants;
import org.egov.prscp.util.DeviceSource;
import org.egov.prscp.util.IdGenRepository;
import org.egov.prscp.util.PrScpUtil;
import org.egov.prscp.web.models.AuditDetails;
import org.egov.prscp.web.models.CommitteeDetail;
import org.egov.prscp.web.models.EventDetail;
import org.egov.prscp.web.models.RequestInfoWrapper;
import org.egov.prscp.web.models.Idgen.IdGenerationResponse;
import org.egov.prscp.web.models.Idgen.IdResponse;
import org.egov.tracer.model.CustomException;
import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

@RunWith(MockitoJUnitRunner.class)
public class EventManagementServiceTest {

	@Mock
	private ObjectMapper objectMapper;
	@Mock
	private DeviceSource deviceSource;
	@Mock
	private PrScpUtil prScpUtil;

	@Mock
	private Producer producer;

	@Mock
	private PrScpConfiguration config;
	@Mock
	private EventManegementRepository repository;

	@Mock
	private IdGenRepository idgenrepository;

	@InjectMocks
	private EventManagementService service;

	@Test
	public void testcreateEvent() throws ParseException {
		JSONArray eventImage = new JSONArray();
		eventImage.add("sample");
		EventDetail eventDetail = EventDetail.builder().moduleCode("Test").startDate("01/04/2020").startTime("11:11")
				.tenantId("ch").endDate("01/04/2020").endTime("11:11").eventImage(eventImage).build();
		// PrScpConfiguration config =
		// PrScpConfiguration.builder().applicationNumberIdgenName("sss").build();
		// config.setApplicationNumberIdgenFormat("sd");
		AuditDetails auditDetails = AuditDetails.builder().createdBy("1").createdTime(1546515646L).lastModifiedBy("1")
				.lastModifiedTime(15645455L).build();
		RequestInfoWrapper infoWrapper = RequestInfoWrapper.builder().auditDetails(auditDetails)
				.requestBody(eventDetail).build();
		Mockito.when(objectMapper.convertValue(infoWrapper.getRequestBody(), EventDetail.class))
				.thenReturn(eventDetail);
		List<IdResponse> idResponses = new ArrayList<>();
		IdResponse ids = IdResponse.builder().id("1").build();
		idResponses.add(ids);
		IdGenerationResponse id = IdGenerationResponse.builder().idResponses(idResponses).build();
		Mockito.when(idgenrepository.getId(Matchers.anyObject(), Matchers.anyString(), Matchers.anyString(),
				Matchers.anyString(), Matchers.anyInt())).thenReturn(id);
		Gson gson = new Gson();
		String payloadData = gson.toJson(eventDetail, EventDetail.class);
	
		Mockito.when(prScpUtil.validateJsonAddUpdateData(payloadData,CommonConstants.EVENTCREATE)).thenReturn("");
		Assert.assertEquals(HttpStatus.CREATED, service.createEvent(infoWrapper, "").getStatusCode());

	}

	@Test(expected = CustomException.class)
	public void testcreateEvent_1() {
		RequestInfoWrapper infoWrapper = RequestInfoWrapper.builder().auditDetails(null).requestBody(null).build();
		Assert.assertEquals(HttpStatus.CREATED, service.createEvent(infoWrapper, "").getStatusCode());
	}

	@Test
	public void testupdateEvent() throws ParseException {

		EventDetail detail = EventDetail.builder().status("PUBLISHED").build();
		List<EventDetail> list = new ArrayList<>();
		list.add(detail);

		Mockito.when(repository.getEvent(Matchers.any(EventDetail.class))).thenReturn(list);

		JSONArray eventImage = new JSONArray();
		eventImage.add("sample");
		EventDetail eventDetail = EventDetail.builder().moduleCode("Test").tenantId("ch").eventDetailUuid("sdsdsdsad")
				.startDate("01/04/2020").startTime("11:11").endDate("01/04/2020").endTime("11:11")
				.eventImage(eventImage).build();
		AuditDetails auditDetails = AuditDetails.builder().createdBy("1").createdTime(1546515646L).lastModifiedBy("1")
				.lastModifiedTime(15645455L).build();
		RequestInfoWrapper infoWrapper = RequestInfoWrapper.builder().auditDetails(auditDetails)
				.requestBody(eventDetail).build();
		Mockito.when(objectMapper.convertValue(infoWrapper.getRequestBody(), EventDetail.class))
				.thenReturn(eventDetail);
		Gson gson = new Gson();
		String payloadData = gson.toJson(eventDetail, EventDetail.class);
	
		Mockito.when(prScpUtil.validateJsonAddUpdateData(payloadData,CommonConstants.EVENTUPDATE)).thenReturn("");
		Assert.assertEquals(HttpStatus.OK, service.updateEvent(infoWrapper).getStatusCode());
	}

	@Test(expected = CustomException.class)
	public void testupdateEvent_1() {
		RequestInfoWrapper infoWrapper = RequestInfoWrapper.builder().auditDetails(null).requestBody(null).build();
		Assert.assertEquals(HttpStatus.CREATED, service.updateEvent(infoWrapper).getStatusCode());
	}

	@Test
	public void testupdateStatus() throws ParseException {
		EventDetail detail = EventDetail.builder().status("PUBLISHED").build();
		List<EventDetail> list = new ArrayList<>();
		list.add(detail);

		Mockito.when(repository.getEvent(Matchers.any(EventDetail.class))).thenReturn(list);

		JSONArray eventImage = new JSONArray();
		eventImage.add("sample");
		EventDetail eventDetail = EventDetail.builder().moduleCode("Test").tenantId("ch").eventDetailUuid("sdsdsdsad")
				.startDate("01/04/2020").startTime("11:11").endDate("01/04/2020").endTime("11:11")
				.eventImage(eventImage).build();
		AuditDetails auditDetails = AuditDetails.builder().createdBy("1").createdTime(1546515646L).lastModifiedBy("1")
				.lastModifiedTime(15645455L).build();
		RequestInfoWrapper infoWrapper = RequestInfoWrapper.builder().auditDetails(auditDetails)
				.requestBody(eventDetail).build();
		Mockito.when(objectMapper.convertValue(infoWrapper.getRequestBody(), EventDetail.class))
				.thenReturn(eventDetail);
		Gson gson = new Gson();
		String payloadData = gson.toJson(eventDetail, EventDetail.class);
	
		Mockito.when(prScpUtil.validateJsonAddUpdateData(payloadData,CommonConstants.EVENTUPDATE)).thenReturn("");
		Assert.assertEquals(HttpStatus.OK, service.updateEventStatus(infoWrapper).getStatusCode());
	}

	@Test(expected = CustomException.class)
	public void testupdateStatus_1() {
		RequestInfoWrapper infoWrapper = RequestInfoWrapper.builder().auditDetails(null).requestBody(null).build();
		Assert.assertEquals(HttpStatus.CREATED, service.updateEventStatus(infoWrapper).getStatusCode());
	}

	@Test
	public void testgetEvent() throws ParseException {

		EventDetail eventDetail = EventDetail.builder().eventDetailUuid("aasdjiasdu8ahs89asdy8a9h").moduleCode("Test")
				.build();
		RequestInfoWrapper infoWrapper = RequestInfoWrapper.builder().requestBody(eventDetail).build();
		Mockito.when(objectMapper.convertValue(infoWrapper.getRequestBody(), EventDetail.class))
				.thenReturn(eventDetail);

		Mockito.when(repository.getEvent(eventDetail)).thenReturn(new ArrayList<EventDetail>());
		Gson gson = new Gson();
		String payloadData = gson.toJson(eventDetail, EventDetail.class);
	
		Mockito.when(prScpUtil.validateJsonAddUpdateData(payloadData,CommonConstants.EVENTGET)).thenReturn("");
		Assert.assertEquals(HttpStatus.OK, service.getEvent(infoWrapper).getStatusCode());
	}
}
