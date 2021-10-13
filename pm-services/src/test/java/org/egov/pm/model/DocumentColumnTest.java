package org.egov.pm.model;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import junit.framework.Assert;

@RunWith(MockitoJUnitRunner.Silent.class)
public class DocumentColumnTest {

	@InjectMocks
	private DocumentColumn documentColumn;

	@Test
	public void testGetTenantId() {
		documentColumn.setTenantId("ch");
		Assert.assertEquals("ch", documentColumn.getTenantId());
	}

	@Test
	public void testGetApplicationType() {
		documentColumn.setApplicationType("NOCTYPE");
		Assert.assertEquals("NOCTYPE", documentColumn.getApplicationType());
	}

	@Test
	public void testGetCertificateDataQuery() {
		documentColumn.setCertificateDataQuery("certificateDataQuery");
		Assert.assertEquals("certificateDataQuery", documentColumn.getCertificateDataQuery());
	}

	@Test
	public void testGetReceiptDataQuery() {
		documentColumn.setReceiptDataQuery("receiptDataQuery");
		Assert.assertEquals("receiptDataQuery", documentColumn.getReceiptDataQuery());
	}

	@Test
	public void testToString() {
		documentColumn.setApplicationType("NOCTYPE");
		String str = documentColumn.toString();
		Assert.assertEquals(str, documentColumn.toString());
	}

	@Test
	public void testHashCode() {
		int hash = documentColumn.hashCode();
		Assert.assertEquals(hash, documentColumn.hashCode());
	}

	@Test
	public void testEquals() {
		documentColumn.setApplicationType("NOCTYPE");
		Assert.assertEquals(true, documentColumn.equals(documentColumn));
	}

}
