package org.egov.prscp.web.models;

import java.util.List;
import org.easymock.EasyMock;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * The class <code>ProcessInstanceTest</code> contains tests for the class <code>{@link ProcessInstance}</code>.
 *
 * @generatedBy CodePro at 25/5/20 3:48 PM
 * @author Aniket.Marathe
 * @version $Revision: 1.0 $
 */
public class ProcessInstanceTest {
	/**
	 * Run the ProcessInstance() constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:48 PM
	 */
	@Test
	public void testProcessInstance_1()
		throws Exception {

		ProcessInstance result = new ProcessInstance();

		// add additional test code here
		assertNotNull(result);
		assertEquals(null, result.getComment());
		assertEquals("ProcessInstance(id=null, tenantId=null, businessService=null, businessId=null, action=null, moduleName=null, state=null, comment=null, documents=null, assigner=null, assignee=null, nextActions=null, stateSla=null, businesssServiceSla=null, previousStatus=null, entity=null, auditDetails=null)", result.toString());
		assertEquals(null, result.getId());
		assertEquals(null, result.getState());
		assertEquals(null, result.getAction());
		assertEquals(null, result.getEntity());
		assertEquals(null, result.getModuleName());
		assertEquals(null, result.getDocuments());
		assertEquals(null, result.getTenantId());
		assertEquals(null, result.getAssignee());
		assertEquals(null, result.getAuditDetails());
		assertEquals(null, result.getBusinesssServiceSla());
		assertEquals(null, result.getBusinessService());
		assertEquals(null, result.getPreviousStatus());
		assertEquals(null, result.getNextActions());
		assertEquals(null, result.getStateSla());
		assertEquals(null, result.getBusinessId());
		assertEquals(null, result.getAssigner());
	}

