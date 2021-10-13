package org.egov.prscp.web.models;

import java.util.List;
import org.easymock.EasyMock;
import org.egov.common.contract.request.Role;
import org.junit.*;
import static org.junit.Assert.*;


public class OwnerInfoTest {
	
	@Test
	public void testOwnerInfo_1()
		throws Exception {

		OwnerInfo result = new OwnerInfo();

		assertNotNull(result);
		assertEquals(null, result.getOwnerType());
		assertEquals(null, result.getInstitutionId());
		assertEquals(null, result.getUserActive());
		assertEquals(null, result.getRelationship());
		assertEquals(null, result.getDocuments());
		assertEquals(null, result.getIsPrimaryOwner());
		assertEquals(null, result.getOwnerShipPercentage());
		//assertEquals("User(id=null, uuid=null, userName=null, password=null, salutation=null, name=null, gender=null, mobileNumber=null, emailId=null, altContactNumber=null, pan=null, aadhaarNumber=null, permanentAddress=null, permanentCity=null, permanentPincode=null, correspondenceCity=null, correspondencePincode=null, correspondenceAddress=null, active=null, dob=null, pwdExpiryDate=null, locale=null, type=null, signature=null, accountLocked=null, roles=null, fatherOrHusbandName=null, bloodGroup=null, identificationMark=null, photo=null, createdBy=null, createdDate=null, lastModifiedBy=null, lastModifiedDate=null, otpReference=null, tenantId=null)", result.toString());
		assertEquals(null, result.getName());
		assertEquals(null, result.getId());
		assertEquals(null, result.getType());
		assertEquals(null, result.getSignature());
		assertEquals(null, result.getPassword());
		assertEquals(null, result.getLocale());
		assertEquals(null, result.getActive());
		assertEquals(null, result.getRoles());
		assertEquals(null, result.getMobileNumber());
		assertEquals(null, result.getEmailId());
		assertEquals(null, result.getDob());
		assertEquals(null, result.getBloodGroup());
		assertEquals(null, result.getPhoto());
		assertEquals(null, result.getPan());
		assertEquals(null, result.getCreatedDate());
		assertEquals(null, result.getAadhaarNumber());
		assertEquals(null, result.getPwdExpiryDate());
		assertEquals(null, result.getPermanentCity());
		assertEquals(null, result.getAccountLocked());
		assertEquals(null, result.getSalutation());
		assertEquals(null, result.getUuid());
		assertEquals(null, result.getGender());
		assertEquals(null, result.getOtpReference());
		assertEquals(null, result.getUserName());
		assertEquals(null, result.getLastModifiedDate());
		assertEquals(null, result.getLastModifiedBy());
		assertEquals(null, result.getCreatedBy());
		assertEquals(null, result.getTenantId());
		assertEquals(null, result.getCorrespondenceCity());
		assertEquals(null, result.getIdentificationMark());
		assertEquals(null, result.getPermanentPincode());
		assertEquals(null, result.getCorrespondenceAddress());
		assertEquals(null, result.getCorrespondencePincode());
		assertEquals(null, result.getAltContactNumber());
		assertEquals(null, result.getPermanentAddress());
		assertEquals(null, result.getFatherOrHusbandName());
	}


