package org.egov.pm.repository;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.egov.common.contract.request.RequestInfo;
import org.egov.common.contract.request.Role;
import org.egov.common.contract.request.User;
import org.egov.common.contract.response.ResponseInfo;
import org.egov.pm.PreApplicationRunnerImpl;
import org.egov.pm.model.NOCApplication;
import org.egov.pm.model.NOCApplicationDetail;
import org.egov.pm.model.NOCApplicationRemark;
import org.egov.pm.model.NOCRequestData;
import org.egov.pm.model.ReportModel;
import org.egov.pm.model.RequestData;
import org.egov.pm.producer.Producer;
import org.egov.pm.repository.querybuilder.QueryBuilder;
import org.egov.pm.repository.rowmapper.ColumnsNocRowMapper;
import org.egov.pm.repository.rowmapper.CounterRowMapper;
import org.egov.pm.repository.rowmapper.NocRowMapper;
import org.egov.pm.service.CommonService;
import org.egov.pm.util.CommonConstants;
import org.egov.pm.util.UserUtil;
import org.egov.pm.web.contract.NocResponse;
import org.egov.pm.web.contract.ResponseData;
import org.egov.pm.wf.model.ProcessInstanceRequest;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

@RunWith(MockitoJUnitRunner.Silent.class)
public class NocRepositoryTestCases {

	@Mock
	CommonService commonService;

	@InjectMocks
	private NocRepository nocRepository;

	@Mock
	RestTemplate restTemplate;

	@InjectMocks
	private UserUtil userUtil;

	@Mock
	private JdbcTemplate jdbcTemplate;

	@Mock
	private Producer producer;
	@Mock
	private ResponseData responseData;

	
	@Mock

	private NOCApplication nocApplication;
	
	
	@Mock
	private NOCApplicationRemark nocApplicationRemark;
	@Mock
	QueryBuilder queryBuilder;

	@Mock
	public JSONObject dataPayLoad = new JSONObject();

	@Mock
	private NocRowMapper nocRowMapper;

	@Mock
	private CounterRowMapper counterRowMapper;

	@Mock
	private ColumnsNocRowMapper columnsNocRowMapper;

	@Mock
	private PreApplicationRunnerImpl applicationRunnerImpl;

	@Value("${persister.update.transition.noc.topic}")
	private String updateNOCTopic;

	@Test
	public void testUpdateNOC() throws JsonParseException, JsonMappingException, ParseException, IOException {
		List<Role> roles = new ArrayList<Role>();
		roles.add(Role.builder().code("CITIZEN").build());
		JSONObject dataPayload = new JSONObject();
		dataPayload.put("createdBy", "a14efd6e-ef04-4195-84f3-c5a9c3a11a77");
		dataPayload.put("idName", "ch.pms");
		RequestData requestData = RequestData.builder()
				.requestInfo(RequestInfo.builder()
						.userInfo(User.builder().userName("Prakash").roles(roles).type("CITIZEN").tenantId("ch")
								.uuid("65a14e00-ba5e-4347-be81-08fc04bb0529").build())
						.build())
				.applicationId("PMS-2020-03-25-042731").tenantId("ch").applicationType("PETNOC")
				.dataPayload(dataPayload).build();

		NOCApplicationDetail nocApplicationDetail = new NOCApplicationDetail();
		nocApplicationDetail.setApplicationUuid("a14efd6e-ef04-4195-84f3-c5a9c3a11a77");
		nocApplicationDetail.setTenantId("ch");

		List<NOCApplicationDetail> list = new ArrayList<>();
		list.add(nocApplicationDetail);

		when(jdbcTemplate.query(anyString(), any(Object[].class), any(ResultSetExtractor.class))).thenReturn(list);

		Assert.assertEquals(null, nocRepository.saveValidateStatus(requestData, "INITIATED"));
	}

	@Test
	public void testGetRemarksForNoc() {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("application_uuid", "[]");
		JSONArray ob = new JSONArray();
		ob.add(jsonObject);

		when(jdbcTemplate.query(Matchers.anyString(), any(Object[].class), any(ResultSetExtractor.class)))
				.thenReturn(ob);

		Assert.assertEquals(ob, nocRepository.getRemarksForNoc("ch", "PMS-2020-03-25-042731"));
	}

	@Test
	public void testFindTemplate() {

		/*EmailTemplateModel emailTemplateModel = EmailTemplateModel.builder().emailSubject("Test")
				.applicationType("PETNONC").tenantId("ch").status("APPROVED").build();
		Map<String, EmailTemplateModel> map = new HashMap<>();
		// map.put("Email", emailTemplateModel);

		RequestData requestData = RequestData.builder().applicationStatus("APPROVED").tenantId("ch")
				.applicationType("PETNOC").build();

		when(applicationRunnerImpl.getTemplate(null, null, null)).thenReturn(map);*/
		 nocRepository.findTemplate("hhh", "hhh", "hhh");

	}

	@Test
	public void testFindNoc() {
		List<Role> roles = new ArrayList<Role>();
		roles.add(Role.builder().code("CITIZEN").build());
		JSONObject dataPayload = new JSONObject();
		dataPayload.put("createdBy", "a14efd6e-ef04-4195-84f3-c5a9c3a11a77");

		RequestData requestData = RequestData.builder()
				.requestInfo(RequestInfo.builder()
						.userInfo(User.builder().userName("Prakash").roles(roles).type("CITIZEN").tenantId("ch")
								.uuid("65a14e00-ba5e-4347-be81-08fc04bb0529").build())
						.build())
				.tenantId("ch").applicationType("PETNOC").dataPayload(dataPayload).build();

		String sql = "select EA.noc_number \"applicationId\",EA.tenant_id \"tenantId\",replace(cast(ED.application_detail -> 'nameOfPetDog' as VARCHAR),'\"','') as \"nameOfPetDog\",replace(cast(ED.application_detail -> 'color' as VARCHAR),'\"','') as \"color\",replace(cast(ED.application_detail -> 'breed' as VARCHAR),'\"','') as \"breed\",EA.application_status \"applicationStatus\" from egpm_noc_application_detail ED inner join egpm_noc_application EA on ED.application_uuid=EA.application_uuid WHERE EA.application_type='PETNOC' AND EA.created_by='a14efd6e-ef04-4195-84f3-c5a9c3a11a77' AND EA.is_active=TRUE AND ED.is_active=TRUE";
		when(applicationRunnerImpl.getSqlQuery("ch", "CITIZEN", "PETNOC")).thenReturn(sql);

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("application_uuid", "");
		JSONArray ob2 = new JSONArray();
		// ob2.add(jsonObject);

		when(jdbcTemplate.query(Matchers.contains(sql), any(Object[].class), any(ResultSetExtractor.class)))
				.thenReturn(ob2);

		Assert.assertEquals(ob2, nocRepository.getNoc(requestData));
	}