	/**
	 * Run the ProcessInstance(String,String,String,String,String,String,State,String,List<Document>,User,User,List<Action>,Long,Long,String,Object,AuditDetails) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:48 PM
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
		State state = new State();
		String comment = "";
		List<Document> documents = EasyMock.createMock(List.class);
		org.egov.common.contract.request.User assigner = new org.egov.common.contract.request.User();
		org.egov.common.contract.request.User assignee = new org.egov.common.contract.request.User();
		List<Action> nextActions = EasyMock.createMock(List.class);
		Long stateSla = new Long(1L);
		Long businesssServiceSla = new Long(1L);
		String previousStatus = "";
		Object entity = new Object();
		AuditDetails auditDetails = new AuditDetails();
		// add mock object expectations here

		EasyMock.replay(documents);
		EasyMock.replay(nextActions);

		ProcessInstance result = new ProcessInstance(id, tenantId, businessService, businessId, action, moduleName, state, comment, documents, assigner, assignee, nextActions, stateSla, businesssServiceSla, previousStatus, entity, auditDetails);

		// add additional test code here
		EasyMock.verify(documents);
		EasyMock.verify(nextActions);
		assertNotNull(result);
		assertEquals("", result.getComment());
		//assertEquals("ProcessInstance(id=, tenantId=, businessService=, businessId=, action=, moduleName=, state=State(uuid=null, tenantId=null, businessServiceId=null, sla=null, state=null, applicationStatus=null, docUploadRequired=null, isStartState=null, isTerminateState=null, isStateUpdatable=null, actions=null, auditDetails=null), comment=, documents=EasyMock for interface java.util.List, assigner=User(id=null, userName=null, name=null, type=null, mobileNumber=null, emailId=null, roles=null, tenantId=null, uuid=null), assignee=User(id=null, userName=null, name=null, type=null, mobileNumber=null, emailId=null, roles=null, tenantId=null, uuid=null), nextActions=EasyMock for interface java.util.List, stateSla=1, businesssServiceSla=1, previousStatus=, entity=java.lang.Object@40be4895, auditDetails=org.egov.prscp.web.models.AuditDetails@4e79aef2)", result.toString());
		assertEquals("", result.getId());
		assertEquals("", result.getAction());
		//assertEquals(new Object(), result.getEntity());
		assertEquals("", result.getModuleName());
		assertEquals("", result.getTenantId());
		assertEquals(new Long(1L), result.getBusinesssServiceSla());
		assertEquals("", result.getBusinessService());
		assertEquals("", result.getPreviousStatus());
		assertEquals(new Long(1L), result.getStateSla());
		assertEquals("", result.getBusinessId());
	}

	
	@Test
	public void testAddDocumentsItem_2()
		throws Exception {
		ProcessInstance fixture = new ProcessInstance("", "", "", "", "", "", new State(), "", (List<Document>) null, new org.egov.common.contract.request.User(), new org.egov.common.contract.request.User(), EasyMock.createNiceMock(List.class), new Long(1L), new Long(1L), "", new Object(), new AuditDetails());
		Document documentsItem = DocumentFactory.createDocument2();

		ProcessInstance result = fixture.addDocumentsItem(documentsItem);

		// add additional test code here
		assertNotNull(result);
		assertEquals("", result.getComment());
		//assertEquals("ProcessInstance(id=, tenantId=, businessService=, businessId=, action=, moduleName=, state=State(uuid=null, tenantId=null, businessServiceId=null, sla=null, state=null, applicationStatus=null, docUploadRequired=null, isStartState=null, isTerminateState=null, isStateUpdatable=null, actions=null, auditDetails=null), comment=, documents=[org.egov.prscp.web.models.Document@5e774640], assigner=User(id=null, userName=null, name=null, type=null, mobileNumber=null, emailId=null, roles=null, tenantId=null, uuid=null), assignee=User(id=null, userName=null, name=null, type=null, mobileNumber=null, emailId=null, roles=null, tenantId=null, uuid=null), nextActions=EasyMock for interface java.util.List, stateSla=1, businesssServiceSla=1, previousStatus=, entity=java.lang.Object@21ecffc6, auditDetails=org.egov.prscp.web.models.AuditDetails@2f2b058b)", result.toString());
		assertEquals("", result.getId());
		assertEquals("", result.getAction());
		//assertEquals(new Object(), result.getEntity());
		assertEquals("", result.getModuleName());
		assertEquals("", result.getTenantId());
		assertEquals(new Long(1L), result.getBusinesssServiceSla());
		assertEquals("", result.getBusinessService());
		assertEquals("", result.getPreviousStatus());
		assertEquals(new Long(1L), result.getStateSla());
		assertEquals("", result.getBusinessId());
	}

	/**
	 * Run the ProcessInstance addNextActionsItem(Action) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:48 PM
	 */
	@Test
	public void testAddNextActionsItem_1()
		throws Exception {
		ProcessInstance fixture = new ProcessInstance("", "", "", "", "", "", new State(), "", EasyMock.createNiceMock(List.class), new org.egov.common.contract.request.User(), new org.egov.common.contract.request.User(), (List<Action>) null, new Long(1L), new Long(1L), "", new Object(), new AuditDetails());
		Action nextActionsItem = ActionFactory.createAction();

		ProcessInstance result = fixture.addNextActionsItem(nextActionsItem);

		// add additional test code here
		assertNotNull(result);
		assertEquals("", result.getComment());
	//	assertEquals("ProcessInstance(id=, tenantId=, businessService=, businessId=, action=, moduleName=, state=State(uuid=null, tenantId=null, businessServiceId=null, sla=null, state=null, applicationStatus=null, docUploadRequired=null, isStartState=null, isTerminateState=null, isStateUpdatable=null, actions=null, auditDetails=null), comment=, documents=EasyMock for interface java.util.List, assigner=User(id=null, userName=null, name=null, type=null, mobileNumber=null, emailId=null, roles=null, tenantId=null, uuid=null), assignee=User(id=null, userName=null, name=null, type=null, mobileNumber=null, emailId=null, roles=null, tenantId=null, uuid=null), nextActions=[Action(uuid=0123456789, tenantId=0123456789, currentState=0123456789, action=0123456789, nextState=0123456789, roles=[, 0123456789], auditDetails=org.egov.prscp.web.models.AuditDetails@3c77109b)], stateSla=1, businesssServiceSla=1, previousStatus=, entity=java.lang.Object@384883cd, auditDetails=org.egov.prscp.web.models.AuditDetails@7d4a1aa0)", result.toString());
		assertEquals("", result.getId());
		assertEquals("", result.getAction());
		//assertEquals(new Object(), result.getEntity());
		assertEquals("", result.getModuleName());
		assertEquals("", result.getTenantId());
		assertEquals(new Long(1L), result.getBusinesssServiceSla());
		assertEquals("", result.getBusinessService());
		assertEquals("", result.getPreviousStatus());
		assertEquals(new Long(1L), result.getStateSla());
		assertEquals("", result.getBusinessId());
	}

	/**
	 * Run the ProcessInstance addNextActionsItem(Action) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:48 PM
	 */
	@Test
	public void testAddNextActionsItem_2()
		throws Exception {
		ProcessInstance fixture = new ProcessInstance("", "", "", "", "", "", new State(), "", EasyMock.createNiceMock(List.class), new org.egov.common.contract.request.User(), new org.egov.common.contract.request.User(), EasyMock.createNiceMock(List.class), new Long(1L), new Long(1L), "", new Object(), new AuditDetails());
		Action nextActionsItem = ActionFactory.createAction2();

		ProcessInstance result = fixture.addNextActionsItem(nextActionsItem);

		// add additional test code here
		assertNotNull(result);
		assertEquals("", result.getComment());
		//assertEquals("ProcessInstance(id=, tenantId=, businessService=, businessId=, action=, moduleName=, state=State(uuid=null, tenantId=null, businessServiceId=null, sla=null, state=null, applicationStatus=null, docUploadRequired=null, isStartState=null, isTerminateState=null, isStateUpdatable=null, actions=null, auditDetails=null), comment=, documents=EasyMock for interface java.util.List, assigner=User(id=null, userName=null, name=null, type=null, mobileNumber=null, emailId=null, roles=null, tenantId=null, uuid=null), assignee=User(id=null, userName=null, name=null, type=null, mobileNumber=null, emailId=null, roles=null, tenantId=null, uuid=null), nextActions=EasyMock for interface java.util.List, stateSla=1, businesssServiceSla=1, previousStatus=, entity=java.lang.Object@7ea6cc5c, auditDetails=org.egov.prscp.web.models.AuditDetails@70613df8)", result.toString());
		assertEquals("", result.getId());
		assertEquals("", result.getAction());
		//assertEquals(new Object(), result.getEntity());
		assertEquals("", result.getModuleName());
		assertEquals("", result.getTenantId());
		assertEquals(new Long(1L), result.getBusinesssServiceSla());
		assertEquals("", result.getBusinessService());
		assertEquals("", result.getPreviousStatus());
		assertEquals(new Long(1L), result.getStateSla());
		assertEquals("", result.getBusinessId());
	}

