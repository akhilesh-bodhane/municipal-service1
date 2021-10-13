package org.egov.prscp.web.models;

import java.util.List;
import org.easymock.EasyMock;
import org.json.simple.JSONArray;
import org.junit.*;
import static org.junit.Assert.*;


public class EventDetailTest {

	@Test
	public void testEventDetail_1()
		throws Exception {

		EventDetail result = new EventDetail();

		assertNotNull(result);
		assertEquals(null, result.getLastModifiedTime());
		assertEquals(null, result.getEndDate());
		assertEquals(null, result.getStartDate());
		assertEquals(null, result.getStatus());
		assertEquals(null, result.getStartTime());
		assertEquals(null, result.getEventType());
		assertEquals(false, result.isActive());
		assertEquals(null, result.getEventString());
		assertEquals(null, result.getArea());
		assertEquals(null, result.getEventLocation());
		assertEquals(null, result.getLastModifiedDate());
		assertEquals(null, result.getEventId());
		assertEquals(null, result.getTenantId());
		assertEquals(false, result.isDefaultGrid());
		assertEquals(null, result.getFacebookUrl());
		assertEquals(null, result.getEventBudget());
		assertEquals(null, result.getInviteGuest());
		assertEquals(null, result.getSourceUuid());
		assertEquals(null, result.getSector());
		assertEquals(null, result.getModuleCode());
		assertEquals(null, result.getEventTitle());
		assertEquals(null, result.getTwitterUrl());
		assertEquals(null, result.getInstagramUrl());
		assertEquals(null, result.getEventImage());
		assertEquals(null, result.getCommitteeUuid());
		assertEquals(null, result.getCommitteeName());
		assertEquals(null, result.getEndTime());
		assertEquals(null, result.getEventStatus());
		assertEquals(null, result.getCreatedBy());
		assertEquals(null, result.getCreatedTime());
		assertEquals(null, result.getCreatedDate());
		assertEquals(null, result.getNotificationTemplateUuid());
		assertEquals(null, result.getEventDetailUuid());
		assertEquals(null, result.getOrganizerDepartmentUuid());
		assertEquals(null, result.getOrganizerDepartmentName());
		assertEquals(null, result.getOrganizerDepartmentUserUuid());
		assertEquals(null, result.getOrganizerUsernName());
		assertEquals(null, result.getEventDescription());
		assertEquals(null, result.getLastModifiedBy());
	}

	
	@Test
	public void testEventDetail_2()
		throws Exception {
		String eventDetailUuid = "";
		String moduleCode = "";
		String eventTitle = "";
		String eventLocation = "";
		String sector = "";
		String organizerDepartmentUuid = "";
		String organizerDepartmentName = "";
		String organizerDepartmentUserUuid = "";
		String organizerUsernName = "";
		String facebookUrl = "";
		String twitterUrl = "";
		String instagramUrl = "";
		String startDate = "";
		String startTime = "";
		String endDate = "";
		String endTime = "";
		String eventDescription = "";
		String eventType = "";
		JSONArray eventImage = new JSONArray();
		Double eventBudget = new Double(1.0);
		String committeeUuid = "";
		String committeeName = "";
		String eventStatus = "";
		String status = "";
		boolean isActive = true;
		String createdBy = "";
		Long createdTime = new Long(1L);
		Long createdDate = new Long(1L);
		String lastModifiedBy = "";
		Long lastModifiedTime = new Long(1L);
		Long lastModifiedDate = new Long(1L);
		String tenantId = "";
		String eventId = "";
		String eventString = "";
		String notificationTemplateUuid = "";
		String area = "";
		boolean defaultGrid = true;
		List<InviteGuest> inviteGuest = EasyMock.createMock(List.class);
		String sourceUuid = "";
		
		EasyMock.replay(inviteGuest);

		EventDetail result = new EventDetail(eventDetailUuid, moduleCode, eventTitle, eventLocation, sector, organizerDepartmentUuid, organizerDepartmentName, organizerDepartmentUserUuid, organizerUsernName, facebookUrl, twitterUrl, instagramUrl, startDate, startTime, endDate, endTime, eventDescription, eventType, eventImage, eventBudget, committeeUuid, committeeName, eventStatus, status, isActive, createdBy, createdTime, createdDate, lastModifiedBy, lastModifiedTime, lastModifiedDate, tenantId, eventId, eventString, notificationTemplateUuid, area, defaultGrid, inviteGuest, sourceUuid);

		EasyMock.verify(inviteGuest);
		assertNotNull(result);
		assertEquals(new Long(1L), result.getLastModifiedTime());
		assertEquals("", result.getEndDate());
		assertEquals("", result.getStartDate());
		assertEquals("", result.getStatus());
		assertEquals("", result.getStartTime());
		assertEquals("", result.getEventType());
		assertEquals(true, result.isActive());
		assertEquals("", result.getEventString());
		assertEquals("", result.getArea());
		assertEquals("", result.getEventLocation());
		assertEquals(new Long(1L), result.getLastModifiedDate());
		assertEquals("", result.getEventId());
		assertEquals("", result.getTenantId());
		assertEquals(true, result.isDefaultGrid());
		assertEquals("", result.getFacebookUrl());
		assertEquals(new Double(1.0), result.getEventBudget());
		assertEquals("", result.getSourceUuid());
		assertEquals("", result.getSector());
		assertEquals("", result.getModuleCode());
		assertEquals("", result.getEventTitle());
		assertEquals("", result.getTwitterUrl());
		assertEquals("", result.getInstagramUrl());
		assertEquals("", result.getCommitteeUuid());
		assertEquals("", result.getCommitteeName());
		assertEquals("", result.getEndTime());
		assertEquals("", result.getEventStatus());
		assertEquals("", result.getCreatedBy());
		assertEquals(new Long(1L), result.getCreatedTime());
		assertEquals(new Long(1L), result.getCreatedDate());
		assertEquals("", result.getNotificationTemplateUuid());
		assertEquals("", result.getEventDetailUuid());
		assertEquals("", result.getOrganizerDepartmentUuid());
		assertEquals("", result.getOrganizerDepartmentName());
		assertEquals("", result.getOrganizerDepartmentUserUuid());
		assertEquals("", result.getOrganizerUsernName());
		assertEquals("", result.getEventDescription());
		assertEquals("", result.getLastModifiedBy());
	}