	@Test
	public void testOwnerInfo_3()
		throws Exception {
		Boolean isPrimaryOwner = new Boolean(true);
		Double ownerShipPercentage = new Double(1.0);
		String ownerType = "";
		String institutionId = "";
		List<Document> documents = EasyMock.createMock(List.class);
		Boolean userActive = new Boolean(true);
		OwnerInfo.RelationshipEnum relationship = OwnerInfo.RelationshipEnum.FATHER;
	
		EasyMock.replay(documents);

		OwnerInfo result = new OwnerInfo(isPrimaryOwner, ownerShipPercentage, ownerType, institutionId, documents, userActive, relationship);

	
		EasyMock.verify(documents);
		assertNotNull(result);
		assertEquals("", result.getOwnerType());
		assertEquals("", result.getInstitutionId());
		assertEquals(Boolean.TRUE, result.getUserActive());
		assertEquals(Boolean.TRUE, result.getIsPrimaryOwner());
		assertEquals(new Double(1.0), result.getOwnerShipPercentage());
		//assertEquals("User(id=null, uuid=null, userName=null, password=null, salutation=null, name=null, gender=null, mobileNumber=null, emailId=null, altContactNumber=null, pan=null, aadhaarNumber=null, permanentAddress=null, permanentCity=null, permanentPincode=null, correspondenceCity=null, correspondencePincode=null, correspondenceAddress=null, active=null, dob=null, pwdExpiryDate=null, locale=null, type=null, signature=null, accountLocked=null, roles=null, fatherOrHusbandName=null, bloodGroup=null, identificationMark=null, photo=null, createdBy=null, createdDate=null, lastModifiedBy=null, lastModifiedDate=null, otpReference=null, tenantId=null)", result.toString());
		assertEquals(null, result.getName());
		assertEquals(null, result.getId());
		assertEquals(null, result.getType());
		assertEquals(null, result.getSignature());
		assertEquals(null, result.getPassword());
		assertEquals(null, result.getLocale());
		assertEquals(null, result.getActive());
		assertEquals(null, result.getRoles());
		assertEquals(null, result.getMobileNumber());
		assertEquals(null, result.getEmailId());
		assertEquals(null, result.getDob());
		assertEquals(null, result.getBloodGroup());
		assertEquals(null, result.getPhoto());
		assertEquals(null, result.getPan());
		assertEquals(null, result.getCreatedDate());
		assertEquals(null, result.getAadhaarNumber());
		assertEquals(null, result.getPwdExpiryDate());
		assertEquals(null, result.getPermanentCity());
		assertEquals(null, result.getAccountLocked());
		assertEquals(null, result.getSalutation());
		assertEquals(null, result.getUuid());
		assertEquals(null, result.getGender());
		assertEquals(null, result.getOtpReference());
		assertEquals(null, result.getUserName());
		assertEquals(null, result.getLastModifiedDate());
		assertEquals(null, result.getLastModifiedBy());
		assertEquals(null, result.getCreatedBy());
		assertEquals(null, result.getTenantId());
		assertEquals(null, result.getCorrespondenceCity());
		assertEquals(null, result.getIdentificationMark());
		assertEquals(null, result.getPermanentPincode());
		assertEquals(null, result.getCorrespondenceAddress());
		assertEquals(null, result.getCorrespondencePincode());
		assertEquals(null, result.getAltContactNumber());
		assertEquals(null, result.getPermanentAddress());
		assertEquals(null, result.getFatherOrHusbandName());
	}

	
	@Test
	public void testOwnerInfo_4()
		throws Exception {
		Long id = new Long(1L);
		String uuid = "";
		String userName = "";
		String password = "";
		String salutation = "";
		String name = "";
		String gender = "";
		String mobileNumber = "";
		String emailId = "";
		String altContactNumber = "";
		String pan = "";
		String aadhaarNumber = "";
		String permanentAddress = "";
		String permanentCity = "";
		String permanentPincode = "";
		String correspondenceCity = "";
		String correspondencePincode = "";
		String correspondenceAddress = "";
		Boolean active = new Boolean(true);
		Long dob = new Long(1L);
		Long pwdExpiryDate = new Long(1L);
		String locale = "";
		String type = "";
		String signature = "";
		Boolean accountLocked = new Boolean(true);
		List<Role> roles = EasyMock.createMock(List.class);
		String fatherOrHusbandName = "";
		String bloodGroup = "";
		String identificationMark = "";
		String photo = "";
		String createdBy = "";
		Long createdDate = new Long(1L);
		String lastModifiedBy = "";
		Long lastModifiedDate = new Long(1L);
		String otpReference = "";
		String tenantId = "";
		Boolean isPrimaryOwner = new Boolean(true);
		Double ownerShipPercentage = new Double(1.0);
		String ownerType = "";
		String institutionId = "";
		List<Document> documents = EasyMock.createMock(List.class);
		OwnerInfo.RelationshipEnum relationship = OwnerInfo.RelationshipEnum.FATHER;
		Boolean userActive = new Boolean(true);
		

		EasyMock.replay(roles);
		EasyMock.replay(documents);

		OwnerInfo result = new OwnerInfo(id, uuid, userName, password, salutation, name, gender, mobileNumber, emailId, altContactNumber, pan, aadhaarNumber, permanentAddress, permanentCity, permanentPincode, correspondenceCity, correspondencePincode, correspondenceAddress, active, dob, pwdExpiryDate, locale, type, signature, accountLocked, roles, fatherOrHusbandName, bloodGroup, identificationMark, photo, createdBy, createdDate, lastModifiedBy, lastModifiedDate, otpReference, tenantId, isPrimaryOwner, ownerShipPercentage, ownerType, institutionId, documents, relationship, userActive);

	
		EasyMock.verify(roles);
		EasyMock.verify(documents);
		assertNotNull(result);
		assertEquals("", result.getOwnerType());
		assertEquals("", result.getInstitutionId());
		assertEquals(Boolean.TRUE, result.getUserActive());
		assertEquals(Boolean.TRUE, result.getIsPrimaryOwner());
		assertEquals(new Double(1.0), result.getOwnerShipPercentage());
		//assertEquals("User(id=1, uuid=, userName=, password=, salutation=, name=, gender=, mobileNumber=, emailId=, altContactNumber=, pan=, aadhaarNumber=, permanentAddress=, permanentCity=, permanentPincode=, correspondenceCity=, correspondencePincode=, correspondenceAddress=, active=true, dob=1, pwdExpiryDate=1, locale=, type=, signature=, accountLocked=true, roles=EasyMock for interface java.util.List, fatherOrHusbandName=, bloodGroup=, identificationMark=, photo=, createdBy=, createdDate=1, lastModifiedBy=, lastModifiedDate=1, otpReference=, tenantId=)", result.toString());
		assertEquals("", result.getName());
		assertEquals(new Long(1L), result.getId());
		assertEquals("", result.getType());
		assertEquals("", result.getSignature());
		assertEquals("", result.getPassword());
		assertEquals("", result.getLocale());
		assertEquals(Boolean.TRUE, result.getActive());
		assertEquals("", result.getMobileNumber());
		assertEquals("", result.getEmailId());
		assertEquals(new Long(1L), result.getDob());
		assertEquals("", result.getBloodGroup());
		assertEquals("", result.getPhoto());
		assertEquals("", result.getPan());
		assertEquals(new Long(1L), result.getCreatedDate());
		assertEquals("", result.getAadhaarNumber());
		assertEquals(new Long(1L), result.getPwdExpiryDate());
		assertEquals("", result.getPermanentCity());
		assertEquals(Boolean.TRUE, result.getAccountLocked());
		assertEquals("", result.getSalutation());
		assertEquals("", result.getUuid());
		assertEquals("", result.getGender());
		assertEquals("", result.getOtpReference());
		assertEquals("", result.getUserName());
		assertEquals(new Long(1L), result.getLastModifiedDate());
		assertEquals("", result.getLastModifiedBy());
		assertEquals("", result.getCreatedBy());
		assertEquals("", result.getTenantId());
		assertEquals("", result.getCorrespondenceCity());
		assertEquals("", result.getIdentificationMark());
		assertEquals("", result.getPermanentPincode());
		assertEquals("", result.getCorrespondenceAddress());
		assertEquals("", result.getCorrespondencePincode());
		assertEquals("", result.getAltContactNumber());
		assertEquals("", result.getPermanentAddress());
		assertEquals("", result.getFatherOrHusbandName());
	}

