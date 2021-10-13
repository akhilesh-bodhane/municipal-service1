package org.egov.prscp.web.models;

import java.util.List;
import org.easymock.EasyMock;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * The class <code>PublicRelationEventTest</code> contains tests for the class <code>{@link PublicRelationEvent}</code>.
 *
 * @generatedBy CodePro at 25/5/20 3:52 PM
 * @author Aniket.Marathe
 * @version $Revision: 1.0 $
 */
public class PublicRelationEventTest {
	/**
	 * Run the PublicRelationEvent() constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:52 PM
	 */
	@Test
	public void testPublicRelationEvent_1()
		throws Exception {

		PublicRelationEvent result = new PublicRelationEvent();

		// add additional test code here
		assertNotNull(result);
		assertEquals(null, result.getComment());
		assertEquals(null, result.getId());
		assertEquals(null, result.getAction());
		assertEquals(null, result.getStatus());
		assertEquals(null, result.getAssignee());
		assertEquals(null, result.getApplicationNumber());
		assertEquals(null, result.getFinancialYear());
		assertEquals(null, result.getValidTo());
		assertEquals(null, result.getTenantId());
		assertEquals(null, result.getAuditDetails());
		assertEquals(null, result.getWfDocuments());
		assertEquals(null, result.getValidFrom());
	}

	/**
	 * Run the PublicRelationEvent(String,String,String,String,Long,Long,String,String,List<Document>,String,AuditDetails,String) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:52 PM
	 */
	@Test
	public void testPublicRelationEvent_2()
		throws Exception {
		String id = "";
		String tenantId = "";
		String applicationNumber = "";
		String financialYear = "";
		Long validFrom = new Long(1L);
		Long validTo = new Long(1L);
		String action = "";
		String assignee = "";
		List<Document> wfDocuments = EasyMock.createMock(List.class);
		String status = "";
		AuditDetails auditDetails = new AuditDetails();
		String comment = "";
		// add mock object expectations here

		EasyMock.replay(wfDocuments);

		PublicRelationEvent result = new PublicRelationEvent(id, tenantId, applicationNumber, financialYear, validFrom, validTo, action, assignee, wfDocuments, status, auditDetails, comment);

		// add additional test code here
		EasyMock.verify(wfDocuments);
		assertNotNull(result);
		assertEquals("", result.getComment());
		assertEquals("", result.getId());
		assertEquals("", result.getAction());
		assertEquals("", result.getStatus());
		assertEquals("", result.getAssignee());
		assertEquals("", result.getApplicationNumber());
		assertEquals("", result.getFinancialYear());
		assertEquals(new Long(1L), result.getValidTo());
		assertEquals("", result.getTenantId());
		assertEquals(new Long(1L), result.getValidFrom());
	}

	/**
	 * Run the PublicRelationEvent.PublicRelationEventBuilder builder() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:52 PM
	 */
	@Test
	public void testBuilder_1()
		throws Exception {

		PublicRelationEvent.PublicRelationEventBuilder result = PublicRelationEvent.builder();

		// add additional test code here
		assertNotNull(result);
		assertEquals("PublicRelationEvent.PublicRelationEventBuilder(id=null, tenantId=null, applicationNumber=null, financialYear=null, validFrom=null, validTo=null, action=null, assignee=null, wfDocuments=null, status=null, auditDetails=null, comment=null)", result.toString());
	}

