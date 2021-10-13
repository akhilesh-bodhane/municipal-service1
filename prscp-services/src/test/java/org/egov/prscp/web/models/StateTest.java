package org.egov.prscp.web.models;

import java.util.List;
import org.easymock.EasyMock;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * The class <code>StateTest</code> contains tests for the class <code>{@link State}</code>.
 *
 * @generatedBy CodePro at 25/5/20 3:53 PM
 * @author Aniket.Marathe
 * @version $Revision: 1.0 $
 */
public class StateTest {
	/**
	 * Run the State() constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:53 PM
	 */
	@Test
	public void testState_1()
		throws Exception {

		State result = new State();

		// add additional test code here
		assertNotNull(result);
		assertEquals("State(uuid=null, tenantId=null, businessServiceId=null, sla=null, state=null, applicationStatus=null, docUploadRequired=null, isStartState=null, isTerminateState=null, isStateUpdatable=null, actions=null, auditDetails=null)", result.toString());
		assertEquals(null, result.getActions());
		assertEquals(null, result.getState());
		assertEquals(null, result.getUuid());
		assertEquals(null, result.getSla());
		assertEquals(null, result.getIsStartState());
		assertEquals(null, result.getAuditDetails());
		assertEquals(null, result.getBusinessServiceId());
		assertEquals(null, result.getApplicationStatus());
		assertEquals(null, result.getIsTerminateState());
		assertEquals(null, result.getDocUploadRequired());
		assertEquals(null, result.getIsStateUpdatable());
		assertEquals(null, result.getTenantId());
	}

	/**
	 * Run the State(String,String,String,Long,String,String,Boolean,Boolean,Boolean,Boolean,List<Action>,AuditDetails) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:53 PM
	 */
	@Test
	public void testState_2()
		throws Exception {
		String uuid = "";
		String tenantId = "";
		String businessServiceId = "";
		Long sla = new Long(1L);
		String state = "";
		String applicationStatus = "";
		Boolean docUploadRequired = new Boolean(true);
		Boolean isStartState = new Boolean(true);
		Boolean isTerminateState = new Boolean(true);
		Boolean isStateUpdatable = new Boolean(true);
		List<Action> actions = EasyMock.createMock(List.class);
		AuditDetails auditDetails = new AuditDetails();
		// add mock object expectations here

		EasyMock.replay(actions);

		State result = new State(uuid, tenantId, businessServiceId, sla, state, applicationStatus, docUploadRequired, isStartState, isTerminateState, isStateUpdatable, actions, auditDetails);

		// add additional test code here
		EasyMock.verify(actions);
		assertNotNull(result);
		//assertEquals("State(uuid=, tenantId=, businessServiceId=, sla=1, state=, applicationStatus=, docUploadRequired=true, isStartState=true, isTerminateState=true, isStateUpdatable=true, actions=EasyMock for interface java.util.List, auditDetails=org.egov.prscp.web.models.AuditDetails@15f204e9)", result.toString());
		assertEquals("", result.getState());
		assertEquals("", result.getUuid());
		assertEquals(new Long(1L), result.getSla());
		assertEquals(Boolean.TRUE, result.getIsStartState());
		assertEquals("", result.getBusinessServiceId());
		assertEquals("", result.getApplicationStatus());
		assertEquals(Boolean.TRUE, result.getIsTerminateState());
		assertEquals(Boolean.TRUE, result.getDocUploadRequired());
		assertEquals(Boolean.TRUE, result.getIsStateUpdatable());
		assertEquals("", result.getTenantId());
	}

