package org.egov.pm.service;

import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.egov.common.contract.request.RequestInfo;
import org.egov.common.contract.request.Role;
import org.egov.common.contract.request.User;
import org.egov.common.contract.response.ResponseInfo;
import org.egov.pm.NocApplication;
import org.egov.pm.PreApplicationRunnerImpl;
import org.egov.pm.model.EmailTemplateModel;
import org.egov.pm.model.ErrorResponseInfo;
import org.egov.pm.model.NOCApplicationDetail;
import org.egov.pm.model.NOCPriceBook;
import org.egov.pm.model.RequestData;
import org.egov.pm.producer.Producer;
import org.egov.pm.repository.NocRepository;
import org.egov.pm.repository.querybuilder.QueryBuilder;
import org.egov.pm.util.CommonConstants;
import org.egov.pm.util.UserUtil;
import org.egov.pm.web.contract.NocResponse;
import org.egov.pm.web.contract.ResponseData;
import org.egov.pm.web.contract.factory.ResponseFactory;
import org.json.JSONException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(MockitoJUnitRunner.Silent.class)
public class NocServiceTestCases {

	@Mock
	private NocRepository nocRepository;

	@InjectMocks
	private NocService nocService;

	@Mock
	private ResponseFactory responseFactory;

	@Mock
	private NocResponse nocResponse;

	@InjectMocks
	private NocApplication nocApplication;

	@Mock
	private UserUtil userUtil;

	@Mock
	private Producer producer;

	@Mock
	private PreApplicationRunnerImpl applicationRunnerImpl;

	@InjectMocks
	private ErrorResponseInfo errorResponseInfo;

	@Mock
	@Qualifier("validatorAddUpdateJSON")
	private JSONObject jsonAddObject;

	@Mock
	@Qualifier("validatorApproveRejectJSON")
	private JSONObject jsonApproveRejectObject;

	@Test
	public void testSearchNoc() throws JSONException {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("nocNumber", "PMS-123456");
		JSONArray arr = new JSONArray();
		arr.add(jsonObject);
		ResponseEntity reps = new ResponseEntity(
				NocResponse.builder().resposneInfo(ResponseInfo.builder().status(CommonConstants.SUCCESS).build())
						.nocApplicationDetail(arr).build(),
				HttpStatus.OK);
		when(nocRepository.getNoc(Matchers.any(RequestData.class))).thenReturn(arr);
		Assert.assertEquals(reps.getStatusCode(), nocService.getNoc(RequestData.builder().build()).getStatusCode());

		JSONArray arr1 = new JSONArray();
		ResponseEntity reps1 = new ResponseEntity(NocResponse.builder()
				.resposneInfo(ResponseInfo.builder().msgId("Invalid role or application type or blank data").build())
				.nocApplicationDetail(arr1).build(), HttpStatus.BAD_REQUEST);
		when(nocRepository.getNoc(Matchers.any(RequestData.class))).thenReturn(arr1);
		Assert.assertEquals(reps1.getStatusCode(), nocService.getNoc(RequestData.builder().build()).getStatusCode());
	}

	@Test
	public void testViewNoc() {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("nocNumber", "PMS-123456");
		JSONArray arr = new JSONArray();
		arr.add(jsonObject);
		ResponseEntity reps = new ResponseEntity(
				NocResponse.builder().resposneInfo(ResponseInfo.builder().status(CommonConstants.SUCCESS).build())
						.nocApplicationDetail(arr).build(),
				HttpStatus.OK);
		when(nocRepository.viewNoc(Matchers.any(RequestData.class))).thenReturn(arr);
		Assert.assertEquals(reps.getStatusCode(), nocService.viewNoc(RequestData.builder().build()).getStatusCode());

		JSONArray arr1 = new JSONArray();
		ResponseEntity reps1 = new ResponseEntity(
				NocResponse.builder().resposneInfo(ResponseInfo.builder().msgId("Invalid application Id").build())
						.nocApplicationDetail(arr1).build(),
				HttpStatus.BAD_REQUEST);
		when(nocRepository.viewNoc(Matchers.any(RequestData.class))).thenReturn(arr1);
		Assert.assertEquals(reps1.getStatusCode(), nocService.viewNoc(RequestData.builder().build()).getStatusCode());
	}

