package org.egov.ec.web.models.workflow;

import java.util.List;

import org.egov.common.contract.request.Role;
import org.egov.ec.web.models.AuditDetails;
import org.egov.ec.web.models.ItemMaster;
import org.egov.ec.web.models.workflow.Action;
import org.junit.*;
import org.mockito.InjectMocks;

import static org.junit.Assert.*;

/**
 * The class <code>ActionTest</code> contains tests for the class <code>{@link Action}</code>.
 *
 * @generated at 17/5/20 2:09 PM
 * @version $Revision: 1.0 $
 */
public class ActionTest {
	@InjectMocks
	private Action action;
	/**
	 * Run the Action() constructor test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:09 PM
	 */
	@Test
	public void testAction_1()
		throws Exception {

		Action result = new Action();

		// add additional test code here
		assertNotNull(result);
		assertEquals("Action(uuid=null, tenantId=null, currentState=null, action=null, nextState=null, roles=null, auditDetails=null)", result.toString());
		assertEquals(null, result.getCurrentState());
		assertEquals(null, result.getAction());
		assertEquals(null, result.getRoles());
		assertEquals(null, result.getTenantId());
		assertEquals(null, result.getAuditDetails());
		assertEquals(null, result.getNextState());
		assertEquals(null, result.getUuid());
	}

	/**
	 * Run the Action(String,String,String,String,String,List<String>,AuditDetails) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:09 PM
	 */
	@Test
	public void testAction_2()
		throws Exception {
		String uuid = "";
		String tenantId = "";
		String currentState = "";
		String action = "";
		String nextState = "";
		List<String> roles = null;
		AuditDetails auditDetails = null;
		// add mock object expectations here


		Action result = new Action(uuid, tenantId, currentState, action, nextState, roles, auditDetails);

		// add additional test code here
		assertNotNull(result);
		assertEquals("Action(uuid=, tenantId=, currentState=, action=, nextState=, roles=null, auditDetails=null)", result.toString());
		assertEquals("", result.getCurrentState());
		assertEquals("", result.getAction());
		assertEquals("", result.getTenantId());
		assertEquals("", result.getNextState());
		assertEquals("", result.getUuid());
	}

	/**
	 * Run the Action addRolesItem(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:09 PM
	 */
	@Test
	public void testAddRolesItem_1()
		throws Exception {
		Action fixture = new Action("", "", "", "", "", null, null);
		String rolesItem = "";
		fixture.addRolesItem(rolesItem);

	}

	/**
	 * Run the Action.ActionBuilder builder() method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:09 PM
	 */
	@Test
	public void testBuilder_1()
		throws Exception {

		Action.ActionBuilder result = Action.builder();

		// add additional test code here
		assertNotNull(result);
		assertEquals("Action.ActionBuilder(uuid=null, tenantId=null, currentState=null, action=null, nextState=null, roles=null, auditDetails=null)", result.toString());
	}
	
