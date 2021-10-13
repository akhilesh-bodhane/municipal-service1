package org.egov.ec.repository;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.jdbc.core.JdbcTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import org.egov.common.contract.request.RequestInfo;
import org.egov.common.contract.request.Role;
import org.egov.ec.config.EchallanConfiguration;
import org.egov.ec.producer.Producer;
import org.egov.ec.repository.ReportRepository;
import org.egov.ec.web.models.Auction;
import org.egov.ec.web.models.DashboardDetails;
import org.egov.ec.web.models.Report;
import org.egov.ec.web.models.RequestInfoWrapper;
import org.egov.tracer.model.CustomException;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(MockitoJUnitRunner.class)
public class ReportRepositoryTest {
	
	@InjectMocks
	private ReportRepository repository;

	@Mock
	private JdbcTemplate jdbcTemplate;

	@Mock
	private Producer producer;

	@Mock
	private EchallanConfiguration config;
	
	@Mock
	private DashboardDetails dashboardDetails;
	
	@Mock 
	private ObjectMapper objectMapper;
	
	@Test
	public void testReport1() {
		Report report = Report.builder().reportType("Payment")
				.toDate(new Date()).fromDate(new Date()).paymentStatus("PAID").itemsAgeFrom("0").itemsAgeTo("20").sector("").encroachmentType("")
				.build();
		System.out.println(report.toString());
		repository.getReport(report);		
	}
	
	@Test
	public void testReport2() {
		Report report = Report.builder().reportType("Seizure")
				.toDate(new Date()).fromDate(new Date()).paymentStatus("PAID").itemsAgeFrom("0").itemsAgeTo("20").sector("").encroachmentType("test").siName("test")
				.build();
		System.out.println(report.toString());
		repository.getReport(report);		
	}
	
	@Test
	public void testReport3() {
		Report report = Report.builder().reportType("Item Age")
				.toDate(new Date()).fromDate(new Date()).paymentStatus("PAID").itemsAgeFrom("0").itemsAgeTo("20").sector("").encroachmentType("test").siName("test")
				.build();
		System.out.println(report.toString());
		repository.getReport(report);		
	}
	
	@Test
	public void testReport4() {
		Report report = Report.builder().reportType("Item Age")
				.toDate(new Date()).fromDate(new Date()).paymentStatus("PAID").itemsAgeFrom("11").itemsAgeTo("20").sector("").encroachmentType("test").siName("test")
				.build();
		System.out.println(report.toString());
		repository.getReport(report);		
	}
	
	@Test
	public void testReport5() {
		Report report = Report.builder().reportType("Item Age")
				.toDate(new Date()).fromDate(new Date()).paymentStatus("PAID").itemsAgeFrom("21").itemsAgeTo("20").sector("").encroachmentType("test").siName("test")
				.build();
		System.out.println(report.toString());
		repository.getReport(report);		
	}
	
	@Test
	public void testReport6() {
		Report report = Report.builder().reportType("Item Age")
				.toDate(new Date()).fromDate(new Date()).paymentStatus("PAID").itemsAgeFrom("30").itemsAgeTo("20").sector("").encroachmentType("test").siName("test")
				.build();
		System.out.println(report.toString());
		repository.getReport(report);		
	}
	
	@Test(expected = CustomException.class)
	public void testReport7() {
		Report report = Report.builder().reportType("jbdfjb")
				.toDate(new Date()).fromDate(new Date()).paymentStatus("PAID").itemsAgeFrom("30").itemsAgeTo("20").sector("").encroachmentType("test").siName("test")
				.build();
		System.out.println(report.toString());
		repository.getReport(report);		
	}
	
	@Test
	public void testReport8() {
		Report report = Report.builder().reportType("Item Age")
				.toDate(new Date()).fromDate(new Date()).paymentStatus("PAID").itemsAgeFrom("All").itemsAgeTo("20").sector("").encroachmentType("test").siName("test")
				.build();
		System.out.println(report.toString());
		repository.getReport(report);		
	}
	
	@Test
	public void testReportDashboard_1() {
		DashboardDetails report = DashboardDetails.builder().roleCode("challanSI").tenantId("ch.chandigarh").build();
		org.egov.common.contract.request.User userInfo = new org.egov.common.contract.request.User();
		userInfo.setTenantId("ch.chandigarh");
		userInfo.setRoles(Arrays.asList(Role.builder().code("challanSI").name("challanSI").build()));
		RequestInfoWrapper infoWrapper = RequestInfoWrapper.builder().requestBody(report)
				.requestInfo(RequestInfo.builder().userInfo(userInfo).build()).build();
		Mockito.when(objectMapper.convertValue(infoWrapper.getRequestBody(), DashboardDetails.class)).thenReturn(report);
		repository.getDashboard(infoWrapper);		
	}
	
	@Test
	public void testReportDashboard_2() {
		DashboardDetails report = DashboardDetails.builder().roleCode("challanSM").tenantId("ch.chandigarh").build();
		org.egov.common.contract.request.User userInfo = new org.egov.common.contract.request.User();
		userInfo.setTenantId("ch.chandigarh");
		userInfo.setRoles(Arrays.asList(Role.builder().code("challanSM").name("challanSM").build()));
		RequestInfoWrapper infoWrapper = RequestInfoWrapper.builder().requestBody(report)
				.requestInfo(RequestInfo.builder().userInfo(userInfo).build()).build();
		Mockito.when(objectMapper.convertValue(infoWrapper.getRequestBody(), DashboardDetails.class)).thenReturn(report);
		repository.getDashboard(infoWrapper);		
	}
	