	@Test
	public void testGetCertificateData() {
		List<Role> roles = new ArrayList<Role>();
		roles.add(Role.builder().code("CITIZEN").build());
		JSONObject dataPayload = new JSONObject();
		dataPayload.put("requestDocumentType", "receiptData");

		String APPLICATION_ID = "PMS-2020-03-25-042731";

		RequestData requestData = RequestData.builder()
				.requestInfo(RequestInfo.builder()
						.userInfo(User.builder().userName("Prakash").roles(roles).type("CITIZEN").tenantId("ch")
								.uuid("65a14e00-ba5e-4347-be81-08fc04bb0529").build())
						.build())
				.applicationId(APPLICATION_ID).tenantId("ch").applicationType("PETNOC").dataPayload(dataPayload)
				.build();

		String sql = "SELECT main.applicant_name as \"applicantName\",main.noc_number as \"applicationId\",TO_CHAR(main.applied_date::DATE, 'DD-MM-YYYY') as \"applicationDate\",main.total_amount as \"Amount\",(select trim(substring(cash_words(main.total_amount::VARCHAR::MONEY), 1, position('dollars' in cash_words(main.total_amount::VARCHAR::MONEY))-1))) AS \"amountinword\",TO_CHAR(TO_TIMESTAMP(remark.created_time / 1000), 'DD-MM-YYYY') AS \"dateofpayment\" FROM egpm_noc_application main left join public.egpm_noc_application_remark remark on main.application_uuid=remark.application_uuid and remark.is_active=main.is_active AND remark.tenant_id=main.tenant_id "
				+ "where main.noc_number'PMS-2020-03-25-042731' AND main.tenant_id='ch' AND main.is_active='true' and main.application_type ='PETNOC' and remark.application_status='PAID'";

		when(applicationRunnerImpl.getCertificateSqlQuery("ch", "PETNOC", "receiptData")).thenReturn(sql);

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("application_uuid", "a14efd6e-ef04-4195-84f3-c5a9c3a11a77");
		JSONArray ob1 = new JSONArray();
		ob1.add(jsonObject);

		

		JSONObject jsonObject2 = new JSONObject();
		jsonObject2.put("application_uuid", "a14efd6e-ef04-4195-84f3-c5a9c3a11a77");
		jsonObject2.put("applicationType", "PETNOC");
		jsonObject2.put("tenantId", "ch");
		JSONArray ob2 = new JSONArray();
		ob2.add(jsonObject2);
		when(jdbcTemplate.query(Matchers.contains(sql), any(Object[].class), any(ResultSetExtractor.class)))
		.thenReturn(ob2);
		Assert.assertEquals(null, nocRepository.getCertificateData(requestData));
	}

	@Test
	public void testViewNoc() {
		List<Role> roles = new ArrayList<Role>();
		roles.add(Role.builder().code("CITIZEN").build());
		JSONObject dataPayload = new JSONObject();
		dataPayload.put("requestDocumentType", "receiptData");

		String APPLICATION_ID = "PMS-2020-03-25-042731";

		RequestData requestData = RequestData.builder()
				.requestInfo(RequestInfo.builder()
						.userInfo(User.builder().userName("Prakash").roles(roles).type("CITIZEN").tenantId("ch")
								.uuid("65a14e00-ba5e-4347-be81-08fc04bb0529").build())
						.build())
				.applicationId(APPLICATION_ID).tenantId("ch").applicationType("PETNOC").dataPayload(dataPayload)
				.build();

		JSONArray actualResult1 = new JSONArray();
		JSONObject actualResultJson1 = new JSONObject();
		actualResultJson1.put("applicationType", "PETNOC");
		actualResultJson1.put("applicationuuid", "a14efd6e-ef04-4195-84f3-c5a9c3a11a77");
		actualResult1.add(actualResultJson1);

		String SELECT_VIEW_QUERY = "select EA.application_uuid applicationUuid, EA.noc_number nocNumber,EA.application_type applicationType,EA.applicant_name applicantName,ED.application_detail applicationDetail,EA.house_number houseNumber,EA.sector sector,EA.applied_date appliedDate,EA.application_status applicationStatus,EA.amount amount,EA.gst_amount gstAmount,EA.performance_bank_guarantee performanceBankGuaranteeCharges,EA.total_amount totalamount from egpm_noc_application_detail ED inner join egpm_noc_application EA on ED.application_uuid=EA.application_uuid WHERE EA.noc_number=? AND EA.is_active=TRUE AND ED.is_active=TRUE";

		when(jdbcTemplate.query(Matchers.contains(SELECT_VIEW_QUERY), any(Object[].class),
				any(ResultSetExtractor.class))).thenReturn(actualResult1);

		JSONArray actualResult2 = new JSONArray();
		JSONObject actualResultJson2 = new JSONObject();
		actualResultJson2.put("applicationStatus", null);
		// actualResultJson2.put("created_by", "65a14e00-ba5e-4347-be81-08fc04bb0529");
		actualResult2.add(actualResultJson2);

		String ALL_REMARKS_QUERY = "select application_uuid applicationUuid,remark,created_by,document_detail documentDetail,application_status applicationStatus, created_time createdTime from egpm_noc_application_remark WHERE application_uuid=? order by created_time DESC";
		when(jdbcTemplate.query(Matchers.contains(ALL_REMARKS_QUERY), any(Object[].class),
				any(ResultSetExtractor.class))).thenReturn(actualResult2);

		JSONArray actualResult3 = new JSONArray();

		actualResultJson1.put("remarks", actualResultJson2);
		actualResult3.add(actualResultJson1);
		 nocRepository.viewNoc(requestData);

	}


