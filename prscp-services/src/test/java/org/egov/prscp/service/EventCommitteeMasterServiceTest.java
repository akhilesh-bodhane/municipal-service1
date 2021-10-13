package org.egov.prscp.service;

import java.util.ArrayList;
import java.util.List;

import org.egov.prscp.config.PrScpConfiguration;
import org.egov.prscp.producer.Producer;
import org.egov.prscp.repository.EventCommitteeMasterRepository;
import org.egov.prscp.util.CommonConstants;
import org.egov.prscp.util.PrScpUtil;
import org.egov.prscp.web.models.AuditDetails;
import org.egov.prscp.web.models.CommitteeDetail;
import org.egov.prscp.web.models.CommitteeMember;
import org.egov.prscp.web.models.Library;
import org.egov.prscp.web.models.RequestInfoWrapper;
import org.egov.tracer.model.CustomException;
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
public class EventCommitteeMasterServiceTest {

	@Mock
	private ObjectMapper objectMapper;

	@Mock
	private EventCommitteeMasterRepository repository;

	@Mock
	private Producer producer;

	@Mock
	private PrScpConfiguration config;
	@Mock
	private PrScpUtil prScpUtil;

	@InjectMocks
	private EventCommitteeMasterService service;

	@Test
	public void testCreateCommittee() throws ParseException {

		List<CommitteeMember> list = new ArrayList<>();

		CommitteeMember committeeMember = CommitteeMember.builder().departmentUuid("321143").departmentUuid("2323232")
				.build();

		list.add(committeeMember);

		CommitteeDetail committeeDetail = CommitteeDetail.builder().committeeName("Test Purpose")
				.committeeDescription("Test Purpose").committeeMember(list).build();

		AuditDetails auditDetails = AuditDetails.builder().createdBy("1").createdTime(1546515646L).lastModifiedBy("1")
				.lastModifiedTime(15645455L).build();

		RequestInfoWrapper infoWrapper = RequestInfoWrapper.builder().auditDetails(auditDetails)
				.requestBody(committeeDetail).build();

		Mockito.when(objectMapper.convertValue(infoWrapper.getRequestBody(), CommitteeDetail.class))
				.thenReturn(committeeDetail);
		Gson gson = new Gson();
		String payloadData = gson.toJson(committeeDetail, CommitteeDetail.class);
		String librarys = "";
		Mockito.when(prScpUtil.validateJsonAddUpdateData(payloadData,CommonConstants.COMMITTEEMASTERCREATE)).thenReturn(librarys);
		Assert.assertEquals(HttpStatus.CREATED, service.createCommittee(infoWrapper).getStatusCode());

	}

	@Test
	public void testTwoCreateCommittee() throws ParseException {

		List<CommitteeMember> list = new ArrayList<>();

		CommitteeDetail committeeDetail = CommitteeDetail.builder().committeeName("Test Purpose")
				.committeeDescription("Test Purpose").committeeMember(list).build();

		AuditDetails auditDetails = AuditDetails.builder().createdBy("1").createdTime(1546515646L).lastModifiedBy("1")
				.lastModifiedTime(15645455L).build();

		RequestInfoWrapper infoWrapper = RequestInfoWrapper.builder().auditDetails(auditDetails)
				.requestBody(committeeDetail).build();

		Mockito.when(objectMapper.convertValue(infoWrapper.getRequestBody(), CommitteeDetail.class))
				.thenReturn(committeeDetail);

		List<CommitteeDetail> listCommitteeDetail = new ArrayList<>();

		listCommitteeDetail.add(committeeDetail);

		Mockito.when(repository.getCommittee(Matchers.anyObject())).thenReturn(listCommitteeDetail);
		Gson gson = new Gson();
		String payloadData = gson.toJson(committeeDetail, CommitteeDetail.class);
		String librarys = "";
		Mockito.when(prScpUtil.validateJsonAddUpdateData(payloadData,CommonConstants.COMMITTEEMASTERCREATE)).thenReturn("");
		Assert.assertEquals(HttpStatus.CREATED, service.createCommittee(infoWrapper).getStatusCode());

	}

	@Test(expected = CustomException.class)
	public void testTwoCreateCommittee_1() {
		RequestInfoWrapper infoWrapper = RequestInfoWrapper.builder().auditDetails(null).requestBody(null).build();
		Assert.assertEquals(HttpStatus.OK, service.createCommittee(infoWrapper).getStatusCode());
	}

