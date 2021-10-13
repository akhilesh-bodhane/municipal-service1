package org.egov.prscp.web.models;

import java.util.List;
import org.easymock.EasyMock;
import org.egov.common.contract.request.Role;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * The class <code>UserTest</code> contains tests for the class <code>{@link User}</code>.
 *
 * @generatedBy CodePro at 25/5/20 3:50 PM
 * @author Aniket.Marathe
 * @version $Revision: 1.0 $
 */
public class UserTest {
	/**
	 * Run the User() constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:50 PM
	 */
	@Test
	public void testUser_1()
		throws Exception {

		User result = new User();

		// add additional test code here
		assertNotNull(result);
		assertEquals("User(id=null, uuid=null, userName=null, password=null, salutation=null, name=null, gender=null, mobileNumber=null, emailId=null, altContactNumber=null, pan=null, aadhaarNumber=null, permanentAddress=null, permanentCity=null, permanentPincode=null, correspondenceCity=null, correspondencePincode=null, correspondenceAddress=null, active=null, dob=null, pwdExpiryDate=null, locale=null, type=null, signature=null, accountLocked=null, roles=null, fatherOrHusbandName=null, bloodGroup=null, identificationMark=null, photo=null, createdBy=null, createdDate=null, lastModifiedBy=null, lastModifiedDate=null, otpReference=null, tenantId=null)", result.toString());
		assertEquals(null, result.getName());
		assertEquals(null, result.getId());
		assertEquals(null, result.getType());
		assertEquals(null, result.getSignature());
		assertEquals(null, result.getPassword());
		assertEquals(null, result.getLocale());
		assertEquals(null, result.getActive());
		assertEquals(null, result.getRoles());
		assertEquals(null, result.getUserName());
		assertEquals(null, result.getLastModifiedDate());
		assertEquals(null, result.getLastModifiedBy());
		assertEquals(null, result.getPermanentPincode());
		assertEquals(null, result.getPermanentAddress());
		assertEquals(null, result.getCorrespondenceCity());
		assertEquals(null, result.getCorrespondenceAddress());
		assertEquals(null, result.getCorrespondencePincode());
		assertEquals(null, result.getIdentificationMark());
		assertEquals(null, result.getFatherOrHusbandName());
		assertEquals(null, result.getAltContactNumber());
		assertEquals(null, result.getSalutation());
		assertEquals(null, result.getGender());
		assertEquals(null, result.getPan());
		assertEquals(null, result.getDob());
		assertEquals(null, result.getBloodGroup());
		assertEquals(null, result.getOtpReference());
		assertEquals(null, result.getPwdExpiryDate());
		assertEquals(null, result.getAccountLocked());
		assertEquals(null, result.getCreatedBy());
		assertEquals(null, result.getPermanentCity());
		assertEquals(null, result.getAadhaarNumber());
		assertEquals(null, result.getCreatedDate());
		assertEquals(null, result.getPhoto());
		assertEquals(null, result.getMobileNumber());
		assertEquals(null, result.getTenantId());
		assertEquals(null, result.getEmailId());
		assertEquals(null, result.getUuid());
	}

	/**
	 * Run the User(Long,String,String,String,String,String,String,String,String,String,String,String,String,String,String,String,String,String,Boolean,Long,Long,String,String,String,Boolean,List<Role>,String,String,String,String,String,Long,String,Long,String,String) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:50 PM
	 */
	@Test
	public void testUser_2()
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
		// add mock object expectations here

		EasyMock.replay(roles);

		User result = new User(id, uuid, userName, password, salutation, name, gender, mobileNumber, emailId, altContactNumber, pan, aadhaarNumber, permanentAddress, permanentCity, permanentPincode, correspondenceCity, correspondencePincode, correspondenceAddress, active, dob, pwdExpiryDate, locale, type, signature, accountLocked, roles, fatherOrHusbandName, bloodGroup, identificationMark, photo, createdBy, createdDate, lastModifiedBy, lastModifiedDate, otpReference, tenantId);