	@Test
	public void testSaveValidateStatus() throws ParseException, JsonParseException, JsonMappingException,
			org.json.simple.parser.ParseException, IOException {

		/*
		 * "RequestInfo":{ "userInfo":{ "id":93, "userName":"vaishnavi",
		 * "name":"vaishnavi", "type":"CITIZEN", "roles":[ { "code":"CITIZEN" } ],
		 * "tenantId":"pb.amritsar", "uuid":"65a14e00-ba5e-4347-be81-08fc04bb0529" } }
		 */
		List<Role> roles = new ArrayList<Role>();
		roles.add(Role.builder().code("CITIZEN").build());

		JSONParser parse = new JSONParser();

		JSONObject obj = (JSONObject) parse.parse("{\r\n" + "      \"nameOfPetDog\":\"Rocky\",\r\n"
				+ "      \"applicantName\":\"Prakash Rao\",\r\n" + "      \"houseNo\":\"14\",\r\n"
				+ "      \"sector\":\"Akshardham\",\r\n" + "      \"age\":\"4\",\r\n" + "      \"sex\":\"MALE\",\r\n"
				+ "      \"breed\":\"Indian\",\r\n" + "    \"idName\":\"ch.pms\",   \"color\":\"Blue\",\r\n"
				+ "      \"identificationMark\":\"aaa\",\r\n"
				+ "      \"immunizationNameVeterinaryDoctor\":\"Test\",\r\n"
				+ "      \"veterinaryCouncilRegistrationNo\":\"11\",\r\n"
				+ "      \"immunizationContactDetail\":\"9988779988\",\r\n"
				+ "      \"immunizationClinicNo\":\"1223\",\r\n" + "      \"immunizationSector\":\"aaa\",\r\n"
				+ "      \"uploadPetPicture\":[\r\n" + "         {\r\n" + "            \"fileStoreId\":\"aa12345\"\r\n"
				+ "         }\r\n" + "      ],\r\n" + "      \"uploadVaccinationCertificate\":[\r\n" + "         {\r\n"
				+ "            \"fileStoreId\":\"aaaa12345\"\r\n" + "         }\r\n" + "      ],\r\n"
				+ "      \"remarks\":\"\"\r\n" + "   }");

		RequestData requestData = RequestData.builder()
				.requestInfo(RequestInfo.builder()
						.userInfo(User.builder().userName("Prakash").roles(roles).type("CITIZEN").tenantId("ch")
								.uuid("65a14e00-ba5e-4347-be81-08fc04bb0529").build())
						.build())
				.applicationId(null).applicationStatus("INITIATED").applicationType("PETNOC").dataPayload(obj).build();

		String APPLICATION_ID = "PMS-2020-03-25-042731";
		when(nocRepository.saveValidateStatus(requestData, "INITIATED")).thenReturn(APPLICATION_ID);
		when(commonService.createWorkflowRequest(Matchers.any(ProcessInstanceRequest.class)))
				.thenReturn(ResponseInfo.builder().status("successful").build());

		String SELECT_APPLICATION_ID_QUERY = "select * from egpm_noc_application where noc_number=? AND is_active=TRUE";


		when(jdbcTemplate.query(Matchers.contains(SELECT_APPLICATION_ID_QUERY), any(Object[].class),
				any(ResultSetExtractor.class))).thenReturn(0);

		JSONArray ob = new JSONArray();
		ob.add(new JSONObject().put("application_uuid", "5f7b6de7-8628-4b09-b97c-ecb6d3ac1cd6"));
		String SELECT_APPID_QUERY = "select ED.application_uuid from egpm_noc_application ED WHERE ED.noc_number=?";

		Assert.assertEquals(APPLICATION_ID, nocRepository.saveValidateStatus(requestData, "INITIATED"));

		when(commonService.generateApplicationId(anyString(), anyString())).thenReturn(APPLICATION_ID);
		when(jdbcTemplate.query(anyString(), any(Object[].class), any(ResultSetExtractor.class))).thenReturn(0);

		RequestData requestData2 = RequestData.builder()
				.requestInfo(RequestInfo.builder()
						.userInfo(User.builder().userName("Prakash").roles(roles).type("CITIZEN").tenantId("ch")
								.uuid("65a14e00-ba5e-4347-be81-08fc04bb0529").build())
						.build())
				.applicationId(null).applicationStatus("DRAFT").applicationType("PETNOC").dataPayload(obj).build();
		Assert.assertEquals(APPLICATION_ID, nocRepository.saveValidateStatus(requestData2, "DRAFT"));

		RequestData requestData3 = RequestData.builder()
				.requestInfo(RequestInfo.builder()
						.userInfo(User.builder().userName("Prakash").roles(roles).type("CITIZEN").tenantId("ch")
								.uuid("65a14e00-ba5e-4347-be81-08fc04bb0529").build())
						.build())
				.applicationId(APPLICATION_ID).applicationStatus("DRAFT").applicationType("PETNOC").dataPayload(obj)
				.build();

		List<NOCApplicationDetail> preparedStatementValues = new ArrayList<>();

		NOCApplicationDetail applicationDetail = new NOCApplicationDetail();
		applicationDetail.setApplicationUuid("sjfh823yrf2989398wdh198218794812r");
		applicationDetail.setCreatedBy("1111");
		applicationDetail.setTenantId("ch");
		preparedStatementValues.add(applicationDetail);

		String SELECT_APPLICATION_DETAIL_QUERY = "select application_detail_uuid, application_uuid, application_detail, is_active, created_by, created_time, last_modified_by, last_modified_time, tenant_id from egpm_noc_application_detail where application_uuid=(select application_uuid from egpm_noc_application where noc_number=? and is_active='true') and is_active='true'";
		when(jdbcTemplate.query(Matchers.contains(SELECT_APPLICATION_DETAIL_QUERY), any(Object[].class),
				any(ResultSetExtractor.class))).thenReturn(preparedStatementValues);

		Assert.assertEquals(APPLICATION_ID, nocRepository.saveValidateStatus(requestData3, "DRAFT"));

	}

