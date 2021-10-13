package org.egov.ec.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.egov.common.contract.request.RequestInfo;
import org.egov.common.contract.request.Role;
import org.egov.common.contract.request.User;
import org.egov.ec.config.EchallanConfiguration;
import org.egov.ec.producer.Producer;
import org.egov.ec.repository.FineMasterRepository;
import org.egov.ec.web.models.EcSearchCriteria;
import org.egov.ec.web.models.FineMaster;
import org.egov.ec.web.models.RequestInfoWrapper;
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
public class FineMasterRepositoryTest {

	@InjectMocks
	private FineMasterRepository repository;

	@Mock
	private JdbcTemplate jdbcTemplate;

	@Mock
	private Producer producer;

	@Mock
	private EchallanConfiguration config;

	@Test
	public void testCreateFine() {
		FineMaster master = FineMaster.builder().fineUuid("aasdjiasdu8ahs89asdy8a9h").encroachmentType("test")
				.numberOfViolation("hdbjhvdj").build();
		repository.saveFine(master);
	}

	@Test
	public void testUpdateFine() {
		FineMaster master = FineMaster.builder().fineUuid("aasdjiasdu8ahs89asdy8a9h").build();
		repository.updateFine(master);
	}

	@Test
	public void testGetFine1() {
		FineMaster master = FineMaster.builder().encroachmentType("Unregistered").build();
		org.egov.common.contract.request.User userInfo = new org.egov.common.contract.request.User();
		userInfo.setTenantId("ch.chandigarh");
		userInfo.setRoles(Arrays.asList(Role.builder().code("challanEAO").name("challanEAO").build()));
		RequestInfoWrapper infoWrapper = RequestInfoWrapper.builder().requestBody(master)
				.requestInfo(RequestInfo.builder().userInfo(userInfo).build()).build();
		List<FineMaster> list = new ArrayList<>();
		list.add(master);

		Mockito.when(jdbcTemplate.query(Matchers.anyString(),
				Matchers.any(Object[].class), Matchers.any(BeanPropertyRowMapper.class))).thenReturn(list);
		

		Assert.assertEquals(master.getEncroachmentType(), repository.getFine(infoWrapper).get(0).getEncroachmentType());

	}
	
	@Test
	public void testGetFine2() {
		FineMaster master = FineMaster.builder().encroachmentType("Unregistered").build();
		org.egov.common.contract.request.User userInfo = new org.egov.common.contract.request.User();
		userInfo.setTenantId("ch.chandigarh");
		userInfo.setRoles(Arrays.asList(Role.builder().code("challanHOD").name("challanHOD").build()));
		RequestInfoWrapper infoWrapper = RequestInfoWrapper.builder().requestBody(master)
				.requestInfo(RequestInfo.builder().userInfo(userInfo).build()).build();
		List<FineMaster> list = new ArrayList<>();
		list.add(master);

		Mockito.when(jdbcTemplate.query(Matchers.anyString(),
				Matchers.any(Object[].class), Matchers.any(BeanPropertyRowMapper.class))).thenReturn(list);
		

		Assert.assertEquals(master.getEncroachmentType(), repository.getFine(infoWrapper).get(0).getEncroachmentType());

	}
	
	@Test
	public void testUpdatePenaltyAmount(){
		FineMaster master = FineMaster.builder().encroachmentType("Unregistered").build();
		List<FineMaster> fineList = new ArrayList<>();
		fineList.add(master);
		EcSearchCriteria searchCriteria=EcSearchCriteria.builder().tenantId("ch.chandigarh").build();

		Mockito.when(jdbcTemplate.query(Matchers.anyString(),
				Matchers.any(Object[].class), Matchers.any(BeanPropertyRowMapper.class))).thenReturn(fineList);		
		RequestInfoWrapper infoWrapper = RequestInfoWrapper.builder().requestBody(fineList).build();
		repository.updatePenaltyAmount(searchCriteria);
	}
}
