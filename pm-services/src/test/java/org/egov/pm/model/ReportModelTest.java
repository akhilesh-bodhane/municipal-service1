package org.egov.pm.model;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import junit.framework.Assert;

@RunWith(MockitoJUnitRunner.Silent.class)
public class ReportModelTest {

	@InjectMocks
	private ReportModel reportModel;

	@Test
	public void testReportModel() {
		ReportModel reportModel2 = new ReportModel("ch", "", "2", "0", "22");
		Assert.assertEquals("ch", reportModel2.getTenantId());
	}

	@Test
	public void testBuilder() {
		ReportModel reportModel2 = ReportModel.builder().tenantId("ch").build();
		Assert.assertEquals("ch", reportModel2.getTenantId());
	}

	@Test
	public void testGetTenantId() {
		reportModel.setTenantId("ch");
		Assert.assertEquals("ch", reportModel.getTenantId());
	}

	@Test
	public void testGetApplicationType() {
		reportModel.setApplicationType("NOCTYPE");
		Assert.assertEquals("NOCTYPE", reportModel.getApplicationType());
	}

	@Test
	public void testGetTotalAverage() {
		reportModel.setTotalAverage("121");
		Assert.assertEquals("121", reportModel.getTotalAverage());
	}

	@Test
	public void testGetTotalAveragePending10DayasTo30Days() {
		reportModel.setTotalAveragePending10DayasTo30Days("445");
		Assert.assertEquals("445", reportModel.getTotalAveragePending10DayasTo30Days());
	}

	@Test
	public void testGetTotalAveragePendingGreaterThan30Days() {
		reportModel.setTotalAveragePendingGreaterThan30Days("578");
		Assert.assertEquals("578", reportModel.getTotalAveragePendingGreaterThan30Days());
	}

	@Test
	public void testReportModelBuilder() {
		ReportModel.ReportModelBuilder reportModel2 = new ReportModel.ReportModelBuilder();
		reportModel2.applicationType("NOCTYPE");
		reportModel2.tenantId("ch");
		reportModel2.totalAverage("545");
		reportModel2.totalAveragePending10DayasTo30Days("2154");
		reportModel2.totalAveragePendingGreaterThan30Days("544545");
		reportModel2.build();

		String str = reportModel2.toString();
		Assert.assertEquals(str, reportModel2.toString());
	}
}
