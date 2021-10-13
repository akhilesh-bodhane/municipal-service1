package org.egov.prscp.web.models.user;

import org.egov.common.contract.request.RequestInfo;
import org.egov.prscp.web.models.OwnerInfo;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * The class <code>CreateUserRequestTest</code> contains tests for the class <code>{@link CreateUserRequest}</code>.
 *
 * @generatedBy CodePro at 25/5/20 3:54 PM
 * @author Aniket.Marathe
 * @version $Revision: 1.0 $
 */
public class CreateUserRequestTest {
	/**
	 * Run the CreateUserRequest() constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:54 PM
	 */
	@Test
	public void testCreateUserRequest_1()
		throws Exception {

		CreateUserRequest result = new CreateUserRequest();

		// add additional test code here
		assertNotNull(result);
		assertEquals(null, result.getUser());
		assertEquals(null, result.getRequestInfo());
	}

	/**
	 * Run the CreateUserRequest(RequestInfo,OwnerInfo) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:54 PM
	 */
	@Test
	public void testCreateUserRequest_2()
		throws Exception {
		RequestInfo requestInfo = new RequestInfo();
		OwnerInfo user = new OwnerInfo();

		CreateUserRequest result = new CreateUserRequest(requestInfo, user);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the RequestInfo getRequestInfo() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:54 PM
	 */
	@Test
	public void testGetRequestInfo_1()
		throws Exception {
		CreateUserRequest fixture = new CreateUserRequest(new RequestInfo(), new OwnerInfo());

		RequestInfo result = fixture.getRequestInfo();

		// add additional test code here
		assertNotNull(result);
		assertEquals("RequestInfo(apiId=null, ver=null, ts=null, action=null, did=null, key=null, msgId=null, authToken=null, correlationId=null, userInfo=null)", result.toString());
		assertEquals(null, result.getKey());
		assertEquals(null, result.getUserInfo());
		assertEquals(null, result.getAction());
		assertEquals(null, result.getMsgId());
		assertEquals(null, result.getVer());
		assertEquals(null, result.getApiId());
		assertEquals(null, result.getTs());
		assertEquals(null, result.getDid());
		assertEquals(null, result.getAuthToken());
		assertEquals(null, result.getCorrelationId());
	}

	/**
	 * Run the OwnerInfo getUser() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:54 PM
	 */
	@Test
	public void testGetUser_1()
		throws Exception {
		CreateUserRequest fixture = new CreateUserRequest(new RequestInfo(), new OwnerInfo());

		OwnerInfo result = fixture.getUser();

		// add additional test code here
		assertNotNull(result);
		assertEquals(null, result.getOwnerType());
		assertEquals(null, result.getRelationship());
		assertEquals(null, result.getDocuments());
		assertEquals(null, result.getInstitutionId());
		assertEquals(null, result.getUserActive());
		assertEquals(null, result.getIsPrimaryOwner());
		assertEquals(null, result.getOwnerShipPercentage());
	//	assertEquals("User(id=null, uuid=null, userName=null, password=null, salutation=null, name=null, gender=null, mobileNumber=null, emailId=null, altContactNumber=null, pan=null, aadhaarNumber=null, permanentAddress=null, permanentCity=null, permanentPincode=null, correspondenceCity=null, correspondencePincode=null, correspondenceAddress=null, active=null, dob=null, pwdExpiryDate=null, locale=null, type=null, signature=null, accountLocked=null, roles=null, fatherOrHusbandName=null, bloodGroup=null, identificationMark=null, photo=null, createdBy=null, createdDate=null, lastModifiedBy=null, lastModifiedDate=null, otpReference=null, tenantId=null)", result.toString());
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
		assertEquals(null, result.getEmailId());
		assertEquals(null, result.getMobileNumber());
		assertEquals(null, result.getTenantId());
		assertEquals(null, result.getUuid());
		assertEquals(null, result.getPan());
		assertEquals(null, result.getAadhaarNumber());
		assertEquals(null, result.getBloodGroup());
		assertEquals(null, result.getAccountLocked());
		assertEquals(null, result.getPermanentCity());
		assertEquals(null, result.getCreatedBy());
		assertEquals(null, result.getPwdExpiryDate());
		assertEquals(null, result.getDob());
		assertEquals(null, result.getCreatedDate());
		assertEquals(null, result.getGender());
		assertEquals(null, result.getPhoto());
		assertEquals(null, result.getSalutation());
		assertEquals(null, result.getOtpReference());
		assertEquals(null, result.getCorrespondenceCity());
		assertEquals(null, result.getIdentificationMark());
		assertEquals(null, result.getAltContactNumber());
		assertEquals(null, result.getLastModifiedBy());
		assertEquals(null, result.getPermanentPincode());
		assertEquals(null, result.getPermanentAddress());
		assertEquals(null, result.getCorrespondenceAddress());
		assertEquals(null, result.getCorrespondencePincode());
		assertEquals(null, result.getFatherOrHusbandName());
	}

	/**
	 * Perform pre-test initialization.
	 *
	 * @throws Exception
	 *         if the initialization fails for some reason
	 *
	 * @generatedBy CodePro at 25/5/20 3:54 PM
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
	 * @generatedBy CodePro at 25/5/20 3:54 PM
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
	 * @generatedBy CodePro at 25/5/20 3:54 PM
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(CreateUserRequestTest.class);
	}
}