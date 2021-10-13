package org.egov.prscp.web.models;

import org.junit.*;
import static org.junit.Assert.*;

public class EmployeeTest {

	@Test
	public void testEmployee_1()
		throws Exception {

		Employee result = new Employee();

		assertNotNull(result);
		assertEquals(null, result.getId());
		assertEquals(null, result.getCode());
		assertEquals(null, result.getUser());
		assertEquals(null, result.getDateOfAppointment());
		assertEquals(null, result.getEmployeeStatus());
		assertEquals(null, result.getAuditDetails());
		assertEquals(null, result.getEmployeeType());
		assertEquals(null, result.getUuid());
		assertEquals(null, result.getTenantId());
		assertEquals(null, result.getIsActive());
	}

	
	@Test
	public void testEmployee_2()
		throws Exception {
		Long id = new Long(1L);
		String uuid = "";
		String code = "";
		String employeeStatus = "";
		String employeeType = "";
		Long dateOfAppointment = new Long(1L);
		Boolean IsActive = new Boolean(true);
		String tenantId = "";
		AuditDetails auditDetails = new AuditDetails();
		User user = new User();

		Employee result = new Employee(id, uuid, code, employeeStatus, employeeType, dateOfAppointment, IsActive, tenantId, auditDetails, user);

	
		assertNotNull(result);
		assertEquals(new Long(1L), result.getId());
		assertEquals("", result.getCode());
		assertEquals(new Long(1L), result.getDateOfAppointment());
		assertEquals("", result.getEmployeeStatus());
		assertEquals("", result.getEmployeeType());
		assertEquals("", result.getUuid());
		assertEquals("", result.getTenantId());
		assertEquals(Boolean.TRUE, result.getIsActive());
	}