	@Test
	public void testOneUpdateCommittee() throws ParseException {

		List<CommitteeMember> list = new ArrayList<>();

		CommitteeMember committeeMember = CommitteeMember.builder().departmentUuid("321143").departmentUuid("2323232")
				.build();

		list.add(committeeMember);

		CommitteeDetail committeeDetail = CommitteeDetail.builder()
				.committeeUuid("ee9c4698-3e55-4bd2-a4a2-352b48c0bdb0").committeeName("Test Purpose")
				.committeeDescription("Test Purpose").committeeMember(list).build();

		AuditDetails auditDetails = AuditDetails.builder().createdBy("1").createdTime(1546515646L).lastModifiedBy("1")
				.lastModifiedTime(15645455L).build();

		RequestInfoWrapper infoWrapper = RequestInfoWrapper.builder().auditDetails(auditDetails)
				.requestBody(committeeDetail).build();
		Mockito.when(objectMapper.convertValue(infoWrapper.getRequestBody(), CommitteeDetail.class))
				.thenReturn(committeeDetail);

		Mockito.when(objectMapper.convertValue(infoWrapper.getRequestBody(), CommitteeDetail.class))
				.thenReturn(committeeDetail);

		List<CommitteeDetail> listCommitteeDetail = new ArrayList<>();

		listCommitteeDetail.add(committeeDetail);

		Mockito.when(repository.getCommittee(Matchers.anyObject())).thenReturn(listCommitteeDetail);

		// Mockito.when(repository.getCommittee(Matchers.anyObject())).thenReturn(listCommitteeDetail);
		Gson gson = new Gson();
		String payloadData = gson.toJson(committeeDetail, CommitteeDetail.class);
		String librarys = "";
		Mockito.when(prScpUtil.validateJsonAddUpdateData(payloadData,CommonConstants.COMMITTEEMASTERUPDATE)).thenReturn(librarys);
		Assert.assertEquals(HttpStatus.OK, service.updateCommittee(infoWrapper).getStatusCode());
	}

	@Test(expected = CustomException.class)
	public void testOneUpdateCommittee_1() {
		RequestInfoWrapper infoWrapper = RequestInfoWrapper.builder().auditDetails(null).requestBody(null).build();
		Assert.assertEquals(HttpStatus.OK, service.updateCommittee(infoWrapper).getStatusCode());
	}

	@Test
	public void testTwoUpdateCommittee() throws ParseException {
		List<CommitteeMember> listCommitteeMember = new ArrayList<>();
		CommitteeMember member = CommitteeMember.builder().departmentName("IT").departmentUuid("aksnd2dn29d")
				.userUuid("15a5sf4f5f").build();
		listCommitteeMember.add(member);

		Mockito.when(repository.getCommitteeByName(Matchers.any(CommitteeDetail.class))).thenReturn(null);

		CommitteeDetail committeeDetail = CommitteeDetail.builder().committeeUuid("jqiw8923d32d").build();
		committeeDetail.setCommitteeMember(listCommitteeMember);
		List<CommitteeDetail> list = new ArrayList<>();
		list.add(committeeDetail);

		Mockito.when(repository.getCommittee(Matchers.any(CommitteeDetail.class))).thenReturn(list);

		AuditDetails auditDetails = AuditDetails.builder().createdBy("1").createdTime(1546515646L).lastModifiedBy("1")
				.lastModifiedTime(15645455L).build();

		RequestInfoWrapper infoWrapper = RequestInfoWrapper.builder().auditDetails(auditDetails)
				.requestBody(committeeDetail).build();
		Mockito.when(objectMapper.convertValue(infoWrapper.getRequestBody(), CommitteeDetail.class))
				.thenReturn(committeeDetail);
		Gson gson = new Gson();
		String payloadData = gson.toJson(committeeDetail, CommitteeDetail.class);
		String librarys = "";
		Mockito.when(prScpUtil.validateJsonAddUpdateData(payloadData,CommonConstants.COMMITTEEMASTERUPDATE)).thenReturn(librarys);
		Assert.assertEquals(HttpStatus.OK, service.updateCommittee(infoWrapper).getStatusCode());
	}

	@Test
	public void testGetCommittee() throws ParseException {

		CommitteeDetail committeeDetail = CommitteeDetail.builder()
				.committeeUuid("ee9c4698-3e55-4bd2-a4a2-352b48c0bdb0").build();

		RequestInfoWrapper infoWrapper = RequestInfoWrapper.builder().requestBody(committeeDetail).build();
		Mockito.when(objectMapper.convertValue(infoWrapper.getRequestBody(), CommitteeDetail.class))
				.thenReturn(committeeDetail);

		Mockito.when(repository.getCommittee(committeeDetail)).thenReturn(new ArrayList<CommitteeDetail>());
		Gson gson = new Gson();
		String payloadData = gson.toJson(committeeDetail, CommitteeDetail.class);
		String librarys = "";
		Mockito.when(prScpUtil.validateJsonAddUpdateData(payloadData,CommonConstants.COMMITTEEMASTERGET)).thenReturn(librarys);
		Assert.assertEquals(HttpStatus.OK, service.getCommittee(infoWrapper).getStatusCode());
	}
}
