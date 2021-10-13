package org.egov.ec.web.models.Idgen;

import java.util.List;
import org.egov.common.contract.response.ResponseInfo;
import org.egov.ec.web.models.Idgen.IdGenerationResponse;
import org.egov.ec.web.models.Idgen.IdResponse;
import org.egov.ec.web.models.workflow.State;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * The class <code>IdGenerationResponseTest</code> contains tests for the class <code>{@link IdGenerationResponse}</code>.
 *
 * @generatedBy CodePro at 17/5/20 2:08 PM
 * @author Aniket.Marathe
 * @version $Revision: 1.0 $
 */
public class IdGenerationResponseTest {
	/**
	 * Run the IdGenerationResponse() constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 17/5/20 2:08 PM
	 */
	@Test
	public void testIdGenerationResponse_1()
		throws Exception {

		IdGenerationResponse result = new IdGenerationResponse();

		
		assertNotNull(result);
		assertEquals("IdGenerationResponse(responseInfo=null, idResponses=null)", result.toString());
		assertEquals(null, result.getIdResponses());
		assertEquals(null, result.getResponseInfo());
	}

	/**
	 * Run the IdGenerationResponse(ResponseInfo,List<IdResponse>) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 17/5/20 2:08 PM
	 */
	@Test
	public void testIdGenerationResponse_2()
		throws Exception {
		ResponseInfo responseInfo = new ResponseInfo();
		List<IdResponse> idResponses = null;

		IdGenerationResponse result = new IdGenerationResponse(responseInfo, idResponses);

		assertNotNull(result);
		assertEquals("IdGenerationResponse(responseInfo=ResponseInfo(apiId=null, ver=null, ts=null, resMsgId=null, msgId=null, status=null), idResponses=null)", result.toString());
	}

	/**
	 * Run the IdGenerationResponse.IdGenerationResponseBuilder builder() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 17/5/20 2:08 PM
	 */
	@Test
	public void testBuilder_1()
		throws Exception {

		IdGenerationResponse.IdGenerationResponseBuilder result = IdGenerationResponse.builder();

		
		assertNotNull(result);
		assertEquals("IdGenerationResponse.IdGenerationResponseBuilder(responseInfo=null, idResponses=null)", result.toString());
	}
	
	@Test
	public void testBuilder_2()
		throws Exception {

		IdGenerationResponse.IdGenerationResponseBuilder builder = IdGenerationResponse.builder();
		builder.responseInfo(null);
		builder.idResponses(null);
		builder.build();
		
		IdGenerationResponse.IdGenerationResponseBuilder builder2 = IdGenerationResponse.builder();
		builder2.responseInfo(null);
		builder2.idResponses(null);
		builder2.build();
		
		Assert.assertEquals(builder2.toString(), builder.toString());
		
	}

	/**
	 * Run the boolean canEqual(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 17/5/20 2:08 PM
	 */
	@Test
	public void testCanEqual_1()
		throws Exception {
		IdGenerationResponse fixture = new IdGenerationResponse(new ResponseInfo(), null);
		Object other = new Object();

		boolean result = fixture.canEqual(other);
		assertEquals(false, result);
	}

	/**
	 * Run the boolean canEqual(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 17/5/20 2:08 PM
	 */
	@Test
	public void testCanEqual_2()
		throws Exception {
		IdGenerationResponse fixture = new IdGenerationResponse(new ResponseInfo(), null);
		Object other = new Object();

		boolean result = fixture.canEqual(other);

		
		assertEquals(false, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 17/5/20 2:08 PM
	 */
	@Test
	public void testEquals_2()
		throws Exception {
		IdGenerationResponse fixture = new IdGenerationResponse(new ResponseInfo(), null);
		Object o = new Object();

		boolean result = fixture.equals(o);

		
		assertEquals(false, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 17/5/20 2:08 PM
	 */
	@Test
	public void testEquals_6()
		throws Exception {
		IdGenerationResponse fixture = new IdGenerationResponse(new ResponseInfo(), (List<IdResponse>) null);
		Object o = new IdGenerationResponse(new ResponseInfo(), (List<IdResponse>) null);

		boolean result = fixture.equals(o);

		
		assertEquals(true, result);
	}
	
	@Test
	public void testEqualsObject() {
		IdGenerationResponse state1=new IdGenerationResponse();
		IdGenerationResponse state2=new IdGenerationResponse();
		Assert.assertEquals(state1,state2);
	}

	/**
	 * Run the List<IdResponse> getIdResponses() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 17/5/20 2:08 PM
	 */
	@Test
	public void testGetIdResponses_1()
		throws Exception {
		IdGenerationResponse fixture = new IdGenerationResponse(new ResponseInfo(), null);

		List<IdResponse> result = fixture.getIdResponses();
		assertEquals(null, result);
	}

	/**
	 * Run the ResponseInfo getResponseInfo() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 17/5/20 2:08 PM
	 */
	@Test
	public void testGetResponseInfo_1()
		throws Exception {
		IdGenerationResponse fixture = new IdGenerationResponse(new ResponseInfo(), null);

		ResponseInfo result = fixture.getResponseInfo();

		
		assertNotNull(result);
		assertEquals("ResponseInfo(apiId=null, ver=null, ts=null, resMsgId=null, msgId=null, status=null)", result.toString());
		assertEquals(null, result.getStatus());
		assertEquals(null, result.getResMsgId());
		assertEquals(null, result.getApiId());
		assertEquals(null, result.getTs());
		assertEquals(null, result.getVer());
		assertEquals(null, result.getMsgId());
	}

	/**
	 * Run the int hashCode() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 17/5/20 2:08 PM
	 */
	@Test
	public void testHashCode_1()
		throws Exception {
		IdGenerationResponse fixture = new IdGenerationResponse((ResponseInfo) null, null);
		IdGenerationResponse fixture1= new IdGenerationResponse((ResponseInfo) null, null);
		int result = fixture.hashCode();		
		assertEquals(result, fixture1.hashCode());
	}

	/**
	 * Run the int hashCode() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 17/5/20 2:08 PM
	 */
	@Test
	public void testHashCode_2()
		throws Exception {
		IdGenerationResponse fixture = new IdGenerationResponse(new ResponseInfo(), (List<IdResponse>) null);

		int result = fixture.hashCode();

		
		assertEquals(64208139, result);
	}

	/**
	 * Run the void setIdResponses(List<IdResponse>) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 17/5/20 2:08 PM
	 */
	@Test
	public void testSetIdResponses_1()
		throws Exception {
		IdGenerationResponse fixture = new IdGenerationResponse(new ResponseInfo(), null);
		List<IdResponse> idResponses = null;
		fixture.setIdResponses(idResponses);

	}

	/**
	 * Run the void setResponseInfo(ResponseInfo) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 17/5/20 2:08 PM
	 */
	@Test
	public void testSetResponseInfo_1()
		throws Exception {
		IdGenerationResponse fixture = new IdGenerationResponse(new ResponseInfo(), null);
		ResponseInfo responseInfo = new ResponseInfo();

		fixture.setResponseInfo(responseInfo);

		
	}
}