	@Test
	public void testBuilder_1()
		throws Exception {

		EventDetail.EventDetailBuilder result = EventDetail.builder();

		assertNotNull(result);
		assertEquals("EventDetail.EventDetailBuilder(eventDetailUuid=null, moduleCode=null, eventTitle=null, eventLocation=null, sector=null, organizerDepartmentUuid=null, organizerDepartmentName=null, organizerDepartmentUserUuid=null, organizerUsernName=null, facebookUrl=null, twitterUrl=null, instagramUrl=null, startDate=null, startTime=null, endDate=null, endTime=null, eventDescription=null, eventType=null, eventImage=null, eventBudget=null, committeeUuid=null, committeeName=null, eventStatus=null, status=null, isActive=false, createdBy=null, createdTime=null, createdDate=null, lastModifiedBy=null, lastModifiedTime=null, lastModifiedDate=null, tenantId=null, eventId=null, eventString=null, notificationTemplateUuid=null, area=null, defaultGrid=false, inviteGuest=null, sourceUuid=null)", result.toString());
	}

	
	@Test
	public void testGetArea_1()
		throws Exception {
		EventDetail fixture = new EventDetail("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", new JSONArray(), new Double(1.0), "", "", "", "", true, "", new Long(1L), new Long(1L), "", new Long(1L), new Long(1L), "", "", "", "", "", true, EasyMock.createNiceMock(List.class), "");

		String result = fixture.getArea();

		
		assertEquals("", result);
	}

	@Test
	public void testGetCommitteeName_1()
		throws Exception {
		EventDetail fixture = new EventDetail("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", new JSONArray(), new Double(1.0), "", "", "", "", true, "", new Long(1L), new Long(1L), "", new Long(1L), new Long(1L), "", "", "", "", "", true, EasyMock.createNiceMock(List.class), "");

		String result = fixture.getCommitteeName();

		assertEquals("", result);
	}

	
	@Test
	public void testGetCommitteeUuid_1()
		throws Exception {
		EventDetail fixture = new EventDetail("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", new JSONArray(), new Double(1.0), "", "", "", "", true, "", new Long(1L), new Long(1L), "", new Long(1L), new Long(1L), "", "", "", "", "", true, EasyMock.createNiceMock(List.class), "");

		String result = fixture.getCommitteeUuid();

		
		assertEquals("", result);
	}


	@Test
	public void testGetCreatedBy_1()
		throws Exception {
		EventDetail fixture = new EventDetail("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", new JSONArray(), new Double(1.0), "", "", "", "", true, "", new Long(1L), new Long(1L), "", new Long(1L), new Long(1L), "", "", "", "", "", true, EasyMock.createNiceMock(List.class), "");

		String result = fixture.getCreatedBy();

		
		assertEquals("", result);
	}

	
	@Test
	public void testGetCreatedDate_1()
		throws Exception {
		EventDetail fixture = new EventDetail("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", new JSONArray(), new Double(1.0), "", "", "", "", true, "", new Long(1L), new Long(1L), "", new Long(1L), new Long(1L), "", "", "", "", "", true, EasyMock.createNiceMock(List.class), "");

		Long result = fixture.getCreatedDate();

		assertNotNull(result);
		assertEquals("1", result.toString());
		assertEquals((byte) 1, result.byteValue());
		assertEquals((short) 1, result.shortValue());
		assertEquals(1, result.intValue());
		assertEquals(1L, result.longValue());
		assertEquals(1.0f, result.floatValue(), 1.0f);
		assertEquals(1.0, result.doubleValue(), 1.0);
	}


	@Test
	public void testGetCreatedTime_1()
		throws Exception {
		EventDetail fixture = new EventDetail("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", new JSONArray(), new Double(1.0), "", "", "", "", true, "", new Long(1L), new Long(1L), "", new Long(1L), new Long(1L), "", "", "", "", "", true, EasyMock.createNiceMock(List.class), "");

		Long result = fixture.getCreatedTime();

		assertNotNull(result);
		assertEquals("1", result.toString());
		assertEquals((byte) 1, result.byteValue());
		assertEquals((short) 1, result.shortValue());
		assertEquals(1, result.intValue());
		assertEquals(1L, result.longValue());
		assertEquals(1.0f, result.floatValue(), 1.0f);
		assertEquals(1.0, result.doubleValue(), 1.0);
	}

	@Test
	public void testGetEndDate_1()
		throws Exception {
		EventDetail fixture = new EventDetail("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", new JSONArray(), new Double(1.0), "", "", "", "", true, "", new Long(1L), new Long(1L), "", new Long(1L), new Long(1L), "", "", "", "", "", true, EasyMock.createNiceMock(List.class), "");

		String result = fixture.getEndDate();

		assertEquals("", result);
	}