	@Test
	public void testBuilder_1()
		throws Exception {

		Employee.EmployeeBuilder result = Employee.builder();

		
		assertNotNull(result);
		assertEquals("Employee.EmployeeBuilder(id=null, uuid=null, code=null, employeeStatus=null, employeeType=null, dateOfAppointment=null, IsActive=null, tenantId=null, auditDetails=null, user=null)", result.toString());
	}

	
	@Test
	public void testGetAuditDetails_1()
		throws Exception {
		Employee fixture = new Employee(new Long(1L), "", "", "", "", new Long(1L), new Boolean(true), "", new AuditDetails(), new User());

		AuditDetails result = fixture.getAuditDetails();

		
		assertNotNull(result);
		assertEquals(null, result.getLastModifiedTime());
		assertEquals(null, result.getLastModifiedBy());
		assertEquals(null, result.getCreatedTime());
		assertEquals(null, result.getCreatedBy());
	}

	
	@Test
	public void testGetCode_1()
		throws Exception {
		Employee fixture = new Employee(new Long(1L), "", "", "", "", new Long(1L), new Boolean(true), "", new AuditDetails(), new User());

		String result = fixture.getCode();

		
		assertEquals("", result);
	}

	
	@Test
	public void testGetDateOfAppointment_1()
		throws Exception {
		Employee fixture = new Employee(new Long(1L), "", "", "", "", new Long(1L), new Boolean(true), "", new AuditDetails(), new User());

		Long result = fixture.getDateOfAppointment();

	
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
	public void testGetEmployeeStatus_1()
		throws Exception {
		Employee fixture = new Employee(new Long(1L), "", "", "", "", new Long(1L), new Boolean(true), "", new AuditDetails(), new User());

		String result = fixture.getEmployeeStatus();

		assertEquals("", result);
	}

	
	@Test
	public void testGetEmployeeType_1()
		throws Exception {
		Employee fixture = new Employee(new Long(1L), "", "", "", "", new Long(1L), new Boolean(true), "", new AuditDetails(), new User());

		String result = fixture.getEmployeeType();

	
		assertEquals("", result);
	}

	@Test
	public void testGetId_1()
		throws Exception {
		Employee fixture = new Employee(new Long(1L), "", "", "", "", new Long(1L), new Boolean(true), "", new AuditDetails(), new User());

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
	public void testGetIsActive_1()
		throws Exception {
		Employee fixture = new Employee(new Long(1L), "", "", "", "", new Long(1L), new Boolean(true), "", new AuditDetails(), new User());

		Boolean result = fixture.getIsActive();

		
		assertNotNull(result);
		assertEquals("true", result.toString());
		assertEquals(true, result.booleanValue());
	}

	
	@Test
	public void testGetTenantId_1()
		throws Exception {
		Employee fixture = new Employee(new Long(1L), "", "", "", "", new Long(1L), new Boolean(true), "", new AuditDetails(), new User());

		String result = fixture.getTenantId();

		
		assertEquals("", result);
	}

	
	@Test
	public void testGetUser_1()
		throws Exception {
		Employee fixture = new Employee(new Long(1L), "", "", "", "", new Long(1L), new Boolean(true), "", new AuditDetails(), new User());

		User result = fixture.getUser();

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
		assertEquals(null, result.getFatherOrHusbandName());
		assertEquals(null, result.getPermanentAddress());
		assertEquals(null, result.getAltContactNumber());
		assertEquals(null, result.getIdentificationMark());
		assertEquals(null, result.getPermanentPincode());
		assertEquals(null, result.getCorrespondencePincode());
		assertEquals(null, result.getCorrespondenceAddress());
		assertEquals(null, result.getLastModifiedBy());
		assertEquals(null, result.getCorrespondenceCity());
		assertEquals(null, result.getUuid());
		assertEquals(null, result.getTenantId());
		assertEquals(null, result.getAccountLocked());
		assertEquals(null, result.getBloodGroup());
		assertEquals(null, result.getPwdExpiryDate());
		assertEquals(null, result.getEmailId());
		assertEquals(null, result.getCreatedBy());
		assertEquals(null, result.getGender());
		assertEquals(null, result.getPhoto());
		assertEquals(null, result.getPermanentCity());
		assertEquals(null, result.getMobileNumber());
		assertEquals(null, result.getAadhaarNumber());
		assertEquals(null, result.getSalutation());
		assertEquals(null, result.getOtpReference());
		assertEquals(null, result.getDob());
		assertEquals(null, result.getCreatedDate());
		assertEquals(null, result.getPan());
	}

	@Test
	public void testGetUuid_1()
		throws Exception {
		Employee fixture = new Employee(new Long(1L), "", "", "", "", new Long(1L), new Boolean(true), "", new AuditDetails(), new User());

		String result = fixture.getUuid();

		// add additional test code here
		assertEquals("", result);
	}


	@Test
	public void testSetAuditDetails_1()
		throws Exception {
		Employee fixture = new Employee(new Long(1L), "", "", "", "", new Long(1L), new Boolean(true), "", new AuditDetails(), new User());
		AuditDetails auditDetails = new AuditDetails();

		fixture.setAuditDetails(auditDetails);

	
	}

	
	@Test
	public void testSetCode_1()
		throws Exception {
		Employee fixture = new Employee(new Long(1L), "", "", "", "", new Long(1L), new Boolean(true), "", new AuditDetails(), new User());
		String code = "";

		fixture.setCode(code);

		
	}

	
	@Test
	public void testSetDateOfAppointment_1()
		throws Exception {
		Employee fixture = new Employee(new Long(1L), "", "", "", "", new Long(1L), new Boolean(true), "", new AuditDetails(), new User());
		Long dateOfAppointment = new Long(1L);

		fixture.setDateOfAppointment(dateOfAppointment);

	}

	@Test
	public void testSetEmployeeStatus_1()
		throws Exception {
		Employee fixture = new Employee(new Long(1L), "", "", "", "", new Long(1L), new Boolean(true), "", new AuditDetails(), new User());
		String employeeStatus = "";

		fixture.setEmployeeStatus(employeeStatus);

	
	}

	
	@Test
	public void testSetEmployeeType_1()
		throws Exception {
		Employee fixture = new Employee(new Long(1L), "", "", "", "", new Long(1L), new Boolean(true), "", new AuditDetails(), new User());
		String employeeType = "";

		fixture.setEmployeeType(employeeType);

	}

	
	@Test
	public void testSetId_1()
		throws Exception {
		Employee fixture = new Employee(new Long(1L), "", "", "", "", new Long(1L), new Boolean(true), "", new AuditDetails(), new User());
		Long id = new Long(1L);

		fixture.setId(id);

	}

	@Test
	public void testSetIsActive_1()
		throws Exception {
		Employee fixture = new Employee(new Long(1L), "", "", "", "", new Long(1L), new Boolean(true), "", new AuditDetails(), new User());
		Boolean IsActive = new Boolean(true);

		fixture.setIsActive(IsActive);

	}


	@Test
	public void testSetTenantId_1()
		throws Exception {
		Employee fixture = new Employee(new Long(1L), "", "", "", "", new Long(1L), new Boolean(true), "", new AuditDetails(), new User());
		String tenantId = "";

		fixture.setTenantId(tenantId);

		
	}

	
	@Test
	public void testSetUser_1()
		throws Exception {
		Employee fixture = new Employee(new Long(1L), "", "", "", "", new Long(1L), new Boolean(true), "", new AuditDetails(), new User());
		User user = new User();

		fixture.setUser(user);

		
	}

	
	@Test
	public void testSetUuid_1()
		throws Exception {
		Employee fixture = new Employee(new Long(1L), "", "", "", "", new Long(1L), new Boolean(true), "", new AuditDetails(), new User());
		String uuid = "";

		fixture.setUuid(uuid);

		
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
		new org.junit.runner.JUnitCore().run(EmployeeTest.class);
	}
}