	@Test
	public void testGetCertificateData() {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("nocNumber", "PMS-123456");
		JSONArray arr = new JSONArray();
		arr.add(jsonObject);
		ResponseEntity reps = new ResponseEntity(
				NocResponse.builder().resposneInfo(ResponseInfo.builder().status(CommonConstants.SUCCESS).build())
						.nocApplicationDetail(arr).build(),
				HttpStatus.OK);
		when(nocRepository.getCertificateData(Matchers.any(RequestData.class))).thenReturn(arr);
		Assert.assertEquals(reps.getStatusCode(),
				nocService.getCertificateData(RequestData.builder().build()).getStatusCode());

		JSONArray arr1 = new JSONArray();
		ResponseEntity reps1 = new ResponseEntity(
				NocResponse.builder().resposneInfo(ResponseInfo.builder().msgId("Invalid application Id").build())
						.nocApplicationDetail(arr1).build(),
				HttpStatus.BAD_REQUEST);
		when(nocRepository.getCertificateData(Matchers.any(RequestData.class))).thenReturn(arr1);
		Assert.assertEquals(reps1.getStatusCode(),
				nocService.getCertificateData(RequestData.builder().build()).getStatusCode());
	}

	@Test
	public void testSearchApplicaion() {
		NOCApplicationDetail applicationDetail = new NOCApplicationDetail();
		applicationDetail.setApplicationUuid("asch298h8d2982djiq8162712ij09129e");
		List<NOCApplicationDetail> nocs = new ArrayList<>();
		nocs.add(applicationDetail);

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("applicationUuid", "ajsfhasu9287482j823e982d9192");

		RequestData requestData = RequestData.builder().requestInfo(RequestInfo.builder().build())
				.dataPayload(jsonObject).applicationStatus("APPROVED").build();

		NocResponse nocResponse = NocResponse.builder()
				.resposneInfo(responseFactory.getResponseInfo(requestData.getRequestInfo(), HttpStatus.OK))
				.nocApplicationDetail(nocs).build();

		
		
	}

	@Test
	public void testSaveNoc() throws JsonParseException, JsonMappingException, ParseException, IOException {
		// SELLMEATNOC

		JSONArray array = new JSONArray();
		JSONObject docs = new JSONObject();
		docs.put("fileStoreId", "asdajsfjasfjasfkafwi3r");
		array.add(docs);

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("applicantName", "prakash hadgal");
		jsonObject.put("fatherHusbandName", "kkkkkk");
		jsonObject.put("houseNo", "A97");
		jsonObject.put("shopNumber", "B98");
		jsonObject.put("ward", "SECTOR958");
		jsonObject.put("division", "IT");
		jsonObject.put("nocSought", "Noc of the above");
		jsonObject.put("sector", "North East");
		jsonObject.put("uploadDocuments", array);
		jsonObject.put("remarks", "");

		RequestData requestData = RequestData.builder()
				.requestInfo(RequestInfo.builder()
						.userInfo(User.builder().userName("Prakash").emailId("abc@gmail.com").mobileNumber("9898989898")
								.type("CITIZEN").tenantId("ch").uuid("65a14e00-ba5e-4347-be81-08fc04bb0529").build())
						.build())
				.applicationStatus("INTITIATED").applicationType("SELLMEATNOC").tenantId("ch")
				.applicationType("SELLMEATNOC").dataPayload(jsonObject).build();

		when(jsonAddObject.toJSONString()).thenReturn(getFileContents("testRecources/noc-type-json-validator.json"));

		when(nocRepository.saveValidateStatus(Matchers.any(RequestData.class), Matchers.anyString()))
				.thenReturn("PMS-12-12-2020-56554");

		EmailTemplateModel emailTemplateModel = new EmailTemplateModel("ch", "email tempalte - [:applicationId:]",
				"INITIATED", "CITIZEN", "SELLMEATNOC", "sms tempalte - [:applicationId:]", "Testing Juints");
		Map<String, EmailTemplateModel> maps = new HashMap<>();
		maps.put("CITIZEN", emailTemplateModel);
		//when(nocRepository.findTemplate("PMS-12-12-2020-56554", "PMS-12-12-2020-56554","PMS-12-12-2020-56554")).thenReturn(maps);

		// 1
		Assert.assertEquals(HttpStatus.CREATED, nocService.saveNoc(requestData).getStatusCode());

		when(nocRepository.saveValidateStatus(Matchers.any(RequestData.class), Matchers.anyString())).thenReturn(null);

		// 2
		Assert.assertEquals(HttpStatus.BAD_REQUEST, nocService.saveNoc(requestData).getStatusCode());

		jsonObject.remove("uploadDocuments");
		RequestData requestData3 = RequestData.builder()
				.requestInfo(RequestInfo.builder()
						.userInfo(User.builder().userName("Prakash").emailId("abc@gmail.com").mobileNumber("9898989898")
								.type("CITIZEN").tenantId("ch").uuid("65a14e00-ba5e-4347-be81-08fc04bb0529").build())
						.build())
				.applicationStatus("INTITIATED").applicationType("SELLMEATNOC").tenantId("ch")
				.applicationType("SELLMEATNOC").dataPayload(jsonObject).build();

		// 3
		Assert.assertEquals(HttpStatus.BAD_REQUEST, nocService.saveNoc(requestData).getStatusCode());
	}