	@Test
	public void testGetEndTime_1()
		throws Exception {
		EventDetail fixture = new EventDetail("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", new JSONArray(), new Double(1.0), "", "", "", "", true, "", new Long(1L), new Long(1L), "", new Long(1L), new Long(1L), "", "", "", "", "", true, EasyMock.createNiceMock(List.class), "");

		String result = fixture.getEndTime();

		assertEquals("", result);
	}

	
	@Test
	public void testGetEventBudget_1()
		throws Exception {
		EventDetail fixture = new EventDetail("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", new JSONArray(), new Double(1.0), "", "", "", "", true, "", new Long(1L), new Long(1L), "", new Long(1L), new Long(1L), "", "", "", "", "", true, EasyMock.createNiceMock(List.class), "");

		Double result = fixture.getEventBudget();

		assertNotNull(result);
		assertEquals("1.0", result.toString());
		assertEquals((byte) 1, result.byteValue());
		assertEquals((short) 1, result.shortValue());
		assertEquals(1, result.intValue());
		assertEquals(1L, result.longValue());
		assertEquals(1.0f, result.floatValue(), 1.0f);
		assertEquals(1.0, result.doubleValue(), 1.0);
		assertEquals(false, result.isNaN());
		assertEquals(false, result.isInfinite());
	}

	@Test
	public void testGetEventDescription_1()
		throws Exception {
		EventDetail fixture = new EventDetail("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", new JSONArray(), new Double(1.0), "", "", "", "", true, "", new Long(1L), new Long(1L), "", new Long(1L), new Long(1L), "", "", "", "", "", true, EasyMock.createNiceMock(List.class), "");

		String result = fixture.getEventDescription();

		assertEquals("", result);
	}

	
	@Test
	public void testGetEventDetailUuid_1()
		throws Exception {
		EventDetail fixture = new EventDetail("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", new JSONArray(), new Double(1.0), "", "", "", "", true, "", new Long(1L), new Long(1L), "", new Long(1L), new Long(1L), "", "", "", "", "", true, EasyMock.createNiceMock(List.class), "");

		String result = fixture.getEventDetailUuid();

		assertEquals("", result);
	}

	
	@Test
	public void testGetEventId_1()
		throws Exception {
		EventDetail fixture = new EventDetail("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", new JSONArray(), new Double(1.0), "", "", "", "", true, "", new Long(1L), new Long(1L), "", new Long(1L), new Long(1L), "", "", "", "", "", true, EasyMock.createNiceMock(List.class), "");

		String result = fixture.getEventId();

		assertEquals("", result);
	}

	
	@Test
	public void testGetEventImage_1()
		throws Exception {
		EventDetail fixture = new EventDetail("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", new JSONArray(), new Double(1.0), "", "", "", "", true, "", new Long(1L), new Long(1L), "", new Long(1L), new Long(1L), "", "", "", "", "", true, EasyMock.createNiceMock(List.class), "");

		JSONArray result = fixture.getEventImage();

		assertNotNull(result);
		assertEquals(0, result.size());
	}

	
	@Test
	public void testGetEventLocation_1()
		throws Exception {
		EventDetail fixture = new EventDetail("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", new JSONArray(), new Double(1.0), "", "", "", "", true, "", new Long(1L), new Long(1L), "", new Long(1L), new Long(1L), "", "", "", "", "", true, EasyMock.createNiceMock(List.class), "");

		String result = fixture.getEventLocation();

		assertEquals("", result);
	}

	@Test
	public void testGetEventStatus_1()
		throws Exception {
		EventDetail fixture = new EventDetail("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", new JSONArray(), new Double(1.0), "", "", "", "", true, "", new Long(1L), new Long(1L), "", new Long(1L), new Long(1L), "", "", "", "", "", true, EasyMock.createNiceMock(List.class), "");

		String result = fixture.getEventStatus();

	
		assertEquals("", result);
	}

	
	@Test
	public void testGetEventString_1()
		throws Exception {
		EventDetail fixture = new EventDetail("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", new JSONArray(), new Double(1.0), "", "", "", "", true, "", new Long(1L), new Long(1L), "", new Long(1L), new Long(1L), "", "", "", "", "", true, EasyMock.createNiceMock(List.class), "");

		String result = fixture.getEventString();

		assertEquals("", result);
	}

	@Test
	public void testGetEventTitle_1()
		throws Exception {
		EventDetail fixture = new EventDetail("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", new JSONArray(), new Double(1.0), "", "", "", "", true, "", new Long(1L), new Long(1L), "", new Long(1L), new Long(1L), "", "", "", "", "", true, EasyMock.createNiceMock(List.class), "");

		String result = fixture.getEventTitle();

		assertEquals("", result);
	}

	
	@Test
	public void testGetEventType_1()
		throws Exception {
		EventDetail fixture = new EventDetail("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", new JSONArray(), new Double(1.0), "", "", "", "", true, "", new Long(1L), new Long(1L), "", new Long(1L), new Long(1L), "", "", "", "", "", true, EasyMock.createNiceMock(List.class), "");

		String result = fixture.getEventType();

	
		assertEquals("", result);
	}

	
	@Test
	public void testGetFacebookUrl_1()
		throws Exception {
		EventDetail fixture = new EventDetail("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", new JSONArray(), new Double(1.0), "", "", "", "", true, "", new Long(1L), new Long(1L), "", new Long(1L), new Long(1L), "", "", "", "", "", true, EasyMock.createNiceMock(List.class), "");

		String result = fixture.getFacebookUrl();

		assertEquals("", result);
	}

	
	@Test
	public void testGetInstagramUrl_1()
		throws Exception {
		EventDetail fixture = new EventDetail("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", new JSONArray(), new Double(1.0), "", "", "", "", true, "", new Long(1L), new Long(1L), "", new Long(1L), new Long(1L), "", "", "", "", "", true, EasyMock.createNiceMock(List.class), "");

		String result = fixture.getInstagramUrl();

	
		assertEquals("", result);
	}

	
	@Test
	public void testGetInviteGuest_1()
		throws Exception {
		EventDetail fixture = new EventDetail("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", new JSONArray(), new Double(1.0), "", "", "", "", true, "", new Long(1L), new Long(1L), "", new Long(1L), new Long(1L), "", "", "", "", "", true, EasyMock.createNiceMock(List.class), "");

		List<InviteGuest> result = fixture.getInviteGuest();

		assertNotNull(result);
		assertEquals(0, result.size());
	}