	@Test
	public void testAddCitizenDetail_1()
		throws Exception {
		OwnerInfo fixture = new OwnerInfo(new Boolean(true), new Double(1.0), "", "", EasyMock.createNiceMock(List.class), new Boolean(true), OwnerInfo.RelationshipEnum.FATHER);
		User user = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", new Boolean(true), new Long(1L), new Long(1L), "", "", "", new Boolean(true), EasyMock.createNiceMock(List.class), "", "", "", "", "", new Long(1L), "", new Long(1L), "", "");

		fixture.addCitizenDetail(user);

	}

	

	@Test
	public void testAddDocumentsItem_2()
		throws Exception {
		OwnerInfo fixture = new OwnerInfo(new Boolean(true), new Double(1.0), "", "", (List<Document>) null, new Boolean(true), OwnerInfo.RelationshipEnum.FATHER);
		Document documentsItem = DocumentFactory.createDocument2();

		OwnerInfo result = fixture.addDocumentsItem(documentsItem);

		assertNotNull(result);
		assertEquals("", result.getOwnerType());
		assertEquals("", result.getInstitutionId());
		assertEquals(Boolean.TRUE, result.getUserActive());
		assertEquals(Boolean.TRUE, result.getIsPrimaryOwner());
		assertEquals(new Double(1.0), result.getOwnerShipPercentage());
	//	assertEquals("User(id=null, uuid=null, userName=null, password=null, salutation=null, name=null, gender=null, mobileNumber=null, emailId=null, altContactNumber=null, pan=null, aadhaarNumber=null, permanentAddress=null, permanentCity=null, permanentPincode=null, correspondenceCity=null, correspondencePincode=null, correspondenceAddress=null, active=null, dob=null, pwdExpiryDate=null, locale=null, type=null, signature=null, accountLocked=null, roles=null, fatherOrHusbandName=null, bloodGroup=null, identificationMark=null, photo=null, createdBy=null, createdDate=null, lastModifiedBy=null, lastModifiedDate=null, otpReference=null, tenantId=null)", result.toString());
		assertEquals(null, result.getName());
		assertEquals(null, result.getId());
		assertEquals(null, result.getType());
		assertEquals(null, result.getSignature());
		assertEquals(null, result.getPassword());
		assertEquals(null, result.getLocale());
		assertEquals(null, result.getActive());
		assertEquals(null, result.getRoles());
		assertEquals(null, result.getMobileNumber());
		assertEquals(null, result.getEmailId());
		assertEquals(null, result.getDob());
		assertEquals(null, result.getBloodGroup());
		assertEquals(null, result.getPhoto());
		assertEquals(null, result.getPan());
		assertEquals(null, result.getCreatedDate());
		assertEquals(null, result.getAadhaarNumber());
		assertEquals(null, result.getPwdExpiryDate());
		assertEquals(null, result.getPermanentCity());
		assertEquals(null, result.getAccountLocked());
		assertEquals(null, result.getSalutation());
		assertEquals(null, result.getUuid());
		assertEquals(null, result.getGender());
		assertEquals(null, result.getOtpReference());
		assertEquals(null, result.getUserName());
		assertEquals(null, result.getLastModifiedDate());
		assertEquals(null, result.getLastModifiedBy());
		assertEquals(null, result.getCreatedBy());
		assertEquals(null, result.getTenantId());
		assertEquals(null, result.getCorrespondenceCity());
		assertEquals(null, result.getIdentificationMark());
		assertEquals(null, result.getPermanentPincode());
		assertEquals(null, result.getCorrespondenceAddress());
		assertEquals(null, result.getCorrespondencePincode());
		assertEquals(null, result.getAltContactNumber());
		assertEquals(null, result.getPermanentAddress());
		assertEquals(null, result.getFatherOrHusbandName());
	}