	@Test
	public void testGetRemarksForNoc() {
		RequestData requestData = RequestData.builder().requestInfo(RequestInfo.builder().build())
				.applicationId("PMS-82748264828482374").applicationType("SELLMEATNOC").tenantId("ch")
				.applicationType("SELLMEATNOC").build();

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("nocNumber", "PMS-123456");
		JSONArray arr = new JSONArray();
		arr.add(jsonObject);
		ResponseEntity reps = new ResponseEntity(
				NocResponse.builder().resposneInfo(ResponseInfo.builder().status(CommonConstants.SUCCESS).build())
						.nocApplicationDetail(arr).build(),
				HttpStatus.OK);
		when(nocRepository.getRemarksForNoc(Matchers.anyString(), Matchers.anyString())).thenReturn(arr);
		Assert.assertEquals(reps.getStatusCode(), nocService.getRemarksForNoc(requestData).getStatusCode());

		JSONArray arr1 = new JSONArray();
		ResponseEntity reps1 = new ResponseEntity(
				NocResponse.builder().resposneInfo(ResponseInfo.builder().msgId("Invalid application Id").build())
						.nocApplicationDetail(arr1).build(),
				HttpStatus.BAD_REQUEST);
		when(nocRepository.getRemarksForNoc(Matchers.anyString(), Matchers.anyString())).thenReturn(arr1);
		Assert.assertEquals(reps1.getStatusCode(), nocService.getRemarksForNoc(requestData).getStatusCode());
	}

