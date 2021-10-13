package org.egov.pm.model;

import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class UserTest {

	@Test
	public void testUser_1() throws Exception {
		Long id = new Long(1L);
		String uuid = "";
		String tenantId = "";
		String username = "";
		String title = "";
		String password = "";
		String salutation = "";
		String guardian = "";
		String name = "";
		String mobileNumber = "";
		String emailId = "";
		String altContactNumber = "";
		String pan = "";
		String aadhaarNumber = "";
		Boolean active = new Boolean(true);
		String locale = "";
		String identificationMark = "";
		String signature = "";
		String photo = "";
		Boolean accountLocked = new Boolean(true);
		Long accountLockedDate = new Long(1L);
		String otpReference = "";
		Long createdBy = new Long(1L);
		Long lastModifiedBy = new Long(1L);
		Long loggedInUserId = new Long(1L);
		boolean otpValidationMandatory = true;
		boolean mobileValidationMandatory = true;

		User result = new User(id, uuid, tenantId, username, title, password, salutation, guardian, name, mobileNumber,
				emailId, altContactNumber, pan, aadhaarNumber, active, locale, identificationMark, signature, photo,
				accountLocked, accountLockedDate, otpReference, createdBy, lastModifiedBy, loggedInUserId,
				otpValidationMandatory, mobileValidationMandatory);

		assertNotNull(result);
		assertEquals("", result.getName());
		assertEquals(new Long(1L), result.getId());
		assertEquals("", result.getSignature());
		assertEquals("", result.getEmailId());
		assertEquals("", result.getPan());
		assertEquals("", result.getMobileNumber());
		assertEquals("", result.getIdentificationMark());
		assertEquals(new Long(1L), result.getAccountLockedDate());
		assertEquals(new Long(1L), result.getLastModifiedBy());
		assertEquals(new Long(1L), result.getLoggedInUserId());
		assertEquals(true, result.isOtpValidationMandatory());
		assertEquals(true, result.isMobileValidationMandatory());
		assertEquals(true, result.isOtpReferenceAbsent());
		assertEquals(false, result.isActiveIndicatorAbsent());
		assertEquals(true, result.isMobileNumberAbsent());
		assertEquals("", result.getAltContactNumber());
		assertEquals("", result.getLocale());
		assertEquals("", result.getTitle());
		assertEquals("", result.getPassword());
		assertEquals(Boolean.TRUE, result.getActive());
		assertEquals("", result.getTenantId());
		assertEquals("", result.getSalutation());
		assertEquals("", result.getGuardian());
		assertEquals("", result.getUsername());
		assertEquals("", result.getUuid());
		assertEquals(false, result.isIdAbsent());
		assertEquals(true, result.isNameAbsent());
		assertEquals(true, result.isUsernameAbsent());
		assertEquals(true, result.isTenantIdAbsent());
		assertEquals(true, result.isPasswordAbsent());
		assertEquals("", result.getOtpReference());
		assertEquals(new Long(1L), result.getCreatedBy());
		assertEquals("", result.getPhoto());
		assertEquals(Boolean.TRUE, result.getAccountLocked());
		assertEquals("", result.getAadhaarNumber());
		assertEquals(false, result.isLoggedInUserDifferentFromUpdatedUser());
	}

	@Test
	public void testBuilder_1() throws Exception {

		User.UserBuilder result = User.builder();

		assertNotNull(result);
		assertEquals(
				"User.UserBuilder(id=null, uuid=null, tenantId=null, username=null, title=null, password=null, salutation=null, guardian=null, name=null, mobileNumber=null, emailId=null, altContactNumber=null, pan=null, aadhaarNumber=null, active=null, locale=null, identificationMark=null, signature=null, photo=null, accountLocked=null, accountLockedDate=null, otpReference=null, createdBy=null, lastModifiedBy=null, loggedInUserId=null, otpValidationMandatory=false, mobileValidationMandatory=false)",
				result.toString());
	}

	@Test
	public void testGetAadhaarNumber_1() throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", new Boolean(true), "",
				"", "", "", new Boolean(true), new Long(1L), "", new Long(1L), new Long(1L), new Long(1L), true, true);

		String result = fixture.getAadhaarNumber();

		assertEquals("", result);
	}

	@Test
	public void testGetAccountLocked_1() throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", new Boolean(true), "",
				"", "", "", new Boolean(true), new Long(1L), "", new Long(1L), new Long(1L), new Long(1L), true, true);

		Boolean result = fixture.getAccountLocked();

		assertNotNull(result);
		assertEquals("true", result.toString());
		assertEquals(true, result.booleanValue());
	}

	@Test
	public void testGetAccountLockedDate_1() throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", new Boolean(true), "",
				"", "", "", new Boolean(true), new Long(1L), "", new Long(1L), new Long(1L), new Long(1L), true, true);

		Long result = fixture.getAccountLockedDate();

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
	public void testGetActive_1() throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", new Boolean(true), "",
				"", "", "", new Boolean(true), new Long(1L), "", new Long(1L), new Long(1L), new Long(1L), true, true);

		Boolean result = fixture.getActive();

		assertNotNull(result);
		assertEquals("true", result.toString());
		assertEquals(true, result.booleanValue());
	}

	@Test
	public void testGetAltContactNumber_1() throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", new Boolean(true), "",
				"", "", "", new Boolean(true), new Long(1L), "", new Long(1L), new Long(1L), new Long(1L), true, true);

		String result = fixture.getAltContactNumber();

		assertEquals("", result);
	}

	@Test
	public void testGetCreatedBy_1() throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", new Boolean(true), "",
				"", "", "", new Boolean(true), new Long(1L), "", new Long(1L), new Long(1L), new Long(1L), true, true);

		Long result = fixture.getCreatedBy();

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
	public void testGetEmailId_1() throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", new Boolean(true), "",
				"", "", "", new Boolean(true), new Long(1L), "", new Long(1L), new Long(1L), new Long(1L), true, true);

		String result = fixture.getEmailId();

		assertEquals("", result);
	}

	@Test
	public void testGetGuardian_1() throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", new Boolean(true), "",
				"", "", "", new Boolean(true), new Long(1L), "", new Long(1L), new Long(1L), new Long(1L), true, true);

		String result = fixture.getGuardian();

		assertEquals("", result);
	}

	@Test
	public void testGetId_1() throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", new Boolean(true), "",
				"", "", "", new Boolean(true), new Long(1L), "", new Long(1L), new Long(1L), new Long(1L), true, true);

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
	public void testGetIdentificationMark_1() throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", new Boolean(true), "",
				"", "", "", new Boolean(true), new Long(1L), "", new Long(1L), new Long(1L), new Long(1L), true, true);

		String result = fixture.getIdentificationMark();

		assertEquals("", result);
	}

	@Test
	public void testGetLastModifiedBy_1() throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", new Boolean(true), "",
				"", "", "", new Boolean(true), new Long(1L), "", new Long(1L), new Long(1L), new Long(1L), true, true);

		Long result = fixture.getLastModifiedBy();

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
	public void testGetLocale_1() throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", new Boolean(true), "",
				"", "", "", new Boolean(true), new Long(1L), "", new Long(1L), new Long(1L), new Long(1L), true, true);

		String result = fixture.getLocale();

		assertEquals("", result);
	}

	@Test
	public void testGetLoggedInUserId_1() throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", new Boolean(true), "",
				"", "", "", new Boolean(true), new Long(1L), "", new Long(1L), new Long(1L), new Long(1L), true, true);

		Long result = fixture.getLoggedInUserId();

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
	public void testGetMobileNumber_1() throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", new Boolean(true), "",
				"", "", "", new Boolean(true), new Long(1L), "", new Long(1L), new Long(1L), new Long(1L), true, true);

		String result = fixture.getMobileNumber();

		assertEquals("", result);
	}

	@Test
	public void testGetName_1() throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", new Boolean(true), "",
				"", "", "", new Boolean(true), new Long(1L), "", new Long(1L), new Long(1L), new Long(1L), true, true);

		String result = fixture.getName();

		assertEquals("", result);
	}

	@Test
	public void testGetOtpReference_1() throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", new Boolean(true), "",
				"", "", "", new Boolean(true), new Long(1L), "", new Long(1L), new Long(1L), new Long(1L), true, true);

		String result = fixture.getOtpReference();

		assertEquals("", result);
	}

	@Test
	public void testGetPan_1() throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", new Boolean(true), "",
				"", "", "", new Boolean(true), new Long(1L), "", new Long(1L), new Long(1L), new Long(1L), true, true);

		String result = fixture.getPan();

		assertEquals("", result);
	}

	@Test
	public void testGetPassword_1() throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", new Boolean(true), "",
				"", "", "", new Boolean(true), new Long(1L), "", new Long(1L), new Long(1L), new Long(1L), true, true);

		String result = fixture.getPassword();

		assertEquals("", result);
	}

	@Test
	public void testGetPhoto_1() throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", new Boolean(true), "",
				"", "", "", new Boolean(true), new Long(1L), "", new Long(1L), new Long(1L), new Long(1L), true, true);

		String result = fixture.getPhoto();

		assertEquals("", result);
	}

	@Test
	public void testGetSalutation_1() throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", new Boolean(true), "",
				"", "", "", new Boolean(true), new Long(1L), "", new Long(1L), new Long(1L), new Long(1L), true, true);

		String result = fixture.getSalutation();

		assertEquals("", result);
	}

	@Test
	public void testGetSignature_1() throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", new Boolean(true), "",
				"", "", "", new Boolean(true), new Long(1L), "", new Long(1L), new Long(1L), new Long(1L), true, true);

		String result = fixture.getSignature();

		assertEquals("", result);
	}

	@Test
	public void testGetTenantId_1() throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", new Boolean(true), "",
				"", "", "", new Boolean(true), new Long(1L), "", new Long(1L), new Long(1L), new Long(1L), true, true);

		String result = fixture.getTenantId();

		assertEquals("", result);
	}

	@Test
	public void testGetTitle_1() throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", new Boolean(true), "",
				"", "", "", new Boolean(true), new Long(1L), "", new Long(1L), new Long(1L), new Long(1L), true, true);

		String result = fixture.getTitle();

		assertEquals("", result);
	}

	@Test
	public void testGetUsername_1() throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", new Boolean(true), "",
				"", "", "", new Boolean(true), new Long(1L), "", new Long(1L), new Long(1L), new Long(1L), true, true);

		String result = fixture.getUsername();

		assertEquals("", result);
	}

	@Test
	public void testGetUuid_1() throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", new Boolean(true), "",
				"", "", "", new Boolean(true), new Long(1L), "", new Long(1L), new Long(1L), new Long(1L), true, true);

		String result = fixture.getUuid();

		assertEquals("", result);
	}

	@Test
	public void testIsActiveIndicatorAbsent_1() throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", new Boolean(true), "",
				"", "", "", new Boolean(true), new Long(1L), "", new Long(1L), new Long(1L), new Long(1L), true, true);

		boolean result = fixture.isActiveIndicatorAbsent();

		assertEquals(false, result);
	}

	@Test
	public void testIsActiveIndicatorAbsent_2() throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", new Boolean(true), "",
				"", "", "", new Boolean(true), new Long(1L), "", new Long(1L), new Long(1L), new Long(1L), true, true);

		boolean result = fixture.isActiveIndicatorAbsent();

		assertEquals(false, result);
	}

	public void testIsIdAbsent_1() throws Exception {
		User fixture = new User((Long) null, "", "", "", "", "", "", "", "", "", "", "", "", "", new Boolean(true), "",
				"", "", "", new Boolean(true), new Long(1L), "", new Long(1L), new Long(1L), new Long(1L), true, true);

		boolean result = fixture.isIdAbsent();

		assertEquals(true, result);
	}

	@Test
	public void testIsIdAbsent_2() throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", new Boolean(true), "",
				"", "", "", new Boolean(true), new Long(1L), "", new Long(1L), new Long(1L), new Long(1L), true, true);

		boolean result = fixture.isIdAbsent();

		assertEquals(false, result);
	}

	@Test
	public void testIsLoggedInUserDifferentFromUpdatedUser_1() throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", new Boolean(true), "",
				"", "", "", new Boolean(true), new Long(1L), "", new Long(1L), new Long(1L), new Long(1L), true, true);

		boolean result = fixture.isLoggedInUserDifferentFromUpdatedUser();

		assertEquals(false, result);
	}

	@Test
	public void testIsLoggedInUserDifferentFromUpdatedUser_2() throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", new Boolean(true), "",
				"", "", "", new Boolean(true), new Long(1L), "", new Long(1L), new Long(1L), new Long(1L), true, true);

		boolean result = fixture.isLoggedInUserDifferentFromUpdatedUser();

		assertEquals(false, result);
	}

	@Test
	public void testIsMobileNumberAbsent_1() throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", new Boolean(true), "",
				"", "", "", new Boolean(true), new Long(1L), "", new Long(1L), new Long(1L), new Long(1L), true, true);

		boolean result = fixture.isMobileNumberAbsent();

		assertEquals(true, result);
	}

	@Test
	public void testIsMobileNumberAbsent_2() throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", new Boolean(true), "",
				"", "", "", new Boolean(true), new Long(1L), "", new Long(1L), new Long(1L), new Long(1L), true, false);

		boolean result = fixture.isMobileNumberAbsent();

		assertEquals(false, result);
	}

	@Test
	public void testIsMobileNumberAbsent_3() throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", new Boolean(true), "",
				"", "", "", new Boolean(true), new Long(1L), "", new Long(1L), new Long(1L), new Long(1L), true, true);

		boolean result = fixture.isMobileNumberAbsent();

		assertEquals(true, result);
	}

	@Test
	public void testIsMobileValidationMandatory_1() throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", new Boolean(true), "",
				"", "", "", new Boolean(true), new Long(1L), "", new Long(1L), new Long(1L), new Long(1L), true, true);

		boolean result = fixture.isMobileValidationMandatory();

		assertEquals(true, result);
	}

	@Test
	public void testIsMobileValidationMandatory_2() throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", new Boolean(true), "",
				"", "", "", new Boolean(true), new Long(1L), "", new Long(1L), new Long(1L), new Long(1L), true, false);

		boolean result = fixture.isMobileValidationMandatory();

		assertEquals(false, result);
	}

	@Test
	public void testIsNameAbsent_1() throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", new Boolean(true), "",
				"", "", "", new Boolean(true), new Long(1L), "", new Long(1L), new Long(1L), new Long(1L), true, true);

		boolean result = fixture.isNameAbsent();

		assertEquals(true, result);
	}

	@Test
	public void testIsNameAbsent_2() throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", new Boolean(true), "",
				"", "", "", new Boolean(true), new Long(1L), "", new Long(1L), new Long(1L), new Long(1L), true, true);

		boolean result = fixture.isNameAbsent();

		assertEquals(true, result);
	}

	@Test
	public void testIsOtpReferenceAbsent_1() throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", new Boolean(true), "",
				"", "", "", new Boolean(true), new Long(1L), "", new Long(1L), new Long(1L), new Long(1L), true, true);

		boolean result = fixture.isOtpReferenceAbsent();

		assertEquals(true, result);
	}

	@Test
	public void testIsOtpReferenceAbsent_2() throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", new Boolean(true), "",
				"", "", "", new Boolean(true), new Long(1L), "", new Long(1L), new Long(1L), new Long(1L), false, true);

		boolean result = fixture.isOtpReferenceAbsent();

		assertEquals(false, result);
	}

	@Test
	public void testIsOtpReferenceAbsent_3() throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", new Boolean(true), "",
				"", "", "", new Boolean(true), new Long(1L), "", new Long(1L), new Long(1L), new Long(1L), true, true);

		boolean result = fixture.isOtpReferenceAbsent();

		assertEquals(true, result);
	}

	@Test
	public void testIsOtpValidationMandatory_1() throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", new Boolean(true), "",
				"", "", "", new Boolean(true), new Long(1L), "", new Long(1L), new Long(1L), new Long(1L), true, true);

		boolean result = fixture.isOtpValidationMandatory();

		assertEquals(true, result);
	}

	@Test
	public void testIsOtpValidationMandatory_2() throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", new Boolean(true), "",
				"", "", "", new Boolean(true), new Long(1L), "", new Long(1L), new Long(1L), new Long(1L), false, true);

		boolean result = fixture.isOtpValidationMandatory();

		assertEquals(false, result);
	}

	@Test
	public void testIsPasswordAbsent_1() throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", new Boolean(true), "",
				"", "", "", new Boolean(true), new Long(1L), "", new Long(1L), new Long(1L), new Long(1L), true, true);

		boolean result = fixture.isPasswordAbsent();

		assertEquals(true, result);
	}

	@Test
	public void testIsPasswordAbsent_2() throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", new Boolean(true), "",
				"", "", "", new Boolean(true), new Long(1L), "", new Long(1L), new Long(1L), new Long(1L), true, true);

		boolean result = fixture.isPasswordAbsent();

		assertEquals(true, result);
	}

	@Test
	public void testIsTenantIdAbsent_1() throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", new Boolean(true), "",
				"", "", "", new Boolean(true), new Long(1L), "", new Long(1L), new Long(1L), new Long(1L), true, true);

		boolean result = fixture.isTenantIdAbsent();

		assertEquals(true, result);
	}

	@Test
	public void testIsTenantIdAbsent_2() throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", new Boolean(true), "",
				"", "", "", new Boolean(true), new Long(1L), "", new Long(1L), new Long(1L), new Long(1L), true, true);

		boolean result = fixture.isTenantIdAbsent();

		assertEquals(true, result);
	}

	@Test
	public void testIsUsernameAbsent_1() throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", new Boolean(true), "",
				"", "", "", new Boolean(true), new Long(1L), "", new Long(1L), new Long(1L), new Long(1L), true, true);

		boolean result = fixture.isUsernameAbsent();

		assertEquals(true, result);
	}

	@Test
	public void testIsUsernameAbsent_2() throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", new Boolean(true), "",
				"", "", "", new Boolean(true), new Long(1L), "", new Long(1L), new Long(1L), new Long(1L), true, true);

		boolean result = fixture.isUsernameAbsent();

		assertEquals(true, result);
	}

	@Test
	public void testSetAadhaarNumber_1() throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", new Boolean(true), "",
				"", "", "", new Boolean(true), new Long(1L), "", new Long(1L), new Long(1L), new Long(1L), true, true);
		String aadhaarNumber = "";

		fixture.setAadhaarNumber(aadhaarNumber);

	}

	@Test
	public void testSetAccountLocked_1() throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", new Boolean(true), "",
				"", "", "", new Boolean(true), new Long(1L), "", new Long(1L), new Long(1L), new Long(1L), true, true);
		Boolean accountLocked = new Boolean(true);

		fixture.setAccountLocked(accountLocked);

	}

	@Test
	public void testSetAccountLockedDate_1() throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", new Boolean(true), "",
				"", "", "", new Boolean(true), new Long(1L), "", new Long(1L), new Long(1L), new Long(1L), true, true);
		Long accountLockedDate = new Long(1L);

		fixture.setAccountLockedDate(accountLockedDate);

	}

	@Test
	public void testSetActive_1() throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", new Boolean(true), "",
				"", "", "", new Boolean(true), new Long(1L), "", new Long(1L), new Long(1L), new Long(1L), true, true);
		boolean isActive = true;

		fixture.setActive(isActive);

	}

	@Test
	public void testSetAltContactNumber_1() throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", new Boolean(true), "",
				"", "", "", new Boolean(true), new Long(1L), "", new Long(1L), new Long(1L), new Long(1L), true, true);
		String altContactNumber = "";

		fixture.setAltContactNumber(altContactNumber);

	}

	@Test
	public void testSetCreatedBy_1() throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", new Boolean(true), "",
				"", "", "", new Boolean(true), new Long(1L), "", new Long(1L), new Long(1L), new Long(1L), true, true);
		Long createdBy = new Long(1L);

		fixture.setCreatedBy(createdBy);

	}

	@Test
	public void testSetEmailId_1() throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", new Boolean(true), "",
				"", "", "", new Boolean(true), new Long(1L), "", new Long(1L), new Long(1L), new Long(1L), true, true);
		String emailId = "";

		fixture.setEmailId(emailId);

	}

	@Test
	public void testSetGuardian_1() throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", new Boolean(true), "",
				"", "", "", new Boolean(true), new Long(1L), "", new Long(1L), new Long(1L), new Long(1L), true, true);
		String guardian = "";

		fixture.setGuardian(guardian);

	}

	@Test
	public void testSetId_1() throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", new Boolean(true), "",
				"", "", "", new Boolean(true), new Long(1L), "", new Long(1L), new Long(1L), new Long(1L), true, true);
		Long id = new Long(1L);

		fixture.setId(id);

	}

	@Test
	public void testSetIdentificationMark_1() throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", new Boolean(true), "",
				"", "", "", new Boolean(true), new Long(1L), "", new Long(1L), new Long(1L), new Long(1L), true, true);
		String identificationMark = "";

		fixture.setIdentificationMark(identificationMark);

	}

	@Test
	public void testSetLastModifiedBy_1() throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", new Boolean(true), "",
				"", "", "", new Boolean(true), new Long(1L), "", new Long(1L), new Long(1L), new Long(1L), true, true);
		Long lastModifiedBy = new Long(1L);

		fixture.setLastModifiedBy(lastModifiedBy);

	}

	@Test
	public void testSetLocale_1() throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", new Boolean(true), "",
				"", "", "", new Boolean(true), new Long(1L), "", new Long(1L), new Long(1L), new Long(1L), true, true);
		String locale = "";

		fixture.setLocale(locale);

	}

	@Test
	public void testSetLoggedInUserId_1() throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", new Boolean(true), "",
				"", "", "", new Boolean(true), new Long(1L), "", new Long(1L), new Long(1L), new Long(1L), true, true);
		Long loggedInUserId = new Long(1L);

		fixture.setLoggedInUserId(loggedInUserId);

	}

	@Test
	public void testSetMobileNumber_1() throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", new Boolean(true), "",
				"", "", "", new Boolean(true), new Long(1L), "", new Long(1L), new Long(1L), new Long(1L), true, true);
		String mobileNumber = "";

		fixture.setMobileNumber(mobileNumber);

	}

	@Test
	public void testSetMobileValidationMandatory_1() throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", new Boolean(true), "",
				"", "", "", new Boolean(true), new Long(1L), "", new Long(1L), new Long(1L), new Long(1L), true, true);
		boolean mobileValidationMandatory = true;

		fixture.setMobileValidationMandatory(mobileValidationMandatory);

	}

	@Test
	public void testSetName_1() throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", new Boolean(true), "",
				"", "", "", new Boolean(true), new Long(1L), "", new Long(1L), new Long(1L), new Long(1L), true, true);
		String name = "";

		fixture.setName(name);

	}

	@Test
	public void testSetOtpReference_1() throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", new Boolean(true), "",
				"", "", "", new Boolean(true), new Long(1L), "", new Long(1L), new Long(1L), new Long(1L), true, true);
		String otpReference = "";

		fixture.setOtpReference(otpReference);

	}

	@Test
	public void testSetOtpValidationMandatory_1() throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", new Boolean(true), "",
				"", "", "", new Boolean(true), new Long(1L), "", new Long(1L), new Long(1L), new Long(1L), true, true);
		boolean otpValidationMandatory = true;

		fixture.setOtpValidationMandatory(otpValidationMandatory);

	}

	@Test
	public void testSetPan_1() throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", new Boolean(true), "",
				"", "", "", new Boolean(true), new Long(1L), "", new Long(1L), new Long(1L), new Long(1L), true, true);
		String pan = "";

		fixture.setPan(pan);

	}

	@Test
	public void testSetPassword_1() throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", new Boolean(true), "",
				"", "", "", new Boolean(true), new Long(1L), "", new Long(1L), new Long(1L), new Long(1L), true, true);
		String password = "";

		fixture.setPassword(password);

	}

	@Test
	public void testSetPhoto_1() throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", new Boolean(true), "",
				"", "", "", new Boolean(true), new Long(1L), "", new Long(1L), new Long(1L), new Long(1L), true, true);
		String photo = "";

		fixture.setPhoto(photo);

	}

	@Test
	public void testSetSalutation_1() throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", new Boolean(true), "",
				"", "", "", new Boolean(true), new Long(1L), "", new Long(1L), new Long(1L), new Long(1L), true, true);
		String salutation = "";

		fixture.setSalutation(salutation);

	}

	@Test
	public void testSetSignature_1() throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", new Boolean(true), "",
				"", "", "", new Boolean(true), new Long(1L), "", new Long(1L), new Long(1L), new Long(1L), true, true);
		String signature = "";

		fixture.setSignature(signature);

	}

	@Test
	public void testSetTenantId_1() throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", new Boolean(true), "",
				"", "", "", new Boolean(true), new Long(1L), "", new Long(1L), new Long(1L), new Long(1L), true, true);
		String tenantId = "";

		fixture.setTenantId(tenantId);

	}

	@Test
	public void testSetTitle_1() throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", new Boolean(true), "",
				"", "", "", new Boolean(true), new Long(1L), "", new Long(1L), new Long(1L), new Long(1L), true, true);
		String title = "";

		fixture.setTitle(title);

	}

	@Test
	public void testSetUsername_1() throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", new Boolean(true), "",
				"", "", "", new Boolean(true), new Long(1L), "", new Long(1L), new Long(1L), new Long(1L), true, true);
		String username = "";

		fixture.setUsername(username);

	}

	@Test
	public void testSetUuid_1() throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", new Boolean(true), "",
				"", "", "", new Boolean(true), new Long(1L), "", new Long(1L), new Long(1L), new Long(1L), true, true);
		String uuid = "";

		fixture.setUuid(uuid);

	}

	@Test
	public void testToBuilder_1() throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", new Boolean(true), "",
				"", "", "", new Boolean(true), new Long(1L), "", new Long(1L), new Long(1L), new Long(1L), true, true);

		User.UserBuilder result = fixture.toBuilder();

		assertNotNull(result);
		assertEquals(
				"User.UserBuilder(id=1, uuid=, tenantId=, username=, title=, password=, salutation=, guardian=, name=, mobileNumber=, emailId=, altContactNumber=, pan=, aadhaarNumber=, active=true, locale=, identificationMark=, signature=, photo=, accountLocked=true, accountLockedDate=1, otpReference=, createdBy=1, lastModifiedBy=1, loggedInUserId=1, otpValidationMandatory=true, mobileValidationMandatory=true)",
				result.toString());
	}

	@Test
	public void testUpdatePassword_1() throws Exception {
		User fixture = new User(new Long(1L), "", "", "", "", "", "", "", "", "", "", "", "", "", new Boolean(true), "",
				"", "", "", new Boolean(true), new Long(1L), "", new Long(1L), new Long(1L), new Long(1L), true, true);
		String newPassword = "";

		fixture.updatePassword(newPassword);

	}

	@Test
	public void testBuilders_1() throws Exception {
		User.UserBuilder fixture = new User.UserBuilder();
		fixture.build();
	}
}