	@Test
	public void testAddUserDetail_1()
		throws Exception {
		OwnerInfo fixture = new OwnerInfo(new Boolean(true), new Double(1.0), "", "", EasyMock.createNiceMock(List.class), new Boolean(true), OwnerInfo.RelationshipEnum.FATHER);
		User user = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", new Boolean(true), new Long(1L), new Long(1L), "", "", "", new Boolean(true), EasyMock.createNiceMock(List.class), "", "", "", "", "", new Long(1L), "", new Long(1L), "", "");

		fixture.addUserDetail(user);

	}

	
	@Test
	public void testAddUserWithoutAuditDetail_1()
		throws Exception {
		OwnerInfo fixture = new OwnerInfo(new Boolean(true), new Double(1.0), "", "", EasyMock.createNiceMock(List.class), new Boolean(true), OwnerInfo.RelationshipEnum.FATHER);
		OwnerInfo user = new OwnerInfo();

		fixture.addUserWithoutAuditDetail(user);

	}

	
	@Test
	public void testBuilder_1()
		throws Exception {

		OwnerInfo.OwnerInfoBuilder result = OwnerInfo.builder();

		assertNotNull(result);
		assertEquals("OwnerInfo.OwnerInfoBuilder(id=null, uuid=null, userName=null, password=null, salutation=null, name=null, gender=null, mobileNumber=null, emailId=null, altContactNumber=null, pan=null, aadhaarNumber=null, permanentAddress=null, permanentCity=null, permanentPincode=null, correspondenceCity=null, correspondencePincode=null, correspondenceAddress=null, active=null, dob=null, pwdExpiryDate=null, locale=null, type=null, signature=null, accountLocked=null, roles=null, fatherOrHusbandName=null, bloodGroup=null, identificationMark=null, photo=null, createdBy=null, createdDate=null, lastModifiedBy=null, lastModifiedDate=null, otpReference=null, tenantId=null, isPrimaryOwner=null, ownerShipPercentage=null, ownerType=null, institutionId=null, documents=null, relationship=null, userActive=null)", result.toString());
	}

	
	@Test
	public void testEquals_1()
		throws Exception {
		OwnerInfo fixture = new OwnerInfo(new Boolean(true), new Double(1.0), "", "", EasyMock.createNiceMock(List.class), new Boolean(true), OwnerInfo.RelationshipEnum.FATHER);
		Object o = new OwnerInfo(new Boolean(true), new Double(1.0), "", "", EasyMock.createNiceMock(List.class), new Boolean(true), OwnerInfo.RelationshipEnum.FATHER);

		boolean result = fixture.equals(o);

		assertEquals(true, result);
	}

	
	@Test
	public void testEquals_2()
		throws Exception {
		OwnerInfo fixture = new OwnerInfo(new Boolean(true), new Double(1.0), "", "", EasyMock.createNiceMock(List.class), new Boolean(true), OwnerInfo.RelationshipEnum.FATHER);
		Object o = null;

		boolean result = fixture.equals(o);

	
		assertEquals(false, result);
	}


