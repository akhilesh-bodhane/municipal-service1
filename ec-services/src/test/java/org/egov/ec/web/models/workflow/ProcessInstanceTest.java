package org.egov.ec.web.models.workflow;

import java.util.List;
import org.egov.common.contract.request.User;
import org.egov.ec.web.models.AuditDetails;
import org.egov.ec.web.models.workflow.Action;
import org.egov.ec.web.models.workflow.Document;
import org.egov.ec.web.models.workflow.ProcessInstance;
import org.egov.ec.web.models.workflow.State;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * The class <code>ProcessInstanceTest</code> contains tests for the class <code>{@link ProcessInstance}</code>.
 *
 * @generated at 17/5/20 2:11 PM
 * @version $Revision: 1.0 $
 */
public class ProcessInstanceTest {
	/**
	 * Run the ProcessInstance() constructor test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:11 PM
	 */
	@Test
	public void testProcessInstance_1()
		throws Exception {

		ProcessInstance result = new ProcessInstance();

		
		assertNotNull(result);
		assertEquals(null, result.getComment());
		assertEquals("ProcessInstance(id=null, tenantId=null, businessService=null, businessId=null, action=null, moduleName=null, state=null, comment=null, documents=null, assigner=null, assignee=null, nextActions=null, stateSla=null, businesssServiceSla=null, previousStatus=null, entity=null, auditDetails=null)", result.toString());
		assertEquals(null, result.getId());
		assertEquals(null, result.getState());
		assertEquals(null, result.getEntity());
		assertEquals(null, result.getModuleName());
		assertEquals(null, result.getAction());
		assertEquals(null, result.getBusinessId());
		assertEquals(null, result.getStateSla());
		assertEquals(null, result.getNextActions());
		assertEquals(null, result.getAssigner());
		assertEquals(null, result.getDocuments());
		assertEquals(null, result.getTenantId());
		assertEquals(null, result.getAssignee());
		assertEquals(null, result.getBusinessService());
		assertEquals(null, result.getPreviousStatus());
		assertEquals(null, result.getBusinesssServiceSla());
		assertEquals(null, result.getAuditDetails());
	}

	/**
	 * Run the ProcessInstance(String,String,String,String,String,String,State,String,List<Document>,User,User,List<Action>,Long,Long,String,Object,AuditDetails) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:11 PM
	 */
	@Test
	public void testProcessInstance_2()
		throws Exception {
		String id = "";
		String tenantId = "";
		String businessService = "";
		String businessId = "";
		String action = "";
		String moduleName = "";
		State state = null;
		String comment = "";
		List<Document> documents =null;
		User assigner = null;
		User assignee = null;
		List<Action> nextActions =null;
		Long stateSla = new Long(1L);
		Long businesssServiceSla = new Long(1L);
		String previousStatus = "";
		Object entity = null;
		AuditDetails auditDetails = null;

		ProcessInstance result = new ProcessInstance(id, tenantId, businessService, businessId, action, moduleName, state, comment, documents, assigner, assignee, nextActions, stateSla, businesssServiceSla, previousStatus, entity, auditDetails);

		assertNotNull(result);
		assertEquals("", result.getComment());
		assertEquals("ProcessInstance(id=, tenantId=, businessService=, businessId=, action=, moduleName=, state=null, comment=, documents=null, assigner=null, assignee=null, nextActions=null, stateSla=1, businesssServiceSla=1, previousStatus=, entity=null, auditDetails=null)", result.toString());
		assertEquals("", result.getId());
		assertEquals(null, result.getEntity());
		assertEquals("", result.getModuleName());
		assertEquals("", result.getAction());
		assertEquals("", result.getBusinessId());
		assertEquals(new Long(1L), result.getStateSla());
		assertEquals("", result.getTenantId());
		assertEquals("", result.getBusinessService());
		assertEquals("", result.getPreviousStatus());
		assertEquals(new Long(1L), result.getBusinesssServiceSla());
	}

	/**
	 * Run the ProcessInstance addDocumentsItem(Document) method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:11 PM
	 */
	@Test
	public void testAddDocumentsItem_1()
		throws Exception {
		ProcessInstance fixture = new ProcessInstance("", "", "", "", "", "", new State(), "", null, new User(), new User(), null, new Long(1L), new Long(1L), "", new Object(), new AuditDetails());
		Document documentsItem = null;

		ProcessInstance result = fixture.addDocumentsItem(documentsItem);

		assertNotNull(result);
	}