	@Test
	public void testGetLastModifiedBy_1()
		throws Exception {
		EventDetail fixture = new EventDetail("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", new JSONArray(), new Double(1.0), "", "", "", "", true, "", new Long(1L), new Long(1L), "", new Long(1L), new Long(1L), "", "", "", "", "", true, EasyMock.createNiceMock(List.class), "");

		String result = fixture.getLastModifiedBy();

		assertEquals("", result);
	}


	@Test
	public void testGetLastModifiedDate_1()
		throws Exception {
		EventDetail fixture = new EventDetail("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", new JSONArray(), new Double(1.0), "", "", "", "", true, "", new Long(1L), new Long(1L), "", new Long(1L), new Long(1L), "", "", "", "", "", true, EasyMock.createNiceMock(List.class), "");

		Long result = fixture.getLastModifiedDate();

		assertNotNull(result);
		assertEquals("1", result.toString());
		assertEquals((byte) 1, result.byteValue());
		assertEquals((short) 1, result.shortValue());
		assertEquals(1, result.intValue());
		assertEquals(1L, result.longValue());
		assertEquals(1.0f, result.floatValue(), 1.0f);
		assertEquals(1.0, result.doubleValue(), 1.0);
	}

	
	@Test
	public void testGetLastModifiedTime_1()
		throws Exception {
		EventDetail fixture = new EventDetail("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", new JSONArray(), new Double(1.0), "", "", "", "", true, "", new Long(1L), new Long(1L), "", new Long(1L), new Long(1L), "", "", "", "", "", true, EasyMock.createNiceMock(List.class), "");

		Long result = fixture.getLastModifiedTime();

		assertNotNull(result);
		assertEquals("1", result.toString());
		assertEquals((byte) 1, result.byteValue());
		assertEquals((short) 1, result.shortValue());
		assertEquals(1, result.intValue());
		assertEquals(1L, result.longValue());
		assertEquals(1.0f, result.floatValue(), 1.0f);
		assertEquals(1.0, result.doubleValue(), 1.0);
	}

	
	@Test
	public void testGetModuleCode_1()
		throws Exception {
		EventDetail fixture = new EventDetail("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", new JSONArray(), new Double(1.0), "", "", "", "", true, "", new Long(1L), new Long(1L), "", new Long(1L), new Long(1L), "", "", "", "", "", true, EasyMock.createNiceMock(List.class), "");

		String result = fixture.getModuleCode();

		assertEquals("", result);
	}

	
	@Test
	public void testGetNotificationTemplateUuid_1()
		throws Exception {
		EventDetail fixture = new EventDetail("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", new JSONArray(), new Double(1.0), "", "", "", "", true, "", new Long(1L), new Long(1L), "", new Long(1L), new Long(1L), "", "", "", "", "", true, EasyMock.createNiceMock(List.class), "");

		String result = fixture.getNotificationTemplateUuid();

		assertEquals("", result);
	}

	
	@Test
	public void testGetOrganizerDepartmentName_1()
		throws Exception {
		EventDetail fixture = new EventDetail("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", new JSONArray(), new Double(1.0), "", "", "", "", true, "", new Long(1L), new Long(1L), "", new Long(1L), new Long(1L), "", "", "", "", "", true, EasyMock.createNiceMock(List.class), "");

		String result = fixture.getOrganizerDepartmentName();

		assertEquals("", result);
	}

	
	@Test
	public void testGetOrganizerDepartmentUserUuid_1()
		throws Exception {
		EventDetail fixture = new EventDetail("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", new JSONArray(), new Double(1.0), "", "", "", "", true, "", new Long(1L), new Long(1L), "", new Long(1L), new Long(1L), "", "", "", "", "", true, EasyMock.createNiceMock(List.class), "");

		String result = fixture.getOrganizerDepartmentUserUuid();

		assertEquals("", result);
	}

	
	@Test
	public void testGetOrganizerDepartmentUuid_1()
		throws Exception {
		EventDetail fixture = new EventDetail("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", new JSONArray(), new Double(1.0), "", "", "", "", true, "", new Long(1L), new Long(1L), "", new Long(1L), new Long(1L), "", "", "", "", "", true, EasyMock.createNiceMock(List.class), "");

		String result = fixture.getOrganizerDepartmentUuid();

		
		assertEquals("", result);
	}

	
	@Test
	public void testGetOrganizerUsernName_1()
		throws Exception {
		EventDetail fixture = new EventDetail("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", new JSONArray(), new Double(1.0), "", "", "", "", true, "", new Long(1L), new Long(1L), "", new Long(1L), new Long(1L), "", "", "", "", "", true, EasyMock.createNiceMock(List.class), "");

		String result = fixture.getOrganizerUsernName();

		assertEquals("", result);
	}

	
	@Test
	public void testGetSector_1()
		throws Exception {
		EventDetail fixture = new EventDetail("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", new JSONArray(), new Double(1.0), "", "", "", "", true, "", new Long(1L), new Long(1L), "", new Long(1L), new Long(1L), "", "", "", "", "", true, EasyMock.createNiceMock(List.class), "");

		String result = fixture.getSector();

		assertEquals("", result);
	}

	
	@Test
	public void testGetSourceUuid_1()
		throws Exception {
		EventDetail fixture = new EventDetail("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", new JSONArray(), new Double(1.0), "", "", "", "", true, "", new Long(1L), new Long(1L), "", new Long(1L), new Long(1L), "", "", "", "", "", true, EasyMock.createNiceMock(List.class), "");

		String result = fixture.getSourceUuid();

		assertEquals("", result);
	}

	
	@Test
	public void testGetStartDate_1()
		throws Exception {
		EventDetail fixture = new EventDetail("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", new JSONArray(), new Double(1.0), "", "", "", "", true, "", new Long(1L), new Long(1L), "", new Long(1L), new Long(1L), "", "", "", "", "", true, EasyMock.createNiceMock(List.class), "");

		String result = fixture.getStartDate();

		assertEquals("", result);
	}