	/**
	 * Run the State addActionsItem(Action) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:53 PM
	 */
	@Test
	public void testAddActionsItem_1()
		throws Exception {
		State fixture = new State("", "", "", new Long(1L), "", "", new Boolean(true), new Boolean(true), new Boolean(true), new Boolean(true), (List<Action>) null, new AuditDetails());
		Action actionsItem = ActionFactory.createAction();

		State result = fixture.addActionsItem(actionsItem);

		// add additional test code here
		assertNotNull(result);
		//assertEquals("State(uuid=, tenantId=, businessServiceId=, sla=1, state=, applicationStatus=, docUploadRequired=true, isStartState=true, isTerminateState=true, isStateUpdatable=true, actions=[Action(uuid=0123456789, tenantId=0123456789, currentState=0123456789, action=0123456789, nextState=0123456789, roles=[, 0123456789], auditDetails=org.egov.prscp.web.models.AuditDetails@654cb706)], auditDetails=org.egov.prscp.web.models.AuditDetails@37fbaa54)", result.toString());
		assertEquals("", result.getState());
		assertEquals("", result.getUuid());
		assertEquals(new Long(1L), result.getSla());
		assertEquals(Boolean.TRUE, result.getIsStartState());
		assertEquals("", result.getBusinessServiceId());
		assertEquals("", result.getApplicationStatus());
		assertEquals(Boolean.TRUE, result.getIsTerminateState());
		assertEquals(Boolean.TRUE, result.getDocUploadRequired());
		assertEquals(Boolean.TRUE, result.getIsStateUpdatable());
		assertEquals("", result.getTenantId());
	}

	/**
	 * Run the State addActionsItem(Action) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:53 PM
	 */
	@Test
	public void testAddActionsItem_2()
		throws Exception {
		State fixture = new State("", "", "", new Long(1L), "", "", new Boolean(true), new Boolean(true), new Boolean(true), new Boolean(true), EasyMock.createNiceMock(List.class), new AuditDetails());
		Action actionsItem = ActionFactory.createAction2();

		State result = fixture.addActionsItem(actionsItem);

		// add additional test code here
		assertNotNull(result);
		//assertEquals("State(uuid=, tenantId=, businessServiceId=, sla=1, state=, applicationStatus=, docUploadRequired=true, isStartState=true, isTerminateState=true, isStateUpdatable=true, actions=EasyMock for interface java.util.List, auditDetails=org.egov.prscp.web.models.AuditDetails@2485cf01)", result.toString());
		assertEquals("", result.getState());
		assertEquals("", result.getUuid());
		assertEquals(new Long(1L), result.getSla());
		assertEquals(Boolean.TRUE, result.getIsStartState());
		assertEquals("", result.getBusinessServiceId());
		assertEquals("", result.getApplicationStatus());
		assertEquals(Boolean.TRUE, result.getIsTerminateState());
		assertEquals(Boolean.TRUE, result.getDocUploadRequired());
		assertEquals(Boolean.TRUE, result.getIsStateUpdatable());
		assertEquals("", result.getTenantId());
	}

	/**
	 * Run the State.StateBuilder builder() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:53 PM
	 */
	@Test
	public void testBuilder_1()
		throws Exception {

		State.StateBuilder result = State.builder();

		// add additional test code here
		assertNotNull(result);
		assertEquals("State.StateBuilder(uuid=null, tenantId=null, businessServiceId=null, sla=null, state=null, applicationStatus=null, docUploadRequired=null, isStartState=null, isTerminateState=null, isStateUpdatable=null, actions=null, auditDetails=null)", result.toString());
	}