	/**
	 * Run the ProcessInstance addNextActionsItem(Action) method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:11 PM
	 */
	@Test
	public void testAddNextActionsItem_1()
		throws Exception {
		ProcessInstance fixture = new ProcessInstance("", "", "", "", "", "", new State(), "", null, new User(), new User(), (List<Action>) null, new Long(1L), new Long(1L), "", null, null);
		Action nextActionsItem = null;

		ProcessInstance result = fixture.addNextActionsItem(nextActionsItem);

		
		assertNotNull(result);
		assertEquals("", result.getComment());
		assertEquals("ProcessInstance(id=, tenantId=, businessService=, businessId=, action=, moduleName=, state=State(uuid=null, tenantId=null, businessServiceId=null, sla=null, state=null, applicationStatus=null, docUploadRequired=null, isStartState=null, isTerminateState=null, isStateUpdatable=null, actions=null, auditDetails=null), comment=, documents=null, assigner=User(id=null, userName=null, name=null, type=null, mobileNumber=null, emailId=null, roles=null, tenantId=null, uuid=null), assignee=User(id=null, userName=null, name=null, type=null, mobileNumber=null, emailId=null, roles=null, tenantId=null, uuid=null), nextActions=[null], stateSla=1, businesssServiceSla=1, previousStatus=, entity=null, auditDetails=null)", result.toString());
		assertEquals("", result.getId());
		assertEquals(null, result.getEntity());
		assertEquals("", result.getModuleName());
		assertEquals("", result.getAction());
		assertEquals("", result.getBusinessId());
		assertEquals(new Long(1L), result.getStateSla());
		assertEquals("", result.getTenantId());
		assertEquals("", result.getBusinessService());
		assertEquals("", result.getPreviousStatus());
		assertEquals(new Long(1L), result.getBusinesssServiceSla());
	}

	/**
	 * Run the ProcessInstance.ProcessInstanceBuilder builder() method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:11 PM
	 */
	@Test
	public void testBuilder_1()
		throws Exception {

		ProcessInstance.ProcessInstanceBuilder result = ProcessInstance.builder();

		
		assertNotNull(result);
		assertEquals("ProcessInstance.ProcessInstanceBuilder(id=null, tenantId=null, businessService=null, businessId=null, action=null, moduleName=null, state=null, comment=null, documents=null, assigner=null, assignee=null, nextActions=null, stateSla=null, businesssServiceSla=null, previousStatus=null, entity=null, auditDetails=null)", result.toString());
	}
	
	@Test
	public void testBuilder_2()
		throws Exception {

		ProcessInstance.ProcessInstanceBuilder builder = new ProcessInstance.ProcessInstanceBuilder();
		builder.id(null);
		builder.businessService(null);
		builder.businessId(null);
		builder.action(null);
		builder.moduleName(null);
		builder.state(null);
		builder.comment(null);
		builder.assigner(null);
		builder.assignee(null);
		builder.nextActions(null);
		builder.stateSla(null);
		builder.businesssServiceSla(null);
		builder.previousStatus(null);
		builder.entity(null);
		builder.auditDetails(null);
		builder.tenantId(null);
		builder.build();

		ProcessInstance.ProcessInstanceBuilder builder2 = new ProcessInstance.ProcessInstanceBuilder();
		builder2.id(null);
		builder2.businessService(null);
		builder2.businessId(null);
		builder2.action(null);
		builder2.moduleName(null);
		builder2.state(null);
		builder2.comment(null);
		builder2.assigner(null);
		builder2.assignee(null);
		builder2.nextActions(null);
		builder2.stateSla(null);
		builder2.businesssServiceSla(null);
		builder2.previousStatus(null);
		builder2.entity(null);
		builder2.auditDetails(null);
		builder2.tenantId(null);
		builder2.build();

		Assert.assertEquals(builder2.toString(), builder.toString());
	}

	/**
	 * Run the boolean canEqual(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:11 PM
	 */
	@Test
	public void testCanEqual_1()
		throws Exception {
		ProcessInstance fixture = new ProcessInstance("", "", "", "", "", "", new State(), "", null, new User(), new User(), null, new Long(1L), new Long(1L), "", new Object(), new AuditDetails());
		Object other = new Object();

		boolean result = fixture.canEqual(other);

		
		assertEquals(false, result);
	}