	@Test
	public void testGetStartTime_1()
		throws Exception {
		EventDetail fixture = new EventDetail("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", new JSONArray(), new Double(1.0), "", "", "", "", true, "", new Long(1L), new Long(1L), "", new Long(1L), new Long(1L), "", "", "", "", "", true, EasyMock.createNiceMock(List.class), "");

		String result = fixture.getStartTime();

	
		assertEquals("", result);
	}

	@Test
	public void testGetStatus_1()
		throws Exception {
		EventDetail fixture = new EventDetail("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", new JSONArray(), new Double(1.0), "", "", "", "", true, "", new Long(1L), new Long(1L), "", new Long(1L), new Long(1L), "", "", "", "", "", true, EasyMock.createNiceMock(List.class), "");

		String result = fixture.getStatus();

		assertEquals("", result);
	}

	
	@Test
	public void testGetTenantId_1()
		throws Exception {
		EventDetail fixture = new EventDetail("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", new JSONArray(), new Double(1.0), "", "", "", "", true, "", new Long(1L), new Long(1L), "", new Long(1L), new Long(1L), "", "", "", "", "", true, EasyMock.createNiceMock(List.class), "");

		String result = fixture.getTenantId();

		assertEquals("", result);
	}

	
	@Test
	public void testGetTwitterUrl_1()
		throws Exception {
		EventDetail fixture = new EventDetail("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", new JSONArray(), new Double(1.0), "", "", "", "", true, "", new Long(1L), new Long(1L), "", new Long(1L), new Long(1L), "", "", "", "", "", true, EasyMock.createNiceMock(List.class), "");

		String result = fixture.getTwitterUrl();

		assertEquals("", result);
	}

	@Test
	public void testIsActive_1()
		throws Exception {
		EventDetail fixture = new EventDetail("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", new JSONArray(), new Double(1.0), "", "", "", "", true, "", new Long(1L), new Long(1L), "", new Long(1L), new Long(1L), "", "", "", "", "", true, EasyMock.createNiceMock(List.class), "");

		boolean result = fixture.isActive();

		assertEquals(true, result);
	}

	@Test
	public void testIsActive_2()
		throws Exception {
		EventDetail fixture = new EventDetail("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", new JSONArray(), new Double(1.0), "", "", "", "", false, "", new Long(1L), new Long(1L), "", new Long(1L), new Long(1L), "", "", "", "", "", true, EasyMock.createNiceMock(List.class), "");

		boolean result = fixture.isActive();

		assertEquals(false, result);
	}

	
	@Test
	public void testIsDefaultGrid_1()
		throws Exception {
		EventDetail fixture = new EventDetail("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", new JSONArray(), new Double(1.0), "", "", "", "", true, "", new Long(1L), new Long(1L), "", new Long(1L), new Long(1L), "", "", "", "", "", true, EasyMock.createNiceMock(List.class), "");

		boolean result = fixture.isDefaultGrid();

		assertEquals(true, result);
	}

	
	@Test
	public void testIsDefaultGrid_2()
		throws Exception {
		EventDetail fixture = new EventDetail("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", new JSONArray(), new Double(1.0), "", "", "", "", true, "", new Long(1L), new Long(1L), "", new Long(1L), new Long(1L), "", "", "", "", "", false, EasyMock.createNiceMock(List.class), "");

		boolean result = fixture.isDefaultGrid();

		assertEquals(false, result);
	}

	@Test
	public void testSetActive_1()
		throws Exception {
		EventDetail fixture = new EventDetail("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", new JSONArray(), new Double(1.0), "", "", "", "", true, "", new Long(1L), new Long(1L), "", new Long(1L), new Long(1L), "", "", "", "", "", true, EasyMock.createNiceMock(List.class), "");
		boolean isActive = true;

		fixture.setActive(isActive);

	}

	
	@Test
	public void testSetArea_1()
		throws Exception {
		EventDetail fixture = new EventDetail("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", new JSONArray(), new Double(1.0), "", "", "", "", true, "", new Long(1L), new Long(1L), "", new Long(1L), new Long(1L), "", "", "", "", "", true, EasyMock.createNiceMock(List.class), "");
		String area = "";

		fixture.setArea(area);

	}