	@Test
	public void testUpdateNoc() throws JsonParseException, JsonMappingException, ParseException, IOException {
		// SELLMEATNOC

		JSONArray array = new JSONArray();
		JSONObject docs = new JSONObject();
		docs.put("fileStoreId", "asdajsfjasfjasfkafwi3r");
		array.add(docs);

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("applicantName", "prakash hadgal");
		jsonObject.put("fatherHusbandName", "kkkkkk");
		jsonObject.put("houseNo", "A97");
		jsonObject.put("shopNumber", "B98");
		jsonObject.put("ward", "SECTOR958");
		jsonObject.put("division", "IT");
		jsonObject.put("nocSought", "Noc of the above");
		jsonObject.put("sector", "North East");
		jsonObject.put("uploadDocuments", array);
		jsonObject.put("remarks", "");

		RequestData requestData = RequestData.builder()
				.requestInfo(RequestInfo.builder()
						.userInfo(User.builder().userName("Prakash").emailId("abc@gmail.com").mobileNumber("9898989898")
								.type("CITIZEN").tenantId("ch").uuid("65a14e00-ba5e-4347-be81-08fc04bb0529").build())
						.build())
				.applicationStatus("INTITIATED").applicationType("SELLMEATNOC").tenantId("ch")
				.applicationId("PMS-12-12-2020-56554").applicationType("SELLMEATNOC").dataPayload(jsonObject).build();

		when(jsonAddObject.toJSONString()).thenReturn(getFileContents("testRecources/noc-type-json-validator.json"));
		when(nocRepository.validateApplicationId(Matchers.anyString())).thenReturn(1);

		// 1
		Assert.assertEquals(HttpStatus.CREATED, nocService.updateNoc(requestData).getStatusCode());

		when(nocRepository.validateApplicationId(Matchers.anyString())).thenReturn(-1);

		// 2
		Assert.assertEquals(HttpStatus.BAD_REQUEST, nocService.updateNoc(requestData).getStatusCode());

		jsonObject.remove("uploadDocuments");
		RequestData requestData3 = RequestData.builder()
				.requestInfo(RequestInfo.builder()
						.userInfo(User.builder().userName("Prakash").emailId("abc@gmail.com").mobileNumber("9898989898")
								.type("CITIZEN").tenantId("ch").uuid("65a14e00-ba5e-4347-be81-08fc04bb0529").build())
						.build())
				.applicationStatus("INTITIATED").applicationType("SELLMEATNOC").tenantId("ch")
				.applicationId("PMS-12-12-2020-56554").applicationType("SELLMEATNOC").dataPayload(jsonObject).build();

		// 3
		Assert.assertEquals(HttpStatus.BAD_REQUEST, nocService.updateNoc(requestData).getStatusCode());
	}

