package org.egov.ec.web.models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.egov.common.contract.request.Role;
import org.egov.ec.web.models.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class UserTest {
	@InjectMocks
	private User user;

	@Test
	public void testUser_1() throws Exception {
		Long id = new Long(1L);
		String uuid = "";
		String username = "";
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
		String permanentPinCode = "";
		String correspondenceCity = "";
		String correspondencePinCode = "";
		String correspondenceAddress = "";
		Boolean active = new Boolean(true);
		Long dob = new Long(1L);
		Long pwdExpiryDate = new Long(1L);
		String locale = "";
		String type = "";
		String signature = "";
		Boolean accountLocked = new Boolean(true);
		List<Role> roles = null;
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

		User result = new User(id, uuid, username, password, salutation, name, gender, mobileNumber, emailId,
				altContactNumber, pan, aadhaarNumber, permanentAddress, permanentCity, permanentPinCode,
				correspondenceCity, correspondencePinCode, correspondenceAddress, active, dob, pwdExpiryDate, locale,
				type, signature, accountLocked, roles, fatherOrHusbandName, bloodGroup, identificationMark, photo,
				createdBy, createdDate, lastModifiedBy, lastModifiedDate, otpReference, tenantId);

		assertNotNull(result);
		assertEquals(new Long(1L), result.getId());
		assertEquals("", result.getUuid());
		assertEquals("", result.getUserName());
		assertEquals("", result.getPassword());
		assertEquals("", result.getSalutation());
		assertEquals("", result.getName());
		assertEquals("", result.getGender());
		assertEquals("", result.getMobileNumber());
		assertEquals("", result.getEmailId());
		assertEquals("", result.getAltContactNumber());
		assertEquals("", result.getPan());
		assertEquals("", result.getAadhaarNumber());
		assertEquals("", result.getPermanentAddress());
		assertEquals("", result.getPermanentCity());
		assertEquals("", result.getPermanentPinCode());
		assertEquals("", result.getCorrespondenceCity());
		assertEquals("", result.getCorrespondencePinCode());
		assertEquals("", result.getCorrespondenceAddress());
		assertEquals(Boolean.TRUE, result.getActive());
		assertEquals(new Long(1L), result.getDob());
		assertEquals(new Long(1L), result.getPwdExpiryDate());
		assertEquals("", result.getLocale());
		assertEquals("", result.getType());
		assertEquals("", result.getSignature());
		assertEquals(Boolean.TRUE, result.getAccountLocked());
		assertEquals(null, result.getRoles());
		assertEquals("", result.getFatherOrHusbandName());
		assertEquals("", result.getBloodGroup());
		assertEquals("", result.getIdentificationMark());
		assertEquals("", result.getPhoto());
		assertEquals("", result.getCreatedBy());
		assertEquals(new Long(1L), result.getCreatedDate());
		assertEquals("", result.getLastModifiedBy());
		assertEquals(new Long(1L), result.getLastModifiedDate());
		assertEquals("", result.getOtpReference());
		assertEquals("", result.getTenantId());
	}

	
	@Test
	public void testBuilder_1() throws Exception {

		User result = new User();

		assertNotNull(result);
		assertEquals(
				"User(id=null, uuid=null, userName=null, password=null, salutation=null, name=null, gender=null, mobileNumber=null, emailId=null, altContactNumber=null, pan=null, aadhaarNumber=null, permanentAddress=null, permanentCity=null, permanentPinCode=null, correspondenceCity=null, correspondencePinCode=null, correspondenceAddress=null, active=null, dob=null, pwdExpiryDate=null, locale=null, type=null, signature=null, accountLocked=null, roles=null, fatherOrHusbandName=null, bloodGroup=null, identificationMark=null, photo=null, createdBy=null, createdDate=null, lastModifiedBy=null, lastModifiedDate=null, otpReference=null, tenantId=null)",
				result.toString());
	}
	
	@Test
	public void testToString() {
		user.toString();
	}
	
	@Test
	public void testUser() {
		user.toString();
	}

	@Test
	public void testEqualsObject() {
		User user1=new User();
		User user2=new User();
		Assert.assertEquals(user1,user2);
		Assert.assertEquals(Boolean.valueOf(true), Boolean.valueOf(user.equals(user)));
	}
	
	@Test
	public void testHashCode() {
		int hash = user.hashCode();
		Assert.assertEquals(hash, user.hashCode());
	}
	
	@Test
	public void testGetId_1() throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",
				new Boolean(true), new Long(1L), new Long(1L), "", "", "", new Boolean(true), null, "","","","","", new Long(1L),
				"",new Long(1L), "","");

		Long result = fixture.getId();

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
	public void testGetUuid_1() throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",
				new Boolean(true), new Long(1L), new Long(1L), "", "", "", new Boolean(true), null, "","","","","", new Long(1L),
				"",new Long(1L), "","");

		String result = fixture.getUuid();
		assertEquals("", result);
	}
	
	@Test
	public void testGetUsername_1() throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",
				new Boolean(true), new Long(1L), new Long(1L), "", "", "", new Boolean(true), null, "","","","","", new Long(1L),
				"",new Long(1L), "","");

		String result = fixture.getUserName();

		assertEquals("", result);
	}
	
	@Test
	public void testGetPassword_1() throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",
				new Boolean(true), new Long(1L), new Long(1L), "", "", "", new Boolean(true), null, "","","","","", new Long(1L),
				"",new Long(1L), "","");

		String result = fixture.getPassword();
		assertEquals("", result);
	}
	
	@Test
	public void testGetAadhaarNumber_1() throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",
				new Boolean(true), new Long(1L), new Long(1L), "", "", "", new Boolean(true), null, "","","","","", new Long(1L),
				"",new Long(1L), "","");

		String result = fixture.getAadhaarNumber();

		assertEquals("", result);
	}

	@Test
	public void testGetAccountLocked_1() throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",
				new Boolean(true), new Long(1L), new Long(1L), "", "", "", new Boolean(true), null, "","","","","", new Long(1L),
				"",new Long(1L), "","");

		Boolean result = fixture.getAccountLocked();

		assertNotNull(result);
		assertEquals("true", result.toString());
		assertEquals(true, result.booleanValue());
	}

	@Test
	public void testGetActive_1() throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",
				new Boolean(true), new Long(1L), new Long(1L), "", "", "", new Boolean(true), null, "","","","","", new Long(1L),
				"",new Long(1L), "","");

		Boolean result = fixture.getActive();

		assertNotNull(result);
		assertEquals("true", result.toString());
		assertEquals(true, result.booleanValue());
	}

	@Test
	public void testGetAltContactNumber_1() throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",
				new Boolean(true), new Long(1L), new Long(1L), "", "", "", new Boolean(true), null, "","","","","", new Long(1L),
				"",new Long(1L), "","");

		String result = fixture.getAltContactNumber();

		assertEquals("", result);
	}

	@Test
	public void testGetCreatedBy_1() throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",
				new Boolean(true), new Long(1L), new Long(1L), "", "", "", new Boolean(true), null, "","","","","", new Long(1L),
				"",new Long(1L), "","");

		String result = fixture.getCreatedBy();

		assertNotNull(result);
		assertEquals("", result);
	}

	@Test
	public void testGetEmailId_1() throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",
				new Boolean(true), new Long(1L), new Long(1L), "", "", "", new Boolean(true), null, "","","","","", new Long(1L),
				"",new Long(1L), "","");

		String result = fixture.getEmailId();
		assertEquals("", result);
	}

	@Test
	public void testGetGender_1() throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",
				new Boolean(true), new Long(1L), new Long(1L), "", "", "", new Boolean(true), null, "","","","","", new Long(1L),
				"",new Long(1L), "","");

		String result = fixture.getGender();
		assertEquals("", result);
	}

	@Test
	public void testGetIdentificationMark_1() throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",
				new Boolean(true), new Long(1L), new Long(1L), "", "", "", new Boolean(true), null, "","","","","", new Long(1L),
				"",new Long(1L), "","");

		String result = fixture.getIdentificationMark();
		assertEquals("", result);
	}

	@Test
	public void testGetLastModifiedBy_1() throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",
				new Boolean(true), new Long(1L), new Long(1L), "", "", "", new Boolean(true), null, "","","","","", new Long(1L),
				"",new Long(1L), "","");

		String result = fixture.getLastModifiedBy();

		assertNotNull(result);
		assertEquals("", result);
	}

	@Test
	public void testGetLocale_1() throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",
				new Boolean(true), new Long(1L), new Long(1L), "", "", "", new Boolean(true), null, "","","","","", new Long(1L),
				"",new Long(1L), "","");
		String result = fixture.getLocale();
		assertEquals("", result);
	}

	@Test
	public void testGetMobileNumber_1() throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",
				new Boolean(true), new Long(1L), new Long(1L), "", "", "", new Boolean(true), null, "","","","","", new Long(1L),
				"",new Long(1L), "","");

		String result = fixture.getMobileNumber();
		assertEquals("", result);
	}

	@Test
	public void testGetName_1() throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",
				new Boolean(true), new Long(1L), new Long(1L), "", "", "", new Boolean(true), null, "","","","","", new Long(1L),
				"",new Long(1L), "","");

		String result = fixture.getName();
		assertEquals("", result);
	}

	@Test
	public void testGetOtpReference_1() throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",
				new Boolean(true), new Long(1L), new Long(1L), "", "", "", new Boolean(true), null, "","","","","", new Long(1L),
				"",new Long(1L), "","");
		String result = fixture.getOtpReference();
		assertEquals("", result);
	}

	@Test
	public void testGetPan_1() throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",
				new Boolean(true), new Long(1L), new Long(1L), "", "", "", new Boolean(true), null, "","","","","", new Long(1L),
				"",new Long(1L), "","");

		String result = fixture.getPan();
		assertEquals("", result);
	}

	@Test
	public void testGetPhoto_1() throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",
				new Boolean(true), new Long(1L), new Long(1L), "", "", "", new Boolean(true), null, "","","","","", new Long(1L),
				"",new Long(1L), "","");
		
		String result = fixture.getPhoto();
		assertEquals("", result);
	}

	@Test
	public void testGetSalutation_1() throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",
				new Boolean(true), new Long(1L), new Long(1L), "", "", "", new Boolean(true), null, "","","","","", new Long(1L),
				"",new Long(1L), "","");

		String result = fixture.getSalutation();
		assertEquals("", result);
	}

	@Test
	public void testGetSignature_1() throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",
				new Boolean(true), new Long(1L), new Long(1L), "", "", "", new Boolean(true), null, "","","","","", new Long(1L),
				"",new Long(1L), "","");

		String result = fixture.getSignature();
		assertEquals("", result);
	}

	@Test
	public void testGetTenantId_1() throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",
				new Boolean(true), new Long(1L), new Long(1L), "", "", "", new Boolean(true), null, "","","","","", new Long(1L),
				"",new Long(1L), "","");

		String result = fixture.getTenantId();
		assertEquals("", result);
	}

	@Test
	public void testGetPermanentAddress_1() throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",
				new Boolean(true), new Long(1L), new Long(1L), "", "", "", new Boolean(true), null, "","","","","", new Long(1L),
				"",new Long(1L), "","");

		String result = fixture.getPermanentAddress();
		assertEquals("", result);
	}
	
	@Test
	public void testGetPermanentCity_1() throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",
				new Boolean(true), new Long(1L), new Long(1L), "", "", "", new Boolean(true), null, "","","","","", new Long(1L),
				"",new Long(1L), "","");

		String result = fixture.getPermanentCity();
		assertEquals("", result);
	}
	
	@Test
	public void testGetPermanentPinCode_1() throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",
				new Boolean(true), new Long(1L), new Long(1L), "", "", "", new Boolean(true), null, "","","","","", new Long(1L),
				"",new Long(1L), "","");

		String result = fixture.getPermanentPinCode();
		assertEquals("", result);
	}

	@Test
	public void testGetCorrespondenceAddress_1() throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",
				new Boolean(true), new Long(1L), new Long(1L), "", "", "", new Boolean(true), null, "","","","","", new Long(1L),
				"",new Long(1L), "","");

		String result = fixture.getCorrespondenceAddress();
		assertEquals("", result);
	}
	
	@Test
	public void testGetCorrespondenceCity_1() throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",
				new Boolean(true), new Long(1L), new Long(1L), "", "", "", new Boolean(true), null, "","","","","", new Long(1L),
				"",new Long(1L), "","");

		String result = fixture.getCorrespondenceCity();
		assertEquals("", result);
	}
	
	@Test
	public void testGetCorrespondencePinCode_1() throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",
				new Boolean(true), new Long(1L), new Long(1L), "", "", "", new Boolean(true), null, "","","","","", new Long(1L),
				"",new Long(1L), "","");

		String result = fixture.getCorrespondencePinCode();
		assertEquals("", result);
	}

	@Test
	public void testSetAadhaarNumber_1() throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",
				new Boolean(true), new Long(1L), new Long(1L), "", "", "", new Boolean(true), null, "","","","","", new Long(1L),
				"",new Long(1L), "","");
		
		String aadhaarNumber = "";
		fixture.setAadhaarNumber(aadhaarNumber);

	}

	@Test
	public void testSetAccountLocked_1() throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",
				new Boolean(true), new Long(1L), new Long(1L), "", "", "", new Boolean(true), null, "","","","","", new Long(1L),
				"",new Long(1L), "","");
		
		Boolean accountLocked = new Boolean(true);
		fixture.setAccountLocked(accountLocked);

	}

	@Test
	public void testSetActive_1() throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",
				new Boolean(true), new Long(1L), new Long(1L), "", "", "", new Boolean(true), null, "","","","","", new Long(1L),
				"",new Long(1L), "","");
		boolean isActive = true;
		fixture.setActive(isActive);

	}

	@Test
	public void testSetAltContactNumber_1() throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",
				new Boolean(true), new Long(1L), new Long(1L), "", "", "", new Boolean(true), null, "","","","","", new Long(1L),
				"",new Long(1L), "","");
		
		String altContactNumber = "";
		fixture.setAltContactNumber(altContactNumber);

	}

	@Test
	public void testSetCreatedBy_1() throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",
				new Boolean(true), new Long(1L), new Long(1L), "", "", "", new Boolean(true), null, "","","","","", new Long(1L),
				"",new Long(1L), "","");
		String createdBy = "";
		fixture.setCreatedBy(createdBy);

	}

	@Test
	public void testSetEmailId_1() throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",
				new Boolean(true), new Long(1L), new Long(1L), "", "", "", new Boolean(true), null, "","","","","", new Long(1L),
				"",new Long(1L), "","");
		
		String emailId = "";
		fixture.setEmailId(emailId);

	}

	@Test
	public void testSetGender_1() throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",
				new Boolean(true), new Long(1L), new Long(1L), "", "", "", new Boolean(true), null, "","","","","", new Long(1L),
				"",new Long(1L), "","");
		String gender = "";
		fixture.setGender(gender);

	}

	@Test
	public void testSetId_1() throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",
				new Boolean(true), new Long(1L), new Long(1L), "", "", "", new Boolean(true), null, "","","","","", new Long(1L),
				"",new Long(1L), "","");
		Long id = new Long(1L);
		fixture.setId(id);

	}

	@Test
	public void testSetIdentificationMark_1() throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",
				new Boolean(true), new Long(1L), new Long(1L), "", "", "", new Boolean(true), null, "","","","","", new Long(1L),
				"",new Long(1L), "","");
		String identificationMark = "";
		fixture.setIdentificationMark(identificationMark);

	}

	@Test
	public void testSetLastModifiedBy_1() throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",
				new Boolean(true), new Long(1L), new Long(1L), "", "", "", new Boolean(true), null, "","","","","", new Long(1L),
				"",new Long(1L), "","");
		String lastModifiedBy = "";
		fixture.setLastModifiedBy(lastModifiedBy);

	}

	@Test
	public void testSetLocale_1() throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",
				new Boolean(true), new Long(1L), new Long(1L), "", "", "", new Boolean(true), null, "","","","","", new Long(1L),
				"",new Long(1L), "","");
		String locale = "";
		fixture.setLocale(locale);

	}

	@Test
	public void testSetMobileNumber_1() throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",
				new Boolean(true), new Long(1L), new Long(1L), "", "", "", new Boolean(true), null, "","","","","", new Long(1L),
				"",new Long(1L), "","");
		String mobileNumber = "";
		fixture.setMobileNumber(mobileNumber);

	}

	@Test
	public void testSetName_1() throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",
				new Boolean(true), new Long(1L), new Long(1L), "", "", "", new Boolean(true), null, "","","","","", new Long(1L),
				"",new Long(1L), "","");
		String name = "";
		fixture.setName(name);

	}

	@Test
	public void testSetOtpReference_1() throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",
				new Boolean(true), new Long(1L), new Long(1L), "", "", "", new Boolean(true), null, "","","","","", new Long(1L),
				"",new Long(1L), "","");
		String otpReference = "";
		fixture.setOtpReference(otpReference);

	}

	@Test
	public void testSetPan_1() throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",
				new Boolean(true), new Long(1L), new Long(1L), "", "", "", new Boolean(true), null, "","","","","", new Long(1L),
				"",new Long(1L), "","");
		String pan = "";
		fixture.setPan(pan);

	}

	@Test
	public void testSetPassword_1() throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",
				new Boolean(true), new Long(1L), new Long(1L), "", "", "", new Boolean(true), null, "","","","","", new Long(1L),
				"",new Long(1L), "","");
		String password = "";
		fixture.setPassword(password);

	}

	@Test
	public void testSetPhoto_1() throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",
				new Boolean(true), new Long(1L), new Long(1L), "", "", "", new Boolean(true), null, "","","","","", new Long(1L),
				"",new Long(1L), "","");
		String photo = "";

		fixture.setPhoto(photo);

	}

	@Test
	public void testSetSalutation_1() throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",
				new Boolean(true), new Long(1L), new Long(1L), "", "", "", new Boolean(true), null, "","","","","", new Long(1L),
				"",new Long(1L), "","");
		String salutation = "";
		fixture.setSalutation(salutation);

	}

	@Test
	public void testSetSignature_1() throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",
				new Boolean(true), new Long(1L), new Long(1L), "", "", "", new Boolean(true), null, "","","","","", new Long(1L),
				"",new Long(1L), "","");
		String signature = "";
		fixture.setSignature(signature);

	}

	@Test
	public void testSetTenantId_1() throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",
				new Boolean(true), new Long(1L), new Long(1L), "", "", "", new Boolean(true), null, "","","","","", new Long(1L),
				"",new Long(1L), "","");
		String tenantId = "";
		fixture.setTenantId(tenantId);

	}

	@Test
	public void testSetUserName_1() throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",
				new Boolean(true), new Long(1L), new Long(1L), "", "", "", new Boolean(true), null, "","","","","", new Long(1L),
				"",new Long(1L), "","");
		String username = "";
		fixture.setUserName(username);

	}

	@Test
	public void testSetUuid_1() throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",
				new Boolean(true), new Long(1L), new Long(1L), "", "", "", new Boolean(true), null, "","","","","", new Long(1L),
				"",new Long(1L), "","");
		String uuid = "";
		fixture.setUuid(uuid);

	}
	
	@Test
	public void testSetCorrespondenceAddress_1() throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",
				new Boolean(true), new Long(1L), new Long(1L), "", "", "", new Boolean(true), null, "","","","","", new Long(1L),
				"",new Long(1L), "","");
		String correspondenceAddress = "";
		fixture.setCorrespondenceAddress(correspondenceAddress);

	}
	
	@Test
	public void testSetCorrespondenceCity1() throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",
				new Boolean(true), new Long(1L), new Long(1L), "", "", "", new Boolean(true), null, "","","","","", new Long(1L),
				"",new Long(1L), "","");
		String correspondenceCity = "";
		fixture.setCorrespondenceCity(correspondenceCity);

	}
	
	@Test
	public void testSetCorrespondencePinCode() throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",
				new Boolean(true), new Long(1L), new Long(1L), "", "", "", new Boolean(true), null, "","","","","", new Long(1L),
				"",new Long(1L), "","");
		String correspondencePinCode = "";
		fixture.setCorrespondencePinCode(correspondencePinCode);
	}
	
	@Test
	public void testSetCreatedDate() throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",
				new Boolean(true), new Long(1L), new Long(1L), "", "", "", new Boolean(true), null, "","","","","", new Long(1L),
				"",new Long(1L), "","");
		Long createdDate = new Long(0);
		fixture.setCreatedDate(createdDate);
	}
	
	@Test
	public void testSetDob() throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",
				new Boolean(true), new Long(1L), new Long(1L), "", "", "", new Boolean(true), null, "","","","","", new Long(1L),
				"",new Long(1L), "","");
		Long dob = new Long(0);
		fixture.setDob(dob);
	}
	
	@Test
	public void testSetFatherOrHusbandName() throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",
				new Boolean(true), new Long(1L), new Long(1L), "", "", "", new Boolean(true), null, "","","","","", new Long(1L),
				"",new Long(1L), "","");
		String fatherOrHusbandName="";
		fixture.setFatherOrHusbandName(fatherOrHusbandName);
	}
	
	@Test
	public void testSetLastModifiedDate() throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",
				new Boolean(true), new Long(1L), new Long(1L), "", "", "", new Boolean(true), null, "","","","","", new Long(1L),
				"",new Long(1L), "","");
		Long lastModifiedDate = new Long(0);
		fixture.setLastModifiedDate(lastModifiedDate);
	}
	
	@Test
	public void testSetRoles() throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",
				new Boolean(true), new Long(1L), new Long(1L), "", "", "", new Boolean(true), null, "","","","","", new Long(1L),
				"",new Long(1L), "","");
		List<Role> roles = null;
		fixture.setRoles(roles);
	}
	
	@Test
	public void testAddRolesItem() throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",
				new Boolean(true), new Long(1L), new Long(1L), "", "", "", new Boolean(true), null, "","","","","", new Long(1L),
				"",new Long(1L), "","");
		Role rolesItem = null;
		fixture.addRolesItem(rolesItem);
	}
	
	@Test
	public void testSetPermanentAddress() throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",
				new Boolean(true), new Long(1L), new Long(1L), "", "", "", new Boolean(true), null, "","","","","", new Long(1L),
				"",new Long(1L), "","");
		String permanentAddress="";
		fixture.setPermanentAddress(permanentAddress);
	}
	
	@Test
	public void testSetPermanentCity() throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",
				new Boolean(true), new Long(1L), new Long(1L), "", "", "", new Boolean(true), null, "","","","","", new Long(1L),
				"",new Long(1L), "","");
		String permanentCity="";
		fixture.setPermanentCity(permanentCity);
	}

	@Test
	public void testSetPermanentPinCode() throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",
				new Boolean(true), new Long(1L), new Long(1L), "", "", "", new Boolean(true), null, "","","","","", new Long(1L),
				"",new Long(1L), "","");
		String permanentPinCode="";
		fixture.setPermanentPinCode(permanentPinCode);
	}
	
	@Test
	public void testSetPwdExpiryDate() throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",
				new Boolean(true), new Long(1L), new Long(1L), "", "", "", new Boolean(true), null, "","","","","", new Long(1L),
				"",new Long(1L), "","");
		Long pwdExpiryDate=new Long(0);
		fixture.setPwdExpiryDate(pwdExpiryDate);
	}
	
	@Test
	public void testSetType() throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",
				new Boolean(true), new Long(1L), new Long(1L), "", "", "", new Boolean(true), null, "","","","","", new Long(1L),
				"",new Long(1L), "","");
		String type="";
		fixture.setType(type);
	}
	
	@Test
	public void testSetBloodGroup() throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",
				new Boolean(true), new Long(1L), new Long(1L), "", "", "", new Boolean(true), null, "","","","","", new Long(1L),
				"",new Long(1L), "","");
		String bloodGroup="";
		fixture.setBloodGroup(bloodGroup);
	}
}