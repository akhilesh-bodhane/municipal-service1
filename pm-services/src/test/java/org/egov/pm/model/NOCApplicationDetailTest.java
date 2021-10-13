package org.egov.pm.model;

import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class NOCApplicationDetailTest {
	@Test
	public void testNOCApplicationDetail_1() throws Exception {

		NOCApplicationDetail result = new NOCApplicationDetail();

		assertNotNull(result);
		assertEquals(null, result.getLastModifiedTime());
		assertEquals(null, result.getIsActive());
		assertEquals(null, result.getCreatedBy());
		assertEquals(null, result.getCreatedTime());
		assertEquals(null, result.getTenantId());
		assertEquals(null, result.getLastModifiedBy());
		assertEquals(null, result.getApplicationUuid());
		assertEquals(null, result.getApplicationDetailUuid());
		assertEquals(null, result.getApplicationDetail());
	}

	@Test
	public void testNOCApplicationDetail_2() throws Exception {
		String applicationDetailUuid = "";
		String applicationUuid = "";
		String applicationDetail = "";
		String createdBy = "";
		Long createdTime = new Long(1L);
		String lastModifiedBy = "";
		Long lastModifiedTime = new Long(1L);
		Boolean isActive = new Boolean(true);
		String tenantId = "";

		NOCApplicationDetail result = new NOCApplicationDetail(applicationDetailUuid, applicationUuid,
				applicationDetail, createdBy, createdTime, lastModifiedBy, lastModifiedTime, isActive, tenantId);

		assertNotNull(result);
		assertEquals(new Long(1L), result.getLastModifiedTime());
		assertEquals(Boolean.TRUE, result.getIsActive());
		assertEquals("", result.getCreatedBy());
		assertEquals(new Long(1L), result.getCreatedTime());
		assertEquals("", result.getTenantId());
		assertEquals("", result.getLastModifiedBy());
		assertEquals("", result.getApplicationUuid());
		assertEquals("", result.getApplicationDetailUuid());
		assertEquals("", result.getApplicationDetail());
	}

	@Test
	public void testBuilder_1() throws Exception {

		NOCApplicationDetail.NOCApplicationDetailBuilder result = NOCApplicationDetail.builder();

		assertNotNull(result);
		assertEquals(
				"NOCApplicationDetail.NOCApplicationDetailBuilder(applicationDetailUuid=null, applicationUuid=null, applicationDetail=null, createdBy=null, createdTime=null, lastModifiedBy=null, lastModifiedTime=null, isActive=null, tenantId=null)",
				result.toString());
	}

	@Test
	public void testGetApplicationDetail_1() throws Exception {
		NOCApplicationDetail fixture = new NOCApplicationDetail("", "", "", "", new Long(1L), "", new Long(1L),
				new Boolean(true), "");

		String result = fixture.getApplicationDetail();

		assertEquals("", result);
	}

	@Test
	public void testGetApplicationDetailUuid_1() throws Exception {
		NOCApplicationDetail fixture = new NOCApplicationDetail("", "", "", "", new Long(1L), "", new Long(1L),
				new Boolean(true), "");

		String result = fixture.getApplicationDetailUuid();

		assertEquals("", result);
	}

	@Test
	public void testGetApplicationUuid_1() throws Exception {
		NOCApplicationDetail fixture = new NOCApplicationDetail("", "", "", "", new Long(1L), "", new Long(1L),
				new Boolean(true), "");

		String result = fixture.getApplicationUuid();

		assertEquals("", result);
	}

	@Test
	public void testGetCreatedBy_1() throws Exception {
		NOCApplicationDetail fixture = new NOCApplicationDetail("", "", "", "", new Long(1L), "", new Long(1L),
				new Boolean(true), "");

		String result = fixture.getCreatedBy();

		assertEquals("", result);
	}

	@Test
	public void testGetCreatedTime_1() throws Exception {
		NOCApplicationDetail fixture = new NOCApplicationDetail("", "", "", "", new Long(1L), "", new Long(1L),
				new Boolean(true), "");

		Long result = fixture.getCreatedTime();

		assertNotNull(result);
		assertEquals("1", result.toString());
		assertEquals((byte) 1, result.byteValue());
		assertEquals((short) 1, result.shortValue());
		assertEquals(1, result.intValue());
		assertEquals(1L, result.longValue());
		assertEquals(1.0f, result.floatValue(), 1.0f);
		assertEquals(1.0, result.doubleValue(), 1.0);
	}

	@Test
	public void testGetIsActive_1() throws Exception {
		NOCApplicationDetail fixture = new NOCApplicationDetail("", "", "", "", new Long(1L), "", new Long(1L),
				new Boolean(true), "");

		Boolean result = fixture.getIsActive();

		assertNotNull(result);
		assertEquals("true", result.toString());
		assertEquals(true, result.booleanValue());
	}

	@Test
	public void testGetLastModifiedBy_1() throws Exception {
		NOCApplicationDetail fixture = new NOCApplicationDetail("", "", "", "", new Long(1L), "", new Long(1L),
				new Boolean(true), "");

		String result = fixture.getLastModifiedBy();

		assertEquals("", result);
	}

	@Test
	public void testGetLastModifiedTime_1() throws Exception {
		NOCApplicationDetail fixture = new NOCApplicationDetail("", "", "", "", new Long(1L), "", new Long(1L),
				new Boolean(true), "");

		Long result = fixture.getLastModifiedTime();

		assertNotNull(result);
		assertEquals("1", result.toString());
		assertEquals((byte) 1, result.byteValue());
		assertEquals((short) 1, result.shortValue());
		assertEquals(1, result.intValue());
		assertEquals(1L, result.longValue());
		assertEquals(1.0f, result.floatValue(), 1.0f);
		assertEquals(1.0, result.doubleValue(), 1.0);
	}

	@Test
	public void testGetTenantId_1() throws Exception {
		NOCApplicationDetail fixture = new NOCApplicationDetail("", "", "", "", new Long(1L), "", new Long(1L),
				new Boolean(true), "");

		String result = fixture.getTenantId();

		assertEquals("", result);
	}

	@Test
	public void testSetApplicationDetail_1() throws Exception {
		NOCApplicationDetail fixture = new NOCApplicationDetail("", "", "", "", new Long(1L), "", new Long(1L),
				new Boolean(true), "");
		String applicationDetail = "";

		fixture.setApplicationDetail(applicationDetail);

	}

	@Test
	public void testSetApplicationDetailUuid_1() throws Exception {
		NOCApplicationDetail fixture = new NOCApplicationDetail("", "", "", "", new Long(1L), "", new Long(1L),
				new Boolean(true), "");
		String applicationDetailUuid = "";

		fixture.setApplicationDetailUuid(applicationDetailUuid);

	}

	@Test
	public void testSetApplicationUuid_1() throws Exception {
		NOCApplicationDetail fixture = new NOCApplicationDetail("", "", "", "", new Long(1L), "", new Long(1L),
				new Boolean(true), "");
		String applicationUuid = "";

		fixture.setApplicationUuid(applicationUuid);

	}

	@Test
	public void testSetCreatedBy_1() throws Exception {
		NOCApplicationDetail fixture = new NOCApplicationDetail("", "", "", "", new Long(1L), "", new Long(1L),
				new Boolean(true), "");
		String createdBy = "";

		fixture.setCreatedBy(createdBy);

	}

	@Test
	public void testSetCreatedTime_1() throws Exception {
		NOCApplicationDetail fixture = new NOCApplicationDetail("", "", "", "", new Long(1L), "", new Long(1L),
				new Boolean(true), "");
		Long createdTime = new Long(1L);

		fixture.setCreatedTime(createdTime);

	}

	@Test
	public void testSetIsActive_1() throws Exception {
		NOCApplicationDetail fixture = new NOCApplicationDetail("", "", "", "", new Long(1L), "", new Long(1L),
				new Boolean(true), "");
		Boolean isActive = new Boolean(true);

		fixture.setIsActive(isActive);

	}

	@Test
	public void testSetLastModifiedBy_1() throws Exception {
		NOCApplicationDetail fixture = new NOCApplicationDetail("", "", "", "", new Long(1L), "", new Long(1L),
				new Boolean(true), "");
		String lastModifiedBy = "";

		fixture.setLastModifiedBy(lastModifiedBy);

	}

	@Test
	public void testSetLastModifiedTime_1() throws Exception {
		NOCApplicationDetail fixture = new NOCApplicationDetail("", "", "", "", new Long(1L), "", new Long(1L),
				new Boolean(true), "");
		Long lastModifiedTime = new Long(1L);

		fixture.setLastModifiedTime(lastModifiedTime);

	}

	@Test
	public void testSetTenantId_1() throws Exception {
		NOCApplicationDetail fixture = new NOCApplicationDetail("", "", "", "", new Long(1L), "", new Long(1L),
				new Boolean(true), "");
		String tenantId = "";

		fixture.setTenantId(tenantId);

	}

	@Test
	public void testNOCApplicationDetails_1() throws Exception {
		NOCApplicationDetail.NOCApplicationDetailBuilder builder = new NOCApplicationDetail.NOCApplicationDetailBuilder();
		builder.applicationDetail("applicationDetail");
		builder.applicationDetailUuid("askdjk2y83dd23yd283d92d923d");
		builder.applicationUuid("veriu384fij2u2jx8881291j192s09");
		builder.createdBy("111");
		builder.createdTime(145545426L);
		builder.isActive(true);
		builder.lastModifiedBy("2222");
		builder.lastModifiedTime(182781278L);
		builder.tenantId("ch");
		builder.build();

		NOCApplicationDetail.NOCApplicationDetailBuilder builder2 = new NOCApplicationDetail.NOCApplicationDetailBuilder();
		builder2.applicationDetail("applicationDetail");
		builder2.applicationDetailUuid("askdjk2y83dd23yd283d92d923d");
		builder2.applicationUuid("veriu384fij2u2jx8881291j192s09");
		builder2.createdBy("111");
		builder2.createdTime(145545426L);
		builder2.isActive(true);
		builder2.lastModifiedBy("2222");
		builder2.lastModifiedTime(182781278L);
		builder2.tenantId("ch");
		builder2.build();

		Assert.assertEquals(builder.toString(), builder2.toString());

	}
}