	@Test
	public void testReportDashboard_3() {
		DashboardDetails report = DashboardDetails.builder().roleCode("challanHOD").tenantId("ch.chandigarh").build();
		org.egov.common.contract.request.User userInfo = new org.egov.common.contract.request.User();
		userInfo.setTenantId("ch.chandigarh");
		userInfo.setRoles(Arrays.asList(Role.builder().code("challanHOD").name("challanHOD").build()));
		RequestInfoWrapper infoWrapper = RequestInfoWrapper.builder().requestBody(report)
				.requestInfo(RequestInfo.builder().userInfo(userInfo).build()).build();
		Mockito.when(objectMapper.convertValue(infoWrapper.getRequestBody(), DashboardDetails.class)).thenReturn(report);
		repository.getDashboard(infoWrapper);	
	}
	
	@Test
	public void testReportDashboard_4() {
		DashboardDetails report = DashboardDetails.builder().roleCode("challanHOD").tenantId("ch.chandigarh").build();
		org.egov.common.contract.request.User userInfo = new org.egov.common.contract.request.User();
		userInfo.setTenantId("ch.chandigarh");
		userInfo.setRoles(Arrays.asList(Role.builder().code("challanHOD").name("challanHOD").build(),Role.builder().code("challanSI").name("challanSI").build()));
		RequestInfoWrapper infoWrapper = RequestInfoWrapper.builder().requestBody(report)
				.requestInfo(RequestInfo.builder().userInfo(userInfo).build()).build();
		Mockito.when(objectMapper.convertValue(infoWrapper.getRequestBody(), DashboardDetails.class)).thenReturn(report);	
		repository.getDashboard(infoWrapper);	
	}
	
	@Test
	public void testReportDashboard_5() {
		DashboardDetails report = DashboardDetails.builder().roleCode("challanHOD").tenantId("ch.chandigarh").build();
		org.egov.common.contract.request.User userInfo = new org.egov.common.contract.request.User();
		userInfo.setTenantId("ch.chandigarh");
		userInfo.setRoles(Arrays.asList(Role.builder().code("challanSM").name("challanSM").build(),Role.builder().code("challanSI").name("challanSI").build()));
		RequestInfoWrapper infoWrapper = RequestInfoWrapper.builder().requestBody(report)
				.requestInfo(RequestInfo.builder().userInfo(userInfo).build()).build();
		Mockito.when(objectMapper.convertValue(infoWrapper.getRequestBody(), DashboardDetails.class)).thenReturn(report);	
		repository.getDashboard(infoWrapper);	
	}
	
	@Test
	public void testReportDashboard_6() {
		DashboardDetails report = DashboardDetails.builder().roleCode("challanHOD").tenantId("ch.chandigarh").build();
		org.egov.common.contract.request.User userInfo = new org.egov.common.contract.request.User();
		userInfo.setTenantId("ch.chandigarh");
		userInfo.setRoles(Arrays.asList(Role.builder().code("challanSM").name("challanSM").build(),Role.builder().code("challanHOD").name("challanHOD").build()));
		RequestInfoWrapper infoWrapper = RequestInfoWrapper.builder().requestBody(report)
				.requestInfo(RequestInfo.builder().userInfo(userInfo).build()).build();
		Mockito.when(objectMapper.convertValue(infoWrapper.getRequestBody(), DashboardDetails.class)).thenReturn(report);
		repository.getDashboard(infoWrapper);	
	}
	
	@Test
	public void testReportDashboard_7() {
		DashboardDetails report = DashboardDetails.builder().roleCode("challanHOD").tenantId("ch.chandigarh").build();
		org.egov.common.contract.request.User userInfo = new org.egov.common.contract.request.User();
		userInfo.setTenantId("ch.chandigarh");
		userInfo.setRoles(Arrays.asList(Role.builder().code("challanSM").name("challanSM").build(),
				Role.builder().code("challanHOD").name("challanHOD").build(),
				Role.builder().code("challanSI").name("challanSI").build()));
		RequestInfoWrapper infoWrapper = RequestInfoWrapper.builder().requestBody(report)
				.requestInfo(RequestInfo.builder().userInfo(userInfo).build()).build();
		Mockito.when(objectMapper.convertValue(infoWrapper.getRequestBody(), DashboardDetails.class)).thenReturn(report);	
		repository.getDashboard(infoWrapper);	
	}
	
	/*
	 * @Test(expected = CustomException.class) public void testDashboard_8() {
	 * DashboardDetails report =
	 * DashboardDetails.builder().roleCode("challanHOD").tenantId("ch.chandigarh").
	 * build(); org.egov.common.contract.request.User userInfo = new
	 * org.egov.common.contract.request.User();
	 * userInfo.setTenantId("ch.chandigarh");
	 * userInfo.setRoles(Arrays.asList(Role.builder().code("dkbjksbk").name(
	 * "sbjhsbj").build(), Role.builder().code("kbkjbj").name("jhbjhb").build(),
	 * Role.builder().code("bjhbjb").name("hbjbk").build())); RequestInfoWrapper
	 * infoWrapper = RequestInfoWrapper.builder().requestBody(report)
	 * .requestInfo(RequestInfo.builder().userInfo(userInfo).build()).build();
	 * Mockito.when(objectMapper.convertValue(infoWrapper.getRequestBody(),
	 * DashboardDetails.class)).thenReturn(report); }
	 */

}
