package org.egov.ec.web.models.workflow;

import java.util.List;

import org.egov.ec.web.models.AuditDetails;
import org.egov.ec.web.models.workflow.BusinessService;
import org.egov.ec.web.models.workflow.State;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * The class <code>BusinessServiceTest</code> contains tests for the class <code>{@link BusinessService}</code>.
 *
 * @generated at 17/5/20 2:10 PM
 * @version $Revision: 1.0 $
 */
public class BusinessServiceTest {
	/**
	 * Run the BusinessService() constructor test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:10 PM
	 */
	@Test
	public void testBusinessService_1()
		throws Exception {

		BusinessService result = new BusinessService();

		// add additional test code here
		assertNotNull(result);
		assertEquals("BusinessService(tenantId=null, uuid=null, businessService=null, business=null, getUri=null, postUri=null, businessServiceSla=null, states=null, auditDetails=null)", result.toString());
		assertEquals(null, result.getStates());
		assertEquals(null, result.getTenantId());
		assertEquals(null, result.getBusiness());
		assertEquals(null, result.getPostUri());
		assertEquals(null, result.getGetUri());
		assertEquals(null, result.getBusinessService());
		assertEquals(null, result.getBusinessServiceSla());
		assertEquals(null, result.getAuditDetails());
		assertEquals(null, result.getUuid());
	}

	/**
	 * Run the BusinessService(String,String,String,String,String,String,Long,List<State>,AuditDetails) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:10 PM
	 */
	@Test
	public void testBusinessService_2()
		throws Exception {
		String tenantId = "";
		String uuid = "";
		String businessService = "";
		String business = "";
		String getUri = "";
		String postUri = "";
		Long businessServiceSla = new Long(1L);
		List<State> states = null;
		AuditDetails auditDetails = null;

		BusinessService result = new BusinessService(tenantId, uuid, businessService, business, getUri, postUri, businessServiceSla, states, auditDetails);

		assertNotNull(result);
		assertEquals("BusinessService(tenantId=, uuid=, businessService=, business=, getUri=, postUri=, businessServiceSla=1, states=null, auditDetails=null)", result.toString());
		assertEquals("", result.getTenantId());
		assertEquals("", result.getBusiness());
		assertEquals("", result.getPostUri());
		assertEquals("", result.getGetUri());
		assertEquals("", result.getBusinessService());
		assertEquals(new Long(1L), result.getBusinessServiceSla());
		assertEquals("", result.getUuid());
	}

	/**
	 * Run the BusinessService addStatesItem(State) method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:10 PM
	 */
	@Test
	public void testAddStatesItem_1()
		throws Exception {
		BusinessService fixture = new BusinessService("", "", "", "", "", "", new Long(1L), (List<State>) null, null);
		State statesItem = new State();

		BusinessService result = fixture.addStatesItem(statesItem);

		// add additional test code here
		assertNotNull(result);
		assertEquals("BusinessService(tenantId=, uuid=, businessService=, business=, getUri=, postUri=, businessServiceSla=1, states=[State(uuid=null, tenantId=null, businessServiceId=null, sla=null, state=null, applicationStatus=null, docUploadRequired=null, isStartState=null, isTerminateState=null, isStateUpdatable=null, actions=null, auditDetails=null)], auditDetails=null)", result.toString());
		assertEquals("", result.getTenantId());
		assertEquals("", result.getBusiness());
		assertEquals("", result.getPostUri());
		assertEquals("", result.getGetUri());
		assertEquals("", result.getBusinessService());
		assertEquals(new Long(1L), result.getBusinessServiceSla());
		assertEquals("", result.getUuid());
	}

