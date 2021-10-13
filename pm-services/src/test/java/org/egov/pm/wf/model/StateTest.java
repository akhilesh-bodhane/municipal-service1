package org.egov.pm.wf.model;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.egov.pm.model.AuditDetail;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import junit.framework.Assert;

@RunWith(MockitoJUnitRunner.Silent.class)
public class StateTest {

	@InjectMocks
	private State state;

	@Test
	public void testHashCode() {
		int hash = state.hashCode();
		Assert.assertEquals(hash, state.hashCode());
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
		AuditDetail aud = new AuditDetail();
		state.setAuditDetails(aud);
		Assert.assertEquals(aud, state.getAuditDetails());
	}

	@Test
	public void testStateStringStringStringLongStringStringBooleanBooleanBooleanBooleanListOfActionAuditDetail() {
		State state2 = new State("as3fv4g5g", "ch", "sdf4f45g54g45", 1215L, "state", true, true, true, true,
				new ArrayList<Action>(), new AuditDetail());
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
		state.auditDetails(new AuditDetail());
		state.actions(new ArrayList<Action>());
		state.businessServiceId("ej3984finf");
		state.docUploadRequired(true);
		state.isStartState(true);
		state.isStateUpdatable(true);
		state.isTerminateState(true);
		state.sla(1235L);
		state.uuid("asknkasjkas");
		state.isStartState(true);
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
		Assert.assertEquals(Boolean.valueOf(true), Boolean.valueOf(state.equals(state)));
	}

	@Test
	public void testCanEqual() {
		Assert.assertEquals(Boolean.valueOf(true), Boolean.valueOf(state.canEqual(state)));
	}

}