	@Test
	public void testSetCommitteeName_1()
		throws Exception {
		EventDetail fixture = new EventDetail("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", new JSONArray(), new Double(1.0), "", "", "", "", true, "", new Long(1L), new Long(1L), "", new Long(1L), new Long(1L), "", "", "", "", "", true, EasyMock.createNiceMock(List.class), "");
		String committeeName = "";

		fixture.setCommitteeName(committeeName);

	}

	
	@Test
	public void testSetCommitteeUuid_1()
		throws Exception {
		EventDetail fixture = new EventDetail("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", new JSONArray(), new Double(1.0), "", "", "", "", true, "", new Long(1L), new Long(1L), "", new Long(1L), new Long(1L), "", "", "", "", "", true, EasyMock.createNiceMock(List.class), "");
		String committeeUuid = "";

		fixture.setCommitteeUuid(committeeUuid);

		
	}

	
	@Test
	public void testSetCreatedBy_1()
		throws Exception {
		EventDetail fixture = new EventDetail("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", new JSONArray(), new Double(1.0), "", "", "", "", true, "", new Long(1L), new Long(1L), "", new Long(1L), new Long(1L), "", "", "", "", "", true, EasyMock.createNiceMock(List.class), "");
		String createdBy = "";

		fixture.setCreatedBy(createdBy);

	}

	
	@Test
	public void testSetCreatedDate_1()
		throws Exception {
		EventDetail fixture = new EventDetail("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", new JSONArray(), new Double(1.0), "", "", "", "", true, "", new Long(1L), new Long(1L), "", new Long(1L), new Long(1L), "", "", "", "", "", true, EasyMock.createNiceMock(List.class), "");
		Long createdDate = new Long(1L);

		fixture.setCreatedDate(createdDate);

	}

	@Test
	public void testSetCreatedTime_1()
		throws Exception {
		EventDetail fixture = new EventDetail("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", new JSONArray(), new Double(1.0), "", "", "", "", true, "", new Long(1L), new Long(1L), "", new Long(1L), new Long(1L), "", "", "", "", "", true, EasyMock.createNiceMock(List.class), "");
		Long createdTime = new Long(1L);

		fixture.setCreatedTime(createdTime);

	}

	
	@Test
	public void testSetDefaultGrid_1()
		throws Exception {
		EventDetail fixture = new EventDetail("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", new JSONArray(), new Double(1.0), "", "", "", "", true, "", new Long(1L), new Long(1L), "", new Long(1L), new Long(1L), "", "", "", "", "", true, EasyMock.createNiceMock(List.class), "");
		boolean defaultGrid = true;

		fixture.setDefaultGrid(defaultGrid);

	}

	@Test
	public void testSetEndDate_1()
		throws Exception {
		EventDetail fixture = new EventDetail("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", new JSONArray(), new Double(1.0), "", "", "", "", true, "", new Long(1L), new Long(1L), "", new Long(1L), new Long(1L), "", "", "", "", "", true, EasyMock.createNiceMock(List.class), "");
		String endDate = "";

		fixture.setEndDate(endDate);

	}

	@Test
	public void testSetEndTime_1()
		throws Exception {
		EventDetail fixture = new EventDetail("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", new JSONArray(), new Double(1.0), "", "", "", "", true, "", new Long(1L), new Long(1L), "", new Long(1L), new Long(1L), "", "", "", "", "", true, EasyMock.createNiceMock(List.class), "");
		String endTime = "";

		fixture.setEndTime(endTime);

	}

	
	@Test
	public void testSetEventBudget_1()
		throws Exception {
		EventDetail fixture = new EventDetail("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", new JSONArray(), new Double(1.0), "", "", "", "", true, "", new Long(1L), new Long(1L), "", new Long(1L), new Long(1L), "", "", "", "", "", true, EasyMock.createNiceMock(List.class), "");
		Double eventBudget = new Double(1.0);

		fixture.setEventBudget(eventBudget);

	}

	@Test
	public void testSetEventDescription_1()
		throws Exception {
		EventDetail fixture = new EventDetail("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", new JSONArray(), new Double(1.0), "", "", "", "", true, "", new Long(1L), new Long(1L), "", new Long(1L), new Long(1L), "", "", "", "", "", true, EasyMock.createNiceMock(List.class), "");
		String eventDescription = "";

		fixture.setEventDescription(eventDescription);

	}

	@Test
	public void testSetEventDetailUuid_1()
		throws Exception {
		EventDetail fixture = new EventDetail("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", new JSONArray(), new Double(1.0), "", "", "", "", true, "", new Long(1L), new Long(1L), "", new Long(1L), new Long(1L), "", "", "", "", "", true, EasyMock.createNiceMock(List.class), "");
		String eventDetailUuid = "";

		fixture.setEventDetailUuid(eventDetailUuid);

	}

	
	@Test
	public void testSetEventId_1()
		throws Exception {
		EventDetail fixture = new EventDetail("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", new JSONArray(), new Double(1.0), "", "", "", "", true, "", new Long(1L), new Long(1L), "", new Long(1L), new Long(1L), "", "", "", "", "", true, EasyMock.createNiceMock(List.class), "");
		String eventId = "";

		fixture.setEventId(eventId);

	
	}

	
	@Test
	public void testSetEventImage_1()
		throws Exception {
		EventDetail fixture = new EventDetail("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", new JSONArray(), new Double(1.0), "", "", "", "", true, "", new Long(1L), new Long(1L), "", new Long(1L), new Long(1L), "", "", "", "", "", true, EasyMock.createNiceMock(List.class), "");
		JSONArray eventImage = new JSONArray();

		fixture.setEventImage(eventImage);

	}