	@Test
	public void testUpdateAppStatus() throws ParseException, JsonParseException, JsonMappingException, IOException {
		List<Role> roles = new ArrayList<Role>();
		roles.add(Role.builder().code("CITIZEN").build());

		JSONParser parse = new JSONParser();

		JSONObject obj = (JSONObject) parse.parse("{\r\n" + "      \"nameOfPetDog\":\"Rocky\",\r\n"
				+ "      \"applicantName\":\"Prakash Rao\",\r\n" + "      \"houseNo\":\"14\",\r\n"
				+ "      \"sector\":\"Akshardham\",\r\n" + "      \"age\":\"4\",\r\n" + "      \"sex\":\"MALE\",\r\n"
				+ "      \"breed\":\"Indian\",\r\n" + "      \"color\":\"Blue\",\r\n"
				+ "      \"identificationMark\":\"aaa\",\r\n"
				+ "      \"immunizationNameVeterinaryDoctor\":\"Test\",\r\n"
				+ "      \"veterinaryCouncilRegistrationNo\":\"11\",\r\n"
				+ "      \"immunizationContactDetail\":\"9988779988\",\r\n"
				+ "      \"immunizationClinicNo\":\"1223\",\r\n" + "      \"immunizationSector\":\"aaa\",\r\n"
				+ "      \"documentDetail\":[\r\n" + "         {\r\n" + "            \"fileStoreId\":\"aa12345\"\r\n"
				+ "         }\r\n" + "      ],\r\n" + "      \"uploadVaccinationCertificate\":[\r\n" + "         {\r\n"
				+ "            \"documentDetail\":\"aaaa12345\"\r\n" + "         }\r\n" + "      ],\r\n"
			
				+ "      \"remarks\":\"\"\r\n" + "   }");

		String APPLICATION_ID = "PMS-2020-03-25-042731";
		RequestData requestData = RequestData.builder()
				.requestInfo(RequestInfo.builder()
						.userInfo(User.builder().userName("Prakash").roles(roles).type("CITIZEN").tenantId("ch")
								.uuid("65a14e00-ba5e-4347-be81-08fc04bb0529").build())
						.build())
				.applicationId(APPLICATION_ID).applicationStatus("INITIATED").applicationType("PETNOC").dataPayload(obj)
				.build();

		ResponseInfo workflowResponse = ResponseInfo.builder().status("successful").build();

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("application_uuid", "a14efd6e-ef04-4195-84f3-c5a9c3a11a77");
		JSONArray ob = new JSONArray();
		ob.add(jsonObject);
		String SELECT_APPID_QUERY = "select ED.application_uuid from egpm_noc_application ED WHERE ED.noc_number=?";

		ResponseData responseData = ResponseData.builder().responseInfo(
				ResponseInfo.builder().msgId(workflowResponse.getMsgId()).status(CommonConstants.SUCCESS).build())
				.applicationId(APPLICATION_ID).build();

		when(jdbcTemplate.query(Matchers.contains(SELECT_APPID_QUERY), any(Object[].class),
				any(ResultSetExtractor.class))).thenReturn(ob);

		String SELECT_NOC_BY_NOCNUMBER  = "select EA.application_uuid applicationUuid, EA.noc_number nocNumber,EA.application_type applicationType,EA.applicant_name applicantName,EA.house_number houseNumber,EA.sector sector,EA.applied_date appliedDate,EA.application_status applicationStatus,EA.tenant_id tenantId,EA.amount amount,EA.gst_amount gstAmount,EA.performance_bank_guarantee performanceBankGuaranteeCharges,EA.total_amount totalamount,EA.created_by createdBy from egpm_noc_application EA WHERE EA.noc_number=? AND EA.is_active=TRUE";
		String SELECT_APPLICATION_DETAIL_QUERY  = "select application_detail_uuid, application_uuid, application_detail, is_active, created_by, created_time, last_modified_by, last_modified_time, tenant_id from egpm_noc_application_detail where application_uuid=(select application_uuid from egpm_noc_application where noc_number=? and is_active='true') and is_active='true'";
		JSONObject jsonObject2 = new JSONObject();
		// jsonObject2.put("application_uuid", "a14efd6e-ef04-4195-84f3-c5a9c3a11a77");
		JSONArray ob2 = new JSONArray();
		jsonObject.put("applicationuuid", "123");
		jsonObject.put("tenantid", "123");
		jsonObject.put("gstAmount", "123");
	jsonObject.put("gstamount", "123");
		jsonObject.put("performancebankguaranteecharges", "123");
		jsonObject.put("amount", "123");
		jsonObject.put("totalamount", "123");
		jsonObject.put("createdby", "123");
		jsonObject.put("badgeNumber", "123");
		jsonObject.put("createdby", "123");

		
		ob2.add(jsonObject);

		when(jdbcTemplate.query(Matchers.contains(SELECT_NOC_BY_NOCNUMBER), any(Object[].class),
				any(ResultSetExtractor.class))).thenReturn(ob2);
		when(jdbcTemplate.query(Matchers.contains(SELECT_APPLICATION_DETAIL_QUERY), any(Object[].class),
				any(ResultSetExtractor.class))).thenReturn(ob2);
		String SELECT_FALLBACK_QUERY =   "select EA.application_uuid as applicationUuid, EA.noc_number as nocNumber,EA.application_type as applicationType,\r\n"
				+ "EA.applicant_name as applicantName,ED.application_detail as applicationDetail,EA.house_number as houseNumber,\r\n"
				+ "EA.sector as sector,EA.applied_date as appliedDate,EA.application_status as applicationStatus,\r\n"
				+ "EA.amount as amount,EA.gst_amount as gstAmount,EA.performance_bank_guarantee as performanceBankGuaranteeCharges,\r\n"
				+ "EA.total_amount as totalamount,ER.remark_id as remarkid\r\n"
				+ "from egpm_noc_application EA inner join egpm_noc_application_detail ED on EA.application_uuid=ED.application_uuid inner join egpm_noc_application_remark ER on EA.application_uuid=ER.application_uuid  where EA.noc_number=?\r\n"
				+ "and EA.is_active=true and ED.is_active=true and ER.is_active=true";


		JSONObject jsonObject1 = new JSONObject();
		jsonObject1.put("nocnumber", "a14efd6e-ef04-4195-84f3-c5a9c3a11a77");
		jsonObject1.put("amount", "100");
		jsonObject1.put("performancebankguaranteecharges", "100");
		jsonObject1.put("gstamount", "100");
		jsonObject1.put("totalamount", "100");
		jsonObject1.put("applicationstatus", "a14efd6e-ef04-4195-84f3-c5a9c3a11a77");
		jsonObject1.put("applicantname", "a14efd6e-ef04-4195-84f3-c5a9c3a11a77");
		jsonObject1.put("housenumber", "a14efd6e-ef04-4195-84f3-c5a9c3a11a77");
		jsonObject1.put("sector", "a14efd6e-ef04-4195-84f3-c5a9c3a11a77");
		jsonObject1.put("applicationuuid", "a14efd6e-ef04-4195-84f3-c5a9c3a11a77");
		jsonObject1.put("remarkid", "a14efd6e-ef04-4195-84f3-c5a9c3a11a77");
		jsonObject1.put("applicationdetail", "a14efd6e-ef04-4195-84f3-c5a9c3a11a77");
		nocApplicationRemark.setApplicationUuid("WHW");
		nocApplication.setNocApplicationRemark(nocApplicationRemark);
		JSONArray ob1 = new JSONArray();
		ob1.add(jsonObject1);
		when(jdbcTemplate.query(Matchers.contains(SELECT_FALLBACK_QUERY), any(Object[].class),
				any(ResultSetExtractor.class))).thenReturn(ob1);
		
		NocRepository nocRepository2 = Mockito.spy(nocRepository);
		
		nocRepository.updateAppStatus(requestData);
		
	}

