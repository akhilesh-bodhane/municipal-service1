package org.egov.prscp.web.models.user;

import java.util.List;
import org.easymock.EasyMock;
import org.egov.common.contract.response.ResponseInfo;
import org.egov.prscp.web.models.OwnerInfo;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * The class <code>UserDetailResponseTest</code> contains tests for the class <code>{@link UserDetailResponse}</code>.
 *
 * @generatedBy CodePro at 25/5/20 3:54 PM
 * @author Aniket.Marathe
 * @version $Revision: 1.0 $
 */
public class UserDetailResponseTest {
	/**
	 * Run the UserDetailResponse() constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:54 PM
	 */
	@Test
	public void testUserDetailResponse_1()
		throws Exception {

		UserDetailResponse result = new UserDetailResponse();

		// add additional test code here
		assertNotNull(result);
		assertEquals(null, result.getUser());
		assertEquals(null, result.getResponseInfo());
	}

	/**
	 * Run the UserDetailResponse(ResponseInfo,List<OwnerInfo>) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:54 PM
	 */
	@Test
	public void testUserDetailResponse_2()
		throws Exception {
		ResponseInfo responseInfo = new ResponseInfo();
		List<OwnerInfo> user = EasyMock.createMock(List.class);
		// add mock object expectations here

		EasyMock.replay(user);

		UserDetailResponse result = new UserDetailResponse(responseInfo, user);

		// add additional test code here
		EasyMock.verify(user);
		assertNotNull(result);
	}

	/**
	 * Run the ResponseInfo getResponseInfo() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:54 PM
	 */
	@Test
	public void testGetResponseInfo_1()
		throws Exception {
		UserDetailResponse fixture = new UserDetailResponse(new ResponseInfo(), EasyMock.createNiceMock(List.class));

		ResponseInfo result = fixture.getResponseInfo();

		// add additional test code here
		assertNotNull(result);
		assertEquals("ResponseInfo(apiId=null, ver=null, ts=null, resMsgId=null, msgId=null, status=null)", result.toString());
		assertEquals(null, result.getStatus());
		assertEquals(null, result.getMsgId());
		assertEquals(null, result.getVer());
		assertEquals(null, result.getApiId());
		assertEquals(null, result.getTs());
		assertEquals(null, result.getResMsgId());
	}

	/**
	 * Run the List<OwnerInfo> getUser() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:54 PM
	 */
	@Test
	public void testGetUser_1()
		throws Exception {
		UserDetailResponse fixture = new UserDetailResponse(new ResponseInfo(), EasyMock.createNiceMock(List.class));

		List<OwnerInfo> result = fixture.getUser();

		// add additional test code here
		assertNotNull(result);
		assertEquals(0, result.size());
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
		new org.junit.runner.JUnitCore().run(UserDetailResponseTest.class);
	}
}