	@Test
	public void testEquals_3()
		throws Exception {
		OwnerInfo fixture = new OwnerInfo(new Boolean(true), new Double(1.0), "", "", EasyMock.createNiceMock(List.class), new Boolean(true), OwnerInfo.RelationshipEnum.FATHER);
		Object o = new Object();

		boolean result = fixture.equals(o);

		
		assertEquals(false, result);
	}

	
	@Test
	public void testEquals_4()
		throws Exception {
		OwnerInfo fixture = new OwnerInfo(new Boolean(true), new Double(1.0), "", "", EasyMock.createNiceMock(List.class), new Boolean(true), OwnerInfo.RelationshipEnum.FATHER);
		Object o = new Object();

		boolean result = fixture.equals(o);

		
		assertEquals(false, result);
	}

	
	@Test
	public void testEquals_5()
		throws Exception {
		OwnerInfo fixture = new OwnerInfo(new Boolean(true), new Double(1.0), "", "", EasyMock.createNiceMock(List.class), new Boolean(true), OwnerInfo.RelationshipEnum.FATHER);
		Object o = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", new Boolean(true), new Long(1L), new Long(1L), "", "", "", new Boolean(true), EasyMock.createNiceMock(List.class), "", "", "", "", "", new Long(1L), "", new Long(1L), "", "");

		boolean result = fixture.equals(o);

		
		assertEquals(false, result);
	}

	
	@Test
	public void testEquals_6()
		throws Exception {
		OwnerInfo fixture = new OwnerInfo(new Boolean(true), new Double(1.0), "", "", EasyMock.createNiceMock(List.class), new Boolean(true), OwnerInfo.RelationshipEnum.FATHER);
		Object o = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", new Boolean(true), new Long(1L), new Long(1L), "", "", "", new Boolean(true), EasyMock.createNiceMock(List.class), "", "", "", "", "", new Long(1L), "", new Long(1L), "", "");

		boolean result = fixture.equals(o);

		
		assertEquals(false, result);
	}

