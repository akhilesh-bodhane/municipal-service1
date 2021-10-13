package org.egov.prscp.web.models;

import java.util.List;
import org.easymock.EasyMock;
import org.egov.common.contract.response.ResponseInfo;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * The class <code>PrResponseTest</code> contains tests for the class <code>{@link PrResponse}</code>.
 *
 * @generatedBy CodePro at 25/5/20 3:50 PM
 * @author Aniket.Marathe
 * @version $Revision: 1.0 $
 */
public class PrResponseTest {
	/**
	 * Run the PrResponse() constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:50 PM
	 */
	@Test
	public void testPrResponse_1()
		throws Exception {

		PrResponse result = new PrResponse();

		// add additional test code here
		assertNotNull(result);
		assertEquals(null, result.getEvents());
		assertEquals(null, result.getResponseInfo());
		assertEquals(null, result.getNotifyGuest());
	}

	/**
	 * Run the PrResponse(ResponseInfo,List<PublicRelationEvent>,List<NotifyGuest>) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:50 PM
	 */
	@Test
	public void testPrResponse_2()
		throws Exception {
		ResponseInfo responseInfo = new ResponseInfo();
		List<PublicRelationEvent> events = EasyMock.createMock(List.class);
		List<NotifyGuest> notifyGuest = EasyMock.createMock(List.class);
		// add mock object expectations here

		EasyMock.replay(events);
		EasyMock.replay(notifyGuest);

		PrResponse result = new PrResponse(responseInfo, events, notifyGuest);

		// add additional test code here
		EasyMock.verify(events);
		EasyMock.verify(notifyGuest);
		assertNotNull(result);
	}

	/**
	 * Run the PrResponse.PrResponseBuilder builder() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:50 PM
	 */
	@Test
	public void testBuilder_1()
		throws Exception {

		PrResponse.PrResponseBuilder result = PrResponse.builder();

		// add additional test code here
		assertNotNull(result);
		assertEquals("PrResponse.PrResponseBuilder(responseInfo=null, events=null, notifyGuest=null)", result.toString());
	}

	/**
	 * Run the List<PublicRelationEvent> getEvents() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:50 PM
	 */
	@Test
	public void testGetEvents_1()
		throws Exception {
		PrResponse fixture = new PrResponse(new ResponseInfo(), EasyMock.createNiceMock(List.class), EasyMock.createNiceMock(List.class));

		List<PublicRelationEvent> result = fixture.getEvents();

		// add additional test code here
		assertNotNull(result);
		assertEquals(0, result.size());
	}

	/**
	 * Run the List<NotifyGuest> getNotifyGuest() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:50 PM
	 */
	@Test
	public void testGetNotifyGuest_1()
		throws Exception {
		PrResponse fixture = new PrResponse(new ResponseInfo(), EasyMock.createNiceMock(List.class), EasyMock.createNiceMock(List.class));

		List<NotifyGuest> result = fixture.getNotifyGuest();

		// add additional test code here
		assertNotNull(result);
		assertEquals(0, result.size());
	}

	/**
	 * Run the ResponseInfo getResponseInfo() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:50 PM
	 */
	@Test
	public void testGetResponseInfo_1()
		throws Exception {
		PrResponse fixture = new PrResponse(new ResponseInfo(), EasyMock.createNiceMock(List.class), EasyMock.createNiceMock(List.class));

		ResponseInfo result = fixture.getResponseInfo();

		// add additional test code here
		assertNotNull(result);
		assertEquals("ResponseInfo(apiId=null, ver=null, ts=null, resMsgId=null, msgId=null, status=null)", result.toString());
		assertEquals(null, result.getStatus());
		assertEquals(null, result.getApiId());
		assertEquals(null, result.getVer());
		assertEquals(null, result.getTs());
		assertEquals(null, result.getResMsgId());
		assertEquals(null, result.getMsgId());
	}

	/**
	 * Run the void setEvents(List<PublicRelationEvent>) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:50 PM
	 */
	@Test
	public void testSetEvents_1()
		throws Exception {
		PrResponse fixture = new PrResponse(new ResponseInfo(), EasyMock.createNiceMock(List.class), EasyMock.createNiceMock(List.class));
		List<PublicRelationEvent> events = EasyMock.createMock(List.class);
		// add mock object expectations here

		EasyMock.replay(events);

		fixture.setEvents(events);

		// add additional test code here
		EasyMock.verify(events);
	}

	/**
	 * Run the void setNotifyGuest(List<NotifyGuest>) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:50 PM
	 */
	@Test
	public void testSetNotifyGuest_1()
		throws Exception {
		PrResponse fixture = new PrResponse(new ResponseInfo(), EasyMock.createNiceMock(List.class), EasyMock.createNiceMock(List.class));
		List<NotifyGuest> notifyGuest = EasyMock.createMock(List.class);
		// add mock object expectations here

		EasyMock.replay(notifyGuest);

		fixture.setNotifyGuest(notifyGuest);

		// add additional test code here
		EasyMock.verify(notifyGuest);
	}

	/**
	 * Run the void setResponseInfo(ResponseInfo) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:50 PM
	 */
	@Test
	public void testSetResponseInfo_1()
		throws Exception {
		PrResponse fixture = new PrResponse(new ResponseInfo(), EasyMock.createNiceMock(List.class), EasyMock.createNiceMock(List.class));
		ResponseInfo responseInfo = new ResponseInfo();

		fixture.setResponseInfo(responseInfo);

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
		new org.junit.runner.JUnitCore().run(PrResponseTest.class);
	}
}