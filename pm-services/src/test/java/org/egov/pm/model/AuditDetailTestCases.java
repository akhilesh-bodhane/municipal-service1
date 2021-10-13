package org.egov.pm.model;

import static org.junit.Assert.fail;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.Silent.class)
public class AuditDetailTestCases {

	@InjectMocks
	private AuditDetail auditDetail;

	@Test
	public void testHashCode() {
		int a = auditDetail.hashCode();
		Assert.assertEquals(a, auditDetail.hashCode());
	}

	@Test
	public void testEqual() {
		boolean a = auditDetail.equals(auditDetail);
		Assert.assertEquals(a, auditDetail.equals(auditDetail));
	}

	@Test
	public void testGetCreatedBy() {
		auditDetail.setCreatedBy("11");
		Assert.assertEquals("11", auditDetail.getCreatedBy());
	}

	@Test
	public void testGetLastModifiedBy() {
		auditDetail.setLastModifiedBy("11");
		Assert.assertEquals("11", auditDetail.getLastModifiedBy());
	}

	@Test
	public void testGetCreatedTime() {
		auditDetail.setCreatedTime(123456789L);
		Assert.assertEquals(123456789L, (long) auditDetail.getCreatedTime());
	}

	@Test
	public void testGetLastModifiedTime() {
		auditDetail.setLastModifiedTime(123456789L);
		Assert.assertEquals(123456789L, (long) auditDetail.getLastModifiedTime());
	}

	@Test
	public void testEqualsObject() {
		Assert.assertEquals(true, auditDetail.equals(auditDetail));
	}

	@Test
	public void testToString() {
		Assert.assertEquals(auditDetail.toString(), auditDetail.toString());
	}

	@Test
	public void testAuditDetail() {
		AuditDetail detail = new AuditDetail();
	}

	@Test
	public void testAuditDetailStringStringLongLong() {
		AuditDetail detail = new AuditDetail();
	}

}