	@Test
	public void testEquals_7()
		throws Exception {
		OwnerInfo fixture = new OwnerInfo(new Boolean(true), new Double(1.0), "", "", EasyMock.createNiceMock(List.class), new Boolean(true), OwnerInfo.RelationshipEnum.FATHER);
		Object o = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", new Boolean(true), new Long(1L), new Long(1L), "", "", "", new Boolean(true), EasyMock.createNiceMock(List.class), "", "", "", "", "", new Long(1L), "", new Long(1L), "", "");

		boolean result = fixture.equals(o);

	
		assertEquals(false, result);
	}

	@Test
	public void testEquals_8()
		throws Exception {
		OwnerInfo fixture = new OwnerInfo(new Boolean(true), new Double(1.0), "", "", EasyMock.createNiceMock(List.class), new Boolean(true), OwnerInfo.RelationshipEnum.FATHER);
		Object o = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", new Boolean(true), new Long(1L), new Long(1L), "", "", "", new Boolean(true), EasyMock.createNiceMock(List.class), "", "", "", "", "", new Long(1L), "", new Long(1L), "", "");

		boolean result = fixture.equals(o);

		assertEquals(false, result);
	}


	@Test
	public void testGetDocuments_1()
		throws Exception {
		OwnerInfo fixture = new OwnerInfo(new Boolean(true), new Double(1.0), "", "", EasyMock.createNiceMock(List.class), new Boolean(true), OwnerInfo.RelationshipEnum.FATHER);

		List<Document> result = fixture.getDocuments();

		assertNotNull(result);
		assertEquals(0, result.size());
	}

	
	@Test
	public void testGetInstitutionId_1()
		throws Exception {
		OwnerInfo fixture = new OwnerInfo(new Boolean(true), new Double(1.0), "", "", EasyMock.createNiceMock(List.class), new Boolean(true), OwnerInfo.RelationshipEnum.FATHER);

		String result = fixture.getInstitutionId();

		assertEquals("", result);
	}

