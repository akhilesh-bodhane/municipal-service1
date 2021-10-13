
package org.egov.ec.web.models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.egov.ec.web.models.EcSearchCriteria;
import org.junit.Assert;
import org.junit.Test;

public class EcSearchCriteriaTest {

	/**
	 * Run the EcSearchCriteria() constructor test.
	 *
	 * @throws Exception
	 *
	 *                   at 30/4/20 5:39 AM
	 */

	@Test
	public void testEcSearchCriteria_1() throws Exception {

		EcSearchCriteria result = new EcSearchCriteria();

		assertNotNull(result);
		assertEquals(null, result.getTenantId());
		assertEquals(null, result.getStatus());
		assertEquals(null, result.getChallanId());
		assertEquals(null, result.getMobileNumber());
		assertEquals(null, result.getAction());
		assertEquals(null, result.getFromDate());
		assertEquals(null, result.getToDate());
		assertEquals(null, result.getOffset());
		assertEquals(null, result.getLimit());
		assertEquals(null, result.getOrderColumn());
		assertEquals(null, result.getSearchText());
		assertEquals(null, result.getChallanUuid());
	}

	/**
	 * Run the
	 * EcSearchCriteria(String,String,String,String,Long,String,Long,Boolean,String)
	 * constructor test.
	 *
	 * @throws Exception
	 *
	 *                   at 30/04/20 1:32 PM
	 */

	@Test
	public void testEcSearchCriteria_2() throws Exception {
		String tenantId = "";
		String status = "";
		String challanId = "";
		String mobileNumber = "";
		String action = "";
		Long fromDate = new Long(1L);
		Long toDate = new Long(1L);
		Integer offset = null;
		Integer limit = null;
		String orderDir = "";
		String orderColumn = "";
		String searchText = "";
		String challanUuid = "";

		EcSearchCriteria result = new EcSearchCriteria(tenantId, status, challanId, mobileNumber, action, fromDate,
				toDate, offset, limit, orderDir, orderColumn, searchText, challanUuid, challanUuid);

		assertNotNull(result);
		assertEquals(new Long(1L), (result.getFromDate()));
		assertEquals(new Long(1L), (result.getToDate()));
		assertEquals(null, result.getOffset());
		assertEquals(null, result.getLimit());
		assertEquals("", result.getMobileNumber());
		assertEquals("", result.getTenantId());
		assertEquals("", result.getAction());
		assertEquals("", result.getOrderDir());
		assertEquals("", result.getOrderColumn());
		assertEquals("", result.getSearchText());
		assertEquals("", result.getChallanId());
		assertEquals("", result.getStatus());
		assertEquals("", result.getChallanUuid());

	}

	/**
	 * Run the EcSearchCriteria.EcSearchCriteriaBuilder builder() method test.
	 *
	 * @throws Exception
	 *
	 *                   at 30/04/20 1:32 PM
	 */

	@Test
	public void testBuilder_1() throws Exception {

		EcSearchCriteria.EcSearchCriteriaBuilder result = EcSearchCriteria.builder();

		assertNotNull(result);
		assertEquals(
				"EcSearchCriteria.EcSearchCriteriaBuilder(tenantId=null, status=null, challanId=null, mobileNumber=null, action=null, fromDate=null, toDate=null, offset=null, limit=null, orderDir=null, orderColumn=null, searchText=null, challanUuid=null)",
				result.toString());
	}

	/**
	 * Run the EcSearchCriteria.EcSearchCriteriaBuilder builder() method test.
	 *
	 * @throws Exception
	 *
	 *                   at 30/04/20 1:32 PM
	 */