	@Test
	public void testSaveNoc() {
		List<Role> roles = new ArrayList<Role>();
		roles.add(Role.builder().code("CITIZEN").build());
		JSONObject dataPayload = new JSONObject();
		dataPayload.put("createdBy", "a14efd6e-ef04-4195-84f3-c5a9c3a11a77");
		RequestData requestData = RequestData.builder()
				.requestInfo(RequestInfo.builder()
						.userInfo(User.builder().userName("Prakash").roles(roles).type("CITIZEN").tenantId("ch")
								.uuid("65a14e00-ba5e-4347-be81-08fc04bb0529").build())
						.build())
				.applicationId("PMS-2020-03-25-042731").tenantId("ch").applicationType("PETNOC")
				.dataPayload(dataPayload).build();

		when(jdbcTemplate.query(anyString(), any(Object[].class), any(ResultSetExtractor.class))).thenReturn(0);
		// when(nocRepository.saveNOCDetails(requestData,"","PMS-2020-03-25-042731")).thenReturn(NOCApplicationDetail.builder().build());

		Assert.assertEquals("PMS-2020-03-25-042731",
				nocRepository.saveNoc(requestData, "INITIATED", "PMS-2020-03-25-042731"));

	}

	@Test
	public void testValidateApplicationId() {

		when(jdbcTemplate.query(anyString(), any(Object[].class), any(ResultSetExtractor.class))).thenReturn(1);
		Assert.assertEquals(Integer.parseInt("1"),
				Integer.parseInt("" + nocRepository.validateApplicationId("PMS-2020-03-25-042731")));

	}

	@Test
	public void testGetUserByNocNumber() {
		String applicationId = "PMS-2020-03-25-042731";
		String SELECT_USER_BY_APPLICATION_ID_QUERY = "select created_by,total_amount from egpm_noc_application where noc_number=? AND is_active=TRUE";
		when(jdbcTemplate.queryForObject(Matchers.contains(SELECT_USER_BY_APPLICATION_ID_QUERY), Matchers.anyObject(),
				Matchers.eq(String.class))).thenReturn("a14efd6e-ef04-4195-84f3-c5a9c3a11a77");
		List<Map<String, Object>> rsMapList = jdbcTemplate
				.queryForList(QueryBuilder.SELECT_USER_BY_APPLICATION_ID_QUERY, new Object[] { applicationId });
		Assert.assertEquals(rsMapList, nocRepository.getUserByNocNumber("PMS-2020-03-25-042731"));

	}