	/**
	 * Run the boolean canEqual(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:11 PM
	 */
	@Test
	public void testCanEqual_2()
		throws Exception {
		ProcessInstance fixture = new ProcessInstance("", "", "", "", "", "", new State(), "", null, new User(), new User(), null, new Long(1L), new Long(1L), "", new Object(), new AuditDetails());
		Object other = new Object();

		boolean result = fixture.canEqual(other);

		
		assertEquals(false, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:11 PM
	 */
	@Test
	public void testEquals_1()
		throws Exception {
		ProcessInstance fixture = new ProcessInstance("", "", "", "", "", "", new State(), "", null, new User(), new User(), null, new Long(1L), new Long(1L), "", new Object(), new AuditDetails());
		Object o = new ProcessInstance("", "", "", "", "", "", new State(), "", null, new User(), new User(), null, new Long(1L), new Long(1L), "", new Object(), new AuditDetails());

		boolean result = fixture.equals(o);

		
		assertEquals(true, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:11 PM
	 */
	@Test
	public void testEquals_2()
		throws Exception {
		ProcessInstance fixture = new ProcessInstance("", "", "", "", "", "", new State(), "", null, new User(), new User(), null, new Long(1L), new Long(1L), "", new Object(), new AuditDetails());
		Object o = new Object();

		boolean result = fixture.equals(o);

		
		assertEquals(false, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:11 PM
	 */
	@Test
	public void testEquals_3()
		throws Exception {
		ProcessInstance fixture = new ProcessInstance("", "", "", "", "", "", new State(), "", null, new User(), new User(), null, new Long(1L), new Long(1L), "", new Object(), new AuditDetails());
		Object o = new ProcessInstance("", "", "", "", "", "", new State(), "", null, new User(), new User(), null, new Long(1L), new Long(1L), "", new Object(), new AuditDetails());

		boolean result = fixture.equals(o);

		
		assertEquals(true, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:11 PM
	 */
	@Test
	public void testEquals_4()
		throws Exception {
		ProcessInstance fixture = new ProcessInstance("", "", "", "", "", "", new State(), "", null, new User(), new User(), null, new Long(1L), new Long(1L), "", new Object(), new AuditDetails());
		Object o = new ProcessInstance("", "", "", "", "", "", new State(), "", null, new User(), new User(), null, new Long(1L), new Long(1L), "", new Object(), new AuditDetails());

		boolean result = fixture.equals(o);

		
		assertEquals(true, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:11 PM
	 */
	@Test
	public void testEquals_5()
		throws Exception {
		ProcessInstance fixture = new ProcessInstance((String) null, "", "", "", "", "", new State(), "", null, new User(), new User(), null, new Long(1L), new Long(1L), "", new Object(), new AuditDetails());
		Object o = new ProcessInstance((String) null, "", "", "", "", "", new State(), "", null, new User(), new User(), null, new Long(1L), new Long(1L), "", new Object(), new AuditDetails());

		boolean result = fixture.equals(o);

		
		assertEquals(true, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:11 PM
	 */
	@Test
	public void testEquals_6()
		throws Exception {
		ProcessInstance fixture = new ProcessInstance("", "", "", "", "", "", new State(), "", null, new User(), new User(), null, new Long(1L), new Long(1L), "", new Object(), new AuditDetails());
		Object o = new ProcessInstance("", "", "", "", "", "", new State(), "", null, new User(), new User(), null, new Long(1L), new Long(1L), "", new Object(), new AuditDetails());

		boolean result = fixture.equals(o);

		
		assertEquals(true, result);
	}

	/**
	 * Run the String getAction() method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:11 PM
	 */
	@Test
	public void testGetAction_1()
		throws Exception {
		ProcessInstance fixture = new ProcessInstance("", "", "", "", "", "", new State(), "", null, new User(), new User(), null, new Long(1L), new Long(1L), "", new Object(), new AuditDetails());

		String result = fixture.getAction();

		
		assertEquals("", result);
	}

	/**
	 * Run the User getAssignee() method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:11 PM
	 */
	@Test
	public void testGetAssignee_1()
		throws Exception {
		ProcessInstance fixture = new ProcessInstance("", "", "", "", "", "", new State(), "", null, new User(), new User(), null, new Long(1L), new Long(1L), "", new Object(), new AuditDetails());

		User result = fixture.getAssignee();

		
		assertNotNull(result);
		assertEquals("User(id=null, userName=null, name=null, type=null, mobileNumber=null, emailId=null, roles=null, tenantId=null, uuid=null)", result.toString());
		assertEquals(null, result.getName());
		assertEquals(null, result.getId());
		assertEquals(null, result.getType());
		assertEquals(null, result.getUserName());
		assertEquals(null, result.getRoles());
		assertEquals(null, result.getTenantId());
		assertEquals(null, result.getEmailId());
		assertEquals(null, result.getMobileNumber());
		assertEquals(null, result.getUuid());
	}

	/**
	 * Run the User getAssigner() method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:11 PM
	 */
	@Test
	public void testGetAssigner_1()
		throws Exception {
		ProcessInstance fixture = new ProcessInstance("", "", "", "", "", "", new State(), "", null, new User(), new User(), null, new Long(1L), new Long(1L), "", new Object(), new AuditDetails());

		User result = fixture.getAssigner();

		
		assertNotNull(result);
		assertEquals("User(id=null, userName=null, name=null, type=null, mobileNumber=null, emailId=null, roles=null, tenantId=null, uuid=null)", result.toString());
		assertEquals(null, result.getName());
		assertEquals(null, result.getId());
		assertEquals(null, result.getType());
		assertEquals(null, result.getUserName());
		assertEquals(null, result.getRoles());
		assertEquals(null, result.getTenantId());
		assertEquals(null, result.getEmailId());
		assertEquals(null, result.getMobileNumber());
		assertEquals(null, result.getUuid());
	}

	/**
	 * Run the AuditDetails getAuditDetails() method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:11 PM
	 */
	@Test
	public void testGetAuditDetails_1()
		throws Exception {
		ProcessInstance fixture = new ProcessInstance("", "", "", "", "", "", new State(), "", null, new User(), new User(), null, new Long(1L), new Long(1L), "", new Object(), new AuditDetails());

		AuditDetails result = fixture.getAuditDetails();

		
		assertNotNull(result);
		assertEquals(null, result.getLastModifiedTime());
		assertEquals(null, result.getLastModifiedBy());
		assertEquals(null, result.getCreatedBy());
		assertEquals(null, result.getUserRole());
		assertEquals(null, result.getCreatedTime());
	}

	/**
	 * Run the String getBusinessId() method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:11 PM
	 */
	@Test
	public void testGetBusinessId_1()
		throws Exception {
		ProcessInstance fixture = new ProcessInstance("", "", "", "", "", "", new State(), "", null, new User(), new User(), null, new Long(1L), new Long(1L), "", new Object(), new AuditDetails());

		String result = fixture.getBusinessId();

		
		assertEquals("", result);
	}

	/**
	 * Run the String getBusinessService() method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:11 PM
	 */
	@Test
	public void testGetBusinessService_1()
		throws Exception {
		ProcessInstance fixture = new ProcessInstance("", "", "", "", "", "", new State(), "", null, new User(), new User(), null, new Long(1L), new Long(1L), "", new Object(), new AuditDetails());

		String result = fixture.getBusinessService();

		
		assertEquals("", result);
	}

	/**
	 * Run the Long getBusinesssServiceSla() method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:11 PM
	 */
	@Test
	public void testGetBusinesssServiceSla_1()
		throws Exception {
		ProcessInstance fixture = new ProcessInstance("", "", "", "", "", "", new State(), "", null, new User(), new User(), null, new Long(1L), new Long(1L), "", new Object(), new AuditDetails());

		Long result = fixture.getBusinesssServiceSla();

		
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
	 * Run the String getComment() method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:11 PM
	 */
	@Test
	public void testGetComment_1()
		throws Exception {
		ProcessInstance fixture = new ProcessInstance("", "", "", "", "", "", new State(), "", null, new User(), new User(), null, new Long(1L), new Long(1L), "", new Object(), new AuditDetails());

		String result = fixture.getComment();

		
		assertEquals("", result);
	}

	/**
	 * Run the List<Document> getDocuments() method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:11 PM
	 */
	@Test
	public void testGetDocuments_1()
		throws Exception {
		ProcessInstance fixture = new ProcessInstance("", "", "", "", "", "", new State(), "", null, new User(), new User(), null, new Long(1L), new Long(1L), "", new Object(), new AuditDetails());

		List<Document> result = fixture.getDocuments();
		assertEquals(null, result);
	}

	/**
	 * Run the Object getEntity() method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:11 PM
	 */
	@Test
	public void testGetEntity_1()
		throws Exception {
		ProcessInstance fixture = new ProcessInstance("", "", "", "", "", "", new State(), "", null, new User(), new User(), null, new Long(1L), new Long(1L), "", new Object(), new AuditDetails());

		Object result = fixture.getEntity();

		
		assertNotNull(result);
	}

	/**
	 * Run the String getId() method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:11 PM
	 */
	@Test
	public void testGetId_1()
		throws Exception {
		ProcessInstance fixture = new ProcessInstance("", "", "", "", "", "", new State(), "", null, new User(), new User(), null, new Long(1L), new Long(1L), "", new Object(), new AuditDetails());

		String result = fixture.getId();

		
		assertEquals("", result);
	}

	/**
	 * Run the String getModuleName() method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:11 PM
	 */
	@Test
	public void testGetModuleName_1()
		throws Exception {
		ProcessInstance fixture = new ProcessInstance("", "", "", "", "", "", new State(), "", null, new User(), new User(), null, new Long(1L), new Long(1L), "", new Object(), new AuditDetails());

		String result = fixture.getModuleName();

		
		assertEquals("", result);
	}

	/**
	 * Run the List<Action> getNextActions() method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:11 PM
	 */
	@Test
	public void testGetNextActions_1()
		throws Exception {
		ProcessInstance fixture = new ProcessInstance("", "", "", "", "", "", new State(), "", null, new User(), new User(), null, new Long(1L), new Long(1L), "", new Object(), new AuditDetails());

		List<Action> result = fixture.getNextActions();
		assertEquals(null, result);
	}

	/**
	 * Run the String getPreviousStatus() method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:11 PM
	 */
	@Test
	public void testGetPreviousStatus_1()
		throws Exception {
		ProcessInstance fixture = new ProcessInstance("", "", "", "", "", "", new State(), "", null, new User(), new User(), null, new Long(1L), new Long(1L), "", new Object(), new AuditDetails());

		String result = fixture.getPreviousStatus();

		
		assertEquals("", result);
	}

	/**
	 * Run the State getState() method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:11 PM
	 */
	@Test
	public void testGetState_1()
		throws Exception {
		ProcessInstance fixture = new ProcessInstance("", "", "", "", "", "", new State(), "", null, new User(), new User(), null, new Long(1L), new Long(1L), "", new Object(), new AuditDetails());

		State result = fixture.getState();

		
		assertNotNull(result);
		assertEquals("State(uuid=null, tenantId=null, businessServiceId=null, sla=null, state=null, applicationStatus=null, docUploadRequired=null, isStartState=null, isTerminateState=null, isStateUpdatable=null, actions=null, auditDetails=null)", result.toString());
		assertEquals(null, result.getActions());
		assertEquals(null, result.getState());
		assertEquals(null, result.getTenantId());
		assertEquals(null, result.getSla());
		assertEquals(null, result.getIsStartState());
		assertEquals(null, result.getApplicationStatus());
		assertEquals(null, result.getIsTerminateState());
		assertEquals(null, result.getDocUploadRequired());
		assertEquals(null, result.getIsStateUpdatable());
		assertEquals(null, result.getBusinessServiceId());
		assertEquals(null, result.getAuditDetails());
		assertEquals(null, result.getUuid());
	}

	/**
	 * Run the Long getStateSla() method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:11 PM
	 */
	@Test
	public void testGetStateSla_1()
		throws Exception {
		ProcessInstance fixture = new ProcessInstance("", "", "", "", "", "", new State(), "", null, new User(), new User(), null, new Long(1L), new Long(1L), "", new Object(), new AuditDetails());

		Long result = fixture.getStateSla();

		
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
	 * Run the String getTenantId() method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:11 PM
	 */
	@Test
	public void testGetTenantId_1()
		throws Exception {
		ProcessInstance fixture = new ProcessInstance("", "", "", "", "", "", new State(), "", null, new User(), new User(), null, new Long(1L), new Long(1L), "", new Object(), new AuditDetails());

		String result = fixture.getTenantId();

		
		assertEquals("", result);
	}

	/**
	 * Run the int hashCode() method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:11 PM
	 */
	@Test
	public void testHashCode_1()
		throws Exception {
		ProcessInstance fixture = new ProcessInstance("", "", "", "", "", "", new State(), "", null, new User(), new User(), null, new Long(1L), new Long(1L), "", new Object(), new AuditDetails());

		int result = fixture.hashCode();

		
		assertEquals(59, result);
	}

	/**
	 * Run the int hashCode() method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:11 PM
	 */
	@Test
	public void testHashCode_2()
		throws Exception {
		ProcessInstance fixture = new ProcessInstance((String) null, "", "", "", "", "", new State(), "", null, new User(), new User(), null, new Long(1L), new Long(1L), "", new Object(), new AuditDetails());

		int result = fixture.hashCode();

		
		assertEquals(102, result);
	}

	/**
	 * Run the void setAction(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:11 PM
	 */
	@Test
	public void testSetAction_1()
		throws Exception {
		ProcessInstance fixture = new ProcessInstance("", "", "", "", "", "", new State(), "", null, new User(), new User(), null, new Long(1L), new Long(1L), "", new Object(), new AuditDetails());
		String action = "";

		fixture.setAction(action);

		
	}

	/**
	 * Run the void setAssignee(User) method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:11 PM
	 */
	@Test
	public void testSetAssignee_1()
		throws Exception {
		ProcessInstance fixture = new ProcessInstance("", "", "", "", "", "", new State(), "", null, new User(), new User(), null, new Long(1L), new Long(1L), "", new Object(), new AuditDetails());
		User assignee = new User();

		fixture.setAssignee(assignee);

		
	}

	/**
	 * Run the void setAssigner(User) method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:11 PM
	 */
	@Test
	public void testSetAssigner_1()
		throws Exception {
		ProcessInstance fixture = new ProcessInstance("", "", "", "", "", "", new State(), "", null, new User(), new User(), null, new Long(1L), new Long(1L), "", new Object(), new AuditDetails());
		User assigner = new User();

		fixture.setAssigner(assigner);

		
	}

	/**
	 * Run the void setAuditDetails(AuditDetails) method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:11 PM
	 */
	@Test
	public void testSetAuditDetails_1()
		throws Exception {
		ProcessInstance fixture = new ProcessInstance("", "", "", "", "", "", new State(), "", null, new User(), new User(), null, new Long(1L), new Long(1L), "", new Object(), new AuditDetails());
		AuditDetails auditDetails = new AuditDetails();

		fixture.setAuditDetails(auditDetails);

		
	}

	/**
	 * Run the void setBusinessId(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:11 PM
	 */
	@Test
	public void testSetBusinessId_1()
		throws Exception {
		ProcessInstance fixture = new ProcessInstance("", "", "", "", "", "", new State(), "", null, new User(), new User(), null, new Long(1L), new Long(1L), "", new Object(), new AuditDetails());
		String businessId = "";

		fixture.setBusinessId(businessId);

		
	}

	/**
	 * Run the void setBusinessService(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:11 PM
	 */
	@Test
	public void testSetBusinessService_1()
		throws Exception {
		ProcessInstance fixture = new ProcessInstance("", "", "", "", "", "", new State(), "", null, new User(), new User(), null, new Long(1L), new Long(1L), "", new Object(), new AuditDetails());
		String businessService = "";

		fixture.setBusinessService(businessService);

		
	}

	/**
	 * Run the void setBusinesssServiceSla(Long) method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:11 PM
	 */
	@Test
	public void testSetBusinesssServiceSla_1()
		throws Exception {
		ProcessInstance fixture = new ProcessInstance("", "", "", "", "", "", new State(), "", null, new User(), new User(), null, new Long(1L), new Long(1L), "", new Object(), new AuditDetails());
		Long businesssServiceSla = new Long(1L);

		fixture.setBusinesssServiceSla(businesssServiceSla);

		
	}

	/**
	 * Run the void setComment(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:11 PM
	 */
	@Test
	public void testSetComment_1()
		throws Exception {
		ProcessInstance fixture = new ProcessInstance("", "", "", "", "", "", new State(), "", null, new User(), new User(), null, new Long(1L), new Long(1L), "", new Object(), new AuditDetails());
		String comment = "";

		fixture.setComment(comment);

		
	}

	/**
	 * Run the void setDocuments(List<Document>) method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:11 PM
	 */
	@Test
	public void testSetDocuments_1()
		throws Exception {
		ProcessInstance fixture = new ProcessInstance("", "", "", "", "", "", new State(), "", null, new User(), new User(), null, new Long(1L), new Long(1L), "", new Object(), new AuditDetails());
		List<Document> documents =null;

		fixture.setDocuments(documents);
			}

	/**
	 * Run the void setEntity(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:11 PM
	 */
	@Test
	public void testSetEntity_1()
		throws Exception {
		ProcessInstance fixture = new ProcessInstance("", "", "", "", "", "", new State(), "", null, new User(), new User(), null, new Long(1L), new Long(1L), "", new Object(), new AuditDetails());
		Object entity = new Object();

		fixture.setEntity(entity);

		
	}

	/**
	 * Run the void setId(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:11 PM
	 */
	@Test
	public void testSetId_1()
		throws Exception {
		ProcessInstance fixture = new ProcessInstance("", "", "", "", "", "", new State(), "", null, new User(), new User(), null, new Long(1L), new Long(1L), "", new Object(), new AuditDetails());
		String id = "";

		fixture.setId(id);

		
	}

	/**
	 * Run the void setModuleName(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:11 PM
	 */
	@Test
	public void testSetModuleName_1()
		throws Exception {
		ProcessInstance fixture = new ProcessInstance("", "", "", "", "", "", new State(), "", null, new User(), new User(), null, new Long(1L), new Long(1L), "", new Object(), new AuditDetails());
		String moduleName = "";

		fixture.setModuleName(moduleName);

		
	}

	/**
	 * Run the void setNextActions(List<Action>) method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:11 PM
	 */
	@Test
	public void testSetNextActions_1()
		throws Exception {
		ProcessInstance fixture = new ProcessInstance("", "", "", "", "", "", new State(), "", null, new User(), new User(), null, new Long(1L), new Long(1L), "", new Object(), new AuditDetails());
		List<Action> nextActions =null;
		fixture.setNextActions(nextActions);
	}

	/**
	 * Run the void setPreviousStatus(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:11 PM
	 */
	@Test
	public void testSetPreviousStatus_1()
		throws Exception {
		ProcessInstance fixture = new ProcessInstance("", "", "", "", "", "", new State(), "", null, new User(), new User(), null, new Long(1L), new Long(1L), "", new Object(), new AuditDetails());
		String previousStatus = "";

		fixture.setPreviousStatus(previousStatus);

		
	}

	/**
	 * Run the void setState(State) method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:11 PM
	 */
	@Test
	public void testSetState_1()
		throws Exception {
		ProcessInstance fixture = new ProcessInstance("", "", "", "", "", "", new State(), "", null, new User(), new User(), null, new Long(1L), new Long(1L), "", new Object(), new AuditDetails());
		State state = new State();

		fixture.setState(state);

		
	}

	/**
	 * Run the void setStateSla(Long) method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:11 PM
	 */
	@Test
	public void testSetStateSla_1()
		throws Exception {
		ProcessInstance fixture = new ProcessInstance("", "", "", "", "", "", new State(), "", null, new User(), new User(), null, new Long(1L), new Long(1L), "", new Object(), new AuditDetails());
		Long stateSla = new Long(1L);

		fixture.setStateSla(stateSla);

		
	}

	/**
	 * Run the void setTenantId(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generated at 17/5/20 2:11 PM
	 */
	@Test
	public void testSetTenantId_1()
		throws Exception {
		ProcessInstance fixture = new ProcessInstance("", "", "", "", "", "", new State(), "", null, new User(), new User(), null, new Long(1L), new Long(1L), "", new Object(), new AuditDetails());
		String tenantId = "";

		fixture.setTenantId(tenantId);

		
	}

	/**
	 * Perform pre-test initialization.
	 *
	 * @throws Exception
	 *         if the initialization fails for some reason
	 *
	 * @generated at 17/5/20 2:11 PM
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
	 * @generated at 17/5/20 2:11 PM
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
	 * @generated at 17/5/20 2:11 PM
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(ProcessInstanceTest.class);
	}
}