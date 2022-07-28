
package org.egov.nulm.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
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
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.egov.common.contract.request.Role;
import org.egov.common.contract.response.ResponseInfo;
import org.egov.nulm.common.CommonConstants;
import org.egov.nulm.config.NULMConfiguration;
import org.egov.nulm.idgen.model.IdGenerationResponse;
import org.egov.nulm.model.NulmShgMemberRequest;
import org.egov.nulm.model.ResponseInfoWrapper;
import org.egov.nulm.model.SmidShgGroup;
import org.egov.nulm.model.SmidShgGroup.StatusEnum;
import org.egov.nulm.model.SmidShgMemberApplication;
import org.egov.nulm.repository.SmidShgMemberRepository;
import org.egov.nulm.repository.SmidShgRepository;
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
public class SmidShgMemberService {

	private final ObjectMapper objectMapper;

	private NULMConfiguration config;

	private SmidShgMemberRepository repository;
	
	@Autowired
	private SmidShgRepository repository1;

	private IdGenRepository idgenrepository;

	private AuditDetailsUtil auditDetailsUtil;
	
	private FileStoreUtils fileStoreUtils;

	@Autowired
	public SmidShgMemberService(SmidShgMemberRepository repository, ObjectMapper objectMapper,
			IdGenRepository idgenrepository, NULMConfiguration config, AuditDetailsUtil auditDetailsUtil,FileStoreUtils fileStoreUtils) {
		this.objectMapper = objectMapper;
		this.repository = repository;
		this.idgenrepository = idgenrepository;
		this.config = config;
		this.auditDetailsUtil = auditDetailsUtil;
		this.fileStoreUtils = fileStoreUtils;

	}
	