	@Test
	public void testUpdateApplicationStatus()
			throws ParseException, JsonParseException, JsonMappingException, IOException {

		List<Role> roles = new ArrayList<Role>();
		roles.add(Role.builder().code("CITIZEN").build());

		JSONParser parse = new JSONParser();

		JSONObject obj = (JSONObject) parse.parse("{\r\n" + "      \"nameOfPetDog\":\"Rocky\",\r\n"
				+ "      \"applicantName\":\"Prakash Rao\",\r\n" + "      \"houseNo\":\"14\",\r\n"
				+ "      \"sector\":\"Akshardham\",\r\n" + "      \"age\":\"4\",\r\n" + "      \"sex\":\"MALE\",\r\n"
				+ "      \"breed\":\"Indian\",\r\n" + "      \"color\":\"Blue\",\r\n"
				+ "      \"identificationMark\":\"aaa\",\r\n"
				+ "      \"immunizationNameVeterinaryDoctor\":\"Test\",\r\n"
				+ "      \"veterinaryCouncilRegistrationNo\":\"11\",\r\n"
				+ "      \"immunizationContactDetail\":\"9988779988\",\r\n"
				+ "      \"immunizationClinicNo\":\"1223\",\r\n" + "      \"immunizationSector\":\"aaa\",\r\n"
				+ "      \"uploadPetPicture\":[\r\n" + "         {\r\n" + "            \"fileStoreId\":\"aa12345\"\r\n"
				+ "         }\r\n" + "      ],\r\n" + "      \"uploadVaccinationCertificate\":[\r\n" + "         {\r\n"
				+ "            \"fileStoreId\":\"aaaa12345\"\r\n" + "         }\r\n" + "      ],\r\n"
				+ "      \"remarks\":\"\"\r\n" + "   }");

		String APPLICATION_ID = "PMS-2020-03-25-042731";

		JSONObject documentList = new JSONObject();
		documentList.put("fileStoreId", "AHDJHAJHAJDHJHJAHDHAJHDJ");
		JSONArray jsonArray = new JSONArray();
		// jsonArray.add(documentList);

		// JSONObject data = new JSONObject();
		obj.put("uploadDocuments", jsonArray);

		RequestData requestData = RequestData.builder()
				.requestInfo(RequestInfo.builder()
						.userInfo(User.builder().userName("Prakash").roles(roles).type("CITIZEN").tenantId("ch")
								.uuid("65a14e00-ba5e-4347-be81-08fc04bb0529").build())
						.build())
				.applicationId(APPLICATION_ID).applicationStatus("INITIATED").applicationType("PETNOC").dataPayload(obj)
				.build();

		ResponseInfo workflowResponse = ResponseInfo.builder().status("successful").build();
		when(commonService.createWorkflowRequest(any(ProcessInstanceRequest.class))).thenReturn(workflowResponse);

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("application_uuid", "a14efd6e-ef04-4195-84f3-c5a9c3a11a77");
		JSONArray ob = new JSONArray();
		ob.add(jsonObject);

		String SELECT_APPID_QUERY = "select ED.application_uuid from egpm_noc_application ED WHERE ED.noc_number=?";

		ResponseData responseData = ResponseData.builder().responseInfo(
				ResponseInfo.builder().msgId(workflowResponse.getMsgId()).status(CommonConstants.SUCCESS).build())
				.applicationId(APPLICATION_ID).build();

		when(jdbcTemplate.query(Matchers.contains(SELECT_APPID_QUERY), any(Object[].class),
				any(ResultSetExtractor.class))).thenReturn(ob);

		String SELECT_NOC_BY_NOCNUMBER = "select EA.application_uuid applicationUuid, EA.noc_number nocNumber,EA.application_type applicationType,EA.applicant_name applicantName,EA.house_number houseNumber,EA.sector sector,EA.applied_date appliedDate,EA.application_status applicationStatus,EA.amount amount,EA.gst_amount gstAmount,EA.performance_bank_guarantee performanceBankGuaranteeCharges from egpm_noc_application EA WHERE EA.noc_number=? AND EA.is_active=TRUE";
		JSONObject jsonObject2 = new JSONObject();
		jsonObject2.put("application_uuid", "a14efd6e-ef04-4195-84f3-c5a9c3a11a77");
		JSONArray ob2 = new JSONArray();
		ob2.add(jsonObject);

		when(jdbcTemplate.query(Matchers.contains(SELECT_NOC_BY_NOCNUMBER), any(Object[].class),
				any(ResultSetExtractor.class))).thenReturn(ob2);

		ResponseData responseData2 = ResponseData.builder().responseInfo(
				ResponseInfo.builder().msgId(workflowResponse.getMsgId()).status(CommonConstants.SUCCESS).build())
				.applicationId(APPLICATION_ID).build();

		Assert.assertEquals("Fail",
				nocRepository.updateAppStatus(requestData).getResponseInfo().getStatus().toString());

	}

	@Test
	public void testgenerateReport() {
		ReportModel value = ReportModel.builder().build();
		value.setTotalAveragePendingGreaterThan30Days("12");
		value.setTotalAveragePending10DayasTo30Days("154");
		value.setTotalAverage("154");
		value.setTenantId("ch");
		value.setApplicationType("NOCTYPE");
		List<ReportModel> listOfResult = new ArrayList<>();
		nocRepository.generateReport(listOfResult);

	}

	@Test
	public void testFindRemarks() {
		when(jdbcTemplate.query(anyString(), any(Object[].class), any(ResultSetExtractor.class))).thenReturn(1);

		Assert.assertEquals(Integer.parseInt("1"),
				Integer.parseInt("" + nocRepository.findRemarks("PMS-2020-03-25-042731")));
	}

	@Test
	public void testviewpricebook() {

		JSONObject dataPayload = new JSONObject();
		dataPayload.put("priceBookId", "123");
		RequestData requestData = RequestData.builder().requestInfo(RequestInfo.builder().build())
				.dataPayload(dataPayload).build();
		NocResponse res = new NocResponse();
		Assert.assertEquals(null, nocRepository.viewPriceBook(requestData));
	}

	@Test
	public void testviewpricebookid() {

		JSONObject dataPayload = new JSONObject();
		dataPayload.put("priceBookId", "123");
		RequestData requestData = RequestData.builder().requestInfo(RequestInfo.builder().build())
				.dataPayload(dataPayload).build();
		Assert.assertEquals(null, nocRepository.viewPriceBookById(requestData));

	}