	@Test
	public void testUpdateNocApplicationStatus() throws ParseException, IOException {
		// SELLMEATNOC

		JSONArray array = new JSONArray();
		JSONObject docs = new JSONObject();
		docs.put("fileStoreId", "asdajsfjasfjasfkafwi3r");
		array.add(docs);

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("uploadDocuments", array);
		jsonObject.put("remarks", "test junit");
		List<Role> roles = new ArrayList<Role>();
		roles.add(Role.builder().code("SISM").build());
		// roles.add(Role.builder().code("CITIZEN").build());

		RequestData requestData = RequestData.builder().requestInfo(RequestInfo.builder()
				.userInfo(User.builder().userName("Prakash").emailId("abc@gmail.com").mobileNumber("9898989898")
						.roles(roles).type("SISM").tenantId("ch").uuid("65a14e00-ba5e-4347-be81-08fc04bb0529").build())
				.build()).applicationStatus("REVIEWOFSUPERINTENDENT").applicationType("SELLMEATNOC").tenantId("ch")
				.applicationId("PMS-12-12-2020-56554").applicationType("SELLMEATNOC").currentState("INITIATED").dataPayload(jsonObject).build();

		ResponseData reponseData = ResponseData.builder()
				.responseInfo(ResponseInfo.builder().status(CommonConstants.SUCCESS).build()).build();
		when(nocRepository.updateAppStatus(Matchers.any(RequestData.class))).thenReturn(reponseData);

		EmailTemplateModel emailTemplateModel = new EmailTemplateModel("ch", "email tempalte - [:applicationId:]",
				"REVIEWOFSUPERINTENDENT", "SISM", "SELLMEATNOC", "sms tempalte - [:applicationId:]", "Testing Juints");
		Map<String, EmailTemplateModel> maps = new HashMap<>();
		maps.put("SISM", emailTemplateModel);
		maps.put("CITIZEN", emailTemplateModel);
		//when(nocRepository.findTemplate("PMS-12-12-2020-56554", "PMS-12-12-2020-56554","PMS-12-12-2020-56554")).thenReturn(maps);

		when(jsonApproveRejectObject.toJSONString())
				.thenReturn(getFileContents("testRecources/noc-update-app-status-validation.json"));

		List<Map<String, Object>> list = new ArrayList<>();
		// "6a9c0fb2-6579-441e-a46f-1e5e84ee6655"
		//when(nocRepository.getUserByNocNumber(Matchers.anyString())).thenReturn(list);

		String json = "{\"responseInfo\":{\"apiId\":null,\"ver\":null,\"ts\":null,\"resMsgId\":null,\"msgId\":null,\"status\":\"200\"},\"user\":[{\"id\":209,\"userName\":\"7276621098\",\"salutation\":null,\"name\":\"citizen\",\"gender\":null,\"mobileNumber\":\"7276621098\",\"emailId\":\"rahul.prakash@extrapreneursindia.com\",\"altContactNumber\":null,\"pan\":null,\"aadhaarNumber\":null,\"permanentAddress\":\"pune\",\"permanentCity\":null,\"permanentPinCode\":null,\"correspondenceAddress\":\"pune\",\"correspondenceCity\":null,\"correspondencePinCode\":null,\"active\":true,\"locale\":null,\"type\":\"CITIZEN\",\"accountLocked\":false,\"accountLockedDate\":0,\"fatherOrHusbandName\":\"Test\",\"signature\":null,\"bloodGroup\":null,\"photo\":null,\"identificationMark\":null,\"createdBy\":0,\"lastModifiedBy\":1,\"tenantId\":\"ch\",\"roles\":[{\"code\":\"CITIZEN\",\"name\":\"Citizen\",\"tenantId\":\"ch\"}],\"uuid\":\"6a9c0fb2-6579-441e-a46f-1e5e84ee6655\",\"createdDate\":\"11-03-2020 14:12:15\",\"lastModifiedDate\":\"21-03-2020 13:56:34\",\"dob\":\"1986-08-04\",\"pwdExpiryDate\":\"09-06-2020 14:12:15\"}]}";
		ObjectMapper objectMapper = new ObjectMapper();
		JsonNode jsonNode = objectMapper.readTree(json);

		//when(userUtil.getUser(Matchers.any(RequestInfo.class), Matchers.anyString())).thenReturn(jsonNode);
//		when(userUtil.getUserByRole(Matchers.any(RequestInfo.class), Matchers.anyString(), Matchers.anyString()))
//				.thenReturn(jsonNode);

		// 1
		Assert.assertEquals(HttpStatus.OK, nocService.updateNocApplicationStatus(requestData).getStatusCode());

		ResponseData reponseData2 = ResponseData.builder()
				.responseInfo(ResponseInfo.builder().status(CommonConstants.FAIL).build()).build();
		when(nocRepository.updateAppStatus(Matchers.any(RequestData.class))).thenReturn(reponseData2);

		// 2
		Assert.assertEquals(HttpStatus.OK, nocService.updateNocApplicationStatus(requestData).getStatusCode());

		jsonObject.remove("remarks");
		RequestData requestData3 = RequestData.builder().requestInfo(RequestInfo.builder()
				.userInfo(User.builder().userName("Prakash").emailId("abc@gmail.com").mobileNumber("9898989898")
						.roles(roles).type("SISM").tenantId("ch").uuid("65a14e00-ba5e-4347-be81-08fc04bb0529").build())
				.build()).applicationStatus("REVIEWOFSUPERINTENDENT").applicationType("SELLMEATNOC").tenantId("ch")
				.applicationId("PMS-12-12-2020-56554").applicationType("SELLMEATNOC").dataPayload(jsonObject).build();

		// 3
		Assert.assertEquals(HttpStatus.BAD_REQUEST,
				nocService.updateNocApplicationStatus(requestData3).getStatusCode());
	}
	@Test
	public void testviewpricebook() {
		RequestData requestData = RequestData.builder().requestInfo(RequestInfo.builder().build())
				.applicationId("PMS-82748264828482374").applicationType("SELLMEATNOC").tenantId("ch")
				.applicationType("SELLMEATNOC").build();

		NocResponse res=new NocResponse();
		List<NOCPriceBook> preparedStatementValues1 = new ArrayList<>();

		when(nocRepository.viewPriceBook(requestData)).thenReturn(preparedStatementValues1);
		Assert.assertEquals(res, nocService.viewPriceBook(requestData));

	}
	
