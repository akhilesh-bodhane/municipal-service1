package org.egov.prscp.web.models;

import java.util.List;
import org.easymock.EasyMock;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * The class <code>PrSearchCriteriaTest</code> contains tests for the class <code>{@link PrSearchCriteria}</code>.
 *
 * @generatedBy CodePro at 25/5/20 3:52 PM
 * @author Aniket.Marathe
 * @version $Revision: 1.0 $
 */
public class PrSearchCriteriaTest {
	/**
	 * Run the PrSearchCriteria() constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:52 PM
	 */
	@Test
	public void testPrSearchCriteria_1()
		throws Exception {

		PrSearchCriteria result = new PrSearchCriteria();

		// add additional test code here
		assertNotNull(result);
		assertEquals(null, result.getOffset());
		assertEquals(null, result.getIds());
		assertEquals(null, result.getLimit());
		assertEquals(null, result.getStatus());
		assertEquals(null, result.getApplicationNumber());
		assertEquals(null, result.getTenantId());
		assertEquals(null, result.getFromDate());
		assertEquals(null, result.getToDate());
		assertEquals(null, result.getOwnerIds());
		assertEquals(null, result.getMobileNumber());
		assertEquals(null, result.getAccountId());
	}

	/**
	 * Run the PrSearchCriteria(String,String,List<String>,String,String,String,Long,Long,Integer,Integer,List<String>) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:52 PM
	 */
	@Test
	public void testPrSearchCriteria_2()
		throws Exception {
		String tenantId = "";
		String status = "";
		List<String> ids = EasyMock.createMock(List.class);
		String applicationNumber = "";
		String mobileNumber = "";
		String accountId = "";
		Long fromDate = new Long(1L);
		Long toDate = new Long(1L);
		Integer offset = new Integer(1);
		Integer limit = new Integer(1);
		List<String> ownerIds = EasyMock.createMock(List.class);
		// add mock object expectations here

		EasyMock.replay(ids);
		EasyMock.replay(ownerIds);

		PrSearchCriteria result = new PrSearchCriteria(tenantId, status, ids, applicationNumber, mobileNumber, accountId, fromDate, toDate, offset, limit, ownerIds);

		// add additional test code here
		EasyMock.verify(ids);
		EasyMock.verify(ownerIds);
		assertNotNull(result);
		assertEquals(new Integer(1), result.getOffset());
		assertEquals(new Integer(1), result.getLimit());
		assertEquals("", result.getStatus());
		assertEquals("", result.getApplicationNumber());
		assertEquals("", result.getTenantId());
		assertEquals(new Long(1L), result.getFromDate());
		assertEquals(new Long(1L), result.getToDate());
		assertEquals("", result.getMobileNumber());
		assertEquals("", result.getAccountId());
	}

	/**
	 * Run the PrSearchCriteria.PrSearchCriteriaBuilder builder() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:52 PM
	 */
	@Test
	public void testBuilder_1()
		throws Exception {

		PrSearchCriteria.PrSearchCriteriaBuilder result = PrSearchCriteria.builder();

		// add additional test code here
		assertNotNull(result);
		assertEquals("PrSearchCriteria.PrSearchCriteriaBuilder(tenantId=null, status=null, ids=null, applicationNumber=null, mobileNumber=null, accountId=null, fromDate=null, toDate=null, offset=null, limit=null, ownerIds=null)", result.toString());
	}