	@Test
	public void testSetEventLocation_1()
		throws Exception {
		EventDetail fixture = new EventDetail("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", new JSONArray(), new Double(1.0), "", "", "", "", true, "", new Long(1L), new Long(1L), "", new Long(1L), new Long(1L), "", "", "", "", "", true, EasyMock.createNiceMock(List.class), "");
		String eventLocation = "";

		fixture.setEventLocation(eventLocation);

	}

	
	@Test
	public void testSetEventStatus_1()
		throws Exception {
		EventDetail fixture = new EventDetail("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", new JSONArray(), new Double(1.0), "", "", "", "", true, "", new Long(1L), new Long(1L), "", new Long(1L), new Long(1L), "", "", "", "", "", true, EasyMock.createNiceMock(List.class), "");
		String eventStatus = "";

		fixture.setEventStatus(eventStatus);

	}

	@Test
	public void testSetEventString_1()
		throws Exception {
		EventDetail fixture = new EventDetail("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", new JSONArray(), new Double(1.0), "", "", "", "", true, "", new Long(1L), new Long(1L), "", new Long(1L), new Long(1L), "", "", "", "", "", true, EasyMock.createNiceMock(List.class), "");
		String eventString = "";

		fixture.setEventString(eventString);

	}

	@Test
	public void testSetEventTitle_1()
		throws Exception {
		EventDetail fixture = new EventDetail("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", new JSONArray(), new Double(1.0), "", "", "", "", true, "", new Long(1L), new Long(1L), "", new Long(1L), new Long(1L), "", "", "", "", "", true, EasyMock.createNiceMock(List.class), "");
		String eventTitle = "";

		fixture.setEventTitle(eventTitle);

	}

	@Test
	public void testSetEventType_1()
		throws Exception {
		EventDetail fixture = new EventDetail("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", new JSONArray(), new Double(1.0), "", "", "", "", true, "", new Long(1L), new Long(1L), "", new Long(1L), new Long(1L), "", "", "", "", "", true, EasyMock.createNiceMock(List.class), "");
		String eventType = "";

		fixture.setEventType(eventType);

	}


	@Test
	public void testSetFacebookUrl_1()
		throws Exception {
		EventDetail fixture = new EventDetail("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", new JSONArray(), new Double(1.0), "", "", "", "", true, "", new Long(1L), new Long(1L), "", new Long(1L), new Long(1L), "", "", "", "", "", true, EasyMock.createNiceMock(List.class), "");
		String facebookUrl = "";

		fixture.setFacebookUrl(facebookUrl);

	}

	
	@Test
	public void testSetInstagramUrl_1()
		throws Exception {
		EventDetail fixture = new EventDetail("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", new JSONArray(), new Double(1.0), "", "", "", "", true, "", new Long(1L), new Long(1L), "", new Long(1L), new Long(1L), "", "", "", "", "", true, EasyMock.createNiceMock(List.class), "");
		String instagramUrl = "";

		fixture.setInstagramUrl(instagramUrl);

	}


	@Test
	public void testSetInviteGuest_1()
		throws Exception {
		EventDetail fixture = new EventDetail("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", new JSONArray(), new Double(1.0), "", "", "", "", true, "", new Long(1L), new Long(1L), "", new Long(1L), new Long(1L), "", "", "", "", "", true, EasyMock.createNiceMock(List.class), "");
		List<InviteGuest> inviteGuest = EasyMock.createMock(List.class);
		// add mock object expectations here

		EasyMock.replay(inviteGuest);

		fixture.setInviteGuest(inviteGuest);

		
		EasyMock.verify(inviteGuest);
	}

	
	@Test
	public void testSetLastModifiedBy_1()
		throws Exception {
		EventDetail fixture = new EventDetail("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", new JSONArray(), new Double(1.0), "", "", "", "", true, "", new Long(1L), new Long(1L), "", new Long(1L), new Long(1L), "", "", "", "", "", true, EasyMock.createNiceMock(List.class), "");
		String lastModifiedBy = "";

		fixture.setLastModifiedBy(lastModifiedBy);

		
	}

	
	@Test
	public void testSetLastModifiedDate_1()
		throws Exception {
		EventDetail fixture = new EventDetail("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", new JSONArray(), new Double(1.0), "", "", "", "", true, "", new Long(1L), new Long(1L), "", new Long(1L), new Long(1L), "", "", "", "", "", true, EasyMock.createNiceMock(List.class), "");
		Long lastModifiedDate = new Long(1L);

		fixture.setLastModifiedDate(lastModifiedDate);

	}

	
	@Test
	public void testSetLastModifiedTime_1()
		throws Exception {
		EventDetail fixture = new EventDetail("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", new JSONArray(), new Double(1.0), "", "", "", "", true, "", new Long(1L), new Long(1L), "", new Long(1L), new Long(1L), "", "", "", "", "", true, EasyMock.createNiceMock(List.class), "");
		Long lastModifiedTime = new Long(1L);

		fixture.setLastModifiedTime(lastModifiedTime);

		
	}

	@Test
	public void testSetModuleCode_1()
		throws Exception {
		EventDetail fixture = new EventDetail("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", new JSONArray(), new Double(1.0), "", "", "", "", true, "", new Long(1L), new Long(1L), "", new Long(1L), new Long(1L), "", "", "", "", "", true, EasyMock.createNiceMock(List.class), "");
		String moduleCode = "";

		fixture.setModuleCode(moduleCode);

		
	}

	
	@Test
	public void testSetNotificationTemplateUuid_1()
		throws Exception {
		EventDetail fixture = new EventDetail("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", new JSONArray(), new Double(1.0), "", "", "", "", true, "", new Long(1L), new Long(1L), "", new Long(1L), new Long(1L), "", "", "", "", "", true, EasyMock.createNiceMock(List.class), "");
		String notificationTemplateUuid = "";

		fixture.setNotificationTemplateUuid(notificationTemplateUuid);

		
	}


