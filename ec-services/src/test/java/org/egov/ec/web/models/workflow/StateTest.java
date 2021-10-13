package org.egov.ec.web.models.workflow;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;
import org.egov.ec.web.models.AuditDetails;
import org.egov.ec.web.models.User;
import org.egov.ec.web.models.workflow.Action;
import org.egov.ec.web.models.workflow.State;
import org.junit.Assert;

@RunWith(MockitoJUnitRunner.class)
public class StateTest {

	@InjectMocks
	private State state;

	@Test
	public void testHashCode() {
		State state1=new State();
		State state2=new State();
		int hash = state1.hashCode();
		Assert.assertEquals(hash, state2.hashCode());
	}

	@Test
	public void testAddActionsItem() {
		Action actionsItem = new Action();
		state.addActionsItem(actionsItem);
	}

	@Test
	public void testBuilder() {
		state.builder();
	}

	@Test
	public void testGetUuid() {
		state.setUuid("sd9wfj3092ojc0923f");
		Assert.assertEquals("sd9wfj3092ojc0923f", state.getUuid());
	}

	@Test
	public void testGetTenantId() {
		state.setTenantId("ch");
		Assert.assertEquals("ch", state.getTenantId());
	}

	@Test
	public void testGetBusinessServiceId() {
		state.setBusinessServiceId("ksji3393923h");
		Assert.assertEquals("ksji3393923h", state.getBusinessServiceId());
	}

	@Test
	public void testGetSla() {
		state.setSla(1215L);
		Assert.assertEquals(Long.valueOf(1215L), state.getSla());
	}

	@Test
	public void testGetState() {
		state.setState("state");
		Assert.assertEquals("state", state.getState());
	}

	@Test
	public void testGetApplicationStatus() {
		state.setApplicationStatus("APPROVED");
		Assert.assertEquals("APPROVED", state.getApplicationStatus());
	}

	@Test
	public void testGetDocUploadRequired() {
		state.setDocUploadRequired(true);
		Assert.assertEquals(Boolean.valueOf(true), state.getDocUploadRequired());
	}

	@Test
	public void testGetIsStartState() {
		state.setIsStartState(true);
		Assert.assertEquals(Boolean.valueOf(true), state.getIsStartState());
	}

	@Test
	public void testGetIsTerminateState() {
		state.setIsTerminateState(true);
		Assert.assertEquals(Boolean.valueOf(true), state.getIsTerminateState());
	}

	@Test
	public void testGetIsStateUpdatable() {
		state.setIsStateUpdatable(true);
		Assert.assertEquals(Boolean.valueOf(true), state.getIsStateUpdatable());
	}

	@Test
	public void testGetActions() {
		List<Action> actions = new ArrayList<Action>();
		state.setActions(actions);
		Assert.assertEquals(actions, state.getActions());
	}

	@Test
	public void testGetAuditDetails() {
		AuditDetails aud = new AuditDetails();
		state.setAuditDetails(aud);
		Assert.assertEquals(aud, state.getAuditDetails());
	}

	@Test
	public void testStateStringStringStringLongStringStringBooleanBooleanBooleanBooleanListOfActionAuditDetail() {
		State state2 = new State("as3fv4g5g", "ch", "sdf4f45g54g45", 1215L, "state", "APPROVED", true, true, true, true,
				new ArrayList<Action>(), new AuditDetails());
		Assert.assertEquals("ch", state2.getTenantId());
	}

	@Test
	public void testState_2() {
		State state = new State();
		Assert.assertEquals(state, state);
	}

	@Test
	public void testStateBuilder() {
		State.StateBuilder state = new State.StateBuilder();
		state.applicationStatus("APPROVED");
		state.auditDetails(new AuditDetails());
		state.actions(new ArrayList<Action>());
		state.businessServiceId("ej3984finf");
		state.docUploadRequired(true);
		state.isStartState(true);
		state.isStateUpdatable(true);
		state.isTerminateState(true);
		state.sla(1235L);
		state.uuid("asknkasjkas");
		state.state("state");
		state.tenantId("ch");
		state.build();
		state.toString();
		
	}
	
	@Test
	public void testToString() {
		state.toString();
	}
	
	@Test
	public void testState() {
		state.toString();
	}

	@Test
	public void testEqualsObject() {
		State state1=new State();
		State state2=new State();
		Assert.assertEquals(state1,state2);
		Assert.assertEquals(Boolean.valueOf(true), Boolean.valueOf(state.equals(state)));
	}

	@Test
	public void testCanEqual() {
		Assert.assertEquals(Boolean.valueOf(true), Boolean.valueOf(state.canEqual(state)));
	}

}