	@Test
	public void testBuilder_2() throws Exception {

		EcSearchCriteria.EcSearchCriteriaBuilder builder = new EcSearchCriteria.EcSearchCriteriaBuilder();
		builder.tenantId(null);
		builder.status(null);
		builder.challanId(null);
		builder.mobileNumber(null);
		builder.action(null);
		builder.fromDate(null);
		builder.toDate(null);
		builder.offset(null);
		builder.limit(null);
		builder.orderDir(null);
		builder.orderColumn(null);
		builder.searchText(null);
		builder.challanUuid(null);
		builder.build();

		EcSearchCriteria.EcSearchCriteriaBuilder builder2 = new EcSearchCriteria.EcSearchCriteriaBuilder();
		builder2.tenantId(null);
		builder2.status(null);
		builder2.challanId(null);
		builder2.mobileNumber(null);
		builder2.action(null);
		builder2.fromDate(null);
		builder2.toDate(null);
		builder2.offset(null);
		builder2.limit(null);
		builder2.orderDir(null);
		builder2.orderColumn(null);
		builder2.searchText(null);
		builder2.challanUuid(null);
		builder2.build();

		Assert.assertEquals(builder2.toString(), builder.toString());
	}

	/**
	 * Run the String getTenantId() method test.
	 *
	 * @throws Exception
	 *
	 *                   at 30/04/20 1:32 PM
	 */

	@Test
	public void testGetTenantId_1() throws Exception {
		EcSearchCriteria fixture = new EcSearchCriteria("", "", "", "", "",  new Long(1L), new Long(1L), null, null, "", "", "","", null);

		String result = fixture.getTenantId();
		assertEquals("", result);
	}

	/**
	 * Run the String getStatus() method test.
	 *
	 * @throws Exception
	 *
	 *                   at 30/04/20 1:32 PM
	 */

	@Test
	public void testGetStatus_1() throws Exception {
		EcSearchCriteria fixture = new EcSearchCriteria("", "", "", "", "",  new Long(1L), new Long(1L), null, null, "", "", "","", null);

		String result = fixture.getStatus();
		assertEquals("", result);
	}

	/**
	 * Run the String getChallanId() method test.
	 *
	 * @throws Exception
	 *
	 *                   at 30/04/20 1:32 PM
	 */

	@Test
	public void testGetChallanId_1() throws Exception {
		EcSearchCriteria fixture =  new EcSearchCriteria("", "", "", "", "",  new Long(1L), new Long(1L), null, null, "", "", "","","");

		String result = fixture.getChallanId();
		assertEquals("", result);
	}

	/**
	 * Run the String getMobileNumber() method test.
	 *
	 * @throws Exception
	 *
	 *                   at 30/04/20 1:32 PM
	 */

	@Test
	public void testGetMobileNumber_1() throws Exception {
		EcSearchCriteria fixture = new EcSearchCriteria("", "", "", "", "",  new Long(1L), new Long(1L), null, null, "", "", "","","");

		String result = fixture.getMobileNumber();
		assertEquals("", result);
	}

	/**
	 * Run the String getAction() method test.
	 *
	 * @throws Exception
	 *
	 *                   at 30/04/20 1:32 PM
	 */

	@Test
	public void testGetAction_1() throws Exception {
		EcSearchCriteria fixture = new EcSearchCriteria("", "", "", "", "",  new Long(1L), new Long(1L), null, null, "", "", "","","");

		String result = fixture.getAction();

		assertEquals("", result);
	}

	/**
	 * Run the Long getFromDate() method test.
	 *
	 * @throws Exception
	 *
	 *                   at 30/04/20 1:32 PM
	 */