	@Test
	public void testviewpricebookid() {
		RequestData requestData = RequestData.builder().requestInfo(RequestInfo.builder().build())
				.applicationId("PMS-82748264828482374").applicationType("SELLMEATNOC").tenantId("ch")
				.applicationType("SELLMEATNOC").build();

		NocResponse res=new NocResponse();
		List<NOCPriceBook> preparedStatementValues1 = new ArrayList<>();

		when(nocRepository.viewPriceBookById(requestData)).thenReturn(preparedStatementValues1);
		Assert.assertEquals(res, nocService.viewPriceBookById(requestData));

	}
	@Test
	public void testupdatepricebook() throws java.text.ParseException {
		RequestData requestData = RequestData.builder().requestInfo(RequestInfo.builder().build())
				.applicationId("PMS-82748264828482374").applicationType("SELLMEATNOC").tenantId("ch")
				.applicationType("SELLMEATNOC").build();

		NocResponse res=new NocResponse();
		List<NOCPriceBook> preparedStatementValues1 = new ArrayList<>();

		//when(nocRepository.updatepricebook(requestData)).thenReturn(res);
		when(nocRepository.getpricebook(requestData,1)).thenReturn(1);
		when(nocRepository.updatepricebookdate(requestData)).thenReturn(res);
		
		Assert.assertEquals(res, nocService.updatepricebook(requestData));

	}
	private String getFileContents(String fileName) throws IOException {
		return IOUtils.toString(this.getClass().getClassLoader().getResourceAsStream(fileName), "UTF-8");
	}
	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void saveNocThrowsCustomException() throws JsonParseException, JsonMappingException, ParseException, IOException {

	RequestData requestData = RequestData.builder().requestInfo(RequestInfo.builder().build())
	.applicationId("PMS-82748264828482374").applicationType("SELLMEATNOC").tenantId("ch")
	.applicationType("SELLMEATNOC").build();

	NocService obj = new NocService();
	obj.saveNoc(requestData);
	}
	@Test
	public void updateNocThrowsCustomException() throws JsonParseException, JsonMappingException, ParseException, IOException {

	RequestData requestData = RequestData.builder().requestInfo(RequestInfo.builder().build())
	.applicationId("PMS-82748264828482374").applicationType("SELLMEATNOC").tenantId("ch")
	.applicationType("SELLMEATNOC").build();

	NocService obj = new NocService();
	obj.updateNoc(requestData);
	}
	@Test
	public void updateNocApplicationStatuscThrowsCustomException() throws JsonParseException, JsonMappingException, ParseException, IOException {

	RequestData requestData = RequestData.builder().requestInfo(RequestInfo.builder().build())
	.applicationId("PMS-82748264828482374").applicationType("SELLMEATNOC").tenantId("ch")
	.applicationType("SELLMEATNOC").build();

	NocService obj = new NocService();
	obj.updateNocApplicationStatus(requestData);
	}
	@Test
	public void validateJsonUpdateStatusDataThrowsCustomException() throws JsonParseException, JsonMappingException, ParseException, IOException {

	RequestData requestData = RequestData.builder().requestInfo(RequestInfo.builder().build())
	.applicationId("PMS-82748264828482374").applicationType("SELLMEATNOC").tenantId("ch")
	.applicationType("SELLMEATNOC").build();

	NocService obj = new NocService();
	obj.validateJsonUpdateStatusData(requestData);
	}
	@Test
	public void updatepricebookThrowsCustomException() throws java.text.ParseException {
	thrown.expect(NullPointerException.class);
	RequestData requestData = RequestData.builder().requestInfo(RequestInfo.builder().build())
	.applicationId("PMS-82748264828482374").applicationType("SELLMEATNOC").tenantId("ch")
	.applicationType("SELLMEATNOC").build();

	NocService obj = new NocService();
	obj.updatepricebook(requestData);
	}
}