	@Test
	public void testSetOrganizerDepartmentName_1()
		throws Exception {
		EventDetail fixture = new EventDetail("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", new JSONArray(), new Double(1.0), "", "", "", "", true, "", new Long(1L), new Long(1L), "", new Long(1L), new Long(1L), "", "", "", "", "", true, EasyMock.createNiceMock(List.class), "");
		String organizerDepartmentName = "";

		fixture.setOrganizerDepartmentName(organizerDepartmentName);

		
	}

	
	@Test
	public void testSetOrganizerDepartmentUserUuid_1()
		throws Exception {
		EventDetail fixture = new EventDetail("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", new JSONArray(), new Double(1.0), "", "", "", "", true, "", new Long(1L), new Long(1L), "", new Long(1L), new Long(1L), "", "", "", "", "", true, EasyMock.createNiceMock(List.class), "");
		String organizerDepartmentUserUuid = "";

		fixture.setOrganizerDepartmentUserUuid(organizerDepartmentUserUuid);

		
	}


	@Test
	public void testSetOrganizerDepartmentUuid_1()
		throws Exception {
		EventDetail fixture = new EventDetail("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", new JSONArray(), new Double(1.0), "", "", "", "", true, "", new Long(1L), new Long(1L), "", new Long(1L), new Long(1L), "", "", "", "", "", true, EasyMock.createNiceMock(List.class), "");
		String organizerDepartmentUuid = "";

		fixture.setOrganizerDepartmentUuid(organizerDepartmentUuid);

		
	}

	
	@Test
	public void testSetOrganizerUsernName_1()
		throws Exception {
		EventDetail fixture = new EventDetail("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", new JSONArray(), new Double(1.0), "", "", "", "", true, "", new Long(1L), new Long(1L), "", new Long(1L), new Long(1L), "", "", "", "", "", true, EasyMock.createNiceMock(List.class), "");
		String organizerUsernName = "";

		fixture.setOrganizerUsernName(organizerUsernName);

		
	}


	@Test
	public void testSetSector_1()
		throws Exception {
		EventDetail fixture = new EventDetail("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", new JSONArray(), new Double(1.0), "", "", "", "", true, "", new Long(1L), new Long(1L), "", new Long(1L), new Long(1L), "", "", "", "", "", true, EasyMock.createNiceMock(List.class), "");
		String sector = "";

		fixture.setSector(sector);

		
	}

	
	@Test
	public void testSetSourceUuid_1()
		throws Exception {
		EventDetail fixture = new EventDetail("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", new JSONArray(), new Double(1.0), "", "", "", "", true, "", new Long(1L), new Long(1L), "", new Long(1L), new Long(1L), "", "", "", "", "", true, EasyMock.createNiceMock(List.class), "");
		String sourceUuid = "";

		fixture.setSourceUuid(sourceUuid);

		
	}

	@Test
	public void testSetStartDate_1()
		throws Exception {
		EventDetail fixture = new EventDetail("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", new JSONArray(), new Double(1.0), "", "", "", "", true, "", new Long(1L), new Long(1L), "", new Long(1L), new Long(1L), "", "", "", "", "", true, EasyMock.createNiceMock(List.class), "");
		String startDate = "";

		fixture.setStartDate(startDate);

		
	}

	@Test
	public void testSetStartTime_1()
		throws Exception {
		EventDetail fixture = new EventDetail("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", new JSONArray(), new Double(1.0), "", "", "", "", true, "", new Long(1L), new Long(1L), "", new Long(1L), new Long(1L), "", "", "", "", "", true, EasyMock.createNiceMock(List.class), "");
		String startTime = "";

		fixture.setStartTime(startTime);

		
	}

	@Test
	public void testSetStatus_1()
		throws Exception {
		EventDetail fixture = new EventDetail("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", new JSONArray(), new Double(1.0), "", "", "", "", true, "", new Long(1L), new Long(1L), "", new Long(1L), new Long(1L), "", "", "", "", "", true, EasyMock.createNiceMock(List.class), "");
		String status = "";

		fixture.setStatus(status);

		
	}

	@Test
	public void testSetTenantId_1()
		throws Exception {
		EventDetail fixture = new EventDetail("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", new JSONArray(), new Double(1.0), "", "", "", "", true, "", new Long(1L), new Long(1L), "", new Long(1L), new Long(1L), "", "", "", "", "", true, EasyMock.createNiceMock(List.class), "");
		String tenantId = "";

		fixture.setTenantId(tenantId);

		
	}

	@Test
	public void testSetTwitterUrl_1()
		throws Exception {
		EventDetail fixture = new EventDetail("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", new JSONArray(), new Double(1.0), "", "", "", "", true, "", new Long(1L), new Long(1L), "", new Long(1L), new Long(1L), "", "", "", "", "", true, EasyMock.createNiceMock(List.class), "");
		String twitterUrl = "";

		fixture.setTwitterUrl(twitterUrl);

		
	}

	
	@Before
	public void setUp()
		throws Exception {
		
	}

	@After
	public void tearDown()
		throws Exception {
		
	}

	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(EventDetailTest.class);
	}
}