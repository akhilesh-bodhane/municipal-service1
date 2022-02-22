
package org.egov.nulm.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;



import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.egov.common.contract.request.Role;
import org.egov.common.contract.response.ResponseInfo;
import org.egov.nulm.common.CommonConstants;
import org.egov.nulm.config.NULMConfiguration;
import org.egov.nulm.idgen.model.IdGenerationResponse;
import org.egov.nulm.model.NulmAlfMemberRequest;
import org.egov.nulm.model.ResponseInfoWrapper;
import org.egov.nulm.model.SmidAlfMemberApplication;
import org.egov.nulm.repository.SmidAlfMemberRepository;
import org.egov.nulm.util.AuditDetailsUtil;
import org.egov.nulm.util.IdGenRepository;
import org.egov.nulm.web.model.Files;
//import org.egov.prscp.web.models.InviteGuest;
//import org.egov.prscp.web.models.memberrequest;
import org.egov.tracer.model.CustomException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.egov.nulm.util.FileStoreUtils;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class SmidAlfMemberService {

	private final ObjectMapper objectMapper;

	private NULMConfiguration config;

	private SmidAlfMemberRepository repository;

	private IdGenRepository idgenrepository;

	private AuditDetailsUtil auditDetailsUtil;
	
	private FileStoreUtils fileStoreUtils;

	@Autowired
	public SmidAlfMemberService(SmidAlfMemberRepository repository, ObjectMapper objectMapper,
			IdGenRepository idgenrepository, NULMConfiguration config, AuditDetailsUtil auditDetailsUtil,FileStoreUtils fileStoreUtils) {
		this.objectMapper = objectMapper;
		this.repository = repository;
		this.idgenrepository = idgenrepository;
		this.config = config;
		this.auditDetailsUtil = auditDetailsUtil;
		this.fileStoreUtils = fileStoreUtils;

	}
	
	public ResponseEntity<ResponseInfoWrapper> uplaodExternalGuest(NulmAlfMemberRequest memberrequest
			) throws IOException {
		try {
			log.debug("inside method uplaodExternalGuest execution begins");


		
			SmidAlfMemberApplication[] guests = objectMapper.convertValue(memberrequest.getSmidAlfMemberApplication(), SmidAlfMemberApplication[].class);
			log.debug(objectMapper.writeValueAsString(guests));
			SmidAlfMemberApplication guest=guests[0];
			
		
			

Files uploadfileId = Files.builder().fileStoreId(guest.getExternalFileStoreId()).build();

			List<Files> attachments = new ArrayList<>();
			attachments.add(uploadfileId);
			String fileUrls = null;
			log.debug("calling getFiles method");
List<Files> attachmentsUrls = fileStoreUtils.getFiles(guest.getTenantId(), attachments);

			
			for (Files files : attachmentsUrls) {
				fileUrls = files.getUrl();
			}

			if (fileUrls == null || fileUrls.isEmpty())
				throw new CustomException(HttpStatus.INTERNAL_SERVER_ERROR.toString(), CommonConstants.ID_GENERATION);
			
			int lastIndexOf = fileUrls.lastIndexOf('\\')+1;
			int lastIndexOf1 = fileUrls.indexOf(".xls")-1;
			String filename=fileUrls.substring(lastIndexOf, lastIndexOf1).replaceAll(" ", "%20");
			StringBuilder string = new StringBuilder(fileUrls);			
			string.replace(lastIndexOf,lastIndexOf1 , filename);
			UrlResource fileResource = new UrlResource(string.toString());
			/*
			CloseableHttpClient client = HttpClientBuilder.create().build();
			HttpGet request = new HttpGet(fileUrls.replaceAll(" ", "%20"));
			request.addHeader("accept", "application/vnd.ms-excel");
			HttpResponse response = client.execute(request);
			HttpEntity entity = response.getEntity();
			int responseCode = response.getStatusLine().getStatusCode();
			InputStream inputStream = entity.getContent();*/
			
			List<SmidAlfMemberApplication> userList = new ArrayList<>();
			HSSFWorkbook workbook = new HSSFWorkbook(fileResource.getInputStream());
			HSSFSheet worksheet = workbook.getSheetAt(0);
			Iterator<Row> rowIterator = worksheet.iterator();
			rowIterator.next(); // skip the header row

			log.debug("XLS SHEET STARTTO READ");

			while (rowIterator.hasNext()) {
				Row nextRow = rowIterator.next();
				Iterator<Cell> cellIterator = nextRow.cellIterator();
				SmidAlfMemberApplication user = SmidAlfMemberApplication.builder().build();

				while (cellIterator.hasNext()) {
					Cell nextCell = cellIterator.next();
					int columnIndex = nextCell.getColumnIndex();
					user.setApplicationId(guest.getAlfUuid()+nextCell);
					switch (columnIndex) {
					case 0:
						nextCell.setCellType(Cell.CELL_TYPE_STRING);
						String name = nextCell.getStringCellValue();
						user.setName(name);
						break;
					case 1:
						nextCell.setCellType(Cell.CELL_TYPE_STRING);
						String mobileno = nextCell.getStringCellValue();
						if(mobileno ==null || mobileno.isEmpty())
						{
							mobileno = "";	
						}
						user.setMobileNo(mobileno);
						break;
					case 2:

						nextCell.setCellType(Cell.CELL_TYPE_STRING);
						 String Adharno = nextCell.getStringCellValue();
						 if(Adharno ==null || Adharno.isEmpty())
							{
							 Adharno = "";	
							}
						
						user.setAdharNo(Adharno);
							
						break;
					case 3:
						nextCell.setCellType(Cell.CELL_TYPE_STRING);
						String address = nextCell.getStringCellValue();
						if(address ==null || address.isEmpty())
						{
							address = "";	
						}
						user.setAddress(address);
						break;
					default:
						break;
					}

				}

				List<SmidAlfMemberApplication> isExists = userList.stream()
						.filter(obj -> (obj.getMobileNo().equals(user.getMobileNo())
								&& obj.getAdharNo().equals(user.getAdharNo())))
						.collect(Collectors.toList());

				if (isExists.isEmpty()) {
					if(user.getName()!=null && !user.getName().isEmpty())
					{
					String uuid = UUID.randomUUID().toString();
			
					user.setApplicationUuid(uuid);

					user.setAlfUuid(guest.getAlfUuid());
		
					if(user.getMobileNo()==null || user.getMobileNo().isEmpty())
					{
						
						user.setMobileNo("0");
					}
					
					if(user.getAdharNo()==null || user.getAdharNo().isEmpty())
					{
						
						user.setAdharNo(" ");
					}
					if(user.getAddress()==null || user.getAddress().isEmpty())
					{
						
						user.setAddress(" ");
					}
					
					userList.add(user);
					
					}
				}
			}
			System.out.println(userList);
			log.debug("size of userList="+userList);

			  

			if (!userList.isEmpty()) {
				log.debug("size of userList="+userList.size());
				List<SmidAlfMemberApplication> userListFinal = repository.saveGuest(userList, memberrequest);
				return new ResponseEntity(ResponseInfoWrapper.builder()
						.responseInfo(ResponseInfo.builder().status(CommonConstants.SUCCESS).build())
						.responseBody(userListFinal).build(), HttpStatus.CREATED);
			} else {
				throw new CustomException(HttpStatus.INTERNAL_SERVER_ERROR.toString(), CommonConstants.ID_GENERATION_1);
			}

		} catch (Exception exception) {
			//log.error("exception inside method uplaodExternalGuest",exception);
			exception.printStackTrace();
			throw new CustomException(HttpStatus.INTERNAL_SERVER_ERROR.toString(), CommonConstants.ID_GENERATION_2);
		}
	}
	
         public ResponseEntity<ResponseInfoWrapper> readExternalGuest(NulmAlfMemberRequest memberrequest) {
        	 try {
        		 log.debug("inside method READExternalGuest execution begins");
        		 SmidAlfMemberApplication[] guests = objectMapper.convertValue(memberrequest.getSmidAlfMemberApplication(), SmidAlfMemberApplication[].class);
     			log.debug(objectMapper.writeValueAsString(guests));
     			SmidAlfMemberApplication guest=guests[0];
     			System.out.println(guests);
     			objectMapper.writeValueAsString(guests);
     		
     			
     Files uploadfileId = Files.builder().fileStoreId(guest.getExternalFileStoreId()).build();

     			List<Files> attachments = new ArrayList<>();
     			attachments.add(uploadfileId);
     			String fileUrls = null;
     			log.debug("calling getFiles method");
     			
     List<Files> attachmentsUrls = fileStoreUtils.getFiles(guest.getTenantId(), attachments);

     			for (Files files : attachmentsUrls) {
     				fileUrls = files.getUrl();
     			}

     			if (fileUrls == null || fileUrls.isEmpty())
     				throw new CustomException(HttpStatus.INTERNAL_SERVER_ERROR.toString(), CommonConstants.ID_GENERATION);
     			
     			int lastIndexOf = fileUrls.lastIndexOf('\\')+1;
     			int lastIndexOf1 = fileUrls.indexOf(".xls")-1;
     			String filename=fileUrls.substring(lastIndexOf, lastIndexOf1).replaceAll(" ", "%20");
     			StringBuilder string = new StringBuilder(fileUrls);			
     			string.replace(lastIndexOf,lastIndexOf1 , filename);
     			UrlResource fileResource = new UrlResource(string.toString());
     			/*
     			CloseableHttpClient client = HttpClientBuilder.create().build();
     			HttpGet request = new HttpGet(fileUrls.replaceAll(" ", "%20"));
     			request.addHeader("accept", "application/vnd.ms-excel");
     			HttpResponse response = client.execute(request);
     			HttpEntity entity = response.getEntity();
     			int responseCode = response.getStatusLine().getStatusCode();
     			InputStream inputStream = entity.getContent();*/
     			
     			List<SmidAlfMemberApplication> userList = new ArrayList<>();
     			HSSFWorkbook workbook = new HSSFWorkbook(fileResource.getInputStream());
     			HSSFSheet worksheet = workbook.getSheetAt(0);
     			Iterator<Row> rowIterator = worksheet.iterator();
     			rowIterator.next(); // skip the header row

     			log.debug("XLS SHEET STARTTO READ");
     			while (rowIterator.hasNext()) {
     				Row nextRow = rowIterator.next();
     				Iterator<Cell> cellIterator = nextRow.cellIterator();
     				SmidAlfMemberApplication user = SmidAlfMemberApplication.builder().build();

     				while (cellIterator.hasNext()) {
     					Cell nextCell = cellIterator.next();
     					int columnIndex = nextCell.getColumnIndex();

     					switch (columnIndex) {
     					case 0:
     						nextCell.setCellType(Cell.CELL_TYPE_STRING);
     						String name = nextCell.getStringCellValue();
     						user.setName(name);
     						break;
     					case 1:
     						nextCell.setCellType(Cell.CELL_TYPE_STRING);
     						String mobileno = nextCell.getStringCellValue();
     						if(mobileno ==null || mobileno.isEmpty())
     						{
     							mobileno = "";	
     						}
     						user.setMobileNo(mobileno);
     						break;
     					case 2:
     						

     						nextCell.setCellType(Cell.CELL_TYPE_STRING);
     						 String Adharno = nextCell.getStringCellValue();
     						 if(Adharno ==null || Adharno.isEmpty())
     							{
     							 Adharno = "";	
     							}
     						
     						user.setAdharNo(Adharno);
     							
     						break;
     					case 3:
     						nextCell.setCellType(Cell.CELL_TYPE_STRING);
     						String address = nextCell.getStringCellValue();
     						if(address ==null || address.isEmpty())
     						{
     							address = "";	
     						}
     						user.setAddress(address);
     						break;
     					default:
     						break;
     					}

     				}
     				log.debug("XLS SHEET STARTTO READ"+user);
     				List<SmidAlfMemberApplication> isExists = userList.stream()
     						.filter(obj -> (obj.getMobileNo().equals(user.getMobileNo())
     								&& obj.getAdharNo().equals(user.getAdharNo())))
     						.collect(Collectors.toList());

     				if (isExists.isEmpty()) {
     					if(user.getName()!=null && !user.getName().isEmpty())
     					{
				
     					if(user.getMobileNo()==null || user.getMobileNo().isEmpty())
     					{
     						
     						user.setMobileNo("0");
     					}
     					
     					if(user.getAdharNo()==null || user.getAdharNo().isEmpty())
     					{
     						
     						user.setAdharNo(" ");
     					}
     					if(user.getAddress()==null || user.getAddress().isEmpty())
     					{
     						
     						user.setAddress(" ");
     					}
     					
     					userList.add(user);
     					
     					}
     				}
     			}
     			System.out.println(userList);
     			log.debug("userList");

     			if (!userList.isEmpty()) {

     				return new ResponseEntity(ResponseInfoWrapper.builder()
     						.responseInfo(ResponseInfo.builder().status(CommonConstants.SUCCESS).build())
     						.responseBody(userList).build(), HttpStatus.CREATED);
     			} else {
     				throw new CustomException(HttpStatus.INTERNAL_SERVER_ERROR.toString(), CommonConstants.ID_GENERATION_1);
     			}

     		} catch (Exception exception) {
     			exception.printStackTrace();
     			throw new CustomException(HttpStatus.INTERNAL_SERVER_ERROR.toString(), CommonConstants.ID_GENERATION_2);
     		}
	}
         
         public ResponseEntity<ResponseInfoWrapper> createMembers(NulmAlfMemberRequest memberrequest) {
     		try {
     			SmidAlfMemberApplication smidapplication = objectMapper.convertValue(memberrequest.getSmidAlfMemberApplication(),
     					SmidAlfMemberApplication.class);
     			   checkValidation(smidapplication);
     			   repository.checkShgUuid(smidapplication);
     				String smidid = UUID.randomUUID().toString();
     				smidapplication.setApplicationUuid(smidid);
     				smidapplication.setIsActive(true);
     				smidapplication.setAuditDetails(auditDetailsUtil.getAuditDetails(memberrequest.getRequestInfo(), CommonConstants.ACTION_CREATE));
     			   // idgen service call to genrate event id
     				IdGenerationResponse id = idgenrepository.getId(memberrequest.getRequestInfo(), smidapplication.getTenantId(),
     						config.getSmidapplicationNumberIdgenName(), config.getSmidapplicationNumberIdgenFormat(), 1);
     				if (id.getIdResponses() != null && id.getIdResponses().get(0) != null)
     					smidapplication.setApplicationId(id.getIdResponses().get(0).getId());
     				else
     					throw new CustomException(HttpStatus.INTERNAL_SERVER_ERROR.toString(), CommonConstants.ID_GENERATION);

     				repository.createMembers(smidapplication);

     				return new ResponseEntity<>(ResponseInfoWrapper.builder()
     						.responseInfo(ResponseInfo.builder().status(CommonConstants.SUCCESS).build())
     						.responseBody(smidapplication).build(), HttpStatus.CREATED);

     			} catch (Exception e) {
     				throw new CustomException(CommonConstants.SMID_SHG_MEMBER_APPLICATION_EXCEPTION_CODE, e.getMessage());
     			}
     	}
     	
     	public ResponseEntity<ResponseInfoWrapper> getMembers(NulmAlfMemberRequest memberrequest) {
     		try {

     			SmidAlfMemberApplication[] shg = objectMapper.convertValue(memberrequest.getSmidAlfMemberApplication(),
     					SmidAlfMemberApplication[].class);
     			SmidAlfMemberApplication shgg = shg[0];
     			List<Role> role=memberrequest.getRequestInfo().getUserInfo().getRoles();
     			List<SmidAlfMemberApplication> groupresult = repository.getMembers(shgg,role,memberrequest.getRequestInfo().getUserInfo().getId());
     			return new ResponseEntity<>(ResponseInfoWrapper.builder()
     					.responseInfo(ResponseInfo.builder().status(CommonConstants.SUCCESS).build())
     					.responseBody(groupresult).build(), HttpStatus.OK);
     		} catch (Exception e) {
     			e.printStackTrace();
     			throw new CustomException(CommonConstants.SMID_SHG_MEMBER_APPLICATION_EXCEPTION_CODE, e.getMessage());
     		}
     	}
     	public ResponseEntity<ResponseInfoWrapper> updateMembers(NulmAlfMemberRequest memberrequest) {
     		try {
     			SmidAlfMemberApplication smidapplication = objectMapper.convertValue(memberrequest.getSmidAlfMemberApplication(),
     					SmidAlfMemberApplication.class);
     			
     			
     			System.out.println("RunRun");
     			checkValidation(smidapplication);
     			String status = "";
     			repository.checkMemberUuid(smidapplication);
     			List<Role> role = memberrequest.getRequestInfo().getUserInfo().getRoles();
     			JSONArray groupresult = repository.getMemmberStatus(smidapplication);
     			JSONObject applicationData = (JSONObject) groupresult.get(0);
     			status = applicationData.get("application_status").toString();
     			for (Role roleobj : role) {
     				if ((roleobj.getCode()).equalsIgnoreCase(config.getRoleNgoUser())) {
     					
     					if (status.equalsIgnoreCase(SmidAlfMemberApplication.StatusEnum.CREATED.toString())) {
     						smidapplication.setApplicationStatus(SmidAlfMemberApplication.StatusEnum.CREATED);
     					}
     					if (status.equalsIgnoreCase(SmidAlfMemberApplication.StatusEnum.APPROVED.toString())
     							|| status.equalsIgnoreCase(SmidAlfMemberApplication.StatusEnum.REJECTED.toString())) {
     						smidapplication.setApplicationStatus(SmidAlfMemberApplication.StatusEnum.UPDATED);
     					}
     				}
     				else {
     					smidapplication.setApplicationStatus(SmidAlfMemberApplication.StatusEnum.fromValue(status));
     				}
     			}
     			smidapplication.setIsActive(true);
     			smidapplication.setAuditDetails(auditDetailsUtil.getAuditDetails(memberrequest.getRequestInfo(), CommonConstants.ACTION_UPDATE));
     		 	repository.updateMembers(smidapplication);

     			return new ResponseEntity<>(ResponseInfoWrapper.builder()
     					.responseInfo(ResponseInfo.builder().status(CommonConstants.SUCCESS).build())
     					.responseBody(smidapplication).build(), HttpStatus.OK);

     		} catch (Exception e) {
     			throw new CustomException(CommonConstants.SMID_SHG_MEMBER_APPLICATION_EXCEPTION_CODE, e.getMessage());
     		}
     	}

	public ResponseEntity<ResponseInfoWrapper> deleteMembers(NulmAlfMemberRequest memberrequest) {
		try {
			SmidAlfMemberApplication smidapplication = objectMapper.convertValue(memberrequest.getSmidAlfMemberApplication(),
					SmidAlfMemberApplication.class);
			String status = "";
			repository.checkMemberUuid(smidapplication);
			List<Role> role = memberrequest.getRequestInfo().getUserInfo().getRoles();
			JSONArray groupresult = repository.getMemmberStatus(smidapplication);
			JSONObject applicationData = (JSONObject) groupresult.get(0);
			status = applicationData.get("application_status").toString();
			for (Role roleobj : role) {
				if ((roleobj.getCode()).equalsIgnoreCase(config.getRoleNgoUser()) ||
						(roleobj.getCode()).equalsIgnoreCase(config.getRoleCitizenUser())) {
					
					if (status.equalsIgnoreCase(SmidAlfMemberApplication.StatusEnum.CREATED.toString())) {
						repository.hardDeleteMembers(smidapplication);
					}
					if (status.equalsIgnoreCase(SmidAlfMemberApplication.StatusEnum.APPROVED.toString())
							|| status.equalsIgnoreCase(SmidAlfMemberApplication.StatusEnum.REJECTED.toString())) {
						smidapplication.setApplicationStatus(SmidAlfMemberApplication.StatusEnum.DELETIONINPROGRESS);
						smidapplication.setIsActive(true);
						smidapplication.setAuditDetails(auditDetailsUtil.getAuditDetails(memberrequest.getRequestInfo(), CommonConstants.ACTION_UPDATE));
					 	repository.deleteMembers(smidapplication);
					}
				}
			}
			
			return new ResponseEntity<>(ResponseInfoWrapper.builder()
					.responseInfo(ResponseInfo.builder().status(CommonConstants.SUCCESS).build())
					.responseBody(smidapplication).build(), HttpStatus.OK);

		} catch (Exception e) {
			throw new CustomException(CommonConstants.SMID_SHG_MEMBER_APPLICATION_EXCEPTION_CODE, e.getMessage());
		}
	}

	private void checkValidation(SmidAlfMemberApplication smidapplication) {
		Map<String, String> errorMap = new HashMap<>();
		if (smidapplication != null) {
			if (smidapplication.getIsMinority() == true
					&& (smidapplication.getMinority() == null || smidapplication.getMinority() == "")) {
				errorMap.put(CommonConstants.APPLICATION_MINORITY_NULL_CODE,
						CommonConstants.APPLICATION_MINORITY_NULL_CODE_MESSAGE);
			}
			if (smidapplication.getIsUrbanPoor() == true
					&& (smidapplication.getBplNo() == null || smidapplication.getBplNo() == "")) {
				errorMap.put(CommonConstants.APPLICATION_BPLNO_NULL_CODE,
						CommonConstants.APPLICATION_BPLNO_NULL_CODE_MESSAGE);
			}
			if (smidapplication.getIsInsurance() == true
					&& (smidapplication.getInsuranceThrough() == null || smidapplication.getInsuranceThrough() == "")) {
				errorMap.put(CommonConstants.APPLICATION_INSURANCE_NULL_CODE,
						CommonConstants.APPLICATION_INSURANCE_NULL_CODE_MESSAGE);
			}
		} else {
			errorMap.put(CommonConstants.MISSING_OR_INVALID_SMID_APPLICATION_OBJECT,
					CommonConstants.MISSING_OR_INVALID_SMID_APPLICATION_MESSAGE);
		}

		if (!CollectionUtils.isEmpty(errorMap.keySet())) {
			throw new CustomException(errorMap);
		}

	}
	
	public ResponseEntity<ResponseInfoWrapper> memberCount(NulmAlfMemberRequest   request) {
		try {

			SmidAlfMemberApplication smidapplication = objectMapper.convertValue(request.getSmidAlfMemberApplication(),
					SmidAlfMemberApplication.class);
			List<SmidAlfMemberApplication> groupresult = repository.getMemberCount(smidapplication);
			return new ResponseEntity<>(ResponseInfoWrapper.builder()
					.responseInfo(ResponseInfo.builder().status(CommonConstants.SUCCESS).build())
					.responseBody(groupresult).build(), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			throw new CustomException(CommonConstants.SMID_SHG_APPLICATION_EXCEPTION_CODE, e.getMessage());
		}
	}

	
}