		// add additional test code here
		EasyMock.verify(roles);
		assertNotNull(result);
		assertEquals("User(id=1, uuid=, userName=, password=, salutation=, name=, gender=, mobileNumber=, emailId=, altContactNumber=, pan=, aadhaarNumber=, permanentAddress=, permanentCity=, permanentPincode=, correspondenceCity=, correspondencePincode=, correspondenceAddress=, active=true, dob=1, pwdExpiryDate=1, locale=, type=, signature=, accountLocked=true, roles=EasyMock for interface java.util.List, fatherOrHusbandName=, bloodGroup=, identificationMark=, photo=, createdBy=, createdDate=1, lastModifiedBy=, lastModifiedDate=1, otpReference=, tenantId=)", result.toString());
		assertEquals("", result.getName());
		assertEquals(new Long(1L), result.getId());
		assertEquals("", result.getType());
		assertEquals("", result.getSignature());
		assertEquals("", result.getPassword());
		assertEquals("", result.getLocale());
		assertEquals(Boolean.TRUE, result.getActive());
		assertEquals("", result.getUserName());
		assertEquals(new Long(1L), result.getLastModifiedDate());
		assertEquals("", result.getLastModifiedBy());
		assertEquals("", result.getPermanentPincode());
		assertEquals("", result.getPermanentAddress());
		assertEquals("", result.getCorrespondenceCity());
		assertEquals("", result.getCorrespondenceAddress());
		assertEquals("", result.getCorrespondencePincode());
		assertEquals("", result.getIdentificationMark());
		assertEquals("", result.getFatherOrHusbandName());
		assertEquals("", result.getAltContactNumber());
		assertEquals("", result.getSalutation());
		assertEquals("", result.getGender());
		assertEquals("", result.getPan());
		assertEquals(new Long(1L), result.getDob());
		assertEquals("", result.getBloodGroup());
		assertEquals("", result.getOtpReference());
		assertEquals(new Long(1L), result.getPwdExpiryDate());
		assertEquals(Boolean.TRUE, result.getAccountLocked());
		assertEquals("", result.getCreatedBy());
		assertEquals("", result.getPermanentCity());
		assertEquals("", result.getAadhaarNumber());
		assertEquals(new Long(1L), result.getCreatedDate());
		assertEquals("", result.getPhoto());
		assertEquals("", result.getMobileNumber());
		assertEquals("", result.getTenantId());
		assertEquals("", result.getEmailId());
		assertEquals("", result.getUuid());
	}

	/**
	 * Run the User addRolesItem(Role) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:50 PM
	 */
	@Test
	public void testAddRolesItem_1()
		throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", new Boolean(true), new Long(1L), new Long(1L), "", "", "", new Boolean(true), (List<Role>) null, "", "", "", "", "", new Long(1L), "", new Long(1L), "", "");
		Role rolesItem = new Role();

		User result = fixture.addRolesItem(rolesItem);

		// add additional test code here
		assertNotNull(result);
		assertEquals("User(id=1, uuid=, userName=, password=, salutation=, name=, gender=, mobileNumber=, emailId=, altContactNumber=, pan=, aadhaarNumber=, permanentAddress=, permanentCity=, permanentPincode=, correspondenceCity=, correspondencePincode=, correspondenceAddress=, active=true, dob=1, pwdExpiryDate=1, locale=, type=, signature=, accountLocked=true, roles=[org.egov.common.contract.request.Role@141f979], fatherOrHusbandName=, bloodGroup=, identificationMark=, photo=, createdBy=, createdDate=1, lastModifiedBy=, lastModifiedDate=1, otpReference=, tenantId=)", result.toString());
		assertEquals("", result.getName());
		assertEquals(new Long(1L), result.getId());
		assertEquals("", result.getType());
		assertEquals("", result.getSignature());
		assertEquals("", result.getPassword());
		assertEquals("", result.getLocale());
		assertEquals(Boolean.TRUE, result.getActive());
		assertEquals("", result.getUserName());
		assertEquals(new Long(1L), result.getLastModifiedDate());
		assertEquals("", result.getLastModifiedBy());
		assertEquals("", result.getPermanentPincode());
		assertEquals("", result.getPermanentAddress());
		assertEquals("", result.getCorrespondenceCity());
		assertEquals("", result.getCorrespondenceAddress());
		assertEquals("", result.getCorrespondencePincode());
		assertEquals("", result.getIdentificationMark());
		assertEquals("", result.getFatherOrHusbandName());
		assertEquals("", result.getAltContactNumber());
		assertEquals("", result.getSalutation());
		assertEquals("", result.getGender());
		assertEquals("", result.getPan());
		assertEquals(new Long(1L), result.getDob());
		assertEquals("", result.getBloodGroup());
		assertEquals("", result.getOtpReference());
		assertEquals(new Long(1L), result.getPwdExpiryDate());
		assertEquals(Boolean.TRUE, result.getAccountLocked());
		assertEquals("", result.getCreatedBy());
		assertEquals("", result.getPermanentCity());
		assertEquals("", result.getAadhaarNumber());
		assertEquals(new Long(1L), result.getCreatedDate());
		assertEquals("", result.getPhoto());
		assertEquals("", result.getMobileNumber());
		assertEquals("", result.getTenantId());
		assertEquals("", result.getEmailId());
		assertEquals("", result.getUuid());
	}

	/**
	 * Run the User addRolesItem(Role) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:50 PM
	 */
	@Test
	public void testAddRolesItem_2()
		throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", new Boolean(true), new Long(1L), new Long(1L), "", "", "", new Boolean(true), EasyMock.createNiceMock(List.class), "", "", "", "", "", new Long(1L), "", new Long(1L), "", "");
		Role rolesItem = new Role();

		User result = fixture.addRolesItem(rolesItem);

		// add additional test code here
		assertNotNull(result);
		assertEquals("User(id=1, uuid=, userName=, password=, salutation=, name=, gender=, mobileNumber=, emailId=, altContactNumber=, pan=, aadhaarNumber=, permanentAddress=, permanentCity=, permanentPincode=, correspondenceCity=, correspondencePincode=, correspondenceAddress=, active=true, dob=1, pwdExpiryDate=1, locale=, type=, signature=, accountLocked=true, roles=EasyMock for interface java.util.List, fatherOrHusbandName=, bloodGroup=, identificationMark=, photo=, createdBy=, createdDate=1, lastModifiedBy=, lastModifiedDate=1, otpReference=, tenantId=)", result.toString());
		assertEquals("", result.getName());
		assertEquals(new Long(1L), result.getId());
		assertEquals("", result.getType());
		assertEquals("", result.getSignature());
		assertEquals("", result.getPassword());
		assertEquals("", result.getLocale());
		assertEquals(Boolean.TRUE, result.getActive());
		assertEquals("", result.getUserName());
		assertEquals(new Long(1L), result.getLastModifiedDate());
		assertEquals("", result.getLastModifiedBy());
		assertEquals("", result.getPermanentPincode());
		assertEquals("", result.getPermanentAddress());
		assertEquals("", result.getCorrespondenceCity());
		assertEquals("", result.getCorrespondenceAddress());
		assertEquals("", result.getCorrespondencePincode());
		assertEquals("", result.getIdentificationMark());
		assertEquals("", result.getFatherOrHusbandName());
		assertEquals("", result.getAltContactNumber());
		assertEquals("", result.getSalutation());
		assertEquals("", result.getGender());
		assertEquals("", result.getPan());
		assertEquals(new Long(1L), result.getDob());
		assertEquals("", result.getBloodGroup());
		assertEquals("", result.getOtpReference());
		assertEquals(new Long(1L), result.getPwdExpiryDate());
		assertEquals(Boolean.TRUE, result.getAccountLocked());
		assertEquals("", result.getCreatedBy());
		assertEquals("", result.getPermanentCity());
		assertEquals("", result.getAadhaarNumber());
		assertEquals(new Long(1L), result.getCreatedDate());
		assertEquals("", result.getPhoto());
		assertEquals("", result.getMobileNumber());
		assertEquals("", result.getTenantId());
		assertEquals("", result.getEmailId());
		assertEquals("", result.getUuid());
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:50 PM
	 */
	@Test
	public void testEquals_1()
		throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", new Boolean(true), new Long(1L), new Long(1L), "", "", "", new Boolean(true), EasyMock.createNiceMock(List.class), "", "", "", "", "", new Long(1L), "", new Long(1L), "", "");
		Object o = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", new Boolean(true), new Long(1L), new Long(1L), "", "", "", new Boolean(true), EasyMock.createNiceMock(List.class), "", "", "", "", "", new Long(1L), "", new Long(1L), "", "");

		boolean result = fixture.equals(o);

		// add additional test code here
		assertEquals(true, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:50 PM
	 */
	@Test
	public void testEquals_2()
		throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", new Boolean(true), new Long(1L), new Long(1L), "", "", "", new Boolean(true), EasyMock.createNiceMock(List.class), "", "", "", "", "", new Long(1L), "", new Long(1L), "", "");
		Object o = null;

		boolean result = fixture.equals(o);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:50 PM
	 */
	@Test
	public void testEquals_3()
		throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", new Boolean(true), new Long(1L), new Long(1L), "", "", "", new Boolean(true), EasyMock.createNiceMock(List.class), "", "", "", "", "", new Long(1L), "", new Long(1L), "", "");
		Object o = new Object();

		boolean result = fixture.equals(o);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:50 PM
	 */
	@Test
	public void testEquals_4()
		throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", new Boolean(true), new Long(1L), new Long(1L), "", "", "", new Boolean(true), EasyMock.createNiceMock(List.class), "", "", "", "", "", new Long(1L), "", new Long(1L), "", "");
		Object o = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", new Boolean(true), new Long(1L), new Long(1L), "", "", "", new Boolean(true), EasyMock.createNiceMock(List.class), "", "", "", "", "", new Long(1L), "", new Long(1L), "", "");

		boolean result = fixture.equals(o);

		// add additional test code here
		assertEquals(true, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:50 PM
	 */
	@Test
	public void testEquals_5()
		throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", new Boolean(true), new Long(1L), new Long(1L), "", "", "", new Boolean(true), EasyMock.createNiceMock(List.class), "", "", "", "", "", new Long(1L), "", new Long(1L), "", "");
		Object o = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", new Boolean(true), new Long(1L), new Long(1L), "", "", "", new Boolean(true), EasyMock.createNiceMock(List.class), "", "", "", "", "", new Long(1L), "", new Long(1L), "", "");

		boolean result = fixture.equals(o);

		// add additional test code here
		assertEquals(true, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:50 PM
	 */
	@Test
	public void testEquals_6()
		throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", new Boolean(true), new Long(1L), new Long(1L), "", "", "", new Boolean(true), EasyMock.createNiceMock(List.class), "", "", "", "", "", new Long(1L), "", new Long(1L), "", "");
		Object o = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", new Boolean(true), new Long(1L), new Long(1L), "", "", "", new Boolean(true), EasyMock.createNiceMock(List.class), "", "", "", "", "", new Long(1L), "", new Long(1L), "", "");

		boolean result = fixture.equals(o);

		// add additional test code here
		assertEquals(true, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:50 PM
	 */
	@Test
	public void testEquals_7()
		throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", new Boolean(true), new Long(1L), new Long(1L), "", "", "", new Boolean(true), EasyMock.createNiceMock(List.class), "", "", "", "", "", new Long(1L), "", new Long(1L), "", "");
		Object o = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", new Boolean(true), new Long(1L), new Long(1L), "", "", "", new Boolean(true), EasyMock.createNiceMock(List.class), "", "", "", "", "", new Long(1L), "", new Long(1L), "", "");

		boolean result = fixture.equals(o);

		// add additional test code here
		assertEquals(true, result);
	}

	/**
	 * Run the String getAadhaarNumber() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:50 PM
	 */
	@Test
	public void testGetAadhaarNumber_1()
		throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", new Boolean(true), new Long(1L), new Long(1L), "", "", "", new Boolean(true), EasyMock.createNiceMock(List.class), "", "", "", "", "", new Long(1L), "", new Long(1L), "", "");

		String result = fixture.getAadhaarNumber();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the Boolean getAccountLocked() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:50 PM
	 */
	@Test
	public void testGetAccountLocked_1()
		throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", new Boolean(true), new Long(1L), new Long(1L), "", "", "", new Boolean(true), EasyMock.createNiceMock(List.class), "", "", "", "", "", new Long(1L), "", new Long(1L), "", "");

		Boolean result = fixture.getAccountLocked();

		// add additional test code here
		assertNotNull(result);
		assertEquals("true", result.toString());
		assertEquals(true, result.booleanValue());
	}

	/**
	 * Run the Boolean getActive() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:50 PM
	 */
	@Test
	public void testGetActive_1()
		throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", new Boolean(true), new Long(1L), new Long(1L), "", "", "", new Boolean(true), EasyMock.createNiceMock(List.class), "", "", "", "", "", new Long(1L), "", new Long(1L), "", "");

		Boolean result = fixture.getActive();

		// add additional test code here
		assertNotNull(result);
		assertEquals("true", result.toString());
		assertEquals(true, result.booleanValue());
	}

	/**
	 * Run the String getAltContactNumber() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:50 PM
	 */
	@Test
	public void testGetAltContactNumber_1()
		throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", new Boolean(true), new Long(1L), new Long(1L), "", "", "", new Boolean(true), EasyMock.createNiceMock(List.class), "", "", "", "", "", new Long(1L), "", new Long(1L), "", "");

		String result = fixture.getAltContactNumber();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the String getBloodGroup() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:50 PM
	 */
	@Test
	public void testGetBloodGroup_1()
		throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", new Boolean(true), new Long(1L), new Long(1L), "", "", "", new Boolean(true), EasyMock.createNiceMock(List.class), "", "", "", "", "", new Long(1L), "", new Long(1L), "", "");

		String result = fixture.getBloodGroup();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the String getCorrespondenceAddress() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:50 PM
	 */
	@Test
	public void testGetCorrespondenceAddress_1()
		throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", new Boolean(true), new Long(1L), new Long(1L), "", "", "", new Boolean(true), EasyMock.createNiceMock(List.class), "", "", "", "", "", new Long(1L), "", new Long(1L), "", "");

		String result = fixture.getCorrespondenceAddress();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the String getCorrespondenceCity() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:50 PM
	 */
	@Test
	public void testGetCorrespondenceCity_1()
		throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", new Boolean(true), new Long(1L), new Long(1L), "", "", "", new Boolean(true), EasyMock.createNiceMock(List.class), "", "", "", "", "", new Long(1L), "", new Long(1L), "", "");

		String result = fixture.getCorrespondenceCity();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the String getCorrespondencePincode() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:50 PM
	 */
	@Test
	public void testGetCorrespondencePincode_1()
		throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", new Boolean(true), new Long(1L), new Long(1L), "", "", "", new Boolean(true), EasyMock.createNiceMock(List.class), "", "", "", "", "", new Long(1L), "", new Long(1L), "", "");

		String result = fixture.getCorrespondencePincode();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the String getCreatedBy() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:50 PM
	 */
	@Test
	public void testGetCreatedBy_1()
		throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", new Boolean(true), new Long(1L), new Long(1L), "", "", "", new Boolean(true), EasyMock.createNiceMock(List.class), "", "", "", "", "", new Long(1L), "", new Long(1L), "", "");

		String result = fixture.getCreatedBy();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the Long getCreatedDate() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:50 PM
	 */
	@Test
	public void testGetCreatedDate_1()
		throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", new Boolean(true), new Long(1L), new Long(1L), "", "", "", new Boolean(true), EasyMock.createNiceMock(List.class), "", "", "", "", "", new Long(1L), "", new Long(1L), "", "");

		Long result = fixture.getCreatedDate();

		// add additional test code here
		assertNotNull(result);
		assertEquals("1", result.toString());
		assertEquals((byte) 1, result.byteValue());
		assertEquals((short) 1, result.shortValue());
		assertEquals(1, result.intValue());
		assertEquals(1L, result.longValue());
		assertEquals(1.0f, result.floatValue(), 1.0f);
		assertEquals(1.0, result.doubleValue(), 1.0);
	}

	/**
	 * Run the Long getDob() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:50 PM
	 */
	@Test
	public void testGetDob_1()
		throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", new Boolean(true), new Long(1L), new Long(1L), "", "", "", new Boolean(true), EasyMock.createNiceMock(List.class), "", "", "", "", "", new Long(1L), "", new Long(1L), "", "");

		Long result = fixture.getDob();

		// add additional test code here
		assertNotNull(result);
		assertEquals("1", result.toString());
		assertEquals((byte) 1, result.byteValue());
		assertEquals((short) 1, result.shortValue());
		assertEquals(1, result.intValue());
		assertEquals(1L, result.longValue());
		assertEquals(1.0f, result.floatValue(), 1.0f);
		assertEquals(1.0, result.doubleValue(), 1.0);
	}

	/**
	 * Run the String getEmailId() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:50 PM
	 */
	@Test
	public void testGetEmailId_1()
		throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", new Boolean(true), new Long(1L), new Long(1L), "", "", "", new Boolean(true), EasyMock.createNiceMock(List.class), "", "", "", "", "", new Long(1L), "", new Long(1L), "", "");

		String result = fixture.getEmailId();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the String getFatherOrHusbandName() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:50 PM
	 */
	@Test
	public void testGetFatherOrHusbandName_1()
		throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", new Boolean(true), new Long(1L), new Long(1L), "", "", "", new Boolean(true), EasyMock.createNiceMock(List.class), "", "", "", "", "", new Long(1L), "", new Long(1L), "", "");

		String result = fixture.getFatherOrHusbandName();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the String getGender() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:50 PM
	 */
	@Test
	public void testGetGender_1()
		throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", new Boolean(true), new Long(1L), new Long(1L), "", "", "", new Boolean(true), EasyMock.createNiceMock(List.class), "", "", "", "", "", new Long(1L), "", new Long(1L), "", "");

		String result = fixture.getGender();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the Long getId() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:50 PM
	 */
	@Test
	public void testGetId_1()
		throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", new Boolean(true), new Long(1L), new Long(1L), "", "", "", new Boolean(true), EasyMock.createNiceMock(List.class), "", "", "", "", "", new Long(1L), "", new Long(1L), "", "");

		Long result = fixture.getId();

		// add additional test code here
		assertNotNull(result);
		assertEquals("1", result.toString());
		assertEquals((byte) 1, result.byteValue());
		assertEquals((short) 1, result.shortValue());
		assertEquals(1, result.intValue());
		assertEquals(1L, result.longValue());
		assertEquals(1.0f, result.floatValue(), 1.0f);
		assertEquals(1.0, result.doubleValue(), 1.0);
	}

	/**
	 * Run the String getIdentificationMark() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:50 PM
	 */
	@Test
	public void testGetIdentificationMark_1()
		throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", new Boolean(true), new Long(1L), new Long(1L), "", "", "", new Boolean(true), EasyMock.createNiceMock(List.class), "", "", "", "", "", new Long(1L), "", new Long(1L), "", "");

		String result = fixture.getIdentificationMark();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the String getLastModifiedBy() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:50 PM
	 */
	@Test
	public void testGetLastModifiedBy_1()
		throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", new Boolean(true), new Long(1L), new Long(1L), "", "", "", new Boolean(true), EasyMock.createNiceMock(List.class), "", "", "", "", "", new Long(1L), "", new Long(1L), "", "");

		String result = fixture.getLastModifiedBy();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the Long getLastModifiedDate() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:50 PM
	 */
	@Test
	public void testGetLastModifiedDate_1()
		throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", new Boolean(true), new Long(1L), new Long(1L), "", "", "", new Boolean(true), EasyMock.createNiceMock(List.class), "", "", "", "", "", new Long(1L), "", new Long(1L), "", "");

		Long result = fixture.getLastModifiedDate();

		// add additional test code here
		assertNotNull(result);
		assertEquals("1", result.toString());
		assertEquals((byte) 1, result.byteValue());
		assertEquals((short) 1, result.shortValue());
		assertEquals(1, result.intValue());
		assertEquals(1L, result.longValue());
		assertEquals(1.0f, result.floatValue(), 1.0f);
		assertEquals(1.0, result.doubleValue(), 1.0);
	}

	/**
	 * Run the String getLocale() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:50 PM
	 */
	@Test
	public void testGetLocale_1()
		throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", new Boolean(true), new Long(1L), new Long(1L), "", "", "", new Boolean(true), EasyMock.createNiceMock(List.class), "", "", "", "", "", new Long(1L), "", new Long(1L), "", "");

		String result = fixture.getLocale();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the String getMobileNumber() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:50 PM
	 */
	@Test
	public void testGetMobileNumber_1()
		throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", new Boolean(true), new Long(1L), new Long(1L), "", "", "", new Boolean(true), EasyMock.createNiceMock(List.class), "", "", "", "", "", new Long(1L), "", new Long(1L), "", "");

		String result = fixture.getMobileNumber();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the String getName() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:50 PM
	 */
	@Test
	public void testGetName_1()
		throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", new Boolean(true), new Long(1L), new Long(1L), "", "", "", new Boolean(true), EasyMock.createNiceMock(List.class), "", "", "", "", "", new Long(1L), "", new Long(1L), "", "");

		String result = fixture.getName();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the String getOtpReference() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:50 PM
	 */
	@Test
	public void testGetOtpReference_1()
		throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", new Boolean(true), new Long(1L), new Long(1L), "", "", "", new Boolean(true), EasyMock.createNiceMock(List.class), "", "", "", "", "", new Long(1L), "", new Long(1L), "", "");

		String result = fixture.getOtpReference();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the String getPan() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:50 PM
	 */
	@Test
	public void testGetPan_1()
		throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", new Boolean(true), new Long(1L), new Long(1L), "", "", "", new Boolean(true), EasyMock.createNiceMock(List.class), "", "", "", "", "", new Long(1L), "", new Long(1L), "", "");

		String result = fixture.getPan();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the String getPassword() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:50 PM
	 */
	@Test
	public void testGetPassword_1()
		throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", new Boolean(true), new Long(1L), new Long(1L), "", "", "", new Boolean(true), EasyMock.createNiceMock(List.class), "", "", "", "", "", new Long(1L), "", new Long(1L), "", "");

		String result = fixture.getPassword();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the String getPermanentAddress() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:50 PM
	 */
	@Test
	public void testGetPermanentAddress_1()
		throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", new Boolean(true), new Long(1L), new Long(1L), "", "", "", new Boolean(true), EasyMock.createNiceMock(List.class), "", "", "", "", "", new Long(1L), "", new Long(1L), "", "");

		String result = fixture.getPermanentAddress();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the String getPermanentCity() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:50 PM
	 */
	@Test
	public void testGetPermanentCity_1()
		throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", new Boolean(true), new Long(1L), new Long(1L), "", "", "", new Boolean(true), EasyMock.createNiceMock(List.class), "", "", "", "", "", new Long(1L), "", new Long(1L), "", "");

		String result = fixture.getPermanentCity();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the String getPermanentPincode() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:50 PM
	 */
	@Test
	public void testGetPermanentPincode_1()
		throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", new Boolean(true), new Long(1L), new Long(1L), "", "", "", new Boolean(true), EasyMock.createNiceMock(List.class), "", "", "", "", "", new Long(1L), "", new Long(1L), "", "");

		String result = fixture.getPermanentPincode();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the String getPhoto() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:50 PM
	 */
	@Test
	public void testGetPhoto_1()
		throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", new Boolean(true), new Long(1L), new Long(1L), "", "", "", new Boolean(true), EasyMock.createNiceMock(List.class), "", "", "", "", "", new Long(1L), "", new Long(1L), "", "");

		String result = fixture.getPhoto();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the Long getPwdExpiryDate() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:50 PM
	 */
	@Test
	public void testGetPwdExpiryDate_1()
		throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", new Boolean(true), new Long(1L), new Long(1L), "", "", "", new Boolean(true), EasyMock.createNiceMock(List.class), "", "", "", "", "", new Long(1L), "", new Long(1L), "", "");

		Long result = fixture.getPwdExpiryDate();

		// add additional test code here
		assertNotNull(result);
		assertEquals("1", result.toString());
		assertEquals((byte) 1, result.byteValue());
		assertEquals((short) 1, result.shortValue());
		assertEquals(1, result.intValue());
		assertEquals(1L, result.longValue());
		assertEquals(1.0f, result.floatValue(), 1.0f);
		assertEquals(1.0, result.doubleValue(), 1.0);
	}

	/**
	 * Run the List<Role> getRoles() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:50 PM
	 */
	@Test
	public void testGetRoles_1()
		throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", new Boolean(true), new Long(1L), new Long(1L), "", "", "", new Boolean(true), EasyMock.createNiceMock(List.class), "", "", "", "", "", new Long(1L), "", new Long(1L), "", "");

		List<Role> result = fixture.getRoles();

		// add additional test code here
		assertNotNull(result);
		assertEquals(0, result.size());
	}

	/**
	 * Run the String getSalutation() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:50 PM
	 */
	@Test
	public void testGetSalutation_1()
		throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", new Boolean(true), new Long(1L), new Long(1L), "", "", "", new Boolean(true), EasyMock.createNiceMock(List.class), "", "", "", "", "", new Long(1L), "", new Long(1L), "", "");

		String result = fixture.getSalutation();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the String getSignature() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:50 PM
	 */
	@Test
	public void testGetSignature_1()
		throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", new Boolean(true), new Long(1L), new Long(1L), "", "", "", new Boolean(true), EasyMock.createNiceMock(List.class), "", "", "", "", "", new Long(1L), "", new Long(1L), "", "");

		String result = fixture.getSignature();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the String getTenantId() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:50 PM
	 */
	@Test
	public void testGetTenantId_1()
		throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", new Boolean(true), new Long(1L), new Long(1L), "", "", "", new Boolean(true), EasyMock.createNiceMock(List.class), "", "", "", "", "", new Long(1L), "", new Long(1L), "", "");

		String result = fixture.getTenantId();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the String getType() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:50 PM
	 */
	@Test
	public void testGetType_1()
		throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", new Boolean(true), new Long(1L), new Long(1L), "", "", "", new Boolean(true), EasyMock.createNiceMock(List.class), "", "", "", "", "", new Long(1L), "", new Long(1L), "", "");

		String result = fixture.getType();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the String getUserName() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:50 PM
	 */
	@Test
	public void testGetUserName_1()
		throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", new Boolean(true), new Long(1L), new Long(1L), "", "", "", new Boolean(true), EasyMock.createNiceMock(List.class), "", "", "", "", "", new Long(1L), "", new Long(1L), "", "");

		String result = fixture.getUserName();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the String getUuid() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:50 PM
	 */
	@Test
	public void testGetUuid_1()
		throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", new Boolean(true), new Long(1L), new Long(1L), "", "", "", new Boolean(true), EasyMock.createNiceMock(List.class), "", "", "", "", "", new Long(1L), "", new Long(1L), "", "");

		String result = fixture.getUuid();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the int hashCode() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:50 PM
	 */
	@Test
	public void testHashCode_1()
		throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", new Boolean(true), new Long(1L), new Long(1L), "", "", "", new Boolean(true), EasyMock.createNiceMock(List.class), "", "", "", "", "", new Long(1L), "", new Long(1L), "", "");

		int result = fixture.hashCode();

		// add additional test code here
		assertEquals(29791, result);
	}

	/**
	 * Run the void setAadhaarNumber(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:50 PM
	 */
	@Test
	public void testSetAadhaarNumber_1()
		throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", new Boolean(true), new Long(1L), new Long(1L), "", "", "", new Boolean(true), EasyMock.createNiceMock(List.class), "", "", "", "", "", new Long(1L), "", new Long(1L), "", "");
		String aadhaarNumber = "";

		fixture.setAadhaarNumber(aadhaarNumber);

		// add additional test code here
	}

	/**
	 * Run the void setAccountLocked(Boolean) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:50 PM
	 */
	@Test
	public void testSetAccountLocked_1()
		throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", new Boolean(true), new Long(1L), new Long(1L), "", "", "", new Boolean(true), EasyMock.createNiceMock(List.class), "", "", "", "", "", new Long(1L), "", new Long(1L), "", "");
		Boolean accountLocked = new Boolean(true);

		fixture.setAccountLocked(accountLocked);

		// add additional test code here
	}

	/**
	 * Run the void setActive(Boolean) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:50 PM
	 */
	@Test
	public void testSetActive_1()
		throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", new Boolean(true), new Long(1L), new Long(1L), "", "", "", new Boolean(true), EasyMock.createNiceMock(List.class), "", "", "", "", "", new Long(1L), "", new Long(1L), "", "");
		Boolean active = new Boolean(true);

		fixture.setActive(active);

		// add additional test code here
	}

	/**
	 * Run the void setAltContactNumber(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:50 PM
	 */
	@Test
	public void testSetAltContactNumber_1()
		throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", new Boolean(true), new Long(1L), new Long(1L), "", "", "", new Boolean(true), EasyMock.createNiceMock(List.class), "", "", "", "", "", new Long(1L), "", new Long(1L), "", "");
		String altContactNumber = "";

		fixture.setAltContactNumber(altContactNumber);

		// add additional test code here
	}

	/**
	 * Run the void setBloodGroup(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:50 PM
	 */
	@Test
	public void testSetBloodGroup_1()
		throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", new Boolean(true), new Long(1L), new Long(1L), "", "", "", new Boolean(true), EasyMock.createNiceMock(List.class), "", "", "", "", "", new Long(1L), "", new Long(1L), "", "");
		String bloodGroup = "";

		fixture.setBloodGroup(bloodGroup);

		// add additional test code here
	}

	/**
	 * Run the void setCorrespondenceAddress(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:50 PM
	 */
	@Test
	public void testSetCorrespondenceAddress_1()
		throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", new Boolean(true), new Long(1L), new Long(1L), "", "", "", new Boolean(true), EasyMock.createNiceMock(List.class), "", "", "", "", "", new Long(1L), "", new Long(1L), "", "");
		String correspondenceAddress = "";

		fixture.setCorrespondenceAddress(correspondenceAddress);

		// add additional test code here
	}

	/**
	 * Run the void setCorrespondenceCity(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:50 PM
	 */
	@Test
	public void testSetCorrespondenceCity_1()
		throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", new Boolean(true), new Long(1L), new Long(1L), "", "", "", new Boolean(true), EasyMock.createNiceMock(List.class), "", "", "", "", "", new Long(1L), "", new Long(1L), "", "");
		String correspondenceCity = "";

		fixture.setCorrespondenceCity(correspondenceCity);

		// add additional test code here
	}

	/**
	 * Run the void setCorrespondencePincode(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:50 PM
	 */
	@Test
	public void testSetCorrespondencePincode_1()
		throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", new Boolean(true), new Long(1L), new Long(1L), "", "", "", new Boolean(true), EasyMock.createNiceMock(List.class), "", "", "", "", "", new Long(1L), "", new Long(1L), "", "");
		String correspondencePincode = "";

		fixture.setCorrespondencePincode(correspondencePincode);

		// add additional test code here
	}

	/**
	 * Run the void setCreatedBy(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:50 PM
	 */
	@Test
	public void testSetCreatedBy_1()
		throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", new Boolean(true), new Long(1L), new Long(1L), "", "", "", new Boolean(true), EasyMock.createNiceMock(List.class), "", "", "", "", "", new Long(1L), "", new Long(1L), "", "");
		String createdBy = "";

		fixture.setCreatedBy(createdBy);

		// add additional test code here
	}

	/**
	 * Run the void setCreatedDate(Long) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:50 PM
	 */
	@Test
	public void testSetCreatedDate_1()
		throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", new Boolean(true), new Long(1L), new Long(1L), "", "", "", new Boolean(true), EasyMock.createNiceMock(List.class), "", "", "", "", "", new Long(1L), "", new Long(1L), "", "");
		Long createdDate = new Long(1L);

		fixture.setCreatedDate(createdDate);

		// add additional test code here
	}

	/**
	 * Run the void setDob(Long) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:50 PM
	 */
	@Test
	public void testSetDob_1()
		throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", new Boolean(true), new Long(1L), new Long(1L), "", "", "", new Boolean(true), EasyMock.createNiceMock(List.class), "", "", "", "", "", new Long(1L), "", new Long(1L), "", "");
		Long dob = new Long(1L);

		fixture.setDob(dob);

		// add additional test code here
	}

	/**
	 * Run the void setEmailId(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:50 PM
	 */
	@Test
	public void testSetEmailId_1()
		throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", new Boolean(true), new Long(1L), new Long(1L), "", "", "", new Boolean(true), EasyMock.createNiceMock(List.class), "", "", "", "", "", new Long(1L), "", new Long(1L), "", "");
		String emailId = "";

		fixture.setEmailId(emailId);

		// add additional test code here
	}

	/**
	 * Run the void setFatherOrHusbandName(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:50 PM
	 */
	@Test
	public void testSetFatherOrHusbandName_1()
		throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", new Boolean(true), new Long(1L), new Long(1L), "", "", "", new Boolean(true), EasyMock.createNiceMock(List.class), "", "", "", "", "", new Long(1L), "", new Long(1L), "", "");
		String fatherOrHusbandName = "";

		fixture.setFatherOrHusbandName(fatherOrHusbandName);

		// add additional test code here
	}

	/**
	 * Run the void setGender(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:50 PM
	 */
	@Test
	public void testSetGender_1()
		throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", new Boolean(true), new Long(1L), new Long(1L), "", "", "", new Boolean(true), EasyMock.createNiceMock(List.class), "", "", "", "", "", new Long(1L), "", new Long(1L), "", "");
		String gender = "";

		fixture.setGender(gender);

		// add additional test code here
	}

	/**
	 * Run the void setId(Long) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:50 PM
	 */
	@Test
	public void testSetId_1()
		throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", new Boolean(true), new Long(1L), new Long(1L), "", "", "", new Boolean(true), EasyMock.createNiceMock(List.class), "", "", "", "", "", new Long(1L), "", new Long(1L), "", "");
		Long id = new Long(1L);

		fixture.setId(id);

		// add additional test code here
	}

	/**
	 * Run the void setIdentificationMark(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:50 PM
	 */
	@Test
	public void testSetIdentificationMark_1()
		throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", new Boolean(true), new Long(1L), new Long(1L), "", "", "", new Boolean(true), EasyMock.createNiceMock(List.class), "", "", "", "", "", new Long(1L), "", new Long(1L), "", "");
		String identificationMark = "";

		fixture.setIdentificationMark(identificationMark);

		// add additional test code here
	}

	/**
	 * Run the void setLastModifiedBy(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:50 PM
	 */
	@Test
	public void testSetLastModifiedBy_1()
		throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", new Boolean(true), new Long(1L), new Long(1L), "", "", "", new Boolean(true), EasyMock.createNiceMock(List.class), "", "", "", "", "", new Long(1L), "", new Long(1L), "", "");
		String lastModifiedBy = "";

		fixture.setLastModifiedBy(lastModifiedBy);

		// add additional test code here
	}

	/**
	 * Run the void setLastModifiedDate(Long) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:50 PM
	 */
	@Test
	public void testSetLastModifiedDate_1()
		throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", new Boolean(true), new Long(1L), new Long(1L), "", "", "", new Boolean(true), EasyMock.createNiceMock(List.class), "", "", "", "", "", new Long(1L), "", new Long(1L), "", "");
		Long lastModifiedDate = new Long(1L);

		fixture.setLastModifiedDate(lastModifiedDate);

		// add additional test code here
	}

	/**
	 * Run the void setLocale(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:50 PM
	 */
	@Test
	public void testSetLocale_1()
		throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", new Boolean(true), new Long(1L), new Long(1L), "", "", "", new Boolean(true), EasyMock.createNiceMock(List.class), "", "", "", "", "", new Long(1L), "", new Long(1L), "", "");
		String locale = "";

		fixture.setLocale(locale);

		// add additional test code here
	}

	/**
	 * Run the void setMobileNumber(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:50 PM
	 */
	@Test
	public void testSetMobileNumber_1()
		throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", new Boolean(true), new Long(1L), new Long(1L), "", "", "", new Boolean(true), EasyMock.createNiceMock(List.class), "", "", "", "", "", new Long(1L), "", new Long(1L), "", "");
		String mobileNumber = "";

		fixture.setMobileNumber(mobileNumber);

		// add additional test code here
	}

	/**
	 * Run the void setName(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:50 PM
	 */
	@Test
	public void testSetName_1()
		throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", new Boolean(true), new Long(1L), new Long(1L), "", "", "", new Boolean(true), EasyMock.createNiceMock(List.class), "", "", "", "", "", new Long(1L), "", new Long(1L), "", "");
		String name = "";

		fixture.setName(name);

		// add additional test code here
	}

	/**
	 * Run the void setOtpReference(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:50 PM
	 */
	@Test
	public void testSetOtpReference_1()
		throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", new Boolean(true), new Long(1L), new Long(1L), "", "", "", new Boolean(true), EasyMock.createNiceMock(List.class), "", "", "", "", "", new Long(1L), "", new Long(1L), "", "");
		String otpReference = "";

		fixture.setOtpReference(otpReference);

		// add additional test code here
	}

	/**
	 * Run the void setPan(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:50 PM
	 */
	@Test
	public void testSetPan_1()
		throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", new Boolean(true), new Long(1L), new Long(1L), "", "", "", new Boolean(true), EasyMock.createNiceMock(List.class), "", "", "", "", "", new Long(1L), "", new Long(1L), "", "");
		String pan = "";

		fixture.setPan(pan);

		// add additional test code here
	}

	/**
	 * Run the void setPassword(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:50 PM
	 */
	@Test
	public void testSetPassword_1()
		throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", new Boolean(true), new Long(1L), new Long(1L), "", "", "", new Boolean(true), EasyMock.createNiceMock(List.class), "", "", "", "", "", new Long(1L), "", new Long(1L), "", "");
		String password = "";

		fixture.setPassword(password);

		// add additional test code here
	}

	/**
	 * Run the void setPermanentAddress(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:50 PM
	 */
	@Test
	public void testSetPermanentAddress_1()
		throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", new Boolean(true), new Long(1L), new Long(1L), "", "", "", new Boolean(true), EasyMock.createNiceMock(List.class), "", "", "", "", "", new Long(1L), "", new Long(1L), "", "");
		String permanentAddress = "";

		fixture.setPermanentAddress(permanentAddress);

		// add additional test code here
	}

	/**
	 * Run the void setPermanentCity(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:50 PM
	 */
	@Test
	public void testSetPermanentCity_1()
		throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", new Boolean(true), new Long(1L), new Long(1L), "", "", "", new Boolean(true), EasyMock.createNiceMock(List.class), "", "", "", "", "", new Long(1L), "", new Long(1L), "", "");
		String permanentCity = "";

		fixture.setPermanentCity(permanentCity);

		// add additional test code here
	}

	/**
	 * Run the void setPermanentPincode(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:50 PM
	 */
	@Test
	public void testSetPermanentPincode_1()
		throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", new Boolean(true), new Long(1L), new Long(1L), "", "", "", new Boolean(true), EasyMock.createNiceMock(List.class), "", "", "", "", "", new Long(1L), "", new Long(1L), "", "");
		String permanentPincode = "";

		fixture.setPermanentPincode(permanentPincode);

		// add additional test code here
	}

	/**
	 * Run the void setPhoto(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:50 PM
	 */
	@Test
	public void testSetPhoto_1()
		throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", new Boolean(true), new Long(1L), new Long(1L), "", "", "", new Boolean(true), EasyMock.createNiceMock(List.class), "", "", "", "", "", new Long(1L), "", new Long(1L), "", "");
		String photo = "";

		fixture.setPhoto(photo);

		// add additional test code here
	}

	/**
	 * Run the void setPwdExpiryDate(Long) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:50 PM
	 */
	@Test
	public void testSetPwdExpiryDate_1()
		throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", new Boolean(true), new Long(1L), new Long(1L), "", "", "", new Boolean(true), EasyMock.createNiceMock(List.class), "", "", "", "", "", new Long(1L), "", new Long(1L), "", "");
		Long pwdExpiryDate = new Long(1L);

		fixture.setPwdExpiryDate(pwdExpiryDate);

		// add additional test code here
	}

	/**
	 * Run the void setRoles(List<Role>) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:50 PM
	 */
	@Test
	public void testSetRoles_1()
		throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", new Boolean(true), new Long(1L), new Long(1L), "", "", "", new Boolean(true), EasyMock.createNiceMock(List.class), "", "", "", "", "", new Long(1L), "", new Long(1L), "", "");
		List<Role> roles = EasyMock.createMock(List.class);
		// add mock object expectations here

		EasyMock.replay(roles);

		fixture.setRoles(roles);

		// add additional test code here
		EasyMock.verify(roles);
	}

	/**
	 * Run the void setSalutation(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:50 PM
	 */
	@Test
	public void testSetSalutation_1()
		throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", new Boolean(true), new Long(1L), new Long(1L), "", "", "", new Boolean(true), EasyMock.createNiceMock(List.class), "", "", "", "", "", new Long(1L), "", new Long(1L), "", "");
		String salutation = "";

		fixture.setSalutation(salutation);

		// add additional test code here
	}

	/**
	 * Run the void setSignature(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:50 PM
	 */
	@Test
	public void testSetSignature_1()
		throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", new Boolean(true), new Long(1L), new Long(1L), "", "", "", new Boolean(true), EasyMock.createNiceMock(List.class), "", "", "", "", "", new Long(1L), "", new Long(1L), "", "");
		String signature = "";

		fixture.setSignature(signature);

		// add additional test code here
	}

	/**
	 * Run the void setTenantId(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:50 PM
	 */
	@Test
	public void testSetTenantId_1()
		throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", new Boolean(true), new Long(1L), new Long(1L), "", "", "", new Boolean(true), EasyMock.createNiceMock(List.class), "", "", "", "", "", new Long(1L), "", new Long(1L), "", "");
		String tenantId = "";

		fixture.setTenantId(tenantId);

		// add additional test code here
	}

	/**
	 * Run the void setType(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:50 PM
	 */
	@Test
	public void testSetType_1()
		throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", new Boolean(true), new Long(1L), new Long(1L), "", "", "", new Boolean(true), EasyMock.createNiceMock(List.class), "", "", "", "", "", new Long(1L), "", new Long(1L), "", "");
		String type = "";

		fixture.setType(type);

		// add additional test code here
	}

	/**
	 * Run the void setUserName(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:50 PM
	 */
	@Test
	public void testSetUserName_1()
		throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", new Boolean(true), new Long(1L), new Long(1L), "", "", "", new Boolean(true), EasyMock.createNiceMock(List.class), "", "", "", "", "", new Long(1L), "", new Long(1L), "", "");
		String userName = "";

		fixture.setUserName(userName);

		// add additional test code here
	}

	/**
	 * Run the void setUuid(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:50 PM
	 */
	@Test
	public void testSetUuid_1()
		throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", new Boolean(true), new Long(1L), new Long(1L), "", "", "", new Boolean(true), EasyMock.createNiceMock(List.class), "", "", "", "", "", new Long(1L), "", new Long(1L), "", "");
		String uuid = "";

		fixture.setUuid(uuid);

		// add additional test code here
	}

	/**
	 * Perform pre-test initialization.
	 *
	 * @throws Exception
	 *         if the initialization fails for some reason
	 *
	 * @generatedBy CodePro at 25/5/20 3:50 PM
	 */
	@Before
	public void setUp()
		throws Exception {
		// add additional set up code here
	}

	/**
	 * Perform post-test clean-up.
	 *
	 * @throws Exception
	 *         if the clean-up fails for some reason
	 *
	 * @generatedBy CodePro at 25/5/20 3:50 PM
	 */
	@After
	public void tearDown()
		throws Exception {
		// Add additional tear down code here
	}

	/**
	 * Launch the test.
	 *
	 * @param args the command line arguments
	 *
	 * @generatedBy CodePro at 25/5/20 3:50 PM
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(UserTest.class);
	}
}