	@Test
	public void testBuilder_2()
		throws Exception {

		Action.ActionBuilder builder = new Action.ActionBuilder();
		builder.uuid(null);
		builder.currentState(null);
		builder.action(null);
		builder.nextState(null);
		builder.roles(null);
		builder.auditDetails(null);
		builder.tenantId(null);
		builder.build();

		Action.ActionBuilder builder2 = new Action.ActionBuilder();
		builder2.uuid(null);
		builder2.currentState(null);
		builder2.action(null);
		builder2.nextState(null);
		builder2.roles(null);
		builder2.auditDetails(null);
		builder2.tenantId(null);
		builder2.build();
		builder2.build();

		Assert.assertEquals(builder2.toString(), builder.toString());
	}
	/**
	 * Run the boolean canEqual(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:09 PM
	 */
	@Test
	public void testCanEqual_1()
		throws Exception {
		Action fixture = new Action("", "", "", "", "", null, new AuditDetails());
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
	 * @generated at 17/5/20 2:09 PM
	 */
	@Test
	public void testCanEqual_2()
		throws Exception {
		Action fixture = new Action("", "", "", "", "", null, new AuditDetails());
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
	 * @generated at 17/5/20 2:09 PM
	 */
	@Test
	public void testEquals_1()
		throws Exception {
		Action fixture = new Action("", "", "", "", "", null, new AuditDetails());
		Object o = new Action("", "", "", "", "", null, new AuditDetails());

		boolean result = fixture.equals(o);

		// add additional test code here
		assertEquals(true, result);
	}

	
	@Test
	public void testHashCode() {
		Action action1=new Action();
		Action action2=new Action();
		int hash = action1.hashCode();
		Assert.assertEquals(hash, action2.hashCode());
	}
	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:09 PM
	 */
	@Test
	public void testEquals_2()
		throws Exception {
		Action action1=new Action();
		Action action2=new Action();

		Assert.assertEquals(action1, action2);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:09 PM
	 */
	@Test
	public void testEquals_4()
		throws Exception {
		Action fixture = new Action("", "", "", "", "", null, new AuditDetails());
		Object o = new Action("", "", "", "", "", null, new AuditDetails());

		boolean result = fixture.equals(o);

		// add additional test code here
		assertEquals(true, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:09 PM
	 */
	@Test
	public void testEquals_5()
		throws Exception {
		Action fixture = new Action("", "", "", "", "", null, new AuditDetails());
		Object o = new Action("", "", "", "", "", null, new AuditDetails());

		boolean result = fixture.equals(o);

		// add additional test code here
		assertEquals(true, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:09 PM
	 */
	@Test
	public void testEquals_6()
		throws Exception {
		Action fixture = new Action("", "", "", "", "", null, new AuditDetails());
		Object o = new Action("", "", "", "", "", null, new AuditDetails());

		boolean result = fixture.equals(o);

		// add additional test code here
		assertEquals(true, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:09 PM
	 */
	@Test
	public void testEquals_7()
		throws Exception {
		Action fixture = new Action("", "", "", (String) null, "", null, new AuditDetails());
		Object o = new Action("", "", "", (String) null, "", null, new AuditDetails());

		boolean result = fixture.equals(o);

		// add additional test code here
		assertEquals(true, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:09 PM
	 */
	@Test
	public void testEquals_8()
		throws Exception {
		Action fixture = new Action("", "", "", "", "", null, new AuditDetails());
		Object o = new Action("", "", "", "", "", null, new AuditDetails());

		boolean result = fixture.equals(o);

		// add additional test code here
		assertEquals(true, result);
	}

	/**
	 * Run the String getAction() method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:09 PM
	 */
	@Test
	public void testGetAction_1()
		throws Exception {
		Action fixture = new Action("", "", "", "", "", null, new AuditDetails());

		String result = fixture.getAction();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the AuditDetails getAuditDetails() method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:09 PM
	 */
	@Test
	public void testGetAuditDetails_1()
		throws Exception {
		Action fixture = new Action("", "", "", "", "", null, new AuditDetails());

		AuditDetails result = fixture.getAuditDetails();

		// add additional test code here
		assertNotNull(result);
		assertEquals(null, result.getLastModifiedTime());
		assertEquals(null, result.getLastModifiedBy());
		assertEquals(null, result.getCreatedBy());
		assertEquals(null, result.getUserRole());
		assertEquals(null, result.getCreatedTime());
	}

	/**
	 * Run the String getCurrentState() method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:09 PM
	 */
	@Test
	public void testGetCurrentState_1()
		throws Exception {
		Action fixture = new Action("", "", "", "", "", null, new AuditDetails());

		String result = fixture.getCurrentState();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the String getNextState() method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:09 PM
	 */
	@Test
	public void testGetNextState_1()
		throws Exception {
		Action fixture = new Action("", "", "", "", "", null, new AuditDetails());

		String result = fixture.getNextState();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the List<String> getRoles() method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:09 PM
	 */
	@Test
	public void testGetRoles_1()
		throws Exception {
		Action fixture = new Action("", "", "", "", "", null, null);

		List<String> result = fixture.getRoles();
		assertEquals(null, result);
	}

	/**
	 * Run the String getTenantId() method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:09 PM
	 */
	@Test
	public void testGetTenantId_1()
		throws Exception {
		Action fixture = new Action("", "", "", "", "", null, new AuditDetails());

		String result = fixture.getTenantId();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the String getUuid() method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:09 PM
	 */
	@Test
	public void testGetUuid_1()
		throws Exception {
		Action fixture = new Action("", "", "", "", "", null, new AuditDetails());

		String result = fixture.getUuid();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the int hashCode() method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:09 PM
	 */
	@Test
	public void testHashCode_1()
		throws Exception {
		Action fixture = new Action("", (String) null, "", "", "", null, new AuditDetails());

		int result = fixture.hashCode();

		// add additional test code here
		assertEquals(355062, result);
	}

	/**
	 * Run the int hashCode() method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:09 PM
	 */
	@Test
	public void testHashCode_2()
		throws Exception {
		Action fixture = new Action("", "", (String) null, (String) null, "", null, new AuditDetails());

		int result = fixture.hashCode();

		// add additional test code here
		assertEquals(207959, result);
	}

	/**
	 * Run the void setAction(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:09 PM
	 */
	@Test
	public void testSetAction_1()
		throws Exception {
		Action fixture = new Action("", "", "", "", "", null, new AuditDetails());
		String action = "";

		fixture.setAction(action);
	}

	/**
	 * Run the void setAuditDetails(AuditDetails) method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:09 PM
	 */
	@Test
	public void testSetAuditDetails_1()
		throws Exception {
		Action fixture = new Action("", "", "", "", "", null, new AuditDetails());
		AuditDetails auditDetails = new AuditDetails();

		fixture.setAuditDetails(auditDetails);

		// add additional test code here
	}

	/**
	 * Run the void setCurrentState(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:09 PM
	 */
	@Test
	public void testSetCurrentState_1()
		throws Exception {
		Action fixture = new Action("", "", "", "", "", null, new AuditDetails());
		String currentState = "";

		fixture.setCurrentState(currentState);

		// add additional test code here
	}

	/**
	 * Run the void setNextState(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:09 PM
	 */
	@Test
	public void testSetNextState_1()
		throws Exception {
		Action fixture = new Action("", "", "", "", "", null, new AuditDetails());
		String nextState = "";

		fixture.setNextState(nextState);

		// add additional test code here
	}

	/**
	 * Run the void setRoles(List<String>) method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:09 PM
	 */
	@Test
	public void testSetRoles_1()
		throws Exception {
		Action fixture = new Action("", "", "", "", "", null, new AuditDetails());
		List<String> roles = null;
		fixture.setRoles(roles);
	}

	/**
	 * Run the void setTenantId(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:09 PM
	 */
	@Test
	public void testSetTenantId_1()
		throws Exception {
		Action fixture = new Action("", "", "", "", "", null, new AuditDetails());
		String tenantId = "";

		fixture.setTenantId(tenantId);

		// add additional test code here
	}

	/**
	 * Run the void setUuid(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:09 PM
	 */
	@Test
	public void testSetUuid_1()
		throws Exception {
		Action fixture = new Action("", "", "", "", "", null, new AuditDetails());
		String uuid = "";

		fixture.setUuid(uuid);

		// add additional test code here
	}
}
