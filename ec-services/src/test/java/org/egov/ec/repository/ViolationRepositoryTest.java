package org.egov.ec.repository;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.egov.common.contract.response.ResponseInfo;
import org.egov.ec.config.EchallanConfiguration;
import org.egov.ec.producer.Producer;
import org.egov.ec.repository.ViolationRepository;
import org.egov.ec.repository.builder.EcQueryBuilder;
import org.egov.ec.web.models.Document;
import org.egov.ec.web.models.EcPayment;
import org.egov.ec.web.models.EcSearchCriteria;
import org.egov.ec.web.models.Violation;
import org.egov.ec.web.models.ViolationItem;
import org.egov.ec.web.models.workflow.ProcessInstanceRequest;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

@RunWith(MockitoJUnitRunner.class)
public class ViolationRepositoryTest {
	
	@InjectMocks
	private ViolationRepository repository;

	@Mock
	private JdbcTemplate jdbcTemplate;

	@Mock
	private Producer producer;

	@Mock
	private EchallanConfiguration config;
	
	@Mock
	EcQueryBuilder ecQueryBuilder;
	
	@Mock
	EcSearchCriteria ecSearchCriteria;
	
	@Test
	public void testCreateViolation() {
		Violation master = Violation.builder().violationUuid("aasdjiasdu8ahs89asdy8a9h")
				.build();
		repository.generateChallan(master);
	}

	@Test
	public void testUpdateViolation() {
		Violation master = Violation.builder().violationUuid("aasdjiasdu8ahs89asdy8a9h")
				.build();
		repository.updateChallan(master);
	}
	
	@Test
	public void testGetpenalty() {
		List<ViolationItem> list=Arrays.asList(ViolationItem.builder().itemType("Two Wheeler").itemName("SYSTEM_PAYMENT").build());
		Violation master = Violation.builder().violationUuid("aasdjiasdu8ahs89asdy8a9h").
				encroachmentType("Seizure of Vehicles").
				violationItem(list).build();
		String x = null;
		Mockito.when(jdbcTemplate.query(Matchers.anyString(),
				Matchers.any(Object[].class), Matchers.any(BeanPropertyRowMapper.class))).thenReturn(x);
		repository.getpenalty(master);
	}
	@Test
	public void testGetpenalty_1() {
		Violation master = Violation.builder().violationUuid("aasdjiasdu8ahs89asdy8a9h").
				encroachmentType("xyz").numberOfViolation("1").
				violationItem(null).build();
		String x = null;
		Mockito.when(jdbcTemplate.query(Matchers.anyString(),
				Matchers.any(Object[].class), Matchers.any(BeanPropertyRowMapper.class))).thenReturn(x);
		repository.getpenalty(master);
	}
	
	@Test
	public void testAddPayment() {
		EcPayment ecPayment = EcPayment.builder().paymentUuid("aasdjiasdu8ahs89asdy8a9h").build();
		repository.addPayment(ecPayment);
	}
	
	
	@Test
	public void testGetChallan1() {
		
		EcSearchCriteria searchCriteria = EcSearchCriteria.builder().searchText("test").limit(0).
				tenantId("ch").limit(1).build();
		List<Violation> violationDetailList = Arrays.asList(Violation.builder().violationUuid("hbhjbhjbjb").siName("hbhbj").build());
		Mockito.when(jdbcTemplate.query(Matchers.anyString(),
				Matchers.any(Object[].class), Matchers.any(BeanPropertyRowMapper.class))).thenReturn(violationDetailList);
		//repository.getChallan(searchCriteria);
	}
	
	@Test
	public void testGetChallan2() {
		
		EcSearchCriteria searchCriteria = EcSearchCriteria.builder().searchText("").action("auctionChallan")
				.tenantId("ch").build();
		repository.getChallan(searchCriteria);
	}

	@Test
	public void testGetChallan3() {
		
		EcSearchCriteria searchCriteria = EcSearchCriteria.builder().searchText("").action("ChallanSM")
				.tenantId("ch").build();
		repository.getChallan(searchCriteria);
	}
	@Test
	public void testGetChallan4() {
		List<Violation> violationDetailList = Arrays.asList(Violation.builder().violationUuid("hbhjbhjbjb").siName("hbhbj").build());
		EcSearchCriteria searchCriteria = EcSearchCriteria.builder().searchText("").limit(0).action("").tenantId("ch").build();
		Mockito.when(jdbcTemplate.query(Matchers.anyString(),
				Matchers.any(Object[].class), Matchers.any(BeanPropertyRowMapper.class))).thenReturn(violationDetailList);
		//repository.getChallan(searchCriteria);
	}
	
	@Test
	public void testGetChallanForHOD() {
		
		EcSearchCriteria searchCriteria = EcSearchCriteria.builder().tenantId("ch").build();
		repository.getChallanForHOD(searchCriteria);
	}
	
	@Test
	public void testGetChallanAuctionForHOD() {
		
		EcSearchCriteria searchCriteria = EcSearchCriteria.builder().tenantId("ch").build();
		repository.getChallanForAuctionHOD(searchCriteria);
	}

	@Test
	public void testGetSearchChallan() {
		
		Violation violation = Violation.builder().tenantId("ch").build();
		repository.getSearchChallan(violation);
	}
}
