package org.egov.ec.web.models.workflow;

import java.util.List;
import org.egov.common.contract.response.ResponseInfo;
import org.egov.ec.web.models.workflow.BusinessService;
import org.egov.ec.web.models.workflow.BusinessServiceResponse;
import org.junit.*;
import org.mockito.InjectMocks;

import static org.junit.Assert.*;

/**
 * The class <code>BusinessServiceResponseTest</code> contains tests for the class <code>{@link BusinessServiceResponse}</code>.
 *
 *@generated at 17/5/20 2:09 PM
 * @version $Revision: 1.0 $
 */
public class BusinessServiceResponseTest {
	
	@InjectMocks
	private BusinessServiceResponse businessServiceResponse;
	/**
	 * Run the BusinessServiceResponse(ResponseInfo,List<BusinessService>) constructor test.
	 *
	 * @throws Exception
	 *
	 *@generated at 17/5/20 2:09 PM
	 */
	@Test
	public void testBusinessServiceResponse_1()
		throws Exception {
		ResponseInfo responseInfo = new ResponseInfo();
		List<BusinessService> businessServices = null;

		BusinessServiceResponse result = new BusinessServiceResponse(responseInfo, businessServices);

		// add additional test code here
		assertNotNull(result);
		assertEquals("BusinessServiceResponse(responseInfo=ResponseInfo(apiId=null, ver=null, ts=null, resMsgId=null, msgId=null, status=null), businessServices=null)", result.toString());
	}

	/**
	 * Run the BusinessServiceResponse addBusinessServiceItem(BusinessService) method test.
	 *
	 * @throws Exception
	 *
	 *@generated at 17/5/20 2:09 PM
	 */
	@Test
	public void testAddBusinessServiceItem_1()
		throws Exception {
		BusinessServiceResponse fixture = new BusinessServiceResponse(new ResponseInfo(), (List<BusinessService>) null);
		BusinessService businessServiceItem = null;

		BusinessServiceResponse result = fixture.addBusinessServiceItem(businessServiceItem);

		assertNotNull(result);
	}

	/**
	 * Run the BusinessServiceResponse.BusinessServiceResponseBuilder builder() method test.
	 *
	 * @throws Exception
	 *
	 *@generated at 17/5/20 2:09 PM
	 */
	@Test
	public void testBuilder_1()
		throws Exception {

		BusinessServiceResponse.BusinessServiceResponseBuilder result = BusinessServiceResponse.builder();

		// add additional test code here
		assertNotNull(result);
		assertEquals("BusinessServiceResponse.BusinessServiceResponseBuilder(responseInfo=null, businessServices=null)", result.toString());
	}
	
	@Test
	public void testBuilder_2()
		throws Exception {

		BusinessServiceResponse.BusinessServiceResponseBuilder builder1 = BusinessServiceResponse.builder();

		builder1.responseInfo(null);
		builder1.businessServices(null);
		builder1.build();
		BusinessServiceResponse.BusinessServiceResponseBuilder builder2 = BusinessServiceResponse.builder();
		builder2.responseInfo(null);
		builder2.businessServices(null);
		builder2.build();
		
		Assert.assertEquals(builder2.toString(), builder1.toString());
	}


	@Test
	public void testEqualsObject() {
		BusinessServiceResponse state1=new BusinessServiceResponse(null, null);
		BusinessServiceResponse state2=new BusinessServiceResponse(null, null);
		Assert.assertEquals(state1,state2);
	}

	/**
	 * Run the List<BusinessService> getBusinessServices() method test.
	 *
	 * @throws Exception
	 *
	 *@generated at 17/5/20 2:09 PM
	 */
	@Test
	public void testGetBusinessServices_1()
		throws Exception {
		BusinessServiceResponse fixture = new BusinessServiceResponse(new ResponseInfo(), null);
		List<BusinessService> result = null;
		assertEquals(null,result);
	}

	/**
	 * Run the ResponseInfo getResponseInfo() method test.
	 *
	 * @throws Exception
	 *
	 *@generated at 17/5/20 2:09 PM
	 */
	@Test
	public void testGetResponseInfo_1()
		throws Exception {
		BusinessServiceResponse fixture = new BusinessServiceResponse(new ResponseInfo(), null);

		ResponseInfo result = fixture.getResponseInfo();

		// add additional test code here
		assertNotNull(result);
		assertEquals("ResponseInfo(apiId=null, ver=null, ts=null, resMsgId=null, msgId=null, status=null)", result.toString());
		assertEquals(null, result.getStatus());
		assertEquals(null, result.getVer());
		assertEquals(null, result.getTs());
		assertEquals(null, result.getMsgId());
		assertEquals(null, result.getResMsgId());
		assertEquals(null, result.getApiId());
	}

	/**
	 * Run the int hashCode() method test.
	 *
	 * @throws Exception
	 *
	 *@generated at 17/5/20 2:09 PM
	 */
	@Test
	public void testHashCode_1()
		throws Exception {
		BusinessServiceResponse fixture = new BusinessServiceResponse((ResponseInfo) null, null);
		BusinessServiceResponse fixture2 = new BusinessServiceResponse((ResponseInfo) null, null);
		int result = fixture.hashCode();
		Assert.assertEquals(result, fixture2.hashCode());

	}

	/**
	 * Run the int hashCode() method test.
	 *
	 * @throws Exception
	 *
	 *@generated at 17/5/20 2:09 PM
	 */
	@Test
	public void testHashCode_2()
		throws Exception {
		BusinessServiceResponse fixture = new BusinessServiceResponse(new ResponseInfo(), (List<BusinessService>) null);

		int result = fixture.hashCode();

		// add additional test code here
		assertEquals(64208139, result);
	}

	/**
	 * Run the void setBusinessServices(List<BusinessService>) method test.
	 *
	 * @throws Exception
	 *
	 *@generated at 17/5/20 2:09 PM
	 */
	@Test
	public void testSetBusinessServices_1()
		throws Exception {
		BusinessServiceResponse fixture = new BusinessServiceResponse(new ResponseInfo(), null);
		List<BusinessService> businessServices = null;

		fixture.setBusinessServices(businessServices);
		
	}

	/**
	 * Run the void setResponseInfo(ResponseInfo) method test.
	 *
	 * @throws Exception
	 *
	 *@generated at 17/5/20 2:09 PM
	 */
	@Test
	public void testSetResponseInfo_1()
		throws Exception {
		BusinessServiceResponse fixture = new BusinessServiceResponse(new ResponseInfo(), null);
		ResponseInfo responseInfo = new ResponseInfo();

		fixture.setResponseInfo(responseInfo);

		// add additional test code here
	}
}