	/**
	 * Run the BusinessService addStatesItem(State) method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:10 PM
	 */
	@Test
	public void testAddStatesItem_2()
		throws Exception {
		BusinessService fixture = new BusinessService("", "", "", "", "", "", new Long(1L), null, null);
		State statesItem = new State();

		BusinessService result = fixture.addStatesItem(statesItem);

		// add additional test code here
		assertNotNull(result);
		assertEquals("BusinessService(tenantId=, uuid=, businessService=, business=, getUri=, postUri=, businessServiceSla=1, states=[State(uuid=null, tenantId=null, businessServiceId=null, sla=null, state=null, applicationStatus=null, docUploadRequired=null, isStartState=null, isTerminateState=null, isStateUpdatable=null, actions=null, auditDetails=null)], auditDetails=null)", result.toString());
		assertEquals("", result.getTenantId());
		assertEquals("", result.getBusiness());
		assertEquals("", result.getPostUri());
		assertEquals("", result.getGetUri());
		assertEquals("", result.getBusinessService());
		assertEquals(new Long(1L), result.getBusinessServiceSla());
		assertEquals("", result.getUuid());
	}

	/**
	 * Run the BusinessService.BusinessServiceBuilder builder() method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:10 PM
	 */
	@Test
	public void testBuilder_1()
		throws Exception {

		BusinessService.BusinessServiceBuilder result = BusinessService.builder();

		// add additional test code here
		assertNotNull(result);
		assertEquals("BusinessService.BusinessServiceBuilder(tenantId=null, uuid=null, businessService=null, business=null, getUri=null, postUri=null, businessServiceSla=null, states=null, auditDetails=null)", result.toString());
	}
	
	@Test
	public void testBuilder_2()
		throws Exception {

		BusinessService.BusinessServiceBuilder builder = BusinessService.builder();		
		builder.auditDetails(null);
		builder.tenantId(null);
		builder.uuid(null);
		builder.businessService(null);
		builder.business(null);
		builder.getUri(null);
		builder.postUri(null);
		builder.businessServiceSla(null);
		builder.states(null);
		builder.auditDetails(null);
		builder.build();
		
		BusinessService.BusinessServiceBuilder builder2 = BusinessService.builder();		
		builder2.auditDetails(null);
		builder2.tenantId(null);
		builder2.uuid(null);
		builder2.businessService(null);
		builder2.business(null);
		builder2.getUri(null);
		builder2.postUri(null);
		builder2.businessServiceSla(null);
		builder2.states(null);
		builder2.auditDetails(null);
		builder2.build();

		Assert.assertEquals(builder2.toString(), builder.toString());
	}