	@Test
	public void testGetIsPrimaryOwner_1()
		throws Exception {
		OwnerInfo fixture = new OwnerInfo(new Boolean(true), new Double(1.0), "", "", EasyMock.createNiceMock(List.class), new Boolean(true), OwnerInfo.RelationshipEnum.FATHER);

		Boolean result = fixture.getIsPrimaryOwner();

		assertNotNull(result);
		assertEquals("true", result.toString());
		assertEquals(true, result.booleanValue());
	}

	
	@Test
	public void testGetOwnerShipPercentage_1()
		throws Exception {
		OwnerInfo fixture = new OwnerInfo(new Boolean(true), new Double(1.0), "", "", EasyMock.createNiceMock(List.class), new Boolean(true), OwnerInfo.RelationshipEnum.FATHER);

		Double result = fixture.getOwnerShipPercentage();

	
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
	public void testGetOwnerType_1()
		throws Exception {
		OwnerInfo fixture = new OwnerInfo(new Boolean(true), new Double(1.0), "", "", EasyMock.createNiceMock(List.class), new Boolean(true), OwnerInfo.RelationshipEnum.FATHER);

		String result = fixture.getOwnerType();

		assertEquals("", result);
	}

	@Test
	public void testGetRelationship_1()
		throws Exception {
		OwnerInfo fixture = new OwnerInfo(new Boolean(true), new Double(1.0), "", "", EasyMock.createNiceMock(List.class), new Boolean(true), OwnerInfo.RelationshipEnum.FATHER);

		OwnerInfo.RelationshipEnum result = fixture.getRelationship();

	
		assertNotNull(result);
		assertEquals("FATHER", result.toString());
		assertEquals("FATHER", result.name());
		assertEquals(0, result.ordinal());
	}

	
	@Test
	public void testGetUserActive_1()
		throws Exception {
		OwnerInfo fixture = new OwnerInfo(new Boolean(true), new Double(1.0), "", "", EasyMock.createNiceMock(List.class), new Boolean(true), OwnerInfo.RelationshipEnum.FATHER);

		Boolean result = fixture.getUserActive();

		assertNotNull(result);
		assertEquals("true", result.toString());
		assertEquals(true, result.booleanValue());
	}

	@Test
	public void testHashCode_1()
		throws Exception {
		OwnerInfo fixture = new OwnerInfo(new Boolean(true), new Double(1.0), "", "", EasyMock.createNiceMock(List.class), new Boolean(true), OwnerInfo.RelationshipEnum.FATHER);

		int result = fixture.hashCode();

		assertEquals(29791, result);
	}


	@Test
	public void testSetDocuments_1()
		throws Exception {
		OwnerInfo fixture = new OwnerInfo(new Boolean(true), new Double(1.0), "", "", EasyMock.createNiceMock(List.class), new Boolean(true), OwnerInfo.RelationshipEnum.FATHER);
		List<Document> documents = EasyMock.createMock(List.class);
	

		EasyMock.replay(documents);

		fixture.setDocuments(documents);

	
		EasyMock.verify(documents);
	}

	
	@Test
	public void testSetInstitutionId_1()
		throws Exception {
		OwnerInfo fixture = new OwnerInfo(new Boolean(true), new Double(1.0), "", "", EasyMock.createNiceMock(List.class), new Boolean(true), OwnerInfo.RelationshipEnum.FATHER);
		String institutionId = "";

		fixture.setInstitutionId(institutionId);

	}

	
	@Test
	public void testSetIsPrimaryOwner_1()
		throws Exception {
		OwnerInfo fixture = new OwnerInfo(new Boolean(true), new Double(1.0), "", "", EasyMock.createNiceMock(List.class), new Boolean(true), OwnerInfo.RelationshipEnum.FATHER);
		Boolean isPrimaryOwner = new Boolean(true);

		fixture.setIsPrimaryOwner(isPrimaryOwner);

	}


	@Test
	public void testSetOwnerShipPercentage_1()
		throws Exception {
		OwnerInfo fixture = new OwnerInfo(new Boolean(true), new Double(1.0), "", "", EasyMock.createNiceMock(List.class), new Boolean(true), OwnerInfo.RelationshipEnum.FATHER);
		Double ownerShipPercentage = new Double(1.0);

		fixture.setOwnerShipPercentage(ownerShipPercentage);

	}

	@Test
	public void testSetOwnerType_1()
		throws Exception {
		OwnerInfo fixture = new OwnerInfo(new Boolean(true), new Double(1.0), "", "", EasyMock.createNiceMock(List.class), new Boolean(true), OwnerInfo.RelationshipEnum.FATHER);
		String ownerType = "";

		fixture.setOwnerType(ownerType);

	}

	@Test
	public void testSetRelationship_1()
		throws Exception {
		OwnerInfo fixture = new OwnerInfo(new Boolean(true), new Double(1.0), "", "", EasyMock.createNiceMock(List.class), new Boolean(true), OwnerInfo.RelationshipEnum.FATHER);
		OwnerInfo.RelationshipEnum relationship = OwnerInfo.RelationshipEnum.FATHER;

		fixture.setRelationship(relationship);

	}

	
	@Test
	public void testSetUserActive_1()
		throws Exception {
		OwnerInfo fixture = new OwnerInfo(new Boolean(true), new Double(1.0), "", "", EasyMock.createNiceMock(List.class), new Boolean(true), OwnerInfo.RelationshipEnum.FATHER);
		Boolean userActive = new Boolean(true);

		fixture.setUserActive(userActive);

		
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
		new org.junit.runner.JUnitCore().run(OwnerInfoTest.class);
	}
}