	/**
	 * Run the String getAction() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:52 PM
	 */
	@Test
	public void testGetAction_1()
		throws Exception {
		PublicRelationEvent fixture = new PublicRelationEvent("", "", "", "", new Long(1L), new Long(1L), "", "", EasyMock.createNiceMock(List.class), "", new AuditDetails(), "");

		String result = fixture.getAction();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the String getApplicationNumber() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:52 PM
	 */
	@Test
	public void testGetApplicationNumber_1()
		throws Exception {
		PublicRelationEvent fixture = new PublicRelationEvent("", "", "", "", new Long(1L), new Long(1L), "", "", EasyMock.createNiceMock(List.class), "", new AuditDetails(), "");

		String result = fixture.getApplicationNumber();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the String getAssignee() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:52 PM
	 */
	@Test
	public void testGetAssignee_1()
		throws Exception {
		PublicRelationEvent fixture = new PublicRelationEvent("", "", "", "", new Long(1L), new Long(1L), "", "", EasyMock.createNiceMock(List.class), "", new AuditDetails(), "");

		String result = fixture.getAssignee();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the AuditDetails getAuditDetails() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:52 PM
	 */
	@Test
	public void testGetAuditDetails_1()
		throws Exception {
		PublicRelationEvent fixture = new PublicRelationEvent("", "", "", "", new Long(1L), new Long(1L), "", "", EasyMock.createNiceMock(List.class), "", new AuditDetails(), "");

		AuditDetails result = fixture.getAuditDetails();

		// add additional test code here
		assertNotNull(result);
		assertEquals(null, result.getLastModifiedTime());
		assertEquals(null, result.getLastModifiedBy());
		assertEquals(null, result.getCreatedTime());
		assertEquals(null, result.getCreatedBy());
	}

	/**
	 * Run the String getComment() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:52 PM
	 */
	@Test
	public void testGetComment_1()
		throws Exception {
		PublicRelationEvent fixture = new PublicRelationEvent("", "", "", "", new Long(1L), new Long(1L), "", "", EasyMock.createNiceMock(List.class), "", new AuditDetails(), "");

		String result = fixture.getComment();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the String getFinancialYear() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:52 PM
	 */
	@Test
	public void testGetFinancialYear_1()
		throws Exception {
		PublicRelationEvent fixture = new PublicRelationEvent("", "", "", "", new Long(1L), new Long(1L), "", "", EasyMock.createNiceMock(List.class), "", new AuditDetails(), "");

		String result = fixture.getFinancialYear();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the String getId() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:52 PM
	 */
	@Test
	public void testGetId_1()
		throws Exception {
		PublicRelationEvent fixture = new PublicRelationEvent("", "", "", "", new Long(1L), new Long(1L), "", "", EasyMock.createNiceMock(List.class), "", new AuditDetails(), "");

		String result = fixture.getId();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the String getStatus() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:52 PM
	 */
	@Test
	public void testGetStatus_1()
		throws Exception {
		PublicRelationEvent fixture = new PublicRelationEvent("", "", "", "", new Long(1L), new Long(1L), "", "", EasyMock.createNiceMock(List.class), "", new AuditDetails(), "");

		String result = fixture.getStatus();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the String getTenantId() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:52 PM
	 */
	@Test
	public void testGetTenantId_1()
		throws Exception {
		PublicRelationEvent fixture = new PublicRelationEvent("", "", "", "", new Long(1L), new Long(1L), "", "", EasyMock.createNiceMock(List.class), "", new AuditDetails(), "");

		String result = fixture.getTenantId();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the Long getValidFrom() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:52 PM
	 */
	@Test
	public void testGetValidFrom_1()
		throws Exception {
		PublicRelationEvent fixture = new PublicRelationEvent("", "", "", "", new Long(1L), new Long(1L), "", "", EasyMock.createNiceMock(List.class), "", new AuditDetails(), "");

		Long result = fixture.getValidFrom();

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
	 * Run the Long getValidTo() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:52 PM
	 */
	@Test
	public void testGetValidTo_1()
		throws Exception {
		PublicRelationEvent fixture = new PublicRelationEvent("", "", "", "", new Long(1L), new Long(1L), "", "", EasyMock.createNiceMock(List.class), "", new AuditDetails(), "");

		Long result = fixture.getValidTo();

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
	 * Run the List<Document> getWfDocuments() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:52 PM
	 */
	@Test
	public void testGetWfDocuments_1()
		throws Exception {
		PublicRelationEvent fixture = new PublicRelationEvent("", "", "", "", new Long(1L), new Long(1L), "", "", EasyMock.createNiceMock(List.class), "", new AuditDetails(), "");

		List<Document> result = fixture.getWfDocuments();

		// add additional test code here
		assertNotNull(result);
		assertEquals(0, result.size());
	}

	/**
	 * Run the void setAction(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:52 PM
	 */
	@Test
	public void testSetAction_1()
		throws Exception {
		PublicRelationEvent fixture = new PublicRelationEvent("", "", "", "", new Long(1L), new Long(1L), "", "", EasyMock.createNiceMock(List.class), "", new AuditDetails(), "");
		String action = "";

		fixture.setAction(action);

		// add additional test code here
	}

	/**
	 * Run the void setApplicationNumber(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:52 PM
	 */
	@Test
	public void testSetApplicationNumber_1()
		throws Exception {
		PublicRelationEvent fixture = new PublicRelationEvent("", "", "", "", new Long(1L), new Long(1L), "", "", EasyMock.createNiceMock(List.class), "", new AuditDetails(), "");
		String applicationNumber = "";

		fixture.setApplicationNumber(applicationNumber);

		// add additional test code here
	}

	/**
	 * Run the void setAssignee(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:52 PM
	 */
	@Test
	public void testSetAssignee_1()
		throws Exception {
		PublicRelationEvent fixture = new PublicRelationEvent("", "", "", "", new Long(1L), new Long(1L), "", "", EasyMock.createNiceMock(List.class), "", new AuditDetails(), "");
		String assignee = "";

		fixture.setAssignee(assignee);

		// add additional test code here
	}

	/**
	 * Run the void setAuditDetails(AuditDetails) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:52 PM
	 */
	@Test
	public void testSetAuditDetails_1()
		throws Exception {
		PublicRelationEvent fixture = new PublicRelationEvent("", "", "", "", new Long(1L), new Long(1L), "", "", EasyMock.createNiceMock(List.class), "", new AuditDetails(), "");
		AuditDetails auditDetails = new AuditDetails();

		fixture.setAuditDetails(auditDetails);

		// add additional test code here
	}

	/**
	 * Run the void setComment(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:52 PM
	 */
	@Test
	public void testSetComment_1()
		throws Exception {
		PublicRelationEvent fixture = new PublicRelationEvent("", "", "", "", new Long(1L), new Long(1L), "", "", EasyMock.createNiceMock(List.class), "", new AuditDetails(), "");
		String comment = "";

		fixture.setComment(comment);

		// add additional test code here
	}

	/**
	 * Run the void setFinancialYear(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:52 PM
	 */
	@Test
	public void testSetFinancialYear_1()
		throws Exception {
		PublicRelationEvent fixture = new PublicRelationEvent("", "", "", "", new Long(1L), new Long(1L), "", "", EasyMock.createNiceMock(List.class), "", new AuditDetails(), "");
		String financialYear = "";

		fixture.setFinancialYear(financialYear);

		// add additional test code here
	}

	/**
	 * Run the void setId(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:52 PM
	 */
	@Test
	public void testSetId_1()
		throws Exception {
		PublicRelationEvent fixture = new PublicRelationEvent("", "", "", "", new Long(1L), new Long(1L), "", "", EasyMock.createNiceMock(List.class), "", new AuditDetails(), "");
		String id = "";

		fixture.setId(id);

		// add additional test code here
	}

	/**
	 * Run the void setStatus(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:52 PM
	 */
	@Test
	public void testSetStatus_1()
		throws Exception {
		PublicRelationEvent fixture = new PublicRelationEvent("", "", "", "", new Long(1L), new Long(1L), "", "", EasyMock.createNiceMock(List.class), "", new AuditDetails(), "");
		String status = "";

		fixture.setStatus(status);

		// add additional test code here
	}

	/**
	 * Run the void setTenantId(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:52 PM
	 */
	@Test
	public void testSetTenantId_1()
		throws Exception {
		PublicRelationEvent fixture = new PublicRelationEvent("", "", "", "", new Long(1L), new Long(1L), "", "", EasyMock.createNiceMock(List.class), "", new AuditDetails(), "");
		String tenantId = "";

		fixture.setTenantId(tenantId);

		// add additional test code here
	}

	/**
	 * Run the void setValidFrom(Long) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:52 PM
	 */
	@Test
	public void testSetValidFrom_1()
		throws Exception {
		PublicRelationEvent fixture = new PublicRelationEvent("", "", "", "", new Long(1L), new Long(1L), "", "", EasyMock.createNiceMock(List.class), "", new AuditDetails(), "");
		Long validFrom = new Long(1L);

		fixture.setValidFrom(validFrom);

		// add additional test code here
	}

	/**
	 * Run the void setValidTo(Long) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:52 PM
	 */
	@Test
	public void testSetValidTo_1()
		throws Exception {
		PublicRelationEvent fixture = new PublicRelationEvent("", "", "", "", new Long(1L), new Long(1L), "", "", EasyMock.createNiceMock(List.class), "", new AuditDetails(), "");
		Long validTo = new Long(1L);

		fixture.setValidTo(validTo);

		// add additional test code here
	}

	/**
	 * Run the void setWfDocuments(List<Document>) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:52 PM
	 */
	@Test
	public void testSetWfDocuments_1()
		throws Exception {
		PublicRelationEvent fixture = new PublicRelationEvent("", "", "", "", new Long(1L), new Long(1L), "", "", EasyMock.createNiceMock(List.class), "", new AuditDetails(), "");
		List<Document> wfDocuments = EasyMock.createMock(List.class);
		// add mock object expectations here

		EasyMock.replay(wfDocuments);

		fixture.setWfDocuments(wfDocuments);

		// add additional test code here
		EasyMock.verify(wfDocuments);
	}

	/**
	 * Perform pre-test initialization.
	 *
	 * @throws Exception
	 *         if the initialization fails for some reason
	 *
	 * @generatedBy CodePro at 25/5/20 3:52 PM
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
	 * @generatedBy CodePro at 25/5/20 3:52 PM
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
	 * @generatedBy CodePro at 25/5/20 3:52 PM
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(PublicRelationEventTest.class);
	}
}