	/**
	 * Run the boolean canEqual(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:10 PM
	 */
	@Test
	public void testCanEqual_1()
		throws Exception {
		BusinessService fixture = new BusinessService("", "", "", "", "", "", new Long(1L), null, null);
		Object other = new Object();

		boolean result = fixture.canEqual(other);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the boolean canEqual(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:10 PM
	 */
	@Test
	public void testCanEqual_2()
		throws Exception {
		BusinessService fixture = new BusinessService("", "", "", "", "", "", new Long(1L), null, null);
		Object other = new Object();

		boolean result = fixture.canEqual(other);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:10 PM
	 */
	@Test
	public void testEquals_1()
		throws Exception {
		BusinessService fixture = new BusinessService("", "", "", "", "", "", new Long(1L), null, null);
		Object o = new BusinessService("", "", "", "", "", "", new Long(1L), null, null);

		boolean result = fixture.equals(o);

		// add additional test code here
		assertEquals(true, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:10 PM
	 */
	@Test
	public void testEquals_2()
		throws Exception {
		BusinessService fixture = new BusinessService("", "", "", "", "", "", new Long(1L), null, null);
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
	 * @generated at 17/5/20 2:10 PM
	 */
	@Test
	public void testEquals_3()
		throws Exception {
		BusinessService fixture = new BusinessService("", "", "", "", "", "", new Long(1L), null, null);
		Object o = new BusinessService("", "", "", "", "", "", new Long(1L), null, null);

		boolean result = fixture.equals(o);

		// add additional test code here
		assertEquals(true, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:10 PM
	 */
	@Test
	public void testEquals_4()
		throws Exception {
		BusinessService fixture = new BusinessService("", "", "", "", "", "", new Long(1L), null, null);
		Object o = new BusinessService("", "", "", "", "", "", new Long(1L), null, null);

		boolean result = fixture.equals(o);

		// add additional test code here
		assertEquals(true, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:10 PM
	 */
	@Test
	public void testEquals_5()
		throws Exception {
		BusinessService fixture = new BusinessService("", "", "", "", "", "", new Long(1L), null, null);
		Object o = new BusinessService("", "", "", "", "", "", new Long(1L), null, null);

		boolean result = fixture.equals(o);

		// add additional test code here
		assertEquals(true, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:10 PM
	 */
	@Test
	public void testEquals_6()
		throws Exception {
		BusinessService fixture = new BusinessService("", "", (String) null, "", "", "", new Long(1L), null, null);
		Object o = new BusinessService("", "", (String) null, "", "", "", new Long(1L), null, null);

		boolean result = fixture.equals(o);

		// add additional test code here
		assertEquals(true, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:10 PM
	 */
	@Test
	public void testEquals_7()
		throws Exception {
		BusinessService fixture = new BusinessService("", "", "", "", "", "", new Long(1L), null, null);
		Object o = new BusinessService("", "", "", "", "", "", new Long(1L), null, null);

		boolean result = fixture.equals(o);

		// add additional test code here
		assertEquals(true, result);
	}
	
	@Test
	public void testEqualsObject() {
		BusinessService state1=new BusinessService();
		BusinessService state2=new BusinessService();
		Assert.assertEquals(state1,state2);
	}

	/**
	 * Run the AuditDetails getAuditDetails() method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:10 PM
	 */
	@Test
	public void testGetAuditDetails_1()
		throws Exception {
		BusinessService fixture = new BusinessService("", "", "", "", "", "", new Long(1L), null, null);

		AuditDetails result = fixture.getAuditDetails();
		assertEquals(null, result);
	}

	/**
	 * Run the String getBusiness() method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:10 PM
	 */
	@Test
	public void testGetBusiness_1()
		throws Exception {
		BusinessService fixture = new BusinessService("", "", "", "", "", "", new Long(1L), null, null);

		String result = fixture.getBusiness();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the String getBusinessService() method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:10 PM
	 */
	@Test
	public void testGetBusinessService_1()
		throws Exception {
		BusinessService fixture = new BusinessService("", "", "", "", "", "", new Long(1L), null, null);

		String result = fixture.getBusinessService();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the Long getBusinessServiceSla() method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:10 PM
	 */
	@Test
	public void testGetBusinessServiceSla_1()
		throws Exception {
		BusinessService fixture = new BusinessService("", "", "", "", "", "", new Long(1L), null, null);

		Long result = fixture.getBusinessServiceSla();

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
	 * Run the String getGetUri() method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:10 PM
	 */
	@Test
	public void testGetGetUri_1()
		throws Exception {
		BusinessService fixture = new BusinessService("", "", "", "", "", "", new Long(1L), null, null);

		String result = fixture.getGetUri();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the String getPostUri() method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:10 PM
	 */
	@Test
	public void testGetPostUri_1()
		throws Exception {
		BusinessService fixture = new BusinessService("", "", "", "", "", "", new Long(1L), null, null);

		String result = fixture.getPostUri();

		// add additional test code here
		assertEquals("", result);
	}


	/**
	 * Run the State getStateFromUuid(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:10 PM
	 */
	@Test
	public void testGetStateFromUuid_4()
		throws Exception {
		BusinessService fixture = new BusinessService("", "", "", "", "", "", new Long(1L), (List<State>) null, null);
		String uuid = "";

		State result = fixture.getStateFromUuid(uuid);
		assertEquals(null, result);
	}

	/**
	 * Run the List<State> getStates() method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:10 PM
	 */
	@Test
	public void testGetStates_1()
		throws Exception {
		BusinessService fixture = new BusinessService("", "", "", "", "", "", new Long(1L), null, null);

		List<State> result = fixture.getStates();
		assertEquals(null, result);
	}

	/**
	 * Run the String getTenantId() method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:10 PM
	 */
	@Test
	public void testGetTenantId_1()
		throws Exception {
		BusinessService fixture = new BusinessService("", "", "", "", "", "", new Long(1L), null, null);

		String result = fixture.getTenantId();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the String getUuid() method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:10 PM
	 */
	@Test
	public void testGetUuid_1()
		throws Exception {
		BusinessService fixture = new BusinessService("", "", "", "", "", "", new Long(1L), null, null);

		String result = fixture.getUuid();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the int hashCode() method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:10 PM
	 */
	@Test
	public void testHashCode_1()
		throws Exception {
		BusinessService fixture = new BusinessService((String) null, "", "", "", "", "", new Long(1L), null, null);

		int result = fixture.hashCode();

		// add additional test code here
		assertEquals(6018, result);
	}

	/**
	 * Run the int hashCode() method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:10 PM
	 */
	@Test
	public void testHashCode_2()
		throws Exception {
		BusinessService fixture = new BusinessService("", "", (String) null, "", "", "", new Long(1L), null, null);

		int result = fixture.hashCode();

		// add additional test code here
		assertEquals(3524, result);
	}

	/**
	 * Run the void setAuditDetails(AuditDetails) method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:10 PM
	 */
	@Test
	public void testSetAuditDetails_1()
		throws Exception {
		BusinessService fixture = new BusinessService("", "", "", "", "", "", new Long(1L), null, null);
		AuditDetails auditDetails = null;

		fixture.setAuditDetails(auditDetails);

		// add additional test code here
	}

	/**
	 * Run the void setBusiness(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:10 PM
	 */
	@Test
	public void testSetBusiness_1()
		throws Exception {
		BusinessService fixture = new BusinessService("", "", "", "", "", "", new Long(1L), null, null);
		String business = "";

		fixture.setBusiness(business);

		// add additional test code here
	}

	/**
	 * Run the void setBusinessService(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:10 PM
	 */
	@Test
	public void testSetBusinessService_1()
		throws Exception {
		BusinessService fixture = new BusinessService("", "", "", "", "", "", new Long(1L), null, null);
		String businessService = "";

		fixture.setBusinessService(businessService);

		// add additional test code here
	}

	/**
	 * Run the void setBusinessServiceSla(Long) method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:10 PM
	 */
	@Test
	public void testSetBusinessServiceSla_1()
		throws Exception {
		BusinessService fixture = new BusinessService("", "", "", "", "", "", new Long(1L), null, null);
		Long businessServiceSla = new Long(1L);

		fixture.setBusinessServiceSla(businessServiceSla);

		// add additional test code here
	}

	/**
	 * Run the void setGetUri(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:10 PM
	 */
	@Test
	public void testSetGetUri_1()
		throws Exception {
		BusinessService fixture = new BusinessService("", "", "", "", "", "", new Long(1L), null, null);
		String getUri = "";

		fixture.setGetUri(getUri);

		// add additional test code here
	}

	/**
	 * Run the void setPostUri(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:10 PM
	 */
	@Test
	public void testSetPostUri_1()
		throws Exception {
		BusinessService fixture = new BusinessService("", "", "", "", "", "", new Long(1L), null, null);
		String postUri = "";

		fixture.setPostUri(postUri);

		// add additional test code here
	}

	/**
	 * Run the void setStates(List<State>) method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:10 PM
	 */
	@Test
	public void testSetStates_1()
		throws Exception {
		BusinessService fixture = new BusinessService("", "", "", "", "", "", new Long(1L), null, null);
		List<State> states = null;
		fixture.setStates(states);
	}

	/**
	 * Run the void setTenantId(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:10 PM
	 */
	@Test
	public void testSetTenantId_1()
		throws Exception {
		BusinessService fixture = new BusinessService("", "", "", "", "", "", new Long(1L), null, null);
		String tenantId = "";

		fixture.setTenantId(tenantId);

		// add additional test code here
	}

	/**
	 * Run the void setUuid(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:10 PM
	 */
	@Test
	public void testSetUuid_1()
		throws Exception {
		BusinessService fixture = new BusinessService("", "", "", "", "", "", new Long(1L), null, null);
		String uuid = "";

		fixture.setUuid(uuid);

		// add additional test code here
	}
}