	@Test
	public void testGetFromDate_1() throws Exception {
		EcSearchCriteria fixture = new EcSearchCriteria("", "", "", "", "",  new Long(1L), new Long(1L), null, null, "", "", "","","");

		Long result = fixture.getFromDate();

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
	 * Run the Long getToDate() method test.
	 *
	 * @throws Exception
	 *
	 *                   at 30/04/20 1:32 PM
	 */

	@Test
	public void testGetToDate_1() throws Exception {
		EcSearchCriteria fixture = new EcSearchCriteria("", "", "", "", "",  new Long(1L), new Long(1L), null, null, "", "", "","","");

		Long result = fixture.getToDate();

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
	 * Run the Boolean getOffset() method test.
	 *
	 * @throws Exception
	 *
	 *                   at 30/04/20 1:32 PM
	 */

	@Test
	public void testGetOffset_1() throws Exception {
		EcSearchCriteria fixture = new EcSearchCriteria("", "", "", "", "",  new Long(1L), new Long(1L), null, null, "", "", "","","");

		Integer result = fixture.getOffset();
		assertEquals(null, result);
	}
	
	/**
	 * Run the Boolean getLimit() method test.
	 *
	 * @throws Exception
	 *
	 *                   at 30/04/20 1:32 PM
	 */

	@Test
	public void testGetLimit_1() throws Exception {
		EcSearchCriteria fixture = new EcSearchCriteria("", "", "", "", "",  new Long(1L), new Long(1L), null, null, "", "", "","","");

		Integer result = fixture.getLimit();
		assertEquals(null, result);
	}

	/**
	 * Run the String getOrderDir() method test.
	 *
	 * @throws Exception
	 *
	 *                   at 30/04/20 1:32 PM
	 */

	@Test
	public void testGetOrderDir_1() throws Exception {
		EcSearchCriteria fixture = new EcSearchCriteria("", "", "", "", "",  new Long(1L), new Long(1L), null, null, "", "", "","","");

		String result = fixture.getOrderDir();

		assertEquals("", result);
	}
	
	/**
	 * Run the String getOrderColumn() method test.
	 *
	 * @throws Exception
	 *
	 *                   at 30/04/20 1:32 PM
	 */

	@Test
	public void testGetOrderColumn_1() throws Exception {
		EcSearchCriteria fixture = new EcSearchCriteria("", "", "", "", "",  new Long(1L), new Long(1L), null, null, "", "", "","","");

		String result = fixture.getOrderColumn();

		assertEquals("", result);
	}
	
	@Test
	public void testGetChallanUuid_1() throws Exception {
		EcSearchCriteria fixture = new EcSearchCriteria("", "", "", "", "",  new Long(1L), new Long(1L), null, null, "", "", "","","");

		String result = fixture.getChallanUuid();

		assertEquals("", result);
	}

	/**
	 * Run the String getSearchText() method test.
	 *
	 * @throws Exception
	 *
	 *                   at 30/04/20 1:32 PM
	 */

	@Test
	public void testGetSearchText_1() throws Exception {
		EcSearchCriteria fixture = new EcSearchCriteria("", "", "", "", "",  new Long(1L), new Long(1L), null, null, "", "", "","","");

		String result = fixture.getSearchText();

		assertEquals("", result);
	}


	/**
	 * Run the String setTenantId() method test.
	 *
	 * @throws Exception
	 *
	 *                   at 30/04/20 1:32 PM
	 */

	@Test
	public void testSetTenantId_1() throws Exception {
		EcSearchCriteria fixture = new EcSearchCriteria("", "", "", "", "",  new Long(1L), new Long(1L), null, null, "", "", "","","");
		String tenantId = "";
		fixture.setTenantId(tenantId);
	}

	/**
	 * Run the String setStatus() method test.
	 *
	 * @throws Exception
	 *
	 *                   at 30/04/20 1:32 PM
	 */

	@Test
	public void testSetStatus_1() throws Exception {
		EcSearchCriteria fixture = new EcSearchCriteria("", "", "", "", "",  new Long(1L), new Long(1L), null, null, "", "", "","","");
		String status = "";
		fixture.setStatus(status);;
	}

	/**
	 * Run the String setChallanId() method test.
	 *
	 * @throws Exception
	 *
	 *                   at 30/04/20 1:32 PM
	 */

	@Test
	public void testSetChallanId_1() throws Exception {
		EcSearchCriteria fixture = new EcSearchCriteria("", "", "", "", "",  new Long(1L), new Long(1L), null, null, "", "", "","","");
		String challanId = "";
		fixture.setChallanId(challanId);;
	}

	/**
	 * Run the String setMobileNumber() method test.
	 *
	 * @throws Exception
	 *
	 *                   at 30/04/20 1:32 PM
	 */

	@Test
	public void testSetMobileNumber_1() throws Exception {
		EcSearchCriteria fixture = new EcSearchCriteria("", "", "", "", "",  new Long(1L), new Long(1L), null, null, "", "", "","","");
		String mobileNumber = "";
		fixture.setMobileNumber(mobileNumber);
	}

	/**
	 * Run the void setAction(String) method test.
	 *
	 * @throws Exception
	 *
	 *                   at 30/04/20 1:32 PM
	 */

	@Test
	public void testSetAction_1() throws Exception {
		EcSearchCriteria fixture = new EcSearchCriteria("", "", "", "", "",  new Long(1L), new Long(1L), null, null, "", "", "","","");
		String action = "";

		fixture.setAction(action);

	}

	/**
	 * Run the void setFromDate(Long) method test.
	 *
	 * @throws Exception
	 *
	 *                   at 30/04/20 1:32 PM
	 */

	@Test
	public void testSetFromDate_1() throws Exception {
		EcSearchCriteria fixture = new EcSearchCriteria("", "", "", "", "",  new Long(1L), new Long(1L), null, null, "", "", "","","");
		Long fromDate = new Long(1L);

		fixture.setFromDate(fromDate);

	}
	
	/**
	 * Run the void setToDate(Long) method test.
	 *
	 * @throws Exception
	 *
	 *                   at 30/04/20 1:32 PM
	 */

	@Test
	public void testSetToDate_1() throws Exception {
		EcSearchCriteria fixture = new EcSearchCriteria("", "", "", "", "",  new Long(1L), new Long(1L), null, null, "", "", "","","");
		Long fromDate = new Long(1L);

		fixture.setToDate(fromDate);

	}

	/**
	 * Run the void setOffset(String) method test.
	 *
	 * @throws Exception
	 *
	 *                   at 30/04/20 1:32 PM
	 */

	@Test
	public void testSetOffset_1() throws Exception {
		EcSearchCriteria fixture = new EcSearchCriteria("", "", "", "", "",  new Long(1L), new Long(1L), null, null, "", "", "","","");
		Integer offset = null;
		fixture.setOffset(offset);

	}
	
	/**
	 * Run the void setOffset(String) method test.
	 *
	 * @throws Exception
	 *
	 *                   at 30/04/20 1:32 PM
	 */

	@Test
	public void testSetLimit_1() throws Exception {
		EcSearchCriteria fixture = new EcSearchCriteria("", "", "", "", "",  new Long(1L), new Long(1L), null, null, "", "", "","","");
		Integer limit = null;
		fixture.setLimit(limit);

	}


	/**
	 * Run the void setOrderDir(String) method test.
	 *
	 * @throws Exception
	 *
	 *                   at 30/04/20 1:32 PM
	 */
	@Test
	public void testSetOrderDir_1() throws Exception {
		EcSearchCriteria fixture = new EcSearchCriteria("", "", "", "", "",  new Long(1L), new Long(1L), null, null, "", "", "","","");
		String orderDir = "";
		fixture.setOrderDir(orderDir);

	}
	
	/**
	 * Run the void setOrderColumn(String) method test.
	 *
	 * @throws Exception
	 *
	 *                   at 30/04/20 1:32 PM
	 */
	@Test
	public void testSetOrderColumn_1() throws Exception {
		EcSearchCriteria fixture = new EcSearchCriteria("", "", "", "", "",  new Long(1L), new Long(1L), null, null, "", "", "","","");
		String orderColumn = "";
		fixture.setOrderColumn(orderColumn);

	}
	
	/**
	 * Run the void setSearchText(String) method test.
	 *
	 * @throws Exception
	 *
	 *                   at 30/04/20 1:32 PM
	 */
	@Test
	public void testSetSearchText_1() throws Exception {
		EcSearchCriteria fixture = new EcSearchCriteria("", "", "", "", "",  new Long(1L), new Long(1L), null, null, "", "", "","","");
		String searchText = "";
		fixture.setSearchText(searchText);

	}
	
	@Test
	public void testSetChallanUuid_1() throws Exception {
		EcSearchCriteria fixture = new EcSearchCriteria("", "", "", "", "",  new Long(1L), new Long(1L), null, null, "", "", "","","");
		String challanUuid = "";
		fixture.setChallanUuid(challanUuid);

	}

}