	/**
	 * Run the String getAccountId() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:52 PM
	 */
	@Test
	public void testGetAccountId_1()
		throws Exception {
		PrSearchCriteria fixture = new PrSearchCriteria("", "", EasyMock.createNiceMock(List.class), "", "", "", new Long(1L), new Long(1L), new Integer(1), new Integer(1), EasyMock.createNiceMock(List.class));

		String result = fixture.getAccountId();

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
		PrSearchCriteria fixture = new PrSearchCriteria("", "", EasyMock.createNiceMock(List.class), "", "", "", new Long(1L), new Long(1L), new Integer(1), new Integer(1), EasyMock.createNiceMock(List.class));

		String result = fixture.getApplicationNumber();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the Long getFromDate() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:52 PM
	 */
	@Test
	public void testGetFromDate_1()
		throws Exception {
		PrSearchCriteria fixture = new PrSearchCriteria("", "", EasyMock.createNiceMock(List.class), "", "", "", new Long(1L), new Long(1L), new Integer(1), new Integer(1), EasyMock.createNiceMock(List.class));

		Long result = fixture.getFromDate();

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
	 * Run the List<String> getIds() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:52 PM
	 */
	@Test
	public void testGetIds_1()
		throws Exception {
		PrSearchCriteria fixture = new PrSearchCriteria("", "", EasyMock.createNiceMock(List.class), "", "", "", new Long(1L), new Long(1L), new Integer(1), new Integer(1), EasyMock.createNiceMock(List.class));

		List<String> result = fixture.getIds();

		// add additional test code here
		assertNotNull(result);
		assertEquals(0, result.size());
	}

	/**
	 * Run the Integer getLimit() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:52 PM
	 */
	@Test
	public void testGetLimit_1()
		throws Exception {
		PrSearchCriteria fixture = new PrSearchCriteria("", "", EasyMock.createNiceMock(List.class), "", "", "", new Long(1L), new Long(1L), new Integer(1), new Integer(1), EasyMock.createNiceMock(List.class));

		Integer result = fixture.getLimit();

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
	 * Run the String getMobileNumber() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:52 PM
	 */
	@Test
	public void testGetMobileNumber_1()
		throws Exception {
		PrSearchCriteria fixture = new PrSearchCriteria("", "", EasyMock.createNiceMock(List.class), "", "", "", new Long(1L), new Long(1L), new Integer(1), new Integer(1), EasyMock.createNiceMock(List.class));

		String result = fixture.getMobileNumber();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the Integer getOffset() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:52 PM
	 */
	@Test
	public void testGetOffset_1()
		throws Exception {
		PrSearchCriteria fixture = new PrSearchCriteria("", "", EasyMock.createNiceMock(List.class), "", "", "", new Long(1L), new Long(1L), new Integer(1), new Integer(1), EasyMock.createNiceMock(List.class));

		Integer result = fixture.getOffset();

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
	 * Run the List<String> getOwnerIds() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:52 PM
	 */
	@Test
	public void testGetOwnerIds_1()
		throws Exception {
		PrSearchCriteria fixture = new PrSearchCriteria("", "", EasyMock.createNiceMock(List.class), "", "", "", new Long(1L), new Long(1L), new Integer(1), new Integer(1), EasyMock.createNiceMock(List.class));

		List<String> result = fixture.getOwnerIds();

		// add additional test code here
		assertNotNull(result);
		assertEquals(0, result.size());
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
		PrSearchCriteria fixture = new PrSearchCriteria("", "", EasyMock.createNiceMock(List.class), "", "", "", new Long(1L), new Long(1L), new Integer(1), new Integer(1), EasyMock.createNiceMock(List.class));

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
		PrSearchCriteria fixture = new PrSearchCriteria("", "", EasyMock.createNiceMock(List.class), "", "", "", new Long(1L), new Long(1L), new Integer(1), new Integer(1), EasyMock.createNiceMock(List.class));

		String result = fixture.getTenantId();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the Long getToDate() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:52 PM
	 */
	@Test
	public void testGetToDate_1()
		throws Exception {
		PrSearchCriteria fixture = new PrSearchCriteria("", "", EasyMock.createNiceMock(List.class), "", "", "", new Long(1L), new Long(1L), new Integer(1), new Integer(1), EasyMock.createNiceMock(List.class));

		Long result = fixture.getToDate();

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
	 * Run the void setAccountId(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:52 PM
	 */
	@Test
	public void testSetAccountId_1()
		throws Exception {
		PrSearchCriteria fixture = new PrSearchCriteria("", "", EasyMock.createNiceMock(List.class), "", "", "", new Long(1L), new Long(1L), new Integer(1), new Integer(1), EasyMock.createNiceMock(List.class));
		String accountId = "";

		fixture.setAccountId(accountId);

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
		PrSearchCriteria fixture = new PrSearchCriteria("", "", EasyMock.createNiceMock(List.class), "", "", "", new Long(1L), new Long(1L), new Integer(1), new Integer(1), EasyMock.createNiceMock(List.class));
		String applicationNumber = "";

		fixture.setApplicationNumber(applicationNumber);

		// add additional test code here
	}

	/**
	 * Run the void setFromDate(Long) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:52 PM
	 */
	@Test
	public void testSetFromDate_1()
		throws Exception {
		PrSearchCriteria fixture = new PrSearchCriteria("", "", EasyMock.createNiceMock(List.class), "", "", "", new Long(1L), new Long(1L), new Integer(1), new Integer(1), EasyMock.createNiceMock(List.class));
		Long fromDate = new Long(1L);

		fixture.setFromDate(fromDate);

		// add additional test code here
	}

	/**
	 * Run the void setIds(List<String>) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:52 PM
	 */
	@Test
	public void testSetIds_1()
		throws Exception {
		PrSearchCriteria fixture = new PrSearchCriteria("", "", EasyMock.createNiceMock(List.class), "", "", "", new Long(1L), new Long(1L), new Integer(1), new Integer(1), EasyMock.createNiceMock(List.class));
		List<String> ids = EasyMock.createMock(List.class);
		// add mock object expectations here

		EasyMock.replay(ids);

		fixture.setIds(ids);

		// add additional test code here
		EasyMock.verify(ids);
	}

	/**
	 * Run the void setLimit(Integer) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:52 PM
	 */
	@Test
	public void testSetLimit_1()
		throws Exception {
		PrSearchCriteria fixture = new PrSearchCriteria("", "", EasyMock.createNiceMock(List.class), "", "", "", new Long(1L), new Long(1L), new Integer(1), new Integer(1), EasyMock.createNiceMock(List.class));
		Integer limit = new Integer(1);

		fixture.setLimit(limit);

		// add additional test code here
	}

	/**
	 * Run the void setMobileNumber(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:52 PM
	 */
	@Test
	public void testSetMobileNumber_1()
		throws Exception {
		PrSearchCriteria fixture = new PrSearchCriteria("", "", EasyMock.createNiceMock(List.class), "", "", "", new Long(1L), new Long(1L), new Integer(1), new Integer(1), EasyMock.createNiceMock(List.class));
		String mobileNumber = "";

		fixture.setMobileNumber(mobileNumber);

		// add additional test code here
	}

	/**
	 * Run the void setOffset(Integer) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:52 PM
	 */
	@Test
	public void testSetOffset_1()
		throws Exception {
		PrSearchCriteria fixture = new PrSearchCriteria("", "", EasyMock.createNiceMock(List.class), "", "", "", new Long(1L), new Long(1L), new Integer(1), new Integer(1), EasyMock.createNiceMock(List.class));
		Integer offset = new Integer(1);

		fixture.setOffset(offset);

		// add additional test code here
	}

	/**
	 * Run the void setOwnerIds(List<String>) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:52 PM
	 */
	@Test
	public void testSetOwnerIds_1()
		throws Exception {
		PrSearchCriteria fixture = new PrSearchCriteria("", "", EasyMock.createNiceMock(List.class), "", "", "", new Long(1L), new Long(1L), new Integer(1), new Integer(1), EasyMock.createNiceMock(List.class));
		List<String> ownerIds = EasyMock.createMock(List.class);
		// add mock object expectations here

		EasyMock.replay(ownerIds);

		fixture.setOwnerIds(ownerIds);

		// add additional test code here
		EasyMock.verify(ownerIds);
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
		PrSearchCriteria fixture = new PrSearchCriteria("", "", EasyMock.createNiceMock(List.class), "", "", "", new Long(1L), new Long(1L), new Integer(1), new Integer(1), EasyMock.createNiceMock(List.class));
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
		PrSearchCriteria fixture = new PrSearchCriteria("", "", EasyMock.createNiceMock(List.class), "", "", "", new Long(1L), new Long(1L), new Integer(1), new Integer(1), EasyMock.createNiceMock(List.class));
		String tenantId = "";

		fixture.setTenantId(tenantId);

		// add additional test code here
	}

	/**
	 * Run the void setToDate(Long) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 25/5/20 3:52 PM
	 */
	@Test
	public void testSetToDate_1()
		throws Exception {
		PrSearchCriteria fixture = new PrSearchCriteria("", "", EasyMock.createNiceMock(List.class), "", "", "", new Long(1L), new Long(1L), new Integer(1), new Integer(1), EasyMock.createNiceMock(List.class));
		Long toDate = new Long(1L);

		fixture.setToDate(toDate);

		// add additional test code here
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
		new org.junit.runner.JUnitCore().run(PrSearchCriteriaTest.class);
	}
}