	@Test
	public void testupdatepricebookid() {
		JSONObject dataPayload = new JSONObject();
		dataPayload.put("priceBookId", "123");
		dataPayload.put("annualPrice", "0");
		dataPayload.put("perWeekPrice", "0");
		dataPayload.put("perMonthPrice", "0");
		dataPayload.put("fixedPrice", "0");
		dataPayload.put("perDayPrice", "0");

		RequestData requestData = RequestData.builder().requestInfo(RequestInfo.builder().build())
				.dataPayload(dataPayload).build();
		NocResponse res = new NocResponse();
		ResponseInfo resposneInfo = new ResponseInfo();
		resposneInfo.setStatus("success");
		res.setResposneInfo(resposneInfo);
		Assert.assertEquals(res, nocRepository.updatepricebook(requestData));

	}
	@Test
	public void testupdatepricebookid1() {
		JSONObject dataPayload = new JSONObject();
		dataPayload.put("application_uuid", "a14efd6e-ef04-4195-84f3-c5a9c3a11a77");
		dataPayload.put("categoryId", "123");
		dataPayload.put("subCategoryId", "0");
		dataPayload.put("annualPrice", "0");
		dataPayload.put("perWeekPrice", "0");
		dataPayload.put("perMonthPrice", "0");
		dataPayload.put("fixedPrice", "0");
		dataPayload.put("perDayPrice", "0");
		
		RequestData requestData = RequestData.builder().requestInfo(RequestInfo.builder().build())
				.dataPayload(dataPayload).build();
		NocResponse res = new NocResponse();
		ResponseInfo resposneInfo = new ResponseInfo();
		resposneInfo.setStatus("success");
		res.setResposneInfo(resposneInfo);
		Assert.assertEquals(res, nocRepository.updatepricebook(requestData));

	}
	@Test
	public void updatenoc() {
		JSONObject dataPayload = new JSONObject();
		dataPayload.put("effectiveFromDate", "2019-07-20");
		dataPayload.put("categoryId", "20");
		dataPayload.put("subCategoryId", "20");
		dataPayload.put("applicantName", "20");
		dataPayload.put("houseNo", "20");
		dataPayload.put("sector", "20");
		
		User userInfo=new User();
		userInfo.setUuid("123");
		RequestData requestData = RequestData.builder().requestInfo(RequestInfo.builder().userInfo(userInfo).build())
				.dataPayload(dataPayload).applicationType("PETNOC").build();
		NocResponse res = new NocResponse();
		ResponseInfo resposneInfo = new ResponseInfo();
		resposneInfo.setStatus("success");
		res.setResposneInfo(resposneInfo);
		String SELECT_APPLICATION_DETAIL_QUERY = "select application_detail_uuid, application_uuid, application_detail, is_active, created_by, created_time, last_modified_by, last_modified_time, tenant_id from egpm_noc_application_detail where application_uuid=(select application_uuid from egpm_noc_application where noc_number=? and is_active='true') and is_active='true'";
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("applicantName", "a14efd6e-ef04-4195-84f3-c5a9c3a11a77");
		jsonObject.put("houseNo", "a14efd6e-ef04-4195-84f3-c5a9c3a11a77");
		jsonObject.put("sector", "a14efd6e-ef04-4195-84f3-c5a9c3a11a77");
		JSONArray ob = new JSONArray();
		ob.add(jsonObject);
		List<NOCApplicationDetail> preparedStatementValues=new ArrayList<>();
		
		ob.add(jsonObject);
		when(jdbcTemplate.query(Matchers.contains(SELECT_APPLICATION_DETAIL_QUERY), any(Object[].class),
				any(ResultSetExtractor.class))).thenReturn(preparedStatementValues);
	
		nocRepository.updateNOC(requestData, SELECT_APPLICATION_DETAIL_QUERY);

	}
	@Test
	public void updatepricebookdate() {
		JSONObject dataPayload = new JSONObject();
		dataPayload.put("effectiveFromDate", "2019-07-20");
		dataPayload.put("categoryId", "20");
		dataPayload.put("subCategoryId", "20");
		
		User userInfo=new User();
		userInfo.setUuid("123");
		RequestData requestData = RequestData.builder().requestInfo(RequestInfo.builder().userInfo(userInfo).build())
				.dataPayload(dataPayload).applicationType("PETNOC").build();
		NocResponse res = new NocResponse();
		ResponseInfo resposneInfo = new ResponseInfo();
		resposneInfo.setStatus("success");
		res.setResposneInfo(resposneInfo);
		String SELECT_PRICE_BOOK_INBETWEEN_QUERY = " SELECT price_book_id,min_sqft,max_sqft, calculation_sequence, calculation_type FROM egpm_noc_price_book WHERE category_id=? and sub_category_id=? AND to_date(?, 'YYYY-MM-DD') between effective_from_date::date and coalesce(effective_to_date::date,current_timestamp + interval '100 year') and application_type=? ";

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("application_uuid", "a14efd6e-ef04-4195-84f3-c5a9c3a11a77");
		JSONArray ob = new JSONArray();
		ob.add(jsonObject);
		when(jdbcTemplate.query(Matchers.contains(SELECT_PRICE_BOOK_INBETWEEN_QUERY), any(Object[].class),
				any(ResultSetExtractor.class))).thenReturn(ob);
		Assert.assertEquals(res, nocRepository.updatepricebookdate(requestData));

	}

	@Test
	public void getAppIdUuid() {
		String SELECT_APPID_QUERY = "select ED.application_uuid from egpm_noc_application ED WHERE ED.noc_number=?";

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("application_uuid", "a14efd6e-ef04-4195-84f3-c5a9c3a11a77");
		JSONArray ob = new JSONArray();
		ob.add(jsonObject);
		when(jdbcTemplate.query(Matchers.contains(SELECT_APPID_QUERY), any(Object[].class),
				any(ResultSetExtractor.class))).thenReturn(ob);
		 nocRepository.getAppIdUuid("req:");

	}

	@Test
	public void getpricebook() throws java.text.ParseException {
		JSONObject dataPayload = new JSONObject();
		dataPayload.put("effectiveFromDate", "2019-07-20");
		RequestData requestData = RequestData.builder().requestInfo(RequestInfo.builder().build())
				.dataPayload(dataPayload).build();
		String SELECT_PRICE_BOOK_INBETWEEN_QUERY = " SELECT price_book_id,min_sqft,max_sqft, calculation_sequence, calculation_type FROM egpm_noc_price_book WHERE category_id=? and sub_category_id=? AND to_date(?, 'YYYY-MM-DD') between effective_from_date::date and coalesce(effective_to_date::date,current_timestamp + interval '100 year') and application_type=? ";

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("application_uuid", "a14efd6e-ef04-4195-84f3-c5a9c3a11a77");
		JSONArray ob = new JSONArray();
		ob.add(jsonObject);
		when(jdbcTemplate.query(Matchers.contains(SELECT_PRICE_BOOK_INBETWEEN_QUERY), any(Object[].class),
				any(ResultSetExtractor.class))).thenReturn(1);
		// int i=Integer.parseInt("1");
		// Assert.assertEquals("1", nocRepository.getpricebook(requestData,1));
		Assert.assertEquals(Integer.parseInt("1"), Integer.parseInt("" + nocRepository.getpricebook(requestData, 1)));

	}

