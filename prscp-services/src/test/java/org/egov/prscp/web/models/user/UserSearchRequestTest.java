package org.egov.prscp.web.models.user;

import java.util.List;
import org.easymock.EasyMock;
import org.egov.common.contract.request.RequestInfo;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * The class <code>UserSearchRequestTest</code> contains tests for the class <code>{@link UserSearchRequest}</code>.
 *
 * @generatedBy CodePro at 25/5/20 3:54 PM
 * @author Aniket.Marathe
 * @version $Revision: 1.0 $
 */
public class UserSearchRequestTest {
	/**
	 * Run the UserSearchRequest() constructor test.
	 *
	 * @generatedBy CodePro at 25/5/20 3:54 PM
	 */
	@Test
	public void testUserSearchRequest_1()
		throws Exception {
		UserSearchRequest result = new UserSearchRequest();
		assertNotNull(result);
		// add additional test code here
	}

	/**
	 * Run the String getAadhaarNumber() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:54 PM
	 */
	@Test
	public void testGetAadhaarNumber_1()
		throws Exception {
		UserSearchRequest fixture = new UserSearchRequest();
		fixture.setPan("");
		fixture.setName("");
		fixture.setUserType("");
		fixture.setPageNumber(1);
		fixture.setMobileNumber("");
		fixture.setRequestInfo(new RequestInfo());
		fixture.setActive(new Boolean(true));
		fixture.setTenantId("");
		fixture.setEmailId("");
		fixture.setRoleCodes(EasyMock.createNiceMock(List.class));
		fixture.setAadhaarNumber("");
		fixture.setUserName("");
		fixture.setFuzzyLogic(true);
		fixture.setUuid(EasyMock.createNiceMock(List.class));
		fixture.setSort(EasyMock.createNiceMock(List.class));
		fixture.setId(EasyMock.createNiceMock(List.class));
		fixture.setPageSize(1);

		String result = fixture.getAadhaarNumber();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the Boolean getActive() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:54 PM
	 */
	@Test
	public void testGetActive_1()
		throws Exception {
		UserSearchRequest fixture = new UserSearchRequest();
		fixture.setPan("");
		fixture.setName("");
		fixture.setUserType("");
		fixture.setPageNumber(1);
		fixture.setMobileNumber("");
		fixture.setRequestInfo(new RequestInfo());
		fixture.setActive(new Boolean(true));
		fixture.setTenantId("");
		fixture.setEmailId("");
		fixture.setRoleCodes(EasyMock.createNiceMock(List.class));
		fixture.setAadhaarNumber("");
		fixture.setUserName("");
		fixture.setFuzzyLogic(true);
		fixture.setUuid(EasyMock.createNiceMock(List.class));
		fixture.setSort(EasyMock.createNiceMock(List.class));
		fixture.setId(EasyMock.createNiceMock(List.class));
		fixture.setPageSize(1);

		Boolean result = fixture.getActive();

		// add additional test code here
		assertNotNull(result);
		assertEquals("true", result.toString());
		assertEquals(true, result.booleanValue());
	}

	/**
	 * Run the String getEmailId() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:54 PM
	 */
	@Test
	public void testGetEmailId_1()
		throws Exception {
		UserSearchRequest fixture = new UserSearchRequest();
		fixture.setPan("");
		fixture.setName("");
		fixture.setUserType("");
		fixture.setPageNumber(1);
		fixture.setMobileNumber("");
		fixture.setRequestInfo(new RequestInfo());
		fixture.setActive(new Boolean(true));
		fixture.setTenantId("");
		fixture.setEmailId("");
		fixture.setRoleCodes(EasyMock.createNiceMock(List.class));
		fixture.setAadhaarNumber("");
		fixture.setUserName("");
		fixture.setFuzzyLogic(true);
		fixture.setUuid(EasyMock.createNiceMock(List.class));
		fixture.setSort(EasyMock.createNiceMock(List.class));
		fixture.setId(EasyMock.createNiceMock(List.class));
		fixture.setPageSize(1);

		String result = fixture.getEmailId();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the List<String> getId() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:54 PM
	 */
	@Test
	public void testGetId_1()
		throws Exception {
		UserSearchRequest fixture = new UserSearchRequest();
		fixture.setPan("");
		fixture.setName("");
		fixture.setUserType("");
		fixture.setPageNumber(1);
		fixture.setMobileNumber("");
		fixture.setRequestInfo(new RequestInfo());
		fixture.setActive(new Boolean(true));
		fixture.setTenantId("");
		fixture.setEmailId("");
		fixture.setRoleCodes(EasyMock.createNiceMock(List.class));
		fixture.setAadhaarNumber("");
		fixture.setUserName("");
		fixture.setFuzzyLogic(true);
		fixture.setUuid(EasyMock.createNiceMock(List.class));
		fixture.setSort(EasyMock.createNiceMock(List.class));
		fixture.setId(EasyMock.createNiceMock(List.class));
		fixture.setPageSize(1);

		List<String> result = fixture.getId();

		// add additional test code here
		assertNotNull(result);
		assertEquals(0, result.size());
	}

	/**
	 * Run the String getMobileNumber() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:54 PM
	 */
	@Test
	public void testGetMobileNumber_1()
		throws Exception {
		UserSearchRequest fixture = new UserSearchRequest();
		fixture.setPan("");
		fixture.setName("");
		fixture.setUserType("");
		fixture.setPageNumber(1);
		fixture.setMobileNumber("");
		fixture.setRequestInfo(new RequestInfo());
		fixture.setActive(new Boolean(true));
		fixture.setTenantId("");
		fixture.setEmailId("");
		fixture.setRoleCodes(EasyMock.createNiceMock(List.class));
		fixture.setAadhaarNumber("");
		fixture.setUserName("");
		fixture.setFuzzyLogic(true);
		fixture.setUuid(EasyMock.createNiceMock(List.class));
		fixture.setSort(EasyMock.createNiceMock(List.class));
		fixture.setId(EasyMock.createNiceMock(List.class));
		fixture.setPageSize(1);

		String result = fixture.getMobileNumber();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the String getName() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:54 PM
	 */
	@Test
	public void testGetName_1()
		throws Exception {
		UserSearchRequest fixture = new UserSearchRequest();
		fixture.setPan("");
		fixture.setName("");
		fixture.setUserType("");
		fixture.setPageNumber(1);
		fixture.setMobileNumber("");
		fixture.setRequestInfo(new RequestInfo());
		fixture.setActive(new Boolean(true));
		fixture.setTenantId("");
		fixture.setEmailId("");
		fixture.setRoleCodes(EasyMock.createNiceMock(List.class));
		fixture.setAadhaarNumber("");
		fixture.setUserName("");
		fixture.setFuzzyLogic(true);
		fixture.setUuid(EasyMock.createNiceMock(List.class));
		fixture.setSort(EasyMock.createNiceMock(List.class));
		fixture.setId(EasyMock.createNiceMock(List.class));
		fixture.setPageSize(1);

		String result = fixture.getName();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the int getPageNumber() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:54 PM
	 */
	@Test
	public void testGetPageNumber_1()
		throws Exception {
		UserSearchRequest fixture = new UserSearchRequest();
		fixture.setPan("");
		fixture.setName("");
		fixture.setUserType("");
		fixture.setPageNumber(1);
		fixture.setMobileNumber("");
		fixture.setRequestInfo(new RequestInfo());
		fixture.setActive(new Boolean(true));
		fixture.setTenantId("");
		fixture.setEmailId("");
		fixture.setRoleCodes(EasyMock.createNiceMock(List.class));
		fixture.setAadhaarNumber("");
		fixture.setUserName("");
		fixture.setFuzzyLogic(true);
		fixture.setUuid(EasyMock.createNiceMock(List.class));
		fixture.setSort(EasyMock.createNiceMock(List.class));
		fixture.setId(EasyMock.createNiceMock(List.class));
		fixture.setPageSize(1);

		int result = fixture.getPageNumber();

		// add additional test code here
		assertEquals(1, result);
	}

	/**
	 * Run the int getPageSize() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:54 PM
	 */
	@Test
	public void testGetPageSize_1()
		throws Exception {
		UserSearchRequest fixture = new UserSearchRequest();
		fixture.setPan("");
		fixture.setName("");
		fixture.setUserType("");
		fixture.setPageNumber(1);
		fixture.setMobileNumber("");
		fixture.setRequestInfo(new RequestInfo());
		fixture.setActive(new Boolean(true));
		fixture.setTenantId("");
		fixture.setEmailId("");
		fixture.setRoleCodes(EasyMock.createNiceMock(List.class));
		fixture.setAadhaarNumber("");
		fixture.setUserName("");
		fixture.setFuzzyLogic(true);
		fixture.setUuid(EasyMock.createNiceMock(List.class));
		fixture.setSort(EasyMock.createNiceMock(List.class));
		fixture.setId(EasyMock.createNiceMock(List.class));
		fixture.setPageSize(1);

		int result = fixture.getPageSize();

		// add additional test code here
		assertEquals(1, result);
	}

	/**
	 * Run the String getPan() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:54 PM
	 */
	@Test
	public void testGetPan_1()
		throws Exception {
		UserSearchRequest fixture = new UserSearchRequest();
		fixture.setPan("");
		fixture.setName("");
		fixture.setUserType("");
		fixture.setPageNumber(1);
		fixture.setMobileNumber("");
		fixture.setRequestInfo(new RequestInfo());
		fixture.setActive(new Boolean(true));
		fixture.setTenantId("");
		fixture.setEmailId("");
		fixture.setRoleCodes(EasyMock.createNiceMock(List.class));
		fixture.setAadhaarNumber("");
		fixture.setUserName("");
		fixture.setFuzzyLogic(true);
		fixture.setUuid(EasyMock.createNiceMock(List.class));
		fixture.setSort(EasyMock.createNiceMock(List.class));
		fixture.setId(EasyMock.createNiceMock(List.class));
		fixture.setPageSize(1);

		String result = fixture.getPan();

		// add additional test code here
		assertEquals("", result);
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
		UserSearchRequest fixture = new UserSearchRequest();
		fixture.setPan("");
		fixture.setName("");
		fixture.setUserType("");
		fixture.setPageNumber(1);
		fixture.setMobileNumber("");
		fixture.setRequestInfo(new RequestInfo());
		fixture.setActive(new Boolean(true));
		fixture.setTenantId("");
		fixture.setEmailId("");
		fixture.setRoleCodes(EasyMock.createNiceMock(List.class));
		fixture.setAadhaarNumber("");
		fixture.setUserName("");
		fixture.setFuzzyLogic(true);
		fixture.setUuid(EasyMock.createNiceMock(List.class));
		fixture.setSort(EasyMock.createNiceMock(List.class));
		fixture.setId(EasyMock.createNiceMock(List.class));
		fixture.setPageSize(1);

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
	 * Run the List<String> getRoleCodes() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:54 PM
	 */
	@Test
	public void testGetRoleCodes_1()
		throws Exception {
		UserSearchRequest fixture = new UserSearchRequest();
		fixture.setPan("");
		fixture.setName("");
		fixture.setUserType("");
		fixture.setPageNumber(1);
		fixture.setMobileNumber("");
		fixture.setRequestInfo(new RequestInfo());
		fixture.setActive(new Boolean(true));
		fixture.setTenantId("");
		fixture.setEmailId("");
		fixture.setRoleCodes(EasyMock.createNiceMock(List.class));
		fixture.setAadhaarNumber("");
		fixture.setUserName("");
		fixture.setFuzzyLogic(true);
		fixture.setUuid(EasyMock.createNiceMock(List.class));
		fixture.setSort(EasyMock.createNiceMock(List.class));
		fixture.setId(EasyMock.createNiceMock(List.class));
		fixture.setPageSize(1);

		List<String> result = fixture.getRoleCodes();

		// add additional test code here
		assertNotNull(result);
		assertEquals(0, result.size());
	}

	/**
	 * Run the List<String> getSort() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:54 PM
	 */
	@Test
	public void testGetSort_1()
		throws Exception {
		UserSearchRequest fixture = new UserSearchRequest();
		fixture.setPan("");
		fixture.setName("");
		fixture.setUserType("");
		fixture.setPageNumber(1);
		fixture.setMobileNumber("");
		fixture.setRequestInfo(new RequestInfo());
		fixture.setActive(new Boolean(true));
		fixture.setTenantId("");
		fixture.setEmailId("");
		fixture.setRoleCodes(EasyMock.createNiceMock(List.class));
		fixture.setAadhaarNumber("");
		fixture.setUserName("");
		fixture.setFuzzyLogic(true);
		fixture.setUuid(EasyMock.createNiceMock(List.class));
		fixture.setSort(EasyMock.createNiceMock(List.class));
		fixture.setId(EasyMock.createNiceMock(List.class));
		fixture.setPageSize(1);

		List<String> result = fixture.getSort();

		// add additional test code here
		assertNotNull(result);
		assertEquals(0, result.size());
	}

	/**
	 * Run the String getTenantId() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:54 PM
	 */
	@Test
	public void testGetTenantId_1()
		throws Exception {
		UserSearchRequest fixture = new UserSearchRequest();
		fixture.setPan("");
		fixture.setName("");
		fixture.setUserType("");
		fixture.setPageNumber(1);
		fixture.setMobileNumber("");
		fixture.setRequestInfo(new RequestInfo());
		fixture.setActive(new Boolean(true));
		fixture.setTenantId("");
		fixture.setEmailId("");
		fixture.setRoleCodes(EasyMock.createNiceMock(List.class));
		fixture.setAadhaarNumber("");
		fixture.setUserName("");
		fixture.setFuzzyLogic(true);
		fixture.setUuid(EasyMock.createNiceMock(List.class));
		fixture.setSort(EasyMock.createNiceMock(List.class));
		fixture.setId(EasyMock.createNiceMock(List.class));
		fixture.setPageSize(1);

		String result = fixture.getTenantId();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the String getUserName() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:54 PM
	 */
	@Test
	public void testGetUserName_1()
		throws Exception {
		UserSearchRequest fixture = new UserSearchRequest();
		fixture.setPan("");
		fixture.setName("");
		fixture.setUserType("");
		fixture.setPageNumber(1);
		fixture.setMobileNumber("");
		fixture.setRequestInfo(new RequestInfo());
		fixture.setActive(new Boolean(true));
		fixture.setTenantId("");
		fixture.setEmailId("");
		fixture.setRoleCodes(EasyMock.createNiceMock(List.class));
		fixture.setAadhaarNumber("");
		fixture.setUserName("");
		fixture.setFuzzyLogic(true);
		fixture.setUuid(EasyMock.createNiceMock(List.class));
		fixture.setSort(EasyMock.createNiceMock(List.class));
		fixture.setId(EasyMock.createNiceMock(List.class));
		fixture.setPageSize(1);

		String result = fixture.getUserName();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the String getUserType() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:54 PM
	 */
	@Test
	public void testGetUserType_1()
		throws Exception {
		UserSearchRequest fixture = new UserSearchRequest();
		fixture.setPan("");
		fixture.setName("");
		fixture.setUserType("");
		fixture.setPageNumber(1);
		fixture.setMobileNumber("");
		fixture.setRequestInfo(new RequestInfo());
		fixture.setActive(new Boolean(true));
		fixture.setTenantId("");
		fixture.setEmailId("");
		fixture.setRoleCodes(EasyMock.createNiceMock(List.class));
		fixture.setAadhaarNumber("");
		fixture.setUserName("");
		fixture.setFuzzyLogic(true);
		fixture.setUuid(EasyMock.createNiceMock(List.class));
		fixture.setSort(EasyMock.createNiceMock(List.class));
		fixture.setId(EasyMock.createNiceMock(List.class));
		fixture.setPageSize(1);

		String result = fixture.getUserType();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the List<String> getUuid() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:54 PM
	 */
	@Test
	public void testGetUuid_1()
		throws Exception {
		UserSearchRequest fixture = new UserSearchRequest();
		fixture.setPan("");
		fixture.setName("");
		fixture.setUserType("");
		fixture.setPageNumber(1);
		fixture.setMobileNumber("");
		fixture.setRequestInfo(new RequestInfo());
		fixture.setActive(new Boolean(true));
		fixture.setTenantId("");
		fixture.setEmailId("");
		fixture.setRoleCodes(EasyMock.createNiceMock(List.class));
		fixture.setAadhaarNumber("");
		fixture.setUserName("");
		fixture.setFuzzyLogic(true);
		fixture.setUuid(EasyMock.createNiceMock(List.class));
		fixture.setSort(EasyMock.createNiceMock(List.class));
		fixture.setId(EasyMock.createNiceMock(List.class));
		fixture.setPageSize(1);

		List<String> result = fixture.getUuid();

		// add additional test code here
		assertNotNull(result);
		assertEquals(0, result.size());
	}

	/**
	 * Run the boolean isFuzzyLogic() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:54 PM
	 */
	@Test
	public void testIsFuzzyLogic_1()
		throws Exception {
		UserSearchRequest fixture = new UserSearchRequest();
		fixture.setPan("");
		fixture.setName("");
		fixture.setUserType("");
		fixture.setPageNumber(1);
		fixture.setMobileNumber("");
		fixture.setRequestInfo(new RequestInfo());
		fixture.setActive(new Boolean(true));
		fixture.setTenantId("");
		fixture.setEmailId("");
		fixture.setRoleCodes(EasyMock.createNiceMock(List.class));
		fixture.setAadhaarNumber("");
		fixture.setUserName("");
		fixture.setFuzzyLogic(true);
		fixture.setUuid(EasyMock.createNiceMock(List.class));
		fixture.setSort(EasyMock.createNiceMock(List.class));
		fixture.setId(EasyMock.createNiceMock(List.class));
		fixture.setPageSize(1);

		boolean result = fixture.isFuzzyLogic();

		// add additional test code here
		assertEquals(true, result);
	}

	/**
	 * Run the boolean isFuzzyLogic() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:54 PM
	 */
	@Test
	public void testIsFuzzyLogic_2()
		throws Exception {
		UserSearchRequest fixture = new UserSearchRequest();
		fixture.setPan("");
		fixture.setName("");
		fixture.setUserType("");
		fixture.setPageNumber(1);
		fixture.setMobileNumber("");
		fixture.setRequestInfo(new RequestInfo());
		fixture.setActive(new Boolean(true));
		fixture.setTenantId("");
		fixture.setEmailId("");
		fixture.setRoleCodes(EasyMock.createNiceMock(List.class));
		fixture.setAadhaarNumber("");
		fixture.setUserName("");
		fixture.setFuzzyLogic(false);
		fixture.setUuid(EasyMock.createNiceMock(List.class));
		fixture.setSort(EasyMock.createNiceMock(List.class));
		fixture.setId(EasyMock.createNiceMock(List.class));
		fixture.setPageSize(1);

		boolean result = fixture.isFuzzyLogic();

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the void setAadhaarNumber(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:54 PM
	 */
	@Test
	public void testSetAadhaarNumber_1()
		throws Exception {
		UserSearchRequest fixture = new UserSearchRequest();
		fixture.setPan("");
		fixture.setName("");
		fixture.setUserType("");
		fixture.setPageNumber(1);
		fixture.setMobileNumber("");
		fixture.setRequestInfo(new RequestInfo());
		fixture.setActive(new Boolean(true));
		fixture.setTenantId("");
		fixture.setEmailId("");
		fixture.setRoleCodes(EasyMock.createNiceMock(List.class));
		fixture.setAadhaarNumber("");
		fixture.setUserName("");
		fixture.setFuzzyLogic(true);
		fixture.setUuid(EasyMock.createNiceMock(List.class));
		fixture.setSort(EasyMock.createNiceMock(List.class));
		fixture.setId(EasyMock.createNiceMock(List.class));
		fixture.setPageSize(1);
		String aadhaarNumber = "";

		fixture.setAadhaarNumber(aadhaarNumber);

		// add additional test code here
	}

	/**
	 * Run the void setActive(Boolean) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:54 PM
	 */
	@Test
	public void testSetActive_1()
		throws Exception {
		UserSearchRequest fixture = new UserSearchRequest();
		fixture.setPan("");
		fixture.setName("");
		fixture.setUserType("");
		fixture.setPageNumber(1);
		fixture.setMobileNumber("");
		fixture.setRequestInfo(new RequestInfo());
		fixture.setActive(new Boolean(true));
		fixture.setTenantId("");
		fixture.setEmailId("");
		fixture.setRoleCodes(EasyMock.createNiceMock(List.class));
		fixture.setAadhaarNumber("");
		fixture.setUserName("");
		fixture.setFuzzyLogic(true);
		fixture.setUuid(EasyMock.createNiceMock(List.class));
		fixture.setSort(EasyMock.createNiceMock(List.class));
		fixture.setId(EasyMock.createNiceMock(List.class));
		fixture.setPageSize(1);
		Boolean active = new Boolean(true);

		fixture.setActive(active);

		// add additional test code here
	}

	/**
	 * Run the void setEmailId(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:54 PM
	 */
	@Test
	public void testSetEmailId_1()
		throws Exception {
		UserSearchRequest fixture = new UserSearchRequest();
		fixture.setPan("");
		fixture.setName("");
		fixture.setUserType("");
		fixture.setPageNumber(1);
		fixture.setMobileNumber("");
		fixture.setRequestInfo(new RequestInfo());
		fixture.setActive(new Boolean(true));
		fixture.setTenantId("");
		fixture.setEmailId("");
		fixture.setRoleCodes(EasyMock.createNiceMock(List.class));
		fixture.setAadhaarNumber("");
		fixture.setUserName("");
		fixture.setFuzzyLogic(true);
		fixture.setUuid(EasyMock.createNiceMock(List.class));
		fixture.setSort(EasyMock.createNiceMock(List.class));
		fixture.setId(EasyMock.createNiceMock(List.class));
		fixture.setPageSize(1);
		String emailId = "";

		fixture.setEmailId(emailId);

		// add additional test code here
	}

	/**
	 * Run the void setFuzzyLogic(boolean) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:54 PM
	 */
	@Test
	public void testSetFuzzyLogic_1()
		throws Exception {
		UserSearchRequest fixture = new UserSearchRequest();
		fixture.setPan("");
		fixture.setName("");
		fixture.setUserType("");
		fixture.setPageNumber(1);
		fixture.setMobileNumber("");
		fixture.setRequestInfo(new RequestInfo());
		fixture.setActive(new Boolean(true));
		fixture.setTenantId("");
		fixture.setEmailId("");
		fixture.setRoleCodes(EasyMock.createNiceMock(List.class));
		fixture.setAadhaarNumber("");
		fixture.setUserName("");
		fixture.setFuzzyLogic(true);
		fixture.setUuid(EasyMock.createNiceMock(List.class));
		fixture.setSort(EasyMock.createNiceMock(List.class));
		fixture.setId(EasyMock.createNiceMock(List.class));
		fixture.setPageSize(1);
		boolean fuzzyLogic = true;

		fixture.setFuzzyLogic(fuzzyLogic);

		// add additional test code here
	}

	/**
	 * Run the void setId(List<String>) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:54 PM
	 */
	@Test
	public void testSetId_1()
		throws Exception {
		UserSearchRequest fixture = new UserSearchRequest();
		fixture.setPan("");
		fixture.setName("");
		fixture.setUserType("");
		fixture.setPageNumber(1);
		fixture.setMobileNumber("");
		fixture.setRequestInfo(new RequestInfo());
		fixture.setActive(new Boolean(true));
		fixture.setTenantId("");
		fixture.setEmailId("");
		fixture.setRoleCodes(EasyMock.createNiceMock(List.class));
		fixture.setAadhaarNumber("");
		fixture.setUserName("");
		fixture.setFuzzyLogic(true);
		fixture.setUuid(EasyMock.createNiceMock(List.class));
		fixture.setSort(EasyMock.createNiceMock(List.class));
		fixture.setId(EasyMock.createNiceMock(List.class));
		fixture.setPageSize(1);
		List<String> id = EasyMock.createMock(List.class);
		// add mock object expectations here

		EasyMock.replay(id);

		fixture.setId(id);

		// add additional test code here
		EasyMock.verify(id);
	}

	/**
	 * Run the void setMobileNumber(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:54 PM
	 */
	@Test
	public void testSetMobileNumber_1()
		throws Exception {
		UserSearchRequest fixture = new UserSearchRequest();
		fixture.setPan("");
		fixture.setName("");
		fixture.setUserType("");
		fixture.setPageNumber(1);
		fixture.setMobileNumber("");
		fixture.setRequestInfo(new RequestInfo());
		fixture.setActive(new Boolean(true));
		fixture.setTenantId("");
		fixture.setEmailId("");
		fixture.setRoleCodes(EasyMock.createNiceMock(List.class));
		fixture.setAadhaarNumber("");
		fixture.setUserName("");
		fixture.setFuzzyLogic(true);
		fixture.setUuid(EasyMock.createNiceMock(List.class));
		fixture.setSort(EasyMock.createNiceMock(List.class));
		fixture.setId(EasyMock.createNiceMock(List.class));
		fixture.setPageSize(1);
		String mobileNumber = "";

		fixture.setMobileNumber(mobileNumber);

		// add additional test code here
	}

	/**
	 * Run the void setName(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:54 PM
	 */
	@Test
	public void testSetName_1()
		throws Exception {
		UserSearchRequest fixture = new UserSearchRequest();
		fixture.setPan("");
		fixture.setName("");
		fixture.setUserType("");
		fixture.setPageNumber(1);
		fixture.setMobileNumber("");
		fixture.setRequestInfo(new RequestInfo());
		fixture.setActive(new Boolean(true));
		fixture.setTenantId("");
		fixture.setEmailId("");
		fixture.setRoleCodes(EasyMock.createNiceMock(List.class));
		fixture.setAadhaarNumber("");
		fixture.setUserName("");
		fixture.setFuzzyLogic(true);
		fixture.setUuid(EasyMock.createNiceMock(List.class));
		fixture.setSort(EasyMock.createNiceMock(List.class));
		fixture.setId(EasyMock.createNiceMock(List.class));
		fixture.setPageSize(1);
		String name = "";

		fixture.setName(name);

		// add additional test code here
	}

	/**
	 * Run the void setPageNumber(int) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:54 PM
	 */
	@Test
	public void testSetPageNumber_1()
		throws Exception {
		UserSearchRequest fixture = new UserSearchRequest();
		fixture.setPan("");
		fixture.setName("");
		fixture.setUserType("");
		fixture.setPageNumber(1);
		fixture.setMobileNumber("");
		fixture.setRequestInfo(new RequestInfo());
		fixture.setActive(new Boolean(true));
		fixture.setTenantId("");
		fixture.setEmailId("");
		fixture.setRoleCodes(EasyMock.createNiceMock(List.class));
		fixture.setAadhaarNumber("");
		fixture.setUserName("");
		fixture.setFuzzyLogic(true);
		fixture.setUuid(EasyMock.createNiceMock(List.class));
		fixture.setSort(EasyMock.createNiceMock(List.class));
		fixture.setId(EasyMock.createNiceMock(List.class));
		fixture.setPageSize(1);
		int pageNumber = 1;

		fixture.setPageNumber(pageNumber);

		// add additional test code here
	}

	/**
	 * Run the void setPageSize(int) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:54 PM
	 */
	@Test
	public void testSetPageSize_1()
		throws Exception {
		UserSearchRequest fixture = new UserSearchRequest();
		fixture.setPan("");
		fixture.setName("");
		fixture.setUserType("");
		fixture.setPageNumber(1);
		fixture.setMobileNumber("");
		fixture.setRequestInfo(new RequestInfo());
		fixture.setActive(new Boolean(true));
		fixture.setTenantId("");
		fixture.setEmailId("");
		fixture.setRoleCodes(EasyMock.createNiceMock(List.class));
		fixture.setAadhaarNumber("");
		fixture.setUserName("");
		fixture.setFuzzyLogic(true);
		fixture.setUuid(EasyMock.createNiceMock(List.class));
		fixture.setSort(EasyMock.createNiceMock(List.class));
		fixture.setId(EasyMock.createNiceMock(List.class));
		fixture.setPageSize(1);
		int pageSize = 1;

		fixture.setPageSize(pageSize);

		// add additional test code here
	}

	/**
	 * Run the void setPan(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:54 PM
	 */
	@Test
	public void testSetPan_1()
		throws Exception {
		UserSearchRequest fixture = new UserSearchRequest();
		fixture.setPan("");
		fixture.setName("");
		fixture.setUserType("");
		fixture.setPageNumber(1);
		fixture.setMobileNumber("");
		fixture.setRequestInfo(new RequestInfo());
		fixture.setActive(new Boolean(true));
		fixture.setTenantId("");
		fixture.setEmailId("");
		fixture.setRoleCodes(EasyMock.createNiceMock(List.class));
		fixture.setAadhaarNumber("");
		fixture.setUserName("");
		fixture.setFuzzyLogic(true);
		fixture.setUuid(EasyMock.createNiceMock(List.class));
		fixture.setSort(EasyMock.createNiceMock(List.class));
		fixture.setId(EasyMock.createNiceMock(List.class));
		fixture.setPageSize(1);
		String pan = "";

		fixture.setPan(pan);

		// add additional test code here
	}

	/**
	 * Run the void setRequestInfo(RequestInfo) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:54 PM
	 */
	@Test
	public void testSetRequestInfo_1()
		throws Exception {
		UserSearchRequest fixture = new UserSearchRequest();
		fixture.setPan("");
		fixture.setName("");
		fixture.setUserType("");
		fixture.setPageNumber(1);
		fixture.setMobileNumber("");
		fixture.setRequestInfo(new RequestInfo());
		fixture.setActive(new Boolean(true));
		fixture.setTenantId("");
		fixture.setEmailId("");
		fixture.setRoleCodes(EasyMock.createNiceMock(List.class));
		fixture.setAadhaarNumber("");
		fixture.setUserName("");
		fixture.setFuzzyLogic(true);
		fixture.setUuid(EasyMock.createNiceMock(List.class));
		fixture.setSort(EasyMock.createNiceMock(List.class));
		fixture.setId(EasyMock.createNiceMock(List.class));
		fixture.setPageSize(1);
		RequestInfo requestInfo = new RequestInfo();

		fixture.setRequestInfo(requestInfo);

		// add additional test code here
	}

	/**
	 * Run the void setRoleCodes(List<String>) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:54 PM
	 */
	@Test
	public void testSetRoleCodes_1()
		throws Exception {
		UserSearchRequest fixture = new UserSearchRequest();
		fixture.setPan("");
		fixture.setName("");
		fixture.setUserType("");
		fixture.setPageNumber(1);
		fixture.setMobileNumber("");
		fixture.setRequestInfo(new RequestInfo());
		fixture.setActive(new Boolean(true));
		fixture.setTenantId("");
		fixture.setEmailId("");
		fixture.setRoleCodes(EasyMock.createNiceMock(List.class));
		fixture.setAadhaarNumber("");
		fixture.setUserName("");
		fixture.setFuzzyLogic(true);
		fixture.setUuid(EasyMock.createNiceMock(List.class));
		fixture.setSort(EasyMock.createNiceMock(List.class));
		fixture.setId(EasyMock.createNiceMock(List.class));
		fixture.setPageSize(1);
		List<String> roleCodes = EasyMock.createMock(List.class);
		// add mock object expectations here

		EasyMock.replay(roleCodes);

		fixture.setRoleCodes(roleCodes);

		// add additional test code here
		EasyMock.verify(roleCodes);
	}

	/**
	 * Run the void setSort(List<String>) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:54 PM
	 */
	@Test
	public void testSetSort_1()
		throws Exception {
		UserSearchRequest fixture = new UserSearchRequest();
		fixture.setPan("");
		fixture.setName("");
		fixture.setUserType("");
		fixture.setPageNumber(1);
		fixture.setMobileNumber("");
		fixture.setRequestInfo(new RequestInfo());
		fixture.setActive(new Boolean(true));
		fixture.setTenantId("");
		fixture.setEmailId("");
		fixture.setRoleCodes(EasyMock.createNiceMock(List.class));
		fixture.setAadhaarNumber("");
		fixture.setUserName("");
		fixture.setFuzzyLogic(true);
		fixture.setUuid(EasyMock.createNiceMock(List.class));
		fixture.setSort(EasyMock.createNiceMock(List.class));
		fixture.setId(EasyMock.createNiceMock(List.class));
		fixture.setPageSize(1);
		List<String> sort = EasyMock.createMock(List.class);
		// add mock object expectations here

		EasyMock.replay(sort);

		fixture.setSort(sort);

		// add additional test code here
		EasyMock.verify(sort);
	}

	/**
	 * Run the void setTenantId(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:54 PM
	 */
	@Test
	public void testSetTenantId_1()
		throws Exception {
		UserSearchRequest fixture = new UserSearchRequest();
		fixture.setPan("");
		fixture.setName("");
		fixture.setUserType("");
		fixture.setPageNumber(1);
		fixture.setMobileNumber("");
		fixture.setRequestInfo(new RequestInfo());
		fixture.setActive(new Boolean(true));
		fixture.setTenantId("");
		fixture.setEmailId("");
		fixture.setRoleCodes(EasyMock.createNiceMock(List.class));
		fixture.setAadhaarNumber("");
		fixture.setUserName("");
		fixture.setFuzzyLogic(true);
		fixture.setUuid(EasyMock.createNiceMock(List.class));
		fixture.setSort(EasyMock.createNiceMock(List.class));
		fixture.setId(EasyMock.createNiceMock(List.class));
		fixture.setPageSize(1);
		String tenantId = "";

		fixture.setTenantId(tenantId);

		// add additional test code here
	}

	/**
	 * Run the void setUserName(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:54 PM
	 */
	@Test
	public void testSetUserName_1()
		throws Exception {
		UserSearchRequest fixture = new UserSearchRequest();
		fixture.setPan("");
		fixture.setName("");
		fixture.setUserType("");
		fixture.setPageNumber(1);
		fixture.setMobileNumber("");
		fixture.setRequestInfo(new RequestInfo());
		fixture.setActive(new Boolean(true));
		fixture.setTenantId("");
		fixture.setEmailId("");
		fixture.setRoleCodes(EasyMock.createNiceMock(List.class));
		fixture.setAadhaarNumber("");
		fixture.setUserName("");
		fixture.setFuzzyLogic(true);
		fixture.setUuid(EasyMock.createNiceMock(List.class));
		fixture.setSort(EasyMock.createNiceMock(List.class));
		fixture.setId(EasyMock.createNiceMock(List.class));
		fixture.setPageSize(1);
		String userName = "";

		fixture.setUserName(userName);

		// add additional test code here
	}

	/**
	 * Run the void setUserType(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:54 PM
	 */
	@Test
	public void testSetUserType_1()
		throws Exception {
		UserSearchRequest fixture = new UserSearchRequest();
		fixture.setPan("");
		fixture.setName("");
		fixture.setUserType("");
		fixture.setPageNumber(1);
		fixture.setMobileNumber("");
		fixture.setRequestInfo(new RequestInfo());
		fixture.setActive(new Boolean(true));
		fixture.setTenantId("");
		fixture.setEmailId("");
		fixture.setRoleCodes(EasyMock.createNiceMock(List.class));
		fixture.setAadhaarNumber("");
		fixture.setUserName("");
		fixture.setFuzzyLogic(true);
		fixture.setUuid(EasyMock.createNiceMock(List.class));
		fixture.setSort(EasyMock.createNiceMock(List.class));
		fixture.setId(EasyMock.createNiceMock(List.class));
		fixture.setPageSize(1);
		String userType = "";

		fixture.setUserType(userType);

		// add additional test code here
	}

	/**
	 * Run the void setUuid(List<String>) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:54 PM
	 */
	@Test
	public void testSetUuid_1()
		throws Exception {
		UserSearchRequest fixture = new UserSearchRequest();
		fixture.setPan("");
		fixture.setName("");
		fixture.setUserType("");
		fixture.setPageNumber(1);
		fixture.setMobileNumber("");
		fixture.setRequestInfo(new RequestInfo());
		fixture.setActive(new Boolean(true));
		fixture.setTenantId("");
		fixture.setEmailId("");
		fixture.setRoleCodes(EasyMock.createNiceMock(List.class));
		fixture.setAadhaarNumber("");
		fixture.setUserName("");
		fixture.setFuzzyLogic(true);
		fixture.setUuid(EasyMock.createNiceMock(List.class));
		fixture.setSort(EasyMock.createNiceMock(List.class));
		fixture.setId(EasyMock.createNiceMock(List.class));
		fixture.setPageSize(1);
		List<String> uuid = EasyMock.createMock(List.class);
		// add mock object expectations here

		EasyMock.replay(uuid);

		fixture.setUuid(uuid);

		// add additional test code here
		EasyMock.verify(uuid);
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
		new org.junit.runner.JUnitCore().run(UserSearchRequestTest.class);
	}
}