	/**
	 * Run the ProcessInstance.ProcessInstanceBuilder builder() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:48 PM
	 */
	@Test
	public void testBuilder_1()
		throws Exception {

		ProcessInstance.ProcessInstanceBuilder result = ProcessInstance.builder();

		// add additional test code here
		assertNotNull(result);
		assertEquals("ProcessInstance.ProcessInstanceBuilder(id=null, tenantId=null, businessService=null, businessId=null, action=null, moduleName=null, state=null, comment=null, documents=null, assigner=null, assignee=null, nextActions=null, stateSla=null, businesssServiceSla=null, previousStatus=null, entity=null, auditDetails=null)", result.toString());
	}

	/**
	 * Run the boolean canEqual(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:48 PM
	 */
	@Test
	public void testCanEqual_1()
		throws Exception {
		ProcessInstance fixture = new ProcessInstance("", "", "", "", "", "", new State(), "", EasyMock.createNiceMock(List.class), new org.egov.common.contract.request.User(), new org.egov.common.contract.request.User(), EasyMock.createNiceMock(List.class), new Long(1L), new Long(1L), "", new Object(), new AuditDetails());
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
	 * @generatedBy CodePro at 25/5/20 3:48 PM
	 */
	@Test
	public void testCanEqual_2()
		throws Exception {
		ProcessInstance fixture = new ProcessInstance("", "", "", "", "", "", new State(), "", EasyMock.createNiceMock(List.class), new org.egov.common.contract.request.User(), new org.egov.common.contract.request.User(), EasyMock.createNiceMock(List.class), new Long(1L), new Long(1L), "", new Object(), new AuditDetails());
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
	 * @generatedBy CodePro at 25/5/20 3:48 PM
	 */
	@Test
	public void testEquals_1()
		throws Exception {
		ProcessInstance fixture = new ProcessInstance("", "", "", "", "", "", new State(), "", EasyMock.createNiceMock(List.class), new org.egov.common.contract.request.User(), new org.egov.common.contract.request.User(), EasyMock.createNiceMock(List.class), new Long(1L), new Long(1L), "", new Object(), new AuditDetails());
		Object o = new ProcessInstance("", "", "", "", "", "", new State(), "", EasyMock.createNiceMock(List.class), new org.egov.common.contract.request.User(), new org.egov.common.contract.request.User(), EasyMock.createNiceMock(List.class), new Long(1L), new Long(1L), "", new Object(), new AuditDetails());

		boolean result = fixture.equals(o);

		// add additional test code here
		assertEquals(true, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:48 PM
	 */
	@Test
	public void testEquals_2()
		throws Exception {
		ProcessInstance fixture = new ProcessInstance("", "", "", "", "", "", new State(), "", EasyMock.createNiceMock(List.class), new org.egov.common.contract.request.User(), new org.egov.common.contract.request.User(), EasyMock.createNiceMock(List.class), new Long(1L), new Long(1L), "", new Object(), new AuditDetails());
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
	 * @generatedBy CodePro at 25/5/20 3:48 PM
	 */
	@Test
	public void testEquals_3()
		throws Exception {
		ProcessInstance fixture = new ProcessInstance("", "", "", "", "", "", new State(), "", EasyMock.createNiceMock(List.class), new org.egov.common.contract.request.User(), new org.egov.common.contract.request.User(), EasyMock.createNiceMock(List.class), new Long(1L), new Long(1L), "", new Object(), new AuditDetails());
		Object o = new ProcessInstance("", "", "", "", "", "", new State(), "", EasyMock.createNiceMock(List.class), new org.egov.common.contract.request.User(), new org.egov.common.contract.request.User(), EasyMock.createNiceMock(List.class), new Long(1L), new Long(1L), "", new Object(), new AuditDetails());

		boolean result = fixture.equals(o);

		// add additional test code here
		assertEquals(true, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:48 PM
	 */
	@Test
	public void testEquals_4()
		throws Exception {
		ProcessInstance fixture = new ProcessInstance("", "", "", "", "", "", new State(), "", EasyMock.createNiceMock(List.class), new org.egov.common.contract.request.User(), new org.egov.common.contract.request.User(), EasyMock.createNiceMock(List.class), new Long(1L), new Long(1L), "", new Object(), new AuditDetails());
		Object o = new ProcessInstance("", "", "", "", "", "", new State(), "", EasyMock.createNiceMock(List.class), new org.egov.common.contract.request.User(), new org.egov.common.contract.request.User(), EasyMock.createNiceMock(List.class), new Long(1L), new Long(1L), "", new Object(), new AuditDetails());

		boolean result = fixture.equals(o);

		// add additional test code here
		assertEquals(true, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:48 PM
	 */
	@Test
	public void testEquals_5()
		throws Exception {
		ProcessInstance fixture = new ProcessInstance((String) null, "", "", "", "", "", new State(), "", EasyMock.createNiceMock(List.class), new org.egov.common.contract.request.User(), new org.egov.common.contract.request.User(), EasyMock.createNiceMock(List.class), new Long(1L), new Long(1L), "", new Object(), new AuditDetails());
		Object o = new ProcessInstance((String) null, "", "", "", "", "", new State(), "", EasyMock.createNiceMock(List.class), new org.egov.common.contract.request.User(), new org.egov.common.contract.request.User(), EasyMock.createNiceMock(List.class), new Long(1L), new Long(1L), "", new Object(), new AuditDetails());

		boolean result = fixture.equals(o);

		// add additional test code here
		assertEquals(true, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:48 PM
	 */
	@Test
	public void testEquals_6()
		throws Exception {
		ProcessInstance fixture = new ProcessInstance("", "", "", "", "", "", new State(), "", EasyMock.createNiceMock(List.class), new org.egov.common.contract.request.User(), new org.egov.common.contract.request.User(), EasyMock.createNiceMock(List.class), new Long(1L), new Long(1L), "", new Object(), new AuditDetails());
		Object o = new ProcessInstance("", "", "", "", "", "", new State(), "", EasyMock.createNiceMock(List.class), new org.egov.common.contract.request.User(), new org.egov.common.contract.request.User(), EasyMock.createNiceMock(List.class), new Long(1L), new Long(1L), "", new Object(), new AuditDetails());

		boolean result = fixture.equals(o);

		// add additional test code here
		assertEquals(true, result);
	}

	/**
	 * Run the String getAction() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:48 PM
	 */
	@Test
	public void testGetAction_1()
		throws Exception {
		ProcessInstance fixture = new ProcessInstance("", "", "", "", "", "", new State(), "", EasyMock.createNiceMock(List.class), new org.egov.common.contract.request.User(), new org.egov.common.contract.request.User(), EasyMock.createNiceMock(List.class), new Long(1L), new Long(1L), "", new Object(), new AuditDetails());

		String result = fixture.getAction();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the org.egov.common.contract.request.User getAssignee() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:48 PM
	 */
	@Test
	public void testGetAssignee_1()
		throws Exception {
		ProcessInstance fixture = new ProcessInstance("", "", "", "", "", "", new State(), "", EasyMock.createNiceMock(List.class), new org.egov.common.contract.request.User(), new org.egov.common.contract.request.User(), EasyMock.createNiceMock(List.class), new Long(1L), new Long(1L), "", new Object(), new AuditDetails());

		org.egov.common.contract.request.User result = fixture.getAssignee();

		// add additional test code here
		assertNotNull(result);
		assertEquals("User(id=null, userName=null, name=null, type=null, mobileNumber=null, emailId=null, roles=null, tenantId=null, uuid=null)", result.toString());
		assertEquals(null, result.getName());
		assertEquals(null, result.getId());
		assertEquals(null, result.getType());
		assertEquals(null, result.getRoles());
		assertEquals(null, result.getUserName());
		assertEquals(null, result.getTenantId());
		assertEquals(null, result.getEmailId());
		assertEquals(null, result.getMobileNumber());
		assertEquals(null, result.getUuid());
	}

	/**
	 * Run the org.egov.common.contract.request.User getAssigner() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:48 PM
	 */
	@Test
	public void testGetAssigner_1()
		throws Exception {
		ProcessInstance fixture = new ProcessInstance("", "", "", "", "", "", new State(), "", EasyMock.createNiceMock(List.class), new org.egov.common.contract.request.User(), new org.egov.common.contract.request.User(), EasyMock.createNiceMock(List.class), new Long(1L), new Long(1L), "", new Object(), new AuditDetails());

		org.egov.common.contract.request.User result = fixture.getAssigner();

		// add additional test code here
		assertNotNull(result);
		assertEquals("User(id=null, userName=null, name=null, type=null, mobileNumber=null, emailId=null, roles=null, tenantId=null, uuid=null)", result.toString());
		assertEquals(null, result.getName());
		assertEquals(null, result.getId());
		assertEquals(null, result.getType());
		assertEquals(null, result.getRoles());
		assertEquals(null, result.getUserName());
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
	 * @generatedBy CodePro at 25/5/20 3:48 PM
	 */
	@Test
	public void testGetAuditDetails_1()
		throws Exception {
		ProcessInstance fixture = new ProcessInstance("", "", "", "", "", "", new State(), "", EasyMock.createNiceMock(List.class), new org.egov.common.contract.request.User(), new org.egov.common.contract.request.User(), EasyMock.createNiceMock(List.class), new Long(1L), new Long(1L), "", new Object(), new AuditDetails());

		AuditDetails result = fixture.getAuditDetails();

		// add additional test code here
		assertNotNull(result);
		assertEquals(null, result.getLastModifiedTime());
		assertEquals(null, result.getCreatedBy());
		assertEquals(null, result.getCreatedTime());
		assertEquals(null, result.getLastModifiedBy());
	}

	/**
	 * Run the String getBusinessId() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:48 PM
	 */
	@Test
	public void testGetBusinessId_1()
		throws Exception {
		ProcessInstance fixture = new ProcessInstance("", "", "", "", "", "", new State(), "", EasyMock.createNiceMock(List.class), new org.egov.common.contract.request.User(), new org.egov.common.contract.request.User(), EasyMock.createNiceMock(List.class), new Long(1L), new Long(1L), "", new Object(), new AuditDetails());

		String result = fixture.getBusinessId();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the String getBusinessService() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:48 PM
	 */
	@Test
	public void testGetBusinessService_1()
		throws Exception {
		ProcessInstance fixture = new ProcessInstance("", "", "", "", "", "", new State(), "", EasyMock.createNiceMock(List.class), new org.egov.common.contract.request.User(), new org.egov.common.contract.request.User(), EasyMock.createNiceMock(List.class), new Long(1L), new Long(1L), "", new Object(), new AuditDetails());

		String result = fixture.getBusinessService();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the Long getBusinesssServiceSla() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:48 PM
	 */
	@Test
	public void testGetBusinesssServiceSla_1()
		throws Exception {
		ProcessInstance fixture = new ProcessInstance("", "", "", "", "", "", new State(), "", EasyMock.createNiceMock(List.class), new org.egov.common.contract.request.User(), new org.egov.common.contract.request.User(), EasyMock.createNiceMock(List.class), new Long(1L), new Long(1L), "", new Object(), new AuditDetails());

		Long result = fixture.getBusinesssServiceSla();

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
	 * Run the String getComment() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:48 PM
	 */
	@Test
	public void testGetComment_1()
		throws Exception {
		ProcessInstance fixture = new ProcessInstance("", "", "", "", "", "", new State(), "", EasyMock.createNiceMock(List.class), new org.egov.common.contract.request.User(), new org.egov.common.contract.request.User(), EasyMock.createNiceMock(List.class), new Long(1L), new Long(1L), "", new Object(), new AuditDetails());

		String result = fixture.getComment();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the List<Document> getDocuments() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:48 PM
	 */
	@Test
	public void testGetDocuments_1()
		throws Exception {
		ProcessInstance fixture = new ProcessInstance("", "", "", "", "", "", new State(), "", EasyMock.createNiceMock(List.class), new org.egov.common.contract.request.User(), new org.egov.common.contract.request.User(), EasyMock.createNiceMock(List.class), new Long(1L), new Long(1L), "", new Object(), new AuditDetails());

		List<Document> result = fixture.getDocuments();

		// add additional test code here
		assertNotNull(result);
		assertEquals(0, result.size());
	}

	/**
	 * Run the Object getEntity() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:48 PM
	 */
	@Test
	public void testGetEntity_1()
		throws Exception {
		ProcessInstance fixture = new ProcessInstance("", "", "", "", "", "", new State(), "", EasyMock.createNiceMock(List.class), new org.egov.common.contract.request.User(), new org.egov.common.contract.request.User(), EasyMock.createNiceMock(List.class), new Long(1L), new Long(1L), "", new Object(), new AuditDetails());

		Object result = fixture.getEntity();

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the String getId() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:48 PM
	 */
	@Test
	public void testGetId_1()
		throws Exception {
		ProcessInstance fixture = new ProcessInstance("", "", "", "", "", "", new State(), "", EasyMock.createNiceMock(List.class), new org.egov.common.contract.request.User(), new org.egov.common.contract.request.User(), EasyMock.createNiceMock(List.class), new Long(1L), new Long(1L), "", new Object(), new AuditDetails());

		String result = fixture.getId();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the String getModuleName() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:48 PM
	 */
	@Test
	public void testGetModuleName_1()
		throws Exception {
		ProcessInstance fixture = new ProcessInstance("", "", "", "", "", "", new State(), "", EasyMock.createNiceMock(List.class), new org.egov.common.contract.request.User(), new org.egov.common.contract.request.User(), EasyMock.createNiceMock(List.class), new Long(1L), new Long(1L), "", new Object(), new AuditDetails());

		String result = fixture.getModuleName();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the List<Action> getNextActions() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:48 PM
	 */
	@Test
	public void testGetNextActions_1()
		throws Exception {
		ProcessInstance fixture = new ProcessInstance("", "", "", "", "", "", new State(), "", EasyMock.createNiceMock(List.class), new org.egov.common.contract.request.User(), new org.egov.common.contract.request.User(), EasyMock.createNiceMock(List.class), new Long(1L), new Long(1L), "", new Object(), new AuditDetails());

		List<Action> result = fixture.getNextActions();

		// add additional test code here
		assertNotNull(result);
		assertEquals(0, result.size());
	}

	/**
	 * Run the String getPreviousStatus() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:48 PM
	 */
	@Test
	public void testGetPreviousStatus_1()
		throws Exception {
		ProcessInstance fixture = new ProcessInstance("", "", "", "", "", "", new State(), "", EasyMock.createNiceMock(List.class), new org.egov.common.contract.request.User(), new org.egov.common.contract.request.User(), EasyMock.createNiceMock(List.class), new Long(1L), new Long(1L), "", new Object(), new AuditDetails());

		String result = fixture.getPreviousStatus();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the State getState() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:48 PM
	 */
	@Test
	public void testGetState_1()
		throws Exception {
		ProcessInstance fixture = new ProcessInstance("", "", "", "", "", "", new State(), "", EasyMock.createNiceMock(List.class), new org.egov.common.contract.request.User(), new org.egov.common.contract.request.User(), EasyMock.createNiceMock(List.class), new Long(1L), new Long(1L), "", new Object(), new AuditDetails());

		State result = fixture.getState();

		// add additional test code here
		assertNotNull(result);
		assertEquals("State(uuid=null, tenantId=null, businessServiceId=null, sla=null, state=null, applicationStatus=null, docUploadRequired=null, isStartState=null, isTerminateState=null, isStateUpdatable=null, actions=null, auditDetails=null)", result.toString());
		assertEquals(null, result.getActions());
		assertEquals(null, result.getState());
		assertEquals(null, result.getTenantId());
		assertEquals(null, result.getUuid());
		assertEquals(null, result.getAuditDetails());
		assertEquals(null, result.getBusinessServiceId());
		assertEquals(null, result.getApplicationStatus());
		assertEquals(null, result.getIsStateUpdatable());
		assertEquals(null, result.getDocUploadRequired());
		assertEquals(null, result.getIsTerminateState());
		assertEquals(null, result.getSla());
		assertEquals(null, result.getIsStartState());
	}

	/**
	 * Run the Long getStateSla() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:48 PM
	 */
	@Test
	public void testGetStateSla_1()
		throws Exception {
		ProcessInstance fixture = new ProcessInstance("", "", "", "", "", "", new State(), "", EasyMock.createNiceMock(List.class), new org.egov.common.contract.request.User(), new org.egov.common.contract.request.User(), EasyMock.createNiceMock(List.class), new Long(1L), new Long(1L), "", new Object(), new AuditDetails());

		Long result = fixture.getStateSla();

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
	 * Run the String getTenantId() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:48 PM
	 */
	@Test
	public void testGetTenantId_1()
		throws Exception {
		ProcessInstance fixture = new ProcessInstance("", "", "", "", "", "", new State(), "", EasyMock.createNiceMock(List.class), new org.egov.common.contract.request.User(), new org.egov.common.contract.request.User(), EasyMock.createNiceMock(List.class), new Long(1L), new Long(1L), "", new Object(), new AuditDetails());

		String result = fixture.getTenantId();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the int hashCode() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:48 PM
	 */
	@Test
	public void testHashCode_1()
		throws Exception {
		ProcessInstance fixture = new ProcessInstance("", "", "", "", "", "", new State(), "", EasyMock.createNiceMock(List.class), new org.egov.common.contract.request.User(), new org.egov.common.contract.request.User(), EasyMock.createNiceMock(List.class), new Long(1L), new Long(1L), "", new Object(), new AuditDetails());

		int result = fixture.hashCode();

		// add additional test code here
		assertEquals(59, result);
	}

	/**
	 * Run the int hashCode() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:48 PM
	 */
	@Test
	public void testHashCode_2()
		throws Exception {
		ProcessInstance fixture = new ProcessInstance((String) null, "", "", "", "", "", new State(), "", EasyMock.createNiceMock(List.class), new org.egov.common.contract.request.User(), new org.egov.common.contract.request.User(), EasyMock.createNiceMock(List.class), new Long(1L), new Long(1L), "", new Object(), new AuditDetails());

		int result = fixture.hashCode();

		// add additional test code here
		assertEquals(102, result);
	}

	/**
	 * Run the void setAction(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:48 PM
	 */
	@Test
	public void testSetAction_1()
		throws Exception {
		ProcessInstance fixture = new ProcessInstance("", "", "", "", "", "", new State(), "", EasyMock.createNiceMock(List.class), new org.egov.common.contract.request.User(), new org.egov.common.contract.request.User(), EasyMock.createNiceMock(List.class), new Long(1L), new Long(1L), "", new Object(), new AuditDetails());
		String action = "";

		fixture.setAction(action);

		// add additional test code here
	}

	/**
	 * Run the void setAssignee(User) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:48 PM
	 */
	@Test
	public void testSetAssignee_1()
		throws Exception {
		ProcessInstance fixture = new ProcessInstance("", "", "", "", "", "", new State(), "", EasyMock.createNiceMock(List.class), new org.egov.common.contract.request.User(), new org.egov.common.contract.request.User(), EasyMock.createNiceMock(List.class), new Long(1L), new Long(1L), "", new Object(), new AuditDetails());
		org.egov.common.contract.request.User assignee = new org.egov.common.contract.request.User();

		fixture.setAssignee(assignee);

		// add additional test code here
	}

	/**
	 * Run the void setAssigner(User) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:48 PM
	 */
	@Test
	public void testSetAssigner_1()
		throws Exception {
		ProcessInstance fixture = new ProcessInstance("", "", "", "", "", "", new State(), "", EasyMock.createNiceMock(List.class), new org.egov.common.contract.request.User(), new org.egov.common.contract.request.User(), EasyMock.createNiceMock(List.class), new Long(1L), new Long(1L), "", new Object(), new AuditDetails());
		org.egov.common.contract.request.User assigner = new org.egov.common.contract.request.User();

		fixture.setAssigner(assigner);

		// add additional test code here
	}

	/**
	 * Run the void setAuditDetails(AuditDetails) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:48 PM
	 */
	@Test
	public void testSetAuditDetails_1()
		throws Exception {
		ProcessInstance fixture = new ProcessInstance("", "", "", "", "", "", new State(), "", EasyMock.createNiceMock(List.class), new org.egov.common.contract.request.User(), new org.egov.common.contract.request.User(), EasyMock.createNiceMock(List.class), new Long(1L), new Long(1L), "", new Object(), new AuditDetails());
		AuditDetails auditDetails = new AuditDetails();

		fixture.setAuditDetails(auditDetails);

		// add additional test code here
	}

	/**
	 * Run the void setBusinessId(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:48 PM
	 */
	@Test
	public void testSetBusinessId_1()
		throws Exception {
		ProcessInstance fixture = new ProcessInstance("", "", "", "", "", "", new State(), "", EasyMock.createNiceMock(List.class), new org.egov.common.contract.request.User(), new org.egov.common.contract.request.User(), EasyMock.createNiceMock(List.class), new Long(1L), new Long(1L), "", new Object(), new AuditDetails());
		String businessId = "";

		fixture.setBusinessId(businessId);

		// add additional test code here
	}

	/**
	 * Run the void setBusinessService(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:48 PM
	 */
	@Test
	public void testSetBusinessService_1()
		throws Exception {
		ProcessInstance fixture = new ProcessInstance("", "", "", "", "", "", new State(), "", EasyMock.createNiceMock(List.class), new org.egov.common.contract.request.User(), new org.egov.common.contract.request.User(), EasyMock.createNiceMock(List.class), new Long(1L), new Long(1L), "", new Object(), new AuditDetails());
		String businessService = "";

		fixture.setBusinessService(businessService);

		// add additional test code here
	}

	/**
	 * Run the void setBusinesssServiceSla(Long) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:48 PM
	 */
	@Test
	public void testSetBusinesssServiceSla_1()
		throws Exception {
		ProcessInstance fixture = new ProcessInstance("", "", "", "", "", "", new State(), "", EasyMock.createNiceMock(List.class), new org.egov.common.contract.request.User(), new org.egov.common.contract.request.User(), EasyMock.createNiceMock(List.class), new Long(1L), new Long(1L), "", new Object(), new AuditDetails());
		Long businesssServiceSla = new Long(1L);

		fixture.setBusinesssServiceSla(businesssServiceSla);

		// add additional test code here
	}

	/**
	 * Run the void setComment(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:48 PM
	 */
	@Test
	public void testSetComment_1()
		throws Exception {
		ProcessInstance fixture = new ProcessInstance("", "", "", "", "", "", new State(), "", EasyMock.createNiceMock(List.class), new org.egov.common.contract.request.User(), new org.egov.common.contract.request.User(), EasyMock.createNiceMock(List.class), new Long(1L), new Long(1L), "", new Object(), new AuditDetails());
		String comment = "";

		fixture.setComment(comment);

		// add additional test code here
	}

	/**
	 * Run the void setDocuments(List<Document>) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:48 PM
	 */
	@Test
	public void testSetDocuments_1()
		throws Exception {
		ProcessInstance fixture = new ProcessInstance("", "", "", "", "", "", new State(), "", EasyMock.createNiceMock(List.class), new org.egov.common.contract.request.User(), new org.egov.common.contract.request.User(), EasyMock.createNiceMock(List.class), new Long(1L), new Long(1L), "", new Object(), new AuditDetails());
		List<Document> documents = EasyMock.createMock(List.class);
		// add mock object expectations here

		EasyMock.replay(documents);

		fixture.setDocuments(documents);

		// add additional test code here
		EasyMock.verify(documents);
	}

	/**
	 * Run the void setEntity(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:48 PM
	 */
	@Test
	public void testSetEntity_1()
		throws Exception {
		ProcessInstance fixture = new ProcessInstance("", "", "", "", "", "", new State(), "", EasyMock.createNiceMock(List.class), new org.egov.common.contract.request.User(), new org.egov.common.contract.request.User(), EasyMock.createNiceMock(List.class), new Long(1L), new Long(1L), "", new Object(), new AuditDetails());
		Object entity = new Object();

		fixture.setEntity(entity);

		// add additional test code here
	}

	/**
	 * Run the void setId(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:48 PM
	 */
	@Test
	public void testSetId_1()
		throws Exception {
		ProcessInstance fixture = new ProcessInstance("", "", "", "", "", "", new State(), "", EasyMock.createNiceMock(List.class), new org.egov.common.contract.request.User(), new org.egov.common.contract.request.User(), EasyMock.createNiceMock(List.class), new Long(1L), new Long(1L), "", new Object(), new AuditDetails());
		String id = "";

		fixture.setId(id);

		// add additional test code here
	}

	/**
	 * Run the void setModuleName(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:48 PM
	 */
	@Test
	public void testSetModuleName_1()
		throws Exception {
		ProcessInstance fixture = new ProcessInstance("", "", "", "", "", "", new State(), "", EasyMock.createNiceMock(List.class), new org.egov.common.contract.request.User(), new org.egov.common.contract.request.User(), EasyMock.createNiceMock(List.class), new Long(1L), new Long(1L), "", new Object(), new AuditDetails());
		String moduleName = "";

		fixture.setModuleName(moduleName);

		// add additional test code here
	}

	/**
	 * Run the void setNextActions(List<Action>) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:48 PM
	 */
	@Test
	public void testSetNextActions_1()
		throws Exception {
		ProcessInstance fixture = new ProcessInstance("", "", "", "", "", "", new State(), "", EasyMock.createNiceMock(List.class), new org.egov.common.contract.request.User(), new org.egov.common.contract.request.User(), EasyMock.createNiceMock(List.class), new Long(1L), new Long(1L), "", new Object(), new AuditDetails());
		List<Action> nextActions = EasyMock.createMock(List.class);
		// add mock object expectations here

		EasyMock.replay(nextActions);

		fixture.setNextActions(nextActions);

		// add additional test code here
		EasyMock.verify(nextActions);
	}

	/**
	 * Run the void setPreviousStatus(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:48 PM
	 */
	@Test
	public void testSetPreviousStatus_1()
		throws Exception {
		ProcessInstance fixture = new ProcessInstance("", "", "", "", "", "", new State(), "", EasyMock.createNiceMock(List.class), new org.egov.common.contract.request.User(), new org.egov.common.contract.request.User(), EasyMock.createNiceMock(List.class), new Long(1L), new Long(1L), "", new Object(), new AuditDetails());
		String previousStatus = "";

		fixture.setPreviousStatus(previousStatus);

		// add additional test code here
	}

	/**
	 * Run the void setState(State) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:48 PM
	 */
	@Test
	public void testSetState_1()
		throws Exception {
		ProcessInstance fixture = new ProcessInstance("", "", "", "", "", "", new State(), "", EasyMock.createNiceMock(List.class), new org.egov.common.contract.request.User(), new org.egov.common.contract.request.User(), EasyMock.createNiceMock(List.class), new Long(1L), new Long(1L), "", new Object(), new AuditDetails());
		State state = new State();

		fixture.setState(state);

		// add additional test code here
	}

	/**
	 * Run the void setStateSla(Long) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:48 PM
	 */
	@Test
	public void testSetStateSla_1()
		throws Exception {
		ProcessInstance fixture = new ProcessInstance("", "", "", "", "", "", new State(), "", EasyMock.createNiceMock(List.class), new org.egov.common.contract.request.User(), new org.egov.common.contract.request.User(), EasyMock.createNiceMock(List.class), new Long(1L), new Long(1L), "", new Object(), new AuditDetails());
		Long stateSla = new Long(1L);

		fixture.setStateSla(stateSla);

		// add additional test code here
	}

	/**
	 * Run the void setTenantId(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:48 PM
	 */
	@Test
	public void testSetTenantId_1()
		throws Exception {
		ProcessInstance fixture = new ProcessInstance("", "", "", "", "", "", new State(), "", EasyMock.createNiceMock(List.class), new org.egov.common.contract.request.User(), new org.egov.common.contract.request.User(), EasyMock.createNiceMock(List.class), new Long(1L), new Long(1L), "", new Object(), new AuditDetails());
		String tenantId = "";

		fixture.setTenantId(tenantId);

		// add additional test code here
	}

	/**
	 * Perform pre-test initialization.
	 *
	 * @throws Exception
	 *         if the initialization fails for some reason
	 *
	 * @generatedBy CodePro at 25/5/20 3:48 PM
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
	 * @generatedBy CodePro at 25/5/20 3:48 PM
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
	 * @generatedBy CodePro at 25/5/20 3:48 PM
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(ProcessInstanceTest.class);
	}
}