	/**
	 * Run the boolean canEqual(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:53 PM
	 */
	@Test
	public void testCanEqual_1()
		throws Exception {
		State fixture = new State("", "", "", new Long(1L), "", "", new Boolean(true), new Boolean(true), new Boolean(true), new Boolean(true), EasyMock.createNiceMock(List.class), new AuditDetails());
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
	 * @generatedBy CodePro at 25/5/20 3:53 PM
	 */
	@Test
	public void testCanEqual_2()
		throws Exception {
		State fixture = new State("", "", "", new Long(1L), "", "", new Boolean(true), new Boolean(true), new Boolean(true), new Boolean(true), EasyMock.createNiceMock(List.class), new AuditDetails());
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
	 * @generatedBy CodePro at 25/5/20 3:53 PM
	 */
	@Test
	public void testEquals_1()
		throws Exception {
		State fixture = new State("", "", "", new Long(1L), "", "", new Boolean(true), new Boolean(true), new Boolean(true), new Boolean(true), EasyMock.createNiceMock(List.class), new AuditDetails());
		Object o = new State("", "", "", new Long(1L), "", "", new Boolean(true), new Boolean(true), new Boolean(true), new Boolean(true), EasyMock.createNiceMock(List.class), new AuditDetails());

		boolean result = fixture.equals(o);

		// add additional test code here
		assertEquals(true, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:53 PM
	 */
	@Test
	public void testEquals_2()
		throws Exception {
		State fixture = new State("", "", "", new Long(1L), "", "", new Boolean(true), new Boolean(true), new Boolean(true), new Boolean(true), EasyMock.createNiceMock(List.class), new AuditDetails());
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
	 * @generatedBy CodePro at 25/5/20 3:53 PM
	 */
	@Test
	public void testEquals_3()
		throws Exception {
		State fixture = new State("", "", "", new Long(1L), "", "", new Boolean(true), new Boolean(true), new Boolean(true), new Boolean(true), EasyMock.createNiceMock(List.class), new AuditDetails());
		Object o = new State("", "", "", new Long(1L), "", "", new Boolean(true), new Boolean(true), new Boolean(true), new Boolean(true), EasyMock.createNiceMock(List.class), new AuditDetails());

		boolean result = fixture.equals(o);

		// add additional test code here
		assertEquals(true, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:53 PM
	 */
	@Test
	public void testEquals_4()
		throws Exception {
		State fixture = new State("", "", "", new Long(1L), "", "", new Boolean(true), new Boolean(true), new Boolean(true), new Boolean(true), EasyMock.createNiceMock(List.class), new AuditDetails());
		Object o = new State("", "", "", new Long(1L), "", "", new Boolean(true), new Boolean(true), new Boolean(true), new Boolean(true), EasyMock.createNiceMock(List.class), new AuditDetails());

		boolean result = fixture.equals(o);

		// add additional test code here
		assertEquals(true, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:53 PM
	 */
	@Test
	public void testEquals_5()
		throws Exception {
		State fixture = new State("", "", "", new Long(1L), "", "", new Boolean(true), new Boolean(true), new Boolean(true), new Boolean(true), EasyMock.createNiceMock(List.class), new AuditDetails());
		Object o = new State("", "", "", new Long(1L), "", "", new Boolean(true), new Boolean(true), new Boolean(true), new Boolean(true), EasyMock.createNiceMock(List.class), new AuditDetails());

		boolean result = fixture.equals(o);

		// add additional test code here
		assertEquals(true, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:53 PM
	 */
	@Test
	public void testEquals_6()
		throws Exception {
		State fixture = new State("", "", "", new Long(1L), "", "", new Boolean(true), new Boolean(true), new Boolean(true), new Boolean(true), EasyMock.createNiceMock(List.class), new AuditDetails());
		Object o = new State("", "", "", new Long(1L), "", "", new Boolean(true), new Boolean(true), new Boolean(true), new Boolean(true), EasyMock.createNiceMock(List.class), new AuditDetails());

		boolean result = fixture.equals(o);

		// add additional test code here
		assertEquals(true, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:53 PM
	 */
	@Test
	public void testEquals_7()
		throws Exception {
		State fixture = new State("", "", "", new Long(1L), (String) null, "", new Boolean(true), new Boolean(true), new Boolean(true), new Boolean(true), EasyMock.createNiceMock(List.class), new AuditDetails());
		Object o = new State("", "", "", new Long(1L), (String) null, "", new Boolean(true), new Boolean(true), new Boolean(true), new Boolean(true), EasyMock.createNiceMock(List.class), new AuditDetails());

		boolean result = fixture.equals(o);

		// add additional test code here
		assertEquals(true, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:53 PM
	 */
	@Test
	public void testEquals_8()
		throws Exception {
		State fixture = new State("", "", "", new Long(1L), "", "", new Boolean(true), new Boolean(true), new Boolean(true), new Boolean(true), EasyMock.createNiceMock(List.class), new AuditDetails());
		Object o = new State("", "", "", new Long(1L), "", "", new Boolean(true), new Boolean(true), new Boolean(true), new Boolean(true), EasyMock.createNiceMock(List.class), new AuditDetails());

		boolean result = fixture.equals(o);

		// add additional test code here
		assertEquals(true, result);
	}

	/**
	 * Run the List<Action> getActions() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:53 PM
	 */
	@Test
	public void testGetActions_1()
		throws Exception {
		State fixture = new State("", "", "", new Long(1L), "", "", new Boolean(true), new Boolean(true), new Boolean(true), new Boolean(true), EasyMock.createNiceMock(List.class), new AuditDetails());

		List<Action> result = fixture.getActions();

		// add additional test code here
		assertNotNull(result);
		assertEquals(0, result.size());
	}

	/**
	 * Run the String getApplicationStatus() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:53 PM
	 */
	@Test
	public void testGetApplicationStatus_1()
		throws Exception {
		State fixture = new State("", "", "", new Long(1L), "", "", new Boolean(true), new Boolean(true), new Boolean(true), new Boolean(true), EasyMock.createNiceMock(List.class), new AuditDetails());

		String result = fixture.getApplicationStatus();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the AuditDetails getAuditDetails() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:53 PM
	 */
	@Test
	public void testGetAuditDetails_1()
		throws Exception {
		State fixture = new State("", "", "", new Long(1L), "", "", new Boolean(true), new Boolean(true), new Boolean(true), new Boolean(true), EasyMock.createNiceMock(List.class), new AuditDetails());

		AuditDetails result = fixture.getAuditDetails();

		// add additional test code here
		assertNotNull(result);
		assertEquals(null, result.getLastModifiedTime());
		assertEquals(null, result.getLastModifiedBy());
		assertEquals(null, result.getCreatedBy());
		assertEquals(null, result.getCreatedTime());
	}

	/**
	 * Run the String getBusinessServiceId() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:53 PM
	 */
	@Test
	public void testGetBusinessServiceId_1()
		throws Exception {
		State fixture = new State("", "", "", new Long(1L), "", "", new Boolean(true), new Boolean(true), new Boolean(true), new Boolean(true), EasyMock.createNiceMock(List.class), new AuditDetails());

		String result = fixture.getBusinessServiceId();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the Boolean getDocUploadRequired() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:53 PM
	 */
	@Test
	public void testGetDocUploadRequired_1()
		throws Exception {
		State fixture = new State("", "", "", new Long(1L), "", "", new Boolean(true), new Boolean(true), new Boolean(true), new Boolean(true), EasyMock.createNiceMock(List.class), new AuditDetails());

		Boolean result = fixture.getDocUploadRequired();

		// add additional test code here
		assertNotNull(result);
		assertEquals("true", result.toString());
		assertEquals(true, result.booleanValue());
	}

	/**
	 * Run the Boolean getIsStartState() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:53 PM
	 */
	@Test
	public void testGetIsStartState_1()
		throws Exception {
		State fixture = new State("", "", "", new Long(1L), "", "", new Boolean(true), new Boolean(true), new Boolean(true), new Boolean(true), EasyMock.createNiceMock(List.class), new AuditDetails());

		Boolean result = fixture.getIsStartState();

		// add additional test code here
		assertNotNull(result);
		assertEquals("true", result.toString());
		assertEquals(true, result.booleanValue());
	}

	/**
	 * Run the Boolean getIsStateUpdatable() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:53 PM
	 */
	@Test
	public void testGetIsStateUpdatable_1()
		throws Exception {
		State fixture = new State("", "", "", new Long(1L), "", "", new Boolean(true), new Boolean(true), new Boolean(true), new Boolean(true), EasyMock.createNiceMock(List.class), new AuditDetails());

		Boolean result = fixture.getIsStateUpdatable();

		// add additional test code here
		assertNotNull(result);
		assertEquals("true", result.toString());
		assertEquals(true, result.booleanValue());
	}

	/**
	 * Run the Boolean getIsTerminateState() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:53 PM
	 */
	@Test
	public void testGetIsTerminateState_1()
		throws Exception {
		State fixture = new State("", "", "", new Long(1L), "", "", new Boolean(true), new Boolean(true), new Boolean(true), new Boolean(true), EasyMock.createNiceMock(List.class), new AuditDetails());

		Boolean result = fixture.getIsTerminateState();

		// add additional test code here
		assertNotNull(result);
		assertEquals("true", result.toString());
		assertEquals(true, result.booleanValue());
	}

	/**
	 * Run the Long getSla() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:53 PM
	 */
	@Test
	public void testGetSla_1()
		throws Exception {
		State fixture = new State("", "", "", new Long(1L), "", "", new Boolean(true), new Boolean(true), new Boolean(true), new Boolean(true), EasyMock.createNiceMock(List.class), new AuditDetails());

		Long result = fixture.getSla();

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
	 * Run the String getState() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:53 PM
	 */
	@Test
	public void testGetState_1()
		throws Exception {
		State fixture = new State("", "", "", new Long(1L), "", "", new Boolean(true), new Boolean(true), new Boolean(true), new Boolean(true), EasyMock.createNiceMock(List.class), new AuditDetails());

		String result = fixture.getState();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the String getTenantId() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:53 PM
	 */
	@Test
	public void testGetTenantId_1()
		throws Exception {
		State fixture = new State("", "", "", new Long(1L), "", "", new Boolean(true), new Boolean(true), new Boolean(true), new Boolean(true), EasyMock.createNiceMock(List.class), new AuditDetails());

		String result = fixture.getTenantId();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the String getUuid() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:53 PM
	 */
	@Test
	public void testGetUuid_1()
		throws Exception {
		State fixture = new State("", "", "", new Long(1L), "", "", new Boolean(true), new Boolean(true), new Boolean(true), new Boolean(true), EasyMock.createNiceMock(List.class), new AuditDetails());

		String result = fixture.getUuid();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the int hashCode() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:53 PM
	 */
	@Test
	public void testHashCode_1()
		throws Exception {
		State fixture = new State("", (String) null, "", new Long(1L), "", "", new Boolean(true), new Boolean(true), new Boolean(true), new Boolean(true), EasyMock.createNiceMock(List.class), new AuditDetails());

		int result = fixture.hashCode();

		// add additional test code here
		assertEquals(355062, result);
	}

	/**
	 * Run the int hashCode() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:53 PM
	 */
	@Test
	public void testHashCode_2()
		throws Exception {
		State fixture = new State("", "", (String) null, new Long(1L), (String) null, "", new Boolean(true), new Boolean(true), new Boolean(true), new Boolean(true), EasyMock.createNiceMock(List.class), new AuditDetails());

		int result = fixture.hashCode();

		// add additional test code here
		assertEquals(207959, result);
	}

	/**
	 * Run the void setActions(List<Action>) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:53 PM
	 */
	@Test
	public void testSetActions_1()
		throws Exception {
		State fixture = new State("", "", "", new Long(1L), "", "", new Boolean(true), new Boolean(true), new Boolean(true), new Boolean(true), EasyMock.createNiceMock(List.class), new AuditDetails());
		List<Action> actions = EasyMock.createMock(List.class);
		// add mock object expectations here

		EasyMock.replay(actions);

		fixture.setActions(actions);

		// add additional test code here
		EasyMock.verify(actions);
	}

	/**
	 * Run the void setApplicationStatus(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:53 PM
	 */
	@Test
	public void testSetApplicationStatus_1()
		throws Exception {
		State fixture = new State("", "", "", new Long(1L), "", "", new Boolean(true), new Boolean(true), new Boolean(true), new Boolean(true), EasyMock.createNiceMock(List.class), new AuditDetails());
		String applicationStatus = "";

		fixture.setApplicationStatus(applicationStatus);

		// add additional test code here
	}

	/**
	 * Run the void setAuditDetails(AuditDetails) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:53 PM
	 */
	@Test
	public void testSetAuditDetails_1()
		throws Exception {
		State fixture = new State("", "", "", new Long(1L), "", "", new Boolean(true), new Boolean(true), new Boolean(true), new Boolean(true), EasyMock.createNiceMock(List.class), new AuditDetails());
		AuditDetails auditDetails = new AuditDetails();

		fixture.setAuditDetails(auditDetails);

		// add additional test code here
	}

	/**
	 * Run the void setBusinessServiceId(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:53 PM
	 */
	@Test
	public void testSetBusinessServiceId_1()
		throws Exception {
		State fixture = new State("", "", "", new Long(1L), "", "", new Boolean(true), new Boolean(true), new Boolean(true), new Boolean(true), EasyMock.createNiceMock(List.class), new AuditDetails());
		String businessServiceId = "";

		fixture.setBusinessServiceId(businessServiceId);

		// add additional test code here
	}

	/**
	 * Run the void setDocUploadRequired(Boolean) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:53 PM
	 */
	@Test
	public void testSetDocUploadRequired_1()
		throws Exception {
		State fixture = new State("", "", "", new Long(1L), "", "", new Boolean(true), new Boolean(true), new Boolean(true), new Boolean(true), EasyMock.createNiceMock(List.class), new AuditDetails());
		Boolean docUploadRequired = new Boolean(true);

		fixture.setDocUploadRequired(docUploadRequired);

		// add additional test code here
	}

	/**
	 * Run the void setIsStartState(Boolean) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:53 PM
	 */
	@Test
	public void testSetIsStartState_1()
		throws Exception {
		State fixture = new State("", "", "", new Long(1L), "", "", new Boolean(true), new Boolean(true), new Boolean(true), new Boolean(true), EasyMock.createNiceMock(List.class), new AuditDetails());
		Boolean isStartState = new Boolean(true);

		fixture.setIsStartState(isStartState);

		// add additional test code here
	}

	/**
	 * Run the void setIsStateUpdatable(Boolean) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:53 PM
	 */
	@Test
	public void testSetIsStateUpdatable_1()
		throws Exception {
		State fixture = new State("", "", "", new Long(1L), "", "", new Boolean(true), new Boolean(true), new Boolean(true), new Boolean(true), EasyMock.createNiceMock(List.class), new AuditDetails());
		Boolean isStateUpdatable = new Boolean(true);

		fixture.setIsStateUpdatable(isStateUpdatable);

		// add additional test code here
	}

	/**
	 * Run the void setIsTerminateState(Boolean) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:53 PM
	 */
	@Test
	public void testSetIsTerminateState_1()
		throws Exception {
		State fixture = new State("", "", "", new Long(1L), "", "", new Boolean(true), new Boolean(true), new Boolean(true), new Boolean(true), EasyMock.createNiceMock(List.class), new AuditDetails());
		Boolean isTerminateState = new Boolean(true);

		fixture.setIsTerminateState(isTerminateState);

		// add additional test code here
	}

	/**
	 * Run the void setSla(Long) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:53 PM
	 */
	@Test
	public void testSetSla_1()
		throws Exception {
		State fixture = new State("", "", "", new Long(1L), "", "", new Boolean(true), new Boolean(true), new Boolean(true), new Boolean(true), EasyMock.createNiceMock(List.class), new AuditDetails());
		Long sla = new Long(1L);

		fixture.setSla(sla);

		// add additional test code here
	}

	/**
	 * Run the void setState(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:53 PM
	 */
	@Test
	public void testSetState_1()
		throws Exception {
		State fixture = new State("", "", "", new Long(1L), "", "", new Boolean(true), new Boolean(true), new Boolean(true), new Boolean(true), EasyMock.createNiceMock(List.class), new AuditDetails());
		String state = "";

		fixture.setState(state);

		// add additional test code here
	}

	/**
	 * Run the void setTenantId(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:53 PM
	 */
	@Test
	public void testSetTenantId_1()
		throws Exception {
		State fixture = new State("", "", "", new Long(1L), "", "", new Boolean(true), new Boolean(true), new Boolean(true), new Boolean(true), EasyMock.createNiceMock(List.class), new AuditDetails());
		String tenantId = "";

		fixture.setTenantId(tenantId);

		// add additional test code here
	}

	/**
	 * Run the void setUuid(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:53 PM
	 */
	@Test
	public void testSetUuid_1()
		throws Exception {
		State fixture = new State("", "", "", new Long(1L), "", "", new Boolean(true), new Boolean(true), new Boolean(true), new Boolean(true), EasyMock.createNiceMock(List.class), new AuditDetails());
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
	 * @generatedBy CodePro at 25/5/20 3:53 PM
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
	 * @generatedBy CodePro at 25/5/20 3:53 PM
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
	 * @generatedBy CodePro at 25/5/20 3:53 PM
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(StateTest.class);
	}
}