	@Test
	public void getpricebook1() throws java.text.ParseException {
		JSONObject dataPayload = new JSONObject();
		dataPayload.put("effectiveFromDate", "2019-07-20");
		RequestData requestData = RequestData.builder().requestInfo(RequestInfo.builder().build())
				.dataPayload(dataPayload).build();
		String SELECT_PRICE_BOOK_INBETWEEN_QUERY = " SELECT price_book_id,min_sqft,max_sqft, calculation_sequence, calculation_type FROM egpm_noc_price_book WHERE category_id=? and sub_category_id=? AND to_date(?, 'YYYY-MM-DD') between effective_from_date::date and coalesce(effective_to_date::date,current_timestamp + interval '100 year') and application_type=? ";

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("application_uuid", "a14efd6e-ef04-4195-84f3-c5a9c3a11a77");
		JSONArray ob = new JSONArray();
		ob.add(jsonObject);
		when(jdbcTemplate.query(Matchers.contains(SELECT_PRICE_BOOK_INBETWEEN_QUERY), any(Object[].class),
				any(ResultSetExtractor.class))).thenReturn(1);
		// int i=Integer.parseInt("1");
		// Assert.assertEquals("1", nocRepository.getpricebook(requestData,0));
		int i=0;
		nocRepository.getpricebook(requestData, i);

	}

	@Test
	public void getCurrentDate() {
		nocRepository.getCurrentDate();
	}
	
	 

	@Test
	public void workflowIntegration() {
	
		JSONObject dataPayload = new JSONObject();
		dataPayload.put("effectiveFromDate", "2019-07-20");
	//	dataPayload.put("uploadDocuments", "a14efd6e-ef04-4195-84f3-c5a9c3a11a77");
		String SELECT_APPID_QUERY = "select ED.application_uuid from egpm_noc_application ED WHERE ED.noc_number=?";
		
		//String SELECT_APPID_QUERY=""
		
		RequestInfo rs=new RequestInfo();
		User userInfo=new User();
		userInfo.setType("EMPLOYEE");
		List<Role> roles=new ArrayList<>();
		Role e=new Role();
		e.setCode("code");
		roles.add(e);
		userInfo.setRoles(roles);
		rs.setUserInfo(userInfo);
		RequestData requestData = new RequestData();
		requestData.setRequestInfo(rs);
		requestData.setDataPayload(dataPayload);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("application_uuid", "a14efd6e-ef04-4195-84f3-c5a9c3a11a77");
			
		JSONArray ob = new JSONArray();
		ob.add(jsonObject);
		when(jdbcTemplate.query(Matchers.contains(SELECT_APPID_QUERY), any(Object[].class),
				any(ResultSetExtractor.class))).thenReturn(ob);
		//Assert.assertEquals("a14efd6e-ef04-4195-84f3-c5a9c3a11a77", nocRepository.getAppIdUuid("req:"));
		
		
		try {
			nocRepository.workflowIntegration("applicationId",requestData,"status");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	@Test
	public void testsetFallBack() {
		String SELECT_FALLBACK_QUERY =   "select EA.application_uuid as applicationUuid, EA.noc_number as nocNumber,EA.application_type as applicationType,\r\n"
				+ "EA.applicant_name as applicantName,ED.application_detail as applicationDetail,EA.house_number as houseNumber,\r\n"
				+ "EA.sector as sector,EA.applied_date as appliedDate,EA.application_status as applicationStatus,\r\n"
				+ "EA.amount as amount,EA.gst_amount as gstAmount,EA.performance_bank_guarantee as performanceBankGuaranteeCharges,\r\n"
				+ "EA.total_amount as totalamount,ER.remark_id as remarkid\r\n"
				+ "from egpm_noc_application EA inner join egpm_noc_application_detail ED on EA.application_uuid=ED.application_uuid inner join egpm_noc_application_remark ER on EA.application_uuid=ER.application_uuid  where EA.noc_number=?\r\n"
				+ "and EA.is_active=true and ED.is_active=true and ER.is_active=true";


		JSONObject jsonObject = new JSONObject();
		jsonObject.put("nocnumber", "a14efd6e-ef04-4195-84f3-c5a9c3a11a77");
		jsonObject.put("amount", "100");
		jsonObject.put("performancebankguaranteecharges", "100");
		jsonObject.put("gstamount", "100");
		jsonObject.put("totalamount", "100");
		jsonObject.put("applicationstatus", "a14efd6e-ef04-4195-84f3-c5a9c3a11a77");
		jsonObject.put("applicantname", "a14efd6e-ef04-4195-84f3-c5a9c3a11a77");
		jsonObject.put("housenumber", "a14efd6e-ef04-4195-84f3-c5a9c3a11a77");
		jsonObject.put("sector", "a14efd6e-ef04-4195-84f3-c5a9c3a11a77");
		jsonObject.put("applicationuuid", "a14efd6e-ef04-4195-84f3-c5a9c3a11a77");
		jsonObject.put("remarkid", "a14efd6e-ef04-4195-84f3-c5a9c3a11a77");
		jsonObject.put("applicationdetail", "a14efd6e-ef04-4195-84f3-c5a9c3a11a77");
		
		
		JSONArray ob = new JSONArray();
		ob.add(jsonObject);
		when(jdbcTemplate.query(Matchers.contains(SELECT_FALLBACK_QUERY), any(Object[].class),
				any(ResultSetExtractor.class))).thenReturn(ob);
		
				nocRepository.setFallBack("PMS-2020-03-25-042731");

	}
	
	

	@Test
	public void callWorkflow()  {
		JSONObject dataPayload = new JSONObject();
		dataPayload.put("effectiveFromDate", "2019-07-20");
		RequestData requestData = RequestData.builder().requestInfo(RequestInfo.builder().build())
				.dataPayload(dataPayload).build();
		String SELECT_PRICE_BOOK_INBETWEEN_QUERY = " SELECT price_book_id,min_sqft,max_sqft, calculation_sequence, calculation_type FROM egpm_noc_price_book WHERE category_id=? and sub_category_id=? AND to_date(?, 'YYYY-MM-DD') between effective_from_date::date and coalesce(effective_to_date::date,current_timestamp + interval '100 year') and application_type=? ";

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("application_uuid", "a14efd6e-ef04-4195-84f3-c5a9c3a11a77");
		JSONArray ob = new JSONArray();
		ob.add(jsonObject);
		when(jdbcTemplate.query(Matchers.contains(SELECT_PRICE_BOOK_INBETWEEN_QUERY), any(Object[].class),
				any(ResultSetExtractor.class))).thenReturn(1);
		NOCRequestData req=new NOCRequestData();
		
		nocRepository.callWorkflow(requestData, "PMS-2020-03-25-042731", req);

	}

}