	public ResponseEntity<ResponseInfoWrapper> uplaodExternalGuest(NulmShgMemberRequest memberrequest
			) throws IOException {
		try {
			log.debug("inside method uplaodExternalGuest execution begins");


		
			SmidShgMemberApplication[] guests = objectMapper.convertValue(memberrequest.getSmidShgMemberApplication(), SmidShgMemberApplication[].class);
			log.debug(objectMapper.writeValueAsString(guests));
			SmidShgMemberApplication guest=guests[0];
			
		
			

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
			
			List<SmidShgMemberApplication> userList = new ArrayList<>();
			HSSFWorkbook workbook = new HSSFWorkbook(fileResource.getInputStream());
			HSSFSheet worksheet = workbook.getSheetAt(0);
			Iterator<Row> rowIterator = worksheet.iterator();
			rowIterator.next(); // skip the header row

			log.debug("XLS SHEET STARTTO READ");

			while (rowIterator.hasNext()) {
				Row nextRow = rowIterator.next();
				Iterator<Cell> cellIterator = nextRow.cellIterator();
				SmidShgMemberApplication user = SmidShgMemberApplication.builder().build();

				while (cellIterator.hasNext()) {
					Cell nextCell = cellIterator.next();
					int columnIndex = nextCell.getColumnIndex();
					user.setApplicationId(guest.getShgUuid()+nextCell);
					user.setExternalFileStoreId(guest.getExternalFileStoreId());
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

				List<SmidShgMemberApplication> isExists = userList.stream()
						.filter(obj -> (obj.getMobileNo().equals(user.getMobileNo())
								&& obj.getAdharNo().equals(user.getAdharNo())))
						.collect(Collectors.toList());

				if (isExists.isEmpty()) {
					if(user.getName()!=null && !user.getName().isEmpty())
					{
					String uuid = UUID.randomUUID().toString();
			
					user.setApplicationUuid(uuid);

					user.setShgUuid(guest.getShgUuid());
		
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
				List<SmidShgMemberApplication> userListFinal = repository.saveGuest(userList, memberrequest);
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
	
         public ResponseEntity<ResponseInfoWrapper> readExternalGuest(NulmShgMemberRequest memberrequest) {
        	 try {
        		 log.debug("inside method READExternalGuest execution begins");
     			SmidShgMemberApplication[] guests = objectMapper.convertValue(memberrequest.getSmidShgMemberApplication(), SmidShgMemberApplication[].class);
     			log.debug(objectMapper.writeValueAsString(guests));
     			SmidShgMemberApplication guest=guests[0];
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
     			
     			List<SmidShgMemberApplication> userList = new ArrayList<>();
     			HSSFWorkbook workbook = new HSSFWorkbook(fileResource.getInputStream());
     			HSSFSheet worksheet = workbook.getSheetAt(0);
     			Iterator<Row> rowIterator = worksheet.iterator();
     			rowIterator.next(); // skip the header row

     			log.debug("XLS SHEET STARTTO READ");
     			while (rowIterator.hasNext()) {
     				Row nextRow = rowIterator.next();
     				Iterator<Cell> cellIterator = nextRow.cellIterator();
     				SmidShgMemberApplication user = SmidShgMemberApplication.builder().build();

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
     				List<SmidShgMemberApplication> isExists = userList.stream()
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
         
         public ResponseEntity<ResponseInfoWrapper> createMembers(NulmShgMemberRequest memberrequest) {
     		try {
     			SmidShgMemberApplication smidapplication = objectMapper.convertValue(memberrequest.getSmidShgMemberApplication(),
     					SmidShgMemberApplication.class);
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
     	
     	public ResponseEntity<ResponseInfoWrapper> getMembers(NulmShgMemberRequest memberrequest) {
     		try {

     			SmidShgMemberApplication[] shg = objectMapper.convertValue(memberrequest.getSmidShgMemberApplication(),
     					SmidShgMemberApplication[].class);
     			SmidShgMemberApplication shgg = shg[0];
     			List<Role> role=memberrequest.getRequestInfo().getUserInfo().getRoles();
     			List<SmidShgMemberApplication> groupresult = repository.getMembers(shgg,role,memberrequest.getRequestInfo().getUserInfo().getId());
     			return new ResponseEntity<>(ResponseInfoWrapper.builder()
     					.responseInfo(ResponseInfo.builder().status(CommonConstants.SUCCESS).build())
     					.responseBody(groupresult).build(), HttpStatus.OK);
     		} catch (Exception e) {
     			e.printStackTrace();
     			throw new CustomException(CommonConstants.SMID_SHG_MEMBER_APPLICATION_EXCEPTION_CODE, e.getMessage());
     		}
     	}
     	public ResponseEntity<ResponseInfoWrapper> updateMembers(NulmShgMemberRequest memberrequest) {
     		try {
     			SmidShgMemberApplication smidapplication = objectMapper.convertValue(memberrequest.getSmidShgMemberApplication(),
     					SmidShgMemberApplication.class);
     			checkValidation(smidapplication);
     			String status = "";
     			repository.checkMemberUuid(smidapplication);
     			List<Role> role = memberrequest.getRequestInfo().getUserInfo().getRoles();
     			JSONArray groupresult = repository.getMemmberStatus(smidapplication);
     			JSONObject applicationData = (JSONObject) groupresult.get(0);
     			status = applicationData.get("application_status").toString();
     			for (Role roleobj : role) {
     				if ((roleobj.getCode()).equalsIgnoreCase(config.getRoleNgoUser())) {
     					
     					if (status.equalsIgnoreCase(SmidShgMemberApplication.StatusEnum.CREATED.toString())) {
     						smidapplication.setApplicationStatus(SmidShgMemberApplication.StatusEnum.CREATED);
     					}
     					if (status.equalsIgnoreCase(SmidShgMemberApplication.StatusEnum.APPROVED.toString())
     							|| status.equalsIgnoreCase(SmidShgMemberApplication.StatusEnum.REJECTED.toString())) {
     						smidapplication.setApplicationStatus(SmidShgMemberApplication.StatusEnum.UPDATED);
     					}
     				}
     				else {
     					smidapplication.setApplicationStatus(SmidShgMemberApplication.StatusEnum.fromValue(status));
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

	public ResponseEntity<ResponseInfoWrapper> deleteMembers(NulmShgMemberRequest memberrequest) {
		try {
			SmidShgMemberApplication smidapplication = objectMapper.convertValue(memberrequest.getSmidShgMemberApplication(),
					SmidShgMemberApplication.class);
			String status = "";
			repository.checkMemberUuid(smidapplication);
			List<Role> role = memberrequest.getRequestInfo().getUserInfo().getRoles();
			JSONArray groupresult = repository.getMemmberStatus(smidapplication);
			JSONObject applicationData = (JSONObject) groupresult.get(0);
			status = applicationData.get("application_status").toString();
			for (Role roleobj : role) {
				if ((roleobj.getCode()).equalsIgnoreCase(config.getRoleNgoUser()) ||
						(roleobj.getCode()).equalsIgnoreCase(config.getRoleCitizenUser())) {
					
					if (status.equalsIgnoreCase(SmidShgMemberApplication.StatusEnum.CREATED.toString())) {
						repository.hardDeleteMembers(smidapplication);
					}
					if (status.equalsIgnoreCase(SmidShgMemberApplication.StatusEnum.APPROVED.toString())
							|| status.equalsIgnoreCase(SmidShgMemberApplication.StatusEnum.REJECTED.toString())) {
						smidapplication.setApplicationStatus(SmidShgMemberApplication.StatusEnum.DELETIONINPROGRESS);
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

	private void checkValidation(SmidShgMemberApplication smidapplication) {
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
	
	public ResponseEntity<ResponseInfoWrapper> memberCount(NulmShgMemberRequest   request) {
		try {

			SmidShgMemberApplication smidapplication = objectMapper.convertValue(request.getSmidShgMemberApplication(),
					SmidShgMemberApplication.class);
			List<SmidShgMemberApplication> groupresult = repository.getMemberCount(smidapplication);
			return new ResponseEntity<>(ResponseInfoWrapper.builder()
					.responseInfo(ResponseInfo.builder().status(CommonConstants.SUCCESS).build())
					.responseBody(groupresult).build(), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			throw new CustomException(CommonConstants.SMID_SHG_APPLICATION_EXCEPTION_CODE, e.getMessage());
		}
	}
	public ResponseEntity<ResponseInfoWrapper> uplaodExternalGuest1(NulmShgMemberRequest memberrequest
			) throws IOException {
		try {
			log.debug("inside method uplaodExternalGuest execution begins");


		
			SmidShgMemberApplication[] guests = objectMapper.convertValue(memberrequest.getSmidShgMemberApplication(), SmidShgMemberApplication[].class);
			log.debug(objectMapper.writeValueAsString(guests));
			SmidShgMemberApplication guest=guests[0];
			
		
			

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
		
			
			List<SmidShgMemberApplication> userList = new ArrayList<>();
			List<SmidShgGroup> userList2 = new ArrayList<>();
			List<SmidShgMemberApplication> userListFinal = null;

			 XSSFWorkbook myWorkBook = new XSSFWorkbook (fileResource.getInputStream());
			XSSFSheet worksheet = myWorkBook.getSheetAt(0);
			Iterator<Row> rowIterator = worksheet.iterator();
			rowIterator.next(); // skip the header row

			log.debug("XLS SHEET STARTTO READ");

			SmidShgGroup user1 = SmidShgGroup.builder().build();
			
			Date d = null ;
			String ss =null ;
			String nn = null;
			

			while (rowIterator.hasNext()) {
				Row nextRow = rowIterator.next();
				Iterator<Cell> cellIterator = nextRow.cellIterator();
				
				SmidShgMemberApplication user = SmidShgMemberApplication.builder().build();

				while (cellIterator.hasNext()) {
					Cell nextCell = cellIterator.next();
					int columnIndex = nextCell.getColumnIndex();
					user.setApplicationId(guest.getShgUuid()+nextCell);
					user.setExternalFileStoreId(guest.getExternalFileStoreId());
					String uuid3 = UUID.randomUUID().toString();
					user.setApplicationUuid(uuid3);
					
					switch (columnIndex) {
					case 0:
						nextCell.setCellType(Cell.CELL_TYPE_STRING);
						String name = nextCell.getStringCellValue();
						user1.setName(name);
//						nn = user1.getName();
						if(name.isEmpty()) {
							user1.setName(nn);	
						}
						
						break;
					case 1:
						nextCell.setCellType(Cell.CELL_TYPE_STRING);
						String mobileno = nextCell.getStringCellValue();
						if(mobileno ==null || mobileno.isEmpty())
						{
							mobileno = "";	
						}

						break;
					case 2:

						nextCell.setCellType(Cell.CELL_TYPE_STRING);
						 String formendThrough = nextCell.getStringCellValue();
						 if(formendThrough ==null || formendThrough.isEmpty())
							{
							 formendThrough = "";	
							}
						
						user1.setFormendThrough(formendThrough);
							
						break;
					case 3:
						nextCell.setCellType(Cell.CELL_TYPE_NUMERIC);
						Double dateOfFormation = nextCell.getNumericCellValue();

						System.out.println("*************************");
						System.out.println("*************************"); 

						
						System.out.println("*************************");
						System.out.println("*************************");

						
						
						if(dateOfFormation != 0.0) {
						 Date date = nextRow.getCell(3).getDateCellValue();
						 Cell cell = nextRow.getCell(3);
						 String string2 = cell.toString();
						 System.out.println("*************************");
							System.out.println("*******hhhhhhhhhhhhh******");
						 System.out.println(string2);
						 String substr2 = string2.substring(3,6);
						 switch (substr2) {
						case "Jan":
							user1.setDateOfFormation((string2).replace("Jan","01"));
							
							ss= (string2).replace("Jan","01");
							break;
						case "Feb":
							user1.setDateOfFormation((string2).replace("Feb","02"));
							break;
						case "Mar":
							user1.setDateOfFormation((string2).replace("Mar","03"));
							break;
						case "Apr":
							user1.setDateOfFormation((string2).replace("Apr","04"));
							break;
						case "May":
							user1.setDateOfFormation((string2).replace("May","05"));
							break;
						case "Jun":
							user1.setDateOfFormation((string2).replace("Jun","06"));
							break;
						case "Jul":
							user1.setDateOfFormation((string2).replace("Jul","07"));
							break;
						case "Aug":
							user1.setDateOfFormation((string2).replace("Aug","08"));
							break;
						case "Sep":
							user1.setDateOfFormation((string2).replace("Sep","09"));
							break;
						case "Oct":
							user1.setDateOfFormation((string2).replace("Oct","10"));
							break;
						case "Nov":
							user1.setDateOfFormation((string2).replace("Nov","11"));
							break;
						case "Dec":
							user1.setDateOfFormation((string2).replace("Dec","12"));
							break;
						
						

						default:
							break;
						}
						 }else {
							 user1.setDateOfFormation(ss);
						}
						 

						break;
					case 4:
						nextCell.setCellType(Cell.CELL_TYPE_STRING);
						String contactNo = nextCell.getStringCellValue();
						if(contactNo ==null || contactNo.isEmpty())
						{
							contactNo = "";	
						}
						user1.setContactNo(contactNo);
						break;
					case 5:
						nextCell.setCellType(Cell.CELL_TYPE_STRING);
						String address = nextCell.getStringCellValue();
						if(address ==null || address.isEmpty())
						{
							address = "";	
						}
						user1.setAddress(address);
						break;
					case 6:
						nextCell.setCellType(Cell.CELL_TYPE_STRING);
						String accountNo = nextCell.getStringCellValue();
						if(accountNo ==null || accountNo.isEmpty())
						{
							accountNo = "";	
						}
						user1.setAccountNo(accountNo);
						break;
					case 7:
						nextCell.setCellType(Cell.CELL_TYPE_NUMERIC);
						Double dateOfFormation1 = nextCell.getNumericCellValue();
						if(dateOfFormation1 != 0.0) {
							 Date date = nextRow.getCell(7).getDateCellValue();
							 Cell cell = nextRow.getCell(7);
							 String string2 = cell.toString();
							 System.out.println("*************************");
								System.out.println("*******hhhhhhhhhhhhh******");
							 System.out.println(string2);
							 String substr2 = string2.substring(3,6);
							 switch (substr2) {
							case "Jan":
								user1.setDateOfOpeningAccount((string2).replace("Jan","01"));
								
								ss= (string2).replace("Jan","01");
								break;
							case "Feb":
								user1.setDateOfOpeningAccount((string2).replace("Feb","02"));
								break;
							case "Mar":
								user1.setDateOfOpeningAccount((string2).replace("Mar","03"));
								break;
							case "Apr":
								user1.setDateOfOpeningAccount((string2).replace("Apr","04"));
								break;
							case "May":
								user1.setDateOfOpeningAccount((string2).replace("May","05"));
								break;
							case "Jun":
								user1.setDateOfOpeningAccount((string2).replace("Jun","06"));
								break;
							case "Jul":
								user1.setDateOfOpeningAccount((string2).replace("Jul","07"));
								break;
							case "Aug":
								user1.setDateOfOpeningAccount((string2).replace("Aug","08"));
								break;
							case "Sep":
								user1.setDateOfOpeningAccount((string2).replace("Sep","09"));
								break;
							case "Oct":
								user1.setDateOfOpeningAccount((string2).replace("Oct","10"));
								break;
							case "Nov":
								user1.setDateOfOpeningAccount((string2).replace("Nov","11"));
								break;
							case "Dec":
								user1.setDateOfOpeningAccount((string2).replace("Dec","12"));
								break;
							
							

							default:
								break;
							}
							 }else {
								 user1.setDateOfOpeningAccount(null);
							}

						break;
					case 8:
						nextCell.setCellType(Cell.CELL_TYPE_STRING);
						String bankName = nextCell.getStringCellValue();
						if(bankName ==null || bankName.isEmpty())
						{
							bankName = "";	
						}
						user1.setBankName(bankName);
						break;
					case 9:
						nextCell.setCellType(Cell.CELL_TYPE_STRING);
						String branchName = nextCell.getStringCellValue();
						if(branchName ==null || branchName.isEmpty())
						{
							branchName = "";	
						}
						user1.setBranchName(branchName);
						break;
					case 10:
						nextCell.setCellType(Cell.CELL_TYPE_STRING);
						String mainAcitivity = nextCell.getStringCellValue();
						if(mainAcitivity ==null || mainAcitivity.isEmpty())
						{
							mainAcitivity = "";	
						}
						user1.setMainAcitivity(mainAcitivity);
						break;
					case 11:
						nextCell.setCellType(Cell.CELL_TYPE_STRING);
						String groupNominatedBy = nextCell.getStringCellValue();
						if(groupNominatedBy ==null || groupNominatedBy.isEmpty())
						{
							groupNominatedBy = "";	
						}
						user1.setGroupNominatedBy(groupNominatedBy);
						break;
					case 12:
						nextCell.setCellType(Cell.CELL_TYPE_STRING);
						String name1 = nextCell.getStringCellValue();
						if(name1 ==null || name1.isEmpty())
						{
							name1 = "";	
						}
						user.setName(name1);

					
						break;
					case 13:
						nextCell.setCellType(Cell.CELL_TYPE_STRING);
						String position = nextCell.getStringCellValue();
						if(position ==null || position.isEmpty())
						{
							position = "";	
						}
						user.setPositionLevel(position);
						break;
					case 14:
						nextCell.setCellType(Cell.CELL_TYPE_STRING);
						String phone = nextCell.getStringCellValue();
						if(phone ==null || phone.isEmpty())
						{
							mainAcitivity = "";	
						}
						user.setMobileNo(phone);
						break;
					case 15:
						nextCell.setCellType(Cell.CELL_TYPE_STRING);
						String gender = nextCell.getStringCellValue();
						if(gender ==null || gender.isEmpty())
						{
							gender = "";	
						}
						user.setGender(gender);
						break;	
					case 166:
						nextCell.setCellType(Cell.CELL_TYPE_NUMERIC);
						
						Double dateOfFormation11 = nextCell.getNumericCellValue();
						if(dateOfFormation11 != 0.0) {
							 Date date = nextRow.getCell(16).getDateCellValue();
							 Cell cell = nextRow.getCell(16);
							 String string2 = cell.toString();
							 System.out.println("*************************");
								System.out.println("*******hhhhhhhhhhhhh******");
							 System.out.println(string2);
							 String substr2 = string2.substring(3,6);
							 switch (substr2) {
							case "Jan":
								user.setDob((string2).replace("Jan","01"));
								
								ss= (string2).replace("Jan","01");
								break;
							case "Feb":
								user.setDob((string2).replace("Feb","02"));
								break;
							case "Mar":
								user.setDob((string2).replace("Mar","03"));
								break;
							case "Apr":
								user.setDob((string2).replace("Apr","04"));
								break;
							case "May":
								user.setDob((string2).replace("May","05"));
								break;
							case "Jun":
								user.setDob((string2).replace("Jun","06"));
								break;
							case "Jul":
								user.setDob((string2).replace("Jul","07"));
								break;
							case "Aug":
								user.setDob((string2).replace("Aug","08"));
								break;
							case "Sep":
								user.setDob((string2).replace("Sep","09"));
								break;
							case "Oct":
								user.setDob((string2).replace("Oct","10"));
								break;
							case "Nov":
								user.setDob((string2).replace("Nov","11"));
								break;
							case "Dec":
								user.setDob((string2).replace("Dec","12"));
								break;
							
							

							default:
								break;
							}
							 }else {
								 user.setDob(null);
							}
						

						break;
					case 17:
						nextCell.setCellType(Cell.CELL_TYPE_STRING);
						String caste = nextCell.getStringCellValue();
						if(caste ==null || caste.isEmpty())
						{
							caste = "";	
						}
						user.setCaste(caste);
						break;						
					default:
						break;
					}

				}

				
				user1.setIsActive(true);
				user1.setTenantId("ch.chandigarh");
				user1.setAuditDetails(
						auditDetailsUtil.getAuditDetails(memberrequest.getRequestInfo(), CommonConstants.ACTION_CREATE));
				// idgen service call to genrate event id
				
				if(!user1.getName().equalsIgnoreCase(nn)) {
				IdGenerationResponse id = idgenrepository.getId(memberrequest.getRequestInfo(), user1.getTenantId(),
						config.getSmidShgIdgenName(), config.getSmidShgIdgenFormat(), 1);
				nn=user1.getName();

					user1.setShgId(id.getIdResponses().get(0).getId());
				user1.setStatus(StatusEnum.APPROVED);
				}
			else {
				System.out.println("NNNN");
				}
				
				if (!user1.getAccountNo().isEmpty()) {
						String uuid = UUID.randomUUID().toString();
						user1.setShgUuid(uuid);
						user.setShgUuid(user1.getShgUuid());
						repository1.createGroup(user1);

						String uuid7 = UUID.randomUUID().toString();
						
						
						user.setApplicationUuid(uuid7);
						user.setShgUuid(user1.getShgUuid());

						userList.add(user);
						}
					else {
						String uuid7 = UUID.randomUUID().toString();
						
						user.setApplicationUuid(uuid7);

						user.setShgUuid(user1.getShgUuid());
			
						userList.add(user);
					}
				

				System.out.println("******************************************");
			}
			userListFinal = repository.saveGuest(userList, memberrequest);
			
			
			System.out.println(userList);
			log.debug("size of userList="+userList);

			if (!userList.isEmpty()) {
				log.debug("size of userList="+userList.size());
				return new ResponseEntity(ResponseInfoWrapper.builder()
						.responseInfo(ResponseInfo.builder().status(CommonConstants.SUCCESS).build())
						.responseBody(userListFinal).build(), HttpStatus.CREATED);
				
			} else {
				throw new CustomException(HttpStatus.INTERNAL_SERVER_ERROR.toString(), CommonConstants.ID_GENERATION_1);
			}

		} catch (Exception exception) {
		
			exception.printStackTrace();
			throw new CustomException(HttpStatus.INTERNAL_SERVER_ERROR.toString(), CommonConstants.ID_GENERATION_2);
		}
	}



	
}
